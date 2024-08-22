package com.baidu.sofire.face.api;

public interface IVideoRecordProcess {
    int cancelRecord();

    void prepare();

    int release();

    int startRecord();

    int stopRecord();
}
