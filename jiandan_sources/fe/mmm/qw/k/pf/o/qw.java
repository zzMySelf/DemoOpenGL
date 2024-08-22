package fe.mmm.qw.k.pf.o;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.vip.ui.viewmodel.VipBuyViewModel;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ VipBuyViewModel f8000ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f8001de;
    public final /* synthetic */ boolean qw;

    public /* synthetic */ qw(boolean z, VipBuyViewModel vipBuyViewModel, MutableLiveData mutableLiveData) {
        this.qw = z;
        this.f8000ad = vipBuyViewModel;
        this.f8001de = mutableLiveData;
    }

    public final void onChanged(Object obj) {
        VipBuyViewModel.qw(this.qw, this.f8000ad, this.f8001de, (fe.mmm.qw.k.yj.qw) obj);
    }
}
