package com.tera.scan.model;

import android.content.Context;
import android.os.Handler;
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
@DebugMetadata(c = "com.tera.scan.model.ImagePredictor$predictor$3", f = "ImagePredictor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImagePredictor$predictor$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ImagePredictorCallback $callback;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Handler $handler;
    public final /* synthetic */ ArrayList<String> $unPredictorList;
    public int label;
    public final /* synthetic */ ImagePredictor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImagePredictor$predictor$3(ImagePredictor imagePredictor, Context context, ArrayList<String> arrayList, Handler handler, ImagePredictorCallback imagePredictorCallback, Continuation<? super ImagePredictor$predictor$3> continuation) {
        super(2, continuation);
        this.this$0 = imagePredictor;
        this.$context = context;
        this.$unPredictorList = arrayList;
        this.$handler = handler;
        this.$callback = imagePredictorCallback;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImagePredictor$predictor$3(this.this$0, this.$context, this.$unPredictorList, this.$handler, this.$callback, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImagePredictor$predictor$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object o2 = this.this$0.f7039i;
            ImagePredictor imagePredictor = this.this$0;
            Context context = this.$context;
            ArrayList<String> arrayList = this.$unPredictorList;
            Handler handler = this.$handler;
            ImagePredictorCallback imagePredictorCallback = this.$callback;
            synchronized (o2) {
                imagePredictor.xxx(context, arrayList, handler, imagePredictorCallback);
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
