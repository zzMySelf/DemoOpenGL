package com.tera.scan.business.textrecognition;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import fe.mmm.qw.j.ddd.ad;
import fe.mmm.qw.j.ddd.qw;
import fe.mmm.qw.rg.de.i;
import fe.mmm.qw.rg.de.yj;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.tera.scan.business.textrecognition.TextRecognitionActivity$setPreview$1$1", f = "TextRecognitionActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TextRecognitionActivity$setPreview$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $path;
    public final /* synthetic */ String $previewPath;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ TextRecognitionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionActivity$setPreview$1$1(String str, Context context, String str2, TextRecognitionActivity textRecognitionActivity, Continuation<? super TextRecognitionActivity$setPreview$1$1> continuation) {
        super(2, continuation);
        this.$previewPath = str;
        this.$context = context;
        this.$path = str2;
        this.this$0 = textRecognitionActivity;
    }

    /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
    public static final void m734invokeSuspend$lambda1(TextRecognitionActivity textRecognitionActivity, Uri uri) {
        textRecognitionActivity.getPreviewImage().setImageURI(uri);
    }

    /* renamed from: invokeSuspend$lambda-3$lambda-2  reason: not valid java name */
    public static final void m735invokeSuspend$lambda3$lambda2(TextRecognitionActivity textRecognitionActivity, Bitmap bitmap) {
        textRecognitionActivity.getPreviewImage().setImageBitmap(bitmap);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextRecognitionActivity$setPreview$1$1 textRecognitionActivity$setPreview$1$1 = new TextRecognitionActivity$setPreview$1$1(this.$previewPath, this.$context, this.$path, this.this$0, continuation);
        textRecognitionActivity$setPreview$1$1.L$0 = obj;
        return textRecognitionActivity$setPreview$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextRecognitionActivity$setPreview$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Context context = this.$context;
            String str = this.$path;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m1155constructorimpl(qw.ad(context, str));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj2)) {
                obj2 = null;
            }
            Uri uri = (Uri) obj2;
            if (uri != null) {
                new Handler(Looper.getMainLooper()).post(new yj(this.this$0, uri));
                return Unit.INSTANCE;
            }
            Bitmap fe2 = ad.fe(this.$previewPath, 1080);
            if (fe2 != null) {
                new Handler(Looper.getMainLooper()).post(new i(this.this$0, fe2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
