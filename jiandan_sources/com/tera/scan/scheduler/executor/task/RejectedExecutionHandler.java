package com.tera.scan.scheduler.executor.task;

public interface RejectedExecutionHandler {
    void qw(Runnable runnable, ThreadPoolExecutor threadPoolExecutor);
}
