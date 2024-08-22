package com.sdk.a;

import com.sdk.a.f;
import com.sdk.e.b;
import com.sdk.f.f;
import com.sdk.o.a;
import com.sdk.r.d;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class g<T> implements Serializable {
    public static final String a = "com.sdk.a.g";
    public static final Boolean b = Boolean.valueOf(f.a);
    public static final long serialVersionUID = -8869881146515387822L;
    public String c = f.a.a.l;
    public String d;
    public String e;
    public TreeMap<String, Object> f;
    public ArrayList<File> g;
    public HashMap<String, Object> h;

    /* renamed from: i  reason: collision with root package name */
    public int f6813i = 0;
    public b<T> j;

    public String a(TreeMap<String, Object> treeMap) {
        StringBuilder sb;
        if (treeMap != null) {
            try {
                sb = new StringBuilder();
                for (Map.Entry next : treeMap.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null && a.b(str).booleanValue()) {
                        String encode = URLEncoder.encode(value.toString(), "UTF-8");
                        if (com.sdk.f.f.d) {
                            if (!"sign".equals(str)) {
                                if (!"unikey".equals(str)) {
                                    sb.append(str);
                                    sb.append("=");
                                    encode = d.b(encode);
                                }
                            }
                            sb.append(str);
                            sb.append("=");
                        } else {
                            sb.append(str);
                            sb.append("=");
                        }
                        sb.append(encode);
                        sb.append(com.alipay.sdk.m.s.a.n);
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception e2) {
                a.a(a, e2.getMessage(), b);
                throw new Exception("http请求参数出错");
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public void a(String str) {
        if (a.b(str).booleanValue()) {
            this.c = str;
        }
    }

    public void b(String str) {
        this.d = str;
    }
}
