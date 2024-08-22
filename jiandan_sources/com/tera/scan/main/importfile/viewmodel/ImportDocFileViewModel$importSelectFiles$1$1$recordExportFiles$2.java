package com.tera.scan.main.importfile.viewmodel;

import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.xxx.uk.when.ad;
import fe.mmm.qw.xxx.uk.when.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "importFile", "Lcom/tera/scan/main/importfile/data/ImportFile;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImportDocFileViewModel$importSelectFiles$1$1$recordExportFiles$2 extends Lambda implements Function1<qw, ScanRecordExportFile> {
    public final /* synthetic */ ImportDocFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFileViewModel$importSelectFiles$1$1$recordExportFiles$2(ImportDocFileViewModel importDocFileViewModel) {
        super(1);
        this.this$0 = importDocFileViewModel;
    }

    @NotNull
    public final ScanRecordExportFile invoke(@NotNull qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "importFile");
        fe.mmm.qw.i.qw.ad("import_doc", "import file: " + qwVar.qw());
        return ad.qw(qwVar, this.this$0.qw);
    }
}
