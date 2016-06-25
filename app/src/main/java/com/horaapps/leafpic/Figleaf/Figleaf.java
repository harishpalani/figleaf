package com.horaapps.leafpic.figleaf;

import android.graphics.ColorMatrixColorFilter;

/**
 * @author Harish Palani
 * @version 6/21/2016
 */
public class Figleaf {

    private static final float[] NEG_ARRAY = {
            -1.0f, 0, 0, 0, 255, // red
            0, -1.0f, 0, 0, 255, // green
            0, 0, -1.0f, 0, 255, // blue
            0, 0, 0, 1.0f, 0  // alpha
    };

    public static final ColorMatrixColorFilter NEGATIVE = new ColorMatrixColorFilter(NEG_ARRAY); // HP: invert negative images — this simulates DECRYPTION // insert decryption mechanism here

}
