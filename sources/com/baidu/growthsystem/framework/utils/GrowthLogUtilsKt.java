package com.baidu.growthsystem.framework.utils;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\bø\u0001\u0000\u001a\u001a\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\bø\u0001\u0000\u001a\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\u001a\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\bø\u0001\u0000\u001a\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"TAG", "", "isDebug", "", "()Z", "checkDebugMode", "", "action", "Lkotlin/Function0;", "debugWithGrowthSystem", "debugMsg", "currentFileName", "msg", "errorWithGrowthSystem", "errorMsg", "lib-growth-system-framework_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GrowthLogUtils.kt */
public final class GrowthLogUtilsKt {
    public static final String TAG = "GrowthSystem";
    private static final boolean isDebug = AppConfig.isDebug();

    public static final boolean isDebug() {
        return isDebug;
    }

    public static final void debugWithGrowthSystem(String currentFileName, String msg) {
        Intrinsics.checkNotNullParameter(currentFileName, "currentFileName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDebug) {
            Log.d(TAG, currentFileName + AbstractJsonLexerKt.COLON + msg);
        }
    }

    public static final void debugWithGrowthSystem(Function0<String> debugMsg) {
        Intrinsics.checkNotNullParameter(debugMsg, "debugMsg");
        if (AppConfig.isDebug()) {
            Log.d(TAG, debugMsg.invoke());
        }
    }

    public static final void errorWithGrowthSystem(String currentFileName, String msg) {
        Intrinsics.checkNotNullParameter(currentFileName, "currentFileName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDebug) {
            Log.e(TAG, currentFileName + AbstractJsonLexerKt.COLON + msg);
        }
    }

    public static final void errorWithGrowthSystem(Function0<String> errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (isDebug()) {
            Log.e(TAG, errorMsg.invoke());
        }
    }

    public static final void checkDebugMode(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (isDebug()) {
            action.invoke();
        }
    }
}
