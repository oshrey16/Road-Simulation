package components;

import utilities.Utilities;
import utilities.VehicleType;

import java.util.ArrayList;

public class Road implements RouteParts, Utilities {
    private final int[] allowedSpeedOptions = {30,40,50,55,60,70,80,90};      //array with values. allow speed in roads.
    private boolean enable;     //true-road on map and vehicles can drive on this road
    private Junction startJunction;     //Junction in Start of the road
    private Junction endJunction;       //Junction in End of the road
    private boolean greenlight;         //true if green light to this road
    private double lenght;          //length of the road
    private int maxSpeed;           //max speed on the road.random from allowedSpeedOptions
    private VehicleType[] vehicleTypes;         //array with allowed types driving on this road.
    private ArrayList<Vehicle> waitingVehicles;     //List of waiting vehicles on this road.

    //Constructors:

    /**
     * Constructor Road.
     * set all fields, set road from start junction to end junction
     * @param start - start junction
     * @param end - end junction
     */
    public Road(Junction start, Junction end){
        //TODO
    }

    /**
     * This method add vehicle to waitingVehicles list
     * @param vehicle -  This vehicle add to the list
     */
    public void addVehicleToWaitingVehicles(Vehicle vehicle){
        //TODO
    }

    /**
     * This method calculate estimated time to pass the road.
     * calc by Vehicle speed,maximum speed on road.
     * formula: length/min(vehicleSpeed or road speed)
     * @param obj - Vehicle to calculate estimated time
     * @return Rounding estimated time (like int)
     */
    public double clacEstimatedTime(Object obj){
        //TODO
        return 0;
    }

    /**
     * This method calcuate the length of the road
     * formula : distance.
     * sqrt((x2-x1)^2 + (y2-y1)^2) = distance
     * use from package utilities,Point - calcDistance(Point)
     * @return the distance between 2 junctions - length of road.
     */
    public double calcLength(){
        return(startJunction.calcDistance(endJunction.getPoint()));
    }

    /**
     * This Method check if vehicle can be passed the route in this road.
     * @param vehicle - the vehicle to check
     * @return true if waiting time for vehicle equal or bigger from clacEstimatedTime
     */
    public boolean canLeave(Vehicle vehicle){
        //TODO
        return false;
    }


    /**
     * This method insert vehicle to road.
     * update all fields and print message.
     * @param vehicle - the vehicle to insert
     */
    public void checkIn(Vehicle vehicle){
        //TODO
    }

    /**
     * This method "release" vehicle from the Road
     * @param vehicle - the vehicle to remove
     */
    public void checkOut(Vehicle vehicle){

    }

    /**
     * this method check the last junction for the vehicle on route.
     * @param vehicle - the vehicle to check for him the last junction
     * @return junction of the end for this vehicle
     */
    public RouteParts findNextPart(Vehicle vehicle){

    }

    /**
     * remove the vehicle from waiting list of junction
     * @param vehicle - the vehicle pass the junction
     */
    public void removeVehicleFromWaitingVehicles(Vehicle vehicle){

    }

    /**
     * enabled when vehicle still on the road in beat.
     * print message.
     * @param vehicle - the vehicle check if him on road
     */
    public void stayOnCurrentPart(Vehicle vehicle){

    }
}
