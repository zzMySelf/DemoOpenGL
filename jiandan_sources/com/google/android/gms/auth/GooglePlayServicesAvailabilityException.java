package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    public final int zzu;

    public GooglePlayServicesAvailabilityException(int i2, String str, Intent intent) {
        super(str, intent);
        this.zzu = i2;
    }

    public int getConnectionStatusCode() {
        return this.zzu;
    }
}
