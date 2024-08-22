package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.export.IPlayerCommonUrlParamManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.player.barrage.VulcanBarragePraise;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanControlEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/player/plugin/BarragePraisePlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "barragePraiseUrl", "", "getSubscribeEvent", "", "onLayerEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "requestBarragePraise", "praise", "Lcom/baidu/searchbox/player/barrage/VulcanBarragePraise;", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarragePraisePlugin.kt */
public final class BarragePraisePlugin extends AbsPlugin {
    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual((Object) event.getAction(), (Object) VulcanControlEvent.ACTION_VULCAN_BARRAGE_PRAISE)) {
            Object extra = event.getExtra(11);
            if (!(extra instanceof VulcanBarragePraise)) {
                extra = null;
            }
            requestBarragePraise((VulcanBarragePraise) extra);
        }
    }

    private final void requestBarragePraise(VulcanBarragePraise praise) {
        if (praise != null) {
            VulcanBarragePraise vulcanBarragePraise = praise;
            Map postParams = new HashMap();
            try {
                JSONObject data = new JSONObject();
                data.put("topic_id", praise.getTopicId());
                data.put("reply_id", praise.getReplyId());
                data.put("type", "1");
                data.put("from", "1");
                data.put("op_from", "0");
                data.put("source", "");
                if (praise.isSelfPraise()) {
                    data.put("undo_type", "1");
                }
                String jSONObject = data.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
                postParams.put("data", jSONObject);
            } catch (JSONException e2) {
                postParams.put("data", "{}");
            }
            String url = IPlayerCommonUrlParamManager.Impl.get().processUrlByBaiduIdentityManager(barragePraiseUrl());
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (StringsKt.startsWith$default(url, "https://", false, 2, (Object) null)) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(url)).params(postParams)).cookieManager(HttpManager.httpManager.getCookieManager(true, false))).build().executeAsyncOnUIBack((ResponseCallback) null);
            } else {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(url)).params(postParams)).build().executeAsyncOnUIBack((ResponseCallback) null);
            }
        }
    }

    public String barragePraiseUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/searchbox?action=comment&cmd=190", Arrays.copyOf(new Object[]{HostConfig.getSearchboxHostForHttps()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public int[] getSubscribeEvent() {
        return new int[]{3};
    }
}
