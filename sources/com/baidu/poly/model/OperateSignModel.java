package com.baidu.poly.model;

import com.baidu.poly.util.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SearchBox */
public class OperateSignModel {
    public String msg;
    public String signUrl;
    public String signUserId;
    public int status;

    public static JSONObject parseToJSON(OperateSignModel operateSignModel) {
        if (operateSignModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("signUrl", operateSignModel.signUrl);
            jSONObject.put("signUserId", operateSignModel.signUserId);
            jSONObject.put("status", operateSignModel.status);
            jSONObject.put("msg", operateSignModel.msg);
        } catch (JSONException e2) {
            Logger.info("JSONException" + e2.getMessage());
        }
        return jSONObject;
    }

    public static OperateSignModel parseToModel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OperateSignModel operateSignModel = new OperateSignModel();
        String str = "";
        operateSignModel.signUrl = jSONObject.isNull("signUrl") ? str : jSONObject.optString("signUrl");
        operateSignModel.signUserId = jSONObject.isNull("signUserId") ? str : jSONObject.optString("signUserId");
        operateSignModel.status = jSONObject.isNull("status") ? 0 : jSONObject.optInt("status");
        if (!jSONObject.isNull("msg")) {
            str = jSONObject.optString("msg");
        }
        operateSignModel.msg = str;
        return operateSignModel;
    }
}
