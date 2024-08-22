package com.yy.open.log;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

public class RSAForPublicKey extends RSAAbstract {
    public void setKey(String sKey) throws RSAException {
        try {
            this.m_oKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(RSAUtil.decrypt(sKey)));
        } catch (Exception e2) {
            throw new RSAException(e2);
        }
    }
}
