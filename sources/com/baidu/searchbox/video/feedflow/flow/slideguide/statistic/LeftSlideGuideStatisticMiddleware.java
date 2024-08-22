package com.baidu.searchbox.video.feedflow.flow.slideguide.statistic;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideBeginAction;
import com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideShowOrHideAction;
import com.baidu.searchbox.video.feedflow.ubc.UBC6304;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/slideguide/statistic/LeftSlideGuideStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getSpecialExt", "Lorg/json/JSONObject;", "guideShowing", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlideGuideStatisticMiddleware.kt */
public final class LeftSlideGuideStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof LeftSlideGuideShowOrHideAction) {
            if (((LeftSlideGuideShowOrHideAction) action2).isShow()) {
                VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "show", UBC6304.Value.HOMEPAGE_GESTURE_GUIDE, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, UBCManifestKt.UBC_ID_6304, 504, (Object) null);
            }
        } else if (action2 instanceof LeftSlideBeginAction) {
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "slide", "homepage", (String) null, (String) null, (String) null, getSpecialExt(((LeftSlideBeginAction) action2).isGuideShowing()), (ItemModel) null, false, UBCManifestKt.UBC_ID_6304, 440, (Object) null);
        }
        return next2.next(store2, action2);
    }

    private final JSONObject getSpecialExt(boolean guideShowing) {
        if (!guideShowing) {
            return null;
        }
        try {
            JSONObject $this$getSpecialExt_u24lambda_u2d0 = new JSONObject();
            $this$getSpecialExt_u24lambda_u2d0.putOpt(UBC6304.Value.PRESS_GUIDE_VALUE, "1");
            return $this$getSpecialExt_u24lambda_u2d0;
        } catch (Exception e2) {
            JSONObject jSONObject = null;
            return null;
        }
    }
}
