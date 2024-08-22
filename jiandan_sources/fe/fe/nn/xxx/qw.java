package fe.fe.nn.xxx;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.sso.p.b;
import com.baidu.sso.r.a;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public Context f2418ad;

    /* renamed from: de  reason: collision with root package name */
    public String f2419de = null;

    /* renamed from: fe  reason: collision with root package name */
    public String f2420fe = null;
    public a qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public b f2421rg;

    /* renamed from: th  reason: collision with root package name */
    public ServiceConnection f2422th = new de(this);

    public qw(Context context) {
        this.f2418ad = context;
    }

    public void ad() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        this.f2418ad.bindService(intent, this.f2422th, 1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|(4:12|(3:16|17|(8:19|20|21|22|23|(1:25)|38|26))|27|28)|13|(0)|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String qw(java.lang.String r9) {
        /*
            r8 = this;
            com.baidu.sso.r.a r0 = r8.qw
            if (r0 != 0) goto L_0x0006
            goto L_0x0081
        L_0x0006:
            r0 = 0
            java.lang.String r1 = r8.f2419de     // Catch:{ all -> 0x007a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x0017
            android.content.Context r1 = r8.f2418ad     // Catch:{ all -> 0x007a }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x007a }
            r8.f2419de = r1     // Catch:{ all -> 0x007a }
        L_0x0017:
            java.lang.String r1 = r8.f2420fe     // Catch:{ all -> 0x007a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x006d
            android.content.Context r1 = r8.f2418ad     // Catch:{ NameNotFoundException -> 0x0032 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0032 }
            java.lang.String r2 = r8.f2419de     // Catch:{ NameNotFoundException -> 0x0032 }
            r3 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0032 }
            if (r1 == 0) goto L_0x0032
            android.content.pm.Signature[] r1 = r1.signatures     // Catch:{ NameNotFoundException -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r1 = r0
        L_0x0033:
            if (r1 == 0) goto L_0x006b
            int r2 = r1.length     // Catch:{ all -> 0x007a }
            if (r2 <= 0) goto L_0x006b
            java.lang.String r2 = "SHA1"
            r3 = 0
            r1 = r1[r3]     // Catch:{ all -> 0x007a }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x007a }
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            byte[] r1 = r2.digest(r1)     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            r2.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            int r4 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x006b }
        L_0x004f:
            if (r3 >= r4) goto L_0x0067
            byte r5 = r1[r3]     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r5 | 256(0x100, float:3.59E-43)
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            r6 = 3
            r7 = 1
            java.lang.String r5 = r5.substring(r7, r6)     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            r2.append(r5)     // Catch:{ NoSuchAlgorithmException -> 0x006b }
            int r3 = r3 + 1
            goto L_0x004f
        L_0x0067:
            java.lang.String r0 = r2.toString()     // Catch:{ NoSuchAlgorithmException -> 0x006b }
        L_0x006b:
            r8.f2420fe = r0     // Catch:{ all -> 0x007a }
        L_0x006d:
            com.baidu.sso.r.a r1 = r8.qw     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r8.f2419de     // Catch:{ all -> 0x007a }
            java.lang.String r3 = r8.f2420fe     // Catch:{ all -> 0x007a }
            com.baidu.sso.r.a$a$a r1 = (com.baidu.sso.r.a.C0059a.C0060a) r1
            java.lang.String r9 = r1.a(r2, r3, r9)     // Catch:{ all -> 0x007a }
            goto L_0x007b
        L_0x007a:
            r9 = r0
        L_0x007b:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x0083
        L_0x0081:
            java.lang.String r9 = ""
        L_0x0083:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.xxx.qw.qw(java.lang.String):java.lang.String");
    }
}
