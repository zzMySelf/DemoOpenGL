package com.baidu.nps.pm;

import java.util.HashMap;
import java.util.Map;

public class BundleInfoGroup {
    private Map<Integer, BundleInfo> bundleInfoMap = new HashMap();
    private long timeStamp = 0;

    public BundleInfoGroup(long timeStamp2) {
        this.timeStamp = timeStamp2;
    }

    public synchronized BundleInfo getBundleByType(int bundleType) {
        return this.bundleInfoMap.get(Integer.valueOf(bundleType));
    }

    public synchronized void updateBundleByType(int bundleType, BundleInfo bundleInfo) {
        bundleInfo.setType(bundleType);
        this.bundleInfoMap.put(Integer.valueOf(bundleType), bundleInfo);
    }

    public synchronized void swapBundleByType(int fromType, int toType) {
        BundleInfo bundleInfo = this.bundleInfoMap.remove(Integer.valueOf(fromType));
        if (bundleInfo != null) {
            this.bundleInfoMap.put(Integer.valueOf(toType), bundleInfo);
        }
    }

    public synchronized void removeBundleByType(int type) {
        this.bundleInfoMap.remove(Integer.valueOf(type));
    }

    public synchronized long getTimeStamp() {
        return this.timeStamp;
    }

    public synchronized void setTimeStamp(long timeStamp2) {
        this.timeStamp = timeStamp2;
    }
}
