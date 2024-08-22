package com.baidu.apollon.restnet.rest;

import android.os.SystemClock;
import com.baidu.apollon.utils.LogUtil;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class g {
    public static final String a = "g";
    public static final HashSet<Class<?>> b = new HashSet<>();
    public static final HashSet<Class<?>> c = new HashSet<>();
    public final int d;
    public final int e;

    static {
        b.add(UnknownHostException.class);
        b.add(SocketException.class);
        b.add(ProtocolException.class);
        c.add(SSLException.class);
        c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        this.d = i2;
        this.e = i3;
    }

    public boolean a(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.d && (a(b, (Throwable) exc) || !a(c, (Throwable) exc))) {
            z = true;
        }
        String str = a;
        LogUtil.d(str, a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep((long) this.e);
        } else {
            exc.printStackTrace();
        }
        return z;
    }

    public boolean a(HashSet<Class<?>> hashSet, Throwable th2) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th2)) {
                return true;
            }
        }
        return false;
    }
}
