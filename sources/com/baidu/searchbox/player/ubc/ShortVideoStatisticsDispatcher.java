package com.baidu.searchbox.player.ubc;

public class ShortVideoStatisticsDispatcher extends BaseVideoStatisticsDispatcher implements IContinuePlayLayerUbcDispatcher, ILogoAnimLayerUbcDispatcher, IGuideViewLayerUbcDispatcher {
    public ShortVideoStatisticsDispatcher(String videoUniqueKey) {
        super(videoUniqueKey);
        this.mUbcFlowStatisticsManager.addFlow(new PlayerSpeedDurationFlow());
    }

    public void showContinueBar() {
        ShortVideoPlayerEventUbc.showContinueBar(this.mUbcContent);
    }

    public void clickContinueBar() {
        ShortVideoPlayerEventUbc.clickContinueBar(this.mUbcContent);
    }

    public void showContinueButton(boolean isPlaying) {
        ShortVideoPlayerEventUbc.showContinueButton(this.mUbcContent, isPlaying);
    }

    public void clickContinueButton(boolean isPlaying) {
        ShortVideoPlayerEventUbc.clickContinueButton(this.mUbcContent, isPlaying);
    }

    public void continueLayerUbc(String type) {
        ShortVideoPlayerEventUbc.continueLayerUbc(this.mUbcContent, type);
    }

    public void onAnimLogoShowUBC() {
        ShortVideoPlayerEventUbc.onAnimLogoShowUBC(this.mUbcContent);
    }

    public void onAnimLogoClickUBC() {
        ShortVideoPlayerEventUbc.onAnimLogoClickUBC(this.mUbcContent);
    }

    public void toastClickUBC() {
        ShortVideoPlayerEventUbc.toastClickUBC(this.mUbcContent);
    }
}
