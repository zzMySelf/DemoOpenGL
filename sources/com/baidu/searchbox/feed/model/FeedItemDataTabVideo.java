package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.model.AdFeedTailFrameInfo;
import com.baidu.searchbox.feed.base.AbstractFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.parser.ValidationResult;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.video.banner.VideoBannerFactory;
import com.baidu.searchbox.feed.video.banner.VideoBannerManifest;
import com.baidu.searchbox.feed.video.banner.model.VideoGoodsBannerModel;
import com.baidu.searchbox.feed.video.banner.model.VideoLinkBannerModel;
import com.baidu.searchbox.player.model.VideoMeta;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.videoplayer.util.VideoInfoProtocolKt;
import com.baidu.share.core.BdShareConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedItemDataTabVideo extends FeedItemDataNews {
    public static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    public static final String ICON_COMMENT = "comment";
    public static final String ICON_DISLIKE = "dislike";
    public static final String ICON_DOWNLOAD = "download";
    public static final String ICON_FAVOR = "favourite";
    public static final String ICON_FOLLOW = "follow";
    public static final String ICON_REPORT = "report";
    public static final String ICON_SHARE = "share";
    public static final String ICON_SPLIT = "split";
    public static final String ICON_VOTE_DOWN = "degrade";
    public static final String ICON_VOTE_UP = "like";
    public static final int SHOW_ICON = 1;
    public static final int SHOW_NUM = 4;
    public static final int SHOW_TITLE = 2;
    public boolean disableVideoAfter;
    public String extRequest;
    public String liveScreenStyle;
    public String mAuthor;
    public String mAuthorCmd;
    public String mAuthorDesc;
    public String mAuthorIcon;
    public String mAuthorId;
    public String mAuthorIntro;
    public int mAuthorLevel;
    public List<BarEntity> mBarSortList;
    public String mCmdDiff;
    public int mCollAuthorType;
    public String mComment;
    public String mContinuePlay;
    public String mDownloadCmd;
    public JSONObject mDownloadListBannerModel;
    public GapLessPlayInfo mGapLessPlayInfo;
    public boolean mHasAuthorLiveDisplayed;
    public String mIconBarStyle;
    public String mIsAuthorOnLive;
    public boolean mIsAutoPlay = false;
    public int mIsOriginalAuthor;
    public boolean mIsPaidVideo;
    public boolean mIsRecommend = false;
    public boolean mIsRecommended = false;
    public String mLabelCmd;
    public String mLiveCmd;
    public boolean mNeedAnim = false;
    public String mOriginalVideoInfo;
    public String mPkgName;
    public String mPlayIconText;
    public String mPlayNum;
    public FeedItemData.PrefixRichTitle mPrefixRichTitle;
    public String mRecType;
    public String mSearchId;
    public List<String> mShareChannelList;
    public String mTags;
    public String mVType;
    public int mVideoAfterReqTime;
    public String mVideoCollectionNum;
    public VideoGoodsBannerModel mVideoGoodsBannerModel;
    public VideoInfoEntity mVideoInfo;
    public VideoLinkBannerModel mVideoLinkBannerModel;
    public String mVideoUrl;
    public VoteInfo mVoteInfo;
    public PaymentInfo paymentInfo;

    public static class GapLessPlayInfo {
        public String mCurrentEndTime;
        public boolean mHasNextClip;
        public String mNextStartTime;
    }

    public FeedItemDataTabVideo() {
    }

    public FeedItemDataTabVideo(JSONObject dataJson) {
        parseJson(dataJson);
    }

    public JSONObject toJson() {
        JSONArray jsonArray;
        JSONObject object = super.parse2Json();
        try {
            object.put("title", this.title);
            object.put("duration", this.duration);
            object.put("video", this.mVideoUrl);
            object.put("cmd", this.mLabelCmd);
            object.put("playcntText", this.mPlayNum);
            object.put("author", this.mAuthor);
            object.put("authorIcon", this.mAuthorIcon);
            object.put("authorLevel", this.mAuthorLevel);
            object.put("authorCmd", this.mAuthorCmd);
            object.put("continuePlay", this.mContinuePlay);
            object.put("isOriginal", this.mIsOriginalAuthor);
            object.put("collVideoNum", this.mVideoCollectionNum);
            object.put("collAuthorType", this.mCollAuthorType);
            object.put("iconBarStyle", this.mIconBarStyle);
            object.put("cmdDiff", this.mCmdDiff);
            object.put("authorDesc", this.mAuthorDesc);
            object.put("comment", this.mComment);
            if (this.images != null && this.images.size() > 0) {
                object.put("image", ((FeedItemDataNews.Image) this.images.get(0)).image);
            }
            List<BarEntity> list = this.mBarSortList;
            if (!(list == null || list.size() <= 0 || (jsonArray = BarEntity.toJsonArray(this.mBarSortList)) == null)) {
                object.put("iconBarSort", jsonArray);
            }
            if (this.feedBar != null) {
                object.put("iconBar", FeedBar.toJson(this.feedBar));
            }
            VideoInfoEntity videoInfoEntity = this.mVideoInfo;
            if (videoInfoEntity != null) {
                object.put("videoInfo", VideoInfoEntity.toJson(videoInfoEntity));
            }
            object.put("searchID", this.mSearchId);
            object.put(VideoMeta.VTYPE, this.mVType);
            object.put(FeedProtocolEntity.FEED_REC_TYPE, this.mRecType);
            object.put("tags", this.mTags);
            object.put("authorID", this.mAuthorId);
            if (this.mShareChannelList != null) {
                JSONArray shareArray = new JSONArray();
                for (String shareChannel : this.mShareChannelList) {
                    JSONObject shareChannelItem = new JSONObject();
                    shareChannelItem.put("channel", shareChannel);
                    shareArray.put(shareChannelItem);
                }
                object.put("share_direct", shareArray);
            }
            object.put("diversionBannerLinkInfo", this.mVideoLinkBannerModel);
            String str = this.mPlayIconText;
            if (str != null) {
                object.put("play_icon_txt", str);
            }
            String str2 = this.mDownloadCmd;
            if (str2 != null) {
                object.put("download_cmd", str2);
            }
            String str3 = this.mPkgName;
            if (str3 != null) {
                object.put("pkg_name", str3);
            }
            object.put("videoAfterReqTime", this.mVideoAfterReqTime);
            object.put("isOnlive", this.mIsAuthorOnLive);
            object.put("liveRoomCmd", this.mLiveCmd);
            object.put(SapiWebView.PARAMS_SCREEN_TYPE, this.liveScreenStyle);
            PaymentInfo paymentInfo2 = this.paymentInfo;
            if (paymentInfo2 != null) {
                object.put("psvAlbumInfo", paymentInfo2.toJson());
            }
            object.put("isPaidVideo", this.mIsPaidVideo ? "1" : "0");
            object.putOpt("disableVideoAfter", Boolean.valueOf(this.disableVideoAfter));
            object.putOpt(IntentData.Protocol.KEY_EXT_REQUEST, this.extRequest);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return object;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        parseJson(jsonObject);
        return this;
    }

    public boolean isFollowed() {
        if (this.feedBar == null || this.feedBar.follow == null) {
            return false;
        }
        return TextUtils.equals(this.feedBar.follow.isFollow, "1");
    }

    public ArrayList<String> collectImageUrls() {
        if (this.mFeedImageList != null && this.mFeedImageList.size() <= 0) {
            super.collectImageUrls();
            if (!TextUtils.isEmpty(this.mAuthorIcon)) {
                this.mFeedImageList.add(this.mAuthorIcon);
            }
        }
        return this.mFeedImageList;
    }

    /* access modifiers changed from: protected */
    public void parseJson(JSONObject jsonObject) {
        List<BarEntity> list;
        if (jsonObject != null) {
            super.parse2Model(jsonObject, this);
            this.title = jsonObject.optString("title");
            this.duration = jsonObject.optString("duration");
            this.mVideoUrl = jsonObject.optString("video");
            this.mLabelCmd = jsonObject.optString("cmd");
            this.mPlayNum = jsonObject.optString("playcntText");
            this.mAuthor = jsonObject.optString("author");
            this.mAuthorIcon = jsonObject.optString("authorIcon");
            this.mAuthorLevel = jsonObject.optInt("authorLevel");
            this.mAuthorCmd = jsonObject.optString("authorCmd");
            this.mContinuePlay = jsonObject.optString("continuePlay");
            this.mIconBarStyle = jsonObject.optString("iconBarStyle");
            this.mCmdDiff = jsonObject.optString("cmdDiff");
            this.mComment = jsonObject.optString("comment");
            this.mAuthorIntro = jsonObject.optString("authorIntro");
            this.mAuthorDesc = jsonObject.optString("authorDesc");
            this.images = new ArrayList();
            if (jsonObject.has("image")) {
                FeedItemDataNews.Image image = new FeedItemDataNews.Image();
                image.image = jsonObject.optString("image");
                this.images.add(image);
            }
            this.mBarSortList = BarEntity.fromJsonArray(jsonObject.optJSONArray("iconBarSort"));
            this.feedBar = FeedBar.fromJson(jsonObject.optJSONObject("iconBar"));
            if (this.feedBar == null && ((list = this.mBarSortList) == null || list.size() < 1)) {
                if (jsonObject.has("comment_num") && jsonObject.has("comment_cmd")) {
                    BarEntity be = new BarEntity();
                    be.mItem = "comment";
                    be.mShow = 5;
                    be.mTitle = "评论";
                    if (this.mBarSortList == null) {
                        this.mBarSortList = new ArrayList();
                    }
                    this.mBarSortList.add(be);
                    if (this.feedBar == null) {
                        this.feedBar = new FeedBar();
                    }
                    this.feedBar.comment = FeedBar.addOldComment(jsonObject.optString("comment_num"), jsonObject.optString("comment_cmd"));
                }
                if (jsonObject.has(BdShareConstants.KEY_URL)) {
                    BarEntity be2 = new BarEntity();
                    be2.mItem = "share";
                    be2.mShow = 1;
                    be2.mTitle = "分享";
                    if (this.mBarSortList == null) {
                        this.mBarSortList = new ArrayList();
                    }
                    this.mBarSortList.add(be2);
                    if (this.feedBar == null) {
                        this.feedBar = new FeedBar();
                    }
                    this.feedBar.share = FeedBar.addOldShare(jsonObject.optString(BdShareConstants.KEY_URL), this.title, "");
                }
                if (this.mBarSortList.size() > 0) {
                    BarEntity be3 = new BarEntity();
                    be3.mItem = "split";
                    be3.mShow = 0;
                    be3.mTitle = "分隔";
                    if (this.mBarSortList == null) {
                        this.mBarSortList = new ArrayList();
                    }
                    this.mBarSortList.add(be3);
                }
            }
            this.mOriginalVideoInfo = jsonObject.optString("videoInfo");
            this.mVideoInfo = VideoInfoEntity.fromJson(jsonObject.optJSONObject("videoInfo"));
            this.mVoteInfo = VoteInfo.fromJson(jsonObject.optJSONObject("voteInfo"));
            JSONObject bannerLinkInfo = jsonObject.optJSONObject("diversionBannerLinkInfo");
            if (bannerLinkInfo == null) {
                this.mVideoLinkBannerModel = null;
            } else if (VideoLinkBannerModel.tryReportCheckRequiredField(bannerLinkInfo)) {
                this.mVideoLinkBannerModel = null;
            } else {
                this.mVideoLinkBannerModel = (VideoLinkBannerModel) VideoBannerFactory.INSTANCE.createBannerModel(VideoBannerManifest.BANNER_TPL_NAME_LINK, bannerLinkInfo);
            }
            JSONObject goodsInfo = jsonObject.optJSONObject("goods");
            if (goodsInfo != null) {
                this.mVideoGoodsBannerModel = (VideoGoodsBannerModel) VideoBannerFactory.INSTANCE.createBannerModel(VideoBannerManifest.BANNER_TPL_NAME_GOODS, goodsInfo);
            } else {
                this.mVideoGoodsBannerModel = null;
            }
            JSONObject prefixRichTitle = jsonObject.optJSONObject(FeedPolyHScrollModelKt.KEY_LIVE_STATUS_BUBBLE);
            if (prefixRichTitle != null) {
                this.mPrefixRichTitle = FeedItemData.PrefixRichTitle.fromJson(prefixRichTitle);
            }
            this.mSearchId = jsonObject.optString("searchID");
            this.mVType = jsonObject.optString(VideoMeta.VTYPE);
            this.mRecType = jsonObject.optString(FeedProtocolEntity.FEED_REC_TYPE);
            this.mTags = jsonObject.optString("tags");
            this.mAuthorId = jsonObject.optString("authorID");
            this.mIsOriginalAuthor = jsonObject.optInt("isOriginal");
            this.mVideoCollectionNum = jsonObject.optString("collVideoNum");
            this.mCollAuthorType = jsonObject.optInt("collAuthorType", 1);
            JSONArray shareChannelList = jsonObject.optJSONArray("share_direct");
            if (shareChannelList != null && shareChannelList.length() > 0) {
                this.mShareChannelList = new ArrayList();
                for (int i2 = 0; i2 < shareChannelList.length(); i2++) {
                    JSONObject shareItem = shareChannelList.optJSONObject(i2);
                    if (shareItem != null) {
                        String optString = shareItem.optString("channel");
                        String channelTemp = optString;
                        if (!TextUtils.isEmpty(optString)) {
                            this.mShareChannelList.add(channelTemp);
                        }
                    }
                }
            }
            if (jsonObject.has("play_icon_txt")) {
                this.mPlayIconText = jsonObject.optString("play_icon_txt");
            }
            if (jsonObject.has("download_cmd")) {
                this.mDownloadCmd = jsonObject.optString("download_cmd");
            }
            if (jsonObject.has("pkg_name")) {
                this.mPkgName = jsonObject.optString("pkg_name");
            }
            this.mVideoAfterReqTime = jsonObject.optInt("videoAfterReqTime");
            this.mIsAuthorOnLive = jsonObject.optString("isOnlive");
            this.mLiveCmd = jsonObject.optString("liveRoomCmd");
            this.mDownloadListBannerModel = jsonObject.optJSONObject("downloadListBannerInfo");
            JSONObject nextVideoClip = jsonObject.optJSONObject("nextVideoClip");
            if (nextVideoClip != null) {
                GapLessPlayInfo gapLessPlayInfo = new GapLessPlayInfo();
                this.mGapLessPlayInfo = gapLessPlayInfo;
                gapLessPlayInfo.mHasNextClip = TextUtils.equals("1", nextVideoClip.optString("hasNextClip"));
                this.mGapLessPlayInfo.mCurrentEndTime = nextVideoClip.optString("currEndTime");
                this.mGapLessPlayInfo.mNextStartTime = nextVideoClip.optString("nextStartTime");
            }
            this.mIsPaidVideo = "1".equals(jsonObject.optString("isPaidVideo"));
            this.liveScreenStyle = jsonObject.optString(SapiWebView.PARAMS_SCREEN_TYPE, "1");
            PaymentInfo fromJson = PaymentInfo.fromJson(jsonObject.optJSONObject("psvAlbumInfo"));
            this.paymentInfo = fromJson;
            fromJson.isAuthro = jsonObject.optString("isAuthro");
            this.disableVideoAfter = jsonObject.optBoolean("disableVideoAfter");
            this.extRequest = jsonObject.optString(IntentData.Protocol.KEY_EXT_REQUEST);
        }
    }

    public void setPrefetchVideo(JSONArray prefetchVideo) {
        this.mPrefetchVideo = prefetchVideo;
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        if (AbstractFeedTemplate.isNameIn((CharSequence) context.layout, "tabvideo", FeedTplNameCenter.VIDEO_COLLECTION, "tabvideo_diversion_video", "tabvideo_diversion_image", "tabvideo_live_autoplay", FeedTplNameCenter.VIDEO_TAB_PAYMENT, "tabvideo_interactive", "video_tab_video")) {
            if (TextUtils.isEmpty(this.title)) {
                return ValidationResult.ERROR_MISSING_TITLE;
            }
            if (this.images == null || this.images.size() == 0) {
                return ValidationResult.ERROR_MISSING_IMAGE;
            }
            if (AbstractFeedTemplate.isNameIn((CharSequence) context.layout, "tabvideo_diversion_image")) {
                return ValidationResult.ok();
            }
            if (TextUtils.isEmpty(this.mVideoUrl)) {
                return ValidationResult.ERROR_MISSING_URL;
            }
            if (AbstractFeedTemplate.isNameIn((CharSequence) context.layout, "tabvideo_diversion_video")) {
                return ValidationResult.ok();
            }
            List<BarEntity> list = this.mBarSortList;
            if (list == null || list.size() == 0) {
                return ValidationResult.ERROR_MISSING_BAR;
            }
            if (this.feedBar == null) {
                return ValidationResult.ERROR_MISSING_FEED_BAR;
            }
            return ValidationResult.ok();
        } else if (this.ad.operate == null) {
            return ValidationResult.ERROR_MISSING_OPERATE;
        } else {
            boolean isAdChnVideo = AbstractFeedTemplate.isNameIn((CharSequence) context.layout, "ad_channel_video", FeedTplNameCenter.AD_CHN_VERTIACL_VIDEO, "ad_channel_video_new", "ad_channel_vertical_video_new");
            boolean isAdChnImg = AbstractFeedTemplate.isNameIn((CharSequence) context.layout, FeedTplNameCenter.AD_CHN_IMG, FeedTplNameCenter.AD_CHN_IMG_NEW);
            if (AbstractFeedTemplate.isNameIn((CharSequence) context.layout, FeedTplNameCenter.VIDEO_HAOKAN)) {
                return ValidationResult.ok();
            }
            if (isAdChnVideo || isAdChnImg) {
                if (this.ad.operate.isDownload()) {
                    return checkVideoAdDownloadFeed(isAdChnVideo);
                }
                if (this.ad.operate.isCommand()) {
                    return checkVideoAdCommandFeed(isAdChnVideo);
                }
            }
            return ValidationResult.ERROR_NOT_MATCH_TYPE;
        }
    }

    /* access modifiers changed from: protected */
    public ValidationResult checkVideoAdCommandFeed(boolean isAdChnVideo) {
        if (TextUtils.isEmpty(this.title)) {
            return ValidationResult.ERROR_MISSING_TITLE;
        }
        if (this.images == null || this.images.size() == 0) {
            return ValidationResult.ERROR_MISSING_IMAGE;
        }
        if (this.images.get(0) == null || TextUtils.isEmpty(((FeedItemDataNews.Image) this.images.get(0)).image)) {
            return ValidationResult.ERROR_MISSING_IMAGE;
        }
        if (isAdChnVideo && TextUtils.isEmpty(this.mVideoUrl)) {
            return ValidationResult.ERROR_MISSING_URL;
        }
        List<BarEntity> list = this.mBarSortList;
        if (list == null || list.size() == 0) {
            return ValidationResult.ERROR_MISSING_BAR;
        }
        return ValidationResult.ok();
    }

    /* access modifiers changed from: protected */
    public ValidationResult checkVideoAdDownloadFeed(boolean isAdChnVideo) {
        if (TextUtils.isEmpty(this.title)) {
            return ValidationResult.ERROR_MISSING_TITLE;
        }
        if (this.images == null || this.images.size() == 0) {
            return ValidationResult.ERROR_MISSING_IMAGE;
        }
        if (this.images.get(0) == null || TextUtils.isEmpty(((FeedItemDataNews.Image) this.images.get(0)).image)) {
            return ValidationResult.ERROR_MISSING_IMAGE;
        }
        if (isAdChnVideo && TextUtils.isEmpty(this.mVideoUrl)) {
            return ValidationResult.ERROR_MISSING_URL;
        }
        List<BarEntity> list = this.mBarSortList;
        if (list == null || list.size() == 0) {
            return ValidationResult.ERROR_MISSING_BAR;
        }
        if (this.ad.feed == null || this.ad.feed.mExtData == null) {
            return ValidationResult.ERROR_MISSING_EXTRA;
        }
        if (this.ad.feed.mExtData.adDownload == null) {
            return ValidationResult.ERROR_MISSING_EXTRA_DOWNLOAD;
        }
        if (TextUtils.isEmpty(this.title)) {
            return ValidationResult.ERROR_MISSING_TITLE;
        }
        if (!this.ad.feed.mExtData.adDownload.isPackageNameValid()) {
            return ValidationResult.ERROR_MISSING_EXTRA_DOWNLOAD_PACKAGE;
        }
        if (TextUtils.isEmpty(this.ad.feed.mExtData.adDownload.downloadUrl)) {
            return ValidationResult.ERROR_MISSING_EXTRA_DOWNLOAD_URL;
        }
        if (this.ad.feed.appInfo == null || AdUtil.isAppDataValid(this.ad.feed.appInfo)) {
            return ValidationResult.ok();
        }
        return ValidationResult.ERROR_INVALID_AD_APP_INFO;
    }

    public static class BarEntity {
        public String mItem = "";
        public int mShow = 0;
        public String mTitle = "";

        /* access modifiers changed from: private */
        public static List<BarEntity> fromJsonArray(JSONArray array) {
            BarEntity currentItem;
            List<BarEntity> items = new ArrayList<>();
            if (array == null || array.length() == 0) {
                return items;
            }
            int count = array.length();
            for (int i2 = 0; i2 < count; i2++) {
                JSONObject obj = array.optJSONObject(i2);
                if (!(obj == null || (currentItem = fromJson(obj)) == null)) {
                    items.add(currentItem);
                }
            }
            return items;
        }

        private static BarEntity fromJson(JSONObject obj) {
            if (obj == null) {
                return null;
            }
            BarEntity item = new BarEntity();
            item.mItem = obj.optString("item");
            item.mShow = obj.optInt("show");
            item.mTitle = obj.optString("title");
            return item;
        }

        /* access modifiers changed from: private */
        public static JSONArray toJsonArray(List<BarEntity> tags) {
            if (tags == null || tags.size() == 0) {
                return null;
            }
            JSONArray jsonArray = new JSONArray();
            for (BarEntity item : tags) {
                JSONObject json = toJson(item);
                if (json != null) {
                    jsonArray.put(json);
                }
            }
            return jsonArray;
        }

        private static JSONObject toJson(BarEntity item) {
            if (item == null) {
                return null;
            }
            JSONObject json = new JSONObject();
            try {
                json.put("item", item.mItem);
                json.put("show", item.mShow);
                json.put("title", item.mTitle);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json;
        }
    }

    public static class VideoInfoEntity {
        public AdFeedTailFrameInfo adTailFrame;
        public boolean hasGuide;
        public int index = 0;
        public boolean mAutoSize;
        public String mBannerButtonText;
        public String mBannerIcon;
        public BarrageInfoEntity mBarrage;
        public int mDuration;
        public String mEnableRatePlay;
        public String mExt;
        public String mExtLog;
        public String mFormat;
        public String mFrom;
        public int mFullScreen;
        public String mHotComments;
        public boolean mLoopingVideo;
        public String mMPD;
        public String mMPDUrl;
        public String mMPDVid;
        public String mPage;
        public String mPageUrl;
        public String mPlayConf;
        public PlayerAnimation mPlayerAnimation;
        public String mPosterImage;
        public boolean mReplayVideo;
        public String mResourceType;
        public String mSeekPosition;
        public String mTitle;
        public String mVid;
        public int urlExpireTs;
        public String videoTime;
        public float visibleScale = 1.0f;
        public float whRatio = 1.0f;

        public static VideoInfoEntity fromJson(JSONObject obj) {
            if (obj == null) {
                return null;
            }
            VideoInfoEntity item = new VideoInfoEntity();
            item.mPosterImage = obj.optString("posterImage");
            item.mTitle = obj.optString("title");
            item.mVid = obj.optString("vid");
            item.mDuration = obj.optInt("duration");
            item.videoTime = obj.optString("videoTime");
            item.mExt = obj.optString("ext");
            item.mPageUrl = obj.optString("pageUrl");
            item.mFullScreen = obj.optInt("full_screen");
            item.mFrom = obj.optString("from");
            item.mPage = obj.optString("page");
            item.mExtLog = obj.optString("ext_log");
            item.mEnableRatePlay = obj.optString("enableRatePlay");
            BarrageInfoEntity barrage = new BarrageInfoEntity();
            JSONObject barrageInfo = obj.optJSONObject("barrage");
            if (barrageInfo != null) {
                barrage.mNid = barrageInfo.optString("nid");
                barrage.mTopicId = barrageInfo.optString("topicId");
            }
            item.mBarrage = barrage;
            JSONArray comments = obj.optJSONArray("hotComments");
            if (comments != null) {
                item.mHotComments = comments.toString();
            }
            JSONObject playerAnimation = obj.optJSONObject("playerAnimation");
            if (FeedItemDataTabVideo.DEBUG) {
                BdVideoLog.d("VideoLogo", "FeedItemDataTabVideo json: " + playerAnimation);
            }
            item.mPlayerAnimation = PlayerAnimation.fromJson(playerAnimation);
            item.mBannerIcon = obj.optString("bannerIcon");
            item.mBannerButtonText = obj.optString("bannerButtonText");
            item.mAutoSize = obj.optBoolean("autoSize");
            boolean z = false;
            item.mLoopingVideo = obj.optInt("loopingVideo") == 1;
            if (obj.optInt("restartVideo") == 1) {
                z = true;
            }
            item.mReplayVideo = z;
            item.mPlayConf = obj.optString("play_conf");
            item.mMPD = obj.optString("mpd");
            item.mMPDUrl = obj.optString("mpd_url");
            item.mMPDVid = obj.optString("mpd_vid");
            item.urlExpireTs = obj.optInt(VideoInfoProtocolKt.URL_EXPIRE_TS);
            item.mResourceType = obj.optString("resourceType");
            item.mFormat = obj.optString("format");
            item.adTailFrame = AdFeedTailFrameInfo.fromJson(obj);
            return item;
        }

        public static JSONObject toJson(VideoInfoEntity item) {
            if (item == null) {
                return null;
            }
            JSONObject json = new JSONObject();
            try {
                json.put("posterImage", item.mPosterImage);
                json.put("title", item.mTitle);
                json.put("vid", item.mVid);
                json.put("duration", item.mDuration);
                json.put("ext", item.mExt);
                json.put("pageUrl", item.mPageUrl);
                json.put("full_screen", item.mFullScreen);
                json.put("enableRatePlay", item.mEnableRatePlay);
                json.put("from", item.mFrom);
                json.put("page", item.mPage);
                json.put("ext_log", item.mExtLog);
                json.put("barrage", BarrageInfoEntity.toJson(item.mBarrage));
                json.put("bannerIcon", item.mBannerIcon);
                json.put("bannerButtonText", item.mBannerButtonText);
                json.put("autoSize", item.mAutoSize);
                PlayerAnimation playerAnimation = item.mPlayerAnimation;
                if (playerAnimation != null) {
                    json.put("playerAnimation", PlayerAnimation.toJson(playerAnimation));
                }
                if (!TextUtils.isEmpty(item.mHotComments)) {
                    try {
                        json.put("mHotComments", new JSONArray(item.mHotComments));
                    } catch (Exception e2) {
                        if (FeedItemDataTabVideo.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                int i2 = 1;
                json.put("loopingVideo", item.mLoopingVideo ? 1 : 0);
                if (!item.mReplayVideo) {
                    i2 = 0;
                }
                json.put("restartVideo", i2);
                json.put("play_conf", item.mPlayConf);
                json.put("mpd", item.mMPD);
                json.put("mpd_url", item.mMPDUrl);
                json.put("mpd_vid", item.mMPDVid);
                json.put(VideoInfoProtocolKt.URL_EXPIRE_TS, item.urlExpireTs);
                json.put("format", item.mFormat);
                json.put("resourceType", item.mResourceType);
                AdFeedTailFrameInfo adFeedTailFrameInfo = item.adTailFrame;
                if (adFeedTailFrameInfo != null) {
                    json.put(AdFeedTailFrameInfo.KEY_TAIL_FRAME, AdFeedTailFrameInfo.toJson(adFeedTailFrameInfo));
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return json;
        }

        public String getPreview6sUrl() {
            if (TextUtils.isEmpty(this.mExt)) {
                return "";
            }
            try {
                return new JSONObject(this.mExt).optString("preview_6s_url");
            } catch (JSONException ex) {
                if (!FeedItemDataTabVideo.DEBUG) {
                    return "";
                }
                ex.printStackTrace();
                return "";
            }
        }

        public String getClarityUrl() {
            if (TextUtils.isEmpty(this.mExt)) {
                return "";
            }
            try {
                return getVideoUrlFromClarity(new JSONObject(this.mExt).getJSONArray("clarityUrl"));
            } catch (JSONException ex) {
                if (!FeedItemDataTabVideo.DEBUG) {
                    return "";
                }
                ex.printStackTrace();
                return "";
            }
        }

        private String getVideoUrlFromClarity(JSONArray clarity) {
            if (clarity == null) {
                return "";
            }
            int i2 = 0;
            while (i2 < clarity.length()) {
                try {
                    JSONObject clarityObj = clarity.getJSONObject(i2);
                    if (clarityObj.getInt("rank") == 0) {
                        return clarityObj.getString("url");
                    }
                    i2++;
                } catch (JSONException e2) {
                    if (FeedItemDataTabVideo.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            return "";
        }

        public boolean clarityUrlValid(String url) {
            if (!TextUtils.isEmpty(this.mExt)) {
                try {
                    JSONArray clarity = new JSONObject(this.mExt).optJSONArray("clarityUrl");
                    if (clarity == null) {
                        return false;
                    }
                    for (int i2 = 0; i2 < clarity.length(); i2++) {
                        JSONObject clarityObj = clarity.getJSONObject(i2);
                        if (clarityObj != null) {
                            if (TextUtils.equals(url, clarityObj.getString("url"))) {
                                return true;
                            }
                        }
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        }
    }

    public static class BarrageInfoEntity {
        public String mNid;
        public String mTopicId;

        public static BarrageInfoEntity fromJson(JSONObject obj) {
            if (obj == null) {
                return null;
            }
            BarrageInfoEntity item = new BarrageInfoEntity();
            item.mNid = obj.optString("nid");
            item.mTopicId = obj.optString("topicId");
            return item;
        }

        public static JSONObject toJson(BarrageInfoEntity item) {
            if (item == null) {
                return null;
            }
            JSONObject json = new JSONObject();
            try {
                json.put("nid", item.mNid);
                json.put("topicId", item.mTopicId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json;
        }
    }

    public static final class PlayerAnimation {
        public String mDownloadScheme;
        @Deprecated
        public String mDownloadToast;
        public boolean mEnable;
        public String mJumpScheme;

        public static PlayerAnimation fromJson(JSONObject obj) {
            if (obj == null) {
                return null;
            }
            PlayerAnimation item = new PlayerAnimation();
            item.mEnable = "1".equals(obj.optString("playerAnimationFlag"));
            item.mJumpScheme = obj.optString("animationJumpScheme");
            item.mDownloadScheme = obj.optString("animationDownloadScheme");
            item.mDownloadToast = obj.optString("downloadToast");
            return item;
        }

        public static JSONObject toJson(PlayerAnimation playerAnimation) {
            String str;
            if (playerAnimation == null) {
                return null;
            }
            JSONObject json = new JSONObject();
            try {
                if (playerAnimation.mEnable) {
                    str = "1";
                } else {
                    str = "0";
                }
                json.put("playerAnimationFlag", str);
                json.put("animationJumpScheme", playerAnimation.mJumpScheme);
                json.put("animationDownloadScheme", playerAnimation.mDownloadScheme);
                if (!TextUtils.isEmpty(playerAnimation.mDownloadToast)) {
                    json.put("downloadToast", playerAnimation.mDownloadToast);
                }
            } catch (JSONException e2) {
                if (FeedItemDataTabVideo.DEBUG) {
                    e2.printStackTrace();
                }
            }
            return json;
        }
    }

    public static class VoteInfo {
        public long endTime;
        public int isVote;
        public int playPercent;
        public int playTime;
        public long startTime;
        public int times;

        /* access modifiers changed from: private */
        public static VoteInfo fromJson(JSONObject obj) {
            if (obj == null) {
                return null;
            }
            VoteInfo voteInfo = new VoteInfo();
            voteInfo.playPercent = obj.optInt("playPercent", 50);
            voteInfo.playTime = obj.optInt("playTime", 60);
            voteInfo.isVote = obj.optInt("isVote", 1);
            voteInfo.startTime = obj.optLong("startTime", 0);
            voteInfo.endTime = obj.optLong("endTime", 0);
            voteInfo.times = obj.optInt("times", 2);
            return voteInfo;
        }

        public boolean isVoteValide() {
            if (this.isVote != 1 || this.startTime == 0 || this.endTime == 0) {
                return false;
            }
            long currentTimeStamp = System.currentTimeMillis() / 1000;
            return this.endTime >= currentTimeStamp && currentTimeStamp >= this.startTime;
        }
    }

    public static class PaymentInfo {
        public String albumCmd;
        public String albumId;
        public String albumType;
        private JSONObject antiSpam;
        private int campCanPurchase;
        public int canSinglePaid;
        private String endTime;
        private String endTimePrefix;
        private String endTipTitle;
        public String img;
        public String isAuthro;
        public String isPaid;
        public int isSinglePaid = 0;
        private String isTailCardExp;
        public String paidSvType;
        public String previewDuration;
        public String priceTxt;
        public String realPrice;
        public String realPriceTxt;
        private JSONObject tailCardPayBtn;
        private String timeNow;
        public String title;
        public int trainingCamp;

        public static PaymentInfo fromJson(JSONObject json) {
            PaymentInfo info = new PaymentInfo();
            if (json == null) {
                return info;
            }
            try {
                info.albumId = json.optString("albumId");
                info.title = json.optString("title");
                info.albumType = json.optString("albumType");
                info.img = json.optString("img");
                info.isPaid = json.optString("isPaid");
                info.priceTxt = json.optString("priceTxt");
                info.realPriceTxt = json.optString("realPriceTxt");
                info.realPrice = json.optString("realPrice");
                info.albumCmd = json.optString("albumCmd");
                info.previewDuration = json.optString("previewDuration");
                info.paidSvType = json.optString("paidSvType");
                info.trainingCamp = json.optInt("isTrainingCamp");
                info.campCanPurchase = json.optInt("campCanPurchase");
                info.isTailCardExp = json.optString("isTailCardExp");
                info.endTime = json.optString("endTime");
                info.timeNow = json.optString("timeNow");
                info.endTipTitle = json.optString("endTipTitle");
                info.tailCardPayBtn = json.optJSONObject("tailCardPayBtn");
                info.endTimePrefix = json.optString("endTimePrefix");
                info.canSinglePaid = json.optInt("canSinglePaid");
                info.isSinglePaid = json.optInt("isSinglePaid");
                info.antiSpam = json.optJSONObject("antiSpam");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return info;
        }

        public JSONObject toJson() {
            JSONObject json = new JSONObject();
            try {
                json.put("isAuthro", this.isAuthro);
                json.put("paidSvType", this.paidSvType);
                json.put("albumId", this.albumId);
                json.put("title", this.title);
                json.put("albumType", this.albumType);
                json.put("img", this.img);
                json.put("isPaid", this.isPaid);
                json.put("priceTxt", this.priceTxt);
                json.put("realPriceTxt", this.realPriceTxt);
                json.put("realPrice", this.realPrice);
                json.put("albumCmd", this.albumCmd);
                json.put("previewDuration", this.previewDuration);
                json.put("isTrainingCamp", this.trainingCamp);
                json.put("campCanPurchase", this.campCanPurchase);
                json.put("isTailCardExp", this.isTailCardExp);
                json.put("endTime", this.endTime);
                json.put("timeNow", this.timeNow);
                json.put("endTipTitle", this.endTipTitle);
                json.put("tailCardPayBtn", this.tailCardPayBtn);
                json.put("endTimePrefix", this.endTimePrefix);
                json.put("canSinglePaid", this.canSinglePaid);
                json.put("isSinglePaid", this.isSinglePaid);
                json.put("antiSpam", this.antiSpam);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json;
        }

        public boolean hasPaid() {
            return "1".equals(this.isPaid);
        }
    }
}
