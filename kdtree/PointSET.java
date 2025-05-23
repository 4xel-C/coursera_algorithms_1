import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {

    private SET<Point2D> points;

    // Constructor method: declare a new empty set of points.
    public PointSET() {
        this.points = new SET<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D point) {
        if (point == null)
            throw new IllegalArgumentException("insert() method cannot recieve null argument.");
        points.add(point);
    }

    public boolean contains(Point2D point) {
        if (point == null)
            throw new IllegalArgumentException("contains() method cannot recieve null argument.");
        return points.contains(point);
    }

    public void draw() {
        for (Point2D point : points) {
            point.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {

        if (rect == null)
            throw new IllegalArgumentException("range() method cannot accept null argument.");

        SET<Point2D> pointsInRange = new SET<>();

        for (Point2D point : points) {
            if (rect.contains(point))
                pointsInRange.add(point);
        }

        return pointsInRange;
    }

    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException("nearest() method cannot accept null argument.");

        double minDistance = Double.POSITIVE_INFINITY; // Declare the minDistance being +infinite for comparison.
        Point2D closestPoint = null;

        for (Point2D point : points) {
            if (point == p)
                continue;

            if (p.distanceSquaredTo(point) < minDistance) {
                closestPoint = point;
                minDistance = p.distanceSquaredTo(point);
            }
        }

        return closestPoint;
    }
}
