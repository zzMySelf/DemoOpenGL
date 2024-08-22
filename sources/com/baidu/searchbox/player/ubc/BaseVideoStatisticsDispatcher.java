package com.baidu.searchbox.player.ubc;

import com.baidu.searchbox.player.helper.VideoDownloadHelper;
import com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;

public class BaseVideoStatisticsDispatcher implements IUniversalPlayerStatDispatcher, IPosterLayerUbcDispatcher, INetTipLayerUbcDispatcher, IGestureLayerUbcDispatcher, IMuteViewLayerUbcDispatcher, IControlLayerUbcDispatcher, IShareLayerUbcDispatcher, IErrorLayerUbcDispatcher, IHaoKanLayerUbcDispatcher, IPreviousNextClickUbcDispatcher {
    protected BDVideoPlayerUbcContent mUbcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    protected PlayerUbcFlowStatisticsManager mUbcFlowStatisticsManager;
    protected String mVideoUniqueKey;

    public BaseVideoStatisticsDispatcher(String videoUniqueKey) {
        this.mVideoUniqueKey = videoUniqueKey;
        this.mUbcFlowStatisticsManager = new PlayerUbcFlowStatisticsManager();
    }

    public void updateVideoUniqueKey(String videoUniqueKey) {
        this.mVideoUniqueKey = videoUniqueKey;
    }

    public void setVideoPlayerUbcContent(BDVideoPlayerUbcContent ubcContent) {
        this.mUbcContent = ubcContent;
        this.mUbcFlowStatisticsManager.setVideoPlayerUbcContent(ubcContent);
    }

    public void start() {
        BaseVideoPlayerEventUbc.upPlayerStatics(this.mUbcContent, "start");
        this.mUbcFlowStatisticsManager.onPlayerStart();
    }

    public void resume() {
        BaseVideoPlayerEventUbc.upPlayerStatics(this.mUbcContent, "resume");
        this.mUbcFlowStatisticsManager.onPlayerResume();
    }

    public void pause() {
        BaseVideoPlayerEventUbc.upPlayerStatics(this.mUbcContent, "pause");
        this.mUbcFlowStatisticsManager.onPlayerPause();
    }

    public void stop(int loopCount) {
        BaseVideoPlayerEventUbc.upPlayerStatics(this.mUbcContent, "stop");
        this.mUbcFlowStatisticsManager.onPlayerStop(loopCount);
    }

    public void end(int loopCount) {
        BaseVideoPlayerEventUbc.upPlayerStatics(this.mUbcContent, "end");
        this.mUbcFlowStatisticsManager.onPlayerEnd(loopCount);
    }

    public void release() {
        this.mUbcFlowStatisticsManager.removeFlow();
    }

    public void onInfo(int what, int extra, Object info) {
        managerPlayerFlowStatistics(what, extra, info);
    }

    /* access modifiers changed from: protected */
    public void uploadFirstFrame() {
    }

    /* access modifiers changed from: protected */
    public void uploadVideoClarityPlay() {
    }

    /* access modifiers changed from: protected */
    public void managerPlayerFlowStatistics(int what, int extra, Object info) {
        this.mUbcFlowStatisticsManager.onInfo(what, extra, info);
    }

    public void switchPlayerSpeed(float currentSpeed) {
        this.mUbcFlowStatisticsManager.switchPlayerSpeed(currentSpeed);
    }

    public void onError(int what, int extra, Object error) {
    }

    public void goBackOrForeground(boolean isForeground, int loopCount) {
        this.mUbcFlowStatisticsManager.goBackOrForeground(isForeground, loopCount);
    }

    public void startInitPlayerKernel() {
    }

    public void endInitPlayerKernel() {
    }

    public void startInitPlayer() {
        PlayerSpeedTracker.startBuildPlayer(this.mVideoUniqueKey);
    }

    public void endInitPlayer() {
        PlayerSpeedTracker.endBuildPlayer(this.mVideoUniqueKey);
    }

    public void startSetupLayer() {
        PlayerSpeedTracker.startSetupLayer(this.mVideoUniqueKey);
    }

    public void endSetupLayerAndStartSetupPlugin() {
        PlayerSpeedTracker.endSetupLayerAndStartSetupPlugin(this.mVideoUniqueKey);
    }

    public void endSetupPlugin() {
        PlayerSpeedTracker.endSetupPlugin(this.mVideoUniqueKey);
    }

