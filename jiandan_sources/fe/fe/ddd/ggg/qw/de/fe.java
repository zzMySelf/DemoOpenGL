package fe.fe.ddd.ggg.qw.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.statistics.ICommandStatistics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import fe.fe.ddd.ggg.qw.ad.ad;
import java.io.IOException;
import java.io.Reader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fe implements ICommandStatistics<ad> {

    /* renamed from: uk  reason: collision with root package name */
    public static final boolean f1436uk = AppConfig.rg();

    /* renamed from: ad  reason: collision with root package name */
    public String f1437ad;

    /* renamed from: de  reason: collision with root package name */
    public int f1438de;

    /* renamed from: fe  reason: collision with root package name */
    public JSONArray f1439fe = new JSONArray();
    public de qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f1440rg;

    /* renamed from: th  reason: collision with root package name */
    public int f1441th;

    /* renamed from: yj  reason: collision with root package name */
    public int f1442yj;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ggg.qw.de.fe.qw.<clinit>():void");
        }
    }

    public fe(de deVar) {
        if (deVar == null) {
            this.qw = new de();
        } else {
            this.qw = deVar;
        }
    }

    public final long ad(String str, String str2) {
        long j = 0;
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        try {
            j = Long.parseLong(str2);
            if (f1436uk) {
                "action = " + str + " support imsdk long connect,new data version is  " + str2;
            }
        } catch (NumberFormatException unused) {
            if (f1436uk) {
                "action = " + str + " support imsdk long connect,version is not right--> " + str2;
            }
        }
        return j;
    }

    public final boolean de(Context context, String str, String str2, qw qwVar, ad adVar, JSONObject jSONObject) {
        if (!th(jSONObject) || ad(str2, adVar.qw) > ad(str2, qwVar.rg(context, str, str2))) {
            return true;
        }
        return false;
    }

    public void fe() {
        ad.qw().ad(this.f1438de, rg());
    }

    public void i(Reader reader, int i2, JSONObject jSONObject) throws IOException {
        this.f1437ad = String.valueOf(System.currentTimeMillis());
        this.f1438de = i2;
        uk(new JsonReader(reader), jSONObject);
        fe();
    }

    public final void o(JsonReader jsonReader, String str) throws IOException {
        if (jsonReader.getPath().equals(str)) {
            jsonReader.skipValue();
            return;
        }
        do {
            int i2 = qw.qw[jsonReader.peek().ordinal()];
            if (i2 == 1) {
                jsonReader.endObject();
            } else if (i2 != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.endArray();
            }
        } while (!jsonReader.getPath().equals(str));
    }

    public void qw(String str, ad adVar, boolean z) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("product", str);
                if (adVar == null) {
                    str2 = "-1";
                } else {
                    str2 = adVar.qw;
                }
                jSONObject.put("version", str2);
                jSONObject.put("valid", z ? "1" : "0");
                if (z) {
                    this.f1441th++;
                }
                this.f1439fe.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject rg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("receive_timestamp", this.f1437ad);
            jSONObject.put("detail", this.f1439fe);
            jSONObject.put("totalCount", this.f1440rg);
            jSONObject.put("successCount", this.f1441th);
            jSONObject.put("versionFilterCount", this.f1442yj);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean th(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("version_asc"), "1");
    }

    public final void uk(JsonReader jsonReader, JSONObject jSONObject) throws IOException {
        boolean z;
        jsonReader.beginObject();
        Gson gson = new Gson();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName2 = jsonReader.nextName();
                boolean z2 = true;
                this.f1440rg++;
                if (f1436uk) {
                    "read action " + nextName + " " + nextName2;
                }
                qw ad2 = this.qw.ad(nextName, nextName2);
                if (ad2 == null) {
                    ad2 = new th();
                    z = false;
                } else {
                    z = true;
                }
                TypeAdapter<?> th2 = ad2.th();
                if (th2 == null) {
                    try {
                        th2 = gson.getAdapter(TypeToken.get(ad2.fe()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        qw(nextName + "/" + nextName2, (ad) null, false);
                    }
                }
                ad ad3 = ad2.ad();
                boolean yj2 = yj(jsonReader, ad3, th2);
                if (yj2) {
                    synchronized (fe.class) {
                        if (!de(fe.fe.ddd.i.qw.qw.qw(), nextName, nextName2, ad2, ad3, jSONObject)) {
                            boolean z3 = f1436uk;
                            qw(nextName + "/" + nextName2, ad3, false);
                            this.f1442yj = this.f1442yj + 1;
                        } else {
                            ad2.de(fe.fe.ddd.i.qw.qw.qw(), nextName, nextName2, ad3);
                        }
                    }
                } else if (f1436uk) {
                    "read action " + nextName + " " + nextName2 + " fail";
                }
                String str = nextName + "/" + nextName2;
                if (!z || !yj2) {
                    z2 = false;
                }
                qw(str, ad3, z2);
            }
            jsonReader.endObject();
        }
        jsonReader.endObject();
    }

    public final boolean yj(JsonReader jsonReader, ad adVar, TypeAdapter typeAdapter) throws IOException {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("data")) {
                    adVar.f1435ad = typeAdapter.read(jsonReader);
                } else if (nextName.equals("version")) {
                    adVar.qw = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return true;
        } catch (Exception unused) {
            o(jsonReader, jsonReader.getPath());
            return false;
        }
    }
}
