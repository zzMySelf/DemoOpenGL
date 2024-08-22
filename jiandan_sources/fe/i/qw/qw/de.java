package fe.i.qw.qw;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class de {
    @NonNull
    public final String qw;

    public de(@NonNull Certificate certificate) {
        try {
            this.qw = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(certificate.getPublicKey().getEncoded()), 0).trim();
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || de.class != obj.getClass()) {
            return false;
        }
        return this.qw.equals(((de) obj).qw);
    }

    public int hashCode() {
        return this.qw.hashCode();
    }

    public String toString() {
        return "pin='" + this.qw + ExtendedMessageFormat.QUOTE;
    }
}
