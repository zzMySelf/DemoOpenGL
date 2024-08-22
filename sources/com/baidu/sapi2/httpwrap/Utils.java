package com.baidu.sapi2.httpwrap;

import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.Map;

class Utils {
    Utils() {
    }

    static Map<String, String> buildCommonParams() {
        SapiConfiguration config;
        Map<String, String> commonParams = new HashMap<>();
        commonParams.put("client", "android");
        ISAccountManager accountManager = ServiceManager.getInstance().getIsAccountManager();
        if (!(accountManager == null || (config = accountManager.getConfignation()) == null)) {
            String clientId = SapiUtils.getClientId(config.context);
            commonParams.put("cuid", clientId);
            commonParams.put("clientid", clientId);
            commonParams.put("clientfrom", "native");
            commonParams.put("zid", accountManager.getCurrentZid(config.context));
            commonParams.put("clientip", config.clientIp);
            commonParams.put("appid", config.appId);
            commonParams.put("tpl", config.tpl);
            commonParams.put("app_version", SapiUtils.getVersionName(config.context));
            commonParams.put("sdk_version", accountManager.getVersionName());
            commonParams.put("sdkversion", accountManager.getVersionName());
        }
        return commonParams;
    }
}
