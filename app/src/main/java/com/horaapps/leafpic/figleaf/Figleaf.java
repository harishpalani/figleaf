package com.horaapps.leafpic.figleaf;

import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;

import com.drew.metadata.jpeg.JpegComponent;
import com.horaapps.leafpic.Base.Media;

import java.io.ByteArrayOutputStream;

import uk.co.senab.photoview.PhotoView;

/**
 * @author Harish Palani
 * @version 6/21/2016
 */
public class Figleaf {

    // Mechanism constants
    public static final int ENCRYPT = 0;
    public static final int DECRYPT = 1;

    private static final float[] NEG_ARRAY = {
            -1.0f, 0, 0, 0, 255, // red
            0, -1.0f, 0, 0, 255, // green
            0, 0, -1.0f, 0, 255, // blue
            0, 0, 0, 1.0f, 0  // alpha
    };

    public static final ColorMatrixColorFilter NEGATIVE = new ColorMatrixColorFilter(NEG_ARRAY); // HP: invert negative images — this simulates DECRYPTION // insert decryption mechanism here

    public static byte[] convertToByteArray(Media media) {
        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();

        photoView.setDrawingCacheEnabled(true);
        photoView.buildDrawingCache();
        Bitmap bitmap = photoView.getDrawingCache();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
        return stream.toByteArray();*/

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        media.getBitmap().compress(Bitmap.CompressFormat.JPEG, 90, stream);
        return stream.toByteArray();
    }

}
