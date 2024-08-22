package fe.fe.ddd.eee;

import com.baidu.util.Base64Encoder;

public class fe {
    public String qw;

    public fe() {
        ad();
    }

    public final void ad() {
        int ad2 = Base64Encoder.ad();
        if (ad2 == 0) {
            this.qw = "1";
            return;
        }
        this.qw = ad2 + "";
    }

    public String qw() {
        return this.qw;
    }
}
