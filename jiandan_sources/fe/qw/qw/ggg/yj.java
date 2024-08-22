package fe.qw.qw.ggg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.qw.qw.pf.ad.ggg;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static final ThreadLocal<Path> f3260ad = new ad();

    /* renamed from: de  reason: collision with root package name */
    public static final ThreadLocal<Path> f3261de = new de();

    /* renamed from: fe  reason: collision with root package name */
    public static final ThreadLocal<float[]> f3262fe = new fe();
    public static final ThreadLocal<PathMeasure> qw = new qw();

    /* renamed from: rg  reason: collision with root package name */
    public static final float f3263rg = ((float) (Math.sqrt(2.0d) / 2.0d));

    /* renamed from: th  reason: collision with root package name */
    public static float f3264th = -1.0f;

    public class ad extends ThreadLocal<Path> {
        /* renamed from: qw */
        public Path initialValue() {
            return new Path();
        }
    }

    public class de extends ThreadLocal<Path> {
        /* renamed from: qw */
        public Path initialValue() {
            return new Path();
        }
    }

    public class fe extends ThreadLocal<float[]> {
        /* renamed from: qw */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public class qw extends ThreadLocal<PathMeasure> {
        /* renamed from: qw */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    public static void ad(Path path, @Nullable ggg ggg) {
        if (ggg != null && !ggg.o()) {
            qw(path, ((fe.qw.qw.pf.de.ad) ggg.uk()).ppp() / 100.0f, ((fe.qw.qw.pf.de.ad) ggg.fe()).ppp() / 100.0f, ((fe.qw.qw.pf.de.ad) ggg.th()).ppp() / 360.0f);
        }
    }

    public static void de(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static Path fe(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF.x;
            float f2 = pointF2.x;
            float f3 = pointF2.y;
            path.cubicTo(pointF3.x + f, pointF.y + pointF3.y, f2 + pointF4.x, f3 + pointF4.y, f2, f3);
        }
        return path;
    }

    public static int i(float f, float f2, float f3, float f4) {
        int i2 = f != 0.0f ? (int) (((float) PayBeanFactory.BEAN_ID_WIDTHDRAW) * f) : 17;
        if (f2 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f3);
        }
        return f4 != 0.0f ? (int) (((float) (i2 * 31)) * f4) : i2;
    }

    /* renamed from: if  reason: not valid java name */
    public static Bitmap m232if(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean o(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static boolean pf(Throwable th2) {
        return (th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException);
    }

    public static void qw(Path path, float f, float f2, float f3) {
        fe.qw.qw.ad.qw("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = qw.get();
        Path path2 = f3260ad.get();
        Path path3 = f3261de.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            fe.qw.qw.ad.ad("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            fe.qw.qw.ad.ad("applyTrimPathIfNeeded");
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = (float) th.yj(min, length);
                max = (float) th.yj(max, length);
            }
            if (min < 0.0f) {
                min = (float) th.yj(min, length);
            }
            if (max < 0.0f) {
                max = (float) th.yj(max, length);
            }
            int i2 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i2 == 0) {
                path.reset();
                fe.qw.qw.ad.ad("applyTrimPathIfNeeded");
                return;
            }
            if (i2 >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            fe.qw.qw.ad.ad("applyTrimPathIfNeeded");
        }
    }

    public static float rg() {
        if (f3264th == -1.0f) {
            f3264th = Resources.getSystem().getDisplayMetrics().density;
        }
        return f3264th;
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m233switch(Canvas canvas, RectF rectF, Paint paint) {
        when(canvas, rectF, paint, 31);
    }

    public static float th(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static boolean uk(Matrix matrix) {
        float[] fArr = f3262fe.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            return true;
        }
        return false;
    }

    public static void when(Canvas canvas, RectF rectF, Paint paint, int i2) {
        fe.qw.qw.ad.qw("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        fe.qw.qw.ad.ad("Utils#saveLayer");
    }

    public static float yj(Matrix matrix) {
        float[] fArr = f3262fe.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f3263rg;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot((double) (fArr[2] - fArr[0]), (double) (fArr[3] - fArr[1]));
    }
}
