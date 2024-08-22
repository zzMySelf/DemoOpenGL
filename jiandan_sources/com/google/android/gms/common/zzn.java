package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final class zzn extends zzl {
    public final Callable<String> zzar;

    public zzn(Callable<String> callable) {
        super(false, (String) null, (Throwable) null);
        this.zzar = callable;
    }

    public final String getErrorMessage() {
        try {
            return this.zzar.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
