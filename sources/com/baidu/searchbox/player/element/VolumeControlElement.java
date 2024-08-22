package com.baidu.searchbox.player.element;

import android.app.Activity;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.ui.VerticalVolumeBar;
import com.baidu.searchbox.videoplayer.ui.R;

public class VolumeControlElement extends ControlLayerElement {
    private boolean isGestureVolume = false;
    private boolean isShowAdLayer = false;
    private boolean isVisibleControlLayer;
    private AudioManager mAudioManager;
    private final Runnable mHideRunnable = new Runnable() {
        public void run() {
            VolumeControlElement.this.hideVolumeBar();
        }
    };
    private int mPercent;
    protected VerticalVolumeBar mVolumeBar;

    public void initElement() {
        VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), (AttributeSet) null, 16842872);
        this.mVolumeBar = verticalVolumeBar;
        verticalVolumeBar.setLayoutParams(getVolumeBarLayoutParams(false));
        this.mVolumeBar.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.videoplayer_video_volume_bar_color));
        this.mVolumeBar.setBackgroundResource(R.drawable.videoplayer_video_volume_bar_shadow_bg);
        int padding = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_shadow_width);
        this.mVolumeBar.setPadding(padding / 2, padding, padding / 2, padding);
        this.mVolumeBar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getVolumeBarLayoutParams(boolean isFullScreen) {
        int showWidth;
        int showLeftMargin;
        int showBottomMargin;
        int shadowWidth = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_shadow_width);
        int screenShort = Math.min(DeviceUtils.ScreenInfo.getDisplayWidth(getContext()), DeviceUtils.ScreenInfo.getDisplayHeight(getContext()));
        if (!isFullScreen) {
            showWidth = ((screenShort / 16) * 9) / 2;
        } else {
            showWidth = screenShort / 2;
        }
        int actualWidth = shadowWidth + showWidth;
        int actualHeight = (shadowWidth * 2) + ((int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_height));
        FrameLayout.LayoutParams volumeBarParams = (FrameLayout.LayoutParams) this.mVolumeBar.getLayoutParams();
        if (volumeBarParams == null) {
            volumeBarParams = new FrameLayout.LayoutParams(actualWidth, actualHeight);
        }
        volumeBarParams.width = actualWidth;
        volumeBarParams.height = actualHeight;
        if (!isFullScreen) {
            showLeftMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_leftmargin);
        } else {
            showLeftMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_full_leftmargin);
        }
        volumeBarParams.leftMargin = showLeftMargin - shadowWidth;
        volumeBarParams.gravity = 80;
        if (!isFullScreen) {
            showBottomMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_bottomargin);
        } else {
            showBottomMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_volume_full_bottomargin);
        }
        volumeBarParams.bottomMargin = showBottomMargin - shadowWidth;
        return volumeBarParams;
    }

    public View getContentView() {
        return this.mVolumeBar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventNotify(com.baidu.searchbox.player.event.VideoEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getAction()
            int r1 = r0.hashCode()
            r2 = 8
            r3 = 0
            r4 = 1
            switch(r1) {
                case -1496842788: goto L_0x0086;
                case -915923721: goto L_0x007b;
                case -552621273: goto L_0x0071;
                case -552580917: goto L_0x0067;
                case -316059751: goto L_0x005d;
                case -21461611: goto L_0x0053;
                case -14542718: goto L_0x0048;
                case 88214150: goto L_0x003e;
                case 649538615: goto L_0x0033;
                case 1547354793: goto L_0x0028;
                case 1822725860: goto L_0x001c;
                case 2064424334: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0090
        L_0x0011:
            java.lang.String r1 = "layer_event_position_slide"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 3
            goto L_0x0091
        L_0x001c:
            java.lang.String r1 = "system_event_volume_changed"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r3
            goto L_0x0091
        L_0x0028:
            java.lang.String r1 = "control_event_stop"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 2
            goto L_0x0091
        L_0x0033:
            java.lang.String r1 = "action_adjust_volume_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 10
            goto L_0x0091
        L_0x003e:
            java.lang.String r1 = "layer_event_ad_show"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 7
            goto L_0x0091
        L_0x0048:
            java.lang.String r1 = "action_hide_volume_bar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 11
            goto L_0x0091
        L_0x0053:
            java.lang.String r1 = "layer_event_touch_down"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r4
            goto L_0x0091
        L_0x005d:
            java.lang.String r1 = "layer_event_adjust_light"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 4
            goto L_0x0091
        L_0x0067:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 6
            goto L_0x0091
        L_0x0071:
            java.lang.String r1 = "layer_event_switch_full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 5
            goto L_0x0091
        L_0x007b:
            java.lang.String r1 = "layer_event_adjust_volume"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = 9
            goto L_0x0091
        L_0x0086:
            java.lang.String r1 = "layer_event_ad_finish"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            r0 = r2
            goto L_0x0091
        L_0x0090:
            r0 = -1
        L_0x0091:
            switch(r0) {
                case 0: goto L_0x00d0;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00bc;
                case 7: goto L_0x00b9;
                case 8: goto L_0x00b6;
                case 9: goto L_0x00a8;
                case 10: goto L_0x00a5;
                case 11: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00d4
        L_0x0095:
            com.baidu.searchbox.player.ui.VerticalVolumeBar r0 = r5.mVolumeBar
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00d4
            com.baidu.searchbox.player.ui.VerticalVolumeBar r0 = r5.mVolumeBar
            r0.setVisibility(r2)
            goto L_0x00d4
        L_0x00a5:
            r5.isGestureVolume = r3
            goto L_0x00d4
        L_0x00a8:
            r5.isGestureVolume = r4
            r0 = 20
            int r0 = r6.getIntExtra(r0)
            r5.mPercent = r0
            r5.showOrUpdateVolumeBar()
            goto L_0x00d4
        L_0x00b6:
            r5.isShowAdLayer = r3
            goto L_0x00d4
        L_0x00b9:
            r5.isShowAdLayer = r4
            goto L_0x00d4
        L_0x00bc:
            r5.updateVolumeBarUI(r3)
            goto L_0x00d4
        L_0x00c0:
            r5.updateVolumeBarUI(r4)
            goto L_0x00d4
        L_0x00c4:
            r5.hideVolumeBar()
            goto L_0x00d4
        L_0x00c8:
            boolean r0 = r5.isVisibleControlLayer
            if (r0 != 0) goto L_0x00d4
            r5.hideVolumeBar()
            goto L_0x00d4
        L_0x00d0:
            r5.showOrUpdateVolumeBar()
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.element.VolumeControlElement.onEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    private void updateVolumeBarUI(boolean isFullScreen) {
        if (this.mVolumeBar == null) {
            initElement();
        }
        this.mVolumeBar.setLayoutParams(getVolumeBarLayoutParams(isFullScreen));
        hideVolumeBar();
    }

    /* access modifiers changed from: protected */
    public void showOrUpdateVolumeBar() {
        Activity curActivity = getVideoPlayer().getActivity();
        if (curActivity == null || !curActivity.hasWindowFocus()) {
            hideVolumeBar();
        } else if ((getVideoPlayer().isPlaying() || getVideoPlayer().isPause()) && !this.isShowAdLayer) {
            VerticalVolumeBar verticalVolumeBar = this.mVolumeBar;
            if (!(verticalVolumeBar == null || verticalVolumeBar.getVisibility() == 0)) {
                this.mVolumeBar.setVisibility(0);
                VideoEvent volumeBarShowEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                dispatchElementEvent(volumeBarShowEvent);
                sendEvent(volumeBarShowEvent);
            }
            hideControlLayer();
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) getContext().getApplicationContext().getSystemService("audio");
            }
            int maxVolume = this.mAudioManager.getStreamMaxVolume(3);
            int curVolume = this.mAudioManager.getStreamVolume(3);
            VerticalVolumeBar verticalVolumeBar2 = this.mVolumeBar;
            if (verticalVolumeBar2 != null) {
                if (!this.isGestureVolume) {
                    verticalVolumeBar2.setMax(maxVolume);
                    this.mVolumeBar.setProgress(curVolume);
                } else {
                    verticalVolumeBar2.setMax(100);
                    this.mVolumeBar.setProgress(this.mPercent);
                }
            }
            getParent().getHandlerInnerLayer().removeCallbacks(this.mHideRunnable);
            getParent().getHandlerInnerLayer().postDelayed(this.mHideRunnable, 1000);
        } else {
            hideVolumeBar();
        }
    }

    /* access modifiers changed from: protected */
    public void hideControlLayer() {
        if (getParent() != null && getParent().isShow()) {
            getParent().togglePanelVisible(false);
        }
    }

    /* access modifiers changed from: private */
    public void hideVolumeBar() {
        VerticalVolumeBar verticalVolumeBar = this.mVolumeBar;
        if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() == 0) {
            this.mVolumeBar.setVisibility(8);
            dispatchElementEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        this.isVisibleControlLayer = isVisible;
        if (isVisible) {
            hideVolumeBar();
        }
    }

    public void onContainerDetach() {
        super.onContainerDetach();
        hideVolumeBar();
    }
}
