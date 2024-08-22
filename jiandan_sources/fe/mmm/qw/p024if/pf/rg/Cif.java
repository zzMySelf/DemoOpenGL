package fe.mmm.qw.p024if.pf.rg;

import android.content.Context;
import android.net.Uri;
import com.tera.scan.flutter.plugin.dbaccess.NetdiskDbAccessPluginProxy;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.Callable;

/* renamed from: fe.mmm.qw.if.pf.rg.if  reason: invalid class name and invalid package */
/* compiled from: lambda */
public final /* synthetic */ class Cif implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Uri f7884ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ MethodCall f7885th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7886uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ Context f7887yj;

    public /* synthetic */ Cif(Uri uri, MethodCall methodCall, Context context, MethodChannel.Result result) {
        this.f7884ad = uri;
        this.f7885th = methodCall;
        this.f7887yj = context;
        this.f7886uk = result;
    }

    public final Object call() {
        return NetdiskDbAccessPluginProxy.o(this.f7884ad, this.f7885th, this.f7887yj, this.f7886uk);
    }
}
