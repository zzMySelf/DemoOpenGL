package com.baidu.searchbox.feed.controller;

import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.listener.FeedBackToHomeListener;
import com.baidu.searchbox.feed.util.FeedUtil;

public class SearchBackToHomeManager {
    public static final int PAGE_NONE = -1;
    public static final int PAGE_SEARCH = 0;
    private static final String SEARCH_BACK_REFORM_A = "0";
    private static final String SEARCH_BACK_REFORM_B = "1";
    private int mEnterPage;
    private boolean mEnterSearchPage;
    private boolean mIsHomeState;
    private String mSearchBackReform;

    private SearchBackToHomeManager() {
        this.mEnterPage = -1;
        this.mEnterSearchPage = false;
        this.mIsHomeState = true;
        this.mSearchBackReform = "0";
        this.mSearchBackReform = FeedPreferenceUtils.getQuickString(FeedBackToHomeListener.BACK_BUTTON_TO_HOME_REFORM, "0");
        FeedUtil.refreshLog("SearchBackToHomeManager", "-init- mSearchBackReform:" + this.mSearchBackReform);
    }

    public boolean isSearchBackReformB() {
        boolean isSearchBackReformB = TextUtils.equals(this.mSearchBackReform, "1");
        FeedUtil.refreshLog("SearchBackToHomeManager", "isSearchBackReformB:" + isSearchBackReformB);
        return isSearchBackReformB;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final SearchBackToHomeManager INSTANCE = new SearchBackToHomeManager();

        private Holder() {
        }
    }

    public static SearchBackToHomeManager getInstance() {
        return Holder.INSTANCE;
    }

    public int getAnchorPos() {
        if (this.mEnterPage == 0) {
            return FeedPreferenceUtils.getQuickInt(FeedBackToHomeListener.BACK_BUTTON_TO_HOME, -1);
        }
        return -1;
    }

    public boolean isBackFromSearch() {
        return this.mEnterPage == 0;
    }

    public boolean isBackFromSearchPage() {
        return this.mEnterSearchPage;
    }

    public void setEnterSearchPage() {
        this.mEnterSearchPage = true;
    }

    public void resetEnterSearchPage() {
        this.mEnterSearchPage = false;
    }

    public void setHomeState(boolean mIsHomeState2) {
        this.mIsHomeState = mIsHomeState2;
    }

    public boolean isHomeState() {
        return this.mIsHomeState;
    }

    public void clear() {
        this.mEnterPage = -1;
    }

    public void setEnterPage(int page) {
        this.mEnterPage = page;
    }
}
