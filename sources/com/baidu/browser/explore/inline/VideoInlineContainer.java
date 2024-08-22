package com.baidu.browser.explore.inline;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.explore.inline.model.InlineModel;
import com.baidu.browser.explore.inline.view.LinkageContainerView;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.explore.tab.na.utils.CkHelper;
import com.baidu.browser.tabna.IResultPageTabContext;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.search.mix.component.APageTcComponent;
import com.baidu.searchbox.search.mix.frame.VideoMixComponentFactory;
import com.baidu.searchbox.search.mix.utils.VideoMixTcManager;
import com.baidu.searchbox.search.tab.core.component.Component;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.core.manager.IDataManager;
import com.baidu.searchbox.search.tab.core.manager.IServiceManager;
import com.baidu.searchbox.search.tab.core.message.EventMessage;
import com.baidu.searchbox.search.tab.core.message.MessageBus;
import com.baidu.searchbox.search.tab.core.message.UBCMessage;
import com.baidu.searchbox.search.tab.implement.ComponentManager;
import com.baidu.searchbox.search.tab.implement.VideoListDataManager;
import com.baidu.searchbox.search.tab.implement.service.IAPageTcService;
import com.baidu.searchbox.search.tab.implement.service.IInlineNaContainerService;
import com.baidu.searchbox.search.tab.implement.service.ITagSearchViewService;
import com.baidu.searchbox.search.tab.implement.service.IVideoListViewService;
import com.baidu.searchbox.search.tab.implement.view.VideoCommonListPage;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@AB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u0004\u0018\u00010!J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0012\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020-H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0018H\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\u0012\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0016J,\u00108\u001a\u00020\u001d2\"\u00109\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0:j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`;H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\b\u0010=\u001a\u00020\u001dH\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/baidu/browser/explore/inline/VideoInlineContainer;", "Lcom/baidu/browser/explore/inline/BaseInlineContainer;", "Lcom/baidu/browser/explore/inline/model/InlineModel;", "context", "Landroid/content/Context;", "dataModel", "resultPageTabContext", "Lcom/baidu/browser/tabna/IResultPageTabContext;", "(Landroid/content/Context;Lcom/baidu/browser/explore/inline/model/InlineModel;Lcom/baidu/browser/tabna/IResultPageTabContext;)V", "abandonFocusRunnable", "Ljava/lang/Runnable;", "componentManager", "Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "getComponentManager", "()Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "setComponentManager", "(Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;)V", "dataManager", "Lcom/baidu/searchbox/search/tab/implement/VideoListDataManager;", "getDataManager", "()Lcom/baidu/searchbox/search/tab/implement/VideoListDataManager;", "dataManager$delegate", "Lkotlin/Lazy;", "isResume", "", "lastVisibleTime", "", "visibleTimeSum", "clearRecycleView", "", "getLinkageRecycleScrollLisener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getLinkageRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getNaRecycleView", "isSlidable", "motionEvent", "Landroid/view/MotionEvent;", "onDestroy", "onHandleInsertNaProtoData", "data", "", "onHandleNaProtoData", "onLinkageFingerTouch", "touchAciton", "", "onLinkageScrollChanged", "scrollSumY", "onLinkageScrollStateChanged", "scrollState", "onNightModeChanged", "nightMode", "onPause", "onResume", "intent", "Landroid/content/Intent;", "onSaveAPageInfo", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onStop", "onVoiceSearchPanelDismiss", "onVoiceSearchPanelShow", "updateContext", "InlineNaContainerService", "VideoLoftContainerComponent", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoInlineContainer.kt */
public final class VideoInlineContainer extends BaseInlineContainer<InlineModel> {
    /* access modifiers changed from: private */
    public Runnable abandonFocusRunnable;
    private IComponentManager componentManager;
    private final Lazy dataManager$delegate = LazyKt.lazy(VideoInlineContainer$dataManager$2.INSTANCE);
    private boolean isResume;
    private long lastVisibleTime;
    private long visibleTimeSum;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoInlineContainer(Context context, InlineModel dataModel, IResultPageTabContext resultPageTabContext) {
        super(context, dataModel, resultPageTabContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        this.componentManager = new ComponentManager(context, this, new VideoMixComponentFactory());
        this.componentManager.setDataManager(getDataManager());
        this.componentManager.registerComponent(new VideoLoftContainerComponent());
        VideoMixTcManager.INSTANCE.setUserAgent(NaRequestManager.INSTANCE.getUserAgentString());
        this.componentManager.registerComponent(new APageTcComponent());
        IAPageTcService iAPageTcService = (IAPageTcService) this.componentManager.getService(IAPageTcService.class);
        if (iAPageTcService != null) {
            iAPageTcService.onSaveUA(NaRequestManager.INSTANCE.getUserAgentString());
        }
    }

    public final IComponentManager getComponentManager() {
        return this.componentManager;
    }

    public final void setComponentManager(IComponentManager iComponentManager) {
        Intrinsics.checkNotNullParameter(iComponentManager, "<set-?>");
        this.componentManager = iComponentManager;
    }

    private final VideoListDataManager getDataManager() {
        return (VideoListDataManager) this.dataManager$delegate.getValue();
    }

    public RecyclerView getLinkageRecycleView() {
        VideoCommonListPage loftListPage;
        if (getMLinkageRecycleView() == null) {
            IComponentManager iComponentManager = this.componentManager;
            LinkageContainerView mRootView = getMRootView();
            if (mRootView != null) {
                iComponentManager.setContentView(mRootView);
                RecyclerView recyclerView = null;
                if (this.isResume) {
                    this.componentManager.sendMessage(new EventMessage(4, (Object) null));
                }
                IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
                if (!(iVideoListViewService == null || (loftListPage = iVideoListViewService.getLoftListPage()) == null)) {
                    recyclerView = loftListPage.getRecyclerView();
                }
                setMLinkageRecycleView(recyclerView);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
        }
        return getMLinkageRecycleView();
    }

    public final void clearRecycleView() {
        this.componentManager.sendMessage(new EventMessage(22, (Object) null));
    }

    private final RecyclerView.OnScrollListener getLinkageRecycleScrollLisener() {
        VideoCommonListPage loftListPage;
        IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
        if (iVideoListViewService == null || (loftListPage = iVideoListViewService.getLoftListPage()) == null) {
            return null;
        }
        return loftListPage.getOnScrollListener();
    }

    public void onLinkageFingerTouch(int touchAciton) {
        VideoCommonListPage loftListPage;
        super.onLinkageFingerTouch(touchAciton);
        IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
        if (iVideoListViewService != null && (loftListPage = iVideoListViewService.getLoftListPage()) != null) {
            loftListPage.onLinkageFingerTouch(touchAciton);
        }
    }

    public void onLinkageScrollStateChanged(int scrollState) {
        VideoCommonListPage loftListPage;
        super.onLinkageScrollStateChanged(scrollState);
        IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
        if (iVideoListViewService != null && (loftListPage = iVideoListViewService.getLoftListPage()) != null) {
            loftListPage.onLinkageScrollStateChanged(scrollState);
        }
    }

    public void onLinkageScrollChanged(int scrollSumY) {
        VideoCommonListPage loftListPage;
        super.onLinkageScrollChanged(scrollSumY);
        IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
        if (iVideoListViewService != null && (loftListPage = iVideoListViewService.getLoftListPage()) != null) {
            loftListPage.onLinkageScrollChanged(scrollSumY);
        }
    }

    public void onSaveAPageInfo(HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        super.onSaveAPageInfo(map);
        IAPageTcService iAPageTcService = (IAPageTcService) this.componentManager.getService(IAPageTcService.class);
        if (iAPageTcService != null) {
            iAPageTcService.onSaveAPageInfo(map);
        }
    }

    public void onHandleNaProtoData(String data) {
        super.onHandleNaProtoData(data);
        IDataManager.Callback callback = getDataManager().getCallback();
        if (callback != null) {
            callback.onRequestSuccess(20, data);
        }
        this.lastVisibleTime = System.currentTimeMillis();
        this.visibleTimeSum = 0;
    }

    public void onHandleInsertNaProtoData(String data) {
        super.onHandleNaProtoData(data);
        IDataManager.Callback callback = getDataManager().getCallback();
        if (callback != null) {
            callback.onRequestSuccess(21, data);
        }
    }

    public void onResume(Intent intent) {
        this.lastVisibleTime = System.currentTimeMillis();
        super.onResume(intent);
        this.isResume = true;
        this.componentManager.sendMessage(new EventMessage(4, (Object) null));
    }

    public void onPause() {
        this.visibleTimeSum += System.currentTimeMillis() - this.lastVisibleTime;
        super.onPause();
        this.isResume = false;
        this.componentManager.sendMessage(new EventMessage(3, (Object) null));
    }

    public void onStop() {
        super.onStop();
        this.isResume = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.isResume = false;
    }

    public void onVoiceSearchPanelDismiss() {
        super.onVoiceSearchPanelDismiss();
        this.componentManager.sendMessage(new EventMessage(4, (Object) null));
    }

    public void onVoiceSearchPanelShow() {
        super.onVoiceSearchPanelShow();
        this.componentManager.sendMessage(new EventMessage(3, (Object) null));
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (motionEvent != null) {
            IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
            if (iVideoListViewService != null) {
                z = !iVideoListViewService.isSlidAble(motionEvent);
            } else {
                z = false;
            }
            if (!z) {
                ITagSearchViewService iTagSearchViewService = (ITagSearchViewService) this.componentManager.getService(ITagSearchViewService.class);
                if (iTagSearchViewService != null) {
                    z2 = !iTagSearchViewService.isSlidAble(motionEvent);
                } else {
                    z2 = false;
                }
                if (z2) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final RecyclerView getNaRecycleView() {
        VideoCommonListPage loftListPage;
        IVideoListViewService iVideoListViewService = (IVideoListViewService) this.componentManager.getService(IVideoListViewService.class);
        if (iVideoListViewService == null || (loftListPage = iVideoListViewService.getLoftListPage()) == null) {
            return null;
        }
        return loftListPage.getRecyclerView();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/browser/explore/inline/VideoInlineContainer$VideoLoftContainerComponent;", "Lcom/baidu/searchbox/search/tab/core/component/Component;", "(Lcom/baidu/browser/explore/inline/VideoInlineContainer;)V", "dispatchMessage", "", "message", "Lcom/baidu/searchbox/search/tab/core/message/IMessage;", "getComponentName", "Ljava/lang/Class;", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "getQuery", "", "registerServices", "serviceManager", "Lcom/baidu/searchbox/search/tab/core/manager/IServiceManager;", "subscribe", "messageBus", "Lcom/baidu/searchbox/search/tab/core/message/MessageBus;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoInlineContainer.kt */
    public final class VideoLoftContainerComponent extends Component {
        public VideoLoftContainerComponent() {
        }

        public Class<? extends IComponent> getComponentName() {
            return VideoLoftContainerComponent.class;
        }

        public void registerServices(IServiceManager serviceManager) {
            Intrinsics.checkNotNullParameter(serviceManager, "serviceManager");
            super.registerServices(serviceManager);
            serviceManager.registerService(IInlineNaContainerService.class, new VideoInlineContainer$VideoLoftContainerComponent$registerServices$1(VideoInlineContainer.this));
        }

        public void subscribe(MessageBus messageBus) {
            Intrinsics.checkNotNullParameter(messageBus, "messageBus");
            messageBus.subscribe(UBCMessage.class, this);
            messageBus.subscribe(EventMessage.class, this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: type inference failed for: r2v13 */
        /* JADX WARNING: type inference failed for: r2v23 */
        /* JADX WARNING: type inference failed for: r2v34 */
        /* JADX WARNING: type inference failed for: r2v57 */
        /* JADX WARNING: type inference failed for: r2v65 */
        /* JADX WARNING: type inference failed for: r2v66 */
        /* JADX WARNING: type inference failed for: r2v67 */
        /* JADX WARNING: type inference failed for: r2v68 */
        /* JADX WARNING: type inference failed for: r2v69 */
        /* JADX WARNING: type inference failed for: r2v70 */
        /* JADX WARNING: type inference failed for: r2v71 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatchMessage(com.baidu.searchbox.search.tab.core.message.IMessage r11) {
            /*
                r10 = this;
                java.lang.String r0 = "message"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                boolean r0 = r11 instanceof com.baidu.searchbox.search.tab.core.message.EventMessage
                if (r0 == 0) goto L_0x03a4
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                int r0 = r0.getWhat()
                java.lang.String r1 = "searchInline"
                r2 = 0
                r3 = 0
                r4 = 1
                switch(r0) {
                    case 1: goto L_0x036d;
                    case 2: goto L_0x0019;
                    case 3: goto L_0x0019;
                    case 4: goto L_0x0019;
                    case 5: goto L_0x0361;
                    case 6: goto L_0x0334;
                    case 7: goto L_0x0304;
                    case 8: goto L_0x0019;
                    case 9: goto L_0x02b9;
                    case 10: goto L_0x0019;
                    case 11: goto L_0x026c;
                    case 12: goto L_0x0216;
                    case 13: goto L_0x0209;
                    case 14: goto L_0x0019;
                    case 15: goto L_0x0019;
                    case 16: goto L_0x017a;
                    case 17: goto L_0x0152;
                    case 18: goto L_0x00fb;
                    case 19: goto L_0x0082;
                    case 20: goto L_0x0067;
                    case 21: goto L_0x001b;
                    default: goto L_0x0019;
                }
            L_0x0019:
                goto L_0x03a4
            L_0x001b:
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                java.lang.Object r0 = r0.getObj()
                boolean r5 = r0 instanceof java.lang.String
                if (r5 == 0) goto L_0x0029
                r2 = r0
                java.lang.String r2 = (java.lang.String) r2
            L_0x0029:
                r0 = r2
                boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r2 == 0) goto L_0x0047
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "topTag TOP_TAG_CLICK url="
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r1, r2)
            L_0x0047:
                if (r0 == 0) goto L_0x0058
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0054
                r1 = r4
                goto L_0x0055
            L_0x0054:
                r1 = r3
            L_0x0055:
                if (r1 != r4) goto L_0x0058
                r3 = r4
            L_0x0058:
                if (r3 == 0) goto L_0x03a4
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x03a4
                r1.onNaTopTagClick(r0)
                goto L_0x03a4
            L_0x0067:
                boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r0 == 0) goto L_0x0072
                java.lang.String r0 = "VideoInlineContainer CONTENT_SHOW"
                android.util.Log.v(r1, r0)
            L_0x0072:
                android.os.Handler r0 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda0 r2 = new com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda0
                r2.<init>(r1)
                r0.post(r2)
                goto L_0x03a4
            L_0x0082:
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                java.lang.Object r0 = r0.getObj()
                boolean r5 = r0 instanceof java.lang.String
                if (r5 == 0) goto L_0x0090
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0091
            L_0x0090:
                r0 = r2
            L_0x0091:
                boolean r5 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r5 == 0) goto L_0x00ad
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "VideoInlineContainer CLICK_SEARCH_TIPS url="
                java.lang.StringBuilder r5 = r5.append(r6)
                java.lang.StringBuilder r5 = r5.append(r0)
                java.lang.String r5 = r5.toString()
                android.util.Log.v(r1, r5)
            L_0x00ad:
                r1 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r1 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r1
                java.util.Map r1 = r1.getMap()
                if (r1 == 0) goto L_0x00bd
                java.lang.String r5 = "action"
                java.lang.Object r1 = r1.get(r5)
                goto L_0x00be
            L_0x00bd:
                r1 = r2
            L_0x00be:
                boolean r5 = r1 instanceof java.lang.Integer
                if (r5 == 0) goto L_0x00c5
                r2 = r1
                java.lang.Integer r2 = (java.lang.Integer) r2
            L_0x00c5:
                if (r2 == 0) goto L_0x00cc
                int r1 = r2.intValue()
                goto L_0x00cd
            L_0x00cc:
                r1 = -1
            L_0x00cd:
                if (r0 == 0) goto L_0x00de
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                if (r2 <= 0) goto L_0x00da
                r2 = r4
                goto L_0x00db
            L_0x00da:
                r2 = r3
            L_0x00db:
                if (r2 != r4) goto L_0x00de
                r3 = r4
            L_0x00de:
                if (r3 == 0) goto L_0x03a4
                com.baidu.browser.explore.inline.VideoInlineContainer r2 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r2 = r2.getMResultPageContext()
                if (r2 == 0) goto L_0x00eb
                r2.onNaItemRefreshSearchTip(r0, r1)
            L_0x00eb:
                android.os.Handler r2 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                com.baidu.browser.explore.inline.VideoInlineContainer r3 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda2 r4 = new com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda2
                r4.<init>(r3)
                r2.post(r4)
                goto L_0x03a4
            L_0x00fb:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.searchbox.browserenhanceengine.container.ContainerModel r0 = r0.containerModel
                com.baidu.browser.explore.inline.model.InlineModel r0 = (com.baidu.browser.explore.inline.model.InlineModel) r0
                if (r0 == 0) goto L_0x0150
                java.lang.String r0 = r0.getUrl()
                if (r0 == 0) goto L_0x0150
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                r3 = 0
                r4 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r4 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r4
                java.util.Map r4 = r4.getMap()
                if (r4 == 0) goto L_0x011e
                java.lang.String r5 = "cardIndex"
                java.lang.Object r4 = r4.get(r5)
                goto L_0x011f
            L_0x011e:
                r4 = r2
            L_0x011f:
                boolean r5 = r4 instanceof java.lang.Integer
                if (r5 == 0) goto L_0x0126
                java.lang.Integer r4 = (java.lang.Integer) r4
                goto L_0x0127
            L_0x0126:
                r4 = r2
            L_0x0127:
                r5 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r5 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r5
                java.util.Map r5 = r5.getMap()
                if (r5 == 0) goto L_0x0138
                java.lang.String r6 = "reason"
                java.lang.Object r5 = r5.get(r6)
                goto L_0x0139
            L_0x0138:
                r5 = r2
            L_0x0139:
                boolean r6 = r5 instanceof java.lang.String
                if (r6 == 0) goto L_0x0140
                r2 = r5
                java.lang.String r2 = (java.lang.String) r2
            L_0x0140:
                if (r4 == 0) goto L_0x014f
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x014f
                int r5 = r4.intValue()
                r1.onNaCardRenderFail(r0, r5, r2)
            L_0x014f:
            L_0x0150:
                goto L_0x03a4
            L_0x0152:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.searchbox.browserenhanceengine.container.ContainerModel r0 = r0.containerModel
                com.baidu.browser.explore.inline.model.InlineModel r0 = (com.baidu.browser.explore.inline.model.InlineModel) r0
                if (r0 == 0) goto L_0x0178
                java.lang.String r0 = r0.getUrl()
                if (r0 == 0) goto L_0x0178
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                r2 = 0
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x0177
                long r3 = java.lang.System.currentTimeMillis()
                java.lang.Long r3 = java.lang.Long.valueOf(r3)
                r1.onNaFirstImageScreenPaint(r0, r3)
            L_0x0177:
            L_0x0178:
                goto L_0x03a4
            L_0x017a:
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "ubcId"
                java.lang.String r5 = "5769"
                r0.put(r1, r5)
                org.json.JSONObject r1 = new org.json.JSONObject
                r1.<init>()
                java.lang.String r5 = "value"
                java.lang.String r6 = "recommend_video_normal"
                r1.put(r5, r6)
                java.lang.String r5 = "type"
                java.lang.String r6 = "fp_perf_new"
                r1.put(r5, r6)
                r5 = 0
                java.lang.String r5 = "se_video_a_na"
                r6 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r6 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r6
                java.util.Map r6 = r6.getMap()
                java.lang.String r7 = "page"
                if (r6 == 0) goto L_0x01cd
                java.lang.Object r6 = r6.get(r7)
                if (r6 == 0) goto L_0x01cd
                r8 = 0
                boolean r9 = r6 instanceof java.lang.String
                if (r9 == 0) goto L_0x01ba
                r2 = r6
                java.lang.String r2 = (java.lang.String) r2
            L_0x01ba:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L_0x01c4
                boolean r2 = kotlin.text.StringsKt.isBlank(r2)
                if (r2 == 0) goto L_0x01c5
            L_0x01c4:
                r3 = r4
            L_0x01c5:
                if (r3 != 0) goto L_0x01cc
                java.lang.String r2 = r6.toString()
                r5 = r2
            L_0x01cc:
            L_0x01cd:
                r1.put(r7, r5)
                java.lang.String r2 = "from"
                java.lang.String r3 = "search"
                r1.put(r2, r3)
                java.lang.String r2 = "dim"
                r0.put(r2, r1)
                org.json.JSONObject r2 = new org.json.JSONObject
                r2.<init>()
                java.lang.String r3 = "os"
                java.lang.String r4 = "android"
                r2.put(r3, r4)
                java.lang.String r3 = com.baidu.android.util.devices.NetWorkUtils.getNetworkClass()
                java.lang.String r4 = "network"
                r2.put(r4, r3)
                java.lang.String r3 = "ext"
                r0.put(r3, r2)
                com.baidu.browser.explore.inline.VideoInlineContainer r3 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r3 = r3.getMResultPageContext()
                if (r3 == 0) goto L_0x03a4
                java.lang.String r4 = r0.toString()
                r3.onNaVideoPlayerFirstPlay(r4)
                goto L_0x03a4
            L_0x0209:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                kotlin.jvm.functions.Function0 r0 = r0.getOnPageShowHighChange()
                if (r0 == 0) goto L_0x03a4
                r0.invoke()
                goto L_0x03a4
            L_0x0216:
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                java.lang.Object r0 = r0.getObj()
                boolean r5 = r0 instanceof java.lang.String
                if (r5 == 0) goto L_0x0224
                r2 = r0
                java.lang.String r2 = (java.lang.String) r2
            L_0x0224:
                r0 = r2
                boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r2 == 0) goto L_0x0241
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "VideoInlineContainer ADVFILTER_CANCEL url="
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r1, r2)
            L_0x0241:
                if (r0 == 0) goto L_0x0252
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x024e
                r1 = r4
                goto L_0x024f
            L_0x024e:
                r1 = r3
            L_0x024f:
                if (r1 != r4) goto L_0x0252
                r3 = r4
            L_0x0252:
                if (r3 == 0) goto L_0x03a4
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x025f
                r1.onNaItemRefreshUrl(r0)
            L_0x025f:
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x03a4
                r1.onNaItemAdvanceFilter()
                goto L_0x03a4
            L_0x026c:
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                java.lang.Object r0 = r0.getObj()
                boolean r3 = r0 instanceof org.json.JSONObject
                if (r3 == 0) goto L_0x027a
                r2 = r0
                org.json.JSONObject r2 = (org.json.JSONObject) r2
            L_0x027a:
                r0 = r2
                boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r2 == 0) goto L_0x0297
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "VideoInlineContainer ITEM_CLICK json="
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r1, r2)
            L_0x0297:
                if (r0 == 0) goto L_0x03a4
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x03a4
                java.lang.String r2 = "iteration"
                int r2 = r0.optInt(r2)
                java.lang.String r3 = "order"
                int r3 = r0.optInt(r3)
                java.lang.String r4 = "srcid"
                java.lang.String r4 = r0.optString(r4)
                r1.onNaItemClick(r2, r3, r4)
                goto L_0x03a4
            L_0x02b9:
                r0 = r11
                com.baidu.searchbox.search.tab.core.message.EventMessage r0 = (com.baidu.searchbox.search.tab.core.message.EventMessage) r0
                java.lang.Object r0 = r0.getObj()
                boolean r5 = r0 instanceof java.lang.String
                if (r5 == 0) goto L_0x02c7
                r2 = r0
                java.lang.String r2 = (java.lang.String) r2
            L_0x02c7:
                r0 = r2
                boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r2 == 0) goto L_0x02e4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "VideoInlineContainer DISPATCH_URL url="
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r1, r2)
            L_0x02e4:
                if (r0 == 0) goto L_0x02f5
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x02f1
                r1 = r4
                goto L_0x02f2
            L_0x02f1:
                r1 = r3
            L_0x02f2:
                if (r1 != r4) goto L_0x02f5
                r3 = r4
            L_0x02f5:
                if (r3 == 0) goto L_0x03a4
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x03a4
                r1.onNaItemDispatchUrl(r0)
                goto L_0x03a4
            L_0x0304:
                boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r0 == 0) goto L_0x030f
                java.lang.String r0 = "VideoInlineContainer PLAYER_STOP"
                android.util.Log.v(r1, r0)
            L_0x030f:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                java.lang.Runnable r0 = r0.abandonFocusRunnable
                if (r0 != 0) goto L_0x0321
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda3 r1 = new com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda3
                r1.<init>(r0)
                r0.abandonFocusRunnable = r1
            L_0x0321:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                java.lang.Runnable r0 = r0.abandonFocusRunnable
                if (r0 == 0) goto L_0x03a4
                r1 = 0
                android.os.Handler r2 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                r3 = 50
                r2.postDelayed(r0, r3)
                goto L_0x03a4
            L_0x0334:
                boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r0 == 0) goto L_0x033f
                java.lang.String r0 = "VideoInlineContainer PLAYER_START"
                android.util.Log.v(r1, r0)
            L_0x033f:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                java.lang.Runnable r0 = r0.abandonFocusRunnable
                if (r0 == 0) goto L_0x0351
                r1 = 0
                android.os.Handler r2 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                r2.removeCallbacks(r0)
            L_0x0351:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                kotlin.jvm.functions.Function1 r0 = r0.getOnContainerMediaFocusChange()
                if (r0 == 0) goto L_0x03a4
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
                r0.invoke(r1)
                goto L_0x03a4
            L_0x0361:
                boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r0 == 0) goto L_0x03a4
                java.lang.String r0 = "VideoInlineContainer ERROR_PAGE_SHOW"
                android.util.Log.v(r1, r0)
                goto L_0x03a4
            L_0x036d:
                boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
                if (r0 == 0) goto L_0x0378
                java.lang.String r0 = "VideoInlineContainer PAGE_SHOW"
                android.util.Log.v(r1, r0)
            L_0x0378:
                com.baidu.browser.explore.inline.VideoInlineContainer r0 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.searchbox.browserenhanceengine.container.ContainerModel r0 = r0.containerModel
                com.baidu.browser.explore.inline.model.InlineModel r0 = (com.baidu.browser.explore.inline.model.InlineModel) r0
                if (r0 == 0) goto L_0x0395
                java.lang.String r0 = r0.getUrl()
                if (r0 == 0) goto L_0x0395
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                r2 = 0
                com.baidu.browser.tabna.IResultPageTabContext r1 = r1.getMResultPageContext()
                if (r1 == 0) goto L_0x0394
                r1.onNaFirstScreenPaintFinished(r0)
            L_0x0394:
            L_0x0395:
                android.os.Handler r0 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
                com.baidu.browser.explore.inline.VideoInlineContainer r1 = com.baidu.browser.explore.inline.VideoInlineContainer.this
                com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda1 r2 = new com.baidu.browser.explore.inline.VideoInlineContainer$VideoLoftContainerComponent$$ExternalSyntheticLambda1
                r2.<init>(r1)
                r0.post(r2)
            L_0x03a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.inline.VideoInlineContainer.VideoLoftContainerComponent.dispatchMessage(com.baidu.searchbox.search.tab.core.message.IMessage):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchMessage$lambda-0  reason: not valid java name */
        public static final void m12823dispatchMessage$lambda0(VideoInlineContainer this$02) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            Function0<Unit> onPageShowCallback = this$02.getOnPageShowCallback();
            if (onPageShowCallback != null) {
                onPageShowCallback.invoke();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchMessage$lambda-2  reason: not valid java name */
        public static final void m12824dispatchMessage$lambda2(VideoInlineContainer this$02) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            IResultPageTabContext mResultPageContext = this$02.getMResultPageContext();
            if (mResultPageContext != null) {
                mResultPageContext.stopWeakNetworkDetect();
            }
            Function0<Unit> onPageShowCallback = this$02.getOnPageShowCallback();
            if (onPageShowCallback != null) {
                onPageShowCallback.invoke();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchMessage$lambda-3  reason: not valid java name */
        public static final void m12825dispatchMessage$lambda3(VideoInlineContainer this$02) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            Function0<Unit> requestContainerResetPosition = this$02.getRequestContainerResetPosition();
            if (requestContainerResetPosition != null) {
                requestContainerResetPosition.invoke();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchMessage$lambda-5  reason: not valid java name */
        public static final void m12826dispatchMessage$lambda5(VideoInlineContainer this$02) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            Function1<Boolean, Unit> onContainerMediaFocusChange = this$02.getOnContainerMediaFocusChange();
            if (onContainerMediaFocusChange != null) {
                onContainerMediaFocusChange.invoke(false);
            }
        }

        public final String getQuery() {
            InlineModel inlineMode = VideoInlineContainer.this.getInlineMode();
            if (inlineMode != null) {
                return inlineMode.getQuery();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J8\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/browser/explore/inline/VideoInlineContainer$InlineNaContainerService;", "Lcom/baidu/searchbox/search/tab/implement/service/IInlineNaContainerService;", "(Lcom/baidu/browser/explore/inline/VideoInlineContainer;)V", "addNoStatePrefetch", "", "url", "", "referer", "buildCkValue", "rcvUrl", "adWidth", "adHeight", "adX", "adY", "screenState", "dispatchScheme", "", "scheme", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getCurrentUrl", "openUrl", "rootViewInWindow", "Landroid/graphics/Rect;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoInlineContainer.kt */
    public final class InlineNaContainerService implements IInlineNaContainerService {
        public InlineNaContainerService() {
        }

        public String getCurrentUrl() {
            IResultPageTabContext mResultPageContext = VideoInlineContainer.this.getMResultPageContext();
            String currentUrl = mResultPageContext != null ? mResultPageContext.getCurrentUrl() : null;
            return currentUrl == null ? "" : currentUrl;
        }

        public boolean openUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            IResultPageTabContext mResultPageContext = VideoInlineContainer.this.getMResultPageContext();
            if (mResultPageContext != null) {
                return mResultPageContext.onNaItemDispatchUrl(url);
            }
            return false;
        }

        public boolean dispatchScheme(String scheme, CallbackHandler handler) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            IResultPageTabContext mResultPageContext = VideoInlineContainer.this.getMResultPageContext();
            if (mResultPageContext != null) {
                return mResultPageContext.onNaItemDispatchScheme(scheme, handler);
            }
            return false;
        }

        public Rect rootViewInWindow() {
            Rect rect = new Rect();
            View it = VideoInlineContainer.this.rootView();
            if (it != null) {
                int[] location = new int[2];
                it.getLocationInWindow(location);
                rect.left = location[0] - it.getLeft();
                rect.top = location[1] - it.getTop();
                rect.right = rect.left + it.getWidth();
                rect.bottom = rect.top + it.getHeight();
            }
            return rect;
        }

        public String buildCkValue(String rcvUrl, String adWidth, String adHeight, String adX, String adY, String screenState) {
            Intrinsics.checkNotNullParameter(rcvUrl, "rcvUrl");
            Intrinsics.checkNotNullParameter(adWidth, "adWidth");
            Intrinsics.checkNotNullParameter(adHeight, "adHeight");
            Intrinsics.checkNotNullParameter(adX, "adX");
            Intrinsics.checkNotNullParameter(adY, "adY");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            return CkHelper.Companion.buildCkValue(VideoInlineContainer.this.ckHelper(), rcvUrl, adWidth, adHeight, adX, adY, screenState);
        }

        public void addNoStatePrefetch(String url, String referer) {
            IResultPageTabContext mResultPageContext;
            NgWebView resultPageWebView;
            WebView currentWebView;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(referer, "referer");
            if (!StringsKt.isBlank(url) && !StringsKt.isBlank(referer) && (mResultPageContext = VideoInlineContainer.this.getMResultPageContext()) != null && (resultPageWebView = mResultPageContext.getResultPageWebView()) != null && (currentWebView = resultPageWebView.getCurrentWebView()) != null) {
                currentWebView.addNoStatePrefetch(url, referer);
            }
        }
    }

    public void onNightModeChanged(boolean nightMode) {
        super.onNightModeChanged(nightMode);
        this.componentManager.onNightModeChanged(nightMode);
    }

    public void updateContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.updateContext(context);
        if (this.componentManager.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.componentManager.getContext()).setBaseContext(context);
        }
    }
}
