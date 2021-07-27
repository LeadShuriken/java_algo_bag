package pojo;

public class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static int isCounterClockWise(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1; // clockwise
        else if (area2 > 0)
            return +1; // counter-clockwise
        else
            return 0; // collinear
    }

    public int compareTo(Point2D o) {
        if (o.x > this.x || o.y > this.y)
            return -1;
        if (o.x < this.x || o.y < this.y)
            return 1;
        return 0;
    }
}