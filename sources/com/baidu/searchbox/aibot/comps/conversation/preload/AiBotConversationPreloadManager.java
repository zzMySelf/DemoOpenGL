package com.baidu.searchbox.aibot.comps.conversation.preload;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.aibot.AIBotPreloadParams;
import com.baidu.searchbox.aibot.AiBotPreloadScene;
import com.baidu.searchbox.aibot.comps.conversation.track.AIBotComponentTracker;
import com.baidu.searchbox.aibot.config.conversation.AiBotConvConfig;
import com.baidu.searchbox.aibot.store.AIBotHostDebugStore;
import com.baidu.searchbox.aibot.utils.AISearchDebugUtils;
import com.baidu.searchbox.aibot.utils.ChannelId;
import com.baidu.searchbox.aibot.yalog.AISearchYalog;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent;
import com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost;
import com.baidu.searchbox.aisearch.comps.conversation.IConversationWebComponentProvider;
import com.baidu.searchbox.aisearch.comps.conversation.track.ComponentTrackStats;
import com.baidu.searchbox.aisearch.comps.conversation.track.DestroyCause;
import com.baidu.searchbox.aisearch.comps.conversation.track.IComponentTracker;
import com.baidu.searchbox.aisearch.comps.web.SimpleWebComponent;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.webkit.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001BB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0017J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0017J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00020$H\u0003J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0003J\u0018\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0003J\b\u00100\u001a\u00020'H\u0007J\b\u00101\u001a\u000202H\u0003J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020'H\u0003J\u0018\u00106\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00020$H\u0003J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\"H\u0017J\b\u00109\u001a\u00020'H\u0003J\b\u0010:\u001a\u00020'H\u0007J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0007J\u0012\u0010>\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u00020$H\u0003R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00048\u0016XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0006R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/aibot/comps/conversation/preload/AiBotConversationPreloadManager;", "Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationWebComponentProvider;", "()V", "enablePreload", "", "getEnablePreload", "()Z", "enablePreload$delegate", "Lkotlin/Lazy;", "enableReuse", "getEnableReuse$annotations", "getEnableReuse", "filters", "", "Lcom/baidu/searchbox/aibot/comps/conversation/preload/IPreloadRequestFilter;", "getFilters", "()Ljava/util/List;", "filters$delegate", "hasAliveWebComponent", "getHasAliveWebComponent", "preloadHost", "Lcom/baidu/searchbox/aibot/comps/conversation/preload/AiBotConversationWebCompPreloadHost;", "getPreloadHost", "()Lcom/baidu/searchbox/aibot/comps/conversation/preload/AiBotConversationWebCompPreloadHost;", "preloadHost$delegate", "rescheduleOnAccountChange", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "acquireComponentTracker", "Lcom/baidu/searchbox/aisearch/comps/conversation/track/IComponentTracker;", "acquireWebComponent", "Lcom/baidu/searchbox/aisearch/comps/conversation/ConversationWebComponent;", "host", "Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationWebCompHost;", "buildPreloadFilters", "cleanupOnUseFailed", "", "instance", "createInstance", "context", "Landroid/content/Context;", "destroyCachedInstance", "cause", "Lcom/baidu/searchbox/aisearch/comps/conversation/track/DestroyCause;", "destroyInstance", "destroyNonreusableInstance", "getCurrentTime", "", "getDestroyCause", "comp", "observeAccountChange", "obtain", "recycleWebComponent", "webComponent", "registerBackForegroundEvent", "rescheduleByConsumed", "schedulePreload", "params", "Lcom/baidu/searchbox/aibot/AIBotPreloadParams;", "startCheckActivityReleased", "tryUsePreloadInstance", "usePreloadInstance", "newSuperior", "CheckActivityHostReleased", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiBotConversationPreloadManager.kt */
public final class AiBotConversationPreloadManager implements IConversationWebComponentProvider {
    public static final AiBotConversationPreloadManager INSTANCE;
    private static final Lazy enablePreload$delegate = LazyKt.lazy(AiBotConversationPreloadManager$enablePreload$2.INSTANCE);
    private static final boolean enableReuse = false;
    private static final Lazy filters$delegate = LazyKt.lazy(AiBotConversationPreloadManager$filters$2.INSTANCE);
    private static final Lazy preloadHost$delegate = LazyKt.lazy(AiBotConversationPreloadManager$preloadHost$2.INSTANCE);
    private static final IAccountStatusChangedListener rescheduleOnAccountChange = new AiBotConversationPreloadManager$$ExternalSyntheticLambda2();

