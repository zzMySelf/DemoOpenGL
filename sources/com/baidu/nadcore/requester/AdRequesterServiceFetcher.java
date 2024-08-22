package com.baidu.nadcore.requester;

import com.baidu.nadcore.requester.NadRequester;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;

public class AdRequesterServiceFetcher extends CachedServiceFetcher<IAdRequester> {
    /* access modifiers changed from: protected */
    public IAdRequester createService() throws ServiceNotFoundException {
        return new IAdRequester() {
            final IAdRequester impl = new AdRequesterImpl();

            public void send(RequestParameters param, NadRequester.AdResponse callback) {
                this.impl.send(param, callback);
            }
        };
    }
}
