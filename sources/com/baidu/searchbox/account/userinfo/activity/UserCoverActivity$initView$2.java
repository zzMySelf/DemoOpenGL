package com.baidu.searchbox.account.userinfo.activity;

import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.userinfo.menu.UnitedSchemePersonalPageDispatcher;
import com.baidu.searchbox.account.userinfo.utils.AlbumUBCUtils;
import com.baidu.searchbox.account.userinfo.utils.UserInfoVipUtilsKt;
import com.baidu.searchbox.account.userinfo.view.UserCoverBottomListener;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryImageEntity;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryTaskDataEntity;
import com.baidu.searchbox.kmm.personalpage.shop.ubc.PersonalPageShopUBCKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/UserCoverActivity$initView$2", "Lcom/baidu/searchbox/account/userinfo/view/UserCoverBottomListener;", "onApplyCoverBtnClick", "", "entity", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryImageEntity;", "onBottomBackListener", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserCoverActivity.kt */
public final class UserCoverActivity$initView$2 implements UserCoverBottomListener {
    final /* synthetic */ UserCoverActivity this$0;

    UserCoverActivity$initView$2(UserCoverActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onBottomBackListener() {
        this.this$0.finish();
    }

    public void onApplyCoverBtnClick(PersonalPageGalleryImageEntity entity) {
        String str;
        String it;
        if (entity != null && !entity.isUsing()) {
            UserCoverActivity userCoverActivity = this.this$0;
            boolean z = true;
            if (entity.isVip()) {
                str = UnitedSchemePersonalPageDispatcher.MENU_ENTRY_GALLERY_VIP;
            } else if (entity.getType() == 1) {
                str = UnitedSchemePersonalPageDispatcher.TASK_COVER_VALUE;
            } else {
                str = UnitedSchemePersonalPageDispatcher.MENU_ENTRY_GALLERY;
            }
            userCoverActivity.topImageFrom = str;
            boolean z2 = false;
            if (entity.isVip() && !UserInfoVipUtilsKt.getDuVIP()) {
                Map ext = new LinkedHashMap();
                if (entity.getImageId().length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    ext.put(PersonalPageShopUBCKt.UBC_PERSONAL_PAGE_SHOP_EXT_COVER_ID, entity.getImageId());
                }
                String it2 = entity.getTabName();
                if (it2 != null) {
                    ext.put("tabname", it2);
                }
                PersonalPageShopUBCKt.shopFunctionClickUBCWithExt(this.this$0.currentUserType, this.this$0.pageSource, AlbumUBCUtils.DEFAULT_GALLERY_VIP_SET, ext);
                UserInfoVipUtilsKt.doBuyVip(this.this$0, UserInfoVipUtilsKt.VIP_BACKGROUND_SCHEME, 1, new UserCoverActivity$initView$2$onApplyCoverBtnClick$2(this.this$0, entity));
            } else if (entity.getType() == 1) {
                PersonalPageGalleryTaskDataEntity taskData = entity.getTaskData();
                if (taskData != null && taskData.getCanUse()) {
                    this.this$0.setUserCover(entity);
                    return;
                }
                PersonalPageGalleryTaskDataEntity taskData2 = entity.getTaskData();
                if (taskData2 != null && (it = taskData2.getScheme()) != null) {
                    UserCoverActivity userCoverActivity2 = this.this$0;
                    Router.invoke(userCoverActivity2, it);
                    Map ext2 = new LinkedHashMap();
                    if (entity.getImageId().length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        ext2.put(PersonalPageShopUBCKt.UBC_PERSONAL_PAGE_SHOP_EXT_COVER_ID, entity.getImageId());
                    }
                    String tabName = entity.getTabName();
                    if (tabName != null) {
                        ext2.put("tabname", tabName);
                    }
                    PersonalPageShopUBCKt.shopFunctionClickUBCWithExt(userCoverActivity2.currentUserType, userCoverActivity2.pageSource, "dotask", ext2);
                }
            } else {
                this.this$0.setUserCover(entity);
            }
        }
    }
}
