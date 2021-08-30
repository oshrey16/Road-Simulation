package Factory;
import components.*;
import utilities.VehicleType;

import java.util.Random;

public class Factory {
    TwoFactory f1;
    FourFactory f2;
    TenFactory f3;

    public Factory(){
        f1 = new TwoFactory();
        f2 = new FourFactory();
        f3 = new TenFactory();
    }
    public synchronized Factory getFactory(int x) {
        if(x==2){
            return f1;
        }
        else if(x==4){
            return f2;
        }
        else if(x==10){
            return f3;
        }
        else{
            System.out.println("ERROR");
            return null;
        }
    }

    public synchronized VehicleType getVehicle(String y){
        return null;
    };

    //Random arr size
    public synchronized String random_y(int x){
        String [] arr = null;
        int rnd;
        if(x==2){
            rnd = new Random().nextInt(2);
            arr = new String[]{"fast","slow"};
            return arr[rnd];
        }
        else if(x==4){
            rnd = new Random().nextInt(3);
            arr = new String[]{"private","work","public"};
            return arr[rnd];
        }
        else {
            rnd = new Random().nextInt(2);
            arr = new String[]{"public", "work"};
            return arr[rnd];
        }
    }

    public static Vehicle prototype(int numbervehicle){
        System.out.println(numbervehicle);
        Vehicle temp = Driving.getvehiclefromarray(numbervehicle);
        Vehicle temp1 = new Vehicle(temp.getLastRoad());
        temp1.setVehicleType(temp.getVehicleType());
        return (temp1);
    }
}
