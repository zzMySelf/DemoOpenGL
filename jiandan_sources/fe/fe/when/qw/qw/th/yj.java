package fe.fe.when.qw.qw.th;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class yj implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ pf f3187ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ yj(MutableLiveData mutableLiveData, pf pfVar) {
        this.qw = mutableLiveData;
        this.f3187ad = pfVar;
    }

    public final void onPayResult(int i2, String str) {
        pf.de(this.qw, this.f3187ad, i2, str);
    }
}
