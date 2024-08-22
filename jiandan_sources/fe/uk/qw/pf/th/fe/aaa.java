package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class aaa {

    /* renamed from: ad  reason: collision with root package name */
    public static final Paint f5947ad;

    /* renamed from: de  reason: collision with root package name */
    public static final Set<String> f5948de;

    /* renamed from: fe  reason: collision with root package name */
    public static final Lock f5949fe;
    public static final Paint qw = new Paint(6);

    public static final class qw implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        new Paint(7);
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f5948de = hashSet;
        f5949fe = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new qw();
        Paint paint = new Paint(7);
        f5947ad = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Bitmap ad(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        float f;
        float f2;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f2 = ((float) i3) / ((float) bitmap.getHeight());
            f3 = (((float) i2) - (((float) bitmap.getWidth()) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = ((float) i2) / ((float) bitmap.getWidth());
            f = (((float) i3) - (((float) bitmap.getHeight()) * f2)) * 0.5f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) ((int) (f3 + 0.5f)), (float) ((int) (f + 0.5f)));
        Bitmap fe2 = bitmapPool.fe(i2, i3, uk(bitmap));
        m382if(bitmap, fe2);
        qw(bitmap, fe2, matrix);
        return fe2;
    }

    public static Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            boolean isLoggable = Log.isLoggable("TransformationUtils", 2);
            return rg(bitmapPool, bitmap, i2, i3);
        }
        boolean isLoggable2 = Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    public static void fe(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    @VisibleForTesting
    public static void i(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m382if(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static boolean o(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap pf(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2) {
        if (!o(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap fe2 = bitmapPool.fe(Math.round(rectF.width()), Math.round(rectF.height()), uk(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        fe2.setHasAlpha(bitmap.hasAlpha());
        qw(bitmap, fe2, matrix);
        return fe2;
    }

    public static void qw(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        f5949fe.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, qw);
            fe(canvas);
        } finally {
            f5949fe.unlock();
        }
    }

    public static Bitmap rg(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            boolean isLoggable = Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            boolean isLoggable2 = Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        Bitmap fe2 = bitmapPool.fe((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), uk(bitmap));
        m382if(bitmap, fe2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            "request: " + i2 + x.a + i3;
            "toFit:   " + bitmap.getWidth() + x.a + bitmap.getHeight();
            "toReuse: " + fe2.getWidth() + x.a + fe2.getHeight();
            "minPct:   " + min;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        qw(bitmap, fe2, matrix);
        return fe2;
    }

    public static Lock th() {
        return f5949fe;
    }

    @NonNull
    public static Bitmap.Config uk(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static int yj(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }
}
