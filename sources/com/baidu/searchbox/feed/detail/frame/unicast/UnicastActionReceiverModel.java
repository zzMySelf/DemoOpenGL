package com.baidu.searchbox.feed.detail.frame.unicast;

import com.baidu.searchbox.noveladapter.ubc.NovelUBCRetrievalStat;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/detail/frame/unicast/UnicastActionReceiverModel;", "", "actionName", "", "middlewareNameSet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "reducerNameSet", "(Ljava/lang/String;Ljava/util/LinkedHashSet;Ljava/util/LinkedHashSet;)V", "getActionName", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "getMiddlewareNameSet", "()Ljava/util/LinkedHashSet;", "getReducerNameSet", "lib-component-redux"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IUnicastActionMappingTable.kt */
public final class UnicastActionReceiverModel {
    private String actionName;
    private final LinkedHashSet<String> middlewareNameSet;
    private final LinkedHashSet<String> reducerNameSet;

    public UnicastActionReceiverModel() {
        this((String) null, (LinkedHashSet) null, (LinkedHashSet) null, 7, (DefaultConstructorMarker) null);
    }

    public UnicastActionReceiverModel(String actionName2, LinkedHashSet<String> middlewareNameSet2, LinkedHashSet<String> reducerNameSet2) {
        Intrinsics.checkNotNullParameter(actionName2, NovelUBCRetrievalStat.ACTION_TYPE_ACTIONNAME);
        Intrinsics.checkNotNullParameter(middlewareNameSet2, "middlewareNameSet");
        Intrinsics.checkNotNullParameter(reducerNameSet2, "reducerNameSet");
        this.actionName = actionName2;
        this.middlewareNameSet = middlewareNameSet2;
        this.reducerNameSet = reducerNameSet2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnicastActionReceiverModel(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new LinkedHashSet() : linkedHashSet, (i2 & 4) != 0 ? new LinkedHashSet() : linkedHashSet2);
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final void setActionName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionName = str;
    }

    public final LinkedHashSet<String> getMiddlewareNameSet() {
        return this.middlewareNameSet;
    }

    public final LinkedHashSet<String> getReducerNameSet() {
        return this.reducerNameSet;
    }
}
