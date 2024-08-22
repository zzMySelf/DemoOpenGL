package fe.mmm.qw.m;

import com.tera.scan.webview.ITitleChangeCallBack;
import kotlin.jvm.functions.Function2;

/* compiled from: lambda */
public final /* synthetic */ class de implements ITitleChangeCallBack {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function2 f8021ad;

    public /* synthetic */ de(Function2 function2) {
        this.f8021ad = function2;
    }

    public final void onTitleChange(String str, String str2) {
        yj.th(this.f8021ad, str, str2);
    }
}
