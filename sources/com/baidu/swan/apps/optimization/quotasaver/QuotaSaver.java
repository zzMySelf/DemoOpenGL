package com.baidu.swan.apps.optimization.quotasaver;

import android.content.Context;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.launch.model.property.Properties;
import com.baidu.swan.apps.lifecycle.backstage.switcher.IOptSwitcher;
import com.baidu.swan.apps.lifecycle.recording.MoveTaskToBackByUserRecorder;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.IpcSession;
import com.baidu.swan.apps.process.ipc.SwanIpc;
import com.baidu.swan.apps.process.messaging.service.SwanClientPuppet;
import com.baidu.swan.apps.process.messaging.service.SwanPuppetManager;
import com.baidu.swan.apps.runtime.EventSubscriber;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanEvent;
import com.baidu.swan.apps.runtime.SwanImpl;
import com.baidu.swan.apps.runtime.def.SwanResetFlags;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u00107\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0002H\u0002J\u0006\u0010;\u001a\u000209J\u0012\u0010<\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\rR\u001b\u0010\"\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\rR\u001b\u0010%\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\rR\u001b\u0010(\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\rR\u001b\u0010+\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\rR\u001b\u0010.\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\rR\u001b\u00101\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\rR\u001b\u00104\u001a\u00020\u001b8FX\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u001d¨\u0006@"}, d2 = {"Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver;", "Lcom/baidu/swan/apps/util/typedbox/TypedCallback;", "Lcom/baidu/swan/apps/runtime/SwanEvent$Impl;", "()V", "config", "Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", "getConfig", "()Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", "config$delegate", "Lkotlin/Lazy;", "enableSuspend", "", "getEnableSuspend", "()Z", "enableSuspend$delegate", "eventSubscriber", "Lcom/baidu/swan/apps/runtime/EventSubscriber;", "kotlin.jvm.PlatformType", "getEventSubscriber", "()Lcom/baidu/swan/apps/runtime/EventSubscriber;", "eventSubscriber$delegate", "optSwitcher", "Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "getOptSwitcher", "()Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "optSwitcher$delegate", "rescueRefractoryPeriod", "", "getRescueRefractoryPeriod", "()J", "rescueRefractoryPeriod$delegate", "shouldKillOnlyOnExitByUser", "getShouldKillOnlyOnExitByUser", "shouldKillOnlyOnExitByUser$delegate", "shouldSuspendAll", "getShouldSuspendAll", "shouldSuspendAll$delegate", "shouldSuspendAnything", "getShouldSuspendAnything", "shouldSuspendAnything$delegate", "shouldSuspendMasterTimer", "getShouldSuspendMasterTimer", "shouldSuspendMasterTimer$delegate", "shouldSuspendSlaveTimer", "getShouldSuspendSlaveTimer", "shouldSuspendSlaveTimer$delegate", "shouldSuspendV8Timer", "getShouldSuspendV8Timer", "shouldSuspendV8Timer$delegate", "shouldSuspendWebViewTimer", "getShouldSuspendWebViewTimer", "shouldSuspendWebViewTimer$delegate", "suspendDelayTime", "getSuspendDelayTime", "suspendDelayTime$delegate", "checkKillableByConfig", "handleKillMsgOnSwanProcess", "", "msg", "killAllSwanProcess", "onCallback", "regEventSubscriberOn", "swanImpl", "Lcom/baidu/swan/apps/runtime/SwanImpl;", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuotaSaver.kt */
public final class QuotaSaver implements TypedCallback<SwanEvent.Impl> {
    public static final QuotaSaver INSTANCE = new QuotaSaver();
    private static final Lazy config$delegate = LazyKt.lazy(QuotaSaver$config$2.INSTANCE);
    private static final Lazy enableSuspend$delegate = LazyKt.lazy(QuotaSaver$enableSuspend$2.INSTANCE);
    private static final Lazy eventSubscriber$delegate = LazyKt.lazy(QuotaSaver$eventSubscriber$2.INSTANCE);
    private static final Lazy optSwitcher$delegate = LazyKt.lazy(QuotaSaver$optSwitcher$2.INSTANCE);
    private static final Lazy rescueRefractoryPeriod$delegate = LazyKt.lazy(QuotaSaver$rescueRefractoryPeriod$2.INSTANCE);
    private static final Lazy shouldKillOnlyOnExitByUser$delegate = LazyKt.lazy(QuotaSaver$shouldKillOnlyOnExitByUser$2.INSTANCE);
    private static final Lazy shouldSuspendAll$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendAll$2.INSTANCE);
    private static final Lazy shouldSuspendAnything$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendAnything$2.INSTANCE);
    private static final Lazy shouldSuspendMasterTimer$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendMasterTimer$2.INSTANCE);
    private static final Lazy shouldSuspendSlaveTimer$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendSlaveTimer$2.INSTANCE);
    private static final Lazy shouldSuspendV8Timer$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendV8Timer$2.INSTANCE);
    private static final Lazy shouldSuspendWebViewTimer$delegate = LazyKt.lazy(QuotaSaver$shouldSuspendWebViewTimer$2.INSTANCE);
    private static final Lazy suspendDelayTime$delegate = LazyKt.lazy(QuotaSaver$suspendDelayTime$2.INSTANCE);

    private QuotaSaver() {
    }

    public final Properties.Impl getConfig() {
        return (Properties.Impl) config$delegate.getValue();
    }

    public final long getRescueRefractoryPeriod() {
        return ((Number) rescueRefractoryPeriod$delegate.getValue()).longValue();
    }

    public final long getSuspendDelayTime() {
        return ((Number) suspendDelayTime$delegate.getValue()).longValue();
    }

    public final boolean getShouldKillOnlyOnExitByUser() {
        return ((Boolean) shouldKillOnlyOnExitByUser$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendAll() {
        return ((Boolean) shouldSuspendAll$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendV8Timer() {
        return ((Boolean) shouldSuspendV8Timer$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendWebViewTimer() {
        return ((Boolean) shouldSuspendWebViewTimer$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendMasterTimer() {
        return ((Boolean) shouldSuspendMasterTimer$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendSlaveTimer() {
        return ((Boolean) shouldSuspendSlaveTimer$delegate.getValue()).booleanValue();
    }

    public final boolean getShouldSuspendAnything() {
        return ((Boolean) shouldSuspendAnything$delegate.getValue()).booleanValue();
    }

    public final boolean getEnableSuspend() {
        return ((Boolean) enableSuspend$delegate.getValue()).booleanValue();
    }

    public final IOptSwitcher getOptSwitcher() {
        return (IOptSwitcher) optSwitcher$delegate.getValue();
    }

    private final EventSubscriber getEventSubscriber() {
        return (EventSubscriber) eventSubscriber$delegate.getValue();
    }

    public void onCallback(SwanEvent.Impl msg) {
        if (msg != null) {
            INSTANCE.handleKillMsgOnSwanProcess(msg);
        }
    }

    public final void regEventSubscriberOn(SwanImpl swanImpl) {
        Intrinsics.checkNotNullParameter(swanImpl, "swanImpl");
        swanImpl.addEventCallback(getEventSubscriber());
    }

    public final void killAllSwanProcess() {
        SwanAppLog.i("QuotaSaver", "killAllSwanProcess: call");
        SwanPuppetManager puppetManager = SwanPuppetManager.get();
        if (puppetManager != null) {
            SwanPuppetManager swanPuppetManager = puppetManager;
            boolean z = true;
            if (INSTANCE.getRescueRefractoryPeriod() <= 0 || !ProcessUtils.isMainProcess() || !SwanAppUIUtils.isAppOnBackground(true)) {
                z = false;
            }
            if (!z) {
                puppetManager = null;
            }
            if (puppetManager != null) {
                LinkedHashSet<SwanClientPuppet> $this$forEach$iv = puppetManager.getClientObjs();
                Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "puppetManager.clientObjs");
                for (SwanClientPuppet item : $this$forEach$iv) {
                    if (item != null) {
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        SwanClientPuppet puppet = item.isProcessOnline() ? item : null;
                        if (puppet != null) {
                            IpcSession ipcSession = SwanIpc.create("quota_saver_killing");
                            ((IpcSession) ipcSession.addCallbackForResponse(new QuotaSaver$$ExternalSyntheticLambda0(ipcSession, puppetManager, puppet)).putString("quota_saver_action", "quota_saver_action_will_done")).addTarget(puppet.getProcess().getClientMsgTarget()).call();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: killAllSwanProcess$lambda-9$lambda-8$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final void m8039killAllSwanProcess$lambda9$lambda8$lambda7$lambda6$lambda5(IpcSession $ipcSession, SwanPuppetManager $puppetManager, SwanClientPuppet $puppet, SwanEvent.Impl ipcSectionData) {
        Intrinsics.checkNotNullParameter($puppetManager, "$puppetManager");
        Intrinsics.checkNotNullParameter($puppet, "$puppet");
        if (ipcSectionData != null) {
            if ((Intrinsics.areEqual((Object) "quota_saver_action_bye", (Object) ipcSectionData.getString("quota_saver_action")) ? ipcSectionData : null) != null) {
                SwanAppLog.i("QuotaSaver", "killSwanProcess: call bye on callback bye");
                $ipcSession.putString("quota_saver_action", "quota_saver_action_bye");
                $ipcSession.call();
                $puppetManager.incrementRescueRefractoryPeriod(INSTANCE.getRescueRefractoryPeriod());
                $puppet.tryUnbind((Context) null);
            }
        }
    }

    private final void handleKillMsgOnSwanProcess(SwanEvent.Impl msg) {
        SwanEvent.Impl impl = msg;
        boolean z = true;
        if (!SwanIpc.acceptTopic(msg.toBundle(), "quota_saver_killing") || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.current().isSwanAppProcess() || !SwanAppUIUtils.isCurrProcessOnBackground(true) || !INSTANCE.checkKillableByConfig()) {
            z = false;
        }
        SwanEvent.Impl ipcSection = z ? msg : null;
        if (ipcSection != null) {
            String action = ipcSection.getString("quota_saver_action");
            SwanAppLog.i("QuotaSaver", "handleKillMsgOnSwanProcess: on action=" + action);
            if (Intrinsics.areEqual((Object) action, (Object) "quota_saver_action_will_done")) {
                SwanAppLog.i("QuotaSaver", "handleKillMsgOnSwanProcess: callback bye by WILL_DONE");
                Swan.get().resetSwanApp(SwanResetFlags.FLAG_FINISH_ACTIVITY, SwanResetFlags.FLAG_REMOVE_TASK);
                ((IpcSession) SwanIpc.require(msg.toBundle()).putString("quota_saver_action", "quota_saver_action_bye")).call();
            } else if (Intrinsics.areEqual((Object) action, (Object) "quota_saver_action_bye")) {
                SwanAppLog.i("QuotaSaver", "handleKillMsgOnSwanProcess: kill do by bye");
                Swan.get().killSwanProcess();
            }
        }
    }

    private final boolean checkKillableByConfig() {
        return !getShouldKillOnlyOnExitByUser() || MoveTaskToBackByUserRecorder.hasRecord() || !Swan.get().hasAppOccupied();
    }
}
