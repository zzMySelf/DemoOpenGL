package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.NoProguard;

public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
