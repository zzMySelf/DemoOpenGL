package jp.co.cyberagent.android.gpuimage.util;

public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw = null;

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
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                jp.co.cyberagent.android.gpuimage.util.Rotation r1 = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.util.Rotation.qw.<clinit>():void");
        }
    }

    public static Rotation fromInt(int i2) {
        if (i2 == 0) {
            return NORMAL;
        }
        if (i2 == 90) {
            return ROTATION_90;
        }
        if (i2 == 180) {
            return ROTATION_180;
        }
        if (i2 == 270) {
            return ROTATION_270;
        }
        if (i2 == 360) {
            return NORMAL;
        }
        throw new IllegalStateException(i2 + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }

    public int asInt() {
        int i2 = qw.qw[ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 90;
        }
        if (i2 == 3) {
            return 180;
        }
        if (i2 == 4) {
            return 270;
        }
        throw new IllegalStateException("Unknown Rotation!");
    }
}
