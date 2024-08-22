package com.baidu.searchbox.personalcenter.popup;

import com.baidu.searchbox.newpersonalcenter.manager.TaskPopupManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterDialog.kt */
final class PersonalCenterDialog$cancelWithAnimation$1$1$onAnimationEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalCenterDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalCenterDialog$cancelWithAnimation$1$1$onAnimationEnd$1(PersonalCenterDialog personalCenterDialog) {
        super(0);
        this.this$0 = personalCenterDialog;
    }

    public final void invoke() {
        TaskPopupManagerKt.onTaskFinished();
        Function0<Unit> taskFinishCallback = this.this$0.getTaskFinishCallback();
        if (taskFinishCallback != null) {
            taskFinishCallback.invoke();
        }
    }
}
