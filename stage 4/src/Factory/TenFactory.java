package Factory;

import utilities.VehicleType;

public class TenFactory extends Factory {
    public TenFactory(){
    }

    @Override
    public synchronized VehicleType getVehicle(String y) {
        if(y=="public"){
            return VehicleType.tram;
        }
        else        //y=="work"
            return VehicleType.semitrailer;
    }
}
