package com.dlife.ctaccountapi;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class o {

    public static class a implements Comparator<Map.Entry<String, String>> {
        /* renamed from: a */
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    }

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    if (!name.contains("wlan")) {
                        if (name.equals("eth0")) {
                        }
                    }
                }
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                        String hostAddress = nextElement2.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(hostAddress);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("pipl", a());
        hashMap.put("timeStamp", Long.toString(System.currentTimeMillis()));
        hashMap.put("rl", "00000");
        hashMap.put("bussinessType", str3);
        hashMap.put("sdkversion", "SDK-JJ-v4.5.0");
        hashMap.put("networkType", n.c(context));
        hashMap.put("onlineType", n.e(context));
        hashMap.put("aip", context.getPackageName());
        return a(str, str2, hashMap, str4);
    }

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        String a2 = j.a(str3, j.a());
        String c = j.c(b(map, com.alipay.sdk.m.s.a.n), str3);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        hashMap.put("clientType", "30020");
        hashMap.put("format", "json");
        hashMap.put("paramKey", a2);
        hashMap.put("paramStr", c);
        hashMap.put("version", "3.0");
        hashMap.put("sign", a(hashMap, str2));
        return b(hashMap, com.alipay.sdk.m.s.a.n);
    }

    public static String a(Map<String, String> map, String str) {
        ArrayList<Map.Entry> arrayList = new ArrayList<>(map.entrySet());
        Collections.sort(arrayList, new a());
        String str2 = "";
        for (Map.Entry value : arrayList) {
            str2 = str2 + ((String) value.getValue());
        }
        return j.a(str2, str);
    }

    public static String b(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            if (TextUtils.isEmpty(str)) {
                str = com.alipay.sdk.m.s.a.n;
            }
            for (Map.Entry next : map.entrySet()) {
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
                sb.append(str);
            }
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
