package com.baidu.thor.sdk.manager.ioc.impl;

import com.baidu.thor.common.ThorLog;
import com.baidu.thor.sdk.manager.ioc.IReporterManager;
import com.baidu.thor.sdk.manager.ioc.Issue;

public class ReporterManager implements IReporterManager {
    private static final String TAG = "ReporterManager";
    private static ReporterManager sInstance = new ReporterManager();
    private IReporterManager mBase;

    private ReporterManager() {
    }

    public static ReporterManager getInstance() {
        return sInstance;
    }

    public void init(IReporterManager iReporterManager) {
        this.mBase = iReporterManager;
    }

    public void onReportIssue(Issue issue) {
        IReporterManager iReporterManager = this.mBase;
        if (iReporterManager == null) {
            ThorLog.w(TAG, "ReporterManager mBase is null.");
        } else {
            iReporterManager.onReportIssue(issue);
        }
    }
}
