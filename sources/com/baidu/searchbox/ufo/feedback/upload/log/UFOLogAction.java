package com.baidu.searchbox.ufo.feedback.upload.log;

import com.baidu.searchbox.feedback.log.ILogAction;
import com.baidu.searchbox.feedback.receiver.UFOConstant;

public class UFOLogAction implements ILogAction {
    public void dispatch(String json) {
        LogEntryUtil.startUploadLog(json);
    }

    public String getType() {
        return UFOConstant.TYPE_ALL;
    }
}
