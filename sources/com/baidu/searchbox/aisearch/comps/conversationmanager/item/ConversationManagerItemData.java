package com.baidu.searchbox.aisearch.comps.conversationmanager.item;

import com.baidu.searchbox.aisearch.comps.conversationmanager.model.ConversationItem;
import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/item/ConversationManagerItemData;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "data", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/model/ConversationItem;", "(Lcom/baidu/searchbox/aisearch/comps/conversationmanager/model/ConversationItem;)V", "getData", "()Lcom/baidu/searchbox/aisearch/comps/conversationmanager/model/ConversationItem;", "isSelected", "", "()Z", "setSelected", "(Z)V", "showDelete", "getShowDelete", "setShowDelete", "showOnceDeleteAnim", "getShowOnceDeleteAnim", "setShowOnceDeleteAnim", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerItemData.kt */
public final class ConversationManagerItemData implements IAdapterData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId DEFAULT_TYPE;
    /* access modifiers changed from: private */
    public static final UniqueId NORMAL_TYPE;
    private final ConversationItem data;
    private boolean isSelected;
    private boolean showDelete;
    private boolean showOnceDeleteAnim;

    public ConversationManagerItemData(ConversationItem data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    public final ConversationItem getData() {
        return this.data;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean getShowDelete() {
        return this.showDelete;
    }

    public final void setShowDelete(boolean z) {
        this.showDelete = z;
    }

    public final boolean getShowOnceDeleteAnim() {
        return this.showOnceDeleteAnim;
    }

    public final void setShowOnceDeleteAnim(boolean z) {
        this.showOnceDeleteAnim = z;
    }

    public UniqueId getType() {
        return this.data.getDefault() == 1 ? DEFAULT_TYPE : NORMAL_TYPE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/item/ConversationManagerItemData$Companion;", "", "()V", "DEFAULT_TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getDEFAULT_TYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "NORMAL_TYPE", "getNORMAL_TYPE", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationManagerItemData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getDEFAULT_TYPE() {
            return ConversationManagerItemData.DEFAULT_TYPE;
        }

        public final UniqueId getNORMAL_TYPE() {
            return ConversationManagerItemData.NORMAL_TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("default");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"default\")");
        DEFAULT_TYPE = gen;
        UniqueId gen2 = UniqueId.gen("normal");
        Intrinsics.checkNotNullExpressionValue(gen2, "gen(\"normal\")");
        NORMAL_TYPE = gen2;
    }
}
