package com.tera.scan.doc.preview.document.ui.view.flavor;

import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.ConfirmDialog;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.doc.preview.office.ui.DocTinyFragment;
import com.tera.scan.doc.preview.pdf.ui.PDFFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0005\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG_DELETE_FILE_DIALOG", "", "bottomFunctionSupport", "", "Lcom/tera/scan/doc/preview/office/ui/DocTinyFragment;", "Lcom/tera/scan/doc/preview/pdf/ui/PDFFragment;", "deleteFileConfirm", "", "Lcom/tera/scan/doc/preview/document/ui/view/DocumentViewerActivity;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirm", "preview-document_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DocumentFragmentKt {
    public static final int ad(@NotNull PDFFragment pDFFragment) {
        Intrinsics.checkNotNullParameter(pDFFragment, "<this>");
        return 19;
    }

    public static final void de(@NotNull DocumentViewerActivity documentViewerActivity, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(documentViewerActivity, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ConfirmDialog.qw qwVar = new ConfirmDialog.qw();
        String string = documentViewerActivity.getString(R.string.delete_dialog_content);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n            R…_dialog_content\n        )");
        qwVar.rg(string);
        String string2 = documentViewerActivity.getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.delete)");
        qwVar.fe(string2);
        String string3 = documentViewerActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.cancel)");
        qwVar.ad(string3);
        qwVar.de(true);
        ConfirmDialog qw = qwVar.qw();
        qw.setOnConfirmChange(new DocumentFragmentKt$deleteFileConfirm$1(function1));
        qw.setOnCancelChange(new DocumentFragmentKt$deleteFileConfirm$2(function1));
        FragmentManager supportFragmentManager = documentViewerActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        qw.show(supportFragmentManager, "DeleteFileDialog");
    }

    public static final int qw(@NotNull DocTinyFragment docTinyFragment) {
        Intrinsics.checkNotNullParameter(docTinyFragment, "<this>");
        return 1;
    }
}
