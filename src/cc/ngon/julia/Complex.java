/**
 * @date Apr 17, 2013
 * @author Ben Cochrane
 */
package cc.ngon.julia;

/**
 * Provides a simple interface for a 2-Dimensional X/Y Complex
 */
public class Complex {
    
    /**
     * Default Constructor for the Complex class, initializes X and Y to zero.
     */
    public Complex() {
        this.a = 0;
        this.b = 0;
    }
    
    /**
     * Constructs Complex by simply setting fields.
     * @param a The X-Coordinate of the Complex object.
     * @param b The Y-Coordinate of the Complex object.
     */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    /**
     * Copy constructor for the Complex class.
     * @param p The Complex object to be copied.
     */
    public Complex(Complex p) {
        this.a = p.a;
        this.b = p.b;
    }
    
    /**
     * Adds two complex numbers.
     * @param p The point to be added to this.
     * @return Returns the sum of this and p.
     */
    public Complex sum(Complex p) {
        return new Complex(p.a + a, p.b + b);
    }
    
    /**
     * Multiplies two complex numbers.
     * @param p The point to be multiplied by this.
     * @return Returns the product of this and p.
     */
    public Complex product(Complex p) {
        return new Complex(a * p.a - b * p.b, b * p.a + a * p.b);
    }
    
    /**
     * Calculates the length of the point from the origin in the complex plane.
     * @return Returns sqrt(a*a + b*b)
     */
    public double magnitude() {
        return Math.sqrt(a * a + b * b);
    }
    
    /**
     * The X-Coordinate of the Complex object.
     */ public double a;
    /**
     * The Y-Coordinate of the Complex object.
     */ public double b;
}