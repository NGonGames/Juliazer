/**
 * @date Apr 17, 2013
 * @author Ben Cochrane
 */
package cc.ngon.julia;

public class View {

    /**
     * Initializes the View object semi-automatically.
     * The viewport is default initialized to (-1, 1, -> 1, 1)
     * @param width Width of the Display the view represents.
     * @param height Height of the Display the view represents.
     */
    public View(int width, int height) {
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
    public View(int width, int height, double xstart, double xend, double ystart, double yend) {
        this.width = width;
        this.height = height;
        this.xStart = xstart;
        this.xEnd = xend;
        this.yStart = ystart;
        this.yEnd = yend;
    }
    
    /**
     * Resizes the display window.
     * @param width New Width of the display being represented.
     * @param height New Height of the display being represented.
     * @return Returns this
     */
    public View resizeDisplay(int width, int height) {
        this.width = width;
        this.height = height;
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
    public View resizeViewport(int xstart, int xend, int ystart, int yend) {
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
    public View resize(int width, int height, int xstart, int xend, int ystart, int yend) {
        return resizeDisplay(width, height).resizeViewport(xstart, xend, ystart, yend);
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
    
}
