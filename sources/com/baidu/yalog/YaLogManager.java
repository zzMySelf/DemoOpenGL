package com.baidu.yalog;

import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;

public interface YaLogManager {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("yaLog", "yaLogConfig");

    float getSingleMaxSize();

    float getTotalMaxSize();

    boolean isClearLocalLog();

    boolean isGlobalSwitchOn();

    void registerConfig(JSONObject jSONObject);

    void registerIdConfig(JSONObject jSONObject, boolean z);
}
