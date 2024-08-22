package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.rest.RestHttpNetwork;
import com.baidu.apollon.restnet.rest.d;
import java.util.List;

public class c {
    public static c a;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public d a(Context context, String str, String str2, String str3, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        Context context2 = context;
        String str5 = str2;
        return new RestUrlConnectionRequest(new RestHttpNetwork(new a(context, str2, z)), str3, httpMethod, list, restMultipartEntity, str4);
    }
}
