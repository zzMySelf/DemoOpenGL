package fe.i.qw.th.de;

import android.os.SystemClock;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class fe {

    /* renamed from: de  reason: collision with root package name */
    public static final String f4493de = "fe";

    /* renamed from: fe  reason: collision with root package name */
    public static final HashSet<Class<?>> f4494fe = new HashSet<>();

    /* renamed from: rg  reason: collision with root package name */
    public static final HashSet<Class<?>> f4495rg = new HashSet<>();

    /* renamed from: ad  reason: collision with root package name */
    public final int f4496ad;
    public final int qw;

    static {
        f4494fe.add(UnknownHostException.class);
        f4494fe.add(SocketException.class);
        f4494fe.add(ProtocolException.class);
        f4495rg.add(SSLException.class);
        f4495rg.add(SocketTimeoutException.class);
    }

    public fe(int i2, int i3) {
        this.qw = i2;
        this.f4496ad = i3;
    }

    public boolean ad(HashSet<Class<?>> hashSet, Throwable th2) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th2)) {
                return true;
            }
        }
        return false;
    }

    public boolean qw(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.qw && (ad(f4494fe, exc) || !ad(f4495rg, exc))) {
            z = true;
        }
        String str = f4493de;
        LogUtil.d(str, f4493de + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep((long) this.f4496ad);
        } else {
            LogUtil.e(f4493de, exc.getMessage(), exc);
        }
        return z;
    }
}
