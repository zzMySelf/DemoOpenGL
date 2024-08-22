package com.baidu.cesium.b;

import fe.fe.fe.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {
    public Map<String, qw> qw = new HashMap();

    public interface a {
        List<qw> a();
    }

    public b(a aVar) {
        for (qw next : aVar.a()) {
            this.qw.put(next.de(), next);
        }
    }

    public List<qw> ad() {
        return new ArrayList(this.qw.values());
    }

    public qw qw(String str) {
        return this.qw.get(str);
    }
}
