package com.baidu.searchbox.mvp.aicard;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.mvp.aicard.AiCardAction;
import com.baidu.searchbox.mvp.common.MvpCommonPageChangeAction;
import com.baidu.searchbox.mvp.common.MvpCommonPageId;
import com.baidu.searchbox.mvp.common.MvpCommonPageModel;
import com.baidu.searchbox.mvp.errorrefresh.MvpErrorRefreshModel;
import com.baidu.searchbox.mvp.recommend.MvpRecommendAction;
import com.baidu.searchbox.mvp.topbar.MvpTopBarAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/mvp/aicard/AiCardMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCardMiddleware.kt */
public final class AiCardMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof MvpCommonPageChangeAction.ChangeCommonPageAction) {
            if (((MvpCommonPageChangeAction.ChangeCommonPageAction) action2).getPageModel().getPageId() != MvpCommonPageId.BIG_AI_CARD) {
                store2.dispatch(AiCardAction.AiCardViewGone.INSTANCE);
            } else if (((MvpCommonPageChangeAction.ChangeCommonPageAction) action2).getPageModel().isRestorePage()) {
                store2.dispatch(AiCardAction.ResumeShowAiCardAction.INSTANCE);
            } else {
                Object pageData = ((MvpCommonPageChangeAction.ChangeCommonPageAction) action2).getPageModel().getPageData();
                AiCardData data = pageData instanceof AiCardData ? (AiCardData) pageData : null;
                if (data != null) {
                    store2.dispatch(new AiCardAction.refreshShowAiCardAction(data));
                } else {
                    store2.dispatch(AiCardAction.AiCardViewGone.INSTANCE);
                    store2.dispatch(new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.NETWORK_ERROR, new MvpErrorRefreshModel((String) null, new MvpRecommendAction.RequestRecommendAction(MvpCommonPageId.BIG_AI_CARD), MvpCommonPageId.BIG_AI_CARD, 1, (DefaultConstructorMarker) null), false, 4, (DefaultConstructorMarker) null)));
                }
            }
        } else if (action2 instanceof MvpTopBarAction.BackAction) {
            store2.dispatch(AiCardAction.RecoverPhotographViewAction.INSTANCE);
        }
        return next2.next(store2, action2);
    }
}
