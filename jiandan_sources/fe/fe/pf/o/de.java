package fe.fe.pf.o;

import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.ids.IdProviderFactory;
import com.baidu.helios.ids.gaid.GaidProvider;
import fe.fe.pf.i.qw.qw;
import java.util.ArrayList;
import java.util.List;

public class de implements IdProviderFactory.IdFactoryProvider {
    public List<BaseIdProvider> qw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qw());
        arrayList.add(new fe.fe.pf.i.fe.qw());
        arrayList.add(new GaidProvider());
        arrayList.add(new fe.fe.pf.i.rg.qw());
        arrayList.add(new fe.fe.pf.i.de.qw());
        return arrayList;
    }
}
