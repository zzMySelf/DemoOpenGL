package com.baidu.searchbox.video.collectionflow.action;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.columnpanel.PadColumnPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorRetryAction;
import com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPayPanelBottomClick;
import com.baidu.searchbox.video.feedflow.detail.player.FirstJumpPlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.player.InvokeChangeLoop;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerPause;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResume;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerSendEvent;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelAction;
import com.baidu.searchbox.video.feedflow.detail.search.TopBarSearchClickedAction;
import com.baidu.searchbox.video.feedflow.detail.similarentrance.SimilarCollectionTopAndBottomBarVisibleAction;
import com.baidu.searchbox.video.feedflow.detail.similarentrance.UpdateSimilarCollectionTopTitleInfoAction;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelAction;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction;
import com.baidu.searchbox.video.feedflow.flow.collectionfold.ExpandBaikeClickAction;
import com.baidu.searchbox.video.feedflow.flow.collectionfold.ExpandClickAction;
import com.baidu.searchbox.video.feedflow.flow.collectionfold.ExpandRecommendClickAction;
import com.baidu.searchbox.video.feedflow.flow.collectionfold.UpdateCollectionPanelData;
import com.baidu.searchbox.video.feedflow.flow.list.CollectionFirstScreenDataRefreshedAction;
import com.baidu.searchbox.video.feedflow.flow.list.CollectionSlideStartAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnSimilarCollectionGuideRecoverAction;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/action/CollectionFlowActionInterceptor;", "Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowActionInterceptor.kt */
public class CollectionFlowActionInterceptor extends VideoFlowActionInterceptor {
    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof TopBarSearchClickedAction) && !(action instanceof CollectionPanelAction.TryLoadPageAction) && !(action instanceof ShortPlayPanelAction.TryLoadPageAction) && !(action instanceof CollectionPanelAction.CollectionPanelVisibleChangedAction) && !(action instanceof BaikePanelAction.CollectionPanelVisibleChangedAction) && !(action instanceof ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction) && !(action instanceof PadColumnPanelVisibleChangedAction) && !(action instanceof ExpandClickAction) && !(action instanceof CollectionPanelAction.PayClickAction) && !(action instanceof CollectionPanelAction.Subscribe) && !(action instanceof CollectionPanelAction.GoBookShelf) && !(action instanceof InvokeChangeLoop) && !(action instanceof ExpandRecommendClickAction) && !(action instanceof ExpandBaikeClickAction) && !(action instanceof RecommendContentPanelAction.ShowRecommendPanelAction) && !(action instanceof RecommendContentPanelAction.HideRecommendPanelAction) && !(action instanceof RecommendContentPanelAction.OnPanelStatusChangeAction) && !(action instanceof RecommendContentPanelAction.OnPanelCloseClickAction) && !(action instanceof RecommendContentPanelAction.OnClickNonPanelAreaAction) && !(action instanceof PlayerSendEvent) && !(action instanceof CollectionSlideStartAction) && !(action instanceof CollectionFirstScreenDataRefreshedAction)) {
            return super.accept(action);
        }
        return true;
    }

    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof PlayerComplete) {
            return true;
        }
        if (action instanceof LongPressSpeedAnim) {
            return true;
        }
        if (action instanceof NetErrorRetryAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.ItemClickAction) {
            return true;
        }
        if (action instanceof LandscapeFoldAction.OnViewClick) {
            return true;
        }
        if (action instanceof UpdateCollectionPanelData) {
            return true;
        }
        if (action instanceof CollectionPanelAction.ShowCollectionPanelAction) {
            return true;
        }
        if ((action instanceof CollectionPanelAction.CollectionPanelVisibleChangedAction) || (action instanceof BaikePanelAction.CollectionPanelVisibleChangedAction) || (action instanceof ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction) || (action instanceof PadColumnPanelVisibleChangedAction)) {
            return false;
        }
        if (action instanceof BaikePanelAction.ShowCollectionPanelAction) {
            return true;
        }
        if (action instanceof PlayerPause) {
            return true;
        }
        if (action instanceof PlayerResume) {
            return true;
        }
        if (action instanceof FirstJumpPlayerFirstFrame) {
            return true;
        }
        if ((action instanceof RecommendContentPanelAction.ShowRecommendPanelAction) || (action instanceof RecommendContentPanelAction.HideRecommendPanelAction)) {
            return false;
        }
        if (action instanceof ShortPlayPanelAction.ShortPlayMarkLoginFromFavorAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.CollectionMarkLoginFromFavorAction) {
            return true;
        }
        if (action instanceof SimilarCollectionTopAndBottomBarVisibleAction) {
            return true;
        }
        if (action instanceof UpdateSimilarCollectionTopTitleInfoAction) {
            return true;
        }
        if (action instanceof OnSimilarCollectionGuideRecoverAction) {
            return true;
        }
        if (action instanceof ShortPlayPayPanelBottomClick) {
            return true;
        }
        return super.deliver(action);
    }
}
