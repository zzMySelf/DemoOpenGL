package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.de  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7919ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f7920th;

    public /* synthetic */ de(MethodChannel.Result result, int i2) {
        this.f7919ad = result;
        this.f7920th = i2;
    }

    public final void run() {
        DocumentToolPluginProxy.mmm(this.f7919ad, this.f7920th);
    }
}
