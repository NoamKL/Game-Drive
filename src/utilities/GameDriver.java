package utilities;

import components.Driving;

public class GameDriver {
    public static void main(String[] args) {
        Driving driving=new Driving(10, 20);
        driving.drive(20);
    }
}
