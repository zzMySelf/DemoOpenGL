package com.tera.scan.model;

import android.content.Context;
import com.tera.scan.model.callback.IImageEnhanceResult;
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
@DebugMetadata(c = "com.tera.scan.model.ImageEnhance$imageEnhanceFilter$job$1", f = "ImageEnhance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageEnhance$imageEnhanceFilter$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ IImageEnhanceResult $callback;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $enalbeDewarp;
    public final /* synthetic */ String $filePath;
    public final /* synthetic */ boolean $postProcess;
    public final /* synthetic */ String $resultPath;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ImageEnhance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageEnhance$imageEnhanceFilter$job$1(ImageEnhance imageEnhance, String str, IImageEnhanceResult iImageEnhanceResult, Context context, boolean z, boolean z2, String str2, Continuation<? super ImageEnhance$imageEnhanceFilter$job$1> continuation) {
        super(2, continuation);
        this.this$0 = imageEnhance;
        this.$filePath = str;
        this.$callback = iImageEnhanceResult;
        this.$context = context;
        this.$postProcess = z;
        this.$enalbeDewarp = z2;
        this.$resultPath = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ImageEnhance$imageEnhanceFilter$job$1 imageEnhance$imageEnhanceFilter$job$1 = new ImageEnhance$imageEnhanceFilter$job$1(this.this$0, this.$filePath, this.$callback, this.$context, this.$postProcess, this.$enalbeDewarp, this.$resultPath, continuation);
        imageEnhance$imageEnhanceFilter$job$1.L$0 = obj;
        return imageEnhance$imageEnhanceFilter$job$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageEnhance$imageEnhanceFilter$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object de2 = this.this$0.f7035rg;
            ImageEnhance imageEnhance = this.this$0;
            String str = this.$filePath;
            IImageEnhanceResult iImageEnhanceResult = this.$callback;
            Context context = this.$context;
            boolean z = this.$postProcess;
            boolean z2 = this.$enalbeDewarp;
            String str2 = this.$resultPath;
            synchronized (de2) {
                coroutineScope.getCoroutineContext();
                imageEnhance.o(coroutineScope, str, iImageEnhanceResult, context, z, z2, str2);
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
