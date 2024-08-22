package fe.fe.when.qw.qw;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.baidu.netdisk.trade.pay.order.IPayResult;
import com.baidu.netdisk.trade.pay.order.model.Purchase;
import com.baidu.netdisk.trade.pay.order.view.LoadingDialog;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ IPayResult f3173ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ de f3174de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f3175fe;
    public final /* synthetic */ LoadingDialog qw;

    /* renamed from: rg  reason: collision with root package name */
    public final /* synthetic */ String f3176rg;

    public /* synthetic */ ad(LoadingDialog loadingDialog, IPayResult iPayResult, de deVar, FragmentActivity fragmentActivity, String str) {
        this.qw = loadingDialog;
        this.f3173ad = iPayResult;
        this.f3174de = deVar;
        this.f3175fe = fragmentActivity;
        this.f3176rg = str;
    }

    public final void onChanged(Object obj) {
        de.rg(this.qw, this.f3173ad, this.f3174de, this.f3175fe, this.f3176rg, (Purchase) obj);
    }
}
