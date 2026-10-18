package Pricing;

import ParkingLot.Ticket;

public class FixedPricingStrategy implements PricingStrategy {

    public double calculate(Ticket ticket){
        return 100.0;
    }
}
