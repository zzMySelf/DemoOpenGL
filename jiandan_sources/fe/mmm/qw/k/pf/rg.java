package fe.mmm.qw.k.pf;

import android.webkit.ValueCallback;
import com.tera.scan.vip.ui.VipWebActivity;

/* compiled from: lambda */
public final /* synthetic */ class rg implements ValueCallback {
    public final /* synthetic */ VipWebActivity qw;

    public /* synthetic */ rg(VipWebActivity vipWebActivity) {
        this.qw = vipWebActivity;
    }

    public final void onReceiveValue(Object obj) {
        VipWebActivity.m942interceptBackPress$lambda8(this.qw, (Throwable) obj);
    }
}
