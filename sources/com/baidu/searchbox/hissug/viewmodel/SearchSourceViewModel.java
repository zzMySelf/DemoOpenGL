package com.baidu.searchbox.hissug.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.browser.SearchConstants;
import com.baidu.searchbox.hissug.HissugConfig;
import com.baidu.searchbox.hissug.util.SugUtil;
import com.baidu.searchbox.hissug.util.common.SceneConstantsKt;

public class SearchSourceViewModel {
    private static final String ENTRANCE_KEY_FEED_BOX = "bdbox_fdserch_txt";
    private static final String ENTRANCE_KEY_HOME_BOX = "home_box_txt";
    private static final String ENTRANCE_KEY_MINI_VIDEO = "m";
    private static final String ENTRANCE_KEY_NOTIFICATION = "app_mainbox_fast_txt";
    private static final String ENTRANCE_KEY_SEARCH_LAND_BOX = "bdbox_tserchland_txt";
    public static final String ENTRANCE_KEY_SEARCH_RESULT_BOX = "bdbox_tserch_txt";
    private static final String ENTRANCE_KEY_VIDEO = "c";
    private boolean isFromBrowserBack = false;
    private boolean isHuikuangSugBack = false;
    private String mSearchFromKey;
    private String mSearchSource;

    public void setSearchSource(Intent intent) {
        this.mSearchSource = SugUtil.getSearchSource(HissugConfig.getAppContext(), intent);
    }

    public void setSearchFromKey(Intent intent) {
        if (intent == null) {
            this.mSearchFromKey = SceneConstantsKt.SCENE_OTHER;
            return;
        }
        String entranceKey = intent.getStringExtra("search_source");
        String boxEntranceKey = intent.getStringExtra("search_box_entrance_key");
        if (TextUtils.equals(entranceKey, "home_box_txt")) {
            this.mSearchFromKey = "ho";
        } else if (TextUtils.equals(entranceKey, "bdbox_fdserch_txt")) {
            this.mSearchFromKey = "fe";
        } else if (TextUtils.equals(entranceKey, "bdbox_tserch_txt")) {
            this.mSearchFromKey = "re";
        } else if (TextUtils.equals(entranceKey, "bdbox_tserchland_txt")) {
            this.mSearchFromKey = SceneConstantsKt.SCENE_LANDING;
        } else if (!TextUtils.isEmpty(boxEntranceKey)) {
            if (TextUtils.equals(boxEntranceKey, "c")) {
                this.mSearchFromKey = "mo";
            } else if (TextUtils.equals(boxEntranceKey, "m")) {
                this.mSearchFromKey = SceneConstantsKt.SCENE_MINIVIDEO;
            } else {
                this.mSearchFromKey = boxEntranceKey;
            }
        } else if (TextUtils.equals(entranceKey, "osts")) {
            this.mSearchFromKey = entranceKey;
        } else if (!TextUtils.equals(entranceKey, "app_mainbox_fast_txt")) {
            this.mSearchFromKey = SceneConstantsKt.SCENE_OTHER;
        }
    }

    public void setSearchFromKey(Intent intent, String searchFromKey) {
        if (searchFromKey != null) {
            this.mSearchFromKey = searchFromKey;
            if (intent != null) {
                intent.putExtra("search_box_entrance_key", searchFromKey);
            }
        }
    }

    public String getSearchSource() {
        return this.mSearchSource;
    }

    public String getSearchFromKey() {
        return this.mSearchFromKey;
    }

    public void setIsFromBrowserBack(Intent intent) {
        if (intent != null) {
            this.isFromBrowserBack = intent.getBooleanExtra("is_from_browser_back", false);
        }
    }

    public boolean isFromBrowserBack() {
        return this.isFromBrowserBack;
    }

    public boolean isHuikuangSugBack() {
        return this.isHuikuangSugBack;
    }

    public void setHuikuangSugBack(Intent intent) {
        if (intent != null) {
            this.isHuikuangSugBack = intent.getBooleanExtra(SearchConstants.IS_HUIKUANG_SUG_BACK, false);
        }
    }
}
