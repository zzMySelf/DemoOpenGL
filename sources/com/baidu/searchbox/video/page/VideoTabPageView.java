package com.baidu.searchbox.video.page;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.ad.exp.AdPolicyGlobal;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.behavior.UserStickinessCollector;
import com.baidu.searchbox.danmakulib.event.DanmakuSendEvent;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.event.VideoAutoPlayEvent;
import com.baidu.searchbox.feed.event.VideoFocusEvent;
import com.baidu.searchbox.feed.event.VideoRecommendEvent;
import com.baidu.searchbox.feed.event.VideoTabPageResumeEvent;
import com.baidu.searchbox.feed.flow.util.SpecTplTypes;
import com.baidu.searchbox.feed.ioc.IFeedFavor;
import com.baidu.searchbox.feed.ioc.IFeedTplVideo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.template.FeedTabVideoAdVideoView;
import com.baidu.searchbox.feed.template.FeedTabVideoView;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.template.tplinterface.IPlayerReuseControl;
import com.baidu.searchbox.feed.template.tplinterface.ITabVideoAutoPlay;
import com.baidu.searchbox.feed.template.tplinterface.IVideoPlayerControl;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.video.FeedVideoState;
import com.baidu.searchbox.feed.video.ILandscapeDataDispatcher;
import com.baidu.searchbox.feed.video.LandScapePageSelectedListener;
import com.baidu.searchbox.feed.video.manager.VideoDataSimplifyProcessor;
import com.baidu.searchbox.feed.video.manager.VideoPlayProgress;
import com.baidu.searchbox.feed.video.statistic.VideoStatisticUtil;
import com.baidu.searchbox.feed.widget.feedflow.WrapContentLinearLayoutManager;
import com.baidu.searchbox.interfaces.SimpleAdSuffixEventListener;
import com.baidu.searchbox.ioc.IVideoDetailUtilsProxy;
import com.baidu.searchbox.landscape.ILandscapeOperatePlayerCallback;
import com.baidu.searchbox.landscape.LandscapeVideoFlowPageNew;
import com.baidu.searchbox.landscape.LandscapeVideoFlowSupportSmallPage;
import com.baidu.searchbox.launch.SmartLaunchController;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.ChannelVideoPlayer;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.player.assistant.ISwitchAssistant;
import com.baidu.searchbox.player.assistant.VideoTabSwitchAssistant;
import com.baidu.searchbox.player.callback.OnSwitchToFullInterceptCallBack;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.layer.HalfScreenBarrageControlBtn;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.searchbox.player.utils.BdVideoAutoPlayUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdVideoSys;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.searchbox.player.utils.DumediaUtils;
import com.baidu.searchbox.player.utils.VideoPlayerSpUtil;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.video.R;
import com.baidu.searchbox.video.VideoAbTestManager;
import com.baidu.searchbox.video.channelpayment.ChannelVideoPaymentPlayer;
import com.baidu.searchbox.video.controller.VideoDataManager;
import com.baidu.searchbox.video.controller.VideoTabSwitchLandscapeControl;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import com.baidu.searchbox.video.detail.export.IVideoRouter;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.inf.VideoTabService;
import com.baidu.searchbox.video.model.VideoAutoPlayGuideModel;
import com.baidu.searchbox.video.page.ChannelPaymentReceiver;
import com.baidu.searchbox.video.page.ubc.VideoTabListLandscapeUbcIml;
import com.baidu.searchbox.video.page.ubc.inf.IVideoPlayerOrientation;
import com.baidu.searchbox.video.page.ubc.inf.IVideoTabListLandscapeUbc;
import com.baidu.searchbox.video.page.ubc.inf.IVideoTabListOuterUbc;
import com.baidu.searchbox.video.payment.player.VideoPaymentPlayer;
import com.baidu.searchbox.video.player.landscape.ILandscapeVideoPlayer;
import com.baidu.searchbox.video.template.VideoTemplateManifest;
import com.baidu.searchbox.video.template.diversion.DiversionVideoView;
import com.baidu.searchbox.video.template.fullitem.PaymentVideoFullItemModel;
import com.baidu.searchbox.video.util.VideoPreferenceUtils;
import com.baidu.searchbox.video.util.VideoTabUbcUtils;
import com.baidu.searchbox.video.util.VideoUtils;
import com.baidu.searchbox.video.widget.VideoMediaContentGuideDialog;
import com.google.ar.core.ImageMetadata;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

