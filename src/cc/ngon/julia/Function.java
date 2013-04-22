/**
 * @date Apr 18, 2013
 * @author Ben Cochrane
 */

package cc.ngon.julia;

/**
 * Represents the anonymous function (z^x + c -> z)
 */
public class Function {
    
    /**
     * Default constructor, uses, x = 2, and threshold of 16
     */
    public Function() {
        this(16, 2.0);
    }
    
    /**
     * Initializes the threshold for the iterations of the function.
     * @param threshold The number of iterations the function evaluates before assuming
     *  the value is within the set.
     */
    public Function(int threshold) {
        this(threshold, 2.0);
    }
    
    /**
     * Initializes the threshold for the iterations of the function.
     * @param threshold The number of iterations the function evaluates before assuming
     *  the value is within the set.
     * @param power The power z is raised to in the function (z^x + c -> z)
     */
    public Function(int threshold, double power) {
        this.mPower = power;
        this.mThreshold = threshold;
    }
    
    /**
     * Evaluates the number of iterations it takes for z to exceed 2
     * A value of -1 indicates that the threshold for iterations was exceeded.
     * @param initial The initial value of the function (z^x + c -> z)
     * @param constant The constant value of the function (z^x + c -> z)
     * @return Returns the number of iterations required for z to exceed 2
     */
    public int eval(Complex z, Complex c) {
        int i = 0;
        while (i < mThreshold && z.magnitude() < radius) {
            z = z.product(z).sum(c);
            ++i;
        }
        return i == mThreshold ? -1 : i;
    }
    
    /**
     * Get the threshold for iterations before assuming a point is in the set.
     * @return Returns maximum number of iterations.
     */
    public int iterations() {
        return mThreshold;
    }
    
    /**
     * Get the threshold for iterations before assuming a point is in the set.
     * @param iterations The maximum number of iterations.
     */
    public void setIterations(int iterations) {
        mThreshold = iterations;
    }

    /**
     * Which power to raise z to in the function (z^x + c -> z)
     */ protected double mPower;
    /**
     * The number of times to evaluate the function (z^x + c -> z)
     */ protected int mThreshold;
    /**
     * The escape radius of a given point.
     */ private final double radius = 2.0;

}
