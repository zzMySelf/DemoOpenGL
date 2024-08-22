package leakcanary;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "runnable", "Ljava/lang/Runnable;", "newThread"}, k = 3, mv = {1, 4, 1})
/* compiled from: AndroidLeakFixes.kt */
final class AndroidLeakFixes$Companion$backgroundExecutor$1 implements ThreadFactory {
    public static final AndroidLeakFixes$Companion$backgroundExecutor$1 INSTANCE = new AndroidLeakFixes$Companion$backgroundExecutor$1();

    AndroidLeakFixes$Companion$backgroundExecutor$1() {
    }

    public final Thread newThread(Runnable runnable) {
        AndroidLeakFixes$Companion$backgroundExecutor$1$thread$1 thread = new AndroidLeakFixes$Companion$backgroundExecutor$1$thread$1(runnable);
        thread.setName("plumber-android-leaks");
        return thread;
    }
}
