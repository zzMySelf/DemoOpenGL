package com.baidu.poly.http;

import com.baidu.poly.util.param.PolyParam;

/* compiled from: SearchBox */
public interface b {
    void doParamPost(String str, PolyParam polyParam, Callback<String> callback);

    void doPost(String str, Headers headers, Forms forms, Callback<String> callback);

    void post(String str, Headers headers, Forms forms, Callback<String> callback);
}
