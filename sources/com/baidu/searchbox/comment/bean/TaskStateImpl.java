package com.baidu.searchbox.comment.bean;

import com.baidu.bdtask.TaskState;
import com.baidu.searchbox.comment.definition.ITaskState;

public class TaskStateImpl implements ITaskState {
    private TaskState mTaskState;

    public TaskStateImpl(TaskState taskState) {
        this.mTaskState = taskState;
    }

    public boolean isTaskActivation() {
        return this.mTaskState != null;
    }
}
