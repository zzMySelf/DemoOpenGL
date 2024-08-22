package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.view.View;
import com.baidu.searchbox.player.control.element.VulcanControlLayerElement;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.toolbar.CommonToolBar;
import com.baidu.searchbox.video.feedflow.detail.player.player.VideoFlowEvent;
import com.baidu.searchbox.video.feedflow.detail.player.player.VideoFlowPlayer;
import com.baidu.searchbox.video.feedflow.flow.bottom.UpdateLandCommentText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/LandCommentElement;", "Lcom/baidu/searchbox/player/control/element/VulcanControlLayerElement;", "()V", "enable", "", "rootView", "Lcom/baidu/searchbox/toolbar/CommonToolBar;", "getRootView", "()Lcom/baidu/searchbox/toolbar/CommonToolBar;", "rootView$delegate", "Lkotlin/Lazy;", "getContentView", "Landroid/view/View;", "getToolBarItemList", "", "Lcom/baidu/searchbox/toolbar/BaseToolBarItem;", "getToolBarMode", "Lcom/baidu/searchbox/toolbar/CommonToolBar$ToolbarMode;", "getVideoPlayer", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/VideoFlowPlayer;", "initElement", "", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onParentVisibleChanged", "visibility", "", "onToolBarItemClick", "toolBarItem", "setCommentEnable", "setDraft", "draft", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/UpdateLandCommentText;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandCommentElement.kt */
public final class LandCommentElement extends VulcanControlLayerElement {
    private boolean enable;
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new LandCommentElement$rootView$2(this));

    private final CommonToolBar getRootView() {
        return (CommonToolBar) this.rootView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean onToolBarItemClick(BaseToolBarItem toolBarItem) {
        switch (toolBarItem.getItemId()) {
            case 10:
                getVideoPlayer().getPlayerCallbackManager().onLandCommentInputClick();
                return true;
            case 21:
                getVideoPlayer().getPlayerCallbackManager().onCommentEmojiClick();
                return true;
            default:
                return true;
        }
    }

    public View getContentView() {
        return getRootView();
    }

    public void initElement() {
    }

    public void onParentVisibleChanged(int visibility) {
        if (visibility != 0 || !this.enable) {
            getRootView().setVisibility(4);
        } else {
            getRootView().setVisibility(visibility);
        }
    }

    public final void setCommentEnable(boolean enable2) {
        this.enable = enable2;
        if (!getParent().isShowing() || !enable2) {
            getRootView().setVisibility(4);
        } else {
            getRootView().setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final List<BaseToolBarItem> getToolBarItemList() {
        List items = new ArrayList();
        items.add(new BaseToolBarItem(10));
        return items;
    }

    /* access modifiers changed from: private */
    public final CommonToolBar.ToolbarMode getToolBarMode() {
        return CommonToolBar.ToolbarMode.DARK;
    }

    public VideoFlowPlayer getVideoPlayer() {
        return (VideoFlowPlayer) super.getVideoPlayer();
    }

    private final void setDraft(UpdateLandCommentText draft) {
        if (draft.getDefault()) {
            getRootView().setDefaultInput(draft.getDraft().toString());
            getRootView().setCommentInput(draft.getDraft());
            return;
        }
        getRootView().setCommentInput(draft.getDraft());
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -993173448:
                if (action.equals(VideoFlowEvent.ACTION_UPDATE_LAND_COMMENT)) {
                    Object extra = event.getExtra(38);
                    UpdateLandCommentText $this$onEventNotify_u24lambda_u2d0 = extra instanceof UpdateLandCommentText ? (UpdateLandCommentText) extra : null;
                    if ($this$onEventNotify_u24lambda_u2d0 != null) {
                        setDraft($this$onEventNotify_u24lambda_u2d0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
