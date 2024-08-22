package com.tera.scan.pdfedit.viewmodel;

import android.content.Context;
import fe.mmm.qw.o.qw.rg.qw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1", f = "PdfWatermarkSelectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<String>>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $mLocalPath;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1(Context context, String str, Continuation<? super PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$mLocalPath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1(this.$context, this.$mLocalPath, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<String>> continuation) {
        return ((PdfWatermarkSelectViewModel$getConvertPdfToLocalImages$1$resultList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final ArrayList arrayList = new ArrayList();
            qw.qw.qw(this.$context, this.$mLocalPath, true, new Function1<List<String>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<String>) (List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable List<String> list) {
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                }
            });
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
