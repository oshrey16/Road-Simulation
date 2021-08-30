package game;

import components.Map;
import components.Vehicle;
import components.VehicleType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Driving {
    private int numOfJuncs;
    private int numOfVehicles;
    private Map currentMap;
    private ArrayList<Vehicle> currentVehicles;
    private double drivingTime;     //time passed from the beginning of driving session
    private int maxTime;        // total round time

    public Driving(int juncs, int vehicles, int maxTime) {
        currentMap = new Map(juncs);
        currentVehicles = new ArrayList<Vehicle>();
        this.numOfJuncs = juncs;
        this.numOfVehicles = vehicles;
        this.maxTime = maxTime;

        int lightsdelay;
        boolean random;
        int firstgreen , maxroads;      //max Entering roads on junction
        for(int i=0;i<currentMap.getJunctions().size();i++)
        {
            random = new Random().nextBoolean();
            lightsdelay = new Random().nextInt((60+10)+1)+1;        //random delay time on junction
            currentMap.getJunctions().get(i).setDelay(lightsdelay);
            currentMap.getJunctions().get(i).setHasLights(random);
            if(random == true)      //has lights
            {
                currentMap.getJunctions().get(i).shut_downlights();     //close all green lights and random
                maxroads = currentMap.getJunctions().get(i).getEnteringRoads().size();
                firstgreen = new Random().nextInt(maxroads);
                currentMap.getJunctions().get(i).getEnteringRoads().get(firstgreen).setIsOpen(true);
                break;      //stop random because one is green light
            }
        }
        addVehicles(vehicles);
    }

    //Getters
    public int getNumOfJuncs() {return numOfJuncs;}
    public int getNumOfVehicles() {return numOfVehicles;}
    public Map getCurrentMap() {return currentMap;}
    public ArrayList<Vehicle> getCurrentVehicles() {return currentVehicles;}
    public double getDrivingTime() {return drivingTime;}
    public int getMaxTime() {return maxTime;}
    public ArrayList<Vehicle> getVehicles(){return this.currentVehicles;}       //for example fix

    //Setters
    public void setNumOfJuncs(int numOfJuncs) {this.numOfJuncs = numOfJuncs;}
    public void setNumOfVehicles(int numOfVehicles) {this.numOfVehicles = numOfVehicles;}
    public void setCurrentMap(Map currentMap) {this.currentMap = currentMap;}
    public void setCurrentVehicles(ArrayList<Vehicle> currentVehicles) {this.currentVehicles = currentVehicles;}
    public void setDrivingTime(double drivingTime) {this.drivingTime = drivingTime;}
    public void setMaxTime(int maxTime) {this.maxTime = maxTime;}

    /**
     * creates a map with random (10-25) junctions quantity.
     */
    public void addMap() {
        Random r = new Random();
        int low = 10;
        int high = 26;
        int result = r.nextInt(high-low) + low;
        this.currentMap = new Map(result);
    }

    /**
     * creates random number (2-8) of vehicles of different types.
     */
    public void addVehicles(){
        this.currentVehicles.clear();   //remove all Vehicles if exists
        Random r = new Random();
        int low = 2;
        int high = 9;
        int result = r.nextInt(high-low) + low;
        int low_junc = 0;
        int high_junc = this.numOfJuncs;
        for(int i = 0; i<result;i++){
            int result_juncts = r.nextInt(high_junc-low_junc) + low_junc;
            currentVehicles.add(new Vehicle(i, VehicleType.getRandomVehicleTypes().get(0) ,currentMap.getJunctions().get(result_juncts)));
        }
    }

    public void startDrive(int maxTime) {
        for (int i = 0; i < maxTime; i++) {
            System.out.println("TURN " + (i+1));
            for (int j = 0; j < numOfVehicles; j++) {
                currentVehicles.get(j).move();
            }
            for(int j=0;j<numOfJuncs;j++)
                currentMap.getJunctions().get(j).changeLight();
            System.out.println();
        }

        System.out.println("STATUS ");
        for (int j = 0; j < numOfVehicles; j++) {
            currentVehicles.get(j).status();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driving)) return false;
        Driving driving = (Driving) o;
        return numOfJuncs == driving.numOfJuncs &&
                numOfVehicles == driving.numOfVehicles &&
                Double.compare(driving.drivingTime, drivingTime) == 0 &&
                maxTime == driving.maxTime &&
                Objects.equals(currentMap, driving.currentMap) &&
                Objects.equals(currentVehicles, driving.currentVehicles);
    }

    @Override
    public String toString() {
        return "Driving{" +
                "numOfJuncs=" + numOfJuncs +
                ", numOfVehicles=" + numOfVehicles +
                ", currentMap=" + currentMap +
                ", currentVehicles=" + currentVehicles +
                ", drivingTime=" + drivingTime +
                ", maxTime=" + maxTime +
                '}';
    }

    /**
     * @param vehicles - add number of vehicles.
     * create number of random types of vehicles and add to list of vehicles
     */
    public void addVehicles(int vehicles){
        this.currentVehicles.clear();   //remove all Vehicles if exists
        Random r = new Random();        //random start junction
        int low = 0;
        int high = currentMap.getJunctions().size();
        for(int i = 0; i<vehicles;i++){
            int result_juncts = r.nextInt(high-low) + low;
            currentVehicles.add(new Vehicle(i, VehicleType.getRandomVehicleTypes().get(0) ,currentMap.getJunctions().get(result_juncts)));
        }
    }
}
