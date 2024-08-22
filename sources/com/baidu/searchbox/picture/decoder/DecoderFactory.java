package com.baidu.searchbox.picture.decoder;

public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException;
}
