package com.baidu.searchbox.items.extrafunc;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.libsimcard.helper.SimCardHelper;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/items/extrafunc/ExtraFunc$getFreeSearchSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getSummary", "", "getTitle", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "isCheck", "", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtraFunc.kt */
public final class ExtraFunc$getFreeSearchSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;
    final /* synthetic */ ExtraFunc this$0;

    ExtraFunc$getFreeSearchSettingItem$1(Context $context2, ExtraFunc $receiver) {
        this.$context = $context2;
        this.this$0 = $receiver;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.CHECKBOX;
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.free_flow_search);
        }
        return null;
    }

    public String getSummary() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.free_flow_card_user_exclusive);
        }
        return null;
    }

    public boolean isCheck() {
        return this.this$0.getBooleanPreferenceInDefaultSP(AppRuntime.getAppContext(), SimCardHelper.PREF_FREE_FLOW_SEARCH, true);
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        boolean isCheck = !isCheck();
        this.this$0.setBooleanPreferenceInDefaultSP(AppRuntime.getAppContext(), SimCardHelper.PREF_FREE_FLOW_SEARCH, isCheck);
        SimCardHelper.getInstance().notifySimCardObservers();
        this.this$0.onExtraFuncPreferenceClickUBC("search_mianliu", isCheck ? "open" : "close");
        preference.updateUI();
    }
}
