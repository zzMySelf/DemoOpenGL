package com.tera.scan.main.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.mars.kotlin.service.IHandlable;
import com.mars.kotlin.service.extension.ServiceKt;
import com.tera.scan.framework.base.service.BaseJobService;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import com.tera.scan.framework.service.HandlableManager;
import fe.mmm.qw.p030switch.fe.qw.qw.ad;
import fe.mmm.qw.xxx.i.qw;

@RequiresApi(api = 22)
public class NetdiskJobService extends BaseJobService {
    public boolean onStartJob(JobParameters jobParameters) {
        ISchedulerService qw;
        super.onStartJob(jobParameters);
        Intent qw2 = qw();
        try {
            if (ServiceKt.onHandle((Service) this, jobParameters, (IHandlable<? extends Object>[]) HandlableManager.ad(getApplicationContext())) || qw2 == null) {
                return false;
            }
            ServiceManager de2 = qw.ad().de();
            if (de2 != null) {
                try {
                    ISchedulerService ad2 = de2.ad(qw2);
                    if (ad2 != null) {
                        ad2.qw(qw2, this);
                        return false;
                    }
                } catch (BadParcelableException e) {
                    fe.mmm.qw.i.qw.th("NetdiskJobService", "onStartJob", e);
                    return false;
                }
            }
            ad fe2 = qw.ad().fe();
            if (!(fe2 == null || (qw = fe2.qw(qw2)) == null)) {
                qw.qw(qw2, this);
            }
            return false;
        } catch (Exception e2) {
            fe.mmm.qw.i.qw.rg("NetdiskJobService", e2.getMessage());
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        super.onStopJob(jobParameters);
        return false;
    }

    public final Intent qw() {
        Intent intent;
        Bundle bundle = this.mExtras;
        if (bundle == null || (intent = (Intent) bundle.getParcelable("raw_intent")) == null) {
            return null;
        }
        intent.setExtrasClassLoader(getClassLoader());
        return intent;
    }
}
