package lawNorder;

import components.Road;
import components.Vehicle;

import java.io.IOException;

public class BigBrother {
    private static BigBrother instance;
    private BigBrother(){
    }

    public static BigBrother getInstance(){
        if(instance == null){
            synchronized (BigBrother.class){
                if(instance == null){
                    instance = new BigBrother();
                }
            }
        }
        return instance;
    }

    public synchronized void reportarrive(Vehicle v){
        int averagespeed;
        //oktieveragespeedme = (int) ((Road) v.getCurrentRoutePart()).getLength() / ((Road) v.getCurrentRoutePart()).getMaxSpeed();
        averagespeed = (int) ((Road) v.getCurrentRoutePart()).getLength() / v.getTimeOnCurrentPart();       //average speed to vehcile
        averagespeed *= 10;
        System.out.println("SPEEED: " + averagespeed);
        if(averagespeed > ((Road) v.getCurrentRoutePart()).getMaxSpeed()){
            System.out.println("REPORT!!!!");
            Moked.writeReport(v);
        }
    }
}
