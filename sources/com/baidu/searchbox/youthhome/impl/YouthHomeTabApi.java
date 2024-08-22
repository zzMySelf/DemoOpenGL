package com.baidu.searchbox.youthhome.impl;

import android.text.TextUtils;
import com.baidu.searchbox.kmm.home.youth.YouthHomeLv1TabMgr;
import com.baidu.searchbox.kmm.home.youth.YouthHomeLv1TabModel;
import com.baidu.searchbox.topinterface.IYouthHomeTabApi;
import com.baidu.searchbox.youthhome.YouthHomeTabContainer;
import com.baidu.searchbox.youthhome.YouthHomeTabContainerManager;
import com.baidu.searchbox.youthhome.YouthHomeTabLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/youthhome/impl/YouthHomeTabApi;", "Lcom/baidu/searchbox/topinterface/IYouthHomeTabApi;", "()V", "getCurrentTabIndex", "", "getCurrentTabTag", "", "getDefaultV1TabTag", "isCurrentRecommendTab", "", "isHideTabs", "setCurrentTab", "", "index", "setCurrentTabByTag", "tag", "youth-home-top_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeTabApi.kt */
public final class YouthHomeTabApi implements IYouthHomeTabApi {
    public String getCurrentTabTag() {
        YouthHomeLv1TabModel currentSelectedTab = YouthHomeLv1TabMgr.INSTANCE.getCurrentSelectedTab();
        if (currentSelectedTab != null) {
            return currentSelectedTab.getTabId();
        }
        return null;
    }

    public int getCurrentTabIndex() {
        YouthHomeLv1TabModel currentSelectedTab = YouthHomeLv1TabMgr.INSTANCE.getCurrentSelectedTab();
        if (currentSelectedTab != null) {
            return currentSelectedTab.getIndex();
        }
        return 0;
    }

    public void setCurrentTabByTag(String tag) {
        YouthHomeTabContainer youthHomeTabContainer;
        YouthHomeTabLayout tabLayout;
        Intrinsics.checkNotNullParameter(tag, "tag");
        WeakReference<YouthHomeTabContainer> youthHomeTabContainer2 = YouthHomeTabContainerManager.INSTANCE.getYouthHomeTabContainer();
        if (youthHomeTabContainer2 != null && (youthHomeTabContainer = (YouthHomeTabContainer) youthHomeTabContainer2.get()) != null && (tabLayout = youthHomeTabContainer.getTabLayout()) != null) {
            YouthHomeTabLayout.setCurrentTabByTag$default(tabLayout, tag, false, 2, (Object) null);
        }
    }

    public void setCurrentTab(int index) {
        YouthHomeTabContainer youthHomeTabContainer;
        YouthHomeTabLayout tabLayout;
        WeakReference<YouthHomeTabContainer> youthHomeTabContainer2 = YouthHomeTabContainerManager.INSTANCE.getYouthHomeTabContainer();
        if (youthHomeTabContainer2 != null && (youthHomeTabContainer = (YouthHomeTabContainer) youthHomeTabContainer2.get()) != null && (tabLayout = youthHomeTabContainer.getTabLayout()) != null) {
            YouthHomeTabLayout.setCurrentTab$default(tabLayout, index, false, 2, (Object) null);
        }
    }

    public boolean isCurrentRecommendTab() {
        return TextUtils.equals(getCurrentTabTag(), "215");
    }

    public String getDefaultV1TabTag() {
        try {
            YouthHomeLv1TabModel currentSelectedTab = YouthHomeLv1TabMgr.INSTANCE.getCurrentSelectedTab();
            if (currentSelectedTab != null) {
                return currentSelectedTab.getTabId();
            }
            return null;
        } catch (Exception e2) {
            String str = null;
            return null;
        }
    }

    public boolean isHideTabs() {
        YouthHomeTabContainer youthHomeTabContainer;
        WeakReference<YouthHomeTabContainer> youthHomeTabContainer2 = YouthHomeTabContainerManager.INSTANCE.getYouthHomeTabContainer();
        if (youthHomeTabContainer2 == null || (youthHomeTabContainer = (YouthHomeTabContainer) youthHomeTabContainer2.get()) == null) {
            return false;
        }
        return youthHomeTabContainer.isHideTabs();
    }
}
