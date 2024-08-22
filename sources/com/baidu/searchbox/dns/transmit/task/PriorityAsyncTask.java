package com.baidu.searchbox.dns.transmit.task;

public abstract class PriorityAsyncTask extends AsyncTask implements Comparable<PriorityAsyncTask> {
    private static final int DEFAULT_PRIORITY = 0;
    private int mPriority;

    public PriorityAsyncTask(Dispatcher dispatcher, String name) {
        super(dispatcher, name);
        this.mPriority = 0;
    }

    public PriorityAsyncTask(Dispatcher dispatcher) {
        super(dispatcher);
        this.mPriority = 0;
    }

    public PriorityAsyncTask(Dispatcher dispatcher, int priority) {
        super(dispatcher);
        this.mPriority = priority;
    }

    public PriorityAsyncTask(Dispatcher dispatcher, int priority, String name) {
        super(dispatcher, name);
        this.mPriority = priority;
    }

    public PriorityAsyncTask() {
        this(PriorityDispatcherHolder.getDispatcher());
    }

    public PriorityAsyncTask(String name) {
        this(PriorityDispatcherHolder.getDispatcher(), name);
    }

    public PriorityAsyncTask(int priority, String name) {
        this(PriorityDispatcherHolder.getDispatcher(), priority, name);
    }

    public PriorityAsyncTask(int priority) {
        this(PriorityDispatcherHolder.getDispatcher(), priority);
    }

    public int compareTo(PriorityAsyncTask targetTask) {
        if (equals(targetTask)) {
            return 0;
        }
        if (targetTask == null) {
            return -1;
        }
        int i2 = this.mPriority;
        int i3 = targetTask.mPriority;
        if (i2 == i3) {
            return 0;
        }
        if (i2 > i3) {
            return -1;
        }
        return 1;
    }
}
