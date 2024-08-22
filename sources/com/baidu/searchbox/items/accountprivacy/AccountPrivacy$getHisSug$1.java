package com.baidu.searchbox.items.accountprivacy;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.hissug.pyramid.IHissugGraph;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/items/accountprivacy/AccountPrivacy$getHisSug$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getSummary", "", "getTitle", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "isCheck", "", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountPrivacy.kt */
public final class AccountPrivacy$getHisSug$1 extends SettingItemModel {
    final /* synthetic */ Context $context;

    AccountPrivacy$getHisSug$1(Context $context2) {
        this.$context = $context2;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.CHECKBOX;
    }

    public String getTitle() {
        Resources resources;
        Context context = this.$context;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getString(R.string.hissug_graph_switch_title);
    }

    public String getSummary() {
        Resources resources;
        Context context = this.$context;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getString(R.string.hissug_graph_switch_summary);
    }

    public boolean isCheck() {
        IHissugGraph iHissugGraph = (IHissugGraph) ServiceManager.getService(IHissugGraph.Companion.getSERVICE_REFERENCE());
        if (iHissugGraph != null) {
            return iHissugGraph.isHissugGraph();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(com.baidu.searchbox.widget.newpreference.items.SettingBasePreference r3, com.baidu.searchbox.widget.newpreference.SettingOperateHandle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "preference"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.searchbox.hissug.pyramid.IHissugGraph$Companion r0 = com.baidu.searchbox.hissug.pyramid.IHissugGraph.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r0 = r0.getSERVICE_REFERENCE()
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.searchbox.hissug.pyramid.IHissugGraph r0 = (com.baidu.searchbox.hissug.pyramid.IHissugGraph) r0
            if (r0 == 0) goto L_0x001f
            boolean r1 = r2.isCheck()
            r1 = r1 ^ 1
            r0.setIsHissugGraph(r1)
        L_0x001f:
            r3.updateUI()
            android.content.Context r0 = r2.$context     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x0034
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x0034
            int r1 = com.baidu.searchbox.settings.R.string.hissug_graph_switch_title     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x003b }
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper r1 = com.baidu.searchbox.items.accountprivacy.AccountPrivacyUBCHelper.INSTANCE     // Catch:{ Exception -> 0x003b }
            r1.ubcClick(r0)     // Catch:{ Exception -> 0x003b }
            goto L_0x0045
        L_0x003b:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0045
            r0.printStackTrace()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.items.accountprivacy.AccountPrivacy$getHisSug$1.onClick(com.baidu.searchbox.widget.newpreference.items.SettingBasePreference, com.baidu.searchbox.widget.newpreference.SettingOperateHandle):void");
    }
}
