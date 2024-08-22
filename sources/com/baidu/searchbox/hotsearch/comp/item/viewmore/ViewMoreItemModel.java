package com.baidu.searchbox.hotsearch.comp.item.viewmore;

import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/hotsearch/comp/item/viewmore/ViewMoreItemModel;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "moreUrl", "", "(Ljava/lang/String;)V", "getMoreUrl", "()Ljava/lang/String;", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "Companion", "lib_hot_search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewMoreItemComp.kt */
public final class ViewMoreItemModel implements IAdapterData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId TYPE;
    private final String moreUrl;

    public ViewMoreItemModel(String moreUrl2) {
        Intrinsics.checkNotNullParameter(moreUrl2, "moreUrl");
        this.moreUrl = moreUrl2;
    }

    public final String getMoreUrl() {
        return this.moreUrl;
    }

    public UniqueId getType() {
        return TYPE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/hotsearch/comp/item/viewmore/ViewMoreItemModel$Companion;", "", "()V", "TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getTYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib_hot_search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ViewMoreItemComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getTYPE() {
            return ViewMoreItemModel.TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("ViewMoreItemModel");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"ViewMoreItemModel\")");
        TYPE = gen;
    }
}
