package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import java.io.Serializable;
import java.util.Map;

public class PwdRequest extends BeanRequestBase implements Serializable {
    public static final int FROM_CHECK = 1;
    public static final int FROM_CREATE = 3;
    public static final int FROM_EDIT = 2;
    public static final int FROM_RNAUTH_SETTING = 4;
    public static final int FROM_SETTING = 0;
    public static final int REQUEST_TYPE_CHECK = 1;
    public static final int REQUEST_TYPE_MODIFY = 3;
    public static final int REQUEST_TYPE_VERIFY = 2;
    public static final long serialVersionUID = 3208920939235207235L;
    public String fromType;
    public String mConfirmPayPass;
    public Map<String, String> mExtData;
    public int mFrom = 1;
    public String mPayPass;
    public int mRequestType = 1;
    public String mSessionKey;
    public String serviceType;

    public boolean checkRequestValidity() {
        if (this.mRequestType == 3) {
            return !TextUtils.isEmpty(this.mPayPass);
        }
        return true;
    }

    public String getRequestId() {
        setBelongPaySdk();
        return DxmPayBeanConstants.REQUEST_ID_PWD;
    }
}
