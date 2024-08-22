package org.apache.commons.base;

public interface StringDecoder extends Decoder {
    String decode(String str) throws DecoderException;
}
