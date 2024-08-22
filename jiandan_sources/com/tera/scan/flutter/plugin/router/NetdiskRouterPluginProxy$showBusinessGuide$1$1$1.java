package com.tera.scan.flutter.plugin.router;

import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/tera/scan/flutter/plugin/router/NetdiskRouterPluginProxy$showBusinessGuide$1$1$1", "Lcom/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog$VipRightsIntroduceCallback;", "replied", "", "getReplied", "()Z", "setReplied", "(Z)V", "callback", "", "res", "", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetdiskRouterPluginProxy$showBusinessGuide$1$1$1 implements VipRightsIntroduceDialog.VipRightsIntroduceCallback {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<VipRightsIntroduceDialog> f6942ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f6943de;
    public boolean qw;

    public NetdiskRouterPluginProxy$showBusinessGuide$1$1$1(Ref.ObjectRef<VipRightsIntroduceDialog> objectRef, MethodChannel.Result result) {
        this.f6942ad = objectRef;
        this.f6943de = result;
    }

    public void qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "res");
        VipRightsIntroduceDialog vipRightsIntroduceDialog = (VipRightsIntroduceDialog) this.f6942ad.element;
        if (vipRightsIntroduceDialog != null) {
            vipRightsIntroduceDialog.de((VipRightsIntroduceDialog.VipRightsIntroduceCallback) null);
        }
        this.f6942ad.element = null;
        if (!this.qw) {
            this.qw = true;
            if (Intrinsics.areEqual((Object) "1", (Object) str)) {
                TradeAccount.f913rg.ppp(new NetdiskRouterPluginProxy$showBusinessGuide$1$1$1$callback$1(this.f6943de, str));
            } else {
                this.f6943de.success(str);
            }
        }
    }
}
