package org.apache.commons.base;

public interface Encoder {
    Object encode(Object obj) throws EncoderException;
}
