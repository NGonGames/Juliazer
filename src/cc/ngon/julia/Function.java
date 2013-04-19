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
    public int eval(double initial, double constant) {
        iterationCount = 0;
        evalImpl(initial, constant);
        return -1;
    }
    
    /**
     * Implementation of the Function evaluation.
     */
    private void evalImpl(double z, double constant) {
        ++iterationCount;
        double zn = Math.pow(z, mPower) + constant;
        if (zn < 2 && iterationCount < mThreshold) {
            evalImpl(zn, constant);
        }
    }

    /**
     * Which power to raise z to in the function (z^x + c -> z)
     */ protected double mPower;
    /**
     * The number of times to evaluate the function (z^x + c -> z)
     */ protected double mThreshold;
     
    /**
      * A field for tracking the number of iterations while evaluating function.
      */ private int iterationCount;

}
