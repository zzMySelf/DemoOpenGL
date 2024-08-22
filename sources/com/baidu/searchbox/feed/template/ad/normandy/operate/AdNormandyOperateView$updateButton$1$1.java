package com.baidu.searchbox.feed.template.ad.normandy.operate;

import com.baidu.searchbox.feed.template.ad.customview.AdMultiStateButton;
import com.baidu.searchbox.feed.template.ad.customview.AdMultiStateDownloadBtn;
import com.baidu.searchbox.feed.template.ad.normandy.operate.AdNormandyOperateView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/template/ad/normandy/operate/AdNormandyOperateView$updateButton$1$1", "Lcom/baidu/searchbox/feed/template/ad/customview/AdMultiStateButton$IActionListener;", "onEnhancedButtonClick", "", "onEnhancedButtonShow", "onNormalButtonClick", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdNormandyOperateView.kt */
public final class AdNormandyOperateView$updateButton$1$1 implements AdMultiStateButton.IActionListener {
    final /* synthetic */ AdNormandyOperateView this$0;

    AdNormandyOperateView$updateButton$1$1(AdNormandyOperateView $receiver) {
        this.this$0 = $receiver;
    }

    public void onNormalButtonClick() {
        AdNormandyOperateView.IActionListener access$getActionListener$p = this.this$0.actionListener;
        if (access$getActionListener$p != null) {
            access$getActionListener$p.onButtonClick("normalbtn", this.this$0.button instanceof AdMultiStateDownloadBtn);
        }
    }

    public void onEnhancedButtonShow() {
    }

    public void onEnhancedButtonClick() {
        AdNormandyOperateView.IActionListener access$getActionListener$p = this.this$0.actionListener;
        if (access$getActionListener$p != null) {
            access$getActionListener$p.onButtonClick("enhancedbtn", this.this$0.button instanceof AdMultiStateDownloadBtn);
        }
    }
}
