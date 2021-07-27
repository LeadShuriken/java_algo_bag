package comparator;

import java.util.Comparator;

import pojos.Point2D;

public class Point2DComparator implements Comparator<Point2D> {

    public int compare(Point2D a, Point2D b) {
        if (a.getX() > b.getX())
            return 1;
        else if (a.getX() < b.getX())
            return -1;
        return 0;
    }
}