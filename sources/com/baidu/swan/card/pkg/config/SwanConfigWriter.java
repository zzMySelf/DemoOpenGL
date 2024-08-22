package com.baidu.swan.card.pkg.config;

import com.baidu.swan.card.pkg.io.SwanCallable;
import com.baidu.swan.card.pkg.io.SwanDataOutputStream;
import java.io.ByteArrayOutputStream;

public abstract class SwanConfigWriter<T> implements SwanCallable<byte[], T> {
    public abstract void writeObject(T t, SwanDataOutputStream swanDataOutputStream) throws Exception;

    public final byte[] call(T t) throws Exception {
        if (t == null) {
            return null;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SwanDataOutputStream configOutputStream = new SwanDataOutputStream(outputStream);
        writeObject(t, configOutputStream);
        byte[] bytes = outputStream.toByteArray();
        configOutputStream.close();
        outputStream.close();
        return bytes;
    }
}
