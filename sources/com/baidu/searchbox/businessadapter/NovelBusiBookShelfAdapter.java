package com.baidu.searchbox.businessadapter;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.kmm.home.lv1tab.HomeLv1TabDataMgr;
import com.baidu.searchbox.kmm.home.lv1tab.HomeLv1TabModel;
import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.novel.common.utils.NovelPadUtilsWrapper;
import com.baidu.searchbox.novel.main.utils.NovelEventDispatcher;
import java.util.List;

public class NovelBusiBookShelfAdapter implements NoProGuard {
    public static boolean shelfEditHideRecommendAndMove() {
        return false;
    }

    public static boolean shelfMenuHideAddToDesktop() {
        return false;
    }

    public static boolean shelfMenuHideNewGroup() {
        return false;
    }

    public static boolean shelfMenuHideReadHistory() {
        return false;
    }

    public static boolean shelfHideAd() {
        return false;
    }

    public static boolean shelfHideHeaderView() {
        return false;
    }

    public static boolean canCloudSync() {
        return true;
    }

    public static boolean canPullDownRefresh() {
        return true;
    }

    public static boolean isBaiduBookShelf() {
        return true;
    }

    public static boolean shelfHideHeaderRecommend() {
        return false;
    }

    public static boolean shelfHideRecommendGroup() {
        return false;
    }

    public static boolean shelfMenuHideUpdateAlert() {
        return false;
    }

    public static boolean shelfMenuShowLinearOrGridMode() {
        return true;
    }

    public static boolean isNewHomePage() {
        List<HomeLv1TabModel> tabList;
        if (NovelPadUtilsWrapper.isInPadMode()) {
            return true;
        }
        Object service = ServiceManager.getService(INewHomeApi.SERVICE_REFERENCE);
        if (!(service instanceof INewHomeApi) || !((INewHomeApi) service).isNewHome() || (tabList = HomeLv1TabDataMgr.getDisplayHomeLv1Tabs()) == null || tabList.size() <= 0) {
            return false;
        }
        for (HomeLv1TabModel tab : tabList) {
            if (tab != null && TextUtils.equals(tab.getTabId(), "32")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBottomHomePage() {
        return "1014".equals(HomeFourthTabTypeUtils.INSTANCE.getCurrentTabTag());
    }

    public static void openVipSuccess() {
        NovelEventDispatcher.getInstance().onEvent(NovelEventDispatcher.VIP_STATE_CHANGE);
    }
}
