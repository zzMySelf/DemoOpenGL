package com.baidu.android.lbspay.datamodel;

import com.dxmpay.apollon.restnet.RestNameValuePair;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AuthorizeData implements Serializable {
    public static String DELIVERY_AUTHORIZE_DATA = "delivery_authorize_data";
    public Map<String, String> mData;

    public void addParams(List<RestNameValuePair> list) {
        Map<String, String> map = this.mData;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                list.add(new RestNameValuePair(str, str2));
            }
        }
    }

    public void setData(Map<String, String> map) {
        this.mData = map;
    }
}
