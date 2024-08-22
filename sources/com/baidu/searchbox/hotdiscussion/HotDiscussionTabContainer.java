package com.baidu.searchbox.hotdiscussion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.browser.core.util.BdViewUtils;
import com.baidu.browser.tabna.BaseNaTabContainer;
import com.baidu.browser.tabna.IResultPageTabContext;
import com.baidu.browser.tabna.SearchTabItem;
import com.baidu.browser.tabna.model.EmptyPageModel;
import com.baidu.browser.tabna.model.TabContainerModel;
import com.baidu.browser.tabna.utils.NaGroupCardParamsUtils;
import com.baidu.browser.tabna.view.NoResultView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.DurationManagerKt;
import com.baidu.search.basic.utils.InvokeCookieManager;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.search.basic.utils.SstPstUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.browserenhanceengine.container.animation.ContainerAnimationInterceptor;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.generalcommunity.InvokeAppEvent;
import com.baidu.searchbox.generalcommunity.injector.ConfigOptions;
import com.baidu.searchbox.generalcommunity.injector.StatusTargetFactory;
import com.baidu.searchbox.generalcommunity.injector.impl.StatusTargetImpl;
import com.baidu.searchbox.generalcommunity.ui.GCommunityUI;
import com.baidu.searchbox.generalcommunity.utils.CommonUtils;
import com.baidu.searchbox.generalcommunity.utils.UiUtils;
import com.baidu.searchbox.hotdiscussion.template.search.SearchHotTopicCardView;
import com.baidu.searchbox.hotdiscussion.template.search.eventbus.AttitudeEvent;
import com.baidu.searchbox.hotdiscussion.template.search.eventbus.HotDiscussionTcEvent;
import com.baidu.searchbox.hotdiscussion.template.search.eventbus.SwitchHotDiscussionTabEvent;
import com.baidu.searchbox.hotdiscussion.textseletecd.MenuDismissEvent;
import com.baidu.searchbox.hotdiscussion.textseletecd.OnTextSelectChanged;
import com.baidu.searchbox.hotdiscussion.textseletecd.OnTextSelectStart;
import com.baidu.searchbox.hotdiscussion.textseletecd.TextSelectDismissEvent;
import com.baidu.searchbox.hotdiscussion.toptip.TopTipComp;
import com.baidu.searchbox.hotdiscussion.toptip.TopTipData;
import com.baidu.searchbox.hotdiscussion.ubc.TCStatisticHelper;
import com.baidu.searchbox.hotdiscussion.view.CenterAttitudeView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionAllView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionBaseView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionGeneralView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionNewView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionNoDiscussView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionRealTimeView;
import com.baidu.searchbox.hotdiscussion.view.HotDiscussionRsseView;
import com.baidu.searchbox.search.pyramid.SearchLongPressInterface;
import com.baidu.searchbox.search.rsseview.SearchRsseView;
import com.baidu.searchbox.searchhotdiscussion.model.HotDiscussionEmptyPageModel;
import com.baidu.searchbox.searchhotdiscussion.model.HotDiscussionTabModel;
import com.baidu.searchbox.searchhotdiscussion.model.HotDiscussionTagModel;
import com.baidu.searchbox.searchhotdiscussion.model.PageConfig;
import com.baidu.searchbox.searchhotdiscussion.view.HotDiscussionAdapter;
import com.baidu.searchbox.searchhotdiscussion.view.HotDiscussionTabBar;
import com.baidu.searchbox.searchhotdiscussion.view.HotDiscussionTabLayout;
import com.baidu.searchbox.searchhotdiscussion.view.HotDiscussionViewPager;
import com.baidu.searchbox.searchhotdiscussion.view.NestedScrollParentRelativeLayout;
import com.baidu.searchbox.searchui.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONException;
import org.json.JSONObject;

