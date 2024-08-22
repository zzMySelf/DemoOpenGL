package com.baidu.android.lbspay;

import com.dxmpay.apollon.restnet.RestNameValuePair;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CashierDataNew implements Serializable {
    public static final String AUTHORIZE_DATA_ID = "authorizeData";
    public static final String CUSTOMER_ID = "customerId";
    public static final String CUSTOMER_UID = "customerUid";
    public static final String DEFAULT_RES_PAGE = "defaultResPage";
    public static String DELIVERY_CASHIER_CONTENT = "delivery_cashier_content";
    public static String DELIVERY_CASHIER_DATA = "delivery_cashier_data";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String EXPIRE_TIME = "orderExpireTime";
    public static final String EXT_DATA = "extData";
    public static final String IMIE = "imei";
    public static final String ITEM_INFO = "itemInfo";
    public static final String MOBILE = "mobile";
    public static final String NOTIFY_URL = "notifyUrl";
    public static final String ORDERID = "orderId";
    public static final String ORDER_CREATE_TIME = "orderCreateTime";
    public static final String ORIGINALAMOUNT_AMOUNT = "originalAmount";
    public static final String PASS_UID = "passuid";
    public static final String PAY_AMOUNT = "payAmount";
    public static final String RETURN_URL = "returnUrl";
    public static final String SDK = "sdk";
    public static final String SDK_STYLE = "sdkStyle";
    public static final String SERVICE = "service";
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "signType";
    public static final String TITLE = "title";
    public static final String TN = "tn";
    public static final String URL = "url";
    public static final long serialVersionUID = 1;
    public String customerId;
    public String defaultResPage;
    public String deviceType = "1";
    public String extData = "";
    public String failUrl;
    public String fuser = "";
    public String imei = "";
    public String itemInfo;
    public Map<String, String> mData;
    public Map<String, String[]> mExtraData;
    public String mobile;
    public String notifyUrl = "";
    public String orderCreateTime;
    public String orderId;
    public String passuid;
    public String payAmount;
    public String returnUrl = "";
    public String sdk;
    public String service;
    public boolean showAllPayType;
    public String sign;
    public String signType;
    public String title;
    public String tn;
    public String url;

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

    public String amount() {
        Map<String, String> map = this.mData;
        return map != null ? map.get("payAmount") : "";
    }

    public String getAuthorizeDataId() {
        Map<String, String> map = this.mData;
        return map != null ? map.get(AUTHORIZE_DATA_ID) : "";
    }

    public String getCustomId() {
        Map<String, String> map = this.mData;
        return map != null ? map.get("customerId") : "";
    }

    public Map<String, String> getData() {
        return this.mData;
    }

    public String getGoodsName() {
        Map<String, String> map = this.mData;
        return map != null ? map.get("title") : "";
    }

    public String[] getOderInfoDescArray() {
        Map<String, String[]> map = this.mExtraData;
        if (map != null) {
            return map.get("orderInfoDescArray");
        }
        return null;
    }

    public String getOrderNo() {
        Map<String, String> map = this.mData;
        return map != null ? map.get("orderId") : "";
    }

    public boolean isShowAllPayType() {
        return this.showAllPayType;
    }

    public String originAmount() {
        Map<String, String> map = this.mData;
        return map != null ? map.get("originalAmount") : "";
    }

    public void setData(Map<String, String> map) {
        this.mData = map;
    }

    public void setExtraData(Map<String, String[]> map) {
        this.mExtraData = map;
    }

    public void setShowAllPayType(boolean z) {
        this.showAllPayType = z;
    }
}
