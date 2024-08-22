package com.baidu.searchbox.performance.memory.monitor.task;

import com.baidu.searchbox.performance.memory.monitor.MemorySnapshot;

public abstract class Task {
    protected long mFirstDelay;

    public abstract boolean canRepeat();

    public abstract void execute(MemorySnapshot memorySnapshot);

    public abstract long getDelay();

    public abstract String getRemark();

    public Task(long firstDelay) {
        this.mFirstDelay = 0;
        this.mFirstDelay = firstDelay;
    }

    public Task() {
        this(0);
    }
}
