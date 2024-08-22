package com.dxmpay.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.dxmpay.apollon.utils.DisplayUtils;
import java.io.File;
import java.io.FileNotFoundException;

public class ImageProcessor {
    public final int qw;

    public ImageProcessor(Context context) {
        this.qw = ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2;
    }

    public static int ad(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i3 == -1) {
            i4 = 1;
        } else {
            i4 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i3)));
        }
        if (i2 == -1) {
            i5 = 128;
        } else {
            double d3 = (double) i2;
            i5 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i5 < i4) {
            return i4;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? i4 : i5;
    }

    public static int qw(BitmapFactory.Options options, int i2, int i3) {
        int ad2 = ad(options, i2, i3);
        if (ad2 > 8) {
            return ((ad2 + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < ad2) {
            i4 <<= 1;
        }
        return i4;
    }

    public Bitmap decode(File file, int i2) throws FileNotFoundException {
        if (file != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                if (!options.mCancel && options.outWidth != -1) {
                    if (options.outHeight != -1) {
                        options.inSampleSize = qw(options, -1, this.qw);
                        options.inJustDecodeBounds = false;
                        options.inDensity = i2;
                        options.inDither = false;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeFile(file.getPath(), options);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
            return null;
        }
        throw new FileNotFoundException("The file is null");
    }
}
