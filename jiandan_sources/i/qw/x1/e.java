package i.qw.x1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class e {
    public static final int qw = Runtime.getRuntime().availableProcessors();

    @Nullable
    public static final String ad(@NotNull String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final int qw() {
        return qw;
    }
}
