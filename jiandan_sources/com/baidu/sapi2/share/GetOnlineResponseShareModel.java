package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class GetOnlineResponseShareModel {
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineResponseShareModel() {
    }

    public static JSONObject parseModel2JsonObject(GetOnlineResponseShareModel getOnlineResponseShareModel) {
        if (getOnlineResponseShareModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            jSONObject.put("app", getOnlineResponseShareModel.app == null ? str : getOnlineResponseShareModel.app);
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, getOnlineResponseShareModel.pkg == null ? str : getOnlineResponseShareModel.pkg);
            if (getOnlineResponseShareModel.bduss != null) {
                str = getOnlineResponseShareModel.bduss;
            }
            jSONObject.put("bduss", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public GetOnlineResponseShareModel(ShareStorage.StorageModel storageModel) {
        if (storageModel != null) {
            this.app = storageModel.app;
            this.pkg = storageModel.pkg;
            this.bduss = storageModel.bduss;
        }
    }
}
