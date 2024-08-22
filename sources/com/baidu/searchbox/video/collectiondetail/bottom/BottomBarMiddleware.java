package com.baidu.searchbox.video.collectiondetail.bottom;

import androidx.lifecycle.MutableLiveData;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.share.CommonShareState;
import com.baidu.searchbox.video.component.share.ShareModel;
import com.baidu.searchbox.video.component.share.SharePanelHide;
import com.baidu.searchbox.video.component.share.SharePanelShow;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.list.ConfigurationChangedAction;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenExpandOrientationChanged;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenFoldStateChanged;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/collectiondetail/bottom/BottomBarMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarMiddleware.kt */
public final class BottomBarMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        MutableLiveData<ShareModel> shareModel;
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof BottomBarShareClick) {
            CommonState state = store.getState();
            Unit unit = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            CommonShareState commonShareState = (CommonShareState) (commonState != null ? commonState.select(CommonShareState.class) : null);
            if (!(commonShareState == null || (shareModel = commonShareState.getShareModel()) == null || shareModel.getValue() == null)) {
                StoreExtKt.post(store2, new SharePanelShow(11, (String) null, (String) null, (String) null, false, false, 0, 126, (DefaultConstructorMarker) null));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                StoreExtKt.post(store2, new ToastAction.Show(R.string.video_flow_collection_detail_share_no_data_toast, (CharSequence) null, 0, (ToastAction) null, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, 2046, (DefaultConstructorMarker) null));
            }
        } else if (action2 instanceof FoldScreenFoldStateChanged) {
            StoreExtKt.post(store2, SharePanelHide.INSTANCE);
        } else if (action2 instanceof FoldScreenExpandOrientationChanged) {
            StoreExtKt.post(store2, SharePanelHide.INSTANCE);
        } else if (action2 instanceof ConfigurationChangedAction) {
            StoreExtKt.post(store2, SharePanelHide.INSTANCE);
        }
        return next2.next(store2, action2);
    }
}
