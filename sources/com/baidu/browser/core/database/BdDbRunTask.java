package com.baidu.browser.core.database;

public abstract class BdDbRunTask {
    /* access modifiers changed from: protected */
    public abstract void run();

    public void excute() {
        BdDbManager.getInstance().doDbRunTask(this);
    }

    /* access modifiers changed from: protected */
    public long excuteCmd(SqliteCmd aCmd) {
        return BdDbManager.getInstance().excuteSyncCmd(aCmd);
    }
}
