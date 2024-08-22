package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAppFromCheck extends OpenAppBaseCheck implements IFromCheck {
    private static final String DATA_TAG_FROM_LIST = "from_wlist";
    private static final String SCHEME_FROM_WHITE_LIST_FILENAME = "scheme_from_white_list_invoke";
    private static final String TAG = "OpenAppFromCheck";
    private ArrayList<String> mFromWhiteKeyList = new ArrayList<>();
    private HashMap<String, List<SchemeCheckInfo>> mFromWhiteMap = new HashMap<>();

    public boolean saveWhiteListDispatch(JSONObject data) {
        JSONObject fromData = data.optJSONObject(DATA_TAG_FROM_LIST);
        if (fromData == null) {
            if (DEBUG) {
                Log.d(TAG, "from whitelist is empty");
            }
            return false;
        } else if (!FileUtils.cache(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME, fromData.toString(), 0)) {
            return false;
        } else {
            synchronized (this) {
                this.mFromWhiteMap.clear();
                this.mFromWhiteKeyList.clear();
                Iterator<String> fromKey = fromData.keys();
                while (fromKey.hasNext()) {
                    String fileName = fromKey.next();
                    JSONArray arrayList = fromData.optJSONArray(fileName);
                    if (arrayList != null) {
                        generateItem(fileName, arrayList);
                        this.mFromWhiteKeyList.add(fileName);
                    }
                }
            }
            return true;
        }
    }

    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                OpenAppFromCheck.this.loadFromWhiteList();
                FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_from_white_list");
            }
        }, "SchemeFromWhiteListLoad", 2);
    }

    /* access modifiers changed from: private */
    public void loadFromWhiteList() {
        try {
            saveFromDataToCache(new JSONObject(FileUtils.readCacheData(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME)));
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private synchronized void saveFromDataToCache(JSONObject fromData) {
        this.mFromWhiteMap.clear();
        this.mFromWhiteKeyList.clear();
        Iterator<String> fromKey = fromData.keys();
        while (fromKey.hasNext()) {
            String fileName = fromKey.next();
            JSONArray arrayList = fromData.optJSONArray(fileName);
            if (arrayList != null) {
                generateItem(fileName, arrayList);
                this.mFromWhiteKeyList.add(fileName);
            }
        }
    }

    private synchronized void generateItem(String fileName, JSONArray arrayList) {
        List<String> dataList = new ArrayList<>();
        int listSize = arrayList.length();
        for (int index = 0; index < listSize; index++) {
            dataList.add(arrayList.optString(index));
        }
        this.mFromWhiteMap.put(fileName, SchemeCheckInfoKt.toSchemeCheckInfoList(dataList));
    }

    public SchemeCheckInfo checkSchemeInFromWhiteList(String originScheme, String fromKey, String refer) {
        if (TextUtils.isEmpty(originScheme) || TextUtils.isEmpty(fromKey)) {
            return null;
        }
        SchemeCheckInfo match = null;
        synchronized (this) {
            if (this.mFromWhiteMap.get(fromKey) != null) {
                match = getInfoInList(originScheme, this.mFromWhiteMap.get(fromKey));
                SchemeForbidStatisticUtils.onEvent(originScheme, originScheme, true, canInvoke(match), "from", refer);
            }
        }
        return match;
    }

    public synchronized ArrayList<String> getFromKeyList() {
        return (ArrayList) this.mFromWhiteKeyList.clone();
    }
}
