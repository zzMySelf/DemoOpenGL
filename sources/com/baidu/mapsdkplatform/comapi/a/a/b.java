package com.baidu.mapsdkplatform.comapi.a.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URLEncoder;

/* compiled from: MapSDKUncaughtExceptionHandler */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f14810a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f14811b;

    /* renamed from: c  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f14812c;

    /* compiled from: MapSDKUncaughtExceptionHandler */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f14813a = new b();
    }

    public static b a() {
        return a.f14813a;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (!f14810a) {
            f14810a = true;
            a(th2);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f14812c;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }

    private b() {
        this.f14811b = "";
        this.f14812c = Thread.getDefaultUncaughtExceptionHandler();
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.f14811b = str;
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof b)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void a(Throwable th2) {
        String str;
        if (th2 != null) {
            String th3 = th2.toString();
            if (!th3.isEmpty() && !th3.contains("BDMapSDKException")) {
                if (th3.contains("com.baidu.platform") || th3.contains("com.baidu.mapsdkplatform") || th3.contains("com.baidu.mapsdkvi")) {
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th2.printStackTrace(printWriter);
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        String stringWriter2 = stringWriter.toString();
                        if (stringWriter2.isEmpty() || (str = this.f14811b) == null) {
                            return;
                        }
                        if (!str.isEmpty()) {
                            File file = new File(URLEncoder.encode(this.f14811b + (System.currentTimeMillis() / 1000) + ".txt", "UTF-8"));
                            if (file.exists() || file.createNewFile()) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(stringWriter2.getBytes());
                                fileOutputStream.close();
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }
}
