package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DredgeNormalExecutorCell extends BaseDredgeExecutorCell {
    protected DredgeNormalExecutorCell(int maxThreadNum) {
        super(maxThreadNum);
        this.maxThreadNum = maxThreadNum;
        this.mExecutor = new ThreadPoolExecutor(maxThreadNum, maxThreadNum, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mExecutor.allowCoreThreadTimeOut(true);
    }

    /* access modifiers changed from: protected */
    public String getTag() {
        return "ElasticDredgeNormalCell";
    }
}
