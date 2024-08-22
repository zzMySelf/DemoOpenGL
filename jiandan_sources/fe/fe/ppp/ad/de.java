package fe.fe.ppp.ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.pass.a;

public class de implements a {

    /* renamed from: ad  reason: collision with root package name */
    public static de f2987ad;

    /* renamed from: th  reason: collision with root package name */
    public static SharedPreferences f2988th;

    public de(Context context, String str) {
        f2988th = context.getSharedPreferences(str, 0);
        context.getApplicationContext();
    }

    public static synchronized void ad(Context context) {
        synchronized (de.class) {
            if (f2987ad == null) {
                f2987ad = new de(context, "sapi_system");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[Catch:{ Exception -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080 A[Catch:{ Exception -> 0x008b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean de(java.lang.String r8, java.lang.Object r9) {
        /*
            android.content.SharedPreferences r0 = f2988th
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2 = 0
            r3 = 1
            int r4 = r1.hashCode()     // Catch:{ Exception -> 0x008b }
            r5 = -672261858(0xffffffffd7ee191e, float:-5.2358329E14)
            r6 = 3
            r7 = 2
            if (r4 == r5) goto L_0x0049
            r5 = 2374300(0x243a9c, float:3.327103E-39)
            if (r4 == r5) goto L_0x003f
            r5 = 67973692(0x40d323c, float:1.6597537E-36)
            if (r4 == r5) goto L_0x0035
            r5 = 1729365000(0x67140408, float:6.989846E23)
            if (r4 == r5) goto L_0x002b
            goto L_0x0053
        L_0x002b:
            java.lang.String r4 = "Boolean"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r1 == 0) goto L_0x0053
            r1 = 0
            goto L_0x0054
        L_0x0035:
            java.lang.String r4 = "Float"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r1 == 0) goto L_0x0053
            r1 = 2
            goto L_0x0054
        L_0x003f:
            java.lang.String r4 = "Long"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r1 == 0) goto L_0x0053
            r1 = 1
            goto L_0x0054
        L_0x0049:
            java.lang.String r4 = "Integer"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r1 == 0) goto L_0x0053
            r1 = 3
            goto L_0x0054
        L_0x0053:
            r1 = -1
        L_0x0054:
            if (r1 == 0) goto L_0x0080
            if (r1 == r3) goto L_0x0076
            if (r1 == r7) goto L_0x006c
            if (r1 == r6) goto L_0x0062
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x008b }
            r0.putString(r8, r9)     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x0062:
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x008b }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x008b }
            r0.putInt(r8, r9)     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x006c:
            java.lang.Float r9 = (java.lang.Float) r9     // Catch:{ Exception -> 0x008b }
            float r9 = r9.floatValue()     // Catch:{ Exception -> 0x008b }
            r0.putFloat(r8, r9)     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x0076:
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ Exception -> 0x008b }
            long r4 = r9.longValue()     // Catch:{ Exception -> 0x008b }
            r0.putLong(r8, r4)     // Catch:{ Exception -> 0x008b }
            goto L_0x0089
        L_0x0080:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ Exception -> 0x008b }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x008b }
            r0.putBoolean(r8, r9)     // Catch:{ Exception -> 0x008b }
        L_0x0089:
            r2 = 1
            goto L_0x008f
        L_0x008b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008f:
            r0.apply()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ppp.ad.de.de(java.lang.String, java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091 A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T qw(java.lang.String r6, T r7) {
        /*
            java.lang.Class r0 = r7.getClass()
            java.lang.String r0 = r0.getSimpleName()
            int r1 = r0.hashCode()     // Catch:{ Exception -> 0x00a2 }
            r2 = -672261858(0xffffffffd7ee191e, float:-5.2358329E14)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L_0x0042
            r2 = 2374300(0x243a9c, float:3.327103E-39)
            if (r1 == r2) goto L_0x0038
            r2 = 67973692(0x40d323c, float:1.6597537E-36)
            if (r1 == r2) goto L_0x002e
            r2 = 1729365000(0x67140408, float:6.989846E23)
            if (r1 == r2) goto L_0x0024
            goto L_0x004c
        L_0x0024:
            java.lang.String r1 = "Boolean"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x004c
            r0 = 0
            goto L_0x004d
        L_0x002e:
            java.lang.String r1 = "Float"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x004c
            r0 = 2
            goto L_0x004d
        L_0x0038:
            java.lang.String r1 = "Long"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x0042:
            java.lang.String r1 = "Integer"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x004c
            r0 = 3
            goto L_0x004d
        L_0x004c:
            r0 = -1
        L_0x004d:
            if (r0 == 0) goto L_0x0091
            if (r0 == r5) goto L_0x0080
            if (r0 == r4) goto L_0x006f
            if (r0 == r3) goto L_0x005e
            android.content.SharedPreferences r0 = f2988th     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r6 = r0.getString(r6, r7)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a8
        L_0x005e:
            android.content.SharedPreferences r0 = f2988th     // Catch:{ Exception -> 0x00a2 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x00a2 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x00a2 }
            int r6 = r0.getInt(r6, r7)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a8
        L_0x006f:
            android.content.SharedPreferences r0 = f2988th     // Catch:{ Exception -> 0x00a2 }
            java.lang.Float r7 = (java.lang.Float) r7     // Catch:{ Exception -> 0x00a2 }
            float r7 = r7.floatValue()     // Catch:{ Exception -> 0x00a2 }
            float r6 = r0.getFloat(r6, r7)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a8
        L_0x0080:
            android.content.SharedPreferences r0 = f2988th     // Catch:{ Exception -> 0x00a2 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ Exception -> 0x00a2 }
            long r1 = r7.longValue()     // Catch:{ Exception -> 0x00a2 }
            long r6 = r0.getLong(r6, r1)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a8
        L_0x0091:
            android.content.SharedPreferences r0 = f2988th     // Catch:{ Exception -> 0x00a2 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x00a2 }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x00a2 }
            boolean r6 = r0.getBoolean(r6, r7)     // Catch:{ Exception -> 0x00a2 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a8
        L_0x00a2:
            r6 = move-exception
            r7 = 0
            r6.printStackTrace()
            r6 = r7
        L_0x00a8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ppp.ad.de.qw(java.lang.String, java.lang.Object):java.lang.Object");
    }
}
