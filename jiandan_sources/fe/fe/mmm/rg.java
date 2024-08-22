package fe.fe.mmm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.apollon.statistics.Config;
import com.baidu.ubc.IUBCStatisticCallback;
import com.baidu.ubc.IUBCUploadCallback;
import com.baidu.ubc.IUBCUploader;
import com.baidu.ubc.UBCUploadTimingManager;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import com.baidu.ubc.constants.EnumConstants$Trigger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rg {
    public static final boolean a = tt.vvv();
    public boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public long f2092ad;
    public int ddd;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2093de = false;
    public long eee = 0;

    /* renamed from: fe  reason: collision with root package name */
    public Context f2094fe;
    public IUBCUploader ggg;

    /* renamed from: i  reason: collision with root package name */
    public List<vvv> f2095i;

    /* renamed from: if  reason: not valid java name */
    public long f56if;
    public UBCUploadTimingManager mmm;
    public int nn;

    /* renamed from: o  reason: collision with root package name */
    public long f2096o;

    /* renamed from: pf  reason: collision with root package name */
    public long f2097pf;
    public HashMap<String, Long> ppp;
    public int qqq;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public qqq f2098rg;
    public String rrr;

    /* renamed from: switch  reason: not valid java name */
    public int f57switch;

    /* renamed from: th  reason: collision with root package name */
    public fe f2099th;
    public Runnable tt = new qw();

    /* renamed from: uk  reason: collision with root package name */
    public long f2100uk = 0;
    public i vvv;
    public SparseArray<ArrayList> when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f2101yj = 0;

    public class ad implements IUBCUploadCallback {
        public final /* synthetic */ l qw;

        public ad(l lVar) {
            this.qw = lVar;
        }

        public void qw(boolean z, vvv vvv) {
            if (!z) {
                rg.this.f2098rg.b(vvv);
            } else {
                rg.this.f2098rg.o(this.qw);
                aaa.o().ad(vvv.ppp(), false, vvv.vvv());
                fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.DB_SUCCESS_EVENT, vvv.mmm());
            }
            this.qw.th();
        }
    }

    public static class de {

        /* renamed from: ad  reason: collision with root package name */
        public vvv f2103ad = null;

        /* renamed from: de  reason: collision with root package name */
        public File f2104de = null;

        /* renamed from: fe  reason: collision with root package name */
        public JSONObject f2105fe = null;

        /* renamed from: i  reason: collision with root package name */
        public IUBCUploadCallback f2106i = null;

        /* renamed from: if  reason: not valid java name */
        public int f58if = 0;

        /* renamed from: o  reason: collision with root package name */
        public long f2107o = 0;

        /* renamed from: pf  reason: collision with root package name */
        public long f2108pf = 0;
        public boolean qw = true;

        /* renamed from: rg  reason: collision with root package name */
        public String f2109rg = null;

        /* renamed from: th  reason: collision with root package name */
        public long f2110th = -1;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f2111uk = false;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f2112yj = false;
    }

    public class fe implements UBCUploadTimingManager.UploadTimingCallback {
        public fe(rg rgVar) {
        }

        public void ad() {
            m.m128switch("clockTime:" + SystemClock.elapsedRealtime(), EnumConstants$RunTime.TIMING_NETWORK_AVAILABLE);
            th.nn().n(EnumConstants$Trigger.NETWORK_AVAILABLE);
            th.nn().h();
            th.nn().a();
        }

        public void de() {
            m.fe(EnumConstants$RunTime.TIMING_LOG_TOO_MANY);
            th.nn().n(EnumConstants$Trigger.LOG_TOO_MANY);
            th.nn().h();
        }

        public void fe() {
            m.m128switch("clockTime:" + SystemClock.elapsedRealtime(), EnumConstants$RunTime.TIMING_BACK_TO_FRONT);
            th.nn().h();
            th.nn().g();
        }

        public void qw() {
            m.m128switch("clockTime:" + SystemClock.elapsedRealtime(), EnumConstants$RunTime.TIMING_FRONT_TO_BACK);
            th.nn().n(EnumConstants$Trigger.FOREGROUND_TO_BACKGROUND);
            th.nn().h();
            th.nn().a();
            th.nn().g();
        }

        public /* synthetic */ fe(rg rgVar, qw qwVar) {
            this(rgVar);
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            if (rg.this.f2101yj == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - rg.this.f2100uk;
                if (uptimeMillis >= CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
                    if (rg.a) {
                        String.format("***saveCache after %d ms***", new Object[]{Long.valueOf(uptimeMillis)});
                    }
                    rg.this.eee();
                    int unused = rg.this.f2101yj = 0;
                    return;
                }
                th.nn().f(this, CoroutineLiveDataKt.DEFAULT_TIMEOUT - uptimeMillis);
            } else if (rg.this.f2101yj == 2) {
                int unused2 = rg.this.f2101yj = 0;
            }
        }
    }

    public rg(Context context) {
        this.f2094fe = context;
        k qw2 = k.qw();
        this.f2098rg = new qqq(context);
        this.f2099th = new fe(context);
        this.ggg = tt.when();
        fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_DATABASE_UPLOADER_SUCCESS);
        m.m128switch("init db&uploader success", EnumConstants$RunTime.INIT_MESSAGE);
        this.f2095i = new ArrayList(20);
        this.f2096o = qw2.de("ubc_last_upload_non_real", 0);
        this.f2097pf = qw2.de("ubc_reset_real_time_count_time", 0);
        this.f56if = qw2.de("ubc_last_upload_failed_data_time", 0);
        this.f57switch = qw2.ad("ubc_real_time_count", 0);
        i vvv2 = i.vvv();
        this.vvv = vvv2;
        vvv2.e(this, context);
        this.f2092ad = System.currentTimeMillis();
        this.qw = new Random().nextInt(31) + 60;
        this.aaa = i.vvv().k();
        this.qqq = i.vvv().tt();
        fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_RULE_MANAGER_SUCCESS);
        m.m128switch("init rule manager success", EnumConstants$RunTime.INIT_MESSAGE);
        aaa.o().pf(this.f2098rg);
        UBCUploadTimingManager o2 = UBCUploadTimingManager.o();
        this.mmm = o2;
        o2.pf(this.f2094fe, this.f2098rg, new fe(this, (qw) null));
        fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_TIMING_MANAGER_SUCCESS);
        m.m128switch("init timing manager success", EnumConstants$RunTime.INIT_MESSAGE);
        this.rrr = j.de(this.f2094fe);
        this.f2098rg.yj(true);
    }

    public void a(vvv vvv2) {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            this.f2099th.i(vvv2);
        }
    }

    public void aaa() {
        File[] listFiles;
        if (j.fe(this.f2094fe)) {
            File file = new File(this.rrr);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                int i2 = 0;
                while (i2 < listFiles.length) {
                    xxx rrr2 = this.f2098rg.rrr(listFiles[i2].getName());
                    if (rrr2 == null || !TextUtils.equals("1", rrr2.ad())) {
                        i2++;
                    } else {
                        if (a) {
                            "processOneFailedData send " + listFiles[i2].getAbsolutePath();
                        }
                        rrr.ad("processOneFailedData file, send");
                        rrr2.th(rrr2.de() + 1);
                        if (this.f2098rg.j(listFiles[i2].getName(), "0", rrr2.de())) {
                            n(rrr2);
                            m.uk(rrr2.qw(), "uploadCount:" + rrr2.de(), EnumConstants$RunTime.FILE_REUPLOAD);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[SYNTHETIC, Splitter:B:30:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[SYNTHETIC, Splitter:B:36:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r3.rrr
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0010
            r0.mkdir()
        L_0x0010:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r3.rrr
            r0.<init>(r1, r5)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0091
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x004d }
            android.util.Base64OutputStream r1 = new android.util.Base64OutputStream     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r0 = 0
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x004d }
            r1.write(r4)     // Catch:{ Exception -> 0x004d }
            r1.flush()     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "save to file suc"
            fe.fe.mmm.rrr.ad(r4)     // Catch:{ Exception -> 0x004d }
            r1.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x0091
        L_0x003c:
            r4 = move-exception
            boolean r5 = a
            if (r5 == 0) goto L_0x0091
        L_0x0041:
            r4.printStackTrace()
            goto L_0x0091
        L_0x0045:
            r4 = move-exception
            r1 = r2
            goto L_0x0082
        L_0x0048:
            r4 = move-exception
            r1 = r2
            goto L_0x004e
        L_0x004b:
            r4 = move-exception
            goto L_0x0082
        L_0x004d:
            r4 = move-exception
        L_0x004e:
            boolean r0 = a     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0055
            r4.printStackTrace()     // Catch:{ all -> 0x004b }
        L_0x0055:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x004b }
            r0.append(r2)     // Catch:{ all -> 0x004b }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x004b }
            r0.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x004b }
            com.baidu.ubc.constants.EnumConstants$RunTime r0 = com.baidu.ubc.constants.EnumConstants$RunTime.FILE_SAVE_IO_ERROR     // Catch:{ all -> 0x004b }
            fe.fe.mmm.m.uk(r5, r4, r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x0091
        L_0x007c:
            r4 = move-exception
            boolean r5 = a
            if (r5 == 0) goto L_0x0091
            goto L_0x0041
        L_0x0082:
            if (r1 == 0) goto L_0x0090
            r1.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r5 = move-exception
            boolean r0 = a
            if (r0 == 0) goto L_0x0090
            r5.printStackTrace()
        L_0x0090:
            throw r4
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.rg.b(java.lang.String, java.lang.String):void");
    }

    public void c() {
        if (j.fe(this.f2094fe)) {
            if (this.when == null) {
                ddd();
            }
            l i2 = l.i(this.f2094fe);
            if (aaa.o().rg(i2) && i2 != null && !i2.h()) {
                i2.y(true);
                h(i2);
            }
        }
    }

    public void d() {
        l o2 = l.o();
        if (this.f2099th.rg(o2)) {
            JSONObject tt2 = o2.tt();
            if (a) {
                "sendQualityData:" + tt2.toString();
            }
            fe.fe.mmm.n.qw.th(BypassConstants$Funnel.PACKAGE_TO_FILE, o2.eee());
            th.nn().q(tt2);
        }
    }

    public final void ddd() {
        if (this.when == null) {
            boolean z = a;
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.when = sparseArray;
            this.f2098rg.tt(sparseArray);
            if (a) {
                "mIdArray: " + this.when.toString();
            }
            this.ppp = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.when.size(); i3++) {
                int keyAt = this.when.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                this.ppp.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.vvv.y(i2);
        }
    }

    public final void e(boolean z) {
        l o2 = l.o();
        o2.y(z);
        if (this.f2099th.th(o2, z)) {
            JSONObject tt2 = o2.tt();
            if (a) {
                "checkFileData:" + tt2.toString();
            }
            this.f2099th.de(z);
            fe.fe.mmm.n.qw.th(BypassConstants$Funnel.PACKAGE_TO_FILE, o2.eee());
            th.nn().q(tt2);
        }
    }

    public final void eee() {
        List<vvv> list = this.f2095i;
        if (list != null && list.size() != 0) {
            this.f2098rg.c(this.f2095i);
            this.f2095i.clear();
            if (this.f2101yj == 1) {
                this.f2101yj = 2;
            }
        }
    }

    public void f() {
        this.f2098rg.e();
    }

    public void g(ddd ddd2) {
        this.f2098rg.d(ddd2);
    }

    public final ArrayList ggg(SparseArray<ArrayList> sparseArray, int i2) {
        ArrayList valueAt;
        if (sparseArray == null || sparseArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            if (!(sparseArray.keyAt(i3) == i2 || (valueAt = sparseArray.valueAt(i3)) == null || valueAt.size() == 0)) {
                arrayList.addAll(valueAt);
            }
        }
        return arrayList;
    }

    public final void h(l lVar) {
        String str;
        lVar.m125if();
        if (!lVar.h()) {
            if (lVar.g()) {
                str = lVar.vvv();
            } else {
                try {
                    JSONObject tt2 = lVar.tt();
                    String th2 = j.th(tt2.toString().getBytes(), true);
                    b(tt2.toString(), th2);
                    if (a) {
                        rrr.qw(lVar);
                        "save send data to file " + th2;
                    }
                    str = th2;
                } catch (OutOfMemoryError unused) {
                    lVar.th();
                    return;
                }
            }
            m.pf(lVar.mmm(), str, "trigger: " + lVar.rrr().getValue(), EnumConstants$RunTime.FILE_SAVE_END);
            fe.fe.mmm.n.qw.th(BypassConstants$Funnel.PACKAGE_TO_FILE, lVar.eee());
            if (!this.f2098rg.i(lVar, str)) {
                lVar.th();
                File file = new File(this.rrr, str);
                if (file.exists() && file.delete()) {
                    boolean z = a;
                }
                this.f2098rg.m135switch(str);
                return;
            }
            c.de().tt(lVar.l(), (long) lVar.b());
            th.nn().p(lVar, str);
            lVar.th();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f56if) >= 7200000) {
                this.f56if = currentTimeMillis;
                k.qw().th("ubc_last_upload_failed_data_time", this.f56if);
                th.nn().a();
                th.nn().h();
            }
        }
    }

    public boolean i() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.eee) <= 300000) {
            return false;
        }
        this.eee = currentTimeMillis;
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public void m136if(nn nnVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONArray jSONArray2 = jSONArray;
        JSONObject ad2 = nnVar.ad();
        if (ad2 != null) {
            Iterator<String> keys = ad2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    Cswitch vvv2 = this.f2098rg.vvv(next);
                    String optString = ad2.optString(next, "0");
                    if (vvv2 != null) {
                        str = vvv2.m138if();
                    } else {
                        str = "0";
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (!z || str == null || !z2) {
                        jSONObject.put("product", String.format("del/%s", new Object[]{next}));
                        jSONObject.put("version", optString);
                        jSONObject.put("valid", "1");
                        if (!this.f2098rg.m134if(next)) {
                            jSONObject.put("valid", "0");
                            this.ddd++;
                        } else {
                            this.xxx++;
                        }
                        jSONArray2.put(jSONObject);
                    } else {
                        jSONObject.put("product", String.format("del/%s", new Object[]{next}));
                        jSONObject.put("valid", "2");
                        jSONObject.put("version", optString);
                        jSONArray2.put(jSONObject);
                        this.nn++;
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void j(nn nnVar, boolean z, IUBCStatisticCallback iUBCStatisticCallback) {
        JSONArray jSONArray = new JSONArray();
        this.xxx = 0;
        this.ddd = 0;
        this.nn = 0;
        m136if(nnVar, z, jSONArray);
        nn(nnVar, z, jSONArray);
        if (iUBCStatisticCallback != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", (this.xxx + this.ddd + this.nn) + "," + this.xxx + "," + this.nn);
                iUBCStatisticCallback.qw(jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
        this.vvv.A(nnVar.de());
        this.vvv.s(nnVar.o() * 86400000);
        this.vvv.t(nnVar.i());
        this.vvv.u(nnVar.fe());
        this.vvv.x(nnVar.yj());
        this.vvv.w(nnVar.th());
        this.vvv.v(nnVar.rg());
        this.vvv.z(nnVar.pf());
        this.vvv.r(nnVar.qw());
        SparseArray<ArrayList> sparseArray = this.when;
        if (sparseArray == null) {
            this.when = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        HashMap<String, Long> hashMap = this.ppp;
        if (hashMap == null) {
            this.ppp = new HashMap<>();
        } else {
            hashMap.clear();
        }
        this.f2098rg.tt(this.when);
        if (a) {
            "mIdArray: " + this.when.toString();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.when.size(); i3++) {
            int keyAt = this.when.keyAt(i3);
            if (keyAt != 0 && i2 == 0) {
                i2 = keyAt;
            }
            this.ppp.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.vvv.y(i2);
        nnVar.de().clear();
    }

    public void k(String str, int i2, String str2) {
        this.f2098rg.g(str, i2, str2);
    }

    public void l(EnumConstants$Trigger enumConstants$Trigger) {
        if (j.fe(this.f2094fe)) {
            l i2 = l.i(this.f2094fe);
            int xxx2 = this.vvv.xxx();
            i2.y(false);
            if (this.aaa) {
                i2.z(this.qqq);
                this.f2098rg.ad(i2);
            } else {
                i2.z(xxx2);
                this.f2098rg.qw(i2);
            }
            int b = i2.b();
            if (b > 0) {
                if (a) {
                    "uploadBackLog size=" + b;
                }
                i2.A(enumConstants$Trigger);
                h(i2);
            }
        }
    }

    public final void m(de deVar) {
        boolean z;
        if (deVar != null) {
            boolean z2 = true;
            if (deVar.f58if <= 1) {
                z2 = false;
            }
            fe.fe.mmm.n.qw.yj(BypassConstants$Funnel.UPLOAD_START, z2, deVar.f2107o, deVar.f2108pf);
            if (deVar.qw) {
                z = this.ggg.ad(deVar.f2104de, deVar.f2110th, deVar.f2112yj, deVar.f2111uk);
            } else {
                z = this.ggg.qw(deVar.f2105fe, deVar.f2112yj, deVar.f2111uk);
            }
            fe.fe.mmm.n.qw.yj(z ? BypassConstants$Funnel.UPLOAD_SUCCESS : BypassConstants$Funnel.UPLOAD_ERROR, z2, deVar.f2107o, deVar.f2108pf);
            if (a) {
                "upload success: " + z;
            }
            IUBCUploadCallback iUBCUploadCallback = deVar.f2106i;
            if (iUBCUploadCallback != null) {
                iUBCUploadCallback.qw(z, deVar.f2103ad);
            }
            if (!TextUtils.isEmpty(deVar.f2109rg)) {
                th.nn().u(deVar.f2109rg, z);
            }
        }
    }

    public void mmm() {
        File[] listFiles;
        if (j.fe(this.f2094fe) && System.currentTimeMillis() >= i.vvv().eee()) {
            File file = new File(this.rrr);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    int length = listFiles.length;
                    int i2 = 0;
                    for (File delete : listFiles) {
                        if (delete.delete()) {
                            i2++;
                        }
                    }
                    int pf2 = this.f2098rg.pf(listFiles.length);
                    if (!a) {
                        c.de().m117if(String.valueOf(1000), listFiles.length, i2, pf2);
                    }
                    m.m128switch("fileCount:" + length + ";deleteFileCount:" + i2 + ";deleteFileDbCount:" + pf2, EnumConstants$RunTime.CLEAR_FILE_LIMIT);
                }
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (a) {
                        "uploadFailedData fileName:" + listFiles[i3].getAbsolutePath();
                    }
                    xxx rrr2 = this.f2098rg.rrr(listFiles[i3].getName());
                    if (rrr2 != null && TextUtils.equals("0", rrr2.ad())) {
                        boolean z = a;
                        rrr.ad("processFailedData file, no need to send");
                    } else if (rrr2 == null || !TextUtils.equals("1", rrr2.ad())) {
                        boolean z2 = a;
                        rrr.ad("processFailedData file, data in db, delete file");
                        listFiles[i3].delete();
                        if (rrr2 != null) {
                            m.yj(rrr2.qw(), EnumConstants$RunTime.FILE_REUPLOAD_NO_DATA_DELETE);
                        }
                    } else {
                        rrr.ad("processFailedData file, send");
                        rrr2.th(rrr2.de() + 1);
                        if (this.f2098rg.j(listFiles[i3].getName(), "0", rrr2.de())) {
                            n(rrr2);
                            m.uk(rrr2.qw(), "uploadCount:" + rrr2.de(), EnumConstants$RunTime.FILE_REUPLOAD);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c0, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d4 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea A[SYNTHETIC, Splitter:B:51:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f9 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010f A[SYNTHETIC, Splitter:B:62:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011c A[SYNTHETIC, Splitter:B:68:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00d0=Splitter:B:46:0x00d0, B:57:0x00f5=Splitter:B:57:0x00f5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(fe.fe.mmm.xxx r11) {
        /*
            r10 = this;
            java.lang.String r0 = "metadata"
            if (r11 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r3 = r11.qw()
            java.io.File r4 = new java.io.File
            java.lang.String r1 = r10.rrr
            r4.<init>(r1, r3)
            boolean r1 = r4.exists()
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            r9 = 0
            boolean r1 = r11.rg()
            if (r1 == 0) goto L_0x0037
            long r0 = r4.length()
            int r5 = (int) r0
            int r6 = r11.de()
            long r7 = r11.fe()
            fe.fe.mmm.l r11 = fe.fe.mmm.l.uk(r4, r5, r6, r7, r9)
            fe.fe.mmm.th r0 = fe.fe.mmm.th.nn()
            r0.p(r11, r3)
            return
        L_0x0037:
            r1 = 0
            boolean r2 = a     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            if (r2 == 0) goto L_0x004c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            r2.<init>()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            java.lang.String r5 = "uploadFile fileName:"
            r2.append(r5)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            r2.append(r3)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            r2.toString()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
        L_0x004c:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            r2.<init>(r4)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00cf }
            int r1 = r2.available()     // Catch:{ Exception -> 0x00ca, OutOfMemoryError -> 0x00c7, all -> 0x00c4 }
            if (r1 <= 0) goto L_0x00b6
            android.util.Base64InputStream r7 = new android.util.Base64InputStream     // Catch:{ Exception -> 0x00ca, OutOfMemoryError -> 0x00c7, all -> 0x00c4 }
            r1 = 0
            r7.<init>(r2, r1)     // Catch:{ Exception -> 0x00ca, OutOfMemoryError -> 0x00c7, all -> 0x00c4 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r1 = fe.fe.mmm.u.th.ad(r7)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            org.json.JSONObject r1 = r2.getJSONObject(r0)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r4 = "uploadtime"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r4 = "upload_index"
            int r5 = r11.de()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            boolean r0 = a     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            if (r0 == 0) goto L_0x009b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r0.<init>()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            java.lang.String r4 = "uploadFile#meta: "
            r0.append(r4)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r0.append(r1)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r0.toString()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
        L_0x009b:
            fe.fe.mmm.th r1 = fe.fe.mmm.th.nn()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            long r4 = r11.fe()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            int r6 = r11.de()     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r1.r(r2, r3, r4, r6)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00b0, all -> 0x00ac }
            r2 = r7
            goto L_0x00b6
        L_0x00ac:
            r11 = move-exception
            r1 = r7
            goto L_0x011a
        L_0x00b0:
            r11 = move-exception
            r1 = r7
            goto L_0x00d0
        L_0x00b3:
            r11 = move-exception
            r1 = r7
            goto L_0x00f5
        L_0x00b6:
            r2.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x0119
        L_0x00bb:
            r11 = move-exception
            boolean r0 = a
            if (r0 == 0) goto L_0x0119
        L_0x00c0:
            r11.printStackTrace()
            goto L_0x0119
        L_0x00c4:
            r11 = move-exception
            r1 = r2
            goto L_0x011a
        L_0x00c7:
            r11 = move-exception
            r1 = r2
            goto L_0x00d0
        L_0x00ca:
            r11 = move-exception
            r1 = r2
            goto L_0x00f5
        L_0x00cd:
            r11 = move-exception
            goto L_0x011a
        L_0x00cf:
            r11 = move-exception
        L_0x00d0:
            boolean r0 = a     // Catch:{ all -> 0x00cd }
            if (r0 == 0) goto L_0x00e8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r0.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = "OutOfMemoryError:"
            r0.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00cd }
            r0.append(r11)     // Catch:{ all -> 0x00cd }
            r0.toString()     // Catch:{ all -> 0x00cd }
        L_0x00e8:
            if (r1 == 0) goto L_0x0119
            r1.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x0119
        L_0x00ee:
            r11 = move-exception
            boolean r0 = a
            if (r0 == 0) goto L_0x0119
            goto L_0x00c0
        L_0x00f4:
            r11 = move-exception
        L_0x00f5:
            boolean r0 = a     // Catch:{ all -> 0x00cd }
            if (r0 == 0) goto L_0x010d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r0.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = "error:"
            r0.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00cd }
            r0.append(r11)     // Catch:{ all -> 0x00cd }
            r0.toString()     // Catch:{ all -> 0x00cd }
        L_0x010d:
            if (r1 == 0) goto L_0x0119
            r1.close()     // Catch:{ IOException -> 0x0113 }
            goto L_0x0119
        L_0x0113:
            r11 = move-exception
            boolean r0 = a
            if (r0 == 0) goto L_0x0119
            goto L_0x00c0
        L_0x0119:
            return
        L_0x011a:
            if (r1 == 0) goto L_0x0128
            r1.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0128
        L_0x0120:
            r0 = move-exception
            boolean r1 = a
            if (r1 == 0) goto L_0x0128
            r0.printStackTrace()
        L_0x0128:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.rg.n(fe.fe.mmm.xxx):void");
    }

    public void nn(nn nnVar, boolean z, JSONArray jSONArray) {
        ArrayList arrayList;
        HashMap<String, String> hashMap;
        JSONArray jSONArray2 = jSONArray;
        List<Cswitch> de2 = nnVar.de();
        if (de2 != null && de2.size() != 0) {
            ArrayList arrayList2 = new ArrayList(de2);
            String str = "1";
            if (this.f2098rg.xxx() > 0) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((Cswitch) it.next()).fe());
                }
                HashMap<String, String> ggg2 = this.f2098rg.ggg(arrayList3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Cswitch switchR = (Cswitch) it2.next();
                    String fe2 = switchR.fe();
                    String str2 = ggg2.get(fe2);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            String optString = jSONObject.optString("version");
                            String str3 = switchR.m138if();
                            JSONObject jSONObject2 = new JSONObject();
                            hashMap = ggg2;
                            try {
                                arrayList = arrayList2;
                                try {
                                    boolean z2 = Integer.parseInt(optString) >= Integer.parseInt(str3);
                                    if (!z || optString == null || str3 == null || !z2) {
                                        if (!TextUtils.equals(jSONObject.optString("dfc"), str) && switchR.when()) {
                                            it2.remove();
                                        }
                                        ggg2 = hashMap;
                                        arrayList2 = arrayList;
                                    } else {
                                        it2.remove();
                                        jSONObject2.put("product", "set/" + fe2);
                                        jSONObject2.put("valid", "2");
                                        jSONObject2.put("version", str3);
                                        jSONArray2.put(jSONObject2);
                                        this.nn++;
                                        ggg2 = hashMap;
                                        arrayList2 = arrayList;
                                    }
                                } catch (NumberFormatException unused) {
                                    boolean z3 = a;
                                    ggg2 = hashMap;
                                    arrayList2 = arrayList;
                                } catch (JSONException unused2) {
                                    boolean z4 = a;
                                    ggg2 = hashMap;
                                    arrayList2 = arrayList;
                                }
                            } catch (NumberFormatException unused3) {
                                arrayList = arrayList2;
                                boolean z32 = a;
                                ggg2 = hashMap;
                                arrayList2 = arrayList;
                            } catch (JSONException unused4) {
                                arrayList = arrayList2;
                                boolean z42 = a;
                                ggg2 = hashMap;
                                arrayList2 = arrayList;
                            }
                        } catch (NumberFormatException unused5) {
                            hashMap = ggg2;
                            arrayList = arrayList2;
                            boolean z322 = a;
                            ggg2 = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused6) {
                            hashMap = ggg2;
                            arrayList = arrayList2;
                            boolean z422 = a;
                            ggg2 = hashMap;
                            arrayList2 = arrayList;
                        }
                    }
                }
            }
            ArrayList arrayList4 = arrayList2;
            boolean f = this.f2098rg.f(arrayList4);
            int size = arrayList4.size();
            if (f) {
                this.xxx += size;
            } else {
                this.ddd += size;
                str = "0";
            }
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                Cswitch switchR2 = (Cswitch) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                String fe3 = switchR2.fe();
                String str4 = switchR2.m138if();
                try {
                    jSONObject3.put("product", "set/" + fe3);
                    jSONObject3.put("version", str4);
                    jSONObject3.put("valid", str);
                } catch (JSONException unused7) {
                    boolean z5 = a;
                }
                jSONArray2.put(jSONObject3);
            }
            nnVar.m131switch(arrayList4);
        }
    }

    public final void o() {
        e(true);
        e(false);
    }

    public void p(String str) {
        if (a) {
            "upload file fail:" + str;
        }
        rrr.ad("upload file fail");
        m.yj(str, EnumConstants$RunTime.FILE_UPDATE_BY_UPLOAD_FAIL);
        this.f2098rg.h(str);
    }

    public final boolean pf() {
        if (a) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f2097pf) > 86400000) {
            this.f57switch = 0;
            this.f2097pf = currentTimeMillis;
            k.qw().th("ubc_reset_real_time_count_time", this.f2097pf);
            k.qw().rg("ubc_real_time_count", this.f57switch);
        }
        if (this.f57switch < 20000) {
            return true;
        }
        boolean z = a;
        int i2 = this.f57switch;
        if (i2 == 20000) {
            this.f57switch = i2 + 1;
            if (!a) {
                c.de().xxx(String.valueOf(20000));
            }
        }
        return false;
    }

    public qqq ppp() {
        return this.f2098rg;
    }

    public void q(String str) {
        File file = new File(this.rrr, str);
        if (a) {
            "deleteUploadFile file:" + file.getAbsolutePath();
        }
        rrr.ad("delete file");
        if (file.exists() && file.delete()) {
            boolean z = a;
            rrr.ad("delete file suc");
            m.yj(str, EnumConstants$RunTime.FILE_DELETE_BY_UPLOAD_SUCCESS);
        }
        this.f2098rg.m135switch(str);
    }

    public final void qqq() {
        this.f57switch++;
        k.qw().rg("ubc_real_time_count", this.f57switch);
    }

    public final void r(String str) {
        if (j.fe(this.f2094fe) && pf()) {
            l i2 = l.i(this.f2094fe);
            i2.y(true);
            i2.m();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            this.f2098rg.ddd(arrayList, true, i2);
            i2.A(EnumConstants$Trigger.BEFORE_AGREE_PRIVACY);
            h(i2);
            qqq();
        }
    }

    public void rrr(vvv vvv2) {
        boolean equals = TextUtils.equals(vvv2.ppp(), vvv2.when());
        boolean z = (equals && (this.vvv.rg(vvv2.ppp()) && (vvv2.xxx() & 64) == 0)) || (equals && ((vvv2.xxx() & 128) != 0));
        if (tt.m142if().qw()) {
            if (!z) {
                this.f2098rg.b(vvv2);
                return;
            }
            List<String> fe2 = tt.m142if().fe();
            if (fe2 == null || !fe2.contains(vvv2.ppp())) {
                this.f2098rg.b(vvv2);
                return;
            } else if (!this.f2093de) {
                if ((System.currentTimeMillis() - this.f2092ad) / 1000 >= ((long) this.qw)) {
                    this.f2093de = true;
                } else {
                    this.f2098rg.b(vvv2);
                    return;
                }
            }
        }
        if (!z || v(vvv2)) {
            if (z) {
                aaa.o().ad(vvv2.ppp(), false, vvv2.vvv());
                fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.DB_SUCCESS_EVENT, vvv2.mmm());
            }
            if (tt.m142if().qw()) {
                this.f2098rg.th();
            } else if (Math.abs(System.currentTimeMillis() - this.f2096o) >= ((long) i.vvv().aaa())) {
                if (!z && this.vvv.m(vvv2.ppp())) {
                    yj(vvv2);
                }
                u(z);
            } else if ((vvv2.xxx() & 1) == 0) {
                if (!z && this.vvv.m(vvv2.ppp())) {
                    yj(vvv2);
                }
                if (this.f2095i.size() >= 20) {
                    eee();
                }
            } else if (!z && this.vvv.m(vvv2.ppp())) {
                this.f2098rg.b(vvv2);
            }
        } else if (this.vvv.m(vvv2.ppp())) {
            this.f2098rg.b(vvv2);
        }
    }

    public void s(boolean z) {
        EnumConstants$Trigger enumConstants$Trigger;
        EnumConstants$Trigger enumConstants$Trigger2;
        if (j.fe(this.f2094fe)) {
            this.f2098rg.yj(z);
            l i2 = l.i(this.f2094fe);
            int xxx2 = this.vvv.xxx();
            i2.z(xxx2);
            i2.y(true);
            l i3 = l.i(this.f2094fe);
            i3.z(xxx2);
            i3.y(false);
            this.f2098rg.ppp(i2, i3);
            int b = i2.b();
            int b2 = i3.b();
            if (a) {
                "real size = " + b + "   no real  = " + b2;
            }
            if (b > 0) {
                if (i2.j()) {
                    c.de().rrr("uploadAll", String.valueOf(xxx2), String.valueOf(b));
                }
                if (z) {
                    enumConstants$Trigger2 = EnumConstants$Trigger.COLD_START;
                } else {
                    enumConstants$Trigger2 = EnumConstants$Trigger.UPLOAD_ALL;
                }
                i2.A(enumConstants$Trigger2);
                h(i2);
            }
            if (b2 > 0) {
                if (i3.j()) {
                    c.de().rrr("uploadAll", String.valueOf(xxx2), String.valueOf(b2));
                }
                if (z) {
                    enumConstants$Trigger = EnumConstants$Trigger.COLD_START;
                } else {
                    enumConstants$Trigger = EnumConstants$Trigger.UPLOAD_ALL;
                }
                i2.A(enumConstants$Trigger);
                h(i3);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m137switch(String str, int i2, int i3, long j, JSONArray jSONArray, String str2) {
        List<String> fe2;
        eee();
        this.f2098rg.when(str, i2, j, jSONArray, str2);
        i iVar = this.vvv;
        if (!(iVar == null || iVar.ad(str) == 0)) {
            m.when(this.f2098rg.nn(str, i2));
        }
        if ((i3 & 128) != 0) {
            r(str);
            return;
        }
        boolean rg2 = this.vvv.rg(str);
        if (tt.m142if().qw()) {
            if (!rg2 || (fe2 = tt.m142if().fe()) == null || !fe2.contains(str)) {
                return;
            }
            if (!this.f2093de) {
                if ((System.currentTimeMillis() - this.f2092ad) / 1000 >= ((long) this.qw)) {
                    this.f2093de = true;
                } else {
                    return;
                }
            }
        }
        if (rg2) {
            if (a) {
                "endFlow flow " + str + " invoke ->uploadRealTimeFlow ";
            }
            w();
        }
        if (!tt.m142if().qw() && Math.abs(System.currentTimeMillis() - this.f2096o) >= ((long) i.vvv().aaa())) {
            if (a) {
                "endFlow flow " + str + " invoke ->uploadNonRealTimeData ";
            }
            u(rg2);
        }
    }

    public final void t(SparseArray<ArrayList> sparseArray, l lVar) {
        boolean z;
        if (sparseArray != null) {
            boolean j = this.vvv.j();
            boolean h = this.vvv.h();
            int ppp2 = this.vvv.ppp();
            if (!j || h || sparseArray.get(ppp2, (Object) null) != null) {
                z = false;
            } else {
                sparseArray.put(ppp2, new ArrayList(0));
                z = true;
            }
            for (int i2 = 0; i2 < sparseArray.size() && !lVar.rg(Config.d); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                if (keyAt == 0) {
                    if (!j || !h) {
                        this.f2098rg.ddd(sparseArray.valueAt(i2), true, lVar);
                    } else {
                        this.f2098rg.ddd(new ArrayList(this.vvv.qqq()), false, lVar);
                    }
                } else if (this.aaa) {
                    lVar.z(this.qqq);
                    if (!j || h || keyAt != ppp2) {
                        this.f2098rg.aaa(sparseArray.valueAt(i2), true, lVar);
                    } else {
                        ArrayList ggg2 = ggg(sparseArray, keyAt);
                        if (ggg2 != null) {
                            this.f2098rg.aaa(ggg2, false, lVar);
                        }
                    }
                } else if (!j || h || keyAt != ppp2) {
                    this.f2098rg.ddd(sparseArray.valueAt(i2), true, lVar);
                } else {
                    ArrayList ggg3 = ggg(sparseArray, keyAt);
                    if (ggg3 != null) {
                        this.f2098rg.ddd(ggg3, false, lVar);
                    }
                }
                if (lVar.f()) {
                    break;
                }
            }
            if (z) {
                sparseArray.remove(ppp2);
            }
        }
    }

    public void tt(vvv vvv2) {
        this.f2099th.yj(vvv2, this.vvv.rg(vvv2.ppp()));
    }

    public final void u(boolean z) {
        boolean z2;
        if (j.fe(this.f2094fe)) {
            boolean z3 = a;
            this.f2096o = System.currentTimeMillis();
            k.qw().th("ubc_last_upload_non_real", this.f2096o);
            o();
            eee();
            this.f2098rg.th();
            HashSet hashSet = new HashSet();
            if (this.when == null) {
                ddd();
            }
            l i2 = l.i(this.f2094fe);
            i2.y(false);
            for (int i3 = 0; i3 < this.when.size(); i3++) {
                int keyAt = this.when.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.ppp;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    long j = (long) keyAt;
                    long j2 = 60000 * j;
                    if (this.aaa) {
                        j2 = 1000 * j;
                    }
                    if (longValue == 0 || (longValue + j2) - System.currentTimeMillis() < ((long) this.vvv.aaa())) {
                        if (this.aaa) {
                            i2.z(this.qqq);
                            this.f2098rg.aaa(this.when.valueAt(i3), true, i2);
                        } else {
                            this.f2098rg.ddd(this.when.valueAt(i3), true, i2);
                        }
                        if (i2.f()) {
                            break;
                        }
                        HashMap<String, Long> hashMap2 = this.ppp;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (!i2.h()) {
                boolean j3 = this.vvv.j();
                boolean h = this.vvv.h();
                int ppp2 = this.vvv.ppp();
                if (!j3 || h || this.when.get(ppp2, (Object) null) != null) {
                    z2 = false;
                } else {
                    this.when.put(ppp2, new ArrayList(0));
                    z2 = true;
                }
                if (!this.aaa) {
                    for (int i4 = 0; i4 < this.when.size(); i4++) {
                        int keyAt2 = this.when.keyAt(i4);
                        if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                            if (i2.rg(Config.d)) {
                                break;
                            }
                            if (!j3 || h || keyAt2 != ppp2) {
                                this.f2098rg.ddd(this.when.valueAt(i4), true, i2);
                            } else {
                                ArrayList ggg2 = ggg(this.when, keyAt2);
                                if (ggg2 != null) {
                                    this.f2098rg.ddd(ggg2, false, i2);
                                }
                            }
                            if (i2.f()) {
                                break;
                            }
                        }
                    }
                }
                if (z2) {
                    this.when.remove(ppp2);
                }
                boolean z4 = a;
                i2.A(z ? EnumConstants$Trigger.REAL_APPEND_UNREAL : EnumConstants$Trigger.UNREAL);
                h(i2);
            }
        }
    }

    public void uk(String str, int i2) {
        eee();
        this.f2098rg.rg(str, i2);
        if (!tt.m142if().qw() && Math.abs(System.currentTimeMillis() - this.f2096o) >= ((long) i.vvv().aaa())) {
            if (a) {
                "cancel flow " + str + " invoke ->uploadNonRealTimeData ";
            }
            boolean z = true;
            i iVar = this.vvv;
            if (iVar != null) {
                z = iVar.rg(str);
            }
            u(z);
        }
    }

    public final boolean v(vvv vvv2) {
        SparseArray<ArrayList> sparseArray;
        if (!j.fe(this.f2094fe) || !pf()) {
            return false;
        }
        eee();
        l vvv3 = vvv(vvv2, false);
        if (vvv3 == null || vvv3.h()) {
            return false;
        }
        EnumConstants$Trigger enumConstants$Trigger = EnumConstants$Trigger.REAL;
        if ((vvv2.xxx() & 128) != 0) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(vvv2.ppp());
            sparseArray = new SparseArray<>(1);
            sparseArray.put(0, arrayList);
            enumConstants$Trigger = EnumConstants$Trigger.BEFORE_AGREE_PRIVACY;
        } else {
            if (this.when == null) {
                ddd();
            }
            if (y(vvv3, "0")) {
                return true;
            }
            sparseArray = this.when;
        }
        t(sparseArray, vvv3);
        vvv3.A(enumConstants$Trigger);
        h(vvv3);
        qqq();
        return true;
    }

    public final l vvv(vvv vvv2, boolean z) {
        l lVar;
        if (z) {
            lVar = l.o();
        } else {
            lVar = l.i(this.f2094fe);
        }
        fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_QUERY_EVENT, vvv2.mmm(), lVar.eee());
        if (!lVar.de(vvv2, vvv2.o())) {
            return null;
        }
        fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_TO_FILE_EVENT, vvv2.mmm(), lVar.eee());
        lVar.y(true);
        if ((vvv2.xxx() & 128) != 0) {
            lVar.m();
        }
        if (!TextUtils.isEmpty(vvv2.pf())) {
            lVar.x("1");
        }
        return lVar;
    }

    public final void w() {
        if (j.fe(this.f2094fe) && pf()) {
            l i2 = l.i(this.f2094fe);
            i2.y(true);
            if (this.when == null) {
                ddd();
            }
            if (!y(i2, "1")) {
                t(this.when, i2);
                i2.A(EnumConstants$Trigger.REAL);
                h(i2);
                qqq();
            }
        }
    }

    public void when() {
        try {
            eee();
        } catch (RuntimeException unused) {
            boolean z = a;
        }
    }

    public boolean x(vvv vvv2) {
        if (!j.fe(this.f2094fe)) {
            return false;
        }
        vvv2.j("1");
        l vvv3 = vvv(vvv2, true);
        if (vvv3 == null || vvv3.h()) {
            return false;
        }
        fe.fe.mmm.n.qw.th(BypassConstants$Funnel.PACKAGE_QUERY, vvv3.eee());
        this.f2098rg.qqq(vvv3);
        JSONObject a2 = vvv3.a(EnumConstants$Trigger.DIRECT_LOG);
        fe.fe.mmm.n.qw.th(BypassConstants$Funnel.PACKAGE_TO_FILE, vvv3.eee());
        th.nn().t(a2, true, vvv2, System.currentTimeMillis(), 1, new ad(vvv3));
        return true;
    }

    public int xxx(String str) {
        i iVar = this.vvv;
        if (iVar != null) {
            return iVar.d(str);
        }
        return -1;
    }

    public final boolean y(l lVar, String str) {
        if (!tt.m142if().qw()) {
            return false;
        }
        List<String> fe2 = tt.m142if().fe();
        if (!(fe2 == null || fe2.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(fe2);
            if (arrayList.size() == 0) {
                return true;
            }
            this.f2098rg.ddd(arrayList, true, lVar);
            h(lVar);
            qqq();
        }
        return true;
    }

    public final void yj(vvv vvv2) {
        m.rg(vvv2.ad(), EnumConstants$RunTime.EVENT_SAVE_CACHE);
        this.f2095i.add(vvv2);
        fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.CACHE_EVENT, vvv2.mmm());
        int i2 = this.f2101yj;
        if (i2 == 0) {
            this.f2100uk = SystemClock.uptimeMillis();
            th.nn().f(this.tt, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            this.f2101yj = 1;
        } else if (i2 == 2) {
            this.f2100uk = SystemClock.uptimeMillis();
            this.f2101yj = 1;
        }
    }
}
