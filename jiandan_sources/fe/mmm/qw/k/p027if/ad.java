package fe.mmm.qw.k.p027if;

import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.util.VipSellerCodeReview;

/* renamed from: fe.mmm.qw.k.if.ad  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ VipSellerCodeReview qw;

    public /* synthetic */ ad(VipSellerCodeReview vipSellerCodeReview) {
        this.qw = vipSellerCodeReview;
    }

    public final void onChanged(Object obj) {
        VipSellerCodeReview.de(this.qw, (Result) obj);
    }
}
