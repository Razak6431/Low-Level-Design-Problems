package ParkingLot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import Pricing.CostComputation;

import javax.security.auth.kerberos.KerberosTicket;
import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel>levels;

    public ParkingBuilding(List<ParkingLevel>levels,
                           CostComputation computation){
        this.levels=levels;
    }

    Ticket allocate(Vehicle vehicle){
        for(ParkingLevel level:levels){
          if(level.hasAvailability(vehicle.getVehicleType())){
              ParkingSpot spot=level.park(vehicle.getVehicleType());
              if(spot != null){
                  Ticket ticket=new Ticket(vehicle,level,spot);
                  System.out.println("Parking allocated at level: "
                  + level.getLevelNumber()
                          +" spot: "+spot.getSpotId()
                  );
                  return ticket;
              }
          }

        }
        throw new RuntimeException("Parking Full...");
    }

    public void release(Ticket ticket){
        ticket.getLevel().unPark(
                ticket.getVehicle().getVehicleType(), ticket.getSpot()
        );
    }

}
