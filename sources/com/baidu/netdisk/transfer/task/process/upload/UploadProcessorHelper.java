package com.baidu.netdisk.transfer.task.process.upload;

import android.content.ContentUris;
import android.net.Uri;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.base.Processor;
import com.baidu.netdisk.transfer.storage.UploadTaskProviderHelper;
import com.baidu.netdisk.transfer.task.TransferTask;
import java.util.ArrayList;

class UploadProcessorHelper {
    private static final String TAG = "UploadProcessorHelper";
    private final String mBduss;

    UploadProcessorHelper(String bduss) {
        this.mBduss = bduss;
    }

    /* access modifiers changed from: package-private */
    public void addTask(TransferTask task, boolean isNotify, Processor.OnAddTaskListener listener) {
        Uri taskUri = new UploadTaskProviderHelper(this.mBduss).addUploadingTask(BaseApplication.getInstance().getContentResolver(), task, isNotify);
        NetDiskLog.d(TAG, "【Upload-SDK】 addTask 传输器添加新任务");
        if (taskUri != null) {
            task.mTaskId = (int) ContentUris.parseId(taskUri);
        }
        if (listener != null) {
            listener.onAddTask();
        }
    }

    public void cancelTask(int id) {
        ArrayList<Integer> ids = new ArrayList<>(1);
        ids.add(Integer.valueOf(id));
        new UploadTaskProviderHelper(this.mBduss).deleteTask(BaseApplication.getInstance().getContentResolver(), false, ids);
    }
}
