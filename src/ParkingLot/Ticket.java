package ParkingLot;

import Entity.ParkingSpot;
import Entity.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    private final Vehicle vehicle;
    private final ParkingLevel level;
    private final ParkingSpot parkingspot;
    private  LocalDateTime entryTime;


    public Ticket(Vehicle vehicle, ParkingLevel level, ParkingSpot parkingspot) {
        this.vehicle = vehicle;
        this.level = level;
        this.parkingspot = parkingspot;
    }


    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingLevel getLevel(){
        return level;
    }

    public ParkingSpot getSpot(){
        return parkingspot;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }
}
