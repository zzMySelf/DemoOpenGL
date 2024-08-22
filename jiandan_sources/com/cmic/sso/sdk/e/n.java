package com.cmic.sso.sdk.e;

import android.content.Context;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class n {
    public static final ExecutorService a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static void a(a aVar) {
        try {
            a.execute(aVar);
        } catch (Exception e) {
            aVar.a.uncaughtException(Thread.currentThread(), e);
        }
    }

    public static abstract class a implements Runnable {
        public final Thread.UncaughtExceptionHandler a;

        public a() {
            this.a = new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th2) {
                    th2.printStackTrace();
                }
            };
        }

        public abstract void a();

        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) null);
        }

        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.a = new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th2) {
                    aVar.a().a.add(th2);
                    AuthnHelper.getInstance(context).callBackResult("200025", "发生未知错误", aVar, (JSONObject) null);
                }
            };
        }
    }
}
