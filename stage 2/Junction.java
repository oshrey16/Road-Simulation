package components;

import utilities.Point;

import java.util.ArrayList;

/**
 * This class is Junction without lights.
 * @author Oshrey Avraham
 */
public class Junction extends Point implements RouteParts {
    private static int objectsCount=1;       //Count objects has been created
    private ArrayList<Road> enteringRoads;      //List of entering roads to this junction
    private ArrayList<Road> exitingRoads;       //List of exiting roads from this junction
    private String junctionName;            //Name of junction

    //Constructors:
    /**
     * Random Constructor. Build random point.
     * Set all parameters.
     * Set NameJunction with his serial number in class
     */
    public Junction(){
        super();        //Create Random Point
        junctionName = String.valueOf(objectsCount);
        enteringRoads = new ArrayList<Road>();
        exitingRoads = new ArrayList<Road>();
        objectsCount++;     //increase counter
    }
    /**
     * Build Junction with parameters.
     * Point(x,y), junctionname.
     * @param junctionName - Name of the Junction.
     * @param x - x parameter to Point
     * @param y - y parameter to Point
     */
    public Junction(String junctionName, double x, double y) {
        super(x, y);
        this.junctionName = junctionName;
        enteringRoads = new ArrayList<Road>();
        exitingRoads = new ArrayList<Road>();
        objectsCount++;     //increase counter
    }

    //Methods:

    /**
     * this function add a road to list of enteringRoads
     * @param road - road to add
     */
    public void addEnteringRoad(Road road){
        //TODO
    }

    /**
     * this function add a road to list of exitingRoads
     * @param road - road to add
     */
    public void addExitingRoad(Road road){
        //TODO
    }

    /**
     * this method calculate to vehicle the maximum time of waiting in the junction
     * the junctions without light, so the time calculate by count of enteringRoads and index road for the vehicle
     * smaller index: high priority - more fast.
     * @param obj - Vehicle. in the vehicle we have the current Road the check the priority.
     * @return count of ways with higher priority than current way of vehicle +1 (pass junction in 1 beat)
     */
    public double calcEstimatedTime(Object obj){
        return 3;
        //TODO
    }

    /**
     * this function check if vehicle can leave the junction and keep driving to the next road.
     * @param vehicle - the vehicle to check
     * @return true if vehicle can leave, else:false
     */
    public boolean canLeave(Vehicle vehicle){
        return false;
        //TODO
    }

    /**
     * help to canLeave function.
     * this method check:
     * if exists exiting roads from the jucntion
     * if in current entering road (for the vehicle) the vehicle is the first.
     * @param vehicle - current vehicle to check
     * @return - true if junction has exiting road/s and the vehicle is the first on waiting list on enterRoad.
     * else: false
     */
    public boolean checkAvailability(Vehicle vehicle){
        //TODO
        return false;
    }

    /**
     * this method belongs to RouteParts.
     * Enabled when vehicle can leave the junction
     * the method update all fields - because vehicle leave the junction!
     * and Print message.
     * @param vehicle - the vehicle that leave the junction
     */
    public void checkOut(Vehicle vehicle){
        //TODO
    }

    /**
     * interface method.
     * find the next part to build random Route to Vehicle.
     * this method check if junction has exiting roads and the enabled.
     * check if the road selected has permission to the vehicle (list of permission types vehicles)
     * @param vehicle - check the routes options to this vehicle
     * @return one of the exiting roads (if all ok) - by random
     * else: return null
     */
    public RouteParts findNextPart(Vehicle vehicle){
        //TODO
    }

    /**
     * interface method.
     * The method enabled when the vehicle cannot leave the junction in this beat.
     * print message.
     * @param vehicle -  the no leave vehicle
     */
    public void stayOnCurrentPart(Vehicle vehicle){
        //TODO
    }
}
