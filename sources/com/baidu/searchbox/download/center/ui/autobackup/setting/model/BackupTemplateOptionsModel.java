package com.baidu.searchbox.download.center.ui.autobackup.setting.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/BackupTemplateOptionsModel;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/AutoBackupSettingBaseModel;", "()V", "fileBackupSwitchStatus", "", "getFileBackupSwitchStatus", "()Z", "setFileBackupSwitchStatus", "(Z)V", "fileBackupTitle", "", "getFileBackupTitle", "()Ljava/lang/String;", "setFileBackupTitle", "(Ljava/lang/String;)V", "pictureBackupSwitchStatus", "getPictureBackupSwitchStatus", "setPictureBackupSwitchStatus", "pictureBackupTitle", "getPictureBackupTitle", "setPictureBackupTitle", "videoBackupSwitchStatus", "getVideoBackupSwitchStatus", "setVideoBackupSwitchStatus", "videoBackupTitle", "getVideoBackupTitle", "setVideoBackupTitle", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupTemplateOptionsModel.kt */
public final class BackupTemplateOptionsModel extends AutoBackupSettingBaseModel {
    private boolean fileBackupSwitchStatus;
    private String fileBackupTitle = "";
    private boolean pictureBackupSwitchStatus;
    private String pictureBackupTitle = "";
    private boolean videoBackupSwitchStatus;
    private String videoBackupTitle = "";

    public final String getVideoBackupTitle() {
        return this.videoBackupTitle;
    }

    public final void setVideoBackupTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoBackupTitle = str;
    }

    public final boolean getVideoBackupSwitchStatus() {
        return this.videoBackupSwitchStatus;
    }

    public final void setVideoBackupSwitchStatus(boolean z) {
        this.videoBackupSwitchStatus = z;
    }

    public final String getFileBackupTitle() {
        return this.fileBackupTitle;
    }

    public final void setFileBackupTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileBackupTitle = str;
    }

    public final boolean getFileBackupSwitchStatus() {
        return this.fileBackupSwitchStatus;
    }

    public final void setFileBackupSwitchStatus(boolean z) {
        this.fileBackupSwitchStatus = z;
    }

    public final String getPictureBackupTitle() {
        return this.pictureBackupTitle;
    }

    public final void setPictureBackupTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pictureBackupTitle = str;
    }

    public final boolean getPictureBackupSwitchStatus() {
        return this.pictureBackupSwitchStatus;
    }

    public final void setPictureBackupSwitchStatus(boolean z) {
        this.pictureBackupSwitchStatus = z;
    }
}
