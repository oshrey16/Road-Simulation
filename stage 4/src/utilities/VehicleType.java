/**
 * 
 */
package utilities;


/**
 * @author krsof
 *
 */
public enum VehicleType {
	car(90), bus(60), bicycle(40), motorcycle(120), truck(80), tram(50), semitrailer(85);
	//car(9), bus(6), bicycle(4), motorcycle(12), truck(8), tram(5), semitrailer(8);
	
	
	private int averageSpeed;
	
	
	VehicleType(int speed) {
		averageSpeed=speed; 
		
	}
	public int getAverageSpeed() {
		return averageSpeed;
	}

	public static VehicleType[] allowTypes(String x){
		if(x=="city"){
			VehicleType [] temp = {VehicleType.car,VehicleType.bus,VehicleType.bicycle,VehicleType.motorcycle,VehicleType.tram};
			return temp;
		}
		else{
			VehicleType [] temp = {VehicleType.car,VehicleType.bus,VehicleType.semitrailer,VehicleType.motorcycle,VehicleType.truck};
			return temp;
		}
	}
}
