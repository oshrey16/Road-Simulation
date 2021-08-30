package components;

import utilities.Timer;
import utilities.Utilities;

import java.util.ArrayList;

/**
 * Abstract Class for Traffic Lights
 */
public abstract class TrafficLights implements Timer, Utilities {
    private int objectsCount;      //count of Objects of this class
    private int delay;             //waiting time to change lights. OFF-0, ON-Random 2 to 6 seconds
    private int greenLightIndex;   //index of Green Light Road in the entering list
    private int id;             //id to Traffic Light
    private final int minDelay = 2;           //minimum value to delay
    private final int maxDelay = 6;             //maximum value to delay
    private ArrayList<Road> roads;          //Entering Roads to Junction with this TrafficLight
    private boolean trafficLightsOn;        //true - Lights ON. false - Lights OFF.
    private int workingTime;                //count beats since lights ON

    //Constructors:

    /**
     * Constructor Traffic Lights
     * Get Entering Road list, set all fields
     * @param roads - entering roads list
     */
    public TrafficLights(ArrayList<Road> roads){
        //TODO
    }

    //Methods:
    public abstract void changeIndex();

    /**
     * This method change color in Junction traffic lights.
     * get index next entering road, then
     * check if all entering roads are Red and turn green light to next entering road.
     * print message - lights changed!
     */
    public void changeLights(){
        //TODO
    }

    /**
     * This method increase time action for Traffic light and check if time to Change lights.
     */
    public void incrementDrivingTime(){
        //TODO
    }
}
