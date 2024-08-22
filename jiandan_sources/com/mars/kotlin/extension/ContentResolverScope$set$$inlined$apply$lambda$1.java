package com.mars.kotlin.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/ContentValuesScope;", "invoke", "com/mars/kotlin/extension/ContentResolverScope$set$3$1"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class ContentResolverScope$set$$inlined$apply$lambda$1 extends Lambda implements Function1<ContentValuesScope, Unit> {
    public final /* synthetic */ Object $column$inlined;
    public final /* synthetic */ Object $value$inlined;
    public final /* synthetic */ ContentResolverScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentResolverScope$set$$inlined$apply$lambda$1(ContentResolverScope contentResolverScope, Object obj, Object obj2) {
        super(1);
        this.this$0 = contentResolverScope;
        this.$column$inlined = obj;
        this.$value$inlined = obj2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentValuesScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentValuesScope contentValuesScope) {
        Intrinsics.checkNotNullParameter(contentValuesScope, "$receiver");
        contentValuesScope.minus(this.$column$inlined, this.$value$inlined);
    }
}
