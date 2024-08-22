package com.tera.scan.pdfedit.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.pdfedit.viewmodel.PdfWatermarkCreateViewModel;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.qqq.o.de;
import fe.mmm.qw.qqq.uk.ad;
import fe.mmm.qw.qqq.uk.f;
import fe.mmm.qw.th.qw.th.i;
import fe.mmm.qw.yj.th;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001aH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006%"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfWatermarkCreateActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "Lkotlin/Lazy;", "localFilePath", "", "watermarkCreateViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkCreateViewModel;", "getWatermarkCreateViewModel", "()Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkCreateViewModel;", "watermarkCreateViewModel$delegate", "watermarkText", "watermarkTextColor", "watermarkTextSize", "", "Ljava/lang/Double;", "watermarkTextSizeScale", "watermarkTextTransparency", "getLayoutId", "", "hideLoading", "", "initData", "initView", "jumpToDocumentViewerPage", "scanRecordExportFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/pdf_edit/watermark_create/activity")
public final class PdfWatermarkCreateActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_PATH = "extra_path";
    @NotNull
    public static final String EXTRA_TEXT = "extra_text";
    @NotNull
    public static final String EXTRA_TEXT_COLOR = "extra_text_color";
    @NotNull
    public static final String EXTRA_TEXT_SIZE = "extra_text_size";
    @NotNull
    public static final String EXTRA_TEXT_SIZE_SCALE = "extra_text_size_scale";
    @NotNull
    public static final String EXTRA_TEXT_TRANSPARENCY = "extra_text_transparency";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkCreateActivity$loadingDialogHelper$2(this));
    @Nullable
    public String localFilePath;
    @NotNull
    public final Lazy watermarkCreateViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkCreateActivity$watermarkCreateViewModel$2(this));
    @Nullable
    public String watermarkText;
    @Nullable
    public String watermarkTextColor;
    @Nullable
    public Double watermarkTextSize;
    @Nullable
    public Double watermarkTextSizeScale;
    @Nullable
    public Double watermarkTextTransparency;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final i getLoadingDialogHelper() {
        return (i) this.loadingDialogHelper$delegate.getValue();
    }

    private final PdfWatermarkCreateViewModel getWatermarkCreateViewModel() {
        return (PdfWatermarkCreateViewModel) this.watermarkCreateViewModel$delegate.getValue();
    }

    private final void hideLoading() {
        getLoadingDialogHelper().fe();
    }

    private final void initData() {
        Unit unit;
        String str = this.watermarkText;
        if (str == null || str.length() == 0) {
            String str2 = this.localFilePath;
            if (str2 != null) {
                ScanRecordExportFile.qw qwVar = ScanRecordExportFile.Companion;
                Application application = getApplication();
                Intrinsics.checkNotNullExpressionValue(application, MediaType.APPLICATION_TYPE);
                jumpToDocumentViewerPage(qwVar.qw(application, str2));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                finish();
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("watermark_info_text_cache", this.watermarkText);
            jSONObject.put("watermark_info_text_size_cache", this.watermarkTextSize);
            jSONObject.put("watermark_info_text_size_scale_cache", this.watermarkTextSizeScale);
            jSONObject.put("watermark_info_text_transparency_cache", this.watermarkTextTransparency);
            jSONObject.put("watermark_info_text_color_cache", this.watermarkTextColor);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            th.ppp().m1013switch("key_watermark_info_cache", jSONObject2);
            getWatermarkCreateViewModel().createWatermarkPdf(this.localFilePath, this.watermarkText, this.watermarkTextSize, this.watermarkTextSizeScale, this.watermarkTextTransparency, this.watermarkTextColor);
        }
        getWatermarkCreateViewModel().getLoadingLiveData().observe(this, new ad(this));
        getWatermarkCreateViewModel().getCreateWatermarkPdfResultLiveData().observe(this, new f(this));
    }

    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m879initData$lambda1(PdfWatermarkCreateActivity pdfWatermarkCreateActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfWatermarkCreateActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                pdfWatermarkCreateActivity.showLoading();
            } else {
                pdfWatermarkCreateActivity.hideLoading();
            }
        }
    }

    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m880initData$lambda2(PdfWatermarkCreateActivity pdfWatermarkCreateActivity, de deVar) {
        Intrinsics.checkNotNullParameter(pdfWatermarkCreateActivity, "this$0");
        if (deVar != null) {
            if (deVar instanceof de.qw) {
                pdfWatermarkCreateActivity.finish();
            } else if (deVar instanceof de.ad) {
                pdfWatermarkCreateActivity.jumpToDocumentViewerPage(((de.ad) deVar).qw());
            }
        }
    }

    private final void jumpToDocumentViewerPage(ScanRecordExportFile scanRecordExportFile) {
        startActivity(DocumentViewerActivity.getStartIntent(getApplicationContext(), scanRecordExportFile.getLocalPath(), scanRecordExportFile, "", -1, 0, ""));
        finish();
    }

    private final void showLoading() {
        getLoadingDialogHelper().rg(R.string.loading_text);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getLayoutId() {
        return R.layout.activity_pdf_watermark_create_layout;
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("extra_path");
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        this.localFilePath = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(EXTRA_TEXT);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.watermarkText = str;
        this.watermarkTextSize = Double.valueOf(getIntent().getDoubleExtra(EXTRA_TEXT_SIZE, 16.0d));
        this.watermarkTextSizeScale = Double.valueOf(getIntent().getDoubleExtra(EXTRA_TEXT_SIZE_SCALE, 1.0d));
        this.watermarkTextTransparency = Double.valueOf(getIntent().getDoubleExtra(EXTRA_TEXT_TRANSPARENCY, 0.2d));
        String stringExtra3 = getIntent().getStringExtra(EXTRA_TEXT_COLOR);
        if (stringExtra3 == null) {
            stringExtra3 = "000000";
        }
        this.watermarkTextColor = stringExtra3;
        String str2 = this.localFilePath;
        if (str2 == null || str2.length() == 0) {
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }
}
