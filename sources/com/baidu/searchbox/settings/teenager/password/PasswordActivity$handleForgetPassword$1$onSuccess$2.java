package com.baidu.searchbox.settings.teenager.password;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.account.IVerifyUserFaceIDListener;
import com.baidu.searchbox.account.data.SearchBoxRealNameResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/settings/teenager/password/PasswordActivity$handleForgetPassword$1$onSuccess$2", "Lcom/baidu/searchbox/account/IVerifyUserFaceIDListener;", "onFailure", "", "resultCode", "", "resultMsg", "", "onSuccess", "searchBoxRealNameResult", "Lcom/baidu/searchbox/account/data/SearchBoxRealNameResult;", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordActivity.kt */
public final class PasswordActivity$handleForgetPassword$1$onSuccess$2 implements IVerifyUserFaceIDListener {
    final /* synthetic */ PasswordActivity this$0;

    PasswordActivity$handleForgetPassword$1$onSuccess$2(PasswordActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess(SearchBoxRealNameResult searchBoxRealNameResult) {
        Intrinsics.checkNotNullParameter(searchBoxRealNameResult, "searchBoxRealNameResult");
        PasswordActivity passwordActivity = this.this$0;
        String str = searchBoxRealNameResult.callbackkey;
        Intrinsics.checkNotNullExpressionValue(str, "searchBoxRealNameResult.callbackkey");
        passwordActivity.checkUserIsAdult(str);
    }

    public void onFailure(int resultCode, String resultMsg) {
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) resultMsg).show();
    }
}
