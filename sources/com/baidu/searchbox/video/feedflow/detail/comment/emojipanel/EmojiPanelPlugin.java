package com.baidu.searchbox.video.feedflow.detail.comment.emojipanel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.utils.BdNetUtils;
import com.baidu.searchbox.praise.emojiinterface.CommentViewPosition;
import com.baidu.searchbox.praise.emojiinterface.EmojiWidgetInterface;
import com.baidu.searchbox.praise.emojiinterface.EmojiWidgetRuntime;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.video.component.autoplay.AutoPlayInterceptPriority;
import com.baidu.searchbox.video.component.autoplay.OnAutoPlayInterceptCallback;
import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayInterceptorService;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.common.ITouchEventListenerService;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentModel;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentState;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentView;
import com.baidu.searchbox.video.feedflow.detail.comment.ICommentService;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.service.PageContainerService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import com.baidu.searchbox.video.service.guidepriority.GuideType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J0\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/comment/emojipanel/EmojiPanelPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "Lcom/baidu/searchbox/video/component/autoplay/OnAutoPlayInterceptCallback;", "()V", "bubbleManager", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "commentEmojiListener", "com/baidu/searchbox/video/feedflow/detail/comment/emojipanel/EmojiPanelPlugin$commentEmojiListener$1", "Lcom/baidu/searchbox/video/feedflow/detail/comment/emojipanel/EmojiPanelPlugin$commentEmojiListener$1;", "emojiWidgetInterface", "Lcom/baidu/searchbox/praise/emojiinterface/EmojiWidgetInterface;", "cancelSendAnim", "", "consumeIntercept", "", "fetchPriority", "Lcom/baidu/searchbox/video/component/autoplay/AutoPlayInterceptPriority;", "handleSendCommentResult", "isSuccess", "result", "Lcom/baidu/searchbox/comment/model/CommentBaseData;", "hideBubble", "hideEmojiPanel", "initEmojiPanel", "context", "Landroid/content/Context;", "emojiUrlList", "", "", "position", "Lcom/baidu/searchbox/praise/emojiinterface/CommentViewPosition;", "isShowEmojiAnim", "isCanShow", "isShownGuide", "needIntercept", "onAttachToManager", "onDestroy", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onRelease", "registerGuide", "setGuideHasShown", "showBubble", "anchorView", "Landroid/view/View;", "showEmojiPanel", "showOrHideGuide", "isVisible", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiPanelPlugin.kt */
public class EmojiPanelPlugin extends LiveDataPlugin implements OnAutoPlayInterceptCallback {
    /* access modifiers changed from: private */
    public BubbleTextManager bubbleManager;
    private EmojiPanelPlugin$commentEmojiListener$1 commentEmojiListener = new EmojiPanelPlugin$commentEmojiListener$1(this);
    /* access modifiers changed from: private */
    public EmojiWidgetInterface emojiWidgetInterface;

