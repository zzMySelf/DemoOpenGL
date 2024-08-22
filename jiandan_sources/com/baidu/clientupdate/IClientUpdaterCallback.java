package com.baidu.clientupdate;

import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import org.json.JSONObject;

public interface IClientUpdaterCallback {
    void ad(JSONObject jSONObject);

    void de(JSONObject jSONObject);

    void fe(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo);

    void qw(JSONObject jSONObject);
}
