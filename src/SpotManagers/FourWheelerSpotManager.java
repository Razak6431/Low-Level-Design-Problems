package SpotManagers;

import Entity.ParkingSpot;
import LookUpStrategy.ParkingSpotLookupStrategy;
import Pricing.PricingStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot>spots, ParkingSpotLookupStrategy strategy){
        super(spots,strategy);

    }

}
