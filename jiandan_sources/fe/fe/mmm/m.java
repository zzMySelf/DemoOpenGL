package fe.fe.mmm;

import android.text.TextUtils;
import com.baidu.ubc.IUbcLogStore;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import com.baidu.ubc.upload.ILogJsonProducer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class m {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f2056ad = tt.vvv();
    public final IUbcLogStore qw;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f2057ad;

        /* renamed from: de  reason: collision with root package name */
        public String f2058de;

        /* renamed from: fe  reason: collision with root package name */
        public String f2059fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f2060rg;

        /* renamed from: th  reason: collision with root package name */
        public String f2061th;

        public String ad() {
            return this.f2058de;
        }

        public String de() {
            return this.f2057ad;
        }

        public String fe() {
            return this.f2059fe;
        }

        public void i(String str) {
            this.f2057ad = str;
        }

        /* renamed from: if  reason: not valid java name */
        public void m129if(String str) {
            this.f2061th = str;
        }

        public void o(String str) {
            this.f2059fe = str;
        }

        public void pf(String str) {
            this.f2060rg = str;
        }

        public String qw() {
            return this.qw;
        }

        public String rg() {
            return this.f2060rg;
        }

        public String th() {
            return this.f2061th;
        }

        public void uk(String str) {
            this.f2058de = str;
        }

        public void yj(String str) {
            this.qw = str;
        }
    }

    public static class de {
        public static m qw = new m();
    }

    public static IUbcLogStore ad() {
        return de.qw.qw;
    }

    public static void de(ad adVar, EnumConstants$RunTime enumConstants$RunTime) {
        if (ad() != null && tt.pf().rg()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("from", enumConstants$RunTime.getFrom());
                jSONObject.put("type", enumConstants$RunTime.getType());
                if (enumConstants$RunTime.getValue() == 1) {
                    jSONObject.put("value", enumConstants$RunTime.getValue());
                }
                if (adVar != null) {
                    if (!TextUtils.isEmpty(adVar.qw())) {
                        jSONObject2.put("eid", adVar.qw());
                    }
                    if (!TextUtils.isEmpty(adVar.de())) {
                        jSONObject2.put("fid", adVar.de());
                    }
                    if (!TextUtils.isEmpty(adVar.ad())) {
                        jSONObject2.put("fn", adVar.ad());
                    }
                    if (!TextUtils.isEmpty(adVar.fe())) {
                        jSONObject2.put("ids", adVar.fe());
                    }
                    if (!TextUtils.isEmpty(adVar.rg())) {
                        jSONObject2.put("logid", adVar.rg());
                    }
                    if (!TextUtils.isEmpty(adVar.th())) {
                        jSONObject2.put("msg", adVar.th());
                    }
                    jSONObject.put(UBCManager.CONTENT_KEY_EXT, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (f2056ad) {
                "runtime: " + jSONObject;
            }
            ad().qw(jSONObject.toString());
        }
    }

    public static void fe(EnumConstants$RunTime enumConstants$RunTime) {
        de((ad) null, enumConstants$RunTime);
    }

    public static void i(String str, int i2, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.i(qw(str, String.valueOf(i2), (String) null));
        de(adVar, enumConstants$RunTime);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m127if(String str, String str2, String str3, boolean z, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        String qw2 = qw(str, str3, (String) null);
        if (z) {
            adVar.yj(qw2);
        } else {
            adVar.i(qw2);
        }
        adVar.pf(str2);
        de(adVar, enumConstants$RunTime);
    }

    public static void o(String str, int i2, String str2, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.i(qw(str, String.valueOf(i2), str2));
        de(adVar, enumConstants$RunTime);
    }

    public static void pf(ArrayList<String> arrayList, String str, String str2, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        if (arrayList != null && arrayList.size() > 0) {
            adVar.o(arrayList.toString());
        }
        adVar.uk(str);
        adVar.m129if(str2);
        de(adVar, enumConstants$RunTime);
    }

    public static String qw(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append("_");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("_");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static void rg(String str, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.yj(str);
        de(adVar, enumConstants$RunTime);
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m128switch(String str, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.m129if(str);
        de(adVar, enumConstants$RunTime);
    }

    public static void th(ILogJsonProducer iLogJsonProducer, String str, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        if (iLogJsonProducer instanceof vvv) {
            adVar.yj(iLogJsonProducer.ad());
        } else if (iLogJsonProducer instanceof ddd) {
            adVar.i(iLogJsonProducer.ad());
        }
        adVar.uk(str);
        de(adVar, enumConstants$RunTime);
    }

    public static void uk(String str, String str2, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.uk(str);
        adVar.m129if(str2);
        de(adVar, enumConstants$RunTime);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void when(com.baidu.ubc.upload.ILogJsonProducer r6) {
        /*
            if (r6 == 0) goto L_0x008f
            com.baidu.ubc.IUbcLogStore r0 = ad()
            if (r0 != 0) goto L_0x000a
            goto L_0x008f
        L_0x000a:
            boolean r0 = r6 instanceof fe.fe.mmm.vvv
            if (r0 == 0) goto L_0x001d
            r0 = r6
            fe.fe.mmm.vvv r0 = (fe.fe.mmm.vvv) r0
            java.lang.String r1 = r0.ppp()
            int r0 = r0.m145switch()
            r2 = -1
            if (r0 == r2) goto L_0x0028
            return
        L_0x001d:
            boolean r0 = r6 instanceof fe.fe.mmm.ddd
            if (r0 == 0) goto L_0x008f
            r0 = r6
            fe.fe.mmm.ddd r0 = (fe.fe.mmm.ddd) r0
            java.lang.String r1 = r0.ppp()
        L_0x0028:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x002f
            return
        L_0x002f:
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r2.<init>()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            android.util.JsonWriter r3 = new android.util.JsonWriter     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            r6.qw(r3)     // Catch:{ Exception -> 0x004c }
            r3.flush()     // Catch:{ Exception -> 0x004c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x004c }
            goto L_0x0064
        L_0x004c:
            r6 = move-exception
            goto L_0x0059
        L_0x004e:
            r6 = move-exception
            goto L_0x0088
        L_0x0050:
            r6 = move-exception
            r3 = r0
            goto L_0x0059
        L_0x0053:
            r6 = move-exception
            r2 = r0
            goto L_0x0088
        L_0x0056:
            r6 = move-exception
            r2 = r0
            r3 = r2
        L_0x0059:
            com.baidu.ubc.IUbcLogStore r4 = ad()     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0086 }
            r4.fe(r1, r6)     // Catch:{ all -> 0x0086 }
        L_0x0064:
            fe.fe.mmm.u.qw.ad(r3)
            fe.fe.mmm.u.qw.ad(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x0085
            fe.fe.mmm.c r6 = fe.fe.mmm.c.de()
            r6.a(r1, r0)
            com.baidu.ubc.IUbcLogStore r6 = ad()
            r6.ad(r1, r0)
            com.baidu.ubc.IUbcLogStore r6 = ad()
            r6.de(r1, r0)
        L_0x0085:
            return
        L_0x0086:
            r6 = move-exception
            r0 = r3
        L_0x0088:
            fe.fe.mmm.u.qw.ad(r0)
            fe.fe.mmm.u.qw.ad(r2)
            throw r6
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.m.when(com.baidu.ubc.upload.ILogJsonProducer):void");
    }

    public static void yj(String str, EnumConstants$RunTime enumConstants$RunTime) {
        ad adVar = new ad();
        adVar.uk(str);
        de(adVar, enumConstants$RunTime);
    }

    public m() {
        this.qw = (IUbcLogStore) fe.fe.vvv.ad.ad.ad.qw(IUbcLogStore.qw);
    }
}
