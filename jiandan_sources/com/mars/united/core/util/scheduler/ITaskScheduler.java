package com.mars.united.core.util.scheduler;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/mars/united/core/util/scheduler/ITaskScheduler;", "", "addHighTask", "", "task", "Lcom/mars/united/core/util/scheduler/BaseTask;", "addLowTask", "addMiddleTask", "addMultiTask", "Lcom/mars/united/core/util/scheduler/BaseMultiTask;", "cancelTask", "", "taskId", "destroy", "", "hasTask", "start", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ITaskScheduler {
    boolean ad(@NotNull String str);

    @Nullable
    String de(@NotNull BaseTask baseTask);

    @Nullable
    String fe(@NotNull BaseMultiTask baseMultiTask);

    boolean qw(@NotNull String str);
}
