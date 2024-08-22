package com.baidu.searchbox.video.feedflow.detail.listpanel;

import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.appdownload.DownloadParam;
import com.baidu.searchbox.video.feedflow.detail.listpanel.listener.IListPanelDownloadStatusListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/listpanel/ListPanelPlugin$initListPopupPanel$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/listener/IListPanelDownloadStatusListener;", "onDownloadNetConnectedFail", "", "onDownloadStatusChange", "downloadParam", "Lcom/baidu/searchbox/video/feedflow/detail/appdownload/DownloadParam;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPanelPlugin.kt */
public final class ListPanelPlugin$initListPopupPanel$1$1 implements IListPanelDownloadStatusListener {
    final /* synthetic */ ListPanelPlugin this$0;

    ListPanelPlugin$initListPopupPanel$1$1(ListPanelPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onDownloadStatusChange(DownloadParam downloadParam) {
        Intrinsics.checkNotNullParameter(downloadParam, "downloadParam");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new ListPanelDownloadStatusChangeAction(downloadParam));
        }
    }

    public void onDownloadNetConnectedFail() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new ToastAction.Show(R.string.video_flow_network_error, (CharSequence) null, 0, (ToastAction) null, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, 2046, (DefaultConstructorMarker) null));
        }
    }
}
