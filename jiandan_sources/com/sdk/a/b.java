package com.sdk.a;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.sdk.f.f;
import java.net.HttpURLConnection;

@SuppressLint({"NewApi"})
public class b {
    public static final String a = "com.sdk.a.b";
    public static Boolean b = Boolean.valueOf(f.a);
    public static Network c;
    public static boolean d;
    public static ConnectivityManager.NetworkCallback e;
    public HttpURLConnection f;
    public ConnectivityManager g;

    public b() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:6|7|8|9|10|11|12|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(android.content.Context r3, java.net.URL r4) {
        /*
            r2 = this;
            r2.<init>()
            android.content.Context r0 = r3.getApplicationContext()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r2.g = r0
            android.net.Network r0 = c     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x0039
            boolean r1 = d     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x0039
            java.net.URLConnection r3 = r0.openConnection(r4)     // Catch:{ IOException -> 0x0026 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0026 }
            r2.f = r3     // Catch:{ IOException -> 0x0026 }
            goto L_0x0038
        L_0x0026:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0047 }
            r3.<init>()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "CellularConnection: "
            r3.append(r4)     // Catch:{ Exception -> 0x0047 }
            java.net.HttpURLConnection r4 = r2.f     // Catch:{ Exception -> 0x0047 }
            r3.append(r4)     // Catch:{ Exception -> 0x0047 }
            r3.toString()     // Catch:{ Exception -> 0x0047 }
        L_0x0038:
            return
        L_0x0039:
            r0 = 0
            d = r0     // Catch:{ Exception -> 0x0047 }
            com.sdk.a.a r0 = new com.sdk.a.a     // Catch:{ Exception -> 0x0047 }
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x0047 }
            e = r0     // Catch:{ Exception -> 0x0047 }
            r2.a(r0, r3, r4)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0053
        L_0x0047:
            r3 = move-exception
            java.lang.String r4 = a
            java.lang.String r3 = r3.toString()
            java.lang.Boolean r0 = b
            com.sdk.o.a.a(r4, r3, r0)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.a.b.<init>(android.content.Context, java.net.URL):void");
    }

    public HttpURLConnection a() {
        HttpURLConnection httpURLConnection;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                return null;
            }
            httpURLConnection = this.f;
        } while (httpURLConnection == null);
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.net.ConnectivityManager.NetworkCallback r4, android.content.Context r5, java.net.URL r6) {
        /*
            r3 = this;
            java.lang.String r6 = "phone"
            r0 = 0
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ Exception -> 0x0024 }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x0024 }
            java.lang.Class r6 = r5.getClass()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = "getDataEnabled"
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0024 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0024 }
            if (r6 == 0) goto L_0x0028
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0024 }
            java.lang.Object r5 = r6.invoke(r5, r1)     // Catch:{ Exception -> 0x0024 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x0024 }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0024 }
            goto L_0x0029
        L_0x0024:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0028:
            r5 = 0
        L_0x0029:
            if (r5 == 0) goto L_0x0047
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L_0x0047
            android.net.NetworkRequest$Builder r5 = new android.net.NetworkRequest$Builder
            r5.<init>()
            r6 = 12
            r5.addCapability(r6)
            r5.addTransportType(r0)
            android.net.NetworkRequest r5 = r5.build()
            android.net.ConnectivityManager r6 = r3.g
            r6.requestNetwork(r5, r4)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.a.b.a(android.net.ConnectivityManager$NetworkCallback, android.content.Context, java.net.URL):void");
    }
}
