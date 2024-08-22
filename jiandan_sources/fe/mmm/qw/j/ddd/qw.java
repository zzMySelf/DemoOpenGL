package fe.mmm.qw.j.ddd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.File;
import java.io.IOException;

public class qw {
    public static Uri ad(Context context, String str) {
        int qw = qw(str);
        if (qw == 0) {
            return Uri.fromFile(new File(str));
        }
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), fe(BitmapFactory.decodeFile(str), qw), (String) null, (String) null));
    }

    public static int de(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            fe.mmm.qw.i.qw.de("BitmapUtil", e.getMessage(), e);
            return 0;
        }
    }

    public static Bitmap fe(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static int qw(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            fe.mmm.qw.i.qw.de("BitmapUtil", e.getMessage(), e);
            return 0;
        }
    }
}
