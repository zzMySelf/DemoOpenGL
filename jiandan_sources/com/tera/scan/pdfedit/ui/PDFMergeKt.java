package com.tera.scan.pdfedit.ui;

import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.qqq.uk.eee;
import fe.mmm.qw.qqq.uk.j;
import fe.mmm.qw.qqq.uk.k;
import fe.mmm.qw.qw.qw;
import fe.mmm.qw.th.qw.th.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0007\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\b\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u0004*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0012\u0010\u0014\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0011¨\u0006\u0016"}, d2 = {"addFileBtnInBottom", "", "Lcom/tera/scan/pdfedit/ui/PdfMergeAdjustFileActivity;", "init", "", "Lcom/tera/scan/pdfedit/ui/PdfToolboxSelectActivity;", "initBottomBtn", "Lcom/tera/scan/pdfedit/ui/PdfMergeAddActivity;", "Lcom/tera/scan/pdfedit/ui/PdfMergingActivity;", "initPageState", "initTopTitle", "Lcom/tera/scan/pdfedit/ui/PdfSplitActivity;", "onPdfLoadClick", "showSuccessToast", "supportSinglePagePdfSplit", "Lcom/tera/scan/pdfedit/viewmodel/PdfSplitViewModel;", "titleName", "", "updateContent", "isDataEmpty", "updateSelectedFileNum", "num", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PDFMergeKt {
    public static final void ad(@NotNull PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "<this>");
        if (qw.qw.pf()) {
            pdfToolboxSelectActivity.initData$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease();
        }
    }

    public static final void de(@NotNull PdfMergeAddActivity pdfMergeAddActivity) {
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "<this>");
        ((UIButton) pdfMergeAddActivity._$_findCachedViewById(R.id.btn_cancel_import)).setTypeface(Typeface.defaultFromStyle(1));
        ((UIButton) pdfMergeAddActivity._$_findCachedViewById(R.id.btn_confirm_import)).setTypeface(Typeface.defaultFromStyle(1));
    }

    public static final void fe(@NotNull PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "<this>");
        ((UIButton) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.btn_add_file)).setTypeface(Typeface.defaultFromStyle(1));
        ((UIButton) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.btn_merge_pdfs)).setTypeface(Typeface.defaultFromStyle(1));
        ImageView imageView = (ImageView) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.iv_adjust_free_limit);
        Intrinsics.checkNotNullExpressionValue(imageView, "iv_adjust_free_limit");
        imageView.setVisibility(0);
        ((ImageView) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.iv_adjust_free_limit)).setImageResource(R.drawable.icon_free_limit);
    }

    public static final void ggg(@NotNull PdfSplitActivity pdfSplitActivity, int i2) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "<this>");
    }

    public static final void i(PdfSplitActivity pdfSplitActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "$this_initTopTitle");
        pdfSplitActivity.getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().changeAllSelectState();
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m849if(@NotNull PdfSplitActivity pdfSplitActivity) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "<this>");
        o.uk(pdfSplitActivity.getString(R.string.pdf_split_success));
    }

    public static final void o(PdfSplitActivity pdfSplitActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "$this_initTopTitle");
        if (bool != null) {
            bool.booleanValue();
            ((TextView) pdfSplitActivity._$_findCachedViewById(R.id.tv_select_all)).setText(pdfSplitActivity.getString(bool.booleanValue() ? R.string.disselect_all_file : R.string.select_all_file));
        }
    }

    public static final void pf(@NotNull PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "<this>");
        fe.mmm.qw.qqq.yj.qw.ad(pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgImp" : "PDFExImp", pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        if (qw.qw.pf()) {
            pdfToolboxSelectActivity.onMyDeviceItemClick$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease();
            return;
        }
        fe.mmm.qw.qqq.yj.qw.fe(pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgUnld" : "PDFExUnld", pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        qw.xxx(qw.qw, pdfToolboxSelectActivity, (String) null, true, new PDFMergeKt$onPdfLoadClick$1(pdfToolboxSelectActivity), 2, (Object) null);
    }

    public static final void ppp(@NotNull PdfToolboxSelectActivity pdfToolboxSelectActivity, boolean z) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "<this>");
        RecyclerView recyclerView = (RecyclerView) pdfToolboxSelectActivity._$_findCachedViewById(R.id.rv_pdf_select_list);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rv_pdf_select_list");
        int i2 = 8;
        recyclerView.setVisibility(z ^ true ? 0 : 8);
        View _$_findCachedViewById = pdfToolboxSelectActivity._$_findCachedViewById(R.id.layout_empty);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_empty");
        _$_findCachedViewById.setVisibility(z ? 0 : 8);
        ConstraintLayout constraintLayout = (ConstraintLayout) pdfToolboxSelectActivity._$_findCachedViewById(R.id.ll_pdf_select_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "ll_pdf_select_bottom_btn");
        if (!z && pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            i2 = 0;
        }
        constraintLayout.setVisibility(i2);
    }

    public static final boolean qw(@NotNull PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "<this>");
        return true;
    }

    public static final void rg(@NotNull PdfMergingActivity pdfMergingActivity) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "<this>");
        ((UIButton) pdfMergingActivity._$_findCachedViewById(R.id.btn_cancel_merge_pdf)).setTypeface(Typeface.defaultFromStyle(1));
    }

    /* renamed from: switch  reason: not valid java name */
    public static final boolean m850switch(@NotNull PdfSplitViewModel pdfSplitViewModel) {
        Intrinsics.checkNotNullParameter(pdfSplitViewModel, "<this>");
        return true;
    }

    public static final void th(@NotNull PdfToolboxSelectActivity pdfToolboxSelectActivity) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "<this>");
        boolean pf2 = qw.qw.pf();
        RecyclerView recyclerView = (RecyclerView) pdfToolboxSelectActivity._$_findCachedViewById(R.id.rv_pdf_select_list);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rv_pdf_select_list");
        int i2 = 8;
        recyclerView.setVisibility(pf2 ? 0 : 8);
        View _$_findCachedViewById = pdfToolboxSelectActivity._$_findCachedViewById(R.id.layout_not_login);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_not_login");
        _$_findCachedViewById.setVisibility(pf2 ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = (ConstraintLayout) pdfToolboxSelectActivity._$_findCachedViewById(R.id.ll_pdf_select_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "ll_pdf_select_bottom_btn");
        if (pf2 && pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            i2 = 0;
        }
        constraintLayout.setVisibility(i2);
        ((UIButton) pdfToolboxSelectActivity._$_findCachedViewById(R.id.btn_login)).setOnClickListener(new eee(pdfToolboxSelectActivity));
        ((UIButton) pdfToolboxSelectActivity._$_findCachedViewById(R.id.btn_pdf_select_cancel_select)).setTypeface(Typeface.defaultFromStyle(1));
        ((UIButton) pdfToolboxSelectActivity._$_findCachedViewById(R.id.btn_pdf_select_confirm_select)).setTypeface(Typeface.defaultFromStyle(1));
        ((TextView) pdfToolboxSelectActivity._$_findCachedViewById(R.id.tv_import_files)).setTypeface(Typeface.defaultFromStyle(1));
        if (pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            ImageView imageView = (ImageView) pdfToolboxSelectActivity._$_findCachedViewById(R.id.iv_toolbox_free_limit);
            Intrinsics.checkNotNullExpressionValue(imageView, "iv_toolbox_free_limit");
            imageView.setVisibility(0);
            ((ImageView) pdfToolboxSelectActivity._$_findCachedViewById(R.id.iv_toolbox_free_limit)).setImageResource(R.drawable.icon_free_limit);
        }
    }

    public static final void uk(@NotNull PdfSplitActivity pdfSplitActivity) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "<this>");
        ((TextView) pdfSplitActivity._$_findCachedViewById(R.id.tv_select_all)).setOnClickListener(new k(pdfSplitActivity));
        pdfSplitActivity.getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().isAllSelectLiveData().observe(pdfSplitActivity, new j(pdfSplitActivity));
        ImageView imageView = (ImageView) pdfSplitActivity._$_findCachedViewById(R.id.iv_split_free_limit);
        Intrinsics.checkNotNullExpressionValue(imageView, "iv_split_free_limit");
        imageView.setVisibility(0);
        ((ImageView) pdfSplitActivity._$_findCachedViewById(R.id.iv_split_free_limit)).setImageResource(R.drawable.icon_free_limit);
    }

    public static final int when(@NotNull PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "<this>");
        return R.string.title_pdf_merge_adjust;
    }

    public static final void yj(PdfToolboxSelectActivity pdfToolboxSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "$this_initPageState");
        fe.mmm.qw.qqq.yj.qw.ad(pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgLg_clk" : "PDFExLg_clk", pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        qw.xxx(qw.qw, pdfToolboxSelectActivity, (String) null, true, new PDFMergeKt$initPageState$1$1(pdfToolboxSelectActivity), 2, (Object) null);
    }
}
