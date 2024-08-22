package com.baidu.searchbox.kmm.home.lv1tab;

import co.touchlab.stately.concurrency.AtomicReferenceKt;
import com.baidu.searchbox.home.tabs.HomeTabTextHolder;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"initHomeLv1TabsFromEmbedData", "", "com.baidu.searchbox.kmm.business.home"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLv1TabEmbedData.kt */
public final class HomeLv1TabEmbedDataKt {
    public static final void initHomeLv1TabsFromEmbedData() {
        List list = new ArrayList();
        Map map = new LinkedHashMap();
        String blockedId = HomeLv1TabUtils.getBlockedTabId();
        if (!Intrinsics.areEqual((Object) blockedId, (Object) "509")) {
            HomeLv1TabModel homeLv1TabModel = new HomeLv1TabModel();
            HomeLv1TabModel $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0 = homeLv1TabModel;
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.setTabId$com_baidu_searchbox_kmm_business_home("509");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.setTabName$com_baidu_searchbox_kmm_business_home("推荐");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.setTabType$com_baidu_searchbox_kmm_business_home("0");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.setUbcType$com_baidu_searchbox_kmm_business_home(HomeLv1TabModelKt.getTabUBCType($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.getTabId()));
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.setSelected$com_baidu_searchbox_kmm_business_home(true);
            AtomicReferenceKt.setValue(HomeLv1TabDataMgr.INSTANCE.getCurrentSelectedTab$com_baidu_searchbox_kmm_business_home(), $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0);
            AtomicReferenceKt.setValue(HomeLv1TabDataMgr.INSTANCE.getDefaultSelectTab$com_baidu_searchbox_kmm_business_home(), $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0);
            map.put($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0.getTabId(), $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d0);
            list.add(homeLv1TabModel);
        }
        if (!Intrinsics.areEqual((Object) blockedId, (Object) "32") && !HomeLv1TabUtils.isBottomBarDisplayedTab("1014")) {
            HomeLv1TabModel homeLv1TabModel2 = new HomeLv1TabModel();
            HomeLv1TabModel $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1 = homeLv1TabModel2;
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.setTabId$com_baidu_searchbox_kmm_business_home("32");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.setTabName$com_baidu_searchbox_kmm_business_home(HomeTabTextHolder.NOVEL_TAB_TEXT);
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.setTabType$com_baidu_searchbox_kmm_business_home("0");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.setUbcType$com_baidu_searchbox_kmm_business_home(HomeLv1TabModelKt.getTabUBCType($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.getTabId()));
            map.put($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1.getTabId(), $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d1);
            list.add(homeLv1TabModel2);
        }
        if (!Intrinsics.areEqual((Object) blockedId, (Object) "163") && !HomeLv1TabUtils.isBottomBarDisplayedTab("1012")) {
            HomeLv1TabModel homeLv1TabModel3 = new HomeLv1TabModel();
            HomeLv1TabModel $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2 = homeLv1TabModel3;
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTabId$com_baidu_searchbox_kmm_business_home("163");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTabName$com_baidu_searchbox_kmm_business_home(HomeTabTextHolder.SHOP_TAB_TEXT);
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTabType$com_baidu_searchbox_kmm_business_home("1");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTalosbizName$com_baidu_searchbox_kmm_business_home("box.rnplugin.searchmanifest");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTalosModuleName$com_baidu_searchbox_kmm_business_home("SearchShoppingIndex");
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTalosPreFetchObj$com_baidu_searchbox_kmm_business_home(new JsonObject((Map<String, ?>) MapsKt.mapOf(TuplesKt.to("method", "get"), TuplesKt.to("url", "https://ducheap.baidu.com/api/entry?ext=%7B%22sa%22%3A%22ozxj_247_256-113_home_na%22%7D&env=mall&shape=mall"))).getRawObject());
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setTalosInitPropsObj$com_baidu_searchbox_kmm_business_home(new JsonObject((Map<String, ?>) MapsKt.mapOf(TuplesKt.to("env", "mall"), TuplesKt.to("sa", "ozxj_247_256-113_home_na"))).getRawObject());
            $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.setUbcType$com_baidu_searchbox_kmm_business_home(HomeLv1TabModelKt.getTabUBCType($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.getTabId()));
            map.put($this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2.getTabId(), $this$initHomeLv1TabsFromEmbedData_u24lambda_u2d2);
            list.add(homeLv1TabModel3);
        }
        AtomicReferenceKt.setValue(HomeLv1TabDataMgr.INSTANCE.getTabsDataList$com_baidu_searchbox_kmm_business_home(), list);
        AtomicReferenceKt.setValue(HomeLv1TabDataMgr.INSTANCE.getTabsDataMap$com_baidu_searchbox_kmm_business_home(), map);
    }
}
