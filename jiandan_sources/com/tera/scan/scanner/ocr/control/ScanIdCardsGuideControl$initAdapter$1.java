package com.tera.scan.scanner.ocr.control;

import com.tera.scan.scanner.ocr.model.ScanIdCardsModel;
import fe.mmm.qw.ggg.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "selectItem", "Lcom/tera/scan/scanner/ocr/model/ScanIdCardsModel;", "selectPosition", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsGuideControl$initAdapter$1 extends Lambda implements Function2<ScanIdCardsModel, Integer, Unit> {
    public final /* synthetic */ ScanIdCardsGuideControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsGuideControl$initAdapter$1(ScanIdCardsGuideControl scanIdCardsGuideControl) {
        super(2);
        this.this$0 = scanIdCardsGuideControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ScanIdCardsModel) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ScanIdCardsModel scanIdCardsModel, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(scanIdCardsModel, "selectItem");
        Integer category = scanIdCardsModel.getCategory();
        if (category != null && category.intValue() == 1) {
            str = "id_cards";
        } else {
            str = (category != null && category.intValue() == 6) ? "passport" : "single_side";
        }
        qw.qw.qw("camera_id_cards_choose_types_click", CollectionsKt__CollectionsJVMKt.listOf(str));
        this.this$0.ppp(i2);
    }
}
