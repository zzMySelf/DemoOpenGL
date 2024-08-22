package com.tera.scan.scheduler.executor.job;

import java.util.concurrent.Callable;

public interface Job extends Callable<Job>, Comparable<Job>, Prioritized {
    void de(long j);

    String getName();

    void yj(Object obj);
}
