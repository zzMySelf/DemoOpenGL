package com.baidu.searchbox.personalcenter.popup;

import android.content.DialogInterface;
import com.baidu.searchbox.newpersonalcenter.model.TaskPopupModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersonalCenterDialog$$ExternalSyntheticLambda2 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ PersonalCenterDialog f$0;
    public final /* synthetic */ TaskPopupModel f$1;

    public /* synthetic */ PersonalCenterDialog$$ExternalSyntheticLambda2(PersonalCenterDialog personalCenterDialog, TaskPopupModel taskPopupModel) {
        this.f$0 = personalCenterDialog;
        this.f$1 = taskPopupModel;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        PersonalCenterDialog.m2250showDiffTypeDialog$lambda9$lambda8(this.f$0, this.f$1, dialogInterface);
    }
}
