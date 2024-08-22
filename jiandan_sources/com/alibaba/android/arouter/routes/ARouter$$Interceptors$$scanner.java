package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import fe.mmm.qw.tt.de.qw;
import java.util.Map;

public class ARouter$$Interceptors$$scanner implements IInterceptorGroup {
    public void loadInto(Map<Integer, Class<? extends IInterceptor>> map) {
        map.put(1, qw.class);
    }
}
