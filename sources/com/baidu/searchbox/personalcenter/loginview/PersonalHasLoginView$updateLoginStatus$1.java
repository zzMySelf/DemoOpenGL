package com.baidu.searchbox.personalcenter.loginview;

import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.data.BoxAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/personalcenter/loginview/PersonalHasLoginView$updateLoginStatus$1", "Lcom/baidu/searchbox/account/IGetBoxAccountListener;", "onFailed", "", "i", "", "onSuccess", "boxAccount", "Lcom/baidu/searchbox/account/data/BoxAccount;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalHasLoginView.kt */
public final class PersonalHasLoginView$updateLoginStatus$1 implements IGetBoxAccountListener {
    final /* synthetic */ boolean $ubcEnable;
    final /* synthetic */ PersonalHasLoginView this$0;

    PersonalHasLoginView$updateLoginStatus$1(PersonalHasLoginView $receiver, boolean $ubcEnable2) {
        this.this$0 = $receiver;
        this.$ubcEnable = $ubcEnable2;
    }

    public void onSuccess(BoxAccount boxAccount) {
        Intrinsics.checkNotNullParameter(boxAccount, "boxAccount");
        this.this$0.setLoginDecorateUri(boxAccount.getOrnament(), boxAccount.getOrnamentId(), this.$ubcEnable);
    }

    public void onFailed(int i2) {
    }
}
