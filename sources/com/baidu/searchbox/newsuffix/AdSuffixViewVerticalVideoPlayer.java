package com.baidu.searchbox.newsuffix;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ad.IAdDebugExceptionRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.home.feed.AdVideoDetailImmersiveActivity;
import com.baidu.searchbox.player.callback.SimpleDuMediaCallback;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.helper.HistoryUtils;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.KernelLayer;
import com.baidu.searchbox.player.model.SeriesUtils;
import com.baidu.searchbox.player.model.VideoPlayHistoryItemInfo;
import com.baidu.searchbox.player.utils.KernelExtUtils;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Locale;

public class AdSuffixViewVerticalVideoPlayer extends AdSuffixViewVerticalVideo {
    private int mPrePlayDuration;
    private SimpleDraweeView mVerticalVideoBottomImage;
    private SimpleDraweeView mVerticalVideoCoverBg;
    /* access modifiers changed from: private */
    public FrameLayout mVideoPlayerLayout;

    public AdSuffixViewVerticalVideoPlayer(Context context) {
        super(context);
    }

    public void changeHalfVisibility(boolean isHalf) {
        super.changeHalfVisibility(isHalf);
        final View adLayerContentView = getAdLayerRootView();
        if (adLayerContentView != null) {
            adLayerContentView.post(new Runnable() {
                public void run() {
                    if (AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout != null) {
                        AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout.setLayoutParams(AdSuffixViewVerticalVideoPlayer.this.addVerticalVideoPlayer(adLayerContentView));
                    }
                }
            });
        }
    }

    private View getAdLayerRootView() {
        return this.mContent;
    }

    public void release() {
        saveProgressToDb();
        super.release();
        setBottomAndCoverImgGone();
    }

    public void pause() {
        super.pause();
        if (this.isMAXLandingPage && isAdVideoTransitionSwitchOpen()) {
            int position = getPosition();
            this.mPrePlayDuration = position;
            if (position > 0) {
                saveProgressToDb();
            }
        }
    }

