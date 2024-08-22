package fe.mmm.qw.p024if.pf.rg;

import android.net.Uri;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.Callable;

/* renamed from: fe.mmm.qw.if.pf.rg.o  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class o implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Cswitch f7888ad;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7889i;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7890o;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Uri f7891th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ Integer f7892uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ Integer f7893yj;

    public /* synthetic */ o(Cswitch switchR, Uri uri, Integer num, Integer num2, boolean z, MethodChannel.Result result) {
        this.f7888ad = switchR;
        this.f7891th = uri;
        this.f7893yj = num;
        this.f7892uk = num2;
        this.f7889i = z;
        this.f7890o = result;
    }

    public final Object call() {
        return Cswitch.ad(this.f7888ad, this.f7891th, this.f7893yj, this.f7892uk, this.f7889i, this.f7890o);
    }
}
