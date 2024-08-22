package fe.fe.when.qw.qw.th;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class de implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ o f3183ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ de(MutableLiveData mutableLiveData, o oVar) {
        this.qw = mutableLiveData;
        this.f3183ad = oVar;
    }

    public final void onPayResult(int i2, String str) {
        o.fe(this.qw, this.f3183ad, i2, str);
    }
}
