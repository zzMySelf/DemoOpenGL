package com.baidu.searchbox.video.payment.videodetail;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.controller.datachannel.FeedDataChannelSubType;
import com.baidu.searchbox.feed.event.VideoContinuePlayEvent;
import com.baidu.searchbox.feed.payment.DataChannelConstants;
import com.baidu.searchbox.player.callback.CommentInputCallback;
import com.baidu.searchbox.player.callback.IAirPlayerListener;
import com.baidu.searchbox.player.callback.IPlayNextVideoCallback;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.OnShareListener;
import com.baidu.searchbox.player.callback.SimpleAirPlayerListener;
import com.baidu.searchbox.player.callback.SimpleVideoPlayerCallback;
import com.baidu.searchbox.player.model.ShareMeta;
import com.baidu.searchbox.player.plugin.utils.MPDUtil;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.searchbox.player.utils.BdNetUtils;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.component.BasePlayerComponent;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.IVideoPerformanceFlowUtils;
import com.baidu.searchbox.video.detail.export.IVideoRouter;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.detail.export.IVideoSender;
import com.baidu.searchbox.video.detail.export.IVideoUiThreadUtils;
import com.baidu.searchbox.video.detail.inf.SchemeCallbackHandler;
import com.baidu.searchbox.video.detail.listener.PayCallBack;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.model.PaymentSpecialColumnModel;
import com.baidu.searchbox.video.detail.model.ShareSource;
import com.baidu.searchbox.video.detail.plugin.component.player.servcie.local.ILocalPlayerService;
import com.baidu.searchbox.video.detail.protocol.Component;
import com.baidu.searchbox.video.detail.service.ICommentService;
import com.baidu.searchbox.video.detail.service.ILinkageLayoutService;
import com.baidu.searchbox.video.detail.service.IMenuService;
import com.baidu.searchbox.video.detail.service.INextPlayService;
import com.baidu.searchbox.video.detail.service.IPayService;
import com.baidu.searchbox.video.detail.service.IPaymentSpecialColumnService;
import com.baidu.searchbox.video.detail.service.IPlayerService;
import com.baidu.searchbox.video.detail.service.IShareService;
import com.baidu.searchbox.video.detail.utils.BdVideoSeriesFactory;
import com.baidu.searchbox.video.detail.utils.UBC1077;
import com.baidu.searchbox.video.detail.utils.VideoDetailExtUtils;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import com.baidu.searchbox.video.detail.utils.VideoSharedPrefsUtils;
import com.baidu.searchbox.video.payment.player.AbsVideoPaymentPlayerCallback;
import com.baidu.searchbox.video.payment.player.VideoPaymentFetchUrlCallback;
import com.baidu.searchbox.video.payment.player.VideoPaymentPlayer;
import com.baidu.searchbox.video.payment.player.VideoPaymentUrlCalibrateHelper;
import com.baidu.searchbox.video.payment.player.VideoPaymentUrlModel;
import com.baidu.searchbox.video.payment.player.listener.PayCountDownListener;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeriesEx;
import com.baidu.searchbox.video.videoplayer.event.VideoActionEvent;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public class VideoPaymentPlayerComponent extends BasePlayerComponent {
    private static final String KEY_IS_PAID_VIDEO = "is_paid_video";
    private static final int PLAY_AUDITION_TOAST_LIMIT = 50;
    private static final String TAG = "VideoPaymentPlayerComponent";
    public static boolean isOnResume;
    /* access modifiers changed from: private */
    public boolean forceSwitchHalfByAirPlay = false;
    private ImageView mAirPlayIcon;
    private final IAirPlayerListener mAirPlayListener = new SimpleAirPlayerListener() {
        public void onPlayEnd() {
            ICommentService commentService;
            VideoPaymentPlayerComponent.this.onPlayingNext(0);
            if (VideoPaymentPlayerComponent.this.isCommentInputShowing() && (commentService = (ICommentService) VideoPaymentPlayerComponent.this.mComponentManager.getService(ICommentService.class)) != null) {
                commentService.dismissCommentInput();
            }
            IShareService shareService = (IShareService) VideoPaymentPlayerComponent.this.mComponentManager.getService(IShareService.class);
            if (shareService != null) {
                shareService.hide();
            }
        }

        public void onPlayFirstDisplay() {
            VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_FIRST_DISPLAY, 0, (Object) null));
        }

        public void onPlayPause() {
            VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_PAUSE, 0, (Object) null));
        }

        public void onPlayResume() {
            super.onPlayResume();
            VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_RESUME, 0, (Object) null));
        }

        public void onClick() {
            if (VideoPaymentPlayerComponent.this.mPlayer != null && VideoPaymentPlayerComponent.this.mPlayer.isFullMode()) {
                boolean unused = VideoPaymentPlayerComponent.this.forceSwitchHalfByAirPlay = true;
                VideoPaymentPlayerComponent.this.mPlayer.switchToHalf();
            }
        }
    };
    private final Object mContinuePlayObj = new Object();
    /* access modifiers changed from: private */
    public boolean mHasCloseUbcFlow;
    /* access modifiers changed from: private */
    public boolean mHasReportPlayerException = false;
    protected AbsVideoPaymentPlayerCallback mIBaseVideoPlayerCallback = new AbsVideoPaymentPlayerCallback() {
        public void onVideoSwitchToHalf() {
            VideoPaymentPlayerComponent.this.notifyPlayerOrientationChanged(true);
            if (VideoPaymentPlayerComponent.this.forceSwitchHalfByAirPlay) {
                boolean unused = VideoPaymentPlayerComponent.this.forceSwitchHalfByAirPlay = false;
                VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_CLICK, 0, (Object) null));
            }
        }

        public void onVideoSwitchToFull() {
            VideoPaymentPlayerComponent.this.notifyPlayerOrientationChanged(false);
            VideoSharedPrefsUtils.putLong("switch_to_full_screen_time", System.currentTimeMillis());
        }

        public void onPanelVisibilityChanged(boolean isVisible) {
            if (isVisible || VideoPaymentPlayerComponent.this.mRightTopHolderView != null) {
                if (VideoPaymentPlayerComponent.this.mRightTopHolderView == null) {
                    initRightTopHolder();
                    if (VideoPaymentPlayerComponent.this.mPlayer != null && VideoPaymentPlayerComponent.this.mPlayer.isAlbumPaid()) {
                        VideoPaymentPlayerComponent.this.initAirPlayIconView();
                    }
                    VideoPaymentPlayerComponent.this.initMoreIconView();
                } else {
                    VideoPaymentPlayerComponent.this.mRightTopHolderView.bringToFront();
                }
                int i2 = 0;
                if (isVisible || (VideoPaymentPlayerComponent.this.mPlayer != null && (VideoPaymentPlayerComponent.this.mPlayer.isComplete() || VideoPaymentPlayerComponent.this.mPlayer.isError() || VideoPaymentPlayerComponent.this.mPlayer.isNetTipLayerVisible()))) {
                    VideoPaymentPlayerComponent.this.setIconVisibility(0);
                    return;
                }
                VideoPaymentPlayerComponent videoPaymentPlayerComponent = VideoPaymentPlayerComponent.this;
                if (!videoPaymentPlayerComponent.mIsPlayError) {
                    i2 = 4;
                }
                videoPaymentPlayerComponent.setIconVisibility(i2);
            }
        }

        private void initRightTopHolder() {
            LinearLayout unused = VideoPaymentPlayerComponent.this.mRightTopHolderView = new LinearLayout(VideoPaymentPlayerComponent.this.mContext);
            VideoPaymentPlayerComponent.this.mRightTopHolderView.setOrientation(0);
            FrameLayout.LayoutParams holderParams = new FrameLayout.LayoutParams(-2, -2);
            holderParams.topMargin = IVideoScreenInfoUtils.Impl.get().dp2px(10.0f);
            holderParams.rightMargin = IVideoScreenInfoUtils.Impl.get().dp2px(15.0f);
            holderParams.gravity = GravityCompat.END;
            VideoPaymentPlayerComponent.this.mPlayerHolderView.addView(VideoPaymentPlayerComponent.this.mRightTopHolderView, holderParams);
            VideoPaymentPlayerComponent.this.mRightTopHolderView.bringToFront();
        }

        public void onVideoUrlExpire() {
            VideoPaymentUrlCalibrateHelper.getInstance().fetchRealPaymentUrl(VideoPaymentPlayerComponent.this.getVid(), VideoPaymentPlayerComponent.this.getAlbumId());
            VideoPaymentUrlCalibrateHelper.getInstance().registerUrlFetcherListener(new VideoPaymentFetchUrlCallback() {
                public void onFetchUrlSuccess(VideoPaymentUrlModel data) {
                    if (VideoPaymentPlayerComponent.this.mPlayer != null) {
                        IVideoUiThreadUtils.Impl.get().runOnUiThread(new Runnable() {
                            public void run() {
                                if (VideoPaymentPlayerComponent.this.mIsActivityOnResume) {
                                    VideoPaymentPlayerComponent.this.mPlayer.doParentPlay();
                                } else {
                                    VideoPaymentPlayerComponent.this.mPlayer.pause();
                                }
                            }
                        });
                        BdVideoSeries series = VideoPaymentPlayerComponent.this.mPlayer.getVideoSeries();
                        if (series != null) {
                            BdVideoSeriesEx.setUrlExpireLongTime(series, data.mUrlExpireTime.longValue());
                            series.setClarityUrlList(data.mClarityListStr);
                            series.setPlayConf(data.mPlayConfStr);
                            VideoPaymentPlayerComponent.this.mPlayer.updateVideoSeries(series);
                        }
                    }
                }

                public void onFetchUrlFail() {
                    if (VideoPaymentPlayerComponent.this.mPlayer != null) {
                        VideoPaymentPlayerComponent.this.mPlayer.showFetchVideoUrlError();
                    }
                }
            });
        }

        public void onPayment() {
            IPayService payService = (IPayService) VideoPaymentPlayerComponent.this.mComponentManager.getService(IPayService.class);
            if (payService == null) {
                return;
            }
            if (VideoPaymentPlayerComponent.this.mPlayer.getColumnModel().isCanSinglePaid()) {
                payService.startSinglePayment(new PayCallBack() {
                    public void paymentStateCallback(int state) {
                        VideoPaymentPlayerComponent.this.updateState(VideoPaymentPlayerComponent.this.mPlayer, state);
                    }
                }, true);
            } else {
                payService.startPayment(new PayCallBack() {
                    public void paymentStateCallback(int state) {
                        VideoPaymentPlayerComponent.this.updateState(VideoPaymentPlayerComponent.this.mPlayer, state);
                    }
                });
            }
        }
    };
    protected boolean mIsActivityOnResume;
    private boolean mIsFirstDisplayReady;
    /* access modifiers changed from: private */
    public boolean mIsPlayError;
    /* access modifiers changed from: private */
    public int mMaxPlayPosition = 0;
    private ImageView mMoreIcon;
    protected IPlayNextVideoCallback mPlayNextVideoCallback = new IPlayNextVideoCallback() {
        public void playNext(int clkType) {
            VideoPaymentPlayerComponent.this.onPlayingNext(clkType);
        }
    };
    protected VideoPaymentPlayer mPlayer;
    protected FrameLayout mPlayerHolderView;
    private final OnShareListener mPlayerShareListener = new OnShareListener() {
        public void share(ShareMeta shareMeta) {
            IShareService service = (IShareService) VideoPaymentPlayerComponent.this.mComponentManager.getService(IShareService.class);
            if (VideoDetailExtUtils.isNotNull(service) && VideoDetailExtUtils.isNotNull(VideoPaymentPlayerComponent.this.mComponentManager.currentModel.commonModel) && VideoDetailExtUtils.isNotNull(VideoPaymentPlayerComponent.this.mComponentManager.currentModel.commonModel.mShareInfo) && VideoDetailExtUtils.isNotNull(shareMeta)) {
                service.share(shareMeta.getMediaType(), ShareSource.PLAYER_BUTTON);
            }
        }
    };
    private SimpleDraweeView mPosterView;
    private int mRefreshStyle;
    /* access modifiers changed from: private */
    public LinearLayout mRightTopHolderView;
    private ScreenLockReceiver mScreenLockReceiver;
    /* access modifiers changed from: private */
    public int mVideoDuration = 0;
    private final Object mVideoEventObj = new Object();
    protected IVideoPlayerCallback mVideoPlayerCallback = new DetailNaPlayerCallBack();

    public View getView() {
        this.mPlayerHolderView = new FrameLayout(this.mContext);
        this.mPlayerHolderView.setLayoutParams(new ViewGroup.LayoutParams(-1, ((Math.min(IVideoScreenInfoUtils.Impl.get().getDisplayWidth(), IVideoScreenInfoUtils.Impl.get().getDisplayHeight()) * 9) / 16) + 2));
        if (this.mPosterView == null) {
            this.mPosterView = new SimpleDraweeView(this.mContext);
            this.mPlayerHolderView.addView(this.mPosterView, new FrameLayout.LayoutParams(-1, -1));
        }
        return this.mPlayerHolderView;
    }

    public void onNewIntent(Intent intent) {
        updateVideoDataSource(false);
        VideoDetailUbcExtUtils.setFromOutside(false);
    }

    public void onNightModeChanged(boolean isNightMode) {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.onNightModeChanged(isNightMode);
        }
    }

    public void onCreate() {
        BdVideoSeries series = null;
        IntentData intentData = this.mComponentManager.currentModel.intentData;
        if (intentData != null) {
            series = createVideoSeries(intentData.getVideoInfo());
        }
        if (series != null) {
            initVideoPlayer(series);
            showPoster(series);
        }
        registerContinuePlayEvent();
        registerVideoAction();
        initLockScreenReceiver();
    }

    public void bindData(JSONObject data) {
        if (this.mComponentManager.currentModel.commonModel != null && !this.mComponentManager.currentModel.commonModel.offLine) {
            if (5 == this.mRefreshStyle) {
                this.mRefreshStyle = -1;
                return;
            }
            this.mComponentManager.notify(MessageUtils.obtainPerformanceMessage(MessageManifest.Performance.PLAYER_BEFORE));
            BdVideoSeries series = null;
            String videoInfo = this.mComponentManager.currentModel.commonModel.playVideoInfo;
            if (!TextUtils.isEmpty(videoInfo)) {
                series = createVideoSeries(videoInfo);
            }
            if (series == null || !initVideoPlayer(series)) {
                if (IVideoAppConfig.Impl.get().isDebug()) {
                    UniversalToast.makeText(this.mContext.getApplicationContext(), (CharSequence) "PlayerComponent: Player Create Fail, Exit").showToast();
                }
                this.mComponentManager.finish();
                return;
            }
            addIsPaidVideo(series);
            this.mComponentManager.notify(MessageUtils.obtainPerformanceMessage(MessageManifest.Performance.PLAYER_AFTER));
            setupPlayer(series);
        }
    }

    private BdVideoSeries createVideoSeries(String videoInfo) {
        BdVideoSeries series = BdVideoSeriesFactory.createVideoSeries(videoInfo);
        if (series == null) {
            this.mComponentManager.notify(MessageUtils.obtainLandingStabilityMessage(MessageManifest.LandingStability.EXT_EXCEPTION, getPd(), new String[0]));
        }
        return series;
    }

    private void showPoster(BdVideoSeries series) {
        if (series != null && !TextUtils.isEmpty(series.getPoster())) {
            InvokerUtils.getPrefetchBitmap(series.getPoster(), this.mPosterView, new InvokerUtils.GetPrefetchBitmapListener());
        }
    }

    private void addIsPaidVideo(BdVideoSeries series) {
        JSONObject jsonObject;
        String extLog = series.getExtLog();
        try {
            if (TextUtils.isEmpty(extLog)) {
                jsonObject = new JSONObject();
            } else {
                jsonObject = new JSONObject(extLog);
            }
            jsonObject.put(KEY_IS_PAID_VIDEO, "1");
            series.setExtLog(jsonObject.toString());
        } catch (JSONException e2) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean initVideoPlayer(BdVideoSeries series) {
        if (series == null) {
            return false;
        }
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer == null) {
            this.mPlayer = new VideoPaymentPlayer(series.getNid(), series.getNid());
            return true;
        }
        videoPaymentPlayer.setVideoUniqueKey(series.getNid());
        return true;
    }

    public void onResume() {
        VideoPaymentPlayer videoPaymentPlayer;
        VideoPaymentPlayer videoPaymentPlayer2 = this.mPlayer;
        if (videoPaymentPlayer2 != null) {
            this.mPlayer.goBackOrForeground(true, videoPaymentPlayer2.isAirPlayDeviceListShowing() || this.mPlayer.isAirPlayLayerShowing());
        }
        ILinkageLayoutService service = (ILinkageLayoutService) this.mComponentManager.getService(ILinkageLayoutService.class);
        if (service != null && service.isTopShown() && service.isScrollTopEdge() && (videoPaymentPlayer = this.mPlayer) != null && videoPaymentPlayer.isComplete()) {
            this.mPlayer.resumeContinuePlay();
        }
        this.mIsActivityOnResume = true;
    }

    public void onPause() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.goBackOrForeground(false);
        }
        this.mIsActivityOnResume = false;
        unregisterLockScreenReceiver();
        if (this.mComponentManager.currentModel.intentData.isFromFeed && !this.mHasCloseUbcFlow) {
            endUBCFlow();
        }
        IVideoPerformanceFlowUtils.Impl.get().resetFlow(IntentData.getNid(this.mComponentManager.currentModel.intentData));
    }

    public void onStop() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null && !videoPaymentPlayer.isPause()) {
            this.mPlayer.goBackOrForeground(false);
        }
    }

    public void onDestroy() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.stop();
            this.mPlayer.resetDefaultSwitchHelper();
            this.mPlayer.getPlayerCallbackManager().release();
            this.mPlayer.detachFromContainer();
            this.mPlayer.release();
            this.mPlayer = null;
        }
        unregisterContinuePlayEvent();
        unregisterVideoAction();
        unregisterFetchVideoUrlListener();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        VideoPaymentPlayer videoPaymentPlayer;
        if (keyCode != 4 || (videoPaymentPlayer = this.mPlayer) == null) {
            return false;
        }
        if (!videoPaymentPlayer.isFullMode()) {
            return isShowLimitFreeToast();
        }
        this.mPlayer.switchToHalf(3);
        return true;
    }

    public void injectService() {
        super.injectService();
        this.mComponentManager.registerServices(IPlayerService.class, new VideoPaymentPlayerService(this));
        this.mComponentManager.registerServices(ILocalPlayerService.class, new VideoPaymentLocalPlayerService(this));
    }

    public String getName() {
        return "player";
    }

    public String getLayout() {
        return Component.Player.FEED_VIDEO_LAYOUT;
    }

    public void setRefreshStyle(int refreshStyle) {
        this.mRefreshStyle = refreshStyle;
    }

    /* access modifiers changed from: protected */
    public boolean isCommentInputShowing() {
        ICommentService service = (ICommentService) this.mComponentManager.getService(ICommentService.class);
        if (service != null) {
            return service.isShowingCommentInput();
        }
        return false;
    }

    private void updateVideoDataSource(boolean autoPlay) {
        BdVideoSeries series = BdVideoSeriesFactory.createVideoSeries(this.mComponentManager.currentModel.intentData.getVideoInfo());
        if (this.mPlayer != null && series != null) {
            PlayerSpeedTracker.startAfterInitToPlayPart(series.getNid());
            this.mPlayer.stop();
            this.mIsFirstDisplayReady = false;
            MPDUtil.setRequestMode(series, 2);
            this.mPlayer.setVideoSeries(series);
            this.mPlayer.start(autoPlay);
        }
    }

    public boolean isFullScreen() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        return videoPaymentPlayer != null && videoPaymentPlayer.isFullMode();
    }

    public boolean isFirstDisplayReady() {
        return this.mIsFirstDisplayReady;
    }

    private void unregisterFetchVideoUrlListener() {
        VideoPaymentUrlCalibrateHelper.getInstance().unRegisterUrlFetcherListener();
    }

    private class DetailNaPlayerCallBack extends SimpleVideoPlayerCallback {
        private DetailNaPlayerCallBack() {
        }

        public void onStart() {
            super.onStart();
            VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.Player.PLAYER_MESSAGE, MessageManifest.Player.START, 1, (Object) null));
        }

        public void onInfo(int what, int extra) {
            super.onInfo(what, extra);
            if (what == 904 || 956 == what) {
                VideoPaymentPlayerComponent.this.handleFirstDisplay();
                if (!VideoPaymentPlayerComponent.this.mIsActivityOnResume && VideoPaymentPlayerComponent.this.mPlayer != null) {
                    VideoPaymentPlayerComponent.this.mPlayer.pause();
                }
                IVideoPerformanceFlowUtils.Impl.get().addEvent("6");
                IntentData mIntentData = VideoPaymentPlayerComponent.this.mComponentManager.currentModel.intentData;
                if (mIntentData != null && mIntentData.isFromFeed && !VideoPaymentPlayerComponent.this.mHasCloseUbcFlow) {
                    VideoPaymentPlayerComponent.this.endUBCFlow();
                }
                boolean unused = VideoPaymentPlayerComponent.this.mIsPlayError = false;
                if (VideoPaymentPlayerComponent.this.mPlayer != null) {
                    if (VideoPaymentPlayerComponent.this.mPlayer.isShowLimitFreeTip()) {
                        VideoPaymentPlayerComponent.this.mPlayer.showLimitFreeTips();
                        VideoPaymentPlayerComponent videoPaymentPlayerComponent = VideoPaymentPlayerComponent.this;
                        videoPaymentPlayerComponent.sendVideoWatchedFreeNumBroadcast(videoPaymentPlayerComponent.mPlayer.getVideoLimitFreeWatchedNum());
                    } else if (VideoPaymentPlayerComponent.this.mPlayer.checkVideoPreviewEnable()) {
                        VideoPaymentPlayerComponent.this.mPlayer.showPreviewTips();
                        if (VideoPaymentPlayerComponent.this.mPlayer.isShowLimitFreePopup()) {
                            boolean unused2 = VideoPaymentPlayerComponent.this.showLimitFreePopup();
                        }
                    }
                }
                IntentData intentData = VideoPaymentPlayerComponent.this.mComponentManager.currentModel.intentData;
                if (intentData != null && "2".equals(intentData.landscapeType)) {
                    intentData.landscapeType = "";
                    VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_CLICK, 0, (Object) null));
                }
            }
        }

        public void onError(int what, int extra, String info) {
            super.onError(what, extra, info);
            boolean unused = VideoPaymentPlayerComponent.this.mIsPlayError = true;
            VideoPaymentPlayerComponent.this.setIconVisibility(0);
            if (BdNetUtils.isNetUp() && !VideoPaymentPlayerComponent.this.mPlayer.isFree() && !VideoPaymentPlayerComponent.this.mPlayer.isAlbumPaid() && VideoPaymentUrlCalibrateHelper.getInstance().checkUrlInvalid(VideoPaymentPlayerComponent.this.mPlayer.getVideoExpireTime())) {
                VideoPaymentUrlCalibrateHelper.getInstance().fetchRealPaymentUrl(VideoPaymentPlayerComponent.this.getVid(), VideoPaymentPlayerComponent.this.getAlbumId());
                VideoPaymentUrlCalibrateHelper.getInstance().registerUrlFetcherListener(new VideoPaymentFetchUrlCallback() {
                    public void onFetchUrlSuccess(VideoPaymentUrlModel data) {
                        BdVideoSeries series = VideoPaymentPlayerComponent.this.mPlayer.getVideoSeries();
                        if (series != null) {
                            BdVideoSeriesEx.setUrlExpireLongTime(series, data.mUrlExpireTime.longValue());
                            series.setClarityUrlList(data.mClarityListStr);
                            series.setPlayConf(data.mPlayConfStr);
                            VideoPaymentPlayerComponent.this.mPlayer.updateVideoSeries(series);
                        }
                    }

                    public void onFetchUrlFail() {
                    }
                });
            }
            if (!VideoPaymentPlayerComponent.this.mHasReportPlayerException) {
                VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtainLandingStabilityMessage(MessageManifest.LandingStability.PLAYER_ERROR_EXCEPTION, VideoPaymentPlayerComponent.this.getPd(), new String[0]));
                boolean unused2 = VideoPaymentPlayerComponent.this.mHasReportPlayerException = true;
            }
        }

        public void onSeekEnd() {
        }

        public void onEnd(int what) {
            super.onEnd(what);
            if (307 == what && VideoPaymentPlayerComponent.this.mPlayer != null) {
                ILinkageLayoutService service = (ILinkageLayoutService) VideoPaymentPlayerComponent.this.mComponentManager.getService(ILinkageLayoutService.class);
                if (service == null || !service.isScrollTopEdge()) {
                    VideoPaymentPlayerComponent.this.mPlayer.stopContinuePlay();
                } else {
                    VideoPaymentPlayerComponent.this.mPlayer.resumeContinuePlay();
                }
            }
        }

        public void onUpdateProgress(int position, int buffer, int max) {
            if (VideoPaymentPlayerComponent.this.mVideoDuration != max) {
                VideoPaymentPlayerComponent.this.sendFinishRate2DataChannel();
                int unused = VideoPaymentPlayerComponent.this.mVideoDuration = max;
            }
            if (position > VideoPaymentPlayerComponent.this.mMaxPlayPosition) {
                int unused2 = VideoPaymentPlayerComponent.this.mMaxPlayPosition = position;
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleFirstDisplay() {
        this.mIsFirstDisplayReady = true;
        this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.Player.PLAYER_MESSAGE, MessageManifest.Player.FIRST_DISPLAY, 1, (Object) null));
    }

    public void endUBCFlow() {
        IntentData intentData = this.mComponentManager.currentModel.intentData;
        if (intentData != null) {
            String page = IVideoDependConstManager.Impl.get().getStringConst("4");
            String type = IVideoDependConstManager.Impl.get().getStringConst("5");
            String from = IVideoDependConstManager.Impl.get().getStringConst("6");
            IVideoPerformanceFlowUtils.Impl.get().setValue(IVideoPerformanceFlowUtils.Impl.get().getPerformanceContentString(page, type, intentData.defaultVideoUrl, "", from, IntentData.getNid(intentData), IVideoPerformanceFlowUtils.Impl.get().getPerformanceExtra(this.mContext, "", intentData.extLog)));
            IVideoPerformanceFlowUtils.Impl.get().endFlow();
            this.mHasCloseUbcFlow = true;
        }
    }

    private class ScreenLockReceiver extends BroadcastReceiver {
        private ScreenLockReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals("android.intent.action.USER_PRESENT", intent.getAction()) && VideoPaymentPlayerComponent.this.mPlayer != null) {
                VideoPaymentPlayerComponent.this.mPlayer.resume();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setIconVisibility(int visibility) {
        ImageView imageView = this.mMoreIcon;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
        ImageView imageView2 = this.mAirPlayIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(visibility);
        }
    }

    /* access modifiers changed from: private */
    public void sendFinishRate2DataChannel() {
        String nid = this.mComponentManager.currentModel.intentData.nid;
        String invalidContextId = IVideoDependConstManager.Impl.get().getStringConst("7");
        if (!TextUtils.isEmpty(nid) && !TextUtils.equals(nid, invalidContextId) && this.mPlayer != null) {
            try {
                int i2 = this.mVideoDuration;
                int finishRate = i2 != 0 ? (this.mMaxPlayPosition * 100) / i2 : 0;
                if (finishRate < 0) {
                    return;
                }
                if (finishRate <= 100) {
                    JSONObject dataChannelObject = new JSONObject();
                    JSONArray contentArray = new JSONArray();
                    JSONObject contentObj = new JSONObject();
                    contentObj.put("nid", nid);
                    contentObj.put("type", FeedDataChannelSubType.SUB_TYPE_READ_FINISH_RATE);
                    contentObj.put("count", String.valueOf(finishRate));
                    contentArray.put(contentObj);
                    dataChannelObject.put(nid, contentArray);
                    IVideoSender.Impl.get().sendBroadcastLocal(this.mContext, IVideoDependConstManager.Impl.get().getStringConst("1"), dataChannelObject.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateState(VideoPaymentPlayer mPlayer2, int state) {
        if (mPlayer2 != null) {
            mPlayer2.sendPaymentState(state);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 1 && this.mRightTopHolderView != null && !findRightTopHolderView()) {
            this.mPlayerHolderView.addView(this.mRightTopHolderView);
        }
    }

    private boolean findRightTopHolderView() {
        for (int i2 = 0; i2 < this.mPlayerHolderView.getChildCount(); i2++) {
            if (this.mPlayerHolderView.getChildAt(i2).equals(this.mRightTopHolderView)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void notifyPlayerOrientationChanged(boolean isHalf) {
        this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.Player.PLAYER_MESSAGE, MessageManifest.Player.ORIENTATION, 0, Boolean.valueOf(isHalf)));
    }

    public void onPlayingNext(int clkType) {
        INextPlayService service = (INextPlayService) this.mComponentManager.getService(INextPlayService.class);
        if (service != null) {
            service.playNext(clkType);
        }
    }

    public void setNextVideoInfo(String title, String posterImage, String videoInfo) {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.setNextColumnTitle(title);
            if (TextUtils.isEmpty(videoInfo) || videoInfo == null) {
                this.mPlayer.setNextColumnVid("");
            } else {
                try {
                    this.mPlayer.setNextColumnVid(new JSONObject(videoInfo).optString("vid"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.mPlayer.setNextColumnPoster(posterImage);
        }
    }

    public void playNextVideo() {
        updateVideoDataSource(true);
        VideoDetailUbcExtUtils.setFromOutside(false);
    }

    public void resumeContinuePlay() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.resumeContinuePlay();
        }
    }

    public void stopContinuePlay() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.stopContinuePlay();
        }
    }

    /* access modifiers changed from: private */
    public void initMoreIconView() {
        if (this.mRightTopHolderView != null) {
            if (this.mMoreIcon == null) {
                ImageView imageView = new ImageView(this.mContext);
                this.mMoreIcon = imageView;
                imageView.setImageResource(R.drawable.video_detail_new_more_normal);
                this.mMoreIcon.setScaleType(ImageView.ScaleType.CENTER);
                this.mMoreIcon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (VideoPaymentPlayerComponent.this.mPlayer != null) {
                            VideoPaymentPlayerComponent.this.mPlayer.stopContinuePlay();
                        }
                        VideoPaymentPlayerComponent.this.showMenu(-1);
                    }
                });
            }
            if (this.mMoreIcon.getParent() == null) {
                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(-2, -2);
                imageParams.width = IVideoScreenInfoUtils.Impl.get().dp2px(30.0f);
                imageParams.height = imageParams.width;
                this.mRightTopHolderView.addView(this.mMoreIcon, imageParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showMenu(int downloadStatus) {
        IMenuService service = (IMenuService) this.mComponentManager.getService(IMenuService.class);
        if (service != null) {
            service.showMenu(downloadStatus);
        }
    }

    /* access modifiers changed from: protected */
    public void initLockScreenReceiver() {
        KeyguardManager keyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            this.mScreenLockReceiver = new ScreenLockReceiver();
            this.mContext.registerReceiver(this.mScreenLockReceiver, new IntentFilter("android.intent.action.USER_PRESENT"));
        }
    }

    private void unregisterLockScreenReceiver() {
        if (this.mScreenLockReceiver != null) {
            this.mContext.unregisterReceiver(this.mScreenLockReceiver);
            this.mScreenLockReceiver = null;
        }
    }

    /* access modifiers changed from: protected */
    public void registerContinuePlayEvent() {
        IVideoEventBusWrapper.Impl.get().register(this.mContinuePlayObj, VideoContinuePlayEvent.class, new Action1<VideoContinuePlayEvent>() {
            public void call(VideoContinuePlayEvent event) {
                if (VideoPaymentPlayerComponent.this.mPlayer == null) {
                    return;
                }
                if (event.play) {
                    VideoPaymentPlayerComponent.this.mPlayer.resumeContinuePlay();
                } else {
                    VideoPaymentPlayerComponent.this.mPlayer.stopContinuePlay();
                }
            }
        });
    }

    private void unregisterContinuePlayEvent() {
        IVideoEventBusWrapper.Impl.get().unregister(this.mContinuePlayObj);
    }

    /* access modifiers changed from: protected */
    public void registerVideoAction() {
        IVideoEventBusWrapper.Impl.get().register(this.mVideoEventObj, VideoActionEvent.class, new Action1<VideoActionEvent>() {
            public void call(VideoActionEvent videoActionEvent) {
                if (TextUtils.equals(videoActionEvent.getAction(), "back") && VideoPaymentPlayerComponent.this.mPlayer != null && VideoPaymentPlayerComponent.this.mPlayer.isFullMode()) {
                    VideoPaymentPlayerComponent.this.mPlayer.switchToHalf(3);
                }
            }
        });
    }

    private void unregisterVideoAction() {
        IVideoEventBusWrapper.Impl.get().unregister(this.mVideoEventObj);
    }

    public int getCurrentDuration() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            return videoPaymentPlayer.getDuration();
        }
        return 0;
    }

    public void endUbcIfNeed() {
        if (!this.mHasCloseUbcFlow) {
            endUBCFlow();
        }
    }

    public VideoPaymentPlayer getPlayer() {
        return this.mPlayer;
    }

    public String getVid() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        return (videoPaymentPlayer == null || videoPaymentPlayer.getVideoSeries() == null) ? "" : this.mPlayer.getVideoSeries().getNid();
    }

    public String getPd() {
        if (this.mComponentManager.currentModel == null || this.mComponentManager.currentModel.commonModel == null) {
            return null;
        }
        return this.mComponentManager.currentModel.commonModel.pd;
    }

    public String getAlbumId() {
        if (this.mComponentManager.currentModel.commonModel == null) {
            return "";
        }
        return this.mComponentManager.currentModel.commonModel.mAlumId;
    }

    /* access modifiers changed from: protected */
    public void setupPlayer(BdVideoSeries series) {
        MPDUtil.setRequestMode(series, 2);
        if (this.mPlayer.getVideoSeries() == null || !this.mPlayer.isPlaying() || !series.getNid().equals(this.mPlayer.getVideoSeries().getNid())) {
            this.mPlayer.setVideoSeries(series);
        }
        this.mPlayer.setCommonData(this.mComponentManager.currentModel.commonModel);
        if (!this.mPlayer.isAttachToContainer()) {
            this.mPlayer.attachToContainer(this.mPlayerHolderView);
        }
        this.mPlayer.setPlayerListener(this.mVideoPlayerCallback);
        this.mPlayer.setVideoPaymentPlayerListener(this.mIBaseVideoPlayerCallback);
        this.mPlayer.setPlayNextVideoCallback(this.mPlayNextVideoCallback);
        this.mPlayer.setShareListener(this.mPlayerShareListener);
        this.mPlayer.setAirPlayerListener(this.mAirPlayListener);
        this.mPlayer.setPayCountDownListener(new PayCountDownListener() {
            public void updateTime(int currTime, int endTime) {
                IPaymentSpecialColumnService service = (IPaymentSpecialColumnService) VideoPaymentPlayerComponent.this.mComponentManager.getService(IPaymentSpecialColumnService.class);
                if (service != null) {
                    service.updateTime(currTime, endTime);
                }
            }

            public void endTime() {
                IPaymentSpecialColumnService service = (IPaymentSpecialColumnService) VideoPaymentPlayerComponent.this.mComponentManager.getService(IPaymentSpecialColumnService.class);
                if (service != null) {
                    service.endTime();
                }
            }
        });
        this.mPlayer.setCommentInputCallback(new CommentInputCallback() {
            public boolean isCommentInputShow() {
                return VideoPaymentPlayerComponent.this.isCommentInputShowing();
            }
        });
        if (!this.mPlayer.isAirPlayLayerShowing() && !this.mPlayer.isAirPlayDeviceListShowing()) {
            this.mPlayer.start();
        }
        this.mPlayer.goBackOrForeground(true);
        if (this.mComponentManager.currentModel.intentData != null) {
            this.mPlayer.setPaymentSource(this.mComponentManager.currentModel.intentData.pd + this.mComponentManager.currentModel.intentData.recSrc);
            this.mPlayer.setPayOrderInfo(this.mComponentManager.currentModel.intentData.payOrderInfo);
        }
    }

    public void setAlbumData(PaymentSpecialColumnModel albumModel) {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.setAlbumData(albumModel);
        }
    }

    public void clickEpisodesItem() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.stop();
            this.mPlayer.showLoadingView();
            this.mIsFirstDisplayReady = false;
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 12032 && message.arg1 == 12036) {
            this.mHasReportPlayerException = false;
        }
    }

    public boolean isShowLimitFreeToast() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer == null || videoPaymentPlayer.getDuration() <= 0 || (this.mPlayer.getPosition() * 100) / this.mPlayer.getDuration() < 50) {
            return false;
        }
        return showLimitFreeToast();
    }

    private boolean showLimitFreeToast() {
        if (!this.mPlayer.checkVideoLimitFreeValid() || this.mPlayer.getColumnModel().mActivityInfo.popupCmd == null) {
            return false;
        }
        FreeLimitSchemeCallbackHandler handler = new FreeLimitSchemeCallbackHandler();
        IVideoRouter.Impl.get().invokeScheme(this.mContext, this.mPlayer.getColumnModel().mActivityInfo.popupCmd, handler);
        return handler.isShow;
    }

    private final class FreeLimitSchemeCallbackHandler implements SchemeCallbackHandler {
        /* access modifiers changed from: private */
        public boolean isShow;

        private FreeLimitSchemeCallbackHandler() {
        }

        public String getCurrentPageUrl() {
            return null;
        }

        public void handleSchemeDispatchCallback(String callback, String param) {
            if (callback != null) {
                char c2 = 65535;
                switch (callback.hashCode()) {
                    case -1351902487:
                        if (callback.equals("onClick")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1012968068:
                        if (callback.equals("onShow")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (VideoPaymentPlayerComponent.this.mPlayer != null && VideoPaymentPlayerComponent.this.mPlayer.checkVideoLimitFreeValid() && VideoPaymentPlayerComponent.this.mPlayer.getColumnModel().mActivityInfo.cmd != null) {
                            IVideoRouter.Impl.get().invoke(VideoPaymentPlayerComponent.this.mContext, VideoPaymentPlayerComponent.this.mPlayer.getColumnModel().mActivityInfo.cmd);
                            VideoPaymentPlayerComponent videoPaymentPlayerComponent = VideoPaymentPlayerComponent.this;
                            videoPaymentPlayerComponent.recordLimitFreeUbc(videoPaymentPlayerComponent.mPlayer);
                            return;
                        }
                        return;
                    case 1:
                        this.isShow = TextUtils.equals(param, "true");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean showLimitFreePopup() {
        if (!this.mPlayer.checkVideoLimitFreeValid() || this.mPlayer.getColumnModel().mActivityInfo.panelCmd == null) {
            return false;
        }
        return IVideoRouter.Impl.get().invoke(this.mContext, this.mPlayer.getColumnModel().mActivityInfo.panelCmd);
    }

    /* access modifiers changed from: private */
    public void sendVideoWatchedFreeNumBroadcast(int doneNum) {
        if (doneNum >= 0) {
            try {
                JSONObject sender = new JSONObject();
                JSONObject content = new JSONObject();
                content.put("type", DataChannelConstants.TYPE_TRIAL_CONSUMED_COUNT);
                content.put("count", doneNum);
                content.put("content", getVid());
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(content);
                sender.put(getAlbumId(), jsonArray);
                IVideoSender.Impl.get().sendBroadcastLocal(this.mContext, "com.baidu.channel.feed.assistmessage", sender.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void recordLimitFreeUbc(VideoPaymentPlayer player) {
        String page = "";
        String nid = "";
        if (player.getVideoSeries() != null) {
            page = player.getVideoSeries().getPage();
            nid = player.getVideoSeries().getNid();
        }
        VideoDetailUbcExtUtils.paymentUbc(page, "click", UBC1077.VALUE.LIMIT_FREE_INSPIRE_CLICK, player.getPaymentSource(), nid, player.getPayOrderInfo(), player.isFullMode() ? "landscape" : "portrait");
    }

    /* access modifiers changed from: private */
    public void initAirPlayIconView() {
        if (this.mRightTopHolderView != null) {
            if (this.mAirPlayIcon == null) {
                ImageView imageView = new ImageView(this.mContext);
                this.mAirPlayIcon = imageView;
                imageView.setImageResource(com.baidu.searchbox.videoplayer.airplay.R.drawable.video_half_airplay);
                this.mAirPlayIcon.setScaleType(ImageView.ScaleType.CENTER);
                this.mAirPlayIcon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        VideoPaymentPlayerComponent.this.mComponentManager.notify(MessageUtils.obtain(MessageManifest.AirPlay.MESSAGE, MessageManifest.AirPlay.AIRPLAY_CLICK, 0, (Object) null));
                        if (VideoPaymentPlayerComponent.this.mPlayer != null) {
                            VideoPaymentPlayerComponent.this.mPlayer.getStatEventTrigger().onAirPlayClick();
                        }
                    }
                });
                VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
                if (videoPaymentPlayer != null) {
                    videoPaymentPlayer.getStatEventTrigger().onAirPlayShow();
                }
            }
            if (this.mAirPlayIcon.getParent() == null) {
                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(-2, -2);
                imageParams.width = IVideoScreenInfoUtils.Impl.get().dp2px(30.0f);
                imageParams.height = IVideoScreenInfoUtils.Impl.get().dp2px(30.0f);
                imageParams.rightMargin = IVideoScreenInfoUtils.Impl.get().dp2px(7.0f);
                this.mRightTopHolderView.addView(this.mAirPlayIcon, imageParams);
            }
        }
    }

    public void startAirPlayConnect() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.showAirPlayDevice();
        }
    }

    public String getVideoUniqueKey() {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            return videoPaymentPlayer.getVideoUniqueKey();
        }
        return null;
    }

    public void updateEndFrame(PaymentSpecialColumnModel.PayBtnInfo tailCardPayBtn) {
        VideoPaymentPlayer videoPaymentPlayer = this.mPlayer;
        if (videoPaymentPlayer != null) {
            videoPaymentPlayer.updateEndFrame(tailCardPayBtn);
        }
    }
}