    public void onNetTips(String type, int toastType) {
        BaseVideoPlayerEventUbc.netTips(this.mUbcContent, type, toastType);
    }

    public void onPosterLoad(int loadStatus) {
        BaseVideoPlayerEventUbc.onPosterLoad(this.mUbcContent, loadStatus);
    }

    public void onVolumeComplete() {
        BaseVideoPlayerEventUbc.onVolumeComplete();
    }

    public void onBrightComplete() {
        BaseVideoPlayerEventUbc.onBrightComplete();
    }

    public void onSeekBarDrags(int startPos, int endPos) {
        BaseVideoPlayerEventUbc.onDragSeekBarProgress(this.mUbcContent, startPos, endPos);
    }

    public void onVideoSpeedMenuAction(String type, boolean isFull, String ext) {
        BaseVideoPlayerEventUbc.onVideoSpeedMenuAction(this.mUbcContent, type, isFull, ext);
    }

    public void onSwitchLockMode(boolean isLock) {
        BaseVideoPlayerEventUbc.onSwitchLockMode(this.mUbcContent, isLock);
    }

    public void onLongPressSeek(String seekStatus, String screenStatus) {
        BaseVideoPlayerEventUbc.onLongPressSeek(this.mUbcContent, seekStatus, screenStatus);
    }

    public void onSwitchVolumeMode(boolean isMute) {
        BaseVideoPlayerEventUbc.onSwitchMuteMode(this.mUbcContent, isMute);
    }

    public void onMuteIconPopShow() {
        BaseVideoPlayerEventUbc.onMuteIconPopShow(this.mUbcContent);
    }

    public void onClarityChange(String currentClarity, String toClarity, boolean isFull) {
        BaseVideoPlayerEventUbc.clarityChange(this.mUbcContent, currentClarity, toClarity, isFull);
    }

    public void onBackExit(long startPlayTime) {
        BaseVideoPlayerEventUbc.onBackExit(startPlayTime);
    }

    public void onVideoDownload(int downloadStatus) {
        BaseVideoPlayerEventUbc.onDownloadVideo(this.mUbcContent, VideoDownloadHelper.getUbcDownloadStatus(downloadStatus));
    }

    public void onPanelVisibilityChanged(boolean isFull) {
        BaseVideoPlayerEventUbc.controlPanelShow(this.mUbcContent, isFull);
    }

    public void onVideoPlay(boolean isPlaying) {
        BaseVideoPlayerEventUbc.onVideoPlay(this.mUbcContent, isPlaying);
    }

    public void onShare() {
        BaseVideoPlayerEventUbc.onFullShare(this.mUbcContent);
    }

    public void onChangedBrightVolumeSeek(String type) {
        BaseVideoPlayerEventUbc.onChangedBrightVolumeSeek(this.mUbcContent, type);
    }

    public void switchPlayMode(boolean isFullMode, int switchType) {
        BaseVideoPlayerEventUbc.switchPlayMode(this.mUbcContent, isFullMode, switchType);
    }

    public void onShareAction(String value, boolean isFullStyle) {
        BaseVideoPlayerEventUbc.onVideoShare(this.mUbcContent, value, isFullStyle);
    }

    public void onReplayAction(boolean isFullStyle) {
        BaseVideoPlayerEventUbc.onVideoReplay(this.mUbcContent, isFullStyle);
    }

    public void reload() {
        BaseVideoPlayerEventUbc.onVideoReload(this.mUbcContent);
    }

    public void onPreviousNextClick(String value) {
        BaseVideoPlayerEventUbc.onPreviousNextClick(this.mUbcContent, value);
    }

    public void showGuideLayer(String type, String page) {
        BaseVideoPlayerEventUbc.guideLayerShow(this.mUbcContent, type, page);
    }

    public void buttonClick(String type, String page, String guideType) {
        BaseVideoPlayerEventUbc.guideLayerClick(this.mUbcContent, type, page, guideType);
    }

    public void kernelSwitchClarity(String currentClarity, String targetClarity, String status, int errorCode, int rank, boolean isFull) {
        if (rank >= 0) {
            BaseVideoPlayerEventUbc.kernelSwitchClarity(this.mUbcContent, currentClarity, targetClarity, status, errorCode, isFull);
        }
    }

    public void clickPlayerControlFloating() {
        BaseVideoPlayerEventUbc.onPlayerControlFloatingClick(this.mUbcContent);
    }
}
