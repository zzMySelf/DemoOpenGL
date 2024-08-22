package com.baidu.netdisk.base.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;

public class BaseJobService extends JobService {
    public static final int ACTIVE_SERVICE_SEND_ACTIVE_ID = 28;
    public static final int CLOUD_FILE_GET_QUOTA_ID = 2;
    public static final int GET_ACCOUNT_THIRD_INFO_ID = 171;
    public static final int GET_CONFIG_SERVICE_GET_PRIVATE_CONFIG_ID = 59;
    public static final int GET_CONFIG_SERVICE_GET_PUBLIC_CONFIG_ID = 58;
    public static final int IS_VIP_ID = 169;
    public static final int RESEND_REQUEST_HELPER_ADD_RESEND_ID = 80;
    protected Bundle mExtras;

    public boolean onStartJob(JobParameters params) {
        Bundle transientExtras = params.getTransientExtras();
        this.mExtras = transientExtras;
        transientExtras.setClassLoader(getClassLoader());
        return false;
    }

    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
