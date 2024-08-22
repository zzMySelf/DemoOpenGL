package fe.fe.yj.de;

import com.baidu.apollon.heartbeat.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class i {
    public static String qw(String str) {
        try {
            return URLEncoder.encode(str, a.h);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
