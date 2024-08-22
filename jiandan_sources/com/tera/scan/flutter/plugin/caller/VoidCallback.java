package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;

@Keep
public interface VoidCallback<T> {
    void onCall(T t);
}
