package com.baidu.searchbox.home.tabs.operation;

import com.baidu.common.operation.view.OperationAlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.home.tabs.view.BottomNavigationItemView;
import com.baidu.searchbox.hometab.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/home/tabs/operation/HomeTabIconAndBubbleProcess$showBaseTabItemOperationView$2", "Lcom/baidu/common/operation/view/OperationAlphaVideo$PlayListener;", "onError", "", "errorInfo", "Lcom/baidu/searchbox/afx/callback/ErrorInfo;", "onStarted", "lib-home-tab-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTabIconAndBubbleProcess.kt */
public final class HomeTabIconAndBubbleProcess$showBaseTabItemOperationView$2 implements OperationAlphaVideo.PlayListener {
    final /* synthetic */ boolean $isRegression;
    final /* synthetic */ OperationAlphaVideo $operationAlphaVideo;
    final /* synthetic */ BottomNavigationItemView $tabItemView;
    final /* synthetic */ HomeTabIconAndBubbleProcess this$0;

    HomeTabIconAndBubbleProcess$showBaseTabItemOperationView$2(BottomNavigationItemView $tabItemView2, HomeTabIconAndBubbleProcess $receiver, boolean $isRegression2, OperationAlphaVideo $operationAlphaVideo2) {
        this.$tabItemView = $tabItemView2;
        this.this$0 = $receiver;
        this.$isRegression = $isRegression2;
        this.$operationAlphaVideo = $operationAlphaVideo2;
    }

    public void onStarted() {
        this.$tabItemView.findViewById(R.id.home_tab_item_content).setVisibility(4);
        this.this$0.doRealShowBubble("operation", this.$tabItemView, this.$isRegression);
    }

    public void onError(ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        if (this.$operationAlphaVideo.getImageView() != null && this.$operationAlphaVideo.getImageView().getVisibility() == 0) {
            this.$tabItemView.findViewById(R.id.home_tab_item_content).setVisibility(4);
            this.this$0.doRealShowBubble("operation", this.$tabItemView, this.$isRegression);
        }
    }
}
