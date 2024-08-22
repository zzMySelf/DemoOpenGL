package com.baidu.searchbox.aisearch.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/aisearch/utils/SharedPrefsUtils;", "", "()V", "getUidSharedPrefs", "Landroid/content/SharedPreferences;", "name", "", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SharedPrefsUtils.kt */
public final class SharedPrefsUtils {
    public static final SharedPrefsUtils INSTANCE = new SharedPrefsUtils();

    private SharedPrefsUtils() {
    }

    public final SharedPreferences getUidSharedPrefs(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Context context = AppRuntime.getAppContext();
        BoxAccount account = LoginUtilsKt.getAccount();
        String uid = account != null ? account.getUid() : null;
        if (uid == null) {
            uid = "";
        }
        return context.getSharedPreferences(context.getPackageName() + Util.md5(uid) + name, 0);
    }
}
