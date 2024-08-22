package com.baidu.searchbox.kmm.home.abtest;

import co.touchlab.stately.concurrency.AtomicBoolean;
import co.touchlab.stately.concurrency.AtomicReferenceKt;
import com.baidu.searchbox.kmm.foundation.device.DeviceKt;
import com.baidu.searchbox.kmm.home.abtest.models.HomeSearchBoxHeightModel;
import com.baidu.searchbox.kmm.home.abtest.models.HomeSearchBoxHeightModelKt;
import com.baidu.searchbox.kmm.home.abtest.models.HomeWeatherColorModel;
import com.baidu.searchbox.kmm.home.abtest.models.HomeWeatherColorModelKt;
import com.baidu.searchbox.kmm.home.abtest.utils.HomeSkinStatusUtilsKt;
import com.baidu.searchbox.kmm.home.lv1tab.HomeLv1TabDataMgr;
import com.baidu.searchbox.kmm.home.pad.PadHomeSwitchMgr;
import com.baidu.searchbox.kmm.home.tab.HomeTabTextDataMgr;
import com.baidu.searchbox.kmm.services.abtest.ABTestKt;
import com.baidu.searchbox.kmm.services.stylemode.StyleModeKt;
import com.baidu.searchbox.kmm.updateprocessor.NewHomeControlUpdateListenerKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020 H\u0007J\n\u0010!\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010\"\u001a\u00020\u001cH\u0007J\b\u0010#\u001a\u00020\u0004H\u0003J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0004H\u0003J\b\u0010&\u001a\u00020\u0004H\u0003J\b\u0010'\u001a\u00020\u0004H\u0003J\b\u0010(\u001a\u00020\u0004H\u0003J\b\u0010)\u001a\u00020\u0004H\u0003J\b\u0010*\u001a\u00020\u0004H\u0003J\b\u0010+\u001a\u00020,H\u0003J\b\u0010-\u001a\u00020\u0004H\u0003J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001eH\u0003J\b\u00100\u001a\u00020,H\u0003J\b\u00101\u001a\u00020\u0004H\u0007J\b\u00102\u001a\u00020\u0004H\u0007J\b\u00103\u001a\u00020\u0004H\u0007J\b\u00104\u001a\u00020\u0004H\u0007J\b\u00105\u001a\u00020\u0004H\u0007J\b\u00106\u001a\u00020\u0004H\u0007J\b\u00107\u001a\u00020\u0004H\u0007J\b\u00108\u001a\u00020\u0004H\u0007J\r\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b:J\b\u0010;\u001a\u00020\u0004H\u0007J\b\u0010<\u001a\u00020\u0004H\u0007J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020\u0004H\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019`\u001aX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0018j\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c`\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/baidu/searchbox/kmm/home/abtest/HomeABTestMgr;", "", "()V", "briefHomeSwitch", "", "Ljava/lang/Boolean;", "currentHomeStyle", "", "isBottomBarNewHeightInternal", "Lco/touchlab/stately/concurrency/AtomicBoolean;", "isBottomBarTipsNewSizeInternal", "isBriefHomeHideFeedTabEnableInternal", "isFeedTabSlidableInternal", "<set-?>", "isHideableForAllFeedTabChannels", "()Z", "isHorizontalScrollEnabledWhenFeedTabHidden", "isLv1TabSlidableInternal", "isLv1TabSlideHideEnable", "isNewBottomBarInternal", "isNewHomeInternal", "isShowAdaptiveFiveTabStyleInternal", "isShowWeatherInternal", "searchBoxHeightABInternal", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/baidu/searchbox/kmm/home/abtest/models/HomeSearchBoxHeightModel;", "Lco/touchlab/stately/concurrency/AtomicReference;", "weatherColorABInternal", "Lcom/baidu/searchbox/kmm/home/abtest/models/HomeWeatherColorModel;", "getBlockedTabId", "", "getBriefHomePagStyle", "Lcom/baidu/searchbox/kmm/home/abtest/BriefHomeStyle;", "getSearchBoxHeight", "getWeatherColor", "initBriefHomeHideFeedTabEnable", "initCurHomePageType", "initFeedSlidable", "initIsBottomBarNewHeight", "initIsBottomBarTipsNewSize", "initIsNewBottomBar", "initIsNewHome", "initLv1TabSlidable", "initSearchBoxHeight", "", "initShowWeather", "initSwitchEnableByKey", "key", "initWeatherColor", "isBottomBarNewHeight", "isBottomBarTipsNewSize", "isBriefHome", "isBriefHomeHideFeedTabEnable", "isFeedTabSlidable", "isLv1TabSlidable", "isNewBottomBar", "isNewHome", "isNewHomeUpdateSwitch", "isNewHomeUpdateSwitch$com_baidu_searchbox_kmm_business_home", "isShowAdaptiveFiveTabStyle", "isShowWeather", "setHomePageSkinStatus", "hasHomeSkin", "com.baidu.searchbox.kmm.business.home"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeABTestMgr.kt */
public final class HomeABTestMgr {
    public static final HomeABTestMgr INSTANCE;
    private static Boolean briefHomeSwitch;
    private static int currentHomeStyle;
    private static final AtomicBoolean isBottomBarNewHeightInternal;
    private static final AtomicBoolean isBottomBarTipsNewSizeInternal;
    private static final AtomicBoolean isBriefHomeHideFeedTabEnableInternal;
    private static final AtomicBoolean isFeedTabSlidableInternal;
    private static boolean isHideableForAllFeedTabChannels = initSwitchEnableByKey("newhome_feed_tab_hide_all_channels");
    private static boolean isHorizontalScrollEnabledWhenFeedTabHidden = initSwitchEnableByKey("newhome_horizontal_scrollable_feed_tab_hidden");
    private static final AtomicBoolean isLv1TabSlidableInternal;
    private static boolean isLv1TabSlideHideEnable = initSwitchEnableByKey("newhome_tabv1_hide");
    private static final AtomicBoolean isNewBottomBarInternal;
    private static final AtomicBoolean isNewHomeInternal;
    private static final AtomicBoolean isShowAdaptiveFiveTabStyleInternal;
    private static final AtomicBoolean isShowWeatherInternal;
    private static final AtomicReference<HomeSearchBoxHeightModel> searchBoxHeightABInternal = new AtomicReference<>((Object) null);
    private static final AtomicReference<HomeWeatherColorModel> weatherColorABInternal = new AtomicReference<>((Object) null);

