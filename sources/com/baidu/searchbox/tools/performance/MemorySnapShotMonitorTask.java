package com.baidu.searchbox.tools.performance;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.performance.memory.monitor.MemoryMonitor;
import com.baidu.searchbox.performance.memory.monitor.VASSingleton;
import com.baidu.searchbox.performance.memory.monitor.listener.MemorySnapshotListener;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.tools.performance.MemoryPreferences;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class MemorySnapShotMonitorTask extends LaunchTask {
    private static final String TAG = "MemorySnapShotMonitor";

    public void execute() {
        if (DEBUG) {
            Log.d(TAG, "MemorySnapShotMonitorTask.execute");
        }
        MemoryMonitor.getInstance().setMonitorEnabled();
        MemoryUBCTask ubcTask = null;
        if (AppConfig.isDebug()) {
            ubcTask = new MemoryUBCTask(120000, 2000, 0, "ubcTask");
        } else if (AppConfig.isBeta()) {
            ubcTask = new MemoryUBCTask(120000, 2000, 0, "ubcTask");
        } else {
            MemoryPreferences mSPInstance = MemoryPreferences.getInstance();
            String switcher = mSPInstance.getStringWrapper(MemoryPreferences.MemoryMonitorConstants.ACTION, "switch", "0");
            if ("1".equals(switcher)) {
                long internal = 0;
                try {
                    internal = (long) Integer.valueOf(mSPInstance.getStringWrapper(MemoryPreferences.MemoryMonitorConstants.ACTION, "interval", "0")).intValue();
                } catch (NumberFormatException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                ubcTask = new MemoryUBCTask(120000, internal, 0, "ubcTask");
            } else if (DEBUG) {
                Log.d(TAG, "switcher = " + switcher);
            }
        }
        if (ubcTask != null) {
            VASSingleton.getInstance().addMemorySnapshotListener(new MemorySnapshotListener() {
                public void onLowVAS(long vasSize) {
                    JSONObject procObj = new JSONObject();
                    try {
                        procObj.put("from", "research");
                        procObj.put("type", "monitor");
                        JSONObject contentObj = new JSONObject();
                        contentObj.put("remark", "onLowVAS");
                        contentObj.put("VmSize", vasSize);
                        procObj.put("ext", contentObj);
                        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(MemoryUBCTask.UBC_ID, procObj);
                        if (MemorySnapShotMonitorTask.DEBUG) {
                            Log.d(MemorySnapShotMonitorTask.TAG, procObj.toString());
                        }
                    } catch (JSONException e2) {
                    }
                }
            });
            MemoryMonitor.getInstance().triggerMonitor(ubcTask);
            return;
        }
    }

    public String getName() {
        return "MemorySnapShotMonitorTask";
    }

    public int getProcess() {
        return 1;
    }
}
