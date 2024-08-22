package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.List;

public class SdkInitBean extends BaseBean<SdkInitResponse> {
    public static final int BACHUP_INIT_YTPE = 3;
    public static final int NEW_INIT_TYPE = 2;
    public static final int OLD_INIT_TYPE = 1;
    public static String b = "";
    public int a = -1;

    public <T> SdkInitBean(Context context) {
        super(context);
    }

    public static void setContentSignForReq(String str) {
        b = str;
    }

    public boolean checkSignSame(String str) {
        return !TextUtils.isEmpty(b) && b.equals(str);
    }

    public void execBean() {
        super.execBean(SdkInitResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("contentSign", b));
        LogUtil.i("SdkInitBean", "contentSign" + b);
        return arrayList;
    }

    public int getBeanId() {
        int i2 = this.a;
        if (i2 == 2) {
            return 786;
        }
        if (i2 != 3) {
            return 530;
        }
        return BeanConstants.BEAN_ID_FOR_BACKUP_INIT;
    }

    public String getUrl() {
        String str;
        LogUtil.i("SdkInitBean", "tag is: " + this.tag[0]);
        int i2 = this.a;
        if (i2 == 1) {
            str = DomainConfig.getInstance().getInitHost(1, this.tag);
        } else if (i2 == 2) {
            str = DomainConfig.getInstance().getInitHost(2, this.tag);
        } else if (i2 != 3) {
            str = DomainConfig.getInstance().getInitHost(1, this.tag);
        } else {
            str = DomainConfig.getInstance().getInitHost(3, this.tag);
        }
        LogUtil.i("SdkInitBean", "tag1 is: " + this.tag[0]);
        return str + "/odp/wireless/sdk/init";
    }

    public boolean needVerifySignature() {
        return true;
    }

    public void setType(int i2) {
        this.a = i2;
    }
}
