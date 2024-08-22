package com.baidu.searchbox.items.accountprivacy;

import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/items/accountprivacy/AccountPrivacyFragment$getGroupTitleItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getTitle", "", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountPrivacyFragment.kt */
public final class AccountPrivacyFragment$getGroupTitleItem$1 extends SettingItemModel {
    final /* synthetic */ Integer $titleResId;
    final /* synthetic */ AccountPrivacyFragment this$0;

    AccountPrivacyFragment$getGroupTitleItem$1(Integer $titleResId2, AccountPrivacyFragment $receiver) {
        this.$titleResId = $titleResId2;
        this.this$0 = $receiver;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.LEFT_TITLE;
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTitle() {
        /*
            r3 = this;
            java.lang.Integer r0 = r3.$titleResId
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x0030
        L_0x0007:
            com.baidu.searchbox.items.accountprivacy.AccountPrivacyFragment r0 = r3.this$0     // Catch:{ Exception -> 0x0024 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0024 }
            if (r0 == 0) goto L_0x0021
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0024 }
            if (r0 == 0) goto L_0x0021
            java.lang.Integer r2 = r3.$titleResId     // Catch:{ Exception -> 0x0024 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            r1 = r0
            goto L_0x002f
        L_0x0024:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x002e
            r0.printStackTrace()
        L_0x002e:
        L_0x002f:
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.items.accountprivacy.AccountPrivacyFragment$getGroupTitleItem$1.getTitle():java.lang.String");
    }
}
