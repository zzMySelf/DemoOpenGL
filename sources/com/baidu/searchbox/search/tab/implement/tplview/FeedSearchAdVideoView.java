package com.baidu.searchbox.search.tab.implement.tplview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.ad.view.SimpleAdInfoView;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.model.VideoAdItemVerticalStyleModel;
import com.baidu.searchbox.feed.ad.util.AdDataReduceUtils;
import com.baidu.searchbox.feed.ad.util.FeedAdLogUtil;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.base.AbstractFeedTemplate;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.net.ADRequester;
import com.baidu.searchbox.feed.net.ParallelCharge;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.tab.view.FeedThinDividerPolicy;
import com.baidu.searchbox.feed.template.FeedAdBaseView;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.template.appdownload.NadLoftDownloadStateButton;
import com.baidu.searchbox.feed.template.common.view.RoundCornerFrameLayout;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo;
import com.baidu.searchbox.search.tab.implement.player.PlayerLayerConfig;
import com.baidu.searchbox.search.tab.implement.player.callback.GestureListener;
import com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext;
import com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper;
import com.baidu.searchbox.search.tab.implement.tplmodel.FeedItemDataSearchAdVideo;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBigImageModel;
import com.baidu.searchbox.search.tab.implement.utils.VideoCommonVideoViewUtilsKt;
import com.baidu.searchbox.search.tab.implement.utils.VideoFontUtilsKt;
import com.baidu.searchbox.search.tab.implement.utils.VideoTabAdVideoViewUtilsKt;
import com.baidu.searchbox.search.video.business.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedSearchAdVideoView extends FeedAdBaseView implements PlayerAttachInfo, View.OnClickListener {
    private static final String TAG = "FeedSearchAdVideoView";
    protected FeedDraweeView mBottomImage;
    private RoundCornerFrameLayout mHolder;
    public IListPlayerContext mPlayerHelper;
    protected TextView mTitle;
    protected RelativeLayout mVideoContainer;
    protected FeedDraweeView mVideoImage;
    private int mVideoImageHeight;
    private int mVideoImageWidth;
    private HashMap<Integer, String> mVideoInfo;
    public TextView mVideoLength;
    private BdBaseImageView mVideoPlayIcon;
    protected int mVideoPlayerRightMargin;
    protected int mVideoPlayerWidth;

    public FeedSearchAdVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedSearchAdVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedSearchAdVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mVideoInfo = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        return inflater.inflate(R.layout.feed_tpl_tab_search_video_ad, this);
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        int paddingHorizontal = VideoCommonVideoViewUtilsKt.getTemplateHorizontalPaddingInPx();
        setPadding(paddingHorizontal, 0, paddingHorizontal, 0);
        View mRootView = findViewById(R.id.feed_template_base);
        View mImageRegion = findViewById(R.id.feed_img_region);
        TextView textView = (TextView) findViewById(R.id.feed_template_base_title_id);
        this.mTitle = textView;
        VideoCommonVideoViewUtilsKt.updateTitleStyle(textView);
        this.mVideoImage = (FeedDraweeView) findViewById(R.id.tab_video_img);
        this.mBottomImage = (FeedDraweeView) findViewById(R.id.tab_bottom_img);
        this.mVideoContainer = (RelativeLayout) findViewById(R.id.video_container);
        this.mVideoLength = VideoTabAdVideoViewUtilsKt.initVideoLength(this);
        this.mVideoPlayIcon = (BdBaseImageView) VideoTabAdVideoViewUtilsKt.initPlayIcon(this);
        RoundCornerFrameLayout roundCornerFrameLayout = (RoundCornerFrameLayout) findViewById(R.id.feed_template_mute_video_layout);
        this.mHolder = roundCornerFrameLayout;
        roundCornerFrameLayout.setCornerRadius(FeedTemplateImgCornersUtil.FEED_IMG_CORNER_SMALL);
        this.mHolder.setBackgroundColor(Color.parseColor("#00ffffff"));
        int calculateWidth = FeedTemplateUtil.getCalculateWidth(context) - (paddingHorizontal * 2);
        this.mVideoImageWidth = calculateWidth;
        this.mVideoImageHeight = Math.round((((float) calculateWidth) * 9.0f) / 16.0f);
        this.mVideoPlayerWidth = this.mVideoImageWidth;
        this.mVideoPlayerRightMargin = 0;
        RelativeLayout.LayoutParams imageLP = (RelativeLayout.LayoutParams) mImageRegion.getLayoutParams();
        imageLP.width = this.mVideoImageWidth;
        imageLP.height = this.mVideoImageHeight;
        mImageRegion.setLayoutParams(imageLP);
        FeedTemplateImgCornersUtil.processSingleImgSmallCorners(this.mVideoImage);
        FeedTemplateImgCornersUtil.processSingleImgSmallCorners(this.mBottomImage);
        onFeedNightModeChanged(NightModeHelper.getNightModeSwitcherState());
        this.mTitle.setOnClickListener(this);
        this.mHolder.setOnClickListener(this);
        mImageRegion.setOnClickListener(this);
        mRootView.setOnClickListener(this);
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        if (feedModel != null && (feedModel.data instanceof FeedItemDataSearchAdVideo)) {
            FeedItemDataSearchAdVideo itemData = (FeedItemDataSearchAdVideo) feedModel.data;
            this.mTitle.setText(itemData.title);
            if (FeedAdUtil.needAdaptSearchVideoDarkBg()) {
                this.mTitle.setTextColor(getResources().getColor(com.baidu.searchbox.search.style.res.R.color.SVC1));
            } else {
                this.mTitle.setTextColor(getResources().getColor(VideoCommonVideoViewUtilsKt.getTitleColorRes()));
            }
            this.mVideoLength.setText(itemData.duration);
            if (itemData.images != null && itemData.images.size() > 0) {
                this.mVideoImage.setPlaceHolderWithSelfFlag().loadImageWithSize(((FeedItemDataNews.Image) itemData.images.get(0)).image, feedModel, new ResizeOptions(this.mVideoImageWidth / 2, this.mVideoImageHeight / 2));
            }
            if (itemData.ad == null || itemData.ad.feed == null || itemData.ad.feed.mVideoAdItemVerticalStyleModel == null) {
                this.mBottomImage.setVisibility(8);
            } else {
                VideoAdItemVerticalStyleModel styleModel = itemData.ad.feed.mVideoAdItemVerticalStyleModel;
                if (styleModel.bottomPicture != null) {
                    this.mBottomImage.setPlaceHolderWithSelfFlag().loadImageWithSize(styleModel.bottomPicture, feedModel, new ResizeOptions(this.mVideoImageWidth / 2, this.mVideoImageHeight / 2));
                    this.mBottomImage.setVisibility(0);
                    if (styleModel.playerWidthRatio > 0.0d) {
                        this.mVideoPlayerWidth = (int) (((double) this.mVideoImageWidth) * styleModel.playerWidthRatio);
                    }
                    if (styleModel.rightMarginRatio > 0.0d) {
                        this.mVideoPlayerRightMargin = (int) (((double) this.mVideoImageWidth) * styleModel.rightMarginRatio);
                    }
                }
            }
            fillVideoInfo(feedModel);
            if (this.mOperateView != null) {
                this.mOperateView.setDaArea(Als.Area.DETAIL.value);
                View authorView = (View) this.mOperateView.findViewById(com.baidu.searchbox.video.template.R.id.tab_video_ad_author_container);
                if (authorView != null) {
                    authorView.setOnClickListener(this);
                }
                TextView authorName = (TextView) this.mOperateView.findViewById(com.baidu.searchbox.video.template.R.id.tab_video_author_text);
                if (authorName != null) {
                    authorName.setOnClickListener(this);
                }
                FontSizeTextViewExtKt.setScaledSizeRes(authorName, 0, R.dimen.dimens_12dp);
                if (!AbstractFeedTemplate.isNameIn((CharSequence) feedModel.layout, FeedTplNameCenter.AD_SEARCH_VIDEO)) {
                    if (!AbstractFeedTemplate.isNameIn((CharSequence) feedModel.layout, FeedTplNameCenter.AD_SEARCH_VIDEO_VERTICAL)) {
                        return;
                    }
                }
                TextView tag = (TextView) this.mOperateView.findViewById(com.baidu.searchbox.video.template.R.id.tab_video_ad_tag);
                if (tag != null) {
                    tag.setTextColor(getResources().getColor(R.color.DC157));
                    FontSizeTextViewExtKt.setScaledSizeRes(tag, 0, R.dimen.dimens_12dp);
                }
                NadLoftDownloadStateButton stateButton = (NadLoftDownloadStateButton) this.mOperateView.findViewById(com.baidu.searchbox.feed.template.R.id.tab_video_ad_operate_progress_button);
                if (stateButton != null) {
                    stateButton.setStateIconColorFilter(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                    stateButton.setCircleColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                    stateButton.setProgressColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                    stateButton.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                }
                SimpleAdInfoView appInfo = (SimpleAdInfoView) this.mOperateView.findViewById(com.baidu.searchbox.feed.template.R.id.simple_ad_info);
                if (appInfo != null) {
                    appInfo.onNightModeChanged(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
                }
                ImageView moreView = (ImageView) this.mOperateView.findViewById(R.id.tab_video_more_image);
                if (moreView != null) {
                    moreView.setColorFilter(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                    moreView.setImageDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.feed.core.R.drawable.feed_nad_loft_video_more_btn));
                }
                updateBottomDetailView();
                updateAuthorImage();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
    }

    public void applyFontSize() {
        if (this.mFeedTemplateImplBase != null) {
            this.mFeedTemplateImplBase.applyFontSize();
        }
        VideoFontUtilsKt.updateFontSize(this.mTitle, R.dimen.search_video_title_size);
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.feed.core.R.drawable.feed_item_bg_cu));
        if (FeedAdUtil.needAdaptSearchVideoDarkBg()) {
            this.mTitle.setTextColor(getResources().getColor(com.baidu.searchbox.search.style.res.R.color.SVC1));
        } else {
            this.mTitle.setTextColor(ContextCompat.getColor(getContext(), VideoCommonVideoViewUtilsKt.getTitleColorRes()));
        }
        this.mVideoLength.setTextColor(getResources().getColor(R.color.search_video_video_length_color));
        if (this.mOperateView != null) {
            TextView tag = (TextView) this.mOperateView.findViewById(com.baidu.searchbox.video.template.R.id.tab_video_ad_tag);
            if (tag != null) {
                tag.setTextColor(getResources().getColor(R.color.DC157));
                VideoCommonVideoViewUtilsKt.updateTextBoldWeight(tag, true);
            }
            TextView authorName = (TextView) this.mOperateView.findViewById(com.baidu.searchbox.video.template.R.id.tab_video_author_text);
            if (authorName != null) {
                if (FeedAdUtil.needAdaptSearchVideoDarkBg()) {
                    authorName.setTextColor(getResources().getColor(com.baidu.searchbox.search.style.res.R.color.SVC3));
                } else {
                    authorName.setTextColor(ContextCompat.getColor(getContext(), R.color.DC4));
                }
                VideoCommonVideoViewUtilsKt.updateTextBoldWeight(authorName, true);
            }
            updateBottomDetailView();
        }
        BdBaseImageView bdBaseImageView = this.mVideoPlayIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.search_video_slide_card_play));
        }
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThinDividerPolicy.getDefault();
    }

    public ViewGroup getAttachedContainer() {
        return this.mHolder;
    }

    public int getItemPosition() {
        if (getFeedModel() != null) {
            return getFeedModel().runtimeStatus.viewPosition;
        }
        return 0;
    }

    public int getOrderForClick() {
        return 0;
    }

    public void onBeginPlay() {
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoImage, false);
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoPlayIcon, false);
        VideoCommonVideoViewUtilsKt.animateShowOrHide(this.mVideoLength, false);
    }

    public void resetState() {
        VideoCommonVideoViewUtilsKt.clearAnimate(this.mVideoImage);
        this.mVideoImage.setAlpha(1.0f);
        this.mVideoPlayIcon.setAlpha(1.0f);
        this.mVideoLength.setAlpha(1.0f);
    }

    public HashMap<Integer, String> getVideoInfoMap() {
        return this.mVideoInfo;
    }

    public String getVideoInfo() {
        FeedBaseModel feedModel = getFeedModel();
        if (feedModel == null || !(feedModel.data instanceof FeedItemDataSearchAdVideo)) {
            return null;
        }
        FeedItemDataSearchAdVideo data = (FeedItemDataSearchAdVideo) feedModel.data;
        if (data.mVideoInfo == null) {
            return null;
        }
        return FeedItemDataTabVideo.VideoInfoEntity.toJson(data.mVideoInfo).toString();
    }

    public int business() {
        return 2;
    }

    public void onHideInfo() {
    }

    public void onUpdateProgress(int progress, int buffer, int max) {
    }

    public FeedBaseModel getModel() {
        return getFeedModel();
    }

    public void setListPlayerHelper(IListPlayerContext listPlayerContext) {
        this.mPlayerHelper = listPlayerContext;
    }

    public void onClick(View v) {
        boolean hasExtra;
        String realCmd;
        FeedBaseModel model = getFeedModel();
        if (model != null) {
            String tcAction = "pys_hotarea";
            String area = Als.Area.HOT_AREA.value;
            if (v.getId() == R.id.feed_template_base_title_id) {
                area = Als.Area.TITTLE.value;
                tcAction = "pys_title";
            } else if (v.getId() == com.baidu.searchbox.video.template.R.id.tab_video_ad_author_container) {
                area = Als.Area.ICON.value;
                tcAction = "pys_brand";
            } else if (v.getId() == com.baidu.searchbox.video.template.R.id.tab_video_author_text) {
                area = Als.Area.USERNAME.value;
                tcAction = "pys_brand";
            } else if (v.getId() == R.id.feed_img_region || v.getId() == R.id.feed_template_mute_video_layout) {
                area = Als.Area.PLAYER.value;
                tcAction = "pys_video";
            }
            if (isPlaying()) {
                AdDataReduceUtils.replacePlayCmd(model);
                realCmd = model.data.ad.feed.mPlayCmd;
                AdDataReduceUtils.replaceDeferredCmd(model);
                String cmd = FeedAdUtil.getDownloadByCmd(realCmd, model.data);
                if (!TextUtils.equals(cmd, realCmd)) {
                    realCmd = cmd;
                    hasExtra = false;
                } else {
                    hasExtra = true;
                }
            } else {
                AdDataReduceUtils.replaceDataLpCmdExt(model);
                realCmd = model.data.ad.feed.mLpCmd;
                hasExtra = true;
            }
            if (TextUtils.isEmpty(realCmd)) {
                AdDataReduceUtils.replaceDataCmdExt(model);
                realCmd = model.data.cmd.get();
            }
            FeedAdUtil.feedAdInvokeCommand(model, getContext(), realCmd);
            handleADClick(model, area);
            uploadClickTcLog(model, tcAction, hasExtra);
        } else if (AdRuntimeHolder.DEBUG) {
            Log.e(TAG, "Invalid search feed model");
        }
    }

    public void updateExtLog(JSONObject extLog) {
        if (this.mFeedTemplateImplBase != null && this.mFeedTemplateImplBase.mFeedModel != null && (this.mFeedTemplateImplBase.mFeedModel.data instanceof FeedItemDataSearchAdVideo)) {
            FeedItemDataSearchAdVideo itemData = (FeedItemDataSearchAdVideo) this.mFeedTemplateImplBase.mFeedModel.data;
            if (!TextUtils.isEmpty(itemData.videoInfoStr)) {
                try {
                    JSONObject videoInfoObj = new JSONObject(itemData.videoInfoStr);
                    videoInfoObj.put("ext_log", extLog);
                    itemData.videoInfoStr = videoInfoObj.toString();
                    this.mFeedTemplateImplBase.mFeedModel.data = itemData;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean fillVideoInfo(FeedBaseModel feedModel) {
        if (feedModel == null || !(feedModel.data instanceof FeedItemDataSearchAdVideo)) {
            return false;
        }
        FeedItemDataSearchAdVideo data = (FeedItemDataSearchAdVideo) feedModel.data;
        if (data.mVideoInfo == null) {
            return false;
        }
        FeedItemDataTabVideo.VideoInfoEntity videoInfoEntity = data.mVideoInfo;
        try {
            this.mVideoInfo.put(106, "false");
            this.mVideoInfo.put(110, "true");
            this.mVideoInfo.put(0, "");
            this.mVideoInfo.put(1, videoInfoEntity.mTitle);
            this.mVideoInfo.put(108, videoInfoEntity.mExt);
            this.mVideoInfo.put(5, videoInfoEntity.mPageUrl);
            this.mVideoInfo.put(107, videoInfoEntity.mPosterImage);
            this.mVideoInfo.put(112, videoInfoEntity.mDuration + "");
            this.mVideoInfo.put(113, videoInfoEntity.mVid);
            JSONObject extLog = new JSONObject(videoInfoEntity.mExtLog);
            extLog.put(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_PAGE, videoInfoEntity.mPage);
            if (!(feedModel.data.ad == null || feedModel.data.ad.ext == null)) {
                JSONObject extParam = new JSONObject();
                extParam.put("extraParams", feedModel.data.ad.ext.extraParams);
                extLog.put("ad_extra_param", extParam);
            }
            this.mVideoInfo.put(111, extLog.toString());
            this.mVideoInfo.put(301, "search");
            if (!TextUtils.isEmpty(videoInfoEntity.mMPD)) {
                this.mVideoInfo.put(350, videoInfoEntity.mMPD);
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isSupportAutoPlay() {
        Rect childRect = new Rect();
        boolean isInParent = this.mVideoImage.getGlobalVisibleRect(childRect);
        float visibleAreaRatio = ((float) (childRect.bottom - childRect.top)) / ((float) this.mVideoImage.getMeasuredHeight());
        if (!isInParent || childRect.bottom <= 0 || visibleAreaRatio < 1.0f) {
            return false;
        }
        return true;
    }

    public float getAutoPlayWeight() {
        Rect childRect = new Rect();
        boolean isInParent = this.mVideoImage.getGlobalVisibleRect(childRect);
        float visibleAreaRatio = ((float) (childRect.bottom - childRect.top)) / ((float) this.mVideoImage.getMeasuredHeight());
        if (!isInParent || childRect.bottom <= 0) {
            return 0.0f;
        }
        return visibleAreaRatio;
    }

    public void handleADClick(FeedBaseModel model, String area) {
        if (NetWorkUtils.isNetworkConnected() && FeedFilter.checkAdFeed(model)) {
            Als.Builder builder = new Als.Builder();
            builder.setTabId(model.runtimeStatus.channelId);
            builder.setPage(Als.Page.VIDEO_SEARCH_TAB);
            builder.setType(Als.LogType.CLICK);
            builder.setArea(area);
            builder.setSboxExtraParam(model.data.ad.ext);
            Als.postADRealTimeLog(builder);
            if (model.data.ad.feed != null) {
                ADRequester.adThirdPartyMonitor(model.data.ad.feed.mExtData, Als.ADActionType.CLICK);
            }
            ParallelCharge.chargeMain(model.data.ad.feed);
        }
    }

    private void uploadClickTcLog(FeedBaseModel feedBaseModel, String action, boolean withExtra) {
        int playPosition;
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataSearchAdVideo)) {
            FeedItemDataSearchAdVideo itemData = (FeedItemDataSearchAdVideo) feedBaseModel.data;
            if (itemData.mVideoInfo != null) {
                try {
                    IListPlayerContext iListPlayerContext = this.mPlayerHelper;
                    if (iListPlayerContext != null) {
                        playPosition = Integer.parseInt(iListPlayerContext.getCurrentVideoPlayDuration(itemData.mVideoInfo.mVid));
                    } else {
                        playPosition = 0;
                    }
                    FeedAdLogUtil.uploadClickTcLog(itemData.mVideoInfo, action, feedBaseModel.runtimeStatus.viewPosition, playPosition, withExtra);
                } catch (NumberFormatException e2) {
                }
            }
        }
    }

    public boolean isPlaying() {
        BaseVideoPlayer player;
        IListPlayerContext iListPlayerContext = this.mPlayerHelper;
        if ((iListPlayerContext instanceof ListPlayerHelper) && (player = iListPlayerContext.getPlayer(business())) != null && player.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean allowC2BResumePlay() {
        return true;
    }

    public GestureListener createGestureListener() {
        return null;
    }

    public int getVideoScalingMode() {
        return 0;
    }

    public HashMap<Integer, Integer> getKernelWH() {
        return null;
    }

    public List<Double> getNodeList() {
        return null;
    }

    public ViewGroup getSeekBarContainer() {
        return null;
    }

    public boolean isEnableDragSeek() {
        return false;
    }

    public void onExpandSummary() {
    }

    public PlayerLayerConfig getPlayerLayerConfig() {
        return new PlayerLayerConfig(false);
    }

    public VideoCommonBigImageModel.KeyFrameInfo getFrameInfo() {
        return null;
    }

    public VideoCommonBigImageModel.FrameSprites getFrameSprites() {
        return null;
    }

    public IListPlayerContext getPlayHelper() {
        return null;
    }

    private void updateBottomDetailView() {
        TextView detailView = (TextView) this.mOperateView.findViewById(com.baidu.searchbox.feed.template.R.id.tab_video_button);
        if (detailView != null) {
            detailView.setTextColor(getResources().getColor(R.color.DC4));
            VideoCommonVideoViewUtilsKt.updateTextBoldWeight(detailView, true);
            detailView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.search_video_ad_btn_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void updateAuthorImage() {
        View authorImg = (View) this.mOperateView.findViewById(com.baidu.searchbox.feed.template.R.id.tab_video_author_image);
        if (authorImg != null) {
            VideoFontUtilsKt.updateViewScaledSize(authorImg, getContext().getResources().getDimension(R.dimen.dimens_24dp), getContext().getResources().getDimension(R.dimen.dimens_24dp), 2);
        }
    }
}
