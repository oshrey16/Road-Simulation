package utilities;
import components.*;
import game.Driving;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Oshrey Avraham
 * ID: 316188531
 */
public class Program {
    public static ArrayList<VehicleType> vehicleTypes = new ArrayList<VehicleType>();

    public static void main(String[] args) {
        //testPoint();
        //testJunction();
        //testroute();
        //setVehicleTypes();
        //testTypes();
        //TestDrivingMapVehicle();
        Driving driving=new Driving(10, 40, 8);
        driving.startDrive(8);
    }

    private static void testPoint() {
        Point A = new Point(2, 5.5);
        Point B = new Point(0, 0);
        Point C = new Point(1000000, 800);
        Point D = new Point(-1, 5);
        Point E = new Point(5, -1);
        Point F = new Point(1000000.01, 5);
        Point G = new Point(5, 803);
        Point H = new Point(A.getX(), C.getY());
        H.setX(42);
        H.setY(42);
        H.setX(100000000);
        H.setX(-0.5);
        H.setY(-100);
        H.setY(1000000);
        System.out.println("H: " + H.toString());
        G.setX(H.getX());
        G.setY(H.getY());
        System.out.println("H equals H: " + H.equals(G));
        System.out.println("H equals F: " + H.equals(F));
    }

    private static void testJunction() {
        Junction arr[] = new Junction[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Junction(new String("" + i), new Point(-1, -1));
        }
        Road arrR[] = new Road[30];
        for (int i = 0; i < arrR.length; i++) {

            int j = new Random().nextInt(arr.length);
            int k = new Random().nextInt(arr.length);
            if (!arr[j].equals(arr[k])) {
                arrR[i] = new Road(arr[j], arr[k], VehicleType.getRandomVehicleTypes(), false, true);
                System.out.println(arrR[i].toString() + " has been created");
            } else i--;
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i].toString() + ": EXITING ROADS:");
            for (int j = 0; j < arr[i].getExitingRoads().size(); j++) {
                System.out.println(arr[i].getExitingRoads().get(j).toString());
            }
            System.out.println(arr[i].toString() + ": ENTERING ROADS:");
            for (int j = 0; j < arr[i].getEnteringRoads().size(); j++) {
                System.out.println(arr[i].getEnteringRoads().get(j).toString());
            }
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i].toString() + " LIGHTS CHECK");
            arr[i].setLightsOn();
            for (int j = 0; j < 5; j++) {
                arr[i].changeLight();
            }
        }

        for (int i = 0; i < arrR.length; i++) {
            System.out.println(arrR[i].toString() + ": " + arrR[i].getAllowedVehicles() + " lenth: " + arrR[i].getLength() + " Max Speed: " + arrR[i].getMaxSpeed());
        }
    }

    private static void testroute() {
        Map map=new Map(5);
        Route route = new Route(map.getJunctions().get(0),VehicleType.getRandomVehicleTypes().get(0));
        System.out.println(route.getJunctions());
        route.printRoute();
        System.out.println("Start: "+route.getStart()+", End: "+route.getEnd());
    }

    private static void setVehicleTypes() {

        vehicleTypes.add(new VehicleType("car", 90));
        vehicleTypes.add(new VehicleType("bus", 60));
        vehicleTypes.add(new VehicleType("bicycle", 40));
        vehicleTypes.add(new VehicleType("motorcycle", 120));
        vehicleTypes.add(new VehicleType("truck", 80));
        vehicleTypes.add(new VehicleType("tram", 50));
        vehicleTypes.add(new VehicleType("semitrailer", 80));
    }

    private static void TestDrivingMapVehicle(){
        Map map=new Map(5);
        map.addJunction(new Junction("Test", new Point(5,10)));
        System.out.println(map.getJunctions());
        map.removeJunction(map.getJunctions().get(5));
        System.out.println(map.getJunctions());
        Driving d=new Driving(5,4,20);
        System.out.println(d.getCurrentVehicles());
        d.addVehicles();
        System.out.println(d.getVehicles());
        System.out.println();

        for(int i=0;i<d.getVehicles().size();i++) {
            d.getVehicles().get(i).move();
        }
    }
}