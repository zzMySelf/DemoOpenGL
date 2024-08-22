package fe.qw.qw.p009switch.o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.i;
import fe.qw.qw.pf.ad.de;
import java.util.Collections;
import java.util.List;

/* renamed from: fe.qw.qw.switch.o.rg  reason: invalid package */
public class rg extends qw {
    public final de tt;

    public rg(fe.qw.qw.rg rgVar, Layer layer) {
        super(rgVar, layer);
        de deVar = new de(rgVar, this, new i("__container", layer.m2if(), false));
        this.tt = deVar;
        deVar.ad(Collections.emptyList(), Collections.emptyList());
    }

    public void d(fe feVar, int i2, List<fe> list, fe feVar2) {
        this.tt.fe(feVar, i2, list, feVar2);
    }

    public void nn(@NonNull Canvas canvas, Matrix matrix, int i2) {
        this.tt.yj(canvas, matrix, i2);
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        super.rg(rectF, matrix, z);
        this.tt.rg(rectF, this.f118switch, z);
    }
}
