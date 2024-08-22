package com.tera.scan.framework.base.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;

@TargetApi(21)
public class BaseJobService extends JobService {
    public Bundle mExtras;

    @TargetApi(26)
    public boolean onStartJob(JobParameters jobParameters) {
        Bundle transientExtras = jobParameters.getTransientExtras();
        this.mExtras = transientExtras;
        transientExtras.setClassLoader(getClassLoader());
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
