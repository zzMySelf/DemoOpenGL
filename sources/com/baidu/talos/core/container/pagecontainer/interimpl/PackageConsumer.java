package com.baidu.talos.core.container.pagecontainer.interimpl;

import com.baidu.talos.core.container.pagecontainer.PackageProcessResult;
import com.baidu.talos.core.container.pagecontainer.TalosPageContainer;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageConsumer;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageProcessor;
import java.lang.ref.WeakReference;

public class PackageConsumer implements IPackageConsumer<PackageProcessResult> {
    private WeakReference<TalosPageContainer> pageContainerRef;

    public PackageConsumer(TalosPageContainer pageContainer) {
        this.pageContainerRef = new WeakReference<>(pageContainer);
    }

    public void onSuccess(PackageProcessResult result) {
        if (this.pageContainerRef.get() != null) {
            ((TalosPageContainer) this.pageContainerRef.get()).onPackageConsumerSuccess(result);
        }
    }

    public void onFailure(IPackageProcessor<PackageProcessResult> processor, int errorCode, String errMsg) {
        if (this.pageContainerRef.get() != null) {
            ((TalosPageContainer) this.pageContainerRef.get()).onPackageConsumerFail(processor, errorCode, errMsg);
        }
    }
}
