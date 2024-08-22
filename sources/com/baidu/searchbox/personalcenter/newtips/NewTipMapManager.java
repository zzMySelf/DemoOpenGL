package com.baidu.searchbox.personalcenter.newtips;

import com.baidu.searchbox.newtips.type.NewTipsNodeID;
import java.util.HashMap;
import java.util.Map;

public class NewTipMapManager {
    private static volatile NewTipMapManager sSingleTon;
    public Map<String, NewTipsNodeID> mNewTipsHandleMap;

    public static NewTipMapManager getInstanse() {
        if (sSingleTon == null) {
            synchronized (NewTipMapManager.class) {
                if (sSingleTon == null) {
                    sSingleTon = new NewTipMapManager();
                }
            }
        }
        return sSingleTon;
    }

    public NewTipMapManager() {
        HashMap hashMap = new HashMap();
        this.mNewTipsHandleMap = hashMap;
        hashMap.put("download", NewTipsNodeID.PersonalDownloadItem);
    }
}
