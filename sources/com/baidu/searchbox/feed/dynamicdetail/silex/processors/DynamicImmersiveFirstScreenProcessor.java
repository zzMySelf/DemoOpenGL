package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.lcp.sdk.action.BehaviorConstant;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.dynamicdetail.ubc.firstscreen.FirstScreenImagesLoadCheckUtil;
import com.baidu.searchbox.feed.dynamicdetail.ubc.firstscreen.FirstScreenPerformanceHelper;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnDestroyViewAction;
import com.baidu.searchbox.feed.listpage.domain.DisplayList;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.silex.actions.TemplateShowAction;
import com.baidu.searchbox.feed.silex.refresh.action.ServerFeedsResultAction;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0003J$\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u001c\u0010 \u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010!\u001a\u00020\u00142\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040#H\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\u0018\u0010&\u001a\u00020\u00142\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0(H\u0002J\b\u0010)\u001a\u00020\u0014H\u0003J\b\u0010*\u001a\u00020\u0014H\u0003J\u0012\u0010+\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010,H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFirstScreenProcessor;", "Lcom/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveFlowProcessor;", "()V", "PLACE_HOLDER_BAR_HEIGHT", "", "firstScreenTplTotalHeight", "netDataArray", "Lorg/json/JSONArray;", "netDataSampleDataImageSet", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "netImagesLoadCheckUtil", "Lcom/baidu/searchbox/feed/dynamicdetail/ubc/firstscreen/FirstScreenImagesLoadCheckUtil;", "preFetchTplShow", "", "prefetchDataFullScreen", "prefetchImagesLoadCheckUtil", "visibleZoomHeight", "handleFeedsFromServer", "", "action", "Lcom/baidu/searchbox/feed/silex/refresh/action/ServerFeedsResultAction;", "handleFirstScreenStatics", "view", "Landroid/view/View;", "feed", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "position", "handleNetDataStatics", "handleNetFirstScreenEndP", "handleNetFirstScreenFirstP", "handlePrefetchDataStatics", "handlePrefetchFirstScreenEndP", "prefetchSample", "", "hasFlowPrefetch", "initNetFirstScreenP", "initPrefetchFirstScreenP", "feedList", "", "onCreateView", "onDestroy", "onTemplateShow", "Lcom/baidu/searchbox/feed/silex/actions/TemplateShowAction;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveFirstScreenProcessor.kt */
public final class DynamicImmersiveFirstScreenProcessor extends DynamicImmersiveFlowProcessor {
    private int PLACE_HOLDER_BAR_HEIGHT = DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 38.0f);
    private int firstScreenTplTotalHeight;
    private JSONArray netDataArray = new JSONArray();
    private final HashMap<String, Integer> netDataSampleDataImageSet = new HashMap<>(3);
    private FirstScreenImagesLoadCheckUtil netImagesLoadCheckUtil = new FirstScreenImagesLoadCheckUtil();
    private boolean preFetchTplShow;
    private boolean prefetchDataFullScreen;
    private FirstScreenImagesLoadCheckUtil prefetchImagesLoadCheckUtil = new FirstScreenImagesLoadCheckUtil();
    private int visibleZoomHeight;

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateView();
            return onProcess;
        } else if (action instanceof TemplateShowAction) {
            onTemplateShow((TemplateShowAction) action);
            return onProcess;
        } else if (action instanceof ServerFeedsResultAction) {
            handleFeedsFromServer((ServerFeedsResultAction) action);
            return onProcess;
        } else {
            if (z && Actions.ACTION_ON_DESTROY.equals(((TypedAction) action).type)) {
                onDestroy();
            }
            return onProcess;
        }
    }

    private final boolean hasFlowPrefetch() {
        Map<String, Object> userData = getUserData();
        Object obj = null;
        if (!((userData != null ? userData.get("hasFlowPrefetch") : null) instanceof Boolean)) {
            return false;
        }
        Map<String, Object> userData2 = getUserData();
        if (userData2 != null) {
            obj = userData2.get("hasFlowPrefetch");
        }
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @OnCreateViewAction
    private final void onCreateView() {
        DisplayList displayList;
        List it;
        if (hasFlowPrefetch() && (displayList = getDisplayList()) != null && (it = displayList.getCachedFeeds()) != null) {
            initPrefetchFirstScreenP(it);
        }
    }

    private final void initPrefetchFirstScreenP(List<? extends FeedBaseModel> feedList) {
        if (!feedList.isEmpty()) {
            HashMap prefetchSample = new HashMap(3);
            int imageCount = 0;
            FeedBaseModel feed = (FeedBaseModel) feedList.get(0);
            if (feed != null) {
                List imgList = feed.getHelper().collectImageUrls();
                if (imgList != null) {
                    imageCount = imgList.size();
                }
                if (imageCount > 0) {
                    String str = feed.id;
                    Intrinsics.checkNotNullExpressionValue(str, "feed.id");
                    prefetchSample.put(str, Integer.valueOf(imageCount));
                }
            }
            if (!prefetchSample.isEmpty()) {
                this.prefetchImagesLoadCheckUtil.initImageLoadedMonitor(getChannelId(), new DynamicImmersiveFirstScreenProcessor$initPrefetchFirstScreenP$2(this, prefetchSample));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handlePrefetchFirstScreenEndP(Map<String, Integer> prefetchSample) {
        FirstScreenPerformanceHelper.get().addEvent("P4");
        if (this.prefetchDataFullScreen) {
            JSONArray prefetchArray = new JSONArray();
            for (Map.Entry it : prefetchSample.entrySet()) {
                JSONObject item = new JSONObject();
                item.put("id", it.getKey());
                item.put("imageCount", ((Number) it.getValue()).intValue());
                prefetchArray.put(item);
            }
            JSONObject event11Info = new JSONObject();
            try {
                event11Info.put("type", FirstScreenPerformanceHelper.TYPE_PREFETCH_SUCCESS_FULL);
                event11Info.put("items", prefetchArray);
            } catch (JSONException e2) {
            }
            FirstScreenPerformanceHelper.get().addEvent(BehaviorConstant.P11, event11Info.toString()).end();
        }
    }

    private final void onTemplateShow(TemplateShowAction action) {
        if (action != null) {
            TemplateShowAction it = action;
            if (action.itemData != null && !DynamicUtilsKt.isSpecialTpl(action.itemData) && FirstScreenPerformanceHelper.get().isActive() && it.itemPosition <= 4) {
                handleFirstScreenStatics(it.itemView, it.itemData, it.itemPosition);
            }
        }
    }

    private final void handleFirstScreenStatics(View view2, FeedBaseModel feed, int position) {
        DynamicUtilsKt.dynamicOnLineLog("FirstScreenStatistics", "是否预取成功: " + hasFlowPrefetch() + ",index: " + position + ",预取模板是否已展现：" + this.preFetchTplShow);
        int height = getPage().getAnchorView().getHeight() - this.PLACE_HOLDER_BAR_HEIGHT;
        this.visibleZoomHeight = height;
        if (height > 0) {
            if (hasFlowPrefetch() && position == 0 && !this.preFetchTplShow) {
                this.preFetchTplShow = true;
                handlePrefetchDataStatics(view2, feed);
            } else if (!hasFlowPrefetch() || (hasFlowPrefetch() && this.preFetchTplShow)) {
                handleNetDataStatics(view2, feed);
            }
        }
    }

    private final void handlePrefetchDataStatics(View view2, FeedBaseModel feed) {
        FirstScreenPerformanceHelper.get().addEvent("P3");
        HashMap prefetchSample = new HashMap(3);
        int imageCount = 0;
        this.prefetchDataFullScreen = (view2 != null ? view2.getHeight() : 0) >= this.visibleZoomHeight;
        if (feed != null) {
            FeedBaseModel feedBaseModel = feed;
            List imgList = feed.getHelper().collectImageUrls();
            if (imgList != null) {
                imageCount = imgList.size();
            }
            if (imageCount > 0) {
                String str = feed.id;
                Intrinsics.checkNotNullExpressionValue(str, "feed.id");
                prefetchSample.put(str, Integer.valueOf(imageCount));
                if (!this.prefetchImagesLoadCheckUtil.checkSampleDataAllImgLoaded(prefetchSample)) {
                    this.prefetchImagesLoadCheckUtil.setSampleDataImagesCollection(prefetchSample);
                }
            } else if (this.prefetchDataFullScreen) {
                FirstScreenPerformanceHelper.get().addEvent("P4");
                JSONObject event11Info = new JSONObject();
                try {
                    event11Info.put("type", FirstScreenPerformanceHelper.TYPE_PREFETCH_SUCCESS_FULL);
                    event11Info.put("items", new JSONArray());
                } catch (JSONException e2) {
                }
                FirstScreenPerformanceHelper.get().addEvent(BehaviorConstant.P11, event11Info.toString()).end();
            }
        }
    }

    private final void handleNetDataStatics(View view2, FeedBaseModel feed) {
        if (view2 != null && feed != null) {
            int height = this.firstScreenTplTotalHeight + view2.getHeight();
            this.firstScreenTplTotalHeight = height;
            int i2 = 0;
            if (height < this.visibleZoomHeight) {
                List imgList = feed.getHelper().collectImageUrls();
                if (imgList != null) {
                    i2 = imgList.size();
                }
                int imageCount = i2;
                String str = feed.id;
                Intrinsics.checkNotNullExpressionValue(str, "feed.id");
                this.netDataSampleDataImageSet.put(str, Integer.valueOf(imageCount));
                JSONObject item = new JSONObject();
                item.put("id", feed.id);
                item.put("imageCount", imageCount);
                this.netDataArray.put(item);
                return;
            }
            FirstScreenPerformanceHelper.get().addEvent(BehaviorConstant.P8);
            List imgList2 = feed.getHelper().collectImageUrls();
            if (imgList2 != null) {
                i2 = imgList2.size();
            }
            int imageCount2 = i2;
            String str2 = feed.id;
            Intrinsics.checkNotNullExpressionValue(str2, "feed.id");
            this.netDataSampleDataImageSet.put(str2, Integer.valueOf(imageCount2));
            JSONObject item2 = new JSONObject();
            item2.put("id", feed.id);
            item2.put("imageCount", imageCount2);
            this.netDataArray.put(item2);
            if (this.netDataSampleDataImageSet.isEmpty()) {
                handleNetFirstScreenFirstP();
                handleNetFirstScreenEndP();
                return;
            }
            this.netImagesLoadCheckUtil.checkSampleDataFirstImgLoaded(this.netDataSampleDataImageSet);
            if (!this.netImagesLoadCheckUtil.checkSampleDataAllImgLoaded(this.netDataSampleDataImageSet)) {
                this.netImagesLoadCheckUtil.setSampleDataImagesCollection(this.netDataSampleDataImageSet);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleNetFirstScreenFirstP() {
        FirstScreenPerformanceHelper.get().addEvent(BehaviorConstant.P9);
    }

    /* access modifiers changed from: private */
    public final void handleNetFirstScreenEndP() {
        String str;
        String type = FirstScreenPerformanceHelper.TYPE_PREFETCH_FAIL;
        if (hasFlowPrefetch()) {
            if (this.prefetchDataFullScreen) {
                str = FirstScreenPerformanceHelper.TYPE_PREFETCH_SUCCESS_FULL;
            } else {
                str = FirstScreenPerformanceHelper.TYPE_PREFETCH_SUCCESS_HALF;
            }
            type = str;
        }
        FirstScreenPerformanceHelper.get().addEvent("P10");
        JSONObject event11Info = new JSONObject();
        try {
            event11Info.put("type", type);
            event11Info.put("items", this.netDataArray);
        } catch (JSONException e2) {
        }
        FirstScreenPerformanceHelper.get().addEvent(BehaviorConstant.P11, event11Info.toString()).end();
    }

    private final void initNetFirstScreenP() {
        if (FirstScreenPerformanceHelper.get().isActive()) {
            this.netImagesLoadCheckUtil.initImageLoadedMonitor(getChannelId(), new DynamicImmersiveFirstScreenProcessor$initNetFirstScreenP$1(this));
        }
    }

    private final void handleFeedsFromServer(ServerFeedsResultAction action) {
        if (action != null) {
            ServerFeedsResultAction it = action;
            if (it.isSuccess() && Intrinsics.areEqual((Object) it.getType(), (Object) "pull")) {
                FirstScreenPerformanceHelper.get().addEvent("P7");
                initNetFirstScreenP();
            }
        }
    }

    @OnDestroyViewAction
    private final void onDestroy() {
        FirstScreenPerformanceHelper.get().cancel();
    }
}