    private HomeABTestMgr() {
    }

    static {
        HomeABTestMgr homeABTestMgr = new HomeABTestMgr();
        INSTANCE = homeABTestMgr;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        isNewHomeInternal = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        isNewBottomBarInternal = atomicBoolean2;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        isShowWeatherInternal = atomicBoolean3;
        AtomicBoolean atomicBoolean4 = new AtomicBoolean(false);
        isLv1TabSlidableInternal = atomicBoolean4;
        AtomicBoolean atomicBoolean5 = new AtomicBoolean(false);
        isFeedTabSlidableInternal = atomicBoolean5;
        AtomicBoolean atomicBoolean6 = new AtomicBoolean(false);
        isBottomBarTipsNewSizeInternal = atomicBoolean6;
        AtomicBoolean atomicBoolean7 = new AtomicBoolean(false);
        isBottomBarNewHeightInternal = atomicBoolean7;
        AtomicBoolean atomicBoolean8 = new AtomicBoolean(false);
        isBriefHomeHideFeedTabEnableInternal = atomicBoolean8;
        currentHomeStyle = 1;
        AtomicBoolean atomicBoolean9 = new AtomicBoolean(false);
        isShowAdaptiveFiveTabStyleInternal = atomicBoolean9;
        atomicBoolean.setValue(initIsNewHome());
        atomicBoolean2.setValue(initIsNewBottomBar());
        atomicBoolean3.setValue(initShowWeather());
        atomicBoolean9.setValue(HomeSwitchMgr.INSTANCE.isAdaptiveFiveTabStyle());
        atomicBoolean5.setValue(initFeedSlidable());
        atomicBoolean4.setValue(initLv1TabSlidable());
        atomicBoolean6.setValue(initIsBottomBarTipsNewSize());
        atomicBoolean7.setValue(initIsBottomBarNewHeight());
        atomicBoolean8.setValue(initBriefHomeHideFeedTabEnable());
        currentHomeStyle = homeABTestMgr.initCurHomePageType();
        initSearchBoxHeight();
        initWeatherColor();
    }

    public final boolean isLv1TabSlideHideEnable() {
        return isLv1TabSlideHideEnable;
    }

