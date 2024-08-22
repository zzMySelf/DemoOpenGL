package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15031a = "s";

    /* renamed from: b  reason: collision with root package name */
    private AsyncHttpClient f15032b;

    public interface a {
        void a(int i2, String str, String str2);

        void a(String str);

        void a(boolean z, String str);
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final s f15033a = new s((r) null);
    }

    private s() {
        this.f15032b = new AsyncHttpClient();
    }

    /* synthetic */ s(r rVar) {
        this();
    }

    public static s a() {
        return b.f15033a;
    }

    private String a(Context context, String str) {
        String str2 = "null";
        if (!a(b(context, str))) {
            return str2;
        }
        try {
            FileInputStream openFileInput = context.openFileInput("server_custom_style_" + str + ".json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(openFileInput));
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.nextName().equals("md5")) {
                        str2 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                try {
                    jsonReader.close();
                    openFileInput.close();
                } catch (IOException e2) {
                    Log.e(f15031a, "Close custom style failed", e2);
                }
                return str2;
            } catch (IOException e3) {
                Log.e(f15031a, "Read custom style failed", e3);
                try {
                    jsonReader.close();
                    openFileInput.close();
                } catch (IOException e4) {
                    Log.e(f15031a, "Close custom style failed", e4);
                }
                return str2;
            } catch (Throwable th2) {
                try {
                    jsonReader.close();
                    openFileInput.close();
                } catch (IOException e5) {
                    Log.e(f15031a, "Close custom style failed", e5);
                }
                throw th2;
            }
        } catch (FileNotFoundException e6) {
            Log.e(f15031a, "Open custom style failed", e6);
            return str2;
        }
    }

    private String a(Context context, String str, boolean z) {
        String a2 = a(context, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("style_id", str);
        linkedHashMap.put("type", z ? "publish" : "edit");
        linkedHashMap.put("md5", a2);
        linkedHashMap.put("token", SyncSysInfo.getAuthToken());
        String str2 = a((Map<String, String>) linkedHashMap) + SyncSysInfo.getPhoneInfo();
        return c() + GameCenterUtils.SCHEME_SWAN_SUFFIX + (str2 + "&sign=" + AppMD5.getSignMD5String(str2));
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String next : map.keySet()) {
            (i2 == 0 ? sb.append(next) : sb.append("&").append(next)).append("=").append(AppMD5.encodeUrlParamsValue(map.get(next)));
            i2++;
        }
        return sb.toString();
    }

    private void a(Context context, String str, String str2, a aVar) {
        this.f15032b.get(str, new r(this, context, str2, aVar));
    }

    private void a(Context context, String str, boolean z, a aVar) {
        String b2 = b(context, str);
        if (!a(b2)) {
            b2 = null;
        }
        if (aVar != null) {
            aVar.a(b2);
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.NETWORK_ERROR.ordinal(), HttpClient.HttpStateError.NETWORK_ERROR.name(), b2);
            }
        } else if (!TextUtils.isEmpty(str)) {
            String a2 = a(context, str, z);
            if (TextUtils.isEmpty(a2)) {
                Log.e(f15031a, "build request url failed");
            } else {
                a(context, a2, str, aVar);
            }
        }
    }

    private boolean a(int i2, String str, String str2) {
        return (103 != i2 || !a(str2)) && i2 == 0;
    }

    private boolean a(Context context, JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String jSONObject2;
        File file = new File(b(context, str));
        if (file.exists()) {
            file.delete();
        }
        try {
            if (file.createNewFile()) {
                file.createNewFile();
            }
            String optString = jSONObject.optString("json");
            String optString2 = jSONObject.optString("md5", "null");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("json", optString);
                jSONObject3.put("md5", optString2);
                jSONObject2 = jSONObject3.toString();
            } catch (JSONException e2) {
                e = e2;
                str2 = f15031a;
                str3 = "build style data failed";
                Log.e(str2, str3, e);
                return false;
            }
            try {
                FileOutputStream openFileOutput = context.openFileOutput("server_custom_style_" + str + ".json", 0);
                openFileOutput.write(jSONObject2.getBytes());
                openFileOutput.flush();
                openFileOutput.close();
                return true;
            } catch (IOException e3) {
                e = e3;
                str2 = f15031a;
                str3 = "write style data into file failed";
                Log.e(str2, str3, e);
                return false;
            }
        } catch (IOException e4) {
            e = e4;
            str2 = f15031a;
            str3 = "create custom file failed";
            Log.e(str2, str3, e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    public String b(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "server_custom_style_" + str + ".json";
    }

    /* access modifiers changed from: private */
    public void b(Context context, String str, String str2, a aVar) {
        String b2 = b(context, str2);
        String str3 = a(b2) ? b2 : null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (a(jSONObject.optInt("status"), jSONObject.optString("message"), b2)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null || optJSONObject.length() == 0) {
                        Log.e(f15031a, "custom style data is null");
                        if (aVar != null) {
                            aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                            return;
                        }
                        return;
                    }
                    boolean a2 = a(context, optJSONObject, str2);
                    if (aVar != null) {
                        if (!a(b2)) {
                            b2 = null;
                        }
                        if (a2) {
                            aVar.a(true, b2);
                        } else {
                            aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "write style data into file failed", b2);
                        }
                    }
                } else if (aVar != null) {
                    aVar.a(false, str3);
                }
            } catch (JSONException e2) {
                Log.e(f15031a, "parse response result failed", e2);
                if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
                }
            }
        } else if (aVar != null) {
            aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), HttpClient.HttpStateError.SERVER_ERROR.name(), str3);
        }
    }

    private String c() {
        return HttpClient.isHttpsEnable ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle" : "http://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle";
    }

    public void a(Context context, String str, a aVar) {
        a(context, str, true, aVar);
    }
}
