package fe.mmm.qw.j.ddd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.j.rg;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ad {
    static {
        rg.ad().getPath() + "/BaiduNetdisk/.thumbnails/";
    }

    public static Bitmap ad(Bitmap bitmap, int i2, int i3, int i4, int i5, Matrix matrix, boolean z) {
        try {
            return Bitmap.createBitmap(bitmap, i2, i3, i4, i5, matrix, z);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static String de() {
        return new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(new Date(System.currentTimeMillis()));
    }

    public static Bitmap fe(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (i2 != 0) {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = qw(options, i2, i2);
            }
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return th(BitmapFactory.decodeFile(str, options), (float) rg(str));
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int qw(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 <= i3 && i5 <= i2) {
            return 1;
        }
        if ((i5 <= i4 || i5 >= i4 * 2) && i4 <= i5 * 2) {
            return Math.round(((float) i5) / ((float) i2));
        }
        return Math.round(((float) i4) / ((float) i3));
    }

    public static int rg(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (Exception e) {
            qw.th("ImageUtil", "", e);
            exifInterface = null;
        }
        if (!(exifInterface == null || (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) == -1)) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
    }

    public static Bitmap th(Bitmap bitmap, float f) {
        if (bitmap == null || f == 0.0f) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            return ad(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            qw.th("ImageUtil", e.toString(), e);
            return null;
        }
    }

    public static String uk(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
            fileOutputStream.close();
            return str;
        } catch (Exception e) {
            qw.th("ImageUtil", e.toString(), e);
            return null;
        }
    }

    public static void yj(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
