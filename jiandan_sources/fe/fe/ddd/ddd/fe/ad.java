package fe.fe.ddd.ddd.fe;

import com.baidu.pyramid.annotation.Provider;
import fe.fe.ddd.ddd.de.qw;
import java.util.ArrayList;

public class ad implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qw());
        arrayList.add(new fe.fe.ddd.ddd.rg.qw());
        return arrayList;
    }
}
