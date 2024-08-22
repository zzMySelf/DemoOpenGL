package com.baidu.searchbox.flowvideo.dynamic.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/flowvideo/dynamic/api/DynamicTitleParagraphsBean;", "Lcom/baidu/searchbox/NoProGuard;", "content", "", "enterNums", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEnterNums", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailBean.kt */
public final class DynamicTitleParagraphsBean implements NoProGuard {
    private final String content;
    private final String enterNums;

    public DynamicTitleParagraphsBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public DynamicTitleParagraphsBean(String content2, String enterNums2) {
        Intrinsics.checkNotNullParameter(content2, "content");
        Intrinsics.checkNotNullParameter(enterNums2, "enterNums");
        this.content = content2;
        this.enterNums = enterNums2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicTitleParagraphsBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEnterNums() {
        return this.enterNums;
    }
}
