package com.baidu.searchbox.home.feed.container.processor;

import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.home.feed.ui.FeedChooseTabDialog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/home/feed/container/processor/FeedContainerDialogProcessor$onResume$2", "Lcom/baidu/searchbox/exclusion/popup/PopupExclusionManagerMap$Operation;", "onBreaked", "", "onShow", "callback", "Lcom/baidu/searchbox/exclusion/popup/ShowStatusCallback;", "lib-feed-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedContainerDialogProcessor.kt */
public final class FeedContainerDialogProcessor$onResume$2 extends PopupExclusionManagerMap.Operation {
    final /* synthetic */ FeedChooseTabDialog $dialog;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedContainerDialogProcessor$onResume$2(FeedChooseTabDialog $dialog2, ExclusionType $super_call_param$1) {
        super($super_call_param$1);
        this.$dialog = $dialog2;
    }

    public void onShow(ShowStatusCallback callback) {
        this.$dialog.show();
        if (callback != null) {
            callback.callback(ShowStatus.REAL_SHOW);
        }
        FeedPreferenceUtils.putBoolean(FeedChooseTabDialog.CHOOSE_TAB_SHOW_SP, false);
    }

    public void onBreaked() {
        FeedPreferenceUtils.putBoolean(FeedChooseTabDialog.CHOOSE_TAB_SHOW_SP, true);
        this.$dialog.dismiss();
    }
}
