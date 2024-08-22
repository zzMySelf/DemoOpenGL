package com.baidu.chatsearch.taskdispatcher;

import java.util.HashMap;

public class NormalTask extends Task {
    private volatile boolean mIsCanceled = false;
    private NormalTask mNextNormalTask;
    private HashMap<String, Object> mParameters;

    public HashMap<String, Object> getParameters() {
        return this.mParameters;
    }

    public NormalTask() {
    }

    public NormalTask(HashMap<String, Object> parameters) {
        this.mParameters = parameters;
    }

    public void setTag(Object tag) {
        this.taskTAG = tag;
    }

    public Object getTag() {
        return this.taskTAG;
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public void cancel() {
        setCanceled(true);
    }

    public void doTask() {
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setCanceled(boolean canceled) {
        this.mIsCanceled = canceled;
    }

    public void setNextTask(NormalTask task) {
        this.mNextNormalTask = task;
    }

    public NormalTask getNextTask() {
        return this.mNextNormalTask;
    }
}
