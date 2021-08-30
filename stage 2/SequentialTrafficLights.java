package components;

import java.util.ArrayList;

/**
 * SequentialTrafficLights Class
 * This Class is Sequential Traffic Lights.
 * move all over the entering roads in List
 * after delay time- turn OFF green light of entering road and turn ON the next entering road
 */
public class SequentialTrafficLights extends TrafficLights {
    private int increment=1;      //serial increase, change value X and turn ON X steps index from current ON

    //Constructors

    /**
     * This Constructor create Sequential Traffic Lights
     * Set list of entering roads. first will be green, then 2 ...
     * @param roads - Entering roads to Junction (Sequential Traffic Lights)
     */
    SequentialTrafficLights(ArrayList<Road> roads){

    }
    //Methods

    /**
     * this method Turn OFF current Traffic lights and Turn ON next Traffic lights.
     */
    public void changeIndex(){
        //TODO
    }
}
