package com.baidu.searchbox.live.floating;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/floating/LiveFloatingStopTipElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "isYY", "", "(Z)V", "contentView", "Landroid/widget/FrameLayout;", "getContentView", "()Landroid/widget/FrameLayout;", "contentView$delegate", "Lkotlin/Lazy;", "()Z", "tipView", "Landroid/widget/TextView;", "getTipView", "()Landroid/widget/TextView;", "tipView$delegate", "Landroid/view/View;", "hide", "", "initElement", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onParentVisibleChanged", "visibility", "", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "show", "syncStatus", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFloatingStopTipElement.kt */
public final class LiveFloatingStopTipElement extends AbsElement {
    private final Lazy contentView$delegate = LazyKt.lazy(new LiveFloatingStopTipElement$contentView$2(this));
    private final boolean isYY;
    private final Lazy tipView$delegate = LazyKt.lazy(new LiveFloatingStopTipElement$tipView$2(this));

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveFloatingStopTipElement.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            iArr[PlayerStatus.PAUSE.ordinal()] = 2;
            iArr[PlayerStatus.COMPLETE.ordinal()] = 3;
            iArr[PlayerStatus.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LiveFloatingStopTipElement(boolean isYY2) {
        this.isYY = isYY2;
    }

    public final boolean isYY() {
        return this.isYY;
    }

    private final FrameLayout getContentView() {
        return (FrameLayout) this.contentView$delegate.getValue();
    }

    private final TextView getTipView() {
        return (TextView) this.tipView$delegate.getValue();
    }

    /* renamed from: getContentView  reason: collision with other method in class */
    public View m117getContentView() {
        return getContentView();
    }

    public void initElement() {
        getContentView().setId(ViewCompat.generateViewId());
        getContentView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout.LayoutParams tipLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        tipLayoutParams.gravity = 17;
        getContentView().addView(getTipView(), tipLayoutParams);
        hide();
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 952368377:
                if (!action.equals(FloatingLayerEvent.ACTION_FLOATING_GESTURE)) {
                    return;
                }
                if (event.getBooleanExtra(1)) {
                    hide();
                    return;
                } else {
                    syncStatus();
                    return;
                }
            case 1409909918:
                if (action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    syncStatus();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        switch (status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
            case 2:
            case 3:
                hide();
                return;
            case 4:
                show();
                return;
            default:
                return;
        }
    }

    public void onParentVisibleChanged(int visibility) {
    }

    private final void syncStatus() {
        BDVideoPlayer videoPlayer = getVideoPlayer();
        boolean z = true;
        if (videoPlayer == null || !videoPlayer.isError()) {
            z = false;
        }
        if (z) {
            show();
        } else {
            hide();
        }
    }

    private final void show() {
        getContentView().setVisibility(0);
    }

    private final void hide() {
        getContentView().setVisibility(8);
    }
}
