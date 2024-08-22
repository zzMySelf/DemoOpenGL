package com.baidu.searchbox.feed.tab.navigation.utils;

import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tab.navigation.constant.TabNavConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u0006\u0010\b\u001a\u00020\t\u001a\u0006\u0010\n\u001a\u00020\t\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004\u001a\u0006\u0010\u000e\u001a\u00020\f\u001a\u0006\u0010\u000f\u001a\u00020\f\u001a\u0006\u0010\u0010\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"IS_SHOW_SORT_GUIDE", "", "LOAD_FILE_TASK_NAME", "SHOW_DRAG_DELAY_TIME", "", "getEnterManageTabCount", "", "getFirstEnterManageTabTime", "getManageTabIsDragged", "", "getManageTabIsEdited", "setFirstEnterManageTabTime", "", "timestamp", "setManageTabDragged", "setManageTabEdited", "updateEnterManageCountAndFirstTime", "lib-feed-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ManageTabGuideManager.kt */
public final class ManageTabGuideManagerKt {
    public static final String IS_SHOW_SORT_GUIDE = "isShowSortGuide";
    public static final String LOAD_FILE_TASK_NAME = "load_guide_from_file_task";
    public static final long SHOW_DRAG_DELAY_TIME = 400;

    public static final void updateEnterManageCountAndFirstTime() {
        int lastEnterCount = FeedPreferenceUtils.getInt(TabNavConstant.KEY_SP_ENTER_MANAGE_TAB_COUNT, 0) + 1;
        FeedPreferenceUtils.putInt(TabNavConstant.KEY_SP_ENTER_MANAGE_TAB_COUNT, lastEnterCount);
        if (lastEnterCount == 1) {
            OnLineLog.get(OnLineLog.TAG_TABS).d("ManageTabGuide[enter:]首次进入频道管理页，时间戳：" + System.currentTimeMillis());
            setFirstEnterManageTabTime(System.currentTimeMillis());
        }
        OnLineLog.get(OnLineLog.TAG_TABS).d("ManageTabGuide[enter:]进入频道管理页次数：" + lastEnterCount);
    }

    public static final int getEnterManageTabCount() {
        return FeedPreferenceUtils.getInt(TabNavConstant.KEY_SP_ENTER_MANAGE_TAB_COUNT, 1);
    }

    public static final boolean getManageTabIsEdited() {
        return FeedPreferenceUtils.getBoolean(TabNavConstant.KEY_SP_MANAGE_TAB_IS_EDITED, false);
    }

    public static final void setManageTabEdited() {
        FeedPreferenceUtils.putBoolean(TabNavConstant.KEY_SP_MANAGE_TAB_IS_EDITED, true);
    }

    public static final boolean getManageTabIsDragged() {
        return FeedPreferenceUtils.getBoolean(TabNavConstant.KEY_SP_MANAGE_TAB_IS_DRAGGED, false);
    }

    public static final void setManageTabDragged() {
        FeedPreferenceUtils.putBoolean(TabNavConstant.KEY_SP_MANAGE_TAB_IS_DRAGGED, true);
    }

    public static final long getFirstEnterManageTabTime() {
        return FeedPreferenceUtils.getLong(TabNavConstant.KEY_SP_FIRST_ENTER_MANAGE_TAB_TIME, 0);
    }

    public static final void setFirstEnterManageTabTime(long timestamp) {
        FeedPreferenceUtils.putLong(TabNavConstant.KEY_SP_FIRST_ENTER_MANAGE_TAB_TIME, timestamp);
    }
}
