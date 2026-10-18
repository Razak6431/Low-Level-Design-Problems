package SpotManagers;

import Entity.ParkingSpot;
import LookUpStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{

    protected TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}
