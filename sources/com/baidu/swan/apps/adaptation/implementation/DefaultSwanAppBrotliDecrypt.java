package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.interfaces.ISwanAppBrotliDecrypt;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliInputStream;

public class DefaultSwanAppBrotliDecrypt implements ISwanAppBrotliDecrypt {
    public InputStream createBrotliInputStream(InputStream inputStream) throws IOException {
        return new BrotliInputStream(inputStream);
    }
}
