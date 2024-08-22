package com.baidu.talos.adapter;

public interface ICookieManagerAdapter {
    void flush();

    String getCookie(String str);

    void removeAllCookie();

    void removeExpiredCookie();

    void setCookie(String str, String str2);
}
