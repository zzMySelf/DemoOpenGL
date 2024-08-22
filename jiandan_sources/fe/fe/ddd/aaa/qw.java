package fe.fe.ddd.aaa;

import com.baidu.pyramid.annotation.Provider;
import java.util.ArrayList;

public class qw implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fe.fe.qqq.yj.qw.qw());
        return arrayList;
    }
}
