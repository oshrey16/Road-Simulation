package components;

public class LightedJunction extends Junction{
    private TrafficLights lights;

    //Constructors:

    /**
     * Create Random Junction.
     * random type of TrafficLights (Random or sequential)
     * add Traffic Lights to the junction.
     */
    public LightedJunction(){
        //TODO
    }

    /**
     * Constructor LightedJunction with parameters.
     * Build junction(super) with name,Point(x,y) and update parameters to LightedJunction
     * @param name - name of junction
     * @param x - x parameter to Point
     * @param y - y parameter to Point
     * @param sequential - true if lights is sequential. false if lights is Random
     * @param lightsOn - true if lights On else false
     */
    public LightedJunction(String name,double x, double y, boolean sequential, boolean lightsOn){
        //TODO
    }

    //Methods:

    /**
     * interface method
     * this method calculate the waiting time on junction for vehicle.
     * Estimated time calculate:
     * time = delay time of traffic lights * (count of entering roads-1)
     * @param obj - Vehicle. in the vehicle we have the current Road the check the priority.
     * @return time+1 (add 1 to leave the junction)
     */
    @Override
    public double calcEstimatedTime(Object obj) {
        //TODO
        return 0;
    }

    /**
     * this function check if vehicle can leave the junction and keep driving to the next road.
     * check with Traffic light if vehicle can leave the junction
     * @param vehicle - the vehicle to check
     * @return true if vehicle can leave
     * else: false
     */
    public boolean canLeave(Vehicle vehicle){
        //TODO
        return false;
    }
}
