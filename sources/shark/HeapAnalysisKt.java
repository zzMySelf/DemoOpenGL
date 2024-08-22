package shark;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, d2 = {"androidManufacturer", "", "androidSdkInt", "", "leakCanaryVersion", "shark"}, k = 2, mv = {1, 4, 1})
/* compiled from: HeapAnalysis.kt */
public final class HeapAnalysisKt {
    /* access modifiers changed from: private */
    public static final int androidSdkInt() {
        try {
            Object obj = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").get((Object) null);
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e2) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public static final String androidManufacturer() {
        try {
            Object obj = Class.forName("android.os.Build").getDeclaredField("MANUFACTURER").get((Object) null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e2) {
            return "Unknown";
        }
    }

    /* access modifiers changed from: private */
    public static final String leakCanaryVersion() {
        try {
            Field versionField = Class.forName("leakcanary.internal.InternalLeakCanary").getDeclaredField("version");
            Intrinsics.checkExpressionValueIsNotNull(versionField, "versionField");
            versionField.setAccessible(true);
            Object obj = versionField.get((Object) null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e2) {
            return "Unknown";
        }
    }
}
