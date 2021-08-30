package components;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Road {
    private Junction fromJunc;      //from junction
    private Junction toJunc;        //to junction
    private ArrayList<VehicleType> allowedVehicles;   // holds the list of vehicle types that are allowed to move on the road.
    private boolean isOpen;     // True when the light is green.
    private boolean isEnabled;  //appears on the map
    private double length;      //the distance between the two junctions.
    private int maxSpeed;       //max speed on this road

    //Constructors
    public Road (Junction from, Junction to)
    {
        this.fromJunc = from;
        this.toJunc = to;
        boolean random = new Random().nextBoolean();
        isOpen = random;
        random = new Random().nextBoolean();
        isEnabled = random;
        length = this.countLength();    //calc the distance between points
        //Random speed in road (between 20-140 kmh)
        this.maxSpeed = new Random().nextInt((140 - 20) + 1) + 20;
        //Connect Junctions with road
        fromJunc.getExitingRoads().add(this);
        toJunc.getEnteringRoads().add(this);
        System.out.println("Road from " + fromJunc.getJunctionName() + " to " + toJunc.getJunctionName() + " has been created");
        //TODO
    }
    public Road (Junction from, Junction to, ArrayList<VehicleType> allowed, boolean open, boolean enabled)
    {
        this.fromJunc = from;
        this.toJunc = to;
        this.allowedVehicles = allowed;
        this.isOpen = open;
        this.isEnabled = enabled;
        this.length = this.countLength();    //calc the distance between points
        //Random speed in road (between 20-140 kmh)
        this.maxSpeed = new Random().nextInt((140 - 20) + 1) + 20;
        //Connect Junctions with road
        fromJunc.getExitingRoads().add(this);
        toJunc.getEnteringRoads().add(this);
        System.out.println("Road from " + fromJunc.getJunctionName() + " to " + toJunc.getJunctionName() + " has been created");
    }

    //Getters
    public Junction getFromJunc(){return this.fromJunc;}
    public Junction getToJunc(){return  this.toJunc;}
    public ArrayList<VehicleType> getAllowedVehicles() {return this.allowedVehicles;}
    public boolean getIsOpen() {return this.isOpen;}
    public boolean getIsEnabled(){return this.isEnabled;}
    public double getLength(){return this.length;}
    public int getMaxSpeed(){return this.maxSpeed;}

    //Setters
    public void setFromJunc(Junction fromJunc){
        this.fromJunc = fromJunc;
        this.length = this.countLength();
    }
    public void setToJunc(Junction toJunc){
        this.toJunc = toJunc;
        this.length = this.countLength();
    }
    public void setAllowedVehicles(ArrayList<VehicleType> allowed){
        this.allowedVehicles = allowed;
    }
    public void setIsOpen(boolean isopen){
        this.isOpen = isopen;
    }
    public void setEnabled(boolean isEnabled){this.isEnabled = isEnabled;}
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    //Methods
    public void addVehicleType(VehicleType type){
        this.allowedVehicles.add(type);
    }

    /**
     * calculate the distance of road from start junction to end junction with using the coordinates(points: locations of junctions).
     * the formula(distance): d=sqrt((x1-x2)^2 + (y1-y2)^2)).
     * @return the distance of road.
     */
    public double countLength(){
        //get points parameters
        double x1 = this.fromJunc.getLocation().getX();  //Point is double (x,y)
        double y1 = this.fromJunc.getLocation().getY();
        double x2 = this.toJunc.getLocation().getX();
        double y2 = this.toJunc.getLocation().getY();

        //Distance calculate: sqrt((x1-x2)^2 + (y1-y2)^2)
        double distance = x1-x2;
        distance = distance *distance;
        double helper = y1-y2;
        helper = helper * helper;
        distance = distance + helper;
        distance = Math.sqrt(distance);
        return distance;
    }

    @Override
    public String toString(){
        return "Road from " + fromJunc.getJunctionName() + " to " + toJunc.getJunctionName();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o instanceof Road)
        {
            if(fromJunc != ((Road) o).fromJunc)
                return false;
            if(toJunc != ((Road) o).toJunc)
                return false;
            if (allowedVehicles != ((Road) o).allowedVehicles)
                return false;
            if(isOpen != ((Road) o).isOpen)
                return false;
            if(isEnabled != ((Road) o).isEnabled)
                return false;
            if(length != ((Road) o).length)
                return false;
            if(maxSpeed != ((Road) o).maxSpeed)
                return false;
            return true;
        }
        return false;
    }
}