package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    public final int zzas;

    public GooglePlayServicesRepairableException(int i2, String str, Intent intent) {
        super(str, intent);
        this.zzas = i2;
    }

    public int getConnectionStatusCode() {
        return this.zzas;
    }
}
