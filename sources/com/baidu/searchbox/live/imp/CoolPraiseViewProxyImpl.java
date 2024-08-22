package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.live.interfaces.service.bd.CoolPraiseProxyService;
import com.baidu.searchbox.live.interfaces.service.bd.ICoolPraiseService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/imp/CoolPraiseViewProxyImpl;", "Lcom/baidu/searchbox/live/interfaces/service/bd/CoolPraiseProxyService;", "()V", "buildCoolPraiseViewInstance", "Lcom/baidu/searchbox/live/interfaces/service/bd/ICoolPraiseService;", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoolPraiseViewProxyImpl.kt */
public final class CoolPraiseViewProxyImpl implements CoolPraiseProxyService {
    public ICoolPraiseService buildCoolPraiseViewInstance() {
        return new CoolPraiseViewServiceImpl();
    }
}
