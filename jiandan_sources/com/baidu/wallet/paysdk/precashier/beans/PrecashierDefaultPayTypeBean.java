package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PrecashierDefaultPayTypeBean extends OtherBean<String> {
    public String a;

    public PrecashierDefaultPayTypeBean(Context context) {
        super(context);
    }

    private List<RestNameValuePair> a(List<RestNameValuePair> list, JSONObject jSONObject) {
        JSONArray names;
        Object obj;
        if (!(jSONObject == null || (names = jSONObject.names()) == null || names.length() <= 0)) {
            for (int i2 = 0; i2 < names.length(); i2++) {
                try {
                    Object obj2 = names.get(i2);
                    if (obj2 != null && (obj2 instanceof String)) {
                        String str = (String) obj2;
                        if (!TextUtils.isEmpty(str) && (obj = jSONObject.get(str)) != null) {
                            if (obj instanceof JSONObject) {
                                a(list, (JSONObject) obj);
                            } else {
                                list.add(new RestNameValuePair(str, obj.toString()));
                            }
                        }
                    }
                } catch (JSONException e) {
                    LogUtil.e("PrecashierDefaultPayTypeBean", e.getMessage(), e);
                }
            }
        }
        return list;
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.a == null) {
            return arrayList;
        }
        try {
            a(arrayList, new JSONObject(this.a));
        } catch (JSONException e) {
            LogUtil.e("PrecashierDefaultPayTypeBean", e.getMessage(), e);
        }
        return arrayList;
    }

    public int getBeanId() {
        return 1;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_PRECASHIER_DEFAULT_PAY_TYPE;
    }

    public boolean needNonce() {
        return false;
    }

    public void setParams(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
        }
    }
}
