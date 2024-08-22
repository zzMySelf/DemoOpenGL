package com.baidu.searchbox.newhome.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isImageShow", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1TabOperationManager.kt */
final class HomeV1TabOperationManager$onApplyOperation$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ HomeV1TabOpService $curTabOpService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeV1TabOperationManager$onApplyOperation$2(HomeV1TabOpService homeV1TabOpService) {
        super(1);
        this.$curTabOpService = homeV1TabOpService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isImageShow) {
        this.$curTabOpService.tabOpShow(isImageShow, "type_operation_image");
    }
}
