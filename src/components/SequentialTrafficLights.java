package components;

import java.util.ArrayList;

public class SequentialTrafficLights extends TrafficLights {
    private final int increment = 1;

    public SequentialTrafficLights(ArrayList<Road> roads) {
        super(roads);
        this.changeIndex();
        this.getRoads().get(this.getGreenLightIndex()).setGreenLight(true);
    }

    public void changeIndex() {
        this.setGreenLightIndex(this.getGreenLightIndex() + this.increment);
    }

    public int getIncrement() {
        return this.increment;
    }

    public String toString() {
        return "";
    }

}
