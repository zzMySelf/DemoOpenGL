package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DredgeDisasterExecutorCell extends BaseDredgeExecutorCell {
    protected DredgeDisasterExecutorCell(int maxThreadNum) {
        super(maxThreadNum);
        this.mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 100, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    /* access modifiers changed from: protected */
    public String getTag() {
        return "ElasticDredgeDisasterCell";
    }
}
