package com.baidu.android.lbspay.beans;

import android.content.Context;
import com.baidu.android.lbspay.network.SignResultResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.OSUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SignResultBean extends BaseBean<SignResultResponse> {
    public static final String TAG = "SignResultBean";
    public String mUrl;

    public SignResultBean(Context context) {
        super(context);
    }

    public void execBean() {
        execBean(SignResultResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NetworkBean.PARAM_REAL_OS, OSUtils.getOSName(this.mContext));
            arrayList.add(new RestNameValuePair("reqData", jSONObject.toString()));
        } catch (JSONException e) {
            LogUtil.e(TAG, e.getMessage(), e);
        }
        return arrayList;
    }

    public int getBeanId() {
        return 4;
    }

    public int getHttpMethod() {
        return 1;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isLbsPayBean() {
        return true;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
