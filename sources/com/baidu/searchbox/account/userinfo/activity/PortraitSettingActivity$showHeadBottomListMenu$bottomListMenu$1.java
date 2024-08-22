package com.baidu.searchbox.account.userinfo.activity;

import android.text.TextUtils;
import com.baidu.android.common.menu.bottomlist.BottomListMenu;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PortraitSettingActivity$showHeadBottomListMenu$bottomListMenu$1", "Lcom/baidu/android/common/menu/bottomlist/BottomListMenu$ItemClickListener;", "onItemClick", "", "id", "", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
public final class PortraitSettingActivity$showHeadBottomListMenu$bottomListMenu$1 implements BottomListMenu.ItemClickListener {
    final /* synthetic */ PortraitSettingActivity this$0;

    PortraitSettingActivity$showHeadBottomListMenu$bottomListMenu$1(PortraitSettingActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(int id) {
        switch (id) {
            case 1:
                String defaultUrl = !TextUtils.isEmpty(this.this$0.mLoginManager.getBoxAccount().dynamicPortrait) ? this.this$0.mLoginManager.getBoxAccount().dynamicPortrait : this.this$0.mLoginManager.getBoxAccount().portrait;
                PortraitSettingActivity portraitSettingActivity = this.this$0;
                String selectedPortraitUrl = portraitSettingActivity.getPortraitDataManager().getSelectedPortraitUrl();
                if (selectedPortraitUrl == null) {
                    selectedPortraitUrl = defaultUrl;
                }
                portraitSettingActivity.previewLargeHead(selectedPortraitUrl);
                AccountPortaitSettingUBCKt.ubc5174$default(this.this$0.getPortraitUbcFrom(), "click", AccountPortaitSettingUBCKt.UBC_LARGERVIEW, (String) null, (Integer) null, (JSONObject) null, 56, (Object) null);
                return;
            case 2:
                this.this$0.updateBottomBtnVisible(false);
                this.this$0.requestTakePhoto();
                AccountPortaitSettingUBCKt.ubc5174$default(this.this$0.getPortraitUbcFrom(), "click", "take_photo", (String) null, (Integer) null, (JSONObject) null, 56, (Object) null);
                return;
            case 3:
                this.this$0.updateBottomBtnVisible(false);
                this.this$0.requestPickPhoto();
                AccountPortaitSettingUBCKt.ubc5174$default(this.this$0.getPortraitUbcFrom(), "click", AccountPortaitSettingUBCKt.UBC_PHOTO_ALBUM, (String) null, (Integer) null, (JSONObject) null, 56, (Object) null);
                return;
            case 4:
                Map paramMap = new LinkedHashMap();
                paramMap.put("sourceFrom", "avatarpanel");
                paramMap.put(UserCoverAdapterKt.DRESS_TYPE_KEY, "avatar");
                PortraitSettingActivityKt.goDressUpCenter(paramMap);
                AccountPortaitSettingUBCKt.ubc5174$default(this.this$0.getPortraitUbcFrom(), "click", AccountPortaitSettingUBCKt.UBC_VALUE_GENERATE_AIPORTRAIT, (String) null, (Integer) null, (JSONObject) null, 56, (Object) null);
                return;
            default:
                return;
        }
    }
}
