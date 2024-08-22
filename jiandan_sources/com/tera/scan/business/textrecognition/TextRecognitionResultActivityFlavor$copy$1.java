package com.tera.scan.business.textrecognition;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.business.textrecognition.TextRecognitionResultActivityFlavor$copy$1", f = "TextRecognitionResultActivity.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class TextRecognitionResultActivityFlavor$copy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LifecycleOwner $lifecycleOwner;
    public final /* synthetic */ String $text;
    public final /* synthetic */ TextRecognitionResultActivity $this_copy;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivityFlavor$copy$1(LifecycleOwner lifecycleOwner, TextRecognitionResultActivity textRecognitionResultActivity, String str, Continuation<? super TextRecognitionResultActivityFlavor$copy$1> continuation) {
        super(2, continuation);
        this.$lifecycleOwner = lifecycleOwner;
        this.$this_copy = textRecognitionResultActivity;
        this.$text = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TextRecognitionResultActivityFlavor$copy$1(this.$lifecycleOwner, this.$this_copy, this.$text, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextRecognitionResultActivityFlavor$copy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
            this.label = 1;
            obj = TextRecognitionResultActivityFlavor.o(lifecycleOwner, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        this.$this_copy.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().initPrivilegeBannerViewVisibility();
        this.$this_copy.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().queryPrivilegeFreeCount();
        if (this.$this_copy.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().privilegeEnable()) {
            TextRecognitionResultActivity textRecognitionResultActivity = this.$this_copy;
            Context context = textRecognitionResultActivity.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextRecognitionResultActivityFlavor.th(textRecognitionResultActivity, context, this.$text);
            return Unit.INSTANCE;
        }
        final TextRecognitionResultActivity textRecognitionResultActivity2 = this.$this_copy;
        final String str = this.$text;
        TextRecognitionResultActivityFlavor.when(textRecognitionResultActivity2, "copy_text", new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().closePrivilegeBannerView();
                    textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().syncUserPrivilege();
                    TextRecognitionResultActivity textRecognitionResultActivity = textRecognitionResultActivity2;
                    Context context = textRecognitionResultActivity.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    TextRecognitionResultActivityFlavor.th(textRecognitionResultActivity, context, str);
                }
            }
        });
        return Unit.INSTANCE;
    }
}
