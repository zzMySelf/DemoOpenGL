package fe.fe.ddd.ppp.ad;

import com.baidu.pyramid.annotation.Provider;
import fe.mmm.qw.e.th.Cswitch;

public class qw implements Provider {
    public Object get() {
        return new Cswitch();
    }
}
