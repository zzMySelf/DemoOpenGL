package fe.fe.when.qw.qw.th;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class rg implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ o f3185ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ rg(MutableLiveData mutableLiveData, o oVar) {
        this.qw = mutableLiveData;
        this.f3185ad = oVar;
    }

    public final void onPayResult(int i2, String str) {
        o.yj(this.qw, this.f3185ad, i2, str);
    }
}
