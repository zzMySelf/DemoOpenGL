package com.baidu.searchbox.kmm.home.tab;

import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.kmm.foundation.utils.datetime.DateKt;
import com.baidu.searchbox.kmm.foundation.utils.datetime.TimeUtils;
import com.baidu.searchbox.kmm.updateprocessor.TabBarFreqControlCCSListenerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/kmm/home/tab/TabBarFreqControlMigrationHelper;", "", "()V", "KEY_MIGRATION_VERSION", "", "MIGRATION_VERSION_1", "", "MIGRATION_VERSION_2", "getCurrentMigrationVersion", "migrateVersionFrom1To2IfNeed", "", "setCurrentMigrationVersion", "version", "com.baidu.searchbox.kmm.business.home"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabBarFreqControlMigrationHelper.kt */
public final class TabBarFreqControlMigrationHelper {
    public static final TabBarFreqControlMigrationHelper INSTANCE = new TabBarFreqControlMigrationHelper();
    private static final String KEY_MIGRATION_VERSION = "tab_bar_freq_ctrl_ver";
    private static final int MIGRATION_VERSION_1 = 1;
    private static final int MIGRATION_VERSION_2 = 2;

    private TabBarFreqControlMigrationHelper() {
    }

    public final void migrateVersionFrom1To2IfNeed() {
        Iterable $this$forEach$iv;
        long nowTimestamp;
        int i2 = 2;
        if (getCurrentMigrationVersion() < 2) {
            long nowTimestamp2 = TimeUtils.getCurrentTimeStamp();
            long todayIndex = TabBarFreqControlCCSListenerKt.getDayIndex(nowTimestamp2);
            Iterable $this$forEach$iv2 = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().allKeys();
            if ($this$forEach$iv2 != null) {
                for (String it : $this$forEach$iv2) {
                    if (StringsKt.startsWith$default(it, TabBarFreqControlMgrKt.COMMON_LAST_SHOW_TIMESTAMP_KEY_PREFIX, false, i2, (Object) null)) {
                        Long l = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(it, 0);
                        if (DateKt.isSameDay(nowTimestamp2, l != null ? l.longValue() : 0)) {
                            String tabId = it.substring(TabBarFreqControlMgrKt.COMMON_LAST_SHOW_TIMESTAMP_KEY_PREFIX.length());
                            Intrinsics.checkNotNullExpressionValue(tabId, "this as java.lang.String).substring(startIndex)");
                            if (StringsKt.isBlank(tabId)) {
                                nowTimestamp = nowTimestamp2;
                                Long l2 = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(TabBarFreqControlMgrKt.makeTabSumDisplayCountKey(tabId), 0);
                                TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().set(TabBarFreqControlMgrKt.makeTabCommonDailyDisplayCountKey(tabId, todayIndex), Long.valueOf(l2 != null ? l2.longValue() : 0));
                            } else {
                                nowTimestamp = nowTimestamp2;
                            }
                        } else {
                            nowTimestamp = nowTimestamp2;
                        }
                        TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().remove(it);
                        nowTimestamp2 = nowTimestamp;
                        i2 = 2;
                    } else {
                        long nowTimestamp3 = nowTimestamp2;
                        if (StringsKt.startsWith$default(it, TabBarFreqControlMgrKt.SPECIFIC_LAST_SHOW_TIMESTAMP_KEY_PREFIX, false, 2, (Object) null)) {
                            Long l3 = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(it, 0);
                            long specificLastShowTimestamp = l3 != null ? l3.longValue() : 0;
                            long nowTimestamp4 = nowTimestamp3;
                            if (DateKt.isSameDay(nowTimestamp4, specificLastShowTimestamp)) {
                                String substring = it.substring(TabBarFreqControlMgrKt.SPECIFIC_LAST_SHOW_TIMESTAMP_KEY_PREFIX.length());
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                List<String> split = StringsKt.split((CharSequence) substring, new char[]{GroupMemberAdapter.MANAGER_CHAR}, false, 2);
                                String tabId2 = (String) CollectionsKt.getOrNull(split, 0);
                                boolean z = true;
                                String operationType = (String) CollectionsKt.getOrNull(split, 1);
                                CharSequence charSequence = tabId2;
                                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                                    CharSequence charSequence2 = operationType;
                                    if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                                        z = false;
                                    }
                                    if (!z) {
                                        $this$forEach$iv = $this$forEach$iv2;
                                        long j2 = specificLastShowTimestamp;
                                        List<String> list = split;
                                        Long l4 = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getLong(TabBarFreqControlMgrKt.makeSpecificDisplayCountKey(tabId2, operationType), 0);
                                        List<String> list2 = list;
                                        TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().set(TabBarFreqControlMgrKt.makeTabSpecificDailyDisplayCountKey(tabId2, operationType, todayIndex), Long.valueOf(l4 != null ? l4.longValue() : 0));
                                    }
                                }
                                $this$forEach$iv = $this$forEach$iv2;
                                List<String> list3 = split;
                                long j3 = specificLastShowTimestamp;
                            } else {
                                $this$forEach$iv = $this$forEach$iv2;
                                long j4 = specificLastShowTimestamp;
                            }
                            TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().remove(it);
                            nowTimestamp2 = nowTimestamp4;
                            $this$forEach$iv2 = $this$forEach$iv;
                            i2 = 2;
                        } else {
                            nowTimestamp2 = nowTimestamp3;
                            i2 = 2;
                        }
                    }
                }
                long j5 = nowTimestamp2;
            }
            setCurrentMigrationVersion(2);
        }
    }

    private final int getCurrentMigrationVersion() {
        Integer num = TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().getInt(KEY_MIGRATION_VERSION, 1);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final void setCurrentMigrationVersion(int version) {
        TabBarFreqControlCCSListenerKt.getTabBarFreqControlKV().set(KEY_MIGRATION_VERSION, Integer.valueOf(version));
    }
}
