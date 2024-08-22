package com.baidu.searchbox.video.feedflow.ad.eshop.floatwindow;

import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.router.AdRouterAction;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/eshop/floatwindow/EcommerceFloatPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "onAttachToManager", "", "onCreate", "onDestroy", "onResume", "sendCloseScheme", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EcommerceFloatPlugin.kt */
public final class EcommerceFloatPlugin extends LiveDataPlugin {
    public void onAttachToManager() {
        EcommerceFloatState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d1 = (EcommerceFloatState) $this$subscribe$iv.subscribe(EcommerceFloatState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d1.getBackFromAutoModeFloating().observe(this, new EcommerceFloatPlugin$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5555onAttachToManager$lambda1$lambda0(EcommerceFloatPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCloseScheme();
    }

    private final void sendCloseScheme() {
        JSONObject paramsJo = new JSONObject();
        paramsJo.put("page_type", "closeDetail");
        StringBuilder strBuilder = new StringBuilder().append("baiduboxapp://goods/enterDetail?params=").append(URLEncoder.encode(paramsJo.toString(), "utf-8"));
        Store<AbsState> store = getStore();
        if (store != null) {
            String sb = strBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "strBuilder.toString()");
            StoreExtKt.post(store, new AdRouterAction(sb, false, 2, (DefaultConstructorMarker) null));
        }
    }

    public void onCreate() {
        super.onCreate();
        AdRuntimeHolder.getEcommerceFloat().setManager(getManager());
    }

    public void onResume() {
        super.onResume();
        AdRuntimeHolder.getEcommerceFloat().setManager(getManager());
    }

    public void onDestroy() {
        AdRuntimeHolder.getEcommerceFloat().removeManager();
        super.onDestroy();
    }
}
