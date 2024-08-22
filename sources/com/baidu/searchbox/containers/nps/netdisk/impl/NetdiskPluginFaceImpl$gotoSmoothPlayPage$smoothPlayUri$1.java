package com.baidu.searchbox.containers.nps.netdisk.impl;

import android.net.Uri;
import com.baidu.searchbox.containers.nps.netdisk.face.NetdiskInvokeExtInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uriBuilder", "Landroid/net/Uri$Builder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetdiskPluginFaceImpl.kt */
final class NetdiskPluginFaceImpl$gotoSmoothPlayPage$smoothPlayUri$1 extends Lambda implements Function1<Uri.Builder, Unit> {
    final /* synthetic */ NetdiskInvokeExtInfo $extInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetdiskPluginFaceImpl$gotoSmoothPlayPage$smoothPlayUri$1(NetdiskInvokeExtInfo netdiskInvokeExtInfo) {
        super(1);
        this.$extInfo = netdiskInvokeExtInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Uri.Builder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Uri.Builder uriBuilder) {
        Intrinsics.checkNotNullParameter(uriBuilder, "uriBuilder");
        uriBuilder.scheme("bdnetdisksdk");
        uriBuilder.authority("n");
        uriBuilder.appendPath("action.filelist");
        uriBuilder.appendQueryParameter("path", "/来自：流畅播视频");
        String ubcSource = this.$extInfo.getUbcSource();
        if (!StringsKt.isBlank(ubcSource)) {
            uriBuilder.appendQueryParameter("source", ubcSource);
        }
    }
}
