package com.baidu.searchbox.qrcode.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import com.baidu.searchbox.qrcode.utils.StorageUtils;
import com.baidu.searchbox.qrcode.utils.Utility;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ImageUtils {
    private static final boolean DEBUG = false;
    private static final int QUALITY = 100;
    private static final String TAG = "ImageUtils";

    private ImageUtils() {
    }

    public static Bitmap decodeBitmapFromUri(Context context, Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        Bitmap bitmap = null;
        InputStream input = null;
        try {
            input = context.getContentResolver().openInputStream(new UriImage(context, uri).getUri());
            if (input != null) {
                bitmap = BitmapFactory.decodeStream(input, (Rect) null, new BitmapFactory.Options());
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Utility.closeSafely((Closeable) null);
            throw th2;
        }
        Utility.closeSafely((Closeable) input);
        return bitmap;
    }

    public static Bitmap decodeBitmapFromUri(Context context, Uri uri, int minSideLength, int maxNumOfPixels) {
        if (context == null || uri == null) {
            return null;
        }
        Bitmap bitmap = null;
        InputStream input = null;
        try {
            UriImage uriImage = new UriImage(context, uri);
            InputStream input2 = context.getContentResolver().openInputStream(uriImage.getUri());
            int inSampleSize = getAppropriateSampleSize(input2, minSideLength, maxNumOfPixels);
            Utility.closeSafely((Closeable) input2);
            input = context.getContentResolver().openInputStream(uriImage.getUri());
            if (input != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = inSampleSize;
                bitmap = BitmapFactory.decodeStream(input, (Rect) null, options);
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Utility.closeSafely((Closeable) null);
            throw th2;
        }
        Utility.closeSafely((Closeable) input);
        return bitmap;
    }

    public static Bitmap loadBitmapFromSDCard(String strPath) {
        try {
            FileInputStream fis = new FileInputStream(new File(strPath));
            Bitmap bmp = BitmapFactory.decodeStream(fis, (Rect) null, new BitmapFactory.Options());
            fis.close();
            return bmp;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Bitmap loadBitmapFromSDCard(String strPath, int minSideLength, int maxNumOfPixels) {
        File file = new File(strPath);
        try {
            FileInputStream fis = new FileInputStream(file);
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = getAppropriateSampleSize(fis, minSideLength, maxNumOfPixels);
            fis.close();
            FileInputStream fis2 = new FileInputStream(file);
            Bitmap bmp = BitmapFactory.decodeStream(fis2, (Rect) null, opts);
            fis2.close();
            return bmp;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);
        if (initialSize > 8) {
            return 8 * ((initialSize + 7) / 8);
        }
        int roundedSize = 1;
        while (roundedSize < initialSize) {
            roundedSize <<= 1;
        }
        return roundedSize;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        double w = (double) options.outWidth;
        double h2 = (double) options.outHeight;
        int lowerBound = maxNumOfPixels == -1 ? 1 : (int) Math.ceil(Math.sqrt((w * h2) / ((double) maxNumOfPixels)));
        int upperBound = minSideLength == -1 ? 128 : (int) Math.min(Math.floor(w / ((double) minSideLength)), Math.floor(h2 / ((double) minSideLength)));
        if (upperBound < lowerBound) {
            return lowerBound;
        }
        if (maxNumOfPixels == -1 && minSideLength == -1) {
            return 1;
        }
        if (minSideLength == -1) {
            return lowerBound;
        }
        return upperBound;
    }

    public static int getAppropriateSampleSize(InputStream is, int minSideLength, int maxNumOfPixels) {
        if (is == null) {
            return 1;
        }
        try {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, (Rect) null, opts);
            if (opts.outHeight <= 0 || opts.outWidth <= 0) {
                return 1;
            }
            return computeSampleSize(opts, minSideLength, maxNumOfPixels);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return 1;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 1;
        }
    }

    public static boolean saveBitmap(Bitmap bitmap) {
        if (!StorageUtils.isExternalStorageWriteable()) {
            return false;
        }
        try {
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "barcode_cache");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(dir, Utility.createFileName("jpg"))));
        } catch (FileNotFoundException e2) {
            return false;
        }
    }

    public static Uri saveBitmap(Bitmap bitmap, String dir, String filename) {
        File file = new File(dir, filename);
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos2)) {
                Uri fromFile = Uri.fromFile(file);
                try {
                    fos2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return fromFile;
            }
            try {
                fos2.close();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            if (fos == null) {
                return null;
            }
            fos.close();
            return null;
        } catch (Throwable th2) {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public static Bitmap duplicateBitmap(Bitmap bmpSrc) {
        if (bmpSrc == null) {
            return null;
        }
        int bmpSrcWidth = bmpSrc.getWidth();
        int bmpSrcHeight = bmpSrc.getHeight();
        if (bmpSrcWidth == 0 || bmpSrcHeight == 0) {
            return null;
        }
        try {
            Bitmap bmpDest = Bitmap.createBitmap(bmpSrcWidth, bmpSrcHeight, Bitmap.Config.ARGB_8888);
            if (bmpDest == null) {
                return bmpDest;
            }
            Canvas canvas = new Canvas(bmpDest);
            Rect rect = new Rect(0, 0, bmpSrcWidth, bmpSrcHeight);
            canvas.drawBitmap(bmpSrc, rect, rect, (Paint) null);
            return bmpDest;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Uri saveImage(byte[] data, String dir, String filename) {
        File file = new File(dir, filename);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            fout.write(data);
            fout.flush();
            try {
                fout.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return Uri.fromFile(file);
        } catch (Exception e3) {
            e3.printStackTrace();
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th2;
        }
    }
}