    public boolean isComplete() {
        if (this.mAdKernelLayer == null || this.mAdKernelLayer.getStatus() != PlayerStatus.COMPLETE) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isProgressValid() {
        return this.mVideoDuration > 0;
    }

    public void saveProgressToDb() {
        if (isProgressValid()) {
            int position = 0;
            if (!(isComplete() || getPosition() == this.mVideoDuration)) {
                position = getPosition();
            }
            SeriesUtils.setPosDur(this.mBdVideoSeries, position, this.mVideoDuration);
            HistoryUtils.saveHistoryRecord(this.mBdVideoSeries);
        }
    }

    public void resume() {
        super.resume();
        if (!isShowingTailFrame() && this.isMAXLandingPage && isAdVideoTransitionSwitchOpen() && this.mBdVideoSeries != null) {
            VideoPlayHistoryItemInfo info = VideoPlayerRuntime.getVideoPlayerDBContext().getPlayHistoryById(VideoPlayHistoryItemInfo.genId(this.mBdVideoSeries.getSelectedVideo().getSourceUrl()));
            if (info != null) {
                seekVideoProgress(info);
            } else {
                seekVideoProgressComplete();
            }
        }
    }

    private boolean seekVideoProgressComplete() {
        if (!AdVideoDetailImmersiveActivity.mIsCompletePlayed) {
            return false;
        }
        seekVideoToEnd();
        return true;
    }

    private void seekVideoToEnd() {
        this.mHasPlayTime = this.mVideoDuration - 1;
        this.mVideoADTimer.setText(String.format(Locale.getDefault(), "%ds", new Object[]{Integer.valueOf(this.mDurationTime - this.mHasPlayTime)}));
        if (this.mAdKernelLayer != null) {
            this.mAdKernelLayer.seekTo(this.mVideoDuration);
        }
    }

    private void seekVideoProgress(VideoPlayHistoryItemInfo info) {
        if (!seekVideoProgressComplete() && !TextUtils.isEmpty(info.getVideoCurLength())) {
            try {
                int videoCurLength = Integer.parseInt(info.getVideoCurLength());
                if (videoCurLength >= this.mVideoDuration) {
                    seekVideoToEnd();
                    return;
                }
                this.mHasPlayTime += (videoCurLength - this.mPrePlayDuration) - 1;
                this.mVideoADTimer.setText(String.format(Locale.getDefault(), "%ds", new Object[]{Integer.valueOf(this.mDurationTime - this.mHasPlayTime)}));
                if (this.mAdKernelLayer != null) {
                    this.mAdKernelLayer.seekTo(videoCurLength);
                }
            } catch (NumberFormatException e2) {
                IAdDebugExceptionRuntime.Impl.get().showExceptionDialogAndWriteLog("640视频时长解析有误.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initPlayer() {
        this.mKernelLayer = this.mPlayer.detachKernelLayer();
        this.mAdKernelLayer = new KernelLayer(AbsVideoKernel.NORMAL_PLAYER);
        final View bVideoView = this.mAdKernelLayer.getContentView();
        if (bVideoView == null) {
            IAdDebugExceptionRuntime.Impl.get().showExceptionDialogAndWriteLog("bVideoView为空!");
            return;
        }
        this.mAdKernelLayer.setZOrderMediaOverlay(true);
        if (checkVerticalVideoStyleDataValid()) {
            final View mAdLayerContentView = getAdLayerRootView();
            if (mAdLayerContentView != null) {
                addBottomAndCoverImg(mAdLayerContentView);
                this.mVideoPlayerLayout = new FrameLayout(mAdLayerContentView.getContext());
                mAdLayerContentView.post(new Runnable() {
                    public void run() {
                        if (AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout != null) {
                            AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout.setLayoutParams(AdSuffixViewVerticalVideoPlayer.this.addVerticalVideoPlayer(mAdLayerContentView));
                            AdSuffixViewVerticalVideoPlayer.this.parentRemoveChildView(bVideoView);
                            AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout.addView(bVideoView);
                            AdSuffixViewVerticalVideoPlayer adSuffixViewVerticalVideoPlayer = AdSuffixViewVerticalVideoPlayer.this;
                            adSuffixViewVerticalVideoPlayer.parentRemoveChildView(adSuffixViewVerticalVideoPlayer.mVideoPlayerLayout);
                            AdSuffixViewVerticalVideoPlayer.this.mContent.addView(AdSuffixViewVerticalVideoPlayer.this.mVideoPlayerLayout);
                        }
                    }
                });
            } else {
                return;
            }
        }
        this.mMainPlayerMute = this.mPlayer.isMute();
        onMuteChanged();
        this.mAdKernelLayer.mute(this.mMainPlayerMute);
        if (!this.mMainPlayerMute) {
            requestAudioFocus();
        }
        if (!(this.mAdItemModel == null || this.mAdItemModel.videoInfo == null)) {
            updateVideoPlayUrl(this.mBdVideoSeries, this.mAdItemModel.videoInfo.videoUrl);
            this.mAdKernelLayer.setVideoSeries(this.mBdVideoSeries);
        }
        KernelExtUtils.setPageInfo(this.mAdKernelLayer, this.mBdVideoSeries, 23);
        this.mAdKernelLayer.setKernelCallBack(new SimpleDuMediaCallback() {
            public boolean onMediaSourceChanged(int i2, int i1, Object o) {
                return false;
            }

            public void onBufferingUpdate(int i2) {
            }

            public void onCompletion() {
                String cmd;
                if (AdSuffixViewVerticalVideoPlayer.this.mAdItemModel != null) {
                    if (AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.button != null) {
                        cmd = AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.button.cmd;
                    } else {
                        cmd = AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.cmd;
                    }
                    AdSuffixViewVerticalVideoPlayer adSuffixViewVerticalVideoPlayer = AdSuffixViewVerticalVideoPlayer.this;
                    adSuffixViewVerticalVideoPlayer.showTail(adSuffixViewVerticalVideoPlayer.mAdItemModel, cmd);
                }
                AdSuffixViewVerticalVideoPlayer.this.setBottomAndCoverImgGone();
            }

            public boolean onError(int i2, int i1, Object o) {
                AdSuffixViewVerticalVideoPlayer.this.setPosterVisibility(0);
                AdSuffixViewVerticalVideoPlayer.this.setBottomAndCoverImgGone();
                return false;
            }

            public boolean onInfo(int i2, int i1, Object o) {
                if (904 == i2 || 956 == i2) {
                    AdSuffixViewVerticalVideoPlayer.this.mAdKernelLayer.getVideoKernel().notifyStatusChange(PlayerStatus.PLAYING);
                    AdSuffixViewVerticalVideoPlayer.this.initVideoViewPlaceHolder();
                    AdSuffixViewVerticalVideoPlayer.this.setVerticalVideoBottomImg(0);
                    AdSuffixViewVerticalVideoPlayer.this.setBgViewVisibility();
                    AdSuffixViewVerticalVideoPlayer.this.setPosterVisibility(4);
                    AdSuffixViewVerticalVideoPlayer.this.reportUbcFirstFrame();
                    if (AdSuffixViewVerticalVideoPlayer.this.mAdItemModel != null) {
                        Als.send(new Als.Builder().setPage(AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.daPage.value).setExtraParam(AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.ext).setType(Als.LogType.VIDEO_START).setExt1("0").setExt3(String.valueOf(AdSuffixViewVerticalVideoPlayer.this.mAdItemModel.duration)));
                    }
                }
                if (910 == i2) {
                    AdSuffixViewVerticalVideoPlayer.this.updateVideoPosModel();
                }
                return false;
            }

            public void onPrepared() {
                AdSuffixViewVerticalVideoPlayer.this.setBottomAndCoverImgGone();
            }

            public void onSeekComplete() {
            }

            public void onVideoSizeChanged(int i2, int i1, int i22, int i3) {
            }
        });
    }

    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams addVerticalVideoPlayer(View mAdLayerContentView) {
        if (this.mAdItemModel == null || this.mAdItemModel.videoAdItemVerticalStyleModel == null) {
            return null;
        }
        FrameLayout.LayoutParams videoPlayerLp = new FrameLayout.LayoutParams(-1, -1);
        updatePlayerSize(videoPlayerLp, mAdLayerContentView);
        updatePlayerOrientationPosition(videoPlayerLp, mAdLayerContentView.getMeasuredWidth());
        updatePlayerPortraitPosition(videoPlayerLp, mAdLayerContentView.getMeasuredHeight());
        return videoPlayerLp;
    }

    private void updatePlayerSize(ViewGroup.LayoutParams params, View layerContentView) {
        double playerWidthRatio = this.mAdItemModel.videoAdItemVerticalStyleModel.playerWidthRatio;
        if (playerWidthRatio <= 0.0d || playerWidthRatio > 1.0d) {
            params.width = (int) (((float) layerContentView.getMeasuredHeight()) * 0.5625f);
            params.height = layerContentView.getMeasuredHeight();
            return;
        }
        params.width = (int) (((double) layerContentView.getMeasuredWidth()) * playerWidthRatio);
        params.height = (int) (((float) params.width) / 0.5625f);
        if (this.mAdKernelLayer != null) {
            this.mAdKernelLayer.setVideoScalingMode(0);
        }
    }

    private void updatePlayerOrientationPosition(FrameLayout.LayoutParams params, int containerWidth) {
        double rightMarginRatio = this.mAdItemModel.videoAdItemVerticalStyleModel.rightMarginRatio;
        int playerPosition = this.mAdItemModel.videoAdItemVerticalStyleModel.playerPosition;
        if (rightMarginRatio >= 0.0d) {
            int playerMarginRight = (int) (((double) containerWidth) * rightMarginRatio);
            if (containerWidth - playerMarginRight <= params.width) {
                params.gravity = 8388627;
                return;
            }
            params.gravity = 8388629;
            params.rightMargin = playerMarginRight;
        } else if (playerPosition == 0) {
            params.gravity = 8388629;
        } else if (playerPosition == 1) {
            params.gravity = 17;
        } else if (playerPosition == 2) {
            params.gravity = 8388627;
        }
    }

    private void updatePlayerPortraitPosition(FrameLayout.LayoutParams params, int containerHeight) {
        double playerHeightRatio = this.mAdItemModel.videoAdItemVerticalStyleModel.playerHeightRatio;
        if (playerHeightRatio > 0.0d && playerHeightRatio < 1.0d) {
            if (playerHeightRatio > 0.5d) {
                params.bottomMargin = (params.height / 2) - Math.max((int) ((1.0d - playerHeightRatio) * ((double) params.height)), containerHeight / 2);
                return;
            }
            params.topMargin = Math.min((int) ((1.0d - playerHeightRatio) * ((double) params.height)), params.height - (containerHeight / 2)) - (params.height / 2);
        }
    }

    /* access modifiers changed from: private */
    public void initVideoViewPlaceHolder() {
        if (this.mAdItemModel != null && this.mAdItemModel.videoAdItemVerticalStyleModel != null && getAdLayerRootView() != null) {
            this.mPlayerPlaceHolder = new View(getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1);
            updatePlayerSize(params, getAdLayerRootView());
            params.height = Math.min(getAdLayerRootView().getMeasuredHeight(), params.height);
            updatePlayerOrientationPosition(params, getAdLayerRootView().getMeasuredWidth());
            AdUtil.removeChildViewFromParent(this.mPlayerPlaceHolder);
            addView(this.mPlayerPlaceHolder, params);
        }
    }

    private void addBottomAndCoverImg(View adLayerContentView) {
        if (adLayerContentView != null) {
            FrameLayout bottomLayout = new FrameLayout(adLayerContentView.getContext());
            FrameLayout.LayoutParams bottomLp = new FrameLayout.LayoutParams(-1, -1);
            this.mVerticalVideoBottomImage = new SimpleDraweeView(adLayerContentView.getContext());
            String bottomPicture = this.mAdItemModel.videoAdItemVerticalStyleModel.bottomPicture;
            if (!checkVerticalVideoStyleDataValid() || TextUtils.isEmpty(bottomPicture)) {
                this.mVerticalVideoBottomImage.setVisibility(8);
            } else {
                this.mVerticalVideoBottomImage.setVisibility(0);
                this.mVerticalVideoBottomImage.setImageURI(bottomPicture);
            }
            this.mVerticalVideoBottomImage.setLayoutParams(bottomLp);
            parentRemoveChildView(this.mVerticalVideoBottomImage);
            bottomLayout.addView(this.mVerticalVideoBottomImage);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(adLayerContentView.getContext());
            this.mVerticalVideoCoverBg = simpleDraweeView;
            simpleDraweeView.setBackgroundColor(adLayerContentView.getContext().getResources().getColor(R.color.tail_background_color));
            this.mVerticalVideoCoverBg.setLayoutParams(bottomLp);
            parentRemoveChildView(this.mVerticalVideoCoverBg);
            bottomLayout.addView(this.mVerticalVideoCoverBg);
            parentRemoveChildView(bottomLayout);
            this.mContent.addView(bottomLayout);
        }
    }

    public boolean checkVerticalVideoStyleDataValid() {
        return (this.mAdItemModel == null || this.mAdItemModel.videoAdItemVerticalStyleModel == null) ? false : true;
    }

    public boolean shouldShowCover() {
        if (!checkVerticalVideoStyleDataValid() || this.mAdItemModel.videoAdItemVerticalStyleModel.coverShadowSwitch != 1) {
            return false;
        }
        return true;
    }

    public void setBgViewVisibility() {
        if (shouldShowCover()) {
            setVerticalVideoCoverImg(0);
        } else {
            setVerticalVideoCoverImg(8);
        }
    }

    public void setVerticalVideoCoverImg(int visibility) {
        SimpleDraweeView simpleDraweeView = this.mVerticalVideoCoverBg;
        if (simpleDraweeView != null) {
            simpleDraweeView.setVisibility(visibility);
        }
    }

    public void setVerticalVideoBottomImg(int visibility) {
        SimpleDraweeView simpleDraweeView = this.mVerticalVideoBottomImage;
        if (simpleDraweeView != null) {
            simpleDraweeView.setVisibility(visibility);
        }
    }

    /* access modifiers changed from: private */
    public void setBottomAndCoverImgGone() {
        setVerticalVideoCoverImg(8);
        setVerticalVideoBottomImg(8);
    }
}
