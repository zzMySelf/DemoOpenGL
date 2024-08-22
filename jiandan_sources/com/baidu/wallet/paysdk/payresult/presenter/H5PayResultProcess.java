package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public abstract class H5PayResultProcess {
    public Context mContext;
    public H5ResultParams mH5;
    public String mQueryResultString;

    public static String getProcessedParams(List<RestNameValuePair> list, String str) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String processedParams = new RestUrlConnectionRequest((RestHttpNetwork) null, (String) null, (HttpDefines$HttpMethod) null, list, (RestMultipartEntity) null, str).getProcessedParams();
        if (processedParams == null) {
            return processedParams;
        }
        try {
            return URLEncoder.encode(processedParams, str);
        } catch (UnsupportedEncodingException e) {
            LogUtil.e("H5PayResultProcess", e.getMessage(), e);
            return processedParams;
        }
    }

    public abstract void afterShow();

    public abstract void beforeShow();

    public abstract void show();
}