    @Deprecated(message = "use enablePreload", replaceWith = @ReplaceWith(expression = "enablePreload", imports = {}))
    public static /* synthetic */ void getEnableReuse$annotations() {
    }

    private AiBotConversationPreloadManager() {
    }

    private final CoroutineScope getScope() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AiBotConversationPreloadManager aiBotConversationPreloadManager = this;
            LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "get()");
            obj = Result.m8971constructorimpl(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        CoroutineScope coroutineScope = null;
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        LifecycleCoroutineScope lifecycleScope = (LifecycleCoroutineScope) obj;
        if (lifecycleScope != null) {
            return lifecycleScope;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            AiBotConversationPreloadManager aiBotConversationPreloadManager2 = this;
            return GlobalScope.INSTANCE;
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Object r1 = Result.m8971constructorimpl(ResultKt.createFailure(th3));
            if (!Result.m8977isFailureimpl(r1)) {
                coroutineScope = r1;
            }
            return coroutineScope;
        }
    }

    static {
        Object obj;
        AiBotConversationPreloadManager $this$_init__u24lambda_u2d5 = new AiBotConversationPreloadManager();
        INSTANCE = $this$_init__u24lambda_u2d5;
        try {
            Result.Companion companion = Result.Companion;
            if (ProcessUtils.isMainProcess() && WarmTipsManager.hasConfirmDialog()) {
                UiThreadUtils.getMainHandler().postDelayed(new AiBotConversationPreloadManager$$ExternalSyntheticLambda3($this$_init__u24lambda_u2d5), 3000);
            }
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && AiBotConversationPreloadManagerKt.DEBUG) {
            Log.w("AiBotPreload", "fail to init ConversationPreloadManager, error=" + it);
        }
        CoroutineScope scope = INSTANCE.getScope();
        if (scope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass3((Continuation<? super AnonymousClass3>) null), 2, (Object) null);
        }
    }

    private final List<IPreloadRequestFilter> getFilters() {
        return (List) filters$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: rescheduleOnAccountChange$lambda-2  reason: not valid java name */
    public static final void m14837rescheduleOnAccountChange$lambda2(boolean oldStatus, boolean newStatus) {
        AISearchYalog.INSTANCE.i("AiBotPreload", "rescheduleOnAccountChange, old=" + oldStatus + ", new=" + newStatus);
        CoroutineScope scope = INSTANCE.getScope();
        if (scope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new AiBotConversationPreloadManager$rescheduleOnAccountChange$1$1(oldStatus, newStatus, (Continuation<? super AiBotConversationPreloadManager$rescheduleOnAccountChange$1$1>) null), 3, (Object) null);
        }
    }

    public boolean getEnableReuse() {
        return enableReuse;
    }

    private final boolean getEnablePreload() {
        return ((Boolean) enablePreload$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final AiBotConversationWebCompPreloadHost getPreloadHost() {
        return (AiBotConversationWebCompPreloadHost) preloadHost$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean getHasAliveWebComponent() {
        return getPreloadHost().getWebComp() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-4  reason: not valid java name */
    public static final void m14835lambda5$lambda4(AiBotConversationPreloadManager $this_runCatching) {
        Intrinsics.checkNotNullParameter($this_runCatching, "$this_runCatching");
        try {
            Result.Companion companion = Result.Companion;
            $this_runCatching.registerBackForegroundEvent();
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public final List<IPreloadRequestFilter> buildPreloadFilters() {
        List arrayList = new ArrayList();
        List $this$buildPreloadFilters_u24lambda_u2d7 = arrayList;
        if (!AiBotConversationPreloadManagerKt.DEBUG || AIBotHostDebugStore.INSTANCE.getPreloadSwitch() == -1) {
            $this$buildPreloadFilters_u24lambda_u2d7.add(new WarmTipsPreloadRequestFilter());
            $this$buildPreloadFilters_u24lambda_u2d7.add(new AiBotCloudControlPreloadRequestFilter());
            if (!AiBotPreloadSwitchKt.isCloudPreloadSupportLogout()) {
                $this$buildPreloadFilters_u24lambda_u2d7.add(new AIBotLoginPreloadRequestFilter());
            }
            $this$buildPreloadFilters_u24lambda_u2d7.add(new CommonPreloadRequestFilter());
            if (AiBotPreloadSwitchKt.isCloudPreloadNeedActive()) {
                $this$buildPreloadFilters_u24lambda_u2d7.add(new ActiveUsagePreloadRequestFilter(AiBotConvConfig.INSTANCE.getPreloadActivePeriod(), AiBotConvConfig.INSTANCE.getPreloadActiveUsage()));
            }
        } else {
            $this$buildPreloadFilters_u24lambda_u2d7.add(new WarmTipsPreloadRequestFilter());
            $this$buildPreloadFilters_u24lambda_u2d7.add(new DebugPreloadRequestFilter());
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$3", f = "AiBotConversationPreloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$3  reason: invalid class name */
    /* compiled from: AiBotConversationPreloadManager.kt */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AiBotConversationPreloadManager.INSTANCE.observeAccountChange();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void registerBackForegroundEvent() {
        BdEventBus.Companion.getDefault().register(this, BdBoxActivityLifecycle.BackForegroundEvent.class, new AiBotConversationPreloadManager$$ExternalSyntheticLambda1());
    }

    /* access modifiers changed from: private */
    /* renamed from: registerBackForegroundEvent$lambda-10  reason: not valid java name */
    public static final void m14836registerBackForegroundEvent$lambda10(BdBoxActivityLifecycle.BackForegroundEvent it) {
        Object obj;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isForeground) {
            if (AiBotConversationPreloadManagerKt.DEBUG) {
                Log.d("AiBotPreload", "app switch to foreground");
            }
            AiBotConversationPreloadManager $this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8 = INSTANCE;
            $this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8.acquireComponentTracker().setHotStartTime($this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8.getCurrentTime());
            if (AiBotPreloadSceneConfig.INSTANCE.isHotLaunchActive()) {
                try {
                    Result.Companion companion = Result.Companion;
                    CoroutineScope scope = $this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8.getScope();
                    Job job = null;
                    if (scope != null) {
                        job = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new AiBotConversationPreloadManager$registerBackForegroundEvent$1$1$1($this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8, (Continuation<? super AiBotConversationPreloadManager$registerBackForegroundEvent$1$1$1>) null), 2, (Object) null);
                    }
                    obj = Result.m8971constructorimpl(job);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m8974exceptionOrNullimpl(obj) != null && AiBotConversationPreloadManagerKt.DEBUG) {
                    Log.w("AiBotPreload", "fail to schedule preload on foreground");
                }
            } else if (AiBotConversationPreloadManagerKt.DEBUG) {
                Log.d("AiBotPreload", AiBotPreloadScene.HOT_LAUNCH + " not in preload scene, skip");
            }
        } else if (AiBotConversationPreloadManagerKt.DEBUG) {
            Log.d("AiBotPreload", "app switch to background");
        }
    }

    /* access modifiers changed from: private */
    public final void observeAccountChange() {
        Object service = ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        BoxAccountManager $this$observeAccountChange_u24lambda_u2d11 = service instanceof BoxAccountManager ? (BoxAccountManager) service : null;
        if ($this$observeAccountChange_u24lambda_u2d11 != null) {
            $this$observeAccountChange_u24lambda_u2d11.addLoginStatusChangedListener(rescheduleOnAccountChange);
        }
    }

    public final void rescheduleByConsumed() {
        CoroutineScope scope;
        if (AiBotConversationPreloadManagerKt.DEBUG) {
            Log.d("AiBotPreload", "reschedule by Consumed");
        }
        if (AiBotPreloadSceneConfig.INSTANCE.isByConsumedActive() && (scope = getScope()) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new AiBotConversationPreloadManager$rescheduleByConsumed$1((Continuation<? super AiBotConversationPreloadManager$rescheduleByConsumed$1>) null), 2, (Object) null);
        }
    }

    public final void schedulePreload(AIBotPreloadParams params) {
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Result.Companion companion = Result.Companion;
            AiBotConversationPreloadManager $this$schedulePreload_u24lambda_u2d14 = this;
            AiBotPreloadScene scene = params.getPreloadScene();
            if (AiBotPreloadSceneConfig.INSTANCE.isSceneActive(scene)) {
                Iterable $this$any$iv = $this$schedulePreload_u24lambda_u2d14.getFilters();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((IPreloadRequestFilter) it.next()).filterRequest()) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z) {
                    String $this$schedulePreload_u24lambda_u2d14_u24lambda_u2d13 = Uri.parse(AiBotConvConfig.INSTANCE.getPreloadAiBotBaseUrl()).toString();
                    if (AiBotConversationPreloadManagerKt.DEBUG) {
                        AISearchDebugUtils aISearchDebugUtils = AISearchDebugUtils.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue($this$schedulePreload_u24lambda_u2d14_u24lambda_u2d13, "this");
                        str = aISearchDebugUtils.replaceHost($this$schedulePreload_u24lambda_u2d14_u24lambda_u2d13, AIBotHostDebugStore.INSTANCE.getDebugWebUrl());
                    } else {
                        Intrinsics.checkNotNullExpressionValue($this$schedulePreload_u24lambda_u2d14_u24lambda_u2d13, "{\n                    this\n                }");
                        str = $this$schedulePreload_u24lambda_u2d14_u24lambda_u2d13;
                    }
                    String preloadUrl = str;
                    CoroutineScope scope = $this$schedulePreload_u24lambda_u2d14.getScope();
                    Job job = null;
                    if (scope != null) {
                        job = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getMain(), (CoroutineStart) null, new AiBotConversationPreloadManager$schedulePreload$1$2($this$schedulePreload_u24lambda_u2d14, scene, preloadUrl, (Continuation<? super AiBotConversationPreloadManager$schedulePreload$1$2>) null), 2, (Object) null);
                    }
                    obj = Result.m8971constructorimpl(job);
                    Throwable it2 = Result.m8974exceptionOrNullimpl(obj);
                    if (it2 != null) {
                        AISearchYalog.INSTANCE.w("AiBotPreload", "schedulePreload fail, error=" + it2);
                    }
                }
            } else if (AiBotConversationPreloadManagerKt.DEBUG) {
                Log.i("AiBotPreload", params.getPreloadScene() + " not active, won't schedule preload");
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public final long getCurrentTime() {
        return IAISearchSpeedStat.Companion.getImpl().getCurrentTime();
    }

    public ConversationWebComponent acquireWebComponent(IConversationWebCompHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return obtain(host.getHostContext(), host);
    }

    public void recycleWebComponent(ConversationWebComponent webComponent) {
        Intrinsics.checkNotNullParameter(webComponent, "webComponent");
        destroyInstance(webComponent);
    }

    public IComponentTracker acquireComponentTracker() {
        return AIBotComponentTracker.INSTANCE;
    }

    private final ConversationWebComponent obtain(Context context, IConversationWebCompHost host) {
        ConversationWebComponent component;
        boolean isPreloadHost = host instanceof AiBotConversationWebCompPreloadHost;
        ConversationWebComponent reused = (!getEnablePreload() || isPreloadHost) ? null : tryUsePreloadInstance(host);
        if (reused == null) {
            AiBotConversationPreloadManager $this$obtain_u24lambda_u2d16 = this;
            $this$obtain_u24lambda_u2d16.cleanupOnUseFailed($this$obtain_u24lambda_u2d16.getPreloadHost().getWebComp());
            component = $this$obtain_u24lambda_u2d16.createInstance(context, host);
        } else {
            component = reused;
        }
        if (!isPreloadHost) {
            component.setHasBeenUsed(true);
        }
        return component;
    }

    private final ConversationWebComponent tryUsePreloadInstance(IConversationWebCompHost host) {
        Object obj;
        ConversationWebComponent instance = getPreloadHost().getWebComp();
        ConversationWebComponent conversationWebComponent = null;
        if (instance == null || !AiBotConversationPreloadManagerKt.canReuseCrossingActivity(instance)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(usePreloadInstance(host));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null) {
            AISearchYalog.INSTANCE.w("AiBotPreload", "reuse instance fail, error=" + it);
        }
        if (!Result.m8977isFailureimpl(obj)) {
            conversationWebComponent = obj;
        }
        return conversationWebComponent;
    }

    private final void cleanupOnUseFailed(ConversationWebComponent instance) {
        Object obj;
        if (instance != null) {
            ConversationWebComponent it = instance;
            if (AiBotConversationPreloadManagerKt.DEBUG) {
                Log.i("AiBotPreload", "instance can't be reuse, will destroy, toggle=" + INSTANCE.getEnableReuse() + ", instance = " + it);
            }
            AiBotConversationPreloadManager $this$cleanupOnUseFailed_u24lambda_u2d21_u24lambda_u2d19 = INSTANCE;
            DestroyCause destroyCause = $this$cleanupOnUseFailed_u24lambda_u2d21_u24lambda_u2d19.getDestroyCause(it);
            try {
                Result.Companion companion = Result.Companion;
                $this$cleanupOnUseFailed_u24lambda_u2d21_u24lambda_u2d19.destroyInstance(it, destroyCause);
                obj = Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it2 = Result.m8974exceptionOrNullimpl(obj);
            if (it2 != null) {
                AISearchYalog.INSTANCE.w("AiBotPreload", "destroy instance fail, error=" + it2);
            }
            Result.m8970boximpl(obj);
        }
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent usePreloadInstance(com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost r7) {
        /*
            r6 = this;
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationWebCompPreloadHost r0 = r6.getPreloadHost()
            com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent r0 = r0.getWebComp()
            r1 = 0
            if (r0 == 0) goto L_0x0091
            r2 = r0
            r3 = 0
            boolean r4 = com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManagerKt.DEBUG
            if (r4 == 0) goto L_0x002c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "reuse instance "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "AiBotPreload"
            android.util.Log.i(r5, r4)
        L_0x002c:
            android.view.View r4 = r2.getView()
            android.view.ViewParent r4 = r4.getParent()
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x003b
            r1 = r4
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L_0x003b:
            if (r1 == 0) goto L_0x0044
            android.view.View r4 = r2.getView()
            r1.removeView(r4)
        L_0x0044:
            com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost r1 = r2.getCurrentHost()
            boolean r1 = r1 instanceof com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationWebCompPreloadHost
            if (r1 == 0) goto L_0x006c
            r1 = r2
            com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent r1 = (com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent) r1
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.RESUMED
            com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt.setMaxLifecycle(r1, r4)
            r1 = r2
            com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent r1 = (com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent) r1
            androidx.lifecycle.LifecycleOwner r4 = r2.getLifecycleOwner()
            androidx.lifecycle.Lifecycle r4 = r4.getLifecycle()
            androidx.lifecycle.Lifecycle$State r4 = r4.getCurrentState()
            java.lang.String r5 = "instance.lifecycleOwner.lifecycle.currentState"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt.setMinLifecycle(r1, r4)
        L_0x006c:
            r2.changeHost(r7)
            r1 = r2
            com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent r1 = (com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent) r1
            androidx.lifecycle.LifecycleOwner r4 = r7.getLifecycleOwner()
            java.lang.String r5 = "newSuperior.lifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt.changeSuperior(r1, r4)
            r1 = 1
            r2.setReused(r1)
            android.os.MessageQueue r1 = android.os.Looper.myQueue()
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$$ExternalSyntheticLambda0 r4 = new com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$$ExternalSyntheticLambda0
            r4.<init>()
            r1.addIdleHandler(r4)
            goto L_0x0092
        L_0x0091:
            r0 = r1
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager.usePreloadInstance(com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost):com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent");
    }

    /* access modifiers changed from: private */
    /* renamed from: usePreloadInstance$lambda-23$lambda-22  reason: not valid java name */
    public static final boolean m14838usePreloadInstance$lambda23$lambda22() {
        INSTANCE.rescheduleByConsumed();
        return false;
    }

    private final ConversationWebComponent createInstance(Context context, IConversationWebCompHost host) {
        if (AiBotConversationPreloadManagerKt.DEBUG) {
            Log.i("AiBotPreload", "creating new instance");
        }
        LifecycleOwner lifecycleOwner = host.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "host.lifecycleOwner");
        LifecycleOwner lifecycleOwner2 = LifecycleKt.createCrossing(lifecycleOwner, Lifecycle.State.RESUMED);
        NgWebView webView = SimpleWebComponent.Companion.createWebView(context);
        WebView $this$createInstance_u24lambda_u2d25_u24lambda_u2d24 = webView.getCurrentWebView();
        if ($this$createInstance_u24lambda_u2d25_u24lambda_u2d24 != null) {
            Intrinsics.checkNotNullExpressionValue($this$createInstance_u24lambda_u2d25_u24lambda_u2d24, "currentWebView");
            $this$createInstance_u24lambda_u2d25_u24lambda_u2d24.setBackgroundColor(0);
            Drawable background = $this$createInstance_u24lambda_u2d25_u24lambda_u2d24.getBackground();
            if (background != null) {
                background.setAlpha(0);
            }
        }
        ConversationWebComponent conversationWebComponent = new ConversationWebComponent(lifecycleOwner2, webView, this, ChannelId.INSTANCE.genNext());
        ConversationWebComponent $this$createInstance_u24lambda_u2d26 = conversationWebComponent;
        if ($this$createInstance_u24lambda_u2d26.getEnableReuse() && (webView.getContext() instanceof MutableContextWrapper)) {
            LifecycleKt.setMinLifecycle($this$createInstance_u24lambda_u2d26, Lifecycle.State.CREATED);
        }
        $this$createInstance_u24lambda_u2d26.changeHost(host);
        return conversationWebComponent;
    }

    private final void destroyInstance(ConversationWebComponent instance, DestroyCause cause) {
        ConversationWebComponent $this$destroyInstance_u24lambda_u2d27 = instance;
        LifecycleKt.setMinLifecycle($this$destroyInstance_u24lambda_u2d27, Lifecycle.State.DESTROYED);
        LifecycleKt.setMaxLifecycle($this$destroyInstance_u24lambda_u2d27, Lifecycle.State.DESTROYED);
        AiBotConversationPreloadManager aiBotConversationPreloadManager = INSTANCE;
        aiBotConversationPreloadManager.acquireComponentTracker().onDestroy(instance, aiBotConversationPreloadManager.getCurrentTime(), cause);
        ComponentTrackStats.INSTANCE.uploadPreloadStatistic(instance, cause);
    }

    public final void destroyNonreusableInstance() {
        ConversationWebComponent $this$destroyNonreusableInstance_u24lambda_u2d28 = getPreloadHost().getWebComp();
        if ($this$destroyNonreusableInstance_u24lambda_u2d28 != null) {
            IConversationWebCompHost host = $this$destroyNonreusableInstance_u24lambda_u2d28.getCurrentHost();
            if (!AiBotConversationPreloadManagerKt.canReuseCrossingActivity($this$destroyNonreusableInstance_u24lambda_u2d28)) {
                AiBotConversationPreloadManager aiBotConversationPreloadManager = INSTANCE;
                if (Intrinsics.areEqual((Object) host, (Object) aiBotConversationPreloadManager.getPreloadHost())) {
                    DestroyCause destroyCause = aiBotConversationPreloadManager.getDestroyCause($this$destroyNonreusableInstance_u24lambda_u2d28);
                    AISearchYalog.INSTANCE.i("AiBotPreload", "host is " + host + ", and " + destroyCause + ", nonreusable, destroy");
                    host.onWebCompDetached($this$destroyNonreusableInstance_u24lambda_u2d28);
                    aiBotConversationPreloadManager.destroyInstance($this$destroyNonreusableInstance_u24lambda_u2d28, destroyCause);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void destroyCachedInstance(com.baidu.searchbox.aisearch.comps.conversation.track.DestroyCause r10) {
        /*
            r9 = this;
            java.lang.String r0 = "AiBotPreload"
            java.lang.String r1 = "cause"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationWebCompPreloadHost r1 = r9.getPreloadHost()
            com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent r1 = r1.getWebComp()
            if (r1 != 0) goto L_0x0012
            return
        L_0x0012:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x009e }
            r2 = r9
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager r2 = (com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager) r2     // Catch:{ all -> 0x009e }
            r3 = 0
            com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost r4 = r1.getCurrentHost()     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x003b
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationWebCompPreloadHost r5 = r2.getPreloadHost()     // Catch:{ all -> 0x009e }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x009e }
            if (r5 != 0) goto L_0x003b
            androidx.lifecycle.LifecycleOwner r5 = r4.getLifecycleOwner()     // Catch:{ all -> 0x009e }
            androidx.lifecycle.Lifecycle r5 = r5.getLifecycle()     // Catch:{ all -> 0x009e }
            androidx.lifecycle.Lifecycle$State r5 = r5.getCurrentState()     // Catch:{ all -> 0x009e }
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ all -> 0x009e }
            if (r5 != r6) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r5 = 0
            goto L_0x003c
        L_0x003b:
            r5 = 1
        L_0x003c:
            if (r5 == 0) goto L_0x007e
            com.baidu.searchbox.aibot.yalog.AISearchYalog r6 = com.baidu.searchbox.aibot.yalog.AISearchYalog.INSTANCE     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r7.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r8 = "host is "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r8 = ", and "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch:{ all -> 0x009e }
            java.lang.String r8 = ", destroy"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x009e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009e }
            r6.i(r0, r7)     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x006d
            r4.onWebCompDetached(r1)     // Catch:{ all -> 0x009e }
        L_0x006d:
            r2.destroyInstance(r1, r10)     // Catch:{ all -> 0x009e }
            com.baidu.searchbox.aisearch.statistic.AISearchStats r6 = r1.getAiSearchStats()     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x007c
            r6.dispose()     // Catch:{ all -> 0x009e }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009e }
            goto L_0x0098
        L_0x007c:
            r6 = 0
            goto L_0x0098
        L_0x007e:
            com.baidu.searchbox.aibot.yalog.AISearchYalog r6 = com.baidu.searchbox.aibot.yalog.AISearchYalog.INSTANCE     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r7.<init>()     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch:{ all -> 0x009e }
            java.lang.String r8 = " but host is active, not destroy"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x009e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009e }
            r6.i(r0, r7)     // Catch:{ all -> 0x009e }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009e }
        L_0x0098:
            java.lang.Object r2 = kotlin.Result.m8971constructorimpl(r6)     // Catch:{ all -> 0x009e }
            goto L_0x00a9
        L_0x009e:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m8971constructorimpl(r2)
        L_0x00a9:
            java.lang.Throwable r2 = kotlin.Result.m8974exceptionOrNullimpl(r2)
            if (r2 == 0) goto L_0x00d4
            r3 = 0
            com.baidu.searchbox.aibot.yalog.AISearchYalog r4 = com.baidu.searchbox.aibot.yalog.AISearchYalog.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "destroy on "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r6 = " fail, error="
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.w(r0, r5)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager.destroyCachedInstance(com.baidu.searchbox.aisearch.comps.conversation.track.DestroyCause):void");
    }

    private final void destroyInstance(ConversationWebComponent instance) {
        if (AiBotConversationPreloadManagerKt.DEBUG) {
            startCheckActivityReleased(instance);
        }
        ConversationWebComponent $this$destroyInstance_u24lambda_u2d31 = instance;
        LifecycleKt.setMinLifecycle($this$destroyInstance_u24lambda_u2d31, Lifecycle.State.DESTROYED);
        LifecycleKt.setMaxLifecycle($this$destroyInstance_u24lambda_u2d31, Lifecycle.State.DESTROYED);
        AiBotConversationPreloadManager aiBotConversationPreloadManager = INSTANCE;
        aiBotConversationPreloadManager.acquireComponentTracker().onDestroy(instance, aiBotConversationPreloadManager.getCurrentTime(), DestroyCause.UNMANAGED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r7.getCurrentHost();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void startCheckActivityReleased(com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000e
            com.baidu.searchbox.aisearch.comps.conversation.IConversationWebCompHost r1 = r7.getCurrentHost()
            if (r1 == 0) goto L_0x000e
            android.content.Context r1 = r1.getHostContext()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0016
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
        L_0x0016:
            if (r0 != 0) goto L_0x0026
            boolean r1 = com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManagerKt.DEBUG
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "AiBotPreload"
            java.lang.String r2 = "activity already null before checking..."
            android.util.Log.w(r1, r2)
        L_0x0025:
            return
        L_0x0026:
            com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$CheckActivityHostReleased r1 = new com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager$CheckActivityHostReleased
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r0)
            java.lang.String r3 = r0.toString()
            r1.<init>(r2, r3)
            android.os.Handler r2 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r4 = 5000(0x1388, double:2.4703E-320)
            r2.postDelayed(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager.startCheckActivityReleased(com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent):void");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/aibot/comps/conversation/preload/AiBotConversationPreloadManager$CheckActivityHostReleased;", "Ljava/lang/Runnable;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "identifier", "", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "run", "", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiBotConversationPreloadManager.kt */
    private static final class CheckActivityHostReleased implements Runnable {
        private final WeakReference<Context> activityRef;
        private final String identifier;

        public CheckActivityHostReleased(WeakReference<Context> activityRef2, String identifier2) {
            Intrinsics.checkNotNullParameter(activityRef2, "activityRef");
            Intrinsics.checkNotNullParameter(identifier2, "identifier");
            this.activityRef = activityRef2;
            this.identifier = identifier2;
        }

        public void run() {
            if (this.activityRef.get() != null) {
                if (AiBotConversationPreloadManagerKt.DEBUG) {
                    Log.w("AiBotPreload", "activity is still hold, instance=" + this.identifier);
                }
                UiThreadUtils.getMainHandler().removeCallbacks(this);
                UiThreadUtils.getMainHandler().postDelayed(this, 5000);
            } else if (AiBotConversationPreloadManagerKt.DEBUG) {
                Log.i("AiBotPreload", "activity released, instance=" + this.identifier);
            }
        }
    }

    private final DestroyCause getDestroyCause(ConversationWebComponent comp) {
        ConversationWebComponent $this$getDestroyCause_u24lambda_u2d32 = comp;
        if ($this$getDestroyCause_u24lambda_u2d32.getHasFatalError()) {
            return DestroyCause.RENDERER_GONE;
        }
        if ($this$getDestroyCause_u24lambda_u2d32.getShowingError()) {
            return DestroyCause.LOAD_FAIL;
        }
        if ($this$getDestroyCause_u24lambda_u2d32.getShowingLoading()) {
            return DestroyCause.LOADING;
        }
        if ($this$getDestroyCause_u24lambda_u2d32.getAccountChanged()) {
            return DestroyCause.ACCOUNT_CHANGE;
        }
        return DestroyCause.LOAD_FAIL;
    }
}
