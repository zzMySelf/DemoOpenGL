package fe.fe.mmm;

import android.text.TextUtils;
import android.util.JsonWriter;
import com.baidu.ubc.upload.ILogJsonProducer;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.mmm.u.fe;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ddd implements ILogJsonProducer {
    public static final boolean mmm = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public int f1999ad;
    public String ddd;

    /* renamed from: de  reason: collision with root package name */
    public String f2000de;

    /* renamed from: fe  reason: collision with root package name */
    public JSONObject f2001fe;
    public String ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f2002i;

    /* renamed from: if  reason: not valid java name */
    public JSONArray f47if = null;
    public String nn;

    /* renamed from: o  reason: collision with root package name */
    public String f2003o;

    /* renamed from: pf  reason: collision with root package name */
    public JSONArray f2004pf;
    public int ppp = 0;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f2005rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f48switch = false;

    /* renamed from: th  reason: collision with root package name */
    public long f2006th;

    /* renamed from: uk  reason: collision with root package name */
    public String f2007uk;
    public JSONObject vvv;
    public int when = 0;
    public String xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f2008yj;

    public ddd() {
    }

    public void a(boolean z) {
        this.f48switch = z;
    }

    public void aaa(long j) {
        this.f2005rg = j;
    }

    public String ad() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw);
        sb.append("_");
        sb.append(this.f1999ad);
        if (!TextUtils.isEmpty(this.ddd)) {
            sb.append("_");
            sb.append(this.ddd);
        }
        return sb.toString();
    }

    public void b(long j) {
        this.f2006th = j;
    }

    public void c(JSONArray jSONArray) {
        this.f47if = jSONArray;
    }

    public void d() {
        if (i.vvv().qw(this.qw)) {
            this.f2002i = tt.pf().de();
        }
    }

    public String ddd() {
        return this.ddd;
    }

    public JSONObject de() throws JSONException {
        String str;
        JSONObject yj2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.qw);
        jSONObject.put("starttime", Long.toString(this.f2005rg));
        jSONObject.put("endtime", Long.toString(this.f2006th));
        jSONObject.put("type", "1");
        i vvv2 = i.vvv();
        if (vvv2.p(this.qw)) {
            str = "1";
        } else {
            str = "0";
        }
        jSONObject.put("isreal", str);
        int ggg2 = vvv2.ggg(this.qw);
        if (ggg2 != 0) {
            jSONObject.put("gflow", String.valueOf(ggg2));
        }
        JSONObject jSONObject2 = this.f2001fe;
        if (jSONObject2 != null) {
            jSONObject.put("content", jSONObject2.toString());
        } else if (!TextUtils.isEmpty(this.f2000de)) {
            jSONObject.put("content", this.f2000de);
        }
        if (!TextUtils.isEmpty(this.f2002i)) {
            jSONObject.put("abtest", this.f2002i);
        }
        if (!TextUtils.isEmpty(this.f2003o)) {
            jSONObject.put("c", this.f2003o);
        }
        JSONArray jSONArray = this.f2004pf;
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObject.put("part", this.f2004pf);
        }
        if (this.f48switch) {
            jSONObject.put("of", "1");
        }
        jSONObject.put("idtype", vvv2.b(this.qw));
        JSONArray jSONArray2 = this.f47if;
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            jSONObject.put("eventlist", this.f47if);
        }
        JSONObject jSONObject3 = this.vvv;
        if (jSONObject3 != null && jSONObject3.length() > 0) {
            jSONObject.put("bizparam", this.vvv);
        }
        if (!TextUtils.isEmpty(this.ggg) && (yj2 = yj()) != null) {
            jSONObject.put("bizInfo", yj2);
        }
        if (!TextUtils.isEmpty(this.xxx)) {
            jSONObject.put("logid", this.xxx);
        }
        if (!TextUtils.isEmpty(this.ddd)) {
            jSONObject.put(UrlOcrConfig.IdCardKey.UUID, this.ddd);
        }
        if (!TextUtils.isEmpty(this.nn)) {
            jSONObject.put("appv", this.nn);
        }
        int i2 = this.f2008yj;
        if (i2 != 0) {
            jSONObject.put("opt", i2);
        }
        return jSONObject;
    }

    public void e(String str) {
        this.f2002i = str;
    }

    public void eee(JSONObject jSONObject) {
        this.vvv = jSONObject;
    }

    public void f(int i2) {
        this.f1999ad = i2;
    }

    public String fe() {
        return this.nn;
    }

    public void g(String str) {
        this.qw = str;
    }

    public JSONObject ggg() {
        return this.f2001fe;
    }

    public void h(String str) {
        this.xxx = str;
    }

    public String i() {
        return this.f2003o;
    }

    /* renamed from: if  reason: not valid java name */
    public long m119if() {
        return this.f2006th;
    }

    public void j(int i2) {
        this.f2008yj = i2;
    }

    public void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f2004pf = new JSONArray(str);
                this.when = str.getBytes("UTF-8").length;
            } catch (JSONException e) {
                if (mmm) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e2) {
                if (mmm) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void l(String str) {
        this.f2007uk = str;
    }

    public void m(String str) {
        this.ddd = str;
    }

    public void mmm(String str) {
        this.nn = str;
    }

    public boolean nn() {
        return this.f48switch;
    }

    public String o() {
        return this.f2000de;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int pf() {
        /*
            r4 = this;
            int r0 = r4.ppp
            if (r0 <= 0) goto L_0x0005
            return r0
        L_0x0005:
            r0 = 0
            java.lang.String r1 = r4.qw
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = r4.qw
            byte[] r1 = r1.getBytes()
            int r1 = r1.length
            int r0 = r0 + r1
        L_0x0016:
            org.json.JSONObject r1 = r4.f2001fe
            java.lang.String r2 = "UTF-8"
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            byte[] r1 = r1.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            int r1 = r1.length     // Catch:{ UnsupportedEncodingException -> 0x0026 }
            goto L_0x003e
        L_0x0026:
            r1 = move-exception
            boolean r3 = mmm
            if (r3 == 0) goto L_0x003f
            r1.printStackTrace()
            goto L_0x003f
        L_0x002f:
            java.lang.String r1 = r4.f2000de
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x003f
            java.lang.String r1 = r4.f2000de
            byte[] r1 = r1.getBytes()
            int r1 = r1.length
        L_0x003e:
            int r0 = r0 + r1
        L_0x003f:
            java.lang.String r1 = r4.f2002i
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x004f
            java.lang.String r1 = r4.f2002i
            byte[] r1 = r1.getBytes()
            int r1 = r1.length
            int r0 = r0 + r1
        L_0x004f:
            org.json.JSONArray r1 = r4.f2004pf
            if (r1 == 0) goto L_0x005c
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x005c
            int r1 = r4.when
            int r0 = r0 + r1
        L_0x005c:
            org.json.JSONObject r1 = r4.vvv
            if (r1 == 0) goto L_0x007b
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x007b
            org.json.JSONObject r1 = r4.vvv     // Catch:{ UnsupportedEncodingException -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x0073 }
            byte[] r1 = r1.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x0073 }
            int r1 = r1.length     // Catch:{ UnsupportedEncodingException -> 0x0073 }
            int r0 = r0 + r1
            goto L_0x007b
        L_0x0073:
            r1 = move-exception
            boolean r2 = mmm
            if (r2 == 0) goto L_0x007b
            r1.printStackTrace()
        L_0x007b:
            java.lang.String r1 = r4.ggg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x008b
            java.lang.String r1 = r4.ggg
            byte[] r1 = r1.getBytes()
            int r1 = r1.length
            int r0 = r0 + r1
        L_0x008b:
            r4.ppp = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.ddd.pf():int");
    }

    public String ppp() {
        return this.qw;
    }

    public void qqq(String str) {
        this.ggg = str;
    }

    public void qw(JsonWriter jsonWriter) throws IOException {
        String str;
        jsonWriter.beginObject();
        jsonWriter.name("id").value(this.qw);
        jsonWriter.name("starttime").value(Long.toString(this.f2005rg));
        jsonWriter.name("endtime").value(Long.toString(this.f2006th));
        jsonWriter.name("type").value("1");
        JsonWriter name = jsonWriter.name("isreal");
        if (i.vvv().p(this.qw)) {
            str = "1";
        } else {
            str = "0";
        }
        name.value(str);
        int ggg2 = i.vvv().ggg(this.qw);
        if (ggg2 != 0) {
            jsonWriter.name("gflow").value((long) ggg2);
        }
        if (this.f2001fe != null) {
            jsonWriter.name("content").value(this.f2001fe.toString());
        } else if (!TextUtils.isEmpty(this.f2000de)) {
            jsonWriter.name("content").value(this.f2000de);
        }
        if (!TextUtils.isEmpty(this.f2002i)) {
            jsonWriter.name("abtest").value(this.f2002i);
        }
        if (!TextUtils.isEmpty(this.f2003o)) {
            jsonWriter.name("c").value(this.f2003o);
        }
        JSONArray jSONArray = this.f2004pf;
        if (jSONArray != null && jSONArray.length() > 0) {
            jsonWriter.name("part");
            fe.qw(jsonWriter, this.f2004pf);
        }
        if (this.f48switch) {
            jsonWriter.name("of").value("1");
        }
        jsonWriter.name("idtype").value(i.vvv().b(this.qw));
        JSONArray jSONArray2 = this.f47if;
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            jsonWriter.name("eventlist");
            jsonWriter.beginArray();
            int length = this.f47if.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) this.f47if.get(i2);
                    if (jSONObject != null) {
                        jsonWriter.beginObject();
                        if (jSONObject.has("id")) {
                            String optString = jSONObject.optString("id");
                            if (!TextUtils.isEmpty(optString)) {
                                jsonWriter.name("id").value(optString);
                            }
                        }
                        if (jSONObject.has("timestamp")) {
                            jsonWriter.name("timestamp").value(Long.toString(jSONObject.optLong("timestamp")));
                        }
                        if (jSONObject.has("content")) {
                            String optString2 = jSONObject.optString("content");
                            if (!TextUtils.isEmpty(optString2)) {
                                jsonWriter.name("content").value(optString2);
                            }
                        }
                        jsonWriter.endObject();
                    }
                } catch (JSONException e) {
                    if (mmm) {
                        e.printStackTrace();
                    }
                }
            }
            jsonWriter.endArray();
        }
        JSONObject jSONObject2 = this.vvv;
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            jsonWriter.name("bizparam");
            fe.qw(jsonWriter, this.vvv);
        }
        if (!TextUtils.isEmpty(this.ggg) && yj() != null) {
            jsonWriter.name("bizInfo");
            fe.qw(jsonWriter, yj());
        }
        if (!TextUtils.isEmpty(this.xxx)) {
            jsonWriter.name("logid").value(this.xxx);
        }
        if (!TextUtils.isEmpty(this.ddd)) {
            jsonWriter.name(UrlOcrConfig.IdCardKey.UUID).value(this.ddd);
        }
        if (!TextUtils.isEmpty(this.nn)) {
            jsonWriter.name("appv").value(this.nn);
        }
        if (this.f2008yj != 0) {
            jsonWriter.name("opt").value((long) this.f2008yj);
        }
        jsonWriter.endObject();
    }

    public long rg() {
        return this.f2005rg;
    }

    public void rrr(String str) {
        this.f2003o = str;
    }

    /* renamed from: switch  reason: not valid java name */
    public String m120switch() {
        return this.f2002i;
    }

    public String th() {
        return this.ggg;
    }

    public void tt(String str) {
        this.f2000de = str;
    }

    public JSONObject uk() {
        return this.vvv;
    }

    public int vvv() {
        return this.f2008yj;
    }

    public int when() {
        return this.f1999ad;
    }

    public String xxx() {
        return this.f2007uk;
    }

    public JSONObject yj() {
        if (TextUtils.isEmpty(this.ggg)) {
            return null;
        }
        try {
            return new JSONObject(this.ggg);
        } catch (JSONException e) {
            if (!mmm) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public ddd(String str, int i2, String str2) {
        this.qw = str;
        this.f1999ad = i2;
        this.f2000de = str2;
        this.f2008yj = 0;
    }

    public ddd(String str, int i2, String str2, int i3) {
        this.qw = str;
        this.f1999ad = i2;
        this.f2000de = str2;
        this.f2008yj = i3;
    }

    public ddd(String str, int i2, JSONObject jSONObject, int i3) {
        this.qw = str;
        this.f1999ad = i2;
        this.f2001fe = jSONObject;
        this.f2008yj = i3;
    }
}
