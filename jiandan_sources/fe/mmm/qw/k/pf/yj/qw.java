package fe.mmm.qw.k.pf.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.vip.ui.action.HybridActionPay;
import fe.mmm.qw.m.ggg.fe.ad;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ HybridActionPay f8005ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ ad f8006de;
    public final /* synthetic */ boolean qw;

    public /* synthetic */ qw(boolean z, HybridActionPay hybridActionPay, ad adVar) {
        this.qw = z;
        this.f8005ad = hybridActionPay;
        this.f8006de = adVar;
    }

    public final void onChanged(Object obj) {
        HybridActionPay.m944buyProduct$lambda2(this.qw, this.f8005ad, this.f8006de, (fe.mmm.qw.k.yj.qw) obj);
    }
}
