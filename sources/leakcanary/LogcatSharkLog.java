package leakcanary;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.SharkLog;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lleakcanary/LogcatSharkLog;", "Lshark/SharkLog$Logger;", "()V", "d", "", "message", "", "throwable", "", "Companion", "leakcanary-android-utils_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: LogcatSharkLog.kt */
public final class LogcatSharkLog implements SharkLog.Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void d(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (message.length() < 4000) {
            Log.d("LeakCanary", message);
            return;
        }
        for (String line : StringsKt.lines(message)) {
            Log.d("LeakCanary", line);
        }
    }

    public void d(Throwable throwable, String message) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Intrinsics.checkParameterIsNotNull(message, "message");
        d(message + 10 + Log.getStackTraceString(throwable));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lleakcanary/LogcatSharkLog$Companion;", "", "()V", "install", "", "leakcanary-android-utils_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: LogcatSharkLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void install() {
            SharkLog.INSTANCE.setLogger(new LogcatSharkLog());
        }
    }
}
