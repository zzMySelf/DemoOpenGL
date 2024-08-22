package com.baidu.browser.arch.service;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000bH&J\b\u0010\f\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/baidu/browser/arch/service/IBrowserServiceManager;", "", "getService", "T", "Lcom/baidu/browser/arch/service/IBrowserService;", "c", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/baidu/browser/arch/service/IBrowserService;", "registerService", "", "serviceFetcher", "Lcom/baidu/browser/arch/service/IBrowserServiceFetcher;", "release", "lib-browser-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBrowserServiceManager.kt */
public interface IBrowserServiceManager {
    <T extends IBrowserService> T getService(Class<T> cls);

    void registerService(Class<? extends IBrowserService> cls, IBrowserServiceFetcher<? extends IBrowserService> iBrowserServiceFetcher);

    void release();
}
