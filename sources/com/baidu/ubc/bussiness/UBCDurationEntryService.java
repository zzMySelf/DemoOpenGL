package com.baidu.ubc.bussiness;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class UBCDurationEntryService {
    private static final String TAG = "UBCDurationEntryService";
    private static final String UBC_ENTRY_EXT_KEY = "ext";
    private static final String UBC_ENTRY_FROM_KEY = "from";
    private static final String UBC_ENTRY_FROM_VALUE = "whole";
    private static final String UBC_ENTRY_ID = "877";
    private static final Integer UBC_ENTRY_JSONVALUE_COUNT = 5;
    private static final String UBC_ENTRY_SOURCE_KEY = "source";
    private static final String[] UBC_ENTRY_TYPES = {"s", "e", "k"};
    private static final String UBC_ENTRY_TYPE_KEY = "type";
    private static final String UBC_ENTRY_VALUE_KEY = "value";
    private static String sessionid;

    public static void timeSplitStasticsWithSource(String source, JSONObject jsonObject) {
        stasticsWithSource(source, "k", jsonObject);
    }

    public static void timeSplitStasticsWithSource(String source, String type, JSONObject jsonObject) {
        stasticsWithSource(source, type, jsonObject);
    }

    private static void stasticsWithSource(String source, String type, JSONObject jsonObject) {
        UBCManager manager;
        if (!TextUtils.isEmpty(source) && !TextUtils.isEmpty(type) && Arrays.asList(UBC_ENTRY_TYPES).contains(type) && (manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            JSONObject json = new JSONObject();
            try {
                json.put("from", UBC_ENTRY_FROM_VALUE);
                json.put("source", source);
                json.put("type", type);
                if (sessionid == null) {
                    sessionid = getSessionid();
                }
                json.put("value", sessionid);
                if (jsonObject != null && jsonObject.length() <= UBC_ENTRY_JSONVALUE_COUNT.intValue()) {
                    json.put("ext", jsonObject);
                }
                manager.onEvent(UBC_ENTRY_ID, json);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String getSessionid() {
        return UUID.randomUUID().toString() + "_" + System.currentTimeMillis();
    }

    public static void resetSessionid() {
        sessionid = null;
    }
}
