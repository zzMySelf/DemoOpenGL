package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.LogUtil;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;

public class ImageProcessor {
    public static final String a = "ImageProcessor";
    public static final int b = -1;
    public final int c;

    public ImageProcessor(Context context) {
        this.c = ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        String str = a;
        LogUtil.d(str, "initialSize = " + b2);
        if (b2 > 8) {
            return ((b2 + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < b2) {
            i4 <<= 1;
        }
        return i4;
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
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

    public Bitmap decode(File file, int i2) throws FileNotFoundException {
        if (file != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                if (!options.mCancel && options.outWidth != -1) {
                    if (options.outHeight != -1) {
                        options.inSampleSize = a(options, -1, this.c);
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

    public Bitmap a(FileDescriptor fileDescriptor, int i2) throws FileNotFoundException {
        if (fileDescriptor != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
                if (!options.mCancel && options.outWidth != -1) {
                    if (options.outHeight != -1) {
                        options.inSampleSize = a(options, -1, this.c);
                        options.inJustDecodeBounds = false;
                        options.inDensity = i2;
                        options.inDither = false;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
            return null;
        }
        throw new FileNotFoundException("The file is null");
    }
}
