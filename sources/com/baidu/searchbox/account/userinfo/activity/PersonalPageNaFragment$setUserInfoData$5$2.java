package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.searchbox.account.userinfo.utils.PersonalPageNaUbcUtils;
import com.baidu.searchbox.follow.Relation;
import com.baidu.searchbox.follow.button.BdFollowButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PersonalPageNaFragment$setUserInfoData$5$2", "Lcom/baidu/searchbox/follow/button/BdFollowButton$FollowResultCallback;", "followFailed", "", "result", "Lcom/baidu/searchbox/follow/button/BdFollowButton$Result;", "errorCode", "", "followSuccess", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
public final class PersonalPageNaFragment$setUserInfoData$5$2 implements BdFollowButton.FollowResultCallback {
    final /* synthetic */ PersonalPageNaFragment this$0;

    PersonalPageNaFragment$setUserInfoData$5$2(PersonalPageNaFragment $receiver) {
        this.this$0 = $receiver;
    }

    public void followFailed(BdFollowButton.Result result, int errorCode) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.setFollowCallback();
        PersonalPageNaFragment.doUbc$default(this.this$0, PersonalPageNaUbcUtils.UBC_VALUE_SUBSCRIBE_ADD_DONT, "pageview", (JSONObject) null, 4, (Object) null);
        this.this$0.followedByToast = false;
    }

    public void followSuccess(BdFollowButton.Result result) {
        Relation relation;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isFollowOpt()) {
            this.this$0.showFollowSuccessDynamicPanel(false, true);
        }
        this.this$0.setFollowCallback();
        this.this$0.updateFollowButtons(result.isFollowed());
        PersonalPageNaFragment personalPageNaFragment = this.this$0;
        if (result.isFollowOpt()) {
            if (this.this$0.mRelation == Relation.FOLLOWED_ME) {
                relation = Relation.FOLLOW_EACH_OTHER;
            } else {
                relation = Relation.FOLLOWED;
            }
        } else if (this.this$0.mRelation == Relation.FOLLOW_EACH_OTHER) {
            relation = Relation.FOLLOWED_ME;
        } else {
            relation = Relation.NONE;
        }
        personalPageNaFragment.mRelation = relation;
        PersonalPageNaFragment personalPageNaFragment2 = this.this$0;
        personalPageNaFragment2.updateMune(personalPageNaFragment2.mRelation);
        PersonalPageNaFragment.doUbc$default(this.this$0, this.this$0.mRelation == Relation.FOLLOW_EACH_OTHER ? PersonalPageNaUbcUtils.UBC_VALUE_ADD_INTERACT : PersonalPageNaUbcUtils.UBC_VALUE_ADD_DONE, PersonalPageNaUbcUtils.UBC_TYPE_SUBSCRIBE_CLICK, (JSONObject) null, 4, (Object) null);
        this.this$0.sendSubscribeRequestAndUpdate(true);
        this.this$0.followedByToast = false;
    }
}
