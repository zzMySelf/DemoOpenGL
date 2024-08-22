package com.tera.scan.model;

import android.content.Context;
import com.tera.scan.model.callback.IImageCropResult;
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
@DebugMetadata(c = "com.tera.scan.model.ImageCropPredictor$imageCrop$1", f = "ImageCropPredictor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageCropPredictor$imageCrop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ IImageCropResult $callback;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CropInfo $cropInfoBean;
    public int label;
    public final /* synthetic */ ImageCropPredictor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCropPredictor$imageCrop$1(ImageCropPredictor imageCropPredictor, CropInfo cropInfo, IImageCropResult iImageCropResult, Context context, Continuation<? super ImageCropPredictor$imageCrop$1> continuation) {
        super(2, continuation);
        this.this$0 = imageCropPredictor;
        this.$cropInfoBean = cropInfo;
        this.$callback = iImageCropResult;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageCropPredictor$imageCrop$1(this.this$0, this.$cropInfoBean, this.$callback, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageCropPredictor$imageCrop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object o2 = this.this$0.f7029uk;
            ImageCropPredictor imageCropPredictor = this.this$0;
            CropInfo cropInfo = this.$cropInfoBean;
            IImageCropResult iImageCropResult = this.$callback;
            Context context = this.$context;
            synchronized (o2) {
                imageCropPredictor.xxx(cropInfo, iImageCropResult, context);
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
