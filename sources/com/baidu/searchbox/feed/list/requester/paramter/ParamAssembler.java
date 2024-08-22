package com.baidu.searchbox.feed.list.requester.paramter;

import com.baidu.searchbox.feed.list.controller.ListController;
import java.util.ArrayList;
import java.util.List;

public final class ParamAssembler {
    private ListController mController;
    private DefaultParamInterceptor mDefaultParamInterceptor;
    private List<IParamInterceptor> mInterceptors = new ArrayList();

    public ParamAssembler(ListController controller) {
        this.mController = controller;
    }

    public Parameter assemble(boolean keepDefaultGetParam, boolean keepDefaultPostParam) {
        this.mDefaultParamInterceptor = new DefaultParamInterceptor(this.mController, keepDefaultGetParam, keepDefaultPostParam);
        return getParamWithInterceptorChain();
    }

    private Parameter getParamWithInterceptorChain() {
        List<IParamInterceptor> interceptors = new ArrayList<>(this.mInterceptors);
        interceptors.add(this.mDefaultParamInterceptor);
        return new RealParamInterceptorChain(interceptors, 0).proceed();
    }

    public void addInterceptor(IParamInterceptor interceptor) {
        this.mInterceptors.add(interceptor);
    }
}
