package com.baidu.searchbox.video.feedflow.tab.quickSlide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.preboot.policy.PlayGlobalConfig;
import com.baidu.searchbox.player.preboot.policy.SlideMode;
import com.baidu.searchbox.player.preboot.record.HistoryDepthMonitorManager;
import com.baidu.searchbox.player.preboot.record.PlayVideoDurationMonitorManager;
import com.baidu.searchbox.player.preboot.record.SpeedMonitorManager;
import com.baidu.searchbox.player.preboot.watcher.UserPlayInfo;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.common.IDetailItemCoreEventService;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0014\u0010'\u001a\u00020\u001d2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010)\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u0004H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0004H\u0002J<\u00109\u001a\n\u0012\u0004\u0012\u0002H;\u0018\u00010:\"\u0004\b\u0000\u0010;*\b\u0012\u0004\u0012\u0002H;0<2\u0006\u0010=\u001a\u00020\u00102\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00020\u00040?H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u000e\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/quickSlide/UserBehaviorPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "currentVideoVisible", "", "getCurrentVideoVisible", "()Z", "setCurrentVideoVisible", "(Z)V", "lastNid", "", "getLastNid", "()Ljava/lang/String;", "setLastNid", "(Ljava/lang/String;)V", "lastProcess", "", "getLastProcess", "()I", "setLastProcess", "(I)V", "playListener", "com/baidu/searchbox/video/feedflow/tab/quickSlide/UserBehaviorPlugin$playListener$1", "Lcom/baidu/searchbox/video/feedflow/tab/quickSlide/UserBehaviorPlugin$playListener$1;", "playState", "getPlayState", "setPlayState", "relativeIntentPosition", "bindPlayerLister", "", "checkEnterQuickSlideStatus", "checkExitQuickSlideStatus", "isEndQuickSlide", "isEnterQuickSlide", "isExitQuickSlideType1", "isExitQuickSlideType2", "onAttachToManager", "onCreate", "onDestroy", "onDetailItemDetach", "itemNid", "onDetailItemPageSelected", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "onPause", "onRelease", "onResume", "storeVideoDuration", "duration", "updateGlobalQuickMode", "newStatus", "Lcom/baidu/searchbox/player/preboot/policy/SlideMode;", "updateOnLifecycleChange", "isResume", "updateQuickSlideStatus", "updateUserBehaviorPlayStatus", "isPlayerPlaying", "firstXElement", "", "T", "", "firstX", "predicate", "Lkotlin/Function1;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserBehaviorPlugin.kt */
public final class UserBehaviorPlugin extends LiveDataPlugin {
    private boolean currentVideoVisible = true;
    private String lastNid = "";
    private int lastProcess;
    private final UserBehaviorPlugin$playListener$1 playListener = new UserBehaviorPlugin$playListener$1(this);
    private boolean playState = true;
    private int relativeIntentPosition;

    public final boolean getCurrentVideoVisible() {
        return this.currentVideoVisible;
    }

    public final void setCurrentVideoVisible(boolean z) {
        this.currentVideoVisible = z;
    }

    public final String getLastNid() {
        return this.lastNid;
    }

