package leakcanary;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: ServiceWatcher.kt */
final class ServiceWatcher$activityThreadClass$2 extends Lambda implements Function0<Class<?>> {
    public static final ServiceWatcher$activityThreadClass$2 INSTANCE = new ServiceWatcher$activityThreadClass$2();

    ServiceWatcher$activityThreadClass$2() {
        super(0);
    }

    public final Class<?> invoke() {
        return Class.forName("android.app.ActivityThread");
    }
}
