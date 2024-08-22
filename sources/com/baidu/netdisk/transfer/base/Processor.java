package com.baidu.netdisk.transfer.base;

public abstract class Processor {
    private static final String TAG = "LoadProcessor";
    protected OnAddTaskListener mOnAddTaskListener;
    protected OnProcessListener mOnProcessListener;

    public interface OnAddTaskListener {
        boolean onAddTask();
    }

    public abstract void process();

    public void setOnProcessListener(OnProcessListener listener) {
        this.mOnProcessListener = listener;
    }

    public void setOnAddTaskListener(OnAddTaskListener onAddTaskListener) {
        this.mOnAddTaskListener = onAddTaskListener;
    }
}
