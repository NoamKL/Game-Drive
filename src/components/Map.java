package components;

import utilities.Utilities;
import java.util.ArrayList;

public class Map implements Utilities {
    private ArrayList<Junction> junctions = new ArrayList<Junction>();
    private ArrayList<Road> roads = new ArrayList<Road>();
    private ArrayList<TrafficLights> lights = new ArrayList<TrafficLights>();

    public Map(int numOfJunctions) {
        this.setAllJunctions(numOfJunctions);
        this.setAllRoads();
    }

    private void setAllJunctions(int numOfJunctions) {
        // Creating junctions or lighted junctions, randomly
        for (int i = 0; i < numOfJunctions; i++) {
            this.junctions.add(
                    (this.getRandomBoolean()) ? new Junction() : new LightedJunction()
            );
        }

    }

    public void setAllRoads() {
        // Creating road between each junction and every other junction
        for (Junction junction : this.junctions) {
            for (Junction junctionOther : this.junctions) {
                if (!junction.equals(junctionOther)) {
                    Road newRoad = new Road(junction, junctionOther);
                    newRoad.setGreenLight(this.getRandomBoolean());
                    junction.addExitingRoad(newRoad);
                    junctionOther.addEnteringRoad(newRoad);
                }
            }
        }
    }

    public void turnLightsOn() {}

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public ArrayList<TrafficLights> getLights() {
        return lights;
    }

    public void setLights(ArrayList<TrafficLights> lights) {
        this.lights = lights;
    }

    public ArrayList<Junction> getJunctions() {
        return this.junctions;
    }

    public void setJunctions(ArrayList<Junction> junctions) {
        this.junctions = junctions;
    }
}
