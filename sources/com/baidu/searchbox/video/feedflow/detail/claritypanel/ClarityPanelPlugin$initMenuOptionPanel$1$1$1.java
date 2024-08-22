package com.baidu.searchbox.video.feedflow.detail.claritypanel;

import com.baidu.searchbox.video.feedflow.view.menupanel.OptionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "model", "Lcom/baidu/searchbox/video/feedflow/view/menupanel/OptionModel;", "oldModel", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClarityPanelPlugin.kt */
final class ClarityPanelPlugin$initMenuOptionPanel$1$1$1 extends Lambda implements Function2<OptionModel, OptionModel, Unit> {
    final /* synthetic */ ClarityPanelPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClarityPanelPlugin$initMenuOptionPanel$1$1$1(ClarityPanelPlugin clarityPanelPlugin) {
        super(2);
        this.this$0 = clarityPanelPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((OptionModel) p1, (OptionModel) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(OptionModel model, OptionModel oldModel) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.this$0.onItemClick(model, oldModel);
    }
}
