package com.tera.scan.pdfedit.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.rrr.qw.ad;
import fe.mmm.qw.th.qw.th.i;
import i.qw.Cif;
import i.qw.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002JO\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019J8\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/pdfedit/util/PdfCreateWatermarkPageHandler;", "", "()V", "getAvailableNewPath", "", "oldPath", "fileOldName", "jumpToDocumentViewerPage", "", "context", "Landroid/content/Context;", "scanRecordExportFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "onCreatePdfFinish", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "path", "performCreateWatermarkPdf", "localFilePath", "watermarkText", "watermarkTextSize", "", "watermarkTextSizeScale", "watermarkTextTransparency", "watermarkTextColor", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "startCreateLocalPdf", "originLocalPath", "filesLocalPath", "", "writePdfToDb", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfCreateWatermarkPageHandler {
    @NotNull
    public static final PdfCreateWatermarkPageHandler qw = new PdfCreateWatermarkPageHandler();

    public static final class qw implements IPdfEditCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ i f7086ad;
        public final /* synthetic */ Context qw;

        public qw(Context context, i iVar) {
            this.qw = context;
            this.f7086ad = iVar;
        }

        public void ad(@Nullable String str) {
            PdfCreateWatermarkPageHandler.qw.th(this.qw, this.f7086ad, str);
        }

        public void qw(int i2) {
        }
    }

    public static final void rg(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.overridePendingTransition(-1, -1);
            activity.finish();
        }
    }

    public final String de(String str, String str2) {
        String str3;
        String sb;
        int i2 = 0;
        do {
            if (i2 == 0) {
                str3 = str2 + " watermark";
            } else {
                str3 = str2 + " watermark(" + i2 + ')';
            }
            StringBuilder sb2 = new StringBuilder();
            String substring = str.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(substring);
            sb2.append('/');
            sb2.append(str3);
            sb2.append(".pdf");
            sb = sb2.toString();
            i2++;
        } while (new File(sb).exists());
        return sb;
    }

    public final void fe(Context context, ScanRecordExportFile scanRecordExportFile) {
        Intent startIntent = DocumentViewerActivity.getStartIntent(context, scanRecordExportFile.getLocalPath(), scanRecordExportFile, "", -1, 0, "");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.startActivity(startIntent);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new fe.mmm.qw.qqq.i.qw(context), 200);
    }

    public final void i(Context context, String str) {
        ScanRecordExportFile qw2 = ScanRecordExportFile.Companion.qw(context, str);
        if (ad.qw.qw().pf(context, CollectionsKt__CollectionsJVMKt.listOf(qw2))) {
            fe(context, qw2);
        }
    }

    public final void th(Context context, i iVar, String str) {
        iVar.fe();
        if (!(str == null || str.length() == 0)) {
            i(context, str);
        }
    }

    public final void uk(Context context, i iVar, String str, String str2, List<String> list) {
        fe.mmm.qw.qqq.ad.qw.qw.qw(context, de(str, str2), new ArrayList(list), false, false, new qw(context, iVar));
    }

    public final void yj(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable Double d, @Nullable Double d2, @Nullable Double d3, @Nullable String str3) {
        Context context2 = context;
        String str4 = str;
        Intrinsics.checkNotNullParameter(context2, "context");
        if (!(str2 == null || str2.length() == 0)) {
            File ad2 = fe.mmm.qw.qqq.de.qw.ad(context);
            if (!(str4 == null || str.length() == 0)) {
                i iVar = new i((Activity) context2);
                i.th(iVar, 0, 1, (Object) null);
                Job unused = Cif.fe(fe.mmm.qw.p030switch.th.ad.qw.qw.qw(), u.ad(), (CoroutineStart) null, new PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2(str, iVar, str2, d, d2, d3, str3, ad2, context, (Continuation<? super PdfCreateWatermarkPageHandler$performCreateWatermarkPdf$2>) null), 2, (Object) null);
            }
        } else if (str4 != null) {
            qw.fe(context2, ScanRecordExportFile.Companion.qw(context2, str4));
        }
    }
}
