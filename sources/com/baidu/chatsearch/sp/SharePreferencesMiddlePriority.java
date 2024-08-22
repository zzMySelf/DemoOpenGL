package com.baidu.chatsearch.sp;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/chatsearch/sp/SharePreferencesMiddlePriority;", "Lcom/baidu/chatsearch/sp/SharedPreferencesBase;", "()V", "SHARED_PREFERENCE_FILE_NAME", "", "getSharePreferencesFileName", "lib-chatsearch-utils_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SharePreferencesMiddlePriority.kt */
public final class SharePreferencesMiddlePriority extends SharedPreferencesBase {
    public static final SharePreferencesMiddlePriority INSTANCE = new SharePreferencesMiddlePriority();
    private static final String SHARED_PREFERENCE_FILE_NAME = "search_craft_sp_middle_priority_confs";

    private SharePreferencesMiddlePriority() {
    }

    /* access modifiers changed from: protected */
    public String getSharePreferencesFileName() {
        return SHARED_PREFERENCE_FILE_NAME;
    }
}
