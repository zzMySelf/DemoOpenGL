package com.baidu.ubc.service;

import com.baidu.pyramid.annotation.component.DefaultHolder;
import com.baidu.pyramid.annotation.component.Holder;
import com.baidu.ubc.inter.IUBCServiceFactory;
import com.baidu.ubc.inter.IUBCServiceFactory_UBCServiceRuntime_Provider;

public class UBCServiceRuntime {
    Holder<IUBCServiceFactory> mUBCServiceFactoryHolder;

    public void initmUBCServiceFactoryHolder() {
        DefaultHolder create = DefaultHolder.create();
        this.mUBCServiceFactoryHolder = create;
        create.set(new IUBCServiceFactory_UBCServiceRuntime_Provider());
    }

    public UBCServiceRuntime() {
        initmUBCServiceFactoryHolder();
    }

    public IUBCServiceFactory getUBCServiceFactory() {
        return this.mUBCServiceFactoryHolder.get();
    }
}
