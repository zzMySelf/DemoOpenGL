package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.caller.VoidCallback;
import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.th  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class th implements VoidCallback {
    public final /* synthetic */ MethodChannel.Result qw;

    public /* synthetic */ th(MethodChannel.Result result) {
        this.qw = result;
    }

    public final void onCall(Object obj) {
        DocumentToolPluginProxy.rrr(this.qw, (Void) obj);
    }
}
