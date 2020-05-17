package components;

import utilities.Utilities;

public interface RouteParts extends Utilities {

    public double calcEstimatedTime(Object obj);

    public boolean canLeave(Vehicle vehicle);

    public void checkIn(Vehicle vehicle);

    public void checkOut(Vehicle vehicle);

    public RouteParts findNextPart(Vehicle vehicle);

    public void stayOnCurrentPart(Vehicle vehicle);

}
