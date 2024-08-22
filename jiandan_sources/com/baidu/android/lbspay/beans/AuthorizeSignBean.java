package com.baidu.android.lbspay.beans;

import android.content.Context;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.network.AuthorizeSignContent;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.OSUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeSignBean extends BaseBean<AuthorizeSignContent> {
    public static final String TAG = "AuthorizeSignBean";
    public AuthorizeData mAuthSignData;

    public AuthorizeSignBean(Context context) {
        super(context);
    }

    public void execBean() {
        execBean(AuthorizeSignContent.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        AuthorizeData authorizeData = this.mAuthSignData;
        if (authorizeData != null) {
            authorizeData.addParams(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RestNameValuePair restNameValuePair = (RestNameValuePair) it.next();
            if ("reqData".equals(restNameValuePair.getName())) {
                try {
                    JSONObject jSONObject = new JSONObject(restNameValuePair.getValue());
                    jSONObject.put(NetworkBean.PARAM_REAL_OS, OSUtils.getOSName(this.mContext));
                    restNameValuePair.setValue(jSONObject.toString());
                    break;
                } catch (JSONException e) {
                    LogUtil.e(TAG, e.getMessage(), e);
                }
            }
        }
        return arrayList;
    }

    public int getBeanId() {
        return 3;
    }

    public int getHttpMethod() {
        return 1;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getZhiFuHost() + "/epic/authorize/sign";
    }

    public boolean isLbsPayBean() {
        return true;
    }

    public void setAuthorizeData(AuthorizeData authorizeData) {
        this.mAuthSignData = authorizeData;
    }
}
