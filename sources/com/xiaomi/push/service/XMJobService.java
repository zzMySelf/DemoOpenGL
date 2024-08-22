package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bj;
import com.xiaomi.push.ft;

public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f7507a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f913a = null;

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f913a = new a(this).f7508a;
        }
        f7507a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f7507a = null;
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f913a;
        if (iBinder != null) {
            return iBinder;
        }
        return new Binder();
    }

    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f7508a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f914a;

        a(Service service) {
            this.f7508a = null;
            this.f7508a = (Binder) bj.a((Object) this, "onBind", new Intent());
            bj.a((Object) this, "attachBaseContext", service);
        }

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        private static class C0108a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f7509a;

            C0108a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f7509a = jobService;
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        b.a("Job finished " + jobParameters.getJobId());
                        this.f7509a.jobFinished(jobParameters, false);
                        if (jobParameters.getJobId() == 1) {
                            ft.a(false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            b.a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f914a == null) {
                this.f914a = new C0108a(this);
            }
            Handler handler = this.f914a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            b.a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }
}
