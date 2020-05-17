package components;

import utilities.Timer;
import utilities.Utilities;

import java.util.ArrayList;

public abstract class TrafficLights implements Timer, Utilities {
    private ArrayList<Road> roads;
    private boolean trafficLightsOn;
    private int workingTime;
    private static int objectsCount;
    private int id;
    private int delay;
    private final int minDelay = 2;
    private final int maxDelay = 6;
    private int greenLightIndex;

    public TrafficLights(ArrayList<Road> roads) {
        objectsCount++;
        this.id = objectsCount;
        this.roads = new ArrayList<>(roads);
        this.delay = 0;
        this.trafficLightsOn = false;
        this.workingTime = 0;
    }

    public abstract void changeIndex();

    public void changeLights() {
        for (int i = 0; i < this.roads.size(); i++) {
            this.roads.get(i).setGreenLight(i == this.greenLightIndex);
        }
    }

    public void incrementDrivingTime() {
        this.workingTime++;
    }

    public int getMaxDelay() {
        return maxDelay;
    }

    public int getMinDelay() {
        return minDelay;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public boolean isTrafficLightsOn() {
        return trafficLightsOn;
    }

    public void setTrafficLightsOn(boolean trafficLightsOn) {
        this.trafficLightsOn = trafficLightsOn;
    }

    /**
     *
     * @return
     */
    public ArrayList<Road> getRoads() {
        return roads;
    }

    /**
     *
     * @param roads
     */
    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public int getGreenLightIndex() {
        return greenLightIndex;
    }

    public void setGreenLightIndex(int greenLightIndex) {
        this.greenLightIndex = greenLightIndex;
    }

    public String toString() {
        //TODO
        return "";
    }

    public boolean equals(TrafficLights other) {
        // TODO - what to compare? maybe objectsCount
        return false;
    }

}
