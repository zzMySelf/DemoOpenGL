package com.baidu.searchbox.download.center.ui.autobackup.setting.model;

import com.baidu.searchbox.download.center.ui.autobackup.setting.template.click.AutoBackupSettingItemClickType;
import com.baidu.searchbox.download.center.ui.fusion.template.PanTemplate;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/BackupTemplatePanModel;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/AutoBackupSettingBaseModel;", "()V", "itemClickType", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;", "getItemClickType", "()Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;", "setItemClickType", "(Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/AutoBackupSettingItemClickType;)V", "mPercent", "", "getMPercent", "()F", "setMPercent", "(F)V", "mSpaceText", "", "getMSpaceText", "()Ljava/lang/String;", "setMSpaceText", "(Ljava/lang/String;)V", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupTemplatePanModel.kt */
public final class BackupTemplatePanModel extends AutoBackupSettingBaseModel {
    private AutoBackupSettingItemClickType itemClickType = AutoBackupSettingItemClickType.ITEM_TYPE_PAN_FILE;
    private float mPercent = DownloadSharedPrefsUtils.getInstance().getFloat(PanTemplate.SP_KEY_PAN_TEMPLATE_PAN_SPACE_PERCENT, 0.0f);
    private String mSpaceText;

    public BackupTemplatePanModel() {
        String str = PanTemplate.PAN_SPACE_DEFAULT_TEXT;
        this.mSpaceText = str;
        String string = DownloadSharedPrefsUtils.getInstance().getString(PanTemplate.SP_KEY_PAN_TEMPLATE_PAN_SPACE_TEXT, str);
        this.mSpaceText = string != null ? string : str;
    }

    public final float getMPercent() {
        return this.mPercent;
    }

    public final void setMPercent(float f2) {
        this.mPercent = f2;
    }

    public final String getMSpaceText() {
        return this.mSpaceText;
    }

    public final void setMSpaceText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSpaceText = str;
    }

    public final AutoBackupSettingItemClickType getItemClickType() {
        return this.itemClickType;
    }

    public final void setItemClickType(AutoBackupSettingItemClickType autoBackupSettingItemClickType) {
        Intrinsics.checkNotNullParameter(autoBackupSettingItemClickType, "<set-?>");
        this.itemClickType = autoBackupSettingItemClickType;
    }
}
