package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanControlEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.video.feedflow.detail.player.player.event.SeamlessPlayEvent;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/SeamlessPlayElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "containerView", "Landroid/view/ViewGroup;", "inControl", "", "inCountDown", "rootView", "getRootView", "()Landroid/view/ViewGroup;", "rootView$delegate", "Lkotlin/Lazy;", "addView", "", "view", "Landroid/view/View;", "changeViewVisible", "getContentView", "hideView", "initElement", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setupRootView", "updateSlotViewLayoutParams", "isPanelShowing", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeamlessPlayElement.kt */
public final class SeamlessPlayElement extends AbsElement {
    private ViewGroup containerView;
    private boolean inControl;
    private boolean inCountDown;
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new SeamlessPlayElement$rootView$2(this));

    private final ViewGroup getRootView() {
        return (ViewGroup) this.rootView$delegate.getValue();
    }

    public View getContentView() {
        return getRootView();
    }

    /* access modifiers changed from: private */
    public final ViewGroup setupRootView() {
        FrameLayout $this$setupRootView_u24lambda_u2d0 = new FrameLayout(getContext());
        $this$setupRootView_u24lambda_u2d0.setLayoutParams(new RelativeLayout.LayoutParams(BDPlayerConfig.sWindowsWidth / 3, -2));
        this.containerView = $this$setupRootView_u24lambda_u2d0;
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$setupRootView_u24lambda_u2d2 = frameLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = layoutParams;
        $this$setupRootView_u24lambda_u2d2.setId(ViewCompat.generateViewId());
        $this$setupRootView_u24lambda_u2d2.setLayoutParams(layoutParams);
        ViewGroup viewGroup = this.containerView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            viewGroup = null;
        }
        $this$setupRootView_u24lambda_u2d2.addView(viewGroup);
        return frameLayout;
    }

    public void initElement() {
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -1638530599:
                if (action.equals(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED)) {
                    boolean visible = event.getBooleanExtra(9);
                    this.inControl = visible;
                    updateSlotViewLayoutParams(visible);
                    changeViewVisible();
                    return;
                }
                return;
            case -882902390:
                if (action.equals("player_event_set_data")) {
                    this.inCountDown = false;
                    changeViewVisible();
                    return;
                }
                return;
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    changeViewVisible();
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    hideView();
                    return;
                }
                return;
            case 54044886:
                if (action.equals(VulcanControlEvent.ACTION_VULCAN_FUN_PANEL_VISIBLE_CHANGED)) {
                    if (event.getBooleanExtra(12)) {
                        hideView();
                        return;
                    } else {
                        changeViewVisible();
                        return;
                    }
                } else {
                    return;
                }
            case 673285521:
                if (action.equals(SeamlessPlayEvent.ACTION_KEY_SEAMLESS_COUNT_DOWN)) {
                    this.inCountDown = event.getBooleanExtra(1);
                    changeViewVisible();
                    return;
                }
                return;
            case 1394546984:
                if (action.equals(LayerEvent.ACTION_ALL_LAYER_VISIBLE_FADE)) {
                    if (event.getBooleanExtra(39)) {
                        hideView();
                        return;
                    } else {
                        changeViewVisible();
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private final void updateSlotViewLayoutParams(boolean isPanelShowing) {
        if (isPanelShowing) {
            LayerUtil.slideInFromShowingBottom(getRootView()).start();
        } else {
            LayerUtil.slideOutToShowingBottom(getRootView()).start();
        }
    }

    public final void addView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ViewGroup viewGroup = this.containerView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            viewGroup = null;
        }
        if (viewGroup.getChildCount() > 0) {
            ViewGroup viewGroup3 = this.containerView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                viewGroup3 = null;
            }
            viewGroup3.removeAllViews();
        }
        ViewGroup viewGroup4 = this.containerView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.addView(view2);
    }

    private final void hideView() {
        ViewGroup viewGroup = this.containerView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
    }

    private final void changeViewVisible() {
        ViewGroup viewGroup = null;
        if (this.inControl || this.inCountDown) {
            ViewGroup viewGroup2 = this.containerView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup3 = this.containerView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(8);
    }
}
