package com.baidu.searchbox.feed.flow.impl;

import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.controller.FeedSearchPostCardManagerKt;
import com.baidu.searchbox.feed.controller.IFeedSearchPostCardPresenter;
import com.baidu.searchbox.feed.event.ActionClickEvent;
import com.baidu.searchbox.feed.event.FeedToTopEvent;
import com.baidu.searchbox.feed.event.TabStateChangeEvent;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowProcessor;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.annotations.OnCreateViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnDestroyViewAction;
import com.baidu.searchbox.feed.flow.annotations.OnPauseAction;
import com.baidu.searchbox.feed.flow.annotations.OnResumeAction;
import com.baidu.searchbox.feed.model.FeedBackData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedSearchPostCardData;
import com.baidu.searchbox.feed.statistic.DisplayReportUtil;
import com.baidu.searchbox.feed.statistic.FeedDisplayReport;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.widget.searchbackcard.CardShow;
import com.baidu.searchbox.feed.widget.searchbackcard.ClickClose;
import com.baidu.searchbox.feed.widget.searchbackcard.ClickToDetail;
import com.baidu.searchbox.feed.widget.searchbackcard.DismissLayer;
import com.baidu.searchbox.feed.widget.searchbackcard.QueryRecommendEvent;
import com.baidu.searchbox.feed.widget.searchbackcard.QueryRecommendViewPresenter;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.home.feed.CeilingSceneKt;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import com.baidu.texas.context.support.StringId;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0003J\b\u0010\u0012\u001a\u00020\bH\u0003J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\b\u0010\u0019\u001a\u00020\bH\u0003J\b\u0010\u001a\u001a\u00020\bH\u0003J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u001cH\u0003J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/flow/impl/FeedSearchPostSupernatantProcessor;", "Lcom/baidu/searchbox/feed/flow/FlowProcessor;", "()V", "queryRecommendViewPresenter", "Lcom/baidu/searchbox/feed/widget/searchbackcard/QueryRecommendViewPresenter;", "searchPostCardPresenter", "Lcom/baidu/searchbox/feed/controller/IFeedSearchPostCardPresenter;", "afterNotShow", "", "afterNotShowByForceBreak", "handleUiEvent", "cardEvent", "Lcom/baidu/searchbox/feed/widget/searchbackcard/QueryRecommendEvent;", "cardData", "Lcom/baidu/searchbox/feed/model/FeedSearchPostCardData;", "hideSearchPostCard", "hideSearchPostCardByForceBreak", "onCreateViewAction", "onDestroyView", "onExternalRefresh", "action", "Lcom/baidu/searchbox/feed/flow/Actions$ExternalRefreshAction;", "onItemChildViewClick", "childViewClick", "Lcom/baidu/searchbox/feed/flow/Actions$ItemChildViewClickAction;", "onPause", "onResume", "onScrollDraggingState", "Lcom/baidu/searchbox/feed/flow/Actions$ScrollDraggingStateAction;", "popupToMainFeedQueue", "toFeedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedSearchPostSupernatantProcessor.kt */
public final class FeedSearchPostSupernatantProcessor extends FlowProcessor {
    /* access modifiers changed from: private */
    public QueryRecommendViewPresenter queryRecommendViewPresenter;
    /* access modifiers changed from: private */
    public IFeedSearchPostCardPresenter searchPostCardPresenter;

    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (z && Actions.ACTION_ON_CREATE_VIEW.equals(((TypedAction) action).type)) {
            onCreateViewAction();
            return onProcess;
        } else if (z && Actions.ACTION_ON_RESUME.equals(((TypedAction) action).type)) {
            onResume();
            return onProcess;
        } else if (z && Actions.ACTION_ON_PAUSE.equals(((TypedAction) action).type)) {
            onPause();
            return onProcess;
        } else if (z && Actions.ACTION_ON_DESTROY.equals(((TypedAction) action).type)) {
            onDestroyView();
            return onProcess;
        } else if (action instanceof Actions.ExternalRefreshAction) {
            onExternalRefresh((Actions.ExternalRefreshAction) action);
            return onProcess;
        } else if (action instanceof Actions.ItemChildViewClickAction) {
            onItemChildViewClick((Actions.ItemChildViewClickAction) action);
            return onProcess;
        } else {
            if (action instanceof Actions.ScrollDraggingStateAction) {
                onScrollDraggingState((Actions.ScrollDraggingStateAction) action);
            }
            return onProcess;
        }
    }

    @OnCreateViewAction
    private final void onCreateViewAction() {
        BdEventBus.Companion.getDefault().register(this, TabStateChangeEvent.class, 1, new FeedSearchPostSupernatantProcessor$$ExternalSyntheticLambda1(this));
        BdEventBus.Companion.getDefault().register(this, ActionClickEvent.class, 1, new FeedSearchPostSupernatantProcessor$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateViewAction$lambda-0  reason: not valid java name */
    public static final void m18679onCreateViewAction$lambda0(FeedSearchPostSupernatantProcessor this$0, TabStateChangeEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!TextUtils.equals(this$0.getChannelId(), it.tabID) && it.messageId == 1) {
            this$0.hideSearchPostCard();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateViewAction$lambda-1  reason: not valid java name */
    public static final void m18680onCreateViewAction$lambda1(FeedSearchPostSupernatantProcessor this$0, ActionClickEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.id == 3) {
            this$0.hideSearchPostCard();
        }
    }

    @OnResumeAction
    private final void onResume() {
        if (this.searchPostCardPresenter == null) {
            this.searchPostCardPresenter = (IFeedSearchPostCardPresenter) getProcessContext().getUserData(new StringId(FeedSearchPostCardManagerKt.USER_DATA_SEARCH_POST_CARD), IFeedSearchPostCardPresenter.Empty.INSTANCE);
        }
        IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter = this.searchPostCardPresenter;
        FeedSearchPostCardData cardData = iFeedSearchPostCardPresenter != null ? iFeedSearchPostCardPresenter.getCardData() : null;
        IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter2 = this.searchPostCardPresenter;
        if (iFeedSearchPostCardPresenter2 != null) {
            iFeedSearchPostCardPresenter2.abortCardData();
        }
        IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter3 = this.searchPostCardPresenter;
        Intrinsics.checkNotNull(iFeedSearchPostCardPresenter3);
        if (iFeedSearchPostCardPresenter3.isFetchingCardData()) {
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter4 = this.searchPostCardPresenter;
            if (iFeedSearchPostCardPresenter4 != null) {
                iFeedSearchPostCardPresenter4.cancelCardReq();
            }
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter5 = this.searchPostCardPresenter;
            FeedStatisticCenter.searchPostCardAction("5", (String) null, "", iFeedSearchPostCardPresenter5 != null ? iFeedSearchPostCardPresenter5.getExperimentName() : null);
        } else if (cardData != null) {
            FeedSearchPostCardData it = cardData;
            if (!getDataManager().getCPageInsertDataManager().hasInsertData()) {
                popupToMainFeedQueue(it);
                return;
            }
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter6 = this.searchPostCardPresenter;
            if (iFeedSearchPostCardPresenter6 != null) {
                iFeedSearchPostCardPresenter6.clearData();
            }
        }
    }

    @OnPauseAction
    private final void onPause() {
        hideSearchPostCard();
    }

    @OnDestroyViewAction
    private final void onDestroyView() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    private final void onExternalRefresh(Actions.ExternalRefreshAction action) {
        String refreshSrc = action.refreshSrc;
        if (TextUtils.equals("8", refreshSrc) || TextUtils.equals("9", refreshSrc) || TextUtils.equals("10", refreshSrc)) {
            hideSearchPostCard();
        }
    }

    private final void onItemChildViewClick(Actions.ItemChildViewClickAction childViewClick) {
        hideSearchPostCard();
    }

    private final void onScrollDraggingState(Actions.ScrollDraggingStateAction action) {
        hideSearchPostCard();
    }

    private final void hideSearchPostCard() {
        UiThreadUtils.runOnUiThread(new FeedSearchPostSupernatantProcessor$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: hideSearchPostCard$lambda-3  reason: not valid java name */
    public static final void m18677hideSearchPostCard$lambda3(FeedSearchPostSupernatantProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QueryRecommendViewPresenter queryRecommendViewPresenter2 = this$0.queryRecommendViewPresenter;
        if (queryRecommendViewPresenter2 != null) {
            queryRecommendViewPresenter2.hideView(false);
        }
    }

    /* access modifiers changed from: private */
    public final void hideSearchPostCardByForceBreak() {
        UiThreadUtils.runOnUiThread(new FeedSearchPostSupernatantProcessor$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: hideSearchPostCardByForceBreak$lambda-4  reason: not valid java name */
    public static final void m18678hideSearchPostCardByForceBreak$lambda4(FeedSearchPostSupernatantProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QueryRecommendViewPresenter queryRecommendViewPresenter2 = this$0.queryRecommendViewPresenter;
        if (queryRecommendViewPresenter2 != null) {
            queryRecommendViewPresenter2.hideView(true);
        }
    }

    private final void popupToMainFeedQueue(FeedSearchPostCardData cardData) {
        PopupExclusionManagerMap.getInstance().display("scene_home", new FeedSearchPostSupernatantProcessor$popupToMainFeedQueue$1(this, cardData, ExclusionType.HOME_AFTER_SEARCH_CARD));
    }

    /* access modifiers changed from: private */
    public final void handleUiEvent(QueryRecommendEvent cardEvent, FeedSearchPostCardData cardData) {
        String str = null;
        if (Intrinsics.areEqual((Object) cardEvent, (Object) ClickToDetail.INSTANCE)) {
            BdEventBus.Companion.getDefault().post(new FeedToTopEvent(new CeilingScene(CeilingSceneKt.CEILING_SOURCE_SOU_HOU_KA, (String) null, 2, (DefaultConstructorMarker) null)));
            FeedDataReportUtils.reportFeedbackAction(toFeedModel(cardData), (HashMap<String, String>) null, "clk", 0, (List<SubTagItem>) null);
            FeedStatisticCenter.ubcFeedDauAction(CeilingSceneKt.CEILING_SOURCE_SOU_HOU_KA, "");
        } else if (Intrinsics.areEqual((Object) cardEvent, (Object) ClickClose.INSTANCE)) {
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter = this.searchPostCardPresenter;
            if (iFeedSearchPostCardPresenter != null) {
                iFeedSearchPostCardPresenter.onCardCloseClick();
            }
            FeedBackData feedBackData = cardData.feedBackData;
            String str2 = feedBackData != null ? feedBackData.ext : null;
            String str3 = cardData.id;
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter2 = this.searchPostCardPresenter;
            if (iFeedSearchPostCardPresenter2 != null) {
                str = iFeedSearchPostCardPresenter2.getExperimentName();
            }
            FeedStatisticCenter.searchPostCardAction(FeedStatisticConstants.UBC_SEARCH_POST_CARD_TYPE_CLICK_CLOSE_VALUE, str2, str3, str);
        } else if (Intrinsics.areEqual((Object) cardEvent, (Object) DismissLayer.INSTANCE)) {
            afterNotShow();
        } else if (Intrinsics.areEqual((Object) cardEvent, (Object) CardShow.INSTANCE)) {
            IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter3 = this.searchPostCardPresenter;
            if (iFeedSearchPostCardPresenter3 != null) {
                iFeedSearchPostCardPresenter3.onCardShown();
            }
            DisplayReportUtil util = FeedDisplayReport.getUtil(getChannelId());
            String str4 = cardData.id;
            String str5 = cardData.layout;
            FeedBackData feedBackData2 = cardData.feedBackData;
            if (feedBackData2 != null) {
                str = feedBackData2.ext;
            }
            util.reportSpecialCardDisplay(str4, str5, "display", str, "list_page", 0);
        }
    }

    /* access modifiers changed from: private */
    public final void afterNotShow() {
        PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_AFTER_SEARCH_CARD);
        IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter = this.searchPostCardPresenter;
        if (iFeedSearchPostCardPresenter != null) {
            iFeedSearchPostCardPresenter.clearData();
        }
    }

    /* access modifiers changed from: private */
    public final void afterNotShowByForceBreak() {
        IFeedSearchPostCardPresenter iFeedSearchPostCardPresenter = this.searchPostCardPresenter;
        if (iFeedSearchPostCardPresenter != null) {
            iFeedSearchPostCardPresenter.clearData();
        }
    }

    private final FeedBaseModel toFeedModel(FeedSearchPostCardData cardData) {
        FeedBaseModel create = FeedBaseModel.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        FeedBaseModel $this$toFeedModel_u24lambda_u2d5 = create;
        $this$toFeedModel_u24lambda_u2d5.id = cardData.id;
        $this$toFeedModel_u24lambda_u2d5.layout = cardData.layout;
        $this$toFeedModel_u24lambda_u2d5.feedback = cardData.feedBackData;
        $this$toFeedModel_u24lambda_u2d5.runtimeStatus.business = "list_page";
        return create;
    }
}
