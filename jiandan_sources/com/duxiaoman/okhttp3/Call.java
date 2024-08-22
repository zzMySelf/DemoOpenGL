package com.duxiaoman.okhttp3;

import fe.th.de.ddd;
import fe.th.de.mmm;
import java.io.IOException;

public interface Call extends Cloneable {

    public interface Factory {
    }

    void cancel();

    mmm execute() throws IOException;

    void qw(Callback callback);

    ddd request();
}
