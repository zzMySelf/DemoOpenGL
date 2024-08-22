package com.baidu.searchbox.noveladapter.ubc;

import android.text.TextUtils;
import com.baidu.searchbox.noveladapter.pyramid.NovelServiceManager;
import org.json.JSONObject;

public class NovelStoryUbcManager {
    private static NovelUBCManagerWrapper novelUBCManager;

    public static NovelUBCManagerWrapper getNovelUBCManager() {
        if (novelUBCManager == null) {
            novelUBCManager = new NovelUBCManagerWrapper();
        }
        return novelUBCManager;
    }

    public static void exeUbc(String eventId, String type, String page, String source, String from, String value, String extObj) {
        try {
            JSONObject jsonObject = new JSONObject();
            if (!TextUtils.isEmpty(type)) {
                jsonObject.put("type", type);
            }
            if (!TextUtils.isEmpty(page)) {
                jsonObject.put("page", page);
            }
            if (!TextUtils.isEmpty(source)) {
                jsonObject.put("source", source);
            }
            if (!TextUtils.isEmpty(from)) {
                jsonObject.put("from", from);
            }
            if (!TextUtils.isEmpty(value)) {
                jsonObject.put("value", value);
            }
            if (!TextUtils.isEmpty(extObj)) {
                jsonObject.put("ext", extObj);
            }
            NovelServiceManager.getNovelUBCManager().onEvent(eventId, jsonObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void exeUbcExtWithObj(String eventId, String type, String page, String source, String from, String value, JSONObject extJsonObj) {
        try {
            JSONObject jsonObject = new JSONObject();
            if (!TextUtils.isEmpty(type)) {
                jsonObject.put("type", type);
            }
            if (!TextUtils.isEmpty(page)) {
                jsonObject.put("page", page);
            }
            if (!TextUtils.isEmpty(source)) {
                jsonObject.put("source", source);
            }
            if (!TextUtils.isEmpty(from)) {
                jsonObject.put("from", from);
            }
            if (!TextUtils.isEmpty(value)) {
                jsonObject.put("value", value);
            }
            if (extJsonObj != null && extJsonObj.length() > 0) {
                jsonObject.put("ext", extJsonObj);
            }
            NovelServiceManager.getNovelUBCManager().onEvent(eventId, jsonObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
