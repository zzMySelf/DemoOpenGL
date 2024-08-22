package com.baidu.netdisk.statistics;

import com.baidu.netdisk.executor.task.BaseCallable;

public abstract class BaseReportTask extends BaseCallable {
    private static final String TAG = "BaseReportTask";

    public BaseReportTask(String name) {
        super(name);
    }

    public BaseReportTask(int priority, int module, boolean upgrade, String name) {
        super(priority, module, upgrade, name);
    }

    /* access modifiers changed from: protected */
    public void reportThreadStatics() {
    }
}