public class VideoTabPageView extends VideoBasePageView implements VideoPlayProgress.OnVideoProgressChange, IVideoPlayerOrientation {
    private static final int FIRST_SCREEN_FLOOR = 3;
    private static final int MIN_DURATION = 15;
    private static final String PLAY_PERCENT = "50";
    private static final String SESSION_TIP_COUNT = "3";
    private static final String SETTINGS_ACTIVITY_CLASS = "com.baidu.searchbox.VideoAutoPlaySettingsActivity";
    private static final String TAG = "VideoTabPageView";
    private static List<String> mHasShowedFollowTipVids;
    private static int mSessionShowFollowTipCount;
    private final ILandscapeOperatePlayerCallback landscapeAssistant = new ILandscapeOperatePlayerCallback() {
        public void switchToHalf(int switchType, String backType, FeedBaseModel currentModel, ILandscapeVideoPlayer player) {
            if (currentModel == null || player == null) {
                VideoTabPageView.this.showHalfStyle();
                return;
            }
            player.switchToHalf(switchType);
            if (player instanceof ChannelVideoPaymentPlayer) {
                ChannelVideoPaymentPlayer paymentPlayer = (ChannelVideoPaymentPlayer) player;
                if (paymentPlayer.checkVideoPreviewEnable() && (paymentPlayer.isPlaying() || paymentPlayer.isPause())) {
                    paymentPlayer.showPreviewTips();
                }
            }
            if ("back_type_payment_click".equals(backType) && (currentModel.data instanceof PaymentVideoFullItemModel) && (player instanceof ChannelVideoPaymentPlayer)) {
                PaymentVideoFullItemModel paymentModel = (PaymentVideoFullItemModel) currentModel.data;
                if (paymentModel.psvAlbumInfo != null) {
                    IVideoRouter.Impl.get().invoke(VideoTabPageView.this.mContext, paymentModel.psvAlbumInfo.albumCmd);
                }
            }
        }

        public ShortVideoPlayer getPlayer(String layout, String nid) {
            ShortVideoPlayer player;
            if (VideoTemplateManifest.VIDEO_FULL_SCREEN_PAY.equals(layout)) {
                player = VideoTabPageView.this.mPlayerManager.getPlayer(FeedTplNameCenter.VIDEO_TAB_PAYMENT, nid);
            } else {
                player = VideoTabPageView.this.mPlayerManager.getPlayer("tabvideo", nid);
            }
            if (player == null) {
                player = new ChannelVideoPlayer(nid);
                VideoTabPageView.this.updateSwitchHelper(player);
                VideoTabPageView.this.initSuffixAd();
            }
            if (player.getSwitchAssistant() == null && (VideoTabPageView.this.mCurrentView instanceof FeedTabVideoView)) {
                new VideoTabSwitchAssistant(player).setVideoHolder(((FeedTabVideoView) VideoTabPageView.this.mCurrentView).getViewHolder());
            }
            return player;
        }
    };
    private VideoMediaContentGuideDialog mAutoPlayGuideDialog;
    private FeedTemplate mCurrentAdView;
    private FeedBaseModel mCurrentPlayModel = null;
    /* access modifiers changed from: private */
    public BubbleBaseManager mFocusBubbleManager;
    private final OnSwitchToFullInterceptCallBack mFullInterceptCallBack = new OnSwitchToFullInterceptCallBack() {
        public boolean switchToFull(int switchType) {
            ShortVideoPlayer player = VideoTabPageView.this.getCurrentPlayer();
            boolean isIntercept = player == null || VideoTabPageView.this.getCurrentAssistant() == null || (!player.isPlaying() && !player.isPause() && !player.isAdLayerShow()) || !VideoTabPageView.this.isNotRefreshing();
            if (isIntercept && switchType != 0) {
                UniversalToast.makeText(VideoTabPageView.this.mContext, R.string.video_tab_enter_full_screen_fail_tip).showToast();
            }
            return isIntercept;
        }
    };
    /* access modifiers changed from: private */
    public final Map<String, FeedBaseModel> mGapLessContainer = new HashMap();
    private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (VideoTabPageView.this.mRecyclerView != null) {
                VideoTabPageView.this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                VideoTabPageView.this.mRecyclerView.postDelayed(new Runnable() {
                    public void run() {
                        if (VideoTabPageView.this.mIsVisibleToUser && !VideoTabPageView.this.mIsViewPause && (VideoTabPageView.this.mContext instanceof FragmentActivity) && (VideoTabPageView.this.mCurrentView instanceof FeedTabVideoView) && VideoTabPageView.this.mRecyclerView != null) {
                            Fragment fragment = ((FragmentActivity) VideoTabPageView.this.mContext).getSupportFragmentManager().findFragmentByTag(HalfScreenBarrageControlBtn.fragmentTag);
                            if (fragment instanceof DialogFragment) {
                                int[] videoRect = new int[2];
                                FeedTabVideoView videoView = (FeedTabVideoView) VideoTabPageView.this.mCurrentView;
                                videoView.getLocationOnScreen(videoRect);
                                int videoBottom = videoRect[1] + videoView.getMeasuredHeight();
                                int[] editRect = new int[2];
                                ((DialogFragment) fragment).getDialog().findViewById(R.id.edit_zone).getLocationOnScreen(editRect);
                                int editTop = editRect[1];
                                if (videoBottom > editTop) {
                                    VideoTabPageView.this.mRecyclerView.smoothScrollBy(0, videoBottom - editTop);
                                }
                            }
                        }
                    }
                }, 400);
            }
        }
    };
    protected IVideoTabListOuterUbc mIVideoTabListOuterUbc;
    /* access modifiers changed from: private */
    public boolean mIsFindItem;
    private final LandScapePageSelectedListener mLandScapePageSelectedListener = new LandScapePageSelectedListener() {
        public void onPageSelected(final FeedBaseModel selectedModel, final int index) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    VideoTabPageView.this.handVideoTabEvent(selectedModel, index);
                    VideoTabPageView.this.onUbcPageSelected();
                }
            });
        }
    };
    protected ILandscapeDataDispatcher mLandscapeDataRequester;
    protected IPlayerStyleSwitchHelper mLandscapeSwitchHelper;
    protected LandscapeVideoFlowPageNew mLandscapeView;
    private NetChangeReceiver mNetChangeReceiver;
    /* access modifiers changed from: private */
    public VideoTabPlayerManager mPlayerManager;
    /* access modifiers changed from: private */
    public final FeedDataManager.OnRecommendListener mRecommendListener = new FeedDataManager.OnRecommendListener() {
        public void onVideoRecommend(FeedFlowModel feedFlowModel, FeedBaseModel feedBaseModel) {
            if (!VideoTabPageView.this.interceptRecommendInsert(feedBaseModel) && !VideoTabPageView.this.handleGapLessVideo(feedFlowModel, feedBaseModel)) {
                VideoTabPageView.this.handleRecommendInsertVideo(feedFlowModel, feedBaseModel);
                VideoDataSimplifyProcessor.joinCmd(feedFlowModel);
            }
        }
    };
    private int mRecyclerHeight;
    private IVideoTabListLandscapeUbc mVideoTabListLandscapeUbc;
    private VideoTabService mVideoTabService;
    private ChannelPaymentReceiver paymentReceiver;

    /* access modifiers changed from: protected */
    public String getName() {
        return TAG;
    }

    public boolean init(Activity activity, String bundleId, String componentName, Bundle extraInfo) {
        if (SmartLaunchController.isSmartLaunchEnabled()) {
            UserStickinessCollector.getInstance().onBusinessCalled("video");
        }
        return super.init(activity, bundleId, componentName, extraInfo);
    }

    private int getShowStatusBarHeight() {
        if (this.mVideoTabService.isHaoKanStatusBarImmersionEnable()) {
            return IVideoScreenInfoUtils.Impl.get().getStatusBarHeight();
        }
        return 0;
    }

    public void setVideoTabListOuterUbcCallback(IVideoTabListOuterUbc callback) {
        this.mIVideoTabListOuterUbc = callback;
    }

    public View onCreateView(Activity context, Bundle info) {
        this.mVideoTabService = (VideoTabService) ServiceManager.getService(VideoTabService.NAME);
        View childView = super.onCreateView(context, info);
        getVideoDataManager().syncAutoPlayVideoConfig();
        BdEventBus.Companion.getDefault().lazyRegister(this, VideoRecommendEvent.class, 1, new Action<VideoRecommendEvent>() {
            public void call(VideoRecommendEvent event) {
                if (TextUtils.equals("video", event.type) && TextUtils.equals(VideoTabPageView.this.mChannelId, event.channelId)) {
                    VideoTabPageView.this.getVideoDataManager().requestVideoRecommendAsync(VideoTabPageView.this.mRecommendListener, event.feedModel, event.hasSuffixAd);
                }
            }
        });
        BdEventBus.Companion.getDefault().lazyRegister(this, VideoAutoPlayEvent.class, 1, new Action<VideoAutoPlayEvent>() {
            public void call(VideoAutoPlayEvent event) {
                if (TextUtils.equals("video", event.type) && TextUtils.equals(VideoTabPageView.this.mChannelId, event.channelId) && !VideoTabPageView.this.mIsViewPause && event.feedModel != null && (event.feedModel.data instanceof FeedItemDataTabVideo)) {
                    FeedItemDataTabVideo tabVideo = (FeedItemDataTabVideo) event.feedModel.data;
                    if (tabVideo.mGapLessPlayInfo != null && tabVideo.mGapLessPlayInfo.mHasNextClip && VideoTabPageView.this.mGapLessContainer.get(event.feedModel.id) != null) {
                        VideoTabPageView.this.playGapLessVideo(tabVideo.mGapLessPlayInfo.mNextStartTime);
                    } else if (!VideoTabPageView.this.isPaymentVideoNormalLand()) {
                        VideoTabPageView.this.scrollToTop(event.feedModel);
                    }
                }
            }
        });
        BdEventBus.Companion.getDefault().lazyRegister(this, VideoFocusEvent.class, 1, new Action<VideoFocusEvent>() {
            public void call(VideoFocusEvent videoFocusEvent) {
                if (videoFocusEvent.mShow) {
                    VideoTabPageView.this.showFocusBubble(videoFocusEvent);
                } else {
                    VideoTabPageView.this.dismissFocusBubble();
                }
            }
        });
        BdEventBus.Companion.getDefault().lazyRegister(this, DanmakuSendEvent.class, 1, new Action<DanmakuSendEvent>() {
            public void call(DanmakuSendEvent danmakuSendEvent) {
                VideoTabPageView.this.responseDanmakuSendEvent(danmakuSendEvent);
            }
        });
        VideoPlayProgress.registerReceiver(this);
        if (BdVideoAutoPlayUtils.isChannelCanAutoPlay()) {
            this.mRecyclerView.setDescendantFocusability(ImageMetadata.HOT_PIXEL_MODE);
        }
        registerNetWorkChangeReceiver();
        registerPaymentChangeReceiver();
        this.mPlayerManager = new VideoTabPlayerManager();
        if (this.mContext instanceof Activity) {
            this.mPlayerManager.activity = (Activity) this.mContext;
        }
        this.mPlayerManager.setOnPlayerCreateListener(new OnPlayerCreateListener() {
            public void onPlayerCreate(String layout, String nid, ShortVideoPlayer player) {
                if (!TextUtils.isEmpty(layout) && player != null) {
                    VideoTabPageView.this.updateSwitchHelper(player);
                    if (!FeedTplNameCenter.VIDEO_TAB_PAYMENT.equals(layout)) {
                        VideoTabPageView.this.initSuffixAd();
                    }
                }
            }
        });
        this.mVideoTabListLandscapeUbc = initVideoTabListLandscapeUbcIml();
        return childView;
    }

    /* access modifiers changed from: protected */
    public IVideoTabListLandscapeUbc initVideoTabListLandscapeUbcIml() {
        VideoTabListLandscapeUbcIml videoTabListLandscapeUbc = new VideoTabListLandscapeUbcIml();
        videoTabListLandscapeUbc.bindVideoTabListOuterUbc(this.mIVideoTabListOuterUbc);
        return videoTabListLandscapeUbc;
    }

    /* access modifiers changed from: private */
    public boolean isPaymentVideoNormalLand() {
        return (getCurrentPlayer() instanceof VideoPaymentPlayer) && getCurrentPlayer().isFullMode() && getCurrentPlayer().getFullScreenStyle() == 0;
    }

    /* access modifiers changed from: private */
    public void responseDanmakuSendEvent(DanmakuSendEvent danmakuSendEvent) {
        switch (danmakuSendEvent.getEventType()) {
            case 0:
                if (this.mLandscapeView == null && this.mRecyclerView != null) {
                    changeSoftInputMode(48);
                    this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
                    this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                    return;
                }
                return;
            case 2:
                if (this.mLandscapeView == null) {
                    changeSoftInputMode(32);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void changeSoftInputMode(int mode) {
        if (this.mContext instanceof FragmentActivity) {
            ((FragmentActivity) this.mContext).getWindow().setSoftInputMode(mode);
        }
    }

    /* access modifiers changed from: private */
    public void showFocusBubble(VideoFocusEvent videoFocusEvent) {
        BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setAnchorView(videoFocusEvent.mAnchorView).setText(videoFocusEvent.mTip).setFontSize(1, 12.0f).setAutoDismissInterval(5000).enableClkDismiss(true).isAutoDetectShowPosition(true).enableAnimation(true).enableBgClk(true).setPaddingBetweenAnchor(videoFocusEvent.mPaddingBetweenAnchor - ((float) DeviceUtils.ScreenInfo.dp2px(this.mContext, 4.0f))).setForceShowPosition(BubblePosition.DOWN).build();
        this.mFocusBubbleManager = build;
        build.showBubble();
    }

    /* access modifiers changed from: protected */
    public void dismissFocusBubble() {
        BubbleBaseManager bubbleBaseManager = this.mFocusBubbleManager;
        if (bubbleBaseManager != null && !bubbleBaseManager.isDismissed()) {
            this.mRecyclerView.post(new Runnable() {
                public void run() {
                    if (VideoTabPageView.this.mFocusBubbleManager != null && !VideoTabPageView.this.mFocusBubbleManager.isDismissed()) {
                        VideoTabPageView.this.mFocusBubbleManager.dismissBubble();
                        BubbleBaseManager unused = VideoTabPageView.this.mFocusBubbleManager = null;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void dismissMuteBubble() {
        ShortVideoPlayer player = getCurrentPlayer();
        if (player != null) {
            player.dismissMuteBubble();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((event.getKeyCode() == 24 || event.getKeyCode() == 25) && VideoUtils.handleVolumeKeyDown(keyCode, event, getCurrentPlayer())) {
            return true;
        }
        if (keyCode != 4) {
            return false;
        }
        if (handleNormalPlayerKeyDown() || handleAdPlayerKeyDown()) {
            return true;
        }
        return false;
    }

    private boolean handleNormalPlayerKeyDown() {
        ShortVideoPlayer player = getCurrentPlayer();
        if (player == null) {
            return false;
        }
        if (this.mLandscapeView == null || !player.isFullMode()) {
            return player.onKeyBack();
        }
        this.mLandscapeView.backToHalf(3, "back_type_exit");
        return true;
    }

    private boolean handleAdPlayerKeyDown() {
        FeedTemplate feedTemplate = this.mCurrentAdView;
        return feedTemplate != null && (feedTemplate instanceof FeedTabVideoAdVideoView) && ((FeedTabVideoAdVideoView) feedTemplate).onPlayerKeyBack();
    }

    public void onViewPause() {
        super.onViewPause();
        hideVideoViewShare();
        ShortVideoPlayer player = getCurrentPlayer();
        if (player != null) {
            player.goBackOrForeground(false);
        }
        releasePlayer();
        onUbcPause();
    }

    /* access modifiers changed from: protected */
    public void onUbcPause() {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            iVideoTabListLandscapeUbc.onPause(this.mCurrentPlayModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onUbcResume() {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            iVideoTabListLandscapeUbc.onResume(this.mCurrentPlayModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onUbcPageSelected() {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            iVideoTabListLandscapeUbc.pageSelected(this.mCurrentPlayModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onSwitchFull(FeedBaseModel model) {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            iVideoTabListLandscapeUbc.switchToFull(model);
        }
    }

    /* access modifiers changed from: protected */
    public void onSwitchHalf(FeedBaseModel model) {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            iVideoTabListLandscapeUbc.switchToHalf(model);
        }
    }

    public void onViewResume() {
        super.onViewResume();
        ShortVideoPlayer player = getCurrentPlayer();
        if (player != null) {
            player.goBackOrForeground(true);
            if (player.isFullMode()) {
                BdVideoSys.requestLandscape((Activity) this.mContext, player.isReverseLandscape());
            }
        }
        BdEventBus.Companion.getDefault().post(new VideoTabPageResumeEvent());
        resumeAuthorOnLiveAni();
        if (player != null && !player.isFullMode()) {
            autoPlayWhenPageVisible();
        }
        onUbcResume();
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        this.mGapLessContainer.clear();
        if (!(this.mRecyclerView == null || this.mRecyclerView.getHandler() == null)) {
            this.mRecyclerView.getHandler().removeCallbacksAndMessages((Object) null);
        }
        VideoMediaContentGuideDialog videoMediaContentGuideDialog = this.mAutoPlayGuideDialog;
        if (videoMediaContentGuideDialog != null && videoMediaContentGuideDialog.isShowing()) {
            this.mAutoPlayGuideDialog.dismiss();
        }
        unRegisterNetWorkChangeReceiver();
        unRegisterPaymentChangeReceiver();
        realReleasePlayer();
    }

    public void onHomeState() {
        super.onHomeState();
        releasePlayer();
    }

    /* access modifiers changed from: protected */
    public void processLinkages() {
        List<LinkageData> items = FeedLinkageManager.getInstance("video").getLinkages();
        boolean isNeedRefresh = false;
        if (items != null && items.size() > 0) {
            for (LinkageData item : items) {
                if (!item.isUsed) {
                    item.isUsed = true;
                    isNeedRefresh = true;
                }
            }
            if (isNeedRefresh) {
                if (this.mRecyclerView != null) {
                    RecyclerView.ItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
                    if ((itemAnimator instanceof DefaultItemAnimator) && ((DefaultItemAnimator) itemAnimator).getSupportsChangeAnimations()) {
                        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
                    }
                }
                setCurrentViewRefreshStyle();
                int start = findFirstVisibleItemPosition();
                int end = findLastVisibleItemPosition();
                if (start != -1 && end != -1) {
                    this.mAdapter.notifyItemRangeChanged(start, (end - start) + 1);
                }
            }
        }
    }

    private void hideVideoViewShare() {
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabVideoView) {
                ((FeedTabVideoView) child).hideShare();
            }
        }
    }

    private void resumeAuthorOnLiveAni() {
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabVideoView) {
                ((FeedTabVideoView) child).resumeAuthorOnLiveAni();
            } else if (IFeedTplVideo.Impl.get().isLiveTpl(child)) {
                IFeedTplVideo.Impl.get().resumeAuthorOnLiveAni(child);
            }
        }
    }

    private void setCurrentViewRefreshStyle() {
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabVideoView) {
                ((FeedTabVideoView) child).setRefreshByLinkageDataChange();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onUnlikeAck(FeedBaseModel model, View v, int position) {
        super.onUnlikeAck(model, v, position);
        View view2 = findPlayingView();
        if (view2 instanceof FeedTabVideoView) {
            FeedTabVideoView tabVideoView = (FeedTabVideoView) view2;
            if (((FeedTabVideoView) view2).getBindModel().runtimeStatus.viewPosition + 1 == position) {
                tabVideoView.setNeedShowTips(false);
            }
        }
    }

    public void onPageSelected(String channelID) {
        super.onPageSelected(channelID);
        dismissFocusBubble();
        hideVideoViewShare();
        releasePlayer();
    }

    private void releasePlayer() {
        ShortVideoPlayer player = getCurrentPlayer();
        if (player != null && !player.isFullMode()) {
            realReleasePlayer();
        }
    }

    private void realReleasePlayer() {
        ILandscapeDataDispatcher iLandscapeDataDispatcher = this.mLandscapeDataRequester;
        if (iLandscapeDataDispatcher != null) {
            iLandscapeDataDispatcher.release();
            this.mLandscapeDataRequester = null;
        }
        this.mPlayerManager.releasePlayer();
    }

    /* access modifiers changed from: protected */
    public boolean interceptRecommendInsert(FeedBaseModel curModel) {
        return false;
    }

    /* access modifiers changed from: private */
    public boolean handleGapLessVideo(FeedFlowModel feedFlowModel, FeedBaseModel feedBaseModel) {
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            FeedItemDataTabVideo feedItemDataTabVideo = (FeedItemDataTabVideo) feedBaseModel.data;
            if (!(feedItemDataTabVideo.mGapLessPlayInfo == null || !feedItemDataTabVideo.mGapLessPlayInfo.mHasNextClip || feedFlowModel == null || feedFlowModel.feedBaseModelList == null || feedFlowModel.feedBaseModelList.size() <= 0)) {
                FeedBaseModel gapLessModel = feedFlowModel.feedBaseModelList.get(0);
                if (checkGapLessModelValidate(gapLessModel)) {
                    this.mGapLessContainer.put(feedBaseModel.id, gapLessModel);
                    if (!(this.mCurrentView instanceof FeedTabVideoView)) {
                        return true;
                    }
                    ((FeedTabVideoView) this.mCurrentView).setGapLessModel(gapLessModel);
                    return true;
                }
            }
        }
        if (this.mCurrentView instanceof FeedTabVideoView) {
            ((FeedTabVideoView) this.mCurrentView).setGapLessModel((FeedBaseModel) null);
        }
        return false;
    }

    private boolean checkGapLessModelValidate(FeedBaseModel gapLessModel) {
        if (!TextUtils.isEmpty(gapLessModel.id) && (gapLessModel.data instanceof FeedItemDataTabVideo) && ((FeedItemDataTabVideo) gapLessModel.data).mVideoInfo != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void handleRecommendInsertVideo(FeedFlowModel feedFlowModel, FeedBaseModel feedBaseModel) {
        if (feedFlowModel != null && TextUtils.equals(feedFlowModel.error, "0")) {
            handleInsertTypeRecommend(feedFlowModel, feedBaseModel);
        }
    }

    /* access modifiers changed from: protected */
    public void handleInsertTypeRecommend(FeedFlowModel feedFlowModel, FeedBaseModel feedBaseModel) {
        ArrayList<FeedBaseModel> recommendFeeds = feedFlowModel.feedBaseModelList;
        if (recommendFeeds != null && recommendFeeds.size() > 0) {
            int dataListPosition = this.mAdapter.getFeedList().indexOf(feedBaseModel);
            int viewPosition = feedBaseModel.runtimeStatus.viewPosition;
            if (dataListPosition != -1) {
                int timeLinePos = this.mTimeLinePos;
                if (dataListPosition >= timeLinePos) {
                    timeLinePos = -1;
                }
                Iterator<FeedBaseModel> it = recommendFeeds.iterator();
                while (it.hasNext()) {
                    dataListPosition++;
                    viewPosition++;
                    insertToFeed(it.next(), dataListPosition, viewPosition);
                    if (timeLinePos > 0) {
                        timeLinePos++;
                    }
                }
                if (timeLinePos > 0) {
                    this.mTimeLinePos = timeLinePos;
                }
                int start = viewPosition + 1;
                int end = findLastVisibleItemPosition() + 2;
                if (start <= end) {
                    this.mAdapter.notifyItemRangeChanged(start, (end - start) + 1);
                }
            }
        }
    }

    private void updateToFeed(FeedBaseModel feedUpdatedModel, int dataPosition, int viewPosition) {
        feedUpdatedModel.runtimeStatus.business = "video";
        this.mDataManager.updateFeedToCache(dataPosition, feedUpdatedModel);
    }

    private void insertToFeed(FeedBaseModel feedRecommendModel, int dataListPosition, int viewInsertPosition) {
        feedRecommendModel.runtimeStatus.business = "video";
        if (feedRecommendModel.data instanceof FeedItemDataTabVideo) {
            FeedItemDataTabVideo feedItemDataTabVideo = (FeedItemDataTabVideo) feedRecommendModel.data;
            feedItemDataTabVideo.mNeedAnim = true;
            feedItemDataTabVideo.mIsRecommend = true;
        }
        this.mDataManager.insertFeedToCache(dataListPosition, feedRecommendModel);
        this.mAdapter.notifyItemInserted(viewInsertPosition);
    }

    /* access modifiers changed from: private */
    public void scrollToTop(FeedBaseModel feedBaseModel) {
        if (!VideoPlayerSpUtil.isInterceptFeedAutoPlay() && this.mRecyclerView.getScrollState() == 0 && !BDShare.getInstance().isShowing()) {
            int nextPosition = feedBaseModel.runtimeStatus.viewPosition + 1;
            int itemViewType = this.mAdapter.getItemViewType(nextPosition);
            if (itemViewType == SpecTplTypes.VIEW_TYPE_TIMELINE) {
                nextPosition++;
            }
            if (itemViewType == VIEW_TYPE_HIDDEN) {
                nextPosition++;
            }
            if (itemViewType != VIEW_TYPE_FOOTER && nextPosition < this.mAdapter.getFeedList().size()) {
                FeedBaseModel nextBaseModel = this.mAdapter.getFeedList().get(nextPosition);
                if (nextBaseModel.data instanceof FeedItemDataTabVideo) {
                    FeedItemDataTabVideo feedItemDataTabVideo = (FeedItemDataTabVideo) nextBaseModel.data;
                    if (TextUtils.equals("ad_channel_video", feedBaseModel.layout) || TextUtils.equals("ad_channel_video", nextBaseModel.layout)) {
                        if (!VideoPlayerSpUtil.isAutoPlay()) {
                            return;
                        }
                        if (TextUtils.equals("ad_channel_video", nextBaseModel.layout)) {
                            feedItemDataTabVideo.mContinuePlay = "1";
                        }
                    }
                    if (TextUtils.equals(feedItemDataTabVideo.mContinuePlay, "1")) {
                        View currentItemView = this.mRecyclerLayoutManager.findViewByPosition(feedBaseModel.runtimeStatus.viewPosition);
                        View nextItemView = this.mRecyclerLayoutManager.findViewByPosition(nextPosition);
                        if (nextItemView == null || isCanPlayView(nextItemView)) {
                            stopVisibleViewPlaying(true);
                            dismissAllPop();
                            int current = getViewTop(currentItemView);
                            int next = getViewTop(nextItemView);
                            if (next <= Integer.MIN_VALUE || current <= 0) {
                                final int finalIndex = nextPosition;
                                this.mRecyclerView.post(new Runnable() {
                                    public void run() {
                                        VideoTabPageView.this.mRecyclerView.smoothScrollToPosition(finalIndex);
                                    }
                                });
                            } else {
                                this.mRecyclerView.smoothScrollBy(0, next - current);
                            }
                            final int finalNextPosition = nextPosition;
                            if (!playNext(this.mRecyclerLayoutManager, finalNextPosition)) {
                                this.mRecyclerView.postDelayed(new Runnable() {
                                    public void run() {
                                        VideoTabPageView videoTabPageView = VideoTabPageView.this;
                                        boolean unused = videoTabPageView.playNext(videoTabPageView.mRecyclerLayoutManager, finalNextPosition);
                                    }
                                }, WrapContentLinearLayoutManager.getScrollToTopDuration(this.mContext));
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void playGapLessVideo(String nextStartTime) {
        FeedBaseModel gapLessModel;
        if (this.mCurrentView instanceof FeedTabVideoView) {
            FeedTabVideoView currentView = (FeedTabVideoView) this.mCurrentView;
            FeedBaseModel currentModel = currentView.getFeedBaseModel();
            if (!TextUtils.isEmpty(currentModel.id) && (gapLessModel = this.mGapLessContainer.get(currentModel.id)) != null) {
                updateGapLessData(currentModel, gapLessModel);
                FeedItemDataTabVideo feedItemDataTabVideo = (FeedItemDataTabVideo) gapLessModel.data;
                feedItemDataTabVideo.mVideoInfo.mSeekPosition = nextStartTime;
                currentView.updateUiData(gapLessModel);
                currentView.updatePlayerDataSource();
                currentView.getLabelView().syncData(gapLessModel);
                JSONObject VideoInfoObj = FeedItemDataTabVideo.VideoInfoEntity.toJson(feedItemDataTabVideo.mVideoInfo);
                if (VideoInfoObj != null) {
                    VideoStatisticUtil.gapLessPlayStatistic(true, VideoInfoObj.toString(), false);
                    VideoStatisticUtil.gapLessPlayStatistic(false, VideoInfoObj.toString(), false);
                }
            }
        }
    }

    private void updateGapLessData(FeedBaseModel currentModel, FeedBaseModel gapLessModel) {
        if (this.mAdapter != null && this.mAdapter.getFeedList() != null && currentModel.runtimeStatus != null && gapLessModel.runtimeStatus != null) {
            gapLessModel.runtimeStatus.viewPosition = currentModel.runtimeStatus.viewPosition;
            int index = this.mAdapter.getFeedList().indexOf(currentModel);
            if (index != -1) {
                this.mAdapter.getFeedList().set(index, gapLessModel);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean playNext(RecyclerView.LayoutManager linearLayoutManager, int position) {
        if (!shouldAutoPlay()) {
            return false;
        }
        View view2 = linearLayoutManager.findViewByPosition(position);
        if (!(view2 instanceof ITabVideoAutoPlay)) {
            return false;
        }
        ITabVideoAutoPlay feedTabVideoView = (ITabVideoAutoPlay) view2;
        feedTabVideoView.setAutoPlayState(true);
        feedTabVideoView.autoContinuePlay();
        feedTabVideoView.setAutoPlayState(false);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldAutoPlay() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean autoPlayVideo(String vid) {
        ArrayList<View> views = getCurrentVisibleViewList();
        if (views == null || views.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < views.size(); i2++) {
            View child = views.get(i2);
            if (child instanceof FeedTabVideoView) {
                return ((FeedTabVideoView) child).playTopVideo(vid);
            }
        }
        return false;
    }

    public void onUserVisibleHint(boolean isVisibleToUser) {
        super.onUserVisibleHint(isVisibleToUser);
        if (this.mIsVisibleToUser && this.mDataManager != null) {
            getVideoDataManager().syncAutoPlayVideoConfig();
            autoPlayWhenPageVisible();
        }
    }

    private void autoPlayWhenPageVisible() {
        if (BdVideoAutoPlayUtils.isChannelCanAutoPlay() && this.mRecyclerView != null) {
            this.mRecyclerView.postDelayed(new Runnable() {
                public void run() {
                    if (VideoTabPageView.this.mIsVisibleToUser && !VideoTabPageView.this.mIsViewPause && VideoTabPageView.this.mRecyclerView != null) {
                        VideoTabPageView.this.videoAutoPlay();
                    }
                }
            }, 500);
        }
    }

    private View getNextVideoView(ArrayList<View> views, int currentPlaying, boolean down) {
        View nextView = null;
        int viewSize = views.size();
        if (down) {
            for (int i2 = currentPlaying + 1; i2 < viewSize; i2++) {
                nextView = views.get(i2);
                if (isCanPlayView(nextView)) {
                    break;
                }
            }
        } else {
            for (int i3 = currentPlaying - 1; i3 >= 0; i3--) {
                nextView = views.get(i3);
                if (isCanPlayView(nextView)) {
                    break;
                }
            }
        }
        return nextView;
    }

    private boolean isCanPlayView(View view2) {
        if (view2 instanceof FeedTabVideoView) {
            return ((FeedTabVideoView) view2).isCanPlayVideo();
        }
        return view2 instanceof ITabVideoAutoPlay;
    }

    /* access modifiers changed from: protected */
    public void videoAutoPlay() {
        if (this.mIsLoadingMore) {
            this.mNeedAutoPlay = true;
        } else if (this.mIsVisibleToUser && !this.mIsViewPause && NetWorkUtils.isNetworkConnected()) {
            boolean isTabVideoAutoPlayEnable = BdVideoAutoPlayUtils.isChannelCanAutoPlay();
            boolean isAdVideoAutoPlayEnable = getVideoDataManager().isAdAutoPlay();
            if ((!isTabVideoAutoPlayEnable && !isAdVideoAutoPlayEnable) || !VideoPlayerSpUtil.isAutoPlay() || checkGuideDialogInterceptAutoPlay()) {
                return;
            }
            if (!(this.mContext instanceof Activity) || ((Activity) this.mContext).hasWindowFocus()) {
                boolean isPlaying = false;
                int curPlayingPosition = -1;
                boolean isCurVideoClose = false;
                int curCloseVideoPosition = -1;
                ArrayList<View> currentVisibleViewList = getCurrentVisibleViewList();
                if (currentVisibleViewList != null && currentVisibleViewList.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= currentVisibleViewList.size()) {
                            break;
                        }
                        View child = currentVisibleViewList.get(i2);
                        if (child instanceof ITabVideoAutoPlay) {
                            ITabVideoAutoPlay videoAutoPlay = (ITabVideoAutoPlay) child;
                            if (videoAutoPlay.isPlaying()) {
                                isPlaying = true;
                                curPlayingPosition = i2;
                                if (videoAutoPlay.closeVideo()) {
                                    isPlaying = false;
                                    curPlayingPosition = -1;
                                    isCurVideoClose = true;
                                    curCloseVideoPosition = i2;
                                }
                            }
                        }
                        i2++;
                    }
                    boolean isUpToDown = calcScrollDirection();
                    View nextView = null;
                    if (isPlaying && !isUpToDown) {
                        nextView = getNextVideoView(currentVisibleViewList, curPlayingPosition, false);
                    } else if (!isPlaying && isCurVideoClose) {
                        View child2 = currentVisibleViewList.get(curCloseVideoPosition);
                        if (viewSupportAutoPlayWrapper(child2, isTabVideoAutoPlayEnable, isAdVideoAutoPlayEnable)) {
                            ITabVideoAutoPlay.VideoLocationInScreen location = ((ITabVideoAutoPlay) child2).locationInScreen(getRecyclerViewLocation(this.mRecyclerView));
                            if (location == ITabVideoAutoPlay.VideoLocationInScreen.Top) {
                                nextView = getNextVideoView(currentVisibleViewList, curCloseVideoPosition, true);
                            } else if (location == ITabVideoAutoPlay.VideoLocationInScreen.Bottom) {
                                nextView = getNextVideoView(currentVisibleViewList, curCloseVideoPosition, false);
                            }
                        }
                    } else if (!isPlaying && this.mRecyclerLayoutManager != null) {
                        int start = findFirstVisibleItemPosition();
                        int end = findLastVisibleItemPosition();
                        if (!isUpToDown) {
                            for (int i3 = end; i3 >= start; i3--) {
                                nextView = this.mRecyclerLayoutManager.findViewByPosition(i3);
                                if (viewSupportAutoPlayWrapper(nextView, isTabVideoAutoPlayEnable, isAdVideoAutoPlayEnable) && ((ITabVideoAutoPlay) nextView).isInPlayScale()) {
                                    break;
                                }
                            }
                        } else {
                            for (int i4 = start; i4 <= end; i4++) {
                                nextView = this.mRecyclerLayoutManager.findViewByPosition(i4);
                                if (viewSupportAutoPlayWrapper(nextView, isTabVideoAutoPlayEnable, isAdVideoAutoPlayEnable) && ((ITabVideoAutoPlay) nextView).isInPlayScale()) {
                                    break;
                                }
                            }
                        }
                    }
                    if (viewSupportAutoPlayWrapper(nextView, isTabVideoAutoPlayEnable, isAdVideoAutoPlayEnable)) {
                        ITabVideoAutoPlay nextVideoView = (ITabVideoAutoPlay) nextView;
                        if (nextVideoView instanceof FeedTabVideoView) {
                            nextVideoView.autoPlayVideo();
                            return;
                        }
                        if (nextVideoView instanceof FeedTabVideoAdVideoView) {
                            ((FeedTabVideoAdVideoView) nextVideoView).mAutoPlayVoiceValue = getAdVideoAutoPlayVoiceValue();
                        }
                        if (nextVideoView instanceof DiversionVideoView) {
                            ((DiversionVideoView) nextVideoView).setAutoPlayVoiceValue(getAdVideoAutoPlayVoiceValue());
                        }
                        nextVideoView.setAutoPlayState(true);
                        nextVideoView.autoPlayVideo();
                        nextVideoView.setAutoPlayState(false);
                    }
                }
            }
        }
    }

    private boolean calcScrollDirection() {
        View stopView;
        if (this.mPullToRefreshView.getState() != 0) {
            return true;
        }
        int scrollStopPosition = findFirstVisibleItemPosition();
        if (scrollStopPosition < this.mScrollStartPosition) {
            return false;
        }
        if (scrollStopPosition > this.mScrollStartPosition || (stopView = this.mRecyclerView.getLayoutManager().findViewByPosition(scrollStopPosition)) == null) {
            return true;
        }
        int[] xy = new int[2];
        stopView.getLocationOnScreen(xy);
        int scrollStopViewLocationY = xy[1];
        if (scrollStopPosition != this.mScrollStartPosition || scrollStopViewLocationY <= this.mScrollStartViewLocationY) {
            return true;
        }
        return false;
    }

    public boolean checkGuideDialogInterceptAutoPlay() {
        String videoUrl;
        VideoMediaContentGuideDialog videoMediaContentGuideDialog = this.mAutoPlayGuideDialog;
        if (videoMediaContentGuideDialog != null && videoMediaContentGuideDialog.isShowing()) {
            return true;
        }
        if (VideoPreferenceUtils.getBoolean(VideoPreferenceUtils.VIDEO_AUTO_PLAY_GUIDE_DIALOG_SHOWED, false)) {
            return false;
        }
        String data = VideoPreferenceUtils.getString(VideoPreferenceUtils.VIDEO_AUTO_PLAY_GUIDE_DIALOG_DATA, "");
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        VideoAutoPlayGuideModel model = VideoAutoPlayGuideModel.parseToModel(data);
        VideoMediaContentGuideDialog.Builder builder = new VideoMediaContentGuideDialog.Builder(this.mContext).setMainTitle(model.getMainTitle()).setSubTitle(model.getSubTitle()).setCloseClickCallBack(new Function1<View, Unit>() {
            public Unit invoke(View view2) {
                VideoTabUbcUtils.uploadAutoPlayGuideDialogUbc(true, "cancel");
                return Unit.INSTANCE;
            }
        });
        if (model.getContentType().equals(VideoAutoPlayGuideModel.ContentType.VIDEO)) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                videoUrl = model.getContentUrlNight();
            } else {
                videoUrl = model.getContentUrl();
            }
            if (TextUtils.isEmpty(videoUrl) || !DumediaUtils.hasCacheFile(videoUrl)) {
                model.prefetchGuideVideoUrl();
                return true;
            }
            builder.setVideoUrl(videoUrl);
        } else if (model.getContentType().equals(VideoAutoPlayGuideModel.ContentType.IMAGE)) {
            builder.setImageUrl(model.getContentUrl());
        }
        Function1<VideoMediaContentGuideDialog, Unit> settingFunction = new Function1<VideoMediaContentGuideDialog, Unit>() {
            public Unit invoke(VideoMediaContentGuideDialog dialog) {
                VideoTabPageView videoTabPageView = VideoTabPageView.this;
                videoTabPageView.startSettingsActivity(videoTabPageView.mContext);
                dialog.dismiss();
                VideoTabUbcUtils.uploadAutoPlayGuideDialogUbc(true, "set");
                return Unit.INSTANCE;
            }
        };
        Function1<VideoMediaContentGuideDialog, Unit> knowFunction = new Function1<VideoMediaContentGuideDialog, Unit>() {
            public Unit invoke(VideoMediaContentGuideDialog dialog) {
                dialog.dismiss();
                VideoTabUbcUtils.uploadAutoPlayGuideDialogUbc(true, "conform");
                return Unit.INSTANCE;
            }
        };
        List<VideoAutoPlayGuideModel.ButtonData> buttonDataList = model.getButtonDataList();
        if (buttonDataList.size() == 1) {
            VideoAutoPlayGuideModel.ButtonData buttonData = buttonDataList.get(0);
            if (buttonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.SETTING)) {
                builder.setButtonInfo(buttonData.getText(), settingFunction);
            } else if (buttonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.KNOW)) {
                builder.setButtonInfo(buttonData.getText(), knowFunction);
            }
        } else if (buttonDataList.size() == 2) {
            VideoAutoPlayGuideModel.ButtonData leftButtonData = buttonDataList.get(0);
            VideoAutoPlayGuideModel.ButtonData rightButtonData = buttonDataList.get(1);
            if (leftButtonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.SETTING) && rightButtonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.KNOW)) {
                builder.setDoubleButtonInfo(leftButtonData.getText(), settingFunction, rightButtonData.getText(), knowFunction);
            } else if (leftButtonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.KNOW) && rightButtonData.getName().equals(VideoAutoPlayGuideModel.ButtonName.SETTING)) {
                builder.setDoubleButtonInfo(leftButtonData.getText(), knowFunction, rightButtonData.getText(), settingFunction);
            }
        }
        VideoMediaContentGuideDialog build = builder.build();
        this.mAutoPlayGuideDialog = build;
        build.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                if (!VideoTabPageView.this.mIsViewPause) {
                    VideoTabPageView.this.autoPlayGuideDialogDismiss();
                    VideoTabPageView.this.videoAutoPlay();
                }
                VideoPreferenceUtils.removeKey(VideoPreferenceUtils.VIDEO_AUTO_PLAY_GUIDE_DIALOG_DATA);
            }
        });
        if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isFinishing()) {
            return true;
        }
        this.mAutoPlayGuideDialog.show();
        VideoTabUbcUtils.uploadAutoPlayGuideDialogUbc(false);
        VideoPreferenceUtils.putBoolean(VideoPreferenceUtils.VIDEO_AUTO_PLAY_GUIDE_DIALOG_SHOWED, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void autoPlayGuideDialogDismiss() {
    }

    private int getAdVideoAutoPlayVoiceValue() {
        if (!BdVideoAutoPlayUtils.isChannelCanAutoPlay()) {
            return 0;
        }
        if (BdVideoAutoPlayUtils.isMutePlayRamOpen()) {
            return BdVideoAutoPlayUtils.isAutoPlayVideoAndAudio() ? 1 : 0;
        }
        return 2;
    }

    private boolean viewSupportAutoPlayWrapper(View view2, boolean isTabVideoAutoPlayEnable, boolean isAdVideoAutoPlayEnable) {
        if (!(view2 instanceof ITabVideoAutoPlay)) {
            return false;
        }
        if (view2 instanceof FeedTabVideoView) {
            if (!isTabVideoAutoPlayEnable || !((FeedTabVideoView) view2).isCanPlayVideo()) {
                return false;
            }
            return true;
        } else if (view2 instanceof FeedTabVideoAdVideoView) {
            return isAdVideoAutoPlayEnable;
        } else {
            if (view2 instanceof DiversionVideoView) {
                return isTabVideoAutoPlayEnable;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void startSettingsActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.baidu.searchbox.VideoAutoPlaySettingsActivity");
            ActivityUtils.startActivitySafely(context, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void dismissAllPop() {
        super.dismissAllPop();
        int count = this.mRecyclerLayoutManager.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = this.mRecyclerLayoutManager.getChildAt(i2);
            if (view2 instanceof FeedTabVideoView) {
                ((FeedTabVideoView) view2).dismissLabelMenu();
            } else if (view2 instanceof FeedTabVideoAdVideoView) {
                FeedTabVideoAdVideoView adVideoView = (FeedTabVideoAdVideoView) view2;
                if (adVideoView.mOperateView != null) {
                    adVideoView.mOperateView.dismissMenu();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public VideoDataManager getVideoDataManager() {
        return (VideoDataManager) this.mDataManager;
    }

    public void onFeedNightModeChange(boolean isNightMode) {
        if (this.mRecyclerView != null && this.mRecyclerView.getAdapter() != null) {
            this.feedItemDecoration.onFeedNightModeChanged(isNightMode);
            this.mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void handleVideoTplAction(FeedTemplate view2, FeedBaseModel model, int position) {
        if (!isTTSState() && model != null) {
            this.mCurrentPlayModel = model;
            PlayerSpeedTracker.beginTrack(model.id);
            this.mCurrentView = (IVideoPlayerControl) view2;
            this.mCurrentPlayingId = model.id;
            if (!this.mCurrentView.hasClicked()) {
                stopVisibleViewPlaying(false);
                if (this.mCurrentView instanceof IPlayerReuseControl) {
                    ((IPlayerReuseControl) this.mCurrentView).startPlay(getCurrentPlayer());
                } else {
                    BdVideoLog.d(TAG, "old channel id : " + this.mChannelId);
                    this.mCurrentView.startPlay();
                    this.mCurrentAdView = view2;
                }
                String actionId = "clk";
                if ((model.data instanceof FeedItemDataTabVideo) && ((FeedItemDataTabVideo) model.data).mIsAutoPlay) {
                    actionId = "video_auto_play";
                }
                FeedDataReportUtils.reportFeedbackAction(model, (HashMap<String, String>) null, actionId, position, (List<SubTagItem>) null);
                if (TextUtils.equals(actionId, "clk")) {
                    IFeedFavor.Impl.get().addHistory(FeedUtil.favorParamsFrom(model));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean ignorePullRefreshData() {
        return this.mLandscapeView != null;
    }

    /* access modifiers changed from: private */
    public void updateSwitchHelper(BaseVideoPlayer player) {
        adjustFullStyleABTest(player);
    }

    public void onUpdateProgress(String vid, int percent) {
        doShowFollowTips(vid, percent);
    }

    private void scrollToPositionAtTop(int position) {
        int movePosition;
        if (BdVideoAutoPlayUtils.isChannelCanAutoPlay() && (movePosition = position - this.mRecyclerView.getChildLayoutPosition(this.mRecyclerView.getChildAt(0))) >= 0 && movePosition < this.mRecyclerView.getChildCount()) {
            this.mRecyclerView.smoothScrollBy(0, this.mRecyclerView.getChildAt(movePosition).getTop());
        }
    }

    /* access modifiers changed from: private */
    public void initSuffixAd() {
        ShortVideoPlayer player = getCurrentPlayer();
        if (player != null && player.getAdLayer() != null) {
            player.getAdLayer().setSuffixAdEventListener(new SimpleAdSuffixEventListener() {
                public void onClose(int what, boolean isAutoPlay) {
                }

                public boolean shouldRequestSuffixAd() {
                    int interval;
                    boolean firstScreen = false;
                    if (!(VideoTabPageView.this.mCurrentView instanceof FeedTabVideoView)) {
                        return false;
                    }
                    FeedBaseModel model = ((FeedTabVideoView) VideoTabPageView.this.mCurrentView).getFeedBaseModel();
                    if (VideoTabPageView.this.getCurrentPlayingFloor() <= 3) {
                        firstScreen = true;
                    }
                    int firstScreenInterval = AdPolicyGlobal.INSTANCE.getAdVideoFirstScreenTailInterval();
                    if (firstScreen) {
                        interval = firstScreenInterval;
                    } else {
                        interval = AdPolicyGlobal.INSTANCE.getAdVideoTailInterval();
                    }
                    return IVideoDetailUtilsProxy.Impl.getIVideoDetailUtilsProxy().shouldRequestSuffixAd(model, VideoTabPageView.this.mAdSuffixRequestParamList, interval, interval);
                }

                public boolean needDiscardSuffixAd() {
                    if (!(VideoTabPageView.this.mCurrentView instanceof FeedTabVideoView)) {
                        return false;
                    }
                    return FeedAdUtil.hasAdInLimitRange(((FeedTabVideoView) VideoTabPageView.this.mCurrentView).getFeedBaseModel(), VideoTabPageView.this.mAdSuffixRequestParamList, AdPolicyGlobal.INSTANCE.getSuffixAdMaxIntervalUp(), AdPolicyGlobal.INSTANCE.getSuffixAdMaxIntervalDown());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public int getCurrentPlayingFloor() {
        FeedBaseModel feedBaseModel = this.mCurrentPlayModel;
        if (feedBaseModel == null) {
            return 0;
        }
        return feedBaseModel.runtimeStatus.viewPosition + 1;
    }

    private void adjustFullStyleABTest(BaseVideoPlayer player) {
        boolean isOpenLandscapeStyle = VideoAbTestManager.getVideoTabFullStyle() == 1;
        if (isOpenLandscapeStyle) {
            if (this.mLandscapeSwitchHelper == null) {
                this.mLandscapeSwitchHelper = new LandscapeStyleSwitchHelper();
            }
            this.mRecyclerHeight = this.mRecyclerView.getMeasuredHeight();
            player.setFullScreenStyle(1);
            player.setStyleSwitchHelper(this.mLandscapeSwitchHelper);
        }
        BdVideoLog.d(TAG, "isOpenLandscapeStyle :" + isOpenLandscapeStyle);
    }

    private void doShowFollowTips(String vid, int percent) {
        FeedBaseModel model;
        View view2 = findPlayingView();
        if ((view2 instanceof FeedTabVideoView) && (model = ((FeedTabVideoView) view2).getBindModel()) != null && !TextUtils.isEmpty(model.id) && TextUtils.equals(model.id, vid) && (model.data instanceof FeedItemDataTabVideo) && ((FeedItemDataTabVideo) model.data).mVideoInfo != null && ((FeedItemDataTabVideo) model.data).mVideoInfo.mDuration > 15) {
            if (mHasShowedFollowTipVids == null) {
                mHasShowedFollowTipVids = new ArrayList();
            }
            if (!mHasShowedFollowTipVids.contains(vid)) {
                try {
                    if (percent < Integer.parseInt(VideoPreferenceUtils.getString(VideoPreferenceUtils.KEY_FOLLOW_TIP_POP_PROGRESS, "50")) || mSessionShowFollowTipCount >= Integer.parseInt(VideoPreferenceUtils.getString(VideoPreferenceUtils.KEY_FOLLOW_TIP_POP_SESSION_COUNT, "3"))) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!(model.data instanceof FeedItemDataTabVideo) || (!((FeedItemDataTabVideo) model.data).isFollowed() && ((FeedItemDataTabVideo) model.data).mIsOriginalAuthor == 1 && ((FeedItemDataTabVideo) model.data).mVideoLinkBannerModel == null)) {
                    if (!mHasShowedFollowTipVids.contains(vid)) {
                        mHasShowedFollowTipVids.add(vid);
                    }
                    mSessionShowFollowTipCount++;
                    ((FeedTabVideoView) view2).getLabelView().showFollowTip(this.mContext.getString(R.string.video_tab_follow_tip));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void handVideoTabEvent(FeedBaseModel selectedModel, int index) {
        BdVideoLog.d(TAG, "handVideoTabEvent======>index" + index);
        this.mCurrentPlayModel = selectedModel;
        if (this.mCurrentView instanceof FeedTabVideoView) {
            if (this.mRecyclerHeight == 0) {
                this.mRecyclerHeight = this.mRecyclerView.getMeasuredHeight();
            }
            this.mCurrentPlayingId = selectedModel.id;
            final int currentIndex = this.mDataManager.getFeedIndexById(selectedModel.id);
            BdVideoLog.d(TAG, "handVideoTabEvent======>currentIndex" + currentIndex);
            FeedTabVideoView oldView = (FeedTabVideoView) this.mCurrentView;
            String currentId = oldView.getFeedBaseModel().id;
            ((LinearLayoutManager) this.mRecyclerLayoutManager).scrollToPositionWithOffset(currentIndex, (this.mRecyclerHeight / 2) - (oldView.getMeasuredHeight() / 2));
            if (!TextUtils.equals(currentId, selectedModel.id)) {
                this.mIsFindItem = true;
                oldView.resetPlayStatus();
                this.mRecyclerView.post(new Runnable() {
                    public void run() {
                        View view2 = VideoTabPageView.this.mRecyclerLayoutManager.findViewByPosition(currentIndex);
                        BdVideoLog.d(VideoTabPageView.TAG, "handVideoTabEvent======>View" + view2 + ",currentIndex====>" + currentIndex);
                        if (view2 instanceof FeedTabVideoView) {
                            FeedTabVideoView tabVideoView = (FeedTabVideoView) view2;
                            VideoTabPageView.this.mCurrentView = tabVideoView;
                            tabVideoView.updateView(FeedVideoState.Prepare, false);
                            FrameLayout videoHolder = tabVideoView.getViewHolder();
                            if (VideoTabPageView.this.getCurrentAssistant() != null) {
                                VideoTabPageView.this.getCurrentAssistant().setVideoHolder(videoHolder);
                            }
                        }
                        boolean unused = VideoTabPageView.this.mIsFindItem = false;
                    }
                });
            }
        }
    }

    private void tryFindActiveItem() {
        int currentIndex = this.mDataManager.getFeedIndexById(this.mCurrentPlayingId);
        View view2 = this.mRecyclerLayoutManager.findViewByPosition(currentIndex);
        if (view2 instanceof FeedTabVideoView) {
            this.mCurrentView = (FeedTabVideoView) view2;
            FrameLayout videoHolder = ((FeedTabVideoView) view2).getViewHolder();
            ISwitchAssistant assistant = getCurrentAssistant();
            if (assistant != null) {
                assistant.setVideoHolder(videoHolder);
            }
            BdVideoLog.d(TAG, "tryFindActiveItem ====>mCurrentView" + this.mCurrentView + ",videoHolder" + videoHolder);
        } else {
            if (currentIndex < 0) {
                currentIndex = 0;
            }
            this.mRecyclerLayoutManager.scrollToPosition(currentIndex);
            this.mPlayerManager.releasePlayer();
        }
        BdViewOpUtils.fixFullScreen4Notch((Activity) this.mContext, false);
        BdVideoSys.requestPortrait((Activity) this.mContext, 1, 0);
        BdViewOpUtils.removeView(this.mLandscapeView.getRootView());
        this.mLandscapeView.onViewDestroy();
        this.mLandscapeView = null;
    }

    public boolean isVideoPlayerLandscape() {
        IVideoTabListLandscapeUbc iVideoTabListLandscapeUbc = this.mVideoTabListLandscapeUbc;
        if (iVideoTabListLandscapeUbc != null) {
            return iVideoTabListLandscapeUbc.isVideoPlayerLandscape();
        }
        return false;
    }

    private class LandscapeStyleSwitchHelper implements IPlayerStyleSwitchHelper {
        private LandscapeStyleSwitchHelper() {
        }

        public void switchToFullStyle() {
            VideoTabPageView.this.showFullStyle();
        }

        public void switchToNormalStyle() {
            VideoTabPageView.this.mRecyclerView.post(new Runnable() {
                public void run() {
                    VideoTabPageView.this.showHalfStyle();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showFullStyle() {
        try {
            LandscapeVideoFlowPageNew landscapeVideoFlowPageNew = this.mLandscapeView;
            if (landscapeVideoFlowPageNew != null) {
                BdViewOpUtils.removeView(landscapeVideoFlowPageNew.getRootView());
                this.mLandscapeView.onViewDestroy();
                this.mLandscapeView = null;
            }
            if (this.mCurrentView instanceof FeedTabVideoView) {
                FeedTabVideoView currentView = (FeedTabVideoView) this.mCurrentView;
                ShortVideoPlayer currentPlayer = getCurrentPlayer();
                ISwitchAssistant currentAssistant = getCurrentAssistant();
                if (currentPlayer == null) {
                    return;
                }
                if (currentAssistant != null) {
                    if (this.mLandscapeDataRequester == null) {
                        this.mLandscapeDataRequester = new VideoTabSwitchLandscapeControl((VideoDataManager) this.mDataManager);
                    }
                    currentView.updateView(FeedVideoState.Prepare, false);
                    currentView.setCurrentMode("FULL_MODE");
                    FrameLayout videoHolder = currentView.getViewHolder();
                    currentAssistant.setVideoHolder(videoHolder);
                    videoHolder.setClickable(true);
                    LandscapeVideoFlowSupportSmallPage landscapeVideoFlowSupportSmallPage = new LandscapeVideoFlowSupportSmallPage((Activity) this.mContext, this.landscapeAssistant, this.mLandScapePageSelectedListener);
                    this.mLandscapeView = landscapeVideoFlowSupportSmallPage;
                    landscapeVideoFlowSupportSmallPage.onViewCreate();
                    this.mLandscapeView.setupData(this.mLandscapeDataRequester, this.mDataManager.getCachedFeeds(), currentView.getFeedBaseModel(), new VideoTabDataTransformManager(), 1);
                    BdVideoSys.requestLandscape((Activity) this.mContext, currentPlayer.isReverseLandscape());
                    BdVideoSys.setKeepScreenOnOff((Activity) this.mContext, true);
                    BdViewOpUtils.attachDecor((Activity) this.mContext, this.mLandscapeView.getRootView());
                    this.mLandscapeView.handleAdState(currentPlayer.isAdLayerShow());
                    if (BdViewOpUtils.hasPermanentMenuKey(this.mContext) && Build.VERSION.SDK_INT >= 19) {
                        BdViewOpUtils.setSystemUiVisibility(BdViewOpUtils.getDecorView((Activity) this.mContext), true);
                    }
                    onSwitchFull(currentView.getFeedBaseModel());
                }
            }
        } catch (Exception e2) {
            BdVideoLog.e(TAG, (Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void showHalfStyle() {
        LandscapeVideoFlowPageNew landscapeVideoFlowPageNew = this.mLandscapeView;
        if (landscapeVideoFlowPageNew != null && !landscapeVideoFlowPageNew.isScroll() && !this.mIsFindItem) {
            try {
                if (this.mCurrentView instanceof FeedTabVideoView) {
                    FeedTabVideoView currentView = (FeedTabVideoView) this.mCurrentView;
                    FeedBaseModel currentModel = currentView.getFeedBaseModel();
                    if (!TextUtils.equals(this.mCurrentPlayingId, currentModel.id)) {
                        tryFindActiveItem();
                        return;
                    }
                    ShortVideoPlayer currentPlayer = getCurrentPlayer();
                    if (currentPlayer != null) {
                        if (currentView.getBindPlayer() == null) {
                            currentView.setBindPlayer(currentPlayer);
                            this.mLandscapeView.releaseBarrageHelper();
                            currentView.updateToPlayStatus();
                            this.mPlayerManager.updateAssistant();
                        }
                        currentView.setCurrentMode("HALF_MODE");
                        currentView.updateView(FeedVideoState.Playing, false);
                        currentView.getLabelView().syncData(currentModel);
                        onSwitchHalf(currentModel);
                    } else {
                        return;
                    }
                }
                BdViewOpUtils.fixFullScreen4Notch((Activity) this.mContext, false);
                BdVideoSys.requestPortrait((Activity) this.mContext, 1, 0);
                BdViewOpUtils.removeView(this.mLandscapeView.getRootView());
                this.mLandscapeView.onViewDestroy();
                this.mLandscapeView = null;
                this.mPlayerManager.switchToPortrait();
            } catch (Exception e2) {
                LandscapeVideoFlowPageNew landscapeVideoFlowPageNew2 = this.mLandscapeView;
                if (landscapeVideoFlowPageNew2 != null) {
                    BdViewOpUtils.removeView(landscapeVideoFlowPageNew2.getRootView());
                    this.mLandscapeView.onViewDestroy();
                    this.mLandscapeView = null;
                }
                BdVideoLog.e(TAG, (Throwable) e2);
            }
        }
    }

    private void registerNetWorkChangeReceiver() {
        if (this.mNetChangeReceiver == null) {
            this.mNetChangeReceiver = new NetChangeReceiver(this);
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        this.mContext.registerReceiver(this.mNetChangeReceiver, filter);
    }

    private void unRegisterNetWorkChangeReceiver() {
        this.mContext.unregisterReceiver(this.mNetChangeReceiver);
        this.mNetChangeReceiver = null;
    }

    private static class NetChangeReceiver extends BroadcastReceiver {
        private final WeakReference<VideoTabPageView> mPageViewWeakRef;

        public NetChangeReceiver(VideoTabPageView pageView) {
            this.mPageViewWeakRef = new WeakReference<>(pageView);
        }

        public void onReceive(Context context, Intent intent) {
            VideoTabPageView pageView;
            if (TextUtils.equals(intent.getAction(), PreloadConstantsKt.CONNECTIVITY_ACTION) && (pageView = (VideoTabPageView) this.mPageViewWeakRef.get()) != null) {
                if (pageView.mCurrentView instanceof FeedTabVideoView) {
                    ((FeedTabVideoView) pageView.mCurrentView).handNetChange();
                }
                pageView.onNetChange();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNetChange() {
    }

    private void registerPaymentChangeReceiver() {
        if (this.paymentReceiver == null) {
            ChannelPaymentReceiver channelPaymentReceiver = new ChannelPaymentReceiver();
            this.paymentReceiver = channelPaymentReceiver;
            channelPaymentReceiver.setIUpdateModel(new ChannelPaymentReceiver.IUpdateModel() {
                public void onUpdate(String albumId) {
                    VideoTabPageView.this.updateModel(albumId);
                }
            });
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(IVideoDependConstManager.Impl.get().getStringConst("1"));
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.paymentReceiver, filter);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r2 = r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateModel(java.lang.String r6) {
        /*
            r5 = this;
            com.baidu.searchbox.video.page.VideoBasePageView$FeedAdapter r0 = r5.getAdapter()
            java.util.ArrayList r0 = r0.getFeedList()
            int r1 = com.baidu.searchbox.video.channelpayment.VideoPaymenyUtil.findFeedBaseModelIndexById(r0, r6)
            r2 = -1
            if (r1 != r2) goto L_0x0010
            return
        L_0x0010:
            java.lang.Object r2 = r0.get(r1)
            com.baidu.searchbox.feed.model.FeedBaseModel r2 = (com.baidu.searchbox.feed.model.FeedBaseModel) r2
            if (r2 != 0) goto L_0x0019
            return
        L_0x0019:
            java.lang.String r3 = r2.id
            com.baidu.searchbox.video.page.VideoTabPageView$20 r4 = new com.baidu.searchbox.video.page.VideoTabPageView$20
            r4.<init>(r2, r1)
            com.baidu.searchbox.video.channelpayment.VideoPaymenyUtil.fetchRealUrl(r3, r6, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.page.VideoTabPageView.updateModel(java.lang.String):void");
    }

    private void unRegisterPaymentChangeReceiver() {
        if (this.paymentReceiver != null) {
            LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.paymentReceiver);
            this.paymentReceiver = null;
        }
    }

    /* access modifiers changed from: private */
    public ShortVideoPlayer getCurrentPlayer() {
        if (!(this.mCurrentView instanceof FeedTabVideoView)) {
            return null;
        }
        if (((FeedTabVideoView) this.mCurrentView).getBindPlayer() instanceof ShortVideoPlayer) {
            ShortVideoPlayer player = (ShortVideoPlayer) ((FeedTabVideoView) this.mCurrentView).getBindPlayer();
            player.setSwitchToFullInterceptCallBack(this.mFullInterceptCallBack);
            return player;
        }
        ShortVideoPlayer player2 = this.mPlayerManager.getPlayer(((FeedTabVideoView) this.mCurrentView).getBindModel());
        if (player2 != null) {
            player2.setSwitchToFullInterceptCallBack(this.mFullInterceptCallBack);
        }
        return player2;
    }

    /* access modifiers changed from: private */
    public ISwitchAssistant getCurrentAssistant() {
        if (this.mCurrentView instanceof FeedTabVideoView) {
            return this.mPlayerManager.getAssistant(((FeedTabVideoView) this.mCurrentView).getBindModel());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean isNotRefreshing() {
        return this.mPullToRefreshView == null || this.mPullToRefreshView.getState() == 0 || this.mPullToRefreshView.getState() == 8;
    }

    /* access modifiers changed from: protected */
    public List<FeedBaseModel> filterListData(ArrayList<FeedBaseModel> dataList) {
        if (dataList == null) {
            return null;
        }
        List<FeedBaseModel> newList = new ArrayList<>();
        for (int i2 = 0; i2 < dataList.size(); i2++) {
            FeedBaseModel model = dataList.get(i2);
            if (checkLayout(model.layout)) {
                newList.add(model);
            }
        }
        return newList;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayout(String layout) {
        return isAllowAutoPlayLayout(layout);
    }

    /* access modifiers changed from: protected */
    public boolean isAllowAutoPlayLayout(String layout) {
        return !"video_tab_video".equals(layout) && !FeedAdUtil.isVideoChannelNewLayout(layout).booleanValue();
    }
}
