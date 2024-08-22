package com.baidu.searchbox.items.accountprivacy;

import android.content.Context;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/items/accountprivacy/AccountPrivacyFragment$getAuthorityDescriptionSettingsItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getTitle", "", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountPrivacyFragment.kt */
public final class AccountPrivacyFragment$getAuthorityDescriptionSettingsItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;
    final /* synthetic */ AccountPrivacyFragment this$0;

    AccountPrivacyFragment$getAuthorityDescriptionSettingsItem$1(Context $context2, AccountPrivacyFragment $receiver) {
        this.$context = $context2;
        this.this$0 = $receiver;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.setting_title_authority_description);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(com.baidu.searchbox.widget.newpreference.items.SettingBasePreference r7, com.baidu.searchbox.widget.newpreference.SettingOperateHandle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "preference"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.content.Context r0 = r6.$context     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0018
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0018
            int r1 = com.baidu.searchbox.settings.R.string.setting_title_authority_description     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper r1 = com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper.INSTANCE     // Catch:{ Exception -> 0x0044 }
            r1.ubcClick(r0)     // Catch:{ Exception -> 0x0044 }
            com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper r1 = com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper.INSTANCE     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "permission_description"
            r1.entranceClickStastic(r2)     // Catch:{ Exception -> 0x0044 }
            com.baidu.searchbox.settings.ioc.ISettingsApp r1 = com.baidu.searchbox.settings.ioc.ISettingsApp.Impl.get()     // Catch:{ Exception -> 0x0044 }
            android.content.Context r2 = r6.$context     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = com.baidu.searchbox.config.HostConfig.getAppAuthorityDescription()     // Catch:{ Exception -> 0x0044 }
            com.baidu.searchbox.items.accountprivacy.AccountPrivacyFragment r4 = r6.this$0     // Catch:{ Exception -> 0x0044 }
            int r5 = com.baidu.searchbox.settings.R.string.app_authority_des_title     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0044 }
            android.content.Intent r1 = r1.getSettingCommonAC(r2, r3, r4)     // Catch:{ Exception -> 0x0044 }
            android.content.Context r2 = r6.$context     // Catch:{ Exception -> 0x0044 }
            if (r2 == 0) goto L_0x004e
            r2.startActivity(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x004e
        L_0x0044:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x004e
            r0.printStackTrace()
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.items.accountprivacy.AccountPrivacyFragment$getAuthorityDescriptionSettingsItem$1.onClick(com.baidu.searchbox.widget.newpreference.items.SettingBasePreference, com.baidu.searchbox.widget.newpreference.SettingOperateHandle):void");
    }
}
