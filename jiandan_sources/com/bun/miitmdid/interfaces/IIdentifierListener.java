package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;

@Keep
public interface IIdentifierListener {
    @Keep
    void onSupport(IdSupplier idSupplier);
}
