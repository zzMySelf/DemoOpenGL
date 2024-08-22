package com.baidu.searchbox.http.cronet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface ICronet {
    public static final ICronet qw = new qw();

    public class qw implements ICronet {
        public HttpURLConnection ad(URL url) throws IOException {
            return null;
        }

        public void de(URL url) {
        }

        public boolean qw() {
            return false;
        }
    }

    HttpURLConnection ad(URL url) throws IOException;

    void de(URL url);

    boolean qw();
}
