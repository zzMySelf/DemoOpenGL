package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrecashierModifyPayTypeBean extends BaseBean<PrecashierModifyPayTypeResponse> {
    public Map<String, String> rec_params;

    public PrecashierModifyPayTypeBean(Context context) {
        super(context);
    }

    public boolean checkRequestParamsAvalable() {
        Map<String, String> map = this.rec_params;
        return map != null && map.size() > 0 && !TextUtils.isEmpty(this.rec_params.get(StatHelper.SP_NO)) && !TextUtils.isEmpty("serial_num");
    }

    public void execBean() {
        super.execBean(PrecashierModifyPayTypeResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        if (!checkRequestParamsAvalable()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = this.rec_params;
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = this.rec_params.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry next = it.next();
                if (next != null) {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    if (!(key == null || !(key instanceof String) || value == null)) {
                        arrayList.add(new RestNameValuePair((String) key, value.toString()));
                    }
                }
            }
        }
        return arrayList;
    }

    public int getBeanId() {
        return 2;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_PRECASHIER_MODIFY_PAY_TYPE;
    }
}
