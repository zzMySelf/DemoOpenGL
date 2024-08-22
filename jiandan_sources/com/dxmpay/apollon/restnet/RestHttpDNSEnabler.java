package com.dxmpay.apollon.restnet;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.converter.StringHttpMessageConverter;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class RestHttpDNSEnabler {

    /* renamed from: ad  reason: collision with root package name */
    public static Pattern f4006ad = Pattern.compile(com.baidu.apollon.restnet.RestHttpDNSEnabler.b);

    /* renamed from: de  reason: collision with root package name */
    public static ConcurrentHashMap<String, ad> f4007de = new ConcurrentHashMap<>();

    /* renamed from: fe  reason: collision with root package name */
    public static long f4008fe = 86400;
    public static final String qw = "RestHttpDNSEnabler";

    public static class ad {
        public String qw;

        public ad(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.f4008fe);
        }

        public ad(String str, long j, long j2) {
            this.qw = str;
        }
    }

    public static class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4009ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f4010th;

        public qw(Context context, String str) {
            this.f4009ad = context;
            this.f4010th = str;
        }

        public void run() {
            RestTemplate restTemplate = new RestTemplate(this.f4009ad.getApplicationContext());
            restTemplate.setMessageConverter(new StringHttpMessageConverter());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("dn", this.f4010th));
            try {
                String str = (String) restTemplate.getForObject("http://180.76.76.112/", arrayList, a.h, String.class);
                if (str instanceof String) {
                    String trim = str.trim();
                    if (trim.contains(" ")) {
                        String[] split = trim.split(" ");
                        trim = split[new Random().nextInt(split.length)];
                    }
                    LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "result: " + trim);
                    if (!TextUtils.isEmpty(trim) && RestHttpDNSEnabler.de(trim)) {
                        synchronized (RestHttpDNSEnabler.f4007de) {
                            RestHttpDNSEnabler.f4007de.put(this.f4010th, new ad(trim));
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.e(RestHttpDNSEnabler.qw, e.getMessage(), e);
            }
        }
    }

    public static boolean de(String str) {
        return f4006ad.matcher(str).matches();
    }

    public static void enableHttpDns(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            String str2 = qw;
            LogUtil.w(str2, qw + " enableHttpDns params context is null or hostName is null.");
        } else if (!f4007de.containsKey(str)) {
            new Thread(new qw(context, str)).start();
        }
    }

    public static String qw(URL url) {
        String replaceFirst;
        String host = url.getHost();
        String url2 = url.toString();
        for (Map.Entry<String, ad> key : f4007de.entrySet()) {
            String str = (String) key.getKey();
            if (str.equals(host) || (ApollonConstants.WALLET_SPECIFIC && str.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                synchronized (f4007de) {
                    replaceFirst = url2.replaceFirst(host, f4007de.get(str).qw);
                }
                return replaceFirst;
            }
        }
        return url2;
    }

    public static void rg(String str) {
        if (de(str)) {
            Iterator<Map.Entry<String, ad>> it = f4007de.entrySet().iterator();
            while (it.hasNext()) {
                if (((ad) it.next().getValue()).qw.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
