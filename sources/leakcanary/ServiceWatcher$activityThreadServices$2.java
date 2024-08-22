package leakcanary;

import android.app.Service;
import android.os.IBinder;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroid/os/IBinder;", "Landroid/app/Service;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: ServiceWatcher.kt */
final class ServiceWatcher$activityThreadServices$2 extends Lambda implements Function0<Map<IBinder, ? extends Service>> {
    final /* synthetic */ ServiceWatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceWatcher$activityThreadServices$2(ServiceWatcher serviceWatcher) {
        super(0);
        this.this$0 = serviceWatcher;
    }

    public final Map<IBinder, Service> invoke() {
        Field mServicesField = this.this$0.getActivityThreadClass().getDeclaredField("mServices");
        mServicesField.setAccessible(true);
        Intrinsics.checkExpressionValueIsNotNull(mServicesField, "activityThreadClass.getD…y { isAccessible = true }");
        Object obj = mServicesField.get(this.this$0.getActivityThreadInstance());
        if (obj != null) {
            return (Map) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<android.os.IBinder, android.app.Service>");
    }
}
