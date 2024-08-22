package com.baidu.android.pushservice.v;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.android.pushservice.job.PushJobService;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f8802a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8803b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8804a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f8805b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8806c;

        public a(Context context) {
            this.f8804a = context;
            this.f8805b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        public final void a() {
            this.f8806c = false;
            this.f8805b.cancel(1);
        }

        public final void a(boolean z) {
            if (z || this.f8806c) {
                long j2 = 300000;
                if (z) {
                    a();
                    j2 = 300000 - (SystemClock.elapsedRealtime() % 300000);
                }
                this.f8806c = true;
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f8804a.getPackageName(), PushJobService.class.getName()));
                builder.setMinimumLatency(j2);
                builder.setOverrideDeadline(j2);
                builder.setRequiredNetworkType(1);
                builder.setPersisted(false);
                this.f8805b.schedule(builder.build());
            }
        }

        public final void b() {
            this.f8806c = false;
            this.f8805b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a aVar = f8802a;
            if (aVar != null) {
                try {
                    aVar.b();
                } catch (Exception e2) {
                }
                f8802a = null;
                f8803b = false;
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (b.class) {
            a aVar = f8802a;
            if (aVar != null) {
                try {
                    f8803b = true;
                    aVar.a(z);
                } catch (Exception e2) {
                }
            }
        }
    }

    public static boolean a() {
        return f8803b;
    }

    public static synchronized void b(Context context) {
        synchronized (b.class) {
            if (f8802a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    f8802a = new a(context);
                } catch (Exception e2) {
                }
            }
        }
    }
}
