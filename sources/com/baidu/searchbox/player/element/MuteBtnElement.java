package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.BarrageLayerController;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.ubc.IMuteViewLayerUbcDispatcher;
import com.baidu.searchbox.player.util.LayerUtils;
import com.baidu.searchbox.player.utils.BdVideoAnimationUtils;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import com.baidu.searchbox.videoplayer.ui.R;

public class MuteBtnElement extends ControlLayerElement implements View.OnClickListener {
    private boolean mIsFullScreen = false;
    private boolean mIsInterceptVisible = false;
    private boolean mIsShowVolumeBar = false;
    private int mMarginBottom = -1;
    private int mMarginLeft = -1;
    protected ImageView mMuteButton;
    protected boolean mPanelShowing;

    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        this.mMuteButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.mMuteButton.setOnClickListener(this);
        FrameLayout.LayoutParams muteViewParams = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_width), (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_height));
        muteViewParams.gravity = 8388691;
        if (this.mMarginLeft == -1) {
            this.mMarginLeft = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_leftmargin);
        }
        muteViewParams.leftMargin = this.mMarginLeft;
        this.mMuteButton.setLayoutParams(muteViewParams);
        this.mMuteButton.setVisibility(8);
        if (this.mParent.getLayerContainer() != null) {
            sycVideoMute();
        }
    }

    public void setMarginLeftSize(int marginLeft) {
        this.mMarginLeft = marginLeft;
    }

    public void setMarginBottomSize(int marginBottom) {
        this.mMarginBottom = marginBottom;
    }

    public void setIsInterceptVisible(boolean isInterceptVisible) {
        this.mIsInterceptVisible = isInterceptVisible;
    }

    public boolean isInterceptVisible() {
        return this.mIsInterceptVisible && !isMute();
    }

    public View getContentView() {
        return this.mMuteButton;
    }

    /* access modifiers changed from: protected */
    public void switchVolumeMode() {
        boolean isMute = isMute();
        if (isMute && BdVolumeUtils.getVolume(getContext()) == 0) {
            BdVolumeUtils.setVolume(getContext(), (int) (((double) BdVolumeUtils.getMaxVolume(getContext())) * 0.35d));
        }
        syncMuteAutoPlayState(isMute);
        boolean isMute2 = !isMute;
        updateMuteIconImg(isMute2);
        getVideoPlayer().setGlobalMuteMode(isMute2);
        VideoSessionManager.getInstance().sendEventToAll(LayerEvent.obtainEvent(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
    }

    /* access modifiers changed from: protected */
    public void syncMuteAutoPlayState(boolean isMute) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventNotify(com.baidu.searchbox.player.event.VideoEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getAction()
            int r1 = r0.hashCode()
            r2 = 8
            r3 = 11
            r4 = 1
            r5 = 4
            r6 = 0
            switch(r1) {
                case -1759675333: goto L_0x00f5;
                case -1151510254: goto L_0x00ea;
                case -1009727513: goto L_0x00df;
                case -849541738: goto L_0x00d4;
                case -552621273: goto L_0x00c9;
                case -552580917: goto L_0x00bf;
                case -461848373: goto L_0x00b4;
                case -333704320: goto L_0x00aa;
                case -316059751: goto L_0x009f;
                case -150198673: goto L_0x0094;
                case -14542718: goto L_0x0088;
                case 14382657: goto L_0x007c;
                case 88214150: goto L_0x0071;
                case 154871702: goto L_0x0065;
                case 250537257: goto L_0x005a;
                case 723345051: goto L_0x004f;
                case 1231554669: goto L_0x0044;
                case 1586388829: goto L_0x0038;
                case 1673877948: goto L_0x002c;
                case 1822725860: goto L_0x001f;
                case 2064424334: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0101
        L_0x0014:
            java.lang.String r1 = "layer_event_position_slide"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = r2
            goto L_0x0102
        L_0x001f:
            java.lang.String r1 = "system_event_volume_changed"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 13
            goto L_0x0102
        L_0x002c:
            java.lang.String r1 = "action_mute_sync_to_all_player"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 16
            goto L_0x0102
        L_0x0038:
            java.lang.String r1 = "layer_event_barrage_editView_visible_status"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 12
            goto L_0x0102
        L_0x0044:
            java.lang.String r1 = "layer_event_lock_screen"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 6
            goto L_0x0102
        L_0x004f:
            java.lang.String r1 = "control_event_start"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 5
            goto L_0x0102
        L_0x005a:
            java.lang.String r1 = "layer_event_net_error_show"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 2
            goto L_0x0102
        L_0x0065:
            java.lang.String r1 = "player_event_on_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 3
            goto L_0x0102
        L_0x0071:
            java.lang.String r1 = "layer_event_ad_show"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = r4
            goto L_0x0102
        L_0x007c:
            java.lang.String r1 = "control_event_status_sync"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 17
            goto L_0x0102
        L_0x0088:
            java.lang.String r1 = "action_hide_volume_bar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 19
            goto L_0x0102
        L_0x0094:
            java.lang.String r1 = "layer_event_click_net_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 7
            goto L_0x0102
        L_0x009f:
            java.lang.String r1 = "layer_event_adjust_light"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 9
            goto L_0x0102
        L_0x00aa:
            java.lang.String r1 = "control_event_show_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = r6
            goto L_0x0102
        L_0x00b4:
            java.lang.String r1 = "player_event_on_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = r5
            goto L_0x0102
        L_0x00bf:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = r3
            goto L_0x0102
        L_0x00c9:
            java.lang.String r1 = "layer_event_switch_full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 10
            goto L_0x0102
        L_0x00d4:
            java.lang.String r1 = "layer_event_barrage_click"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 15
            goto L_0x0102
        L_0x00df:
            java.lang.String r1 = "action_show_volume_bar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 18
            goto L_0x0102
        L_0x00ea:
            java.lang.String r1 = "action_mute_icon_update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 20
            goto L_0x0102
        L_0x00f5:
            java.lang.String r1 = "player_event_go_back_or_foreground"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 14
            goto L_0x0102
        L_0x0101:
            r0 = -1
        L_0x0102:
            switch(r0) {
                case 0: goto L_0x0246;
                case 1: goto L_0x0246;
                case 2: goto L_0x0246;
                case 3: goto L_0x0246;
                case 4: goto L_0x0246;
                case 5: goto L_0x0219;
                case 6: goto L_0x01eb;
                case 7: goto L_0x01de;
                case 8: goto L_0x01ca;
                case 9: goto L_0x01ca;
                case 10: goto L_0x01bc;
                case 11: goto L_0x01a9;
                case 12: goto L_0x01a4;
                case 13: goto L_0x016c;
                case 14: goto L_0x015e;
                case 15: goto L_0x0155;
                case 16: goto L_0x0150;
                case 17: goto L_0x0150;
                case 18: goto L_0x0138;
                case 19: goto L_0x0110;
                case 20: goto L_0x0107;
                default: goto L_0x0105;
            }
        L_0x0105:
            goto L_0x024c
        L_0x0107:
            boolean r0 = r8.getBooleanExtra(r4)
            r7.updateMuteIconImg(r0)
            goto L_0x024c
        L_0x0110:
            r7.mIsShowVolumeBar = r6
            boolean r0 = r7.isMute()
            r7.updateMuteIconImg(r0)
            android.widget.ImageView r0 = r7.mMuteButton
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x024c
            boolean r0 = r7.mPanelShowing
            if (r0 == 0) goto L_0x012b
            boolean r0 = r7.isInterceptVisible()
            if (r0 == 0) goto L_0x024c
        L_0x012b:
            boolean r0 = r7.isMute()
            if (r0 != 0) goto L_0x024c
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r2)
            goto L_0x024c
        L_0x0138:
            r7.mIsShowVolumeBar = r4
            boolean r0 = r7.isMute()
            r7.updateMuteIconImg(r0)
            android.widget.ImageView r0 = r7.mMuteButton
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x024c
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r6)
            goto L_0x024c
        L_0x0150:
            r7.sycVideoMute()
            goto L_0x024c
        L_0x0155:
            boolean r0 = r8.getBooleanExtra(r3)
            r7.updateMuteIconPosition(r0)
            goto L_0x024c
        L_0x015e:
            boolean r0 = r8.getBooleanExtra(r5)
            if (r0 == 0) goto L_0x024c
            r7.sycVideoMute()
            r7.handleMuteViewStatus()
            goto L_0x024c
        L_0x016c:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r7.getVideoPlayer()
            boolean r0 = r0.isStop()
            if (r0 != 0) goto L_0x01a3
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r7.getVideoPlayer()
            boolean r0 = r0.isComplete()
            if (r0 == 0) goto L_0x0181
            goto L_0x01a3
        L_0x0181:
            int r0 = r8.getIntExtra(r5)
            if (r0 > 0) goto L_0x0188
            goto L_0x0189
        L_0x0188:
            r4 = r6
        L_0x0189:
            r7.updateMuteIconImg(r4)
            r7.handleMuteViewStatus()
            boolean r1 = r7.isMute()
            if (r1 == 0) goto L_0x0197
            if (r0 > 0) goto L_0x019b
        L_0x0197:
            if (r1 != 0) goto L_0x024c
            if (r0 != 0) goto L_0x024c
        L_0x019b:
            r7.switchVolumeMode()
            r7.handleMuteViewStatus()
            goto L_0x024c
        L_0x01a3:
            return
        L_0x01a4:
            r7.onBarrageVisible(r8)
            goto L_0x024c
        L_0x01a9:
            r7.mIsFullScreen = r6
            boolean r0 = r7.isMute()
            r7.updateMuteIconImg(r0)
            r7.mPanelShowing = r6
            r7.updateMuteIconPosition(r6)
            r7.handleMuteViewStatus()
            goto L_0x024c
        L_0x01bc:
            r7.mIsFullScreen = r4
            boolean r0 = r7.isMute()
            r7.updateMuteIconImg(r0)
            r7.onLayerSwitchToFull()
            goto L_0x024c
        L_0x01ca:
            boolean r0 = r7.isMute()
            if (r0 == 0) goto L_0x01d7
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r6)
            goto L_0x024c
        L_0x01d7:
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r5)
            goto L_0x024c
        L_0x01de:
            android.widget.ImageView r0 = r7.mMuteButton
            boolean r1 = r7.isInterceptVisible()
            if (r1 != 0) goto L_0x01e7
            r5 = r6
        L_0x01e7:
            r0.setVisibility(r5)
            goto L_0x024c
        L_0x01eb:
            boolean r0 = r7.isMute()
            if (r0 == 0) goto L_0x0213
            boolean r0 = com.baidu.searchbox.player.BaseVideoPlayer.isOrientationLock()
            if (r0 == 0) goto L_0x0205
            android.widget.ImageView r0 = r7.mMuteButton
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x024c
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r5)
            goto L_0x024c
        L_0x0205:
            android.widget.ImageView r0 = r7.mMuteButton
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x024c
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r6)
            goto L_0x024c
        L_0x0213:
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r5)
            goto L_0x024c
        L_0x0219:
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r7.getVideoPlayer()
            boolean r0 = r0.isFullMode()
            if (r0 == 0) goto L_0x0242
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r7.getVideoPlayer()
            int r0 = r0.getFullScreenStyle()
            if (r0 != r4) goto L_0x0242
            android.widget.ImageView r0 = r7.mMuteButton
            boolean r1 = r7.shouldShowMuteView()
            if (r1 == 0) goto L_0x023d
            boolean r1 = r7.isInterceptVisible()
            if (r1 != 0) goto L_0x023d
            r5 = r6
            goto L_0x023e
        L_0x023d:
        L_0x023e:
            r0.setVisibility(r5)
            goto L_0x024c
        L_0x0242:
            r7.handleMuteViewStatus()
            goto L_0x024c
        L_0x0246:
            android.widget.ImageView r0 = r7.mMuteButton
            r0.setVisibility(r5)
        L_0x024c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.element.MuteBtnElement.onEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if ((PlayerStatus.PREPARING == status || PlayerStatus.PLAYING == status) && this.mPanelShowing && this.mMuteButton.getVisibility() != 0 && !isInterceptVisible()) {
            this.mMuteButton.setVisibility(0);
        }
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        boolean z = false;
        this.mPanelShowing = (!BaseVideoPlayer.isOrientationLock() || !getVideoPlayer().isFullMode()) && isVisible;
        if (getVideoPlayer().isFullMode()) {
            changeFullModeMuteVisible(this.mPanelShowing);
            if (BarrageLayerController.hasBarrage() && BarrageLayerController.isBarrageOn()) {
                z = true;
            }
            updateMuteIconPosition(z, isVisible);
            return;
        }
        changeHalfModeMuteVisible(this.mPanelShowing);
    }

    private void onBarrageVisible(VideoEvent event) {
        updateMuteIconPosition(event.getBooleanExtra(16));
    }

    private void onLayerSwitchToFull() {
        boolean z = true;
        this.mPanelShowing = getVideoPlayer().getFullScreenStyle() == 0;
        if (!BarrageLayerController.hasBarrage() || !BarrageLayerController.isBarrageOn()) {
            z = false;
        }
        updateMuteIconPosition(z);
        handleMuteViewStatus();
    }

    /* access modifiers changed from: protected */
    public void sycVideoMute() {
        boolean isMute = getMuteSwitch(getVideoPlayer().isPlayerMute() || BdVolumeUtils.getVolume(getContext()) <= 0);
        getVideoPlayer().setMuteMode(isMute);
        updateMuteIconImg(isMute);
    }

    /* access modifiers changed from: protected */
    public boolean getMuteSwitch(boolean isMute) {
        return isMute;
    }

    public void onClick(View v) {
        if (v.equals(this.mMuteButton) && !this.mIsShowVolumeBar) {
            switchVolumeMode();
            handleMuteViewStatus();
            if (getMuteStatDispatcher() != null) {
                getMuteStatDispatcher().onSwitchVolumeMode(isMute());
            }
        }
    }

    public void updateMuteIconImg(boolean isMute) {
        if (this.mIsFullScreen) {
            if (!isMute) {
                if (!this.mIsShowVolumeBar) {
                    this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.videoplayer_new_player_mute_open_selector_full));
                } else {
                    this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_open_full));
                }
            } else if (!this.mIsShowVolumeBar) {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.videoplayer_new_player_mute_close_selector_full));
            } else {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_close_full));
            }
            dismissMuteBubble();
        } else if (isMute || BdVolumeUtils.getVolume(getContext()) == 0) {
            if (!this.mIsShowVolumeBar) {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_open_selector));
            } else {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_open_half));
            }
            showMuteBubble();
        } else {
            if (!this.mIsShowVolumeBar) {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_close_selector));
            } else {
                this.mMuteButton.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.videoplayer.business.R.drawable.videoplayer_new_player_mute_close_half));
            }
            dismissMuteBubble();
        }
    }

    public void updateMuteIconPosition(boolean hasDanmakuEditView) {
        updateMuteIconPosition(hasDanmakuEditView, true);
    }

    public void updateMuteIconPosition(boolean hasDanmakuEditView, boolean visible) {
        int marginBottom;
        FrameLayout.LayoutParams muteViewParams = (FrameLayout.LayoutParams) this.mMuteButton.getLayoutParams();
        boolean isLandscape = true;
        if (!getVideoPlayer().isFullMode() || getVideoPlayer().getFullScreenStyle() != 1) {
            isLandscape = false;
        }
        if (!isLandscape && !hasDanmakuEditView) {
            muteViewParams.bottomMargin = 0;
            muteViewParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_leftmargin);
        } else if (visible) {
            if (this.mMarginBottom == -1) {
                marginBottom = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_buttomargin);
            } else {
                marginBottom = this.mMarginBottom;
            }
            muteViewParams.bottomMargin = marginBottom;
            muteViewParams.leftMargin = this.mMarginLeft;
        } else {
            muteViewParams.bottomMargin = 0;
            muteViewParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.videoplayer_bd_video_mute_leftmargin);
        }
        this.mMuteButton.setLayoutParams(muteViewParams);
    }

    public int changeHalfModeMuteVisible(boolean visible) {
        if (visible) {
            this.mMuteButton.setVisibility(0);
            return 4;
        }
        handleMuteViewStatus();
        return 0;
    }

    /* access modifiers changed from: protected */
    public int changeFullModeMuteVisible(boolean visible) {
        int i2 = 0;
        if (!getVideoPlayer().isFullMode() || getVideoPlayer().getFullScreenStyle() != 1) {
            if (visible) {
                fakeInVideoMuteView();
                return 4;
            }
            if (isMute() && shouldShowMuteView()) {
                this.mMuteButton.setVisibility(0);
            } else if (this.mIsShowVolumeBar) {
                this.mMuteButton.setVisibility(0);
            } else {
                this.mMuteButton.setVisibility(4);
            }
            return 0;
        } else if (visible) {
            ImageView imageView = this.mMuteButton;
            if (!shouldShowMuteView() || isInterceptVisible()) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            return 4;
        } else {
            if ((isMute() || BdVolumeUtils.getVolume(getContext()) == 0) && shouldShowMuteView()) {
                this.mMuteButton.setVisibility(0);
            } else if (this.mIsShowVolumeBar) {
                this.mMuteButton.setVisibility(0);
            } else {
                this.mMuteButton.setVisibility(4);
            }
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void handleMuteViewStatus() {
        if (isMute() || BdVolumeUtils.getVolume(getContext()) == 0) {
            if (shouldShowMuteView()) {
                this.mMuteButton.setVisibility(0);
            } else {
                this.mMuteButton.setVisibility(4);
            }
        } else if (this.mPanelShowing && !isInterceptVisible()) {
            this.mMuteButton.setVisibility(0);
        } else if (this.mIsShowVolumeBar) {
            this.mMuteButton.setVisibility(0);
        } else {
            this.mMuteButton.setVisibility(4);
        }
        ImageView imageView = this.mMuteButton;
        if (imageView != null && imageView.getVisibility() != 0) {
            dismissMuteBubble();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowMuteView() {
        BaseVideoPlayer videoPlayer = getVideoPlayer();
        ILayer netTipLayer = LayerUtils.findAdLayer(getVideoPlayer().getLayerContainer().getLayerList());
        return !videoPlayer.isComplete() && !videoPlayer.isError() && !videoPlayer.isStop() && (netTipLayer == null || netTipLayer.getContentView().getVisibility() != 0);
    }

    private void fakeInVideoMuteView() {
        Animation inAnimation = BdVideoAnimationUtils.getBottomInAnimation();
        if (this.mMuteButton.getVisibility() != 0) {
            this.mMuteButton.setVisibility(0);
            this.mMuteButton.startAnimation(inAnimation);
        }
    }

    private void fakeOutVideoMuteView() {
        Animation outAnimation = BdVideoAnimationUtils.getBottomOutAnimation();
        if (this.mMuteButton.getVisibility() == 0) {
            this.mMuteButton.startAnimation(outAnimation);
            outAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    MuteBtnElement.this.mMuteButton.setVisibility(4);
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean isMute() {
        return BDVideoPlayer.isGlobalMute();
    }

    private IMuteViewLayerUbcDispatcher getMuteStatDispatcher() {
        return getVideoPlayer().getStatDispatcher();
    }

    public void showMuteBubble() {
    }

    public void dismissMuteBubble() {
    }
}
