/**
 * @date Apr 17, 2013
 * @author Ben Cochrane
 */
package cc.ngon.julia;

/**
 * The View class provides an abstraction from the viewport of the Julia fractal
 * rendering process. Additionally the View class provides utility methods for 
 * display/viewport conversions. This class can be thought of as a basic 2D Camera.
 */
public class ImageView {

    /**
     * Initializes the View object semi-automatically.
     * The viewport is default initialized to (-1, 1, -> 1, 1)
     * @param width Width of the Display the view represents.
     * @param height Height of the Display the view represents.
     */
    public ImageView(int width, int height) {
        this(width, height, -1, 1, -1, 1);
    }
    
    /**
     * Fully initializes the View object manually.
     * @param width Width of the Display the view represents.
     * @param height Height of the Display the view represents.
     * @param xstart The X-Position on the Cartesian plane bound to the left of the display.
     * @param xend The X-Position on the Cartesian plane bound to the right of the display.
     * @param ystart The Y-Position on the Cartesian plane bound to the top of the display.
     * @param yend The Y-Position on the Cartesian plane bound to the bottom of the display.
     */
    public ImageView(int width, int height, double xstart, double xend, double ystart, double yend) {
        this.width = width;
        this.height = height;
        this.xStart = xstart;
        this.xEnd = xend;
        this.yStart = ystart;
        this.yEnd = yend;
        
        this.mImage = new float[3 * width * height];
    }
    
    /**
     * Resizes the display window.
     * @param width New Width of the display being represented.
     * @param height New Height of the display being represented.
     * @return Returns this
     */
    public ImageView resizeDisplay(int width, int height) {
        this.width = width;
        this.height = height;
        this.mImage = new float[3 * width * height];
        return this;
    }
    
    /**
     * Resizes the viewport.
     * @param xstart The X-Position on the Cartesian plane bound to the left of the display.
     * @param xend The X-Position on the Cartesian plane bound to the right of the display.
     * @param ystart The Y-Position on the Cartesian plane bound to the top of the display.
     * @param yend The Y-Position on the Cartesian plane bound to the bottom of the display.
     * @return Returns this
     */
    public ImageView resizeViewport(double xstart, double xend, double ystart, double yend) {
        this.xStart = xstart;
        this.xEnd = xend;
        this.yStart = ystart;
        this.yEnd = yend;
        return this;
    }
    
    /**
     * Resizes both the display size and viewport representation simultaneously.
     * @param width Width of the Display the view represents.
     * @param height Height of the Display the view represents.
     * @param xstart The X-Position on the Cartesian plane bound to the left of the display.
     * @param xend The X-Position on the Cartesian plane bound to the right of the display.
     * @param ystart The Y-Position on the Cartesian plane bound to the top of the display.
     * @param yend The Y-Position on the Cartesian plane bound to the bottom of the display.
     * @return 
     */
    public ImageView resize(int width, int height, double xstart, double xend, double ystart, double yend) {
        return resizeDisplay(width, height).resizeViewport(xstart, xend, ystart, yend);
    }
    
    /**
     * Converts a display coordinate to a viewport coordinate.
     * @param c The display coordinate to be converted.
     * @return Complex containing the X/Y of the viewport coordinate corresponding
     *  to coord.
     */
    public Complex convertDisplayToViewport(Complex c) {
        return new Complex(xStart + (c.a / width) * (xEnd - xStart),
                yStart + (c.b / height) * (yEnd - yStart));
    }
    
    /**
     * Converts a viewport coordinate to a display coordinate.
     * @param c The viewport coordinate to be converted.
     * @return Complex containing the X/Y of the display coordinate corresponding
     *  to coord.
     */
    public Complex convertViewportToDisplay(Complex c) {
        return new Complex(((c.a - xStart) / (xEnd - xStart)) * width,
                ((c.b - yStart) / (yEnd - yStart)) * height);
    }
    
    /**
     * Sets a pixel value in the image array based on the current gradient.
     * @param c The x/y coordinate pair in display coordinates.
     * @param iterations The number of iterations currently used.
     */
    public void setPointIteration(Complex c, int iterations) {
        int n = (int)(c.a + width * c.b);
        float r = mImage[n];
    }
    
    /**
     * The X-Position on the Cartesian plane bound to the left of the display.
     */ protected double xStart;
    /**
     * The X-Position on the Cartesian plane bound to the right of the display.
     */ protected double xEnd;
    /**
     * The Y-Position on the Cartesian plane bound to the top of the display.
     */ protected double yStart;
    /**
     * The Y-Position on the Cartesian plane bound to the bottom of the display.
     */ protected double yEnd;
    
    /**
     * The cached width of the display.
     */ protected double width;
    /**
     * The cached height of the display.
     */ protected double height;
    
    /**
     * An RGB format array to represent the screen image.
     */ protected float[] mImage;
    
}
