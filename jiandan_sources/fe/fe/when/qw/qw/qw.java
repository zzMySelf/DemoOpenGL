package fe.fe.when.qw.qw;

import androidx.lifecycle.Observer;
import com.baidu.netdisk.trade.pay.order.IPayResult;
import fe.fe.when.qw.qw.yj.ad;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f3179ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ String f3180de;
    public final /* synthetic */ IPayResult qw;

    public /* synthetic */ qw(IPayResult iPayResult, String str, String str2) {
        this.qw = iPayResult;
        this.f3179ad = str;
        this.f3180de = str2;
    }

    public final void onChanged(Object obj) {
        de.th(this.qw, this.f3179ad, this.f3180de, (ad) obj);
    }
}
