package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.InstallBase;
import com.baidu.cyberplayer.sdk.context.ICyberMediaContext;
import com.baidu.cyberplayer.sdk.context.ICyberStatistic;
import java.lang.reflect.Method;

public final class UbcSessionUploader {
    private static final String SERVICE_MANAGER_CALSS_NAME = "com.baidu.pyramid.runtime.service.ServiceManager";
    private static final String SERVICE_REFERENCE_CLASS_NAME = "com.baidu.pyramid.runtime.service.ServiceReference";
    private static final String TAG = "UbcSessionUploader";
    private static final String UBC_BAIDUURLEXP_ID = "5790";
    private static final String UBC_BAIDUURL_ID = "5793";
    private static final String UBC_CYBERDOWN_ID = "5960";
    private static final String UBC_DEADLINK_ID = "5927";
    private static final String UBC_DLNA_ID = "5784";
    private static final String UBC_DOWNLOAD_ID = "5785";
    private static final String UBC_FLOWSTAT_ID = "5792";
    private static final String UBC_GRAYRELEASE_ID = "5786";
    private static final String UBC_INIT_ID = "5787";
    private static final String UBC_MANAGER_CLASS_NAME = "com.baidu.ubc.UBCManager";
    private static final String UBC_NOSTART_ID = "5789";
    private static final String UBC_NOTBAIDUURL_ID = "5791";
    public static final String UBC_SUBP_ID = "5248";
    public static final int UBC_TYPE_BAIDU_URL = -1009;
    public static final int UBC_TYPE_BAIDU_URL_EXP = -1006;
    public static final int UBC_TYPE_CYBER_DOWN_INIT = -1012;
    public static final int UBC_TYPE_DLNA = -1013;
    public static final int UBC_TYPE_DOWNLOAD = -1003;
    public static final int UBC_TYPE_FLOW_STAT = -1008;
    public static final int UBC_TYPE_GRAY_RELEASE = -1004;
    public static final int UBC_TYPE_INIT = -1010;
    public static final int UBC_TYPE_NOT_BAIDU_URL = -1007;
    public static final int UBC_TYPE_NO_START = -1005;
    public static final int UBC_TYPE_VIDEO_DEAD_LINK = -1011;
    private static UbcSessionUploader ubcInstance;
    private Method mOnEvent = null;
    private Object mUbcManager = null;

    private UbcSessionUploader() {
    }

    private void onSessionEvent(String uid, String content) {
        ICyberStatistic cyberStatistic;
        ICyberMediaContext cyberMediaContext = InstallBase.getCyberMediaContext();
        if (cyberMediaContext != null && (cyberStatistic = cyberMediaContext.getCyberStatistic()) != null) {
            CyberLog.d(TAG, "UBC upload by Dependency-Inject, UBCID: " + uid);
            cyberStatistic.onSessionEvent(uid, content);
        }
    }

    public void upload(String aContent, String serverType, int uploadType) {
        String uid;
        if (CyberGlobalSetting.getInstance().isUbcUploadEnable()) {
            switch (uploadType) {
                case -1013:
                    uid = UBC_DLNA_ID;
                    break;
                case -1012:
                    uid = UBC_CYBERDOWN_ID;
                    break;
                case -1011:
                    uid = UBC_DEADLINK_ID;
                    break;
                case -1010:
                    uid = UBC_INIT_ID;
                    break;
                case -1009:
                    uid = UBC_BAIDUURL_ID;
                    break;
                case -1008:
                    uid = UBC_FLOWSTAT_ID;
                    break;
                case -1007:
                    uid = UBC_NOTBAIDUURL_ID;
                    break;
                case -1006:
                    uid = UBC_BAIDUURLEXP_ID;
                    break;
                case -1005:
                    uid = UBC_NOSTART_ID;
                    break;
                case -1004:
                    uid = UBC_GRAYRELEASE_ID;
                    break;
                case -1003:
                    uid = UBC_DOWNLOAD_ID;
                    break;
                default:
                    return;
            }
            try {
                onSessionEvent(uid, aContent);
            } catch (Exception e2) {
            }
        }
    }

    public void upload(String ubcId, String aContent) {
        if (CyberGlobalSetting.getInstance().isUbcUploadEnable()) {
            onSessionEvent(ubcId, aContent);
        }
    }

    public static synchronized UbcSessionUploader getInstance() {
        UbcSessionUploader ubcSessionUploader;
        synchronized (UbcSessionUploader.class) {
            if (ubcInstance == null) {
                ubcInstance = new UbcSessionUploader();
            }
            ubcSessionUploader = ubcInstance;
        }
        return ubcSessionUploader;
    }
}
