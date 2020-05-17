package utilities;

public enum VehicleType {
    car(90), bus(60), bicycle(40), motorcycle(120),
    truck(80), tram(50), semitrailer(85);

    private int averageSpeed;

    VehicleType(int speed) {
        this.averageSpeed = speed;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}
