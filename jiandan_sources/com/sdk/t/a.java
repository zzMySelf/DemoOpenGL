package com.sdk.t;

import com.baidu.android.common.others.lang.StringUtil;
import com.sdk.f.f;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

public class a extends com.sdk.i.a {
    public static final String a = "com.sdk.t.a";
    public static boolean b = f.a;

    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        if (treeMap == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(str2);
            stringBuffer.append('?');
            for (Map.Entry next : treeMap.entrySet()) {
                String str3 = (String) next.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append(next.getValue());
                sb.append("");
                String sb2 = sb.toString();
                if (next.getValue() != null && sb2.length() > 0) {
                    if (!StringUtil.NULL_STRING.equals(sb2)) {
                        if (!"sign".equals(str3)) {
                            if (!str3.startsWith("_")) {
                                if (!"file".equals(str3)) {
                                    stringBuffer.append(str3);
                                    stringBuffer.append(com.alipay.sdk.m.n.a.h);
                                    stringBuffer.append(next.getValue());
                                    stringBuffer.append(Typography.amp);
                                }
                            }
                        }
                    }
                }
            }
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            com.sdk.r.f a2 = com.sdk.r.f.a();
            return a2.b.a(stringBuffer.toString());
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
