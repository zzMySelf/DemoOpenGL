package com.baidu.searchbox.player.ad.suffix.ioc;

import com.baidu.searchbox.feed.ad.detail.AdVideoUserInfoProxyFactoryImpl_Factory;
import com.baidu.searchbox.feed.ad.suffix.AdVideoSuffixProxyFactoryImplNew_Factory;
import com.baidu.searchbox.player.ad.suffix.interfaces.IAdVideoSuffixProxyFactoryNew;
import com.baidu.searchbox.player.ad.suffix.interfaces.IAdVideoUserInfoProxyFactory;

public class AdVideoRuntime {
    public static IAdVideoSuffixProxyFactoryNew getAdVideoSuffixProxyFactory() {
        return AdVideoSuffixProxyFactoryImplNew_Factory.get();
    }

    public static IAdVideoUserInfoProxyFactory getAdVideoUserInfoLayerProxy() {
        return AdVideoUserInfoProxyFactoryImpl_Factory.get();
    }
}
