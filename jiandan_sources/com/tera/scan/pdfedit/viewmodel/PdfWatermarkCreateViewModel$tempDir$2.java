package com.tera.scan.pdfedit.viewmodel;

import fe.mmm.qw.qqq.de.qw;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PdfWatermarkCreateViewModel$tempDir$2 extends Lambda implements Function0<File> {
    public final /* synthetic */ PdfWatermarkCreateViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkCreateViewModel$tempDir$2(PdfWatermarkCreateViewModel pdfWatermarkCreateViewModel) {
        super(0);
        this.this$0 = pdfWatermarkCreateViewModel;
    }

    @NotNull
    public final File invoke() {
        return qw.ad(this.this$0.qw);
    }
}
