package ParkingLot;
import Entity.Vehicle;
import ParkingLot.ParkingBuilding;
import ParkingLot.EntranceGate;
public class ParkingLot {

    private final ParkingBuilding building;
    private final EntranceGate entranceGate;


    public ParkingLot(ParkingBuilding building, EntranceGate entranceGate) {
        this.building = building;
        this.entranceGate = entranceGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entranceGate.enter(building,vehicle);
    }






}
