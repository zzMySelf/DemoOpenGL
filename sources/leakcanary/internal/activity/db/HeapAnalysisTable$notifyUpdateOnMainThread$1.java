package leakcanary.internal.activity.db;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
/* compiled from: HeapAnalysisTable.kt */
final class HeapAnalysisTable$notifyUpdateOnMainThread$1 implements Runnable {
    public static final HeapAnalysisTable$notifyUpdateOnMainThread$1 INSTANCE = new HeapAnalysisTable$notifyUpdateOnMainThread$1();

    HeapAnalysisTable$notifyUpdateOnMainThread$1() {
    }

    public final void run() {
        for (Function0 it : HeapAnalysisTable.updateListeners) {
            it.invoke();
        }
    }
}
