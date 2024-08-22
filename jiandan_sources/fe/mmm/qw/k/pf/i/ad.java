package fe.mmm.qw.k.pf.i;

import com.tera.scan.vip.ui.view.VipScrollViewPage;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ VipScrollViewPage f7986ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7987th;

    public /* synthetic */ ad(VipScrollViewPage vipScrollViewPage, int i2) {
        this.f7986ad = vipScrollViewPage;
        this.f7987th = i2;
    }

    public final void run() {
        VipScrollViewPage.m951setCurrentPage$lambda6(this.f7986ad, this.f7987th);
    }
}
