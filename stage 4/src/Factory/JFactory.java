package Factory;

import components.Junction;
import components.LightedJunction;

import java.util.Random;

public class JFactory {
    public synchronized Junction getJunction(String x){
        if(x=="city"){
            return (new LightedJunction());
        }
        else        //x=="contry
        {
            if(new Random().nextBoolean()) {
                return (new LightedJunction());
            }
            else
                return (new Junction());
        }
    }
}
