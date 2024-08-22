package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.pf  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class pf implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7938ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ boolean f7939th;

    public /* synthetic */ pf(MethodChannel.Result result, boolean z) {
        this.f7938ad = result;
        this.f7939th = z;
    }

    public final void run() {
        DocumentToolPluginProxy.l(this.f7938ad, this.f7939th);
    }
}
