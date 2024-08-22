package fe.qw.qw.p009switch.i;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.qw;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.i.yj  reason: invalid package */
public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public PointF f3480ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f3481de;
    public final List<qw> qw;

    public yj(PointF pointF, boolean z, List<qw> list) {
        this.f3480ad = pointF;
        this.f3481de = z;
        this.qw = new ArrayList(list);
    }

    public PointF ad() {
        return this.f3480ad;
    }

    public void de(yj yjVar, yj yjVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f3480ad == null) {
            this.f3480ad = new PointF();
        }
        this.f3481de = yjVar.fe() || yjVar2.fe();
        if (yjVar.qw().size() != yjVar2.qw().size()) {
            fe.de("Curves must have the same number of control points. Shape 1: " + yjVar.qw().size() + "\tShape 2: " + yjVar2.qw().size());
        }
        int min = Math.min(yjVar.qw().size(), yjVar2.qw().size());
        if (this.qw.size() < min) {
            for (int size = this.qw.size(); size < min; size++) {
                this.qw.add(new qw());
            }
        } else if (this.qw.size() > min) {
            for (int size2 = this.qw.size() - 1; size2 >= min; size2--) {
                List<qw> list = this.qw;
                list.remove(list.size() - 1);
            }
        }
        PointF ad2 = yjVar.ad();
        PointF ad3 = yjVar2.ad();
        rg(th.pf(ad2.x, ad3.x, f), th.pf(ad2.y, ad3.y, f));
        for (int size3 = this.qw.size() - 1; size3 >= 0; size3--) {
            qw qwVar = yjVar.qw().get(size3);
            qw qwVar2 = yjVar2.qw().get(size3);
            PointF qw2 = qwVar.qw();
            PointF ad4 = qwVar.ad();
            PointF de2 = qwVar.de();
            PointF qw3 = qwVar2.qw();
            PointF ad5 = qwVar2.ad();
            PointF de3 = qwVar2.de();
            this.qw.get(size3).fe(th.pf(qw2.x, qw3.x, f), th.pf(qw2.y, qw3.y, f));
            this.qw.get(size3).rg(th.pf(ad4.x, ad5.x, f), th.pf(ad4.y, ad5.y, f));
            this.qw.get(size3).th(th.pf(de2.x, de3.x, f), th.pf(de2.y, de3.y, f));
        }
    }

    public boolean fe() {
        return this.f3481de;
    }

    public List<qw> qw() {
        return this.qw;
    }

    public final void rg(float f, float f2) {
        if (this.f3480ad == null) {
            this.f3480ad = new PointF();
        }
        this.f3480ad.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.qw.size() + "closed=" + this.f3481de + ExtendedMessageFormat.END_FE;
    }

    public yj() {
        this.qw = new ArrayList();
    }
}
