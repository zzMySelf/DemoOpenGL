package curtains.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: WindowManagerSpy.kt */
final class WindowManagerSpy$mViewsField$2 extends Lambda implements Function0<Field> {
    public static final WindowManagerSpy$mViewsField$2 INSTANCE = new WindowManagerSpy$mViewsField$2();

    WindowManagerSpy$mViewsField$2() {
        super(0);
    }

    public final Field invoke() {
        Class windowManagerClass = WindowManagerSpy.INSTANCE.getWindowManagerClass();
        if (windowManagerClass == null) {
            return null;
        }
        Field $this$apply = windowManagerClass.getDeclaredField("mViews");
        $this$apply.setAccessible(true);
        return $this$apply;
    }
}
