package Factory;

import utilities.VehicleType;

public class TwoFactory extends Factory {
    public TwoFactory(){
    }

    @Override
    public synchronized VehicleType getVehicle(String y) {
        if(y=="fast"){
            return VehicleType.motorcycle;
        }
        else    //"slow"
            return VehicleType.bicycle;
    }
}
