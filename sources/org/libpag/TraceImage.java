package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + createBitmap.getWidth() + ", height = " + createBitmap.getHeight() + ")");
    }
}
