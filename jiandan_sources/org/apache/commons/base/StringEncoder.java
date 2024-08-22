package org.apache.commons.base;

public interface StringEncoder extends Encoder {
    String encode(String str) throws EncoderException;
}
