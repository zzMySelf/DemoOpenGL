package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import pf.de;

public interface Dns {
    public static final Dns SYSTEM = de.qw;

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
