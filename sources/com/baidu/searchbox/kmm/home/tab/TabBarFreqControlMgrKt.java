package com.baidu.searchbox.kmm.home.tab;

import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.home.tabs.constants.HomeTabIconBubbleConstants;
import com.baidu.searchbox.kmm.updateprocessor.TabBarFreqControlCCSListenerKt;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0011\u001a\u0001\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f2J\u0010\r\u001aF\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000b0\u000bj*\u0012\u0004\u0012\u00020\u0001\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e`\f`\f2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001at\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012J\u0010\r\u001aF\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000b0\u000bj*\u0012\u0004\u0012\u00020\u0001\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e`\f`\fH\u0002\u001a\u0001\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2J\u0010\r\u001aF\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000b0\u000bj*\u0012\u0004\u0012\u00020\u0001\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e`\f`\fH\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a\u0018\u0010#\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\u0010\u0010$\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a\u0018\u0010%\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\u0018\u0010&\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a\u0018\u0010'\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0016H\u0000\u001a \u0010)\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0016H\u0000\u001a\u0010\u0010*\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"COMMON_LAST_SHOW_TIMESTAMP_KEY_PREFIX", "", "JSON_KEY_OPERATIONS", "LOG_TAG", "SPECIFIC_LAST_SHOW_TIMESTAMP_KEY_PREFIX", "TAB_BAR_FREQ_AVAILABLE", "", "TAB_BAR_FREQ_DISMISS_INTERVAL", "TAB_BAR_FREQ_DISPLAY_COUNT", "TAB_BAR_FREQ_OTHER", "checkSpecMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tabUploadInfo", "", "tab", "operationType", "composeCommonParams", "", "kvKey", "prefix", "defaultValue", "", "jsonKey", "composeSpecificOperationParams", "tabIdList", "", "diffMin", "ts1", "ts2", "logPrefix", "tabId", "makeCommonDismissTimeKey", "makeCommonLastDisplayTimeKey", "makeDismissUniqueIdKey", "makeLastDisplayTimeKey", "makeShowUniqueIdKey", "makeSpecificDismissTimeKey", "makeSpecificDisplayCountKey", "makeTabCommonDailyDisplayCountKey", "dayIndex", "makeTabSpecificDailyDisplayCountKey", "makeTabSumDisplayCountKey", "com.baidu.searchbox.kmm.business.home"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabBarFreqControlMgr.kt */
public final class TabBarFreqControlMgrKt {
    public static final String COMMON_LAST_SHOW_TIMESTAMP_KEY_PREFIX = "common_lastshow_timestamp_";
    private static final String JSON_KEY_OPERATIONS = "operations";
    private static final String LOG_TAG = "KMM-BarFreq";
    public static final String SPECIFIC_LAST_SHOW_TIMESTAMP_KEY_PREFIX = "lastshow_timestamp_";
    public static final int TAB_BAR_FREQ_AVAILABLE = 0;
    public static final int TAB_BAR_FREQ_DISMISS_INTERVAL = 2;
    public static final int TAB_BAR_FREQ_DISPLAY_COUNT = 1;
    public static final int TAB_BAR_FREQ_OTHER = -1;

    /* access modifiers changed from: private */
    public static final long diffMin(long ts1, long ts2) {
        return ((ts1 - ts2) / ((long) 60)) / ((long) 1000);
    }

    public static final String makeTabSumDisplayCountKey(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        return "sum_show_times_" + tabId;
    }

