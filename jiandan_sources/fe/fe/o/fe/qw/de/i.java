package fe.fe.o.fe.qw.de;

import com.baidu.down.loopj.android.http.exp.IntercepterException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public class i {

    /* renamed from: ad  reason: collision with root package name */
    public static HashSet f2526ad = new HashSet();

    /* renamed from: de  reason: collision with root package name */
    public static HashSet f2527de = new HashSet();
    public final long[] qw;

    static {
        f2526ad.add(NoHttpResponseException.class);
        f2526ad.add(UnknownHostException.class);
        f2526ad.add(SocketException.class);
        f2526ad.add(SocketTimeoutException.class);
        f2526ad.add(ConnectTimeoutException.class);
        f2527de.add(IntercepterException.class);
    }

    public i(long[] jArr) {
        this.qw = jArr;
    }

    public boolean qw(HashSet hashSet, Throwable th2) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isInstance(th2)) {
                return true;
            }
        }
        return false;
    }
}
