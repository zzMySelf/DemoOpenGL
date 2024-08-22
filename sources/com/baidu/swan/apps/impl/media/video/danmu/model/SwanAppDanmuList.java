package com.baidu.swan.apps.impl.media.video.danmu.model;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class SwanAppDanmuList {
    private static final String COLOR_WHITE = "#FFFFFF";
    private List<SwanAppDanmuItem> danmuList;

    public static SwanAppDanmuList createFakeInstance() {
        SwanAppDanmuList data = new SwanAppDanmuList();
        List<SwanAppDanmuItem> list = new ArrayList<>();
        SwanAppDanmuItem item = new SwanAppDanmuItem();
        item.setSelf(false);
        item.setPlayTime("-1");
        item.setColor("#FFFFFF");
        item.setContent("");
        list.add(item);
        data.setDanmuList(list);
        return data;
    }

    public List<SwanAppDanmuItem> getDanmuList() {
        return this.danmuList;
    }

    public void setDanmuList(List<SwanAppDanmuItem> danmaList) {
        this.danmuList = danmaList;
    }

    public boolean isEmpty() {
        return getDanmuList() == null || getDanmuList().isEmpty();
    }

    public static SwanAppDanmuList fromJson(String param) {
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            JSONArray danmuArray = new JSONArray(param);
            SwanAppDanmuList data = new SwanAppDanmuList();
            List<SwanAppDanmuItem> danmuList2 = new ArrayList<>();
            int size = danmuArray.length();
            for (int index = 0; index < size; index++) {
                danmuList2.add(SwanAppDanmuItem.fromJson(danmuArray.getString(index)));
            }
            data.danmuList = danmuList2;
            return data;
        } catch (JSONException e2) {
            if (SwanAppLibConfig.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
