package components;

import utilities.Utilities;
import utilities.VehicleType;

import java.util.ArrayList;

public class Road implements RouteParts, Utilities {

    private final int[] allowedSpeedOptions = {30, 40, 50, 55, 60, 70, 80, 90};
    private boolean enable;
    private Junction startJunction;
    private Junction endJunction;
    private boolean greenLight;
    private double length;
    private int maxSpeed;
    private VehicleType[] vehicleTypes;
    private ArrayList<Vehicle> waitingVehicles = new ArrayList<Vehicle>();

    public Road(Junction start, Junction end) {
        this.startJunction = start;
        this.endJunction = end;
        this.greenLight = false; //TODO - check what default should it be
        this.enable = true;
        this.length = this.calcLength();
        this.maxSpeed = this.allowedSpeedOptions[
                this.getRandomInt(0, this.allowedSpeedOptions.length)
                ];
    }

    /**
     *
     * @param vehicle
     */
    public void addVehicleToWaitingVehicles(Vehicle vehicle) {
        this.waitingVehicles.add(vehicle);
    }

    /**
     *
     * @param obj
     * @return
     */
    public double calcEstimatedTime(Object obj) {
        return Math.ceil(this.length / Math.min(
            this.maxSpeed, ((Vehicle) obj).getVehicleType().getAverageSpeed()
        ));
    }

    /**
     *
     * @return
     */
    public double calcLength() {
        return this.startJunction.calcDistance(this.endJunction);
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean canLeave(Vehicle vehicle) {
        return vehicle.getTimeOnCurrentPart() >= this.calcEstimatedTime(vehicle) &&
                this.greenLight;
    }

    public void checkIn(Vehicle vehicle) {
        // TODO - anything else?
        this.waitingVehicles.add(vehicle);

    }

    public void checkOut(Vehicle vehicle) {
        // TODO - anything else?
        this.waitingVehicles.remove(vehicle);
    }

    /**
     *
     * @param vehicle
     * @return
     */
    public RouteParts findNextPart(Vehicle vehicle) {
        return this.endJunction;
    }

    /**
     *
     * @param vehicle
     */
    public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
        this.waitingVehicles.remove(vehicle);
    }

    public void stayOnCurrentPart(Vehicle vehicle) {

    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isGreenLight() {
        return greenLight;
    }

    public void setGreenLight(boolean greenLight) {
        this.greenLight = greenLight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public ArrayList<Vehicle> getWaitingVehicles(){
        return this.waitingVehicles;
    }

    public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {
        this.waitingVehicles = waitingVehicles;
    }

    public void setEndJunction(Junction endJunction) {
        this.endJunction = endJunction;
    }

    public Junction getEndJunction() {
        return endJunction;
    }

    public void setStartJunction(Junction startJunction) {
        this.startJunction = startJunction;
    }

    public Junction getStartJunction() {
        return startJunction;
    }


}
