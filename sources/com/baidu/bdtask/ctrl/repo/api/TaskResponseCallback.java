package com.baidu.bdtask.ctrl.repo.api;

import com.baidu.bdtask.model.response.TaskResponseData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", "", "onError", "", "errorNo", "", "errorMsg", "", "onSucceed", "data", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public interface TaskResponseCallback {
    void onError(int i2, String str);

    void onSucceed(TaskResponseData taskResponseData);
}
