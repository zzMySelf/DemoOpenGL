package com.baidu.wallet.core.beans.a;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class c extends a {
    public c(Context context) {
        super(context, 1);
    }

    public void execBean() {
        execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("fileName", "111111111111.txt"));
        return arrayList;
    }

    public int getBeanId() {
        return 1239309120;
    }

    public int getHttpMethod() {
        return super.getHttpMethod();
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppHost(this.tag) + "/odp/wireless/misc/app/saveFile";
    }
}
