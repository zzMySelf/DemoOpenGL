package fe.fe.th.th;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.util.Base64Encoder;
import fe.fe.aaa.qw;
import java.net.URLEncoder;

public class ad {
    public StringBuilder qw;

    public ad(String str) {
        this.qw = new StringBuilder(str);
    }

    public void ad(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = this.qw;
            sb.append(a.n + str + "=");
            this.qw.append(URLEncoder.encode(str2));
            qw.qw("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
            qw.qw("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + str2);
        }
    }

    public void qw(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = this.qw;
            sb.append(a.n + str + "=");
            byte[] de2 = Base64Encoder.de(URLEncoder.encode(str2).getBytes());
            this.qw.append(new String(de2));
            qw.qw("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
            qw.qw("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + new String(de2));
        }
    }

    public String toString() {
        return this.qw.toString();
    }
}
