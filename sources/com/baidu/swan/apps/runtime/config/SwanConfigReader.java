package com.baidu.swan.apps.runtime.config;

import com.baidu.swan.apps.io.SwanCallable;
import com.baidu.swan.apps.io.SwanDataInputStream;
import java.io.ByteArrayInputStream;

public abstract class SwanConfigReader<T> implements SwanCallable<T, byte[]> {
    public abstract T readObject(SwanDataInputStream swanDataInputStream) throws Exception;

    public final T call(byte[] bytes) throws Exception {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        SwanDataInputStream configInputStream = new SwanDataInputStream(inputStream);
        T value = readObject(configInputStream);
        configInputStream.close();
        inputStream.close();
        return value;
    }
}
