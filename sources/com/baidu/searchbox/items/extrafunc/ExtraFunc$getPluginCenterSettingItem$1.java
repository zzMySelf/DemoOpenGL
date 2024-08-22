package com.baidu.searchbox.items.extrafunc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.settings.ioc.ISettingsApp;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/items/extrafunc/ExtraFunc$getPluginCenterSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getTipText", "", "getTitle", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtraFunc.kt */
public final class ExtraFunc$getPluginCenterSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isPluginNewState;
    final /* synthetic */ ExtraFunc this$0;

    ExtraFunc$getPluginCenterSettingItem$1(Context $context2, boolean $isPluginNewState2, ExtraFunc $receiver) {
        this.$context = $context2;
        this.$isPluginNewState = $isPluginNewState2;
        this.this$0 = $receiver;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.plugin_center_title);
        }
        return null;
    }

    public String getTipText() {
        Context context;
        if (!this.$isPluginNewState || (context = this.$context) == null) {
            return null;
        }
        return context.getString(com.baidu.android.common.ui.style.R.string.tips_new);
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        ISettingsApp.Impl.get().pluginRetractUpdates();
        BaseActivity.setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
        this.this$0.onExtraFuncPreferenceClickUBC("plugin_center", "enter");
        try {
            Context context = this.$context;
            if (context != null) {
                Intent $this$onClick_u24lambda_u2d0 = new Intent();
                String packageName = this.$context.getPackageName();
                Intrinsics.checkNotNull(packageName);
                $this$onClick_u24lambda_u2d0.setComponent(new ComponentName(packageName, "com.baidu.searchbox.plugins.center.list.PluginCenterActivity"));
                context.startActivity($this$onClick_u24lambda_u2d0);
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
                Log.d("Settings", "Error, Maybe Activity Not Found, Please Check");
            }
        }
    }
}
