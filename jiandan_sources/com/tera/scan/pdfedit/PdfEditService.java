package com.tera.scan.pdfedit;

import android.content.Context;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import i.qw.Cif;
import i.qw.i0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/tera/scan/pdfedit/PdfEditService;", "", "()V", "createLocalPdf", "", "context", "Landroid/content/Context;", "pdfPath", "", "filePaths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isA4Size", "", "showLogo", "callback", "Lcom/tera/scan/pdfedit/component/provider/IPdfEditCallback;", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfEditService {
    public final void qw(@NotNull Context context, @NotNull String str, @NotNull ArrayList<String> arrayList, boolean z, boolean z2, @NotNull IPdfEditCallback iPdfEditCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pdfPath");
        Intrinsics.checkNotNullParameter(arrayList, "filePaths");
        IPdfEditCallback iPdfEditCallback2 = iPdfEditCallback;
        Intrinsics.checkNotNullParameter(iPdfEditCallback2, "callback");
        i0 i0Var = i0.f6136ad;
        Job unused = Cif.fe(i0Var, (CoroutineContext) null, (CoroutineStart) null, new PdfEditService$createLocalPdf$1(context, arrayList, str, z2, iPdfEditCallback2, z, (Continuation<? super PdfEditService$createLocalPdf$1>) null), 3, (Object) null);
    }
}