public class HotDiscussionTabContainer extends BaseNaTabContainer implements HotDiscussionViewPager.ScrollJudgeListener, GCommunityUI.RefreshResultCallback {
    private static final int BUBBLE_MARGIN_BOTTOM = 7;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int EXPRESS_TEMPLATE_SHOWING = 1;
    public static final int REAL_TIME_SHOWING = 1;
    public static final int REQUEST_TYPE_CLICK_TAB = 1;
    private static final String SEARCH_HOT_SPOT_ALL = "search_hot_spot_all";
    private static final String SEARCH_HOT_SPOT_GENERAL_PREFIX = "search_hot_spot_general_";
    private static final String SEARCH_HOT_SPOT_NEW = "search_hot_spot_new";
    private static final String SEARCH_HOT_SPOT_REAL_TIME = "search_hot_spot_real_time";
    private static final int SELECT_REAL_TIME_TAB = 1;
    private static final String TAG = "HotDiscussionTab";
    private BubbleTextManager bubbleManager;
    /* access modifiers changed from: private */
    public boolean expressTemplateShowed;
    /* access modifiers changed from: private */
    public boolean hasRealTimeStrong;
    /* access modifiers changed from: private */
    public boolean hasReportClickMore;
    /* access modifiers changed from: private */
    public boolean isClickToSort = false;
    /* access modifiers changed from: private */
    public boolean isPublishing = false;
    /* access modifiers changed from: private */
    public boolean isResume;
    private boolean isSelectRealTime;
    /* access modifiers changed from: private */
    public final SearchLongPressInterface longPressInterface = ((SearchLongPressInterface) ServiceManager.getService(SearchLongPressInterface.Companion.getSERVICE_REFERENCE()));
    /* access modifiers changed from: private */
    public CenterAttitudeView mAttitudeView;
    /* access modifiers changed from: private */
    public ViewStub mAttitudeViewStub;
    private SearchHotTopicCardView mCardView;
    private ConfigOptions mConfigOptions;
    /* access modifiers changed from: private */
    public HotDiscussionBaseView mCurHotDiscussionView;
    /* access modifiers changed from: private */
    public int mCurPos = 0;
    private HotDiscussionAdapter mDiscussionAdapter;
    private HotDiscussionBaseView mHotDiscussionTagAllView;
    private HotDiscussionBaseView mHotDiscussionTagNewView;
    private HotDiscussionBaseView mHotDiscussionTagRealTimeView;
    private final List<HotDiscussionBaseView> mHotDiscussionViewList = new ArrayList();
    private HotDiscussionNoDiscussView mNoDiscussView;
    private ScrollView mNoResultViewContainer;
    /* access modifiers changed from: private */
    public HashMap<String, String> mRefreshUrlMap = new HashMap<>();
    private NestedScrollParentRelativeLayout mRootView;
    /* access modifiers changed from: private */
    public SearchRsseView mRsseView;
    private HotDiscussionRsseViewModel mRsseViewModel;
    private View mSpaceView = null;
    private StatusTargetFactory mStatusTargetFactory;
    /* access modifiers changed from: private */
    public HotDiscussionTabBar mTabBar;
    private HotDiscussionTabLayout mTabLayout;
    private ImageView mUgcImage;
    private ViewModelStore mViewModelStore;
    private HotDiscussionViewPager mViewPager;
    private LinearLayout noResultParent = null;
    /* access modifiers changed from: private */
    public TopTipComp noResultTopTipComp = null;
    /* access modifiers changed from: private */
    public final View.OnClickListener onSelMenuClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            BdEventBus.Companion.getDefault().post(TextSelectDismissEvent.INSTANCE);
        }
    };
    /* access modifiers changed from: private */
    public boolean reportAfterResponse;
    private HotDiscussionTabModel tabData;
    private int topPaddingInNewTab;
    /* access modifiers changed from: private */
    public TopTipComp topTipComp = null;
    private View topViewChildContainer = null;

    public HotDiscussionTabContainer(Context context, TabContainerModel model, IResultPageTabContext resultPageTabContext, SearchTabItem tabItem) {
        super(context, model, resultPageTabContext, tabItem);
        this.topPaddingInNewTab = context.getResources().getDimensionPixelSize(R.dimen.result_na_page_padding_top_new_tab);
        initStatusTargetFactory();
        initConfigOptions();
        initHotDiscussionView();
        this.page = "realtime_ugc";
        registerFontSizeChange();
        registerTextSelectStart();
        registerTextSelectChange();
        registerTextSelectCancel();
    }

    /* access modifiers changed from: protected */
    public View contentView() {
        if (this.mRootView == null) {
            int layoutId = com.baidu.searchbox.searchhotdiscussiontab.R.layout.browser_hot_discussion_tab;
            if (ResultPageABTest.isAllTabSupportImmerse()) {
                layoutId = com.baidu.searchbox.searchhotdiscussiontab.R.layout.browser_hot_discussion_tab_new;
            }
            NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = (NestedScrollParentRelativeLayout) LayoutInflater.from(this.mContext).inflate(layoutId, this.mRootView);
            this.mRootView = nestedScrollParentRelativeLayout;
            UiUtils.setViewColor(nestedScrollParentRelativeLayout, com.baidu.searchbox.generalcommunity.R.color.community_template_background_color);
            HotDiscussionViewPager hotDiscussionViewPager = (HotDiscussionViewPager) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_viewpager);
            this.mViewPager = hotDiscussionViewPager;
            hotDiscussionViewPager.setCanViewPagerScrollHorizontally(false);
            this.mViewPager.setScrollJudgeListener(this);
            HotDiscussionTabLayout hotDiscussionTabLayout = (HotDiscussionTabLayout) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_tab_layout);
            this.mTabLayout = hotDiscussionTabLayout;
            hotDiscussionTabLayout.setVisibility(8);
            this.mTabBar = (HotDiscussionTabBar) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_tab_bar);
            this.mUgcImage = (ImageView) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_ugc);
            if (ResultPageABTest.isAllTabSupportImmerse()) {
                this.mUgcImage.setImageResource(com.baidu.searchbox.searchhotdiscussion.R.drawable.browser_na_hot_discussion_ugc_new);
            } else {
                this.mUgcImage.setImageResource(com.baidu.searchbox.searchhotdiscussion.R.drawable.browser_na_hot_discussion_ugc);
            }
            setUpUgcLayout();
            this.mAttitudeViewStub = (ViewStub) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_attitude_view_stub);
            initRsseView();
            this.mRootView.setBottomView(this.mViewPager);
            this.topViewChildContainer = this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.top_view_child_layout);
            List<View> viewList = new ArrayList<>();
            List<String> tabList = new ArrayList<>();
            for (HotDiscussionBaseView hotDiscussionView : this.mHotDiscussionViewList) {
                viewList.add(hotDiscussionView.getContentView());
                tabList.add(hotDiscussionView.getTabName());
            }
            initMarginView();
            initViewPager(viewList);
            initTabBar(tabList);
            setSortListener();
            initUgcImage();
            updateRootBg(NightModeHelper.getNightModeSwitcherState());
            updateTagLayout();
        }
        return this.mRootView;
    }

    private void initMarginView() {
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            View marginView = nestedScrollParentRelativeLayout.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_margin_view);
            if (!ResultPageABTest.isNewTabFrameworkOpen() || ResultPageABTest.isResultPageNewStyle()) {
                marginView.setVisibility(8);
            } else {
                marginView.setVisibility(0);
            }
        }
    }

    private void setUpUgcLayout() {
        Map<String, Integer> offsetData;
        Integer offset;
        if (this.mUgcImage != null && this.mResultPageContext != null) {
            ViewGroup.LayoutParams params = this.mUgcImage.getLayoutParams();
            if ((params instanceof ViewGroup.MarginLayoutParams) && (offsetData = this.mResultPageContext.getBottomOffset()) != null && (offset = offsetData.get("bottomCoverHeight")) != null) {
                ((ViewGroup.MarginLayoutParams) params).bottomMargin = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), (float) (offset.intValue() + 7));
                this.mUgcImage.setLayoutParams(params);
            }
        }
    }

    private void initRsseView() {
        this.mRsseView = new HotDiscussionRsseView(this.mContext);
        this.mRootView.setTopView(this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_topview_container));
        ((FrameLayout) this.mRootView.findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_rsse_container)).addView(this.mRsseView.getRootView());
        this.mViewModelStore = new ViewModelStore();
        HotDiscussionRsseViewModel hotDiscussionRsseViewModel = (HotDiscussionRsseViewModel) new ViewModelProvider(this.mViewModelStore, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(HotDiscussionRsseViewModel.class);
        this.mRsseViewModel = hotDiscussionRsseViewModel;
        this.mRsseView.bind(this, hotDiscussionRsseViewModel);
        this.mRsseViewModel.isShow().observe(this, new Observer<Boolean>() {
            public void onChanged(Boolean isShow) {
                if (Boolean.TRUE.equals(isShow)) {
                    HotDiscussionTabContainer.this.mRsseView.setVisibility(0);
                } else {
                    HotDiscussionTabContainer.this.mRsseView.setVisibility(8);
                }
            }
        });
        this.mRsseViewModel.setFetchDataListener(new Function2<String, String, Unit>() {
            public Unit invoke(String url, String query) {
                HotDiscussionTabContainer.this.loadUrl(url);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadUrl(String url) {
        if (!TextUtils.isEmpty(url) && this.mResultPageContext != null && this.mResultPageContext.getContainerManager() != null) {
            this.mResultPageContext.getContainerManager().openContainerWithUrl(url, (Map<String, String>) null, (Object) null, true);
        }
    }

    private void updatePageList(boolean hasRealTime) {
        HotDiscussionBaseView removeHotTabView = hasRealTime ? getNewTabView() : getRealTimeTabView();
        HotDiscussionBaseView addHotTabView = hasRealTime ? getRealTimeTabView() : getNewTabView();
        this.mHotDiscussionViewList.remove(removeHotTabView);
        removeHotTabView.onDestroy();
        if (removeHotTabView == this.mHotDiscussionTagRealTimeView) {
            this.mHotDiscussionTagRealTimeView = null;
        } else if (removeHotTabView == this.mHotDiscussionTagNewView) {
            this.mHotDiscussionTagNewView = null;
        }
        if (!this.mHotDiscussionViewList.contains(addHotTabView)) {
            this.mHotDiscussionViewList.add(addHotTabView);
            updateViewPageAndTabBar();
        }
        if (this.isSelectRealTime) {
            this.mTabBar.setSelectedPosition(1);
            List<HotDiscussionBaseView> list = this.mHotDiscussionViewList;
            if (list != null && list.size() >= 2 && !(this.mCurHotDiscussionView instanceof HotDiscussionRealTimeView)) {
                this.mCurHotDiscussionView = this.mHotDiscussionViewList.get(1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePageList() {
        HotDiscussionTabModel hotDiscussionTabModel = this.tabData;
        if (hotDiscussionTabModel != null && hotDiscussionTabModel.getTagList() != null) {
            List<HotDiscussionBaseView> list = new ArrayList<>();
            for (HotDiscussionTagModel tagModel : this.tabData.getTagList()) {
                list.add(createGeneralTabView(new HotDiscussionGeneralView.TabInfo(tagModel.getTagName(), tagModel.getTagValue(), this.tabData.getIndexSort().getSortName(), this.tabData.getIndexSort().getSortValue(), tagModel.getTagClk()), list.size()));
            }
            for (HotDiscussionBaseView discussionView : this.mHotDiscussionViewList) {
                discussionView.onDestroy();
            }
            this.mHotDiscussionViewList.clear();
            this.mHotDiscussionViewList.addAll(list);
            updateViewPageAndTabBar();
            this.mCurHotDiscussionView = this.mHotDiscussionViewList.get(this.tabData.getTagIndex());
            this.mViewPager.setCurrentItem(this.tabData.getTagIndex());
            this.mCurHotDiscussionView.onResume();
        }
    }

    private void updateViewPageAndTabBar() {
        List<View> viewList = new ArrayList<>();
        List<String> tabList = new ArrayList<>();
        for (HotDiscussionBaseView hotDiscussionView : this.mHotDiscussionViewList) {
            viewList.add(hotDiscussionView.getContentView());
            tabList.add(hotDiscussionView.getTabName());
        }
        HotDiscussionAdapter hotDiscussionAdapter = new HotDiscussionAdapter(viewList);
        this.mDiscussionAdapter = hotDiscussionAdapter;
        this.mViewPager.setAdapter(hotDiscussionAdapter);
        HotDiscussionTabModel hotDiscussionTabModel = this.tabData;
        if (hotDiscussionTabModel == null || !hotDiscussionTabModel.isValid()) {
            this.mTabBar.setTabItems(tabList);
            return;
        }
        this.mTabLayout.setTabData(this.tabData);
        this.mViewPager.setOffscreenPageLimit(this.mDiscussionAdapter.getCount() - 1);
    }

    public void showUrl(String url, boolean needRequest) {
        if (needRequest) {
            resetToInit(false);
            this.mHasReportUpScreen = false;
        }
        super.showUrl(url, needRequest);
    }

    public void reload() {
        this.mHasNetData = false;
        showContentView(false);
        resetToInit(true);
        this.mRefreshUrl = this.mRefreshUrlMap.get(String.valueOf(this.mCurPos));
        requestUrl(-2);
    }

    public void updateRefreshUrl(String refreshUrl) {
        this.mRefreshUrlMap.put(String.valueOf(this.mCurPos), this.mRefreshUrl);
    }

    private void resetToInit(boolean isRefresh) {
        if (!isRefresh) {
            this.mTabBar.setVisibility(8);
        }
        if (isRefresh) {
            this.mTabBar.setSelectedPosition(this.mCurPos);
        } else {
            this.mTabBar.setSelectedPosition(0);
        }
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            nestedScrollParentRelativeLayout.resetPosition();
        }
        for (HotDiscussionBaseView baseView : this.mHotDiscussionViewList) {
            baseView.resetToInit();
        }
    }

    private void initViewPager(List<View> viewList) {
        HotDiscussionAdapter hotDiscussionAdapter = new HotDiscussionAdapter(viewList);
        this.mDiscussionAdapter = hotDiscussionAdapter;
        this.mViewPager.setAdapter(hotDiscussionAdapter);
    }

    private void initTabBar(List<String> tabList) {
        this.mTabBar.setTabItems(tabList);
        this.mTabBar.setOnTabItemClickListener(new HotDiscussionTabBar.OnTabItemClickListener() {
            public void onClick(View v, int index) {
                HotDiscussionTabContainer.this.hideNoResultView();
                HotDiscussionTabContainer.this.updatePageInfo(index, true);
            }
        });
        this.mTabBar.setOnTabItemSelectListener(new HotDiscussionTabBar.OnTabItemSelectListener() {
            public void onItemSelect(View v, int index) {
                HotDiscussionTabContainer.this.updatePageInfo(index, false);
            }
        });
    }

    private void setSortListener() {
        this.mTabLayout.setSortListener(new Function3<String, Integer, String, Unit>() {
            public Unit invoke(String name, Integer value, String tcClk) {
                if (!(HotDiscussionTabContainer.this.mCurHotDiscussionView instanceof HotDiscussionGeneralView)) {
                    return null;
                }
                ((HotDiscussionGeneralView) HotDiscussionTabContainer.this.mCurHotDiscussionView).getTabInfo().setSortName(name);
                ((HotDiscussionGeneralView) HotDiscussionTabContainer.this.mCurHotDiscussionView).getTabInfo().setSortValue(value.intValue());
                HotDiscussionTabContainer.this.mCurHotDiscussionView.resetToInit();
                HotDiscussionTabContainer.this.mCurHotDiscussionView.show();
                boolean unused = HotDiscussionTabContainer.this.isClickToSort = true;
                HotDiscussionTabContainer.this.reportSortClick(tcClk);
                HotDiscussionTabContainer.this.hideNoResultView();
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void updatePageInfo(int index, boolean isClick) {
        if (index != this.mViewPager.getCurrentItem()) {
            HotDiscussionBaseView prevView = this.mCurHotDiscussionView;
            this.mViewPager.setCurrentItem(index);
            this.mCurPos = index;
            HotDiscussionBaseView hotDiscussionBaseView = this.mHotDiscussionViewList.get(index);
            this.mCurHotDiscussionView = hotDiscussionBaseView;
            if (hotDiscussionBaseView != null) {
                if (prevView != null) {
                    prevView.onPause();
                }
                this.isClickToSort = false;
                syncSortInfo();
                this.mCurHotDiscussionView.show();
                if (prevView != null) {
                    prevView.closePullRefreshLoading();
                    prevView.onStop();
                }
                if (isClick) {
                    reportTagClick();
                }
            }
            HotDiscussionTabModel hotDiscussionTabModel = this.tabData;
            if (hotDiscussionTabModel != null) {
                hotDiscussionTabModel.setTagIndex(index);
            }
        }
    }

    private void syncSortInfo() {
        HotDiscussionTabModel hotDiscussionTabModel;
        int sortValue;
        if ((this.mCurHotDiscussionView instanceof HotDiscussionGeneralView) && (hotDiscussionTabModel = this.tabData) != null && hotDiscussionTabModel.isValid() && (sortValue = this.tabData.getIndexSort().getSortValue()) != ((HotDiscussionGeneralView) this.mCurHotDiscussionView).getTabInfo().getSortValue()) {
            ((HotDiscussionGeneralView) this.mCurHotDiscussionView).getTabInfo().setSortValue(sortValue);
            if (this.mCurHotDiscussionView.isInit()) {
                this.mCurHotDiscussionView.resetToInit();
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportTagClick() {
        PageConfig.ClickInfo clickInfo = this.mCurHotDiscussionView.getClickInfo();
        if (AppConfig.isDebug()) {
            Log.d(TAG, "reportTagClick: " + clickInfo);
        }
        if (clickInfo == null) {
            this.reportAfterResponse = true;
            return;
        }
        this.reportAfterResponse = false;
        TCStatisticHelper.reportHotDiscussionAction("", clickInfo.query, clickInfo.lid, clickInfo.applid, clickInfo.referlid, this.mCurHotDiscussionView.getTcAction());
    }

    /* access modifiers changed from: private */
    public void reportSortClick(String action) {
        PageConfig.ClickInfo clickInfo = this.mCurHotDiscussionView.getClickInfo();
        if (AppConfig.isDebug()) {
            Log.d(TAG, "reportSortClick: " + clickInfo);
        }
        if (clickInfo != null) {
            TCStatisticHelper.reportHotDiscussionAction("", clickInfo.query, clickInfo.lid, clickInfo.applid, clickInfo.referlid, action);
        }
    }

    private void initUgcImage() {
        this.mUgcImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (HotDiscussionTabContainer.this.mCurHotDiscussionView != null && !CommonUtils.isFastClick()) {
                    String ugcScheme = HotDiscussionTabContainer.this.mCurHotDiscussionView.getUgcScheme();
                    if (!TextUtils.isEmpty(ugcScheme)) {
                        UnitedSchemeEntity entity = new UnitedSchemeEntity(Uri.parse(ugcScheme));
                        UnitedSchemeMainDispatcher dispatcher = new UnitedSchemeMainDispatcher();
                        final WeakReference<HotDiscussionTabContainer> containerRef = new WeakReference<>(HotDiscussionTabContainer.this);
                        dispatcher.dispatch(HotDiscussionTabContainer.this.mContext, entity, new CallbackHandler() {
                            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
                                r0 = (com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer) r3.get();
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public void handleSchemeDispatchCallback(java.lang.String r3, final java.lang.String r4) {
                                /*
                                    r2 = this;
                                    java.lang.String r0 = com.baidu.searchbox.searchhotdiscussion.net.PublishDataManager.getPublishStatus(r4)
                                    java.lang.String r1 = "0"
                                    boolean r0 = android.text.TextUtils.equals(r1, r0)
                                    if (r0 != 0) goto L_0x000d
                                    return
                                L_0x000d:
                                    java.lang.ref.WeakReference r0 = r3
                                    java.lang.Object r0 = r0.get()
                                    com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer r0 = (com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer) r0
                                    if (r0 != 0) goto L_0x0018
                                    return
                                L_0x0018:
                                    r1 = 1
                                    boolean unused = r0.isPublishing = r1
                                    com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer$7$1$1 r1 = new com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer$7$1$1
                                    r1.<init>(r4, r0)
                                    r0.changeToSecondTab(r1)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer.AnonymousClass7.AnonymousClass1.handleSchemeDispatchCallback(java.lang.String, java.lang.String):void");
                            }

                            public String getCurrentPageUrl() {
                                return null;
                            }
                        });
                    }
                    PageConfig.ClickInfo clickInfo = HotDiscussionTabContainer.this.mCurHotDiscussionView.getClickInfo();
                    if (clickInfo != null) {
                        TCStatisticHelper.reportPublishClick("", clickInfo.query, clickInfo.lid, clickInfo.applid, clickInfo.referlid, TCStatisticHelper.VALUE_ACTION_PUBLISH);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void changeToSecondTab(final Function0 function) {
        HotDiscussionTabModel hotDiscussionTabModel = this.tabData;
        if (hotDiscussionTabModel == null || hotDiscussionTabModel.getTagIndex() == 1) {
            function.invoke();
            return;
        }
        this.mTabBar.setSelectedPosition(1);
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView == null || !hotDiscussionBaseView.isInit() || this.mCurHotDiscussionView.isEmpty()) {
            HotDiscussionBaseView hotDiscussionBaseView2 = this.mCurHotDiscussionView;
            if (hotDiscussionBaseView2 instanceof HotDiscussionGeneralView) {
                ((HotDiscussionGeneralView) hotDiscussionBaseView2).setHandleResponseCallback(new Function0<Unit>() {
                    public Unit invoke() {
                        function.invoke();
                        return null;
                    }
                });
                return;
            }
            return;
        }
        function.invoke();
    }

    /* access modifiers changed from: private */
    public void insertUgcData(final JSONObject object) {
        UiThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (HotDiscussionTabContainer.this.mCurHotDiscussionView != null) {
                    boolean removeOriginalData = HotDiscussionTabContainer.this.mCurHotDiscussionView instanceof HotDiscussionAllView;
                    int position = 0;
                    if (HotDiscussionTabContainer.this.mCurHotDiscussionView instanceof HotDiscussionAllView) {
                        position = HotDiscussionTabContainer.this.expressTemplateShowed ? 2 : HotDiscussionTabContainer.this.hasRealTimeStrong ? 1 : 0;
                    } else if (HotDiscussionTabContainer.this.mCurHotDiscussionView instanceof HotDiscussionRealTimeView) {
                        position = HotDiscussionTabContainer.this.expressTemplateShowed;
                    }
                    HotDiscussionTabContainer.this.mCurHotDiscussionView.setOneDynamicInfo(object, (int) position, removeOriginalData);
                    HotDiscussionTabContainer.this.mCurHotDiscussionView.showContent();
                }
            }
        });
    }

    public IResultPageTabContext getParentTabContext() {
        return this.mResultPageContext;
    }

    public void onCreate(Context context) {
        super.onCreate(context);
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            hotDiscussionBaseView.onCreate();
        }
        contentView();
    }

    public void onStart() {
        super.onStart();
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            hotDiscussionBaseView.onStart();
        }
    }

    public void onResume(Intent intent) {
        super.onResume(intent);
        this.isResume = true;
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            hotDiscussionBaseView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.isResume = false;
        if (this.mResultPageContext != null) {
            this.mResultPageContext.setWeakManagerBgColor(UiUtils.getColor(com.baidu.searchbox.searchhotdiscussiontab.R.color.weak_network_tip_bg_color_normal), UiUtils.getColor(com.baidu.searchbox.searchhotdiscussiontab.R.color.weak_network_tip_bg_color_night));
        }
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            hotDiscussionBaseView.onPause();
        }
        BdEventBus.Companion.getDefault().post(TextSelectDismissEvent.INSTANCE);
    }

    public void onStop() {
        super.onStop();
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            hotDiscussionBaseView.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        for (HotDiscussionBaseView discussionView : this.mHotDiscussionViewList) {
            discussionView.onDestroy();
        }
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onReEnter() {
        super.onReEnter();
        if (!this.mHasNetData) {
            hideNoResultView();
            clearCache();
            this.tabData = null;
            HotDiscussionTabBar hotDiscussionTabBar = this.mTabBar;
            if (hotDiscussionTabBar != null) {
                hotDiscussionTabBar.setSelectedPosition(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void hideNoResultView() {
        BdViewUtils.removeFromParent(this.mNoResultViewContainer);
        BdViewUtils.removeFromParent(this.mNoResultView);
        BdViewUtils.removeFromParent(this.mNoDiscussView);
        hideBubble();
    }

    private void clearCache() {
        if (this.tabData != null) {
            for (HotDiscussionBaseView hotDiscussionBaseView : this.mHotDiscussionViewList) {
                hotDiscussionBaseView.clearViewModelStore();
            }
        }
    }

    public ContainerAnimationInterceptor getContainerAnimation() {
        return null;
    }

    private void registerFontSizeChange() {
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, new Action<FontSizeChangeMessage>() {
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                if (HotDiscussionTabContainer.this.mTabBar != null) {
                    HotDiscussionTabContainer.this.mTabBar.onFontSizeChange();
                }
                if (HotDiscussionTabContainer.this.topTipComp != null) {
                    HotDiscussionTabContainer.this.topTipComp.onFontChanged(false);
                }
                if (HotDiscussionTabContainer.this.noResultTopTipComp != null) {
                    HotDiscussionTabContainer.this.noResultTopTipComp.onFontChanged(false);
                }
                if (HotDiscussionAbTest.INSTANCE.isGlobalNewStyle() && HotDiscussionTabContainer.this.mRsseView != null) {
                    HotDiscussionTabContainer.this.mRsseView.onFontSizeChanged();
                }
            }
        });
    }

    private void registerTextSelectStart() {
        BdEventBus.Companion.getDefault().register(this, OnTextSelectStart.class, new Action<OnTextSelectStart>() {
            public void call(OnTextSelectStart event) {
                int x = event.getPositionX();
                int y = event.getPositionY();
                if (HotDiscussionTabContainer.this.longPressInterface != null) {
                    HotDiscussionTabContainer.this.longPressInterface.showMenuDialog(x, y, "", "", "", 10, false, false);
                }
            }
        });
    }

    private void registerTextSelectChange() {
        BdEventBus.Companion.getDefault().register(this, OnTextSelectChanged.class, new Action<OnTextSelectChanged>() {
            public void call(OnTextSelectChanged event) {
                Rect rect = event.getCoordinateRect();
                if (HotDiscussionTabContainer.this.longPressInterface != null) {
                    HotDiscussionTabContainer.this.longPressInterface.showSelectionActionDialog(rect.top, rect.bottom, rect.left, rect.right, event.getText(), false, false);
                    HotDiscussionTabContainer.this.longPressInterface.setMenuClickListener(HotDiscussionTabContainer.this.onSelMenuClickListener);
                }
            }
        });
    }

    private void registerTextSelectCancel() {
        BdEventBus.Companion.getDefault().register(this, MenuDismissEvent.class, new Action<MenuDismissEvent>() {
            public void call(MenuDismissEvent event) {
                if (HotDiscussionTabContainer.this.longPressInterface != null) {
                    HotDiscussionTabContainer.this.longPressInterface.hideSelectionActionDialog();
                }
            }
        });
    }

    public void onNightModeChanged(boolean nightMode) {
        super.onNightModeChanged(nightMode);
        updateRootBg(nightMode);
        HotDiscussionTabBar hotDiscussionTabBar = this.mTabBar;
        if (hotDiscussionTabBar != null) {
            hotDiscussionTabBar.onNightModeChanged();
        }
        View view2 = this.mSpaceView;
        if (view2 != null) {
            UiUtils.setViewColor(view2, com.baidu.android.common.ui.style.R.color.GC9);
        }
        if (this.mUgcImage != null) {
            if (ResultPageABTest.isAllTabSupportImmerse()) {
                this.mUgcImage.setImageResource(com.baidu.searchbox.searchhotdiscussion.R.drawable.browser_na_hot_discussion_ugc_new);
            } else {
                this.mUgcImage.setImageResource(com.baidu.searchbox.searchhotdiscussion.R.drawable.browser_na_hot_discussion_ugc);
            }
        }
        SearchHotTopicCardView searchHotTopicCardView = this.mCardView;
        if (searchHotTopicCardView != null) {
            searchHotTopicCardView.applyFeedNightMode();
            this.mCardView.update(getEmptyModel().cardModel, (Map<String, Object>) null);
        }
        SearchRsseView searchRsseView = this.mRsseView;
        if (searchRsseView != null) {
            searchRsseView.onNightModeChanged();
        }
        TopTipComp topTipComp2 = this.topTipComp;
        if (topTipComp2 != null) {
            topTipComp2.onNightModeChanged();
        }
        TopTipComp topTipComp3 = this.noResultTopTipComp;
        if (topTipComp3 != null) {
            topTipComp3.onNightModeChanged();
        }
    }

    private void updateRootBg(boolean nightMode) {
        if (!ResultPageABTest.isNewTabFrameworkOpen() || ResultPageABTest.isResultPageNewStyle()) {
            setPageBg(this.mRootView, nightMode);
            return;
        }
        setPageBg(this.mViewPager, nightMode);
        setPageBg(this.topViewChildContainer, nightMode);
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            nestedScrollParentRelativeLayout.setBackground((Drawable) null);
        }
    }

    private void setPageBg(View bgView, boolean nightMode) {
        if (bgView == null) {
            return;
        }
        if (!ResultPageABTest.isNewDoubleTab() || nightMode) {
            bgView.setBackground((Drawable) null);
            UiUtils.setViewColor(bgView, com.baidu.searchbox.generalcommunity.R.color.community_template_background_color);
            return;
        }
        bgView.setBackgroundColor(0);
        bgView.setBackground(ContextCompat.getDrawable(AppRuntime.getAppContext(), com.baidu.searchbox.searchhotdiscussiontab.R.drawable.tab_layout_bg));
    }

    private void updateTagLayout() {
        ViewGroup.LayoutParams params;
        if (this.mTabLayout != null && ResultPageABTest.isNewDoubleTab() && (params = this.mTabLayout.getLayoutParams()) != null) {
            params.width = -1;
            params.height = -2;
            this.mTabLayout.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: protected */
    public void handleRequestStart(int request) {
    }

    /* access modifiers changed from: protected */
    public void handleSuccessResponse(final int requestType, String responseString, BaseNaTabContainer.IHandleResponseFinish callback) {
        if (this.mCurHotDiscussionView != null) {
            HotDiscussionTabLayout hotDiscussionTabLayout = this.mTabLayout;
            if (hotDiscussionTabLayout != null) {
                hotDiscussionTabLayout.setVisibility(0);
            }
            HotDiscussionTabModel tabModel = new HotDiscussionTabModel().toModel(responseString);
            if (tabModel.isValid()) {
                if (this.tabData == null) {
                    this.tabData = tabModel;
                    updatePageList();
                } else {
                    this.tabData = tabModel;
                }
            } else if (this.tabData == null) {
                updatePageList(isContainRealTimeTab(responseString));
            }
            this.mCurHotDiscussionView.handleSuccessResponse(requestType, responseString, callback, new HotDiscussionBaseView.OnTcReportListener() {
                public void tcReport() {
                    if (requestType == 1 && HotDiscussionTabContainer.this.reportAfterResponse && !HotDiscussionTabContainer.this.isClickToSort) {
                        HotDiscussionTabContainer.this.reportTagClick();
                        boolean unused = HotDiscussionTabContainer.this.reportAfterResponse = false;
                    }
                    if (HotDiscussionTabContainer.this.hasReportClickMore) {
                        HotDiscussionTabContainer.this.reportTcClickMore();
                        boolean unused2 = HotDiscussionTabContainer.this.hasReportClickMore = false;
                    }
                }
            });
        }
        if (this.mResultPageContext != null) {
            this.mResultPageContext.setPullReload(false);
        }
        TopTipData data = TopTipData.Companion.fromJsonStr(responseString);
        if (data != null) {
            TopTipComp topTipComp2 = this.topTipComp;
            if (topTipComp2 == null) {
                this.topTipComp = TopTipComp.Companion.createTopTipComp(this.mRootView, data);
            } else {
                topTipComp2.setData(data);
            }
            HotDiscussionRsseViewModel hotDiscussionRsseViewModel = this.mRsseViewModel;
            if (hotDiscussionRsseViewModel != null) {
                hotDiscussionRsseViewModel.showRsseView(false);
                return;
            }
            return;
        }
        TopTipComp topTipComp3 = this.topTipComp;
        if (topTipComp3 != null) {
            topTipComp3.setData((TopTipData) null);
        }
        HotDiscussionRsseViewModel hotDiscussionRsseViewModel2 = this.mRsseViewModel;
        if (hotDiscussionRsseViewModel2 != null) {
            hotDiscussionRsseViewModel2.handleRsseData(responseString);
        }
    }

    private boolean isContainRealTimeTab(String responseString) {
        JSONObject itemList;
        JSONObject pageConfig;
        if (TextUtils.isEmpty(responseString)) {
            return false;
        }
        try {
            JSONObject data = new JSONObject(responseString).optJSONObject("data");
            if (data == null || (itemList = data.optJSONObject("itemlist")) == null || (pageConfig = itemList.optJSONObject("pageConfig")) == null) {
                return false;
            }
            int strongStatus = pageConfig.optInt("is_strong");
            boolean z = true;
            this.expressTemplateShowed = pageConfig.optInt("has_attitude") == 1;
            this.isSelectRealTime = pageConfig.optInt("is_realtime") == 1;
            if (strongStatus != 1) {
                z = false;
            }
            this.hasRealTimeStrong = z;
            return z;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public void switchToRealTimeTab() {
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            nestedScrollParentRelativeLayout.resetPosition();
        }
        HotDiscussionTabBar hotDiscussionTabBar = this.mTabBar;
        if (hotDiscussionTabBar != null) {
            hotDiscussionTabBar.setSelectedPosition(1);
        }
    }

    /* access modifiers changed from: protected */
    public void handleFailResponse(int requestType, Exception e2) {
        if (this.mResultPageContext != null) {
            this.mResultPageContext.setPullReload(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean needUpdateRefreshUrl(int requestType) {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> getUrlParams(int r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            com.baidu.browser.tabna.IResultPageTabContext r1 = r3.mResultPageContext
            if (r1 == 0) goto L_0x001d
            com.baidu.browser.tabna.IResultPageTabContext r1 = r3.mResultPageContext
            java.util.Map r1 = r1.getExtraInfoFromWindow()
            if (r1 == 0) goto L_0x001d
            com.baidu.browser.tabna.IResultPageTabContext r1 = r3.mResultPageContext
            java.util.Map r1 = r1.getExtraInfoFromWindow()
            java.lang.String r2 = "applid"
            java.lang.Object r1 = r1.get(r2)
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x001d:
            com.baidu.searchbox.hotdiscussion.view.HotDiscussionBaseView r1 = r3.mCurHotDiscussionView
            java.util.Map r1 = r1.getUrlParams(r4, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hotdiscussion.HotDiscussionTabContainer.getUrlParams(int):java.util.Map");
    }

    public void setIsRefreshEnable(boolean isRefreshEnable) {
    }

    /* access modifiers changed from: protected */
    public void showContentView(boolean isShow) {
        super.showContentView(isShow);
        showViewVisible(this.mUgcImage, isShow);
        showViewVisible(this.mTabBar, isShow);
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null && hotDiscussionBaseView.getCommunityUI() != null) {
            if (isShow) {
                this.mCurHotDiscussionView.getCommunityUI().startPlayIfNeeded();
            } else {
                this.mCurHotDiscussionView.getCommunityUI().stopPlayCurTemplate(1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initTabDurationParams() {
        this.mTabDuration.setSource(DurationManagerKt.SOURCE_TAB_HOTDISCUSSION);
        this.mTabDuration.setProductForPst(SstPstUtils.SST_PST_PRODUCT_TAB_HOTDISCUSSION);
        super.initTabDurationParams();
    }

    private void showViewVisible(View view2, boolean isShow) {
        if (view2 == null) {
            return;
        }
        if (isShow) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    private void initStatusTargetFactory() {
        this.mStatusTargetFactory = new StatusTargetImpl() {
            public boolean showCustomShimmerView(boolean isShow) {
                if (!HotDiscussionTabContainer.DEBUG) {
                    return true;
                }
                Log.v(HotDiscussionTabContainer.TAG, "showCustomShimmerView isShow = " + isShow);
                return true;
            }

            public boolean showCustomErrorView(boolean isShow) {
                HotDiscussionTabContainer.this.showErrorPage(isShow);
                return true;
            }
        };
    }

    private void initConfigOptions() {
        this.mConfigOptions = new ConfigOptions().setColdBootPolicy(0).setNeedAutoRefresh(false).setGetRequest(true).setPrefetchPolicy(true).setFilterPolicy(false).setProcessDuplicatePolicy(2).reportTemplateRuntimeStatus(false).setLoadHistoryPolicy(false).setPtrEnabled(false).setNestedPtr(true).needLoadMore(true).setShareFrom(ConfigOptions.SHARE_FROM_SEARCH_REYI).setEnableTextSelected(HotDiscussionAbTest.INSTANCE.isTextSelEnable()).postRequestBuilder(19, 0, 109);
    }

    private void initHotDiscussionView() {
        this.mHotDiscussionViewList.add(getAllTabView());
        HotDiscussionBaseView hotDiscussionBaseView = this.mHotDiscussionTagAllView;
        this.mCurHotDiscussionView = hotDiscussionBaseView;
        hotDiscussionBaseView.onResume();
        registerShowCenterAttitudeEvent();
        registerInvokeAppEvent();
        registerSwitchTabEvent();
        registerTcReportEvent();
    }

    private void registerShowCenterAttitudeEvent() {
        BdEventBus.Companion.getDefault().register(this, AttitudeEvent.class, new Action<AttitudeEvent>() {
            public void call(AttitudeEvent attitudeEvent) {
                if (attitudeEvent != null && HotDiscussionTabContainer.this.isResume) {
                    if (HotDiscussionTabContainer.this.mAttitudeView == null) {
                        CenterAttitudeView unused = HotDiscussionTabContainer.this.mAttitudeView = (CenterAttitudeView) HotDiscussionTabContainer.this.mAttitudeViewStub.inflate().findViewById(com.baidu.searchbox.searchhotdiscussiontab.R.id.hot_discussion_attitude_view);
                        HotDiscussionTabContainer.this.setAttitudeViewLocation();
                    }
                    if (attitudeEvent.eventStatus == 1) {
                        HotDiscussionTabContainer.this.mAttitudeView.preLoadImageUrlList(attitudeEvent.allImageUrl);
                    } else if (attitudeEvent.scaleStatus == 0) {
                        HotDiscussionTabContainer.this.mAttitudeView.cancelAnimatorSet();
                    } else if (!TextUtils.isEmpty(attitudeEvent.imageUrl)) {
                        HotDiscussionTabContainer.this.mAttitudeView.setAttitudeImage(attitudeEvent.imageUrl);
                        HotDiscussionTabContainer.this.mAttitudeView.animatorStart();
                    }
                }
            }
        });
    }

    private void registerInvokeAppEvent() {
        BdEventBus.Companion.getDefault().register(this, InvokeAppEvent.class, new Action<InvokeAppEvent>() {
            public void call(InvokeAppEvent invokeAppEvent) {
                if (invokeAppEvent != null) {
                    InvokeCookieManager.getInstance().asyncCookie(invokeAppEvent.getStrategyPos());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setAttitudeViewLocation() {
        CenterAttitudeView centerAttitudeView = this.mAttitudeView;
        if (centerAttitudeView != null) {
            centerAttitudeView.post(new Runnable() {
                public void run() {
                    float high = (float) DeviceUtils.ScreenInfo.getDisplayHeight(HotDiscussionTabContainer.this.mContext);
                    float viewWidth = (float) HotDiscussionTabContainer.this.mContext.getResources().getDimensionPixelSize(com.baidu.searchbox.searchhotdiscussiontab.R.dimen.search_hot_discussion_center_attitude_width);
                    float yLocation = ((high / 2.0f) - (viewWidth / 2.0f)) - (high - ((float) HotDiscussionTabContainer.this.rootView().getHeight()));
                    HotDiscussionTabContainer.this.mAttitudeView.setX((((float) DeviceUtils.ScreenInfo.getDisplayWidth(HotDiscussionTabContainer.this.mContext)) / 2.0f) - (viewWidth / 2.0f));
                    HotDiscussionTabContainer.this.mAttitudeView.setY(yLocation);
                }
            });
        }
    }

    private void registerSwitchTabEvent() {
        BdEventBus.Companion.getDefault().register(this, SwitchHotDiscussionTabEvent.class, new Action<SwitchHotDiscussionTabEvent>() {
            public void call(SwitchHotDiscussionTabEvent switchHotDiscussionTabEvent) {
                if (HotDiscussionTabContainer.this.isResume) {
                    HotDiscussionTabContainer.this.switchToRealTimeTab();
                }
            }
        });
    }

    private void registerTcReportEvent() {
        BdEventBus.Companion.getDefault().register(this, HotDiscussionTcEvent.class, new Action<HotDiscussionTcEvent>() {
            public void call(HotDiscussionTcEvent hotDiscussionTcEvent) {
                if (HotDiscussionTabContainer.this.isResume) {
                    HotDiscussionTabContainer.this.reportTcLayoutClick(hotDiscussionTcEvent);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void reportTcLayoutClick(HotDiscussionTcEvent hotDiscussionTcEvent) {
        if (hotDiscussionTcEvent != null) {
            if (hotDiscussionTcEvent.getReportLocal() == 0) {
                this.hasReportClickMore = true;
            }
            if (this.mCurHotDiscussionView != null) {
                switch (hotDiscussionTcEvent.getReportLocal()) {
                    case 0:
                        reportTcClickMore();
                        return;
                    case 1:
                        reportTcClickAttitude(hotDiscussionTcEvent);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportTcClickMore() {
        PageConfig.ClickInfo clickInfo = this.mCurHotDiscussionView.getClickInfo();
        if (clickInfo != null) {
            TCStatisticHelper.reportMoreClick("", clickInfo.query, clickInfo.lid, clickInfo.applid, clickInfo.referlid);
        }
    }

    private void reportTcClickAttitude(HotDiscussionTcEvent hotDiscussionTcEvent) {
        PageConfig.ClickInfo clickInfo = this.mCurHotDiscussionView.getClickInfo();
        if (clickInfo != null) {
            TCStatisticHelper.reportAttitudeClick("", clickInfo.query, clickInfo.lid, clickInfo.applid, clickInfo.referlid, hotDiscussionTcEvent.getAction());
        }
    }

    private HotDiscussionBaseView getAllTabView() {
        if (this.mHotDiscussionTagAllView == null) {
            HotDiscussionBaseView hotDiscussionTagAllView = new HotDiscussionAllView(createBuilder(SEARCH_HOT_SPOT_ALL));
            hotDiscussionTagAllView.addRefreshResultCallback(this);
            hotDiscussionTagAllView.onCreate();
            setRefreshListener(hotDiscussionTagAllView);
            this.mHotDiscussionTagAllView = hotDiscussionTagAllView;
        }
        return this.mHotDiscussionTagAllView;
    }

    private HotDiscussionBaseView getNewTabView() {
        if (this.mHotDiscussionTagNewView == null) {
            HotDiscussionBaseView hotDiscussionTagNewView = new HotDiscussionNewView(createBuilder(SEARCH_HOT_SPOT_NEW));
            hotDiscussionTagNewView.addRefreshResultCallback(this);
            hotDiscussionTagNewView.onCreate();
            setRefreshListener(hotDiscussionTagNewView);
            this.mHotDiscussionTagNewView = hotDiscussionTagNewView;
        }
        return this.mHotDiscussionTagNewView;
    }

    private HotDiscussionBaseView getRealTimeTabView() {
        if (this.mHotDiscussionTagRealTimeView == null) {
            HotDiscussionBaseView hotDiscussionTagRealTimeView = new HotDiscussionRealTimeView(createBuilder(SEARCH_HOT_SPOT_REAL_TIME));
            hotDiscussionTagRealTimeView.addRefreshResultCallback(this);
            hotDiscussionTagRealTimeView.onCreate();
            setRefreshListener(hotDiscussionTagRealTimeView);
            this.mHotDiscussionTagRealTimeView = hotDiscussionTagRealTimeView;
        }
        return this.mHotDiscussionTagRealTimeView;
    }

    private HotDiscussionBaseView createGeneralTabView(HotDiscussionGeneralView.TabInfo tabInfo, int index) {
        HotDiscussionBaseView generalTabView = new HotDiscussionGeneralView(createBuilder(SEARCH_HOT_SPOT_GENERAL_PREFIX + index + tabInfo.getTabValue()), tabInfo);
        generalTabView.addRefreshResultCallback(this);
        generalTabView.onCreate();
        setRefreshListener(generalTabView);
        return generalTabView;
    }

    private void setRefreshListener(HotDiscussionBaseView hotDiscussionBaseView) {
        if (hotDiscussionBaseView != null) {
            final WeakReference<IResultPageTabContext> resultPageFeatureRef = new WeakReference<>(this.mResultPageContext);
            hotDiscussionBaseView.setPullRefreshDataListener(new GCommunityUI.PullRefreshDataListener() {
                public void onPullRefreshData() {
                    HotDiscussionTabContainer.this.mHasNetData = false;
                    IResultPageTabContext resultPageTabContext = (IResultPageTabContext) resultPageFeatureRef.get();
                    if (resultPageTabContext != null) {
                        resultPageTabContext.setPullReload(true);
                    }
                    HotDiscussionTabContainer hotDiscussionTabContainer = HotDiscussionTabContainer.this;
                    hotDiscussionTabContainer.mRefreshUrl = (String) hotDiscussionTabContainer.mRefreshUrlMap.get(String.valueOf(HotDiscussionTabContainer.this.mCurPos));
                    HotDiscussionTabContainer.this.requestUrl(-4);
                }
            });
            if (this.mContext != null) {
                hotDiscussionBaseView.setRefreshTips(this.mContext.getResources().getString(com.baidu.searchbox.searchhotdiscussiontab.R.string.hot_discussion_tab_refresh_complete));
            }
        }
    }

    private HotDiscussionBaseView.Builder createBuilder(String business) {
        return new HotDiscussionBaseView.Builder(this.mContext, business + getContainerId(), this.mTabItem, this).setConfigOptions(this.mConfigOptions).setStatusTargetFactory(this.mStatusTargetFactory);
    }

    public boolean canScrollDown() {
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        return hotDiscussionBaseView != null && hotDiscussionBaseView.canScrollDown();
    }

    public void scrollToTop() {
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            nestedScrollParentRelativeLayout.resetPosition();
        }
        for (HotDiscussionBaseView baseView : this.mHotDiscussionViewList) {
            baseView.scrollToTop();
        }
    }

    public void onSuccess() {
        naPageShowStatistics();
    }

    public void onFail() {
    }

    public void hideTabBar() {
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            nestedScrollParentRelativeLayout.hideTopView();
        }
    }

    public void showContainer(final int state) {
        super.showContainer(state);
        UiThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (state == 4) {
                    if (!HotDiscussionTabContainer.this.showNoDiscussView()) {
                        HotDiscussionTabContainer.this.showNoResultViewWithRecommendCard();
                    }
                    HotDiscussionTabContainer.this.showLoadingView(false);
                    HotDiscussionTabContainer.this.showErrorPage(false);
                    HotDiscussionTabContainer.super.showContentView(true);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onHandleNotShowGroupCard(boolean hasPeakParams) {
        if (ResultPageABTest.isNewDoubleTab() && HotDiscussionAbTest.INSTANCE.isHideSubTab() && !HotDiscussionAbTest.INSTANCE.isGlobalNewStyle()) {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (HotDiscussionTabContainer.this.mResultPageContext != null && HotDiscussionTabContainer.this.mTabItem != null && !TextUtils.isEmpty(HotDiscussionTabContainer.this.mTabItem.pd)) {
                        HotDiscussionTabContainer.this.mResultPageContext.setTabGroupCardParams(NaGroupCardParamsUtils.buildDefaultPeakParams(HotDiscussionTabContainer.this.mTabItem.pd));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public EmptyPageModel parseEmptyModel(JSONObject jsonObject) {
        return new HotDiscussionEmptyPageModel().parseJson(jsonObject);
    }

    /* access modifiers changed from: protected */
    public void onShowNoResultWithRecommend(int requestType, String recommendData, boolean forceClear) {
        onShowNoResultWithoutRecommend();
    }

    /* access modifiers changed from: protected */
    public void onShowNoResultWithoutRecommend() {
        if (getEmptyModel() == null || !getEmptyModel().isHasRecommendCard) {
            showContainer(3);
        } else {
            showContainer(4);
        }
    }

    /* access modifiers changed from: private */
    public void showNoResultViewWithRecommendCard() {
        if (this.mRootView != null && this.mContext != null && this.mTabItem != null && getEmptyModel() != null) {
            if (this.mNoResultView == null) {
                this.mNoResultView = new NoResultView(this.mContext, this.mTabItem.title);
                this.mNoResultView.setLoadUrlListener(this);
            }
            this.mNoResultView.update(getEmptyModel());
            if (getEmptyModel().cardModel.data != null && this.mNoResultView.getParent() == null) {
                handleEmptyViewWithRecomCard();
            } else if (this.mNoResultView.getParent() == null) {
                handleEmptyView();
            }
            this.mNoResultView.setVisibility(0);
        }
    }

    private void handleEmptyViewWithRecomCard() {
        if (DEBUG) {
            Log.i(TAG, "handleEmptyViewWithRecomCard");
        }
        this.mNoResultViewContainer = new ScrollView(this.mContext);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        setPaddingInNewTab(linearLayout);
        this.mNoResultViewContainer.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        this.mRootView.addView(this.mNoResultViewContainer, new ViewGroup.LayoutParams(-1, -1));
        TopTipComp topTipComp2 = this.noResultTopTipComp;
        View topTipContainer = topTipComp2 != null ? topTipComp2.getTopTipParent() : null;
        if (topTipContainer != null) {
            BdViewUtils.removeFromParent(topTipContainer);
            if (topTipComp2.getTipData() != null) {
                linearLayout.addView(topTipContainer, -1, -2);
            }
        }
        linearLayout.addView(this.mNoResultView, new LinearLayout.LayoutParams(-1, -2));
        this.mNoResultView.setGuideLineEnd(this.mContext.getResources().getDimensionPixelOffset(com.baidu.searchbox.searchhotdiscussiontab.R.dimen.search_hot_no_result_guideline_margin_end));
        SearchHotTopicCardView searchHotTopicCardView = new SearchHotTopicCardView(this.mContext);
        this.mCardView = searchHotTopicCardView;
        searchHotTopicCardView.applyFeedNightMode();
        this.mCardView.update(getEmptyModel().cardModel, (Map<String, Object>) null);
        linearLayout.addView(this.mCardView, new LinearLayout.LayoutParams(-1, -2));
        this.mNoResultView.setDividerVisibility(0);
    }

    private void handleEmptyView() {
        if (DEBUG) {
            Log.i(TAG, "handleEmptyView");
        }
        addNoResultViewWithTopTips(this.mRootView);
    }

    private void addNoResultViewWithTopTips(ViewGroup rootView) {
        if (rootView != null && this.mNoResultView != null) {
            BdViewUtils.removeFromParent(this.mNoResultView);
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(-1, -1);
            TopTipComp topTipComp2 = this.noResultTopTipComp;
            if (topTipComp2 != null) {
                LinearLayout linearLayout = this.noResultParent;
                if (linearLayout == null) {
                    LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                    this.noResultParent = linearLayout2;
                    linearLayout2.setOrientation(1);
                } else {
                    BdViewUtils.removeFromParent(linearLayout);
                    this.noResultParent.removeAllViews();
                }
                BdViewUtils.removeFromParent(topTipComp2.getTopTipParent());
                if (topTipComp2.getTipData() != null) {
                    this.noResultParent.addView(topTipComp2.getTopTipParent(), -1, -2);
                }
                this.noResultParent.addView(this.mNoResultView, -1, -1);
                rootView.addView(this.noResultParent, params);
                setPaddingInNewTab(this.noResultParent);
                this.noResultParent.setVisibility(0);
                this.mNoResultView.setVisibility(0);
                return;
            }
            setMarginInNewTab(params);
            rootView.addView(this.mNoResultView, params);
            this.mNoResultView.setVisibility(0);
        }
    }

    private void setMarginInNewTab(ViewGroup.MarginLayoutParams lp) {
        if (lp != null && ResultPageABTest.isNewTabFrameworkOpen() && !ResultPageABTest.isResultPageNewStyle()) {
            lp.topMargin = this.topPaddingInNewTab;
        }
    }

    private void setPaddingInNewTab(View view2) {
        if (view2 != null && ResultPageABTest.isNewTabFrameworkOpen() && !ResultPageABTest.isResultPageNewStyle()) {
            view2.setPadding(view2.getPaddingLeft(), this.topPaddingInNewTab, view2.getPaddingRight(), view2.getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void showNoResultView(boolean isShow) {
        if (!isShow || !showNoDiscussView()) {
            showHotNoResultView(isShow);
        }
    }

    private void showHotNoResultView(boolean isShow) {
        View rootView = rootView();
        if ((rootView instanceof ViewGroup) && this.mContext != null && this.mTabItem != null) {
            if (isShow) {
                if (this.mNoResultView == null) {
                    this.mNoResultView = new NoResultView(this.mContext, this.mTabItem.title);
                    this.mNoResultView.setLoadUrlListener(this);
                }
                this.mNoResultView.update(this.mNoResultModel);
                addNoResultViewWithTopTips((ViewGroup) rootView);
                return;
            }
            if (this.mNoResultView != null) {
                this.mNoResultView.setVisibility(8);
            }
            LinearLayout linearLayout = this.noResultParent;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean showNoDiscussView() {
        HotDiscussionTabModel hotDiscussionTabModel;
        if (this.mRootView == null || this.mContext == null || (hotDiscussionTabModel = this.tabData) == null || hotDiscussionTabModel.getTagIndex() != 1) {
            return false;
        }
        HotDiscussionNoDiscussView hotDiscussionNoDiscussView = this.mNoDiscussView;
        if (hotDiscussionNoDiscussView == null) {
            this.mNoDiscussView = new HotDiscussionNoDiscussView(this.mContext);
        } else {
            BdViewUtils.removeFromParent(hotDiscussionNoDiscussView);
        }
        TopTipComp tipComp = this.noResultTopTipComp;
        if (tipComp != null) {
            View topTipParent = tipComp.getTopTipParent();
            BdViewUtils.removeFromParent(topTipParent);
            setPaddingInNewTab(topTipParent);
            if (tipComp.getTipData() != null) {
                this.mRootView.addView(topTipParent, -1, -2);
            }
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
            params.addRule(13);
            this.mRootView.addView(this.mNoDiscussView, params);
        } else {
            setPaddingInNewTab(this.mNoDiscussView);
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(-2, -2);
            params2.addRule(13);
            this.mRootView.addView(this.mNoDiscussView, params2);
        }
        BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(this.mContext.getString(com.baidu.searchbox.searchhotdiscussiontab.R.string.hot_discussion_no_discuss_guide)).setAnchorView((View) this.mUgcImage).enableAnimation(true).enableClkDismiss(true).setForceShowPosition(BubblePosition.LEFT).build();
        this.bubbleManager = build;
        build.showBubble();
        return true;
    }

    private void hideBubble() {
        BubbleTextManager bubbleTextManager = this.bubbleManager;
        if (bubbleTextManager != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    /* access modifiers changed from: protected */
    public boolean showNoResultIfNeeded(JSONObject responseJson, boolean isShow) {
        HotDiscussionTabModel hotDiscussionTabModel;
        if (DEBUG) {
            Log.i(TAG, "showNoResultIfNeeded");
        }
        TopTipData data = TopTipData.Companion.fromJson(responseJson);
        TopTipComp topTipComp2 = this.noResultTopTipComp;
        if (topTipComp2 != null) {
            topTipComp2.setData(data);
        } else if (data != null) {
            this.noResultTopTipComp = TopTipComp.Companion.createTopTipCompForNoResult(this.mContext, data);
        }
        if (this.isPublishing) {
            return false;
        }
        if (this.tabData == null) {
            HotDiscussionTabModel tabModel = new HotDiscussionTabModel().toModel(responseJson.toString());
            if (tabModel.isValid() && tabModel.getTagIndex() == 1) {
                this.tabData = tabModel;
                UiThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        HotDiscussionTabContainer.this.updatePageList();
                    }
                });
            }
        }
        boolean showNoResult = super.showNoResultIfNeeded(responseJson, isShow);
        if (!showNoResult || (hotDiscussionTabModel = this.tabData) == null || hotDiscussionTabModel.getTagIndex() != 1) {
            return showNoResult;
        }
        return false;
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    private HotDiscussionEmptyPageModel getEmptyModel() {
        return (HotDiscussionEmptyPageModel) this.mNoResultModel;
    }

    public int getTabTopOffset() {
        int topOffset = 0;
        int listOffset = 0;
        NestedScrollParentRelativeLayout nestedScrollParentRelativeLayout = this.mRootView;
        if (nestedScrollParentRelativeLayout != null) {
            topOffset = nestedScrollParentRelativeLayout.getScrollOffset();
        }
        HotDiscussionBaseView hotDiscussionBaseView = this.mCurHotDiscussionView;
        if (hotDiscussionBaseView != null) {
            listOffset = hotDiscussionBaseView.getScrollOffset();
        }
        if (DEBUG) {
            Log.d(TAG, "----->>>getTabTopOffset=" + (topOffset + listOffset));
        }
        return topOffset + listOffset;
    }

    public void setBottomOffset(int offset) {
        if (this.mUgcImage != null && this.mResultPageContext != null && ResultPageABTest.isNewDoubleTab()) {
            ViewGroup.LayoutParams params = this.mUgcImage.getLayoutParams();
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) params).bottomMargin = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 7.0f) + offset;
                this.mUgcImage.setLayoutParams(params);
            }
        }
    }
}
