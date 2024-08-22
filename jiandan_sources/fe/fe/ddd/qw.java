package fe.fe.ddd;

import com.baidu.pyramid.annotation.Provider;
import fe.fe.ddd.when.ad.qw.de;
import java.util.ArrayList;

public class qw implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fe.fe.ddd.de.fe.qw());
        arrayList.add(new de());
        arrayList.add(new fe.fe.ddd.nn.rg.qw());
        return arrayList;
    }
}
