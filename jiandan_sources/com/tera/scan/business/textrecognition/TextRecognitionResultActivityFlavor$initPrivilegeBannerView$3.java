package com.tera.scan.business.textrecognition;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import fe.mmm.qw.rg.de.aaa.ad;
import i.qw.Cif;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivityFlavor$initPrivilegeBannerView$3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ TextRecognitionResultActivity $this_initPrivilegeBannerView;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.tera.scan.business.textrecognition.TextRecognitionResultActivityFlavor$initPrivilegeBannerView$3$1", f = "TextRecognitionResultActivity.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tera.scan.business.textrecognition.TextRecognitionResultActivityFlavor$initPrivilegeBannerView$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(textRecognitionResultActivity, textRecognitionResultActivity2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                TextRecognitionResultActivity textRecognitionResultActivity = textRecognitionResultActivity;
                this.label = 1;
                obj = TextRecognitionResultActivityFlavor.o(textRecognitionResultActivity, this);
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
            textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().initPrivilegeBannerViewVisibility();
            textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().queryPrivilegeFreeCount();
            if (TextRecognitionResultActivityFlavor.i(textRecognitionResultActivity2)) {
                textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().closePrivilegeBannerView();
                return Unit.INSTANCE;
            }
            final TextRecognitionResultActivity textRecognitionResultActivity2 = textRecognitionResultActivity2;
            TextRecognitionResultActivityFlavor.when(textRecognitionResultActivity2, "text_guide_btn", new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().closePrivilegeBannerView();
                        textRecognitionResultActivity2.getTextRecognitionResultViewModel$business_text_recongition_aiscanConfigRelease().syncUserPrivilege();
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivityFlavor$initPrivilegeBannerView$3(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.$this_initPrivilegeBannerView = textRecognitionResultActivity;
    }

    public final void invoke() {
        ad.ad("UpgradeScan", "Trial_Guide", (String) null, (String) null, (Map) null, 28, (Object) null);
        final TextRecognitionResultActivity textRecognitionResultActivity = this.$this_initPrivilegeBannerView;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(textRecognitionResultActivity);
        final TextRecognitionResultActivity textRecognitionResultActivity2 = this.$this_initPrivilegeBannerView;
        Job unused = Cif.fe(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
