/**
 * @date Apr 17, 2013
 * @author Ben Cochrane
 */
package cc.ngon.julia;

/**
 * Provides a simple interface for a 2-Dimensional X/Y Point
 * @author Ben Cochrane
 */
public class Point {
    
    /**
     * Constructs Point by simply setting fields.
     * @param x The X-Coordinate of the Point object.
     * @param y The Y-Coordinate of the Point object.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Copy constructor for the Point class.
     * @param p The Point object to be copied.
     */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    /**
     * The X-Coordinate of the Point object.
     */ public double x;
    /**
     * The Y-Coordinate of the Point object.
     */ public double y;
}
