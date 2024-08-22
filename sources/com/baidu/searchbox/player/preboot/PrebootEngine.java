package com.baidu.searchbox.player.preboot;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.assistant.KernelCacheAssistant;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.kernel.KernelLayerCreator;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.preboot.callback.IPrefetchStatListener;
import com.baidu.searchbox.player.preboot.callback.OnPrefetchResultListener;
import com.baidu.searchbox.player.preboot.env.PolicyScene;
import com.baidu.searchbox.player.preboot.env.PrebootConfig;
import com.baidu.searchbox.player.preboot.env.PrebootInfo;
import com.baidu.searchbox.player.preboot.env.PrebootRuntime;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import com.baidu.searchbox.player.preboot.env.PrebootType;
import com.baidu.searchbox.player.preboot.policy.IPrebootPolicyService;
import com.baidu.searchbox.player.preboot.policy.PrebootPolicyServiceManager;
import com.baidu.searchbox.player.preboot.processor.IPrebootProcessor;
import com.baidu.searchbox.player.preboot.scheduler.AbsScheduler;
import com.baidu.searchbox.player.preboot.task.AbsPrebootTask;
import com.baidu.searchbox.player.utils.KernelLayerExtUtilsKt;
import com.baidu.searchbox.plugins.kernels.webview.ZeusInstallHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J/\u0010!\u001a\u00020\"2%\b\u0002\u0010#\u001a\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010$H\u0007J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\nH\u0007J\b\u0010.\u001a\u00020/H\u0007J \u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0007J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0007J0\u00100\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0007J\u0006\u0010;\u001a\u00020\u001aJ\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001d\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\"H\u0000¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020\"H\u0000¢\u0006\u0002\bDR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8@X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/baidu/searchbox/player/preboot/PrebootEngine;", "", "()V", "cachePool", "Lcom/baidu/searchbox/player/assistant/KernelCacheAssistant;", "kernelCreator", "Lcom/baidu/searchbox/player/kernel/KernelLayerCreator;", "policyManager", "Lcom/baidu/searchbox/player/preboot/policy/PrebootPolicyServiceManager;", "preCreateKernelKey", "", "prefetchResultListener", "Lcom/baidu/searchbox/player/preboot/callback/OnPrefetchResultListener;", "getPrefetchResultListener$preboot_release", "()Lcom/baidu/searchbox/player/preboot/callback/OnPrefetchResultListener;", "prefetchResultListener$delegate", "Lkotlin/Lazy;", "prefetchStatListener", "Lcom/baidu/searchbox/player/preboot/callback/IPrefetchStatListener;", "getPrefetchStatListener$preboot_release", "()Lcom/baidu/searchbox/player/preboot/callback/IPrefetchStatListener;", "setPrefetchStatListener$preboot_release", "(Lcom/baidu/searchbox/player/preboot/callback/IPrefetchStatListener;)V", "scheduler", "Lcom/baidu/searchbox/player/preboot/scheduler/AbsScheduler;", "add", "", "processor", "Lcom/baidu/searchbox/player/preboot/processor/IPrebootProcessor;", "collectPolicyService", "config", "Lcom/baidu/searchbox/player/preboot/env/PrebootConfig;", "collectProcessor", "createKernelCache", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "callback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/player/message/IMessenger;", "Lkotlin/ParameterName;", "name", "messenger", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "deliverTask", "prebootInfo", "Lcom/baidu/searchbox/player/preboot/env/PrebootInfo;", "getPreCreateKernelKey", "hasPreCreateKernel", "", "preboot", "videoSeries", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "type", "Lcom/baidu/searchbox/player/preboot/env/PrebootType;", "scene", "Lcom/baidu/searchbox/player/preboot/env/PolicyScene;", "from", "page", "source", "url", "release", "remove", "saveKernelCache", "key", "kernelLayer", "saveKernelCache$preboot_release", "setupConfig", "setupConfig$preboot_release", "tryGetKernelCache", "tryGetKernelCache$preboot_release", "Companion", "Holder", "preboot_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrebootEngine.kt */
public final class PrebootEngine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private KernelCacheAssistant cachePool;
    private KernelLayerCreator kernelCreator;
    private PrebootPolicyServiceManager policyManager;
    private String preCreateKernelKey;
    private final Lazy prefetchResultListener$delegate;
    private IPrefetchStatListener prefetchStatListener;
    private AbsScheduler scheduler;

    public /* synthetic */ PrebootEngine(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @StableApi
    @JvmStatic
    public static final PrebootEngine getInstance() {
        return Companion.getInstance();
    }

    private PrebootEngine() {
        this.policyManager = PrebootPolicyServiceManager.INSTANCE;
        this.preCreateKernelKey = PrebootRuntimeKt.KEY_PRE_CREATE;
        this.prefetchResultListener$delegate = LazyKt.lazy(PrebootEngine$prefetchResultListener$2.INSTANCE);
        setupConfig$preboot_release(PrebootRuntime.INSTANCE.getConfig$preboot_release());
    }

    public final OnPrefetchResultListener getPrefetchResultListener$preboot_release() {
        return (OnPrefetchResultListener) this.prefetchResultListener$delegate.getValue();
    }

    public final IPrefetchStatListener getPrefetchStatListener$preboot_release() {
        return this.prefetchStatListener;
    }

    public final void setPrefetchStatListener$preboot_release(IPrefetchStatListener iPrefetchStatListener) {
        this.prefetchStatListener = iPrefetchStatListener;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/preboot/PrebootEngine$Companion;", "", "()V", "getInstance", "Lcom/baidu/searchbox/player/preboot/PrebootEngine;", "preboot_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrebootEngine.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @StableApi
        @JvmStatic
        public final PrebootEngine getInstance() {
            return Holder.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/preboot/PrebootEngine$Holder;", "", "()V", "instance", "Lcom/baidu/searchbox/player/preboot/PrebootEngine;", "getInstance", "()Lcom/baidu/searchbox/player/preboot/PrebootEngine;", "preboot_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrebootEngine.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final PrebootEngine instance = new PrebootEngine((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final PrebootEngine getInstance() {
            return instance;
        }
    }

    public final void setupConfig$preboot_release(PrebootConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        KernelCacheAssistant kernelCacheAssistant = KernelCacheAssistant.get();
        Intrinsics.checkNotNullExpressionValue(kernelCacheAssistant, "get()");
        this.cachePool = kernelCacheAssistant;
        this.scheduler = config.provideScheduler();
        this.kernelCreator = config.kernelCreator();
        collectPolicyService(config);
        collectProcessor(config);
        this.prefetchStatListener = config.prefetchStatListener();
    }

    private final void collectProcessor(PrebootConfig config) {
        for (Function0 initializer : config.processorCollector().collect()) {
            add((IPrebootProcessor) initializer.invoke());
        }
    }

    private final void collectPolicyService(PrebootConfig config) {
        for (Function0 initializer : config.policyServiceCollector().collect()) {
            this.policyManager.registerService((IPrebootPolicyService) initializer.invoke());
        }
    }

    @StableApi
    public final void preboot(BasicVideoSeries videoSeries, PrebootType type, PolicyScene scene) {
        Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(scene, "scene");
        PrebootRuntimeKt.print$default("preboot call, videoSeries is => {" + videoSeries + AbstractJsonLexerKt.END_OBJ, (Exception) null, 1, (Object) null);
        deliverTask(PrebootRuntimeKt.toPrebootInfo(videoSeries, type, scene));
    }

    @StableApi
    public final void preboot(PrebootInfo prebootInfo) {
        Intrinsics.checkNotNullParameter(prebootInfo, "prebootInfo");
        PrebootRuntimeKt.print$default("preboot call, preboot info => {" + prebootInfo + AbstractJsonLexerKt.END_OBJ, (Exception) null, 1, (Object) null);
        deliverTask(prebootInfo);
    }

    @StableApi
    public final void preboot(String from, String page, String source, String url, PolicyScene scene) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scene, "scene");
        deliverTask(new PrebootInfo(from, page, source, "", url, PrebootType.PRE_CREATE, scene));
    }

    @StableApi
    public final void add(IPrebootProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, ZeusInstallHelper.CpuInfoConst.PROCESSOR);
        AbsScheduler absScheduler = this.scheduler;
        if (absScheduler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduler");
            absScheduler = null;
        }
        absScheduler.add(processor);
    }

    @StableApi
    public final void remove(IPrebootProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, ZeusInstallHelper.CpuInfoConst.PROCESSOR);
        AbsScheduler absScheduler = this.scheduler;
        if (absScheduler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduler");
            absScheduler = null;
        }
        absScheduler.remove(processor);
    }

    @StableApi
    public final boolean hasPreCreateKernel() {
        KernelCacheAssistant kernelCacheAssistant = this.cachePool;
        if (kernelCacheAssistant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cachePool");
            kernelCacheAssistant = null;
        }
        return PrebootRuntimeKt.isValid(kernelCacheAssistant.getCache(this.preCreateKernelKey));
    }

    public static /* synthetic */ BaseKernelLayer createKernelCache$default(PrebootEngine prebootEngine, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        return prebootEngine.createKernelCache(function1);
    }

    @StableApi
    public final BaseKernelLayer createKernelCache(Function1<? super IMessenger, ? extends IKernelPlayer> callback) {
        KernelLayerCreator kernelLayerCreator = this.kernelCreator;
        if (kernelLayerCreator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kernelCreator");
            kernelLayerCreator = null;
        }
        return PrebootRuntimeKt.create(kernelLayerCreator, callback);
    }

    @StableApi
    public final String getPreCreateKernelKey() {
        return this.preCreateKernelKey;
    }

    public final void saveKernelCache$preboot_release(String key, BaseKernelLayer kernelLayer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kernelLayer, "kernelLayer");
        this.preCreateKernelKey = key;
        KernelCacheAssistant kernelCacheAssistant = this.cachePool;
        if (kernelCacheAssistant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cachePool");
            kernelCacheAssistant = null;
        }
        kernelCacheAssistant.putCache(key, kernelLayer);
    }

    public final BaseKernelLayer tryGetKernelCache$preboot_release() {
        KernelCacheAssistant kernelCacheAssistant = this.cachePool;
        if (kernelCacheAssistant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cachePool");
            kernelCacheAssistant = null;
        }
        BaseKernelLayer kernelLayer = kernelCacheAssistant.removeCache(this.preCreateKernelKey);
        if (!PrebootRuntimeKt.isValid(kernelLayer)) {
            kernelLayer = createKernelCache$default(this, (Function1) null, 1, (Object) null);
        }
        KernelLayerExtUtilsKt.setFromPrebootTag(kernelLayer);
        return kernelLayer;
    }

    private final void deliverTask(PrebootInfo prebootInfo) {
        AbsPrebootTask task = this.policyManager.deliverTask(prebootInfo);
        if (task != null) {
            AbsScheduler absScheduler = null;
            PrebootRuntimeKt.print$default("publishTask begin, task => {" + task + AbstractJsonLexerKt.END_OBJ, (Exception) null, 1, (Object) null);
            AbsScheduler absScheduler2 = this.scheduler;
            if (absScheduler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduler");
            } else {
                absScheduler = absScheduler2;
            }
            absScheduler.publish(task);
        }
    }

    public final void release() {
        AbsScheduler absScheduler = this.scheduler;
        if (absScheduler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduler");
            absScheduler = null;
        }
        absScheduler.release();
    }
}
