package fe.mmm.qw.d.ad.ggg;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public List<de> f7686ad = new ArrayList();
    public View qw;

    public void ad() {
        if (!fe.mmm.qw.d.fe.fe.qw(this.f7686ad)) {
            this.f7686ad.clear();
        }
    }

    public void qw() {
        if (!fe.mmm.qw.d.fe.fe.qw(this.f7686ad)) {
            for (de ad2 : this.f7686ad) {
                ad2.ad(this.qw);
            }
        }
    }

    public String toString() {
        return "SkinItem [view=" + this.qw.getClass().getSimpleName() + ", attrs=" + this.f7686ad + "]";
    }
}
