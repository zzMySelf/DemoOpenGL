package fe.vvv.qw.o;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.xxx.ad;
import java.util.Objects;

public class qw {

    /* renamed from: o  reason: collision with root package name */
    public static final CameraLogger f9045o = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final Class<?> f9046ad;

    /* renamed from: de  reason: collision with root package name */
    public Object f9047de = null;

    /* renamed from: fe  reason: collision with root package name */
    public long f9048fe = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f9049i = -1;
    public final ad qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f9050rg = -1;

    /* renamed from: th  reason: collision with root package name */
    public int f9051th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public ad f9052uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public int f9053yj = 0;

    public qw(@NonNull ad adVar) {
        this.qw = adVar;
        this.f9046ad = adVar.de();
    }

    @NonNull
    public <T> T ad() {
        qw();
        return this.f9047de;
    }

    @NonNull
    public Class<?> de() {
        return this.f9046ad;
    }

    public boolean equals(Object obj) {
        return (obj instanceof qw) && ((qw) obj).f9048fe == this.f9048fe;
    }

    public int fe() {
        qw();
        return this.f9049i;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.qw, this.f9046ad, this.f9047de, Long.valueOf(this.f9048fe), Long.valueOf(this.f9050rg), Integer.valueOf(this.f9051th), Integer.valueOf(this.f9053yj), this.f9052uk, Integer.valueOf(this.f9049i)});
    }

    public void i() {
        if (uk()) {
            f9045o.uk("Frame with time", Long.valueOf(this.f9048fe), "is being released.");
            Object obj = this.f9047de;
            this.f9047de = null;
            this.f9051th = 0;
            this.f9053yj = 0;
            this.f9048fe = -1;
            this.f9052uk = null;
            this.f9049i = -1;
            this.qw.yj(this, obj);
        }
    }

    public void o(@NonNull Object obj, long j, int i2, int i3, @NonNull ad adVar, int i4) {
        this.f9047de = obj;
        this.f9048fe = j;
        this.f9050rg = j;
        this.f9051th = i2;
        this.f9053yj = i3;
        this.f9052uk = adVar;
        this.f9049i = i4;
    }

    public final void qw() {
        if (!uk()) {
            f9045o.ad("Frame is dead! time:", Long.valueOf(this.f9048fe), "lastTime:", Long.valueOf(this.f9050rg));
            throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
        }
    }

    public int rg() {
        qw();
        return this.f9053yj;
    }

    @NonNull
    public ad th() {
        qw();
        return this.f9052uk;
    }

    public final boolean uk() {
        return this.f9047de != null;
    }

    public long yj() {
        qw();
        return this.f9048fe;
    }
}
