package com.baidu.searchbox.video.feedflow.detail.payment.shortPlayAutoUnlock.service;

import com.baidu.searchbox.video.feedflow.detail.payment.shortPlayAutoUnlock.ShortPlayAutoUnlockComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/shortPlayAutoUnlock/service/ShortPlayAutoUnlockService;", "Lcom/baidu/searchbox/video/feedflow/detail/payment/shortPlayAutoUnlock/service/IShortPlayAutoUnlockService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/payment/shortPlayAutoUnlock/ShortPlayAutoUnlockComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/payment/shortPlayAutoUnlock/ShortPlayAutoUnlockComponent;)V", "isAdCountDownShowing", "", "isAutoUnLockViewShowing", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayAutoUnlockService.kt */
public final class ShortPlayAutoUnlockService implements IShortPlayAutoUnlockService {
    private final ShortPlayAutoUnlockComponent component;

    public ShortPlayAutoUnlockService(ShortPlayAutoUnlockComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public boolean isAdCountDownShowing() {
        return this.component.isAdCountDownShowing();
    }

    public boolean isAutoUnLockViewShowing() {
        return this.component.isAutoUnLockViewShowing();
    }
}
