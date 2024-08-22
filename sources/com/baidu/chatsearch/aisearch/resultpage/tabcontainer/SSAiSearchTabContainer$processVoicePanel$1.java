package com.baidu.chatsearch.aisearch.resultpage.tabcontainer;

import com.baidu.chatsearch.bottommenu.ChatSearchPhotoGuideManager;
import com.baidu.chatsearch.menu.longpress.LongPressMenuManager;
import com.baidu.chatsearch.model.ubc.SSDurationManager;
import com.baidu.searchbox.ng.browser.NgWebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "isShow", "", "isSendSuccess", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSearchTabContainer.kt */
final class SSAiSearchTabContainer$processVoicePanel$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ SSAiSearchTabContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiSearchTabContainer$processVoicePanel$1(SSAiSearchTabContainer sSAiSearchTabContainer) {
        super(2);
        this.this$0 = sSAiSearchTabContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isShow, boolean isSendSuccess) {
        int i2 = 1;
        if (isShow) {
            this.this$0.voicePanelStatusNotifyWeb(true);
            this.this$0.getDurationManager().setPage("search");
            NgWebView mWebView = this.this$0.getMWebView();
            if (mWebView != null) {
                mWebView.pauseMedia();
            }
            LongPressMenuManager longPressMenuManager = this.this$0.getLongPressMenuManager();
            if (longPressMenuManager != null) {
                longPressMenuManager.onPause();
            }
            ChatSearchPhotoGuideManager.INSTANCE.dismissBubble();
        } else {
            this.this$0.voicePanelStatusNotifyWeb(false);
            SSDurationManager access$getDurationManager = this.this$0.getDurationManager();
            if (!isSendSuccess) {
                i2 = 2;
            }
            access$getDurationManager.setSeEndType(Integer.valueOf(i2));
            if (!isSendSuccess) {
                this.this$0.getDurationManager().setPage(this.this$0.getCurrentPageName());
            }
            NgWebView mWebView2 = this.this$0.getMWebView();
            if (mWebView2 != null) {
                mWebView2.resumeMedia();
            }
        }
        if (isSendSuccess) {
            this.this$0.getDurationManager().setPage("resultpage");
        }
    }
}
