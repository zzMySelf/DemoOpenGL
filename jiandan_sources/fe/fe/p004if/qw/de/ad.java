package fe.fe.p004if.qw.de;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: fe.fe.if.qw.de.ad  reason: invalid package */
public abstract class ad {

    /* renamed from: ad  reason: collision with root package name */
    public de f1911ad = null;
    public Context qw;

    public ad(Context context) {
        this.qw = context;
    }

    public abstract InputStream ad() throws Exception;

    public abstract void de(de deVar);

    public abstract boolean fe() throws IOException;

    public de qw() {
        return this.f1911ad;
    }

    public abstract de rg(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, SSLHandshakeException, AssertionError;

    public abstract void th(qw qwVar) throws IOException;
}
