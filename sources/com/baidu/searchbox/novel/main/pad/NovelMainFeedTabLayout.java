package com.baidu.searchbox.novel.main.pad;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.alipay.sdk.m.u.i;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.discovery.novel.utils.NovelAccountUtils;
import com.baidu.searchbox.environment.dinovel.NovelMainFeedViewManagerPad;
import com.baidu.searchbox.environment.dinovel.pluginentrance.IPluginLoadCallback;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.newhome.HomeV1TabViewRefreshType;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.common.utils.NovelPadUtilsWrapper;
import com.baidu.searchbox.novel.granary.data.source.local.core.NovelSpManager;
import com.baidu.searchbox.novel.main.NovelSearchBoxController;
import com.baidu.searchbox.novel.main.pad.fragment.NovelBaseFragment;
import com.baidu.searchbox.novel.main.pad.fragment.NovelFragmentManager;
import com.baidu.searchbox.novel.main.pad.fragment.NovelWebFragment;
import com.baidu.searchbox.novel.main.pad.listener.INovelOnGetLastReadBookListener;
import com.baidu.searchbox.novel.main.pad.view.NovelReadTipsView;
import com.baidu.searchbox.novel.main.webtab.IScrollEvent;
import com.baidu.searchbox.novel.main.webtab.IScrollEventListener;
import com.baidu.searchbox.novel.stat.ubc.NovelCustomUbc;
import com.baidu.searchbox.novel.stat.ubc.NovelUbcStatUtils;
import com.baidu.searchbox.novel.view.NovelBubbleManager;
import com.baidu.searchbox.noveladapter.account.NovelBoxAccountManagerWrapper;
import com.baidu.searchbox.noveladapter.concurrent.NovelUiThreadUtilWrapper;
import com.baidu.searchbox.noveladapter.elasticthread.NovelExecutorUtilsExt;
import com.baidu.searchbox.noveladapter.eventbus.ContainerEventRegister;
import com.baidu.searchbox.noveladapter.eventbus.INovelAction1;
import com.baidu.searchbox.noveladapter.feed.tab.NovelFeedNavigationAdapter;
import com.baidu.searchbox.noveladapter.feed.tab.NovelMultiTabItemInfo;
import com.baidu.searchbox.noveladapter.feed.tab.NovelSlidingTabLayout;
import com.baidu.searchbox.noveladapter.feed.tab.NovelSlidingTabStrip;
import com.baidu.searchbox.noveladapter.feedcore.NovelTabViewPager;
import com.baidu.searchbox.noveladapter.novelcore.IExternalForward;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.noveladapter.skin.INovelNightModeChangeListener;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeHelperWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import com.baidu.searchbox.nps.PluginInvokeManager;
import com.baidu.searchbox.story.NovelSharedPrefHelper;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NovelMainFeedTabLayout extends RelativeLayout implements View.OnClickListener, INovelNightModeChangeListener, INovelOnGetLastReadBookListener {
    private static final String BOY = "boy";
    private static final String CATEGORY = "category";
    private static final String GIRL = "girl";
    private static final String LAST_UPLOAD_BOOK_COUNT = "last_upload_book_count";
    private static final String LISTEN = "listen";
    private static final int READ_SHELF_BOOK_LIMIT_DAY = 3;
    private static final String RECOMMEND = "recommend";
    private static final int SCROLL_OFFSET_LIMIT_VALUE = 50;
    private static final int SELECT_DEFAULT_FEED_TAB_INDEX = 1;
    private static final int SELECT_SHELF_TAB_INDEX = 0;
    private static final String SHELF = "shelf";
    private static final String SHORT = "short";
    private static final String SP_KEY = "sp_key_shelf_tips_is_show";
    private static final String SP_KEY_RECOMMEND_NEW_TIP = "sp_key_recommend_new_tip";
    private static final String SP_KEY_RECOMMEND_TIPS_TIMESTAMP = "sp_key_recommend_tips_timestamp";
    private static final String SP_NAME = "sp_name_shelf_tips";
    private static final String TAG = "NovelMainFeedTabLayout";
    private static final String USER_CENTER_SCHEME = "baiduboxapp://novel/openNovelTab?param=";
    /* access modifiers changed from: private */
    public NovelFeedNavigationAdapter adapter;
    /* access modifiers changed from: private */
    public NovelBubbleManager bubbleManager = null;
    /* access modifiers changed from: private */
    public int currentUserStatus = 0;
    private final Object eventTag = new Object();
    private int forceSelectedIndex = -1;
    /* access modifiers changed from: private */
    public boolean isAbTestOpen = false;
    private LoginStateListener loginStateListener;
    private Activity mActivity;
    private FrameLayout mFlUserInfo;
    private FragmentManager mFragmentManager;
    /* access modifiers changed from: private */
    public final NovelFragmentManager mManager;
    /* access modifiers changed from: private */
    public NovelReadTipsView mNovelReadTipsView;
    private SimpleDraweeView mNovelTabUserIcon;
    private LinearLayout mNovleContainer;
    private View mPadLeftTabView;
    private NovelSearchBoxController mSearchBoxController;
    private FrameLayout mSearchViewContainer;
    private NovelSlidingTabLayout mSlidingTabLayout;
    private RelativeLayout mTabLayout;
    /* access modifiers changed from: private */
    public NovelTabViewPager mViewPager;
    /* access modifiers changed from: private */
    public boolean needRefreshable = true;
    private IScrollEventListener scrollEventListener;
    private boolean scrolled;
    private View searchBoxView = null;
    private NovelSlidingTabConfig slidingTabConfig;

    public NovelMainFeedTabLayout(Activity activity, FragmentManager fragmentManager, NovelFragmentManager manager) {
        super(activity);
        this.mManager = manager;
        this.mActivity = activity;
        this.mFragmentManager = fragmentManager;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.novel_main_top_feedtab_pad, this, true);
        this.mPadLeftTabView = findViewById(R.id.novel_pad_left_view);
        this.mTabLayout = (RelativeLayout) findViewById(R.id.tab_layout);
        this.mSlidingTabLayout = (NovelSlidingTabLayout) findViewById(R.id.novel_tab_layout);
        this.mSearchViewContainer = (FrameLayout) findViewById(R.id.novel_tab_search_view_container);
        this.mViewPager = (NovelTabViewPager) findViewById(R.id.novel_viewpager);
        this.mFlUserInfo = (FrameLayout) findViewById(R.id.fl_user_info);
        this.mNovelTabUserIcon = (SimpleDraweeView) findViewById(R.id.novel_tab_user_icon);
        this.mNovelReadTipsView = (NovelReadTipsView) findViewById(R.id.novel_read_tips_view);
        this.mNovleContainer = (LinearLayout) findViewById(R.id.novle_pad_container);
        this.mFlUserInfo.setOnClickListener(this);
        initView();
        setPadLeftTabWidth();
        onFontSizeChanged();
        showRereadTips("");
        registerSearchBoxEvent();
    }

    private void initView() {
        NovelTabViewPager novelTabViewPager = this.mViewPager;
        if (novelTabViewPager != null) {
            if (this.mManager != null) {
                novelTabViewPager.setAllowedSwipeDirection(NovelTabViewPager.NovelSwipeDirection.ALL);
            }
            this.mViewPager.setAdapter(getViewPagerAdapter());
        }
        initSlidingTabLayout();
        refreshAvatar();
        initSearchView();
        onSelectFeedTabIndex(oldSelect());
        setLeftTabBackground();
        checkPluginData();
    }

    private int oldSelect() {
        int selectFeedTabIndex = 1;
        long shelfBookReadTime = NovelSharedPrefHelper.getShelfBookReadTime();
        if (NovelSharedPrefHelper.needNextSelectShelfTab() || isReadShelfBookInNDays(shelfBookReadTime)) {
            selectFeedTabIndex = 0;
        }
        long saveTime = NovelSharedPrefHelper.getSelectFeedTabIndexTime();
        if (saveTime > 0 && DateTimeUtils.isSameDay(saveTime, System.currentTimeMillis())) {
            selectFeedTabIndex = NovelSharedPrefHelper.getSelectFeedTabIndex();
        }
        int i2 = this.forceSelectedIndex;
        if (i2 == -1 || i2 == selectFeedTabIndex) {
            return selectFeedTabIndex;
        }
        int selectFeedTabIndex2 = this.forceSelectedIndex;
        NovelSharedPrefHelper.saveSelectFeedTabIndex(selectFeedTabIndex2);
        this.forceSelectedIndex = -1;
        return selectFeedTabIndex2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setPadLeftTabWidth();
        updateSearchView();
    }

    private void setPadLeftTabWidth() {
        View view2 = this.mPadLeftTabView;
        if (view2 != null) {
            ViewGroup.LayoutParams params = view2.getLayoutParams();
            if (NovelPadUtilsWrapper.isPadHorizontal((Activity) null)) {
                params.width = DeviceUtil.ScreenInfo.dp2px(getContext(), 80.0f);
            } else {
                params.width = DeviceUtil.ScreenInfo.dp2px(getContext(), 70.0f);
            }
            this.mPadLeftTabView.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: private */
    public void onSelectFeedTabIndex(final int selectFeedTabIndex) {
        NovelUiThreadUtilWrapper.runOnUiThread(new Runnable() {
            public void run() {
                int i2;
                if (NovelMainFeedTabLayout.this.mViewPager != null) {
                    NovelMainFeedTabLayout.this.mViewPager.setCurrentItem(selectFeedTabIndex);
                    List<MultiTabItemInfo> itemInfos = NovelMainTabDataHelper.getInstance().getTabItemInfos();
                    if (itemInfos != null && (i2 = selectFeedTabIndex) >= 0 && i2 < itemInfos.size()) {
                        MultiTabItemInfo multiTabItemInfo = itemInfos.get(selectFeedTabIndex);
                        if (NovelMainFeedTabLayout.this.mManager != null && (multiTabItemInfo instanceof NovelMultiTabItemInfo)) {
                            NovelMainFeedTabLayout.this.mManager.onTabSelected((NovelMultiTabItemInfo) multiTabItemInfo);
                        }
                    }
                    if (NovelPadUtilsWrapper.isInPadMode()) {
                        NovelMainFeedTabLayout.this.mViewPager.setOffscreenPageLimit(5);
                    } else {
                        NovelMainFeedTabLayout.this.mViewPager.setOffscreenPageLimit(0);
                    }
                }
            }
        });
    }

    private boolean isReadShelfBookInNDays(long shelfBookReadTime) {
        return shelfBookReadTime > 0 && DateTimeUtils.isFewDaysAgo(shelfBookReadTime, 3);
    }

    private void registerFontSizeChangeMessage() {
        ContainerEventRegister.registerFontSizeChangeEvent(toString(), new ContainerEventRegister.NovelFontSizeMessageEventCallback() {
            public void call(int messageId, Object messageContent) {
                NovelMainFeedTabLayout.this.onFontSizeChanged();
            }
        });
    }

    private void unRegisterFontSizeChangeMessage() {
        ContainerEventRegister.unRegisterFontSizeChangeEvent(toString());
    }

    private void registerLoginStateListener() {
        new NovelBoxAccountManagerWrapper().addLoginStatusChangedListener(getLoginStateListener());
    }

    private void unRegisterLoginStateListener() {
        new NovelBoxAccountManagerWrapper().removeLoginStatusChangedListener(getLoginStateListener());
    }

    /* access modifiers changed from: private */
    public void refreshAvatar() {
        BoxAccount boxAccount = NovelAccountUtils.getBoxAccount(getContext());
        if (boxAccount == null) {
            this.mNovelTabUserIcon.setImageDrawable(NovelNightModeUtils.getDrawable(R.drawable.novel_default_user_icon));
        } else if (!TextUtils.isEmpty(boxAccount.getPortrait())) {
            this.mNovelTabUserIcon.setImageURI(boxAccount.getPortrait());
        }
    }

    private void initSlidingTabLayout() {
        if (this.mSlidingTabLayout != null) {
            NovelSlidingTabConfig novelSlidingTabConfig = new NovelSlidingTabConfig();
            this.slidingTabConfig = novelSlidingTabConfig;
            this.mSlidingTabLayout.setSlidingTabConfig(novelSlidingTabConfig);
            this.mSlidingTabLayout.setTabDistance((int) getResources().getDimension(R.dimen.novel_dimens_4dp));
            this.mSlidingTabLayout.setFirstTabMarginLeft((int) getResources().getDimension(R.dimen.novel_dimens_9dp));
            this.mSlidingTabLayout.setViewPager(this.mViewPager);
            this.mSlidingTabLayout.addOnPageChangeListener(new NovelSlidingTabLayout.OnTabChangeListener() {
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels, boolean isUserDrag) {
                }

                public void onPageSelected(int position, NovelMultiTabItemInfo itemInfo) {
                    if (NovelMainFeedTabLayout.this.mManager != null) {
                        NovelMainFeedTabLayout.this.mManager.onTabSelected(itemInfo);
                    }
                    NovelSharedPrefHelper.saveSelectFeedTabIndex(position);
                    NovelSharedPrefHelper.saveSelectFeedTabIndexTime(System.currentTimeMillis());
                    if (itemInfo != null) {
                        Object service = ServiceManager.getService(INewHomeApi.SERVICE_REFERENCE);
                        if (service instanceof INewHomeApi) {
                            ((INewHomeApi) service).setContentFloatRefreshVisible("32", itemInfo.canPullRefresh);
                        }
                        boolean unused = NovelMainFeedTabLayout.this.needRefreshable = itemInfo.canPullRefresh;
                    }
                    if (NovelMainFeedTabLayout.this.adapter != null) {
                        Fragment fragment = NovelMainFeedTabLayout.this.adapter.getFragmentByPosition(position);
                        if (fragment instanceof IScrollEvent) {
                            int scrollOffset = ((IScrollEvent) fragment).getScrollOffset();
                            ((IScrollEvent) fragment).setScrollOffsetEvent(NovelMainFeedTabLayout.this.getScrollOffsetEventListener());
                            NovelMainFeedTabLayout.this.updateTabBackGround(scrollOffset);
                        }
                    }
                    if (itemInfo != null) {
                        String source = NovelMainFeedTabLayout.this.getTabUbcSource(itemInfo.mId);
                        if (!TextUtils.isEmpty(source)) {
                            NovelUbcStatUtils.ubc5958("novel", "click", NovelCustomUbc.Page.PAGE_FEEDTABNOVEL_NEW_OVERALL, source, NovelMainFeedTabLayout.this.getFromActionForSta(), new JSONObject());
                        }
                    }
                }
            });
        }
    }

    private void initSearchView() {
        if (this.mSearchViewContainer != null && this.mActivity != null) {
            NovelSearchBoxController novelSearchBoxController = new NovelSearchBoxController();
            this.mSearchBoxController = novelSearchBoxController;
            novelSearchBoxController.setIsBottomTab(true);
            View searchBoxView2 = this.mSearchBoxController.getSearchBoxView(this.mActivity);
            this.searchBoxView = searchBoxView2;
            if (searchBoxView2 != null) {
                this.mSearchViewContainer.addView(this.searchBoxView, new RelativeLayout.LayoutParams(getSearchViewWidthPX(), -1));
            }
        }
    }

    public void updateSearchView() {
        FrameLayout frameLayout;
        View view2;
        if (NovelPadUtilsWrapper.isInPadMode() && (frameLayout = this.mSearchViewContainer) != null && this.mActivity != null && this.mSearchBoxController != null && (view2 = this.searchBoxView) != null) {
            frameLayout.removeView(view2);
            this.searchBoxView = this.mSearchBoxController.getSearchBoxView(this.mActivity);
            this.mSearchViewContainer.addView(this.searchBoxView, new RelativeLayout.LayoutParams(getSearchViewWidthPX(), -1));
            NovelSearchBoxController novelSearchBoxController = this.mSearchBoxController;
            if (novelSearchBoxController != null) {
                novelSearchBoxController.changeToPadSearchBtnStyle();
            }
        }
    }

    /* access modifiers changed from: private */
    public String getFromActionForSta() {
        return "feedtabnovel_new";
    }

    /* access modifiers changed from: private */
    public String getTabUbcSource(String tabId) {
        if ("1007".equals(tabId)) {
            return "select";
        }
        if ("1001".equals(tabId)) {
            return "boy";
        }
        if ("1002".equals(tabId)) {
            return "girl";
        }
        if ("1013".equals(tabId)) {
            return NovelCustomUbc.Source.SOURCE_YOUNG_TAB_STORY;
        }
        if ("1009".equals(tabId)) {
            return "category";
        }
        if ("1000".equals(tabId)) {
            return "shelf";
        }
        if ("1011".equals(tabId)) {
            return "listen";
        }
        return "";
    }

    /* access modifiers changed from: private */
    public IScrollEventListener getScrollOffsetEventListener() {
        if (this.scrollEventListener == null) {
            this.scrollEventListener = new IScrollEventListener() {
                public void onScrollOffset(int offset) {
                    NovelMainFeedTabLayout.this.updateTabBackGround(offset);
                }
            };
        }
        return this.scrollEventListener;
    }

    /* access modifiers changed from: private */
    public void updateTabBackGround(int scrollOffset) {
        if (scrollOffset >= 50) {
            this.scrolled = true;
        } else {
            this.scrolled = false;
        }
    }

    private PagerAdapter getViewPagerAdapter() {
        NovelFeedNavigationAdapter novelFeedNavigationAdapter = new NovelFeedNavigationAdapter(getFragmentManager(), this.mViewPager, new NovelFeedNavigationAdapter.IFragmentMaker() {
            public Fragment makeFragment(NovelMultiTabItemInfo multiTabItemInfo, Bundle bundle) {
                return NovelMainFeedTabLayout.this.getFragment(multiTabItemInfo);
            }
        });
        this.adapter = novelFeedNavigationAdapter;
        novelFeedNavigationAdapter.setTabInfos(NovelMainTabDataHelper.getInstance().getTabItemInfos());
        return this.adapter;
    }

    /* access modifiers changed from: private */
    public Fragment getFragment(NovelMultiTabItemInfo multiTabItemInfo) {
        Fragment fragment = null;
        NovelFragmentManager novelFragmentManager = this.mManager;
        if (novelFragmentManager != null) {
            fragment = novelFragmentManager.getFragment(this.mActivity, multiTabItemInfo);
        }
        if (fragment instanceof IScrollEvent) {
            ((IScrollEvent) fragment).setScrollOffsetEvent(getScrollOffsetEventListener());
            updateTabBackGround(((IScrollEvent) fragment).getScrollOffset());
        }
        return fragment;
    }

    private FragmentManager getFragmentManager() {
        Activity topActivity;
        if (this.mFragmentManager != null || (topActivity = BdBoxActivityManager.getRealTopActivity()) == null || !(topActivity instanceof FragmentActivity)) {
            return this.mFragmentManager;
        }
        return ((FragmentActivity) topActivity).getSupportFragmentManager();
    }

    public void onClick(View v) {
        if (v == this.mFlUserInfo) {
            Router.invoke(getContext(), makeUserCenterScheme());
            NovelUbcStatUtils.ubc5958("novel", "click", NovelCustomUbc.Page.PAGE_FEEDTABNOVEL_NEW_OVERALL, "center", getFromActionForSta(), new JSONObject());
        }
    }

    public void setSearchViewOnContentRefresh(String tabId, HomeV1TabViewRefreshType refreshType, String ext) {
        NovelSearchBoxController novelSearchBoxController = this.mSearchBoxController;
        if (novelSearchBoxController != null) {
            novelSearchBoxController.onContentRefresh(tabId, refreshType, ext);
        }
    }

    public void refreshReadTips() {
        NovelMainFeedViewManagerPad.getInstance().reqeustReadBookInfo((NovelFragmentManager) null, this);
    }

    public void onGetLastReadBook(JSONObject bookInfoObj) {
        if (bookInfoObj == null) {
            hideReadTipsView();
            return;
        }
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            novelReadTipsView.showTips(bookInfoObj, false);
        }
    }

    public void hideReadTipsView() {
        if (this.mNovelReadTipsView != null) {
            NovelUiThreadUtilWrapper.runOnUiThread(new Runnable() {
                public void run() {
                    NovelMainFeedTabLayout.this.mNovelReadTipsView.hideTips(false, true);
                }
            });
        }
    }

    public boolean isReadTipsViewShow() {
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            return novelReadTipsView.isShow();
        }
        return false;
    }

    public void refreshCurrentTab() {
        NovelFeedNavigationAdapter novelFeedNavigationAdapter;
        NovelTabViewPager novelTabViewPager = this.mViewPager;
        if (novelTabViewPager != null && (novelFeedNavigationAdapter = this.adapter) != null) {
            Fragment fragmentByPosition = novelFeedNavigationAdapter.getFragmentByPosition(novelTabViewPager.getCurrentItem());
            if (fragmentByPosition instanceof NovelBaseFragment) {
                boolean canRefresh = true;
                NovelFragmentManager novelFragmentManager = this.mManager;
                if (novelFragmentManager != null) {
                    NovelMultiTabItemInfo info = novelFragmentManager.getSelectedItemInfo();
                    canRefresh = info != null && info.canPullRefresh;
                }
                if (canRefresh) {
                    ((NovelBaseFragment) fragmentByPosition).refresh();
                }
            }
        }
    }

    public void requestCurrentFragmentDisallowOnIntercept(boolean enable) {
        NovelTabViewPager novelTabViewPager = this.mViewPager;
        if (novelTabViewPager != null && this.adapter != null) {
            novelTabViewPager.requestDisallowInterceptTouchEvent(enable);
            Fragment current = this.adapter.getFragmentByPosition(this.mViewPager.getCurrentItem());
            if (current != null && (current instanceof NovelWebFragment)) {
                ((NovelWebFragment) current).setPullRefreshEnable(!enable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onNightModeChanged(NovelNightModeUtils.isNightMode());
        NovelNightModeHelperWrapper.subscribeNightModeChangeEvent(TAG, this);
        registerFontSizeChangeMessage();
        registerLoginStateListener();
    }

    public void showRereadTips(String original) {
        if (TextUtils.isEmpty(original)) {
            refreshReadTips();
        } else if (!"feedtabnovel_new".equals(original)) {
            refreshReadTips();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NovelNightModeHelperWrapper.unsubscribeNightModeChangedEvent(TAG);
        unRegisterFontSizeChangeMessage();
        unRegisterLoginStateListener();
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            novelReadTipsView.hideTips(false, true);
        }
    }

    private void setLeftTabBackground() {
        if (this.mPadLeftTabView != null) {
            this.mPadLeftTabView.setBackgroundColor(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC12));
        }
        if (this.mNovleContainer != null) {
            this.mNovleContainer.setBackgroundColor(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC12));
        }
    }

    public void onNightModeChanged(boolean isNight) {
        NovelSlidingTabConfig novelSlidingTabConfig;
        setLeftTabBackground();
        NovelSearchBoxController novelSearchBoxController = this.mSearchBoxController;
        if (novelSearchBoxController != null) {
            novelSearchBoxController.onNightModeChanged(isNight);
        }
        if (!(this.mSlidingTabLayout == null || (novelSlidingTabConfig = this.slidingTabConfig) == null)) {
            novelSlidingTabConfig.setNight(NovelNightModeHelperWrapper.getNightModeSwitcherState());
            this.mSlidingTabLayout.setSlidingTabConfig(this.slidingTabConfig);
            this.mSlidingTabLayout.updateUi();
        }
        refreshAvatar();
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            novelReadTipsView.onNightModeChanged(isNight);
        }
    }

    public void onFontSizeChanged() {
        NovelSlidingTabConfig novelSlidingTabConfig;
        NovelSlidingTabLayout novelSlidingTabLayout = this.mSlidingTabLayout;
        if (!(novelSlidingTabLayout == null || (novelSlidingTabConfig = this.slidingTabConfig) == null)) {
            novelSlidingTabLayout.setSlidingTabConfig(novelSlidingTabConfig);
            this.mSlidingTabLayout.updateUi();
        }
        NovelSearchBoxController novelSearchBoxController = this.mSearchBoxController;
        if (novelSearchBoxController != null) {
            novelSearchBoxController.onFontSizeChanged();
        }
        RelativeLayout relativeLayout = this.mTabLayout;
        if (relativeLayout != null) {
            NovelFontSizeSettingsWrapper.setScaledViewHeightRes(relativeLayout, R.dimen.novel_dimens_41dp);
        }
        FrameLayout frameLayout = this.mFlUserInfo;
        if (frameLayout != null) {
            NovelFontSizeSettingsWrapper.setScaledViewHeightRes(frameLayout, R.dimen.novel_dimens_41dp);
        }
        SimpleDraweeView simpleDraweeView = this.mNovelTabUserIcon;
        if (simpleDraweeView != null) {
            NovelFontSizeSettingsWrapper.setScaledViewSizeRes(simpleDraweeView, R.dimen.novel_dimens_19dp, R.dimen.novel_dimens_19dp);
        }
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            novelReadTipsView.onFontSizeChanged();
        }
    }

    public void stopPullRefresh() {
        NovelFeedNavigationAdapter novelFeedNavigationAdapter;
        Fragment current;
        NovelTabViewPager novelTabViewPager = this.mViewPager;
        if (novelTabViewPager != null && (novelFeedNavigationAdapter = this.adapter) != null && (current = novelFeedNavigationAdapter.getFragmentByPosition(novelTabViewPager.getCurrentItem())) != null && (current instanceof NovelWebFragment)) {
            ((NovelWebFragment) current).stopPullRefresh();
        }
    }

    public void ondestroy() {
        NovelFragmentManager novelFragmentManager = this.mManager;
        if (novelFragmentManager != null) {
            novelFragmentManager.onDestroy();
        }
        NovelSearchBoxController novelSearchBoxController = this.mSearchBoxController;
        if (novelSearchBoxController != null) {
            novelSearchBoxController.onDestroy();
        }
        registerLoginStateListener();
        unRegisterSearchBoxEvent();
    }

    private LoginStateListener getLoginStateListener() {
        if (this.loginStateListener == null) {
            this.loginStateListener = new LoginStateListener(this);
        }
        return this.loginStateListener;
    }

    public boolean needFloatBtnRefresh() {
        if (!this.needRefreshable || !isReadTipsViewShow()) {
            return this.needRefreshable;
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        NovelBubbleManager novelBubbleManager = this.bubbleManager;
        if (novelBubbleManager != null && !novelBubbleManager.isDismissed()) {
            this.bubbleManager.dismissBubble();
        }
        boolean handle = super.dispatchTouchEvent(ev);
        NovelReadTipsView novelReadTipsView = this.mNovelReadTipsView;
        if (novelReadTipsView != null) {
            novelReadTipsView.updateOnTouchEvent();
        }
        return handle;
    }

    /* access modifiers changed from: private */
    public void onAbTest(final int userStatus, int selectFeedTabIndex) {
        NovelUiThreadUtilWrapper.runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = NovelMainFeedTabLayout.this.isAbTestOpen = true;
                int unused2 = NovelMainFeedTabLayout.this.currentUserStatus = userStatus;
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r5 = r4.get(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showRecommendTabNewTipIfNeed(int r8) {
        /*
            r7 = this;
            boolean r0 = r7.isAbTestOpen
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            java.lang.String r1 = "sp_name_shelf_tips"
            com.baidu.searchbox.novel.granary.data.source.local.core.NovelSpManager r1 = com.baidu.searchbox.novel.granary.data.source.local.core.NovelSpManager.getI(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.String r4 = "sp_key_recommend_new_tip"
            boolean r5 = r1.getBoolean(r4, r2)
            if (r5 != 0) goto L_0x0021
            if (r8 != r3) goto L_0x0020
            r1.putBoolean(r4, r3)
            goto L_0x0021
        L_0x0020:
            r0 = 1
        L_0x0021:
            com.baidu.searchbox.noveladapter.feed.tab.NovelSlidingTabLayout r4 = r7.mSlidingTabLayout
            if (r4 == 0) goto L_0x0051
            com.baidu.searchbox.novel.main.pad.NovelMainTabDataHelper r4 = com.baidu.searchbox.novel.main.pad.NovelMainTabDataHelper.getInstance()
            java.util.List r4 = r4.getTabItemInfos()
            if (r4 == 0) goto L_0x0051
            java.lang.Object r5 = r4.get(r3)
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r5 = (com.baidu.searchbox.feed.tab.update.MultiTabItemInfo) r5
            if (r5 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0040
            boolean r3 = r5.isNewTip
            if (r3 == 0) goto L_0x003f
            r5.isNewTip = r2
        L_0x003f:
            return
        L_0x0040:
            com.baidu.searchbox.noveladapter.feed.tab.NovelSlidingTabLayout r2 = r7.mSlidingTabLayout
            com.baidu.searchbox.novel.main.pad.NovelMainFeedTabLayout$8 r6 = new com.baidu.searchbox.novel.main.pad.NovelMainFeedTabLayout$8
            r6.<init>(r5, r1)
            r2.setTabNewTipChangeListener(r6)
            r5.isNewTip = r3
            com.baidu.searchbox.noveladapter.feed.tab.NovelSlidingTabLayout r2 = r7.mSlidingTabLayout
            r2.showNewTip(r5)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.novel.main.pad.NovelMainFeedTabLayout.showRecommendTabNewTipIfNeed(int):void");
    }

    private void checkShowRecommendTips(int index) {
        NovelSlidingTabLayout novelSlidingTabLayout;
        if (!this.isAbTestOpen) {
            return;
        }
        if (index == 0 || index == -1) {
            boolean canShow = true;
            NovelSpManager spManager = NovelSpManager.getI(SP_NAME);
            if (spManager != null) {
                long shownTime = spManager.getLong(SP_KEY_RECOMMEND_TIPS_TIMESTAMP, 0);
                if (shownTime > 0) {
                    int i2 = this.currentUserStatus;
                    if (i2 > 0 && i2 < 3) {
                        canShow = false;
                    } else if (DateUtils.isToday(shownTime)) {
                        canShow = false;
                    }
                }
            }
            if (canShow && (novelSlidingTabLayout = this.mSlidingTabLayout) != null) {
                novelSlidingTabLayout.postDelayed(new NovelMainFeedTabLayout$$ExternalSyntheticLambda0(this, spManager), 250);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$checkShowRecommendTips$0$com-baidu-searchbox-novel-main-pad-NovelMainFeedTabLayout  reason: not valid java name */
    public /* synthetic */ void m1718lambda$checkShowRecommendTips$0$combaidusearchboxnovelmainpadNovelMainFeedTabLayout(NovelSpManager spManager) {
        NovelSlidingTabStrip tabStrip;
        View anchorView = null;
        NovelSlidingTabLayout novelSlidingTabLayout = this.mSlidingTabLayout;
        if (!(novelSlidingTabLayout == null || (tabStrip = novelSlidingTabLayout.getTabStrip()) == null)) {
            anchorView = tabStrip.getChildAt(1);
        }
        if (anchorView != null) {
            this.bubbleManager = NovelBubbleManager.getBuilder().setAnchor(anchorView).setDirection(2).setText("去书城看看吧").setTextColor(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC6)).setBackground(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC28)).setPaddingBetweenAnchor(0.0f).enableAnimation(true).setAutoDismissInterval(5000).build();
            NovelTabViewPager novelTabViewPager = this.mViewPager;
            if (novelTabViewPager != null && novelTabViewPager.getCurrentItem() == 0) {
                this.bubbleManager.showBubble();
                if (spManager != null) {
                    spManager.putLong(SP_KEY_RECOMMEND_TIPS_TIMESTAMP, System.currentTimeMillis());
                }
            }
        }
    }

    private void checkShowShelfTips(int index) {
        NovelSpManager spManager = NovelSpManager.getI(SP_NAME);
        boolean isTipsShow = false;
        if (spManager != null) {
            isTipsShow = spManager.getBoolean(SP_KEY, false);
        }
        if (!isTipsShow) {
            if (index == 0) {
                if (spManager != null) {
                    spManager.putBoolean(SP_KEY, true);
                }
                NovelBubbleManager novelBubbleManager = this.bubbleManager;
                if (novelBubbleManager != null && !novelBubbleManager.isDismissed()) {
                    this.bubbleManager.dismissBubble();
                }
            } else if (index == 1) {
                post(new NovelMainFeedTabLayout$$ExternalSyntheticLambda1(this, spManager));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$checkShowShelfTips$1$com-baidu-searchbox-novel-main-pad-NovelMainFeedTabLayout  reason: not valid java name */
    public /* synthetic */ void m1719lambda$checkShowShelfTips$1$combaidusearchboxnovelmainpadNovelMainFeedTabLayout(final NovelSpManager spManager) {
        NovelSlidingTabStrip tabStrip;
        View anchorView = null;
        NovelSlidingTabLayout novelSlidingTabLayout = this.mSlidingTabLayout;
        if (!(novelSlidingTabLayout == null || (tabStrip = novelSlidingTabLayout.getTabStrip()) == null)) {
            anchorView = tabStrip.getChildAt(0);
        }
        if (anchorView != null) {
            this.bubbleManager = NovelBubbleManager.getBuilder().setAnchor(anchorView).setDirection(2).setText("你的书都在这里哦").setTextColor(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC6)).setBackground(NovelNightModeUtils.getColor(com.baidu.android.common.ui.style.R.color.GC28)).setPaddingBetweenAnchor(0.0f).enableAnimation(true).setOnBubbleEventListener(new NovelBubbleManager.OnBubbleEventListener() {
                public void onBubbleDismiss() {
                }

                public void onBubbleShow() {
                    NovelSpManager novelSpManager = spManager;
                    if (novelSpManager != null) {
                        novelSpManager.putBoolean(NovelMainFeedTabLayout.SP_KEY, true);
                    }
                }

                public void onBubbleClick() {
                }
            }).build();
            NovelTabViewPager novelTabViewPager = this.mViewPager;
            if (novelTabViewPager == null || novelTabViewPager.getCurrentItem() != 0) {
                this.bubbleManager.showBubble();
            } else if (spManager != null) {
                spManager.putBoolean(SP_KEY, true);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSelectTab(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = -1
            int r1 = r6.hashCode()
            r2 = -1
            switch(r1) {
                case -1102508601: goto L_0x0050;
                case 97740: goto L_0x0046;
                case 3173020: goto L_0x003c;
                case 50511102: goto L_0x0032;
                case 109403690: goto L_0x0027;
                case 109413500: goto L_0x001c;
                case 989204668: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x005a
        L_0x0011:
            java.lang.String r1 = "recommend"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 1
            goto L_0x005b
        L_0x001c:
            java.lang.String r1 = "short"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 2
            goto L_0x005b
        L_0x0027:
            java.lang.String r1 = "shelf"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 0
            goto L_0x005b
        L_0x0032:
            java.lang.String r1 = "category"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 6
            goto L_0x005b
        L_0x003c:
            java.lang.String r1 = "girl"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 5
            goto L_0x005b
        L_0x0046:
            java.lang.String r1 = "boy"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 4
            goto L_0x005b
        L_0x0050:
            java.lang.String r1 = "listen"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 3
            goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            switch(r1) {
                case 0: goto L_0x006b;
                case 1: goto L_0x0069;
                case 2: goto L_0x0067;
                case 3: goto L_0x0065;
                case 4: goto L_0x0063;
                case 5: goto L_0x0061;
                case 6: goto L_0x005f;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x006d
        L_0x005f:
            r0 = 6
            goto L_0x006d
        L_0x0061:
            r0 = 5
            goto L_0x006d
        L_0x0063:
            r0 = 4
            goto L_0x006d
        L_0x0065:
            r0 = 3
            goto L_0x006d
        L_0x0067:
            r0 = 2
            goto L_0x006d
        L_0x0069:
            r0 = 1
            goto L_0x006d
        L_0x006b:
            r0 = 0
        L_0x006d:
            if (r0 != r2) goto L_0x0070
            return
        L_0x0070:
            com.baidu.searchbox.noveladapter.feedcore.NovelTabViewPager r1 = r5.mViewPager
            if (r1 == 0) goto L_0x009e
            r1.setCurrentItem(r0)
            com.baidu.searchbox.novel.main.pad.NovelMainTabDataHelper r1 = com.baidu.searchbox.novel.main.pad.NovelMainTabDataHelper.getInstance()
            java.util.List r1 = r1.getTabItemInfos()
            if (r1 == 0) goto L_0x009d
            if (r0 < 0) goto L_0x009d
            int r2 = r1.size()
            if (r0 >= r2) goto L_0x009d
            java.lang.Object r2 = r1.get(r0)
            com.baidu.searchbox.feed.tab.update.MultiTabItemInfo r2 = (com.baidu.searchbox.feed.tab.update.MultiTabItemInfo) r2
            com.baidu.searchbox.novel.main.pad.fragment.NovelFragmentManager r3 = r5.mManager
            if (r3 == 0) goto L_0x009d
            boolean r4 = r2 instanceof com.baidu.searchbox.noveladapter.feed.tab.NovelMultiTabItemInfo
            if (r4 == 0) goto L_0x009d
            r4 = r2
            com.baidu.searchbox.noveladapter.feed.tab.NovelMultiTabItemInfo r4 = (com.baidu.searchbox.noveladapter.feed.tab.NovelMultiTabItemInfo) r4
            r3.onTabSelected(r4)
        L_0x009d:
            goto L_0x00a0
        L_0x009e:
            r5.forceSelectedIndex = r0
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.novel.main.pad.NovelMainFeedTabLayout.setSelectTab(java.lang.String):void");
    }

    public void hideShelfBubble() {
        NovelBubbleManager novelBubbleManager = this.bubbleManager;
        if (novelBubbleManager != null && !novelBubbleManager.isDismissed()) {
            post(new Runnable() {
                public void run() {
                    if (NovelMainFeedTabLayout.this.bubbleManager != null && !NovelMainFeedTabLayout.this.bubbleManager.isDismissed()) {
                        NovelMainFeedTabLayout.this.bubbleManager.hideBubbleView();
                    }
                }
            });
        }
    }

    private String makeUserCenterScheme() {
        String params = "{\"tab\":1008,\"fromaction\":" + "feedtabnovel_new" + i.f2534d;
        try {
            params = URLEncoder.encode(params, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return USER_CENTER_SCHEME + params;
    }

    private final class LoginStateListener implements NovelBoxAccountManagerWrapper.NovelLoginStatusChangedListener {
        private WeakReference<NovelMainFeedTabLayout> weakReference;

        public LoginStateListener(NovelMainFeedTabLayout tabLayout) {
            this.weakReference = new WeakReference<>(tabLayout);
        }

        public void onLoginStatusChanged(int status) {
            NovelMainFeedTabLayout tabLayout;
            WeakReference<NovelMainFeedTabLayout> weakReference2 = this.weakReference;
            if (weakReference2 != null && (tabLayout = (NovelMainFeedTabLayout) weakReference2.get()) != null) {
                tabLayout.refreshAvatar();
            }
        }
    }

    private void registerSearchBoxEvent() {
        BdEventBus.Companion.getDefault().register(this.eventTag, NovelSearchBoxEvent.class, 1, new INovelAction1<NovelSearchBoxEvent>() {
            public void call(NovelSearchBoxEvent novelSearchBoxEvent) {
                if (novelSearchBoxEvent.isShow) {
                    NovelMainFeedTabLayout.this.showRereadTips("");
                } else {
                    NovelMainFeedTabLayout.this.hideReadTipsView();
                }
            }
        });
    }

    private void unRegisterSearchBoxEvent() {
        BdEventBus.Companion.getDefault().unregister(this.eventTag);
    }

    public void uploadBookShelfCount() {
        long lastUploadTime = 0;
        NovelSpManager novelSpManager = NovelSpManager.getI(SP_NAME);
        if (novelSpManager != null) {
            lastUploadTime = novelSpManager.getLong(LAST_UPLOAD_BOOK_COUNT, 0);
        }
        if (!DateTimeUtils.isSameDay(lastUploadTime, System.currentTimeMillis())) {
            NovelExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    if (PluginInvokeManager.getInstance().isPluginInit()) {
                        IExternalForward iExternalForward = IExternalForward.Impl.get();
                        if (iExternalForward != null) {
                            NovelMainFeedTabLayout.this.ubcUserShelfBookCount(iExternalForward.getUserBookShelfCount());
                            return;
                        }
                        return;
                    }
                    PluginInvokeManager.getInstance().invokeNovel(true, new IPluginLoadCallback() {
                        public void loadSuccess() {
                            IExternalForward iExternalForward = IExternalForward.Impl.get();
                            if (iExternalForward != null) {
                                NovelMainFeedTabLayout.this.ubcUserShelfBookCount(iExternalForward.getUserBookShelfCount());
                            }
                        }

                        public void loadError() {
                        }
                    });
                }
            }, "GET_BOOKS_COUNT_FROM_SHELF", 3);
        }
    }

    private void checkPluginData() {
        NovelExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (PluginInvokeManager.getInstance().isPluginInit()) {
                    int maodingType = -1;
                    boolean isOpen = false;
                    int userStatus = 0;
                    IExternalForward iExternalForward = IExternalForward.Impl.get();
                    if (iExternalForward != null) {
                        maodingType = iExternalForward.getMaodingType();
                        isOpen = iExternalForward.isOpenShelfRecommendAbTest();
                        if (isOpen) {
                            userStatus = iExternalForward.getUserStatus();
                        }
                    }
                    if (maodingType != -1) {
                        NovelMainFeedTabLayout.this.onSelectFeedTabIndex(maodingType);
                    }
                    if (isOpen) {
                        NovelMainFeedTabLayout.this.onAbTest(userStatus, maodingType);
                        return;
                    }
                    return;
                }
                PluginInvokeManager.getInstance().invokeNovel(false, new IPluginLoadCallback() {
                    public void loadSuccess() {
                        int maodingType = -1;
                        boolean isOpen = false;
                        int userStatus = 0;
                        IExternalForward iExternalForward = IExternalForward.Impl.get();
                        if (iExternalForward != null) {
                            maodingType = iExternalForward.getMaodingType();
                            isOpen = iExternalForward.isOpenShelfRecommendAbTest();
                            if (isOpen) {
                                userStatus = iExternalForward.getUserStatus();
                            }
                        }
                        if (maodingType != -1) {
                            NovelMainFeedTabLayout.this.onSelectFeedTabIndex(maodingType);
                        }
                        if (isOpen) {
                            NovelMainFeedTabLayout.this.onAbTest(userStatus, maodingType);
                        }
                    }

                    public void loadError() {
                    }
                });
            }
        }, "CHECK_MAODING_TYPE", 3);
    }

    /* access modifiers changed from: private */
    public void ubcUserShelfBookCount(int bookCount) {
        HashMap hashMap = new HashMap();
        hashMap.put("book_inventory", String.valueOf(bookCount));
        hashMap.put(NovelCustomUbc.Key.KEY_FROMACTION_ORIGINAL, "feedtabnovel_new");
        NovelUbcStatUtils.exeUbc(NovelCustomUbc.EventId.UBC_EVENT_ID_5958, "show", NovelCustomUbc.Page.PAGE_FEEDTABNOVEL_NEW_OVERALL, "book_inventory", "novel", "feedtabnovel_new", (Map<String, String>) hashMap);
        NovelSpManager novelSpManager = NovelSpManager.getI(SP_NAME);
        if (novelSpManager != null) {
            novelSpManager.putLong(LAST_UPLOAD_BOOK_COUNT, System.currentTimeMillis());
        }
    }

    private int getSearchViewWidthPX() {
        Activity activity = this.mActivity;
        if (activity == null || !NovelPadUtilsWrapper.isPadHorizontal(activity)) {
            return DeviceUtils.ScreenInfo.dp2px(getContext(), 237.5f);
        }
        return (int) ((((double) (DeviceUtils.ScreenInfo.getDisplayWidth(getContext()) / 2)) - 63.5d) * 0.87d);
    }
}
