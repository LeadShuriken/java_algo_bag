package pojo;

import java.util.Comparator;

import util.Accessor;

public class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    public static final Comparator<Point2D> Y_SORT = (Point2D a, Point2D b) -> {
        if (a.getY() > b.getY())
            return 1;
        else if (a.getY() < b.getY())
            return -1;
        return 0;
    };

    public static final Comparator<Point2D> X_SORT = (Point2D a, Point2D b) -> {
        if (a.getX() > b.getX())
            return 1;
        else if (a.getX() < b.getX())
            return -1;
        return 0;
    };

    public static final Accessor<Point2D, Double> X_ACCESSOR = new Accessor<>() {
        public int compare(Point2D a, Point2D b) {
            return Point2D.X_SORT.compare(a, b);
        };

        public Double apply(Point2D t) {
            return t.getX();
        }

        public Point2D create(Double a) {
            return new Point2D(a, 0);
        }
    };

    public static final Accessor<Point2D, Double> Y_ACCESSOR = new Accessor<>() {
        public int compare(Point2D a, Point2D b) {
            return Point2D.Y_SORT.compare(a, b);
        };

        public Double apply(Point2D t) {
            return t.getY();
        }

        public Point2D create(Double a) {
            return new Point2D(0, a);
        }
    };

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