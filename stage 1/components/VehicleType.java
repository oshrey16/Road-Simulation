package components;
import java.util.ArrayList;
import java.util.Random;

public class VehicleType {
    private String TypeName;
    private int speed;      //average speed of vehicle type

    //Constructor
    public VehicleType(String name, int speed){
        this.TypeName = name;
        this.speed = speed;
    }
    //Methods
    @Override
    public String toString(){
        return this.TypeName+", average speed: " + this.speed;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o instanceof VehicleType){
            if(((VehicleType) o).TypeName == this.TypeName && ((VehicleType) o).speed == this.speed)
                return true;
        }
        return false;
    }

    //Getters
    public String getName(){return this.TypeName;}
    public int getSpeed(){return this.speed;}
    public String getTypeName(){return this.TypeName;}

    /**
     *
     * @return ArrayList With types of vehicles. the number of types limited up to 3
     * and set speed to type.
     */
    public static ArrayList<VehicleType> getRandomVehicleTypes(){
        ArrayList<VehicleType> x = new ArrayList<VehicleType>();
        int numtypes = new Random().nextInt((3 - 1) + 1) + 1;   //random limited 3 Types of vehicles on road
        while(numtypes!=0) {
            String[] arr = {"bicycle", "bus", "car", "motorcycle", "truck"};
            int rand = new Random().nextInt(5);
            int speed;
            if (rand == 0)
                speed = 40;
            else {
                if (rand == 1)
                    speed = 60;
                else {
                    if (rand == 2)
                        speed = 90;
                    else {
                        if (rand == 3)
                            speed = 120;
                        else
                            speed = 70;
                    }
                }
            }
            VehicleType g = new VehicleType(arr[rand], speed);
            x.add(g);
            numtypes--;
        }
        return x;
    }
}
