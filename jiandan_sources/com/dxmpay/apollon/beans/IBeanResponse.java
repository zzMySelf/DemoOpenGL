package com.dxmpay.apollon.beans;

import android.content.Context;
import com.dxmpay.apollon.NoProguard;

public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
