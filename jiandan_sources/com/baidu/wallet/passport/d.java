package com.baidu.wallet.passport;

import android.text.TextUtils;
import com.dxm.pass_basic.DxmAccount;
import com.dxm.pass_gate.DxmAccountManager;
import java.lang.reflect.Field;
import java.util.Map;

public class d {

    public static abstract class a {
        public static final int a = -1001;
        public static final int b = -1002;
        public static final int c = -1003;
        public static final String d = "未登录";
        public static final String e = "未找到反射方法";
        public static final String f = "参数错误";

        public abstract void a(int i2, String str);
    }

    public static class b {
        public static String a = "1";
        public static String b = "2";
        public Object c;
        public Map<String, String> d;
    }

    public Object a(Object obj, Object[] objArr, String str, a aVar, Class<?>... clsArr) {
        DxmAccount dxmGetSession = DxmAccountManager.getInstance().dxmGetSession();
        if (dxmGetSession == null) {
            aVar.a(-1001, "未登录");
            return null;
        } else if (obj == null || TextUtils.isEmpty(str) || clsArr == null) {
            aVar.a(-1003, "参数错误");
            return null;
        } else {
            Object[] a2 = a(objArr, dxmGetSession);
            boolean z = obj instanceof Class;
            Class<?> cls = z ? (Class) obj : obj.getClass();
            if (z) {
                obj = null;
            }
            try {
                return cls.getDeclaredMethod(str, clsArr).invoke(obj, a2);
            } catch (Exception unused) {
                aVar.a(-1002, "未找到反射方法");
                return null;
            }
        }
    }

    private Object[] a(Object[] objArr, DxmAccount dxmAccount) {
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar = objArr[i2];
            if (!(bVar instanceof b)) {
                objArr2[i2] = bVar;
            } else {
                b bVar2 = bVar;
                Map<String, String> map = bVar2.d;
                if (map == null) {
                    objArr2[i2] = bVar2.c;
                } else {
                    for (String next : map.keySet()) {
                        objArr2[i2] = null;
                    }
                }
            }
        }
        return objArr2;
    }

    private Object a(Object obj, String str, String str2) {
        if (obj == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return obj;
        }
        if (obj instanceof String) {
            return str2;
        }
        if (obj instanceof Map) {
            ((Map) obj).put(str, str2);
            return obj;
        }
        try {
            Field field = obj.getClass().getField(str);
            field.setAccessible(true);
            field.set(str, str2);
            return obj;
        } catch (Exception unused) {
            return obj;
        }
    }
}