    public static final String makeSpecificDisplayCountKey(String tabId, String operationType) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(operationType, HomeTabIconBubbleConstants.HOME_TAB_OPERATION_TYPE);
        return "show_times_" + tabId + GroupMemberAdapter.MANAGER_CHAR + operationType;
    }

    private static final String makeLastDisplayTimeKey(String tabId, String operationType) {
        return SPECIFIC_LAST_SHOW_TIMESTAMP_KEY_PREFIX + tabId + GroupMemberAdapter.MANAGER_CHAR + operationType;
    }

    private static final String makeCommonLastDisplayTimeKey(String tabId) {
        return COMMON_LAST_SHOW_TIMESTAMP_KEY_PREFIX + tabId;
    }

    /* access modifiers changed from: private */
    public static final String makeSpecificDismissTimeKey(String tabId, String operationType) {
        return "last_dismiss_timestamp_" + tabId + GroupMemberAdapter.MANAGER_CHAR + operationType;
    }

    /* access modifiers changed from: private */
    public static final String makeCommonDismissTimeKey(String tabId) {
        return "common_last_dismiss_timestamp_" + tabId;
    }

    /* access modifiers changed from: private */
    public static final String makeShowUniqueIdKey(String tabId) {
        return "last_show_" + tabId + "_uniqueId";
    }

    /* access modifiers changed from: private */
    public static final String makeDismissUniqueIdKey(String tabId) {
        return "last_dismiss_" + tabId + "_uniqueId";
    }

    public static final String makeTabCommonDailyDisplayCountKey(String tabId, long dayIndex) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        return TabBarFreqControlCCSListenerKt.COMMON_DISPLAY_COUNT_KEY_PREFIX + tabId + GroupMemberAdapter.MANAGER_CHAR + dayIndex;
    }

    public static final String makeTabSpecificDailyDisplayCountKey(String tabId, String operationType, long dayIndex) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(operationType, HomeTabIconBubbleConstants.HOME_TAB_OPERATION_TYPE);
        return TabBarFreqControlCCSListenerKt.SPECIFIC_DISPLAY_COUNT_KEY_PREFIX + tabId + GroupMemberAdapter.MANAGER_CHAR + operationType + GroupMemberAdapter.MANAGER_CHAR + dayIndex;
    }

    /* access modifiers changed from: private */
    public static final String logPrefix(String tabId, String operationType) {
        return "Tab: " + tabId + ", Operation: " + operationType;
    }

    /* access modifiers changed from: private */
    public static final void composeCommonParams(String kvKey, String prefix, long defaultValue, String jsonKey, HashMap<String, HashMap<String, Object>> tabUploadInfo) {
        if (StringsKt.startsWith$default(kvKey, prefix, false, 2, (Object) null)) {
            String tabId = StringsKt.replace$default(kvKey, prefix, "", false, 4, (Object) null);
            Long l = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(kvKey, defaultValue);
            long kvValue = l != null ? l.longValue() : defaultValue;
            if (!tabUploadInfo.containsKey(tabId)) {
                tabUploadInfo.put(tabId, new HashMap());
            }
            HashMap hashMap = tabUploadInfo.get(tabId);
            if (hashMap != null) {
                hashMap.put(jsonKey, String.valueOf(kvValue));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void composeSpecificOperationParams(String kvKey, String prefix, long defaultValue, String jsonKey, Set<String> tabIdList, HashMap<String, HashMap<String, Object>> tabUploadInfo) {
        String str = kvKey;
        String str2 = prefix;
        boolean z = false;
        if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            for (String tab : tabIdList) {
                if (StringsKt.startsWith$default(str, str2 + tab + GroupMemberAdapter.MANAGER_CHAR, z, 2, (Object) null)) {
                    HashMap specMap = checkSpecMap(tabUploadInfo, tab, StringsKt.replace$default(kvKey, str2 + tab + GroupMemberAdapter.MANAGER_CHAR, "", false, 4, (Object) null));
                    if (specMap != null) {
                        long j2 = defaultValue;
                        Long l = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(str, j2);
                        String put = specMap.put(jsonKey, String.valueOf(l != null ? l.longValue() : j2));
                    } else {
                        long j3 = defaultValue;
                        String str3 = jsonKey;
                    }
                } else {
                    long j4 = defaultValue;
                    String str4 = jsonKey;
                    HashMap<String, HashMap<String, Object>> hashMap = tabUploadInfo;
                }
                z = false;
            }
            long j5 = defaultValue;
            String str5 = jsonKey;
            HashMap<String, HashMap<String, Object>> hashMap2 = tabUploadInfo;
            return;
        }
        long j6 = defaultValue;
        String str6 = jsonKey;
        HashMap<String, HashMap<String, Object>> hashMap3 = tabUploadInfo;
    }

    private static final HashMap<String, String> checkSpecMap(HashMap<String, HashMap<String, Object>> tabUploadInfo, String tab, String operationType) {
        HashMap hashMap;
        HashMap hashMap2 = tabUploadInfo.get(tab);
        boolean z = true;
        if (!(hashMap2 != null && hashMap2.containsKey(JSON_KEY_OPERATIONS)) && (hashMap = tabUploadInfo.get(tab)) != null) {
            hashMap.put(JSON_KEY_OPERATIONS, new HashMap());
        }
        HashMap hashMap3 = tabUploadInfo.get(tab);
        Object obj = hashMap3 != null ? hashMap3.get(JSON_KEY_OPERATIONS) : null;
        HashMap operationMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (operationMap == null || !operationMap.containsKey(operationType)) {
            z = false;
        }
        if (!z && operationMap != null) {
            operationMap.put(operationType, new HashMap());
        }
        Object obj2 = operationMap != null ? operationMap.get(operationType) : null;
        if (obj2 instanceof HashMap) {
            return (HashMap) obj2;
        }
        return null;
    }
}
