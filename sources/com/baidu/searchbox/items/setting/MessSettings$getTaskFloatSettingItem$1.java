package com.baidu.searchbox.items.setting;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.rewardsystem.operation.TaskFloatShowSettingActivity;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.taskapi.core.strategy.TaskIsExistStrategy;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/items/setting/MessSettings$getTaskFloatSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getTitle", "", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "isShow", "", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessSettings.kt */
public final class MessSettings$getTaskFloatSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;

    MessSettings$getTaskFloatSettingItem$1(Context $context2) {
        this.$context = $context2;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.setting_title_task_float);
        }
        return null;
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        try {
            Context context = this.$context;
            if (context != null) {
                context.startActivity(new Intent(this.$context, TaskFloatShowSettingActivity.class));
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isShow() {
        return TaskIsExistStrategy.globalTaskIsExist();
    }
}
