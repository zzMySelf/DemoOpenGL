package com.baidu.searchbox.video.feedflow.detail.relatedpreview;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.control.RelatedPreviewConfigController;
import com.baidu.searchbox.video.feedflow.view.FolderTextViewContainerKt;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0001\u001a\u001e\u0010\r\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u0001\u001a&\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u001a&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"FLOW_VIDEO_RELATED_PREVIEW_FROM_KEY", "", "FLOW_VIDEO_RELATED_PREVIEW_PAGE_KEY", "ONE_DAY", "", "SHOW_TYPE_LIKE", "SHOW_TYPE_PREV", "canShowBelongFromAndPage", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "sourcePage", "canShowBelongPd", "pdString", "canShowInDefaultCounts", "defaultCount", "configController", "Lcom/baidu/searchbox/video/feedflow/detail/relatedpreview/control/RelatedPreviewConfigController;", "canShowInDefaultDays", "defaultDay", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedPreviewState.kt */
public final class RelatedPreviewStateKt {
    private static final String FLOW_VIDEO_RELATED_PREVIEW_FROM_KEY = "from";
    private static final String FLOW_VIDEO_RELATED_PREVIEW_PAGE_KEY = "page";
    private static final int ONE_DAY = 86400000;
    public static final String SHOW_TYPE_LIKE = "3";
    public static final String SHOW_TYPE_PREV = "2";

    public static final boolean canShowBelongFromAndPage(Store<AbsState> store, String sourcePage) {
        IntentData intentData;
        Intrinsics.checkNotNullParameter(sourcePage, FolderTextViewContainerKt.TYPE_SOUCE_PAGE);
        try {
            JSONArray $this$canShowBelongFromAndPage_u24lambda_u2d0 = new JSONArray(sourcePage);
            int length = $this$canShowBelongFromAndPage_u24lambda_u2d0.length();
            for (int index = 0; index < length; index++) {
                String str = null;
                if (store != null) {
                    AbsState state = store.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
                } else {
                    intentData = null;
                }
                IntentData data = intentData;
                JSONObject item = $this$canShowBelongFromAndPage_u24lambda_u2d0.optJSONObject(index);
                String from = item.optString("from");
                String page = item.optString("page");
                if (Intrinsics.areEqual((Object) from, (Object) data != null ? data.from : null)) {
                    if (data != null) {
                        str = data.page;
                    }
                    if (Intrinsics.areEqual((Object) page, (Object) str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (JSONException e2) {
            return false;
        }
    }

    public static final boolean canShowBelongPd(Store<AbsState> store, String pdString) {
        Intrinsics.checkNotNullParameter(pdString, "pdString");
        String pd = null;
        if (store != null) {
            AbsState state = store.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
            if (intentData != null) {
                pd = intentData.pd;
            }
        }
        if (pd == null) {
            pd = "";
        }
        try {
            JSONArray $this$canShowBelongPd_u24lambda_u2d1 = new JSONArray(pdString);
            int length = $this$canShowBelongPd_u24lambda_u2d1.length();
            for (int index = 0; index < length; index++) {
                if (Intrinsics.areEqual((Object) $this$canShowBelongPd_u24lambda_u2d1.optString(index), (Object) pd)) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e2) {
            return true;
        }
    }

    public static final boolean canShowInDefaultDays(int defaultDay, RelatedPreviewConfigController configController, Store<AbsState> store) {
        Intrinsics.checkNotNullParameter(configController, "configController");
        long firstTime = configController.getShowFirstTime(store);
        if (defaultDay <= 0) {
            return false;
        }
        if ((System.currentTimeMillis() - firstTime) - ((long) (86400000 * defaultDay)) <= 0) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        configController.recordShowFirstTime(store, calendar.getTimeInMillis());
        configController.resetShownCount(store);
        return true;
    }

    public static final boolean canShowInDefaultCounts(int defaultCount, RelatedPreviewConfigController configController, Store<AbsState> store) {
        Intrinsics.checkNotNullParameter(configController, "configController");
        if (configController.getShownCount(store) < defaultCount) {
            return true;
        }
        return false;
    }
}
