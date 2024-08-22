package fe.i.qw.yj;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.webmanager.b;
import com.baidu.sapi2.utils.SapiUtils;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.webmanager.JavaBridgeObject;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: th  reason: collision with root package name */
    public static final boolean f4503th = (ApollonConstants.DEBUG & false);

    /* renamed from: yj  reason: collision with root package name */
    public static final String f4504yj = b.c.toLowerCase();

    /* renamed from: ad  reason: collision with root package name */
    public final HashMap<String, Set<String>> f4505ad = new HashMap<>();

    /* renamed from: de  reason: collision with root package name */
    public boolean f4506de = false;

    /* renamed from: fe  reason: collision with root package name */
    public String f4507fe;
    public final HashMap<String, Object> qw = new HashMap<>();

    /* renamed from: rg  reason: collision with root package name */
    public final Map<String, String> f4508rg = new HashMap();

    public final String ad(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SapiUtils.KEY_QR_LOGIN_ERROR, i2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (i2 == 0 && str2 != null) {
                jSONObject.put("result", str2);
            }
        } catch (JSONException e) {
            LogUtil.e(b.b, e.getMessage(), e);
        }
        return jSONObject.toString();
    }

    public void de() {
        this.f4508rg.clear();
    }

    public void fe(Object obj, String str) {
        LogUtil.i(b.b, "addJavascriptInterface to map: <" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + ">");
        if (obj != null && !TextUtils.isEmpty(str)) {
            this.qw.put(str, obj);
            this.f4507fe = null;
        }
    }

    public boolean i(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        boolean z;
        String str4;
        LogUtil.i(b.b, "handle url: " + str);
        LogUtil.i(b.b, "handle msg: " + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(b.c)) {
            str4 = str2.substring(9);
            z = true;
        } else if (!str2.startsWith(b.c.toLowerCase())) {
            return false;
        } else {
            str4 = str2.substring(9);
            z = false;
        }
        try {
            JavaBridgeObject javaBridgeObject = (JavaBridgeObject) JsonUtils.fromJson(str4, JavaBridgeObject.class);
            if (f4503th && javaBridgeObject != null) {
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
                LogUtil.i(b.b, "call: " + sb.toString());
            }
            if (javaBridgeObject != null) {
                return uk(jsPromptResult, z, javaBridgeObject);
            }
            return true;
        } catch (JSONException e) {
            LogUtil.e(b.b, e.getMessage(), e);
            jsPromptResult.cancel();
            return true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m285if(String str, String str2) {
        HashMap<String, Set<String>> hashMap;
        Set set;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashMap = this.f4505ad) == null || hashMap.size() < 1 || (set = this.f4505ad.get(str)) == null) {
            return false;
        }
        return set.contains(str2);
    }

    public String o() {
        if (!this.f4506de && !TextUtils.isEmpty(this.f4507fe)) {
            return this.f4507fe;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function JsAddJavascriptInterface_(){");
        for (String next : this.qw.keySet()) {
            try {
                yj(sb, this.qw.get(next), next);
            } catch (JSONException e) {
                LogUtil.e(b.b, "", e);
            }
        }
        for (String next2 : this.f4508rg.values()) {
            if (!TextUtils.isEmpty(next2)) {
                sb.append(next2);
            }
        }
        this.f4506de = false;
        if (f4503th) {
            sb.append("console.log('addJavascript done!');");
        }
        sb.append("}");
        sb.append(")()");
        this.f4507fe = sb.toString();
        LogUtil.i(b.b, "getImpactedJsString : " + this.f4507fe);
        return this.f4507fe;
    }

    public void pf(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f4508rg.remove(str);
        }
    }

    public final Class<?> qw(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return String.class;
    }

    public void rg(String str) {
        this.qw.remove(str);
        this.f4507fe = null;
        LogUtil.i(b.b, "removeJavascriptInterface from map: " + str);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m286switch() {
        this.qw.clear();
        this.f4507fe = null;
    }

    public void th(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f4506de = true;
            this.f4508rg.put(str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3 A[Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f6 A[Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0110 A[Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0118 A[Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0162  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean uk(android.webkit.JsPromptResult r11, boolean r12, com.dxmpay.apollon.webmanager.JavaBridgeObject r13) {
        /*
            r10 = this;
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r10.qw
            java.lang.String r1 = r13.obj
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r1 = "interface:"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x004a
            boolean r0 = f4503th
            if (r0 == 0) goto L_0x0024
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "not exist js interface:"
            r0.append(r4)
            java.lang.String r4 = r13.obj
            r0.append(r4)
            r0.toString()
        L_0x0024:
            if (r12 == 0) goto L_0x0046
            r12 = 101(0x65, float:1.42E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r13 = r13.obj
            r0.append(r13)
            java.lang.String r13 = " not found!"
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r12 = r10.ad(r12, r13, r2)
            r11.confirm(r12)
            goto L_0x0049
        L_0x0046:
            r11.cancel()
        L_0x0049:
            return r3
        L_0x004a:
            java.lang.Object[] r4 = r13.args
            java.lang.String r5 = "JsJavaBridge"
            r6 = 0
            if (r4 != 0) goto L_0x0091
            java.lang.String r4 = r13.func
            if (r4 != 0) goto L_0x0091
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "interface query: found for "
            r13.append(r2)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r5, r13)
            if (r12 == 0) goto L_0x008d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r1)
            r12.append(r0)
            java.lang.String r13 = " found!"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            java.lang.String r13 = r13.toString()
            java.lang.String r12 = r10.ad(r6, r12, r13)
            r11.confirm(r12)
            goto L_0x0090
        L_0x008d:
            r11.cancel()
        L_0x0090:
            return r3
        L_0x0091:
            java.lang.Object[] r1 = r13.args
            if (r1 == 0) goto L_0x0097
            int r1 = r1.length
            goto L_0x0098
        L_0x0097:
            r1 = 0
        L_0x0098:
            if (r1 <= 0) goto L_0x00c6
            java.lang.Class[] r4 = new java.lang.Class[r1]
            r7 = 0
        L_0x009d:
            if (r7 >= r1) goto L_0x00c7
            java.lang.Object[] r8 = r13.args
            r8 = r8[r7]
            java.lang.Class r8 = r10.qw(r8)
            r4[r7] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "type:"
            r8.append(r9)
            r9 = r4[r7]
            java.lang.String r9 = r9.getName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r5, r8)
            int r7 = r7 + 1
            goto L_0x009d
        L_0x00c6:
            r4 = r2
        L_0x00c7:
            java.lang.String r7 = r13.obj     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.String r8 = r13.func     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            boolean r7 = r10.m285if(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            if (r7 == 0) goto L_0x00e2
            java.lang.Class r7 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.String r8 = r13.func     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.reflect.Method r4 = r7.getMethod(r8, r4)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.Object[] r7 = r13.args     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.Object r0 = r4.invoke(r0, r7)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            goto L_0x00e3
        L_0x00e2:
            r0 = r2
        L_0x00e3:
            if (r0 == 0) goto L_0x00f0
            java.lang.Class r4 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            if (r4 != r7) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r4 = 0
            goto L_0x00f1
        L_0x00f0:
            r4 = 1
        L_0x00f1:
            if (r4 == 0) goto L_0x00f6
            java.lang.String r0 = ""
            goto L_0x00fa
        L_0x00f6:
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
        L_0x00fa:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            r4.<init>()     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.String r7 = "called ok: "
            r4.append(r7)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            r4.append(r0)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            java.lang.String r4 = r4.toString()     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            com.dxmpay.apollon.utils.LogUtil.i(r5, r4)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            if (r12 == 0) goto L_0x0118
            java.lang.String r0 = r10.ad(r6, r2, r0)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            r11.confirm(r0)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
            goto L_0x011b
        L_0x0118:
            r11.confirm(r0)     // Catch:{ NoSuchMethodException -> 0x0166, IllegalArgumentException -> 0x0136, IllegalAccessException -> 0x0129, InvocationTargetException -> 0x011c }
        L_0x011b:
            return r3
        L_0x011c:
            r0 = move-exception
            boolean r1 = f4503th
            if (r1 == 0) goto L_0x0143
            java.lang.String r11 = r0.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r5, r11, r0)
            return r6
        L_0x0129:
            r0 = move-exception
            boolean r1 = f4503th
            if (r1 == 0) goto L_0x0143
            java.lang.String r11 = r0.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r5, r11, r0)
            return r6
        L_0x0136:
            r0 = move-exception
            boolean r1 = f4503th
            if (r1 == 0) goto L_0x0143
            java.lang.String r11 = r0.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r5, r11, r0)
            return r6
        L_0x0143:
            if (r12 == 0) goto L_0x0162
            r12 = 100
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = r13.func
            r0.append(r13)
            java.lang.String r13 = " call failed!"
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r12 = r10.ad(r12, r13, r2)
            r11.confirm(r12)
            goto L_0x0165
        L_0x0162:
            r11.cancel()
        L_0x0165:
            return r3
        L_0x0166:
            boolean r0 = f4503th
            if (r0 == 0) goto L_0x01a2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = r13.func
            r0.<init>(r4)
            java.lang.String r4 = "("
            r0.append(r4)
            if (r1 <= 0) goto L_0x019d
            java.lang.String r4 = "'"
            r0.append(r4)
            java.lang.Object[] r5 = r13.args
            r5 = r5[r6]
            r0.append(r5)
            r0.append(r4)
            r5 = 1
        L_0x0189:
            if (r5 >= r1) goto L_0x019d
            java.lang.String r6 = ",'"
            r0.append(r6)
            java.lang.Object[] r6 = r13.args
            r6 = r6[r5]
            r0.append(r6)
            r0.append(r4)
            int r5 = r5 + 1
            goto L_0x0189
        L_0x019d:
            java.lang.String r1 = ")"
            r0.append(r1)
        L_0x01a2:
            if (r12 == 0) goto L_0x01c1
            r12 = 102(0x66, float:1.43E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = r13.func
            r0.append(r13)
            java.lang.String r13 = " not found, check the method name or arguments."
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r12 = r10.ad(r12, r13, r2)
            r11.confirm(r12)
            goto L_0x01c4
        L_0x01c1:
            r11.cancel()
        L_0x01c4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.qw.yj.qw.uk(android.webkit.JsPromptResult, boolean, com.dxmpay.apollon.webmanager.JavaBridgeObject):boolean");
    }

    public final boolean when(String str) {
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

    @SuppressLint({"NewApi"})
    public final void yj(StringBuilder sb, Object obj, String str) throws JSONException {
        if (sb == null || obj == null || TextUtils.isEmpty(str)) {
            LogUtil.e(b.b, "createJsScript: invalid params:", (Throwable) null);
            LogUtil.e(b.b, "script=" + sb, (Throwable) null);
            LogUtil.e(b.b, "obj=" + obj + ", interfaceName=" + str, (Throwable) null);
            return;
        }
        Class<?> cls = obj.getClass();
        if (f4503th) {
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
            if (!name.endsWith(b.f727i) && !when(name) && !hashSet.contains(name)) {
                hashSet.add(name);
                sb.append(name);
                sb.append(":function(){");
                if (method.getReturnType() != Void.TYPE) {
                    sb.append("return ");
                }
                sb.append("prompt('");
                sb.append(f4504yj);
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
        this.f4505ad.put(str, hashSet);
        int length = sb.length() - 1;
        if (sb.charAt(length) == ',') {
            sb.deleteCharAt(length);
        }
        sb.append("};");
        sb.append("}");
    }
}
