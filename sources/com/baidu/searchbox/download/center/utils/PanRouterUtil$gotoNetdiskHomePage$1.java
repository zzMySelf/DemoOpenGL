package com.baidu.searchbox.download.center.utils;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.containers.nps.netdisk.face.INetdiskPluginFace;
import com.baidu.searchbox.containers.nps.netdisk.face.NetdiskInvokeExtInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "callbackContext", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PanRouterUtil.kt */
final class PanRouterUtil$gotoNetdiskHomePage$1 extends Lambda implements Function1<Context, Unit> {
    final /* synthetic */ String $downgradeScheme;
    final /* synthetic */ boolean $isFold;
    final /* synthetic */ String $tab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PanRouterUtil$gotoNetdiskHomePage$1(String str, boolean z, String str2) {
        super(1);
        this.$downgradeScheme = str;
        this.$isFold = z;
        this.$tab = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Context) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Context callbackContext) {
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        Object service = ServiceManager.getService(INetdiskPluginFace.Companion.getSERVICE_REFERENCE());
        INetdiskPluginFace netdiskFace = service instanceof INetdiskPluginFace ? (INetdiskPluginFace) service : null;
        NetdiskInvokeExtInfo extInfo = new NetdiskInvokeExtInfo("file", this.$downgradeScheme);
        if (netdiskFace != null) {
            netdiskFace.gotoHomePage(callbackContext, this.$isFold, this.$tab, extInfo, (Function3<? super Boolean, ? super Integer, ? super String, Unit>) null);
        }
    }
}
