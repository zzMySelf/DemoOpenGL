package com.baidu.searchbox.feed.widget.tabfloat;

import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.tab.navigation.utils.FeedTabFloatManager;

public class TabFloatSp {
    public static final String CLOSE_COUNT_ON_TAB_ID = "tab_float_close_count_";
    public static final String LAST_CLOSE_TIME_ON_TAB_ID = "tab_float_last_close_time_";
    public static final String LAST_SHOWN_TIME = "tab_float_last_shown_time";
    private static final String TAG = "TabFloatSp";

    public static boolean shouldShowFloatViewFromSp(String tabId) {
        FeedTabFloatManager.TabFloatModel model = FeedTabFloatManager.getInstance().getTabFloatModel();
        if (model == null || !model.isValidate() || DateTimeUtils.isSameDay(System.currentTimeMillis(), FeedPreferenceUtils.getLong(LAST_SHOWN_TIME, 0))) {
            return false;
        }
        int tabCloseCount = FeedPreferenceUtils.getInt(CLOSE_COUNT_ON_TAB_ID + tabId, 0);
        long tabLastCloseTime = FeedPreferenceUtils.getLong(LAST_CLOSE_TIME_ON_TAB_ID + tabId, 0);
        if (tabCloseCount >= 3) {
            return false;
        }
        if (tabCloseCount == 1 && DateTimeUtils.isFewDaysAgo(tabLastCloseTime, model.firstDelTimeSpace)) {
            return false;
        }
        if (tabCloseCount != 2 || !DateTimeUtils.isFewDaysAgo(tabLastCloseTime, model.secondDelTimeSpace)) {
            return true;
        }
        return false;
    }

    public static void updateCloseData(String tabId) {
        String keyCloseCount = CLOSE_COUNT_ON_TAB_ID + tabId;
        FeedPreferenceUtils.putInt(keyCloseCount, FeedPreferenceUtils.getInt(keyCloseCount, 0) + 1);
        FeedPreferenceUtils.putLong(LAST_CLOSE_TIME_ON_TAB_ID + tabId, System.currentTimeMillis());
    }

    public static void updateShownTime() {
        FeedPreferenceUtils.putLong(LAST_SHOWN_TIME, System.currentTimeMillis());
    }
}
