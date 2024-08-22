package com.baidu.searchbox.aisearch.utils;

import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEBUG", "", "KEY_USAGE_TIMESTAMPS", "", "MAX_RECORDS", "", "SP_FILE_NAME", "TAG", "lib-aisearch-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UsageTracker.kt */
public final class UsageTrackerKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_USAGE_TIMESTAMPS = "sp_usage_timestamps";
    private static final int MAX_RECORDS = 10;
    private static final String SP_FILE_NAME = "com.baidu.searchbox.aisearch.usage_tracker_pref";
    private static final String TAG = "ConversationPreload";
}
