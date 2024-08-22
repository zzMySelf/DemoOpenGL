package com.baidu.searchbox.video.feedflow.detail.autoplay;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanAutoplayClicked;
import com.baidu.searchbox.video.feedflow.detail.toast.OnTipBtnClickAction;
import com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/autoplay/AutoplayStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "autoplayGuideStatistic", "", "value", "", "autoplaySwitchStatistic", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoplayStatisticMiddleware.kt */
public final class AutoplayStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        String str;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof ShowTipAction) {
            if (Intrinsics.areEqual((Object) ((ShowTipAction) action).getTipKey(), (Object) "autoplay")) {
                autoplayGuideStatistic(store, "show");
            }
        } else if (action instanceof OnTipBtnClickAction) {
            if (Intrinsics.areEqual((Object) ((OnTipBtnClickAction) action).getTipKey(), (Object) "autoplay")) {
                autoplayGuideStatistic(store, "click");
            }
        } else if (action instanceof OnShowAutoPlayTip) {
            if (((OnShowAutoPlayTip) action).getTipsConfig().getGuideStyleType() == 5) {
                autoplayGuideStatistic(store, "show");
            }
        } else if (action instanceof OnVulcanAutoplayClicked) {
            if (((OnVulcanAutoplayClicked) action).isGuideClick()) {
                autoplayGuideStatistic(store, "click");
            } else {
                if (((OnVulcanAutoplayClicked) action).getSwitch()) {
                    str = "on";
                } else {
                    str = "off";
                }
                autoplaySwitchStatistic(store, str);
            }
        }
        return next.next(store, action);
    }

    private final void autoplayGuideStatistic(Store<CommonState> store, String value) {
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), UBC2736.TYPE.TYPE_AUTOPLAY_TOAST, value, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, (String) null, 1016, (Object) null);
    }

    private final void autoplaySwitchStatistic(Store<CommonState> store, String value) {
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "autoPlay", value, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, (String) null, 1016, (Object) null);
    }
}
