package com.baidu.searchbox.aisearch.comps.conversation.preload;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.aisearch.AISearchPreloadParams;
import com.baidu.searchbox.aisearch.PreloadScene;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationReuseManager;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent;
import com.baidu.searchbox.aisearch.config.conversation.ConversationConfig;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.aisearch.store.AISearchHostDebugStore;
import com.baidu.searchbox.aisearch.utils.AISearchDebugUtils;
import com.baidu.searchbox.aisearch.yalog.AISearchYalog;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.security.WarmTipsManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u0018H\u0003J\b\u0010\u001e\u001a\u00020\u0018H\u0007J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0015\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b!R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/preload/ConversationPreloadManager;", "", "()V", "filters", "", "Lcom/baidu/searchbox/aisearch/comps/conversation/preload/IPreloadRequestFilter;", "getFilters", "()Ljava/util/List;", "filters$delegate", "Lkotlin/Lazy;", "rescheduleOnAccountChange", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "webComponentProvider", "Lcom/baidu/searchbox/aisearch/comps/conversation/ConversationReuseManager;", "getWebComponentProvider", "()Lcom/baidu/searchbox/aisearch/comps/conversation/ConversationReuseManager;", "buildPreloadFilters", "getCurrentTime", "", "observeAccountChange", "", "preloadOnMainThread", "params", "Lcom/baidu/searchbox/aisearch/AISearchPreloadParams;", "preloadOnMainThread$lib_aisearch_impl_release", "registerBackForegroundEvent", "rescheduleOnLowMemory", "schedulePreload", "schedulePreloadNoFilter", "schedulePreloadNoFilter$lib_aisearch_impl_release", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationPreloadManager.kt */
public final class ConversationPreloadManager {
    public static final ConversationPreloadManager INSTANCE;
    private static final Lazy filters$delegate = LazyKt.lazy(ConversationPreloadManager$filters$2.INSTANCE);
    private static final IAccountStatusChangedListener rescheduleOnAccountChange = new ConversationPreloadManager$$ExternalSyntheticLambda1();
    private static final ConversationReuseManager webComponentProvider = ConversationReuseManager.INSTANCE;

    private ConversationPreloadManager() {
    }

