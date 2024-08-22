package com.baidu.searchbox.video.hotflow.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.boxshare.ISystemScreenshotContent;
import com.baidu.searchbox.boxshare.SystemScreenshotContentBean;
import com.baidu.searchbox.download.center.ui.DownloadProcessManager;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.IComponentStateListener;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreAction;
import com.baidu.searchbox.feed.detail.ext.common.ExcAction;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.feed.detail.ext.common.UbcExtBean;
import com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.ui.drawerslide.BiSerialDetailBaseActivity;
import com.baidu.searchbox.heatmap.HeatMapHelper;
import com.baidu.searchbox.launch.restore.data.PageRestoreData;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.assemble.creator.HotArchCreator;
import com.baidu.searchbox.video.collectionflow.datachannel.comment.CollectionFlowCommentRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.comment.VideoFlowCommentRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.follow.CollectionFlowFollowRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.follow.VideoFlowFollowRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.pay.FlowPayRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.praise.CollectionMiniPraiseRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.praise.CollectionNormalPraiseRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.praise.VideoFlowPraiseRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.praise.VideoLandPraiseRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.share.CollectionFlowShareRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.talospanel.TalosPanelRegister;
import com.baidu.searchbox.video.collectionflow.datachannel.task.CollectionTaskRegister;
import com.baidu.searchbox.video.collectionflow.slide.ILeftSlidePersonPageListener;
import com.baidu.searchbox.video.collectionflow.slide.ILeftSlidePersonPageService;
import com.baidu.searchbox.video.collectionflow.slide.LeftSlidePersonPageState;
import com.baidu.searchbox.video.collectionflow.slide.VideoFlowSlideIntercept;
import com.baidu.searchbox.video.component.datachannel.service.IDataChannelService;
import com.baidu.searchbox.video.component.share.ShareModel;
import com.baidu.searchbox.video.component.share.ShareModelKt;
import com.baidu.searchbox.video.component.share.service.ICommonShareService;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.detail.core.IntextDataExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoToolBarUtils;
import com.baidu.searchbox.video.detail.utils.VideoImmersionUtils;
import com.baidu.searchbox.video.feedflow.common.IDetailItemCoreEventService;
import com.baidu.searchbox.video.feedflow.common.IMultiWindowService;
import com.baidu.searchbox.video.feedflow.common.ITouchEventListenerService;
import com.baidu.searchbox.video.feedflow.common.serviceimpl.MultiWindowImpl;
import com.baidu.searchbox.video.feedflow.datachannel.chatroom.CollectionFlowChatroomRegister;
import com.baidu.searchbox.video.feedflow.detail.challenge.ChallengeViewRegister;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeChanged;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.bottom.utils.TopBackUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.coldlaunch.ColdLaunchRestoreState;
import com.baidu.searchbox.video.feedflow.flow.gohome.GoHomeState;
import com.baidu.searchbox.video.feedflow.flow.list.ActivityAnimation;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.ConfigurationChangedAction;
import com.baidu.searchbox.video.feedflow.flow.list.DispatchTouchDownEvent;
import com.baidu.searchbox.video.feedflow.flow.list.DispatchTouchUpEvent;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.OnActivityDestroy;
import com.baidu.searchbox.video.feedflow.flow.list.PostIntentAction;
import com.baidu.searchbox.video.feedflow.flow.service.FlowActivityService;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowActivityService;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction;
import com.baidu.searchbox.video.feedflow.fragment.FragmentData;
import com.baidu.searchbox.video.feedflow.fragment.IVideoFlowActivityAgentListener;
import com.baidu.searchbox.video.feedflow.guidepriority.GuidePriorityHelper;
import com.baidu.searchbox.video.feedflow.tab.back.GestureBackAction;
import com.baidu.searchbox.video.feedflow.tab.back.SlipBackAction;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowSchemeUtilsKt;
import com.baidu.searchbox.video.hotflow.HotFlowActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020:H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020:H\u0016J\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020:H\u0002J\u0014\u0010I\u001a\u00020:2\n\u0010J\u001a\u00060Kj\u0002`LH\u0002J\b\u0010M\u001a\u00020:H\u0002J\u001c\u0010N\u001a\u00020:2\b\u0010O\u001a\u0004\u0018\u00010B2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0002J\n\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020:H\u0016J\u0012\u0010Y\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020^2\b\u0010A\u001a\u0004\u0018\u00010_H\u0016J\"\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020^2\u0006\u0010b\u001a\u00020^2\b\u0010c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010d\u001a\u00020(H\u0016J\u0010\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020gH\u0016J$\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010m\u001a\u00020:H\u0016J\b\u0010n\u001a\u00020:H\u0016J\b\u0010o\u001a\u00020:H\u0016J\b\u0010p\u001a\u00020:H\u0016J\b\u0010q\u001a\u00020:H\u0016J\b\u0010r\u001a\u00020:H\u0016J\u001a\u0010s\u001a\u00020(2\u0006\u0010]\u001a\u00020^2\b\u0010A\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010t\u001a\u00020:2\u0006\u0010u\u001a\u00020(H\u0016J\u0010\u0010v\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010w\u001a\u00020:2\u0006\u0010x\u001a\u00020(H\u0016J\b\u0010y\u001a\u00020:H\u0016J.\u0010z\u001a\u00020:2\u0006\u0010a\u001a\u00020^2\u000e\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020}0|2\u0006\u0010~\u001a\u00020H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020(H\u0016J\t\u0010\u0001\u001a\u00020:H\u0002J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020}H\u0016J\u0011\u0010\u0001\u001a\u00020:2\u0006\u0010F\u001a\u00020GH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R!\u0010.\u001a\b\u0012\u0004\u0012\u0002000/8BX\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b6\u00107¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/video/hotflow/fragment/HotFlowFragment;", "Lcom/baidu/searchbox/appframework/fragment/BaseFragment;", "Lcom/baidu/searchbox/feed/detail/arch/api/IComponentStateListener;", "Lcom/baidu/searchbox/video/collectionflow/slide/ILeftSlidePersonPageListener;", "Lcom/baidu/searchbox/video/feedflow/fragment/IVideoFlowActivityAgentListener;", "Lcom/baidu/searchbox/boxshare/ISystemScreenshotContent;", "()V", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "getComponentManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "componentManager$delegate", "Lkotlin/Lazy;", "downloadProcessManager", "Lcom/baidu/searchbox/download/center/ui/DownloadProcessManager;", "getDownloadProcessManager", "()Lcom/baidu/searchbox/download/center/ui/DownloadProcessManager;", "downloadProcessManager$delegate", "flowSlideIntercept", "Lcom/baidu/searchbox/video/collectionflow/slide/VideoFlowSlideIntercept;", "getFlowSlideIntercept", "()Lcom/baidu/searchbox/video/collectionflow/slide/VideoFlowSlideIntercept;", "flowSlideIntercept$delegate", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent$delegate", "Lcom/baidu/searchbox/video/feedflow/fragment/FragmentData;", "intentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "getIntentData", "()Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "intentData$delegate", "isOnPanelSlide", "", "multiWindowService", "Lcom/baidu/searchbox/video/feedflow/common/serviceimpl/MultiWindowImpl;", "getMultiWindowService", "()Lcom/baidu/searchbox/video/feedflow/common/serviceimpl/MultiWindowImpl;", "multiWindowService$delegate", "store", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getStore", "()Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "store$delegate", "videoBusiness", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "getVideoBusiness", "()Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "videoBusiness$delegate", "addLeftSlideDrawerContent", "", "content", "Landroid/view/View;", "lp", "Landroid/view/ViewGroup$LayoutParams;", "addSlideExtraListener", "canSlideDrawer", "event", "Landroid/view/MotionEvent;", "canSlideFinish", "closeLeftSlideDrawer", "dispatchAction", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "dispatchActive", "dispatchExcAction", "exc", "Ljava/lang/Exception;", "Lkotlin/Exception;", "dispatchInactive", "dispatchTouchEvent", "ev", "heatMapHelper", "Lcom/baidu/searchbox/heatmap/HeatMapHelper;", "getRestoreData", "Lcom/baidu/searchbox/launch/restore/data/PageRestoreData;", "getSlideActivity", "Lcom/baidu/searchbox/feed/ui/drawerslide/BiSerialDetailBaseActivity;", "getSystemScreenshotContent", "Lcom/baidu/searchbox/boxshare/SystemScreenshotContentBean;", "onActivityBackPressed", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityKeyDown", "keyCode", "", "Landroid/view/KeyEvent;", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDragBegin", "onDragReset", "onDrawerClosed", "onDrawerOpened", "onExit", "onKeyDown", "onMultiWindowModeChanged", "isInMultiWindowMode", "onNewIntent", "onNightModeChanged", "isNightMode", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "openLeftSlideDrawer", "registerService", "setDataChannelRegister", "setEnableSlide", "setLeftSlideDrawerSlideEnable", "enable", "startFlowVideo", "uploadBackStatistic", "type", "uploadTopBackStatistic", "Companion", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotFlowFragment.kt */
public final class HotFlowFragment extends BaseFragment implements IComponentStateListener, ILeftSlidePersonPageListener, IVideoFlowActivityAgentListener, ISystemScreenshotContent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HotFlowFragment.class, "intent", "getIntent()Landroid/content/Intent;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy componentManager$delegate = LazyKt.lazy(HotFlowFragment$componentManager$2.INSTANCE);
    private final Lazy downloadProcessManager$delegate = LazyKt.lazy(new HotFlowFragment$downloadProcessManager$2(this));
    private final Lazy flowSlideIntercept$delegate = LazyKt.lazy(new HotFlowFragment$flowSlideIntercept$2(this));
    private final Lazy handler$delegate = LazyKt.lazy(HotFlowFragment$handler$2.INSTANCE);
    private final FragmentData intent$delegate = new FragmentData("ARGUMENTS_KEY_INTENT");
    private final Lazy intentData$delegate = BdPlayerUtils.lazyNone(new HotFlowFragment$intentData$2(this));
    /* access modifiers changed from: private */
    public boolean isOnPanelSlide;
    private final Lazy multiWindowService$delegate = BdPlayerUtils.lazyNone(new HotFlowFragment$multiWindowService$2(this));
    private final Lazy store$delegate = LazyKt.lazy(new HotFlowFragment$store$2(this));
    private final Lazy videoBusiness$delegate = BdPlayerUtils.lazyNone(new HotFlowFragment$videoBusiness$2(this));

    @JvmStatic
    public static final HotFlowFragment newInstance(Intent intent) {
        return Companion.newInstance(intent);
    }

    /* access modifiers changed from: private */
    public final Intent getIntent() {
        return (Intent) this.intent$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final VideoBusiness getVideoBusiness() {
        return (VideoBusiness) this.videoBusiness$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final IntentData getIntentData() {
        return (IntentData) this.intentData$delegate.getValue();
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ComponentArchManager getComponentManager() {
        return (ComponentArchManager) this.componentManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AbsStore<CommonState> getStore() {
        return (AbsStore) this.store$delegate.getValue();
    }

    private final VideoFlowSlideIntercept getFlowSlideIntercept() {
        return (VideoFlowSlideIntercept) this.flowSlideIntercept$delegate.getValue();
    }

    private final DownloadProcessManager getDownloadProcessManager() {
        return (DownloadProcessManager) this.downloadProcessManager$delegate.getValue();
    }

    private final MultiWindowImpl getMultiWindowService() {
        return (MultiWindowImpl) this.multiWindowService$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/hotflow/fragment/HotFlowFragment$Companion;", "", "()V", "newInstance", "Lcom/baidu/searchbox/video/hotflow/fragment/HotFlowFragment;", "intent", "Landroid/content/Intent;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HotFlowFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HotFlowFragment newInstance(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            HotFlowFragment $this$newInstance_u24lambda_u2d1 = new HotFlowFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGUMENTS_KEY_INTENT", intent);
            $this$newInstance_u24lambda_u2d1.setArguments(bundle);
            return $this$newInstance_u24lambda_u2d1;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        IntentData intentData = getIntentData();
        String str = intentData != null ? intentData.nid : null;
        if (str == null) {
            str = "";
        }
        PlayerSpeedTracker.activityOnCreateStart(str);
        registerService();
        getComponentManager().bindStore(getStore());
        ComponentArchManager componentManager = getComponentManager();
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        componentManager.configWithoutLifecycleBind(context, lifecycle, HotArchCreator.Impl.INSTANCE.get().createFactory(getVideoBusiness()));
        getComponentManager().setStateListener(this);
        setDataChannelRegister();
        View root = getComponentManager().createView();
        startFlowVideo();
        ComponentArchManager componentManager2 = getComponentManager();
        Lifecycle lifecycle2 = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycle");
        componentManager2.bindLifeCycle(lifecycle2);
        return root;
    }

    private final void registerService() {
        BiSerialDetailBaseActivity $this$registerService_u24lambda_u2d0 = getSlideActivity();
        if ($this$registerService_u24lambda_u2d0 != null) {
            getComponentManager().registerServices(IFlowActivityService.class, new FlowActivityService($this$registerService_u24lambda_u2d0));
        }
        getComponentManager().registerServices(IMultiWindowService.class, getMultiWindowService());
    }

    private final void setDataChannelRegister() {
        IDataChannelService iDataChannelService = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService != null) {
            iDataChannelService.addRegister(new CollectionMiniPraiseRegister());
        }
        IDataChannelService iDataChannelService2 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService2 != null) {
            iDataChannelService2.addRegister(new CollectionNormalPraiseRegister());
        }
        IDataChannelService iDataChannelService3 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService3 != null) {
            iDataChannelService3.addRegister(new VideoLandPraiseRegister());
        }
        IDataChannelService iDataChannelService4 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService4 != null) {
            iDataChannelService4.addRegister(new VideoFlowPraiseRegister());
        }
        IDataChannelService iDataChannelService5 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService5 != null) {
            iDataChannelService5.addRegister(new CollectionFlowCommentRegister());
        }
        IDataChannelService iDataChannelService6 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService6 != null) {
            iDataChannelService6.addRegister(new VideoFlowCommentRegister());
        }
        IDataChannelService iDataChannelService7 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService7 != null) {
            iDataChannelService7.addRegister(new CollectionFlowFollowRegister());
        }
        IDataChannelService iDataChannelService8 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService8 != null) {
            iDataChannelService8.addRegister(new VideoFlowFollowRegister());
        }
        IDataChannelService iDataChannelService9 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService9 != null) {
            iDataChannelService9.addRegister(new CollectionFlowShareRegister());
        }
        IDataChannelService iDataChannelService10 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService10 != null) {
            iDataChannelService10.addRegister(new FlowPayRegister());
        }
        IDataChannelService iDataChannelService11 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService11 != null) {
            iDataChannelService11.addRegister(new CollectionFlowChatroomRegister());
        }
        IDataChannelService iDataChannelService12 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService12 != null) {
            iDataChannelService12.addRegister(new TalosPanelRegister());
        }
        IDataChannelService iDataChannelService13 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService13 != null) {
            iDataChannelService13.addRegister(new CollectionTaskRegister());
        }
        IDataChannelService iDataChannelService14 = (IDataChannelService) getComponentManager().getService(IDataChannelService.class);
        if (iDataChannelService14 != null) {
            iDataChannelService14.addRegister(new ChallengeViewRegister());
        }
    }

    private final void startFlowVideo() {
        Intent intent;
        try {
            if (getIntentData() == null && (intent = getIntent()) != null) {
                IntextDataExtKt.parseFeedIntentData(intent, true);
            }
            IntentData intentData = getIntentData();
            if (intentData != null) {
                VideoFlowSchemeUtilsKt.configLaunchSource(intentData, getIntent());
            }
            IntentData intentData2 = getIntentData();
            if (intentData2 != null) {
                VideoFlowSchemeUtilsKt.configLaunchMode(intentData2, getIntent());
            }
            VideoFlowSchemeUtilsKt.configState(getStore(), getIntentData());
            getStore().dispatch(new CoreAction.NewIntent(getIntentData()));
            getStore().dispatch(new PostIntentAction(getIntent()));
        } catch (Exception exc) {
            getHandler().post(new HotFlowFragment$$ExternalSyntheticLambda1(this, exc));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startFlowVideo$lambda-1  reason: not valid java name */
    public static final void m7072startFlowVideo$lambda1(HotFlowFragment this$0, Exception $exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($exc, "$exc");
        this$0.dispatchExcAction($exc);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        GoHomeState goHomeState;
        MutableLiveData<Unit> goHomeAction;
        super.onActivityCreated(savedInstanceState);
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        String str = null;
        HotFlowActivity $this$onActivityCreated_u24lambda_u2d2 = slideActivity instanceof HotFlowActivity ? (HotFlowActivity) slideActivity : null;
        if ($this$onActivityCreated_u24lambda_u2d2 != null) {
            $this$onActivityCreated_u24lambda_u2d2.registerListener(this);
        }
        BiSerialDetailBaseActivity $this$onActivityCreated_u24lambda_u2d4 = getSlideActivity();
        if (!($this$onActivityCreated_u24lambda_u2d4 == null || (goHomeState = (GoHomeState) getStore().subscribe(GoHomeState.class)) == null || (goHomeAction = goHomeState.getGoHomeAction()) == null)) {
            goHomeAction.observe($this$onActivityCreated_u24lambda_u2d4, new HotFlowFragment$$ExternalSyntheticLambda0(this));
        }
        getStore().subscribe(ColdLaunchRestoreState.class);
        ILeftSlidePersonPageService $this$onActivityCreated_u24lambda_u2d5 = (ILeftSlidePersonPageService) getComponentManager().getService(ILeftSlidePersonPageService.class);
        if ($this$onActivityCreated_u24lambda_u2d5 != null) {
            $this$onActivityCreated_u24lambda_u2d5.addLeftSlidePersonPageListener(this);
        }
        IntentData intentData = getIntentData();
        if (intentData != null) {
            str = intentData.nid;
        }
        if (str == null) {
            str = "";
        }
        PlayerSpeedTracker.activityOnCreateEnd(str);
        addSlideExtraListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-4$lambda-3  reason: not valid java name */
    public static final void m7071onActivityCreated$lambda4$lambda3(HotFlowFragment this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DIFactory.postDelayed$default(DIFactory.INSTANCE, new HotFlowFragment$onActivityCreated$2$1$1(this$0), 190, (Object) null, 4, (Object) null);
        BiSerialDetailBaseActivity slideActivity = this$0.getSlideActivity();
        if (slideActivity != null) {
            slideActivity.finish(2);
        }
    }

    public void onStart() {
        super.onStart();
        getDownloadProcessManager().registerDownloadReceiver(false);
    }

    public void onResume() {
        super.onResume();
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        boolean z = true;
        if (slideActivity == null || !slideActivity.isDrawerClosed()) {
            z = false;
        }
        if (z) {
            dispatchActive();
        }
        getMultiWindowService().onResume();
    }

    public void onPause() {
        super.onPause();
        dispatchInactive();
    }

    public void onStop() {
        super.onStop();
        getDownloadProcessManager().unregisterDownloadReceiver();
    }

    public void onDestroy() {
        super.onDestroy();
        ITouchEventListenerService iTouchEventListenerService = (ITouchEventListenerService) getComponentManager().getService(ITouchEventListenerService.class);
        if (iTouchEventListenerService != null) {
            iTouchEventListenerService.clearAllListener();
        }
        IDetailItemCoreEventService iDetailItemCoreEventService = (IDetailItemCoreEventService) getComponentManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService != null) {
            iDetailItemCoreEventService.clearAllListener();
        }
        State state = getStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(IntentData.class);
        }
        IntentData intentData = (IntentData) obj;
        if (intentData != null ? Intrinsics.areEqual((Object) intentData.isColdLaunchRestore, (Object) true) : false) {
            VideoFlowUBCHelper.INSTANCE.tryUploadColdLaunchStatistic(false);
        }
        getStore().dispatch(OnActivityDestroy.INSTANCE);
        dispatchInactive();
        GuidePriorityHelper.INSTANCE.release();
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getComponentManager().dispatchNewIntent(intent);
    }

    public void setEnableSlide() {
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.setEnableSliding(true, getFlowSlideIntercept());
        }
    }

    public boolean canSlideFinish(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return getFlowSlideIntercept().isSlidable(event);
    }

    public boolean canSlideDrawer(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return getFlowSlideIntercept().canSlideDrawer(event);
    }

    public void onDragBegin() {
        getStore().dispatch(ActivityAnimation.DragBegin.INSTANCE);
    }

    public void onDragReset() {
        getStore().dispatch(ActivityAnimation.Reset.INSTANCE);
    }

    public void dispatchTouchEvent(MotionEvent ev, HeatMapHelper heatMapHelper) {
        ITouchEventListenerService iTouchEventListenerService = (ITouchEventListenerService) getComponentManager().getService(ITouchEventListenerService.class);
        if (iTouchEventListenerService != null) {
            iTouchEventListenerService.dispatch(ev);
        }
        State state = getStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(LeftSlidePersonPageState.class);
        }
        LeftSlidePersonPageState leftSlidePersonPageState = (LeftSlidePersonPageState) obj;
        boolean z = true;
        if (!(leftSlidePersonPageState != null && leftSlidePersonPageState.isOpened())) {
            if (ev != null && ev.getAction() == 0) {
                getStore().dispatch(new DispatchTouchDownEvent(ev));
            }
            if (ev == null || ev.getAction() != 1) {
                z = false;
            }
            if (z) {
                getStore().dispatch(new DispatchTouchUpEvent(ev));
            }
        }
    }

    public void onDrawerClosed() {
        getStore().dispatch(LeftSlideAction.DrawerClosedAction.INSTANCE);
        dispatchActive();
    }

    public void onDrawerOpened() {
        getStore().dispatch(LeftSlideAction.DrawerOpenedAction.INSTANCE);
        dispatchInactive();
    }

    public void uploadBackStatistic(String type) {
        CommonItemData commonItemData;
        CommonItemData commonItemData2;
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            IFlowComponentService iFlowComponentService = (IFlowComponentService) getComponentManager().getService(IFlowComponentService.class);
            Object obj = null;
            ItemModel curItemModel = iFlowComponentService != null ? iFlowComponentService.getCurItemModel() : null;
            String ext = (curItemModel == null || (commonItemData2 = curItemModel.getCommonItemData()) == null) ? null : commonItemData2.getExt();
            if (ext == null) {
                ext = "";
            }
            JSONObject mergeExt = UbcExtBeanKt.mergeExt((curItemModel == null || (commonItemData = curItemModel.getCommonItemData()) == null) ? null : commonItemData.getExtLog(), ext);
            State state = getStore().getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(UbcBean.class);
            }
            UbcBean $this$uploadBackStatistic_u24lambda_u2d6 = (UbcBean) obj;
            if ($this$uploadBackStatistic_u24lambda_u2d6 != null) {
                JSONObject createCustomExt = DIFactory.INSTANCE.createCustomExt();
                createCustomExt.putOpt(IVideoToolBarUtils.SESSION_ID, IVideoToolBarUtils.Impl.get().getSessionId());
                createCustomExt.putOpt(IVideoToolBarUtils.CLICK_ID, IVideoToolBarUtils.Impl.get().getClickId());
                UbcExtBean ubcExtBean = new UbcExtBean("206", UbcBean.copy$default($this$uploadBackStatistic_u24lambda_u2d6, "tool", (String) null, (String) null, type, (String) null, 22, (Object) null), mergeExt.toString(), createCustomExt.toString());
                VideoFlowUBCHelper.INSTANCE.getUbc().onEvent(ubcExtBean.getId(), ubcExtBean.toJson());
            }
        } catch (Exception e2) {
        }
    }

    public void uploadTopBackStatistic(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        getStore().dispatch(GestureBackAction.INSTANCE);
    }

    public void dispatchAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        getStore().dispatch(action);
    }

    public PageRestoreData getRestoreData() {
        State state = getStore().getState();
        String scheme = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        ColdLaunchRestoreState coldLaunchRestoreState = (ColdLaunchRestoreState) (commonState != null ? commonState.select(ColdLaunchRestoreState.class) : null);
        if (coldLaunchRestoreState != null) {
            scheme = coldLaunchRestoreState.getColdLaunchScheme();
        }
        if (scheme == null) {
            scheme = "";
        }
        return new PageRestoreData(scheme, 100);
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        getStore().dispatch(new NightModeChanged(isNightMode));
    }

    public void onConfigurationChanged(Configuration newConfig) {
        FragmentActivity $this$onConfigurationChanged_u24lambda_u2d7;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        getComponentManager().dispatchConfigurationChanged(newConfig);
        if (newConfig.orientation == 1 && ($this$onConfigurationChanged_u24lambda_u2d7 = getActivity()) != null) {
            VideoImmersionUtils.setupNavBarStyleImmersiveStickyWithLightStatusBar($this$onConfigurationChanged_u24lambda_u2d7);
        }
        getStore().dispatch(new ConfigurationChangedAction(newConfig));
        getMultiWindowService().onConfigurationChanged(newConfig);
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        getMultiWindowService().setMultiWindowMode(isInMultiWindowMode);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event == null || !getComponentManager().dispatchKeyDown(keyCode, event)) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getComponentManager().dispatchActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        getComponentManager().dispatchRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public boolean onActivityKeyDown(int keyCode, KeyEvent event) {
        return onKeyDown(keyCode, event);
    }

    public void onActivityBackPressed() {
        onBackPressed();
    }

    public boolean onBackPressed() {
        if (TopBackUtilsKt.isTopBackSwitch()) {
            uploadTopBackStatistic(SlipBackAction.INSTANCE);
        } else {
            uploadBackStatistic("key");
        }
        return super.onBackPressed();
    }

    public void onExit() {
        DIFactory.INSTANCE.post(new HotFlowFragment$onExit$1(this));
    }

    private final void dispatchInactive() {
        getComponentManager().dispatchActive(false);
    }

    private final void dispatchActive() {
        getComponentManager().dispatchActive(true);
    }

    private final void dispatchExcAction(Exception exc) {
        getStore().dispatch(new ExcAction(exc));
    }

    public void openLeftSlideDrawer() {
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.openDrawer();
        }
    }

    public void closeLeftSlideDrawer() {
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.closeDrawer();
        }
    }

    public void addLeftSlideDrawerContent(View content, ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(lp, "lp");
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.addDrawerContent(content, lp);
        }
    }

    public void setLeftSlideDrawerSlideEnable(boolean enable) {
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.setDrawerSlideEnable(enable);
        }
    }

    private final void addSlideExtraListener() {
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (slideActivity != null) {
            slideActivity.setSlideExtraListener(new HotFlowFragment$addSlideExtraListener$1(this));
        }
    }

    private final BiSerialDetailBaseActivity getSlideActivity() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BiSerialDetailBaseActivity) {
            return (BiSerialDetailBaseActivity) activity;
        }
        return null;
    }

    public SystemScreenshotContentBean getSystemScreenshotContent() {
        ICommonShareService iCommonShareService;
        ShareModel shareInfo;
        BiSerialDetailBaseActivity slideActivity = getSlideActivity();
        if (BdPlayerUtils.orFalse(slideActivity != null ? Boolean.valueOf(slideActivity.isDrawerOpened()) : null) || (iCommonShareService = (ICommonShareService) getComponentManager().getService(ICommonShareService.class)) == null || (shareInfo = iCommonShareService.getShareInfo()) == null) {
            return null;
        }
        return ShareModelKt.toSystemScreenshotInfo(shareInfo);
    }
}
