package com.baidu.searchbox.video.feedflow.flow.collection.backguide;

import com.baidu.searchbox.feed.biserialdetail.ubc.DynamicDetailStatisticsHelperKt;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBC6037;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/backguide/CollectionBackGuideStatisticMiddleWare;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getSpecialExt", "Lorg/json/JSONObject;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionBackGuideStatisticMiddleWare.kt */
public final class CollectionBackGuideStatisticMiddleWare implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        boolean z = true;
        Boolean bool = null;
        if (action2 instanceof OnCollectionBackGuideShow) {
            String value = ((OnCollectionBackGuideShow) action2).getValue();
            if (value != null) {
                if (value.length() <= 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
            if (BdPlayerUtils.orFalse(bool)) {
                VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "show", ((OnCollectionBackGuideShow) action2).getValue(), (String) null, (String) null, "feed_video_landing", getSpecialExt(), (ItemModel) null, false, UBCManifestKt.UBC_ID_6233, 408, (Object) null);
            }
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "show", UBC6037.Value.VALUE_COLLECTION_RETURN_BACK, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, "6037", 504, (Object) null);
        } else if (action2 instanceof OnCollectionBackGuideClick) {
            String value2 = ((OnCollectionBackGuideClick) action2).getValue();
            if (value2 != null) {
                if (value2.length() <= 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
            if (BdPlayerUtils.orFalse(bool)) {
                VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "click", ((OnCollectionBackGuideClick) action2).getValue(), (String) null, (String) null, "feed_video_landing", getSpecialExt(), (ItemModel) null, false, UBCManifestKt.UBC_ID_6233, 408, (Object) null);
            }
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "click", UBC6037.Value.VALUE_COLLECTION_RETURN_BACK, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, "6037", 504, (Object) null);
        }
        return next2.next(store2, action2);
    }

    private final JSONObject getSpecialExt() {
        try {
            JSONObject $this$getSpecialExt_u24lambda_u2d0 = new JSONObject();
            $this$getSpecialExt_u24lambda_u2d0.putOpt(DynamicDetailStatisticsHelperKt.UBC_VALUE_JUMP_TYPE, "finish");
            return $this$getSpecialExt_u24lambda_u2d0;
        } catch (Exception e2) {
            return new JSONObject();
        }
    }
}