    public final boolean isHideableForAllFeedTabChannels() {
        return isHideableForAllFeedTabChannels;
    }

    public final boolean isHorizontalScrollEnabledWhenFeedTabHidden() {
        return isHorizontalScrollEnabledWhenFeedTabHidden;
    }

    @JvmStatic
    public static final boolean isNewHome() {
        return isNewHomeInternal.getValue();
    }

    @JvmStatic
    public static final boolean isBriefHome() {
        Boolean bool = briefHomeSwitch;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(HomeSwitchMgrKt.isBriefHomeSwitch() && isNewHome());
        briefHomeSwitch = valueOf;
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final BriefHomeStyle getBriefHomePagStyle() {
        switch (currentHomeStyle) {
            case 4:
                return BriefHomeStyle.BRIEF_HOME_STYLE_THICK_HEADER;
            case 5:
                return BriefHomeStyle.BRIEF_HOME_STYLE_FEED_NO_HEADER;
            default:
                return BriefHomeStyle.BRIEF_HOME_STYLE_UNKNOW;
        }
    }

    @JvmStatic
    public static final void setHomePageSkinStatus(boolean hasHomeSkin) {
        HomeSkinStatusUtilsKt.setHomeSkinStatus(hasHomeSkin);
    }

    @JvmStatic
    public static final boolean isNewBottomBar() {
        return isNewBottomBarInternal.getValue();
    }

    @JvmStatic
    public static final boolean isBottomBarTipsNewSize() {
        return isBottomBarTipsNewSizeInternal.getValue();
    }

    @JvmStatic
    public static final boolean isBottomBarNewHeight() {
        return isBottomBarNewHeightInternal.getValue();
    }

    @JvmStatic
    public static final boolean isShowWeather() {
        return isShowWeatherInternal.getValue();
    }

    @JvmStatic
    public static final boolean isShowAdaptiveFiveTabStyle() {
        return isShowAdaptiveFiveTabStyleInternal.getValue();
    }

    @JvmStatic
    public static final boolean isLv1TabSlidable() {
        return isLv1TabSlidableInternal.getValue();
    }

    @JvmStatic
    public static final boolean isFeedTabSlidable() {
        return isFeedTabSlidableInternal.getValue();
    }

    @JvmStatic
    public static final HomeSearchBoxHeightModel getSearchBoxHeight() {
        return (HomeSearchBoxHeightModel) AtomicReferenceKt.getValue(searchBoxHeightABInternal);
    }

    @JvmStatic
    public static final HomeWeatherColorModel getWeatherColor() {
        HomeWeatherColorModel homeWeatherColorModel = (HomeWeatherColorModel) AtomicReferenceKt.getValue(weatherColorABInternal);
        return homeWeatherColorModel == null ? HomeABTestMgrKt.getDefaultHomeWeatherColorModel() : homeWeatherColorModel;
    }

    @JvmStatic
    public static final boolean isBriefHomeHideFeedTabEnable() {
        return isBriefHomeHideFeedTabEnableInternal.getValue();
    }

    @JvmStatic
    private static final boolean initIsNewHome() {
        if (HomeABTestMgrKt.isDebugForceHitNewHome() || HomeABTestMgrKt.isDebugForceHitBriefHome()) {
            HomeLv1TabDataMgr homeLv1TabDataMgr = HomeLv1TabDataMgr.INSTANCE;
            return true;
        } else if ((HomeSwitchMgr.INSTANCE.isAbSwitchNewHome() || HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) && HomeSkinResStatusMgr.canUseNewHome$com_baidu_searchbox_kmm_business_home() && !StyleModeKt.isTeenagerMode()) {
            return HomeLv1TabDataMgr.isDataAvailable$com_baidu_searchbox_kmm_business_home();
        } else {
            return false;
        }
    }

    private final int initCurHomePageType() {
        if (!DeviceKt.isTabletDevice() && HomeSwitchMgrKt.isBriefHomeSwitchValue(HomeABTestMgrKt.getHomeAbSwitchValue()) && isNewHome() && !PadHomeSwitchMgr.INSTANCE.getSideBarStyleSwitchOn() && !HomeSkinStatusUtilsKt.getCurrentSkinStatus()) {
            return HomeABTestMgrKt.getHomeAbSwitchValue();
        }
        return 1;
    }

    @JvmStatic
    private static final boolean initIsNewBottomBar() {
        int bottomBar;
        if (HomeTabTextDataMgr.INSTANCE.isPureTextBar()) {
            return false;
        }
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            bottomBar = HomeABTestMgrKt.getHomeAbSwitchValue();
        } else if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            bottomBar = NewHomeControlUpdateListenerKt.getUpdateKvIntFromLocal("newhome_switch_one", 1);
        } else {
            bottomBar = HomeABTestMgrKt.getHomeAbSwitchValue();
        }
        if (!(bottomBar == 2 || bottomBar == 3) || !HomeSkinResStatusMgr.canUseNewBottomBar$com_baidu_searchbox_kmm_business_home()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    private static final boolean initIsBottomBarTipsNewSize() {
        if (ABTestKt.getABTestSwitch("bottom_bar_guidance_spotsize_switch", 0) == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    private static final boolean initIsBottomBarNewHeight() {
        if (ABTestKt.getABTestSwitch("bottom_bar_height_switch", 0) == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    private static final boolean initBriefHomeHideFeedTabEnable() {
        if (ABTestKt.getABTestSwitch("briefhome_vertical_scrollable_feed_tab_hidden", 0) == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    private static final boolean initSwitchEnableByKey(String key) {
        int slideHide = 0;
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            slideHide = ABTestKt.getABTestSwitch(key, 0);
        } else if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            slideHide = NewHomeControlUpdateListenerKt.getUpdateKvIntFromLocal(key, 0);
        }
        if (slideHide == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    private static final boolean initShowWeather() {
        return true;
    }

    @JvmStatic
    private static final boolean initFeedSlidable() {
        if (!isNewHome()) {
            return true;
        }
        int isFeedSlidAble = 1;
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            isFeedSlidAble = ABTestKt.getABTestSwitch("newhome_feedtab_one", 1);
        } else if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            isFeedSlidAble = NewHomeControlUpdateListenerKt.getUpdateKvIntFromLocal("newhome_feedtab_one", 1);
        }
        if (isFeedSlidAble == 1) {
            return true;
        }
        return false;
    }

    public final String getBlockedTabId() {
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            return ABTestKt.getABTestSwitch("newhome_fivetab_one", "");
        }
        if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            return NewHomeControlUpdateListenerKt.getUpdateKvStringFromLocal("newhome_fivetab_one", "");
        }
        return "";
    }

    public final boolean isNewHomeUpdateSwitch$com_baidu_searchbox_kmm_business_home() {
        return HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome();
    }

    @JvmStatic
    private static final boolean initLv1TabSlidable() {
        if (isNewHome() && ABTestKt.getABTestSwitch("newhome_v1tab_slide_one", 1) != 0) {
            return true;
        }
        return false;
    }

    @JvmStatic
    private static final void initSearchBoxHeight() {
        String json = "";
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            json = ABTestKt.getABTestSwitch("newhome_search_one", "");
        } else if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            json = NewHomeControlUpdateListenerKt.getUpdateKvStringFromLocal("newhome_search_one", "");
        }
        boolean z = true;
        if (!(json.length() == 0)) {
            HomeSearchBoxHeightModel model = HomeSearchBoxHeightModelKt.decodeHomeSearchBoxAB(json);
            if (model == null || !HomeSearchBoxHeightModelKt.isAvailable(model)) {
                z = false;
            }
            if (z) {
                AtomicReferenceKt.setValue(searchBoxHeightABInternal, model);
            }
        }
    }

    @JvmStatic
    private static final void initWeatherColor() {
        String json = "";
        if (HomeSwitchMgr.INSTANCE.isAbSwitchNewHome()) {
            json = ABTestKt.getABTestSwitch("newhome_weather_color_one", "");
        } else if (HomeSwitchMgr.INSTANCE.isUpdateSwitchNewHome()) {
            json = NewHomeControlUpdateListenerKt.getUpdateKvStringFromLocal("newhome_weather_color_one", "");
        }
        boolean z = true;
        if (!(json.length() == 0)) {
            HomeWeatherColorModel model = HomeWeatherColorModelKt.decodeWeatherColorAB(json);
            if (model == null || !HomeWeatherColorModelKt.isAvailable(model)) {
                z = false;
            }
            if (z) {
                AtomicReferenceKt.setValue(weatherColorABInternal, model);
            }
        }
    }
}
