package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.sapi2.utils.SapiUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static final boolean a = (ApollonConstants.DEBUG & false);
    public static final String b = "JsJavaBridge";
    public static final String c = "BdWallet:";
    public static final String d = c.toLowerCase();
    public static final int e = 0;
    public static final int f = 101;
    public static final int g = 102;
    public static final int h = 100;

    /* renamed from: i  reason: collision with root package name */
    public static final String f727i = "Local";
    public final HashMap<String, Object> j = new HashMap<>();
    public final HashMap<String, Set<String>> k = new HashMap<>();
    public boolean l = false;
    public String m;
    public final Map<String, String> n = new HashMap();

    public void a(Object obj, String str) {
        if (a) {
            "addJavascriptInterface to map: <" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + ">";
        }
        if (obj != null && !TextUtils.isEmpty(str)) {
            this.j.put(str, obj);
            this.m = null;
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n.remove(str);
        }
    }

    public void c() {
        this.j.clear();
        this.m = null;
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (Method name : Object.class.getMethods()) {
            if (str.equals(name.getName())) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        if (!this.l && !TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function JsAddJavascriptInterface_(){");
        for (String next : this.j.keySet()) {
            try {
                a(sb, this.j.get(next), next);
            } catch (JSONException unused) {
                boolean z = a;
            }
        }
        for (String next2 : this.n.values()) {
            if (!TextUtils.isEmpty(next2)) {
                sb.append(next2);
            }
        }
        this.l = false;
        if (a) {
            sb.append("console.log('addJavascript done!');");
        }
        sb.append("}");
        sb.append(")()");
        this.m = sb.toString();
        if (a) {
            "getImpactedJsString : " + this.m;
        }
        return this.m;
    }

    public void a(String str) {
        this.j.remove(str);
        this.m = null;
        if (a) {
            "removeJavascriptInterface from map: " + str;
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.l = true;
            this.n.put(str, str2);
        }
    }

    public void a() {
        this.n.clear();
    }

    public boolean a(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        boolean z;
        String str4;
        if (a) {
            "handle url: " + str;
            "handle msg: " + str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(c)) {
            str4 = str2.substring(9);
            z = true;
        } else if (!str2.startsWith(c.toLowerCase())) {
            return false;
        } else {
            str4 = str2.substring(9);
            z = false;
        }
        try {
            JavaBridgeObject javaBridgeObject = (JavaBridgeObject) JsonUtils.fromJson(str4, JavaBridgeObject.class);
            if (a && javaBridgeObject != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(javaBridgeObject.obj);
                sb.append(IStringUtil.CURRENT_PATH);
                sb.append(javaBridgeObject.func);
                sb.append("(");
                if (javaBridgeObject.args.length > 0) {
                    sb.append("\"");
                    sb.append(javaBridgeObject.args[0]);
                    sb.append("\"");
                    for (int i2 = 1; i2 < javaBridgeObject.args.length; i2++) {
                        sb.append(",\"");
                        sb.append(javaBridgeObject.args[i2]);
                        sb.append("\"");
                    }
                }
                sb.append(")");
                LogUtil.i(b, "call: " + sb.toString());
            }
            if (javaBridgeObject != null) {
                return a(jsPromptResult, z, javaBridgeObject);
            }
            return true;
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
            jsPromptResult.cancel();
            return true;
        }
    }

    private boolean b(String str, String str2) {
        HashMap<String, Set<String>> hashMap;
        Set set;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashMap = this.k) == null || hashMap.size() < 1 || (set = this.k.get(str)) == null) {
            return false;
        }
        return set.contains(str2);
    }

    @SuppressLint({"NewApi"})
    private void a(StringBuilder sb, Object obj, String str) throws JSONException {
        if (sb != null && obj != null && !TextUtils.isEmpty(str)) {
            Class<?> cls = obj.getClass();
            if (a) {
                sb.append("if(typeof(window." + str + ")!='undefined'){");
                sb.append("console.log('window." + str + " is exist!!');}else{");
            } else {
                sb.append("if(typeof(window." + str + ")=='undefined'){");
            }
            sb.append("window.");
            sb.append(str);
            sb.append("={");
            Method[] methods = cls.getMethods();
            HashSet hashSet = new HashSet();
            for (Method method : methods) {
                String name = method.getName();
                if (!name.endsWith(f727i) && !c(name) && !hashSet.contains(name)) {
                    hashSet.add(name);
                    sb.append(name);
                    sb.append(":function(){");
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("return ");
                    }
                    sb.append("prompt('");
                    sb.append(d);
                    sb.append("'+");
                    sb.append("JSON.stringify({");
                    sb.append(IconCompat.EXTRA_OBJ);
                    sb.append(":'");
                    sb.append(str);
                    sb.append("',");
                    sb.append("func");
                    sb.append(":'");
                    sb.append(name);
                    sb.append("',");
                    sb.append("args");
                    sb.append(":Array.prototype.slice.call(arguments)");
                    sb.append("})");
                    sb.append(");");
                    sb.append("},");
                }
            }
            this.k.put(str, hashSet);
            int length = sb.length() - 1;
            if (sb.charAt(length) == ',') {
                sb.deleteCharAt(length);
            }
            sb.append("};");
            sb.append("}");
        } else if (a) {
            "script=" + sb;
            "obj=" + obj + ", interfaceName=" + str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1 A[Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f4 A[Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc A[Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010e A[Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0116 A[Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0154  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.webkit.JsPromptResult r10, boolean r11, com.baidu.apollon.webmanager.JavaBridgeObject r12) {
        /*
            r9 = this;
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r9.j
            java.lang.String r1 = r12.obj
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r1 = "interface:"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x004a
            boolean r0 = a
            if (r0 == 0) goto L_0x0024
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "not exist js interface:"
            r0.append(r4)
            java.lang.String r4 = r12.obj
            r0.append(r4)
            r0.toString()
        L_0x0024:
            if (r11 == 0) goto L_0x0046
            r11 = 101(0x65, float:1.42E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r12 = r12.obj
            r0.append(r12)
            java.lang.String r12 = " not found!"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.String r11 = r9.a((int) r11, (java.lang.String) r12, (java.lang.String) r2)
            r10.confirm(r11)
            goto L_0x0049
        L_0x0046:
            r10.cancel()
        L_0x0049:
            return r3
        L_0x004a:
            java.lang.Object[] r4 = r12.args
            r5 = 0
            if (r4 != 0) goto L_0x008f
            java.lang.String r4 = r12.func
            if (r4 != 0) goto L_0x008f
            boolean r12 = a
            if (r12 == 0) goto L_0x0067
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = "interface query: found for "
            r12.append(r2)
            r12.append(r0)
            r12.toString()
        L_0x0067:
            if (r11 == 0) goto L_0x008b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r11.append(r0)
            java.lang.String r12 = " found!"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            java.lang.String r12 = r12.toString()
            java.lang.String r11 = r9.a((int) r5, (java.lang.String) r11, (java.lang.String) r12)
            r10.confirm(r11)
            goto L_0x008e
        L_0x008b:
            r10.cancel()
        L_0x008e:
            return r3
        L_0x008f:
            java.lang.Object[] r1 = r12.args
            if (r1 == 0) goto L_0x0095
            int r1 = r1.length
            goto L_0x0096
        L_0x0095:
            r1 = 0
        L_0x0096:
            if (r1 <= 0) goto L_0x00c4
            java.lang.Class[] r4 = new java.lang.Class[r1]
            r6 = 0
        L_0x009b:
            if (r6 >= r1) goto L_0x00c5
            java.lang.Object[] r7 = r12.args
            r7 = r7[r6]
            java.lang.Class r7 = r9.a((java.lang.Object) r7)
            r4[r6] = r7
            boolean r7 = a
            if (r7 == 0) goto L_0x00c1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "type:"
            r7.append(r8)
            r8 = r4[r6]
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            r7.toString()
        L_0x00c1:
            int r6 = r6 + 1
            goto L_0x009b
        L_0x00c4:
            r4 = r2
        L_0x00c5:
            java.lang.String r6 = r12.obj     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.String r7 = r12.func     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            boolean r6 = r9.b(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            if (r6 == 0) goto L_0x00e0
            java.lang.Class r6 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.String r7 = r12.func     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.reflect.Method r4 = r6.getMethod(r7, r4)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.Object[] r6 = r12.args     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.Object r0 = r4.invoke(r0, r6)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            goto L_0x00e1
        L_0x00e0:
            r0 = r2
        L_0x00e1:
            if (r0 == 0) goto L_0x00ee
            java.lang.Class r4 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.Class r6 = java.lang.Void.TYPE     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            if (r4 != r6) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r4 = 0
            goto L_0x00ef
        L_0x00ee:
            r4 = 1
        L_0x00ef:
            if (r4 == 0) goto L_0x00f4
            java.lang.String r0 = ""
            goto L_0x00f8
        L_0x00f4:
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
        L_0x00f8:
            boolean r4 = a     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            if (r4 == 0) goto L_0x010c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            r4.<init>()     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            java.lang.String r6 = "called ok: "
            r4.append(r6)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            r4.append(r0)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            r4.toString()     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
        L_0x010c:
            if (r11 == 0) goto L_0x0116
            java.lang.String r0 = r9.a((int) r5, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            r10.confirm(r0)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
            goto L_0x0119
        L_0x0116:
            r10.confirm(r0)     // Catch:{ NoSuchMethodException -> 0x0158, IllegalArgumentException -> 0x012c, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x011a }
        L_0x0119:
            return r3
        L_0x011a:
            r0 = move-exception
            boolean r1 = a
            if (r1 == 0) goto L_0x0135
            r0.printStackTrace()
            return r5
        L_0x0123:
            r0 = move-exception
            boolean r1 = a
            if (r1 == 0) goto L_0x0135
            r0.printStackTrace()
            return r5
        L_0x012c:
            r0 = move-exception
            boolean r1 = a
            if (r1 == 0) goto L_0x0135
            r0.printStackTrace()
            return r5
        L_0x0135:
            if (r11 == 0) goto L_0x0154
            r11 = 100
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = r12.func
            r0.append(r12)
            java.lang.String r12 = " call failed!"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.String r11 = r9.a((int) r11, (java.lang.String) r12, (java.lang.String) r2)
            r10.confirm(r11)
            goto L_0x0157
        L_0x0154:
            r10.cancel()
        L_0x0157:
            return r3
        L_0x0158:
            boolean r0 = a
            if (r0 == 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = r12.func
            r0.<init>(r4)
            java.lang.String r4 = "("
            r0.append(r4)
            if (r1 <= 0) goto L_0x018f
            java.lang.String r4 = "'"
            r0.append(r4)
            java.lang.Object[] r6 = r12.args
            r5 = r6[r5]
            r0.append(r5)
            r0.append(r4)
            r5 = 1
        L_0x017b:
            if (r5 >= r1) goto L_0x018f
            java.lang.String r6 = ",'"
            r0.append(r6)
            java.lang.Object[] r6 = r12.args
            r6 = r6[r5]
            r0.append(r6)
            r0.append(r4)
            int r5 = r5 + 1
            goto L_0x017b
        L_0x018f:
            java.lang.String r1 = ")"
            r0.append(r1)
        L_0x0194:
            if (r11 == 0) goto L_0x01b3
            r11 = 102(0x66, float:1.43E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = r12.func
            r0.append(r12)
            java.lang.String r12 = " not found, check the method name or arguments."
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.String r11 = r9.a((int) r11, (java.lang.String) r12, (java.lang.String) r2)
            r10.confirm(r11)
            goto L_0x01b6
        L_0x01b3:
            r10.cancel()
        L_0x01b6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.webmanager.b.a(android.webkit.JsPromptResult, boolean, com.baidu.apollon.webmanager.JavaBridgeObject):boolean");
    }

    private String a(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SapiUtils.KEY_QR_LOGIN_ERROR, i2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (i2 == 0 && str2 != null) {
                jSONObject.put("result", str2);
            }
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    private Class<?> a(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return String.class;
    }
}
