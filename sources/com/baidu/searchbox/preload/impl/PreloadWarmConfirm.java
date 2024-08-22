package com.baidu.searchbox.preload.impl;

import android.content.Context;
import com.baidu.searchbox.preload.business.request.PreloadRequestManager;
import com.baidu.searchbox.security.action.IWarmConfirmAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/preload/impl/PreloadWarmConfirm;", "Lcom/baidu/searchbox/security/action/IWarmConfirmAction;", "()V", "doAction", "", "context", "Landroid/content/Context;", "lib-preload-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreloadWarmConfirm.kt */
public final class PreloadWarmConfirm implements IWarmConfirmAction {
    public void doAction(Context context) {
        PreloadRequestManager.INSTANCE.request(false);
    }
}
