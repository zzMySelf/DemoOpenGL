package com.baidu.ar.cloud;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.a;
import com.baidu.ar.p.u;
import java.util.HashMap;

public class c {
    private static String a(IHttpRequest iHttpRequest) {
        if (iHttpRequest == null) {
            return null;
        }
        try {
            IHttpResponse execute = iHttpRequest.execute();
            if (execute.isSuccess()) {
                return execute.getContent();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, HashMap hashMap, byte[] bArr) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return null;
        }
        newRequest.setMethod("POST").setUrl(str).setAsMultipart();
        if (hashMap != null) {
            newRequest.addPartMap(hashMap);
        }
        newRequest.addFile("image", bArr);
        newRequest.setAsMultipart();
        return a(newRequest);
    }

    public static void a(a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConstants.HTTP_ENGINE_VERSION, Integer.valueOf(com.baidu.ar.p.c.a()));
        hashMap.put("business", "cloud_recognize");
        hashMap.put("os", "android");
        hashMap.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        String c2 = u.c();
        "http->" + c2;
        try {
            HttpFactory.newRequest().setUrl(c2).addHeader("Content-Type: application/x-www-form-urlencoded").setMethod("POST").addFormData(hashMap).enqueue(aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(a aVar, byte[] bArr) {
        String d2 = u.d();
        "http->" + d2;
        try {
            HttpFactory.newRequest().setUrl(d2).addHeader("Content-Type:application/protobuf").setMethod("POST").setBody(bArr).enqueue(aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
