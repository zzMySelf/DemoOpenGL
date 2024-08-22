package com.baidu.sofire.l;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class b {
    public static b h;

    /* renamed from: i  reason: collision with root package name */
    public static int f1090i;
    public Context a;
    public a b = null;
    public File c;
    public File d;
    public HandlerThread e;
    public Handler f;
    public boolean g = false;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            b.f1090i--;
            if (b.this.f != null) {
                Message message = new Message();
                message.what = 1;
                b.this.f.sendMessage(message);
            }
        }

        public void onActivityResumed(Activity activity) {
            b.f1090i++;
            if (b.this.f != null) {
                Message message = new Message();
                message.what = 1;
                b.this.f.sendMessage(message);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.baidu.sofire.l.b$b  reason: collision with other inner class name */
    public class C0054b extends Handler {

        /* renamed from: com.baidu.sofire.l.b$b$a */
        public class a extends TimerTask {
            public final /* synthetic */ Timer a;

            public a(Timer timer) {
                this.a = timer;
            }

            public void run() {
                try {
                    boolean unused = b.this.g = false;
                    if (b.f1090i > 0) {
                        b.a(b.this, true);
                        b.a(b.this);
                    } else {
                        b.a(b.this, false);
                    }
                    Timer timer = this.a;
                    if (timer != null) {
                        timer.cancel();
                    }
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.a.a;
                }
            }
        }

        public C0054b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    if (b.this.d.exists() || !b.a()) {
                        b bVar = b.this;
                        if (!bVar.g) {
                            boolean unused = bVar.g = true;
                            Timer timer = new Timer();
                            timer.schedule(new a(timer), 500);
                            return;
                        }
                        return;
                    }
                    b.a(b.this, true);
                    b.a(b.this);
                }
            } catch (Throwable unused2) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public b(Context context) {
        this.a = context;
        File file = new File(new File(new File(c.f(context), "sofire_tmp"), ".tmp"), ".cfmflgd");
        this.c = file;
        if (file.exists() && !this.c.isDirectory()) {
            this.c.delete();
        }
        if (!this.c.exists()) {
            this.c.mkdirs();
        }
        int myPid = Process.myPid();
        File file2 = this.c;
        this.d = new File(file2, "sofire_fgff_" + myPid);
        b();
    }

    public static void a(b bVar, boolean z) {
        bVar.getClass();
        if (z) {
            try {
                if (!bVar.d.exists()) {
                    bVar.d.createNewFile();
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        } else if (bVar.d.exists()) {
            bVar.d.delete();
        }
    }

    public final void b() {
        HandlerThread handlerThread = new HandlerThread("sofire_thread_check_fg", 10);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new C0054b(this.e.getLooper());
    }

    public static void a(b bVar) {
        bVar.getClass();
        try {
            File file = bVar.c;
            if (file != null && file.isDirectory()) {
                for (File file2 : bVar.c.listFiles()) {
                    if (file2.exists() && !file2.equals(bVar.d)) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static boolean a() {
        return f1090i > 0;
    }
}
