package com.baidu.android.util.soloader;

public interface ICallingSoLoader {
    void load(String str) throws Throwable;

    void loadLibrary(String str) throws Throwable;
}
