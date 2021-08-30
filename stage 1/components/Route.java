package components;

import java.util.ArrayList;
import java.util.Random;

public class Route {
    private ArrayList<Junction> junctions;       // list of junctions on the route by the order of movement.
    private ArrayList<Road> roads;       // list of roads on the route by the order of movement.
    private double delay;       //time that will take the vehicle to make this route.
    private VehicleType vehicleType;

    //Constructors
    public Route(ArrayList<Junction> juncs, ArrayList<Road> roads, VehicleType vehType)
    {
        this.junctions = juncs;
        this.roads = roads;
        this.vehicleType = vehType;
        delay = calcDelay();
    }
    public Route(Junction start, Junction end, VehicleType vehType)     //not implemented in this task.
    {
        junctions = new ArrayList<Junction>();
        roads = new ArrayList<Road>();
        junctions.add(start);
        junctions.add(end);
        roads.add(new Road(start,end));
        vehicleType = vehType;
        delay = calcDelay();
    }

    public Route(Junction start,VehicleType vehType) {
        vehicleType = vehType;
        junctions = new ArrayList<Junction>();
        roads = new ArrayList<Road>();
        junctions.add(start);
        int junctionlen = 9;        //maximum (10) junctions on Route
        int nextroad, randomindex;
        ArrayList<Integer> enabledRoads = enabledRoads();       //get enabled road from this junction
        while (enabledRoads.size() != 0 && junctionlen != 0) {
            randomindex = new Random().nextInt(enabledRoads.size());   //random exit road to build Route
            nextroad = enabledRoads.get(randomindex);       //get the enable road
            System.out.println(nextroad);
            roads.add(junctions.get((junctions.size() - 1)).getExitingRoads().get(nextroad));     //add the road to list
            junctions.add(roads.get(roads.size() - 1).getToJunc());       //add junction to list
            junctionlen--;      //part of route added!!
            enabledRoads = enabledRoads();          //update Enabled roads from junction
        }
    }

    //Getters
    public Junction getStart(){
        if(!junctions.isEmpty())    //check if array not empty
            return junctions.get(0);
        else
            return null;
    }
    public Junction getEnd(){
        if(junctions.size()>1)    //check if array not empty
            return junctions.get(junctions.size()-1);
        else
            return null;
    }
    public ArrayList<Junction> getJunctions(){return this.junctions;}
    public ArrayList<Road> getRoads(){return this.roads;}

    //Methods
    public void printRoute(){
      System.out.println(this.getStart()+", " + getRoads().get(0));
    }

    /**
     * set length to be a sum of delay values of all the junctions on the route
     * and the time that will take this type of vehicle to pass all the roads.
     * Time is calculated by dividing the distance by min(average speed, maxSpeed).
     * The delay time on junctions is calculated according to worse case:
     * if there is a traffic lights on the junction, we use it’s delay value multiplied by (number of entering roads minus one).
     * If there is no traffic lights on the junction, the delay time is the priority level of the road that
     * leads us to this junction (the index of this road in the list of roads).
     * @return: the time to pass the route.
     */
    public double calcDelay(){
        double delay;
        double distance_all_roads = 0;
        int avarage_speed = 0;
        for(int i=0;i<roads.size();i++)
        {
            distance_all_roads = distance_all_roads + roads.get(i).getLength();
            if(roads.get(i).getMaxSpeed() >= vehicleType.getSpeed())
                avarage_speed = avarage_speed + vehicleType.getSpeed();     //drive with vehicle speed
            else
                avarage_speed = avarage_speed + roads.get(i).getMaxSpeed();     //prevent speed on road.
        }
        //calc distance of all route and dived by average speed.
        delay = distance_all_roads/(avarage_speed/roads.size());

        //calc time on junctions
        int timeonjunc = 0;
        for(int i=0;i<junctions.size();i++){
            if(junctions.get(i).getHasLights() == true){
                timeonjunc = timeonjunc + (junctions.get(i).getDelay()*(junctions.get(i).getEnteringRoads().size()-1));
            }
            else
            {
                timeonjunc = timeonjunc+i;
            }
        }
        return (delay+(double) timeonjunc);
    }

    /**
     * @return array of index enabled roads
     */
    public ArrayList<Integer> enabledRoads(){
        ArrayList<Integer> enabled = new ArrayList<Integer>();
        for(int i=0; i < junctions.get(junctions.size()-1).getExitingRoads().size() ; i++)
        {
            if(junctions.get(junctions.size()-1).getExitingRoads().get(i).getIsEnabled() == true)
                enabled.add(i);
        }
        return enabled;
    }

    @Override
    public String toString(){
        return ("from " + junctions.get(0) + " to " + junctions.get(junctions.size()-1));
    }
}