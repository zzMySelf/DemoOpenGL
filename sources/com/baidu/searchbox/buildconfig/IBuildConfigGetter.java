package com.baidu.searchbox.buildconfig;

public interface IBuildConfigGetter {
    boolean getBoolean(String str, String str2);

    double getDouble(String str, String str2);

    float getFloat(String str, String str2);

    int getInt(String str, String str2);

    long getLong(String str, String str2);

    int getResId(String str, String str2);

    short getShort(String str, String str2);

    String getString(String str, String str2);
}
