package components;

import utilities.Utilities;
import utilities.Timer;

import java.util.ArrayList;

public class Driving implements Utilities, Timer {

    private Map map;
    private ArrayList<Vehicle> vehicles;
    private int drivingTime;
    private ArrayList<Timer> allTimedElements;

    public Driving(int numOfJunctions, int numOfVehicles) {
        // TODO - need completion, I didnt fully understand how the flow should be
        this.map = new Map(numOfJunctions);
        this.drivingTime = 0;
    }

    public void drive(int numOfTurns) {
        for (int i = 0; i < numOfTurns; i++) {
            this.incrementDrivingTime();
        }
    }

    public void incrementDrivingTime() {}

    public int getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Timer> getAllTimedElements() {
        return allTimedElements;
    }

    public void setAllTimedElements(ArrayList<Timer> allTimedElements) {
        this.allTimedElements = allTimedElements;
    }
}
