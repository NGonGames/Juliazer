/**
 * @date Apr 22, 2013
 * @author Ben Cochrane
 */
package cc.ngon.julia;

import java.awt.Color;

/**
 *
 */
public class Gradient {

    /**
     *
     */
    public Gradient() {
        Color[] c = { Color.black, Color.white };
        mColors = new float[2][3];
        for (int i = 0; i < 2; ++i) {
            mColors[i] = Color.RGBtoHSB(c[i].getRed(), c[i].getBlue(), c[i].getGreen(), mColors[i]);
        }
    }
    
    /**
     *
     * @param c
     */
    public Gradient(Color[] c) {
        mColors = new float[c.length][3];
        for (int i = 0; i < c.length; ++i) {
            mColors[i] = Color.RGBtoHSB(c[i].getRed(), c[i].getBlue(), c[i].getGreen(), mColors[i]);
        }
    }
    
    /**
     *
     * @param fl
     * @return
     */
    public final float[] getColor(float fl) {
        if (mColors.length < 2)  {
            return mColors[0];
        } else {
            float f = fl - (float)Math.floor(fl);
            int n = mColors.length;
            int fx0 = (int)Math.floor((float)n * f);
            int fx1 = (int)Math.ceil((float)n * f);
            float[] c1 = mColors[fx0], c2 = mColors[fx1];
            float w0 = (f - fx0) * n;
            float[] c = new float[3];
            c[0] = lerp(c1[0], c2[0], w0);
            c[1] = lerp(c1[1], c2[1], w0);
            c[2] = lerp(c1[2], c2[2], w0);
            return c;
        }
    }
    
    private float lerp(float from, float to, float by) {
        return from + (to - from) * by;
    }
    
    private float[][] mColors;
}
