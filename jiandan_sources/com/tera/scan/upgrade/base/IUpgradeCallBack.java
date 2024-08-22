package com.tera.scan.upgrade.base;

import com.tera.scan.upgrade.model.UpdateInfo;
import org.json.JSONObject;

public interface IUpgradeCallBack {
    void ad(JSONObject jSONObject);

    void de(JSONObject jSONObject);

    void fe(UpdateInfo updateInfo);

    void qw(JSONObject jSONObject);
}
