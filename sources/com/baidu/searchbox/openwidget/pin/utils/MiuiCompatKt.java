package com.baidu.searchbox.openwidget.pin.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\b\u0010\u0007\u001a\u00020\u0003H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEBUG", "", "OPS_MODE_ASK", "", "OP_INSTALL_SHORTCUT", "TAG", "", "checkMiuiOpAddShortcut", "lib-openwidget-ability-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiuiCompat.kt */
public final class MiuiCompatKt {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final int OPS_MODE_ASK = 5;
    private static final int OP_INSTALL_SHORTCUT = 10017;
    private static final String TAG = "WidgetPinStrategy";

    public static final int checkMiuiOpAddShortcut() {
        Integer num;
        String obj;
        Integer intOrNull;
        if (Build.VERSION.SDK_INT < 19) {
            return 1;
        }
        Context context = AppRuntime.getAppContext();
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = context.getSystemService("appops");
            AppOpsManager appOpsManager = systemService instanceof AppOpsManager ? (AppOpsManager) systemService : null;
            if (appOpsManager == null) {
                num = Result.m8971constructorimpl(1);
                Throwable it = Result.m8974exceptionOrNullimpl(num);
                if (it != null && DEBUG) {
                    Log.w(TAG, "error when check op add shortcut, error=" + it);
                }
                if (Result.m8978isSuccessimpl(num)) {
                    int it2 = ((Number) num).intValue();
                    if (DEBUG) {
                        Log.d(TAG, "check op add shortcut, result=" + it2);
                    }
                }
                if (Result.m8977isFailureimpl(num)) {
                    num = 2;
                }
                return ((Number) num).intValue();
            }
            Method checkOp = appOpsManager.getClass().getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            checkOp.setAccessible(true);
            Object result = checkOp.invoke(appOpsManager, new Object[]{10017, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()});
            if (result == null || (obj = result.toString()) == null || (intOrNull = StringsKt.toIntOrNull(obj)) == null) {
                return 1;
            }
            return intOrNull.intValue();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
