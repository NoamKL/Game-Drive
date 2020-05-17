package components;

import java.util.ArrayList;

public class LightedJunction extends Junction {

    private TrafficLights lights;

    /**
     *
     * @param name
     * @param x
     * @param y
     * @param sequential
     * @param lightsOn
     */
    public LightedJunction(String name, double x, double y, boolean sequential, boolean lightsOn) {
        super(name, x, y);
        ArrayList<Road> totalRoads = new ArrayList<>(this.getEnteringRoads());
        totalRoads.addAll(this.getExitingRoads());
        this.lights = (sequential) ?
                new SequentialTrafficLights(totalRoads) :
                new RandomTrafficLights(totalRoads);
        if (lightsOn) {this.lights.changeLights();}
    }

    /**
     *
     */
    public LightedJunction() {
        super();
        ArrayList<Road> totalRoads = new ArrayList<>(this.getEnteringRoads());
        totalRoads.addAll(this.getExitingRoads());
        this.lights = (this.getRandomBoolean()) ?
                new SequentialTrafficLights(totalRoads) :
                new RandomTrafficLights(totalRoads);
        if (this.getRandomBoolean()) {this.lights.changeIndex();}
    }

    /**
     *
     * @param obj
     * @return
     */
    public double calcEstimatedTime(Object obj) {
        return this.lights.getDelay() * (this.getEnteringRoads().size() - 1) + 1;
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean canLeave(Vehicle vehicle) {
        return this.lights.isTrafficLightsOn();
    }

    /**
     *
     * @return
     */
    public String toString() {
        return this.getJunctionName() + "(Lighted)";
    }

    public boolean equals(LightedJunction other) {
        // TODO - how to compare?
        return false;
    }

    /**
     *
     * @return
     */
    public TrafficLights getLights() {
        return this.lights;
    }

    /**
     *
     * @param lights
     */
    public void setLights(TrafficLights lights) {
        this.lights = lights;
    }

}
