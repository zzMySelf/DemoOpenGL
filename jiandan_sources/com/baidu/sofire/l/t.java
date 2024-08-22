package com.baidu.sofire.l;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.sofire.a.a;

public class t {
    public static final String[] a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "xbOAOB93VGI-kwCx1KZxzESB35X3hv9xe1VSXGErZbY=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};
    public static byte[] b = g.a(16);

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        try {
            context.getApplicationContext().getContentResolver();
            return a(context, str, bundle, Uri.parse("content://" + context.getPackageName() + IStringUtil.CURRENT_PATH + str2 + ".ac.provider"));
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|(3:20|21|(1:23)(1:24))|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        if (r3 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0030, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle a(android.content.Context r3, java.lang.String r4, android.os.Bundle r5, android.net.Uri r6) {
        /*
            r0 = 0
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0048 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            r2 = 17
            if (r1 < r2) goto L_0x0043
            r2 = 24
            android.content.ContentProviderClient r3 = r3.acquireUnstableContentProviderClient(r6)     // Catch:{ all -> 0x0023 }
            android.os.Bundle r4 = r3.call(r4, r0, r5)     // Catch:{ all -> 0x0024 }
            if (r1 >= r2) goto L_0x001f
            r3.release()     // Catch:{ all -> 0x0048 }
            goto L_0x0022
        L_0x001f:
            r3.close()     // Catch:{ all -> 0x0048 }
        L_0x0022:
            return r4
        L_0x0023:
            r3 = r0
        L_0x0024:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0033
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            if (r4 >= r2) goto L_0x0030
            r3.release()     // Catch:{ all -> 0x0048 }
            goto L_0x0033
        L_0x0030:
            r3.close()     // Catch:{ all -> 0x0048 }
        L_0x0033:
            return r0
        L_0x0034:
            r4 = move-exception
            if (r3 == 0) goto L_0x0042
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            if (r5 >= r2) goto L_0x003f
            r3.release()     // Catch:{ all -> 0x0048 }
            goto L_0x0042
        L_0x003f:
            r3.close()     // Catch:{ all -> 0x0048 }
        L_0x0042:
            throw r4     // Catch:{ all -> 0x0048 }
        L_0x0043:
            android.os.Bundle r3 = r3.call(r6, r4, r0, r5)     // Catch:{ all -> 0x0048 }
            return r3
        L_0x0048:
            int r3 = com.baidu.sofire.a.a.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.t.a(android.content.Context, java.lang.String, android.os.Bundle, android.net.Uri):android.os.Bundle");
    }
}
