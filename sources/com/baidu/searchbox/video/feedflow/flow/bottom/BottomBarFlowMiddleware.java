package com.baidu.searchbox.video.feedflow.flow.bottom;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.DetailModelDispatchSuccess;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageOpenAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarCommentClickedAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarEmojiClickedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.ChangeLongPressMoreBarrageSwitchAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAIPlayClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAutoPlayChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.more.AutoplayNextBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.MoreClickAction;
import com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnLandCommentEmojiClick;
import com.baidu.searchbox.video.feedflow.detail.player.OnLandCommentInputClick;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanAIPlayClicked;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanAutoplayClicked;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged;
import com.baidu.searchbox.video.feedflow.detail.relatedsearch.RelatedSearchPanelAction;
import com.baidu.searchbox.video.feedflow.detail.search.TopBarSearchClickedAction;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnOutSideStartAutoPlay;
import com.baidu.searchbox.video.feedflow.detail.seekbar.SeekBarAwakeAction;
import com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarStart;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsAIPlayClickedAction;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsAutoPlayChangedAction;
import com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorksStatusChange;
import com.baidu.searchbox.video.feedflow.flow.list.ActivityAnimation;
import com.baidu.searchbox.video.feedflow.flow.list.DispatchTouchUpEvent;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/bottom/BottomBarFlowMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarFlowMiddleware.kt */
public final class BottomBarFlowMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        MutableLiveData<BottomBarModel> data;
        BottomBarModel $this$apply_u24lambda_u2d1;
        MutableLiveData<BottomBarModel> data2;
        BottomBarModel $this$apply_u24lambda_u2d0;
        RunTimeStatus runTimeStatus;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof AutoplayNextBtnClick) {
            StoreExtKt.post(store, new AutoPlaySwitchStateChange());
        } else {
            if (action instanceof OnVulcanAutoplayClicked ? true : action instanceof LongPressMoreAutoPlayChangedAction ? true : action instanceof VideoSettingsAutoPlayChangedAction) {
                StoreExtKt.post(store, new AutoPlaySwitchStateChange());
            } else if (action instanceof OnVulcanAIPlayClicked) {
                StoreExtKt.post(store, new AIPlaySwitchStateChange(((OnVulcanAIPlayClicked) action).getPlayMode()));
            } else if (action instanceof LongPressMoreAIPlayClickAction) {
                StoreExtKt.post(store, new AIPlaySwitchStateChange(((LongPressMoreAIPlayClickAction) action).getPlayMode()));
            } else if (action instanceof VideoSettingsAIPlayClickedAction) {
                StoreExtKt.post(store, new AIPlaySwitchStateChange(((VideoSettingsAIPlayClickedAction) action).getPlayMode()));
            } else if (action instanceof OnOutSideStartAutoPlay) {
                StoreExtKt.post(store, new AutoPlaySwitchStateChange());
            } else {
                Object obj = null;
                if (action instanceof DetailModelDispatchSuccess) {
                    CommonState state = store.getState();
                    CommonState commonState = state instanceof CommonState ? state : null;
                    if (commonState != null) {
                        obj = commonState.select(ItemModel.class);
                    }
                    ItemModel itemModel = (ItemModel) obj;
                    if (((itemModel == null || (runTimeStatus = itemModel.getRunTimeStatus()) == null) ? -1 : runTimeStatus.getPosition()) + 1 == ((DetailModelDispatchSuccess) action).getPosition()) {
                        store.dispatch(NextDetailModelDispatchSuccess.INSTANCE);
                    }
                } else if (action instanceof ScrollStateChanged) {
                    if (((ScrollStateChanged) action).getScrollState() == 1) {
                        StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                    }
                } else if (action instanceof PlayerOrientationChanged) {
                    if (((PlayerOrientationChanged) action).isFullScreen()) {
                        StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                    }
                } else if (action instanceof ActivityAnimation.DragBegin) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof LeftSlideAction.DrawerBeginAction) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof UserDragSeekBarStart) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof LongPressSpeedAnim) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof NextBigCardAction.NextBigCardPanelShowOrHide) {
                    if (((NextBigCardAction.NextBigCardPanelShowOrHide) action).isShow()) {
                        StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                    }
                } else if (action instanceof RelatedSearchPanelAction.ShowRelatedSearchPanelAction) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof MoreClickAction) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof TopBarSearchClickedAction) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof InvokeHideAutoPlayBottomGuide) {
                    StoreExtKt.post(store, new ShowOrHideAutoPlaySwitchGuide(false));
                } else if (action instanceof BottomBarCommentClickedAction) {
                    StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                } else if (action instanceof OnAuthorWorksStatusChange) {
                    if (!Intrinsics.areEqual((Object) ((OnAuthorWorksStatusChange) action).getStatus(), (Object) AuthorWorkStatus.Close.INSTANCE)) {
                        StoreExtKt.post(store, HideGuideByOpt.INSTANCE);
                    }
                } else if (action instanceof BarrageOpenAction) {
                    if (CommonStateExtKt.isActive(store)) {
                        StoreExtKt.post(store, new HotCommentBtnClickAction(((BarrageOpenAction) action).getOpen(), false, 2, (DefaultConstructorMarker) null));
                    }
                } else if (action instanceof DispatchTouchUpEvent) {
                    StoreExtKt.post(store, new RemoveEmojiAction());
                } else if (action instanceof ChangeLongPressMoreBarrageSwitchAction) {
                    if (CommonStateExtKt.isActive(store)) {
                        StoreExtKt.post(store, new HotCommentBtnClickAction(((ChangeLongPressMoreBarrageSwitchAction) action).getChecked(), false, 2, (DefaultConstructorMarker) null));
                    }
                } else if (action instanceof SeekBarAwakeAction) {
                    StoreExtKt.post(store, new RemoveLongClickAction());
                } else if (action instanceof OnLandCommentInputClick) {
                    CommonState state2 = store.getState();
                    CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
                    if (commonState2 != null) {
                        obj = commonState2.select(BottomBarState.class);
                    }
                    BottomBarState bottomBarState = (BottomBarState) obj;
                    if (!(bottomBarState == null || (data2 = bottomBarState.getData()) == null || ($this$apply_u24lambda_u2d0 = data2.getValue()) == null)) {
                        store.dispatch(new BottomBarCommentClickedAction($this$apply_u24lambda_u2d0, false, false, 1, false, 16, (DefaultConstructorMarker) null));
                    }
                } else if (action instanceof OnLandCommentEmojiClick) {
                    CommonState state3 = store.getState();
                    CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
                    if (commonState3 != null) {
                        obj = commonState3.select(BottomBarState.class);
                    }
                    BottomBarState bottomBarState2 = (BottomBarState) obj;
                    if (!(bottomBarState2 == null || (data = bottomBarState2.getData()) == null || ($this$apply_u24lambda_u2d1 = data.getValue()) == null)) {
                        store.dispatch(new BottomBarEmojiClickedAction($this$apply_u24lambda_u2d1));
                    }
                }
            }
        }
        return next.next(store, action);
    }
}
