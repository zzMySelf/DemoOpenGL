package yj.qw.qw.qw.qw.fe;

import jp.co.cyberagent.android.gpuimage.util.Rotation;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final float[] f11105ad = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: de  reason: collision with root package name */
    public static final float[] f11106de = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: fe  reason: collision with root package name */
    public static final float[] f11107fe = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] qw = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                jp.co.cyberagent.android.gpuimage.util.Rotation[] r0 = jp.co.cyberagent.android.gpuimage.util.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yj.qw.qw.qw.qw.fe.ad.qw.<clinit>():void");
        }
    }

    public static float[] ad(Rotation rotation, boolean z, boolean z2) {
        float[] fArr;
        int i2 = qw.qw[rotation.ordinal()];
        if (i2 == 1) {
            fArr = f11105ad;
        } else if (i2 == 2) {
            fArr = f11106de;
        } else if (i2 != 3) {
            fArr = qw;
        } else {
            fArr = f11107fe;
        }
        if (z) {
            fArr = new float[]{qw(fArr[0]), fArr[1], qw(fArr[2]), fArr[3], qw(fArr[4]), fArr[5], qw(fArr[6]), fArr[7]};
        }
        if (!z2) {
            return fArr;
        }
        return new float[]{fArr[0], qw(fArr[1]), fArr[2], qw(fArr[3]), fArr[4], qw(fArr[5]), fArr[6], qw(fArr[7])};
    }

    public static float qw(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }
}
