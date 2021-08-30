package utilities;
import java.util.Random;

public class Point {
    private final double min_x = 0;
    private final  double max_x = 1000000;
    private final double min_y = 0;
    private final  double max_y = 800;
    private double x;
    private double y;

    //Constructor
    public Point(){
        //Random X between 0-1000000
        double random = new Random().nextDouble();  //random: 0.xxxxxxxx
        double result1 = min_x + (random * (max_x - min_x));
        //Random Y between 0-800
        random = new Random().nextDouble();         //random: 0.xxxxxxx
        double result2 = min_y + (random * (max_y - min_y));
        this.x = result1;
        this.y = result2;
        System.out.println("Point " + this + " has been created");
    }

    public Point(double x,double y)
    {
        if(x>=min_x && x<=max_x){
            if(y>=min_y && y<=max_y) {
                this.x = x;
                this.y = y;
                System.out.println("Point " + this + " has been created");
            }
            else        //Y is illegal
            {
                double random = new Random().nextDouble();  //Random Y between 0-800
                double result = min_y + (random * (max_y - min_y));     //Random.nextdouble return 0.xxxxxx and calc by range
                System.out.println("The value "+ y +" is illegal forY, therefore has been replaced with " + result);
                this.x = x;
                this.y = result;
                System.out.println("Point " + this + " has been created");
            }
        }
        else                //X is illegal
        {
            double random = new Random().nextDouble();  //Random X between 0-1000000
            double result = min_x + (random * (max_x - min_x));
            System.out.println("The value "+ x +" is illegal forX, therefore has been replaced with " + result);
            if(y>=min_y && y<=max_y) {
                this.x = result;
                this.y = y;
                System.out.println("Point " + this + " has been created");
            }
            else        //Y is illegal
            {
                random = new Random().nextDouble();  //Random Y between 0-800
                double result2 = min_y + (random * (max_y - min_y));
                System.out.println("The value "+ y +" is illegal forY, therefore has been replaced with " + result2);
                this.x = result;
                this.y = result2;
                System.out.println("Point " + this + " has been created");
            }
        }
    }

    //Getters
    public double getX() {return x;}
    public double getY() {return y;}

    //Setters
    public void setX(double x){
        if(x>=min_x && x<= max_x)
            this.x = x;
        else
            System.out.println("The value " + x + " is illegal for x");
    }

    public void setY(double y){
        if(y>=min_y && y<= max_y)
            this.y = y;
        else
            System.out.println("The value " + y + " is illegal for y");
    }

    @Override
    public String toString()
    {
        return ("(" + x + " , " + y + ")");
    }

    @Override
    public boolean equals(Object p)
    {
        if(p == this)
            return true;
        if(p instanceof Point)
        {
            if(this.x == ((Point) p).x && this.y == ((Point) p).y)
                return true;
            return false;
        }
        return false;
    }
}
