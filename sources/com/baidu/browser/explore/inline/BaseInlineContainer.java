package com.baidu.browser.explore.inline;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.explore.inline.model.InlineModel;
import com.baidu.browser.explore.inline.view.LinkageContainerView;
import com.baidu.browser.explore.tab.na.utils.CkHelper;
import com.baidu.browser.tabna.IResultPageTabContext;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import com.baidu.searchbox.browserenhanceengine.container.animation.ContainerAnimationInterceptor;
import com.baidu.searchbox.browserenhanceengine.container.templete.LifecycleContainer;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010R\u001a\u00020$H\u0016J\b\u0010S\u001a\u00020$H\u0016J\b\u0010T\u001a\u00020UH\u0016J\n\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u001a\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020$2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010\\\u001a\u00020(2\u0006\u0010Y\u001a\u00020$2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010]\u001a\u00020(H\u0002J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010a\u001a\u00020(H\u0016J\b\u0010b\u001a\u00020(H\u0016J\u0012\u0010c\u001a\u00020$2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020$H\u0016J\u0010\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.H\u0016J0\u0010i\u001a\u00020(2&\u0010j\u001a\"\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u00010kj\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u0001`mH\u0016J¸\u0001\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020.2\u0006\u0010p\u001a\u00020.2&\u0010q\u001a\"\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u00010kj\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u0001`m2&\u0010r\u001a\"\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u00010kj\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u0001`m2&\u0010s\u001a\"\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u00010kj\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u0001`m2&\u0010t\u001a\"\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u00010kj\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0018\u0001`mH\u0016J\u0012\u0010u\u001a\u00020(2\b\u0010v\u001a\u0004\u0018\u00010lH\u0016J\u0012\u0010w\u001a\u00020(2\b\u0010v\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010y\u001a\u00020.H\u0016J\u0012\u0010z\u001a\u00020(2\b\u0010{\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010|\u001a\u00020(2\u0006\u0010}\u001a\u00020.H\u0016J\u0010\u0010~\u001a\u00020(2\u0006\u0010\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020.H\u0016J-\u0010\u0001\u001a\u00020(2\"\u0010j\u001a\u001e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l0kj\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l`mH\u0016J\u0013\u0010\u0001\u001a\u00020(2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u0001\u001a\u00020(H\u0016J\t\u0010\u0001\u001a\u00020(H\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010WH\u0016J\u0019\u0010\u0001\u001a\u00020(2\t\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020\u0002J\u0013\u0010\u0001\u001a\u00020(2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R7\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R^\u00100\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020(\u0018\u00010#2#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020(\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R^\u00104\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020(\u0018\u00010#2#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020(\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\"\u00107\u001a\n\u0012\u0004\u0012\u00020(\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\n\u0012\u0004\u0012\u00020(\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R^\u0010A\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020(\u0018\u00010#2#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020(\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R\"\u0010D\u001a\n\u0012\u0004\u0012\u00020(\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010:\"\u0004\bF\u0010<RL\u0010G\u001a4\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020(\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NRL\u0010O\u001a4\u0012\u0013\u0012\u00110.¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020(\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010N¨\u0006\u0001"}, d2 = {"Lcom/baidu/browser/explore/inline/BaseInlineContainer;", "T", "Lcom/baidu/browser/explore/inline/model/InlineModel;", "Lcom/baidu/searchbox/browserenhanceengine/container/templete/LifecycleContainer;", "context", "Landroid/content/Context;", "dataModel", "resultPageTabContext", "Lcom/baidu/browser/tabna/IResultPageTabContext;", "(Landroid/content/Context;Lcom/baidu/browser/explore/inline/model/InlineModel;Lcom/baidu/browser/tabna/IResultPageTabContext;)V", "hasOnSaveAPageInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "inlineMode", "getInlineMode", "()Lcom/baidu/browser/explore/inline/model/InlineModel;", "setInlineMode", "(Lcom/baidu/browser/explore/inline/model/InlineModel;)V", "mLinkageRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMLinkageRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMLinkageRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mResultPageContext", "getMResultPageContext", "()Lcom/baidu/browser/tabna/IResultPageTabContext;", "setMResultPageContext", "(Lcom/baidu/browser/tabna/IResultPageTabContext;)V", "mRootView", "Lcom/baidu/browser/explore/inline/view/LinkageContainerView;", "getMRootView", "()Lcom/baidu/browser/explore/inline/view/LinkageContainerView;", "setMRootView", "(Lcom/baidu/browser/explore/inline/view/LinkageContainerView;)V", "onContainerMediaFocusChange", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isRequest", "", "getOnContainerMediaFocusChange", "()Lkotlin/jvm/functions/Function1;", "setOnContainerMediaFocusChange", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "height", "onContentViewHeightChanged", "getOnContentViewHeightChanged", "setOnContentViewHeightChanged", "dy", "onLinkageContainerScroll", "getOnLinkageContainerScroll", "setOnLinkageContainerScroll", "onPageShowCallback", "Lkotlin/Function0;", "getOnPageShowCallback", "()Lkotlin/jvm/functions/Function0;", "setOnPageShowCallback", "(Lkotlin/jvm/functions/Function0;)V", "onPageShowHighChange", "getOnPageShowHighChange", "setOnPageShowHighChange", "diff", "onTopPageHeightChanged", "getOnTopPageHeightChanged", "setOnTopPageHeightChanged", "requestContainerResetPosition", "getRequestContainerResetPosition", "setRequestContainerResetPosition", "topContainerScrollBy", "Lkotlin/Function2;", "scrollY", "isAnim", "getTopContainerScrollBy", "()Lkotlin/jvm/functions/Function2;", "setTopContainerScrollBy", "(Lkotlin/jvm/functions/Function2;)V", "topContainerScrollTo", "getTopContainerScrollTo", "setTopContainerScrollTo", "canGoBack", "canGoForward", "ckHelper", "Lcom/baidu/browser/explore/tab/na/utils/CkHelper;", "contentView", "Landroid/view/View;", "expandedBottomView", "expand", "animation", "Landroid/view/animation/Animation;", "expandedTopView", "getAPageInfo", "getContainerAnimation", "Lcom/baidu/searchbox/browserenhanceengine/container/animation/ContainerAnimationInterceptor;", "getLinkageRecycleView", "goBack", "goForWard", "isSlidable", "ev", "Landroid/view/MotionEvent;", "isSupportFullScreenMode", "onFontChangeSize", "fontsize", "onHandleAPageInfo", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onHandleAPageTcLog", "type", "iteration", "clkInfoObjParams", "extraObjParams", "urlParams", "extra", "onHandleInsertNaProtoData", "data", "onHandleNaProtoData", "onHandleNaProtoDataEnd", "cardCount", "onHandleTalosCommInfo", "info", "onLinkageFingerTouch", "touchAction", "onLinkageScrollChanged", "scrollSumY", "onLinkageScrollStateChanged", "scrollState", "onSaveAPageInfo", "onViewCreated", "onVoiceSearchPanelDismiss", "onVoiceSearchPanelShow", "rootView", "updateContainerForStruct", "model", "updateInlineMode", "newInlineModel", "updateResultPageTabContext", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseInlineContainer.kt */
public class BaseInlineContainer<T extends InlineModel> extends LifecycleContainer<T> {
    private final AtomicBoolean hasOnSaveAPageInfo = new AtomicBoolean(false);
    private InlineModel inlineMode;
    private RecyclerView mLinkageRecycleView;
    private IResultPageTabContext mResultPageContext;
    private LinkageContainerView mRootView;
    private Function1<? super Boolean, Unit> onContainerMediaFocusChange;
    private Function1<? super Integer, Unit> onContentViewHeightChanged;
    private Function1<? super Integer, Unit> onLinkageContainerScroll;
    private Function0<Unit> onPageShowCallback;
    private Function0<Unit> onPageShowHighChange;
    private Function1<? super Integer, Unit> onTopPageHeightChanged;
    private Function0<Unit> requestContainerResetPosition;
    private Function2<? super Integer, ? super Boolean, Unit> topContainerScrollBy;
    private Function2<? super Integer, ? super Boolean, Unit> topContainerScrollTo;

    /* access modifiers changed from: protected */
    public final IResultPageTabContext getMResultPageContext() {
        return this.mResultPageContext;
    }

    /* access modifiers changed from: protected */
    public final void setMResultPageContext(IResultPageTabContext iResultPageTabContext) {
        this.mResultPageContext = iResultPageTabContext;
    }

    /* access modifiers changed from: protected */
    public final LinkageContainerView getMRootView() {
        return this.mRootView;
    }

    /* access modifiers changed from: protected */
    public final void setMRootView(LinkageContainerView linkageContainerView) {
        this.mRootView = linkageContainerView;
    }

    /* access modifiers changed from: protected */
    public final RecyclerView getMLinkageRecycleView() {
        return this.mLinkageRecycleView;
    }

    /* access modifiers changed from: protected */
    public final void setMLinkageRecycleView(RecyclerView recyclerView) {
        this.mLinkageRecycleView = recyclerView;
    }

    public final Function0<Unit> getOnPageShowCallback() {
        return this.onPageShowCallback;
    }

    public final void setOnPageShowCallback(Function0<Unit> function0) {
        this.onPageShowCallback = function0;
    }

    public final Function0<Unit> getRequestContainerResetPosition() {
        return this.requestContainerResetPosition;
    }

    public final void setRequestContainerResetPosition(Function0<Unit> function0) {
        this.requestContainerResetPosition = function0;
    }

    public final Function0<Unit> getOnPageShowHighChange() {
        return this.onPageShowHighChange;
    }

    public final void setOnPageShowHighChange(Function0<Unit> function0) {
        this.onPageShowHighChange = function0;
    }

    public final Function1<Integer, Unit> getOnTopPageHeightChanged() {
        return this.onTopPageHeightChanged;
    }

    public final void setOnTopPageHeightChanged(Function1<? super Integer, Unit> value) {
        this.onTopPageHeightChanged = value;
        LinkageContainerView linkageContainerView = this.mRootView;
        if (linkageContainerView != null) {
            linkageContainerView.setOnTopPageHeightChanged(value);
        }
    }

    public final Function2<Integer, Boolean, Unit> getTopContainerScrollTo() {
        return this.topContainerScrollTo;
    }

    public final void setTopContainerScrollTo(Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.topContainerScrollTo = function2;
    }

    public final Function2<Integer, Boolean, Unit> getTopContainerScrollBy() {
        return this.topContainerScrollBy;
    }

    public final void setTopContainerScrollBy(Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.topContainerScrollBy = function2;
    }

    public final Function1<Boolean, Unit> getOnContainerMediaFocusChange() {
        return this.onContainerMediaFocusChange;
    }

    public final void setOnContainerMediaFocusChange(Function1<? super Boolean, Unit> function1) {
        this.onContainerMediaFocusChange = function1;
    }

    public final Function1<Integer, Unit> getOnContentViewHeightChanged() {
        return this.onContentViewHeightChanged;
    }

    public final void setOnContentViewHeightChanged(Function1<? super Integer, Unit> value) {
        this.onContentViewHeightChanged = value;
        LinkageContainerView linkageContainerView = this.mRootView;
        if (linkageContainerView != null) {
            linkageContainerView.setOnContentViewHeightChanged(value);
        }
    }

    public final Function1<Integer, Unit> getOnLinkageContainerScroll() {
        return this.onLinkageContainerScroll;
    }

    public final void setOnLinkageContainerScroll(Function1<? super Integer, Unit> value) {
        this.onLinkageContainerScroll = value;
        LinkageContainerView linkageContainerView = this.mRootView;
        if (linkageContainerView != null) {
            linkageContainerView.setOnLinkageContainerScroll(value);
        }
    }

    /* access modifiers changed from: protected */
    public final InlineModel getInlineMode() {
        return this.inlineMode;
    }

    /* access modifiers changed from: protected */
    public final void setInlineMode(InlineModel inlineModel) {
        this.inlineMode = inlineModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseInlineContainer(Context context, T dataModel, IResultPageTabContext resultPageTabContext) {
        super(context, (ContainerModel) dataModel);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inlineMode = dataModel;
        this.mResultPageContext = resultPageTabContext;
    }

    public CkHelper ckHelper() {
        return CkHelper.Companion.createOrGetCkHelper("na");
    }

    public final void updateInlineMode(InlineModel newInlineModel) {
        Intrinsics.checkNotNullParameter(newInlineModel, "newInlineModel");
        InlineModel inlineModel = this.inlineMode;
        if (inlineModel != null) {
            inlineModel.setUrl(newInlineModel.getUrl());
        }
        InlineModel inlineModel2 = this.inlineMode;
        if (inlineModel2 != null) {
            inlineModel2.setQuery(newInlineModel.getQuery());
        }
        InlineModel inlineModel3 = this.inlineMode;
        if (inlineModel3 != null) {
            inlineModel3.setPreload(false);
        }
    }

    public void updateResultPageTabContext(IResultPageTabContext resultPageTabContext) {
        this.mResultPageContext = resultPageTabContext;
    }

    public RecyclerView getLinkageRecycleView() {
        return this.mLinkageRecycleView;
    }

    public void onLinkageFingerTouch(int touchAction) {
    }

    public void onLinkageScrollStateChanged(int scrollState) {
    }

    public void onLinkageScrollChanged(int scrollSumY) {
    }

    public void onHandleAPageTcLog(int type, int iteration, HashMap<String, String> clkInfoObjParams, HashMap<String, String> extraObjParams, HashMap<String, String> urlParams, HashMap<String, String> extra) {
    }

    public void onHandleAPageInfo(HashMap<String, String> map) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onHandleAPageInfo map = " + map);
        }
        if (map != null) {
            this.hasOnSaveAPageInfo.set(true);
            onSaveAPageInfo(map);
        }
    }

    public void onHandleTalosCommInfo(String info) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onHandleTalosCommInfo info = " + info);
        }
    }

    private final void getAPageInfo() {
        IResultPageTabContext iResultPageTabContext;
        HashMap it;
        if (this.hasOnSaveAPageInfo.compareAndSet(false, true) && (iResultPageTabContext = this.mResultPageContext) != null && (it = iResultPageTabContext.getAPageInfo()) != null) {
            onSaveAPageInfo(it);
        }
    }

    public void onSaveAPageInfo(HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onSaveAPageInfo map = " + map);
        }
    }

    public void onHandleNaProtoData(String data) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "handleNaProtoData data = " + data);
        }
        getAPageInfo();
    }

    public void onHandleNaProtoDataEnd(int cardCount) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onHandleNaProtoDataEnd");
        }
    }

    public void onHandleInsertNaProtoData(String data) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onHandleInsertNaProtoData data = " + data);
        }
        getAPageInfo();
    }

    public View rootView() {
        if (this.mRootView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LinkageContainerView linkageContainerView = new LinkageContainerView(context);
            this.mRootView = linkageContainerView;
            linkageContainerView.setOnLinkageContainerScroll(this.onLinkageContainerScroll);
            LinkageContainerView linkageContainerView2 = this.mRootView;
            if (linkageContainerView2 != null) {
                linkageContainerView2.setOnContentViewHeightChanged(this.onContentViewHeightChanged);
            }
            LinkageContainerView linkageContainerView3 = this.mRootView;
            if (linkageContainerView3 != null) {
                linkageContainerView3.setOnTopPageHeightChanged(this.onTopPageHeightChanged);
            }
            LinkageContainerView linkageContainerView4 = this.mRootView;
            if (linkageContainerView4 != null) {
                linkageContainerView4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            LinkageContainerView linkageContainerView5 = this.mRootView;
            if (linkageContainerView5 != null) {
                linkageContainerView5.setRecycleView(getLinkageRecycleView());
            }
        }
        return this.mRootView;
    }

    public boolean isSlidable(MotionEvent ev) {
        return true;
    }

    public boolean canGoBack() {
        return false;
    }

    public void goBack() {
    }

    public boolean canGoForward() {
        return false;
    }

    public void goForWard() {
    }

    public boolean isSupportFullScreenMode() {
        return true;
    }

    public ContainerAnimationInterceptor getContainerAnimation() {
        return null;
    }

    public void updateContainerForStruct(T model) {
    }

    public void expandedTopView(boolean expand, Animation animation) {
    }

    public void expandedBottomView(boolean expand, Animation animation) {
    }

    public View contentView() {
        return null;
    }

    public void onViewCreated(Context context) {
    }

    public void onFontChangeSize(int fontsize) {
        Function0<Unit> function0 = this.onPageShowHighChange;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onVoiceSearchPanelShow() {
    }

    public void onVoiceSearchPanelDismiss() {
    }
}
