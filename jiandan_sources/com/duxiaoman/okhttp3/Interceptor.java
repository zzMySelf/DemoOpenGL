package com.duxiaoman.okhttp3;

import fe.th.de.ddd;
import fe.th.de.mmm;
import java.io.IOException;

public interface Interceptor {

    public interface Chain {
        int connectTimeoutMillis();

        Connection connection();

        mmm qw(ddd ddd) throws IOException;

        int readTimeoutMillis();

        ddd request();

        int writeTimeoutMillis();
    }

    mmm intercept(Chain chain) throws IOException;
}
