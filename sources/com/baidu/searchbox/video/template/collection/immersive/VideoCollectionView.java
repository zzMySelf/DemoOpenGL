package com.baidu.searchbox.video.template.collection.immersive;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.event.VideoCollectionWakeupEvent;
import com.baidu.searchbox.feed.event.VideoDestroyEvent;
import com.baidu.searchbox.feed.ioc.IFeedVideoDetail;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.FeedItemImmersiveVideoModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.template.CollectionVideoBottomView;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedRelativeLayout;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.feed.template.tplinterface.ICollectionVideoControl;
import com.baidu.searchbox.feed.template.tplinterface.IVideoImmersiveClickCommentTitleListener;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.helper.ClarityHelper;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.KernelLayer;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.BdVideoNewParser;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class VideoCollectionView extends FeedRelativeLayout implements ICollectionVideoControl, IVideoImmersiveClickCommentTitleListener {
    private static final float AUTO_PLAY_AREA_RATIO = 0.6666667f;
    private static final float HEIGHT_WIDTH_RATIO = 0.5625f;
    private static final String TAG = "FeedImmersiveVideoView";
    private static final int VIDEO_PLAY_PROGRESS = 5;
    private static final int VIDEO_SHADOW_ANIMATION_DURATION = 250;
    private boolean isSuccessReuseKernel = false;
    private int mBackgroundColor = 1052688;
    private View mBottomShadow;
    private CollectionVideoBottomView mBottomView;
    private Context mContext;
    private int mDuration;
    private FeedBaseModel mFeedModel;
    private FeedPolicyModel mFeedPolicyModel;
    private boolean mHasClicked;
    private boolean mIsClassicTheme = true;
    private FeedItemImmersiveVideoModel mItemModel;
    private Animator mLightOffPlayAreaAnimator;
    private Animator mLightOnPlayAreaAnimator;
    private String mNeedReplaceUrl;
    private OnClickCommentTitleListener mOnClickCommentTitleListener;
    private BaseVideoPlayer mPlayer;
    private int mProgress;
    private TextView mVideoError;
    private FrameLayout mVideoHolder;
    private FeedDraweeView mVideoImage;
    private int mVideoImageHeight;
    private int mVideoImageWidth;
    private HashMap<Integer, String> mVideoInfo = new HashMap<>();
    private ImageView mVideoPlayIcon;
    /* access modifiers changed from: private */
    public View mVideoShadow;
    private VideoState mVideoState = VideoState.PREPARE;

    public interface OnClickCommentTitleListener {
        void onClickComment();

        void onClickTitle();
    }

    enum VideoState {
        PREPARE,
        PLAYING,
        PAUSE,
        ERROR,
        PLAYED
    }

    public VideoCollectionView(Context context) {
        super(context);
        this.mContext = context;
        initUi();
    }

    public void setPlayer(BaseVideoPlayer shortVideoPlayer) {
        this.mPlayer = shortVideoPlayer;
    }

    public void setFeedPolicyModel(FeedPolicyModel policyModel) {
        this.mFeedPolicyModel = policyModel;
    }

    public FeedPolicyModel getFeedPolicyModel() {
        return this.mFeedPolicyModel;
    }

    private void initUi() {
        View view2 = LayoutInflater.from(this.mContext).inflate(R.layout.feed_tpl_immersive_video, this);
        this.mVideoImage = (FeedDraweeView) view2.findViewById(R.id.feed_tpl_immersive_video_img_id);
        this.mVideoHolder = (FrameLayout) view2.findViewById(R.id.video_holder);
        this.mVideoPlayIcon = (ImageView) view2.findViewById(R.id.feed_tpl_immersive_video_play_icon_id);
        this.mVideoImage.setTemplateFlag(4);
        this.mVideoError = (TextView) view2.findViewById(com.baidu.searchbox.video.template.R.id.feed_video_play_error);
        this.mVideoShadow = view2.findViewById(R.id.video_surface_shadow);
        this.mVideoImage.setOnClickListener(this);
        this.mVideoPlayIcon.setOnClickListener(this);
        this.mVideoError.setOnClickListener(this);
        this.mVideoShadow.setOnClickListener(this);
        this.mVideoHolder.setOnClickListener(this);
        int calculateWidth = FeedTemplateUtil.getCalculateWidth(getContext());
        this.mVideoImageWidth = calculateWidth;
        this.mVideoImageHeight = Math.round(((float) calculateWidth) * 0.5625f);
        ViewGroup.LayoutParams imageLP = this.mVideoImage.getLayoutParams();
        imageLP.width = this.mVideoImageWidth;
        imageLP.height = this.mVideoImageHeight;
        this.mVideoImage.setLayoutParams(imageLP);
        this.mVideoHolder.setLayoutParams(imageLP);
        ViewGroup.LayoutParams errorLP = this.mVideoError.getLayoutParams();
        errorLP.height = this.mVideoImageHeight;
        this.mVideoError.setLayoutParams(errorLP);
        ViewGroup.LayoutParams videoShadowLp = this.mVideoShadow.getLayoutParams();
        videoShadowLp.height = this.mVideoImageHeight;
        this.mVideoShadow.setLayoutParams(videoShadowLp);
        initAnimator();
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        updateView(feedModel);
        if (createBottomView(feedModel)) {
            this.mBottomView.updateView(feedModel);
            this.mBottomView.getBottomRootView().setVisibility(0);
            createVideoInfo(feedModel);
        }
    }

    private boolean createBottomView(FeedBaseModel feedModel) {
        if (feedModel == null || feedModel.layout == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.feed_tpl_immersive_video_img_id);
        if (this.mBottomView != null) {
            return true;
        }
        CollectionVideoBottomView collectionVideoBottomView = new CollectionVideoBottomView(this.mContext);
        this.mBottomView = collectionVideoBottomView;
        collectionVideoBottomView.setDislikeListener(new CollectionVideoBottomView.OnDislikeListener() {
            public void onDislikeClick(View view2) {
                if (VideoCollectionView.this.mFeedTemplateImplBase.mClickListener != null) {
                    VideoCollectionView.this.mFeedTemplateImplBase.mClickListener.onClick(view2);
                }
            }
        });
        addView(this.mBottomView.getBottomRootView(), layoutParams);
        View bottomShadow = this.mBottomView.getBottomShadow();
        this.mBottomShadow = bottomShadow;
        bottomShadow.setOnClickListener(this);
        this.mBottomView.getBottomRootView().setVisibility(8);
        this.mBottomView.setOnClickCommentTitleListener(this);
        return true;
    }

    private void initAnimator() {
        float backgroundRatio = ((float) this.mBackgroundColor) / 1.6777215E7f;
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mVideoShadow, "alpha", new float[]{1.0f, backgroundRatio}).setDuration(250);
        this.mLightOnPlayAreaAnimator = duration;
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                VideoCollectionView.this.mVideoShadow.setVisibility(8);
            }
        });
        this.mLightOffPlayAreaAnimator = ObjectAnimator.ofFloat(this.mVideoShadow, "alpha", new float[]{backgroundRatio, 1.0f}).setDuration(250);
    }

    public void updateBottomView(FeedBaseModel feedModel) {
        if (this.mBottomView != null) {
            this.mFeedModel.id = feedModel.id;
            this.mFeedModel.data = feedModel.data;
            this.mFeedModel.feedback = feedModel.feedback;
            this.mFeedModel.runtimeStatus.business = feedModel.runtimeStatus.business;
            if (feedModel.data instanceof FeedItemImmersiveVideoModel) {
                this.mItemModel = (FeedItemImmersiveVideoModel) feedModel.data;
            }
            this.mBottomView.updateView(feedModel);
        }
    }

    public void updateBottomTitle(FeedBaseModel feedModel) {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.updateBottomTitle(feedModel);
        }
    }

    private void createVideoInfo(FeedBaseModel feedModel) {
        if (feedModel != null && (feedModel.data instanceof FeedItemImmersiveVideoModel)) {
            FeedItemImmersiveVideoModel itemData = (FeedItemImmersiveVideoModel) feedModel.data;
            this.mVideoInfo.put(0, itemData.mVideoUrl);
            this.mVideoInfo.put(106, "false");
            this.mVideoInfo.put(110, "true");
            FeedItemDataTabVideo.VideoInfoEntity videoInfoEntity = ((FeedItemImmersiveVideoModel) feedModel.data).mVideoInfo;
            if (videoInfoEntity != null) {
                this.mVideoInfo.put(1, videoInfoEntity.mTitle);
                this.mVideoInfo.put(108, videoInfoEntity.mExt);
                this.mVideoInfo.put(5, videoInfoEntity.mPageUrl);
                this.mVideoInfo.put(301, videoInfoEntity.mFrom);
                this.mVideoInfo.put(124, videoInfoEntity.mPage);
                this.mVideoInfo.put(107, videoInfoEntity.mPosterImage);
                this.mVideoInfo.put(112, videoInfoEntity.mDuration + "");
                this.mVideoInfo.put(113, videoInfoEntity.mVid);
                this.mVideoInfo.put(111, videoInfoEntity.mExtLog);
                if (!TextUtils.isEmpty(videoInfoEntity.mExt)) {
                    try {
                        new JSONObject(videoInfoEntity.mExt);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (videoInfoEntity.mPlayerAnimation != null) {
                    FeedItemDataTabVideo.PlayerAnimation playerAnimation = videoInfoEntity.mPlayerAnimation;
                    this.mVideoInfo.put(120, playerAnimation.mEnable ? "1" : "0");
                    if (playerAnimation.mEnable) {
                        this.mVideoInfo.put(121, playerAnimation.mJumpScheme);
                        this.mVideoInfo.put(122, playerAnimation.mDownloadScheme);
                        this.mVideoInfo.put(123, playerAnimation.mDownloadToast);
                    }
                }
            } else {
                this.mVideoInfo.put(1, itemData.title);
                this.mVideoInfo.put(108, "");
            }
            if (itemData.mImage != null && videoInfoEntity == null) {
                this.mVideoInfo.put(107, itemData.mImage);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseVideoPlayer baseVideoPlayer;
        super.onDetachedFromWindow();
        if (!this.mVideoState.equals(VideoState.PREPARE) && (baseVideoPlayer = this.mPlayer) != null && !baseVideoPlayer.isFullMode()) {
            destroyVideo(false);
        }
        removeView(this.mBottomShadow);
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.detachFromVideoView();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        int width = this.mVideoPlayIcon.getMeasuredWidth();
        int height = this.mVideoPlayIcon.getMeasuredHeight();
        ImageView imageView = this.mVideoPlayIcon;
        int i2 = this.mVideoImageWidth;
        int i3 = this.mVideoImageHeight;
        imageView.layout((i2 - width) / 2, (i3 - height) / 2, ((i2 - width) / 2) + width, ((i3 - height) / 2) + height);
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.onFontSizeChanged(fontSizeInPx);
        }
    }

    private void setClickIntercept(boolean isHandleClickViewSelf) {
        FeedRuntime.getFeedVideoDetail().setRootClickListener(this.mPlayer, this, isHandleClickViewSelf);
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null) {
            frameLayout.setClickable(!isHandleClickViewSelf);
        }
    }

    private void playVideo(HashMap<Integer, String> videoInfo, boolean autoPlay) {
        setClickIntercept(false);
        BaseVideoPlayer baseVideoPlayer = this.mPlayer;
        if (baseVideoPlayer != null && !baseVideoPlayer.isFullMode()) {
            this.mPlayer.attachToContainer(this.mVideoHolder);
        }
        if (this.mItemModel.mVideoInfo != null && !TextUtils.isEmpty(this.mItemModel.mVideoInfo.mPageUrl)) {
            videoInfo.put(5, this.mItemModel.mVideoInfo.mPageUrl);
        }
        if (this.mPlayer != null) {
            BdVideoSeries series = BdVideoNewParser.parseToVideoSeriesSafely(videoInfo);
            if (!TextUtils.isEmpty(this.mNeedReplaceUrl) && this.isSuccessReuseKernel) {
                ClarityHelper.replaceUrl(series, this.mNeedReplaceUrl);
            }
            if (series != null) {
                this.mPlayer.setVideoSeries(series);
            }
            if (this.mPlayer.getVideoSeries() != null) {
                this.mPlayer.getVideoSeries().setVideoAd(buildVideoAd());
                IFeedVideoDetail feedVideoDetail = FeedRuntime.getFeedVideoDetail();
                BaseVideoPlayer baseVideoPlayer2 = this.mPlayer;
                feedVideoDetail.changeInterceptor(baseVideoPlayer2, baseVideoPlayer2.getVideoSeries());
            }
            if (autoPlay) {
                FeedRuntime.getFeedVideoDetail().start(this.mPlayer, true);
            } else {
                FeedRuntime.getFeedVideoDetail().start(this.mPlayer, false);
            }
            if (this.isSuccessReuseKernel && this.mPlayer.isPause()) {
                if (BDVideoPlayer.isGlobalMute()) {
                    this.mPlayer.setGlobalMuteMode(true);
                }
                this.mPlayer.resume();
                this.isSuccessReuseKernel = false;
            }
            updateView(VideoState.PLAYING, false);
        }
    }

    public void setSuccessReuseKernelUrl(boolean isReuseKernel, String videoUrl) {
        this.isSuccessReuseKernel = isReuseKernel;
        this.mNeedReplaceUrl = videoUrl;
    }

    /* access modifiers changed from: protected */
    public BdVideoAd buildVideoAd() {
        String tpl;
        String source;
        if (this.mVideoInfo.isEmpty() || !TextUtils.equals("search", this.mVideoInfo.get(301))) {
            source = "immersive";
            tpl = "feed";
        } else {
            source = "search_immersive";
            tpl = "search";
        }
        return new BdVideoAd.Builder().pauseAd(false).suffixAd(true).source(source).tpl(tpl).page("video_landing").pos(-5).build();
    }

    public void onUpdateProgress(int progress, int duration) {
        this.mProgress = progress;
        this.mDuration = duration;
        if (isPromoteValid() && progress > 5) {
            this.mBottomView.showDownloadPromote();
        }
    }

    public void onClick(View v) {
        if (this.mFeedTemplateImplBase.mClickListener != null) {
            setTag(this.mFeedTemplateImplBase.mFeedModel);
            this.mFeedTemplateImplBase.mClickListener.onClick(v);
        }
    }

    private void stopVideoPlay() {
        BaseVideoPlayer baseVideoPlayer = this.mPlayer;
        if (baseVideoPlayer != null) {
            if (!baseVideoPlayer.isStop()) {
                this.mPlayer.stop();
            }
            if (this.mPlayer.getPlayerKernelLayer() == null) {
                this.mPlayer.attachKernelLayer(new KernelLayer(AbsVideoKernel.CYBER_PLAYER));
            }
            this.mHasClicked = false;
            updateView(VideoState.PREPARE, false);
            dismissBottomMenu();
        }
    }

    private void destroyVideo(boolean destroyForError) {
        if (this.mDuration > 0 && this.mProgress >= 0) {
            BdEventBus.Companion.getDefault().post(new VideoDestroyEvent(this.mFeedModel.id, (int) ((((double) this.mProgress) * 100.0d) / ((double) this.mDuration))));
        }
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mVideoHolder.setVisibility(4);
            this.mVideoHolder.setClickable(false);
        }
        VideoState state = destroyForError ? VideoState.ERROR : VideoState.PREPARE;
        this.mHasClicked = false;
        updateView(state, destroyForError);
        dismissBottomMenu();
    }

    public void destroyVideo() {
        destroyVideo(false);
    }

    private void updateView(FeedBaseModel feedModel) {
        if (feedModel == null || !(feedModel.data instanceof FeedItemImmersiveVideoModel)) {
            this.mVideoImage.setVisibility(8);
            return;
        }
        this.mFeedModel = feedModel;
        this.mItemModel = (FeedItemImmersiveVideoModel) feedModel.data;
        this.mVideoPlayIcon.setVisibility(0);
        String url = ((FeedItemImmersiveVideoModel) feedModel.data).mVideoInfo.mPosterImage;
        if (!TextUtils.isEmpty(url)) {
            this.mVideoImage.setVisibility(0);
        }
        new ResizeOptions(DeviceUtil.ScreenInfo.dp2px(getContext(), (float) (this.mVideoImageWidth / 2)), DeviceUtil.ScreenInfo.dp2px(getContext(), (float) (this.mVideoImageHeight / 2)));
        this.mVideoImage.setPlaceHolderWithSelfFlag().loadImage(url, feedModel);
    }

    private void updateView(VideoState videoState, boolean isDestroy) {
        this.mVideoState = videoState;
        FrameLayout frameLayout = this.mVideoHolder;
        int i2 = 8;
        if (frameLayout != null) {
            frameLayout.setClickable(false);
            this.mVideoHolder.setVisibility(8);
        }
        switch (AnonymousClass3.$SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState[videoState.ordinal()]) {
            case 1:
            case 2:
                this.mVideoImage.setVisibility(0);
                this.mVideoPlayIcon.setVisibility(0);
                this.mVideoError.setVisibility(8);
                return;
            case 3:
            case 4:
                FrameLayout frameLayout2 = this.mVideoHolder;
                if (frameLayout2 != null) {
                    frameLayout2.setClickable(true);
                    if (this.mVideoHolder.getVisibility() != 0) {
                        this.mVideoHolder.setVisibility(0);
                    }
                }
                this.mVideoImage.setVisibility(4);
                this.mVideoPlayIcon.setVisibility(8);
                this.mVideoError.setVisibility(8);
                lightOnPlayAreaIfNeed();
                BdEventBus.Companion.getDefault().post(new VideoCollectionWakeupEvent(this, 1));
                return;
            case 5:
                this.mVideoImage.setVisibility(4);
                this.mVideoPlayIcon.setVisibility(8);
                if (isDestroy) {
                    this.mVideoError.setVisibility(0);
                    return;
                } else {
                    this.mVideoError.setVisibility(8);
                    return;
                }
            default:
                this.mVideoImage.setVisibility(0);
                this.mVideoPlayIcon.setVisibility(0);
                TextView textView = this.mVideoError;
                if (isDestroy) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                return;
        }
    }

    /* renamed from: com.baidu.searchbox.video.template.collection.immersive.VideoCollectionView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState;

        static {
            int[] iArr = new int[VideoState.values().length];
            $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState = iArr;
            try {
                iArr[VideoState.PREPARE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState[VideoState.PLAYED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState[VideoState.PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState[VideoState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$template$collection$immersive$VideoCollectionView$VideoState[VideoState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private void showVideoHolder() {
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null && !frameLayout.isShown()) {
            this.mVideoHolder.bringToFront();
            this.mVideoHolder.setVisibility(0);
            this.mVideoHolder.setClickable(true);
        }
    }

    private void hideVideoHolder() {
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null) {
            frameLayout.setClickable(false);
            this.mVideoHolder.setVisibility(4);
        }
    }

    public boolean isPlaying() {
        return !this.mVideoState.equals(VideoState.PREPARE);
    }

    public boolean hasClicked() {
        return this.mHasClicked;
    }

    public void startPlay() {
        if (!isStaticDisplay()) {
            play(false);
        }
    }

    public void startAutoPlay(boolean isScroll) {
        if (!isStaticDisplay()) {
            play(true);
        }
        if (isScroll) {
            hidePromoteView();
        }
    }

    private void play(boolean isAuto) {
        this.mHasClicked = true;
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        if (hashMap != null) {
            playVideo(hashMap, isAuto);
        }
    }

    private boolean isStaticDisplay() {
        FeedItemImmersiveVideoModel feedItemImmersiveVideoModel = this.mItemModel;
        return feedItemImmersiveVideoModel != null && feedItemImmersiveVideoModel.isStaticDisplay();
    }

    public void resumePlayer() {
        if (this.mPlayer != null && !isStaticDisplay()) {
            this.mPlayer.resume();
            this.mPlayer.goBackOrForeground(true);
            updateView(VideoState.PLAYING, false);
        }
    }

    public void pausePlay() {
        pauseVideo();
    }

    public void pauseVideo() {
        BaseVideoPlayer baseVideoPlayer = this.mPlayer;
        if (baseVideoPlayer != null) {
            baseVideoPlayer.goBackOrForeground(false);
            this.mPlayer.pause();
        }
    }

    public void stopPlay() {
        BaseVideoPlayer baseVideoPlayer = this.mPlayer;
        if (baseVideoPlayer == null || !baseVideoPlayer.isFullMode() || this.mVideoState == VideoState.PLAYED) {
            stopVideoPlay();
            return;
        }
        if (isSuffixPlay()) {
            this.mPlayer.goBackOrForeground(false);
        }
        this.mPlayer.pause();
        this.mHasClicked = false;
        updateView(VideoState.PREPARE, false);
    }

    public void forceStopPlay() {
        stopPlay();
    }

    public void onClickComment() {
        OnClickCommentTitleListener onClickCommentTitleListener = this.mOnClickCommentTitleListener;
        if (onClickCommentTitleListener != null) {
            onClickCommentTitleListener.onClickComment();
        }
    }

    public void onClickTitle() {
        OnClickCommentTitleListener onClickCommentTitleListener = this.mOnClickCommentTitleListener;
        if (onClickCommentTitleListener != null) {
            onClickCommentTitleListener.onClickTitle();
        }
    }

    public boolean isSupportAutoPlay() {
        Rect childRect = new Rect();
        boolean isInParent = this.mVideoImage.getGlobalVisibleRect(childRect);
        float visibleAreaRatio = ((float) (childRect.bottom - childRect.top)) / ((float) this.mVideoImage.getMeasuredHeight());
        if (!isInParent || childRect.bottom <= 0 || visibleAreaRatio <= 0.6666667f) {
            return false;
        }
        return true;
    }

    public void lightOffIfNeed() {
        lightOffPlayAreaIfNeed();
        lightOffBottomIfNeed();
    }

    public void lightOnIfNeed() {
        lightOnPlayAreaIfNeed();
        BdEventBus.Companion.getDefault().post(new VideoCollectionWakeupEvent(this, 0));
    }

    public void lightOffBottomIfNeed() {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.lightOffBottomAreaIfNeed();
        }
    }

    public void lightOnPlayAreaIfNeed() {
        boolean isLightOn = this.mVideoShadow.getVisibility() == 8 && !this.mLightOnPlayAreaAnimator.isRunning() && !this.mLightOffPlayAreaAnimator.isRunning();
        if (!this.mLightOnPlayAreaAnimator.isRunning() && !isLightOn) {
            if (this.mLightOffPlayAreaAnimator.isRunning()) {
                this.mLightOffPlayAreaAnimator.end();
            }
            this.mLightOnPlayAreaAnimator.start();
        }
    }

    private void lightOffPlayAreaIfNeed() {
        boolean isLightOff = this.mVideoShadow.getVisibility() == 0 && !this.mLightOnPlayAreaAnimator.isRunning() && !this.mLightOffPlayAreaAnimator.isRunning();
        if (!this.mLightOffPlayAreaAnimator.isRunning() && !isLightOff) {
            if (this.mLightOnPlayAreaAnimator.isRunning()) {
                this.mLightOnPlayAreaAnimator.end();
            }
            this.mVideoShadow.setVisibility(0);
            this.mLightOffPlayAreaAnimator.start();
        }
    }

    public void lightOnBottomInfoAWhile() {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.lightOnBottomInfoAWhile();
        }
    }

    public void lightOnBottomInfoAlways() {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.lightOnBottomInfoAlways();
        }
    }

    public void updateHighlightSwitchChangeAnimation() {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.updataHighlightSwitchChangeAnimation();
        }
    }

    public FeedBaseModel getFeedBaseModel() {
        return getFeedModel();
    }

    public String getNid() {
        return this.mFeedModel.id;
    }

    public void updateByLinkageDate(LinkageData linkageData) {
        FeedItemImmersiveVideoModel feedItemImmersiveVideoModel;
        if (linkageData != null) {
            if (TextUtils.equals(linkageData.type, "comment")) {
                FeedItemImmersiveVideoModel feedItemImmersiveVideoModel2 = this.mItemModel;
                if (!(feedItemImmersiveVideoModel2 == null || feedItemImmersiveVideoModel2.feedBar == null || this.mItemModel.feedBar.comment == null)) {
                    this.mItemModel.feedBar.comment.count = FeedUtil.convertStringToIntSafe(linkageData.count);
                }
            } else if (!(!TextUtils.equals(linkageData.type, "pro") || (feedItemImmersiveVideoModel = this.mItemModel) == null || feedItemImmersiveVideoModel.feedBar == null || this.mItemModel.feedBar.like == null)) {
                this.mItemModel.feedBar.like.status = TextUtils.equals(linkageData.status, "1");
                this.mItemModel.feedBar.like.count = FeedUtil.convertStringToIntSafe(linkageData.count);
            }
            updateBottomView(this.mFeedModel);
        }
    }

    public boolean isPlayerPlay() {
        BaseVideoPlayer baseVideoPlayer = this.mPlayer;
        return baseVideoPlayer != null && baseVideoPlayer.isPlaying();
    }

    public boolean isSuffixPlay() {
        return (this.mPlayer == null || FeedRuntime.getFeedVideoDetail().getAdLayerProxy(this.mPlayer) == null || !FeedRuntime.getFeedVideoDetail().getAdLayerProxy(this.mPlayer).isAdLayerVisible()) ? false : true;
    }

    public void setOnClickCommentTitleListener(OnClickCommentTitleListener onClickCommentTitleListener) {
        this.mOnClickCommentTitleListener = onClickCommentTitleListener;
    }

    public View getVideoShadow() {
        return this.mVideoShadow;
    }

    public FrameLayout getVideoHolder() {
        return this.mVideoHolder;
    }

    public void dismissBottomMenu() {
        CollectionVideoBottomView collectionVideoBottomView = this.mBottomView;
        if (collectionVideoBottomView != null) {
            collectionVideoBottomView.menuDismiss(0);
        }
    }

    private boolean isPromoteValid() {
        FeedItemImmersiveVideoModel feedItemImmersiveVideoModel = this.mItemModel;
        return feedItemImmersiveVideoModel != null && feedItemImmersiveVideoModel.mPromote != null && this.mItemModel.mPromote.isValuable() && this.mBottomView.isPromoteNotShowing();
    }

    private void hidePromoteView() {
        this.mBottomView.hideDownloadPromote();
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        FeedItemImmersiveVideoModel feedItemImmersiveVideoModel;
        if (!(this.mVideoShadow.getVisibility() != 0) || (feedItemImmersiveVideoModel = this.mItemModel) == null || (!feedItemImmersiveVideoModel.isStaticDisplay() && !this.mItemModel.isDynamicDisplay())) {
            return false;
        }
        return true;
    }
}
