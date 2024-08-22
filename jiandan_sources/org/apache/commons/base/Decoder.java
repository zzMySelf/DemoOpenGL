package org.apache.commons.base;

public interface Decoder {
    Object decode(Object obj) throws DecoderException;
}
