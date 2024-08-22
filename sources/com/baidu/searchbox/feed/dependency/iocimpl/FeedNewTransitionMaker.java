package com.baidu.searchbox.feed.dependency.iocimpl;

import android.view.View;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.biserial.BiSerialFlowItemClickManager;
import com.baidu.searchbox.feed.ioc.INewTransitionMaker;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout;
import com.baidu.searchbox.feed.ui.drawerslide.SlideToFinishActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/dependency/iocimpl/FeedNewTransitionMaker;", "Lcom/baidu/searchbox/feed/ioc/INewTransitionMaker;", "()V", "postUpdateSharedElement", "", "registerOnFinish", "onFinish", "Lkotlin/Function0;", "setSharedElement", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "itemView", "Landroid/view/View;", "lib-feed-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedNewTransition.kt */
public final class FeedNewTransitionMaker implements INewTransitionMaker {
    public void setSharedElement(FeedBaseModel model, View itemView) {
        if (model != null && itemView != null) {
            BiSerialFlowItemClickManager.setClickItemMap(model, itemView);
            SlideToFinishActivity.Companion.setSharedElement(itemView);
        }
    }

    public void registerOnFinish(Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        BdEventBus.Companion.getDefault().register(this, DynamicSlideFinishLayout.FinishEvent.class, 1, new FeedNewTransitionMaker$$ExternalSyntheticLambda0(this, onFinish));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerOnFinish$lambda-0  reason: not valid java name */
    public static final void m18570registerOnFinish$lambda0(FeedNewTransitionMaker $target, Function0 $onFinish, DynamicSlideFinishLayout.FinishEvent it) {
        Intrinsics.checkNotNullParameter($target, "$target");
        Intrinsics.checkNotNullParameter($onFinish, "$onFinish");
        Intrinsics.checkNotNullParameter(it, "it");
        BdEventBus.Companion.getDefault().unregister($target);
        $onFinish.invoke();
    }

    public void postUpdateSharedElement() {
        BdEventBus.Companion.getDefault().post(DynamicSlideFinishLayout.UpdateEvent.INSTANCE);
    }
}
