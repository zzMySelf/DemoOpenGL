package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.o  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7936ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7937th;

    public /* synthetic */ o(MethodChannel.Result result, int i2) {
        this.f7936ad = result;
        this.f7937th = i2;
    }

    public final void run() {
        DocumentToolPluginProxy.ddd(this.f7936ad, this.f7937th);
    }
}
