package com.baidu.searchbox.items.setting;

import android.content.Context;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.searchbox.kmm.settings.SettingsConstantsKt;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/items/setting/MessageSetting$getMessageSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getItemId", "", "getTitle", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "isShow", "", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageSetting.kt */
public final class MessageSetting$getMessageSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;
    final /* synthetic */ MessageSetting this$0;

    MessageSetting$getMessageSettingItem$1(Context $context2, MessageSetting $receiver) {
        this.$context = $context2;
        this.this$0 = $receiver;
    }

    public String getItemId() {
        return SettingsConstantsKt.SETTING_ID_MESSAGE;
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public boolean isShow() {
        return !StyleMode.INSTANCE.isTeenagerStyle();
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.push_message_setting);
        }
        return null;
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        this.this$0.openMessageSetting(this.$context);
    }
}
