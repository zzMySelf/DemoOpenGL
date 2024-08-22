package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class GetOnlineRequestShareModel {
    public static final String FROM_INTER_FLOW_NO = "0";
    public static final String FROM_INTER_FLOW_YES = "1";
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineRequestShareModel() {
    }

    public static JSONObject parseModel2JsonObject(GetOnlineRequestShareModel getOnlineRequestShareModel) {
        if (getOnlineRequestShareModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            jSONObject.put("app", getOnlineRequestShareModel.app == null ? str : getOnlineRequestShareModel.app);
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, getOnlineRequestShareModel.pkg == null ? str : getOnlineRequestShareModel.pkg);
            if (getOnlineRequestShareModel.bduss != null) {
                str = getOnlineRequestShareModel.bduss;
            }
            jSONObject.put("bduss", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public GetOnlineRequestShareModel(ShareStorage.StorageModel storageModel) {
        if (storageModel != null) {
            this.app = storageModel.app;
            this.pkg = storageModel.pkg;
            this.bduss = storageModel.bduss;
        }
    }
}
