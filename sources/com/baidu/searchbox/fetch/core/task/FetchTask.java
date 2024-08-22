package com.baidu.searchbox.fetch.core.task;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.fetch.inter.IFetchTask;
import com.baidu.searchbox.log.inter.APerfManager;
import org.json.JSONObject;

public class FetchTask implements IFetchTask {
    public void reportDispatchCheckFail(String type, String extJobId, String extVersion, String extStatus, JSONObject extOrigin) {
        JSONObject mainJsonObject = KeyTool.buildMainKey(type, "-1", KeyTool.buildExtKey(extJobId, extVersion, extStatus, "", extOrigin));
        APerfManager aPerfManager = (APerfManager) ServiceManager.getService(APerfManager.SERVICE_REFERENCE);
        if (aPerfManager != null) {
            aPerfManager.log("1289", mainJsonObject);
        }
    }

    public void reportDispatch(String type, String extJobId, String extVersion, JSONObject origin, String extStatus) {
        JSONObject mainJsonObject = KeyTool.buildMainKey(type, "1", KeyTool.buildExtKey(extJobId, extVersion, extStatus, "", origin));
        APerfManager aPerfManager = (APerfManager) ServiceManager.getService(APerfManager.SERVICE_REFERENCE);
        if (aPerfManager != null) {
            aPerfManager.log("1289", mainJsonObject);
        }
    }

    public void reportTaskCheckFail(String type, String extJobId, String extVersion, JSONObject originData) {
        JSONObject mainJsonObject = KeyTool.buildMainKey(type, "2", KeyTool.buildExtKey(extJobId, extVersion, "", "", originData));
        APerfManager aPerfManager = (APerfManager) ServiceManager.getService(APerfManager.SERVICE_REFERENCE);
        if (aPerfManager != null) {
            aPerfManager.log("1289", mainJsonObject);
        }
    }

    public void reportTaskRun(String type, String extJobId, String extVersion) {
        JSONObject mainJsonObject = KeyTool.buildMainKey(type, "3", KeyTool.buildExtKey(extJobId, extVersion, "", "", (JSONObject) null));
        APerfManager aPerfManager = (APerfManager) ServiceManager.getService(APerfManager.SERVICE_REFERENCE);
        if (aPerfManager != null) {
            aPerfManager.log("1289", mainJsonObject);
        }
    }

    public void reportTaskDone(String type, String extJobId, String extVersion, String extCount, boolean isExpired) {
        JSONObject mainJsonObject = KeyTool.buildMainKey(type, "4", KeyTool.buildExtKey(extJobId, extVersion, "1", extCount, (JSONObject) null));
        APerfManager aPerfManager = (APerfManager) ServiceManager.getService(APerfManager.SERVICE_REFERENCE);
        if (aPerfManager != null) {
            aPerfManager.log("1289", mainJsonObject);
        }
    }
}
