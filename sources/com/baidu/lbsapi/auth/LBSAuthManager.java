package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.lbsapi.auth.d;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.23";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f13541a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static m f13542b;

    /* renamed from: c  reason: collision with root package name */
    private static int f13543c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Hashtable<String, LBSAuthManagerListener> f13544d = new Hashtable<>();

    /* renamed from: e  reason: collision with root package name */
    private static LBSAuthManager f13545e;

    /* renamed from: f  reason: collision with root package name */
    private d f13546f = null;

    /* renamed from: g  reason: collision with root package name */
    private f f13547g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13548h = false;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f13549i = new i(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        f13541a = context;
        m mVar = f13542b;
        if (mVar != null && !mVar.isAlive()) {
            f13542b = null;
        }
        a.c("BaiduApiAuth SDK Version:1.0.23");
        d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007a, code lost:
        if (r6 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x008b, code lost:
        if (r6 == null) goto L_0x008e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.lang.String r3 = "/proc/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.lang.StringBuilder r6 = r2.append(r6)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.lang.String r2 = "/cmdline"
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c, all -> 0x0058 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0052, all -> 0x004e }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0052, all -> 0x004e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x004b, IOException -> 0x0048, all -> 0x0046 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x004b, IOException -> 0x0048, all -> 0x0046 }
            java.lang.String r0 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x003d }
            r2.close()
            r1.close()
        L_0x0038:
            r6.close()
            goto L_0x008e
        L_0x003d:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x005c
        L_0x0042:
            r3 = move-exception
            goto L_0x0070
        L_0x0044:
            r3 = move-exception
            goto L_0x0081
        L_0x0046:
            r2 = move-exception
            goto L_0x005c
        L_0x0048:
            r2 = move-exception
            r2 = r0
            goto L_0x0070
        L_0x004b:
            r2 = move-exception
            r2 = r0
            goto L_0x0081
        L_0x004e:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x005c
        L_0x0052:
            r1 = move-exception
            r1 = r0
            goto L_0x006f
        L_0x0055:
            r1 = move-exception
            r1 = r0
            goto L_0x0080
        L_0x0058:
            r6 = move-exception
            r2 = r6
            r6 = r0
            r1 = r6
        L_0x005c:
            if (r0 == 0) goto L_0x0061
            r0.close()
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            if (r6 == 0) goto L_0x006b
            r6.close()
        L_0x006b:
            throw r2
        L_0x006c:
            r6 = move-exception
            r6 = r0
            r1 = r6
        L_0x006f:
            r2 = r1
        L_0x0070:
            if (r2 == 0) goto L_0x0075
            r2.close()
        L_0x0075:
            if (r1 == 0) goto L_0x007a
            r1.close()
        L_0x007a:
            if (r6 == 0) goto L_0x008e
            goto L_0x008d
        L_0x007d:
            r6 = move-exception
            r6 = r0
            r1 = r6
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r2 == 0) goto L_0x0086
            r2.close()
        L_0x0086:
            if (r1 == 0) goto L_0x008b
            r1.close()
        L_0x008b:
            if (r6 == 0) goto L_0x008e
        L_0x008d:
            goto L_0x0038
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(int):java.lang.String");
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
        }
        String str = null;
        try {
            str = a(myPid);
        } catch (IOException e2) {
        }
        return str != null ? str : f13541a.getPackageName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r6.equals(r1) != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"
            java.lang.String r1 = ""
            java.lang.String r2 = r6.getPackageName()
            r3 = 101(0x65, float:1.42E-43)
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0053 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x0053 }
            android.os.Bundle r2 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r2 != 0) goto L_0x002d
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r6 = f13544d     // Catch:{ NameNotFoundException -> 0x0053 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ NameNotFoundException -> 0x0053 }
            com.baidu.lbsapi.auth.LBSAuthManagerListener r6 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r6     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r6 == 0) goto L_0x0065
            java.lang.String r2 = "AndroidManifest.xml的application中没有meta-data标签"
            java.lang.String r2 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r2)     // Catch:{ NameNotFoundException -> 0x0053 }
            r6.onAuthResult(r3, r2)     // Catch:{ NameNotFoundException -> 0x0053 }
            goto L_0x0065
        L_0x002d:
            android.os.Bundle r6 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0053 }
            java.lang.String r2 = "com.baidu.lbsapi.API_KEY"
            java.lang.String r6 = r6.getString(r2)     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r6 == 0) goto L_0x003d
            boolean r1 = r6.equals(r1)     // Catch:{ NameNotFoundException -> 0x0050 }
            if (r1 == 0) goto L_0x004e
        L_0x003d:
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r1 = f13544d     // Catch:{ NameNotFoundException -> 0x0050 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ NameNotFoundException -> 0x0050 }
            com.baidu.lbsapi.auth.LBSAuthManagerListener r1 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r1     // Catch:{ NameNotFoundException -> 0x0050 }
            if (r1 == 0) goto L_0x004e
            java.lang.String r2 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r0)     // Catch:{ NameNotFoundException -> 0x0050 }
            r1.onAuthResult(r3, r2)     // Catch:{ NameNotFoundException -> 0x0050 }
        L_0x004e:
            r1 = r6
            goto L_0x0065
        L_0x0050:
            r1 = move-exception
            r1 = r6
            goto L_0x0054
        L_0x0053:
            r6 = move-exception
        L_0x0054:
            java.util.Hashtable<java.lang.String, com.baidu.lbsapi.auth.LBSAuthManagerListener> r6 = f13544d
            java.lang.Object r6 = r6.get(r7)
            com.baidu.lbsapi.auth.LBSAuthManagerListener r6 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r6
            if (r6 == 0) goto L_0x0065
            java.lang.String r7 = com.baidu.lbsapi.auth.ErrorMessage.a(r3, r0)
            r6.onAuthResult(r3, r7)
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        m mVar;
        if (str == null) {
            str = e();
        }
        Message obtainMessage = this.f13549i.obtainMessage();
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has("current")) {
                jSONObject.put("current", System.currentTimeMillis());
            }
            c(jSONObject.toString());
            if (jSONObject.has("current")) {
                jSONObject.remove("current");
            }
            i2 = jSONObject.getInt("status");
            obtainMessage.what = i2;
            obtainMessage.obj = jSONObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.f13549i.sendMessage(obtainMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
            obtainMessage.what = i2;
            obtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            obtainMessage.setData(bundle2);
            this.f13549i.sendMessage(obtainMessage);
        }
        m mVar2 = f13542b;
        if (mVar2 != null) {
            mVar2.a();
        }
        f13543c--;
        a.a("httpRequest called mAuthCounter-- = " + f13543c);
        if (f13543c == 0 && (mVar = f13542b) != null) {
            mVar.c();
            f13542b = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String str2) {
        String str3;
        String str4;
        String a2 = a(f13541a, str2);
        if (a2 != null && !a2.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            a.a("url:https://api.map.baidu.com/sdkcs/verify");
            hashMap.put(BindingXConstants.KEY_INTERPOLATER_OUTPUT, "json");
            hashMap.put("ak", a2);
            a.a("ak:" + a2);
            hashMap.put("mcode", b.a(f13541a));
            hashMap.put("from", "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Map.Entry next : hashtable.entrySet()) {
                    String str5 = (String) next.getKey();
                    String str6 = (String) next.getValue();
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        hashMap.put(str5, str6);
                    }
                }
            }
            try {
                str3 = CommonParam.getCUID(f13541a);
            } catch (Exception e2) {
                a.a("get cuid failed");
                e2.printStackTrace();
                str3 = "";
            }
            a.a("cuid:" + str3);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("cuid", str3);
            } else {
                hashMap.put("cuid", "");
            }
            hashMap.put("pcn", f13541a.getPackageName());
            hashMap.put("version", VERSION);
            hashMap.put("macaddr", "");
            try {
                str4 = b.a();
            } catch (Exception e3) {
                str4 = "";
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("language", str4);
            } else {
                hashMap.put("language", "");
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str == null) {
                hashMap.put("from_service", "");
            } else {
                hashMap.put("from_service", str);
            }
            d dVar = new d(f13541a);
            this.f13546f = dVar;
            dVar.a((HashMap<String, String>) hashMap, (d.a<String>) new k(this, str2));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2) {
        String str3;
        String str4;
        String a2 = a(f13541a, str2);
        if (a2 != null && !a2.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            hashMap.put(BindingXConstants.KEY_INTERPOLATER_OUTPUT, "json");
            hashMap.put("ak", a2);
            hashMap.put("from", "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Map.Entry next : hashtable.entrySet()) {
                    String str5 = (String) next.getKey();
                    String str6 = (String) next.getValue();
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        hashMap.put(str5, str6);
                    }
                }
            }
            try {
                str3 = CommonParam.getCUID(f13541a);
            } catch (Exception e2) {
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("cuid", str3);
            } else {
                hashMap.put("cuid", "");
            }
            hashMap.put("pcn", f13541a.getPackageName());
            hashMap.put("version", VERSION);
            hashMap.put("macaddr", "");
            try {
                str4 = b.a();
            } catch (Exception e3) {
                str4 = "";
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("language", str4);
            } else {
                hashMap.put("language", "");
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str == null) {
                hashMap.put("from_service", "");
            } else {
                hashMap.put("from_service", str);
            }
            f fVar = new f(f13541a);
            this.f13547g = fVar;
            fVar.a(hashMap, strArr, new l(this, str2));
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        String str2;
        String a2 = a(f13541a, str);
        try {
            JSONObject jSONObject = new JSONObject(e());
            if (!jSONObject.has("ak")) {
                return true;
            }
            str2 = jSONObject.getString("ak");
            return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            str2 = "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r0.format(java.lang.Long.valueOf(r7)).equals(r0.format(java.lang.Long.valueOf(r5))) == false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "status"
            java.lang.String r1 = "current"
            r2 = 601(0x259, float:8.42E-43)
            r3 = -1
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r4.<init>(r14)     // Catch:{ JSONException -> 0x0083 }
            boolean r14 = r4.has(r0)     // Catch:{ JSONException -> 0x0083 }
            if (r14 != 0) goto L_0x0016
            r4.put(r0, r3)     // Catch:{ JSONException -> 0x0083 }
        L_0x0016:
            int r14 = r4.getInt(r0)     // Catch:{ JSONException -> 0x0083 }
            boolean r0 = r4.has(r1)     // Catch:{ JSONException -> 0x0080 }
            if (r0 == 0) goto L_0x005d
            if (r14 != 0) goto L_0x005d
            long r5 = r4.getLong(r1)     // Catch:{ JSONException -> 0x0080 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0080 }
            long r9 = r7 - r5
            double r9 = (double) r9     // Catch:{ JSONException -> 0x0080 }
            r11 = 4704985352480227328(0x414b774000000000, double:3600000.0)
            double r9 = r9 / r11
            r11 = 4627448617123184640(0x4038000000000000, double:24.0)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x003a
            goto L_0x005c
        L_0x003a:
            boolean r0 = r13.f13548h     // Catch:{ JSONException -> 0x0080 }
            if (r0 == 0) goto L_0x005d
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x0080 }
            java.lang.String r3 = "yyyy-MM-dd"
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0080 }
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ JSONException -> 0x0080 }
            java.lang.String r3 = r0.format(r3)     // Catch:{ JSONException -> 0x0080 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ JSONException -> 0x0080 }
            java.lang.String r0 = r0.format(r5)     // Catch:{ JSONException -> 0x0080 }
            boolean r0 = r3.equals(r0)     // Catch:{ JSONException -> 0x0080 }
            if (r0 != 0) goto L_0x005d
        L_0x005c:
            r14 = r2
        L_0x005d:
            boolean r0 = r4.has(r1)     // Catch:{ JSONException -> 0x0080 }
            if (r0 == 0) goto L_0x007e
            r0 = 602(0x25a, float:8.44E-43)
            if (r14 != r0) goto L_0x007e
            long r0 = r4.getLong(r1)     // Catch:{ JSONException -> 0x0080 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0080 }
            long r3 = r3 - r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r0
            double r0 = (double) r3
            r3 = 4640537203540230144(0x4066800000000000, double:180.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007e
            goto L_0x0089
        L_0x007e:
            r2 = r14
            goto L_0x0089
        L_0x0080:
            r0 = move-exception
            r2 = r14
            goto L_0x0086
        L_0x0083:
            r14 = move-exception
            r0 = r14
            r2 = r3
        L_0x0086:
            r0.printStackTrace()
        L_0x0089:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.b(java.lang.String):int");
    }

    private void c(String str) {
        f13541a.getSharedPreferences("authStatus_" + a(f13541a), 0).edit().putString("status", str).commit();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (f13542b == null) {
                m mVar = new m("auth");
                f13542b = mVar;
                mVar.start();
                while (f13542b.f13576a == null) {
                    try {
                        a.a("wait for create auth thread.");
                        Thread.sleep(3);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String e() {
        return f13541a.getSharedPreferences("authStatus_" + a(f13541a), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (f13545e == null) {
            synchronized (LBSAuthManager.class) {
                if (f13545e == null) {
                    f13545e = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            f13541a = context;
        } else if (a.f13550a) {
            a.b("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return f13545e;
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            boolean z2 = false;
            if (hashtable != null) {
                String str2 = hashtable.get("zero_auth");
                if (str2 != null) {
                    if (Integer.valueOf(str2).intValue() == 1) {
                        z2 = true;
                    }
                }
            }
            this.f13548h = z2;
            String str3 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f13544d.put(str3, lBSAuthManagerListener);
            }
            String a2 = a(f13541a, str3);
            if (a2 != null) {
                if (!a2.equals("")) {
                    f13543c++;
                    a.a(" mAuthCounter  ++ = " + f13543c);
                    String e2 = e();
                    a.a("getAuthMessage from cache:" + e2);
                    int b2 = b(e2);
                    if (b2 == 601) {
                        try {
                            c(new JSONObject().put("status", 602).toString());
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    d();
                    m mVar = f13542b;
                    if (mVar != null) {
                        if (mVar.f13576a != null) {
                            a.a("mThreadLooper.mHandler = " + f13542b.f13576a);
                            f13542b.f13576a.post(new j(this, b2, z, str3, str, hashtable));
                            return b2;
                        }
                    }
                    return -1;
                }
            }
            return 101;
        }
    }

    public String getCUID() {
        Context context = f13541a;
        if (context == null) {
            return "";
        }
        try {
            return CommonParam.getCUID(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getKey() {
        Context context = f13541a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f13541a;
        return context == null ? "" : b.a(context);
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
