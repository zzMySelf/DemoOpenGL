package com.tera.scan.pdfedit.viewmodel;

import fe.mmm.qw.qqq.rg.ad;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel$startSplitPdf$1", f = "PdfSplitViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfSplitViewModel$startSplitPdf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ PdfSplitViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfSplitViewModel$startSplitPdf$1(PdfSplitViewModel pdfSplitViewModel, Continuation<? super PdfSplitViewModel$startSplitPdf$1> continuation) {
        super(2, continuation);
        this.this$0 = pdfSplitViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfSplitViewModel$startSplitPdf$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfSplitViewModel$startSplitPdf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.nn.getCount() > 0) {
                this.this$0.nn.await();
            }
            Pair pair = (Pair) this.this$0.f7126pf.getValue();
            if (pair != null) {
                PdfSplitViewModel pdfSplitViewModel = this.this$0;
                ArrayList<ad> arrayList = new ArrayList<>();
                for (Object next : (Iterable) pair.getSecond()) {
                    if (((ad) next).de()) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                for (ad qw : arrayList) {
                    arrayList2.add(qw.qw());
                }
                pdfSplitViewModel.o(arrayList2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
