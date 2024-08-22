package com.baidu.netdisk.external;

public interface IUploadState {
    public static final int STATE_FAILED = -1;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_RUNNING = 0;
    public static final int STATE_SUCCESS = 1;
}
