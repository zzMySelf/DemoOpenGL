package com.baidu.wallet.core;

import android.content.Context;
import android.net.http.HttpResponseCache;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class a {
    public static final String a = "HttpCache";

    public static void a(Context context) {
        if (context == null) {
            try {
                LogUtil.i(a, "HTTP response cache installation failed, context is null");
            } catch (MalformedURLException unused) {
            } catch (IOException e) {
                LogUtil.i(a, "HTTP response cache installation failed:" + e);
            }
        } else if (HttpResponseCache.getInstalled() == null) {
            new URL("https://www.duxiaoman.com/index").openConnection().setDefaultUseCaches(false);
            HttpResponseCache.install(new File(context.getCacheDir(), "http"), 10485760);
        }
    }

    public static void a() {
        HttpResponseCache installed = HttpResponseCache.getInstalled();
        if (installed != null) {
            installed.flush();
        }
    }
}
