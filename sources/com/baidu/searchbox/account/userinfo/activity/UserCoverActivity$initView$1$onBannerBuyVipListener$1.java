package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.account.userinfo.utils.OnBuyVipListener;
import com.baidu.searchbox.account.userinfo.utils.UserInfoVipUtilsKt;
import com.baidu.searchbox.account.userinfo.view.UserCoverBottomView;
import com.baidu.searchbox.account.userinfo.view.UserCoverHeadView;
import com.baidu.searchbox.kmm.personalpage.shop.ubc.PersonalPageShopUBCKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/UserCoverActivity$initView$1$onBannerBuyVipListener$1", "Lcom/baidu/searchbox/account/userinfo/utils/OnBuyVipListener;", "onBuyVipListener", "", "buyStatus", "", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserCoverActivity.kt */
public final class UserCoverActivity$initView$1$onBannerBuyVipListener$1 implements OnBuyVipListener {
    final /* synthetic */ UserCoverActivity this$0;

    UserCoverActivity$initView$1$onBannerBuyVipListener$1(UserCoverActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onBuyVipListener(boolean buyStatus) {
        if (buyStatus) {
            ((UserCoverHeadView) this.this$0._$_findCachedViewById(R.id.user_cover_head_view)).setBannerVipData();
            ((UserCoverBottomView) this.this$0._$_findCachedViewById(R.id.user_cover_bottom_view)).onCoverSelected(this.this$0.getCurrentSetEntity());
            PersonalPageShopUBCKt.shopFunctionClickUBC$default(this.this$0.currentUserType, this.this$0.pageSource, UserInfoVipUtilsKt.getDuVIP() ? "renewal_done" : "viptips_done", (String) null, 8, (Object) null);
        }
    }
}
