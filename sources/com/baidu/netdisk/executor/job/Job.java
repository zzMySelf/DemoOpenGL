package com.baidu.netdisk.executor.job;

import java.util.concurrent.Callable;

public interface Job extends Callable<Job>, Comparable<Job>, Prioritized {
    void cancel();

    long getCreateToCompleteTime();

    long getCreateToExcuteTime();

    long getExcuteToCompleteTime();

    String getName();

    Object getTag();

    boolean isCancelled();

    boolean isComplete();

    boolean isRunning();

    void setTag(Object obj);
}
