package fe.ggg.ad.ad.qw;

import com.android.billingclient.api.PurchasesUpdatedListener;
import com.mars.united.international.pay.GooglePay;
import fe.de.qw.qw.yj;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qw implements PurchasesUpdatedListener {
    public final /* synthetic */ GooglePay qw;

    public /* synthetic */ qw(GooglePay googlePay) {
        this.qw = googlePay;
    }

    public final void fe(yj yjVar, List list) {
        GooglePay.ggg(this.qw, yjVar, list);
    }
}
