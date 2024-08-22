package com.baidu.searchbox.download.center.ui.autobackup.transcode;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/transcode/TranscodeLogUtil;", "", "()V", "TAG", "", "logException", "", "exception", "Ljava/lang/Exception;", "logInDebug", "message", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TranscodeLogUtil.kt */
public final class TranscodeLogUtil {
    public static final TranscodeLogUtil INSTANCE = new TranscodeLogUtil();
    private static final String TAG = "TranscodeLogRecord";

    private TranscodeLogUtil() {
    }

    public final void logInDebug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (AppConfig.isDebug()) {
            Log.d(TAG, message);
        }
    }

    public final void logException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (AppConfig.isDebug()) {
            try {
                new RuntimeException(TAG, exception).printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
