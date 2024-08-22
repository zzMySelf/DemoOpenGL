package fe.mmm.qw.p024if.pf.rg;

import com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.rg.de  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7881ad;

    public /* synthetic */ de(MethodChannel.Result result) {
        this.f7881ad = result;
    }

    public final void run() {
        NetdiskDbAccessPluginProxy.pf(this.f7881ad);
    }
}
