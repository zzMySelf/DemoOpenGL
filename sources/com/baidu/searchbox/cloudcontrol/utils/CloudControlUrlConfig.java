package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;

public class CloudControlUrlConfig {
    private static final String KEY_RUN_TYPE = "runtype";
    private static final String KEY_TYPE_ID = "type_id";
    private static final String OEM_NAME_SPACE = "OEMConfig";
    private static final String OEM_TYPE_ID = "OEM_TYPE_ID";
    private static String mDebugHost = "";
    private static String mOEMTypeId = "0";
    private static final String mUrl = "%s/ccs/v1/start/confsync";

    public static void setDebugHost(String debugHost) {
        mDebugHost = debugHost;
    }

    public static void setOemTypeId(String oemTypeId) {
        mOEMTypeId = oemTypeId;
    }

    public static String getCloudControlUrl(String runType) {
        String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
        if (AppConfig.isDebug() && !TextUtils.isEmpty(mDebugHost)) {
            searchboxHostForHttps = mDebugHost;
        }
        String url = CommonUrlParamManager.getInstance().appendParam(String.format(mUrl, new Object[]{searchboxHostForHttps}), 1);
        if (!TextUtils.isEmpty(runType)) {
            url = UrlUtil.addParam(url, KEY_RUN_TYPE, runType);
        }
        String typeId = String.valueOf(mOEMTypeId);
        if (!TextUtils.isEmpty(typeId)) {
            return UrlUtil.addParam(url, "type_id", typeId);
        }
        return url;
    }
}
