package com.baidu.searchbox.http;

public interface IClientIPProvider {
    String getClientIP();

    String getClientIPv6();

    void notifyChanged(String str);
}
