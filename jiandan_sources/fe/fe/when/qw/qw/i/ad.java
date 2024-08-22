package fe.fe.when.qw.qw.i;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class ad implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ fe f3177ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ ad(MutableLiveData mutableLiveData, fe feVar) {
        this.qw = mutableLiveData;
        this.f3177ad = feVar;
    }

    public final void onPayResult(int i2, String str) {
        fe.de(this.qw, this.f3177ad, i2, str);
    }
}
