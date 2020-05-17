package components;


import java.util.ArrayList;

public class RandomTrafficLights extends TrafficLights {

    public RandomTrafficLights(ArrayList<Road> roads) {
        super(roads);
        this.changeIndex();
        this.getRoads().get(this.getGreenLightIndex()).setGreenLight(true);

    }

    public void changeIndex() {
        this.setGreenLightIndex(this.getRandomInt(0, this.getRoads().size()));
    }
}
