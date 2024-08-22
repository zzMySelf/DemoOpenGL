package com.baidu.apollon.restnet.http;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends CookieHandler {
    public final CookieManager a;

    public static class a {
        public static final e a = new e();
    }

    public static e a() {
        return a.a;
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            return Collections.emptyMap();
        }
        String cookie = this.a.getCookie(uri.toString());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(cookie)) {
            hashMap.put("Cookie", Collections.singletonList(cookie));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            List<String> list = map.get("Set-Cookie");
            List<String> list2 = map.get(HttpHeaders.SET_COOKIE2);
            if (list != null) {
                for (String cookie : list) {
                    this.a.setCookie(uri.toString(), cookie);
                }
            }
            if (list2 != null) {
                for (String cookie2 : list2) {
                    this.a.setCookie(uri.toString(), cookie2);
                }
            }
        }
    }

    public e() {
        CookieManager instance = CookieManager.getInstance();
        this.a = instance;
        if (!instance.acceptCookie()) {
            this.a.setAcceptCookie(true);
        }
    }
}
