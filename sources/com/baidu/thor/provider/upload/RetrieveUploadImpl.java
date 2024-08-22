package com.baidu.thor.provider.upload;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.thor.provider.UploadInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RetrieveUploadImpl implements UploadInterface {
    private static final String TAG = "RetrieveUploadImpl";

    public String getType() {
        return "RETRIEVE";
    }

    public void setType(String type) {
    }

    public void upload(String uploadType, JSONObject content, File file) {
        JSONObject jSONObject = content;
        if (!"RETRIEVE".equals(uploadType)) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "upload type is wrong, should be RETRIEVE");
            }
        } else if (jSONObject != null) {
            String retrieveType = jSONObject.optString("retrieveType");
            if (!TextUtils.isEmpty(retrieveType)) {
                String jobId = jSONObject.optString("retrieveJobId");
                if (!TextUtils.isEmpty(jobId)) {
                    String version = jSONObject.optString("retrieveVersion");
                    if (!TextUtils.isEmpty(version)) {
                        long maxSizeLimit = jSONObject.optLong("retrieveMaxLimitSize");
                        long startTime = jSONObject.optLong("retrieveStartTime");
                        long endTime = jSONObject.optLong("retrieveEndTime");
                        JSONArray jsonArray = jSONObject.optJSONArray("retrieveFilters");
                        if (jsonArray != null) {
                            List<String> filters = new ArrayList<>();
                            for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                                String jo = jsonArray.optString(i2);
                                if (!TextUtils.isEmpty(jo)) {
                                    filters.add(jo);
                                }
                            }
                            JSONArray jSONArray = jsonArray;
                            ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).fetchUpload(retrieveType, jobId, version, maxSizeLimit, startTime, endTime, filters);
                            if (AppConfig.isDebug()) {
                                Log.d(TAG, "Retrieve upload content is " + content.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    public void uploadUBCDirectly(String ubcId, JSONObject content) {
    }

    public boolean uploadBOSWithResult(String uploadType, JSONObject content, File file) {
        return false;
    }
}
