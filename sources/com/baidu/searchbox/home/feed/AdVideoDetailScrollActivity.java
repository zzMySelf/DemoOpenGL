package com.baidu.searchbox.home.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.ad.AdParamsCache;
import com.baidu.searchbox.ad.dazzle.view.AdVideoDetailBottomView;
import com.baidu.searchbox.ad.dazzle.view.AdVideoDetailTipsView;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import com.baidu.searchbox.ad.download.manager.BusinessSourceHelperKt;
import com.baidu.searchbox.ad.exp.AdPolicyGlobal;
import com.baidu.searchbox.ad.feed.R;
import com.baidu.searchbox.ad.lightbrowser.AdLightBrowserWidgets;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.discovery.picture.utils.Utils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.detail.AdVideoDetailDataUtils;
import com.baidu.searchbox.feed.ad.log.AdVisibleLogManager;
import com.baidu.searchbox.feed.ad.log.AdVisibleSimpleModel;
import com.baidu.searchbox.feed.ad.model.MMAMonitorUrl;
import com.baidu.searchbox.feed.ad.prerender.AdPreRenderStateRecorder;
import com.baidu.searchbox.feed.ad.tail.AdBaseTailFrameView;
import com.baidu.searchbox.feed.ad.tail.AdEmbeddedTailFrameView;
import com.baidu.searchbox.feed.ad.util.AdDataReduceUtils;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.event.AdVideoDetailEvent;
import com.baidu.searchbox.feed.event.FeedAdVideoZeroSecMonitorEvent;
import com.baidu.searchbox.feed.ioc.IFeedNews;
import com.baidu.searchbox.feed.ioc.IFeedShare;
import com.baidu.searchbox.feed.model.AdTailFrameData;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.home.feed.WebViewContainer;
import com.baidu.searchbox.lightbrowser.LightBrowserActivity;
import com.baidu.searchbox.lightbrowser.listener.IUrlShare;
import com.baidu.searchbox.lightbrowser.prerender.PreRenderTrigger;
import com.baidu.searchbox.lightbrowser.prerender.data.AdRenderData;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.lightbrowser.view.PageStateChangeCallback;
import com.baidu.searchbox.ng.errorview.view.BdMultiStateView;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import com.baidu.searchbox.player.H5ProxyPlayer;
import com.baidu.searchbox.player.ad.AdShortVideoPlayer;
import com.baidu.searchbox.player.callback.OnShareListener;
import com.baidu.searchbox.player.callback.SimpleBaseVideoPlayerCallback;
import com.baidu.searchbox.player.callback.SimpleVideoPlayerCallback;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.model.ShareMeta;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.utils.FeedAdTools;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.BdVideoNewParser;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.webkit.sdk.VideoPlayer;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AdVideoDetailScrollActivity extends AdVideoDetailBaseActivity {
    private static final String INTENT_AD_EXT = "extInfo";
    private static final String INTENT_CPV_URL = "cpv_url";
    private static final String INTENT_FLOAT_TIP = "floatTip";
    private static final String INTENT_INTERACT_BTN_TARGET = "bannerButtonScheme";
    private static final String INTENT_INTERACT_BTN_TXT = "bannerButtonText";
    private static final String INTENT_MONITOR_LOG_SWITCH = "monitor_log";
    private static final String INTENT_NEED_SHARE_TOKEN = "needShareToken";
    private static final String INTENT_PARAM = "params";
    private static final String INTENT_PLAYER_RATIO_KEY = "playerRatio";
    private static final String INTENT_SHARE_URL = "bannerShareUrl";
    private static final String INTENT_STYLE_KEY = "style";
    private static final String INTENT_TAIL_BRAND_NAME = "bannerBrandName";
    private static final String INTENT_TAIL_HEAD_URL = "bannerIcon";
    static final String INTENT_VIDEO_INFO = "videoinfo";
    private static final String KEY_AD_EXT = "ad_extra_param";
    private static final String KEY_BOTTOM_BTN_SHOW = "bottom_btn_show";
    private static final String KEY_BOTTOM_BTN_TXT = "bottom_btn_txt";
    private static final String KEY_COMMENT = "comment";
    private static final String KEY_EXT_LOG = "ext_log";
    private static final String KEY_INJECTION_ANDROID_JS_SWITCH = "injection_android_js_switch";
    private static final String KEY_REPLAY_VIDEO = "restartVideo";
    public static final String KEY_SCROLL_RATIO = "scroll_ratio";
    private static final String NID = "nid";
    private static final int VIDEO_DETAL_HEIGHT = 2;
    public static final double VIDEO_SHOW_PART = 0.25d;
    /* access modifiers changed from: private */
    public boolean hasHideTipsView;
    /* access modifiers changed from: private */
    public boolean isLoadedJs = false;
    /* access modifiers changed from: private */
    public boolean isUp = false;
    private AdDownload mAdDownload;
    private String mAdExtInfo;
    private SimpleDraweeView mAdForegroundImg;
    private BdBaseImageView mAdForegroundPlayIcon;
    private AdTailFrameData mAdTailFrameData;
    /* access modifiers changed from: private */
    public boolean mBottomBtnShow;
    private String mBottomBtnText;
    private String mBtnText;
    /* access modifiers changed from: private */
    public String mBtnUrl;
    private String mCPVUrl = "";
    private int mCurrentPlayerMode = 1;
    /* access modifiers changed from: private */
    public AdVideoDetailBottomView mDetailBottomView;
    private String mExtraParam = "";
    private String mFloatTipText;
    /* access modifiers changed from: private */
    public final AdLightBrowserWidgets.IAdFloatTopBar mFloatTopBar = AdLightBrowserWidgets.createAdFloatTopBar(this);
    /* access modifiers changed from: private */
    public RelativeLayout mForegroundView;
    /* access modifiers changed from: private */
    public boolean mInjectionJsSwitch;
    private View.OnClickListener mInteractClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.ad_video_img || id == R.id.ad_video_image_video_icon) {
                AdVideoDetailScrollActivity.this.play();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mIsFirstInit = true;
    private boolean mIsNightMode = false;
    /* access modifiers changed from: private */
    public boolean mIsShowKeyboard;
    /* access modifiers changed from: private */
    public boolean mIsShowTailView;
    private boolean mIsStartMMAMonitor;
    /* access modifiers changed from: private */
    public boolean mIsVideoVisible = true;
    private MMAMonitorUrl mMMAMonitorUrl;
    /* access modifiers changed from: private */
    public String mNid = "";
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private Runnable mPlayRunnable = new Runnable() {
        public void run() {
            AdVideoDetailScrollActivity.this.play();
        }
    };
    protected AdShortVideoPlayer mPlayer;
    private VideoPlayerFactory mPlayerFactoryOnBrowser = new VideoPlayerFactory() {
        public VideoPlayer create(Context context) {
            H5ProxyPlayer unused = AdVideoDetailScrollActivity.this.mProxyPlayer = new H5ProxyPlayer(context, AbsVideoKernel.CYBER_PLAYER);
            return AdVideoDetailScrollActivity.this.mProxyPlayer;
        }
    };
    /* access modifiers changed from: private */
    public double mPlayerRatio;
    private int mPostLogSwitch;
    /* access modifiers changed from: private */
    public int mPreViewGestureEndTime;
    /* access modifiers changed from: private */
    public int mPreViewGestureStartTime;
    /* access modifiers changed from: private */
    public H5ProxyPlayer mProxyPlayer;
    private boolean mReplayVideo = false;
    private ValueAnimator mScrollAnimator;
    private WebViewContainer.OnScrollChangedCallback mScrollCallback = new WebViewContainer.OnScrollChangedCallback() {
        public void onScroll(int dx, int dy) {
            float y;
            if (AdVideoDetailScrollActivity.this.mVideoHolder != null && AdVideoDetailScrollActivity.this.mTailFrameView != null && AdVideoDetailScrollActivity.this.mForegroundView != null && AdVideoDetailScrollActivity.this.mPlayer != null && AdVideoDetailScrollActivity.this.mWebViewContainer != null) {
                if (AdVideoDetailScrollActivity.this.mTipsView != null && !AdVideoDetailScrollActivity.this.hasHideTipsView && dy > 0) {
                    AdVideoDetailScrollActivity.this.mTipsView.setVisibility(8);
                    boolean unused = AdVideoDetailScrollActivity.this.hasHideTipsView = true;
                }
                float y2 = AdVideoDetailScrollActivity.this.mVideoHolder.getY() - ((float) dy);
                if (AdVideoDetailScrollActivity.this.isVerticalVideo()) {
                    y = (float) Math.max((double) y2, -((((double) DeviceUtils.ScreenInfo.getDisplayHeight(AdVideoDetailScrollActivity.this)) * AdVideoDetailScrollActivity.this.mPlayerRatio) + 2.0d));
                } else {
                    y = Math.max(y2, -(((((float) DeviceUtils.ScreenInfo.getDisplayWidth(AdVideoDetailScrollActivity.this)) * 9.0f) / 16.0f) + 2.0f));
                }
                float y3 = Math.min(y, 0.0f);
                AdVideoDetailScrollActivity.this.moveView(y3);
                AdVideoDetailScrollActivity.this.mFloatTopBar.updateActionBarAlpha(y3, (float) AdVideoDetailScrollActivity.this.mVideoHeight, AdVideoDetailScrollActivity.this.getBdActionBar());
                if (AdVideoDetailScrollActivity.this.mPlayer.isComplete() && !AdVideoDetailScrollActivity.this.mIsShowTailView && AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin() > 0) {
                    AdVideoDetailScrollActivity.this.showTailView();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public double mScrollRatio;
    private String mShareUrl;
    private String mTailBrandName;
    /* access modifiers changed from: private */
    public AdEmbeddedTailFrameView mTailFrameView;
    private String mTailHeadUrl;
    AdVideoDetailTipsView mTipsView;
    private List<String> mTwoSecUrl;
    int mVideoHeight = 0;
    protected VideoViewHolder mVideoHolder;
    HashMap<Integer, String> mVideoInfo;
    /* access modifiers changed from: private */
    public WebViewContainer mWebViewContainer;
    /* access modifiers changed from: private */
    public int mWebViewHeight = 0;
    private WebViewContainer.OnUpListener onUpListener = new WebViewContainer.OnUpListener() {
        public void onUp(boolean scrollUp) {
            if (AdVideoDetailScrollActivity.this.mWebViewContainer != null) {
                double marginRatio = AdVideoDetailScrollActivity.this.mScrollRatio;
                if (scrollUp) {
                    marginRatio = 1.0d - marginRatio;
                }
                AdVideoDetailScrollActivity.this.handleUpAction((((double) AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin()) * 1.0d) / (((double) AdVideoDetailScrollActivity.this.mVideoHeight) * 1.0d) >= marginRatio);
                AdVideoDetailScrollActivity.this.mFloatTopBar.onUp(AdVideoDetailScrollActivity.this.mWebViewContainer, true);
            }
        }
    };
    private String title;

    /* access modifiers changed from: private */
    public void loadAdJs() {
        String injectJs = FileUtils.readAssetData(FeedRuntime.getAppContext(), "inject/ad_video_inject.js");
        if (!TextUtils.isEmpty(injectJs)) {
            loadJavaScript(injectJs);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(19);
        parseData();
        sendActionAls(Als.Page.PAGE_VIDEO_LP, Als.LogType.VIDEO_LP_PV.type, "");
        Intent intent = getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("style"))) {
            String style = intent.getStringExtra("style");
            JSONObject outToolIdsObj = null;
            try {
                if (!TextUtils.isEmpty(style)) {
                    outToolIdsObj = new JSONObject(style).optJSONObject("toolids");
                }
                if (outToolIdsObj != null) {
                    intent.putExtra("toolbaricons", outToolIdsObj.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        super.onCreate(savedInstanceState);
        getBrowserContainer().getAdPresenter().setPageType(1);
        getWindow().setFormat(-3);
        setEnableSliding(true);
        FeedUtil.fixTarget26Crash(this);
        initActionBarBg();
        initWebView();
        initUI();
        initCommonTool();
        setEnableImmersion(false);
    }

    public void onInitActionBar() {
        if (AdUtil.needShowTopBack(getIntent(), this.mNid)) {
            ActionBarExtKt.showActionBar(getBrowserContainer().getActionToolbarPresenter(), false);
        }
    }

    private void initActionBarBg() {
        if (getIntent().hasExtra("extra_actionbar_color_str")) {
            String colorStr = getIntent().getStringExtra("extra_actionbar_color_str");
            if (!TextUtils.isEmpty(colorStr)) {
                try {
                    ActionBarExtKt.setActionBarBackgroundColor(getBrowserContainer().getActionToolbarPresenter(), Color.parseColor(colorStr));
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initWebView() {
        if (getBrowserView() != null) {
            getBrowserView().getSettings().setDisplayZoomControls(false);
            getBrowserView().getSettings().setBuiltInZoomControls(false);
            getBrowserView().getSettings().setSupportZoom(false);
            getBrowserView().getSettings().setJavaScriptEnabled(true);
            if (!(getBrowserView() == null || getBrowserView().getStateView() == null)) {
                getBrowserView().getStateView().setErrorViewClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        AdVideoDetailScrollActivity.this.getBrowserView().onRetryClick();
                        AdVideoDetailScrollActivity.this.initUI();
                    }
                });
                getBrowserView().setStateChangeCallback(new PageStateChangeCallback() {
                    public void onLoadSuccess() {
                        int visibleHeight;
                        if (!AdVideoDetailScrollActivity.this.isLoadedJs && AdVideoDetailScrollActivity.this.mInjectionJsSwitch) {
                            boolean unused = AdVideoDetailScrollActivity.this.isLoadedJs = true;
                            int videoPlayHeight = DeviceUtils.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) AdVideoDetailScrollActivity.this.mVideoHeight);
                            if (AdUtil.needShowTopBack(AdVideoDetailScrollActivity.this.getIntent(), AdVideoDetailScrollActivity.this.mNid)) {
                                visibleHeight = DeviceUtils.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) FeedTemplateUtil.getCalculateHeight(FeedRuntime.getAppContext())) - videoPlayHeight;
                            } else {
                                visibleHeight = (DeviceUtils.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) FeedTemplateUtil.getCalculateHeight(FeedRuntime.getAppContext())) - ((int) AdVideoDetailScrollActivity.this.getResources().getDimension(com.baidu.android.common.ui.style.R.dimen.common_tool_bar_height))) - videoPlayHeight;
                            }
                            AdVideoDetailScrollActivity.this.loadAdJs();
                            AdVideoDetailScrollActivity.this.loadJavaScript("var native_ad_selected_elem=getPossibleConvertElement(" + visibleHeight + ");move(native_ad_selected_elem, 1, " + videoPlayHeight + ")");
                            boolean unused2 = AdVideoDetailScrollActivity.this.isUp = true;
                        }
                    }

                    public void onLoadFailure() {
                        if (AdVideoDetailScrollActivity.this.getBrowserView() != null) {
                            ((FrameLayout.LayoutParams) AdVideoDetailScrollActivity.this.getBrowserView().getLayoutParams()).topMargin = 0;
                            View errorView = AdVideoDetailScrollActivity.this.getBrowserView().getStateView().getView(BdMultiStateView.ViewState.ERROR);
                            if (!(errorView instanceof NetworkErrorView)) {
                                return;
                            }
                            if (!AdVideoDetailScrollActivity.this.mIsFirstInit) {
                                ((NetworkErrorView) errorView).resetIconWidthAndHeight();
                                return;
                            }
                            AdVideoDetailScrollActivity.this.mWebViewContainer.setTopLimit(0);
                            AdVideoDetailScrollActivity.this.mWebViewContainer.setTopMargin(0);
                        }
                    }

                    public void onHideLoading() {
                    }
                });
            }
            if (getBrowserView() != null && this.mPlayerFactoryOnBrowser != null) {
                getBrowserView().setVideoPlayerFactory(this.mPlayerFactoryOnBrowser);
            }
        }
    }

    private void parseData() {
        String str;
        String params = getIntent().getStringExtra("params");
        if (!TextUtils.isEmpty(params)) {
            try {
                this.mVideoInfo = new HashMap<>();
                JSONObject paramObj = new JSONObject(params);
                String url = paramObj.optString("openurl");
                Intent intent = getIntent();
                if (intent != null) {
                    intent.putExtra("url", url);
                    intent.putExtra("ad_invoke_flag", paramObj.optString("ad_invoke_flag"));
                }
                String adJsSwitch = paramObj.optString(KEY_INJECTION_ANDROID_JS_SWITCH, "0");
                this.mInjectionJsSwitch = !"0".equals(adJsSwitch);
                this.mBottomBtnShow = "1".equals(paramObj.optString(KEY_BOTTOM_BTN_SHOW, "0"));
                this.mBottomBtnText = paramObj.optString(KEY_BOTTOM_BTN_TXT);
                String adFlagStr = paramObj.optString("adFlag");
                if (!TextUtils.isEmpty(adFlagStr)) {
                    setPageReportData(adFlagStr);
                    JSONObject jsonObject = new JSONObject(adFlagStr);
                    this.mNid = jsonObject.optString("nid");
                    this.mExtraParam = jsonObject.optString("ext");
                }
                String videoInfoStr = paramObj.optString("videoinfo");
                if (!TextUtils.isEmpty(videoInfoStr)) {
                    JSONObject videoObj = new JSONObject(videoInfoStr);
                    this.mPlayerRatio = videoObj.optDouble(INTENT_PLAYER_RATIO_KEY);
                    this.mVideoInfo.put(0, videoObj.optString("videoUrl"));
                    setPageUrl(videoObj.optString("pageUrl"));
                    this.mVideoInfo.put(5, getPageUrl());
                    this.mVideoInfo.put(1, videoObj.optString("bannerTitle"));
                    this.mVideoInfo.put(107, videoObj.optString("posterImage"));
                    String extraParam = videoObj.optString("ext_log");
                    if (TextUtils.isEmpty(extraParam)) {
                        String str2 = adJsSwitch;
                        String str3 = adFlagStr;
                        this.mVideoInfo.put(111, new JSONObject().put(KEY_AD_EXT, this.mExtraParam).put("da_page", Als.Page.PAGE_VIDEO_LP.value).toString());
                    } else {
                        String str4 = adFlagStr;
                        boolean haveDaPage = new JSONObject(extraParam).has("da_page");
                        HashMap<Integer, String> hashMap = this.mVideoInfo;
                        if (haveDaPage) {
                            str = extraParam;
                        } else {
                            str = new JSONObject(extraParam).put("da_page", Als.Page.PAGE_VIDEO_LP.value).toString();
                        }
                        hashMap.put(111, str);
                    }
                    this.mVideoInfo.put(112, videoObj.optString("videoTime"));
                    this.mVideoInfo.put(124, videoObj.optString("page"));
                    this.mVideoInfo.put(301, videoObj.optString("from"));
                    this.mBtnText = videoObj.optString(INTENT_INTERACT_BTN_TXT);
                    this.mScrollRatio = videoObj.optDouble("scroll_ratio", 0.25d);
                    boolean z = true;
                    if (videoObj.optInt(KEY_REPLAY_VIDEO) != 1) {
                        z = false;
                    }
                    this.mReplayVideo = z;
                    double d2 = this.mScrollRatio;
                    if (d2 >= 1.0d || d2 <= 0.0d) {
                        this.mScrollRatio = 0.25d;
                    }
                    if (this.mBtnText.length() > 4) {
                        this.mBtnText = this.mBtnText.substring(0, 4);
                    }
                    this.mBtnUrl = videoObj.optString(INTENT_INTERACT_BTN_TARGET);
                    this.mShareUrl = videoObj.optString(INTENT_SHARE_URL);
                    getBrowserContainer().setLinkUrl(this.mShareUrl);
                    this.mAdExtInfo = videoObj.optString("extInfo");
                    this.mAdExtInfo = captureExtInfo(videoObj);
                    this.mTailBrandName = videoObj.optString(INTENT_TAIL_BRAND_NAME);
                    this.title = videoObj.optString("title");
                    this.mTailHeadUrl = videoObj.optString(INTENT_TAIL_HEAD_URL);
                    this.mTwoSecUrl = FeedAdTools.parseTwoSecUrl(videoObj);
                    if (AdParamsCache.getInstance().getObj(this.mNid, AdUtil.KEY_MMA_MONITOR_URL) instanceof MMAMonitorUrl) {
                        this.mMMAMonitorUrl = (MMAMonitorUrl) AdParamsCache.getInstance().getObj(this.mNid, AdUtil.KEY_MMA_MONITOR_URL);
                    } else {
                        this.mMMAMonitorUrl = MMAMonitorUrl.parseMMAUrl(videoObj);
                    }
                    this.mCPVUrl = videoObj.optString(INTENT_CPV_URL);
                    this.mPostLogSwitch = videoObj.optInt(INTENT_MONITOR_LOG_SWITCH);
                    String type = videoObj.optString("type");
                    String needShareToken = videoObj.optString("needShareToken");
                    if (intent != null) {
                        intent.putExtra("needShareToken", needShareToken);
                    }
                    if (TextUtils.equals(type, "download")) {
                        AdDownload adDownload = new AdDownload();
                        this.mAdDownload = adDownload;
                        adDownload.packageName = videoObj.optString("packageName");
                        this.mAdDownload.downloadUrl = videoObj.optString("downloadUrl");
                        this.mAdDownload.key = videoObj.optString(PluginInvokerConstants.DOWNLOAD_KEY);
                        this.mAdDownload.deferredCmd = videoObj.optString("deferred_cmd");
                        AdDownload adDownload2 = this.mAdDownload;
                        adDownload2.extra = AdDownloadExtra.create(adDownload2, (JSONObject) null);
                        String source = paramObj.optString("source");
                        this.mAdDownload.source = TextUtils.isEmpty(source) ? BusinessSourceHelperKt.SOURCE_NA : source;
                        AdDataReduceUtils.replaceDeferredCmd(this.mAdDownload);
                    }
                    this.mFloatTipText = videoObj.optString(INTENT_FLOAT_TIP, "");
                    this.mPreViewGestureEndTime = AdVideoDetailDataUtils.getGestureEndTime(this.mNid);
                    this.mPreViewGestureStartTime = AdVideoDetailDataUtils.getGestureStartTime(this.mNid);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private String captureExtInfo(JSONObject videoObj) {
        String extInfo = "";
        JSONObject jsonExtLog = videoObj.optJSONObject("ext_log");
        if (jsonExtLog != null) {
            extInfo = jsonExtLog.optString(KEY_AD_EXT);
        }
        if (TextUtils.isEmpty(extInfo)) {
            return videoObj.optString("extInfo");
        }
        return extInfo;
    }

    /* access modifiers changed from: private */
    public void initUI() {
        VideoViewHolder videoViewHolder = this.mVideoHolder;
        if (videoViewHolder != null && videoViewHolder.getChildCount() == 0) {
            destroyShortVideo();
        }
        if (NetWorkUtils.isNetworkConnected(this) || !this.mIsFirstInit) {
            this.mIsFirstInit = false;
            if (isVerticalVideo()) {
                this.mVideoHeight = (int) ((((double) DeviceUtils.ScreenInfo.getDisplayHeight(this)) * this.mPlayerRatio) + 2.0d);
            } else {
                this.mVideoHeight = ((DeviceUtils.ScreenInfo.getDisplayWidth(this) * 9) / 16) + 2;
            }
            HashMap<Integer, String> hashMap = this.mVideoInfo;
            if (hashMap != null) {
                String videoUrl = hashMap.get(0);
                if (!TextUtils.isEmpty(videoUrl)) {
                    initTailView();
                    initForegroundView();
                    initVideo(videoUrl);
                    updateSkin(NightModeHelper.getNightModeSwitcherState());
                    initVideoLPStatus();
                    VideoViewHolder videoViewHolder2 = this.mVideoHolder;
                    if (videoViewHolder2 != null) {
                        videoViewHolder2.setVisibility(0);
                    }
                    if (this.mTipsView == null) {
                        AdVideoDetailTipsView initTipsView = initTipsView();
                        this.mTipsView = initTipsView;
                        if (initTipsView != null && getBrowserView() != null) {
                            getBrowserView().addView(this.mTipsView);
                        }
                    }
                }
            }
        }
    }

    public AdVideoDetailTipsView initTipsView() {
        AdVideoDetailTipsView tipsView = new AdVideoDetailTipsView(getApplicationContext());
        FrameLayout.LayoutParams tipsViewLp = new FrameLayout.LayoutParams(-2, -2);
        tipsViewLp.gravity = 49;
        tipsViewLp.topMargin = DeviceUtils.ScreenInfo.dp2px(getApplicationContext(), 17.0f);
        tipsView.setTipsText(this.mFloatTipText);
        tipsView.setLayoutParams(tipsViewLp);
        if (TextUtils.isEmpty(this.mFloatTipText)) {
            tipsView.setVisibility(8);
        }
        return tipsView;
    }

    private void initForegroundView() {
        if (this.mVideoInfo != null && this.mForegroundView == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.ad_video_detail_forground_view, (ViewGroup) null);
            this.mForegroundView = relativeLayout;
            this.mAdForegroundImg = (SimpleDraweeView) relativeLayout.findViewById(R.id.ad_video_img);
            this.mAdForegroundPlayIcon = (BdBaseImageView) this.mForegroundView.findViewById(R.id.ad_video_image_video_icon);
            RelativeLayout.LayoutParams imageParams = (RelativeLayout.LayoutParams) this.mAdForegroundImg.getLayoutParams();
            if (imageParams != null) {
                imageParams.width = DeviceUtils.ScreenInfo.getDisplayWidth(this);
                imageParams.height = this.mVideoHeight;
                this.mAdForegroundImg.setLayoutParams(imageParams);
            }
            this.mAdForegroundImg.setOnClickListener(this.mInteractClickListener);
            this.mAdForegroundPlayIcon.setOnClickListener(this.mInteractClickListener);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
            params.height = this.mVideoHeight;
            this.mForegroundView.setVisibility(0);
            ((FrameLayout) findViewById(com.baidu.searchbox.lightbrowser.base.R.id.rootview)).addView(this.mForegroundView, params);
        }
    }

    private void initCommonTool() {
        if (getBottomBar() != null && getIntent() != null && AdUtil.getLpBackStyleFromIntent(getIntent()) != 4) {
            if (getIntent().getStringExtra("comment") != null) {
                getBottomBar().setItemVisibility(7, true);
            } else {
                getBottomBar().setItemVisibility(7, false);
            }
            getBottomBar().setItemVisibility(8, true);
            getBottomBar().setItemVisibility(9, true);
        }
    }

    public boolean onToolBarItemClick(View view2, BaseToolBarItem item) {
        if (item.getItemId() != 9) {
            return false;
        }
        dismissMenu();
        onShareClick();
        return true;
    }

    public boolean onCommonMenuItemClick(View view2, CommonMenuItem menuItem) {
        return onItemClick(menuItem);
    }

    private boolean onItemClick(CommonMenuItem item) {
        if (item.getItemId() != 10) {
            return false;
        }
        if (TextUtils.isEmpty(this.mShareUrl)) {
            UniversalToast.makeText(getApplicationContext(), com.baidu.searchbox.lightbrowser.base.R.string.browser_menu_toast_copy_url_null).showToast();
            return true;
        }
        IFeedShare.Impl.get().createBrowserShortUrl(this, AdUtil.replaceShareToken(this.mShareUrl), (String) null, IFeedShare.COMMON_SHARE_SOURCE, new IFeedShare.IBrowserCopyLinkListener() {
            public void onComplete(String linkUrl) {
                WrappedClipboardManager.newInstance(AdVideoDetailScrollActivity.this).setText(linkUrl);
                UniversalToast.makeText((Context) AdVideoDetailScrollActivity.this, com.baidu.searchbox.lightbrowser.base.R.string.copy_dialog_title).showHighlightToast();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public void onShareClick() {
        String shareUrl = TextUtils.isEmpty(this.mShareUrl) ? getBrowserContainer().getUrl() : this.mShareUrl;
        IFeedShare iFeedShare = IFeedShare.Impl.get();
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        iFeedShare.callShare(this, (String) null, (String) null, (String) null, hashMap != null ? hashMap.get(1) : "", (String) null, (String) null, shareUrl, (String) null, 1, "all", "album", (String) null, false, (IFeedShare.IOnSocialListener) null, (IFeedShare.IOnChildItemClickListener) null);
    }

    private void initTailView() {
        if (this.mVideoInfo != null) {
            AdEmbeddedTailFrameView adEmbeddedTailFrameView = new AdEmbeddedTailFrameView(this);
            this.mTailFrameView = adEmbeddedTailFrameView;
            adEmbeddedTailFrameView.setAlsHandler(new AdBaseTailFrameView.OnAlsHandler() {
                public void sendAls(String actionType, String area) {
                    AdVideoDetailScrollActivity.this.sendActionAls(Als.Page.PAGE_VIDEO_LP_TAIL, actionType, area);
                }
            });
            String imageUrl = this.mVideoInfo.get(107);
            AdDownload adDownload = this.mAdDownload;
            if (adDownload == null) {
                this.mAdTailFrameData = AdTailFrameData.createDetail(imageUrl, this.mTailHeadUrl, this.mBtnText, this.mBtnUrl, this.mTailBrandName);
            } else {
                AdDownloadBean downloadBean = AdDownloadBean.create(adDownload, Als.Page.PAGE_VIDEO_LP_TAIL.value, this.mAdExtInfo);
                this.mAdTailFrameData = AdTailFrameData.createDownload(imageUrl, this.mTailHeadUrl, this.mBtnText, this.mBtnUrl, this.mTailBrandName, downloadBean, false);
            }
            this.mAdTailFrameData.title = this.title;
            this.mAdTailFrameData.extraParams = this.mAdExtInfo;
            this.mAdTailFrameData.adId = this.mNid;
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
            params.height = this.mVideoHeight;
            ((FrameLayout) findViewById(com.baidu.searchbox.lightbrowser.base.R.id.rootview)).addView(this.mTailFrameView, params);
            this.mTailFrameView.setVisibility(4);
        }
    }

    public LinearLayout initBrowserLayout() {
        LightBrowserView lightBrowserView;
        if (isVerticalVideo()) {
            this.mVideoHeight = (int) ((((double) DeviceUtils.ScreenInfo.getDisplayHeight(this)) * this.mPlayerRatio) + 2.0d);
        } else {
            this.mVideoHeight = ((DeviceUtils.ScreenInfo.getDisplayWidth(this) * 9) / 16) + 2;
        }
        final LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(1);
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.mVideoHeight;
        String baseUrl = getBrowserContainer().getUrl();
        AdRenderData renderData = AdRenderData.createConsumeData("", baseUrl);
        if (PreRenderTrigger.INSTANCE.consumable(PreRenderTrigger.Type.AD, renderData)) {
            lightBrowserView = new LightBrowserView((Context) this, 2, (IUrlShare) getBrowserContainer(), renderData);
            AdPreRenderStateRecorder.getInstance().recordByPreRenderSuccess(baseUrl);
            getBrowserContainer().getAdPresenter().setPreRenderSuccess(true);
        } else {
            lightBrowserView = new LightBrowserView((Context) this, 2, (IUrlShare) getBrowserContainer());
        }
        setBrowserView(lightBrowserView);
        WebViewContainer webViewContainer = new WebViewContainer(this);
        this.mWebViewContainer = webViewContainer;
        webViewContainer.setClipChildren(false);
        this.mWebViewContainer.setLayerType(2, (Paint) null);
        this.mWebViewContainer.setStyle(3);
        this.mWebViewContainer.setTopLimit(this.mVideoHeight);
        this.mWebViewContainer.setTopMargin(this.mVideoHeight);
        this.mWebViewContainer.setOnScrollChangeListener(this.mScrollCallback);
        this.mWebViewContainer.setOnUpListener(this.onUpListener);
        layoutParams.height = -1;
        ViewTreeObserver vto = this.mWebViewContainer.getViewTreeObserver();
        if (vto != null) {
            vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    AdVideoDetailScrollActivity adVideoDetailScrollActivity = AdVideoDetailScrollActivity.this;
                    int unused = adVideoDetailScrollActivity.mWebViewHeight = adVideoDetailScrollActivity.mWebViewContainer.getMeasuredHeight();
                    if (AdVideoDetailScrollActivity.this.getBrowserView() == null) {
                        ViewTreeObserver v = AdVideoDetailScrollActivity.this.mWebViewContainer.getViewTreeObserver();
                        if (v != null && v.isAlive()) {
                            v.removeOnPreDrawListener(this);
                        }
                        return true;
                    }
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) AdVideoDetailScrollActivity.this.getBrowserView().getLayoutParams();
                    params.height = AdVideoDetailScrollActivity.this.mWebViewHeight;
                    if (AdVideoDetailScrollActivity.this.mBottomBtnShow) {
                        params.bottomMargin = (int) AdVideoDetailScrollActivity.this.getResources().getDimension(com.baidu.searchbox.feed.ad.R.dimen.dimens_48dp);
                    } else {
                        params.bottomMargin = 0;
                    }
                    AdVideoDetailScrollActivity.this.getBrowserView().setLayoutParams(params);
                    ViewTreeObserver v2 = AdVideoDetailScrollActivity.this.mWebViewContainer.getViewTreeObserver();
                    if (v2 != null && v2.isAlive()) {
                        v2.removeOnPreDrawListener(this);
                    }
                    return true;
                }
            });
        }
        this.mWebViewContainer.setInterceptScrollLister(new WebViewContainer.InterceptScrollLister() {
            public boolean isInterceptParentScroll() {
                return AdVideoDetailScrollActivity.this.getBrowserView().getTouchMode() == 6;
            }
        });
        this.mWebViewContainer.setMinFlingVelocity(1000);
        this.mWebViewContainer.setUpYVelocityRatio(3.5f);
        this.mWebViewContainer.setInterceptFlingListener(new WebViewContainer.InterceptFlingListener() {
            public boolean interceptFling(boolean scrollUp) {
                if (scrollUp && AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin() <= AdVideoDetailScrollActivity.this.mVideoHeight) {
                    AdVideoDetailScrollActivity.this.handleUpAction(false);
                    return true;
                } else if (scrollUp || AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin() < AdVideoDetailScrollActivity.this.mWebViewContainer.getMinTopMargin()) {
                    return false;
                } else {
                    AdVideoDetailScrollActivity.this.handleUpAction(true);
                    return true;
                }
            }
        });
        if (getBrowserView() != null) {
            this.mWebViewContainer.addView(getBrowserView(), layoutParams);
        }
        keyboardOptimization();
        LinearLayout.LayoutParams lvp = new LinearLayout.LayoutParams(-1, -1);
        lvp.weight = 1.0f;
        contentLayout.setClipChildren(false);
        contentLayout.addView(this.mWebViewContainer, lvp);
        if (this.mBottomBtnShow) {
            AdVideoDetailBottomView adVideoDetailBottomView = new AdVideoDetailBottomView(contentLayout.getContext());
            this.mDetailBottomView = adVideoDetailBottomView;
            adVideoDetailBottomView.updateBottomView(this.mBottomBtnText);
            this.mDetailBottomView.setBottomViewListener(new AdVideoDetailBottomView.AdVideoDetailBottomViewListener() {
                public void closeBottomView() {
                    contentLayout.removeView(AdVideoDetailScrollActivity.this.mDetailBottomView);
                    if (AdVideoDetailScrollActivity.this.getBrowserView() != null) {
                        layoutParams.height = AdVideoDetailScrollActivity.this.mWebViewHeight;
                        layoutParams.bottomMargin = 0;
                        AdVideoDetailScrollActivity.this.getBrowserView().setLayoutParams(layoutParams);
                    }
                }
            });
            contentLayout.addView(this.mDetailBottomView);
            this.mDetailBottomView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Router.invoke(AdVideoDetailScrollActivity.this.mDetailBottomView.getContext(), AdVideoDetailScrollActivity.this.mBtnUrl);
                }
            });
        }
        return contentLayout;
    }

    private void initVideoLPStatus() {
        if (this.mWebViewContainer != null && getBrowserView() != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.mVideoHeight;
            layoutParams.height = this.mWebViewHeight;
            this.mWebViewContainer.setTopMargin(this.mVideoHeight);
            this.mWebViewContainer.setTopLimit(this.mVideoHeight);
            this.mWebViewContainer.setStyle(3);
            getBrowserView().setLayoutParams(layoutParams);
        }
    }

    private void keyboardOptimization() {
        getBrowserContainer().getAdPresenter().applyKeyboardAdjust(false);
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() {
            int preBottom;

            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                int bottomPadding;
                int visibleHeight;
                int i2 = right;
                int i3 = oldRight;
                Rect rect = new Rect();
                View view2 = v;
                v.getWindowVisibleDisplayFrame(rect);
                int i4 = rect.bottom;
                int i5 = this.preBottom;
                if (i4 == i5 || i5 == 0) {
                    this.preBottom = rect.bottom;
                } else if (AdVideoDetailScrollActivity.this.getBrowserView() != null) {
                    int keyboardHeight = this.preBottom - rect.bottom;
                    if (keyboardHeight > 200) {
                        if (AdVideoDetailScrollActivity.this.mIsVideoVisible && i2 == i3) {
                            AdVideoDetailScrollActivity.this.handleUpAction(false);
                        }
                        boolean unused = AdVideoDetailScrollActivity.this.mIsShowKeyboard = true;
                        if (i2 == i3) {
                            if (AdUtil.needShowTopBack(AdVideoDetailScrollActivity.this.getIntent(), AdVideoDetailScrollActivity.this.mNid)) {
                                bottomPadding = AdVideoDetailScrollActivity.this.mWebViewContainer.getMinTopMargin() + keyboardHeight;
                            } else {
                                bottomPadding = (keyboardHeight - ((int) AdVideoDetailScrollActivity.this.getResources().getDimension(com.baidu.android.common.ui.style.R.dimen.common_tool_bar_height))) + AdVideoDetailScrollActivity.this.mWebViewContainer.getMinTopMargin();
                            }
                            AdVideoDetailScrollActivity.this.getBrowserView().setPadding(AdVideoDetailScrollActivity.this.getBrowserView().getPaddingLeft(), AdVideoDetailScrollActivity.this.getBrowserView().getPaddingTop(), AdVideoDetailScrollActivity.this.getBrowserView().getPaddingRight(), bottomPadding);
                            if (AdVideoDetailScrollActivity.this.mIsVideoVisible) {
                                visibleHeight = (AdVideoDetailScrollActivity.this.getBrowserView().getHeight() - keyboardHeight) - AdVideoDetailScrollActivity.this.mVideoHeight;
                            } else {
                                visibleHeight = AdVideoDetailScrollActivity.this.getBrowserView().getHeight() - keyboardHeight;
                            }
                            AdVideoDetailScrollActivity adVideoDetailScrollActivity = AdVideoDetailScrollActivity.this;
                            adVideoDetailScrollActivity.visibleRectChange(visibleHeight, keyboardHeight, adVideoDetailScrollActivity.getBrowserView().getHeight(), AdVideoDetailScrollActivity.this.mVideoHeight);
                        }
                    } else {
                        if (i2 == i3 && AdVideoDetailScrollActivity.this.mIsShowKeyboard) {
                            if (AdVideoDetailScrollActivity.this.getBrowserView().getWebViewScrollY() < 3) {
                                AdVideoDetailScrollActivity.this.handleUpAction(true);
                            }
                            AdVideoDetailScrollActivity.this.getBrowserView().setPadding(AdVideoDetailScrollActivity.this.getBrowserView().getPaddingLeft(), AdVideoDetailScrollActivity.this.getBrowserView().getPaddingTop(), AdVideoDetailScrollActivity.this.getBrowserView().getPaddingRight(), AdVideoDetailScrollActivity.this.mWebViewContainer.getMinTopMargin());
                            AdVideoDetailScrollActivity adVideoDetailScrollActivity2 = AdVideoDetailScrollActivity.this;
                            adVideoDetailScrollActivity2.visibleRectChange(adVideoDetailScrollActivity2.getBrowserView().getHeight(), 0, AdVideoDetailScrollActivity.this.getBrowserView().getHeight(), AdVideoDetailScrollActivity.this.mVideoHeight);
                        }
                        boolean unused2 = AdVideoDetailScrollActivity.this.mIsShowKeyboard = false;
                    }
                    this.preBottom = rect.bottom;
                }
            }
        };
        getWindow().getDecorView().addOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    public void visibleRectChange(int visibleHeight, int keyboardHeight, int webViewHeight, int videoHeight) {
        loadJavaScript("NadJsControl.visibleRectChange(".concat(String.valueOf(visibleHeight)).concat(",").concat(String.valueOf(keyboardHeight)).concat(",").concat(String.valueOf(webViewHeight)).concat(",").concat(String.valueOf(videoHeight)).concat(");"));
    }

    private void initVideo(String videoUrl) {
        initVideoHolder();
        initVideoPlayer(videoUrl);
    }

    private void initVideoPlayer(String videoUrl) {
        if (this.mPlayer == null) {
            this.mPlayer = new AdShortVideoPlayer(videoUrl);
            AdVideoDetailStrategy strategy = new AdVideoDetailStrategy();
            if (isVerticalVideo()) {
                strategy.setShowFullScreenBtn(false);
            }
            this.mPlayer.attachToContainer(this.mVideoHolder);
            this.mPlayer.setPlayerListener(new PlayerListener());
            this.mPlayer.setShortVideoPlayerListener(new ShortVideoPlayerListener());
            this.mPlayer.setShareListener(new OnShareListener() {
                public void share(ShareMeta shareMeta) {
                    AdVideoDetailScrollActivity.this.onShareClick();
                }
            });
            this.mPlayer.setStrategy(strategy);
            this.mVideoInfo.put(103, "3");
            String posterUrl = this.mVideoInfo.get(107);
            String prefetchUrl = IFeedNews.Impl.get().getImageCache(posterUrl, false);
            if (!TextUtils.isEmpty(prefetchUrl)) {
                this.mVideoInfo.put(107, prefetchUrl);
            } else {
                this.mVideoInfo.put(107, posterUrl);
            }
            this.mVideoInfo.put(110, "true");
            BdVideoSeries series = BdVideoNewParser.parseToVideoSeriesSafely(this.mVideoInfo);
            if (series != null) {
                series.setNid(this.mNid);
                series.setReplayVideo(this.mReplayVideo);
                this.mPlayer.setVideoSeries(series);
                if (!isFinishing()) {
                    String imageUrl = this.mVideoInfo.get(107);
                    SimpleDraweeView simpleDraweeView = this.mAdForegroundImg;
                    if (simpleDraweeView != null) {
                        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImage(getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_img_default_icon));
                        if (!TextUtils.isEmpty(imageUrl)) {
                            this.mAdForegroundImg.setImageURI(Utils.getUri(imageUrl));
                        }
                        this.mAdForegroundImg.setVisibility(0);
                    }
                    postPlay();
                }
            } else if (FeedRuntime.GLOBAL_DEBUG) {
                throw new IllegalArgumentException("BdVideoSeries cannot be null.");
            }
        }
    }

    private void postPlay() {
        if (getBrowserView() != null) {
            getBrowserView().post(this.mPlayRunnable);
        }
    }

    /* access modifiers changed from: private */
    public void play() {
        if (this.mPlayer != null) {
            if (NetWorkUtils.isNetworkConnected(this)) {
                if (this.mPlayer.getVideoSeries() == null) {
                    this.mPlayer.setVideoInfo(this.mVideoInfo);
                }
                if (isVerticalVideo()) {
                    this.mPlayer.setLooping(true);
                } else {
                    this.mPlayer.setLooping(false);
                }
                this.mPlayer.start();
                return;
            }
            UniversalToast.makeText(getApplicationContext(), (CharSequence) getString(R.string.login_portrait_no_network)).setDuration(3).showToast();
        }
    }

    private void initVideoHolder() {
        if (this.mVideoHolder == null) {
            VideoViewHolder videoViewHolder = new VideoViewHolder(this);
            this.mVideoHolder = videoViewHolder;
            videoViewHolder.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (((FrameLayout) v).getChildCount() == 0) {
                        AdVideoDetailScrollActivity.this.initUI();
                    }
                }
            });
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
            params.height = this.mVideoHeight;
            params.gravity = 48;
            FrameLayout rootView = (FrameLayout) findViewById(com.baidu.searchbox.lightbrowser.base.R.id.rootview);
            if (rootView != null) {
                rootView.addView(this.mVideoHolder, params);
            }
            this.mVideoHolder.setVisibility(4);
            if (getIntent() != null && !AdUtil.needShowToolBarAndFloatMoreIcon(getIntent()) && AdUtil.getLpBackStyleFromIntent(getIntent()) != 4) {
                this.mFloatTopBar.initFloatActionBar(rootView, getIntent(), this.mNid, getBdActionBar(), this.mWebViewContainer, getBrowserView());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            parseData();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return handleKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mPlayer != null && shouldResumePlayer()) {
            this.mPlayer.goBackOrForeground(true);
        }
        hideStatusBar();
        handlePlayerOrientationHelper();
    }

    private boolean shouldResumePlayer() {
        WebViewContainer webViewContainer = this.mWebViewContainer;
        if (webViewContainer == null || this.mPlayer == null) {
            return false;
        }
        if (!((((double) webViewContainer.getTopMargin()) * 1.0d) / (((double) this.mVideoHeight) * 1.0d) >= 0.25d) || this.mPlayer.isPlaying() || this.mIsShowTailView) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        cancelScrollAnimator();
        AdShortVideoPlayer adShortVideoPlayer = this.mPlayer;
        if (adShortVideoPlayer != null && !adShortVideoPlayer.isPause() && !this.mPlayer.isComplete() && !this.mPlayer.isStop()) {
            this.mPlayer.goBackOrForeground(false);
        }
    }

    public void finish() {
        super.finish();
        RelativeLayout relativeLayout = this.mForegroundView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        updatePreViewProgress(this.mNid);
        destroyShortVideo();
        BdEventBus.Companion.getDefault().post(new AdVideoDetailEvent(0));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mProxyPlayer = null;
        this.mPlayerFactoryOnBrowser = null;
        cancelScrollAnimator();
        destroyShortVideo();
        if (this.mOnLayoutChangeListener != null) {
            getWindow().getDecorView().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
            this.mOnLayoutChangeListener = null;
        }
        BdEventBus.Companion.getDefault().post(new AdVideoDetailEvent(0));
    }

    public boolean onActionBarBackPressed() {
        this.mFloatTopBar.updateCloseBtnVisibility(getBrowserContainer().shouldShowCloseBar());
        return false;
    }

    public boolean handleKeyDown(int keyCode, KeyEvent event) {
        return videoPluginHandledKeyDown(keyCode);
    }

    public boolean videoPluginHandledKeyDown(int keyCode) {
        H5ProxyPlayer h5ProxyPlayer;
        boolean handled = false;
        AdShortVideoPlayer adShortVideoPlayer = this.mPlayer;
        if ((adShortVideoPlayer == null && this.mProxyPlayer == null) || keyCode != 4) {
            return false;
        }
        if (adShortVideoPlayer != null) {
            handled = adShortVideoPlayer.onKeyBack();
        }
        if (handled || (h5ProxyPlayer = this.mProxyPlayer) == null) {
            return handled;
        }
        return h5ProxyPlayer.onKeyBack(this);
    }

    /* access modifiers changed from: private */
    public void startVisibleMonitor() {
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        if (hashMap != null && this.mPlayer != null && this.mVideoHolder != null && !TextUtils.isEmpty(hashMap.get(0))) {
            Als.Builder builder = new Als.Builder();
            builder.setPage(Als.Page.PAGE_VIDEO_LP);
            builder.setExt1("1");
            if (!TextUtils.isEmpty(this.mAdExtInfo)) {
                builder.setExtraParam(this.mAdExtInfo);
            }
            builder.setType(Als.LogType.VISIBLE_TWO_SEC);
            AdVisibleSimpleModel.Builder builderModel = new AdVisibleSimpleModel.Builder();
            builderModel.setBuilder(builder).setTaskId(FeedAdUtil.genMonitorTaskId(this.mNid));
            List<String> list = this.mTwoSecUrl;
            if (list != null && !list.isEmpty()) {
                builderModel.setTwoSecUrl(this.mTwoSecUrl);
            }
            AdVisibleLogManager.startTwoSecMonitor(this.mVideoHolder, builderModel.create(), this.mNid, new AdVisibleLogManager.IAdVisibleListener<Integer>() {
                public Integer onHandleEvent(String taskId) {
                    if (AdVideoDetailScrollActivity.this.mVideoInfo == null || AdVideoDetailScrollActivity.this.mPlayer == null || !TextUtils.equals(taskId, FeedAdUtil.genMonitorTaskId(AdVideoDetailScrollActivity.this.mNid))) {
                        return -1;
                    }
                    int time = AdVideoDetailScrollActivity.this.mPlayer.getPositionMs();
                    if (time == AdVideoDetailScrollActivity.this.mPlayer.getDuration()) {
                        if (LightBrowserActivity.DEBUG) {
                            Log.d(LightBrowserActivity.TAG, "time end:" + time + "   duration:" + AdVideoDetailScrollActivity.this.mPlayer.getDuration());
                        }
                        time = 0;
                    }
                    if (LightBrowserActivity.DEBUG) {
                        Log.d(LightBrowserActivity.TAG, "onHandleEvent:" + time);
                    }
                    return Integer.valueOf(time);
                }

                public void onMonitorStop(String taskId) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void startZeroSecMonitor() {
        FeedAdVideoZeroSecMonitorEvent event = new FeedAdVideoZeroSecMonitorEvent();
        event.mTaskId = this.mNid;
        BdEventBus.Companion.getDefault().post(event);
    }

    /* access modifiers changed from: private */
    public void startMMAMonitor() {
        if (this.mMMAMonitorUrl != null && this.mVideoHolder != null && !this.mIsStartMMAMonitor) {
            FeedRuntime.getAdMMAVisibleMonitor().mmaVideoPlayMonitor(this.mMMAMonitorUrl, this.mVideoHolder, 2, this.mPostLogSwitch, this.mExtraParam);
            this.mIsStartMMAMonitor = true;
        }
    }

    /* access modifiers changed from: private */
    public void endVisibleMonitor() {
        VideoViewHolder videoViewHolder = this.mVideoHolder;
        if (videoViewHolder != null) {
            AdVisibleLogManager.stopTwoSecMonitor((View) videoViewHolder);
        } else if (this.mVideoInfo != null) {
            AdVisibleLogManager.stopTwoSecMonitor(FeedAdUtil.genMonitorTaskId(this.mNid));
        }
    }

    private class PlayerListener extends SimpleVideoPlayerCallback {
        private PlayerListener() {
        }

        public void onStart() {
            super.onStart();
            if (AdVideoDetailScrollActivity.this.mForegroundView != null) {
                AdVideoDetailScrollActivity.this.mForegroundView.setVisibility(4);
            }
            AdVideoDetailScrollActivity.this.startVisibleMonitor();
            AdVideoDetailScrollActivity.this.startZeroSecMonitor();
            if (AdPolicyGlobal.INSTANCE.getAdMMAMonitorSwitch()) {
                AdVideoDetailScrollActivity.this.startMMAMonitor();
            }
        }

        public void onPrepared() {
            if (AdVideoDetailScrollActivity.this.mPreViewGestureStartTime != 0 && AdVideoDetailScrollActivity.this.mPreViewGestureEndTime != 0) {
                AdVideoDetailScrollActivity.this.mPlayer.seekTo(AdVideoDetailDataUtils.getLandingPageVideoPrpgress(AdVideoDetailScrollActivity.this.mNid));
            }
        }

        public void onPause() {
            AdVideoDetailScrollActivity.this.mFloatTopBar.onPause(AdVideoDetailScrollActivity.this.mWebViewContainer);
        }

        public void onEnd(int what) {
            super.onEnd(what);
            AdVideoDetailScrollActivity.this.endVisibleMonitor();
            if (!AdVideoDetailScrollActivity.this.isVerticalVideo() && AdVideoDetailScrollActivity.this.mIsVideoVisible) {
                AdVideoDetailScrollActivity.this.showTailView();
            }
        }

        public void onInfo(int what, int extra) {
            switch (what) {
                case 100:
                    AdVideoDetailScrollActivity.this.destroyShortVideo();
                    return;
                default:
                    return;
            }
        }

        public void onError(int what, int extra, String info) {
            super.onError(what, extra, info);
            AdVideoDetailScrollActivity.this.endVisibleMonitor();
        }
    }

    /* access modifiers changed from: private */
    public boolean isVerticalVideo() {
        return this.mPlayerRatio - 0.0d > 0.01d;
    }

    /* access modifiers changed from: private */
    public void showTailView() {
        if (this.mCurrentPlayerMode != 2) {
            RelativeLayout relativeLayout = this.mForegroundView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            AdEmbeddedTailFrameView adEmbeddedTailFrameView = this.mTailFrameView;
            if (adEmbeddedTailFrameView != null && this.mAdTailFrameData != null) {
                this.mIsShowTailView = true;
                adEmbeddedTailFrameView.bringToFront();
                this.mTailFrameView.showTailFrame(this.mAdTailFrameData);
                this.mFloatTopBar.onShowTailView(this.mIsVideoVisible);
            }
        }
    }

    /* access modifiers changed from: private */
    public void hideInputMethod() {
        if (getBrowserView() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
            if (imm != null && imm.isActive()) {
                imm.hideSoftInputFromWindow(getBrowserView().getApplicationWindowToken(), 0);
            }
            getBrowserView().setPadding(getBrowserView().getPaddingLeft(), getBrowserView().getPaddingTop(), getBrowserView().getPaddingRight(), this.mWebViewContainer.getMinTopMargin());
        }
    }

    private class ShortVideoPlayerListener extends SimpleBaseVideoPlayerCallback {
        private ShortVideoPlayerListener() {
        }

        public void onVideoSwitchToFull() {
            super.onVideoSwitchToFull();
            AdVideoDetailScrollActivity.this.handlePlayModeChange(2);
            AdVideoDetailScrollActivity.this.hideInputMethod();
        }

        public void onVideoSwitchToHalf() {
            super.onVideoSwitchToHalf();
            AdVideoDetailScrollActivity.this.handlePlayModeChange(1);
        }

        public void onPanelVisibilityChanged(boolean isVisible) {
            super.onPanelVisibilityChanged(isVisible);
            if (AdUtil.needShowTopBack(AdVideoDetailScrollActivity.this.getIntent(), AdVideoDetailScrollActivity.this.mNid)) {
                AdVideoDetailScrollActivity.this.mFloatTopBar.onPanelVisibilityChangedForTB(AdVideoDetailScrollActivity.this.mWebViewContainer, isVisible);
            } else {
                AdVideoDetailScrollActivity.this.mFloatTopBar.onPanelVisibilityChanged(AdVideoDetailScrollActivity.this.mWebViewContainer, isVisible);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handlePlayModeChange(int mode) {
        AdEmbeddedTailFrameView adEmbeddedTailFrameView;
        int i2 = this.mCurrentPlayerMode;
        if (2 == i2 && mode != i2) {
            AdShortVideoPlayer adShortVideoPlayer = this.mPlayer;
            if (!(adShortVideoPlayer == null || !adShortVideoPlayer.isPlaying() || (adEmbeddedTailFrameView = this.mTailFrameView) == null)) {
                adEmbeddedTailFrameView.setVisibility(4);
                this.mIsShowTailView = false;
            }
            this.mFloatTopBar.handlePlayModeChange(this.mIsShowTailView);
        }
        this.mCurrentPlayerMode = mode;
        this.mFloatTopBar.onHideStatusBar();
    }

    /* access modifiers changed from: private */
    public void destroyShortVideo() {
        endVisibleMonitor();
        if (AdPolicyGlobal.INSTANCE.getAdMMAMonitorSwitch()) {
            FeedRuntime.getAdMMAVisibleMonitor().stopMMAVisibleMonitor(this.mMMAMonitorUrl);
        }
        if (getBrowserView() != null) {
            getBrowserView().removeCallbacks(this.mPlayRunnable);
        }
        AdShortVideoPlayer adShortVideoPlayer = this.mPlayer;
        if (adShortVideoPlayer != null) {
            adShortVideoPlayer.release();
            this.mPlayer = null;
        }
        VideoViewHolder videoViewHolder = this.mVideoHolder;
        if (videoViewHolder != null) {
            ViewGroup parentView = (ViewGroup) videoViewHolder.getParent();
            if (parentView != null) {
                parentView.removeView(this.mVideoHolder);
            }
            this.mVideoHolder.removeAllViews();
            this.mVideoHolder = null;
        }
        this.mFloatTopBar.onDestroyShortVideo((FrameLayout) findViewById(com.baidu.searchbox.lightbrowser.base.R.id.rootview));
    }

    public String obtainPageTitle() {
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        if (hashMap == null) {
            return super.obtainPageTitle();
        }
        return hashMap.get(1);
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        if (isNightMode != this.mIsNightMode) {
            updateSkin(isNightMode);
        }
    }

    /* access modifiers changed from: protected */
    public void updateSkin(boolean isNightMode) {
        this.mIsNightMode = isNightMode;
        this.mFloatTopBar.invalidate();
        SimpleDraweeView simpleDraweeView = this.mAdForegroundImg;
        if (simpleDraweeView != null) {
            simpleDraweeView.invalidate();
        }
        BdBaseImageView bdBaseImageView = this.mAdForegroundPlayIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.invalidate();
        }
        RelativeLayout relativeLayout = this.mForegroundView;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(getResources().getColor(com.baidu.searchbox.feed.core.R.color.feed_tab_bg_at_homepage));
        }
        AdEmbeddedTailFrameView adEmbeddedTailFrameView = this.mTailFrameView;
        if (adEmbeddedTailFrameView != null && adEmbeddedTailFrameView.getVisibility() == 0) {
            this.mTailFrameView.onNightModeChanged();
        }
    }

    /* access modifiers changed from: private */
    public void sendActionAls(Als.Page page, String type, String area) {
        Als.Builder builder = new Als.Builder();
        builder.setType(type);
        builder.setPage(page);
        if (!TextUtils.isEmpty(area)) {
            builder.setArea(area);
        }
        if (!TextUtils.isEmpty(this.mAdExtInfo)) {
            builder.setExtraParam(this.mAdExtInfo);
        }
        Als.postADRealTimeLog(builder);
    }

    /* access modifiers changed from: private */
    public void moveView(float y) {
        VideoViewHolder videoViewHolder = this.mVideoHolder;
        if (videoViewHolder != null && this.mTailFrameView != null && this.mForegroundView != null) {
            videoViewHolder.setY(y);
            this.mTailFrameView.setY(y);
            this.mForegroundView.setY(y);
        }
    }

    /* access modifiers changed from: private */
    public void handleUpAction(boolean isShowUpTargetPart) {
        if (this.mVideoHeight > 0 && this.mVideoHolder != null && this.mForegroundView != null && this.mWebViewContainer != null && this.mPlayer != null) {
            if (this.mIsShowKeyboard && isShowUpTargetPart) {
                hideInputMethod();
                this.mIsShowKeyboard = false;
            }
            moveViewWithAnim(isShowUpTargetPart);
        }
    }

    public void moveViewWithAnim(final boolean scrollDown) {
        if (this.mVideoHolder != null && this.mWebViewContainer != null && !isScrollAnimatorRunning()) {
            cancelScrollAnimator();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mScrollAnimator = ofFloat;
            ofFloat.setDuration(100);
            this.mScrollAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(scrollDown) {
                float lastAnimValue = 0.0f;
                int preWebContainerTopMargin;
                float preY;
                int scrollDistance;
                int scrollDistanceDown;
                int scrollDistanceUp;
                final /* synthetic */ boolean val$scrollDown;

                {
                    this.val$scrollDown = r4;
                    this.scrollDistanceDown = AdVideoDetailScrollActivity.this.mVideoHeight - AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin();
                    int topMargin = AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin() - AdVideoDetailScrollActivity.this.mWebViewContainer.getMinTopMargin();
                    this.scrollDistanceUp = topMargin;
                    this.scrollDistance = r4 ? this.scrollDistanceDown : topMargin;
                    this.preWebContainerTopMargin = AdVideoDetailScrollActivity.this.mWebViewContainer.getTopMargin();
                    this.preY = AdVideoDetailScrollActivity.this.mVideoHolder.getY();
                }

                public void onAnimationUpdate(ValueAnimator animation) {
                    if (AdVideoDetailScrollActivity.this.mWebViewContainer != null && animation != null) {
                        float value = ((Float) animation.getAnimatedValue()).floatValue();
                        int preScrollDistance = (int) (((float) this.scrollDistance) * (value - this.lastAnimValue));
                        if (this.val$scrollDown) {
                            preScrollDistance = -preScrollDistance;
                        }
                        this.preY -= (float) preScrollDistance;
                        this.preWebContainerTopMargin -= preScrollDistance;
                        AdVideoDetailScrollActivity.this.mWebViewContainer.scrollBy(0, preScrollDistance);
                        AdVideoDetailScrollActivity.this.mWebViewContainer.setTopMargin(this.preWebContainerTopMargin);
                        AdVideoDetailScrollActivity.this.moveView(this.preY);
                        this.lastAnimValue = value;
                    }
                }
            });
            this.mScrollAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    if (AdVideoDetailScrollActivity.this.mWebViewContainer != null) {
                        AdVideoDetailScrollActivity.this.handleScrollAnimateEnd(scrollDown);
                    }
                }
            });
            this.mScrollAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void handleScrollAnimateEnd(boolean scrollDown) {
        WebViewContainer webViewContainer = this.mWebViewContainer;
        if (webViewContainer != null && this.mPlayer != null) {
            this.mIsVideoVisible = scrollDown;
            if (scrollDown) {
                webViewContainer.scrollBy(0, -(this.mVideoHeight - webViewContainer.getTopMargin()));
                moveView(0.0f);
                this.mWebViewContainer.setTopMargin(this.mVideoHeight);
                if (!this.isUp && this.mInjectionJsSwitch) {
                    loadJavaScript("animate_move(native_ad_selected_elem,1," + DeviceUtils.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) this.mVideoHeight) + ")");
                    this.isUp = scrollDown;
                }
                if (!this.mPlayer.isPlaying()) {
                    this.mPlayer.resume();
                    this.mPlayer.goBackOrForeground(true);
                }
                if (this.mWebViewContainer.getTopMargin() >= this.mVideoHeight) {
                    this.mFloatTopBar.onHandleScrollAnimateEnd();
                }
            } else {
                webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.mWebViewContainer.getMinTopMargin());
                moveView((float) ((-this.mVideoHeight) + this.mWebViewContainer.getMinTopMargin()));
                WebViewContainer webViewContainer2 = this.mWebViewContainer;
                webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
                if (this.isUp && this.mInjectionJsSwitch) {
                    loadJavaScript("animate_move(native_ad_selected_elem,3," + DeviceUtils.ScreenInfo.px2dp(FeedRuntime.getAppContext(), (float) this.mVideoHeight) + ")");
                    this.isUp = scrollDown;
                }
                sendActionAls(Als.Page.PAGE_VIDEO_LP, Als.LogType.VIDEO_LP_VIDEO_HIDE.type, "");
                if (this.mPlayer.isPlaying()) {
                    this.mPlayer.pause();
                    this.mPlayer.goBackOrForeground(false);
                }
            }
            handlePlayerOrientationHelper();
            showFloatView(this.mIsVideoVisible, new View.OnClickListener() {
                public void onClick(View v) {
                    AdVideoDetailScrollActivity.this.handleUpAction(true);
                }
            });
        }
    }

    private boolean isScrollAnimatorRunning() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    private void cancelScrollAnimator() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void handlePlayerOrientationHelper() {
        AdShortVideoPlayer adShortVideoPlayer = this.mPlayer;
        if (adShortVideoPlayer != null) {
            if (this.mIsVideoVisible) {
                adShortVideoPlayer.enableOrientationEventHelper();
            } else {
                adShortVideoPlayer.disableOrientationEventHelper();
            }
            if (isVerticalVideo()) {
                this.mPlayer.disableOrientationEventHelper();
            }
        }
    }

    public void hideStatusBar() {
        if (!TextUtils.equals("VIVO", RomUtils.getName())) {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mFloatTopBar.onHideStatusBar();
    }

    public boolean needAppendPublicParam() {
        return false;
    }

    private int calculatePreViewProgress(int progress, int gestureViewStartTime, int gestureViewEndTime) {
        if (progress < gestureViewStartTime) {
            return progress;
        }
        return (progress + gestureViewEndTime) - gestureViewStartTime;
    }

    private void updatePreViewProgress(String id) {
        if (this.mPlayer != null && !TextUtils.isEmpty(id) && this.mPreViewGestureStartTime != 0 && this.mPreViewGestureEndTime != 0) {
            if (this.mPlayer.isComplete()) {
                FeedAdUtil.clearAiVideoViewCache(id);
            } else {
                savePreViewVideoProgress(id);
            }
        }
    }

    private void savePreViewVideoProgress(String id) {
        if (this.mPlayer != null && !TextUtils.isEmpty(id)) {
            int landingPageVideoProgress = this.mPlayer.getPosition();
            AdParamsCache.Companion.getInstance().putParam(id, AdParamsCache.PARAM_VIDEO_PRE_VIEW_PROGRESS, String.valueOf(calculatePreViewProgress(landingPageVideoProgress, this.mPreViewGestureStartTime, this.mPreViewGestureEndTime)));
            AdParamsCache.Companion.getInstance().putParam(id, AdParamsCache.PARAM_VIDEO_LANDING_PAGE_PROGRESS, String.valueOf(landingPageVideoProgress));
        }
    }
}