    public final void setLastNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastNid = str;
    }

    public final int getLastProcess() {
        return this.lastProcess;
    }

    public final void setLastProcess(int i2) {
        this.lastProcess = i2;
    }

    public final boolean getPlayState() {
        return this.playState;
    }

    public final void setPlayState(boolean z) {
        this.playState = z;
    }

    public void onCreate() {
        super.onCreate();
        IDetailItemCoreEventService iDetailItemCoreEventService = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService != null) {
            iDetailItemCoreEventService.addItemSelectedListener(new UserBehaviorPlugin$onCreate$1(this));
        }
        IDetailItemCoreEventService iDetailItemCoreEventService2 = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService2 != null) {
            iDetailItemCoreEventService2.addItemDetachFromScreenListener(new UserBehaviorPlugin$onCreate$2(this));
        }
    }

    public void onAttachToManager() {
        UserBehaviorState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d2 = (UserBehaviorState) $this$subscribe$iv.subscribe(UserBehaviorState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getUpdateSlideStatus().observe(this, new UserBehaviorPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.isCovered().observe(this, new UserBehaviorPlugin$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m6871onAttachToManager$lambda2$lambda0(UserBehaviorPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkEnterQuickSlideStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m6872onAttachToManager$lambda2$lambda1(UserBehaviorPlugin this$0, Boolean isCovered) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isCovered, "isCovered");
        if (isCovered.booleanValue()) {
            this$0.currentVideoVisible = false;
            this$0.updateOnLifecycleChange(false);
            return;
        }
        this$0.currentVideoVisible = true;
        this$0.updateOnLifecycleChange(true);
    }

    /* access modifiers changed from: private */
    public final void onDetailItemPageSelected(ItemModel<?> itemModel) {
        Object obj = null;
        onDetailItemDetach$default(this, (String) null, 1, (Object) null);
        checkEnterQuickSlideStatus();
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        int i2 = 0;
        this.relativeIntentPosition = iFlowComponentService != null ? iFlowComponentService.getRelativeIntentVideoPosition() : 0;
        if (itemModel != null) {
            IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
            if (iPlayerComponentService != null) {
                i2 = iPlayerComponentService.getCurProgress();
            }
            int currentProcess = i2;
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(UserBehaviorState.class);
                }
                UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
                if (userBehaviorState != null) {
                    userBehaviorState.buildUserBehaviorModel(itemModel, currentProcess);
                }
            }
            this.lastNid = itemModel.getNid();
            this.playState = true;
        }
    }

    static /* synthetic */ void onDetailItemDetach$default(UserBehaviorPlugin userBehaviorPlugin, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        userBehaviorPlugin.onDetailItemDetach(str);
    }

    /* access modifiers changed from: private */
    public final void onDetailItemDetach(String itemNid) {
        UserBehaviorModel $this$onDetailItemDetach_u24lambda_u2d4;
        bindPlayerLister();
        String nid = itemNid == null ? this.lastNid : itemNid;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            UserBehaviorState userBehaviorState = (UserBehaviorState) (commonState != null ? commonState.select(UserBehaviorState.class) : null);
            if (!(userBehaviorState == null || ($this$onDetailItemDetach_u24lambda_u2d4 = userBehaviorState.getUserBehaviorModel(nid)) == null)) {
                if (!(!$this$onDetailItemDetach_u24lambda_u2d4.isDetach())) {
                    $this$onDetailItemDetach_u24lambda_u2d4 = null;
                }
                if ($this$onDetailItemDetach_u24lambda_u2d4 != null) {
                    $this$onDetailItemDetach_u24lambda_u2d4.setDetachProcess(this.lastProcess);
                    UserBehaviorModelKt.onUserBehaviorDetach($this$onDetailItemDetach_u24lambda_u2d4);
                    storeVideoDuration($this$onDetailItemDetach_u24lambda_u2d4.getStayTime());
                    Store $this$select$iv2 = getStore();
                    if ($this$select$iv2 != null) {
                        AbsState state2 = $this$select$iv2.getState();
                        CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
                        if (commonState2 != null) {
                            obj = commonState2.select(UserBehaviorState.class);
                        }
                        UserBehaviorState userBehaviorState2 = (UserBehaviorState) obj;
                        if (userBehaviorState2 != null) {
                            userBehaviorState2.updateTotalPlayCompletionRatio($this$onDetailItemDetach_u24lambda_u2d4.getPlayCompletionRatio());
                        }
                    }
                }
            }
        }
        this.lastProcess = 0;
    }

    /* access modifiers changed from: private */
    public final void updateUserBehaviorPlayStatus(boolean isPlayerPlaying) {
        UserBehaviorModel userBehaviorModel;
        this.playState = isPlayerPlaying;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(UserBehaviorState.class);
            }
            UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
            if (userBehaviorState != null && (userBehaviorModel = userBehaviorState.getUserBehaviorModel(this.lastNid)) != null) {
                UserBehaviorModelKt.updateUserBehaviorPlayPart(userBehaviorModel, isPlayerPlaying);
            }
        }
    }

    private final void updateOnLifecycleChange(boolean isResume) {
        UserBehaviorModel userBehaviorModel;
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        Object obj = null;
        boolean isPlay = BdPlayerUtils.orFalse(iPlayerComponentService != null ? Boolean.valueOf(iPlayerComponentService.isPlayerPlaying()) : null);
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(UserBehaviorState.class);
            }
            UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
            if (!(userBehaviorState == null || (userBehaviorModel = userBehaviorState.getUserBehaviorModel(this.lastNid)) == null)) {
                UserBehaviorModelKt.updateUserBehaviorStayPart(userBehaviorModel, isResume);
            }
        }
        if (isPlay) {
            updateUserBehaviorPlayStatus(isPlay);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorStateKt.getUserPlayInfo(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkEnterQuickSlideStatus() {
        /*
            r3 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r3.getStore()
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.player.preboot.watcher.UserPlayInfo r0 = com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorStateKt.getUserPlayInfo(r0)
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.player.preboot.policy.SlideMode r0 = r0.getSlideState()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            boolean r2 = r3.isEnterQuickSlide()
            if (r2 == 0) goto L_0x001b
            com.baidu.searchbox.player.preboot.policy.SlideMode r1 = com.baidu.searchbox.player.preboot.policy.SlideMode.QUICK_SLIDE
        L_0x001b:
            if (r1 == 0) goto L_0x0022
            if (r0 == r1) goto L_0x0022
            r3.updateQuickSlideStatus(r1)
        L_0x0022:
            com.baidu.searchbox.player.preboot.policy.SlideMode r2 = com.baidu.searchbox.player.preboot.policy.SlideMode.NONE_SLIDE
            if (r0 != r2) goto L_0x002b
            com.baidu.searchbox.player.preboot.policy.SlideMode r2 = com.baidu.searchbox.player.preboot.policy.SlideMode.NORMAL_SLIDE
            r3.updateGlobalQuickMode(r2)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorPlugin.checkEnterQuickSlideStatus():void");
    }

    private final void bindPlayerLister() {
        IPlayerComponentService $this$bindPlayerLister_u24lambda_u2d5 = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if ($this$bindPlayerLister_u24lambda_u2d5 != null) {
            $this$bindPlayerLister_u24lambda_u2d5.removePlayerComponentListener(this.playListener);
            $this$bindPlayerLister_u24lambda_u2d5.addPlayerComponentListener(this.playListener);
        }
    }

    public void onResume() {
        SlideMode $this$onResume_u24lambda_u2d6;
        super.onResume();
        if (this.currentVideoVisible) {
            updateOnLifecycleChange(true);
        }
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            UserPlayInfo userPlayInfo = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            UserBehaviorState userBehaviorState = (UserBehaviorState) (commonState != null ? commonState.select(UserBehaviorState.class) : null);
            if (userBehaviorState != null && ($this$onResume_u24lambda_u2d6 = userBehaviorState.getQuickSlideStatus()) != null) {
                Store<AbsState> store = getStore();
                if (store != null) {
                    userPlayInfo = UserBehaviorStateKt.getUserPlayInfo(store);
                }
                if (userPlayInfo != null) {
                    userPlayInfo.setSlideState($this$onResume_u24lambda_u2d6);
                }
            }
        }
    }

    public void onPause() {
        if (this.currentVideoVisible) {
            updateOnLifecycleChange(false);
        }
    }

    public void onRelease() {
        super.onRelease();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(this.playListener);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        updateGlobalQuickMode(SlideMode.NORMAL_SLIDE);
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(this.playListener);
        }
        Store<AbsState> store = getStore();
        Object obj = null;
        String source = store != null ? CommonStateExtKt.pdRec(store) : null;
        int depth = Math.abs(this.relativeIntentPosition) + 1;
        if (depth > 0) {
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(VideoBusiness.class);
                }
                VideoBusiness $this$onDestroy_u24lambda_u2d7 = (VideoBusiness) obj;
                if ($this$onDestroy_u24lambda_u2d7 != null) {
                    HistoryDepthMonitorManager.INSTANCE.addHistData($this$onDestroy_u24lambda_u2d7.from(), $this$onDestroy_u24lambda_u2d7.page(), source, Integer.valueOf(depth));
                }
            }
            HistoryDepthMonitorManager.storeDepthRecord();
        }
        PlayVideoDurationMonitorManager.storeDurationRecord();
        SpeedMonitorManager.storeRecord();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r6.isQuickSlideStatus() == true) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkExitQuickSlideStatus() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0029
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0016
        L_0x0015:
            r4 = r6
        L_0x0016:
            if (r4 == 0) goto L_0x001e
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorState> r5 = com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x001e:
            com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorState r6 = (com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorState) r6
            if (r6 == 0) goto L_0x0029
            boolean r0 = r6.isQuickSlideStatus()
            if (r0 != r1) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            if (r1 == 0) goto L_0x0037
            boolean r0 = r7.isEndQuickSlide()
            if (r0 == 0) goto L_0x0037
            com.baidu.searchbox.player.preboot.policy.SlideMode r0 = com.baidu.searchbox.player.preboot.policy.SlideMode.NORMAL_SLIDE
            r7.updateQuickSlideStatus(r0)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorPlugin.checkExitQuickSlideStatus():void");
    }

    private final void updateQuickSlideStatus(SlideMode newStatus) {
        if (FlowSwitchStateKt.getPlayGlobalConfig(getStore()) != null) {
            updateGlobalQuickMode(newStatus);
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                Object obj = null;
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(UserBehaviorState.class);
                }
                UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
                if (userBehaviorState != null) {
                    userBehaviorState.changeSlideStatus(newStatus);
                }
            }
            Store<AbsState> store = getStore();
            if (store != null) {
                StoreExtKt.post(store, QuickSlideStateChange.INSTANCE);
            }
        }
    }

    private final boolean isEnterQuickSlide() {
        PlayGlobalConfig config;
        Store $this$select$iv;
        CopyOnWriteArrayList<UserBehaviorModel> userBehaviorRecordList;
        List<UserBehaviorModel> list;
        Store<AbsState> store = getStore();
        if (!(store == null || (config = FlowSwitchStateKt.getPlayGlobalConfig(store)) == null || ($this$select$iv = getStore()) == null)) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(UserBehaviorState.class);
            }
            UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
            if (!(userBehaviorState == null || (userBehaviorRecordList = userBehaviorState.getUserBehaviorRecordList()) == null || (list = firstXElement(userBehaviorRecordList, config.getQuickEnterX(), UserBehaviorPlugin$isEnterQuickSlide$1.INSTANCE)) == null)) {
                for (UserBehaviorModel element : list) {
                    if (element.getEndTime() - element.getStartTime() > ((long) config.getQuickEnterN())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean isEndQuickSlide() {
        PlayGlobalConfig config;
        Store<AbsState> store = getStore();
        if (store == null || (config = FlowSwitchStateKt.getPlayGlobalConfig(store)) == null) {
            return false;
        }
        switch (config.getQuickExitType()) {
            case 1:
                return isExitQuickSlideType1();
            case 2:
                return isExitQuickSlideType2();
            default:
                return false;
        }
    }

    private final boolean isExitQuickSlideType1() {
        PlayGlobalConfig config;
        Store $this$select$iv;
        CopyOnWriteArrayList<UserBehaviorModel> userBehaviorRecordList;
        UserBehaviorModel it;
        Store<AbsState> store = getStore();
        if (!(store == null || (config = FlowSwitchStateKt.getPlayGlobalConfig(store)) == null || ($this$select$iv = getStore()) == null)) {
            AbsState state = $this$select$iv.getState();
            UserBehaviorModel userBehaviorModel = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            UserBehaviorState userBehaviorState = (UserBehaviorState) (commonState != null ? commonState.select(UserBehaviorState.class) : null);
            if (!(userBehaviorState == null || (userBehaviorRecordList = userBehaviorState.getUserBehaviorRecordList()) == null || (it = (UserBehaviorModel) CollectionsKt.firstOrNull(userBehaviorRecordList)) == null)) {
                if (it.checkLayout()) {
                    userBehaviorModel = it;
                }
                if (userBehaviorModel != null) {
                    UserBehaviorModel model = userBehaviorModel;
                    if ((model.getEndTime() == 0 ? System.currentTimeMillis() : model.getEndTime()) - model.getStartTime() > ((long) config.getQuickExitN())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isExitQuickSlideType2() {
        PlayGlobalConfig config;
        Store $this$select$iv;
        CopyOnWriteArrayList<UserBehaviorModel> userBehaviorRecordList;
        List<UserBehaviorModel> list;
        Store<AbsState> store = getStore();
        if (!(store == null || (config = FlowSwitchStateKt.getPlayGlobalConfig(store)) == null || ($this$select$iv = getStore()) == null)) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(UserBehaviorState.class);
            }
            UserBehaviorState userBehaviorState = (UserBehaviorState) obj;
            if (!(userBehaviorState == null || (userBehaviorRecordList = userBehaviorState.getUserBehaviorRecordList()) == null || (list = firstXElement(userBehaviorRecordList, config.getQuickExitSeriesX(), UserBehaviorPlugin$isExitQuickSlideType2$1.INSTANCE)) == null)) {
                for (UserBehaviorModel element : list) {
                    if ((element.getEndTime() == 0 ? System.currentTimeMillis() : element.getEndTime()) - element.getStartTime() < ((long) config.getQuickExitSeriesN())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final void updateGlobalQuickMode(SlideMode newStatus) {
        Store<AbsState> store = getStore();
        UserPlayInfo userPlayInfo = store != null ? UserBehaviorStateKt.getUserPlayInfo(store) : null;
        if (userPlayInfo != null) {
            userPlayInfo.setSlideState(newStatus);
        }
    }

    private final void storeVideoDuration(int duration) {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            String source = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            VideoBusiness videoBusiness = (VideoBusiness) (commonState != null ? commonState.select(VideoBusiness.class) : null);
            if (videoBusiness != null) {
                VideoBusiness business = videoBusiness;
                Store<AbsState> store = getStore();
                if (store != null) {
                    source = CommonStateExtKt.pdRec(store);
                }
                PlayVideoDurationMonitorManager.INSTANCE.addHistData(business.from(), business.page(), source, Integer.valueOf(duration / 1000));
            }
        }
    }

    private final <T> List<T> firstXElement(List<? extends T> $this$firstXElement, int firstX, Function1<? super T, Boolean> predicate) {
        List<T> arrayList = new ArrayList<>();
        int index = 0;
        for (Object element : $this$firstXElement) {
            if (index >= firstX) {
                break;
            } else if (predicate.invoke(element).booleanValue()) {
                arrayList.add(element);
                index++;
            }
        }
        if (arrayList.size() == firstX) {
            return arrayList;
        }
        return null;
    }
}
