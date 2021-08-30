package components;
import utilities.*;

import java.util.ArrayList;
import java.util.Random;

public class Junction {
    private String junctionName;
    private Point location;     // location of the junction on the map
    private ArrayList<Road> enteringRoads;   // holds the list of the roads that enter to the junction.
    private ArrayList<Road> exitingRoads;   // holds the list of the roads that exit the junction.
    private boolean hasLights; // checks if the junction has traffic lights.
    private int delay; // delay time in seconds
    private ArrayList<Vehicle> vehicles; //list of entering roads with cars waiting on the junction

    //Constructor
    public Junction(String name, Point loc) {
        enteringRoads = new ArrayList<Road>();
        exitingRoads = new ArrayList<Road>();
        vehicles = new ArrayList<Vehicle>();
        boolean random_lights = new Random().nextBoolean();
        this.hasLights = random_lights;

        this.location = loc;
        if (name != "") {
            this.junctionName = name;
            System.out.println("Junction " + junctionName + " has been created.");
        } else {
            System.out.println("Junction name error");
            System.exit(1);
        }
    }

    //Getters
    public String getJunctionName() {
        return junctionName;
    }

    public Point getLocation() {
        return location;
    }

    public ArrayList<Road> getEnteringRoads() {
        return enteringRoads;
    }

    public ArrayList<Road> getExitingRoads() {
        return exitingRoads;
    }

    public boolean getHasLights() {
        return hasLights;
    }

    public int getDelay() {
        return delay;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    //Setters
    public void setJunctionName(String name) {
        this.junctionName = name;
    }

    public void setLocation(Point loc) {
        this.location = loc;
    }

    public void setEnteringRoads(ArrayList<Road> enteringRoads) {
        this.enteringRoads = enteringRoads;
    }

    public void setExitingRoads(ArrayList<Road> exitingRoads) {
        this.exitingRoads = exitingRoads;
    }

    public void setHasLights(boolean hasLights) {
        this.hasLights = hasLights;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public void changeLight() {
        if(hasLights == true) {
            if (!this.enteringRoads.isEmpty()) {
                int size = this.enteringRoads.size();  //get number of EnteringRoads
                for (int i = 0; i < size; i++) {
                    if (this.enteringRoads.get(i).getIsOpen() == true)    //search and find green light
                    {
                        if (i + 1 != size) //check if this is end of array
                        {
                            this.enteringRoads.get(i).setIsOpen(false);
                            this.enteringRoads.get(i + 1).setIsOpen(true);
                            System.out.println("Road from " + this.enteringRoads.get(i + 1).getFromJunc().getJunctionName() + " to " + this.enteringRoads.get(i + 1).getToJunc().getJunctionName() + ": green light");
                            break;
                        } else {
                            this.enteringRoads.get(i).setIsOpen(false);
                            this.enteringRoads.get(0).setIsOpen(true);
                            System.out.println("Road from " + this.enteringRoads.get(0).getFromJunc().getJunctionName() + " to " + this.enteringRoads.get(0).getToJunc().getJunctionName() + ": green light");
                            break;
                        }
                    }
                }
            }
        }
        else        //junction without lights
        {
            int size = this.enteringRoads.size();  //get number of EnteringRoads
            for(int i=0;i<enteringRoads.size();i++){
                if(enteringRoads.get(i).getIsOpen() == true) {
                    if (i + 1 != size) //check if this is end of array
                    {
                        this.enteringRoads.get(i).setIsOpen(false);
                        this.enteringRoads.get(i + 1).setIsOpen(true);
                        break;
                    } else {
                        this.enteringRoads.get(i).setIsOpen(false);
                        this.enteringRoads.get(0).setIsOpen(true);
                        break;
                    }
                }
            }
        }
    }
    public boolean checkAvailability(Road r) {
        if (r.getIsOpen() == true)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return ("Junction " + junctionName);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Junction) {
            if (this.junctionName != ((Junction) o).junctionName)
                return false;
            if (this.enteringRoads != ((Junction) o).enteringRoads)
                return false;
            if (this.exitingRoads != ((Junction) o).exitingRoads)
                return false;
            if (this.location.equals(((Junction) o).location) == false)
                return false;
            if (this.hasLights != ((Junction) o).hasLights)
                return false;
            if (this.delay != ((Junction) o).delay)
                return false;
            if (this.vehicles != ((Junction) o).vehicles)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Set The lights on the junction.
     * check if lights already on if not - swich ON
     * else: do noting
     */
    public void setLightsOn() {
        this.hasLights = true;        //set light on
        if(this.delay == 0) {
            this.delay = new Random().nextInt((10 - 1) + 1) + 1;  //Random delay time between 1-10
            System.out.println("Junction " + junctionName + ": traffic lights ON. Delay time: " + this.delay);      //display lights ON
            if (!this.enteringRoads.isEmpty()) {
                this.enteringRoads.get(0).setIsOpen(true);
                System.out.println("Road from " + this.enteringRoads.get(0).getFromJunc().getJunctionName() + " to " + this.enteringRoads.get(0).getToJunc().getJunctionName() + ": green light");
            }
        }
    }

    public void shut_downlights() {
        for(int i=0;i<enteringRoads.size();i++){
            enteringRoads.get(i).setIsOpen(false);
        }
    }
}
