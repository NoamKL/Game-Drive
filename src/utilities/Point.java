package utilities;


public abstract class Point implements Utilities {

    private final int minVal = 0, maxX = 800, maxY = 600;
    private double x, y;

    public Point(double x, double y) {
        if (this.checkValue(x, minVal, maxX) && this.checkValue(y, minVal, maxY)) {
            this.x = x;
            this.y = y;
        } else {
            this.x = getRandomDouble(minVal, maxX);
            this.y = getRandomDouble(minVal, maxY);
        }
    }

    public Point() {
        this.x = getRandomDouble(minVal, maxX);
        this.y = getRandomDouble(minVal, maxY);
    }

    public double calcDistance(Point other) {
        return Math.sqrt(
            Math.pow(this.x - other.getX(), 2) +
            Math.pow(this.y - other.getY(), 2)
        );
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

/*
    public int getMinVal() {
        return this.minVal;
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }
*/
}
