package com.baidu.searchbox.aibot.comps.conversation.preload;

import android.net.Uri;
import com.baidu.searchbox.aibot.AiBotPreloadScene;
import com.baidu.searchbox.aibot.yalog.AISearchYalog;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$schedulePreload$1$2", f = "AiBotConversationPreloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AiBotConversationPreloadManager.kt */
final class AiBotConversationPreloadManager$schedulePreload$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $preloadUrl;
    final /* synthetic */ AiBotPreloadScene $scene;
    final /* synthetic */ AiBotConversationPreloadManager $this_runCatching;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiBotConversationPreloadManager$schedulePreload$1$2(AiBotConversationPreloadManager aiBotConversationPreloadManager, AiBotPreloadScene aiBotPreloadScene, String str, Continuation<? super AiBotConversationPreloadManager$schedulePreload$1$2> continuation) {
        super(2, continuation);
        this.$this_runCatching = aiBotConversationPreloadManager;
        this.$scene = aiBotPreloadScene;
        this.$preloadUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AiBotConversationPreloadManager$schedulePreload$1$2(this.$this_runCatching, this.$scene, this.$preloadUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AiBotConversationPreloadManager$schedulePreload$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Uri.Builder buildUpon;
        Uri.Builder appendQueryParameter;
        Uri build;
        String uri;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Object obj2 = obj;
                this.$this_runCatching.destroyNonreusableInstance();
                if (this.$this_runCatching.getHasAliveWebComponent()) {
                    AISearchYalog.INSTANCE.d("AiBotPreload", "skip preload, already has alive instance");
                    return Unit.INSTANCE;
                }
                long startTime = this.$this_runCatching.getCurrentTime();
                AiBotConversationPreloadManager aiBotConversationPreloadManager = this.$this_runCatching;
                ConversationWebComponent $this$invokeSuspend_u24lambda_u2d3 = aiBotConversationPreloadManager.acquireWebComponent(aiBotConversationPreloadManager.getPreloadHost());
                boolean z = false;
                String str = null;
                if ((!$this$invokeSuspend_u24lambda_u2d3.isPreload() ? 1 : null) == null) {
                    $this$invokeSuspend_u24lambda_u2d3 = null;
                }
                if ($this$invokeSuspend_u24lambda_u2d3 != null) {
                    AiBotConversationPreloadManager aiBotConversationPreloadManager2 = this.$this_runCatching;
                    AiBotPreloadScene aiBotPreloadScene = this.$scene;
                    String str2 = this.$preloadUrl;
                    $this$invokeSuspend_u24lambda_u2d3.setPreload(true);
                    aiBotConversationPreloadManager2.acquireComponentTracker().onPreloadStart($this$invokeSuspend_u24lambda_u2d3, startTime, aiBotPreloadScene.getSceneId(), (String) null);
                    String it = $this$invokeSuspend_u24lambda_u2d3.getActionId();
                    if (it.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        str = it;
                    }
                    if (!(str == null || (buildUpon = Uri.parse(str2).buildUpon()) == null || (appendQueryParameter = buildUpon.appendQueryParameter("channelId", $this$invokeSuspend_u24lambda_u2d3.getActionId())) == null || (build = appendQueryParameter.build()) == null || (uri = build.toString()) == null)) {
                        str2 = uri;
                    }
                    Intrinsics.checkNotNullExpressionValue(str2, "actionId.takeIf { it.isN…             ?:preloadUrl");
                    String finalPreloadUrl = str2;
                    AISearchYalog.INSTANCE.i("AiBotPreload", "preloadUrl=" + finalPreloadUrl);
                    $this$invokeSuspend_u24lambda_u2d3.loadUrl(finalPreloadUrl);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
