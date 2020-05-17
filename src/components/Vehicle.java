package components;

import utilities.Utilities;
import utilities.Timer;
import utilities.VehicleType;

public class Vehicle implements Timer, Utilities {

    private static int objectsCount;
    private int id;
    private VehicleType vehicleType;
    private int timeFromRouteStart;
    private int timeOnCurrentPart;
    private Route currentRoute;
    private RouteParts currentRouteParts;
    private Road lastRoad;
    private String status;


    public Vehicle(Road road) {
        objectsCount++;
        this.id = objectsCount;
        this.vehicleType = VehicleType.values()[getRandomInt(0, VehicleType.values().length)];
        this.timeFromRouteStart = 0;
        this.timeOnCurrentPart = 0;

        this.lastRoad = road;
        this.status = null;

    }

    public void move() {
        //TODO - need to figure out
    }

    public void incrementDrivingTime() {
        //TODO - need to figure out
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
    }

    public void setCurrentRoute(Route route) {
        this.currentRoute = route;
    }

    public Route getCurrentRoute() {
        return this.currentRoute;
    }

    public void setCurrentRouteParts(RouteParts routeParts) {
        this.currentRouteParts = currentRoute;
    }

    public RouteParts getCurrentRouteParts() {
        return this.currentRouteParts;
    }

    public int getTimeOnCurrentPart() {
        return timeOnCurrentPart;
    }

    public void setTimeOnCurrentPart(int timeOnCurrentPart) {
        this.timeOnCurrentPart = timeOnCurrentPart;
    }

    public int getTimeFromRouteStart() {
        return timeFromRouteStart;
    }

    public void setTimeFromRouteStart(int timeFromRouteStart) {
        this.timeFromRouteStart = timeFromRouteStart;
    }

    public Road getLastRoad() {
        return lastRoad;
    }

    public void setLastRoad(Road lastRoad) {
        this.lastRoad = lastRoad;
    }

    public String getStatus() {
        // TODO - check what the status should be, and update the checkIn method for Road, Junction
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
