package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import com.baidu.android.ext.widget.C0297BdPopupWindow;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/ShortPlayPanelAdapter$createContent$1$2", "Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/CommonListViewListener;", "moreShortPlayClick", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPanelAdapter.kt */
public final class ShortPlayPanelAdapter$createContent$1$2 implements CommonListViewListener {
    final /* synthetic */ ShortPlayPanelAdapter this$0;

    ShortPlayPanelAdapter$createContent$1$2(ShortPlayPanelAdapter $receiver) {
        this.this$0 = $receiver;
    }

    public void moreShortPlayClick() {
        C0297BdPopupWindow access$getWindow = this.this$0.getWindow();
        if (access$getWindow != null) {
            access$getWindow.dismiss();
        }
    }
}
