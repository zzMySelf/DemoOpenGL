package fe.uk.qw.vvv;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.load.model.Model;
import com.google.common.base.Ascii;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public static final char[] f6048ad = new char[64];
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static volatile Handler f6049de;
    public static final char[] qw = "0123456789abcdef".toCharArray();

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.vvv.o.qw.<clinit>():void");
        }
    }

    @NonNull
    public static String aaa(@NonNull byte[] bArr) {
        String fe2;
        synchronized (f6048ad) {
            fe2 = fe(bArr, f6048ad);
        }
        return fe2;
    }

    public static boolean ad(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof Model) {
            return ((Model) obj).qw(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean ddd(int i2, int i3) {
        return xxx(i2) && xxx(i3);
    }

    public static boolean de(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @NonNull
    public static String fe(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = qw;
            cArr[i3] = cArr2[b >>> 4];
            cArr[i3 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static boolean ggg() {
        return !vvv();
    }

    @NonNull
    public static <T> List<T> i(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: if  reason: not valid java name */
    public static int m390if(float f, int i2) {
        return m391switch(Float.floatToIntBits(f), i2);
    }

    public static void mmm(Runnable runnable) {
        o().removeCallbacks(runnable);
    }

    public static void nn(Runnable runnable) {
        o().post(runnable);
    }

    public static Handler o() {
        if (f6049de == null) {
            synchronized (o.class) {
                if (f6049de == null) {
                    f6049de = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f6049de;
    }

    public static int pf(float f) {
        return m390if(f, 17);
    }

    public static int ppp(boolean z, int i2) {
        return m391switch(z ? 1 : 0, i2);
    }

    public static void qw() {
        if (!vvv()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    @NonNull
    public static <T> Queue<T> rg(int i2) {
        return new ArrayDeque(i2);
    }

    /* renamed from: switch  reason: not valid java name */
    public static int m391switch(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int th(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * uk(config);
    }

    public static int uk(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = qw.qw[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    public static boolean vvv() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static int when(@Nullable Object obj, int i2) {
        return m391switch(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static boolean xxx(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    @TargetApi(19)
    public static int yj(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + x.a + bitmap.getHeight() + "] " + bitmap.getConfig());
    }
}
