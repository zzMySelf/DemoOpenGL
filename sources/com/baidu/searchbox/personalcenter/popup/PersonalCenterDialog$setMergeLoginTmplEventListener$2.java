package com.baidu.searchbox.personalcenter.popup;

import android.view.View;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.account.component.IAccountComponentCallback;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.newpersonalcenter.model.TaskPopupModel;
import com.baidu.searchbox.personalcenter.PersonalCenterUbc;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/personalcenter/popup/PersonalCenterDialog$setMergeLoginTmplEventListener$2", "Lcom/baidu/searchbox/account/component/IAccountComponentCallback;", "onButtonClick", "", "buttonType", "", "onComponentReady", "view", "Landroid/view/View;", "loginStyle", "onLoginResult", "resultCode", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterDialog.kt */
public final class PersonalCenterDialog$setMergeLoginTmplEventListener$2 implements IAccountComponentCallback {
    final /* synthetic */ TaskPopupModel $model;
    final /* synthetic */ PersonalCenterDialog this$0;

    PersonalCenterDialog$setMergeLoginTmplEventListener$2(PersonalCenterDialog $receiver, TaskPopupModel $model2) {
        this.this$0 = $receiver;
        this.$model = $model2;
    }

    public void onComponentReady(View view2, int loginStyle) {
        PersonalCenterDialog personalCenterDialog = this.this$0;
        personalCenterDialog.ubcSource = personalCenterDialog.getLoginUbcSource(loginStyle);
    }

    public void onLoginResult(int resultCode) {
        if (resultCode == -2) {
            this.this$0.dismissAndFinish();
            PersonalCenterUbc.taskPopupEvent("login_cancel", this.$model.getUserIdentity(), this.this$0.ubcSource);
        } else if (this.this$0.getBoxAccountManager().isLogin(0)) {
            this.this$0.onLoginSuccess(this.$model);
        } else {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "登录失败，试试其他方式").show();
            this.this$0.handleHalfScreenLogin(this.$model);
        }
    }

    public void onButtonClick(int buttonType) {
    }
}
