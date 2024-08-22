package com.baidu.assistant.res.update.cloudcontrol.files;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/assistant/res/update/cloudcontrol/files/OperateFileConfig;", "", "()V", "DOWNLOADING_FILE_NAME", "", "DOWNLOAD_FILE_NAME", "PATH_ASSISTANT_OPERATE", "TASK_CLEAR_ALL", "TASK_CLEAR_SINGLE_FILE", "TASK_CLEAR_VERSION_FILE", "lib-assistant-update_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OperateFileConfig.kt */
public final class OperateFileConfig {
    public static final String DOWNLOADING_FILE_NAME = "assistant_operate.tmp";
    public static final String DOWNLOAD_FILE_NAME = "assistant_operate.zip";
    public static final OperateFileConfig INSTANCE = new OperateFileConfig();
    public static final String PATH_ASSISTANT_OPERATE = "assistant_operate";
    public static final String TASK_CLEAR_ALL = "operate_clear_all_task";
    public static final String TASK_CLEAR_SINGLE_FILE = "operate_clear_single_task";
    public static final String TASK_CLEAR_VERSION_FILE = "operate_clear_task";

    private OperateFileConfig() {
    }
}
