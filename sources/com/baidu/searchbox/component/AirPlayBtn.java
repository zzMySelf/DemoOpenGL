package com.baidu.searchbox.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.kernel.AdLayerEvent;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.element.ControlLayerElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.util.LayerUtils;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.baidu.searchbox.videoplayer.airplay.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/component/AirPlayBtn;", "Lcom/baidu/searchbox/player/element/ControlLayerElement;", "Landroid/view/View$OnClickListener;", "()V", "airPlayBtn", "Landroid/widget/ImageView;", "getAirPlayBtn", "()Landroid/widget/ImageView;", "airPlayBtn$delegate", "Lkotlin/Lazy;", "canShow", "", "getContentView", "Landroid/view/View;", "initElement", "", "initFullModeBtn", "initHalfModeBtn", "isLimitState", "onClick", "view", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "togglePanelVisible", "isVisible", "isBubbleShow", "lib-player-airplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirPlayBtn.kt */
public final class AirPlayBtn extends ControlLayerElement implements View.OnClickListener {
    private final Lazy airPlayBtn$delegate = LazyKt.lazy(new AirPlayBtn$airPlayBtn$2(this));
    private boolean canShow = true;

    private final ImageView getAirPlayBtn() {
        return (ImageView) this.airPlayBtn$delegate.getValue();
    }

    public View getContentView() {
        return getAirPlayBtn();
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        super.togglePanelVisible(isVisible, isBubbleShow);
        if ((isVisible || isLimitState()) && this.canShow) {
            getAirPlayBtn().setVisibility(0);
        } else {
            getAirPlayBtn().setVisibility(8);
        }
    }

    public void initElement() {
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    initFullModeBtn();
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    initHalfModeBtn();
                    return;
                }
                return;
            case -461848373:
                if (!action.equals("player_event_on_error")) {
                    return;
                }
                break;
            case 88214150:
                if (!action.equals(AdLayerEvent.ACTION_AD_SHOW)) {
                    return;
                }
                break;
            case 154871702:
                if (!action.equals("player_event_on_complete")) {
                    return;
                }
                break;
            case 1017883448:
                if (action.equals(LayerEvent.ACTION_SHOW_AIR_PLAY)) {
                    this.canShow = true;
                    if (getParent().isShow()) {
                        getAirPlayBtn().setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            case 1908303507:
                if (action.equals(LayerEvent.ACTION_HIDE_AIR_PLAY)) {
                    this.canShow = false;
                    getAirPlayBtn().setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
        getAirPlayBtn().setVisibility(8);
    }

    private final void initHalfModeBtn() {
        getAirPlayBtn().setImageResource(R.drawable.video_half_airplay);
        ViewGroup.LayoutParams layoutParams = getAirPlayBtn().getLayoutParams();
        FrameLayout.LayoutParams $this$initHalfModeBtn_u24lambda_u2d0 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if ($this$initHalfModeBtn_u24lambda_u2d0 != null) {
            $this$initHalfModeBtn_u24lambda_u2d0.topMargin = InvokerUtils.dip2pix(14.0f);
            $this$initHalfModeBtn_u24lambda_u2d0.rightMargin = InvokerUtils.dip2pix(90.0f);
        }
    }

    private final void initFullModeBtn() {
        getAirPlayBtn().setImageResource(R.drawable.video_full_airplay);
        ViewGroup.LayoutParams layoutParams = getAirPlayBtn().getLayoutParams();
        FrameLayout.LayoutParams $this$initFullModeBtn_u24lambda_u2d1 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if ($this$initFullModeBtn_u24lambda_u2d1 != null) {
            $this$initFullModeBtn_u24lambda_u2d1.topMargin = InvokerUtils.dip2pix(20.0f);
            $this$initFullModeBtn_u24lambda_u2d1.rightMargin = InvokerUtils.dip2pix(52.0f);
        }
    }

    private final boolean isLimitState() {
        BaseVideoPlayer player = getVideoPlayer();
        boolean isComplete = player.isComplete();
        boolean isError = player.isError();
        boolean isNetTipLayerVisible = false;
        ILayer netTipLayer = LayerUtils.findNetTipLayerLayer(getVideoPlayer().getLayerContainer().getLayerList());
        if (netTipLayer != null) {
            isNetTipLayerVisible = netTipLayer.getContentView().getVisibility() == 0;
        }
        if (isComplete || isError || isNetTipLayerVisible) {
            return true;
        }
        return false;
    }

    public void onClick(View view2) {
        if (Intrinsics.areEqual((Object) view2, (Object) getAirPlayBtn())) {
            getVideoPlayer().getStatEventTrigger().onAirPlayClick();
            getVideoPlayer().getPlayerCallbackManager().onAirPlayClick();
        }
    }
}
