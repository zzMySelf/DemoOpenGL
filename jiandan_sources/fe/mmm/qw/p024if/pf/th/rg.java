package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;

/* renamed from: fe.mmm.qw.if.pf.th.rg  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7944ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ List f7945th;

    public /* synthetic */ rg(MethodChannel.Result result, List list) {
        this.f7944ad = result;
        this.f7945th = list;
    }

    public final void run() {
        DocumentToolPluginProxy.w(this.f7944ad, this.f7945th);
    }
}
