package com.baidu.growthsystem.framework.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0016\b\u0000\u0010\u0002*\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "SUB", "Lcom/baidu/growthsystem/framework/component/BaseSubGrowthComponent;", "STATUS", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseGrowthComponent.kt */
final class BaseGrowthComponent$onClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseGrowthComponent<SUB, STATUS> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseGrowthComponent$onClick$1(BaseGrowthComponent<SUB, STATUS> baseGrowthComponent) {
        super(0);
        this.this$0 = baseGrowthComponent;
    }

    public final Unit invoke() {
        SUB curSubComponent = this.this$0.getCurSubComponent();
        if (curSubComponent == null) {
            return null;
        }
        curSubComponent.onClick();
        return Unit.INSTANCE;
    }
}
