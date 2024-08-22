package com.baidu.searchbox.items.setting.account.tips;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.kmm.settings.SettingsConstantsKt;
import com.baidu.searchbox.settings.tips.IBusinessTipsInfoHandler;
import com.baidu.searchbox.widget.newpreference.model.tips.SettingTipsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/items/setting/account/tips/AccountManagerBusinessTipsInfoHandler;", "Lcom/baidu/searchbox/settings/tips/IBusinessTipsInfoHandler;", "()V", "fetchTipsInfoAsync", "", "callback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/widget/newpreference/model/tips/SettingTipsInfo;", "Lkotlin/ParameterName;", "name", "settingTipsInfo", "getSettingItemId", "", "onItemClicked", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountManagerBusinessTipsInfoHandler.kt */
public final class AccountManagerBusinessTipsInfoHandler implements IBusinessTipsInfoHandler {
    public String getSettingItemId() {
        return SettingsConstantsKt.SETTING_ID_ACCOUNT_MANAGER;
    }

    public void fetchTipsInfoAsync(Function1<? super SettingTipsInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (accountManager != null) {
            accountManager.isShowSettingsRealNameGuide(new AccountManagerBusinessTipsInfoHandler$fetchTipsInfoAsync$1(this, callback));
        }
    }

    public void onItemClicked(SettingTipsInfo settingTipsInfo) {
        Intrinsics.checkNotNullParameter(settingTipsInfo, "settingTipsInfo");
    }
}
