package com.baidu.searchbox.nadbrowser.phase2.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.ioc.AdJavaScriptInterfaceKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/nadbrowser/phase2/utils/DebugLogger;", "", "()V", "printDebug", "", "tag", "", "abstract", "printError", "showToast", "context", "Landroid/content/Context;", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DebugLogger.kt */
public final class DebugLogger {
    public static final DebugLogger INSTANCE = new DebugLogger();

    private DebugLogger() {
    }

    @JvmStatic
    public static final void printDebug(String tag, String str) {
        if (AdJavaScriptInterfaceKt.getDEBUG()) {
            Log.d("NadBrowser@debug@" + tag, "printLog: >>>>>>>> " + str);
        }
    }

    @JvmStatic
    public static final void printError(String tag, String str) {
        if (AdJavaScriptInterfaceKt.getDEBUG()) {
            Log.e("NadBrowser@error@" + tag, "printLog: >>>>>>>> " + str);
        }
    }

    public final void showToast(Context context, String str) {
        if (context != null) {
            Context it = context;
            if (AdJavaScriptInterfaceKt.getDEBUG()) {
                Toast.makeText(it, str, 1).show();
            }
        }
    }
}
