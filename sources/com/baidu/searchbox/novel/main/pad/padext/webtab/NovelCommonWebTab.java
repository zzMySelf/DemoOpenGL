package com.baidu.searchbox.novel.main.pad.padext.webtab;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.lightbrowser.event.OnWebViewScrollEvent;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.common.utils.NovelUrlUtils;
import com.baidu.searchbox.novel.main.pad.fragment.NovelFragmentManager;
import com.baidu.searchbox.novel.main.tab.fragment.NovelTabInfo;
import com.baidu.searchbox.novel.main.webtab.NovelWebTabPullToRefreshView;
import com.baidu.searchbox.novel.main.webtab.SupportPullRefreshLightBrowserView;
import com.baidu.searchbox.noveladapter.browser.NovelNetworkErrorView;
import com.baidu.searchbox.noveladapter.novelinterface.INovelHomePageCallback;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import com.baidu.searchbox.story.NovelUtility;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;

public class NovelCommonWebTab extends NovelMainWebTab {
    private static final int MSG_REFERESH_STOP = 2;
    private static final int MSG_SCROLL_STOP = 1;
    private static final String PARAM_DATA = "&data=";
    private static final String PARAM_DATA_IN_URL = "data=";
    public static final String PARAM_KEY_FROM_ACTION = "fromaction";
    private static final String PARAM_SOUPPORT_SOUND = "&supportsound=";
    private static final String TAG = "NovelCommonWebTab";
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public CommonWebTabHandler mHandler;
    private boolean mHasExecuted;
    /* access modifiers changed from: private */
    public boolean mIsScrollStart = false;
    private boolean mIsShowColor;
    /* access modifiers changed from: private */
    public boolean mIsWebPageMove = false;
    private long mLastEnterTime = 0;
    /* access modifiers changed from: private */
    public NovelFragmentManager mManager;
    private boolean mNeedRefresh;
    private int mShowColor;
    /* access modifiers changed from: private */
    public NovelTabInfo mTabInfo;

    public NovelCommonWebTab(Context context) {
        super(context);
        this.mContext = context;
    }

    public NovelCommonWebTab(Context context, NovelTabInfo tabInfo) {
        super(context);
        this.mContext = context;
        this.mTabInfo = tabInfo;
        this.mShowColor = NovelNightModeUtils.getColor(R.color.NC507);
        this.mHandler = new CommonWebTabHandler(this);
    }

    public NovelCommonWebTab(Context context, NovelTabInfo tabInfo, NovelFragmentManager manager) {
        super(context);
        this.mManager = manager;
        this.mContext = context;
        this.mTabInfo = tabInfo;
        this.mShowColor = NovelNightModeUtils.getColor(R.color.NC507);
        this.mHandler = new CommonWebTabHandler(this);
    }

    public int getShowColor() {
        return this.mShowColor;
    }

    public boolean isShowDivider() {
        return this.mIsShowColor;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = super.onCreateView(inflater, container, savedInstanceState);
        setPullRefreshListener();
        return view2;
    }

    /* access modifiers changed from: protected */
    public String getLoadUrl() {
        NovelTabInfo novelTabInfo = this.mTabInfo;
        if (novelTabInfo == null || TextUtils.isEmpty(novelTabInfo.mTabUrl)) {
            return null;
        }
        return processLoadUrl(addFromActionToUrl(NovelUrlUtils.processUrl(this.mTabInfo.mTabUrl)));
    }

