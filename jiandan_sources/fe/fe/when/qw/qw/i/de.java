package fe.fe.when.qw.qw.i;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class de implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ fe f3178ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ de(MutableLiveData mutableLiveData, fe feVar) {
        this.qw = mutableLiveData;
        this.f3178ad = feVar;
    }

    public final void onPayResult(int i2, String str) {
        fe.rg(this.qw, this.f3178ad, i2, str);
    }
}
