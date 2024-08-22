package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.uk  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class uk implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7947ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ boolean f7948th;

    public /* synthetic */ uk(MethodChannel.Result result, boolean z) {
        this.f7947ad = result;
        this.f7948th = z;
    }

    public final void run() {
        DocumentToolPluginProxy.j(this.f7947ad, this.f7948th);
    }
}
