package com.baidu.sapi2.httpwrap;

import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, String> buildCommonParams() {
        SapiConfiguration confignation;
        HashMap hashMap = new HashMap();
        hashMap.put("client", SapiDeviceInfo.OS_TYPE);
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        if (!(isAccountManager == null || (confignation = isAccountManager.getConfignation()) == null)) {
            String clientId = SapiUtils.getClientId(confignation.context);
            hashMap.put("cuid", clientId);
            hashMap.put("clientid", clientId);
            hashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
            hashMap.put("zid", isAccountManager.getCurrentZid(confignation.context));
            hashMap.put("clientip", confignation.clientIp);
            hashMap.put("appid", confignation.appId);
            hashMap.put("tpl", confignation.tpl);
            hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
            hashMap.put("sdk_version", isAccountManager.getVersionName());
            hashMap.put("sdkversion", isAccountManager.getVersionName());
        }
        return hashMap;
    }
}
