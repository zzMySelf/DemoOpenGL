package com.baidu.searchbox.player.utils;

import com.baidu.abtest.ExpInfo;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.video.videoplayer.httpdns.VideoHttpDns2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BdCyberABTestManager {
    private static BdCyberABTestManager sManager;
    private VideoHttpDns2 mHttpDns2;
    private final Map<String, String> mOpts = new HashMap();

    private BdCyberABTestManager() {
    }

    public static BdCyberABTestManager getInstance() {
        if (sManager == null) {
            synchronized (AbTestManager.class) {
                if (sManager == null) {
                    sManager = new BdCyberABTestManager();
                }
            }
        }
        return sManager;
    }

    public synchronized Map<String, String> getCyberABTestOpts() {
        if (this.mOpts.size() == 0) {
            Iterator<String> it = AbTestManager.getInstance().getRawSwitch().keys();
            if (it != null) {
                while (it.hasNext()) {
                    String key = it.next();
                    if (key.startsWith("cybermedia_abtest_")) {
                        this.mOpts.put(key, AbTestManager.getInstance().getSwitch(key, ""));
                    }
                }
            }
            this.mOpts.put("abtest_sid", getSidString());
        }
        return this.mOpts;
    }

    public String getSidString() {
        List<ExpInfo> list = AbTestManager.getInstance().getExperimentInfoList();
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (ExpInfo expInfo : list) {
            builder.append(expInfo.getExpId()).append("_").append(expInfo.getExpComponentKey()).append("-");
        }
        return builder.substring(0, builder.length() - 1);
    }

    public VideoHttpDns2 getHttpDns() {
        if (this.mHttpDns2 == null) {
            this.mHttpDns2 = new VideoHttpDns2();
        }
        return this.mHttpDns2;
    }
}
