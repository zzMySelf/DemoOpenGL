package com.baidu.netdisk.io;

import com.google.gson.annotations.SerializedName;

public class UploadRequest {
    @SerializedName("task_id")
    public String taskId;
    @SerializedName("task_local_path")
    public String taskLocalPath;
    @SerializedName("task_remote_path")
    public String taskRemotePath;
}
