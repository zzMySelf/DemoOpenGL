package com.baidu.searchbox.aicreative.creating.progress;

import com.baidu.searchbox.aicreative.creating.AiCreativeImageCreatingRequestManager;
import com.baidu.searchbox.aicreative.creating.bottombar.AiCreativeImageCreatingBottomBarAction;
import com.baidu.searchbox.aicreative.creating.plugin.creating.AiCreativeImageCreatingAction;
import com.baidu.searchbox.aicreative.creating.progress.AiCreativeImageCreatingProgressAction;
import com.baidu.searchbox.dynamicpublisher.uploadImage.UploadImageAction;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/aicreative/creating/progress/AiCreativeImageCreatingProgressMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageCreatingProgressMiddleware.kt */
public final class AiCreativeImageCreatingProgressMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof UploadImageAction.UploadImagesFail) {
            store.dispatch(new AiCreativeImageCreatingProgressAction.ShowViewEnable(false));
            store.dispatch(new AiCreativeImageCreatingProgressAction.UpdateCreatingStatus(3));
        } else if (action instanceof UploadImageAction.UploadImages) {
            AiCreativeImageCreatingRequestManager.INSTANCE.setImgUploadStartRequestTime(System.currentTimeMillis());
            store.dispatch(new AiCreativeImageCreatingProgressAction.UpdateCreatingStatus(1));
        } else if (action instanceof AiCreativeImageCreatingAction.UpdateCreatingStatus) {
            int status = ((AiCreativeImageCreatingAction.UpdateCreatingStatus) action).getStatus();
            if (status == 5) {
                store.dispatch(new AiCreativeImageCreatingProgressAction.UpdateProgress(100));
            }
            switch (status) {
                case 5:
                case 6:
                    store.dispatch(new AiCreativeImageCreatingProgressAction.ShowViewEnable(false));
                    break;
            }
            store.dispatch(new AiCreativeImageCreatingProgressAction.UpdateCreatingStatus(((AiCreativeImageCreatingAction.UpdateCreatingStatus) action).getStatus()));
        } else if (action instanceof AiCreativeImageCreatingBottomBarAction.ShowLoadingAction) {
            store.dispatch(new AiCreativeImageCreatingProgressAction.ShowLoadingViewEnable(((AiCreativeImageCreatingBottomBarAction.ShowLoadingAction) action).getEnable()));
        }
        return next.next(store, action);
    }
}
