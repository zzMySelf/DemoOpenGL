package com.baidu.searchbox.home.tabs.operation;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/home/tabs/operation/ILinkageCallback;", "", "actId", "", "getActId", "()Ljava/lang/String;", "isNeedLinkage", "", "()Z", "saveLinkageInfo", "", "id", "endTime", "", "subtractRecordCount", "lib-home-tab-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ILinkageCallback.kt */
public interface ILinkageCallback {
    String getActId();

    boolean isNeedLinkage();

    void saveLinkageInfo(String str, long j2);

    void subtractRecordCount();
}
