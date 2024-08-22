package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.ad  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7917ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7918th;

    public /* synthetic */ ad(MethodChannel.Result result, int i2) {
        this.f7917ad = result;
        this.f7918th = i2;
    }

    public final void run() {
        DocumentToolPluginProxy.I(this.f7917ad, this.f7918th);
    }
}
