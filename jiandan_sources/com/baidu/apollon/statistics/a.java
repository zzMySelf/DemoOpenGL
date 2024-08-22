package com.baidu.apollon.statistics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class a {
    public static final String a = "com.baidu.wallet.base.statistics.DXMSdkSAUtils";
    public static Class<?> b = null;
    public static Method c = null;
    public static final String d = "onEventWithValues";

    public static void a(String str, List<String> list) {
        if (b == null || c == null) {
            try {
                Class<?> cls = Class.forName(a);
                b = cls;
                c = cls.getDeclaredMethod(d, new Class[]{String.class, Collection.class});
            } catch (Throwable unused) {
            }
        }
        Method method = c;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{str, list});
            } catch (Exception unused2) {
            }
        }
    }

    public static void a(String str, String... strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (strArr != null && strArr.length > 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            a(str, (List<String>) arrayList);
        } catch (Exception unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(str2);
            arrayList.add(str3);
            a("exception_stat", (List<String>) arrayList);
        } catch (Exception unused) {
        }
    }
}
