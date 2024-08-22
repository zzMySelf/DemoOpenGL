package com.tera.scan.pdfedit.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel", f = "PdfWatermarkSelectViewModel.kt", i = {0}, l = {64}, m = "doInitPdfData", n = {"this"}, s = {"L$0"})
public final class PdfWatermarkSelectViewModel$doInitPdfData$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PdfWatermarkSelectViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkSelectViewModel$doInitPdfData$1(PdfWatermarkSelectViewModel pdfWatermarkSelectViewModel, Continuation<? super PdfWatermarkSelectViewModel$doInitPdfData$1> continuation) {
        super(continuation);
        this.this$0 = pdfWatermarkSelectViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.qw(this);
    }
}
