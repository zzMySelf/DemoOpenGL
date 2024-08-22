package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.a;
import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.b;

public final class e {
    public static List<i> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new k());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T a2;
        for (i next : a) {
            if (next.a(a.a(type)) && (a2 = next.a(obj, type)) != null) {
                return a2;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith(StringUtil.ARRAY_START) || !trim.endsWith("}")) {
            return a((Object) trim, type);
        } else {
            bVar = new b(trim);
        }
        return a(bVar, type);
    }
}
