package com.tera.scan.pdfedit.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import fe.mmm.qw.qqq.yj.qw;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PDFMergeKt$initPageState$1$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ PdfToolboxSelectActivity $this_initPageState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PDFMergeKt$initPageState$1$1(PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        super(1);
        this.$this_initPageState = pdfToolboxSelectActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            boolean isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease = this.$this_initPageState.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease();
            qw.fe("PDFMrgLgSuc", this.$this_initPageState.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
            View _$_findCachedViewById = this.$this_initPageState._$_findCachedViewById(R.id.layout_not_login);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_not_login");
            _$_findCachedViewById.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) this.$this_initPageState._$_findCachedViewById(R.id.rv_pdf_select_list);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "rv_pdf_select_list");
            recyclerView.setVisibility(0);
            this.$this_initPageState.initData$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease();
        }
    }
}
