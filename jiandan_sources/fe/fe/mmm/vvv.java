package fe.fe.mmm;

import android.text.TextUtils;
import android.util.JsonWriter;
import com.baidu.ubc.upload.ILogJsonProducer;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.mmm.u.fe;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class vvv implements ILogJsonProducer {
    public static final boolean ddd = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public String f2219ad;

    /* renamed from: de  reason: collision with root package name */
    public int f2220de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2221fe = "";
    public String ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f2222i;

    /* renamed from: if  reason: not valid java name */
    public String f64if = "0";

    /* renamed from: o  reason: collision with root package name */
    public boolean f2223o = false;

    /* renamed from: pf  reason: collision with root package name */
    public String f2224pf = "";
    public JSONObject ppp;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public JSONObject f2225rg;

    /* renamed from: switch  reason: not valid java name */
    public int f65switch = -1;

    /* renamed from: th  reason: collision with root package name */
    public long f2226th;

    /* renamed from: uk  reason: collision with root package name */
    public String f2227uk;
    public String vvv;
    public String when;
    public String xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f2228yj;

    public vvv(String str) {
        this.qw = str;
        this.f2219ad = str;
        this.f2220de = -1;
        this.f2228yj = 0;
    }

    public void a(String str) {
        this.f2222i = str;
    }

    public String aaa() {
        return this.vvv;
    }

    public String ad() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw);
        if (!TextUtils.isEmpty(this.vvv)) {
            sb.append("_");
            sb.append(this.vvv);
        }
        if (this.f65switch != -1) {
            sb.append("_");
            sb.append(this.f65switch);
        }
        return sb.toString();
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2221fe = str;
        }
    }

    public void c(boolean z) {
        this.f2223o = z;
    }

    public void d() {
        String str = this.qw;
        if (str != null && str.equals(this.f2219ad) && i.vvv().qw(this.qw)) {
            this.f2227uk = tt.pf().de();
        }
    }

    public String ddd() {
        return this.f64if;
    }

    public JSONObject de() throws JSONException {
        JSONObject th2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.qw);
        jSONObject.put("timestamp", Long.toString(this.f2226th));
        String str = "0";
        jSONObject.put("type", str);
        JSONObject jSONObject2 = this.f2225rg;
        if (jSONObject2 != null) {
            jSONObject.put("content", jSONObject2.toString());
        } else if (!TextUtils.isEmpty(this.f2221fe)) {
            jSONObject.put("content", this.f2221fe);
        }
        if (!TextUtils.isEmpty(this.f2227uk)) {
            jSONObject.put("abtest", this.f2227uk);
        }
        if (!TextUtils.isEmpty(this.f2222i)) {
            jSONObject.put("c", this.f2222i);
        }
        if (this.f2223o) {
            jSONObject.put("of", "1");
        }
        i vvv2 = i.vvv();
        jSONObject.put("idtype", vvv2.b(this.qw));
        if (vvv2.p(this.qw)) {
            str = "1";
        }
        jSONObject.put("isreal", str);
        int ggg2 = vvv2.ggg(this.qw);
        if (ggg2 != 0) {
            jSONObject.put("gflow", String.valueOf(ggg2));
        }
        JSONObject jSONObject3 = this.ppp;
        if (jSONObject3 != null && jSONObject3.length() > 0) {
            jSONObject.put("bizparam", this.ppp);
        }
        if (!TextUtils.isEmpty(this.when) && (th2 = th()) != null) {
            jSONObject.put("bizInfo", th2);
        }
        if (!TextUtils.isEmpty(this.ggg)) {
            jSONObject.put("logid", this.ggg);
        }
        if (!TextUtils.isEmpty(this.vvv)) {
            jSONObject.put(UrlOcrConfig.IdCardKey.UUID, this.vvv);
        }
        if (!TextUtils.isEmpty(this.xxx)) {
            jSONObject.put("appv", this.xxx);
        }
        int i2 = this.f2228yj;
        if (i2 != 0) {
            jSONObject.put("opt", i2);
        }
        return jSONObject;
    }

    public void e(String str) {
        this.f2227uk = str;
    }

    public void eee(String str) {
        this.xxx = str;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f2225rg = jSONObject;
        }
    }

    public String fe() {
        return this.xxx;
    }

    public void g(String str) {
        this.ggg = str;
    }

    public JSONObject ggg() {
        return this.f2225rg;
    }

    public void h(int i2) {
        this.f2228yj = i2;
    }

    public String i() {
        return this.f2221fe;
    }

    /* renamed from: if  reason: not valid java name */
    public String m144if() {
        return this.f2224pf;
    }

    public void j(String str) {
        this.f64if = str;
    }

    public void k(int i2) {
        this.f65switch = i2;
    }

    public void l(long j) {
        this.f2226th = j;
    }

    public void m(String str) {
        this.vvv = str;
    }

    public long mmm() {
        return this.f2226th;
    }

    public int nn() {
        return this.f65switch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int o() {
        /*
            r4 = this;
            java.lang.String r0 = r4.qw
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r4.qw
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            int r1 = r1 + r0
        L_0x0011:
            org.json.JSONObject r0 = r4.f2225rg
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            byte[] r0 = r0.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            int r0 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            goto L_0x0039
        L_0x0021:
            r0 = move-exception
            boolean r3 = ddd
            if (r3 == 0) goto L_0x003a
            r0.printStackTrace()
            goto L_0x003a
        L_0x002a:
            java.lang.String r0 = r4.f2221fe
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = r4.f2221fe
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
        L_0x0039:
            int r1 = r1 + r0
        L_0x003a:
            java.lang.String r0 = r4.f2227uk
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004a
            java.lang.String r0 = r4.f2227uk
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            int r1 = r1 + r0
        L_0x004a:
            org.json.JSONObject r0 = r4.ppp
            if (r0 == 0) goto L_0x0069
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0069
            org.json.JSONObject r0 = r4.ppp     // Catch:{ UnsupportedEncodingException -> 0x0061 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x0061 }
            byte[] r0 = r0.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x0061 }
            int r0 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x0061 }
            int r1 = r1 + r0
            goto L_0x0069
        L_0x0061:
            r0 = move-exception
            boolean r2 = ddd
            if (r2 == 0) goto L_0x0069
            r0.printStackTrace()
        L_0x0069:
            java.lang.String r0 = r4.when
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0079
            java.lang.String r0 = r4.when
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            int r1 = r1 + r0
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.vvv.o():int");
    }

    public String pf() {
        return this.f2227uk;
    }

    public String ppp() {
        return this.qw;
    }

    public boolean qqq() {
        return this.f2223o;
    }

    public void qw(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("id").value(this.qw);
        jsonWriter.name("timestamp").value(Long.toString(this.f2226th));
        String str = "0";
        jsonWriter.name("type").value(str);
        if (this.f2225rg != null) {
            jsonWriter.name("content").value(this.f2225rg.toString());
        } else if (!TextUtils.isEmpty(this.f2221fe)) {
            jsonWriter.name("content").value(this.f2221fe);
        }
        if (!TextUtils.isEmpty(this.f2227uk)) {
            jsonWriter.name("abtest").value(this.f2227uk);
        }
        if (!TextUtils.isEmpty(this.f2222i)) {
            jsonWriter.name("c").value(this.f2222i);
        }
        if (this.f2223o) {
            jsonWriter.name("of").value("1");
        }
        jsonWriter.name("idtype").value(i.vvv().b(this.qw));
        JsonWriter name = jsonWriter.name("isreal");
        if (i.vvv().p(this.qw)) {
            str = "1";
        }
        name.value(str);
        int ggg2 = i.vvv().ggg(this.qw);
        if (ggg2 != 0) {
            jsonWriter.name("gflow").value(String.valueOf(ggg2));
        }
        JSONObject jSONObject = this.ppp;
        if (jSONObject != null && jSONObject.length() > 0) {
            jsonWriter.name("bizparam");
            fe.qw(jsonWriter, this.ppp);
        }
        if (!TextUtils.isEmpty(this.when) && th() != null) {
            jsonWriter.name("bizInfo");
            fe.qw(jsonWriter, th());
        }
        if (!TextUtils.isEmpty(this.ggg)) {
            jsonWriter.name("logid").value(this.ggg);
        }
        if (!TextUtils.isEmpty(this.vvv)) {
            jsonWriter.name(UrlOcrConfig.IdCardKey.UUID).value(this.vvv);
        }
        if (!TextUtils.isEmpty(this.xxx)) {
            jsonWriter.name("appv").value(this.xxx);
        }
        if (this.f2228yj != 0) {
            jsonWriter.name("opt").value((long) this.f2228yj);
        }
        jsonWriter.endObject();
    }

    public String rg() {
        return this.when;
    }

    public void rrr(String str) {
        this.when = str;
    }

    /* renamed from: switch  reason: not valid java name */
    public int m145switch() {
        return this.f2220de;
    }

    public JSONObject th() {
        if (TextUtils.isEmpty(this.when)) {
            return null;
        }
        try {
            return new JSONObject(this.when);
        } catch (JSONException e) {
            if (!ddd) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public void tt(JSONObject jSONObject) {
        this.ppp = jSONObject;
    }

    public String uk() {
        return this.f2222i;
    }

    public String vvv() {
        return this.ggg;
    }

    public String when() {
        return this.f2219ad;
    }

    public int xxx() {
        return this.f2228yj;
    }

    public JSONObject yj() {
        return this.ppp;
    }

    public vvv(String str, String str2, int i2) {
        this.qw = str;
        this.f2219ad = str;
        this.f2220de = -1;
        this.f2221fe = str2;
        this.f2228yj = i2;
        if ((i2 & 2) == 0) {
            this.f2226th = System.currentTimeMillis();
        }
    }

    public vvv(String str, JSONObject jSONObject, int i2) {
        this.qw = str;
        this.f2219ad = str;
        this.f2220de = -1;
        this.f2225rg = jSONObject;
        this.f2228yj = i2;
        if ((i2 & 2) == 0) {
            this.f2226th = System.currentTimeMillis();
        }
    }

    public vvv(String str, String str2, int i2, String str3, int i3) {
        this.qw = str2;
        this.f2219ad = str;
        this.f2220de = i2;
        this.f2221fe = str3;
        this.f2228yj = i3;
        if ((i3 & 2) == 0) {
            this.f2226th = System.currentTimeMillis();
        }
    }

    public vvv(String str, String str2, int i2, String str3, long j, int i3) {
        this.qw = str2;
        this.f2219ad = str;
        this.f2220de = i2;
        this.f2221fe = str3;
        this.f2228yj = i3;
        if ((i3 & 2) != 0) {
            return;
        }
        if (j > 0) {
            this.f2226th = j;
        } else {
            this.f2226th = System.currentTimeMillis();
        }
    }
}
