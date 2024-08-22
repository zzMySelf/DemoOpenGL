package com.baidu.searchbox.introduction.model;

import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.introduction.data.TaskGainData;
import com.baidu.searchbox.introduction.inter.ITaskPersuadeCallBack;
import com.baidu.searchbox.introduction.model.TaskGuideRequestUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/introduction/model/TaskGuidePersuadeUtil$gainPersuadePackage$1", "Lcom/baidu/searchbox/introduction/model/TaskGuideRequestUtil$RequestCallBack;", "Lcom/baidu/searchbox/introduction/data/TaskGainData;", "response", "", "data", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskGuidePersuadeUtil.kt */
public final class TaskGuidePersuadeUtil$gainPersuadePackage$1 implements TaskGuideRequestUtil.RequestCallBack<TaskGainData> {
    final /* synthetic */ ITaskPersuadeCallBack $callback;
    final /* synthetic */ BdAlertDialog $dialog;

    TaskGuidePersuadeUtil$gainPersuadePackage$1(BdAlertDialog $dialog2, ITaskPersuadeCallBack $callback2) {
        this.$dialog = $dialog2;
        this.$callback = $callback2;
    }

    public void response(TaskGainData data) {
        TaskGuidePersuadeUtil.INSTANCE.handlePersuadeGainResult(this.$dialog, data, this.$callback);
    }
}
