package com.tera.scan.vip.ui;

import android.app.Activity;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.IStateCallback;
import fe.mmm.qw.m.Cif;
import fe.mmm.qw.m.th;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tera/scan/webview/BaseWebViewFragment;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipWebActivity$fragment$2 extends Lambda implements Function0<BaseWebViewFragment> {
    public final /* synthetic */ VipWebActivity this$0;

    public static final class qw implements IStateCallback {
        public final /* synthetic */ VipWebActivity qw;

        public qw(VipWebActivity vipWebActivity) {
            this.qw = vipWebActivity;
        }

        public void ad(@Nullable BaseWebViewFragment baseWebViewFragment, boolean z) {
        }

        public void onDestroyView() {
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void qw(@Nullable Activity activity) {
            this.qw.initWebView();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipWebActivity$fragment$2(VipWebActivity vipWebActivity) {
        super(0);
        this.this$0 = vipWebActivity;
    }

    public final BaseWebViewFragment invoke() {
        Cif ifVar = new Cif();
        ifVar.i(new qw(this.this$0));
        ifVar.pf(new th());
        return ifVar.qw();
    }
}
