package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class ac extends BaseBean<Object> {
    public String a;
    public FeedbackDialog.c b;

    public ac(Context context) {
        super(context);
    }

    public void a(String str, FeedbackDialog.c cVar) {
        this.a = str;
        this.b = cVar;
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("trans_no", this.a));
        arrayList.add(new RestNameValuePair("score", "" + this.b.a));
        FeedbackDialog.c cVar = this.b;
        arrayList.add(new RestNameValuePair("tag_list", a(cVar != null ? cVar.b : null)));
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SAVE_FEEDBACK;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SAVE_FEEDBACK;
    }

    public String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            sb.append(strArr[0]);
            for (int i2 = 1; i2 < strArr.length; i2++) {
                sb.append(",");
                sb.append(strArr[i2]);
            }
            sb = new StringBuilder("[" + sb + "]");
        }
        return sb.toString();
    }
}
