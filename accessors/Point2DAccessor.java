package accessors;

import pojos.Point2D;

public class Point2DAccessor implements Accessor<Point2D> {

    public double value(Point2D a) {
        return a.getX();
    }

    public Point2D obj(double a) {
        return new Point2D(a, a);
    }
}