    private String addFromActionToUrl(String url) {
        String fromAction;
        if (TextUtils.isEmpty(url) || url.indexOf(PARAM_DATA_IN_URL) != -1) {
            return url;
        }
        JSONObject postData = new JSONObject();
        String postDataValue = "";
        try {
            NovelFragmentManager novelFragmentManager = this.mManager;
            if (novelFragmentManager == null || !novelFragmentManager.isBottomBar()) {
                fromAction = "feedtabnovel_new";
            } else {
                fromAction = "feedtabnovel_bar_youngversion";
            }
            postData.put("fromaction", fromAction);
            postDataValue = URLEncoder.encode(postData.toString(), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return url + (PARAM_DATA + postDataValue) + "&supportsound=1";
    }

    private String processLoadUrl(String loadUrl) {
        Object value;
        if (TextUtils.isEmpty(this.urlParams)) {
            return loadUrl;
        }
        try {
            JSONObject jsonObject = new JSONObject(this.urlParams);
            Iterator<String> keys = jsonObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String key = keys.next();
                    if (!TextUtils.isEmpty(key) && (value = jsonObject.opt(key)) != null) {
                        loadUrl = NovelUrlUtils.addParam(loadUrl, key, String.valueOf(value));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return loadUrl;
    }

    /* access modifiers changed from: protected */
    public String generateUBCNameValue() {
        NovelTabInfo novelTabInfo = this.mTabInfo;
        if (novelTabInfo == null || TextUtils.isEmpty(novelTabInfo.mTabName)) {
            return null;
        }
        return NovelUtility.getUBCArgs(this.mTabInfo.mTabName, "", this.mTabInfo.mTabName);
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        if (this.mIsShowColor) {
            this.mShowColor = NovelNightModeUtils.getColor(R.color.NC507);
        } else {
            this.mShowColor = NovelNightModeUtils.getColor(R.color.NC507);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mTabSelected) {
            informTabShow(true);
        }
    }

    public void onPause() {
        super.onPause();
        NovelTabInfo novelTabInfo = this.mTabInfo;
        if (novelTabInfo != null && TextUtils.equals("1006", novelTabInfo.mTabId)) {
            this.mNeedRefresh = true;
        }
        if (this.mTabSelected) {
            informTabShow(false);
        }
    }

    public void onRefresh(boolean isShowRefreshAnimation) {
        super.onRefresh(isShowRefreshAnimation);
        if (isShowRefreshAnimation) {
            scrollToTop();
            autoPullToRefresh();
            return;
        }
        scrollToTop();
        if (!NetWorkUtils.isNetworkConnected(this.mContext)) {
            UniversalToast.makeText(this.mContext, R.string.novel_common_net_error).showToast();
        } else {
            refreshToWebPage();
        }
    }

    public void onScrollToTop() {
        super.onScrollToTop();
        scrollToTop();
    }

    public void onTabSelected() {
        super.onTabSelected();
        informTabShow(true);
        if (this.needReload || this.mNeedRefresh) {
            refreshUrl();
            this.needReload = false;
            this.mNeedRefresh = false;
        }
    }

    private void refreshUrl() {
        String loadUrl = getLoadUrl();
        boolean reload = this.needReload && !TextUtils.equals(this.mCurrentRequestUrl, loadUrl);
        if (reload || this.mNeedRefresh) {
            this.mCurrentRequestUrl = loadUrl;
            refreshWebPage(reload);
        }
    }

    public void onTabUnSelected() {
        super.onTabUnSelected();
        informTabShow(false);
    }

    private void setPullRefreshListener() {
        if (this.mSupportPullReFreshView != null && this.mTabInfo != null) {
            this.mSupportPullReFreshView.setPullRefreshEnabled(this.mTabInfo.canPullRefresh);
            this.mSupportPullReFreshView.setPullRefreshUnable(this.mTabInfo.canPullRefresh);
            this.mSupportPullReFreshView.setOnRefreshListener(new SupportPullRefreshLightBrowserView.OnRefreshListener() {
                public void onPullUpToRefresh() {
                    INovelHomePageCallback homePageCallback;
                    if (NovelCommonWebTab.this.mManager != null && (homePageCallback = NovelCommonWebTab.this.mManager.getHomePageCallback()) != null) {
                        homePageCallback.onStartRefresh(false);
                    }
                }

                public void onPullDownToRefresh() {
                    INovelHomePageCallback homePageCallback;
                    if (!NetWorkUtils.isNetworkConnected(NovelCommonWebTab.this.mContext)) {
                        UniversalToast.makeText(NovelCommonWebTab.this.mContext, R.string.novel_common_net_error).showToast();
                        NovelCommonWebTab.this.stopPullRefresh(false);
                        return;
                    }
                    NovelCommonWebTab.this.mHandler.sendEmptyMessageDelayed(2, 5000);
                    NovelCommonWebTab.this.refreshToWebPage();
                    if (NovelCommonWebTab.this.mManager != null && (homePageCallback = NovelCommonWebTab.this.mManager.getHomePageCallback()) != null) {
                        homePageCallback.onStartRefresh(false);
                    }
                }
            });
            initScrollListener();
        }
    }

    private void initScrollListener() {
        NovelWebTabPullToRefreshView refreshView = this.mSupportPullReFreshView.getNovelWebTabPullToRefreshView();
        if (refreshView != null) {
            refreshView.setOnScrollListener(new NovelWebTabPullToRefreshView.NovelPullToRefreshScrollListener() {
                public void onActionUp() {
                    if (NovelCommonWebTab.this.mHandler != null && NovelCommonWebTab.this.mIsScrollStart) {
                        NovelCommonWebTab.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                        boolean unused = NovelCommonWebTab.this.mIsScrollStart = false;
                    }
                }

                public void onActionMove() {
                }
            });
        }
        LightBrowserView lightBrowserView = this.mSupportPullReFreshView.getLightBrowserView();
        if (lightBrowserView != null) {
            lightBrowserView.addScrollEvent(new OnWebViewScrollEvent() {
                public void onScrollOffset(int offset) {
                    super.onScrollOffset(offset);
                    boolean unused = NovelCommonWebTab.this.mIsWebPageMove = offset != 0;
                }

                public void onScrollToBottom(int velocity) {
                    super.onScrollToBottom(velocity);
                    boolean unused = NovelCommonWebTab.this.mIsWebPageMove = false;
                }
            });
        }
    }

    private static class CommonWebTabHandler extends Handler {
        WeakReference<NovelCommonWebTab> reference;

        public CommonWebTabHandler(NovelCommonWebTab tab) {
            this.reference = new WeakReference<>(tab);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final NovelCommonWebTab commonWebTab = (NovelCommonWebTab) this.reference.get();
            if (commonWebTab != null) {
                switch (msg.what) {
                    case 2:
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            public void run() {
                                commonWebTab.stopPullRefresh(false);
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void refreshToWebPage() {
        if (this.mNovelInterface == null || TextUtils.isEmpty(this.mNovelInterface.getPullToRefreshCallback())) {
            resetWebViewStatus();
            ExecutorUtilsExt.delayPostOnElastic(new Runnable() {
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            NovelCommonWebTab.this.stopPullRefresh(true);
                        }
                    });
                }
            }, "RefreshWebPage", 1, 500);
            return;
        }
        invokeJsCallback(this.mNovelInterface.getPullToRefreshCallback(), "");
    }

    private void setWebViewScrollEventListener() {
        if (this.mWebViewLayout != null && this.mPullRefreshView != null) {
            this.mWebViewLayout.addScrollEvent(new OnWebViewScrollEvent() {
                public void onScrollOffset(int offset) {
                    if (NovelCommonWebTab.this.mTabInfo != null) {
                        NovelCommonWebTab.this.mPullRefreshView.setPullRefreshEnabled(NovelCommonWebTab.this.mTabInfo.canPullRefresh && offset <= 0);
                    }
                }

                public void onScrollToBottom(int velocity) {
                }
            });
        }
    }

    public void stopPullRefresh(boolean showSuccessTip) {
        String tip = this.mContext.getResources().getString(R.string.novel_recommend_refresh_tip);
        if (this.mPullRefreshView != null) {
            this.mPullRefreshView.onPullDownRefreshComplete(showSuccessTip, tip);
        }
    }

    public void setPullRefreshEnable(boolean enable) {
        if (this.mPullRefreshView != null && this.mTabInfo != null) {
            this.mPullRefreshView.setPullRefreshEnabled(enable && this.mTabInfo.canPullRefresh);
        }
    }

    public void autoPullToRefresh() {
        if (this.mPullRefreshView != null && this.isEnablePullRefresh) {
            this.mPullRefreshView.doPullRefreshing(true, 0);
        }
    }

    public boolean hasRefreshAbility() {
        return isRecommendTab();
    }

    private boolean isRecommendTab() {
        NovelTabInfo novelTabInfo = this.mTabInfo;
        if (novelTabInfo != null) {
            return "2".equals(novelTabInfo.mTabId);
        }
        return false;
    }

    private void scrollToTop() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NovelCommonWebTab.this.mWebViewLayout != null) {
                    NovelCommonWebTab.this.mWebViewLayout.scrollWebViewTo(0, 0);
                }
            }
        }, 100);
    }

    private void refreshWebPage(boolean reload) {
        if (reload || this.mNovelInterface == null || TextUtils.isEmpty(this.mNovelInterface.getPullToRefreshCallback())) {
            resetWebViewStatus();
            ExecutorUtilsExt.delayPostOnElastic(new Runnable() {
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            NovelCommonWebTab.this.stopPullRefresh(true);
                        }
                    });
                }
            }, "RefreshWebPage", 1, 500);
            return;
        }
        invokeJsCallback(this.mNovelInterface.getPullToRefreshCallback(), "");
    }

    /* access modifiers changed from: protected */
    public View initErrorView() {
        NovelNetworkErrorView errorView = new NovelNetworkErrorView(getContext());
        errorView.setTextButtonClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (NetWorkUtils.isNetworkConnected(NovelCommonWebTab.this.mContext)) {
                    NovelCommonWebTab.this.resetWebViewStatus();
                }
            }
        });
        return errorView;
    }

    public void notifyPullToRefreshFinished(String result) {
        this.mHandler.removeMessages(2);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                NovelCommonWebTab.this.stopPullRefresh(true);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        CommonWebTabHandler commonWebTabHandler = this.mHandler;
        if (commonWebTabHandler != null) {
            commonWebTabHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
