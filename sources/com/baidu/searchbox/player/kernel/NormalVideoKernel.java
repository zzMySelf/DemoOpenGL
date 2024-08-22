package com.baidu.searchbox.player.kernel;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.cyberplayer.sdk.DuMediaPlayConstants;
import com.baidu.cyberplayer.sdk.DuMediaRuntimeInfo;
import com.baidu.cyberplayer.sdk.IVideoView;
import com.baidu.cyberplayer.sdk.filter.FilterConfig;
import com.baidu.cyberplayer.sdk.filter.VideoSrConfig;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.BaseDumediaVideoKernel;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.utils.MediaInfoConvert;
import com.baidu.searchbox.player.view.RoundOutlineProvider;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NormalVideoKernel extends BaseDumediaVideoKernel {
    private final BVideoView mVideoView = new BVideoView(BDPlayerConfig.getAppContext());

    NormalVideoKernel() {
    }

    /* access modifiers changed from: protected */
    public void setVideoViewCallBack(DumediaInfoConverter converter) {
        this.mVideoView.setOnCompletionListener(converter);
        this.mVideoView.setOnErrorListener(converter);
        this.mVideoView.setOnInfoListener(converter);
        this.mVideoView.setOnSeekCompleteListener(converter);
        this.mVideoView.setOnPreparedListener(converter);
        this.mVideoView.setOnBufferingUpdateListener(converter);
        this.mVideoView.setOnVideoSizeChangedListener(converter);
        this.mVideoView.setOnMediaSourceChangedListener(converter);
        setZOrderMediaOverlay(true);
    }

    public void setZOrderMediaOverlay(boolean isMediaOverlay) {
        this.mVideoView.setZOrderMediaOverlay(isMediaOverlay);
    }

    public void setDecodeMode(int mode) {
        this.mVideoView.setDecodeMode(mode);
    }

    public int getDecodeMode() {
        return this.mVideoView.getDecodeMode();
    }

    public void setSpeed(float i2) {
        this.mVideoView.setSpeed(i2);
    }

    public void setProxy(String proxy) {
        if (!TextUtils.isEmpty(proxy)) {
            this.mVideoView.setOption("http_proxy", proxy);
            this.mVideoView.setOption("need-t5-auth", "true");
            return;
        }
        this.mVideoView.setOption("http_proxy", "");
        this.mVideoView.setOption("need-t5-auth", "false");
    }

    public void setSRConfig(float config) {
        super.setSRConfig(config);
        VideoSrConfig.SrScale scale = getScale(config);
        if (scale != null) {
            this.mVideoView.setFilterEnable(DuMediaPlayConstants.DuMediaEffectFilter.VIDEO_SR, true);
            VideoSrConfig srConfig = new VideoSrConfig.Builder().scale(scale).build();
            List<FilterConfig> configs = new ArrayList<>();
            configs.add(srConfig);
            this.mVideoView.updateFilterConfig(configs);
            return;
        }
        this.mVideoView.setFilterEnable(DuMediaPlayConstants.DuMediaEffectFilter.VIDEO_SR, false);
    }

    public void updateFreeProxy(String proxy) {
        this.mVideoView.changeProxyDynamic(proxy);
    }

    public View getBVideoView() {
        return this.mVideoView;
    }

    public int getVideoHeight() {
        return this.mVideoView.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.mVideoView.getVideoWidth();
    }

    public int getPositionMs() {
        if (!matchStatus(PlayerStatus.IDLE) || getDuration() - this.mVideoView.getCurrentPosition() > 2) {
            return this.mVideoView.getCurrentPosition();
        }
        return getDurationMs();
    }

    public int getSyncPositionMs() {
        return this.mVideoView.getCurrentPositionSync();
    }

    public int getPosition() {
        if (matchStatus(PlayerStatus.IDLE)) {
            int dur = getDuration() / 1000;
            if (dur - (this.mVideoView.getCurrentPosition() / 1000) <= 2) {
                return dur;
            }
        }
        return this.mVideoView.getCurrentPosition() / 1000;
    }

    public void mute(boolean isMute) {
        this.mVideoView.muteOrUnmuteAudio(isMute);
    }

    public int getBufferingPosition() {
        return this.mBufferingPosition;
    }

    public int getDuration() {
        return this.mVideoView.getDuration() / 1000;
    }

    public int getDurationMs() {
        return this.mVideoView.getDuration();
    }

    public int getPlayedTime() {
        return (int) this.mVideoView.getPlayedTime();
    }

    public void seekToMs(int pos, int seekMode) {
        this.mVideoView.seekTo(pos, seekMode);
    }

    public void setLooping(boolean loop) {
        this.mVideoView.setLooping(loop);
    }

    public void setExternalInfo(String key, Object value) {
        this.mVideoView.setExternalInfo(key, value);
    }

    public void setOption(String key, String value) {
        this.mVideoView.setOption(key, value);
    }

    public void setDynamicOption(String key, String value) {
        this.mVideoView.setOption(key, value);
    }

    public void setVideoRotation(int rotation) {
        this.mVideoView.setVideoRotation(rotation);
    }

    public void setVideoScalingMode(int scalingMode) {
        this.mVideoView.setVideoScalingMode(scalingMode);
    }

    public void onInit() {
        super.onInit();
        this.mVideoView.reset();
        this.mVideoView.setVideoScalingMode(2);
        this.mVideoView.setSpeed(1.0f);
        this.mVideoView.setVideoRotation(0);
        this.mVideoView.setVisibility(0);
        this.mVideoView.setAlpha(1.0f);
        setRemote(true);
    }

    public void onRelease() {
        super.onRelease();
        this.mHeader.clear();
        stopPlayback();
        this.mVideoView.setVisibility(0);
        this.mVideoView.setAlpha(1.0f);
        setKernelCallBack((IKernelPlayer) null);
    }

    public boolean verify(String type) {
        return AbsVideoKernel.NORMAL_PLAYER.equals(type);
    }

    public void play(String videoUrl) {
        super.play(videoUrl);
        if (!InvokerConstants.PRELOAD_PREFIX.equals(videoUrl)) {
            start();
        }
    }

    /* access modifiers changed from: protected */
    public void setDataSourceAndPrepare() {
        this.mVideoView.setVideoURI(getVideoUri(), this.mHeader, getVideoUrlModel().getOptions());
    }

    public void resume() {
        super.resume();
        if (matchStatus(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
            notifyStatusChange(PlayerStatus.PLAYING);
            this.mVideoView.start();
        }
    }

    public void pause() {
        super.pause();
        if (matchStatus(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
            notifyStatusChange(PlayerStatus.PAUSE);
            this.mVideoView.pause();
        }
    }

    public void stop() {
        super.stop();
        stopPlayback();
    }

    public void stopPlayback() {
        super.stopPlayback();
        this.mVideoView.stopPlayback();
    }

    public void start() {
        super.start();
        this.mVideoView.start();
        if (matchStatus(PlayerStatus.COMPLETE)) {
            notifyStatusChange(PlayerStatus.PLAYING);
        }
    }

    public void setClarityInfo(String clarityInfo) {
        this.mVideoView.setClarityInfo(clarityInfo);
    }

    public void switchMediaSource(int rank) {
        this.mVideoView.switchMediaSource(rank);
    }

    public void switchMediaSource(int rank, int mode) {
        if (mode == 1) {
            this.mVideoView.switchMediaSource(rank, DuMediaPlayConstants.DuMediaSourceSwitchMode.MEDIASOURCE_SWITCH_FORCE_MODE);
        } else {
            this.mVideoView.switchMediaSource(rank, DuMediaPlayConstants.DuMediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE);
        }
    }

    public void setRemote(boolean isOpen) {
        this.mVideoView.setRemote(isOpen);
    }

    public void setVideoFormatOptions(String format, HashMap<String, String> options) {
        for (Map.Entry<String, String> entry : options.entrySet()) {
            this.mVideoView.setOption(entry.getKey(), entry.getValue());
        }
    }

    public boolean takeSnapshotAsync(final OnSnapShotFrameListener l, float scale) {
        if (l != null) {
            return this.mVideoView.takeSnapshotAsync(new IVideoView.OnSnapShotCompleteListener() {
                public void onSnapShotComplete(Bitmap bitmap) {
                    l.onSnapShotComplete(bitmap);
                }
            }, scale, 0, 0);
        }
        return false;
    }

    public String getKernelType() {
        return AbsVideoKernel.NORMAL_PLAYER;
    }

    public void setHttpDns(IDnsProcessListener dns) {
        super.setHttpDns(dns);
        this.mVideoView.setHttpDns(new BaseDumediaVideoKernel.CyberPlayerHttpDNS(dns));
    }

    public void setRadius(float radius) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mVideoView.setOutlineProvider(new RoundOutlineProvider(radius));
        }
    }

    public Map<String, String> getKernelInfo() {
        return super.getKernelInfo();
    }

    public KernelMediaInfo getKernelMediaInfo() {
        BVideoView bVideoView = this.mVideoView;
        if (bVideoView != null) {
            return MediaInfoConvert.transform(bVideoView.getMediaInfo());
        }
        return null;
    }

    public void getMediaRuntimeInfo(int type, final OnMediaRuntimeInfoListener runtimeInfoListener) {
        BVideoView bVideoView = this.mVideoView;
        if (bVideoView != null) {
            bVideoView.getMediaRuntimeInfo(type, new DuMediaRuntimeInfo.OnMediaRuntimeInfoDefault() {
                public void onInfo(DuMediaRuntimeInfo cyberRuntimeInfo) {
                    OnMediaRuntimeInfoListener onMediaRuntimeInfoListener = runtimeInfoListener;
                    if (onMediaRuntimeInfoListener != null) {
                        onMediaRuntimeInfoListener.onInfo(MediaInfoConvert.transform(cyberRuntimeInfo));
                    }
                }
            });
        }
    }
}
