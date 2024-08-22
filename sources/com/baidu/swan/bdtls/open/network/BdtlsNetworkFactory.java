package com.baidu.swan.bdtls.open.network;

import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;

public class BdtlsNetworkFactory {
    public static HttpRequestBuilder getRequestBuilder(BdtlsNetworkConfig config, BdtlsHttpManager httpManager) {
        HttpCommonRequestBuilder builder;
        if (httpManager == null) {
            httpManager = BdtlsHttpManager.getDefault();
        }
        String str = config.method;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c2 = 2;
                    break;
                }
                break;
            case 70454:
                if (str.equals("GET")) {
                    c2 = 0;
                    break;
                }
                break;
            case 79599:
                if (str.equals("PUT")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2213344:
                if (str.equals("HEAD")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2461856:
                if (str.equals("POST")) {
                    c2 = 3;
                    break;
                }
                break;
            case 80083237:
                if (str.equals("TRACE")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1669334218:
                if (str.equals("CONNECT")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2012838315:
                if (str.equals("DELETE")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return httpManager.getRequest();
            case 1:
                return httpManager.headerRequest();
            case 2:
                builder = httpManager.optionsRequest();
                break;
            case 3:
                builder = httpManager.postRequest();
                break;
            case 4:
                builder = httpManager.putRequest();
                break;
            case 5:
                builder = httpManager.deleteRequest();
                break;
            case 6:
                builder = httpManager.traceRequest();
                break;
            case 7:
                builder = httpManager.connectRequest();
                break;
            default:
                return httpManager.getRequest();
        }
        if (config.requestBody != null) {
            builder.requestBody(config.requestBody);
        }
        return builder;
    }

    public static HttpRequestBuilder getRequestBuilder(BdtlsNetworkConfig config) {
        return getRequestBuilder(config, (BdtlsHttpManager) null);
    }
}
