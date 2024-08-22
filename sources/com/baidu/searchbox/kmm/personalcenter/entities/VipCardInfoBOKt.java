package com.baidu.searchbox.kmm.personalcenter.entities;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"decodeVipCardInfoFromTabModel", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/VipCardInfoBO;", "vipTabModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipCardInfoBO.kt */
public final class VipCardInfoBOKt {
    public static final List<VipCardInfoBO> decodeVipCardInfoFromTabModel(PersonalCenterTabModel vipTabModel) {
        List<PersonalCenterTabItemModel> $this$forEach$iv;
        String ubcType;
        String ubcFrom;
        ArrayList vipCardInfoDatas = new ArrayList();
        if (!(vipTabModel == null || ($this$forEach$iv = vipTabModel.getBody()) == null)) {
            for (PersonalCenterTabItemModel tabItemModel : $this$forEach$iv) {
                String title = tabItemModel.getTitle();
                String scheme = tabItemModel.getScheme();
                CharSequence charSequence = title;
                boolean z = false;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    CharSequence charSequence2 = scheme;
                    if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                        z = true;
                    }
                    if (!z) {
                        String subTitle = tabItemModel.getSubTitle();
                        String subTitle2 = subTitle == null ? "" : subTitle;
                        String icon = tabItemModel.getIcon();
                        String moreTitle = tabItemModel.getMRightText();
                        String bgIcon = tabItemModel.getBgIcon();
                        String bgIconNight = tabItemModel.getBgIconNight();
                        String ubcId = tabItemModel.getUbcEventId();
                        String ubcType2 = tabItemModel.getUbcType();
                        if (ubcType2 == null) {
                            ubcType = "";
                        } else {
                            ubcType = ubcType2;
                        }
                        String ubcFrom2 = tabItemModel.getUbcFrom();
                        if (ubcFrom2 == null) {
                            ubcFrom = "";
                        } else {
                            ubcFrom = ubcFrom2;
                        }
                        vipCardInfoDatas.add(new VipCardInfoBO(title, subTitle2, icon, bgIcon, bgIconNight, moreTitle, scheme, ubcId, ubcType, ubcFrom, Intrinsics.areEqual((Object) "1", (Object) tabItemModel.getForceLogin()), tabItemModel.getAdvertInfo()));
                    }
                }
            }
        }
        return vipCardInfoDatas;
    }
}
