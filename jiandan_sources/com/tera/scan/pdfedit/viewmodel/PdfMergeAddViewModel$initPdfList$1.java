package com.tera.scan.pdfedit.viewmodel;

import i.qw.o;
import i.qw.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfMergeAddViewModel$initPdfList$1", f = "PdfMergeAddViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class PdfMergeAddViewModel$initPdfList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ PdfMergeAddViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfMergeAddViewModel$initPdfList$1(PdfMergeAddViewModel pdfMergeAddViewModel, Continuation<? super PdfMergeAddViewModel$initPdfList$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfMergeAddViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfMergeAddViewModel$initPdfList$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfMergeAddViewModel$initPdfList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.qw.setValue(Boxing.boxBoolean(true));
            CoroutineDispatcher ad2 = u.ad();
            PdfMergeAddViewModel$initPdfList$1$resultList$1 pdfMergeAddViewModel$initPdfList$1$resultList$1 = new PdfMergeAddViewModel$initPdfList$1$resultList$1(this.this$0, (Continuation<? super PdfMergeAddViewModel$initPdfList$1$resultList$1>) null);
            this.label = 1;
            obj = o.yj(ad2, pdfMergeAddViewModel$initPdfList$1$resultList$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.f7088de.setValue((List) obj);
        this.this$0.qw.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
