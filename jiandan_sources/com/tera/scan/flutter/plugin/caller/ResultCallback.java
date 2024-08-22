package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;

@Keep
public interface ResultCallback<T> {
    void onResult(T t);
}
