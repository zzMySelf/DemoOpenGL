package com.baidu.searchbox.items.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/items/setting/DebugSetting$getDebugSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getTitle", "", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "isShow", "", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DebugSetting.kt */
public final class DebugSetting$getDebugSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;

    DebugSetting$getDebugSettingItem$1(Context $context2) {
        this.$context = $context2;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public boolean isShow() {
        return AppConfig.isDebug();
    }

    public String getTitle() {
        return WebViewFactoryProvider.SETTING_DEBUG;
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        try {
            Context context = this.$context;
            Intent $this$onClick_u24lambda_u2d0 = new Intent();
            $this$onClick_u24lambda_u2d0.setComponent(new ComponentName(this.$context.getPackageName(), "com.baidu.searchbox.tools.develop.DebugMainActivity"));
            context.startActivity($this$onClick_u24lambda_u2d0);
        } catch (Exception e2) {
        }
    }
}
