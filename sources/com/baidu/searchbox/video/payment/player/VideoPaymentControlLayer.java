package com.baidu.searchbox.video.payment.player;

import com.baidu.searchbox.player.element.VideoControlBackground;
import com.baidu.searchbox.player.element.VideoControlHalfTitle;
import com.baidu.searchbox.player.element.VideoHalfNextTipsElement;
import com.baidu.searchbox.player.element.VideoLottiePlayBtn;
import com.baidu.searchbox.player.element.VolumeControlElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ControlLayer;

public class VideoPaymentControlLayer extends ControlLayer {
    private VideoPaymentBottomBarElement mControlBottomBarComponent;
    private VideoPaymentPreviewTipsElement mPreviewTipsComponent;

    /* access modifiers changed from: protected */
    public void setupElement() {
        this.mVideoControlBackground = new VideoControlBackground();
        addElement(this.mVideoControlBackground);
        this.mVideoControlHalfTitle = new VideoControlHalfTitle();
        addElement(this.mVideoControlHalfTitle);
        this.mVideoControlFullTitle = new VideoPaymentControlFullTitle();
        addElement(this.mVideoControlFullTitle);
        addElement(new VideoLottiePlayBtn());
        this.mVideoHalfNextTipsElement = new VideoHalfNextTipsElement();
        addElement(this.mVideoHalfNextTipsElement);
        addBottomBarElement();
        addMuteBtnElement();
        addElement(new VolumeControlElement());
        VideoPaymentPreviewTipsElement videoPaymentPreviewTipsElement = new VideoPaymentPreviewTipsElement();
        this.mPreviewTipsComponent = videoPaymentPreviewTipsElement;
        addElement(videoPaymentPreviewTipsElement);
        addElement(new VideoPaymentLimitFreeTipsElement());
        addPlaySpeedElement("video_landing");
    }

    /* access modifiers changed from: protected */
    public void addBottomBarElement() {
        VideoPaymentBottomBarElement videoPaymentBottomBarElement = new VideoPaymentBottomBarElement();
        this.mControlBottomBarComponent = videoPaymentBottomBarElement;
        addElement(videoPaymentBottomBarElement);
    }

    public void onLayerEventNotify(VideoEvent event) {
        if ((LayerEvent.ACTION_SWITCH_HALF.equals(event.getAction()) || LayerEvent.ACTION_SWITCH_FULL.equals(event.getAction())) && this.mSpeedMenuView != null) {
            this.mSpeedMenuView.setRootViewGone();
        }
        super.onLayerEventNotify(event);
    }
}
