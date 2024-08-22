package com.tera.scan.pdfedit;

import android.content.Context;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import fe.mmm.qw.qqq.fe.ad;
import fe.mmm.qw.qqq.fe.qw;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.pdfedit.PdfEditService$createLocalPdf$1", f = "PdfEditService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdfEditService$createLocalPdf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ IPdfEditCallback $callback;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ArrayList<String> $filePaths;
    public final /* synthetic */ boolean $isA4Size;
    public final /* synthetic */ String $pdfPath;
    public final /* synthetic */ boolean $showLogo;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfEditService$createLocalPdf$1(Context context, ArrayList<String> arrayList, String str, boolean z, IPdfEditCallback iPdfEditCallback, boolean z2, Continuation<? super PdfEditService$createLocalPdf$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$filePaths = arrayList;
        this.$pdfPath = str;
        this.$showLogo = z;
        this.$callback = iPdfEditCallback;
        this.$isA4Size = z2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PdfEditService$createLocalPdf$1(this.$context, this.$filePaths, this.$pdfPath, this.$showLogo, this.$callback, this.$isA4Size, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PdfEditService$createLocalPdf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ad adVar = new ad();
            boolean z = this.$isA4Size;
            Context context = this.$context;
            boolean z2 = this.$showLogo;
            if (z) {
                adVar.uk();
            } else {
                adVar.i(context, z2);
            }
            this.$callback.ad(new qw(adVar).qw(this.$context, this.$filePaths, this.$pdfPath, this.$showLogo, this.$callback));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
