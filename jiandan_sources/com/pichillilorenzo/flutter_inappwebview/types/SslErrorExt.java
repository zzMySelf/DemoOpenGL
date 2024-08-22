package com.pichillilorenzo.flutter_inappwebview.types;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class SslErrorExt extends SslError {
    public SslErrorExt(int i2, SslCertificate sslCertificate, String str) {
        super(i2, sslCertificate, str);
    }

    @Nullable
    public static Map<String, Object> toMap(SslError sslError) {
        String str = null;
        if (sslError == null) {
            return null;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            str = "The certificate is not yet valid";
        } else if (primaryError == 1) {
            str = "The certificate has expired";
        } else if (primaryError == 2) {
            str = "Hostname mismatch";
        } else if (primaryError == 3) {
            str = "The certificate authority is not trusted";
        } else if (primaryError == 4) {
            str = "The date of the certificate is invalid";
        } else if (primaryError == 5) {
            str = "A generic error occurred";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("androidError", Integer.valueOf(primaryError));
        hashMap.put("message", str);
        return hashMap;
    }
}
