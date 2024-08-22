package fe.mmm.qw.p024if.pf.qw;

import com.tera.scan.flutter.plugin.account.AccountChannelPluginProxy;
import com.tera.scan.flutter.plugin.caller.VoidCallback;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.qw.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements VoidCallback {
    public final /* synthetic */ MethodChannel.Result qw;

    public /* synthetic */ qw(MethodChannel.Result result) {
        this.qw = result;
    }

    public final void onCall(Object obj) {
        AccountChannelPluginProxy.ad(this.qw, (Boolean) obj);
    }
}
