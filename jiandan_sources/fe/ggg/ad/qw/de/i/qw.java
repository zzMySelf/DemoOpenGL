package fe.ggg.ad.qw.de.i;

import android.content.Context;
import android.os.storage.StorageVolume;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable
    public static final String ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        StorageVolume de2 = de(context);
        if (de2 == null) {
            return null;
        }
        return qw(de2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079 A[Catch:{ Exception -> 0x009b }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.os.storage.StorageVolume de(@org.jetbrains.annotations.NotNull android.content.Context r7) {
        /*
            java.lang.String r0 = "mContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "storage"
            java.lang.Object r7 = r7.getSystemService(r0)
            boolean r0 = r7 instanceof android.os.storage.StorageManager
            r1 = 0
            if (r0 == 0) goto L_0x0013
            android.os.storage.StorageManager r7 = (android.os.storage.StorageManager) r7
            goto L_0x0014
        L_0x0013:
            r7 = r1
        L_0x0014:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x003d
            if (r7 != 0) goto L_0x001e
            goto L_0x009b
        L_0x001e:
            java.util.List r7 = r7.getStorageVolumes()
            if (r7 != 0) goto L_0x0026
            goto L_0x009b
        L_0x0026:
            java.util.Iterator r7 = r7.iterator()
        L_0x002a:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x009b
            java.lang.Object r0 = r7.next()
            android.os.storage.StorageVolume r0 = (android.os.storage.StorageVolume) r0
            boolean r2 = r0.isRemovable()
            if (r2 == 0) goto L_0x002a
            return r0
        L_0x003d:
            java.lang.String r0 = "android.os.storage.StorageVolume"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x009b }
            r2 = 0
            if (r7 != 0) goto L_0x0048
        L_0x0046:
            r3 = r1
            goto L_0x0057
        L_0x0048:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x009b }
            if (r3 != 0) goto L_0x004f
            goto L_0x0046
        L_0x004f:
            java.lang.String r4 = "getVolumeList"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x009b }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x009b }
        L_0x0057:
            java.lang.String r4 = "isRemovable"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x009b }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r5)     // Catch:{ Exception -> 0x009b }
            java.lang.String r4 = "storageVolumeClazz.getMethod(\"isRemovable\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ Exception -> 0x009b }
            if (r3 != 0) goto L_0x0068
            r7 = r1
            goto L_0x006e
        L_0x0068:
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009b }
            java.lang.Object r7 = r3.invoke(r7, r4)     // Catch:{ Exception -> 0x009b }
        L_0x006e:
            boolean r3 = r7 instanceof android.os.storage.StorageVolume[]     // Catch:{ Exception -> 0x009b }
            if (r3 == 0) goto L_0x0075
            android.os.storage.StorageVolume[] r7 = (android.os.storage.StorageVolume[]) r7     // Catch:{ Exception -> 0x009b }
            goto L_0x0076
        L_0x0075:
            r7 = r1
        L_0x0076:
            if (r7 != 0) goto L_0x0079
            goto L_0x009b
        L_0x0079:
            int r3 = r7.length     // Catch:{ Exception -> 0x009b }
            r4 = 0
        L_0x007b:
            if (r4 >= r3) goto L_0x009b
            r5 = r7[r4]     // Catch:{ Exception -> 0x009b }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009b }
            java.lang.Object r6 = r0.invoke(r5, r6)     // Catch:{ Exception -> 0x009b }
            if (r6 == 0) goto L_0x0093
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x009b }
            boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x009b }
            if (r6 == 0) goto L_0x0090
            return r5
        L_0x0090:
            int r4 = r4 + 1
            goto L_0x007b
        L_0x0093:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r7.<init>(r0)     // Catch:{ Exception -> 0x009b }
            throw r7     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ggg.ad.qw.de.i.qw.de(android.content.Context):android.os.storage.StorageVolume");
    }

    @Nullable
    public static final String qw(@NotNull StorageVolume storageVolume) {
        Intrinsics.checkNotNullParameter(storageVolume, "<this>");
        try {
            Method method = storageVolume.getClass().getMethod("getPath", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "javaClass.getMethod(\"getPath\")");
            Object invoke = method.invoke(storageVolume, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
