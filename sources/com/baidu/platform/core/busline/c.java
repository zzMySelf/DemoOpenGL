package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.SearchType;
import com.baidu.platform.base.d;
import com.baidu.platform.base.e;

public class c extends com.baidu.platform.base.c implements IBusLineSearch {

    /* renamed from: g  reason: collision with root package name */
    OnGetBusLineSearchResultListener f16628g = null;

    public void a() {
        this.f16193c.lock();
        this.f16628g = null;
        this.f16193c.unlock();
    }

    public void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        this.f16193c.lock();
        this.f16628g = onGetBusLineSearchResultListener;
        this.f16193c.unlock();
    }

    public boolean a(BusLineSearchOption busLineSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUS_LINE_DETAIL);
        return a((e) new b(busLineSearchOption), (Object) this.f16628g, (d) aVar);
    }
}
