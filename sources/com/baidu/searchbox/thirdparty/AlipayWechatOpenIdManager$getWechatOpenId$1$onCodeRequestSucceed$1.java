package com.baidu.searchbox.thirdparty;

import android.app.Activity;
import com.baidu.searchbox.thirdparty.base.IResultListener;
import com.baidu.searchbox.thirdparty.schema.WXOpenidData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "wxOpenidData", "Lcom/baidu/searchbox/thirdparty/schema/WXOpenidData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlipayWechatOpenIdManager.kt */
final class AlipayWechatOpenIdManager$getWechatOpenId$1$onCodeRequestSucceed$1 extends Lambda implements Function1<WXOpenidData, Unit> {
    final /* synthetic */ IResultListener $callback;
    final /* synthetic */ WeakReference<Activity> $ctxRef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlipayWechatOpenIdManager$getWechatOpenId$1$onCodeRequestSucceed$1(WeakReference<Activity> weakReference, IResultListener iResultListener) {
        super(1);
        this.$ctxRef = weakReference;
        this.$callback = iResultListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((WXOpenidData) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(WXOpenidData wxOpenidData) {
        Intrinsics.checkNotNullParameter(wxOpenidData, "wxOpenidData");
        Activity it = (Activity) this.$ctxRef.get();
        if (it != null) {
            AlipayWechatOpenIdManager.INSTANCE.moveTaskToFront(it);
        }
        this.$callback.onSuccess(wxOpenidData.toJson());
    }
}
