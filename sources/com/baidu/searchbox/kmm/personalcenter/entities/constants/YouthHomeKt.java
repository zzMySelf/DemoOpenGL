package com.baidu.searchbox.kmm.personalcenter.entities.constants;

import com.baidu.searchbox.home.tabs.HomeTabTextHolder;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\n\u001a\u00020\u000bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u000e\u0010\b\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"YOUTH_HOME_BLOCK_SLIDE_ITEMS", "", "", "getYOUTH_HOME_BLOCK_SLIDE_ITEMS", "()Ljava/util/List;", "YOUTH_HOME_BLOCK_SMART_GROUPS", "", "getYOUTH_HOME_BLOCK_SMART_GROUPS", "YOUTH_HOME_HAS_SHOWED_PARAM", "YOUTH_HOME_MESSAGE_ITEM_ID", "makeCommonFunMessageItem", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHome.kt */
public final class YouthHomeKt {
    private static final List<String> YOUTH_HOME_BLOCK_SLIDE_ITEMS = CollectionsKt.listOf("nightmode", "slidebanxuemode", "slidezitidaxiao");
    private static final List<Integer> YOUTH_HOME_BLOCK_SMART_GROUPS = CollectionsKt.listOf(Integer.valueOf(ViewTypeConstantsKt.SMART_FONT_SIZE));
    public static final String YOUTH_HOME_HAS_SHOWED_PARAM = "youngHomePage";
    public static final String YOUTH_HOME_MESSAGE_ITEM_ID = "tongzhi";

    public static final List<String> getYOUTH_HOME_BLOCK_SLIDE_ITEMS() {
        return YOUTH_HOME_BLOCK_SLIDE_ITEMS;
    }

    public static final List<Integer> getYOUTH_HOME_BLOCK_SMART_GROUPS() {
        return YOUTH_HOME_BLOCK_SMART_GROUPS;
    }

    public static final PersonalCenterTabItemModel makeCommonFunMessageItem() {
        PersonalCenterTabItemModel personalCenterTabItemModel = new PersonalCenterTabItemModel();
        PersonalCenterTabItemModel $this$makeCommonFunMessageItem_u24lambda_u2d0 = personalCenterTabItemModel;
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setKeyId("tongzhi");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setTitle(HomeTabTextHolder.XIAOXI_TAB_TEXT);
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setIcon("https://b.bdstatic.com/token_img/8c7dd922ad_20231007095224.png");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setIconNightUrl("https://b.bdstatic.com/token_img/8c7dd922ad_20231007095224.png");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setIconDarkUrl("https://b.bdstatic.com/token_img/8c7dd922ad_20231007095226.png");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setForceLogin("0");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setUbcEventId("192");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setUbcType("tongzhi");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setUbcFrom("wode");
        $this$makeCommonFunMessageItem_u24lambda_u2d0.setScheme("baiduboxapp://v28/message/openMessageCenter?params=%7B%22type%22%3A%202%2C%20%22source%22%3A%20%225%22%7D&callback=_bdbox_js_186");
        return personalCenterTabItemModel;
    }
}
