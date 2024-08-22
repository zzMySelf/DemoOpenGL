package com.baidu.android.util.soloader;

import android.annotation.SuppressLint;

public final class DefaultSoLoader implements ICallingSoLoader {
    public static DefaultSoLoader getDefaultSoLoader() {
        return new DefaultSoLoader();
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void load(String str) {
        System.load(str);
    }

    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
