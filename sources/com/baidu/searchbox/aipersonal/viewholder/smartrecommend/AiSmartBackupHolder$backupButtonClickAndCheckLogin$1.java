package com.baidu.searchbox.aipersonal.viewholder.smartrecommend;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiSmartBackupHolder.kt */
/* synthetic */ class AiSmartBackupHolder$backupButtonClickAndCheckLogin$1 extends FunctionReferenceImpl implements Function1<PersonalCenterTabItemModel, Unit> {
    AiSmartBackupHolder$backupButtonClickAndCheckLogin$1(Object obj) {
        super(1, obj, AiSmartBackupHolder.class, "buttonJumpToBackUp", "buttonJumpToBackUp(Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PersonalCenterTabItemModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(PersonalCenterTabItemModel p0) {
        ((AiSmartBackupHolder) this.receiver).buttonJumpToBackUp(p0);
    }
}
