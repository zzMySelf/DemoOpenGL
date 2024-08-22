package fe.fe.ddd.th.ad;

import com.baidu.pyramid.annotation.Provider;
import fe.fe.ddd.ddd.qw.ad.qw;
import java.util.ArrayList;

public class ad implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qw());
        return arrayList;
    }
}
