package fe.vvv.qw.o;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import fe.vvv.qw.yj.i.qw;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ad<T> {

    /* renamed from: uk  reason: collision with root package name */
    public static final CameraLogger f9038uk = CameraLogger.qw(ad.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public int f9039ad = -1;

    /* renamed from: de  reason: collision with root package name */
    public fe.vvv.qw.xxx.ad f9040de = null;

    /* renamed from: fe  reason: collision with root package name */
    public int f9041fe = -1;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Class<T> f9042rg;

    /* renamed from: th  reason: collision with root package name */
    public LinkedBlockingQueue<qw> f9043th;

    /* renamed from: yj  reason: collision with root package name */
    public qw f9044yj;

    public ad(int i2, @NonNull Class<T> cls) {
        this.qw = i2;
        this.f9042rg = cls;
        this.f9043th = new LinkedBlockingQueue<>(this.qw);
    }

    public final int ad() {
        return this.f9039ad;
    }

    public final Class<T> de() {
        return this.f9042rg;
    }

    public final int fe() {
        return this.qw;
    }

    public void i(int i2, @NonNull fe.vvv.qw.xxx.ad adVar, @NonNull qw qwVar) {
        rg();
        this.f9040de = adVar;
        this.f9041fe = i2;
        this.f9039ad = (int) Math.ceil(((double) ((long) ((adVar.fe() * adVar.rg()) * ImageFormat.getBitsPerPixel(i2)))) / 8.0d);
        for (int i3 = 0; i3 < fe(); i3++) {
            this.f9043th.offer(new qw(this));
        }
        this.f9044yj = qwVar;
    }

    @Nullable
    public qw qw(@NonNull T t, long j) {
        if (rg()) {
            qw poll = this.f9043th.poll();
            if (poll != null) {
                f9038uk.uk("getFrame for time:", Long.valueOf(j), "RECYCLING.");
                poll.o(t, j, this.f9044yj.de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR), this.f9044yj.de(Reference.SENSOR, Reference.VIEW, Axis.RELATIVE_TO_SENSOR), this.f9040de, this.f9041fe);
                return poll;
            }
            f9038uk.de("getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            th(t, false);
            return null;
        }
        throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
    }

    public boolean rg() {
        return this.f9040de != null;
    }

    public abstract void th(@NonNull T t, boolean z);

    public void uk() {
        if (!rg()) {
            f9038uk.i("release called twice. Ignoring.");
            return;
        }
        f9038uk.de("release: Clearing the frame and buffer queue.");
        this.f9043th.clear();
        this.f9039ad = -1;
        this.f9040de = null;
        this.f9041fe = -1;
        this.f9044yj = null;
    }

    public void yj(@NonNull qw qwVar, @NonNull T t) {
        if (rg()) {
            th(t, this.f9043th.offer(qwVar));
        }
    }
}
