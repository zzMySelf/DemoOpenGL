package com.baidu.searchbox.items.setting;

import android.content.Context;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheTips;
import com.baidu.searchbox.widget.newpreference.SettingOperateHandle;
import com.baidu.searchbox.widget.newpreference.items.SettingBasePreference;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/items/setting/MessSettings$getClearCacheSettingItem$1", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "getItemId", "", "getSubTitle", "getTitle", "getType", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel$Type;", "onClick", "", "preference", "Lcom/baidu/searchbox/widget/newpreference/items/SettingBasePreference;", "handle", "Lcom/baidu/searchbox/widget/newpreference/SettingOperateHandle;", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessSettings.kt */
public final class MessSettings$getClearCacheSettingItem$1 extends SettingItemModel {
    final /* synthetic */ Context $context;

    MessSettings$getClearCacheSettingItem$1(Context $context2) {
        this.$context = $context2;
    }

    public String getItemId() {
        return "clean_cache";
    }

    public SettingItemModel.Type getType() {
        return SettingItemModel.Type.NORMAL;
    }

    public String getTitle() {
        Context context = this.$context;
        if (context != null) {
            return context.getString(R.string.history_private_setting);
        }
        return null;
    }

    public String getSubTitle() {
        String cleanSizeString = DefaultSharedPrefsWrapper.getInstance().getString(ClearCacheTips.CLEAR_CACHE_TIPS_WITHOUT_DOWNLOAD_KEY, "");
        CharSequence charSequence = cleanSizeString;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return cleanSizeString;
        }
        String str = null;
        return null;
    }

    public void onClick(SettingBasePreference preference, SettingOperateHandle handle) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        try {
            Context contextActual = this.$context;
            if (contextActual != null) {
                Router.invoke(contextActual, "baiduboxapp://v16/ucenter/cleanCache?params={\"source\": \"setting\"}");
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
