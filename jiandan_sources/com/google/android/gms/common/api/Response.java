package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    public T zzbb;

    public Response() {
    }

    @NonNull
    public T getResult() {
        return this.zzbb;
    }

    public void setResult(@NonNull T t) {
        this.zzbb = t;
    }

    public Response(@NonNull T t) {
        this.zzbb = t;
    }
}
