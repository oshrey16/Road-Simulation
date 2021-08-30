package components;

import utilities.Utilities;
import utilities.VehicleType;

import java.sql.Time;

public class Vehicle implements Utilities, Time {
    private int id;
    private VehicleType vehicleType;
    private Route currentRoute;
    private RouteParts currentRoutePart;
    private int timeFromRouteStart;
    private int timeOnCurrentPart;
    private int objectsCount;
    private Road lastRoad;
    private String status;

    //Constructors:

    public Vehicle(Road road){
        //TODO
    }

    //Methods:
    public void move(){
        //TODO
    }
    
    public void incrementDrivingTime(){
        //TODO
    }
}
