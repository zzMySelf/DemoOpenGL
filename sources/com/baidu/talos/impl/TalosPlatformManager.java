package com.baidu.talos.impl;

import android.content.Context;
import com.baidu.searchbox.reactnative.RNInitParamsManager;
import com.baidu.searchbox.reactnative.RNSearchBoxUtility;
import com.baidu.searchbox.reactnative.RNSearchBoxViewEventDispatcher;
import com.baidu.searchbox.reactnative.modules.util.RNLogHelper;
import com.baidu.talos.common.ITalosHostCapacity;
import com.baidu.talos.core.util.RNABTestUtil;

public class TalosPlatformManager implements ITalosHostCapacity {
    public String getPlatformInfo(Context contextParam) {
        return RNInitParamsManager.getPlatformInfo(contextParam);
    }

    public void hideLoadingView(int viewID) {
        RNSearchBoxViewEventDispatcher.getInstance().hideLoadingView(viewID);
    }

    public void writeLogToBuffer(String log) {
        RNLogHelper.getInstance().writeLogToBuffer(log);
    }

    public void convertCacheAndUploadLogFile() {
        RNLogHelper.getInstance().convertCacheAndUploadLogFile();
    }

    public String getABSid() {
        return RNSearchBoxUtility.getABSid();
    }

    public String getTraficInfo() {
        return RNInitParamsManager.getTraficInfo();
    }

    public boolean enableDoubleList() {
        return RNABTestUtil.enableDoubleList();
    }
}
