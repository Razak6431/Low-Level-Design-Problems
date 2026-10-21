package ParkingLot;

import Entity.Vehicle;

public class EntranceGate {

    public Ticket enter(ParkingBuilding building, Vehicle vehicle){
        return building.allocate(vehicle);
    }


}
