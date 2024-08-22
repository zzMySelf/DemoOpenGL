package com.baidu.sofire.ac;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sofire.b.b;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.j.a;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.l;
import com.baidu.sofire.l.r;
import com.baidu.sofire.l.s;
import com.baidubce.http.StatusCodes;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FH {
    public static final int INVOKE_METHOD_ERROR_DEFULT = -1;
    public static final int INVOKE_METHOD_ERROR_ILLGEAL_METHOD_NAME = -3;
    public static final int INVOKE_METHOD_ERROR_JSON = -2;
    public static final int INVOKE_METHOD_ERROR_METHOD_NOT_FOUND = -4;
    public static final int INVOKE_METHOD_ERROR_MUTI_METHOD = -5;
    public static final int INVOKE_METHOD_ERROR_PARAM_MISMATCH = -6;
    public static final int INVOKE_METHOD_SUCCESS = 0;
    public static final int TYPE_VERSION = 1;

    public static void bc(Context context, boolean z) {
        String str = d.a;
        if (context != null && s.a(context)) {
            a.a(context).a(z);
        }
    }

    public static boolean call(int i2, String str) {
        return call(i2, str, (Callback) null);
    }

    public static Pair<Integer, Object> callSync(int i2, String str) {
        return callSync(i2, str, (Class<?>[]) null, new Object[0]);
    }

    public static int disableNfcCardReader(Activity activity) {
        if (activity == null) {
            return BaseActivity.EXTRA_PARAM_FROM_CHOICE_SHARE;
        }
        if (c.k(activity.getApplicationContext()) != 1) {
            return 5;
        }
        Pair<Integer, Object> callSync = callSync(SafeService.SOFIRE_MODULE_ID_NFC, "disable", new Class[]{Activity.class}, activity);
        if (((Integer) callSync.first).intValue() == 0) {
            return ((Integer) callSync.second).intValue();
        }
        return ((Integer) callSync.first).intValue();
    }

    public static void enableNfcCardReader(Activity activity, ReadcardCallback readcardCallback, int i2) {
        if (activity == null) {
            readcardCallback.onFailure(1004, "", "");
        } else if (c.k(activity.getApplicationContext()) != 1) {
            readcardCallback.onFailure(5, "", "");
        } else {
            com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a(readcardCallback);
            Pair<Integer, Object> callSync = callSync(SafeService.SOFIRE_MODULE_ID_NFC, "enable", new Class[]{Activity.class, Callback.class, Integer.TYPE}, activity, aVar, Integer.valueOf(i2));
            if (((Integer) callSync.first).intValue() != 0) {
                readcardCallback.onFailure(((Integer) callSync.first).intValue(), "", "");
            }
        }
    }

    public static String gd(Context context) {
        return "";
    }

    public static Pair<Integer, String> gel() {
        String str;
        String str2 = d.a;
        try {
            if (!TextUtils.isEmpty(b.a)) {
                str = Base64.encodeToString(b.a.getBytes(), 0);
            } else {
                str = "";
            }
            return new Pair<>(Integer.valueOf(b.b), str);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return new Pair<>(Integer.valueOf(b.b), "");
        }
    }

    public static Object getPInfo(int i2, int i3) {
        j jVar;
        List<ApkInfo> b;
        try {
            Context context = com.baidu.sofire.b.c.e;
            if (context != null) {
                if (s.a(context)) {
                    if (i3 == 1 && i2 > 0 && (jVar = j.g) != null && (b = jVar.b()) != null) {
                        if (b.size() > 0) {
                            for (ApkInfo next : b) {
                                if (next.key == i2) {
                                    String str = next.versionName;
                                    if (str == null) {
                                        return "";
                                    }
                                    return str;
                                }
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            int i4 = com.baidu.sofire.a.a.a;
            return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.6.7.0";
    }

    public static String got(Context context) {
        return d.b(context);
    }

    public static String gt(Context context, String str, String str2, int i2, String str3) {
        Class<String> cls = String.class;
        String str4 = d.a;
        if (context != null) {
            try {
                if (s.a(context)) {
                    if (TextUtils.isEmpty(str)) {
                        return c.a(context, 8);
                    }
                    int i3 = 2;
                    Pair<Integer, Object> a = d.a(100067, "retrieveToken", (Class<?>[]) new Class[]{cls, cls, Integer.TYPE, cls}, str, str2, Integer.valueOf(i2), str3);
                    if (((Integer) a.first).intValue() == 0) {
                        String str5 = (String) a.second;
                        if (!TextUtils.isEmpty(str5)) {
                            return str5;
                        }
                        return c.a(context, 9);
                    }
                    if (((Integer) a.first).intValue() != 4) {
                        if (((Integer) a.first).intValue() != 3) {
                            if (((Integer) a.first).intValue() == 5 || ((Integer) a.first).intValue() == 11) {
                                return c.a(context, 7);
                            }
                            return c.a(context, 8);
                        }
                    }
                    String[] p = c.p(context);
                    d.a(context, 0, p[0], p[1], 100067);
                    if (((Integer) a.first).intValue() == 3) {
                        i3 = 5;
                    }
                    return c.a(context, i3);
                }
            } catch (Throwable unused) {
                int i4 = com.baidu.sofire.a.a.a;
            }
        }
        return "";
    }

    public static String gz(Context context) {
        return d.c(context);
    }

    public static String gzfi(Context context, String str, int i2, String str2) {
        l.a();
        return d.a(context, str, i2, str2);
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        d.a(context, 0, str, str2, iArr);
    }

    public static void initDelay(Context context, int i2, String str, String str2, int... iArr) {
        d.a(context, i2, str, str2, iArr);
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        Method method;
        Context context2 = context;
        Class<String> cls = String.class;
        if (context2 == null) {
            try {
                return new Pair<>(-1, "");
            } catch (IllegalArgumentException unused) {
                int i2 = com.baidu.sofire.a.a.a;
                return new Pair<>(-6, "");
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.a.a;
                return new Pair<>(-1, "");
            }
        } else if (!s.a(context)) {
            return new Pair<>(12, "");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("f");
                if (!TextUtils.isEmpty(optString) && !"init".equals(optString) && !"initDelay".equals(optString)) {
                    if (!NotificationCompat.CATEGORY_CALL.equals(optString)) {
                        Class<FH> cls2 = FH.class;
                        JSONArray optJSONArray = jSONObject.optJSONArray("p");
                        if (optString.equals("callSync")) {
                            if (com.baidu.sofire.b.c.e == null) {
                                com.baidu.sofire.b.c.e = context.getApplicationContext();
                            }
                            if (optJSONArray != null && optJSONArray.length() == 2) {
                                method = cls2.getMethod("callSync", new Class[]{Integer.TYPE, cls});
                            } else if (optJSONArray != null && optJSONArray.length() < 2) {
                                return new Pair<>(-6, "");
                            } else {
                                method = cls2.getMethod("callSync", new Class[]{Integer.TYPE, cls, Class[].class, Object[].class});
                            }
                        } else if (!optString.equals("gzfi")) {
                            Method method2 = null;
                            int i4 = 0;
                            for (Method method3 : cls2.getMethods()) {
                                if (optString.equals(method3.getName())) {
                                    if (method2 == null) {
                                        method2 = method3;
                                    }
                                    i4++;
                                }
                            }
                            if (i4 > 0) {
                                if (method2 != null) {
                                    if (i4 >= 2) {
                                        return new Pair<>(-5, "");
                                    }
                                    method = method2;
                                }
                            }
                            return new Pair<>(-4, "");
                        } else if (optJSONArray != null && optJSONArray.length() == 2) {
                            method = cls2.getMethod("gzfi", new Class[]{Context.class, cls, Integer.TYPE});
                        } else if (optJSONArray == null || optJSONArray.length() != 3) {
                            return new Pair<>(-6, "");
                        } else {
                            method = cls2.getMethod("gzfi", new Class[]{Context.class, cls, Integer.TYPE, cls});
                        }
                        Object[] parseParams = parseParams(optString, context2, optJSONArray, 0, method.getParameterTypes());
                        if ("callSync".equals(optString)) {
                            Pair pair = (Pair) method.invoke((Object) null, parseParams);
                            if (((Integer) pair.first).intValue() != 0) {
                                return new Pair<>(pair.first, "");
                            }
                            Object obj = pair.second;
                            if (obj == null) {
                                return new Pair<>(0, "");
                            }
                            return new Pair<>(0, obj.toString());
                        }
                        Object invoke = method.invoke((Object) null, parseParams);
                        if (invoke == null) {
                            return new Pair<>(0, "");
                        }
                        return new Pair<>(0, invoke.toString());
                    }
                }
                return new Pair<>(-3, "");
            } catch (Throwable unused3) {
                int i5 = com.baidu.sofire.a.a.a;
                return new Pair<>(-2, "");
            }
        }
    }

    public static boolean isInitSuc(int i2) {
        Context context = com.baidu.sofire.b.c.e;
        if (context == null || !s.a(context)) {
            return false;
        }
        return c.b(i2);
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
            return true;
        }
        if ("F".equals(str)) {
            return false;
        }
        throw new IllegalArgumentException("parse boolean fail:" + str);
    }

    public static byte parseByte(String str) throws IllegalArgumentException {
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue <= 127 && intValue >= -128) {
                return (byte) intValue;
            }
            throw new IllegalArgumentException("parse byte fail");
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse byte fail:" + str);
        }
    }

    public static char parseChar(String str) throws IllegalArgumentException {
        try {
            if (str.length() == 1) {
                return str.charAt(0);
            }
            throw new IllegalArgumentException("parse char fail");
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse char fail:" + str);
        }
    }

    public static Class[] parseClassArray(String str) throws IllegalArgumentException {
        try {
            int length = str.length();
            Class[] clsArr = new Class[length];
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == 'F') {
                    clsArr[i2] = Float.TYPE;
                } else if (charAt == 'Z') {
                    clsArr[i2] = Boolean.TYPE;
                } else if (charAt == 'I') {
                    clsArr[i2] = Integer.TYPE;
                } else if (charAt == 'J') {
                    clsArr[i2] = Long.TYPE;
                } else if (charAt == 'S') {
                    clsArr[i2] = Short.TYPE;
                } else if (charAt != 'T') {
                    switch (charAt) {
                        case 'B':
                            clsArr[i2] = Byte.TYPE;
                            break;
                        case 'C':
                            clsArr[i2] = Character.TYPE;
                            break;
                        case 'D':
                            clsArr[i2] = Double.TYPE;
                            break;
                        default:
                            throw new IllegalArgumentException("parse classArray fail");
                    }
                } else {
                    clsArr[i2] = String.class;
                }
            }
            return clsArr;
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse classArray fail:" + str);
        }
    }

    public static double parseDouble(String str) throws IllegalArgumentException {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse double fail:" + str);
        }
    }

    public static float parseFloat(String str) throws IllegalArgumentException {
        try {
            return Float.valueOf(str).floatValue();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse float fail:" + str);
        }
    }

    public static int parseInt(String str) throws IllegalArgumentException {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse int fail:" + str);
        }
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse long fail:" + str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018 A[Catch:{ all -> 0x01f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object[] parseParams(java.lang.String r9, android.content.Context r10, org.json.JSONArray r11, int r12, java.lang.Class[] r13) throws java.lang.IllegalArgumentException {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "callSync"
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x01f7 }
            r1 = 0
            if (r13 == 0) goto L_0x0011
            int r2 = r13.length     // Catch:{ all -> 0x01f7 }
            if (r2 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            int r2 = r13.length     // Catch:{ all -> 0x01f7 }
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x01f7 }
            r4 = 0
            r5 = r4
        L_0x0016:
            if (r1 >= r2) goto L_0x01f6
            if (r13 == 0) goto L_0x01ee
            r6 = r13[r1]     // Catch:{ all -> 0x01f7 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x01f7 }
            if (r7 == 0) goto L_0x003a
            if (r10 == 0) goto L_0x002a
            r3[r1] = r10     // Catch:{ all -> 0x01f7 }
            goto L_0x01da
        L_0x002a:
            android.content.Context r6 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x01f7 }
            if (r6 == 0) goto L_0x0032
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01da
        L_0x0032:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "method request context"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x003a:
            if (r11 == 0) goto L_0x01e6
            java.lang.String r7 = r11.optString(r12)     // Catch:{ all -> 0x01f7 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x01c8
            java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x0052
            goto L_0x01c8
        L_0x0052:
            java.lang.Class r8 = java.lang.Byte.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x01af
            java.lang.Class<java.lang.Byte> r8 = java.lang.Byte.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x0064
            goto L_0x01af
        L_0x0064:
            java.lang.Class r8 = java.lang.Character.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x0086
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x007e
            char r6 = parseChar(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Character r6 = java.lang.Character.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x007e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "char not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x0086:
            java.lang.Class r8 = java.lang.Short.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x0196
            java.lang.Class<java.lang.Short> r8 = java.lang.Short.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x0098
            goto L_0x0196
        L_0x0098:
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x017d
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x00aa
            goto L_0x017d
        L_0x00aa:
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x0164
            java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x00bc
            goto L_0x0164
        L_0x00bc:
            java.lang.Class r8 = java.lang.Float.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x014a
            java.lang.Class<java.lang.Float> r8 = java.lang.Float.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x00ce
            goto L_0x014a
        L_0x00ce:
            java.lang.Class r8 = java.lang.Double.TYPE     // Catch:{ all -> 0x01f7 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 != 0) goto L_0x0130
            java.lang.Class<java.lang.Double> r8 = java.lang.Double.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x00df
            goto L_0x0130
        L_0x00df:
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x00eb
            r3[r1] = r7     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x00eb:
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x01f7 }
            if (r8 == 0) goto L_0x0110
            if (r9 == 0) goto L_0x0108
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r5 == 0) goto L_0x0100
            r3[r1] = r4     // Catch:{ all -> 0x01f7 }
            r5 = r4
            goto L_0x01d8
        L_0x0100:
            java.lang.Class[] r5 = parseClassArray(r7)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r5     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x0108:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "only callSync support Class[]"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x0110:
            java.lang.Class<java.lang.Object[]> r7 = java.lang.Object[].class
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 == 0) goto L_0x01da
            if (r9 == 0) goto L_0x0128
            if (r5 != 0) goto L_0x0120
            r3[r1] = r4     // Catch:{ all -> 0x01f7 }
            goto L_0x01da
        L_0x0120:
            java.lang.Object[] r6 = parseParams(r0, r10, r11, r12, r5)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01da
        L_0x0128:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "only callSync support Object[]"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x0130:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x0142
            double r6 = parseDouble(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x0142:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "double not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x014a:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x015c
            float r6 = parseFloat(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x015c:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "float not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x0164:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x0175
            long r6 = parseLong(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x0175:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "long not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x017d:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x018e
            int r6 = parseInt(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x018e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "int not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x0196:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x01a7
            short r6 = parseShort(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Short r6 = java.lang.Short.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x01a7:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "short not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x01af:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x01c0
            byte r6 = parseByte(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
            goto L_0x01d8
        L_0x01c0:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "byte not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x01c8:
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x01f7 }
            if (r6 != 0) goto L_0x01de
            boolean r6 = parseBoolean(r7)     // Catch:{ all -> 0x01f7 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x01f7 }
            r3[r1] = r6     // Catch:{ all -> 0x01f7 }
        L_0x01d8:
            int r12 = r12 + 1
        L_0x01da:
            int r1 = r1 + 1
            goto L_0x0016
        L_0x01de:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "boolean not support null String"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x01e6:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "request params but get null"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x01ee:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f7 }
            java.lang.String r10 = "parameterTypes null"
            r9.<init>(r10)     // Catch:{ all -> 0x01f7 }
            throw r9     // Catch:{ all -> 0x01f7 }
        L_0x01f6:
            return r3
        L_0x01f7:
            r9 = move-exception
            int r10 = com.baidu.sofire.a.a.a
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            java.lang.String r9 = r9.getMessage()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.FH.parseParams(java.lang.String, android.content.Context, org.json.JSONArray, int, java.lang.Class[]):java.lang.Object[]");
    }

    public static short parseShort(String str) throws IllegalArgumentException {
        try {
            return Short.valueOf(str).shortValue();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            throw new IllegalArgumentException("parse short fail:" + str);
        }
    }

    public static void setAgreePolicy(Context context, boolean z) {
        d.a(context, z);
    }

    public static void setDeviceInfoCallback(DeviceInfoCallback deviceInfoCallback) {
        r.a = deviceInfoCallback;
    }

    public static void setDid(Context context, String str) {
        String str2 = d.a;
        if (context != null) {
            try {
                if (s.a(context)) {
                    a a = a.a(context);
                    a.d.putString("s_h_d_id", str);
                    if (Build.VERSION.SDK_INT >= 9) {
                        a.d.apply();
                    } else {
                        a.d.commit();
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public static void tryLoadModule(Context context, BDModuleLoadCallback bDModuleLoadCallback, int i2) {
        d.a(context, i2, bDModuleLoadCallback, true);
    }

    public static String xgz(Context context, String str) {
        int i2;
        String str2 = d.a;
        if (context == null) {
            return "";
        }
        try {
            if (!s.a(context)) {
                return "";
            }
            if (!TextUtils.isEmpty(str) && str.contains("enoketnco")) {
                return d.b(context);
            }
            Pair<Integer, Object> b = d.b(1, "xgz", (Class<?>[]) new Class[]{String.class}, str);
            if (((Integer) b.first).intValue() == 0 && !TextUtils.isEmpty((String) b.second)) {
                return (String) b.second;
            }
            i2 = ((Integer) b.first).intValue() == 0 ? StatusCodes.BAD_GATEWAY : ((Integer) b.first).intValue();
            try {
                return new JSONObject().put("rc", i2).put("z", d.c(context)).toString();
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.a.a;
                return "";
            }
        } catch (Throwable unused2) {
            int i4 = com.baidu.sofire.a.a.a;
            i2 = IMPushPb.ActionType.REQUEST_VALUE;
        }
    }

    public static boolean call(int i2, String str, Callback callback) {
        return call(i2, str, callback, (Class<?>[]) null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return d.a(i2, str, clsArr, objArr);
    }

    public static void init(Context context, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i2) {
        d.a(context, 0, str, str2, bDModuleLoadCallback, i2);
    }

    public static void initDelay(Context context, int i2, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i3) {
        d.a(context, i2, str, str2, bDModuleLoadCallback, i3);
    }

    public static boolean call(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i2, str, (Callback) null, clsArr, objArr);
    }

    public static String gzfi(Context context, String str, int i2) {
        l.a();
        return d.a(context, str, i2, (String) null);
    }

    public static boolean call(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return d.a(i2, str, callback, clsArr, objArr);
    }

    public static void enableNfcCardReader(Activity activity, ReadcardCallback readcardCallback) {
        enableNfcCardReader(activity, readcardCallback, 3);
    }
}
