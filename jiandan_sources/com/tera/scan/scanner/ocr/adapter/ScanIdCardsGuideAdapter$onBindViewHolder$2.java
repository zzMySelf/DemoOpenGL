package com.tera.scan.scanner.ocr.adapter;

import com.tera.scan.ui.view.widget.UITextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tera/scan/ui/view/widget/UITextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsGuideAdapter$onBindViewHolder$2 extends Lambda implements Function1<UITextView, Unit> {
    public final /* synthetic */ int $position;
    public final /* synthetic */ ScanIdCardsGuideAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsGuideAdapter$onBindViewHolder$2(ScanIdCardsGuideAdapter scanIdCardsGuideAdapter, int i2) {
        super(1);
        this.this$0 = scanIdCardsGuideAdapter;
        this.$position = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UITextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull UITextView uITextView) {
        Intrinsics.checkNotNullParameter(uITextView, "it");
        this.this$0.qw(this.$position);
    }
}
