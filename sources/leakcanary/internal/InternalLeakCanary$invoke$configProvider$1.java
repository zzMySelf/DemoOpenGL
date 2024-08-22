package leakcanary.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import leakcanary.LeakCanary;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lleakcanary/LeakCanary$Config;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: InternalLeakCanary.kt */
final class InternalLeakCanary$invoke$configProvider$1 extends Lambda implements Function0<LeakCanary.Config> {
    public static final InternalLeakCanary$invoke$configProvider$1 INSTANCE = new InternalLeakCanary$invoke$configProvider$1();

    InternalLeakCanary$invoke$configProvider$1() {
        super(0);
    }

    public final LeakCanary.Config invoke() {
        return LeakCanary.getConfig();
    }
}
