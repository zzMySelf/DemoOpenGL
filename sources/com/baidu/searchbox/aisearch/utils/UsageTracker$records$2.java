package com.baidu.searchbox.aisearch.utils;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UsageTracker.kt */
final class UsageTracker$records$2 extends Lambda implements Function0<CopyOnWriteArrayList<Long>> {
    public static final UsageTracker$records$2 INSTANCE = new UsageTracker$records$2();

    UsageTracker$records$2() {
        super(0);
    }

    public final CopyOnWriteArrayList<Long> invoke() {
        return new CopyOnWriteArrayList<>(UsageTracker.INSTANCE.loadRecords());
    }
}
