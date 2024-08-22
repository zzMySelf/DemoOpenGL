package fe.fe.when.qw.qw.th;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.LBSPayBack;

/* compiled from: lambda */
public final /* synthetic */ class uk implements LBSPayBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ pf f3186ad;
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ uk(MutableLiveData mutableLiveData, pf pfVar) {
        this.qw = mutableLiveData;
        this.f3186ad = pfVar;
    }

    public final void onPayResult(int i2, String str) {
        pf.rg(this.qw, this.f3186ad, i2, str);
    }
}
