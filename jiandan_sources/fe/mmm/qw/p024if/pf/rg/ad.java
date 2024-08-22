package fe.mmm.qw.p024if.pf.rg;

import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* renamed from: fe.mmm.qw.if.pf.rg.ad  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7879ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Map f7880th;

    public /* synthetic */ ad(MethodChannel.Result result, Map map) {
        this.f7879ad = result;
        this.f7880th = map;
    }

    public final void run() {
        Cswitch.de(this.f7879ad, this.f7880th);
    }
}
