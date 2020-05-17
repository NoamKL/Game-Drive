package components;

import java.util.ArrayList;

public class Route implements RouteParts {
    private ArrayList<RouteParts> routeParts;
    private Vehicle vehicle;

    public Route(RouteParts start, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.routeParts = new ArrayList<RouteParts>();

        RouteParts currentRoutePart = start;
        while (this.routeParts.size() <= 10 && currentRoutePart != null) {
            this.routeParts.add(currentRoutePart.findNextPart(vehicle));
            currentRoutePart = currentRoutePart.findNextPart(vehicle);
        }
        this.checkIn(vehicle);
    }

    /**
     *
     * @param obj
     * @return
     */
    public double calcEstimatedTime(Object obj) {
        double totalEstimatedTime = 0;
        for (RouteParts routePart : this.routeParts) {
            totalEstimatedTime += routePart.calcEstimatedTime(this.vehicle);
        }
        return totalEstimatedTime;
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean canLeave(Vehicle vehicle) {
        return vehicle.getCurrentRouteParts() == this.routeParts.get(this.routeParts.size() - 1);
    }

    public void checkIn(Vehicle vehicle) {
        vehicle.setCurrentRoute(this);
        vehicle.setCurrentRouteParts(this.routeParts.get(0));
        vehicle.setTimeOnCurrentPart(0);
        vehicle.setTimeFromRouteStart(0);

        double totalLength = 0;
        for (RouteParts routeParts : this.routeParts) {
            totalLength += (routeParts instanceof Road) ? ((Road) routeParts).calcLength() : 0;
        }

        System.out.printf(
                " - is starting a new Route from %s, length : %s, max speed %s to %s, " +
                        "estimated time for route: %s",
                this.routeParts.get(0), totalLength, ((Road) this.routeParts.get(0)).getMaxSpeed(),
                vehicle.getLastRoad(), this.calcEstimatedTime(vehicle)
        );
    }

    public void checkOut(Vehicle vehicle) {
        //TODO - what happens when current route is finished?
    }

    public RouteParts findNextPart(Vehicle vehicle) {
        //TODO - calculate a new route after finished the current one?
        return null;
    }

    public void stayOnCurrentPart(Vehicle vehicle) {
        //TODO
    }

}
