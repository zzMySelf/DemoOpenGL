package com.tera.scan.scanner.ocr.control;

import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.ggg.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tera/scan/ui/view/widget/UIButton;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsGuideControl$onInitView$1 extends Lambda implements Function1<UIButton, Unit> {
    public final /* synthetic */ ScanIdCardsGuideControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsGuideControl$onInitView$1(ScanIdCardsGuideControl scanIdCardsGuideControl) {
        super(1);
        this.this$0 = scanIdCardsGuideControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UIButton) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull UIButton uIButton) {
        Intrinsics.checkNotNullParameter(uIButton, "it");
        int o2 = this.this$0.o();
        qw.qw.qw("camera_id_cards_take_photos_click", CollectionsKt__CollectionsJVMKt.listOf(o2 != 1 ? o2 != 6 ? "single_side" : "passport" : "id_cards"));
        this.this$0.when();
    }
}
