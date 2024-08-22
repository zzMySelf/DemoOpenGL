package com.baidu.netdisk.cloudfile.io.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FileManagerBroadcastBean implements Parcelable {
    public static final Parcelable.Creator<FileManagerBroadcastBean> CREATOR = new Parcelable.Creator<FileManagerBroadcastBean>() {
        public FileManagerBroadcastBean[] newArray(int size) {
            return new FileManagerBroadcastBean[size];
        }

        public FileManagerBroadcastBean createFromParcel(Parcel source) {
            return new FileManagerBroadcastBean(source);
        }
    };
    private static final String TAG = "FileManagerBroadcastBean";
    public boolean callList;
    public String destDir;
    public int failedCount;
    public int failedType;
    public int progress;
    public int taskError;
    public long taskId;
    public String taskStatus;
    public int taskType;
    public int totalFailedCount;

    public FileManagerBroadcastBean(long taskId2, int type, FileManagerTaskResponse result, int failedCount2, int failedTotalCount, int failedType2, String dest, boolean list) {
        this.taskId = taskId2;
        this.taskType = type;
        this.failedCount = failedCount2;
        this.totalFailedCount = failedTotalCount;
        this.failedType = failedType2;
        this.destDir = dest;
        this.callList = list;
        if (result != null) {
            this.progress = result.progress;
            this.taskError = result.taskErrno;
            this.taskStatus = result.status;
            return;
        }
        this.taskStatus = "failed";
    }

    public FileManagerBroadcastBean(Parcel src) {
        this.progress = src.readInt();
        this.taskError = src.readInt();
        this.taskId = src.readLong();
        this.taskStatus = src.readString();
        this.taskType = src.readInt();
        this.failedCount = src.readInt();
        this.totalFailedCount = src.readInt();
        this.failedType = src.readInt();
        this.callList = src.readInt() != 1 ? false : true;
        this.destDir = src.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.progress);
        dest.writeInt(this.taskError);
        dest.writeLong(this.taskId);
        dest.writeString(this.taskStatus);
        dest.writeInt(this.taskType);
        dest.writeInt(this.failedCount);
        dest.writeInt(this.totalFailedCount);
        dest.writeInt(this.failedType);
        dest.writeInt(this.callList ? 1 : 0);
        dest.writeString(this.destDir);
    }
}
