package com.baidu.netdisk.transfer.task.process.upload;

import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.storage.PathKt;
import com.baidu.netdisk.transfer.base.Processor;
import com.baidu.netdisk.transfer.base.UploadInfo;
import com.baidu.netdisk.transfer.task.UploadTask;

class NewUploadTaskProcessor extends Processor {
    private final String mBduss;
    private final boolean mIsNotify;
    private final String mUid;
    private final UploadInfo mUploadInfo;

    NewUploadTaskProcessor(UploadInfo info, boolean isNotify, String bduss, String uid) {
        this.mUploadInfo = info;
        this.mIsNotify = isNotify;
        this.mBduss = bduss;
        this.mUid = uid;
    }

    public void process() {
        new UploadProcessorHelper(this.mBduss).addTask(new UploadTask(BaseApplication.getInstance(), PathKt.rFile(this.mUploadInfo.getLocalePath(), BaseApplication.mContext), this.mUploadInfo.getRemotePath(), this.mBduss, this.mUid, this.mUploadInfo.getConflictStrategy(), this.mUploadInfo.getQuality()), this.mIsNotify, this.mOnAddTaskListener);
    }
}
