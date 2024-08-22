package com.baidu.searchbox.download.center.ui.autobackup.setting.template;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.autobackup.setting.model.AutoBackupSettingBaseModel;
import com.baidu.searchbox.download.center.ui.autobackup.setting.model.BackupTemplateDescribeModel;
import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/BackupTemplateDescribeHolder;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/AbsAutoBackupSettingHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "update", "", "autoBackupSettingModel", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/AutoBackupSettingBaseModel;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupTemplateDescribeHolder.kt */
public final class BackupTemplateDescribeHolder extends AbsAutoBackupSettingHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupTemplateDescribeHolder(ViewGroup parent) {
        super(parent, R.layout.auto_backup_setting_tpl_desc_layout);
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
    }

    public void update(AutoBackupSettingBaseModel autoBackupSettingModel) {
        Intrinsics.checkNotNullParameter(autoBackupSettingModel, "autoBackupSettingModel");
        if (autoBackupSettingModel instanceof BackupTemplateDescribeModel) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.templateDescTextView);
            if (textView != null) {
                textView.setText(((BackupTemplateDescribeModel) autoBackupSettingModel).getTitle());
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.templateDescTextView);
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.getColor(this.itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC4));
            }
        }
    }
}
