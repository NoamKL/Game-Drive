package components;

import utilities.Point;

import java.util.ArrayList;
import java.util.Collections;

public class Junction extends Point implements RouteParts {

    private static int objectsCount;
    private ArrayList<Road> enteringRoads;
    private ArrayList<Road> exitingRoads;
    private String junctionName;

    /**
     *
     * @param junctionName
     * @param x
     * @param y
     */
    public Junction(String junctionName, double x, double y) {
        super(x, y);
        objectsCount++;
        this.junctionName = junctionName;
        this.enteringRoads = new ArrayList<Road>();
        this.exitingRoads = new ArrayList<Road>();
        this.successMessage(this.junctionName);
    }

    /**
     *
     */
    public Junction() {
        super();
        objectsCount++;
        this.junctionName = "Junction " + Integer.toString(objectsCount);
        this.enteringRoads = new ArrayList<Road>();
        this.exitingRoads = new ArrayList<Road>();
        this.successMessage(this.junctionName);
    }

    /**
     *
     * @param road
     */
    public void addEnteringRoad(Road road) {
        this.enteringRoads.add(road);
    }

    /**
     *
     * @param road
     */
    public void addExitingRoad(Road road) {
        this.exitingRoads.add(road);
    }

    /**
     *
     * @param obj
     * @return
     */
    public double calcEstimatedTime(Object obj) {
        return Math.min(this.exitingRoads.size(),
                this.enteringRoads.indexOf(((Vehicle) obj).getLastRoad())
        );
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean canLeave(Vehicle vehicle) {
        //TODO - what should be checked here?
        return this.checkAvailability(vehicle);
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean checkAvailability(Vehicle vehicle) {
        return !this.exitingRoads.isEmpty() &&
                vehicle.getLastRoad().getWaitingVehicles().get(0) == vehicle;
    }

    /**
     *
     * @param vehicle
     */
    public void checkIn(Vehicle vehicle) {
        vehicle.setLastRoad((Road)vehicle.getCurrentRouteParts());
        vehicle.setCurrentRouteParts(this);
        vehicle.setTimeOnCurrentPart(0);
        System.out.printf("- has arrived to %s", this.junctionName);

    }

    /**
     *
     * @param vehicle
     */
    public void checkOut(Vehicle vehicle) {
        if (this.canLeave(vehicle)) {
            vehicle.setCurrentRouteParts(this.findNextPart(vehicle));
            vehicle.setTimeOnCurrentPart(0);
            System.out.printf("- has left %s", this.junctionName);
        }
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public RouteParts findNextPart(Vehicle vehicle) {
        Collections.shuffle(this.exitingRoads);
        for ( Road road : this.exitingRoads) {
            if (road.canLeave(vehicle) && road.isEnable())
                    return road;
        }
        return null;
    }

    /**
     *
     * @param vehicle
     */
    public void stayOnCurrentPart(Vehicle vehicle) {
        //TODO - is there anythin else?
        System.out.printf("- is waiting at %s", this.junctionName);

    }

    /**
     *
     * @return
     */
    public String toString() {
        return this.junctionName;
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Junction other) {
        return (objectsCount == other.getObjectsCount());
    }

    /**
     *
     * @return
     */
    public ArrayList<Road> getEnteringRoads() {
        return this.enteringRoads;
    }

    /**
     *
     * @param enteringRoads
     */
    public void setEnteringRoads(ArrayList<Road> enteringRoads) {
        this.enteringRoads = enteringRoads;
    }

    /**
     *
     * @return
     */
    public ArrayList<Road> getExitingRoads() {
        return this.exitingRoads;
    }

    /**
     *
     * @param exitingRoads
     */
    public void setExitingRoads(ArrayList<Road> exitingRoads) {
        this.exitingRoads = exitingRoads;
    }

    /**
     *
     * @param junctionName
     */
    public void setJunctionName(String junctionName) {
        this.junctionName = junctionName;
    }

    /**
     *
     * @return
     */
    public String getJunctionName() {
        return this.junctionName;
    }

    public int getObjectsCount() {
        return objectsCount;
    }

}
