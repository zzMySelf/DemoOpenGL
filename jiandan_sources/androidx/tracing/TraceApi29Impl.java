package androidx.tracing;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
public final class TraceApi29Impl {
    public static void beginAsyncSection(@NonNull String str, int i2) {
        Trace.beginAsyncSection(str, i2);
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        Trace.endAsyncSection(str, i2);
    }

    public static void setCounter(@NonNull String str, int i2) {
        Trace.setCounter(str, (long) i2);
    }
}
