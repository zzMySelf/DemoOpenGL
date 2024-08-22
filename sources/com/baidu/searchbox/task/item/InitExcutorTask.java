package com.baidu.searchbox.task.item;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.deviceinfo.IDevicePortraitManager;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class InitExcutorTask extends LaunchTask {
    private static final String ELASTIC_STATISTIC_UBC_ID = "815";
    public static final boolean ENABLE_STATISTIC_RECORDER = false;
    public static final boolean ENABLE_STATISTIC_WARNING = true;
    public static final long STATISTIC_UPLOAD_DELAY = 15000;

    public void execute() {
        initElasticExecutor();
    }

    public String getName() {
        return "InitExcutor";
    }

    public int getProcess() {
        return 1;
    }

    private void initElasticExecutor() {
        ElasticConfig.updateConfig();
        setElasticUploader();
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() {
            public void run() {
                IDevicePortraitManager devicePortraitManager;
                boolean deviceScoreStatisticSwitch = AbTestManager.getInstance().getSwitch("device_score_statistic_11.15", false);
                if (InitExcutorTask.DEBUG) {
                    Log.d("DeviceScoreAB", "deviceScoreStatisticSwitch : " + String.valueOf(deviceScoreStatisticSwitch));
                }
                if (deviceScoreStatisticSwitch && (devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE)) != null) {
                    devicePortraitManager.statisticData(AppRuntime.getAppContext());
                }
            }
        }, "statistic_device_score", 3, 15000);
    }

    private void setElasticUploader() {
        ElasticDataUploader.getInstance().setUploader(new ElasticDataUploader.IUploader() {
            public void uploadStatisticData(JSONObject content) {
            }

            public void uploadWarningData(JSONObject content) {
                try {
                    JSONObject warningJson = new JSONObject();
                    warningJson.put("warning_json", content);
                    HashMap map = new HashMap();
                    map.put("from", "research");
                    map.put("ext", warningJson);
                    UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                    if (ubc != null) {
                        ubc.onEvent(InitExcutorTask.ELASTIC_STATISTIC_UBC_ID, (Map<String, String>) map);
                    }
                } catch (JSONException e2) {
                }
            }
        });
    }
}
