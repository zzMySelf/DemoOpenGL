package fe.mmm.qw.p024if.pf.fe;

import androidx.lifecycle.Observer;
import com.tera.scan.flutter.plugin.commerce.CommerceChannelPluginProxy;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.Ref;

/* renamed from: fe.mmm.qw.if.pf.fe.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f7877ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7878de;
    public final /* synthetic */ Ref.IntRef qw;

    public /* synthetic */ qw(Ref.IntRef intRef, String str, MethodChannel.Result result) {
        this.qw = intRef;
        this.f7877ad = str;
        this.f7878de = result;
    }

    public final void onChanged(Object obj) {
        CommerceChannelPluginProxy.fe(this.qw, this.f7877ad, this.f7878de, (Boolean) obj);
    }
}
