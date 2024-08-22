package com.baidu.searchbox.account.userinfo.activity;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageNaUbcUtils;
import com.baidu.searchbox.follow.button.BdFollowButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PersonalPageNaFragment$getFollowButtonClickListener$1$onClick$rightButton$1", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
public final class PersonalPageNaFragment$getFollowButtonClickListener$1$onClick$rightButton$1 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ PersonalPageNaFragment this$0;

    PersonalPageNaFragment$getFollowButtonClickListener$1$onClick$rightButton$1(PersonalPageNaFragment $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        BdFollowButton access$getMFollowButton$p = this.this$0.mFollowButton;
        if (access$getMFollowButton$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            access$getMFollowButton$p = null;
        }
        access$getMFollowButton$p.unFollow();
        PersonalPageNaFragment.doUbc$default(this.this$0, PersonalPageNaUbcUtils.UBC_VALUE_UNFO_CONFIRM, (String) null, (JSONObject) null, 6, (Object) null);
    }
}
