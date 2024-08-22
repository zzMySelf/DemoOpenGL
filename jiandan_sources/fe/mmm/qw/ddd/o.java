package fe.mmm.qw.ddd;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.tera.scan.model.ImageBytePredictorCallback;
import com.terascan.algo.DocumentResult;
import com.terascan.algo.DocumentScanAPI;
import com.terascan.algo.Point;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class o extends uk {
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public static final qw f327if = new qw((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public static volatile o f328switch;

    /* renamed from: i  reason: collision with root package name */
    public int f7715i;

    /* renamed from: o  reason: collision with root package name */
    public int f7716o;

    /* renamed from: pf  reason: collision with root package name */
    public int f7717pf;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<Point> f7718uk;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final o qw() {
            o i2 = o.f328switch;
            if (i2 == null) {
                synchronized (this) {
                    i2 = o.f328switch;
                    if (i2 == null) {
                        i2 = new o((DefaultConstructorMarker) null);
                        qw qwVar = o.f327if;
                        o.f328switch = i2;
                    }
                }
            }
            return i2;
        }
    }

    public o() {
    }

    public /* synthetic */ o(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void ggg(Context context, byte[] bArr, fe.mmm.qw.ddd.pf.qw qwVar, int i2, int i3, boolean z, ImageBytePredictorCallback imageBytePredictorCallback) {
        if (!yj(context)) {
            pf(bArr, imageBytePredictorCallback);
        } else {
            xxx(bArr, qwVar, i2, i3, z, imageBytePredictorCallback);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m966if(ArrayList<Point> arrayList) {
        ArrayList<Point> arrayList2 = this.f7718uk;
        if (arrayList2 == null) {
            return false;
        }
        double ad2 = i.ad(arrayList2);
        double ad3 = i.ad(arrayList);
        double d = ad2 + ad3;
        if (((int) d) == 0) {
            return true;
        }
        double d2 = ad3 / d;
        if (d2 >= 0.30000001192092896d && d2 <= 0.699999988079071d) {
            return false;
        }
        this.f7717pf++;
        return true;
    }

    public final void pf(byte[] bArr, ImageBytePredictorCallback imageBytePredictorCallback) {
        int i2 = this.f7715i + 1;
        this.f7715i = i2;
        if (i2 >= 2 || this.f7718uk == null) {
            this.f7715i = 0;
            this.f7718uk = null;
            imageBytePredictorCallback.qw(bArr.hashCode(), (DocumentResult) null);
            return;
        }
        DocumentResult documentResult = new DocumentResult();
        documentResult.setCode(0);
        documentResult.setPoints(this.f7718uk);
        imageBytePredictorCallback.qw(bArr.hashCode(), documentResult);
    }

    public final Point ppp(ArrayList<Point> arrayList) {
        int i2 = 0;
        int i3 = 0;
        for (Point x : arrayList) {
            i3 += (int) x.getX();
        }
        for (Point y : arrayList) {
            i2 += (int) y.getY();
        }
        return new Point(((float) i3) / 4.0f, ((float) i2) / 4.0f);
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m967switch(int i2, int i3, ArrayList<Point> arrayList) {
        ArrayList<Point> arrayList2 = this.f7718uk;
        if (arrayList2 == null) {
            return false;
        }
        Point ppp = ppp(arrayList2);
        Point ppp2 = ppp(arrayList);
        float abs = Math.abs(ppp2.getX() - ppp.getX());
        float abs2 = Math.abs(ppp2.getY() - ppp.getY());
        if (abs / ((float) i2) <= 0.2f && abs2 / ((float) i3) <= 0.2f) {
            return false;
        }
        this.f7716o++;
        return true;
    }

    public void uk() {
        super.uk();
    }

    public final void vvv(@NotNull Context context, @NotNull byte[] bArr, @NotNull fe.mmm.qw.ddd.pf.qw qwVar, int i2, int i3, boolean z, @NotNull ImageBytePredictorCallback imageBytePredictorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bArr, "imageBuffer");
        Intrinsics.checkNotNullParameter(qwVar, "ocrPredictorData");
        Intrinsics.checkNotNullParameter(imageBytePredictorCallback, "callback");
        System.currentTimeMillis();
        ggg(context, bArr, qwVar, i2, i3, z, imageBytePredictorCallback);
    }

    public final boolean when(byte[] bArr, fe.mmm.qw.ddd.pf.qw qwVar, ArrayList<Point> arrayList) {
        int i2;
        int i3;
        if (arrayList != null) {
            if (qwVar.qw() % 180 == 0) {
                i3 = qwVar.de();
                i2 = qwVar.ad();
            } else {
                i3 = qwVar.ad();
                i2 = qwVar.de();
            }
            if (de(i3, i2, arrayList) || fe(arrayList) || ad(arrayList) || qw(i3, i2, arrayList) || m967switch(i3, i2, arrayList) || m966if(arrayList)) {
                return false;
            }
            float rg2 = ((float) qwVar.rg()) / ((float) i3);
            float fe2 = ((float) qwVar.fe()) / ((float) i2);
            for (Point point : arrayList) {
                point.setX(point.getX() * rg2);
                point.setY(point.getY() * fe2);
            }
        }
        return true;
    }

    @WorkerThread
    public final void xxx(@NotNull byte[] bArr, @NotNull fe.mmm.qw.ddd.pf.qw qwVar, int i2, int i3, boolean z, @NotNull ImageBytePredictorCallback imageBytePredictorCallback) {
        Object obj;
        Intrinsics.checkNotNullParameter(bArr, "imageBuffer");
        Intrinsics.checkNotNullParameter(qwVar, "ocrPredictorData");
        Intrinsics.checkNotNullParameter(imageBytePredictorCallback, "callback");
        if (qwVar.de() <= 0 || qwVar.ad() <= 0) {
            pf(bArr, imageBytePredictorCallback);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            DocumentScanAPI th2 = th();
            DocumentResult detect = th2 != null ? th2.detect(bArr, i2, i3, z) : null;
            if (detect != null) {
                if (detect.getCode() == 0) {
                    ArrayList<Point> points = detect.getPoints();
                    if (!when(bArr, qwVar, points)) {
                        pf(bArr, imageBytePredictorCallback);
                    } else {
                        this.f7715i = 0;
                        this.f7718uk = points;
                        imageBytePredictorCallback.qw(bArr.hashCode(), detect);
                    }
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                    if (Result.m1158exceptionOrNullimpl(obj) != null) {
                        pf(bArr, imageBytePredictorCallback);
                        return;
                    }
                    return;
                }
            }
            pf(bArr, imageBytePredictorCallback);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th3));
        }
    }
}
