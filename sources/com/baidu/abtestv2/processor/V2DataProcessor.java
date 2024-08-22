package com.baidu.abtestv2.processor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.abtest.ExpInfo;
import com.baidu.abtest.model.ExperimentKeys;
import com.baidu.abtest.model.SwitchInfo;
import com.baidu.easyab.EasyABDataManager;
import com.baidu.easyab.util.ParseUtil;
import com.baidu.easyab.util.SwitchInfoUtil;
import com.baidu.searchbox.config.ABTestConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V2DataProcessor {
    private static final String TAG = "V2DataProcessor";
    private int fileCount = AbTestDataManager.getInstance().getFileCount();

    public HashMap<String, ExpInfo> getExpInfoFromFile(String switchInfoJsonData) {
        HashMap<String, ExpInfo> expInfoMap = new HashMap<>();
        try {
            JSONObject switchInfoJson = new JSONObject(switchInfoJsonData);
            Iterator<String> keys = switchInfoJson.keys();
            while (keys.hasNext()) {
                JSONObject dataJson = switchInfoJson.optJSONObject(keys.next());
                if (dataJson != null) {
                    String sid = dataJson.optString("sid");
                    String[] sidArray = sid.split("_");
                    if (sidArray.length == 2) {
                        expInfoMap.put(sid, new ExpInfo(ParseUtil.parseInt(sidArray[0]), ParseUtil.parseInt(sidArray[1])));
                    }
                }
            }
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return expInfoMap;
    }

    public HashMap<String, ExpInfo> getExpInfoFromConfig() {
        HashMap<String, ExpInfo> expInfoMap = new HashMap<>();
        for (String key : AbTestDataManager.getInstance().getSwitchKeys()) {
            try {
                String sid = new JSONObject(AbTestDataManager.getInstance().getSwitchInfo(key)).optString("sid");
                String[] sidArray = sid.split("_");
                if (sidArray.length == 2) {
                    expInfoMap.put(sid, new ExpInfo(ParseUtil.parseInt(sidArray[0]), ParseUtil.parseInt(sidArray[1])));
                }
            } catch (JSONException e2) {
                if (ABTestConfig.isDebug()) {
                    Log.d(TAG, "ABTest switchInfo string parse json error");
                }
            }
        }
        return expInfoMap;
    }

    public HashMap<String, ExpInfo> getExpInfoFromSapFile(String sapData) {
        HashMap<String, ExpInfo> expInfoMap = new HashMap<>();
        if (!TextUtils.isEmpty(sapData)) {
            try {
                JSONArray sapDataArray = new JSONObject(sapData).getJSONArray("data");
                if (sapDataArray != null && sapDataArray.length() > 0) {
                    for (int i2 = 0; i2 < sapDataArray.length(); i2++) {
                        String sid = sapDataArray.getString(i2);
                        String[] sidArray = sid.split("_");
                        if (sidArray.length == 2) {
                            expInfoMap.put(sid, new ExpInfo(ParseUtil.parseInt(sidArray[0]), ParseUtil.parseInt(sidArray[1])));
                        }
                    }
                }
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
        return expInfoMap;
    }

    public HashMap<String, ExpInfo> getExpInfoFromSapConfig() {
        HashMap<String, ExpInfo> expInfoMap = new HashMap<>();
        String sapData = AbTestDataManager.getInstance().getSapData();
        if (!TextUtils.isEmpty(sapData)) {
            try {
                JSONArray sapDataArray = new JSONArray(sapData);
                if (sapDataArray.length() > 0) {
                    for (int i2 = 0; i2 < sapDataArray.length(); i2++) {
                        String sid = sapDataArray.getString(i2);
                        String[] sidArray = sid.split("_");
                        if (sidArray.length == 2) {
                            expInfoMap.put(sid, new ExpInfo(ParseUtil.parseInt(sidArray[0]), ParseUtil.parseInt(sidArray[1])));
                        }
                    }
                }
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
        return expInfoMap;
    }

    public List<SwitchInfo> getSwitchInfoListFromConfig(int fileIndex) {
        List<SwitchInfo> switchInfoList = new ArrayList<>();
        for (String key : AbTestDataManager.getInstance().getSwitchKeys()) {
            if (SwitchInfoUtil.switchKeyIndex(key, this.fileCount) == fileIndex) {
                try {
                    switchInfoList.add(new SwitchInfo(key, new JSONObject(AbTestDataManager.getInstance().getSwitchInfo(key)).opt("data")));
                } catch (JSONException e2) {
                    if (ABTestConfig.isDebug()) {
                        Log.d(TAG, "ABTest switchInfo string parse json error");
                    }
                }
            }
        }
        return switchInfoList;
    }

    public HashMap<String, JSONObject> getSwitchInfoMap() {
        String switchInfoData = EasyABDataManager.getV2SwitchInfo();
        HashMap<String, JSONObject> switchInfoMap = new HashMap<>();
        if (!TextUtils.isEmpty(switchInfoData)) {
            try {
                JSONObject switchObj = new JSONObject(switchInfoData);
                Iterator<String> it = switchObj.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    switchInfoMap.put(key, switchObj.getJSONObject(key));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            for (String key2 : AbTestDataManager.getInstance().getSwitchKeys()) {
                try {
                    switchInfoMap.put(key2, new JSONObject(AbTestDataManager.getInstance().getSwitchInfo(key2)));
                } catch (JSONException e3) {
                    if (ABTestConfig.isDebug()) {
                        Log.d(TAG, "ABTest switchInfo string parse json error");
                    }
                }
            }
        }
        return switchInfoMap;
    }

    public synchronized void transferSwitchInfoToFile() {
        Set<String> switchKeys = AbTestDataManager.getInstance().getSwitchKeys();
        JSONObject switchInfo = new JSONObject();
        for (String key : switchKeys) {
            try {
                switchInfo.put(key, new JSONObject(AbTestDataManager.getInstance().getSwitchInfo(key)));
            } catch (JSONException e2) {
                if (ABTestConfig.isDebug()) {
                    Log.d(TAG, "ABTest switchInfo string parse json error");
                }
            }
        }
        EasyABDataManager.saveV2SwitchInfo(switchInfo);
    }

    public synchronized void transferSapDataToFile() {
        String version = AbTestDataManager.getInstance().getSapVersion();
        String sapData = AbTestDataManager.getInstance().getSapData();
        if (!TextUtils.isEmpty(sapData)) {
            try {
                JSONObject sapJson = new JSONObject();
                JSONArray sapDataArray = new JSONArray(sapData);
                sapJson.put("version", version);
                sapJson.put(ExperimentKeys.EXPS, sapDataArray);
                EasyABDataManager.saveSapData(sapJson);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
        return;
    }
}
