package fe.mmm.qw.k.pf;

import android.webkit.ValueCallback;
import com.tera.scan.vip.ui.VipWebActivity;

/* compiled from: lambda */
public final /* synthetic */ class de implements ValueCallback {
    public final /* synthetic */ VipWebActivity qw;

    public /* synthetic */ de(VipWebActivity vipWebActivity) {
        this.qw = vipWebActivity;
    }

    public final void onReceiveValue(Object obj) {
        VipWebActivity.m941interceptBackPress$lambda7(this.qw, (String) obj);
    }
}
