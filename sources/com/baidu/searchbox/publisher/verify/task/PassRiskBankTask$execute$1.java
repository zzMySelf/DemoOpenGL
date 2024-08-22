package com.baidu.searchbox.publisher.verify.task;

import com.baidu.searchbox.account.IAuthWidgetCallback;
import com.baidu.searchbox.account.result.BoxSapiResult;
import com.baidu.searchbox.publisher.verify.AuthSceneConstansKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/publisher/verify/task/PassRiskBankTask$execute$1", "Lcom/baidu/searchbox/account/IAuthWidgetCallback;", "onFailure", "", "result", "Lcom/baidu/searchbox/account/result/BoxSapiResult;", "onSuccess", "content", "", "creative_plugin_impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PassRiskBankTask.kt */
public final class PassRiskBankTask$execute$1 implements IAuthWidgetCallback {
    final /* synthetic */ PassRiskBankTask this$0;

    PassRiskBankTask$execute$1(PassRiskBankTask $receiver) {
        this.this$0 = $receiver;
    }

    public void onFailure(BoxSapiResult result) {
        String str;
        PassRiskBankTask passRiskBankTask = this.this$0;
        if (result == null || (str = Integer.valueOf(result.getResultCode()).toString()) == null) {
            str = AuthSceneConstansKt.ERROR_RISK_BANK;
        }
        passRiskBankTask.callbackError(str, "risk bank fail " + (result != null ? result.getResultMsg() : null));
    }

    public void onSuccess(String content) {
        CharSequence charSequence = content;
        if (charSequence == null || charSequence.length() == 0) {
            this.this$0.callbackError(AuthSceneConstansKt.ERROR_RISK_BANK, "risk bank fail auth sid null");
        } else {
            this.this$0.executeNext();
        }
    }
}
