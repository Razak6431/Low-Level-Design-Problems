package Entity;
import Enum.VehicleType;

public class Vehicle {

    public String vehicleNumber;
    public VehicleType vehicletype;

    public Vehicle(String vehicleno,VehicleType type){
        this.vehicleNumber=vehicleno;
        this.vehicletype=type;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public VehicleType getVehicleType(){
        return vehicletype;
    }

}
