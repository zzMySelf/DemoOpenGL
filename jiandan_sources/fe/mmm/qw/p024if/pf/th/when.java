package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;

/* renamed from: fe.mmm.qw.if.pf.th.when  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class when implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7949ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ List f7950th;

    public /* synthetic */ when(MethodChannel.Result result, List list) {
        this.f7949ad = result;
        this.f7950th = list;
    }

    public final void run() {
        DocumentToolPluginProxy.u(this.f7949ad, this.f7950th);
    }
}
