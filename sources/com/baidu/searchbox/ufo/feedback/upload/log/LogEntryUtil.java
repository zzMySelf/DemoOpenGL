package com.baidu.searchbox.ufo.feedback.upload.log;

import com.baidu.searchbox.ufo.feedback.upload.log.upload.UploadChain;

public class LogEntryUtil {
    public static void startUploadLog(String logKey) {
        new UploadChain().addChain(new UFOFeedback()).processUpload(logKey);
    }
}
