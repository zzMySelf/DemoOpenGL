package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.dxmpay.wallet.core.beans.BeanRequestBase;

public class b extends BeanRequestBase {
    public String a;
    public String b;
    public String c;
    public String d;

    public b(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public boolean checkRequestValidity() {
        return !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d);
    }

    public String getRequestId() {
        return DxmPayBeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
