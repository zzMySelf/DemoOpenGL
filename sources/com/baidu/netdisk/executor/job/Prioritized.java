package com.baidu.netdisk.executor.job;

public interface Prioritized {
    int getPriority();

    void setPriority(Priority priority);
}
