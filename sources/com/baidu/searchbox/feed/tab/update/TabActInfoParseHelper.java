package com.baidu.searchbox.feed.tab.update;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TabActInfoParseHelper {
    private static final String SP_KEY_FEED_ACT_USER_CLICK = "feed_act_user_click";
    private static final String SP_SEPARATOR = ";";
    private static final String SP_TAB_ACT_SHOW = "tab_act_show";
    private static final String SP_TAB_USER_CLICK = "tab_user_click";
    public static final String TAG = "TabActInfoParseHelper";
    private static final String VALUE_SECTION_TYPE_DAY = "1";
    private static final String VALUE_SECTION_TYPE_TOTAL = "-1";
    private static final int VALUE_TIMES_INFINITE = -1;
    public static String mActId;
    private static boolean mIsFirstBoot = true;
    private static HashMap<String, Boolean> sTabShowingNewMap = new HashMap<>();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean parseTabActInfo(java.lang.String r5, com.baidu.searchbox.feed.tab.update.MultiTabItemActInfo r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x00b9
            if (r6 != 0) goto L_0x000b
            goto L_0x00b9
        L_0x000b:
            boolean r0 = r6.isOnline()
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            r2 = 1
            if (r0 == 0) goto L_0x002a
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002a
            return r2
        L_0x002a:
            java.lang.String r0 = r6.activityId
            mActId = r0
            boolean r0 = mIsFirstBoot
            if (r0 == 0) goto L_0x00a1
            int r0 = r6.totalMaxTimes
            r3 = -1
            if (r0 == r3) goto L_0x0044
            java.lang.String r0 = r6.activityId
            java.lang.String r4 = "-1"
            int r0 = getActShowCount(r5, r0, r4)
            int r4 = r6.totalMaxTimes
            if (r0 < r4) goto L_0x0044
            return r1
        L_0x0044:
            int r0 = r6.sectionMaxTimes
            if (r0 != r3) goto L_0x0052
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r0.put(r5, r3)
            goto L_0x0086
        L_0x0052:
            java.lang.String r0 = r6.sectionType
            int r4 = r0.hashCode()
            switch(r4) {
                case 49: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0066
        L_0x005c:
            java.lang.String r4 = "1"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x005b
            r0 = r1
            goto L_0x0067
        L_0x0066:
            r0 = r3
        L_0x0067:
            switch(r0) {
                case 0: goto L_0x006b;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x0086
        L_0x006b:
            int r0 = r6.sectionMaxTimes
            if (r0 == r3) goto L_0x007c
            java.lang.String r0 = r6.activityId
            java.lang.String r3 = r6.sectionType
            int r0 = getActShowCount(r5, r0, r3)
            int r3 = r6.sectionMaxTimes
            if (r0 < r3) goto L_0x007c
            return r1
        L_0x007c:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r0.put(r5, r3)
        L_0x0086:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            if (r0 == 0) goto L_0x00a1
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00a1
            java.lang.String r0 = r6.activityId
            recordActShowTime(r5, r0)
        L_0x00a1:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            if (r0 == 0) goto L_0x00b8
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = sTabShowingNewMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00b8
            r1 = r2
        L_0x00b8:
            return r1
        L_0x00b9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.update.TabActInfoParseHelper.parseTabActInfo(java.lang.String, com.baidu.searchbox.feed.tab.update.MultiTabItemActInfo):boolean");
    }

    public static void setFirstBoot(boolean isFirstBoot) {
        mIsFirstBoot = isFirstBoot;
    }

    public static boolean isShowingNew(String tabId) {
        HashMap<String, Boolean> hashMap;
        if (TextUtils.isEmpty(tabId) || (hashMap = sTabShowingNewMap) == null || hashMap.get(tabId) == null || !sTabShowingNewMap.get(tabId).booleanValue()) {
            return false;
        }
        return true;
    }

    private static void recordActShowTime(String tabId, String actId) {
        SharedPreferences sp = FeedRuntime.getAppContext().getSharedPreferences(SP_TAB_ACT_SHOW, 0);
        String uniActID = genUniActSign(tabId, actId);
        Set<String> actShowTimeSet = sp.getStringSet(uniActID, new HashSet());
        Set<String> newActShowTimeSet = new HashSet<>();
        newActShowTimeSet.addAll(actShowTimeSet);
        newActShowTimeSet.add(String.valueOf(System.currentTimeMillis()));
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(uniActID, newActShowTimeSet);
        editor.apply();
    }

    private static int getActShowCount(String tabId, String actId, String queryType) {
        Set<String> actShowTimeSet = FeedRuntime.getAppContext().getSharedPreferences(SP_TAB_ACT_SHOW, 0).getStringSet(genUniActSign(tabId, actId), new HashSet());
        if (TextUtils.equals(queryType, "-1")) {
            return actShowTimeSet.size();
        }
        List<Long> actShowTimeList = new ArrayList<>();
        for (String showTime : actShowTimeSet) {
            actShowTimeList.add(Long.valueOf(showTime));
        }
        Collections.sort(actShowTimeList);
        int showTimeInDay = 0;
        int i2 = actShowTimeList.size() - 1;
        while (i2 >= 0 && actShowTimeList.get(i2).longValue() >= getTodayZeroTime()) {
            showTimeInDay++;
            i2--;
        }
        return showTimeInDay;
    }

    public static void recordUserClick(String tabId) {
        if (!TextUtils.isEmpty(mActId)) {
            SharedPreferences sp = FeedRuntime.getAppContext().getSharedPreferences(SP_TAB_USER_CLICK, 0);
            Set<String> userClickActIdSet = sp.getStringSet(SP_KEY_FEED_ACT_USER_CLICK, new HashSet());
            Set<String> newUserClickActIdSet = new HashSet<>();
            newUserClickActIdSet.addAll(userClickActIdSet);
            newUserClickActIdSet.add(genUniActSign(tabId, mActId));
            SharedPreferences.Editor editor = sp.edit();
            editor.putStringSet(SP_KEY_FEED_ACT_USER_CLICK, newUserClickActIdSet);
            editor.apply();
        }
    }

    private static long getTodayZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime().getTime();
    }

    private static String genUniActSign(String tabId, String actId) {
        return tabId + ";" + actId;
    }
}
