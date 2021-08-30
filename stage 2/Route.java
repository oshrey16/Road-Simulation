package components;

import utilities.VehicleType;

import java.util.ArrayList;

public class Route implements RouteParts {
    private ArrayList<RouteParts> RouteParts;           //list of junctions and roads. start to end.
    private Vehicle vehicle;            //Route build for Vehicle: vehicle

    //Constructors:

    /**
     * Random Constructor,search next RouteParts from current RouteParts
     * until 10 RouteParts in the Route
     * OR
     * cant find RouteParts (junction without ways out for this vehicle)
     *
     * @param start   - start of the route
     * @param vehicle - the route for the vehicle
     */
    Route(RouteParts start, Vehicle vehicle) {

    }

    //Methods:

    /**
     * this method calculate the estimated time to pass the route for the vehicle.
     * @param obj - vehicle to calc estimated time
     * @return Estimated Time
     */
    public double calcEstimatedTime(Object obj){

        //TODO
        return 0;
    }

    /**
     * Check if vehicle arrive to end of route
     * @param vehicle - the vehicle to check for
     * @return true if vehicle arrive to the end of route
     * else - false.
     */
    public boolean canLeave(Vehicle vehicle){
        return false;
        //TODO
    }


    /**
     * This method update the vehicle on route (when vehicle get the route)
     * update all fields
     * print message
     * @param vehicle - the vehicle to update on route
     */
    public void checkIn(Vehicle vehicle){

    }

    /**
     * This Method "release" vehicle from route
     * print message
     * @param vehicle - the vehile to "release" from route
     */
    public void checkOut(Vehicle vehicle){

    }

    /**
     * if vehicle arrive to last PartRoute
     * this method make new route for vehicle
     * -if vehicle arrive to last RouteParts:
     *      -if there no more ways from current junction:
     *          make new Route (random) from the old start RouteParts
     *      else:
     *          continue route from current junction.
     * -else(if vehicle not arrive to end):
     *      return next RoutePart from current RoutePart
     * @param vehicle - the vehicle to check and build new route
     * @return if vehicle not arrive: new Route
     *          else: next RoutePart from current RoutePart
     */
    public RouteParts findNextPart(Vehicle vehicle){
        //TODO
    }

    /**
     * print message that vehicle still driving in current route
     * @param vehicle
     */
    public void stayOnCurrentPart(Vehicle vehicle){

    }
}
