package fe.fe.ddd.de.de;

import com.baidu.pyramid.annotation.Provider;
import fe.fe.ddd.de.fe.ad;
import java.util.ArrayList;

public class qw implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ad());
        arrayList.add(new fe.fe.ddd.de.rg.qw());
        return arrayList;
    }
}
