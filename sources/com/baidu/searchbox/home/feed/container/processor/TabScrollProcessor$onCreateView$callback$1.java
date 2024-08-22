package com.baidu.searchbox.home.feed.container.processor;

import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.feed.controller.datachannel.FeedDataChannelConstants;
import com.baidu.searchbox.feed.tab.interaction.IRNPageScrollInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/home/feed/container/processor/TabScrollProcessor$onCreateView$callback$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-feed-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabScrollProcessor.kt */
public final class TabScrollProcessor$onCreateView$callback$1 extends NAReceiverCallback {
    final /* synthetic */ TabScrollProcessor this$0;

    TabScrollProcessor$onCreateView$callback$1(TabScrollProcessor $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String data) {
        CharSequence charSequence = data;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                int pageOffsetY = this.this$0.processRNPageData(data);
                if (Intrinsics.areEqual((Object) action, (Object) FeedDataChannelConstants.ACTION_RN_PAGE_SCROLL)) {
                    this.this$0.curRNOutScrollY = pageOffsetY;
                    IRNPageScrollInfo access$getRNPageScrollInfo = this.this$0.getRNPageScrollInfo();
                    if (access$getRNPageScrollInfo != null) {
                        access$getRNPageScrollInfo.setRNOutScrollY(pageOffsetY);
                    }
                } else if (Intrinsics.areEqual((Object) action, (Object) FeedDataChannelConstants.ACTION_RN_SUB_PAGE_SCROLL)) {
                    this.this$0.curRNInScrollY = pageOffsetY;
                    IRNPageScrollInfo access$getRNPageScrollInfo2 = this.this$0.getRNPageScrollInfo();
                    if (access$getRNPageScrollInfo2 != null) {
                        access$getRNPageScrollInfo2.setRNInScrollY(pageOffsetY);
                    }
                }
                TabScrollProcessor tabScrollProcessor = this.this$0;
                TabScrollProcessor.processPageScroll$default(tabScrollProcessor, false, tabScrollProcessor.curRNInScrollY + this.this$0.curRNOutScrollY, 1, (Object) null);
            }
        }
    }
}
