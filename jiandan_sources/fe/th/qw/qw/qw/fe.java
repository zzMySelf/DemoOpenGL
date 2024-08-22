package fe.th.qw.qw.qw;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.duxiaoman.dxmpay.statistics.StatApi;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public int f5581ad;

    /* renamed from: de  reason: collision with root package name */
    public byte[] f5582de;

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f5583fe;
    public JSONArray qw;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f5584ad;
        public int qw;
    }

    public static class de {
        public static fe qw = new fe();
    }

    public static fe qw() {
        return de.qw;
    }

    public void ad(int i2, String str) {
        if ("normal_log".equals(str)) {
            this.f5581ad = i2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void de(fe.th.qw.qw.qw.th r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            byte[] r0 = r4.f5582de
            monitor-enter(r0)
            org.json.JSONArray r1 = r4.qw     // Catch:{ all -> 0x0024 }
            int r1 = r1.length()     // Catch:{ all -> 0x0024 }
            org.json.JSONArray r2 = r4.qw     // Catch:{ JSONException -> 0x0015 }
            org.json.JSONObject r3 = r5.ad()     // Catch:{ JSONException -> 0x0015 }
            r2.put(r1, r3)     // Catch:{ JSONException -> 0x0015 }
        L_0x0015:
            com.duxiaoman.dxmpay.statistics.StrategyProcess r1 = com.duxiaoman.dxmpay.statistics.StrategyProcess.getInstance()     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = r5.qw     // Catch:{ all -> 0x0024 }
            boolean r5 = r1.isForceToSend(r5)     // Catch:{ all -> 0x0024 }
            r4.rg(r5)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.fe.de(fe.th.qw.qw.qw.th):void");
    }

    public void fe(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f5582de) {
                i();
            }
            rg(false);
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i2 = this.f5581ad;
        if (i2 > 0) {
            if (Build.VERSION.SDK_INT >= 19) {
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 > 0) {
                        this.qw.remove(0);
                        i2 = i3;
                    } else {
                        this.f5581ad = 0;
                        return;
                    }
                }
            } else {
                try {
                    Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                    declaredField.setAccessible(true);
                    List list = (List) declaredField.get(this.qw);
                    int i4 = this.f5581ad;
                    while (true) {
                        int i5 = i4 - 1;
                        if (i4 > 0) {
                            if (list.size() > 0) {
                                list.remove(0);
                            }
                            i4 = i5;
                        } else {
                            this.f5581ad = 0;
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = r0.getBytes().length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        if ((r1 instanceof java.lang.OutOfMemoryError) != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        java.lang.System.gc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r1 != 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (204800 <= r1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0038, code lost:
        fe.th.qw.qw.qw.qw.yj(false, com.duxiaoman.dxmpay.statistics.StatApi.getAppContext(), "f509cd1137cc45e510496d1c174306a6.json", r0, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r1 >= 204800) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0043, code lost:
        if (r7 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        com.duxiaoman.dxmpay.statistics.internal.LogSender.getInstance().triggerSending("normal_log");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rg(boolean r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            byte[] r1 = r6.f5582de
            monitor-enter(r1)
            org.json.JSONArray r2 = r6.qw     // Catch:{ all -> 0x004f }
            int r2 = r2.length()     // Catch:{ all -> 0x004f }
            r3 = 0
            if (r2 != 0) goto L_0x0019
            android.content.Context r7 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "f509cd1137cc45e510496d1c174306a6.json"
            fe.th.qw.qw.qw.qw.yj(r3, r7, r2, r0, r3)     // Catch:{ all -> 0x004f }
            monitor-exit(r1)     // Catch:{ all -> 0x004f }
            return
        L_0x0019:
            org.json.JSONArray r0 = r6.qw     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004f }
            monitor-exit(r1)     // Catch:{ all -> 0x004f }
            byte[] r1 = r0.getBytes()     // Catch:{ all -> 0x0026 }
            int r1 = r1.length     // Catch:{ all -> 0x0026 }
            goto L_0x0030
        L_0x0026:
            r1 = move-exception
            boolean r1 = r1 instanceof java.lang.OutOfMemoryError
            if (r1 == 0) goto L_0x002f
            java.lang.System.gc()
            return
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 != 0) goto L_0x0033
            return
        L_0x0033:
            r2 = 204800(0x32000, float:2.86986E-40)
            if (r2 <= r1) goto L_0x0041
            android.content.Context r4 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()
            java.lang.String r5 = "f509cd1137cc45e510496d1c174306a6.json"
            fe.th.qw.qw.qw.qw.yj(r3, r4, r5, r0, r3)
        L_0x0041:
            if (r1 >= r2) goto L_0x0045
            if (r7 == 0) goto L_0x004e
        L_0x0045:
            com.duxiaoman.dxmpay.statistics.internal.LogSender r7 = com.duxiaoman.dxmpay.statistics.internal.LogSender.getInstance()
            java.lang.String r0 = "normal_log"
            r7.triggerSending(r0)
        L_0x004e:
            return
        L_0x004f:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.fe.rg(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r1 = r4.f5582de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.put("array", r4.qw);
        r5.qw = r4.qw.length();
        r5.f5584ad = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r2 != null) goto L_0x0021;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.th.qw.qw.qw.fe.ad th(java.lang.String r5) {
        /*
            r4 = this;
            fe.th.qw.qw.qw.fe$ad r5 = new fe.th.qw.qw.qw.fe$ad
            r5.<init>()
            byte[] r0 = r4.f5583fe
            monitor-enter(r0)
            com.duxiaoman.dxmpay.statistics.StatApi r1 = com.duxiaoman.dxmpay.statistics.StatApi.getInstance()     // Catch:{ JSONException -> 0x0042 }
            com.duxiaoman.dxmpay.statistics.internal.IStatConfig r1 = r1.getSettings()     // Catch:{ JSONException -> 0x0042 }
            if (r1 == 0) goto L_0x001c
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0042 }
            java.lang.String r1 = r1.getHeader()     // Catch:{ JSONException -> 0x0042 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0042 }
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0021
            return r5
        L_0x0021:
            byte[] r1 = r4.f5582de
            monitor-enter(r1)
            java.lang.String r0 = "array"
            org.json.JSONArray r3 = r4.qw     // Catch:{ JSONException -> 0x003c }
            r2.put(r0, r3)     // Catch:{ JSONException -> 0x003c }
            org.json.JSONArray r0 = r4.qw     // Catch:{ JSONException -> 0x003c }
            int r0 = r0.length()     // Catch:{ JSONException -> 0x003c }
            r5.qw = r0     // Catch:{ JSONException -> 0x003c }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x003c }
            r5.f5584ad = r0     // Catch:{ JSONException -> 0x003c }
            goto L_0x003c
        L_0x003a:
            r5 = move-exception
            goto L_0x003e
        L_0x003c:
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            return r5
        L_0x003e:
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r5
        L_0x0040:
            r5 = move-exception
            goto L_0x0044
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return r5
        L_0x0044:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.fe.th(java.lang.String):fe.th.qw.qw.qw.fe$ad");
    }

    public void uk() {
        if (qw.i(StatApi.getAppContext(), false, "f509cd1137cc45e510496d1c174306a6.json")) {
            String de2 = qw.de(false, StatApi.getAppContext(), "f509cd1137cc45e510496d1c174306a6.json");
            if (!TextUtils.isEmpty(de2) && de2.getBytes().length <= 409600) {
                try {
                    synchronized (this.f5582de) {
                        this.qw = new JSONArray(de2);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public boolean yj() {
        boolean z;
        synchronized (this.f5582de) {
            z = this.qw.length() == 0;
        }
        return z;
    }

    public fe() {
        this.qw = new JSONArray();
        this.f5581ad = 0;
        this.f5582de = new byte[0];
        this.f5583fe = new byte[0];
    }
}
