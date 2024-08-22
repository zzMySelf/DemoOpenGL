package com.baidu.apollon.restnet;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class RestHttpDNSEnabler {
    public static final String a = "RestHttpDNSEnabler";
    public static final String b = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public static Pattern c = Pattern.compile(b);
    public static ConcurrentHashMap<String, a> d = new ConcurrentHashMap<>();
    public static long e = 86400;

    public static class a {
        public String a;
        public long b;
        public long c;
        public boolean d;

        public a(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.e);
        }

        public a(String str, long j, long j2) {
            this.a = str;
            this.b = j;
            this.c = j2;
        }
    }

    public static boolean c(String str) {
        for (Map.Entry<String, a> value : d.entrySet()) {
            if (((a) value.getValue()).a.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void enableHttpDns(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            String str2 = a;
            LogUtil.w(str2, a + " enableHttpDns params context is null or hostName is null.");
        } else if (!d.containsKey(str)) {
            new Thread(new Runnable() {
                public void run() {
                    RestTemplate restTemplate = new RestTemplate(DxmApplicationContextImpl.getApplicationContext(context));
                    restTemplate.setMessageConverter(new b());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new RestNameValuePair("dn", str));
                    try {
                        String str = (String) restTemplate.a("http://180.76.76.112/", arrayList, com.baidu.apollon.heartbeat.a.h, String.class);
                        if (str instanceof String) {
                            String trim = str.trim();
                            if (trim.contains(" ")) {
                                String[] split = trim.split(" ");
                                trim = split[new Random().nextInt(split.length)];
                            }
                            LogUtil.v("apollon_rest", "result: " + trim);
                            if (!TextUtils.isEmpty(trim) && RestHttpDNSEnabler.a(trim)) {
                                synchronized (RestHttpDNSEnabler.d) {
                                    RestHttpDNSEnabler.d.put(str, new a(trim));
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static boolean a(String str) {
        return c.matcher(str).matches();
    }

    public static void b(String str) {
        if (a(str)) {
            Iterator<Map.Entry<String, a>> it = d.entrySet().iterator();
            while (it.hasNext()) {
                if (((a) it.next().getValue()).a.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public static String a(URL url) {
        String replaceFirst;
        String host = url.getHost();
        String url2 = url.toString();
        for (Map.Entry<String, a> key : d.entrySet()) {
            String str = (String) key.getKey();
            if (str.equals(host) || (ApollonConstants.WALLET_SPECIFIC && str.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                synchronized (d) {
                    replaceFirst = url2.replaceFirst(host, d.get(str).a);
                }
                return replaceFirst;
            }
        }
        return url2;
    }
}
