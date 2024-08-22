package fe.mmm.qw.p024if.pf.rg;

import android.net.Uri;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: fe.mmm.qw.if.pf.rg.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ppp f7901ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Uri f7902th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7903yj;

    public /* synthetic */ qw(ppp ppp, Uri uri, MethodChannel.Result result) {
        this.f7901ad = ppp;
        this.f7902th = uri;
        this.f7903yj = result;
    }

    public final void run() {
        ppp.rg(this.f7901ad, this.f7902th, this.f7903yj);
    }
}
