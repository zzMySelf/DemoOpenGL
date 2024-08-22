package com.baidu.growthsystem.wealth.common.util;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.growthsystem.wealth.common.cheat.anticheat.base.IWealthVideoAntiCheatServiceKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/growthsystem/wealth/common/util/WealthVideoPreferenceUtil;", "Lcom/baidu/android/util/sp/SharedPrefsWrapper;", "()V", "getStringSafely", "", "key", "defValue", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoPreferenceUtil.kt */
public final class WealthVideoPreferenceUtil extends SharedPrefsWrapper {
    public static final WealthVideoPreferenceUtil INSTANCE = new WealthVideoPreferenceUtil();

    private WealthVideoPreferenceUtil() {
        super(IWealthVideoAntiCheatServiceKt.MODULE_WEALTH_VIDEO);
    }

    public final String getStringSafely(String key, String defValue) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        String string = getString(key, defValue);
        return string == null ? defValue : string;
    }
}
