package fe.mmm.qw.j.ggg;

import android.os.Build;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class qw {
    public static boolean ad() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static String qw() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            fe.mmm.qw.i.qw.ad("DeviceUtils", "inetAddress:" + nextElement);
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            fe.mmm.qw.i.qw.th("DeviceUtils", "WifiPreference IpAddress", e);
            return "";
        } catch (Exception e2) {
            fe.mmm.qw.i.qw.th("DeviceUtils", "WifiPreference IpAddress", e2);
            return "";
        }
    }
}
