package fe.mmm.qw.k.p027if;

import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.util.VipSellerCodeReview;
import fe.de.qw.qw.Cif;

/* renamed from: fe.mmm.qw.k.if.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Cif f7982ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ String f7983de;
    public final /* synthetic */ VipSellerCodeReview qw;

    public /* synthetic */ qw(VipSellerCodeReview vipSellerCodeReview, Cif ifVar, String str) {
        this.qw = vipSellerCodeReview;
        this.f7982ad = ifVar;
        this.f7983de = str;
    }

    public final void onChanged(Object obj) {
        VipSellerCodeReview.i(this.qw, this.f7982ad, this.f7983de, (Result) obj);
    }
}
