package fe.vvv.ad.de;

import android.opengl.GLES20;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.i.qw;
import fe.vvv.ad.th.th;
import java.nio.FloatBuffer;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

public class de extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public static final float[] f8826rg = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public FloatBuffer f8827fe;

    public de() {
        FloatBuffer ad2 = qw.ad(f8826rg.length);
        ad2.put(f8826rg);
        ad2.clear();
        Unit unit = Unit.INSTANCE;
        this.f8827fe = ad2;
    }

    @NotNull
    public FloatBuffer fe() {
        return this.f8827fe;
    }

    public void qw() {
        fe.ad("glDrawArrays start");
        GLES20.glDrawArrays(th.vvv(), 0, th());
        fe.ad("glDrawArrays end");
    }
}
