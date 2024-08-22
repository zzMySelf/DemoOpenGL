package com.baidu.searchbox.preload.impl.ioc;

import com.baidu.android.app.account.BoxLocalSessionManager;
import com.baidu.searchbox.net.update.listener.UpdateCommonUrlListener;
import com.baidu.searchbox.preload.business.ioc.IPreloadBusiness;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/preload/impl/ioc/PreloadBusiness;", "Lcom/baidu/searchbox/preload/business/ioc/IPreloadBusiness;", "()V", "getBduss", "", "getUpdateCommonUrlSwitch", "lib-preload-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreloadBusiness.kt */
public final class PreloadBusiness implements IPreloadBusiness {
    public String getBduss() {
        return BoxLocalSessionManager.getInstance().getAccountBduss();
    }

    public String getUpdateCommonUrlSwitch() {
        return UpdateCommonUrlListener.KEY_SWITCH_IS_USE_OLD_URL_PARAMS_SP;
    }
}
