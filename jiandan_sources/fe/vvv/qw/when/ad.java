package fe.vvv.qw.when;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ad {
    @VisibleForTesting
    public final List<qw> qw;

    public ad(@NonNull List<qw> list) {
        this.qw = list;
    }

    @NonNull
    public static ad ad(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull RectF rectF) {
        return de(adVar, rectF, 1000);
    }

    @NonNull
    public static ad de(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull RectF rectF, int i2) {
        return fe(adVar, rectF, i2, false);
    }

    @NonNull
    public static ad fe(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull RectF rectF, int i2, boolean z) {
        ArrayList<qw> arrayList = new ArrayList<>();
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        float width = rectF.width();
        float height = rectF.height();
        arrayList.add(new qw(rectF, i2));
        if (z) {
            arrayList.add(new qw(qw(pointF, width * 1.5f, height * 1.5f), Math.round(((float) i2) * 0.1f)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (qw ad2 : arrayList) {
            arrayList2.add(ad2.ad(adVar));
        }
        return new ad(arrayList2);
    }

    @NonNull
    public static RectF qw(@NonNull PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @NonNull
    public static ad rg(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        return th(adVar, pointF, 1000);
    }

    @NonNull
    public static ad th(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF, int i2) {
        return fe(adVar, qw(pointF, ((float) adVar.rg()) * 0.05f, ((float) adVar.fe()) * 0.05f), i2, true);
    }

    @NonNull
    public ad uk(@NonNull MeteringTransform meteringTransform) {
        ArrayList arrayList = new ArrayList();
        for (qw rg2 : this.qw) {
            arrayList.add(rg2.rg(meteringTransform));
        }
        return new ad(arrayList);
    }

    @NonNull
    public <T> List<T> yj(int i2, @NonNull MeteringTransform<T> meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.qw);
        for (qw next : this.qw) {
            arrayList.add(meteringTransform.qw(next.f9126ad, next.f9127th));
        }
        return arrayList.subList(0, Math.min(i2, arrayList.size()));
    }
}
