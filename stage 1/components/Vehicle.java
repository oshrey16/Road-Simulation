package components;

import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
    private int id;
    private VehicleType type;
    private int speed;      //average speed for this type of vehicle.
    private Route currentRoute;
    private Junction lastJunction;      //current junction or last junction where the vehicle visited
    private Road lastRoad;
    private boolean movesNow;       //True if the vehicle is on the road between the junctions.
    private double spentTime;       //time passed from the beginning of movement on the route.

    //Constructor
    public Vehicle(int id, VehicleType type, Junction lastJunction) {
        this.id = id;
        this.type = type;
        this.lastJunction = lastJunction;
        spentTime = 0;
        movesNow = false;
        currentRoute = new Route(lastJunction,type);
        speed = type.getSpeed();
        lastRoad = currentRoute.getRoads().get(0);
        System.out.println(type + " ID: " + id + " has been created and placed at " + lastJunction +".");
    }

    //Getters
    public int getId() {return id;}
    public VehicleType getType(){return type;}
    public int getSpeed(){return speed;}
    public Route getCurrentRoute(){return currentRoute;}
    public Junction getLastJunction() {return lastJunction;}
    public Road getLastRoad(){return lastRoad;}
    public boolean getMovesNow(){return movesNow;}
    public double getSpentTime(){return spentTime;}

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setType(VehicleType type){
        this.type = type;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setCurrentRoute(Route currentRoute){
        this.currentRoute = currentRoute;
    }
    public void setLastJunction(Junction lastJunction){
        this.lastJunction = lastJunction;
    }
    public void setLastRoad(Road lastRoad){this.lastRoad = lastRoad;}
    public void setMovesNow(boolean movesNow){
        this.movesNow = movesNow;
    }
    public void setSpentTime(double spentTime){
        this.spentTime = spentTime;
    }

    @Override
    public String toString(){
        return (type +  ", average speed: "  + speed + ", ID: " + id);
    }
    //Methods
    /**
     * wait for the current point delay time and move to the next point of the route.
     */
    public void move() {
        if(lastJunction != currentRoute.getEnd() || spentTime == 0) {     //check if arrived to End Of the Route.
            if(lastJunction == currentRoute.getStart())
            {
                System.out.println(this + " is starting route " + currentRoute);
            }
            if (lastJunction.getHasLights() == true) {
                if (lastRoad.getIsOpen() == false)      //red light
                {
                    spentTime = spentTime + this.lastJunction.getDelay();
                    System.out.println(this + " is waiting for green light at " + lastJunction);
                } else        //green light
                {
                    //Check if this is the last junction
                    int index = 0;
                    for (int i = 0; i < currentRoute.getJunctions().size(); i++) {
                        //get the index from route
                        if (currentRoute.getJunctions().get(i) == lastJunction)
                            index = i + 1;
                    }
                    if (index != currentRoute.getJunctions().size())     //check if this is not the last junction
                    {
                        checkOut();
                        if (speed <= lastRoad.getMaxSpeed())
                            spentTime = spentTime + lastRoad.getLength() / speed;     //speed limit
                        else
                            spentTime = spentTime + lastRoad.getLength() / lastRoad.getMaxSpeed();
                        lastJunction = currentRoute.getJunctions().get(index);
                        System.out.println(this + " is moving on Road from " + lastRoad.getFromJunc() + " to " + lastRoad.getToJunc() + ". Delay time: " + spentTime);
                        checkIn();
                    } else {
                        System.out.println(this + " stays at " + lastJunction + " - no exiting roads.");
                    }
                }
            } else        //junction without lights
            {
                if (lastRoad.getIsOpen() == false) {
                    spentTime = spentTime + 10;     //10 sec wait in junction
                    System.out.println(this + " is waiting for his priority at " + lastJunction);
                } else {
                    //Check if this is the last junction
                    int index = 0;
                    for (int i = 0; i < currentRoute.getJunctions().size(); i++) {
                        //get the index from route
                        if (currentRoute.getJunctions().get(i) == lastJunction)
                            index = i + 1;
                    }
                    if (index != currentRoute.getJunctions().size())     //check if this is not the last junction
                    {
                        checkOut();
                        if (speed <= lastRoad.getMaxSpeed())
                            spentTime = spentTime + lastRoad.getLength() / speed;     //speed limit
                        else
                            spentTime = spentTime + lastRoad.getLength() / lastRoad.getMaxSpeed();
                        lastJunction = currentRoute.getJunctions().get(index);
                        System.out.println(this + " is moving on Road from " + lastRoad.getFromJunc() + " to " + lastRoad.getToJunc() + ". Delay time: " + spentTime);
                        checkIn();
                    } else {
                        System.out.println(this + " stays at " + lastJunction + " - no exiting roads.");
                    }
                }
            }
        }
        else        //has arrived to End Of the Route.
        {
            System.out.println(this + " has arrived to " + currentRoute.getEnd());
        }
    }

    /**
     * prints the details about the vehicle including current position,
     * time spent on the route and the first and last junctions on the route.
     */
    public void status(){
        System.out.println(this + ". Position: " + lastJunction + " Current Route: " + currentRoute + " Time spent: " + spentTime);
    }

    public  void checkOut(){
        ArrayList<Vehicle> temp = lastJunction.getVehicles();
        temp.remove(this);
        this.lastJunction.setVehicles(temp);
        movesNow = true;
        System.out.println(this + " has left " + lastJunction);
    }
    /**
     * if arrived to a junction, update the junction waiting list
     * and calculate the delay time before the next move.
     */
    public void checkIn(){
        ArrayList<Vehicle> temp = lastJunction.getVehicles();
        temp.add(this);
        this.lastJunction.setVehicles(temp);
        movesNow = false;
        System.out.println(this + " has arrived to " + lastJunction);
    }
}
