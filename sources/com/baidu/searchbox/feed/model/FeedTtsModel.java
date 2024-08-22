package com.baidu.searchbox.feed.model;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.purelisten.PureListenConstantsKt;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.feed.tts.interfaces.MockFeedPlayCallback;
import com.baidu.searchbox.feed.tts.model.FeedSongModel;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.model.TtsModelHelper;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.music.bean.Song;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedTtsModel implements IFeedTTSModel {
    private static final String LANDURL_FEED = "component=com.baidu.searchbox\\/.home.feed.FeedDetailActivity;";
    private static final String LANDURL_SEARCH = "action=com.baidu.searchbox.action.BROWSER;";
    private static final String LANDURL_SEARCH_SIMPLE = "action=com.baidu.searchbox.action.LIGHT_SEARCH;";
    public static final String SP_IS_AUTO_PLAY_VIDEO = "spAutoPlayVideo";
    private HashMap<String, String> extMap;
    public FeedTtsModel innerModel;
    private int mAbstractLength;
    private final FeedBaseModel mBaseModel;
    private int mContentLength;
    private float mConvertRadio;
    private String mCoverImg;
    private String mEndTTSText;
    private JSONObject mFavoriteJObject;
    private String mForcedSpeakerId;
    private String mForcedSpeakerName;
    private float mHoverViewPosition = -1.0f;
    private boolean mInTTSList;
    private boolean mIsAutoPlay;
    private boolean mLandingTTS;
    private String mLandingUrl;
    private String mMockedAction;
    private String mPassThrough;
    public String mPrevNid;
    private int mRalState = 0;
    private String mShareImg;
    private String mShareTitle;
    private String mShareUrl;
    private FeedSongModel mSongProperty;
    private String mTextUrl;
    private String mTtsActionId;
    private String mTtsImageUrl;
    private int mTtsState = 0;
    private String mUkey;
    private String mVideoShareInfo;
    private String mVoiceType;
    public MockFeedPlayCallback playCallback;
    public boolean ttsBtnLogShown = false;

    public static IFeedTTSModel createMock() {
        return createMock(String.valueOf(System.currentTimeMillis()), IFeedTTSModel.Action.CHANGE_SRC, IFeedTTSModel.DEFAULT_TIP_WORDS);
    }

    public static IFeedTTSModel createMock(String id, String action, String content) {
        return createMock(id, action, content, (MockFeedPlayCallback) null);
    }

    public static IFeedTTSModel createMock(String id, String action, String content, MockFeedPlayCallback callback) {
        return IFeedTTSContext.Impl.get().createMock(id, action, content, callback);
    }

    public FeedTtsModel(FeedBaseModel baseModel, boolean landingTTS) {
        this.mBaseModel = baseModel;
        this.mLandingTTS = landingTTS;
    }

    public FeedBaseModel getFeedBaseModel() {
        return this.mBaseModel;
    }

    public void putExtInfo(String key, String value) {
        if (this.extMap == null) {
            this.extMap = new HashMap<>();
        }
        this.extMap.put(key, value);
    }

    public String getExtInfo(String key, String defaultValue) {
        if (!hasExtInfo(key)) {
            return defaultValue;
        }
        return this.extMap.get(key);
    }

    public boolean hasExtInfo(String key) {
        HashMap<String, String> hashMap = this.extMap;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(key);
    }

    public boolean isMocked() {
        return !TextUtils.isEmpty(this.mMockedAction);
    }

    public boolean isLandingTTS() {
        return this.mLandingTTS;
    }

    public void setLandingTTS(boolean isLandingTTS) {
        this.mLandingTTS = isLandingTTS;
    }

    public String getFirstImageUrl() {
        FeedTtsModel feedTtsModel;
        if (this.mBaseModel == null) {
            return null;
        }
        FeedBaseModel model = this.mBaseModel;
        if (!TextUtils.isEmpty(this.mTtsImageUrl)) {
            return this.mTtsImageUrl;
        }
        if (isLandingTTS() && (feedTtsModel = this.innerModel) != null) {
            model = feedTtsModel.mBaseModel;
        }
        ArrayList<String> urls = model.getHelper().collectImageUrls();
        if (urls == null || urls.size() <= 0) {
            return null;
        }
        return urls.get(0);
    }

    public String getLandingUrl() {
        FeedTtsModel feedTtsModel;
        String url = null;
        if (TextUtils.equals("1", getExtInfo(IFeedTTSContext.CONTENT_NEED_LOCK, (String) null))) {
            url = this.mLandingUrl;
        } else {
            if (this.mBaseModel != null) {
                FeedProtocolEntity model = this.mBaseModel;
                if (isLandingTTS() && (feedTtsModel = this.innerModel) != null) {
                    model = feedTtsModel.mBaseModel;
                }
                if (!(model == null || model.data == null)) {
                    url = model.data.cmd.get();
                }
            }
            if (TextUtils.isEmpty(url) && !TextUtils.isEmpty(this.mLandingUrl)) {
                url = this.mLandingUrl;
            }
        }
        if (!TextUtils.isEmpty(url)) {
            return url.replaceFirst(LANDURL_SEARCH, LANDURL_FEED).replaceFirst(LANDURL_SEARCH_SIMPLE, LANDURL_FEED);
        }
        return url;
    }

    public void setLandingUrl(String url) {
        this.mLandingUrl = url;
    }

    public String getTTSShowTitle() {
        Spanned titleHtmled;
        if (this.mBaseModel == null) {
            return "";
        }
        if (TtsModelHelper.INSTANCE.isDynamicFeed(this)) {
            return TtsModelHelper.INSTANCE.getTitleWhenDynamic(this);
        }
        String title = this.mBaseModel.getHelper().getFeedTitle();
        if (!StringUtil.isBlank(title) || this.mBaseModel.data == null || !StringUtil.isNotBlank(this.mBaseModel.data.titleTts) || (titleHtmled = Html.fromHtml(this.mBaseModel.data.titleTts)) == null) {
            return title;
        }
        return titleHtmled.toString();
    }

    public String getTTSReadTitle() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || feedBaseModel.data == null) {
            return "";
        }
        return TextUtils.isEmpty(this.mBaseModel.data.titleTts) ? this.mBaseModel.getHelper().getFeedTitle() : this.mBaseModel.data.titleTts;
    }

    public boolean isRightAnswerPageWithTag(String tag) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        return (feedBaseModel == null || feedBaseModel.data == null || !TextUtils.equals(this.mBaseModel.data.resourceType, tag)) ? false : true;
    }

    public int getTTSTitleLength() {
        FeedBaseModel feedBaseModel;
        if (!isVideoTts() && !isAigc() && (feedBaseModel = this.mBaseModel) != null && feedBaseModel.data != null && !TextUtils.isEmpty(this.mBaseModel.data.titleTts)) {
            return Html.fromHtml(this.mBaseModel.data.titleTts).toString().length();
        }
        return 0;
    }

    public String getDataFrom() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        return (feedBaseModel == null || feedBaseModel.data == null) ? "" : this.mBaseModel.data.source;
    }

    public String getFavorData() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || feedBaseModel.data == null || this.mBaseModel.data.feedBar == null || this.mBaseModel.data.feedBar.favor == null) {
            return null;
        }
        if (FeedRuntime.GLOBAL_DEBUG) {
            Log.d("RecordHis", "getSpeechingFeedFavorData: return from model");
        }
        return FeedBar.Favor.toJson(this.mBaseModel.data.feedBar.favor).toString();
    }

    public String getChannelId() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null) {
            return null;
        }
        return feedBaseModel.runtimeStatus.channelId;
    }

    public void setClickTimestamp(String clickTimestamp) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null) {
            feedBaseModel.runtimeStatus.reportInfo.clickTime = FeedUtil.convertStringToLongSafe(clickTimestamp);
        }
    }

    public boolean isTopFixed() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || feedBaseModel.duplicateData == null) {
            return false;
        }
        return true;
    }

    public boolean canTTS() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null) {
            return false;
        }
        boolean isNotSupportVideo = feedBaseModel.getTtsModel().isVideoTts() && !FeedTTSPreferenceUtil.getBoolean(SP_IS_AUTO_PLAY_VIDEO, true);
        if (!TextUtils.equals(this.mBaseModel.istts, "1") || isNotSupportVideo) {
            return false;
        }
        return true;
    }

    public boolean hasTtsBody() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null) {
            return false;
        }
        return TextUtils.equals(feedBaseModel.isttsbody, "1");
    }

    public String getId() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null) {
            return null;
        }
        return feedBaseModel.id;
    }

    public boolean isReadable(boolean ignoreHasRead) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        boolean isReaded = feedBaseModel != null && feedBaseModel.runtimeStatus.isRead;
        if (!canTTS() || (!ignoreHasRead && isReaded)) {
            return false;
        }
        return true;
    }

    public void decorateFeedBaseModel(String decoratorStr) {
        if (!TextUtils.isEmpty(decoratorStr)) {
            try {
                JSONObject jsonObject = new JSONObject(decoratorStr);
                setFavoriteJObject(jsonObject);
                setShareTitle(jsonObject.optString("title"));
                String shareUrl = jsonObject.optString("shareUrl");
                setShareUrl(TextUtils.isEmpty(shareUrl) ? jsonObject.optString("url") : shareUrl);
                if (TextUtils.isEmpty(this.mLandingUrl) && !TextUtils.isEmpty(jsonObject.optString("cmd"))) {
                    String landingUrl = jsonObject.optString("cmd");
                    if (TextUtils.equals(jsonObject.optString(PureListenConstantsKt.KEY_PURE_TTS_CATEGORY), PureListenConstantsKt.TTS_CATEGORY_FEED_PURE_LISTEN)) {
                        try {
                            JSONObject cmdJson = new JSONObject(landingUrl);
                            if (cmdJson.has("url")) {
                                landingUrl = cmdJson.optString("url");
                            }
                        } catch (JSONException e2) {
                            if (AppConfig.isDebug()) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    setLandingUrl(landingUrl);
                }
                setShareImg(jsonObject.optString("img"));
                setUKey(jsonObject.optString("ukey"));
            } catch (JSONException e3) {
            }
        }
    }

    public boolean checkTtsNormalState() {
        return canTTS() && getTtsState() != 0;
    }

    public void setMockedAction(String mockedAction) {
        this.mMockedAction = mockedAction;
    }

    public String getMockedAction() {
        return this.mMockedAction;
    }

    public void setForcedSpeaker(String speakerId, String speakerName) {
        this.mForcedSpeakerId = speakerId;
        this.mForcedSpeakerName = speakerName;
    }

    public String getForcedSpeakerId() {
        return this.mForcedSpeakerId;
    }

    public String getForcedSpeakerName() {
        return this.mForcedSpeakerName;
    }

    public String getTextUrl() {
        return this.mTextUrl;
    }

    public void setTextUrl(String textUrl) {
        this.mTextUrl = textUrl;
    }

    public String getEndTTSText() {
        return this.mEndTTSText;
    }

    public void setEndTTSText(String endTTSText) {
        this.mEndTTSText = endTTSText;
    }

    public void setInTTSList(boolean inTTSList) {
        this.mInTTSList = inTTSList;
    }

    public boolean isInTTSList() {
        return this.mInTTSList;
    }

    public int getContentLength() {
        return this.mContentLength;
    }

    public void setContentLength(int contentLength) {
        this.mContentLength = contentLength;
    }

    public int getAbstractLength() {
        return this.mAbstractLength;
    }

    public void setAbstractLength(int abstractLength) {
        this.mAbstractLength = abstractLength;
    }

    public int getTtsState() {
        return this.mTtsState;
    }

    public void setTtsState(int ttsState) {
        FeedTtsModel feedTtsModel;
        this.mTtsState = ttsState;
        if (isLandingTTS() && (feedTtsModel = this.innerModel) != null && feedTtsModel != this) {
            feedTtsModel.setTtsState(ttsState);
        }
    }

    public boolean isRead() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null) {
            return false;
        }
        return feedBaseModel.runtimeStatus.isRead;
    }

    public void setRead(boolean read) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null) {
            feedBaseModel.runtimeStatus.isRead = read;
        }
    }

    public boolean isAutoPlay() {
        return this.mIsAutoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.mIsAutoPlay = autoPlay;
    }

    public String getTtsActionId() {
        return this.mTtsActionId;
    }

    public void setTtsActionId(String ttsActionId) {
        this.mTtsActionId = ttsActionId;
    }

    public void setCoverImg(String coverImg) {
        this.mCoverImg = coverImg;
    }

    public String getCoverImg() {
        return this.mCoverImg;
    }

    public String getUkey() {
        return this.mUkey;
    }

    public void setUKey(String uKey) {
        this.mUkey = uKey;
    }

    public String getShareTitle() {
        return this.mShareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.mShareTitle = shareTitle;
    }

    public String getShareUrl() {
        return this.mShareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.mShareUrl = shareUrl;
    }

    public void setShareImg(String shareImg) {
        this.mShareImg = shareImg;
    }

    public String getShareImg() {
        return this.mShareImg;
    }

    public void setHoverViewPosition(float position) {
        this.mHoverViewPosition = position;
    }

    public float getHoverViewPosition() {
        return this.mHoverViewPosition;
    }

    public void setFavoriteJObject(JSONObject jObject) {
        this.mFavoriteJObject = jObject;
    }

    public JSONObject getFavoriteJObject() {
        return this.mFavoriteJObject;
    }

    public int getRalState() {
        return this.mRalState;
    }

    public void setRalState(int ralState) {
        this.mRalState = ralState;
    }

    public String getTtsImageUrl() {
        return this.mTtsImageUrl;
    }

    public void setTtsImageUrl(String ttsImageUrl) {
        this.mTtsImageUrl = ttsImageUrl;
    }

    public boolean isCommonStream() {
        String from = getExtInfo("from", "");
        return TextUtils.equals(from, "stream") || TextUtils.equals(from, IFeedTTSModel.FROM_STREAM_HISTORY);
    }

    public boolean isCombinnation() {
        if (this.mBaseModel == null) {
            return false;
        }
        return FeedTplNameCenter.COMBINATION.equals(this.mBaseModel.layout);
    }

    public List<IFeedTTSModel> getCombindSubs() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || feedBaseModel.data == null) {
            return null;
        }
        return new ArrayList<>();
    }

    public void setChannelId(String channelId) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null) {
            feedBaseModel.runtimeStatus.channelId = channelId;
        }
    }

    public void setPrevNid(String id) {
        this.mPrevNid = id;
    }

    public String getPrevNid() {
        return this.mPrevNid;
    }

    public void setBusiness(String business) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null) {
            feedBaseModel.runtimeStatus.business = business;
        }
    }

    public MockFeedPlayCallback getPlayback() {
        return this.playCallback;
    }

    public void setPlayback(MockFeedPlayCallback callback) {
        this.playCallback = callback;
    }

    public void setDataFrom(String source) {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null && feedBaseModel.data != null) {
            this.mBaseModel.data.source = source;
        }
    }

    public String toString() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel != null) {
            return feedBaseModel.toString();
        }
        return "";
    }

    public String getPassThrough() {
        return this.mPassThrough;
    }

    public void setPassThrough(String passParams) {
        this.mPassThrough = passParams;
    }

    public void setSongProperty(FeedSongModel songProperty) {
        this.mSongProperty = songProperty;
    }

    public FeedSongModel getSongProperty() {
        return this.mSongProperty;
    }

    public boolean isFeedSong() {
        return this.mSongProperty != null;
    }

    public Song extractCommonSong() {
        if (this.mSongProperty == null) {
            return null;
        }
        Song song = new Song();
        song.mAudioType = 1;
        song.id = this.mSongProperty.id;
        song.mSongName = this.mSongProperty.name;
        song.mArtistName = this.mSongProperty.artist;
        song.mAlbumImageLink = this.mSongProperty.imgUrl;
        song.mLyricLink = this.mSongProperty.lrcUrl;
        song.lrcCode = this.mSongProperty.lrcCode;
        song.mOnlineUrl = this.mSongProperty.audioUrl;
        song.mAppDownlaodUrl = this.mSongProperty.appDownloadUrl;
        song.mAppName = this.mSongProperty.appName;
        song.mAppSize = this.mSongProperty.appSize;
        return song;
    }

    public boolean isVideoTts() {
        return !TextUtils.isEmpty(getVoiceType());
    }

    public boolean isAutoVideoTts() {
        return TextUtils.equals(getVoiceType(), "0");
    }

    public String tryToGetVideoInfo() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || !(feedBaseModel.data instanceof FeedItemDataNews)) {
            return null;
        }
        return ((FeedItemDataNews) this.mBaseModel.data).videoInfo;
    }

    public void setShareInfo(String shareInfo) {
        this.mVideoShareInfo = shareInfo;
    }

    public String getShareInfo() {
        return this.mVideoShareInfo;
    }

    public String getVoiceType() {
        FeedBaseModel feedBaseModel;
        if (!(!TextUtils.isEmpty(this.mVoiceType) || (feedBaseModel = this.mBaseModel) == null || feedBaseModel.data == null)) {
            this.mVoiceType = this.mBaseModel.data.voiceType;
        }
        return this.mVoiceType;
    }

    public void setVoiceType(String voiceType) {
        this.mVoiceType = voiceType;
    }

    public boolean getResNotSuitableTts() {
        FeedBaseModel feedBaseModel = this.mBaseModel;
        if (feedBaseModel == null || feedBaseModel.data == null) {
            return false;
        }
        return TextUtils.equals("0", this.mBaseModel.data.suitableBroadcast);
    }

    public boolean isAigc() {
        String bizExt = getExtInfo(IFeedTTSContext.KEY_BIZ_EXT_PARAMS, (String) null);
        if (TextUtils.isEmpty(bizExt)) {
            return false;
        }
        try {
            return TextUtils.equals("aigc", new JSONObject(bizExt).optString("novelType", (String) null));
        } catch (Exception e2) {
            if (FeedRuntime.GLOBAL_DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public boolean isEndlessFlowData() {
        return "1".equals(getExtInfo(IFeedTTSContext.KEY_IS_ENDLESS_FLOW, "0"));
    }

    public void markEndlessFlowData() {
        putExtInfo(IFeedTTSContext.KEY_IS_ENDLESS_FLOW, "1");
    }

    public float getConvertRadio() {
        float f2 = this.mConvertRadio;
        if (f2 > 0.0f) {
            return f2;
        }
        int wordCount = 0;
        String wholeWordCount = getExtInfo("letterCount", (String) null);
        if (!TextUtils.isEmpty(wholeWordCount)) {
            wordCount = FeedUtil.convertStringToIntSafe(wholeWordCount);
        }
        int duration = 0;
        String bizExt = getExtInfo(IFeedTTSContext.KEY_BIZ_EXT_PARAMS, (String) null);
        if (!TextUtils.isEmpty(bizExt)) {
            try {
                duration = FeedUtil.convertStringToIntSafe(new JSONObject(bizExt).optString(IFeedTTSContext.KEY_AUDIO_DURATION));
            } catch (JSONException e2) {
                if (FeedRuntime.GLOBAL_DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        if (wordCount <= 0 || duration <= 0) {
            this.mConvertRadio = 4.0f;
            return 4.0f;
        }
        float f3 = ((float) wordCount) / (((float) duration) / 1000.0f);
        this.mConvertRadio = f3;
        return f3;
    }
}
