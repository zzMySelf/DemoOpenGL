package com.itextpdf.text.pdf.security;

import java.security.Key;

public class MakeXmlSignature$EmptyKey implements Key {
    public static MakeXmlSignature$EmptyKey instance = new MakeXmlSignature$EmptyKey();

    public static MakeXmlSignature$EmptyKey getInstance() {
        return instance;
    }

    public String getAlgorithm() {
        return null;
    }

    public byte[] getEncoded() {
        return new byte[0];
    }

    public String getFormat() {
        return null;
    }
}
