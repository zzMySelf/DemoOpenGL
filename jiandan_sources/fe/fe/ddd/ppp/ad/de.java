package fe.fe.ddd.ppp.ad;

import com.baidu.pyramid.annotation.Provider;
import fe.fe.ddd.nn.rg.ad;
import java.util.ArrayList;

public class de implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ad());
        return arrayList;
    }
}
