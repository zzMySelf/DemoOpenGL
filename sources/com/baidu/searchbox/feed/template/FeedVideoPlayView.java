package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.availability.image.FeedDraweeCallerContext;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.feed.tab.view.FeedThinDividerPolicy;
import com.baidu.searchbox.feed.template.tplinterface.IVideoPlayerControl;
import com.baidu.searchbox.feed.video.FeedVideoState;
import com.baidu.searchbox.player.MuteVideoPlayer;
import com.baidu.searchbox.player.callback.SimpleVideoPlayerCallback;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.HashMap;

public class FeedVideoPlayView extends NewsFeedBaseView implements IVideoPlayerControl {
    private static final String IS_FROM_FEED = "true";
    private static final int KEY_VIDEO_TITLE = 1;
    private static final int KEY_VIDEO_URL = 0;
    private static final String UBC_FEED_VIDEO_ID = "160";
    private static final String UBC_FEED_VIDEO_PLAY_ID = "199";
    private static final String UBC_FEED_VIDEO_TYPE = "type";
    private static final String UBC_FEED_VIDEO_WIFI = "wifi";
    private static final String UBC_VIDEO_CURRENT_POSITION = "currentPosition";
    private static final String UBC_VIDEO_FROM = "isFromFeed";
    private static final String UBC_VIDEO_LENGTH = "length";
    private static final String UBC_VIDEO_NID = "nid";
    private static final String UBC_VIDEO_URL = "url";
    private static final int VIDEO_HOLDER_ID = Math.abs((int) System.currentTimeMillis());
    private static final int VIDEO_IMAGE_HEIGHT = 185;
    private static final int VIDEO_IMAGE_WIDTH = 360;
    private static final String VIDEO_NO_WIFI = "false";
    private static final String VIDEO_WIFI = "true";
    private boolean mHasClicked;
    private String mNid;
    /* access modifiers changed from: private */
    public boolean mPlayWithWifi;
    private MuteVideoPlayer mPlayer;
    private String mUrl;
    private TextView mVideoError;
    private FrameLayout mVideoHolder;
    protected FeedDraweeView mVideoImage;
    private HashMap<Integer, String> mVideoInfo = new HashMap<>();
    protected TextView mVideoLength;
    private ImageView mVideoPlayIcon;
    private FeedVideoState mVideoState = FeedVideoState.Prepare;

