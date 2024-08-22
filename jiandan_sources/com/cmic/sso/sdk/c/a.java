package com.cmic.sso.sdk.c;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public abstract class a extends SSLSocketFactory {
    public SSLSocketFactory delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
}
