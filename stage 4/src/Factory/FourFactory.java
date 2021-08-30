package Factory;

import utilities.VehicleType;

public class FourFactory extends Factory {
    public FourFactory(){
    }
    @Override
    public synchronized VehicleType getVehicle(String y) {
        if(y=="private"){
            return VehicleType.car;
        }
        else if(y=="work"){
            return VehicleType.truck;
        }
        else    //y=="public"
            return VehicleType.bus;
    }
}
