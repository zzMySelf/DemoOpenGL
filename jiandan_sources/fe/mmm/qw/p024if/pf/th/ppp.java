package fe.mmm.qw.p024if.pf.th;

import com.tera.scan.flutter.plugin.documenttool.DocumentToolPluginProxy;
import com.tera.scan.model.callback.IImageCropResult;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.Ref;

/* renamed from: fe.mmm.qw.if.pf.th.ppp  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ppp implements IImageCropResult {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f7940ad;
    public final /* synthetic */ Ref.BooleanRef qw;

    public /* synthetic */ ppp(Ref.BooleanRef booleanRef, MethodChannel.Result result) {
        this.qw = booleanRef;
        this.f7940ad = result;
    }

    public final void onResult(String str) {
        DocumentToolPluginProxy.ppp(this.qw, this.f7940ad, str);
    }
}
