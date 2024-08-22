package com.baidu.searchbox.prefetch.tasks;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.baidu.searchbox.prefetch.base.PrefetchItemData;
import com.baidu.searchbox.prefetch.base.SimplePrefetchListener;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractPrefetch extends AsyncTask<String, Void, Boolean> implements Comparable<AbstractPrefetch> {
    protected PrefetchItemData mData;
    /* access modifiers changed from: private */
    public boolean mDone = false;
    private boolean mNeedTimeOUt = false;
    private SimplePrefetchListener mPrefetchListener;
    private int mTaskPriority = 0;
    private int mTimeOut = 500;
    private long mTimestamp;

    /* access modifiers changed from: protected */
    public abstract int getTaskPriority();

    public abstract String getTaskType();

    /* access modifiers changed from: protected */
    public abstract boolean isNeedPrefetch();

    /* access modifiers changed from: protected */
    public abstract void run();

    public void bindData(TaskDataBuilder builder) {
        this.mData = builder.mData;
        this.mTaskPriority = getPriorityWithControl();
        if (builder.needHighPriority) {
            this.mTaskPriority = 1;
        }
        this.mTimestamp = builder.mTimestamp;
        this.mNeedTimeOUt = builder.mNeedTimeOut;
    }

    private int getPriorityWithControl() {
        int priority = getTaskPriority();
        if (priority > 1) {
            priority = 1;
        }
        if (priority < -1) {
            return -1;
        }
        return priority;
    }

    public void setTimeOut(int timeMills) {
        this.mTimeOut = timeMills;
    }

    public String getPrimaryKey() {
        return this.mData.getKey();
    }

    public PrefetchItemData getData() {
        return this.mData;
    }

    /* access modifiers changed from: protected */
    public final Boolean doInBackground(String... params) {
        if (this.mNeedTimeOUt) {
            cancelSelfWhenTimeOut();
        }
        if (getData() != null && isNeedPrefetch()) {
            run();
        }
        this.mDone = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(Boolean s) {
        super.onPostExecute(s);
        SimplePrefetchListener simplePrefetchListener = this.mPrefetchListener;
        if (simplePrefetchListener != null) {
            simplePrefetchListener.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    /* access modifiers changed from: protected */
    public final void onCancelled(Boolean s) {
        super.onCancelled(s);
        SimplePrefetchListener simplePrefetchListener = this.mPrefetchListener;
        if (simplePrefetchListener != null) {
            simplePrefetchListener.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        super.onCancelled();
    }

    private void cancelSelfWhenTimeOut() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                if (!AbstractPrefetch.this.mDone) {
                    AbstractPrefetch.this.cancel(true);
                }
            }
        }, (long) this.mTimeOut);
    }

    public void setPrefetchListener(SimplePrefetchListener resultListener) {
        this.mPrefetchListener = resultListener;
    }

    public final int compareTo(AbstractPrefetch task) {
        int i2 = this.mTaskPriority;
        int i3 = task.mTaskPriority;
        if (i2 == i3) {
            long j2 = this.mTimestamp;
            long j3 = task.mTimestamp;
            if (j2 == j3) {
                return 0;
            }
            if (j2 < j3) {
                return 1;
            }
            return -1;
        } else if (i2 < i3) {
            return 1;
        } else {
            return -1;
        }
    }

    public static final class TaskDataBuilder {
        /* access modifiers changed from: private */
        public PrefetchItemData mData;
        /* access modifiers changed from: private */
        public boolean mNeedTimeOut = false;
        /* access modifiers changed from: private */
        public long mTimestamp = SystemClock.uptimeMillis();
        /* access modifiers changed from: private */
        public boolean needHighPriority = false;

        public TaskDataBuilder itemData(PrefetchItemData prefetchItemData) {
            this.mData = prefetchItemData;
            return this;
        }

        public TaskDataBuilder improvePriority() {
            this.needHighPriority = true;
            return this;
        }

        public TaskDataBuilder needTimeOut(boolean needTimeOUt) {
            this.mNeedTimeOut = needTimeOUt;
            return this;
        }
    }
}
