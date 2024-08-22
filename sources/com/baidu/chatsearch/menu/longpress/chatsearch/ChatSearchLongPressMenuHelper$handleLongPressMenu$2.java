package com.baidu.chatsearch.menu.longpress.chatsearch;

import com.baidu.chatsearch.menu.longpress.chatsearch.constants.BrowserStatisticConstants;
import com.baidu.chatsearch.menu.longpress.chatsearch.login.ItemModeHelperKt;
import com.baidu.searchbox.ng.browser.statistic.LongPress;
import com.baidu.webkit.sdk.WebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchLongPressMenuHelper.kt */
final class ChatSearchLongPressMenuHelper$handleLongPressMenu$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ WebView.HitTestResult $hitTestResult;
    final /* synthetic */ ChatSearchChatLongPressMenuContext $menuContext;
    final /* synthetic */ ChatSearchLongPressMenuHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSearchLongPressMenuHelper$handleLongPressMenu$2(WebView.HitTestResult hitTestResult, ChatSearchLongPressMenuHelper chatSearchLongPressMenuHelper, ChatSearchChatLongPressMenuContext chatSearchChatLongPressMenuContext) {
        super(1);
        this.$hitTestResult = hitTestResult;
        this.this$0 = chatSearchLongPressMenuHelper;
        this.$menuContext = chatSearchChatLongPressMenuContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean it) {
        if (!it) {
            switch (this.$hitTestResult.getType()) {
                case 0:
                    this.this$0.showLinkPopMenu(this.$menuContext, ItemModeHelperKt.buildItemModeHelper(this.$hitTestResult.getCustomData()));
                    this.this$0.loadLongPressScript(this.$menuContext);
                    ChatSearchChatLongPressMenuContext chatSearchChatLongPressMenuContext = this.$menuContext;
                    ChatSearchLongPressMenuBuilderKt.doStatisticsCardShowUBCForPopMenu(chatSearchChatLongPressMenuContext, chatSearchChatLongPressMenuContext.getMenuItemList(), LongPress.TEXT_LINK, BrowserStatisticConstants.VALUE_LINK);
                    return;
                case 10:
                    ChatSearchLongPressMenuHelper.showTextPopMenu$default(this.this$0, this.$menuContext, false, ItemModeHelperKt.buildItemModeHelper(this.$hitTestResult.getCustomData()), 2, (Object) null);
                    this.this$0.loadLongPressScript(this.$menuContext);
                    ChatSearchChatLongPressMenuContext chatSearchChatLongPressMenuContext2 = this.$menuContext;
                    ChatSearchLongPressMenuBuilderKt.doStatisticsCardShowUBCForPopMenu(chatSearchChatLongPressMenuContext2, chatSearchChatLongPressMenuContext2.getMenuItemList(), "text", this.$menuContext.getUbcValue());
                    return;
                default:
                    return;
            }
        }
    }
}
