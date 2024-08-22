package fe.fe.mmm;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.SparseArray;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import com.baidu.ubc.constants.EnumConstants$Trigger;
import com.baidu.ubc.upload.ILogJsonProducer;
import com.baidubce.services.vod.VodClient;
import fe.fe.mmm.n.qw;
import fe.fe.mmm.t.ad;
import fe.fe.mmm.t.de;
import fe.fe.mmm.u.yj;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l {
    public static final boolean a = tt.vvv();
    public long aaa;

    /* renamed from: ad  reason: collision with root package name */
    public SparseArray<Integer> f2046ad;
    public de ddd;

    /* renamed from: de  reason: collision with root package name */
    public ArrayList<String> f2047de;
    public long eee;

    /* renamed from: fe  reason: collision with root package name */
    public ArrayList<Integer> f2048fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f2049i;

    /* renamed from: if  reason: not valid java name */
    public int f52if;
    public String mmm;
    public File nn;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2050o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f2051pf;
    public boolean ppp;
    public int qqq;
    public JSONArray qw;

    /* renamed from: rg  reason: collision with root package name */
    public ArrayList<String> f2052rg;
    public long rrr;

    /* renamed from: switch  reason: not valid java name */
    public long f53switch;

    /* renamed from: th  reason: collision with root package name */
    public Set<String> f2053th;
    public EnumConstants$Trigger tt;

    /* renamed from: uk  reason: collision with root package name */
    public long f2054uk;
    public JsonWriter vvv;
    public int when;
    public ad xxx;

    /* renamed from: yj  reason: collision with root package name */
    public long f2055yj;

    public l() {
        this.f2053th = new HashSet();
        this.f2050o = false;
        this.f2051pf = false;
        this.f52if = 0;
        this.f53switch = 0;
        this.when = 614400;
        this.ppp = false;
        this.ggg = 0;
        this.vvv = null;
        this.xxx = null;
        this.ddd = null;
        this.mmm = null;
        this.aaa = 0;
        this.qqq = 1;
        this.eee = 0;
        this.rrr = 0;
        this.tt = EnumConstants$Trigger.DEFAULT;
        this.qw = new JSONArray();
        this.f2046ad = new SparseArray<>();
        this.f2047de = new ArrayList<>();
        this.f2048fe = new ArrayList<>();
        this.f2052rg = new ArrayList<>();
        this.f2055yj = 0;
        this.f2054uk = 0;
        this.f2049i = "0";
        this.eee = System.currentTimeMillis();
    }

    public static l i(Context context) {
        File file;
        String de2 = j.de(context);
        File file2 = new File(de2);
        if (!file2.exists() && !file2.mkdir()) {
            return new l();
        }
        do {
            file = new File(de2, "upload_" + System.currentTimeMillis() + UUID.randomUUID().toString());
        } while (file.exists());
        return new l(file);
    }

    public static l o() {
        return new l();
    }

    public static l uk(File file, int i2, int i3, long j, boolean z) {
        return new l(file, i2, i3, j, z);
    }

    public void A(EnumConstants$Trigger enumConstants$Trigger) {
        this.tt = enumConstants$Trigger;
    }

    public final void B() {
        try {
            ad adVar = new ad(new FileOutputStream(this.nn), 2);
            this.xxx = adVar;
            de deVar = new de(adVar);
            this.ddd = deVar;
            JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(deVar));
            this.vvv = jsonWriter;
            jsonWriter.beginObject();
            this.vvv.name("data");
            this.vvv.flush();
            this.ddd.rg();
            this.vvv.beginArray();
            this.ggg = 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            n();
        } catch (IOException e2) {
            e2.printStackTrace();
            n();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: org.json.JSONException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: org.json.JSONException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: java.io.OutputStreamWriter} */
    /* JADX WARNING: type inference failed for: r3v18, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v21, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v27, types: [fe.fe.mmm.t.qw, java.io.Closeable, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062 A[Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055, all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d A[Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055, all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac A[SYNTHETIC, Splitter:B:59:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec A[Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e5, all -> 0x00e2, all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7 A[Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e5, all -> 0x00e2, all -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C() {
        /*
            r9 = this;
            boolean r0 = a
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            fe.fe.mmm.t.qw r2 = new fe.fe.mmm.t.qw     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055 }
            java.io.File r4 = r9.nn     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055 }
            r4 = 0
            r2.<init>(r3, r4)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0055 }
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x0049 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x0049 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
        L_0x001e:
            int r7 = r3.read(r6, r4, r5)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
            if (r7 < 0) goto L_0x0028
            r0.write(r6, r4, r7)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
            goto L_0x001e
        L_0x0028:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r5 = r0.toString()     // Catch:{ JSONException -> 0x0032 }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0032 }
            goto L_0x003b
        L_0x0032:
            r4 = move-exception
            boolean r5 = a     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
            if (r5 == 0) goto L_0x003a
            r4.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
        L_0x003a:
            r4 = r1
        L_0x003b:
            fe.fe.mmm.u.qw.ad(r2)
            fe.fe.mmm.u.qw.ad(r0)
            fe.fe.mmm.u.qw.ad(r3)
            goto L_0x007a
        L_0x0045:
            r4 = move-exception
            goto L_0x005e
        L_0x0047:
            r4 = move-exception
            goto L_0x0069
        L_0x0049:
            r3 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x0147
        L_0x004f:
            r4 = move-exception
            r3 = r1
            goto L_0x005e
        L_0x0052:
            r4 = move-exception
            r3 = r1
            goto L_0x0069
        L_0x0055:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x0147
        L_0x005b:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L_0x005e:
            boolean r5 = a     // Catch:{ all -> 0x0146 }
            if (r5 == 0) goto L_0x0070
            r4.printStackTrace()     // Catch:{ all -> 0x0146 }
            goto L_0x0070
        L_0x0066:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L_0x0069:
            boolean r5 = a     // Catch:{ all -> 0x0146 }
            if (r5 == 0) goto L_0x0070
            r4.printStackTrace()     // Catch:{ all -> 0x0146 }
        L_0x0070:
            fe.fe.mmm.u.qw.ad(r2)
            fe.fe.mmm.u.qw.ad(r0)
            fe.fe.mmm.u.qw.ad(r3)
            r4 = r1
        L_0x007a:
            if (r4 != 0) goto L_0x007d
            return
        L_0x007d:
            java.lang.String r0 = "metadata"
            org.json.JSONObject r0 = r4.optJSONObject(r0)     // Catch:{ JSONException -> 0x00a0 }
            if (r0 == 0) goto L_0x00a9
            java.lang.String r2 = "upload_index"
            int r3 = r9.qqq     // Catch:{ JSONException -> 0x009e }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ JSONException -> 0x009e }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x009e }
            java.lang.String r2 = "uploadtime"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x009e }
            java.lang.String r3 = java.lang.Long.toString(r5)     // Catch:{ JSONException -> 0x009e }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x009e }
            goto L_0x00a9
        L_0x009e:
            r2 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r2 = move-exception
            r0 = r1
        L_0x00a2:
            boolean r3 = a
            if (r3 == 0) goto L_0x00a9
            r2.printStackTrace()
        L_0x00a9:
            if (r0 != 0) goto L_0x00ac
            return
        L_0x00ac:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e5, all -> 0x00e2 }
            java.io.File r3 = r9.nn     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e5, all -> 0x00e2 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e5, all -> 0x00e2 }
            fe.fe.mmm.t.ad r3 = new fe.fe.mmm.t.ad     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            r5 = 2
            r3.<init>(r2, r5)     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            r9.xxx = r3     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            fe.fe.mmm.t.de r3 = new fe.fe.mmm.t.de     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            fe.fe.mmm.t.ad r5 = r9.xxx     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            r9.ddd = r3     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            fe.fe.mmm.t.de r5 = r9.ddd     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x00dc, all -> 0x00da }
            java.lang.String r5 = r4.toString()     // Catch:{ FileNotFoundException -> 0x00d8, IOException -> 0x00d6 }
            r3.write(r5)     // Catch:{ FileNotFoundException -> 0x00d8, IOException -> 0x00d6 }
            r3.flush()     // Catch:{ FileNotFoundException -> 0x00d8, IOException -> 0x00d6 }
            goto L_0x00fa
        L_0x00d6:
            r5 = move-exception
            goto L_0x00e8
        L_0x00d8:
            r5 = move-exception
            goto L_0x00f3
        L_0x00da:
            r0 = move-exception
            goto L_0x0135
        L_0x00dc:
            r5 = move-exception
            r3 = r1
            goto L_0x00e8
        L_0x00df:
            r5 = move-exception
            r3 = r1
            goto L_0x00f3
        L_0x00e2:
            r0 = move-exception
            r2 = r1
            goto L_0x0135
        L_0x00e5:
            r5 = move-exception
            r2 = r1
            r3 = r2
        L_0x00e8:
            boolean r6 = a     // Catch:{ all -> 0x0133 }
            if (r6 == 0) goto L_0x00fa
            r5.printStackTrace()     // Catch:{ all -> 0x0133 }
            goto L_0x00fa
        L_0x00f0:
            r5 = move-exception
            r2 = r1
            r3 = r2
        L_0x00f3:
            boolean r6 = a     // Catch:{ all -> 0x0133 }
            if (r6 == 0) goto L_0x00fa
            r5.printStackTrace()     // Catch:{ all -> 0x0133 }
        L_0x00fa:
            fe.fe.mmm.u.qw.ad(r3)
            fe.fe.mmm.t.de r3 = r9.ddd
            fe.fe.mmm.u.qw.ad(r3)
            fe.fe.mmm.t.ad r3 = r9.xxx
            fe.fe.mmm.u.qw.ad(r3)
            fe.fe.mmm.u.qw.ad(r2)
            r9.xxx = r1
            r9.ddd = r1
            boolean r1 = a
            if (r1 == 0) goto L_0x0132
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateMeta#content: "
            r1.append(r2)
            r1.append(r4)
            r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateMeta#meta: "
            r1.append(r2)
            r1.append(r0)
            r1.toString()
        L_0x0132:
            return
        L_0x0133:
            r0 = move-exception
            r1 = r3
        L_0x0135:
            fe.fe.mmm.u.qw.ad(r1)
            fe.fe.mmm.t.de r1 = r9.ddd
            fe.fe.mmm.u.qw.ad(r1)
            fe.fe.mmm.t.ad r1 = r9.xxx
            fe.fe.mmm.u.qw.ad(r1)
            fe.fe.mmm.u.qw.ad(r2)
            throw r0
        L_0x0146:
            r1 = move-exception
        L_0x0147:
            fe.fe.mmm.u.qw.ad(r2)
            fe.fe.mmm.u.qw.ad(r0)
            fe.fe.mmm.u.qw.ad(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.l.C():void");
    }

    public JSONObject a(EnumConstants$Trigger enumConstants$Trigger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.qw);
            if (this.f2055yj == 0 || this.f2054uk == 0) {
                this.f2055yj = this.f2054uk;
            }
            this.rrr = System.currentTimeMillis();
            jSONObject2.put("mintime", Long.toString(this.f2055yj));
            jSONObject2.put("maxtime", Long.toString(this.f2054uk));
            jSONObject2.put("createtime", Long.toString(this.eee));
            jSONObject2.put("uploadtime", Long.toString(this.rrr));
            jSONObject2.put("md5", j.th(this.qw.toString().getBytes(), true));
            if (enumConstants$Trigger != null) {
                jSONObject2.put("trigger", enumConstants$Trigger.getValue());
            }
            long j = this.rrr;
            this.aaa = j;
            jSONObject2.put("uploadtime_f", Long.toString(j));
            jSONObject2.put("upload_index", Integer.toString(this.qqq));
            String de2 = yj.ad().de();
            if (!TextUtils.isEmpty(de2)) {
                jSONObject2.put(VodClient.PARA_PROCESS, de2);
            }
            String qw2 = yj.ad().qw();
            if (!TextUtils.isEmpty(qw2)) {
                jSONObject2.put("db_sync", qw2);
            }
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f2049i);
            jSONObject.put("isreal", this.f2050o ? "1" : "0");
        } catch (JSONException unused) {
            boolean z = a;
        }
        return jSONObject;
    }

    public long aaa() {
        return this.f2054uk;
    }

    public final void ad(JSONObject jSONObject) {
        this.qw.put(jSONObject);
    }

    public int b() {
        return this.f52if;
    }

    public long c() {
        return this.aaa;
    }

    public int d() {
        return this.qqq;
    }

    public ArrayList<Integer> ddd() {
        return this.f2048fe;
    }

    public final boolean de(ILogJsonProducer iLogJsonProducer, int i2) {
        JsonWriter jsonWriter;
        if (!this.ppp) {
            try {
                ad(iLogJsonProducer.de());
                r(iLogJsonProducer);
                p(i2);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            if (this.ggg == 0) {
                File file = this.nn;
                m.th(iLogJsonProducer, file != null ? file.getName() : null, EnumConstants$RunTime.FILE_SAVE);
                qw.th(BypassConstants$Funnel.PACKAGE_QUERY, this.eee);
                B();
            }
            if (this.ggg != 1 || (jsonWriter = this.vvv) == null) {
                return false;
            }
            try {
                iLogJsonProducer.qw(jsonWriter);
                r(iLogJsonProducer);
                p(i2);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                n();
                return false;
            }
        }
    }

    public long e() {
        return this.rrr;
    }

    public long eee() {
        return this.eee;
    }

    public boolean f() {
        return this.ppp && this.ggg == 3;
    }

    public void fe(boolean z, int i2) {
        ArrayList<Integer> arrayList;
        int size;
        if (i2 != 0 && (arrayList = this.f2048fe) != null && arrayList.size() != 0 && (size = this.f2048fe.size()) < i2) {
            c.de().pf(z, size, i2);
        }
    }

    public boolean g() {
        return this.ppp;
    }

    public File ggg() {
        return this.nn;
    }

    public boolean h() {
        if (this.ppp) {
            int i2 = this.ggg;
            if ((i2 == 2 || i2 == 1) && this.f52if != 0) {
                return false;
            }
            return true;
        } else if (this.qw.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m125if() {
        if (this.ppp) {
            if (this.f52if == 0) {
                yj();
            }
            if (this.ggg != 1) {
                n();
                return;
            }
            JsonWriter jsonWriter = this.vvv;
            if (jsonWriter != null) {
                try {
                    jsonWriter.endArray();
                    this.vvv.flush();
                    this.ddd.th();
                    if (this.f2055yj == 0 || this.f2054uk == 0) {
                        this.f2055yj = this.f2054uk;
                    }
                    String rg2 = j.rg(this.ddd.qw(), "", true);
                    if (!TextUtils.isEmpty(rg2)) {
                        this.mmm = rg2;
                    }
                    if (a) {
                        String de2 = this.ddd.de();
                        if (TextUtils.isEmpty(de2)) {
                            "**********UploadData content: " + de2;
                        }
                    }
                    this.rrr = System.currentTimeMillis();
                    this.vvv.name("metadata");
                    this.vvv.beginObject();
                    this.vvv.name("mintime").value(Long.toString(this.f2055yj));
                    this.vvv.name("maxtime").value(Long.toString(this.f2054uk));
                    this.vvv.name("createtime").value(Long.toString(this.eee));
                    this.vvv.name("uploadtime").value(Long.toString(this.rrr));
                    this.vvv.name("md5").value(rg2);
                    this.vvv.name("trigger").value(this.tt.getValue());
                    this.aaa = this.rrr;
                    this.vvv.name("uploadtime_f").value(Long.toString(this.aaa));
                    this.vvv.name("upload_index").value(Integer.toString(this.qqq));
                    String de3 = yj.ad().de();
                    if (!TextUtils.isEmpty(de3)) {
                        this.vvv.name(VodClient.PARA_PROCESS).value(de3);
                    }
                    String qw2 = yj.ad().qw();
                    if (!TextUtils.isEmpty(qw2)) {
                        this.vvv.name("db_sync").value(qw2);
                    }
                    String str = "1";
                    if (!tt.ggg()) {
                        this.vvv.name("beforePrivacy").value(str);
                    }
                    this.vvv.endObject();
                    this.vvv.name("isAbtest").value(this.f2049i);
                    JsonWriter name = this.vvv.name("isreal");
                    if (!this.f2050o) {
                        str = "0";
                    }
                    name.value(str);
                    this.vvv.endObject();
                    this.vvv.flush();
                    fe.fe.mmm.u.qw.ad(this.vvv);
                    this.f53switch = this.xxx.qw();
                    if (this.nn.exists() && !TextUtils.isEmpty(this.mmm)) {
                        File file = new File(this.nn.getParentFile(), this.mmm);
                        if (!file.exists()) {
                            if (this.nn.renameTo(file)) {
                                m.uk(file.getName(), this.nn.getName(), EnumConstants$RunTime.FILE_RENAME);
                                this.nn = file;
                            } else if (a) {
                                "rename error for file: " + this.nn.getAbsolutePath();
                            }
                        }
                    }
                    this.ggg = 2;
                } catch (IOException e) {
                    e.printStackTrace();
                    n();
                } catch (Throwable th2) {
                    fe.fe.mmm.u.qw.ad(this.vvv);
                    fe.fe.mmm.u.qw.ad(this.ddd);
                    throw th2;
                }
                fe.fe.mmm.u.qw.ad(this.vvv);
                fe.fe.mmm.u.qw.ad(this.ddd);
                this.vvv = null;
                this.xxx = null;
                this.ddd = null;
            }
        }
    }

    public boolean j() {
        return this.f52if >= this.when;
    }

    public boolean k() {
        return this.f2051pf;
    }

    public boolean l() {
        return this.f2050o;
    }

    public void m() {
        this.f2051pf = true;
    }

    public final ArrayList<String> mmm() {
        return this.f2052rg;
    }

    public final void n() {
        ArrayList<String> arrayList = this.f2052rg;
        File file = this.nn;
        m.pf(arrayList, file != null ? file.getName() : null, (String) null, EnumConstants$RunTime.FILE_SAVE_IO_ERROR);
        pf();
        this.ggg = 3;
    }

    public final SparseArray<Integer> nn() {
        return this.f2046ad;
    }

    public final void p(int i2) {
        if (i2 > 0) {
            this.f52if += i2;
        }
    }

    public final void pf() {
        if (this.ppp) {
            JsonWriter jsonWriter = this.vvv;
            if (jsonWriter != null) {
                fe.fe.mmm.u.qw.ad(jsonWriter);
                this.vvv = null;
            }
            de deVar = this.ddd;
            if (deVar != null) {
                fe.fe.mmm.u.qw.ad(deVar);
                this.ddd = null;
                this.xxx = null;
            }
            File file = this.nn;
            if (file != null && file.exists()) {
                fe.fe.mmm.u.ad.qw(this.nn);
            }
            this.f2046ad.clear();
            this.f2047de.clear();
            this.f2048fe.clear();
            this.f2052rg.clear();
            this.nn = null;
            this.mmm = null;
            this.f52if = 0;
        }
    }

    public JSONArray ppp() {
        return this.qw;
    }

    public void q(String str) {
        GZIPInputStream gZIPInputStream;
        FileNotFoundException e;
        IOException e2;
        if (a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPInputStream = new GZIPInputStream(new fe.fe.mmm.t.qw(new FileInputStream(this.nn), 0));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = gZIPInputStream.read(bArr, 0, 4096);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                    "content: " + jSONObject;
                    "meta: " + jSONObject.optJSONObject("metadata");
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    fe.fe.mmm.u.qw.ad(byteArrayOutputStream);
                    fe.fe.mmm.u.qw.ad(gZIPInputStream);
                }
            } catch (FileNotFoundException e6) {
                gZIPInputStream = null;
                e = e6;
                e.printStackTrace();
                fe.fe.mmm.u.qw.ad(byteArrayOutputStream);
                fe.fe.mmm.u.qw.ad(gZIPInputStream);
            } catch (IOException e7) {
                gZIPInputStream = null;
                e2 = e7;
                e2.printStackTrace();
                fe.fe.mmm.u.qw.ad(byteArrayOutputStream);
                fe.fe.mmm.u.qw.ad(gZIPInputStream);
            } catch (Throwable th2) {
                th = th2;
                fe.fe.mmm.u.qw.ad(byteArrayOutputStream);
                fe.fe.mmm.u.qw.ad(gZIPInputStream);
                throw th;
            }
            fe.fe.mmm.u.qw.ad(byteArrayOutputStream);
            fe.fe.mmm.u.qw.ad(gZIPInputStream);
        }
    }

    public long qqq() {
        return this.f2055yj;
    }

    public void qw(Set<String> set) {
        if (!this.f2053th.containsAll(set)) {
            this.f2053th.addAll(set);
        }
    }

    public final void r(ILogJsonProducer iLogJsonProducer) {
        if (iLogJsonProducer != null) {
            if (iLogJsonProducer instanceof vvv) {
                vvv vvv2 = (vvv) iLogJsonProducer;
                s(vvv2.ppp());
                t(vvv2);
                v(vvv2.ad());
            } else if (iLogJsonProducer instanceof ddd) {
                ddd ddd2 = (ddd) iLogJsonProducer;
                u(ddd2.when(), Integer.parseInt(ddd2.ppp()));
                v(ddd2.ad());
            }
        }
    }

    public boolean rg(int i2) {
        return this.f52if >= i2;
    }

    public EnumConstants$Trigger rrr() {
        return this.tt;
    }

    public final void s(String str) {
        if (!this.f2047de.contains(str)) {
            this.f2047de.add(str);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public Set<String> m126switch() {
        return this.f2053th;
    }

    public void t(vvv vvv2) {
        int nn2;
        if (vvv2 != null && this.f2048fe != null && vvv2.m145switch() == -1 && (nn2 = vvv2.nn()) != -1) {
            this.f2048fe.add(Integer.valueOf(nn2));
        }
    }

    public void th() {
        this.f2046ad.clear();
        this.f2047de.clear();
        this.f2048fe.clear();
        this.f2052rg.clear();
        this.qw = null;
    }

    public JSONObject tt() {
        return a((EnumConstants$Trigger) null);
    }

    public final void u(int i2, int i3) {
        this.f2046ad.put(i2, Integer.valueOf(i3));
    }

    public final void v(String str) {
        this.f2052rg.add(str);
    }

    public String vvv() {
        if (!this.ppp || !this.nn.exists()) {
            return null;
        }
        return this.nn.getName();
    }

    public final void w(long j, long j2) {
        long j3 = this.f2055yj;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f2055yj = j;
        }
        if (j2 > this.f2054uk) {
            this.f2054uk = j2;
        }
    }

    public long when() {
        return this.f53switch;
    }

    public void x(String str) {
        this.f2049i = str;
    }

    public final ArrayList<String> xxx() {
        return this.f2047de;
    }

    public void y(boolean z) {
        this.f2050o = z;
    }

    public final void yj() {
        pf();
        this.ggg = 0;
    }

    public void z(int i2) {
        if (i2 >= 0) {
            this.when = i2;
        }
    }

    public l(File file) {
        this.f2053th = new HashSet();
        this.f2050o = false;
        this.f2051pf = false;
        this.f52if = 0;
        this.f53switch = 0;
        this.when = 614400;
        this.ppp = false;
        this.ggg = 0;
        this.vvv = null;
        this.xxx = null;
        this.ddd = null;
        this.mmm = null;
        this.aaa = 0;
        this.qqq = 1;
        this.eee = 0;
        this.rrr = 0;
        this.tt = EnumConstants$Trigger.DEFAULT;
        this.qw = new JSONArray();
        this.f2046ad = new SparseArray<>();
        this.f2047de = new ArrayList<>();
        this.f2048fe = new ArrayList<>();
        this.f2052rg = new ArrayList<>();
        this.f2055yj = 0;
        this.f2054uk = 0;
        this.f2049i = "0";
        this.eee = System.currentTimeMillis();
        if (file != null) {
            this.nn = file;
            this.ppp = true;
        }
    }

    public l(File file, int i2, int i3, long j, boolean z) {
        this.f2053th = new HashSet();
        this.f2050o = false;
        this.f2051pf = false;
        this.f52if = 0;
        this.f53switch = 0;
        this.when = 614400;
        this.ppp = false;
        this.ggg = 0;
        this.vvv = null;
        this.xxx = null;
        this.ddd = null;
        this.mmm = null;
        this.aaa = 0;
        this.qqq = 1;
        this.eee = 0;
        this.rrr = 0;
        this.tt = EnumConstants$Trigger.DEFAULT;
        this.nn = file;
        this.ppp = true;
        this.f52if = i2;
        this.qqq = i3;
        this.eee = j;
        if (z) {
            C();
        } else {
            this.rrr = System.currentTimeMillis();
        }
    }
}
