package com.baidu.searchbox.cloudcontrol.processor;

import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import fe.fe.ddd.yj.ad.de;
import fe.fe.ddd.yj.ad.fe;
import org.json.JSONException;
import org.json.JSONObject;

public interface ICloudControlProcessor {
    de ad(String str, boolean z, JSONObject jSONObject);

    void qw(fe feVar, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException;
}
