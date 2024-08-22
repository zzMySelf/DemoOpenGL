package com.baidu.apollon.restnet.http;

import android.os.Build;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class d extends CookieHandler {
    public static final d a = new d();
    public final CookieHandler b;

    public d() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b = e.a();
        } else {
            this.b = new CookieManager((CookieStore) null, CookiePolicy.ACCEPT_ALL);
        }
    }

    public static d a() {
        return a;
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        return this.b.get(uri, map);
    }

    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        this.b.put(uri, map);
    }
}
