package com.baidu.searchbox.secondfloor.home.stat;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.secondfloor.home.model.SwanAppRecommendBanner;
import com.baidu.searchbox.secondfloor.home.model.SwanAppRecommendData;
import com.baidu.searchbox.secondfloor.home.model.SwanAppRecommendItem;
import com.baidu.searchbox.secondfloor.home.recommend.SwanAppItemBean;
import com.baidu.searchbox.secondfloor.home.recommend.SwanAppRecommendBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendShowUBCUtils {
    private static RecommendUBCShowData sRecommendListRecommendUBCShowData;
    private static RecommendUBCShowData sSecondFloorRecommendUBCShowData;

    public static void initSecondFloorRecommendUBCShowData(SwanAppRecommendData recommendData) {
        if (recommendData != null) {
            if (recommendData.bannerList != null) {
                Iterator<SwanAppRecommendBanner> it = recommendData.bannerList.iterator();
                while (it.hasNext()) {
                    it.next().sextJsonObject = recommendData.sextJsonObject;
                }
            }
            if (recommendData.recommendList != null) {
                Iterator<SwanAppRecommendItem> it2 = recommendData.recommendList.iterator();
                while (it2.hasNext()) {
                    it2.next().sextJsonObject = recommendData.sextJsonObject;
                }
            }
            RecommendUBCShowData recommendUBCShowData = new RecommendUBCShowData();
            sSecondFloorRecommendUBCShowData = recommendUBCShowData;
            recommendUBCShowData.sext = recommendData.sextJsonObject;
        }
    }

    public static void initRecommendListRecommendUBCShowData(SwanAppRecommendBean recommendBean) {
        if (recommendBean != null) {
            if (recommendBean.getAppList() != null) {
                for (SwanAppItemBean app : recommendBean.getAppList()) {
                    app.setSextJsonObject(recommendBean.getSextJsonObject());
                }
            }
            RecommendUBCShowData recommendUBCShowData = new RecommendUBCShowData();
            sRecommendListRecommendUBCShowData = recommendUBCShowData;
            recommendUBCShowData.sext = recommendBean.getSextJsonObject();
        }
    }

    public static void clearSecondFloorRecommendUBCShowData() {
        sSecondFloorRecommendUBCShowData = null;
    }

    public static void clearRecommendListRecommendUBCShowData() {
        sRecommendListRecommendUBCShowData = null;
    }

    public static void addShowBannerSecondFloor(int position, SwanAppRecommendBanner banner) {
        if (banner != null && sSecondFloorRecommendUBCShowData != null && banner.sextJsonObject == sSecondFloorRecommendUBCShowData.sext) {
            if (sSecondFloorRecommendUBCShowData.clist == null) {
                sSecondFloorRecommendUBCShowData.clist = new RecommendUBCShowList();
            }
            if (sSecondFloorRecommendUBCShowData.clist.bannerList == null) {
                sSecondFloorRecommendUBCShowData.clist.bannerList = new ArrayList();
            }
            for (RecommendUBCShowItem item : sSecondFloorRecommendUBCShowData.clist.bannerList) {
                if (position == item.position && TextUtils.equals(banner.bid, item.bid)) {
                    return;
                }
            }
            RecommendUBCShowItem item2 = new RecommendUBCShowItem();
            item2.position = position;
            item2.bid = banner.bid;
            item2.schema = banner.schema;
            item2.fromtype = banner.dataFrom;
            item2.stmp = System.currentTimeMillis();
            sSecondFloorRecommendUBCShowData.clist.bannerList.add(item2);
        }
    }

    public static void addShowAppSecondFloor(int position, SwanAppRecommendItem app) {
        if (app != null && sSecondFloorRecommendUBCShowData != null && app.sextJsonObject == sSecondFloorRecommendUBCShowData.sext) {
            if (sSecondFloorRecommendUBCShowData.clist == null) {
                sSecondFloorRecommendUBCShowData.clist = new RecommendUBCShowList();
            }
            if (sSecondFloorRecommendUBCShowData.clist.appList == null) {
                sSecondFloorRecommendUBCShowData.clist.appList = new ArrayList();
            }
            for (RecommendUBCShowItem item : sSecondFloorRecommendUBCShowData.clist.appList) {
                if (position == item.position && TextUtils.equals(app.appkey, item.appid)) {
                    return;
                }
            }
            RecommendUBCShowItem item2 = new RecommendUBCShowItem();
            item2.position = position;
            item2.appid = app.appkey;
            item2.schema = app.schema;
            item2.fromtype = app.dataFrom;
            item2.stmp = System.currentTimeMillis();
            sSecondFloorRecommendUBCShowData.clist.appList.add(item2);
        }
    }

    public static void addShowAppRecommendList(int position, SwanAppItemBean app) {
        if (app != null && sRecommendListRecommendUBCShowData != null && app.getSextJsonObject() == sRecommendListRecommendUBCShowData.sext) {
            if (sRecommendListRecommendUBCShowData.clist == null) {
                sRecommendListRecommendUBCShowData.clist = new RecommendUBCShowList();
            }
            if (sRecommendListRecommendUBCShowData.clist.appList == null) {
                sRecommendListRecommendUBCShowData.clist.appList = new ArrayList();
            }
            for (RecommendUBCShowItem item : sRecommendListRecommendUBCShowData.clist.appList) {
                if (position == item.position && TextUtils.equals(app.getAppkey(), item.appid)) {
                    return;
                }
            }
            RecommendUBCShowItem item2 = new RecommendUBCShowItem();
            item2.position = position;
            item2.appid = app.getAppkey();
            item2.schema = app.getSchema();
            item2.fromtype = app.getDataFrom();
            item2.stmp = System.currentTimeMillis();
            sRecommendListRecommendUBCShowData.clist.appList.add(item2);
        }
    }

    public static void reportSecondFloorRecommendUBCShowData() {
        if (sSecondFloorRecommendUBCShowData != null) {
            HomeSecondFloorUBCUtils.event("760", "show", (String) null, "rcm", "index", new Gson().toJson((Object) sSecondFloorRecommendUBCShowData));
            sSecondFloorRecommendUBCShowData.clist = null;
        }
    }

    public static void reportRecommendListRecommendUBCShowData() {
        if (sRecommendListRecommendUBCShowData != null) {
            HomeSecondFloorUBCUtils.event("760", "show", (String) null, "rcm", HomeSecondFloorStatConstants.PAGE_RECOMMEND_LIST, new Gson().toJson((Object) sRecommendListRecommendUBCShowData));
            sRecommendListRecommendUBCShowData.clist = null;
        }
    }

    static class RecommendUBCShowData implements NoProGuard {
        RecommendUBCShowList clist;
        JsonObject sext;

        RecommendUBCShowData() {
        }
    }

    static class RecommendUBCShowList implements NoProGuard {
        List<RecommendUBCShowItem> appList;
        List<RecommendUBCShowItem> bannerList;

        RecommendUBCShowList() {
        }
    }

    static class RecommendUBCShowItem implements NoProGuard {
        String appid;
        String bid;
        String fromtype;
        int position;
        String schema;
        long stmp;

        RecommendUBCShowItem() {
        }
    }
}
