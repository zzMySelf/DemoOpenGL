package fe.vvv.qw.yj.i;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.tera.scan.ui.widget.RotateProgress;

public class qw {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f9212rg = CameraLogger.qw(qw.class.getSimpleName());
    @VisibleForTesting

    /* renamed from: ad  reason: collision with root package name */
    public int f9213ad = 0;
    @VisibleForTesting

    /* renamed from: de  reason: collision with root package name */
    public int f9214de = 0;
    @VisibleForTesting

    /* renamed from: fe  reason: collision with root package name */
    public int f9215fe = 0;
    public Facing qw;

    /* renamed from: fe.vvv.qw.yj.i.qw$qw  reason: collision with other inner class name */
    public static /* synthetic */ class C0321qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.otaliastudios.cameraview.engine.offset.Reference[] r0 = com.otaliastudios.cameraview.engine.offset.Reference.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.engine.offset.Reference r1 = com.otaliastudios.cameraview.engine.offset.Reference.VIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.engine.offset.Reference r1 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.otaliastudios.cameraview.engine.offset.Reference r1 = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.yj.i.qw.C0321qw.<clinit>():void");
        }
    }

    public boolean ad(@NonNull Reference reference, @NonNull Reference reference2) {
        return de(reference, reference2, Axis.ABSOLUTE) % 180 != 0;
    }

    public int de(@NonNull Reference reference, @NonNull Reference reference2, @NonNull Axis axis) {
        int qw2 = qw(reference, reference2);
        return (axis == Axis.RELATIVE_TO_SENSOR && this.qw == Facing.FRONT) ? th(360 - qw2) : qw2;
    }

    public final void fe() {
        f9212rg.de("Angles changed:", "sensorOffset:", Integer.valueOf(this.f9213ad), "displayOffset:", Integer.valueOf(this.f9214de), "deviceOrientation:", Integer.valueOf(this.f9215fe));
    }

    public void i(@NonNull Facing facing, int i2) {
        rg(i2);
        this.qw = facing;
        this.f9213ad = i2;
        if (facing == Facing.FRONT) {
            this.f9213ad = th(360 - i2);
        }
        fe();
    }

    public final int qw(@NonNull Reference reference, @NonNull Reference reference2) {
        if (reference == reference2) {
            return 0;
        }
        Reference reference3 = Reference.BASE;
        if (reference2 == reference3) {
            return th(360 - qw(reference2, reference));
        }
        if (reference != reference3) {
            return th(qw(reference3, reference2) - qw(Reference.BASE, reference));
        }
        int i2 = C0321qw.qw[reference2.ordinal()];
        if (i2 == 1) {
            return th(360 - this.f9214de);
        }
        if (i2 == 2) {
            return th(this.f9215fe);
        }
        if (i2 == 3) {
            return th(360 - this.f9213ad);
        }
        throw new RuntimeException("Unknown reference: " + reference2);
    }

    public final void rg(int i2) {
        if (i2 != 0 && i2 != 90 && i2 != 180 && i2 != 270) {
            throw new IllegalStateException("This value is not sanitized: " + i2);
        }
    }

    public final int th(int i2) {
        return (i2 + RotateProgress.FULL_DEGREE) % RotateProgress.FULL_DEGREE;
    }

    public void uk(int i2) {
        rg(i2);
        this.f9214de = i2;
        fe();
    }

    public void yj(int i2) {
        rg(i2);
        this.f9215fe = i2;
        fe();
    }
}
