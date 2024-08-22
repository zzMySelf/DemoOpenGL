package com.baidu.searchbox.download.center.ui.autobackup.setting.model;

import com.baidu.searchbox.download.center.ui.autobackup.setting.template.click.AutoBackupSettingItemClickType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/BackupTemplateSwitchModel;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/AutoBackupSettingBaseModel;", "()V", "itemClickType", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;", "getItemClickType", "()Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;", "setItemClickType", "(Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;)V", "mutexMob", "", "getMutexMob", "()Ljava/lang/Boolean;", "setMutexMob", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "switchStatus", "getSwitchStatus", "()Z", "setSwitchStatus", "(Z)V", "title", "getTitle", "setTitle", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupTemplateSwitchModel.kt */
public final class BackupTemplateSwitchModel extends AutoBackupSettingBaseModel {
    private AutoBackupSettingItemClickType itemClickType = AutoBackupSettingItemClickType.ITEM_TYPE_UN_KNOW;
    private Boolean mutexMob = false;
    private String subTitle;
    private boolean switchStatus;
    private String title = "";

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setSwitchStatus(boolean z) {
        this.switchStatus = z;
    }

    public final AutoBackupSettingItemClickType getItemClickType() {
        return this.itemClickType;
    }

    public final void setItemClickType(AutoBackupSettingItemClickType autoBackupSettingItemClickType) {
        Intrinsics.checkNotNullParameter(autoBackupSettingItemClickType, "<set-?>");
        this.itemClickType = autoBackupSettingItemClickType;
    }

    public final Boolean getMutexMob() {
        return this.mutexMob;
    }

    public final void setMutexMob(Boolean bool) {
        this.mutexMob = bool;
    }
}
