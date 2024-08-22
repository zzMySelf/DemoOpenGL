package com.baidu.searchbox.search.tab.implement.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/utils/SkipRecord;", "", "skipSeekSuccess", "", "(Z)V", "getSkipSeekSuccess", "()Z", "setSkipSeekSuccess", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SkipToastUtil.kt */
public final class SkipRecord {
    private boolean skipSeekSuccess;

    public SkipRecord() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public SkipRecord(boolean skipSeekSuccess2) {
        this.skipSeekSuccess = skipSeekSuccess2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SkipRecord(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean getSkipSeekSuccess() {
        return this.skipSeekSuccess;
    }

    public final void setSkipSeekSuccess(boolean z) {
        this.skipSeekSuccess = z;
    }
}
