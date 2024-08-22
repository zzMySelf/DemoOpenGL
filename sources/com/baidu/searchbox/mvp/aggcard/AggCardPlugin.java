package com.baidu.searchbox.mvp.aggcard;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J0\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/mvp/aggcard/AggCardPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "headerKey", "", "headerValue", "httpErrorStatusCode", "httpSuccessStatusCode", "", "onAttachToManager", "", "showReport", "id", "scene", "sign", "mark", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AggCardPlugin.kt */
public final class AggCardPlugin extends LiveDataPlugin {
    private final String headerKey = "Content-Type";
    private final String headerValue = "application/x-www-form-urlencoded";
    /* access modifiers changed from: private */
    public final String httpErrorStatusCode = "0";
    /* access modifiers changed from: private */
    public final int httpSuccessStatusCode = 200;

    public void onAttachToManager() {
        AggCardState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d1 = (AggCardState) store.subscribe((Class<T>) AggCardState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d1.getClkReportData().observe(this, new AggCardPlugin$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m1358onAttachToManager$lambda1$lambda0(AggCardPlugin this$0, ClkReportData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showReport(it.getId(), it.getScene(), it.getSign(), it.getMark());
    }

    private final void showReport(String id, String scene, String sign, String mark) {
        String url = UgcServerApiUtils.processCommonParams(UgcServerApiUtils.getAigcHost() + UgcServerApiUtils.PRE_PUBLISH_SHOW_REPORT);
        Map paramsMap = new LinkedHashMap();
        Map $this$showReport_u24lambda_u2d6 = paramsMap;
        if (id != null) {
            String str = (String) $this$showReport_u24lambda_u2d6.put("id", id);
        }
        if (scene != null) {
            String str2 = (String) $this$showReport_u24lambda_u2d6.put("scene", scene);
        }
        if (sign != null) {
            String str3 = (String) $this$showReport_u24lambda_u2d6.put("sign", sign);
        }
        if (mark != null) {
            $this$showReport_u24lambda_u2d6.put(UBC2736.VALUE.VALUE_MARK, mark);
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().addHeader(this.headerKey, this.headerValue)).addParams(paramsMap)).url(url)).enableStat(true)).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(false, false))).build().executeAsync(new AggCardPlugin$showReport$1(this));
    }
}
