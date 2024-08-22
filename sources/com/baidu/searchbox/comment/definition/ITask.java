package com.baidu.searchbox.comment.definition;

public interface ITask {
    void addActionWithActionId(String str);

    ITaskState findTaskStateByActionId(String str);

    boolean hasInitialized();
}
