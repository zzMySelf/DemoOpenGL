package fe.mmm.qw.yj;

import com.baidu.android.common.others.lang.StringUtil;
import com.tencent.mmkv.MMKV;
import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public IParameter f8720ad;

    /* renamed from: de  reason: collision with root package name */
    public MMKV f8721de;
    public IAccountChecker qw;

    public fe(IAccountChecker iAccountChecker, IParameter iParameter) {
        this.qw = iAccountChecker;
        this.f8720ad = iParameter;
    }

    public int ad(String str, int i2) {
        try {
            return Integer.parseInt(fe(str, String.valueOf(i2)));
        } catch (Exception e) {
            e.printStackTrace();
            return i2;
        }
    }

    public long de(String str, long j) {
        try {
            return Long.parseLong(fe(str, String.valueOf(j)));
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public String fe(String str, String str2) {
        return yj() ? this.f8721de.getString(str, str2) : str2;
    }

    public void i(String str) {
        if (yj() && str != null) {
            this.f8721de.remove(str).apply();
        }
    }

    public void qw() {
        if (yj()) {
            this.f8721de.clearMemoryCache();
            this.f8721de = null;
        }
    }

    public boolean rg(String str, boolean z) {
        try {
            return Boolean.parseBoolean(fe(str, String.valueOf(z)));
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public boolean th(String str) {
        if (!yj() || str == null) {
            return false;
        }
        return this.f8721de.containsKey(str);
    }

    public String toString() {
        IParameter iParameter = this.f8720ad;
        return iParameter == null ? StringUtil.NULL_STRING : iParameter.rg();
    }

    public <T> void uk(String str, T t) {
        if (yj() && t != null) {
            this.f8721de.putString(str, String.valueOf(t)).apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ee, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean yj() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.tencent.mmkv.MMKV r0 = r8.f8721de     // Catch:{ all -> 0x00f7 }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r8)
            return r1
        L_0x0008:
            com.tera.scan.config.IParameter r0 = r8.f8720ad     // Catch:{ all -> 0x00f7 }
            if (r0 == 0) goto L_0x00ef
            com.tera.scan.config.IAccountChecker r0 = r8.qw     // Catch:{ all -> 0x00f7 }
            r2 = 0
            if (r0 == 0) goto L_0x001b
            com.tera.scan.config.IAccountChecker r0 = r8.qw     // Catch:{ all -> 0x00f7 }
            boolean r0 = r0.ad()     // Catch:{ all -> 0x00f7 }
            if (r0 != 0) goto L_0x001b
            monitor-exit(r8)
            return r2
        L_0x001b:
            com.tera.scan.config.IParameter r0 = r8.f8720ad     // Catch:{ Exception -> 0x0040 }
            java.lang.String r0 = r0.de()     // Catch:{ Exception -> 0x0040 }
            com.tencent.mmkv.MMKV.initialize((java.lang.String) r0)     // Catch:{ Exception -> 0x0040 }
            com.tera.scan.config.IParameter r0 = r8.f8720ad     // Catch:{ Exception -> 0x0040 }
            java.lang.String r0 = r0.rg()     // Catch:{ Exception -> 0x0040 }
            r3 = 2
            com.tera.scan.config.IParameter r4 = r8.f8720ad     // Catch:{ Exception -> 0x0040 }
            boolean r4 = r4.fe()     // Catch:{ Exception -> 0x0040 }
            if (r4 == 0) goto L_0x0038
            java.lang.String r4 = fe.mmm.qw.j.vvv.fe.ad()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0039
        L_0x0038:
            r4 = 0
        L_0x0039:
            com.tencent.mmkv.MMKV r0 = com.tencent.mmkv.MMKV.mmkvWithID(r0, r3, r4)     // Catch:{ Exception -> 0x0040 }
            r8.f8721de = r0     // Catch:{ Exception -> 0x0040 }
            goto L_0x0057
        L_0x0040:
            r0 = move-exception
            java.lang.String r3 = "MMKVConfig"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r4.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "mmkv init error : "
            r4.append(r5)     // Catch:{ all -> 0x00f7 }
            r4.append(r0)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00f7 }
            fe.mmm.qw.i.qw.rg(r3, r0)     // Catch:{ all -> 0x00f7 }
        L_0x0057:
            com.tencent.mmkv.MMKV r0 = r8.f8721de     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "is_netdisk_config_transfer"
            boolean r0 = r0.getBoolean(r3, r2)     // Catch:{ all -> 0x00f7 }
            if (r0 != 0) goto L_0x00ed
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00f7 }
            fe.mmm.qw.yj.ad r0 = new fe.mmm.qw.yj.ad     // Catch:{ all -> 0x00f7 }
            com.tera.scan.config.IAccountChecker r4 = r8.qw     // Catch:{ all -> 0x00f7 }
            com.tera.scan.config.IParameter r5 = r8.f8720ad     // Catch:{ all -> 0x00f7 }
            r0.<init>(r4, r5)     // Catch:{ all -> 0x00f7 }
            boolean r4 = r0.ad()     // Catch:{ all -> 0x00f7 }
            if (r4 == 0) goto L_0x00c2
            java.lang.String r4 = "MMKVConfig"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r5.<init>()     // Catch:{ all -> 0x00f7 }
            com.tera.scan.config.IParameter r6 = r0.f8716ad     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = r6.qw()     // Catch:{ all -> 0x00f7 }
            r5.append(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = " load old : "
            r5.append(r6)     // Catch:{ all -> 0x00f7 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00f7 }
            long r6 = r6 - r2
            r5.append(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f7 }
            fe.mmm.qw.i.qw.ad(r4, r5)     // Catch:{ all -> 0x00f7 }
            java.util.Properties r4 = r0.f8717de     // Catch:{ all -> 0x00f7 }
            java.util.Enumeration r4 = r4.propertyNames()     // Catch:{ all -> 0x00f7 }
        L_0x009e:
            boolean r5 = r4.hasMoreElements()     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00c2
            java.lang.Object r5 = r4.nextElement()     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00f7 }
            java.util.Properties r6 = r0.f8717de     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = r6.getProperty(r5)     // Catch:{ all -> 0x00f7 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00f7 }
            if (r7 != 0) goto L_0x009e
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00f7 }
            if (r7 != 0) goto L_0x009e
            com.tencent.mmkv.MMKV r7 = r8.f8721de     // Catch:{ all -> 0x00f7 }
            r7.putString(r5, r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x009e
        L_0x00c2:
            com.tencent.mmkv.MMKV r0 = r8.f8721de     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = "is_netdisk_config_transfer"
            r0.putBoolean(r4, r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = "MMKVConfig"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r4.<init>()     // Catch:{ all -> 0x00f7 }
            com.tera.scan.config.IParameter r5 = r8.f8720ad     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = r5.rg()     // Catch:{ all -> 0x00f7 }
            r4.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = " transfer spent : "
            r4.append(r5)     // Catch:{ all -> 0x00f7 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00f7 }
            long r5 = r5 - r2
            r4.append(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00f7 }
            fe.mmm.qw.i.qw.ad(r0, r2)     // Catch:{ all -> 0x00f7 }
        L_0x00ed:
            monitor-exit(r8)
            return r1
        L_0x00ef:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = "mParameter 用来描述配置文件信息，不可为空"
            r0.<init>(r1)     // Catch:{ all -> 0x00f7 }
            throw r0     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.yj.fe.yj():boolean");
    }
}
