package com.baidu.wallet.base.iddetect.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.iddetect.IDDetectConstants;
import com.baidu.wallet.base.iddetect.datamodel.IDDetectResponse;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BaseBean;
import java.util.ArrayList;
import java.util.List;

public class IDDetectBean extends BaseBean<IDDetectResponse> {
    public String mIdPic = "";

    public <T> IDDetectBean(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(IDDetectResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("id_pic", this.mIdPic));
        return arrayList;
    }

    public int getBeanId() {
        return IDDetectBeanFactory.BEAN_ID_ID_DETECT;
    }

    public String getEncode() {
        return "gbk";
    }

    public int getHttpMethod() {
        return 1;
    }

    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getWalletHttpsHost() + IDDetectConstants.API_ID_DETECT_BEAN;
    }

    public void setBeanParams(String str) {
        this.mIdPic = str;
    }
}