    public void onAttachToManager() {
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        EmojiPanelState emojiPanelState;
        MutableLiveData<Boolean> isShow;
        EmojiPanelState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        IAutoPlayInterceptorService iAutoPlayInterceptorService = (IAutoPlayInterceptorService) getManager().getService(IAutoPlayInterceptorService.class);
        if (iAutoPlayInterceptorService != null) {
            iAutoPlayInterceptorService.addInterceptor(this);
        }
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d1 = (EmojiPanelState) store.subscribe((Class<T>) EmojiPanelState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d1.getGuideVisible().observe(this, new EmojiPanelPlugin$$ExternalSyntheticLambda0(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || (emojiPanelState = (EmojiPanelState) store2.subscribe((Class<T>) EmojiPanelState.class)) == null || (isShow = emojiPanelState.isShow()) == null)) {
            isShow.observe(this, new EmojiPanelPlugin$$ExternalSyntheticLambda1(this));
        }
        Store<AbsState> store3 = getStore();
        if (!(store3 == null || (coreState = (CoreState) store3.subscribe((Class<T>) CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new EmojiPanelPlugin$$ExternalSyntheticLambda2(this));
        }
        ITouchEventListenerService iTouchEventListenerService = (ITouchEventListenerService) getManager().getService(ITouchEventListenerService.class);
        if (iTouchEventListenerService != null) {
            iTouchEventListenerService.addTouchEventListener(new EmojiPanelPlugin$onAttachToManager$4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m11090onAttachToManager$lambda1$lambda0(EmojiPanelPlugin this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        this$0.showOrHideGuide(isVisible.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3  reason: not valid java name */
    public static final void m11091onAttachToManager$lambda3(EmojiPanelPlugin this$0, Boolean isShow) {
        CommentViewPosition position;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isShow, "isShow");
        if (isShow.booleanValue()) {
            Store $this$select$iv = this$0.getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                Object obj = null;
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(EmojiPanelState.class);
                }
                EmojiPanelState emojiPanelState = (EmojiPanelState) obj;
                if (emojiPanelState != null && (position = emojiPanelState.getPosition()) != null) {
                    this$0.showEmojiPanel(position);
                    return;
                }
                return;
            }
            return;
        }
        this$0.hideEmojiPanel();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5  reason: not valid java name */
    public static final void m11092onAttachToManager$lambda5(EmojiPanelPlugin this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    private final void showEmojiPanel(CommentViewPosition position) {
        CommentModel commentModel;
        AbsState state;
        CommentState commentState;
        MutableLiveData<CommentModel> data;
        if (!BdNetUtils.isNetUp()) {
            Store<AbsState> store = getStore();
            if (store != null) {
                store.dispatch(new ToastAction.SolidShow(R.string.video_flow_network_error, (CharSequence) null, 0, (ToastAction) null, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, 2046, (DefaultConstructorMarker) null));
                return;
            }
            return;
        }
        Store<AbsState> store2 = getStore();
        if (store2 == null || (state = store2.getState()) == null || (commentState = (CommentState) state.select(CommentState.class)) == null || (data = commentState.getData()) == null || (commentModel = data.getValue()) == null) {
            CommentViewPosition commentViewPosition = position;
            commentModel = null;
        } else {
            CommentModel $this$showEmojiPanel_u24lambda_u2d6 = commentModel;
            if ($this$showEmojiPanel_u24lambda_u2d6.isOffline()) {
                DIFactory.INSTANCE.post(new EmojiPanelPlugin$showEmojiPanel$1$1(this));
                return;
            } else if (!$this$showEmojiPanel_u24lambda_u2d6.isEnable()) {
                DIFactory.INSTANCE.post(new EmojiPanelPlugin$showEmojiPanel$1$2(this));
                return;
            } else if ($this$showEmojiPanel_u24lambda_u2d6.isEmojiPanelSwitch()) {
                initEmojiPanel(getContext(), $this$showEmojiPanel_u24lambda_u2d6.getEmojiPanelResourceList(), position, $this$showEmojiPanel_u24lambda_u2d6.isEmojiPanelAnim());
                EmojiWidgetInterface emojiWidgetInterface2 = this.emojiWidgetInterface;
                if (emojiWidgetInterface2 != null) {
                    emojiWidgetInterface2.showEmojiPanel(this.commentEmojiListener);
                }
            } else {
                return;
            }
        }
        if (commentModel == null) {
            EmojiPanelPlugin emojiPanelPlugin = this;
            DIFactory.INSTANCE.post(new EmojiPanelPlugin$showEmojiPanel$2$1(this));
        }
    }

    private final void initEmojiPanel(Context context, List<String> emojiUrlList, CommentViewPosition position, boolean isShowEmojiAnim) {
        EmojiWidgetInterface emojiWidgetInterface2 = EmojiWidgetRuntime.get();
        Integer num = null;
        if (emojiWidgetInterface2 != null) {
            EmojiWidgetInterface $this$initEmojiPanel_u24lambda_u2d8 = emojiWidgetInterface2;
            ICommentService iCommentService = (ICommentService) getManager().getService(ICommentService.class);
            if (iCommentService != null) {
                num = Integer.valueOf(iCommentService.getCommentIconDrawableRes());
            }
            Integer drawableRes = num;
            $this$initEmojiPanel_u24lambda_u2d8.initEmojiPanel(context, emojiUrlList, position, drawableRes != null ? drawableRes.intValue() : 0, isShowEmojiAnim);
        } else {
            emojiWidgetInterface2 = null;
        }
        this.emojiWidgetInterface = emojiWidgetInterface2;
    }

    private final void hideEmojiPanel() {
        EmojiWidgetInterface emojiWidgetInterface2 = this.emojiWidgetInterface;
        if (emojiWidgetInterface2 != null) {
            emojiWidgetInterface2.hideEmojiPanel();
        }
    }

    private final void cancelSendAnim() {
        EmojiWidgetInterface emojiWidgetInterface2 = this.emojiWidgetInterface;
        if (emojiWidgetInterface2 != null) {
            emojiWidgetInterface2.cancelSendAnim();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r3 = r7.getReplyData();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleSendCommentResult(boolean r6, com.baidu.searchbox.comment.model.CommentBaseData r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0023
            com.baidu.searchbox.feed.detail.frame.Store r1 = r5.getStore()
            if (r1 == 0) goto L_0x0023
            com.baidu.searchbox.video.component.comment.CommonCommentAction$OnCommentResult r2 = new com.baidu.searchbox.video.component.comment.CommonCommentAction$OnCommentResult
            if (r7 == 0) goto L_0x0016
            com.baidu.searchbox.comment.model.ReplyData r3 = r7.getReplyData()
            if (r3 == 0) goto L_0x0016
            java.lang.String r3 = r3.data
            goto L_0x0017
        L_0x0016:
            r3 = r0
        L_0x0017:
            if (r3 != 0) goto L_0x001b
            java.lang.String r3 = ""
        L_0x001b:
            r2.<init>(r3, r0)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x0023:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r5.getStore()
            if (r1 == 0) goto L_0x0040
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0035
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0036
        L_0x0035:
            r3 = r0
        L_0x0036:
            if (r3 == 0) goto L_0x003e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r0 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r0 = r3.select(r0)
        L_0x003e:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r0 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r0
        L_0x0040:
            if (r0 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            r1 = 0
            r0.setEmojiPanelShowing(r1)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.comment.emojipanel.EmojiPanelPlugin.handleSendCommentResult(boolean, com.baidu.searchbox.comment.model.CommentBaseData):void");
    }

    /* access modifiers changed from: private */
    public final void showOrHideGuide(boolean isVisible) {
        CommentView commentView;
        if (!isVisible || !isCanShow()) {
            hideBubble();
            return;
        }
        ICommentService iCommentService = (ICommentService) getManager().getService(ICommentService.class);
        if (iCommentService != null && (commentView = iCommentService.getCommentView()) != null && commentView.getVisibility() == 0) {
            showBubble(commentView);
        }
    }

    private final void registerGuide() {
        GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
        if (guidePriorityService != null) {
            GuidePriorityService.DefaultImpls.registerGuide$default(guidePriorityService, new EmojiPanelPlugin$registerGuide$1(this), new EmojiPanelPlugin$registerGuide$2(this), new EmojiPanelPlugin$registerGuide$3(this), 47, false, GuideType.INTERACTION, false, 64, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isShownGuide() {
        return DIFactory.INSTANCE.getConfig().getCommentEmojiPanelGuideIsShow();
    }

    private final void setGuideHasShown() {
        DIFactory.INSTANCE.getConfig().setCommentEmojiPanelGuideShown();
    }

    private final boolean isCanShow() {
        AbsState state;
        CommentState commentState;
        MutableLiveData<CommentModel> data;
        CommentModel $this$isCanShow_u24lambda_u2d10;
        boolean z;
        boolean z2 = true;
        boolean isNeedShowGuide = !isShownGuide();
        Store<AbsState> store = getStore();
        if (LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null)) {
            isNeedShowGuide = false;
        }
        boolean isNeedShowGuide2 = false;
        if (isNeedShowGuide) {
            GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
            if (guidePriorityService != null) {
                z = GuidePriorityService.DefaultImpls.isCanShow$default(guidePriorityService, 47, (Function1) null, 2, (Object) null);
            } else {
                z = false;
            }
            isNeedShowGuide = z;
        }
        if (!isNeedShowGuide) {
            return isNeedShowGuide;
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || (state = store2.getState()) == null || (commentState = (CommentState) state.select(CommentState.class)) == null || (data = commentState.getData()) == null || ($this$isCanShow_u24lambda_u2d10 = data.getValue()) == null)) {
            if ($this$isCanShow_u24lambda_u2d10.isOffline() || !$this$isCanShow_u24lambda_u2d10.isEnable() || !$this$isCanShow_u24lambda_u2d10.isEmojiPanelSwitch()) {
                z2 = false;
            }
            isNeedShowGuide2 = z2;
        }
        return isNeedShowGuide2;
    }

    private final void showBubble(View anchorView) {
        ViewGroup portraitContainer;
        PageContainerService pageContainerService = (PageContainerService) getManager().getService(PageContainerService.class);
        if (pageContainerService != null && (portraitContainer = pageContainerService.getPageContainerPortrait()) != null) {
            BubbleTextManager $this$showBubble_u24lambda_u2d11 = ((BubbleTextBuilder) BubbleManager.newBuilder(new BubbleTextBuilder().getClass())).setAnchorAndRootView(anchorView, portraitContainer).setText(getContext().getString(R.string.video_flow_emoji_panel_guide_tips)).setAutoDismissInterval(3000).setForceShowPosition(BubblePosition.LEFT).setTextColor(ContextCompat.getColor(getContext(), R.color.video_flow_comment_emoji_panel_guide_text), ContextCompat.getColor(getContext(), R.color.video_flow_comment_emoji_panel_guide_text)).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.video_flow_comment_emoji_panel_guide_bg), ContextCompat.getColor(getContext(), R.color.video_flow_comment_emoji_panel_guide_bg)).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new EmojiPanelPlugin$showBubble$1(this)).build();
            this.bubbleManager = $this$showBubble_u24lambda_u2d11;
            if ($this$showBubble_u24lambda_u2d11 != null) {
                $this$showBubble_u24lambda_u2d11.enableAnimation(true);
                $this$showBubble_u24lambda_u2d11.showBubble();
            }
            setGuideHasShown();
        }
    }

    private final void hideBubble() {
        BubbleTextManager bubbleTextManager = this.bubbleManager;
        if (bubbleTextManager != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnBindData) {
            return;
        }
        if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            hideBubble();
            hideEmojiPanel();
            cancelSendAnim();
        } else if (nestedAction instanceof NestedAction.OnPageSelected) {
            hideEmojiPanel();
            registerGuide();
        }
    }

    public void onRelease() {
        super.onRelease();
        hideEmojiPanel();
    }

    public void onDestroy() {
        super.onDestroy();
        hideEmojiPanel();
    }

    public AutoPlayInterceptPriority fetchPriority() {
        return AutoPlayInterceptPriority.Flow.CommentEmojiPanel.INSTANCE;
    }

    public boolean needIntercept() {
        EmojiWidgetInterface it = this.emojiWidgetInterface;
        if (it == null) {
            return false;
        }
        if (!it.isShowing() && !it.isSendAnimShowing()) {
            ICommentService iCommentService = (ICommentService) getManager().getService(ICommentService.class);
            if (!(iCommentService != null && iCommentService.commentIconIsPressing())) {
                return false;
            }
        }
        return true;
    }

    public boolean consumeIntercept() {
        return false;
    }
}
