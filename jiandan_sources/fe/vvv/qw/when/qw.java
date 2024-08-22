package fe.vvv.qw.when;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import fe.vvv.qw.xxx.ad;

public class qw implements Comparable<qw> {

    /* renamed from: ad  reason: collision with root package name */
    public final RectF f9126ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f9127th;

    public qw(@NonNull RectF rectF, int i2) {
        this.f9126ad = rectF;
        this.f9127th = i2;
    }

    @NonNull
    public qw ad(@NonNull ad adVar) {
        return qw(new RectF(0.0f, 0.0f, (float) adVar.rg(), (float) adVar.fe()));
    }

    /* renamed from: fe */
    public int compareTo(@NonNull qw qwVar) {
        return -Integer.valueOf(this.f9127th).compareTo(Integer.valueOf(qwVar.f9127th));
    }

    @NonNull
    public qw qw(@NonNull RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.set(Math.max(rectF.left, this.f9126ad.left), Math.max(rectF.top, this.f9126ad.top), Math.min(rectF.right, this.f9126ad.right), Math.min(rectF.bottom, this.f9126ad.bottom));
        return new qw(rectF2, this.f9127th);
    }

    @NonNull
    public qw rg(@NonNull MeteringTransform meteringTransform) {
        RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
        PointF pointF = new PointF();
        RectF rectF2 = this.f9126ad;
        pointF.set(rectF2.left, rectF2.top);
        PointF ad2 = meteringTransform.ad(pointF);
        th(rectF, ad2);
        RectF rectF3 = this.f9126ad;
        ad2.set(rectF3.right, rectF3.top);
        PointF ad3 = meteringTransform.ad(ad2);
        th(rectF, ad3);
        RectF rectF4 = this.f9126ad;
        ad3.set(rectF4.right, rectF4.bottom);
        PointF ad4 = meteringTransform.ad(ad3);
        th(rectF, ad4);
        RectF rectF5 = this.f9126ad;
        ad4.set(rectF5.left, rectF5.bottom);
        th(rectF, meteringTransform.ad(ad4));
        return new qw(rectF, this.f9127th);
    }

    public final void th(@NonNull RectF rectF, @NonNull PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }
}
