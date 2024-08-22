package com.baidu.searchbox.log.core.util;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.log.inter.model.ABLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ABFileUtil {
    public static String jsonString(ABLog.ABFile file) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("path", file.mPath);
            jsonObject.put("delete", file.mDelete);
            jsonObject.put("alias", file.mAlias);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return jsonObject.toString();
    }

    public static String setToString(HashSet<ABLog.ABFile> filePaths) {
        JSONArray jsonArray = new JSONArray();
        if (filePaths != null) {
            Iterator iterator = filePaths.iterator();
            while (iterator.hasNext()) {
                jsonArray.put(jsonString(iterator.next()));
            }
        }
        return jsonArray.toString();
    }

    public static ABLog.ABFile fromJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        if (jsonObject == null) {
            return null;
        }
        String path = jsonObject.optString("path");
        boolean delete = jsonObject.optBoolean("delete");
        String alias = jsonObject.optString("alias");
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return new ABLog.ABFile(path, alias, delete);
    }

    public static HashSet<ABLog.ABFile> jsonToSet(String str) {
        HashSet<ABLog.ABFile> fileSet = new HashSet<>();
        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                fileSet.add(fromJson(jsonArray.get(i2).toString()));
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return fileSet;
    }
}
