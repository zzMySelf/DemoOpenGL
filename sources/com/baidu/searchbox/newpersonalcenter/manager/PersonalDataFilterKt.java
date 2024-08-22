package com.baidu.searchbox.newpersonalcenter.manager;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"AVAILABLE_OPERATIONS_COUNT", "", "checkNeedPassData", "", "models", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "category", "(Ljava/util/List;Ljava/lang/Integer;)Z", "lib-personal-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalDataFilter.kt */
public final class PersonalDataFilterKt {
    private static final int AVAILABLE_OPERATIONS_COUNT = 4;

    public static final boolean checkNeedPassData(List<? extends PersonalCenterTabItemModel> models, Integer category) {
        if (models == null || category == null) {
            return false;
        }
        category.intValue();
        if (6001 == category.intValue() && models.size() != 4) {
            return true;
        }
        return false;
    }
}
