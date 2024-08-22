package com.baidu.speech.utils.analysis;

import java.io.Serializable;
import java.util.HashMap;

public class StatisticsData implements Serializable {
    private static final long SerialVersionUID = 1;
    private String appname;
    private String dataCollectVersion;
    private int logId;
    private String os;
    private int real;
    private String sdkVersion;
    private String uid;

    public int getLogId() {
        return this.logId;
    }

    public void setLogId(int logId2) {
        this.logId = logId2;
    }

    public void setReal(int real2) {
        this.real = real2;
    }

    public void setUid(String uid2) {
        this.uid = uid2;
    }

    public void setAppname(String appname2) {
        this.appname = appname2;
    }

    public void setSdkVersion(String sdkVersion2) {
        this.sdkVersion = sdkVersion2;
    }

    public void setDataCollectVersion(String dataCollectVersion2) {
        this.dataCollectVersion = dataCollectVersion2;
    }

    public void setOs(String os2) {
        this.os = os2;
    }

    public int getReal() {
        return this.real;
    }

    public String getUid() {
        String str = this.uid;
        return str == null ? "" : str;
    }

    public String getAppname() {
        String str = this.appname;
        return str == null ? "" : str;
    }

    public String getSdkVersion() {
        String str = this.sdkVersion;
        return str == null ? "" : str;
    }

    public String getDataCollectVersion() {
        String str = this.dataCollectVersion;
        return str == null ? "" : str;
    }

    public String getOs() {
        String str = this.os;
        return str == null ? "" : str;
    }

    public static long getSerialVersionUID() {
        return 1;
    }

    public HashMap getStatisicsData() {
        HashMap StatisicsData = new HashMap();
        StatisicsData.put("logId", Integer.valueOf(getLogId()));
        StatisicsData.put("real", Integer.valueOf(getReal()));
        StatisicsData.put("uid", getUid());
        StatisicsData.put("appname", getAppname());
        StatisicsData.put("sdk_version", getSdkVersion());
        StatisicsData.put("data_collect_version", getDataCollectVersion());
        StatisicsData.put("os", getOs());
        return StatisicsData;
    }
}
