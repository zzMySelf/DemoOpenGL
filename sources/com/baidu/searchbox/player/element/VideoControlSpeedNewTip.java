package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.baidu.searchbox.videoplayer.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/element/VideoControlSpeedNewTip;", "Lcom/baidu/searchbox/player/element/VideoControlSpeedTip;", "()V", "initElement", "", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setContainerLayoutParams", "setSpeed", "speed", "", "togglePanelVisible", "isVisible", "", "isBubbleShow", "updateViewLayout", "isPanelVisible", "lib-player-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoControlSpeedNewTip.kt */
public class VideoControlSpeedNewTip extends VideoControlSpeedTip {
    public void initElement() {
        this.mRlSpeedTips = View.inflate(getContext(), R.layout.videoplayer_bd_video_control_clarity_tip, (ViewGroup) null);
        this.mSpeedText = (TextView) this.mRlSpeedTips.findViewById(R.id.tv_speed_text);
        View findViewById = this.mRlSpeedTips.findViewById(R.id.tv_action);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            setContainerLayoutParams();
            this.mRlSpeedTips.setVisibility(8);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    this.mRlSpeedTips.setVisibility(8);
                    return;
                }
                return;
            case -168817549:
                if (action.equals(LayerEvent.ACTION_SPEED_CHANGED)) {
                    this.mRlSpeedTips.setVisibility(0);
                    Object extra = event.getExtra(26);
                    Float speed = extra instanceof Float ? (Float) extra : null;
                    if (speed != null) {
                        setSpeed(speed.floatValue());
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        updateViewLayout(isVisible);
        if (this.mRlSpeedTips.getVisibility() == 0 && !isVisible) {
            hideSpeedTips();
        }
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [com.baidu.searchbox.player.layer.AbsNewControlLayer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateViewLayout(boolean r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.mRlSpeedTips
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.widget.FrameLayout.LayoutParams
            r2 = 0
            if (r1 == 0) goto L_0x000e
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 == 0) goto L_0x0056
            r1 = r0
            r3 = 0
            r4 = 1097859072(0x41700000, float:15.0)
            int r4 = com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils.dip2pix(r4)
            r1.leftMargin = r4
            if (r7 == 0) goto L_0x0026
            r2 = 1117913088(0x42a20000, float:81.0)
            int r2 = com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils.dip2pix(r2)
            r1.bottomMargin = r2
            goto L_0x004f
        L_0x0026:
            r4 = 1090519040(0x41000000, float:8.0)
            int r4 = com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils.dip2pix(r4)
            r1.bottomMargin = r4
            com.baidu.searchbox.player.layer.AbsNewControlLayer r4 = r6.getParent()
            boolean r5 = r4 instanceof com.baidu.searchbox.player.layer.ControlLandscapeLayer
            if (r5 == 0) goto L_0x0039
            r2 = r4
            com.baidu.searchbox.player.layer.ControlLandscapeLayer r2 = (com.baidu.searchbox.player.layer.ControlLandscapeLayer) r2
        L_0x0039:
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0044
            boolean r2 = r2.isMuteButtonShowing()
            if (r2 != r4) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r4 = r5
        L_0x0045:
            if (r4 == 0) goto L_0x004f
            r2 = 1111490560(0x42400000, float:48.0)
            int r2 = com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils.dip2pix(r2)
            r1.leftMargin = r2
        L_0x004f:
            r2 = 8388691(0x800053, float:1.175506E-38)
            r0.gravity = r2
        L_0x0056:
            android.view.View r1 = r6.mRlSpeedTips
            r2 = r0
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r1.setLayoutParams(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.element.VideoControlSpeedNewTip.updateViewLayout(boolean):void");
    }

    private final void setContainerLayoutParams() {
        this.mRlSpeedTips.setLayoutParams(new FrameLayout.LayoutParams(-2, InvokerUtils.dip2pix(24.0f)));
    }

    public void setSpeed(float speed) {
        updateViewLayout(false);
        super.setSpeed(speed);
    }
}
