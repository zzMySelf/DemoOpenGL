package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy$onMethodCall$3;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.yj  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class yj implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7951ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f7952th;

    public /* synthetic */ yj(MethodChannel.Result result, String str) {
        this.f7951ad = result;
        this.f7952th = str;
    }

    public final void run() {
        DocumentToolPluginProxy$onMethodCall$3.m761invokeSuspend$lambda3$lambda2(this.f7951ad, this.f7952th);
    }
}
