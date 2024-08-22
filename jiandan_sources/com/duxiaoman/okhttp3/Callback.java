package com.duxiaoman.okhttp3;

import fe.th.de.mmm;
import java.io.IOException;

public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, mmm mmm) throws IOException;
}
