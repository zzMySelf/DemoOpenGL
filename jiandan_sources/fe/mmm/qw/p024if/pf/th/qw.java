package fe.mmm.qw.p024if.pf.th;

import android.app.Activity;
import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.th.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7941ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Activity f7942th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String f7943yj;

    public /* synthetic */ qw(MethodChannel.Result result, Activity activity, String str) {
        this.f7941ad = result;
        this.f7942th = activity;
        this.f7943yj = str;
    }

    public final void run() {
        DocumentToolPluginProxy.z(this.f7941ad, this.f7942th, this.f7943yj);
    }
}
