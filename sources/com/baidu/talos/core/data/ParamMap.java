package com.baidu.talos.core.data;

import com.baidu.talos.NoProguard;
import java.util.Map;

public interface ParamMap extends NoProguard {
    ParamArray getArray(String str);

    boolean getBoolean(String str);

    double getDouble(String str);

    Dynamic getDynamic(String str);

    int getInteger(String str);

    long getLong(String str);

    ParamMap getMap(String str);

    Object getObject(String str);

    String getString(String str);

    ParamType getType(String str);

    boolean hasKey(String str);

    boolean isNull(String str);

    ParamMapKeySetIterator keySetIterator();

    void merge(ParamMap paramMap);

    void putArray(String str, ParamArray paramArray);

    void putBoolean(String str, boolean z);

    void putDouble(String str, Double d2);

    void putDynamic(String str, Dynamic dynamic);

    void putInteger(String str, Integer num);

    void putLong(String str, Long l);

    void putMap(String str, ParamMap paramMap);

    void putNull(String str);

    void putObject(String str, Object obj);

    void putString(String str, String str2);

    void remove(String str);

    int size();

    Map<String, Object> toMap();
}
