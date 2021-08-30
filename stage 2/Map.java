package components;

import utilities.Utilities;

import java.util.ArrayList;

/**
 * Class : Map
 * map of all traffic with junctions, roads and lights.
 */
public class Map implements Utilities {

    private ArrayList<Junction> junctions;
    private ArrayList<Road> roads;
    private ArrayList<TrafficLights> lights;

    //Constructor

    /**
     * Constructor Map
     * build map with Random junctions (with or without Traffic Lights)
     * build roads between the ALL junctions
     * Random junctions with Traffic lights Turn ON the lights (Random TurnON)
     * @param numOfJunctions - number of junctions on the Map
     */
    Map(int numOfJunctions){
        //TODO
    }


    //Methods

    /**
     * This Method Build The Roads For the Map constructor; method help for constructor
     */
    public void SetAllRoads(){
        //TODO
    }

    /**
     * This Method turn the lights on in Junctions; method help for constructor
     */
    public void turnLightsOn(){
        //TODO
    }
}
