package com.android.msasdk;

import androidx.annotation.Keep;

@Keep
public interface FreemeIdsSupplier {
    @Keep
    void connect(IConnect iConnect);

    @Keep
    String getAAID(String str);

    @Keep
    String getOAID();

    @Keep
    String getUDID(String str);

    @Keep
    String getVAID(String str);

    @Keep
    boolean isSupported();

    @Keep
    void shutDown();
}
