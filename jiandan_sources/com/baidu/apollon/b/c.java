package com.baidu.apollon.b;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class c {
    @NonNull
    public final String a;

    public c(@NonNull Certificate certificate) {
        try {
            this.a = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(certificate.getPublicKey().getEncoded()), 0).trim();
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "pin='" + this.a + ExtendedMessageFormat.QUOTE;
    }

    public c(@NonNull String str) {
        if (Base64.decode(str, 0).length == 32) {
            this.a = str.trim();
            return;
        }
        throw new IllegalArgumentException("Invalid pin: length is not 32 bytes");
    }
}