    public FeedVideoPlayView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        return inflater.inflate(R.layout.feed_tpl_video_play, this);
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        setPadding(getResources().getDimensionPixelSize(R.dimen.feed_template_m1), getResources().getDimensionPixelSize(R.dimen.feed_template_m2_title), getResources().getDimensionPixelSize(R.dimen.feed_template_m1), 0);
        this.mVideoImage = (FeedDraweeView) findViewById(R.id.feed_template_video_image_id);
        this.mVideoLength = (TextView) findViewById(R.id.feed_template_video_video_length_id);
        this.mVideoPlayIcon = (ImageView) findViewById(R.id.feed_template_video_image_video_icon_id);
        this.mVideoError = (TextView) findViewById(R.id.feed_video_play_error);
        this.mVideoImage.setTemplateFlag(14).setOnClickListener(this);
        updateVideoPlayView();
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        updateVideoPlayView();
    }

    private void updateVideoPlayView() {
        this.mVideoError.setTextColor(getResources().getColor(R.color.feed_video_play_error_text_color));
        this.mVideoError.setBackgroundColor(getResources().getColor(R.color.feed_video_play_error_bg_color));
        this.mVideoLength.setTextColor(getResources().getColor(R.color.feed_video_length_txt_color_cu));
        this.mVideoLength.setBackground(getResources().getDrawable(R.drawable.feed_video_tips_bg));
        this.mVideoPlayIcon.setImageDrawable(getResources().getDrawable(R.drawable.feed_video_play));
    }

    /* access modifiers changed from: protected */
    public void updateFeedOrderSense() {
        updateHorizontalPadding(this);
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
        int i2 = 8;
        if (model != null && (model.data instanceof FeedItemDataNews)) {
            FeedItemDataNews feedItemDataNews = (FeedItemDataNews) model.data;
            FeedItemDataNews itemData = feedItemDataNews;
            if (feedItemDataNews.hasVideo()) {
                this.mUrl = itemData.video;
                this.mNid = model.id;
                this.mVideoInfo.put(1, itemData.title);
                this.mVideoInfo.put(0, itemData.video);
                if (itemData.images != null && itemData.images.size() > 0) {
                    this.mVideoImage.setVisibility(0);
                    this.mVideoLength.setText(itemData.duration);
                    TextView textView = this.mVideoLength;
                    if (!TextUtils.isEmpty(itemData.duration)) {
                        i2 = 0;
                    }
                    textView.setVisibility(i2);
                    this.mVideoPlayIcon.setVisibility(0);
                    return;
                }
                return;
            }
        }
        this.mVideoImage.setVisibility(8);
        this.mVideoLength.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
        if (model != null && (model.data instanceof FeedItemDataNews)) {
            FeedItemDataNews itemData = (FeedItemDataNews) model.data;
            if (itemData.images != null && itemData.images.size() > 0) {
                this.mVideoImage.setPlaceHolderWithSelfFlag().loadImageWithSize(itemData.images.get(0).image, model, new ResizeOptions(DeviceUtil.ScreenInfo.dp2px(this.mFeedTemplateImplBase.mContext, 180.0f), DeviceUtil.ScreenInfo.dp2px(this.mFeedTemplateImplBase.mContext, 92.0f)), FeedDraweeCallerContext.getTemplateCallerContext(model));
            }
        }
        this.mVideoLength.setTextColor(this.mFeedTemplateImplBase.mContext.getResources().getColor(R.color.feed_video_length_txt_color_cu));
    }

    private void initPlayer() {
        if (this.mPlayer == null) {
            MuteVideoPlayer muteVideoPlayer = new MuteVideoPlayer(getContext());
            this.mPlayer = muteVideoPlayer;
            muteVideoPlayer.setMuteMode(true);
        }
        if (this.mVideoHolder == null) {
            FrameLayout layout = (FrameLayout) findViewById(R.id.feed_video_area);
            int i2 = VIDEO_HOLDER_ID;
            FrameLayout frameLayout = (FrameLayout) layout.findViewById(i2);
            this.mVideoHolder = frameLayout;
            if (frameLayout == null) {
                FrameLayout frameLayout2 = new FrameLayout(this.mFeedTemplateImplBase.mContext);
                this.mVideoHolder = frameLayout2;
                frameLayout2.setId(i2);
                this.mVideoHolder.setClickable(false);
                layout.addView(this.mVideoHolder, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
        this.mPlayer.attachToContainer(this.mVideoHolder);
        this.mPlayer.setPlayerListener(new SimpleVideoPlayerCallback() {
            boolean playSuccess = false;

            public void onStart() {
                super.onStart();
                if (!this.playSuccess) {
                    this.playSuccess = true;
                    FeedVideoPlayView feedVideoPlayView = FeedVideoPlayView.this;
                    boolean unused = feedVideoPlayView.mPlayWithWifi = feedVideoPlayView.isWifi();
                }
            }

            public void onEnd(int what) {
                super.onEnd(what);
                FeedVideoPlayView.this.destroyVideo(false);
                this.playSuccess = false;
            }

            public void onError(int what, int extra, String info) {
                super.onError(what, extra, info);
                FeedVideoPlayView.this.destroyVideo(true);
                this.playSuccess = false;
            }
        });
    }

    private void playVideo(HashMap<Integer, String> videoInfo) {
        initPlayer();
        MuteVideoPlayer muteVideoPlayer = this.mPlayer;
        if (muteVideoPlayer != null) {
            muteVideoPlayer.setVideoInfo(videoInfo);
            this.mPlayer.start();
        }
        updateView(FeedVideoState.Playing);
    }

    private void pauseVideo() {
        MuteVideoPlayer muteVideoPlayer = this.mPlayer;
        if (muteVideoPlayer != null) {
            muteVideoPlayer.goBackOrForeground(false);
        }
    }

    /* access modifiers changed from: private */
    public void destroyVideo(boolean destroyForError) {
        if (this.mPlayer != null) {
            uploadUBC();
            this.mPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
        }
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mVideoHolder.setVisibility(8);
            this.mVideoHolder.setClickable(false);
            this.mVideoHolder = null;
        }
        BdEventBus.Companion.getDefault().unregister(this);
        FeedVideoState state = destroyForError ? FeedVideoState.Error : FeedVideoState.Prepare;
        this.mHasClicked = false;
        updateView(state);
    }

    private void uploadUBC() {
        if (this.mPlayer != null) {
            HashMap<String, String> map = new HashMap<>(7);
            map.put("wifi", this.mPlayWithWifi ? "true" : "false");
            map.put(UBC_VIDEO_CURRENT_POSITION, String.valueOf(this.mPlayer.getPositionMs()));
            map.put("length", String.valueOf(this.mPlayer.getDurationMs()));
            map.put("url", this.mUrl);
            map.put("nid", this.mNid);
            map.put(UBC_VIDEO_FROM, "true");
            FeedUBCWrapper.ubcOnEvent("199", map, FeedUBCWrapper.getFrameSource(this.mFeedTemplateImplBase != null ? this.mFeedTemplateImplBase.mFeedModel : null));
        }
    }

    private void updateView(FeedVideoState videoState) {
        this.mVideoState = videoState;
        FrameLayout frameLayout = this.mVideoHolder;
        if (frameLayout != null) {
            frameLayout.setClickable(false);
            this.mVideoHolder.setVisibility(8);
        }
        switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState[videoState.ordinal()]) {
            case 1:
                this.mVideoPlayIcon.setVisibility(0);
                this.mVideoLength.setVisibility(0);
                this.mVideoError.setVisibility(8);
                return;
            case 2:
            case 3:
                FrameLayout frameLayout2 = this.mVideoHolder;
                if (frameLayout2 != null) {
                    frameLayout2.setClickable(true);
                    this.mVideoHolder.setVisibility(0);
                }
                this.mVideoPlayIcon.setVisibility(8);
                this.mVideoLength.setVisibility(8);
                this.mVideoError.setVisibility(8);
                return;
            case 4:
                this.mVideoPlayIcon.setVisibility(8);
                this.mVideoLength.setVisibility(8);
                this.mVideoError.setVisibility(0);
                return;
            default:
                this.mVideoPlayIcon.setVisibility(0);
                this.mVideoLength.setVisibility(0);
                this.mVideoError.setVisibility(8);
                return;
        }
    }

    /* renamed from: com.baidu.searchbox.feed.template.FeedVideoPlayView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState;

        static {
            int[] iArr = new int[FeedVideoState.values().length];
            $SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState = iArr;
            try {
                iArr[FeedVideoState.Prepare.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState[FeedVideoState.Playing.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState[FeedVideoState.Pause.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$video$FeedVideoState[FeedVideoState.Error.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mVideoState.equals(FeedVideoState.Playing)) {
            destroyVideo(false);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        if (this.mVideoState.equals(FeedVideoState.Playing)) {
            destroyVideo(false);
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    /* access modifiers changed from: private */
    public boolean isWifi() {
        return NetWorkUtils.isWifiNetworkConnected();
    }

    public boolean isPlaying() {
        return !this.mVideoState.equals(FeedVideoState.Prepare);
    }

    public boolean hasClicked() {
        return this.mHasClicked;
    }

    public void startPlay() {
        this.mHasClicked = true;
        playVideo(this.mVideoInfo);
    }

    public void pausePlay() {
        pauseVideo();
    }

    public void stopPlay() {
        destroyVideo(false);
    }

    public void forceStopPlay() {
        destroyVideo(false);
    }

    public void onClick(View v) {
        if (this.mFeedTemplateImplBase.mClickListener != null) {
            if (v.getId() == R.id.feed_template_video_image_id) {
                setTag(this.mFeedTemplateImplBase.mFeedModel);
                this.mFeedTemplateImplBase.mClickListener.onClick(this);
                return;
            }
            v.setTag(this.mFeedTemplateImplBase.mFeedModel);
            this.mFeedTemplateImplBase.mClickListener.onClick(v);
        }
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThinDividerPolicy.getDefault();
    }

    public int getDividerOffset() {
        return getResources().getDimensionPixelOffset(R.dimen.feed_template_m2_real);
    }
}
