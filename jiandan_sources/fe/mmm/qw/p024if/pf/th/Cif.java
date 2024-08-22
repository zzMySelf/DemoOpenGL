package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.if  reason: invalid class name and invalid package */
/* compiled from: lambda */
public final /* synthetic */ class Cif implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7934ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ boolean f7935th;

    public /* synthetic */ Cif(MethodChannel.Result result, boolean z) {
        this.f7934ad = result;
        this.f7935th = z;
    }

    public final void run() {
        DocumentToolPluginProxy.n(this.f7934ad, this.f7935th);
    }
}
