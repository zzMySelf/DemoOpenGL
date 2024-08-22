package com.baidu.searchbox.personal.manager;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterDataWrapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/personal/manager/IPersonalizedDataListener;", "", "onFailedCallback", "", "failToast", "", "isInitLocalData", "", "onLoadSucceedCallback", "dataWrapper", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterDataWrapper;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPersonalizedDataListener.kt */
public interface IPersonalizedDataListener {
    void onFailedCallback(String str, boolean z);

    void onLoadSucceedCallback(PersonalCenterDataWrapper personalCenterDataWrapper, boolean z);
}