    static {
        Object obj;
        ConversationPreloadManager $this$_init__u24lambda_u2d5 = new ConversationPreloadManager();
        INSTANCE = $this$_init__u24lambda_u2d5;
        try {
            Result.Companion companion = Result.Companion;
            if (ProcessUtils.isMainProcess() && WarmTipsManager.hasConfirmDialog()) {
                UiThreadUtils.getMainHandler().postDelayed(new ConversationPreloadManager$$ExternalSyntheticLambda2($this$_init__u24lambda_u2d5), 3000);
            }
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && ConversationPreloadManagerKt.DEBUG) {
            Log.w("ConversationPreload", "fail to init ConversationPreloadManager, error=" + it);
        }
        CoroutineScope scope = INSTANCE.getScope();
        if (scope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass3((Continuation<? super AnonymousClass3>) null), 2, (Object) null);
        }
    }

    public final ConversationReuseManager getWebComponentProvider() {
        return webComponentProvider;
    }

    private final CoroutineScope getScope() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ConversationPreloadManager conversationPreloadManager = this;
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
            ConversationPreloadManager conversationPreloadManager2 = this;
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

    private final List<IPreloadRequestFilter> getFilters() {
        return (List) filters$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: rescheduleOnAccountChange$lambda-2  reason: not valid java name */
    public static final void m15637rescheduleOnAccountChange$lambda2(boolean oldStatus, boolean newStatus) {
        AISearchYalog.INSTANCE.i("ConversationPreload", "rescheduleOnAccountChange, old=" + oldStatus + ", new=" + newStatus);
        CoroutineScope scope = INSTANCE.getScope();
        if (scope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new ConversationPreloadManager$rescheduleOnAccountChange$1$1(oldStatus, newStatus, (Continuation<? super ConversationPreloadManager$rescheduleOnAccountChange$1$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-4  reason: not valid java name */
    public static final void m15635lambda5$lambda4(ConversationPreloadManager $this_runCatching) {
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
        if (!ConversationPreloadManagerKt.DEBUG || AISearchHostDebugStore.INSTANCE.getPreloadSwitch() == -1) {
            $this$buildPreloadFilters_u24lambda_u2d7.add(new WarmTipsPreloadRequestFilter());
            $this$buildPreloadFilters_u24lambda_u2d7.add(new CloudControlPreloadRequestFilter());
            $this$buildPreloadFilters_u24lambda_u2d7.add(new CommonPreloadRequestFilter());
            switch (PreloadSwitchKt.getCloudPreloadSwitch()) {
                case 1:
                    $this$buildPreloadFilters_u24lambda_u2d7.add(new LoginPreloadRequestFilter());
                    break;
                case 2:
                    $this$buildPreloadFilters_u24lambda_u2d7.add(new LoginPreloadRequestFilter());
                    $this$buildPreloadFilters_u24lambda_u2d7.add(new ActiveUsagePreloadRequestFilter(ConversationConfig.INSTANCE.getPreloadActivePeriod(), ConversationConfig.INSTANCE.getPreloadActiveUsage()));
                    break;
                case 4:
                    $this$buildPreloadFilters_u24lambda_u2d7.add(new ActiveUsagePreloadRequestFilter(ConversationConfig.INSTANCE.getPreloadActivePeriod(), ConversationConfig.INSTANCE.getPreloadActiveUsage()));
                    break;
            }
        } else {
            $this$buildPreloadFilters_u24lambda_u2d7.add(new WarmTipsPreloadRequestFilter());
            $this$buildPreloadFilters_u24lambda_u2d7.add(new DebugPreloadRequestFilter());
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.baidu.searchbox.aisearch.comps.conversation.preload.ConversationPreloadManager$3", f = "ConversationPreloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.baidu.searchbox.aisearch.comps.conversation.preload.ConversationPreloadManager$3  reason: invalid class name */
    /* compiled from: ConversationPreloadManager.kt */
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
                    ConversationPreloadManager.INSTANCE.observeAccountChange();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void registerBackForegroundEvent() {
        BdEventBus.Companion.getDefault().register(this, BdBoxActivityLifecycle.BackForegroundEvent.class, new ConversationPreloadManager$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: registerBackForegroundEvent$lambda-10  reason: not valid java name */
    public static final void m15636registerBackForegroundEvent$lambda10(BdBoxActivityLifecycle.BackForegroundEvent it) {
        Object obj;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isForeground) {
            if (ConversationPreloadManagerKt.DEBUG) {
                Log.d("ConversationPreload", "app switch to foreground");
            }
            ConversationPreloadManager $this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8 = INSTANCE;
            webComponentProvider.acquireComponentTracker().setHotStartTime($this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8.getCurrentTime());
            if (PreloadSceneConfig.INSTANCE.isHotLaunchActive()) {
                try {
                    Result.Companion companion = Result.Companion;
                    CoroutineScope scope = $this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8.getScope();
                    Job job = null;
                    if (scope != null) {
                        job = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new ConversationPreloadManager$registerBackForegroundEvent$1$1$1($this$registerBackForegroundEvent_u24lambda_u2d10_u24lambda_u2d8, (Continuation<? super ConversationPreloadManager$registerBackForegroundEvent$1$1$1>) null), 2, (Object) null);
                    }
                    obj = Result.m8971constructorimpl(job);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m8974exceptionOrNullimpl(obj) != null && ConversationPreloadManagerKt.DEBUG) {
                    Log.w("ConversationPreload", "fail to schedule preload on foreground");
                }
            } else if (ConversationPreloadManagerKt.DEBUG) {
                Log.d("ConversationPreload", PreloadScene.HOT_LAUNCH + " not in preload scene, skip");
            }
        } else if (ConversationPreloadManagerKt.DEBUG) {
            Log.d("ConversationPreload", "app switch to background");
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

    public final void schedulePreload(AISearchPreloadParams params) {
        Object obj;
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Result.Companion companion = Result.Companion;
            ConversationPreloadManager $this$schedulePreload_u24lambda_u2d13 = this;
            if (PreloadSceneConfig.INSTANCE.isSceneActive(params.getPreloadScene())) {
                Iterable $this$any$iv = $this$schedulePreload_u24lambda_u2d13.getFilters();
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
                    $this$schedulePreload_u24lambda_u2d13.schedulePreloadNoFilter$lib_aisearch_impl_release(params);
                    obj = Result.m8971constructorimpl(Unit.INSTANCE);
                    Throwable it2 = Result.m8974exceptionOrNullimpl(obj);
                    if (it2 != null) {
                        AISearchYalog.INSTANCE.w("ConversationPreload", "schedulePreload fail, error=" + it2);
                    }
                }
            } else if (ConversationPreloadManagerKt.DEBUG) {
                Log.i("ConversationPreload", params.getPreloadScene() + " not active, won't schedule preload");
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final void schedulePreloadNoFilter$lib_aisearch_impl_release(AISearchPreloadParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        CoroutineScope scope = getScope();
        if (scope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getMain(), (CoroutineStart) null, new ConversationPreloadManager$schedulePreloadNoFilter$1(params, (Continuation<? super ConversationPreloadManager$schedulePreloadNoFilter$1>) null), 2, (Object) null);
        }
    }

    public final void preloadOnMainThread$lib_aisearch_impl_release(AISearchPreloadParams params) {
        Object obj;
        String preloadUrl;
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Result.Companion companion = Result.Companion;
            ConversationPreloadManager $this$preloadOnMainThread_u24lambda_u2d16 = this;
            if (ConversationPreloadManagerKt.DEBUG) {
                preloadUrl = AISearchDebugUtils.INSTANCE.replaceHost(ConversationConfig.INSTANCE.getPreloadBaseUrl(), AISearchHostDebugStore.INSTANCE.getDebugWebUrl());
            } else {
                preloadUrl = ConversationConfig.INSTANCE.getPreloadBaseUrl();
            }
            ConversationReuseManager conversationReuseManager = webComponentProvider;
            conversationReuseManager.destroyNonreusableInstance();
            if (conversationReuseManager.getHasAliveWebComponent()) {
                AISearchYalog.INSTANCE.d("ConversationPreload", "skip preload " + params.getPreloadScene() + ", already has alive instance");
                return;
            }
            long startTime = $this$preloadOnMainThread_u24lambda_u2d16.getCurrentTime();
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
            ConversationWebComponent webComp = conversationReuseManager.reuseOrCreate(appContext, conversationReuseManager.getPreloadHost());
            ConversationWebComponent $this$preloadOnMainThread_u24lambda_u2d16_u24lambda_u2d15 = webComp;
            $this$preloadOnMainThread_u24lambda_u2d16_u24lambda_u2d15.setPreload(true);
            $this$preloadOnMainThread_u24lambda_u2d16_u24lambda_u2d15.getWebComponentProvider().acquireComponentTracker().onPreloadStart($this$preloadOnMainThread_u24lambda_u2d16_u24lambda_u2d15, startTime, params.getPreloadScene().getSceneId(), params.getFrom());
            AISearchYalog.INSTANCE.i("ConversationPreload", params.getPreloadScene() + "  preloadUrl=" + preloadUrl);
            webComp.loadUrl(preloadUrl);
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
            Throwable it = Result.m8974exceptionOrNullimpl(obj);
            if (it != null) {
                AISearchYalog.INSTANCE.w("ConversationPreload", "schedulePreload " + params.getPreloadScene() + " fail, error=" + it);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final void rescheduleOnLowMemory() {
        CoroutineScope scope;
        if (ConversationPreloadManagerKt.DEBUG) {
            Log.d("ConversationPreload", "reschedule on low memory");
        }
        if (PreloadSceneConfig.INSTANCE.isMemoryWarnActive() && (scope = getScope()) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), (CoroutineStart) null, new ConversationPreloadManager$rescheduleOnLowMemory$1((Continuation<? super ConversationPreloadManager$rescheduleOnLowMemory$1>) null), 2, (Object) null);
        }
    }

    private final long getCurrentTime() {
        return IAISearchSpeedStat.Companion.getImpl().getCurrentTime();
    }
}
