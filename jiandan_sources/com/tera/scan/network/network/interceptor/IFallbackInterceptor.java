package com.tera.scan.network.network.interceptor;

import androidx.annotation.NonNull;
import org.json.JSONException;

public interface IFallbackInterceptor {

    public interface Builder<T> {
        @NonNull
        T ad(@NonNull String str) throws JSONException;

        @NonNull
        T[] qw(int i2);
    }

    @NonNull
    <T> T[] ad(@NonNull String str, @NonNull Builder<T> builder) throws JSONException;

    void de(boolean z, boolean z2);

    boolean fe(@NonNull String str);

    boolean qw(@NonNull String str);

    void rg(boolean z);
}
