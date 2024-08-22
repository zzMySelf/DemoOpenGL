package com.baidu.searchbox.home.tabs.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.IDataObserver;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.MessageCenterService;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.aipersonal.PersonalABManagerWrapper;
import com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper;
import com.baidu.searchbox.aipersonal.PersonalAiFragment;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.environment.runtime.NovelRuntime;
import com.baidu.searchbox.feed.event.FeedRecommendRefreshEvent;
import com.baidu.searchbox.feed.event.HomeFeedTabEvent;
import com.baidu.searchbox.feed.newsflash.ui.fragment.NewsFlashFragment;
import com.baidu.searchbox.feed.refreshex.BaiduLogoRefreshRevolutionary;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.tab.model.VideoTabTracker;
import com.baidu.searchbox.feed.tab.navigation.manager.TabNavDataManager;
import com.baidu.searchbox.feed.tab.utils.FeedCloudTabUtil;
import com.baidu.searchbox.home.fragment.HomeFragment;
import com.baidu.searchbox.home.tabs.BaseTabItemView;
import com.baidu.searchbox.home.tabs.HomeTabInfo;
import com.baidu.searchbox.home.tabs.HomeTabManager;
import com.baidu.searchbox.home.tabs.HomeTabTextHolder;
import com.baidu.searchbox.home.tabs.IHomeTabFetcher;
import com.baidu.searchbox.home.tabs.NoneFragment;
import com.baidu.searchbox.home.tabs.ServiceCenterFourTabFragment;
import com.baidu.searchbox.home.tabs.TabManager;
import com.baidu.searchbox.home.tabs.bubble.HomeTabBubbleManager;
import com.baidu.searchbox.home.tabs.constants.HomeAbtestConstants;
import com.baidu.searchbox.home.tabs.constants.HomeTabConstants;
import com.baidu.searchbox.home.tabs.constants.HomeTabUBCConstants;
import com.baidu.searchbox.home.tabs.ioc.IHomeTabApp;
import com.baidu.searchbox.home.tabs.pad.PadHomeTabInfo;
import com.baidu.searchbox.home.tabs.utils.DefaultHomeBarUbcManagerKt;
import com.baidu.searchbox.home.tabs.utils.DynamicTabTypeUtilsKt;
import com.baidu.searchbox.home.tabs.utils.HomeDynamicTabUtils;
import com.baidu.searchbox.home.tabs.utils.HomeDynamicTabValue;
import com.baidu.searchbox.home.tabs.utils.HomeTabImmerseHelper;
import com.baidu.searchbox.home.tabs.utils.HomeTabUbcUtilsKt;
import com.baidu.searchbox.home.tabs.utils.HomeTabUtils;
import com.baidu.searchbox.home.tabs.utils.MessageFunctionOpStatKt;
import com.baidu.searchbox.home.tabs.utils.ThirdTabTypeUtilsKt;
import com.baidu.searchbox.home.tabs.youth.YouthHomeTabDataUtilKt;
import com.baidu.searchbox.home.tabs.youth.YouthHomeTabInfo;
import com.baidu.searchbox.kmm.home.lv1tab.HomeLv1TabDataMgr;
import com.baidu.searchbox.kmm.home.pad.PadHomeSideBarMgr;
import com.baidu.searchbox.kmm.home.pad.PadHomeSideBarModel;
import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.kmm.home.tab.HomeSecondTabTypeUtils;
import com.baidu.searchbox.kmm.home.tab.HomeTabTextDataMgr;
import com.baidu.searchbox.kmm.home.youth.YouthHomeBottomTabModel;
import com.baidu.searchbox.kmm.home.youth.YouthHomeSwitchMgr;
import com.baidu.searchbox.launch.task.UniTask;
import com.baidu.searchbox.launch.task.UniTaskBuilder;
import com.baidu.searchbox.launch.task.UniTaskManager;
import com.baidu.searchbox.message.tab.MessageCenterTabService;
import com.baidu.searchbox.novel.ioc.container.INovelAbility;
import com.baidu.searchbox.personal.PersonalMixFragment;
import com.baidu.searchbox.personal.PersonalizedFragment;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.baidu.searchbox.video.inf.VideoTabService;
import com.baidu.searchbox.youthhome.IYouthHomeApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeTabFetcher implements IHomeTabFetcher {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int MSG_TYPE_DEFAULT = 0;
    private static final int MSG_TYPE_SHOW_NUMBER = 1;
    private static final int MSG_TYPE_SHOW_RED_DOT = 2;
    private static final String TAG = "HomeTabFetcher";
    private static final String TASK_NAME_REGISTER_MSG = "home_tab_register_msg";
    /* access modifiers changed from: private */
    public boolean hasRegisterIdleTask = false;
    private ArrayList<String> mActiveHomeTabTagList = new ArrayList<>();
    private SimpleActivityLifeCycle mHomeLifecycle;

    public void onInit() {
        parseTabTextSwitch(AbTestManager.getInstance().getSwitch("home_tab_text_switch", HomeAbtestConstants.BOTTOM_TAB_TEXT_AB_SWITCH_A));
        registerHomeLifeCycle();
    }

    public ArrayList<HomeTabInfo> createHomeTabInfoList(Context context) {
        if (TabManager.isSideBarStyle()) {
            return createPadTabInfoList(context);
        }
        boolean teenager = StyleMode.INSTANCE.isTeenagerStyle();
        ArrayList<HomeTabInfo> defaultTabInfos = new ArrayList<>();
        if (teenager) {
            HomeTabInfo feed = new HomeTabInfo();
            HomeTabInfo voice = new HomeTabInfo();
            HomeTabInfo personal = new HomeTabInfo();
            buildFeedTab(context, feed);
            buildThirdTab(voice);
            buildPersonalTab(context, personal);
            ArrayList<String> activeHomeTabTagList = new ArrayList<>();
            activeHomeTabTagList.add(feed.getTag());
            activeHomeTabTagList.add(voice.getTag());
            activeHomeTabTagList.add(personal.getTag());
            this.mActiveHomeTabTagList = activeHomeTabTagList;
            HomeTabUtils.update(activeHomeTabTagList);
            defaultTabInfos.add(feed);
            defaultTabInfos.add(voice);
            defaultTabInfos.add(personal);
        } else {
            HomeTabInfo feed2 = new HomeTabInfo();
            HomeTabInfo secondTab = new HomeTabInfo();
            HomeTabInfo voice2 = new HomeTabInfo();
            HomeTabInfo fourthTab = new HomeTabInfo();
            HomeTabInfo personal2 = new HomeTabInfo();
            buildFeedTab(context, feed2);
            buildSecondTab(context, secondTab);
            buildThirdTab(voice2);
            buildFourthTab(context, fourthTab);
            buildPersonalTab(context, personal2);
            ArrayList<String> activeHomeTabTagList2 = new ArrayList<>();
            activeHomeTabTagList2.add(feed2.getTag());
            activeHomeTabTagList2.add(secondTab.getTag());
            activeHomeTabTagList2.add(voice2.getTag());
            activeHomeTabTagList2.add(fourthTab.getTag());
            activeHomeTabTagList2.add(personal2.getTag());
            this.mActiveHomeTabTagList = activeHomeTabTagList2;
            HomeTabUtils.update(activeHomeTabTagList2);
            defaultTabInfos.add(feed2);
            defaultTabInfos.add(secondTab);
            defaultTabInfos.add(voice2);
            defaultTabInfos.add(fourthTab);
            defaultTabInfos.add(personal2);
        }
        return defaultTabInfos;
    }

    private ArrayList<HomeTabInfo> createPadTabInfoList(Context context) {
        ArrayList<HomeTabInfo> defaultTabInfos = new ArrayList<>();
        List<PadHomeSideBarModel> tabs = PadHomeSideBarMgr.INSTANCE.getAllTabs();
        ArrayList<String> activeHomeTabTagList = new ArrayList<>();
        for (PadHomeSideBarModel tab : tabs) {
            PadHomeTabInfo tabInfo = new PadHomeTabInfo();
            tabInfo.init(context, tab);
            String tabId = tab.getTabId();
            char c2 = 65535;
            switch (tabId.hashCode()) {
                case 1507424:
                    if (tabId.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1507425:
                    if (tabId.equals("1002")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1507427:
                    if (tabId.equals("1004")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1507458:
                    if (tabId.equals("1014")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    buildPadFeedTab(context, tabInfo);
                    break;
                case 1:
                    buildPadVideoTab(context, tabInfo);
                    break;
                case 2:
                    buildPadNovelTab(tabInfo);
                    break;
                case 3:
                    buildPadPersonalTab(context, tabInfo);
                    break;
            }
            activeHomeTabTagList.add(tabInfo.getTag());
            defaultTabInfos.add(tabInfo);
        }
        this.mActiveHomeTabTagList = activeHomeTabTagList;
        HomeTabUtils.update(activeHomeTabTagList);
        return defaultTabInfos;
    }

    public ArrayList<HomeTabInfo> createYouthHomeTabInfoList(Context context) {
        if (YouthHomeSwitchMgr.INSTANCE.getBottomBarStyle() == 2) {
            return createYouthHomePureTextTabInfoList(context);
        }
        return createYouthHomeFloatTabInfoList(context);
    }

    private ArrayList<HomeTabInfo> createYouthHomeFloatTabInfoList(Context context) {
        ArrayList<HomeTabInfo> youthTabInfos = new ArrayList<>();
        YouthHomeTabInfo feed = new YouthHomeTabInfo();
        YouthHomeTabInfo voice = new YouthHomeTabInfo();
        YouthHomeTabInfo personal = new YouthHomeTabInfo();
        buildYouthFeedTab(context, feed);
        buildYouthVoiceTab(voice);
        buildYouthPersonalTab(context, personal);
        ArrayList<String> activeHomeTabTagList = new ArrayList<>();
        activeHomeTabTagList.add(feed.getTag());
        activeHomeTabTagList.add(voice.getTag());
        activeHomeTabTagList.add(personal.getTag());
        this.mActiveHomeTabTagList = activeHomeTabTagList;
        HomeTabUtils.update(activeHomeTabTagList);
        youthTabInfos.add(feed);
        youthTabInfos.add(voice);
        youthTabInfos.add(personal);
        return youthTabInfos;
    }

    private ArrayList<HomeTabInfo> createYouthHomePureTextTabInfoList(Context context) {
        ArrayList<HomeTabInfo> youthTabInfos = new ArrayList<>();
        YouthHomeTabInfo feed = new YouthHomeTabInfo();
        YouthHomeTabInfo video = new YouthHomeTabInfo();
        YouthHomeTabInfo voice = new YouthHomeTabInfo();
        YouthHomeTabInfo novel = new YouthHomeTabInfo();
        YouthHomeTabInfo personal = new YouthHomeTabInfo();
        buildYouthFeedTab(context, feed);
        buildYouthVideoTab(context, video);
        buildYouthVoiceTab(voice);
        buildYouthNovelTab(context, novel);
        buildYouthPersonalTab(context, personal);
        ArrayList<String> activeHomeTabTagList = new ArrayList<>();
        activeHomeTabTagList.add(feed.getTag());
        activeHomeTabTagList.add(video.getTag());
        activeHomeTabTagList.add(voice.getTag());
        activeHomeTabTagList.add(novel.getTag());
        activeHomeTabTagList.add(personal.getTag());
        this.mActiveHomeTabTagList = activeHomeTabTagList;
        HomeTabUtils.update(activeHomeTabTagList);
        youthTabInfos.add(feed);
        youthTabInfos.add(video);
        youthTabInfos.add(voice);
        youthTabInfos.add(novel);
        youthTabInfos.add(personal);
        return youthTabInfos;
    }

    public ArrayList<String> getTabTagList() {
        return this.mActiveHomeTabTagList;
    }

    private boolean parseTabTextSwitch(String tabShowText) {
        if (TextUtils.isEmpty(tabShowText)) {
            return false;
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(tabShowText);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            try {
                jsonObject = new JSONObject(HomeAbtestConstants.BOTTOM_TAB_TEXT_AB_SWITCH_A);
            } catch (JSONException e1) {
                if (DEBUG) {
                    e1.printStackTrace();
                }
            }
        }
        HomeTabTextHolder.getInstance().checkTabText(jsonObject);
        return true;
    }

    private void setTabTextColor(HomeTabInfo tabInfo) {
        tabInfo.setNormalColor(R.color.GC1).setCheckedColor(R.color.GC1).setNormalColorMix(com.baidu.searchbox.hometab.business.R.color.BC324).setCheckedColorMix(com.baidu.searchbox.hometab.business.R.color.BC324).setPureTextTabNormalColor(com.baidu.searchbox.hometab.business.R.color.BC42).setPureTextTabCheckedColor(com.baidu.searchbox.hometab.business.R.color.BC41).setPureTextTabNormalColorMix(com.baidu.searchbox.hometab.business.R.color.BC42).setPureTextTabCheckedColorMix(com.baidu.searchbox.hometab.business.R.color.home_pure_text_tab_text_color);
    }

    private void setYouthTabPureTextColor(YouthHomeTabInfo tabInfo) {
        tabInfo.setPureTextTabNormalColor(com.baidu.searchbox.hometab.business.R.color.BC42).setPureTextTabCheckedColor(com.baidu.searchbox.hometab.business.R.color.BC41).setPureTextTabNormalColorMix(com.baidu.searchbox.hometab.business.R.color.BC42).setPureTextTabCheckedColorMix(com.baidu.searchbox.hometab.business.R.color.home_pure_text_tab_text_color);
    }

    private void buildFeedTab(Context context, final HomeTabInfo feed) {
        String feedStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1001");
        if (TextUtils.isEmpty(feedStr)) {
            feedStr = HomeTabTextHolder.getInstance().getTabHome();
        }
        feed.setTag("Feed").setText(feedStr).setTabDrawable(getTabDrawable("Feed")).setTabSelectedDrawable(getTabSelectedDrawable("Feed")).setTabDrawableMix(getTabDrawableMix("Feed")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Feed")).setOnlyIconStyle(true).setSupportBadge(true).setSupportLoading(true).setExtTabClickListener(createFeedTabClickListener()).setTabItemViewLifeCycleListener(new HomeTabInfo.TabItemViewLifeCycleListener() {
            public void onAttachedToWindow(final BaseTabItemView tabItemView) {
                BdEventBus.Companion.getDefault().lazyRegister(tabItemView, HomeFeedTabEvent.class, 1, new Action<HomeFeedTabEvent>() {
                    public void call(HomeFeedTabEvent event) {
                        if (TextUtils.equals(event.eventType, HomeFeedTabEvent.EVENT_HIDE_BADGE)) {
                            if (tabItemView.isShowLoading()) {
                                tabItemView.finishLoading();
                            }
                            if (tabItemView.isBadgeVisible()) {
                                tabItemView.hideBadge();
                            }
                        } else if (TextUtils.equals(event.eventType, HomeFeedTabEvent.EVENT_SHOW_BADGE) && feed.isChecked()) {
                            tabItemView.initBadgeView();
                            tabItemView.showBadgeText(event.badgeText);
                        }
                    }
                });
            }

            public void onDetachedFromWindow(BaseTabItemView tabItemView) {
                BdEventBus.Companion.getDefault().unregister(tabItemView);
            }
        }).setFragment(HomeFragment.class);
        setTabTextColor(feed);
        if (DEBUG) {
            Log.d(TAG, "build feed tab, first register global ShakeListener");
        }
    }

    private void buildPadFeedTab(Context context, final PadHomeTabInfo feed) {
        feed.setTag("Feed").setText(feed.getText()).setTabDrawable(getTabDrawable("Feed")).setTabSelectedDrawable(getTabSelectedDrawable("Feed")).setTabDrawableMix(getTabDrawableMix("Feed")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Feed")).setOnlyIconStyle(true).setSupportBadge(true).setSupportLoading(true).setExtTabClickListener(createFeedTabClickListener()).setTabItemViewLifeCycleListener(new HomeTabInfo.TabItemViewLifeCycleListener() {
            public void onAttachedToWindow(final BaseTabItemView tabItemView) {
                BdEventBus.Companion.getDefault().lazyRegister(tabItemView, HomeFeedTabEvent.class, 1, new Action<HomeFeedTabEvent>() {
                    public void call(HomeFeedTabEvent event) {
                        if (TextUtils.equals(event.eventType, HomeFeedTabEvent.EVENT_HIDE_BADGE)) {
                            if (tabItemView.isShowLoading()) {
                                tabItemView.finishLoading();
                            }
                            if (tabItemView.isBadgeVisible()) {
                                tabItemView.hideBadge();
                            }
                        } else if (TextUtils.equals(event.eventType, HomeFeedTabEvent.EVENT_SHOW_BADGE) && feed.isChecked()) {
                            tabItemView.initBadgeView();
                            tabItemView.showBadgeText(event.badgeText);
                        }
                    }
                });
            }

            public void onDetachedFromWindow(BaseTabItemView tabItemView) {
                BdEventBus.Companion.getDefault().unregister(tabItemView);
            }
        }).setFragment(HomeFragment.class);
        setTabTextColor(feed);
    }

    private static HomeTabInfo.OnTabClickListener createFeedTabClickListener() {
        return new HomeTabInfo.OnTabClickListener() {
            public HomeTabInfo.TabClickResult onTabClick(BaseTabItemView tabItemView, String preCurrentTabTag) {
                String extraTag;
                boolean doCommonProcess = true;
                if ("Feed".equals(preCurrentTabTag)) {
                    boolean isBadgeShow = tabItemView.isBadgeVisible();
                    if (isBadgeShow) {
                        if (!tabItemView.isShowLoading()) {
                            tabItemView.showLoading();
                            BaiduLogoRefreshRevolutionary.getDefault().setIsAtDefChannelWhileRefresh(TextUtils.equals(TabController.INSTANCE.getCurrentChannelId(), FeedCloudTabUtil.getGoHomeTabId()));
                            FeedRecommendRefreshEvent feedRecommendRefreshEvent = new FeedRecommendRefreshEvent();
                            feedRecommendRefreshEvent.mFeedFlowState = "9";
                            BdEventBus.Companion.getDefault().post(feedRecommendRefreshEvent);
                        }
                        tabItemView.hideBadge();
                        TabController.INSTANCE.ubcHomeBearTabTipShow("bar", "guide_click");
                        doCommonProcess = false;
                    }
                    if (isBadgeShow && !tabItemView.isShowLoading() && (TextUtils.equals(TabController.INSTANCE.getCurrentChannelId(), FeedCloudTabUtil.getGoHomeTabId()) || !TabNavDataManager.getInstance().isAdded(FeedCloudTabUtil.getGoHomeTabId()))) {
                        extraTag = HomeTabManager.HOME_TAB_CLICK_BADGE_REFRESH;
                    } else if (!isBadgeShow && !tabItemView.isShowLoading() && TabController.INSTANCE.getHomeState() == 0 && TextUtils.equals(TabController.INSTANCE.getCurrentChannelId(), FeedCloudTabUtil.getGoHomeTabId())) {
                        extraTag = "home_tab_click_home_refresh";
                    } else if (TabController.INSTANCE.getHomeState() != 0 || !TextUtils.equals(TabController.INSTANCE.getCurrentChannelId(), FeedCloudTabUtil.getGoHomeTabId())) {
                        extraTag = HomeTabManager.HOME_TAB_CLICK_GO_HOME;
                    } else {
                        extraTag = null;
                    }
                } else {
                    extraTag = null;
                }
                return new HomeTabInfo.TabClickResult(doCommonProcess, extraTag);
            }
        };
    }

    private void buildVideoTab(final Context context, HomeTabInfo video) {
        final VideoTabService videoTabService = (VideoTabService) ServiceManager.getService(VideoTabService.NAME);
        if (videoTabService != null) {
            String videoStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1002");
            if (TextUtils.isEmpty(videoStr)) {
                videoStr = HomeTabTextHolder.getInstance().getTabNiceVideo();
            }
            video.setTag("Video").setText(videoStr).setTabDrawable(getTabDrawable("Video")).setTabSelectedDrawable(getTabSelectedDrawable("Video")).setTabDrawableMix(getTabDrawableMix("Video")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Video")).setSupportBadge(true).setTabChangeListener(new HomeTabInfo.OnTabChangeListener() {
                public void onTabChangeToThis() {
                    videoTabService.saveDataWhenVideoTabShown(context);
                }
            }).setExtTabClickListener(new HomeTabInfo.OnTabClickListener() {
                public HomeTabInfo.TabClickResult onTabClick(BaseTabItemView tabItemView, String preCurrentTabTag) {
                    VideoTabTracker.INSTANCE.setType(0);
                    if (!tabItemView.isBadgeVisible()) {
                        return null;
                    }
                    tabItemView.hideBadge();
                    HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
                    tabBubbleManager.saveClickedTipId("Video");
                    tabBubbleManager.onTipClick("Video");
                    return null;
                }
            }).setFragment(videoTabService.getVideoTabClass());
            setTabTextColor(video);
        }
    }

    private void buildPadVideoTab(final Context context, PadHomeTabInfo video) {
        final VideoTabService videoTabService = (VideoTabService) ServiceManager.getService(VideoTabService.NAME);
        if (videoTabService != null) {
            video.setTag("Video").setText(video.getText()).setTabDrawable(getTabDrawable("Video")).setTabSelectedDrawable(getTabSelectedDrawable("Video")).setTabDrawableMix(getTabDrawableMix("Video")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Video")).setSupportBadge(true).setTabChangeListener(new HomeTabInfo.OnTabChangeListener() {
                public void onTabChangeToThis() {
                    videoTabService.saveDataWhenVideoTabShown(context);
                }
            }).setExtTabClickListener(new HomeTabInfo.OnTabClickListener() {
                public HomeTabInfo.TabClickResult onTabClick(BaseTabItemView tabItemView, String preCurrentTabTag) {
                    VideoTabTracker.INSTANCE.setType(0);
                    if (!tabItemView.isBadgeVisible()) {
                        return null;
                    }
                    tabItemView.hideBadge();
                    HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
                    tabBubbleManager.saveClickedTipId("Video");
                    tabBubbleManager.onTipClick("Video");
                    return null;
                }
            }).setFragment(videoTabService.getVideoTabClass());
            setTabTextColor(video);
        }
    }

    private void buildThirdTab(HomeTabInfo tabInfo) {
        tabInfo.setTag(ThirdTabTypeUtilsKt.getThirdTabTag()).setTabDrawable(com.baidu.searchbox.hometab.impl.R.drawable.home_tab_video_bg_selector).setFragment(NoneFragment.class);
    }

    public void buildFourthTab(Context context, HomeTabInfo fourthTab) {
        buildFourthTabByUpdate(context, fourthTab);
    }

    private void buildFourthTabByUpdate(Context context, HomeTabInfo fourthTab) {
        HomeDynamicTabValue fourthTabValue = getFourthTabValue();
        int switchValue = fourthTabValue.getTabValue();
        if (DEBUG) {
            Log.d(TAG, "4tab ——> 初次获取的开关值: " + switchValue);
        }
        setTabTextColor(fourthTab);
        switch (switchValue) {
            case 17:
                buildShopTab(fourthTab, fourthTabValue);
                return;
            case 18:
                buildMessageTab(fourthTab, fourthTabValue);
                return;
            case 19:
                buildNovelTab(fourthTab, fourthTabValue);
                return;
            case 20:
                buildNewsTab(fourthTab, fourthTabValue);
                return;
            case 21:
                buildVideoTab(context, fourthTab);
                return;
            default:
                buildMessageTab(fourthTab, fourthTabValue);
                return;
        }
    }

    private void buildSecondTab(Context context, HomeTabInfo secondTab) {
        HomeDynamicTabValue secondTabValue = getSecondTabValue();
        int switchValue = secondTabValue.getTabValue();
        if (DEBUG) {
            Log.d(TAG, "2tab ——> 初次获取的开关值: " + switchValue);
        }
        setTabTextColor(secondTab);
        switch (switchValue) {
            case 17:
                buildShopTab(secondTab, secondTabValue);
                return;
            case 18:
                buildMessageTab(secondTab, secondTabValue);
                return;
            case 20:
                buildNewsTab(secondTab, secondTabValue);
                return;
            case 21:
                buildVideoTab(context, secondTab);
                return;
            default:
                buildVideoTab(context, secondTab);
                return;
        }
    }

    private void buildShopTab(HomeTabInfo homeTabInfo, HomeDynamicTabValue fourthTabValue) {
        String shopTabStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1012");
        if (TextUtils.isEmpty(shopTabStr)) {
            shopTabStr = HomeTabTextHolder.getInstance().getTabShop();
        }
        homeTabInfo.setTag(HomeTabConstants.TAB_TAG_SHOP).setArgs(DynamicTabTypeUtilsKt.getDynamicTabArgs()).setText(shopTabStr).setTabDrawable(getTabDrawable(HomeTabConstants.TAB_TAG_SHOP)).setTabSelectedDrawable(getTabSelectedDrawable(HomeTabConstants.TAB_TAG_SHOP)).setTabDrawableMix(getTabDrawableMix(HomeTabConstants.TAB_TAG_SHOP)).setTabSelectedDrawableMix(getTabSelectedDrawableMix(HomeTabConstants.TAB_TAG_SHOP)).setSupportBadge(true).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda1()).setTabSource(fourthTabValue.getValueSource()).setFragment(ServiceCenterFourTabFragment.class);
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildShopTab$0(BaseTabItemView tabItemView, String preCurrentTabTag) {
        HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
        tabBubbleManager.updateLinkageInfo();
        if (!tabItemView.isBadgeVisible()) {
            return null;
        }
        tabItemView.hideBadge();
        tabBubbleManager.saveClickedTipId(HomeTabConstants.TAB_TAG_SHOP);
        tabBubbleManager.onTipClick(HomeTabConstants.TAB_TAG_SHOP);
        return null;
    }

    private void buildPadNovelTab(PadHomeTabInfo homeTabInfo) {
        INovelAbility iNovelAbility = NovelRuntime.getNovelAbility();
        if (iNovelAbility != null) {
            HomeDynamicTabValue fourthTabValue = new HomeDynamicTabValue();
            fourthTabValue.setValueSource("default");
            fourthTabValue.setTabValue(19);
            homeTabInfo.setTag("Novel").setArgs(DynamicTabTypeUtilsKt.getDynamicTabArgs()).setText(homeTabInfo.getText()).setTabDrawable(getTabDrawable("Novel")).setTabSelectedDrawable(getTabSelectedDrawable("Novel")).setTabDrawableMix(getTabDrawableMix("Novel")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Novel")).setSupportBadge(true).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda6()).setTabSource(fourthTabValue.getValueSource()).setFragment(iNovelAbility.getNovelPadTabClass());
            setTabTextColor(homeTabInfo);
        }
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildPadNovelTab$1(BaseTabItemView tabItemView, String preCurrentTabTag) {
        HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
        tabBubbleManager.updateLinkageInfo();
        if (!tabItemView.isBadgeVisible()) {
            return null;
        }
        tabItemView.hideBadge();
        tabBubbleManager.saveClickedTipId("Novel");
        tabBubbleManager.onTipClick("Novel");
        return null;
    }

    private void buildNovelTab(HomeTabInfo homeTabInfo, HomeDynamicTabValue fourthTabValue) {
        INovelAbility iNovelAbility = NovelRuntime.getNovelAbility();
        if (iNovelAbility != null) {
            String novelTabStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1014");
            if (TextUtils.isEmpty(novelTabStr)) {
                novelTabStr = HomeTabTextHolder.getInstance().getTabNovel();
            }
            homeTabInfo.setTag("Novel").setArgs(DynamicTabTypeUtilsKt.getDynamicTabArgs()).setText(novelTabStr).setTabDrawable(getTabDrawable("Novel")).setTabSelectedDrawable(getTabSelectedDrawable("Novel")).setTabDrawableMix(getTabDrawableMix("Novel")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Novel")).setSupportBadge(true).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda0()).setTabSource(fourthTabValue.getValueSource()).setFragment(iNovelAbility.getNovelTabClass());
        }
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildNovelTab$2(BaseTabItemView tabItemView, String preCurrentTabTag) {
        HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
        tabBubbleManager.updateLinkageInfo();
        if (!tabItemView.isBadgeVisible()) {
            return null;
        }
        tabItemView.hideBadge();
        tabBubbleManager.saveClickedTipId("Novel");
        tabBubbleManager.onTipClick("Novel");
        return null;
    }

    private void buildNewsTab(HomeTabInfo homeTabInfo, HomeDynamicTabValue fourthTabValue) {
        String newsTabStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1016");
        if (TextUtils.isEmpty(newsTabStr)) {
            newsTabStr = HomeTabTextHolder.getInstance().getTabNews();
        }
        homeTabInfo.setTag("News").setArgs(DynamicTabTypeUtilsKt.getDynamicTabArgs()).setText(newsTabStr).setTabDrawable(getTabDrawable("News")).setTabSelectedDrawable(getTabSelectedDrawable("News")).setTabDrawableMix(getTabDrawableMix("News")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("News")).setSupportBadge(true).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda8()).setTabSource(fourthTabValue.getValueSource()).setFragment(NewsFlashFragment.class);
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildNewsTab$3(BaseTabItemView tabItemView, String preCurrentTabTag) {
        HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
        tabBubbleManager.updateLinkageInfo();
        if (!tabItemView.isBadgeVisible()) {
            return null;
        }
        tabItemView.hideBadge();
        tabBubbleManager.saveClickedTipId("News");
        tabBubbleManager.onTipClick("News");
        return null;
    }

    private void buildMessageTab(HomeTabInfo messageTabInfo, HomeDynamicTabValue fourthTabValue) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "buildMessageTab start messageTabInfo:" + messageTabInfo.toString());
        }
        MessageCenterTabService messageTabService = (MessageCenterTabService) ServiceManager.getService(MessageCenterTabService.SERVICE_REFERENCE);
        if (messageTabService != null) {
            String messageTabStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1013");
            if (TextUtils.isEmpty(messageTabStr)) {
                messageTabStr = HomeTabTextHolder.getInstance().getTabXiaoxi();
            }
            setTabTextColor(messageTabInfo);
            Bundle args = new Bundle();
            args.putString("source", TabInfo.ID_PLAYER_INFO);
            messageTabInfo.setTag("Xiaoxi").setText(messageTabStr).setTabDrawable(getTabDrawable("Xiaoxi")).setTabSelectedDrawable(getTabSelectedDrawable("Xiaoxi")).setTabDrawableMix(getTabDrawableMix("Xiaoxi")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Xiaoxi")).setSupportBadge(true).setTabChangeListener(new HomeTabFetcher$$ExternalSyntheticLambda2()).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda3(messageTabService)).setTabSource(fourthTabValue.getValueSource()).setFragment(messageTabService.getMessageCenterTabClass()).setArgs(args);
            showMessageBadge(messageTabInfo);
            if (z) {
                Log.d(TAG, "buildMessageTab end messageTabInfo:" + messageTabInfo);
            }
        }
    }

    static /* synthetic */ void lambda$buildMessageTab$4() {
        if (DEBUG) {
            Log.d(TAG, "buildMessageTab onTabChangeToThis");
        }
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildMessageTab$5(MessageCenterTabService messageTabService, BaseTabItemView tabItemView, String preCurrentTabTag) {
        if (tabItemView.isBadgeVisible() && tabItemView.isFunctionBadge()) {
            if (tabItemView.isDotBadge()) {
                MessageFunctionOpStatKt.onRedDotBadgeClick();
            } else {
                MessageFunctionOpStatKt.onNumberBadgeClick();
            }
        }
        HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
        if (tabItemView == null || tabBubbleManager == null) {
            return null;
        }
        boolean isMessageRedDot = tabBubbleManager.isMessageRedDot();
        boolean isBadgeShow = tabItemView.isBadgeVisible();
        if (!isMessageRedDot && isBadgeShow) {
            tabBubbleManager.onTipClick("Xiaoxi");
        }
        messageTabService.savePreCurrentTabTag((String) tabItemView.getTag(), preCurrentTabTag);
        return null;
    }

    private void showMessageBadge(HomeTabInfo messageTabInfo) {
        if (!StyleMode.INSTANCE.isTeenagerStyle()) {
            messageTabInfo.setTabItemViewLifeCycleListener(new HomeTabInfo.TabItemViewLifeCycleListener() {
                private static final String IS_CHANGE_BADGE_BG_COLOR = "my_bar_mourn_switch";
                private static final int MSG_TYPE_DEFAULT = 0;
                private static final int MSG_TYPE_SHOW_NUMBER = 1;
                private static final int MSG_TYPE_SHOW_RED_DOT = 2;
                /* access modifiers changed from: private */
                public int curMsgType = -1;
                private SimpleActivityLifeCycle lifeCycle;
                private IDataObserver mImMsgObserver;
                private final Handler mMsgHandler = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (AnonymousClass8.this.mTabItemViewRef != null && AnonymousClass8.this.mTabItemViewRef.get() != null) {
                            int unused = AnonymousClass8.this.curMsgType = msg.what;
                            switch (msg.what) {
                                case 0:
                                    if (HomeTabBubbleManager.getInstance().isMessageRedDot()) {
                                        ((BaseTabItemView) AnonymousClass8.this.mTabItemViewRef.get()).hideBadge();
                                        return;
                                    }
                                    return;
                                case 1:
                                    HomeTabBubbleManager.getInstance().setMessageRedDot(true);
                                    long unreadCount = ((Long) msg.obj).longValue();
                                    BaseTabItemView tabItemView = (BaseTabItemView) AnonymousClass8.this.mTabItemViewRef.get();
                                    if (tabItemView != null) {
                                        boolean isBadgeVisibleToUser = AnonymousClass8.this.isTabVisibleToUser(tabItemView);
                                        tabItemView.showBadgeNumber(unreadCount, true);
                                        if (!isBadgeVisibleToUser && AnonymousClass8.this.isTabVisibleToUser(tabItemView)) {
                                            MessageFunctionOpStatKt.onNumberBadgeShow();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 2:
                                    HomeTabBubbleManager.getInstance().setMessageRedDot(true);
                                    BaseTabItemView tabItemView2 = (BaseTabItemView) AnonymousClass8.this.mTabItemViewRef.get();
                                    if (tabItemView2 != null) {
                                        boolean isBadgeVisibleToUser2 = AnonymousClass8.this.isTabVisibleToUser(tabItemView2);
                                        tabItemView2.showBadgeDot(true);
                                        if (!isBadgeVisibleToUser2 && AnonymousClass8.this.isTabVisibleToUser(tabItemView2)) {
                                            MessageFunctionOpStatKt.onRedDotBadgeShow();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                };
                /* access modifiers changed from: private */
                public WeakReference<BaseTabItemView> mTabItemViewRef;

                /* access modifiers changed from: private */
                public boolean isTabVisibleToUser(BaseTabItemView tabItemView) {
                    if (BdBoxActivityManager.getRealTopActivity() == tabItemView.getContext()) {
                        return tabItemView.isBadgeVisible();
                    }
                    return false;
                }

                /* access modifiers changed from: private */
                public void registerMsgObserver() {
                    WeakReference<BaseTabItemView> weakReference;
                    if (!(this.mImMsgObserver != null || (weakReference = this.mTabItemViewRef) == null || weakReference.get() == null)) {
                        this.mImMsgObserver = new HomeTabFetcher$8$$ExternalSyntheticLambda2(this);
                        if (AbTestManager.getInstance().getSwitch(IS_CHANGE_BADGE_BG_COLOR, false)) {
                            ((BaseTabItemView) this.mTabItemViewRef.get()).setIsChangeBadgeViewBgColor(true);
                        }
                        ((BaseTabItemView) this.mTabItemViewRef.get()).initBadgeView();
                        updateImUnreadCount();
                    }
                    if (this.mImMsgObserver != null) {
                        MessageCenterService.getObservable().addObserver(this.mImMsgObserver);
                    }
                }

                /* access modifiers changed from: package-private */
                /* renamed from: lambda$registerMsgObserver$0$com-baidu-searchbox-home-tabs-impl-HomeTabFetcher$8  reason: not valid java name */
                public /* synthetic */ void m20216lambda$registerMsgObserver$0$combaidusearchboxhometabsimplHomeTabFetcher$8(Observable o, Object arg) {
                    updateImUnreadCount();
                }

                private void registerMessageTask() {
                    if (AbTestManager.getInstance().getSwitch(IS_CHANGE_BADGE_BG_COLOR, false) || !AbTestManager.getInstance().getSwitch("global_mourn_switch", false)) {
                        UniTask msgTask = UniTaskBuilder.createIdleUniTask(new HomeTabFetcher$8$$ExternalSyntheticLambda1(this), "home_tab_register_message", true);
                        UniTaskManager.getInstance().registerLaunchTasks(msgTask);
                    }
                }

                private void updateImUnreadCount() {
                    ExecutorUtilsExt.postOnElastic(new HomeTabFetcher$8$$ExternalSyntheticLambda0(this), "MessageUnreadCount", 1);
                }

                /* access modifiers changed from: package-private */
                /* renamed from: lambda$updateImUnreadCount$1$com-baidu-searchbox-home-tabs-impl-HomeTabFetcher$8  reason: not valid java name */
                public /* synthetic */ void m20217lambda$updateImUnreadCount$1$combaidusearchboxhometabsimplHomeTabFetcher$8() {
                    long fusionMessageUnreadCount = MessageCenterService.getMessageCenterUnreadCount(4);
                    boolean fusionMessageHasDot = fusionMessageUnreadCount == -1;
                    long unreadCount = 0;
                    if (fusionMessageUnreadCount > 0) {
                        unreadCount = fusionMessageUnreadCount;
                    }
                    try {
                        Message msg = Message.obtain();
                        if (unreadCount > 0) {
                            msg.what = 1;
                            msg.obj = Long.valueOf(unreadCount);
                        } else if (fusionMessageHasDot) {
                            msg.what = 2;
                        } else {
                            msg.what = 0;
                        }
                        this.mMsgHandler.sendMessage(msg);
                    } catch (Exception e2) {
                    }
                }

                public void onAttachedToWindow(BaseTabItemView tabItemView) {
                    this.mTabItemViewRef = new WeakReference<>(tabItemView);
                    registerMessageTask();
                    AnonymousClass2 r0 = new SimpleActivityLifeCycle() {
                        public void onActivityResumed(Activity activity) {
                            BaseTabItemView baseTabItemView = (BaseTabItemView) AnonymousClass8.this.mTabItemViewRef.get();
                            if (baseTabItemView != null && activity == baseTabItemView.getContext() && AnonymousClass8.this.isTabVisibleToUser(baseTabItemView) && baseTabItemView.isBadgeVisible() && baseTabItemView.isFunctionBadge()) {
                                if (AnonymousClass8.this.curMsgType == 2) {
                                    MessageFunctionOpStatKt.onRedDotBadgeShow();
                                } else if (AnonymousClass8.this.curMsgType == 1) {
                                    MessageFunctionOpStatKt.onNumberBadgeShow();
                                }
                            }
                        }
                    };
                    this.lifeCycle = r0;
                    BdBoxActivityManager.registerLifeCycle(r0);
                }

                public void onDetachedFromWindow(BaseTabItemView tabItemView) {
                    try {
                        if (this.mImMsgObserver != null) {
                            if (HomeTabFetcher.DEBUG) {
                                Log.d(HomeTabFetcher.TAG, "首页我的删除im监听");
                            }
                            MessageCenterService.getObservable().deleteObserver(this.mImMsgObserver);
                            this.mImMsgObserver = null;
                        }
                        this.mMsgHandler.removeCallbacksAndMessages((Object) null);
                        BdBoxActivityManager.unregisterLifeCycle(this.lifeCycle);
                        this.lifeCycle = null;
                    } catch (Exception e2) {
                    }
                }
            });
        }
    }

    private void buildPersonalTab(Context context, HomeTabInfo personal) {
        String personalStr = HomeTabTextDataMgr.INSTANCE.getTabTextByTag("1004");
        if (TextUtils.isEmpty(personalStr)) {
            personalStr = HomeTabTextHolder.getInstance().getTabPersonal();
        }
        setTabTextColor(personal);
        HomeTabInfo homeTabInfo = personal.setTag("Personal").setText(personalStr).setTabDrawable(getTabDrawable("Personal")).setTabSelectedDrawable(getTabSelectedDrawable("Personal")).setTabDrawableMix(getTabDrawableMix("Personal")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Personal")).setSupportBadge(true).setTabChangeListener(new HomeTabInfo.OnTabChangeListener() {
            public void onTabChangeToThis() {
                HomeTabFetcher.this.m20214lambda$buildYouthPersonalTab$8$combaidusearchboxhometabsimplHomeTabFetcher();
            }
        }).setExtTabClickListener(new HomeTabInfo.OnTabClickListener() {
            public HomeTabInfo.TabClickResult onTabClick(BaseTabItemView tabItemView, String preCurrentTabTag) {
                ClearCacheUtils.doClearCacheJob();
                return null;
            }
        });
        if (PersonalABManagerWrapper.INSTANCE.isFusionPersonalCenter()) {
            homeTabInfo.setFragment(PersonalMixFragment.class);
        } else if (PersonalABManagerWrapper.INSTANCE.isShowSmartPersonalCenter()) {
            homeTabInfo.setFragment(PersonalAiFragment.class);
        } else {
            homeTabInfo.setFragment(PersonalizedFragment.class);
        }
        if (!DynamicTabTypeUtilsKt.isMessageBottomTabDisplayed() && !StyleMode.INSTANCE.isTeenagerStyle()) {
            personal.setTabItemViewLifeCycleListener(createPersonalTabItemLifeCycleListener());
        }
    }

    private HomeTabInfo.TabItemViewLifeCycleListener createPersonalTabItemLifeCycleListener() {
        return new HomeTabInfo.TabItemViewLifeCycleListener() {
            private IDataObserver mImMsgObserver;
            /* access modifiers changed from: private */
            public Handler mMsgHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (AnonymousClass11.this.mTabItemViewRef != null && AnonymousClass11.this.mTabItemViewRef.get() != null) {
                        switch (msg.what) {
                            case 0:
                                ((BaseTabItemView) AnonymousClass11.this.mTabItemViewRef.get()).hideBadge();
                                return;
                            case 1:
                                ((BaseTabItemView) AnonymousClass11.this.mTabItemViewRef.get()).showBadgeNumber(((Long) msg.obj).longValue(), true);
                                HomeTabBubbleManager.getInstance().setPersonalTabNumRedDot(true);
                                HomeTabFetcher.this.personalBadgeShowUBC("2");
                                return;
                            case 2:
                                ((BaseTabItemView) AnonymousClass11.this.mTabItemViewRef.get()).showBadgeDot(true);
                                HomeTabBubbleManager.getInstance().setPersonalTabOnlyRedDot(true);
                                HomeTabFetcher.this.personalBadgeShowUBC("1");
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            /* access modifiers changed from: private */
            public WeakReference<BaseTabItemView> mTabItemViewRef;

            /* access modifiers changed from: private */
            public void registerMsgObserver() {
                if (this.mImMsgObserver == null) {
                    this.mImMsgObserver = new IDataObserver() {
                        public void update(Observable o, Object arg) {
                            AnonymousClass11.this.updateImUnreadCount();
                        }
                    };
                    WeakReference<BaseTabItemView> weakReference = this.mTabItemViewRef;
                    if (weakReference != null && weakReference.get() != null) {
                        if (AbTestManager.getInstance().getSwitch("my_bar_mourn_switch", false)) {
                            ((BaseTabItemView) this.mTabItemViewRef.get()).setIsChangeBadgeViewBgColor(true);
                        }
                        ((BaseTabItemView) this.mTabItemViewRef.get()).initBadgeView();
                        updateImUnreadCount();
                    } else {
                        return;
                    }
                }
                if (HomeTabFetcher.DEBUG) {
                    Log.d(HomeTabFetcher.TAG, "首页我的添加im监听");
                }
                MessageCenterService.getObservable().addObserver(this.mImMsgObserver);
            }

            private void registerMsgTask() {
                if (AbTestManager.getInstance().getSwitch("my_bar_mourn_switch", false) || !AbTestManager.getInstance().getSwitch("global_mourn_switch", false)) {
                    UniTask msgTask = UniTaskBuilder.createIdleUniTask(new Runnable() {
                        public void run() {
                            AnonymousClass11.this.registerMsgObserver();
                        }
                    }, HomeTabFetcher.TASK_NAME_REGISTER_MSG, true);
                    UniTaskManager.getInstance().registerLaunchTasks(msgTask);
                }
            }

            /* access modifiers changed from: private */
            public void updateImUnreadCount() {
                HomeTabBubbleManager.getInstance().setPersonalTabNumRedDot(false);
                HomeTabBubbleManager.getInstance().setPersonalTabOnlyRedDot(false);
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        long fusionMessageUnreadCount = 0;
                        if (!DynamicTabTypeUtilsKt.isMessageBottomTabDisplayed()) {
                            fusionMessageUnreadCount = MessageCenterService.getMessageCenterUnreadCount(4);
                        }
                        boolean fusionMessageHasDot = fusionMessageUnreadCount == -1;
                        long advisoryUnreadCount = 0;
                        if (!HomeLv1TabDataMgr.hasQuestionTab()) {
                            if (PersonalABManagerWrapper.INSTANCE.isShowSmartPersonalCenter()) {
                                if (PersonalAiDataManagerWrapper.INSTANCE.getManager().getSmartItemInfoModel(PersonalConstants.NOTIFY_WENYIWEN) != null) {
                                    advisoryUnreadCount = MessageCenterService.getMessageCenterUnreadCount(2);
                                }
                            } else {
                                advisoryUnreadCount = MessageCenterService.getMessageCenterUnreadCount(2);
                            }
                        }
                        boolean advisoryUnreadHasDot = false;
                        if (DynamicTabTypeUtilsKt.isMessageBottomTabDisplayed()) {
                            advisoryUnreadHasDot = advisoryUnreadCount == -1;
                        }
                        long unreadCount = advisoryUnreadCount;
                        if (advisoryUnreadCount < 0) {
                            unreadCount = 0;
                        }
                        if (fusionMessageUnreadCount > 0) {
                            unreadCount += fusionMessageUnreadCount;
                        }
                        try {
                            Message msg = Message.obtain();
                            if (unreadCount > 0) {
                                msg.what = 1;
                                msg.obj = Long.valueOf(unreadCount);
                            } else {
                                if (!fusionMessageHasDot) {
                                    if (!advisoryUnreadHasDot) {
                                        msg.what = 0;
                                    }
                                }
                                msg.what = 2;
                            }
                            AnonymousClass11.this.mMsgHandler.sendMessage(msg);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }, "updateImUnreadCount", 1);
            }

            public void onAttachedToWindow(BaseTabItemView tabItemView) {
                this.mTabItemViewRef = new WeakReference<>(tabItemView);
                registerMsgTask();
            }

            public void onDetachedFromWindow(BaseTabItemView tabItemView) {
                if (this.mImMsgObserver != null) {
                    if (HomeTabFetcher.DEBUG) {
                        Log.d(HomeTabFetcher.TAG, "首页我的删除im监听");
                    }
                    MessageCenterService.getObservable().deleteObserver(this.mImMsgObserver);
                    this.mImMsgObserver = null;
                }
                Handler handler = this.mMsgHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
            }
        };
    }

    private void buildYouthFeedTab(Context context, YouthHomeTabInfo feed) {
        feed.setTag("Feed").setSupportBadge(true).setExtTabClickListener(createFeedTabClickListener()).setTabItemViewLifeCycleListener(new HomeTabInfo.TabItemViewLifeCycleListener() {
            public void onAttachedToWindow(BaseTabItemView tabItemView) {
            }

            public void onDetachedFromWindow(BaseTabItemView tabItemView) {
            }
        }).setFragment(HomeFragment.class);
        String feedStr = "";
        YouthHomeBottomTabModel feedYouthTabModel = YouthHomeTabDataUtilKt.getBottomTabModelByTag("Feed");
        if (feedYouthTabModel != null) {
            feed.setYouthHomeBottomTabModel(feedYouthTabModel);
            feed.updateYouthIconDrawable(context, feedYouthTabModel);
            feedStr = feedYouthTabModel.getName();
        }
        if (TextUtils.isEmpty(feedStr)) {
            feedStr = HomeTabTextHolder.getInstance().getTabHome();
        }
        feed.setText(feedStr);
        setYouthTabPureTextColor(feed);
        if (DEBUG) {
            Log.d(TAG, "build youth feed tab");
        }
    }

    private void buildYouthVideoTab(final Context context, YouthHomeTabInfo video) {
        final VideoTabService videoTabService = (VideoTabService) ServiceManager.getService(VideoTabService.NAME);
        if (videoTabService != null) {
            video.setTag("Video").setTabChangeListener(new HomeTabInfo.OnTabChangeListener() {
                public void onTabChangeToThis() {
                    videoTabService.saveDataWhenVideoTabShown(context);
                }
            }).setExtTabClickListener(new HomeTabInfo.OnTabClickListener() {
                public HomeTabInfo.TabClickResult onTabClick(BaseTabItemView tabItemView, String preCurrentTabTag) {
                    VideoTabTracker.INSTANCE.setType(0);
                    if (!tabItemView.isBadgeVisible()) {
                        return null;
                    }
                    if (AppConfig.isDebug()) {
                        UniversalToast.makeText(context, (CharSequence) "Must NO Video Badge!").show();
                    }
                    tabItemView.hideBadge();
                    HomeTabBubbleManager tabBubbleManager = HomeTabBubbleManager.getInstance();
                    tabBubbleManager.saveClickedTipId("Video");
                    tabBubbleManager.onTipClick("Video");
                    return null;
                }
            }).setFragment(videoTabService.getVideoTabClass());
            String videoStr = "";
            YouthHomeBottomTabModel videoYouthTabModel = YouthHomeTabDataUtilKt.getBottomTabModelByTag("Video");
            if (videoYouthTabModel != null) {
                video.setYouthHomeBottomTabModel(videoYouthTabModel);
                video.updateYouthIconDrawable(context, videoYouthTabModel);
                videoStr = videoYouthTabModel.getName();
            }
            if (TextUtils.isEmpty(videoStr)) {
                videoStr = HomeTabTextHolder.getInstance().getTabNiceVideo();
            }
            video.setText(videoStr);
            setYouthTabPureTextColor(video);
            if (DEBUG) {
                Log.d(TAG, "build youth video tab");
            }
        }
    }

    private void buildYouthVoiceTab(YouthHomeTabInfo voice) {
        voice.setTag("Voice").setTabDrawable(com.baidu.searchbox.hometab.impl.R.drawable.home_tab_video_bg_selector).setFragment(NoneFragment.class);
        YouthHomeBottomTabModel voiceYouthTabModel = YouthHomeTabDataUtilKt.getBottomTabModelByTag("Voice");
        if (voiceYouthTabModel != null) {
            voice.setYouthHomeBottomTabModel(voiceYouthTabModel);
        }
        if (DEBUG) {
            Log.d(TAG, "build youth voice tab");
        }
    }

    private void buildYouthNovelTab(Context context, YouthHomeTabInfo novel) {
        INovelAbility iNovelAbility = NovelRuntime.getNovelAbility();
        if (iNovelAbility != null) {
            novel.setTag("Novel").setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda9()).setFragment(iNovelAbility.getNovelTabClass());
            YouthHomeBottomTabModel novelYouthTabModel = YouthHomeTabDataUtilKt.getBottomTabModelByTag("Novel");
            String novelStr = "";
            if (novelYouthTabModel != null) {
                novel.setYouthHomeBottomTabModel(novelYouthTabModel);
                novel.updateYouthIconDrawable(context, novelYouthTabModel);
                novelStr = novelYouthTabModel.getName();
            }
            if (TextUtils.isEmpty(novelStr)) {
                novelStr = HomeTabTextHolder.getInstance().getTabNovel();
            }
            novel.setText(novelStr);
            setYouthTabPureTextColor(novel);
            if (DEBUG) {
                Log.d(TAG, "build youth novel tab");
            }
        }
    }

    static /* synthetic */ HomeTabInfo.TabClickResult lambda$buildYouthNovelTab$6(BaseTabItemView tabItemView, String preCurrentTabTag) {
        return null;
    }

    private void buildPadPersonalTab(Context context, PadHomeTabInfo personal) {
        setTabTextColor(personal);
        personal.setTag("Personal").setText(personal.getText()).setTabDrawable(getTabDrawable("Personal")).setTabSelectedDrawable(getTabSelectedDrawable("Personal")).setTabDrawableMix(getTabDrawableMix("Personal")).setTabSelectedDrawableMix(getTabSelectedDrawableMix("Personal")).setSupportBadge(true).setTabChangeListener(new HomeTabInfo.OnTabChangeListener() {
            public void onTabChangeToThis() {
                HomeTabFetcher.this.m20214lambda$buildYouthPersonalTab$8$combaidusearchboxhometabsimplHomeTabFetcher();
            }
        }).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda7()).setFragment(PersonalAiFragment.class);
        if (!DynamicTabTypeUtilsKt.isMessageBottomTabDisplayed() && !StyleMode.INSTANCE.isTeenagerStyle()) {
            personal.setTabItemViewLifeCycleListener(createPersonalTabItemLifeCycleListener());
        }
    }

    private void buildYouthPersonalTab(Context context, YouthHomeTabInfo personal) {
        personal.setTag("Personal").setSupportBadge(true).setTabChangeListener(new HomeTabFetcher$$ExternalSyntheticLambda4(this)).setExtTabClickListener(new HomeTabFetcher$$ExternalSyntheticLambda5()).setTabItemViewLifeCycleListener(createYouthPersonalTabItemLifeCycleListener()).setFragment(PersonalAiFragment.class);
        String personalStr = "";
        YouthHomeBottomTabModel personalYouthTabModel = YouthHomeTabDataUtilKt.getBottomTabModelByTag("Personal");
        if (personalYouthTabModel != null) {
            personal.setYouthHomeBottomTabModel(personalYouthTabModel);
            personal.updateYouthIconDrawable(context, personalYouthTabModel);
            personalStr = personalYouthTabModel.getName();
        }
        if (TextUtils.isEmpty(personalStr)) {
            personalStr = HomeTabTextHolder.getInstance().getTabPersonal();
        }
        personal.setText(personalStr);
        setYouthTabPureTextColor(personal);
        if (DEBUG) {
            Log.d(TAG, "build youth feed tab");
        }
    }

    private HomeTabInfo.TabItemViewLifeCycleListener createYouthPersonalTabItemLifeCycleListener() {
        return new HomeTabInfo.TabItemViewLifeCycleListener() {
            private IDataObserver mImMsgObserver;
            /* access modifiers changed from: private */
            public Handler mMsgHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (AnonymousClass16.this.mTabItemViewRef != null && AnonymousClass16.this.mTabItemViewRef.get() != null) {
                        switch (msg.what) {
                            case 0:
                                ((BaseTabItemView) AnonymousClass16.this.mTabItemViewRef.get()).hideBadge();
                                return;
                            case 1:
                                ((BaseTabItemView) AnonymousClass16.this.mTabItemViewRef.get()).showBadgeNumber(((Long) msg.obj).longValue(), true);
                                HomeTabFetcher.this.personalBadgeShowUBC("2");
                                return;
                            case 2:
                                ((BaseTabItemView) AnonymousClass16.this.mTabItemViewRef.get()).showBadgeDot(true);
                                HomeTabFetcher.this.personalBadgeShowUBC("1");
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            /* access modifiers changed from: private */
            public WeakReference<BaseTabItemView> mTabItemViewRef;

            /* access modifiers changed from: private */
            public void registerMsgObserver() {
                if (this.mImMsgObserver == null) {
                    this.mImMsgObserver = new IDataObserver() {
                        public void update(Observable o, Object arg) {
                            AnonymousClass16.this.updateImUnreadCount();
                        }
                    };
                    WeakReference<BaseTabItemView> weakReference = this.mTabItemViewRef;
                    if (weakReference != null && weakReference.get() != null) {
                        ((BaseTabItemView) this.mTabItemViewRef.get()).initBadgeView();
                        updateImUnreadCount();
                    } else {
                        return;
                    }
                }
                if (HomeTabFetcher.DEBUG) {
                    Log.d(HomeTabFetcher.TAG, "年轻化首页我的添加im监听");
                }
                MessageCenterService.getObservable().addObserver(this.mImMsgObserver);
            }

            private void registerMsgTask() {
                UniTask msgTask = UniTaskBuilder.createIdleUniTask(new Runnable() {
                    public void run() {
                        AnonymousClass16.this.registerMsgObserver();
                    }
                }, HomeTabFetcher.TASK_NAME_REGISTER_MSG, true);
                UniTaskManager.getInstance().registerLaunchTasks(msgTask);
            }

            /* access modifiers changed from: private */
            public void updateImUnreadCount() {
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        long fusionMessageUnreadCount = MessageCenterService.getMessageCenterUnreadCount(4);
                        boolean fusionMessageHasDot = fusionMessageUnreadCount == -1;
                        long advisoryUnreadCount = 0;
                        if (PersonalAiDataManagerWrapper.INSTANCE.getManager().getSmartItemInfoModel(PersonalConstants.NOTIFY_WENYIWEN) != null) {
                            advisoryUnreadCount = MessageCenterService.getMessageCenterUnreadCount(2);
                        }
                        long unreadCount = advisoryUnreadCount;
                        if (advisoryUnreadCount < 0) {
                            unreadCount = 0;
                        }
                        if (fusionMessageUnreadCount > 0) {
                            unreadCount += fusionMessageUnreadCount;
                        }
                        try {
                            Message msg = Message.obtain();
                            if (unreadCount > 0) {
                                msg.what = 1;
                                msg.obj = Long.valueOf(unreadCount);
                            } else if (fusionMessageHasDot) {
                                msg.what = 2;
                            } else {
                                msg.what = 0;
                            }
                            AnonymousClass16.this.mMsgHandler.sendMessage(msg);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }, "youthUpdateImUnreadCount", 1);
            }

            public void onAttachedToWindow(BaseTabItemView tabItemView) {
                this.mTabItemViewRef = new WeakReference<>(tabItemView);
                registerMsgTask();
            }

            public void onDetachedFromWindow(BaseTabItemView tabItemView) {
                if (this.mImMsgObserver != null) {
                    if (HomeTabFetcher.DEBUG) {
                        Log.d(HomeTabFetcher.TAG, "年轻化首页我的删除im监听");
                    }
                    MessageCenterService.getObservable().deleteObserver(this.mImMsgObserver);
                    this.mImMsgObserver = null;
                }
                Handler handler = this.mMsgHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
            }
        };
    }

    public HomeDynamicTabValue getFourthTabValue() {
        HomeDynamicTabValue fourthTabValue = new HomeDynamicTabValue();
        fourthTabValue.setTabIndex(4);
        if (HomeFourthTabTypeUtils.INSTANCE.isFourthTabTypeMessage()) {
            fourthTabValue.setValueSource("default");
            fourthTabValue.setTabValue(18);
            return fourthTabValue;
        }
        int switchValue = HomeDynamicTabUtils.getServerControlForthTab();
        if (switchValue == -100) {
            fourthTabValue.setValueSource("default");
            switchValue = 18;
        } else {
            fourthTabValue.setValueSource("server");
            if (DEBUG) {
                Log.d(TAG, "4th tab server 云控生效，switchValue=" + switchValue);
            }
        }
        fourthTabValue.setTabValue(switchValue);
        return fourthTabValue;
    }

    public HomeDynamicTabValue getSecondTabValue() {
        HomeDynamicTabValue secondTabValue = new HomeDynamicTabValue();
        secondTabValue.setTabIndex(2);
        if ("1002".equals(HomeSecondTabTypeUtils.INSTANCE.getCurrentTabTag())) {
            secondTabValue.setValueSource("default");
            secondTabValue.setTabValue(21);
            return secondTabValue;
        }
        int switchValue = HomeDynamicTabUtils.getServerControlSecondTab();
        if (switchValue == -100) {
            secondTabValue.setValueSource("default");
            switchValue = 21;
        } else {
            secondTabValue.setValueSource("server");
            if (DEBUG) {
                Log.d(TAG, "2nd tab server 云控生效，switchValue=" + switchValue);
            }
        }
        secondTabValue.setTabValue(switchValue);
        return secondTabValue;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getTabSelectedDrawable(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1675632080: goto L_0x0045;
                case 2185662: goto L_0x003b;
                case 2424563: goto L_0x0031;
                case 2576150: goto L_0x0027;
                case 75458076: goto L_0x001d;
                case 82650203: goto L_0x0013;
                case 507808352: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Personal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Novel"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Shop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "News"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Feed"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Xiaoxi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0050
        L_0x004f:
            r0 = -1
        L_0x0050:
            switch(r0) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_news_pressed_new_style
            return r0
        L_0x0057:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_novel_pressed_new_style
            return r0
        L_0x005a:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_xiaoxi_pressed_new_style
            return r0
        L_0x005d:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_shop_pressed_new_style
            return r0
        L_0x0060:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_personal_pressed_new_style
            return r0
        L_0x0063:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_haokan_video_pressed_new_style
            return r0
        L_0x0066:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_home_page_pressed_new_style
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.tabs.impl.HomeTabFetcher.getTabSelectedDrawable(java.lang.String):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getTabSelectedDrawableMix(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1675632080: goto L_0x0045;
                case 2185662: goto L_0x003b;
                case 2424563: goto L_0x0031;
                case 2576150: goto L_0x0027;
                case 75458076: goto L_0x001d;
                case 82650203: goto L_0x0013;
                case 507808352: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Personal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Novel"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Shop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "News"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Feed"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Xiaoxi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0050
        L_0x004f:
            r0 = -1
        L_0x0050:
            switch(r0) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_news_pressed_mix_new_style
            return r0
        L_0x0057:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_novel_pressed_mix_new_style
            return r0
        L_0x005a:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_xiaoxi_pressed_mix_new_style
            return r0
        L_0x005d:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_shop_pressed_mix_new_style
            return r0
        L_0x0060:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_personal_pressed_mix_new_style
            return r0
        L_0x0063:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_haokan_video_pressed_mix_new_style
            return r0
        L_0x0066:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_home_page_pressed_mix_new_style
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.tabs.impl.HomeTabFetcher.getTabSelectedDrawableMix(java.lang.String):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getTabDrawable(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1675632080: goto L_0x0045;
                case 2185662: goto L_0x003b;
                case 2424563: goto L_0x0031;
                case 2576150: goto L_0x0027;
                case 75458076: goto L_0x001d;
                case 82650203: goto L_0x0013;
                case 507808352: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Personal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Novel"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Shop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "News"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Feed"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Xiaoxi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0050
        L_0x004f:
            r0 = -1
        L_0x0050:
            switch(r0) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_news_normal_new_style
            return r0
        L_0x0057:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_novel_normal_new_style
            return r0
        L_0x005a:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_xiaoxi_normal_new_style
            return r0
        L_0x005d:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_shop_normal_new_style
            return r0
        L_0x0060:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_personal_normal_new_style
            return r0
        L_0x0063:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_haokan_video_normal_new_style
            return r0
        L_0x0066:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_home_page_normal_new_style
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.tabs.impl.HomeTabFetcher.getTabDrawable(java.lang.String):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getTabDrawableMix(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1675632080: goto L_0x0045;
                case 2185662: goto L_0x003b;
                case 2424563: goto L_0x0031;
                case 2576150: goto L_0x0027;
                case 75458076: goto L_0x001d;
                case 82650203: goto L_0x0013;
                case 507808352: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Personal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Novel"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Shop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "News"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Feed"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Xiaoxi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0050
        L_0x004f:
            r0 = -1
        L_0x0050:
            switch(r0) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_news_normal_mix_new_style
            return r0
        L_0x0057:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_novel_normal_mix_new_style
            return r0
        L_0x005a:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_xiaoxi_normal_mix_new_style
            return r0
        L_0x005d:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_shop_normal_mix_new_style
            return r0
        L_0x0060:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_personal_normal_mix_new_style
            return r0
        L_0x0063:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_haokan_video_normal_mix_new_style
            return r0
        L_0x0066:
            int r0 = com.baidu.android.common.ui.style.R.drawable.home_tab_home_page_normal_mix_new_style
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.tabs.impl.HomeTabFetcher.getTabDrawableMix(java.lang.String):int");
    }

    /* access modifiers changed from: private */
    public void personalBadgeShowUBC(String ubcValue) {
        String page;
        String ubcSource;
        BoxAccount account = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getBoxAccount();
        boolean isVip = true;
        boolean isBaiJiaHao = account != null && TextUtils.equals(account.getUserType(), "1");
        if (account == null || !TextUtils.equals(account.getMemberVip(), "1")) {
            isVip = false;
        }
        if (isBaiJiaHao && isVip) {
            page = PersonalConstants.PAGE_BUSER_VIP;
        } else if (isBaiJiaHao) {
            page = PersonalConstants.PAGE_BUSER_OUTSIDER;
        } else if (isVip) {
            page = PersonalConstants.PAGE_CUSER_VIP;
        } else {
            page = PersonalConstants.PAGE_CUSER_OUTSIDER;
        }
        if (TabManager.isSideBarStyle()) {
            ubcSource = "pad_mode";
        } else if (IYouthHomeApi.Companion.getYouthHomeApi() == null || !IYouthHomeApi.Companion.getYouthHomeApi().isYouthHome()) {
            ubcSource = null;
        } else {
            ubcSource = "youth_mode";
        }
        JSONObject ext = new JSONObject();
        HomeTabUbcUtilsKt.appendPadInfoExt(ext, false);
        PersonCenterUBCStatistic.statisticUBC("personal_show", ubcSource, ubcValue, ext, PersonalConstants.FROM_DITAB, "179", page);
    }

    /* access modifiers changed from: private */
    /* renamed from: personalTabShowUBC */
    public void m20214lambda$buildYouthPersonalTab$8$combaidusearchboxhometabsimplHomeTabFetcher() {
        String source;
        String ubcValue = HomeTabBubbleManager.getInstance().isPersonalTabNumRedDot() ? "2" : HomeTabBubbleManager.getInstance().isPersonalTabOnlyRedDot() ? "1" : "0";
        BoxAccount account = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getBoxAccount();
        boolean z = true;
        boolean isBaiJiaHao = account != null && TextUtils.equals(account.getUserType(), "1");
        if (account == null || !TextUtils.equals(account.getMemberVip(), "1")) {
            z = false;
        }
        boolean isVip = z;
        String page = (!isBaiJiaHao || !isVip) ? isBaiJiaHao ? PersonalConstants.PAGE_BUSER_OUTSIDER : isVip ? PersonalConstants.PAGE_CUSER_VIP : PersonalConstants.PAGE_CUSER_OUTSIDER : PersonalConstants.PAGE_BUSER_VIP;
        String source2 = null;
        if (TabManager.isSideBarStyle()) {
            source = "pad_mode";
        } else {
            if (StyleMode.INSTANCE.isTeenagerStyle()) {
                source2 = "child_mode";
            }
            if (IYouthHomeApi.Companion.getYouthHomeApi() == null || !IYouthHomeApi.Companion.getYouthHomeApi().isYouthHome()) {
                source = source2;
            } else {
                source = "youth_mode";
            }
        }
        JSONObject ext = new JSONObject();
        try {
            ext.put("style", "old");
            String v1TabTag = HomeTabUbcUtilsKt.getHomeV1TabTag();
            if (!TextUtils.isEmpty(v1TabTag)) {
                ext.put(HomeTabUBCConstants.UBC_EXT_V1_TAB_TAG, v1TabTag);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HomeTabUbcUtilsKt.appendPadInfoExt(ext, false);
        JSONObject jSONObject = ext;
        PersonCenterUBCStatistic.statisticUBC("personal", source, ubcValue, ext, PersonalConstants.FROM_DITAB, "179", page);
    }

    private void registerHomeLifeCycle() {
        AnonymousClass17 r0 = new SimpleActivityLifeCycle() {
            private boolean fromBackground = false;

            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                if (HomeTabFetcher.this.hasRegisterIdleTask) {
                    HomeTabFetcher.this.doResumeUbc(activity);
                    return;
                }
                final WeakReference<Activity> activityRef = new WeakReference<>(activity);
                UniTask uniTask = UniTaskBuilder.createIdleUniTask(new Runnable() {
                    public void run() {
                        HomeTabFetcher.this.doResumeUbc((Activity) activityRef.get());
                    }
                }, "registerHomeLifeCycleTask", true);
                UniTaskManager.getInstance().registerLaunchTasks(uniTask);
                boolean unused = HomeTabFetcher.this.hasRegisterIdleTask = true;
            }

            public void onForegroundToBackground(Activity activity) {
                this.fromBackground = true;
            }

            public void onBackgroundToForeground(Activity activity) {
                if (this.fromBackground) {
                    Activity topActivity = BdBoxActivityManager.getRealTopActivity();
                    if (topActivity != null && IHomeTabApp.Impl.get().isMainActivity(topActivity) && TextUtils.equals(HomeTabManager.getCurrentTabID(), "Video")) {
                        if ("short_play".equals(HomeTabManager.getSubTabTag("Video"))) {
                            DefaultHomeBarUbcManagerKt.onHotStartUbcShow(DefaultHomeBarUbcManagerKt.SHORTBAR);
                        } else {
                            DefaultHomeBarUbcManagerKt.onHotStartUbcShow("videobar");
                        }
                    }
                    this.fromBackground = false;
                }
            }
        };
        this.mHomeLifecycle = r0;
        BdBoxActivityManager.registerLifeCycle(r0);
    }

    /* access modifiers changed from: private */
    public void doResumeUbc(Activity activity) {
        if (activity != null && IHomeTabApp.Impl.get() != null && IHomeTabApp.Impl.get().isMainActivity(activity) && !HomeTabImmerseHelper.INSTANCE.isTabBarHidden()) {
            HomeDynamicTabUtils.ubcDynamicTabShow(getFourthTabValue());
            HomeDynamicTabUtils.ubcDynamicTabShow(getSecondTabValue());
            if (DEBUG) {
                Log.d(TAG, "onMainActivityResumed");
            }
        }
    }

    public void release() {
        SimpleActivityLifeCycle simpleActivityLifeCycle = this.mHomeLifecycle;
        if (simpleActivityLifeCycle != null) {
            BdBoxActivityManager.unregisterLifeCycle(simpleActivityLifeCycle);
            this.mHomeLifecycle = null;
        }
    }
}
