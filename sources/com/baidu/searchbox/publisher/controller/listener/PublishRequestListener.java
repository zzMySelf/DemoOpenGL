package com.baidu.searchbox.publisher.controller.listener;

public interface PublishRequestListener {
    void onFailed(String str, String str2, String str3, String str4);

    void onSuccess(String str);
}
