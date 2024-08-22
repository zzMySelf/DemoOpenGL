package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.i  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7932ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7933th;

    public /* synthetic */ i(MethodChannel.Result result, int i2) {
        this.f7932ad = result;
        this.f7933th = i2;
    }

    public final void run() {
        DocumentToolPluginProxy.vvv(this.f7932ad, this.f7933th);
    }
}
