package com.baidu.live.business.model.data;

import android.text.TextUtils;
import com.baidu.live.business.util.LiveFeedPreferenceUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveTabWrapData {
    public static final String LIVE_FEED_PAGE_TAB_CACHE_KEY = "live_feed_page_tab_cache_key";
    public static final String LIVE_FEED_PAGE_TAB_CACHE_TIME = "live_feed_page_tab_cache_time";
    public int cacheCause;
    public long cacheTime;
    public int errCode;
    public String errMsg;
    public boolean isCacheData;
    public List<LiveTabEntity> tabList;

    public void parserJson(JSONObject jsonObject, boolean pageInit, int requestCode, boolean isLiveChannel) {
        List<LiveTabEntity> list;
        if (jsonObject != null) {
            this.errCode = jsonObject.optInt("inner_errno");
            this.errMsg = jsonObject.optString("inner_msg");
            JSONArray itemsArray = jsonObject.optJSONArray("items");
            getTabListByJson(itemsArray);
            if (pageInit && itemsArray != null && (list = this.tabList) != null && !list.isEmpty() && isLiveChannel) {
                LiveFeedPreferenceUtils.putLong(LIVE_FEED_PAGE_TAB_CACHE_TIME, System.currentTimeMillis());
                LiveFeedPreferenceUtils.putString(LIVE_FEED_PAGE_TAB_CACHE_KEY, itemsArray.toString());
            }
        }
        if (isLiveChannel && pageInit) {
            List<LiveTabEntity> list2 = this.tabList;
            if (list2 == null || list2.isEmpty()) {
                this.cacheCause = 2;
                String tabCache = LiveFeedPreferenceUtils.getString(LIVE_FEED_PAGE_TAB_CACHE_KEY, "");
                if (!TextUtils.isEmpty(tabCache)) {
                    try {
                        getTabListByJson(new JSONArray(tabCache));
                        this.isCacheData = true;
                        if (requestCode == -101) {
                            this.cacheCause = 1;
                        } else if (this.errCode != 0) {
                            this.cacheCause = 3;
                        }
                        this.cacheTime = LiveFeedPreferenceUtils.getlong(LIVE_FEED_PAGE_TAB_CACHE_TIME, 0);
                    } catch (JSONException e2) {
                        LiveFeedPreferenceUtils.removeKey(LIVE_FEED_PAGE_TAB_CACHE_KEY);
                        LiveFeedPreferenceUtils.removeKey(LIVE_FEED_PAGE_TAB_CACHE_TIME);
                    }
                }
            }
        }
    }

    private void getTabListByJson(JSONArray itemsArray) {
        if (itemsArray != null && itemsArray.length() > 0) {
            this.tabList = new ArrayList();
            for (int i2 = 0; i2 < itemsArray.length(); i2++) {
                JSONObject itemJson = itemsArray.optJSONObject(i2);
                if (itemJson != null) {
                    LiveTabEntity itemInfo = new LiveTabEntity();
                    itemInfo.parserJson(itemJson);
                    this.tabList.add(itemInfo);
                }
            }
        }
    }
}
