package com.baidu.searchbox.feed.template;

import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.skin.NightModeHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.feed.template.FeedPrefixTagView$initAfxView$1", f = "FeedPrefixTagView.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FeedPrefixTagView.kt */
final class FeedPrefixTagView$initAfxView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlphaVideo $afxView;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ FeedPrefixTagView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedPrefixTagView$initAfxView$1(FeedPrefixTagView feedPrefixTagView, String str, AlphaVideo alphaVideo, Continuation<? super FeedPrefixTagView$initAfxView$1> continuation) {
        super(2, continuation);
        this.this$0 = feedPrefixTagView;
        this.$url = str;
        this.$afxView = alphaVideo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedPrefixTagView$initAfxView$1(this.this$0, this.$url, this.$afxView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedPrefixTagView$initAfxView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FeedPrefixTagView$initAfxView$1 feedPrefixTagView$initAfxView$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                feedPrefixTagView$initAfxView$1 = this;
                feedPrefixTagView$initAfxView$1.label = 1;
                Object access$getAfxFile = feedPrefixTagView$initAfxView$1.this$0.getAfxFile(feedPrefixTagView$initAfxView$1.$url, feedPrefixTagView$initAfxView$1);
                if (access$getAfxFile != coroutine_suspended) {
                    Object obj = $result;
                    $result = access$getAfxFile;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                feedPrefixTagView$initAfxView$1 = this;
                Object obj2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        File file = (File) $result;
        if (file != null && file.exists()) {
            AlphaVideo $this$invokeSuspend_u24lambda_u2d1 = feedPrefixTagView$initAfxView$1.$afxView;
            $this$invokeSuspend_u24lambda_u2d1.setVisibility(0);
            $this$invokeSuspend_u24lambda_u2d1.setSourcePath(file.getAbsolutePath());
            $this$invokeSuspend_u24lambda_u2d1.setDarkFilter(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.0f);
            $this$invokeSuspend_u24lambda_u2d1.setLooping(true);
            $this$invokeSuspend_u24lambda_u2d1.setOnVideoErrorListener(new FeedPrefixTagView$initAfxView$1$$ExternalSyntheticLambda0());
            $this$invokeSuspend_u24lambda_u2d1.play();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m19476invokeSuspend$lambda1$lambda0(ErrorInfo errorInfo) {
        return true;
    }
}
