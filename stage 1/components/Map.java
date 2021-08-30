package components;

import utilities.Point;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class is the map of roads and junctions.
 */
public class Map {
    private ArrayList<Junction> junctions;
    private ArrayList<Road> roads;

    //Default Constructor

    /**
     * Creates a map with 20 random junctions and connects all of them one to another with roads.
     * in this case we have 20*19 roads and 20 junctions.
     */
    public Map() {
        junctions = new ArrayList<Junction>();
        roads = new ArrayList<Road>();
        for (int i = 0; i < 20; i++) {
            junctions.add(new Junction(new String("" + i), new Point()));
        }
        //Connect Junctions with Roads
        //We Have 20*19 Roads
        boolean random_isEnabled;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i != j) {
                    random_isEnabled = new Random().nextBoolean();
                    roads.add(new Road(junctions.get(i), junctions.get(j), VehicleType.getRandomVehicleTypes(), false, random_isEnabled));
                    if(this.junctions.get(j).getHasLights() == true)
                        this.junctions.get(j).setLightsOn();
                }
            }
        }
        speedRandom();
    }

    /**
     * Creates a map  number of junctions and connect them by nubmer of roads.
     * if we get number of roads: (junctions*(junctions-1)) so connect all of them
     * else: connect by random.
     * @param junctions - number of junctions we want in the map
     * @param roads - number of roads we want in the map
     */
    public Map(int junctions, int roads) {
        this.junctions = new ArrayList<Junction>();
        for (int i = 0; i < junctions; i++) {
            this.junctions.add(new Junction(new String("" + i), new Point()));
        }
        //Connect Junctions with Roads
        boolean random_isEnabled;
        if(roads == junctions*(junctions-1)){
            //We have all roads to connect (all options)
            for (int i = 0; i < junctions; i++) {
                for (int j = 0; j < junctions; j++) {
                    if (i != j) {
                        random_isEnabled = new Random().nextBoolean();
                        this.roads.add(new Road(this.junctions.get(i), this.junctions.get(j), VehicleType.getRandomVehicleTypes(), false, random_isEnabled));
                        if(this.junctions.get(j).getHasLights() == true)
                            this.junctions.get(j).setLightsOn();
                    }
                }
            }
        }
        //Random Junctions To Connect
        for (int i = 0; i < roads; i++) {
            int j = new Random().nextInt(roads);
            int k = new Random().nextInt(roads);
            if (j != k) {      //same random junctions
                random_isEnabled = new Random().nextBoolean();
                Road r = new Road(this.junctions.get(j), this.junctions.get(k), VehicleType.getRandomVehicleTypes(), false, random_isEnabled);
                if (!this.roads.contains(r)) {      //if road exists
                    this.roads.add(r);
                    if(this.junctions.get(j).getHasLights() == true)        //check if junction has lights
                        this.junctions.get(j).setLightsOn();        //set lights ON
                } else
                    i--;
            } else
                i--;
        }
        speedRandom();
    }

    /**
     * Create map by number of junctions.
     * create number of roads: (junctions*-(junctions-1))
     * and connect all the roads with junctions.
     * @param junctions - number of junctions we want in the map
     */
    public Map(int junctions) {
        //SetArrays
        this.junctions = new ArrayList<Junction>();
        this.roads = new ArrayList<Road>();
        for (int i = 0; i < junctions; i++) {
            this.junctions.add(new Junction(new String("" + i), new Point()));
        }
        //Connect Junctions with Roads
        //We Have (junctions*(junctions-1)) Roads
        boolean random_isEnabled;
        for (int i = 0; i < junctions; i++) {
            for (int j = 0; j < junctions; j++) {
                if (i != j) {
                    random_isEnabled = new Random().nextBoolean();
                    this.roads.add(new Road(this.junctions.get(i), this.junctions.get(j), VehicleType.getRandomVehicleTypes(), false, random_isEnabled));   //add road To Array roads
                    if(this.junctions.get(j).getHasLights() == true)        //check if junction has lights
                        this.junctions.get(j).setLightsOn();        //set lights ON
                }
            }
        }
        speedRandom();
    }

    /**
     * Create map by ArrayList of junctions.
     * create number of roads: (junctions*-(junctions-1))
     * and connect all the roads with junctions.
     * @param juncs Array of junctions. they will connection by roads.
     */
    public Map (ArrayList<Junction> juncs) {
        this.junctions = juncs;     //set juncs to the Object
        this.roads = new ArrayList<Road>();     //set roads
        //Connect Junctions with Roads
        //We Have (juncs.size()*(juncs.size()-1)) Roads
        for (int i = 0; i < juncs.size(); i++) {
            for (int j = 0; j < juncs.size(); j++) {
                if (i != j) {
                    this.roads.add(new Road(this.junctions.get(i), this.junctions.get(j), VehicleType.getRandomVehicleTypes(), false, true));   //add road To Array roads
                    this.junctions.get(j).setLightsOn();     //set lights ON
                }
            }
        }
        speedRandom();
    }

    /**
     * Create map by ArrayList of junctions and roads.
     * All The roads Connected to Junction (by road constructor)
     * @param juncs ArrayList of junctions.
     * @param roads ArrayList of Roads. they connected to junctions.
     */
    public Map (ArrayList<Junction>juncs, ArrayList<Road>roads){
        this.junctions = juncs;     //set juncs to the Object
        this.roads = roads;         //set roads to the Object

        //We Have Roads.size() roads
        int k =0;
        for (int i = 0; i < juncs.size(); i++) {
            for (int j = 0; j < juncs.size(); j++) {
                if (i != j) {
                    this.junctions.get(j).setLightsOn();        //set lights ON
                }
            }
        }
        speedRandom();
    }

    //Methods
    /**
     * @param r - the Road you want to add to route
     */
    public void addRoad(Road r){
        this.roads.add(r);
        System.out.println(r+" has been added to the map.");
    }
    /**
     * @param r - the Road you want to remove from route
     */
    public void removeRoad(Road r){
        if(this.roads.contains(r))
            this.roads.remove(r);
        else
            System.out.println("Road not Found!");
    }

    /**
     * @param junc - the junction you want to add to route
     */
    public void addJunction(Junction junc){
        this.junctions.add(junc);
        System.out.println(junc+" has been added to the map.");
    }

    /**
     * @param junc - the junction you want to remove from route
     */
    public void  removeJunction(Junction junc) //removes the junction and all connected to it roads from the map.
    {
        //Remove Roads From Map
        if(this.junctions.contains(junc)) {
            for(int i=0;i<roads.size();i++){
                for(int j=0;j<junc.getExitingRoads().size();j++)
                    if(roads.get(i) == junc.getExitingRoads().get(j))
                        roads.remove(i);
                for(int j=0;j<junc.getEnteringRoads().size();j++)
                    if(roads.get(i) == junc.getEnteringRoads().get(j))
                        roads.remove(i);
            }
            this.junctions.remove(junc);
            System.out.println(junc+ " has been removed from the map.");
        }
        else
            System.out.println("junction not Found!");
    }

    //Bonus get methods (pdf run example)
    public ArrayList<Junction> getJunctions(){return this.junctions;}
    public ArrayList<Road> getRoads(){return this.roads;}

    public static int getNumberJuncs(){
        if(getNumberJuncs() == 0)
            return 0;
        return getNumberJuncs();
    }

    public void speedRandom(){
        int rnd;
        for(int i = 0; i< roads.size();i++) {
            rnd = new Random().nextInt((140 - 40) + 1) + 40;  //Random delay time between 40-140 kmh
            roads.get(i).setMaxSpeed(rnd);
        }
    }
}
