package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.searchbox.account.userinfo.activity.UserCoverActivity;
import com.baidu.searchbox.feed.tab.SlidingTabLayout;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.kmm.personalpage.shop.ubc.PersonalPageShopUBCKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/UserCoverActivity$showUserCoverList$tabChangeListener$1", "Lcom/baidu/searchbox/feed/tab/SlidingTabLayout$OnTabChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "isUserDrag", "", "onPageSelected", "itemInfo", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserCoverActivity.kt */
public final class UserCoverActivity$showUserCoverList$tabChangeListener$1 implements SlidingTabLayout.OnTabChangeListener {
    final /* synthetic */ UserCoverActivity this$0;

    UserCoverActivity$showUserCoverList$tabChangeListener$1(UserCoverActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels, boolean isUserDrag) {
    }

    public void onPageSelected(int position, MultiTabItemInfo itemInfo) {
        if (itemInfo instanceof UserCoverActivity.UserCoverMultiTabItemInfo) {
            PersonalPageShopUBCKt.shopTabClickUBC(this.this$0.currentUserType, this.this$0.pageSource, ((UserCoverActivity.UserCoverMultiTabItemInfo) itemInfo).getData().getCateTitle());
        }
    }
}
