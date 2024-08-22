package com.baidu.chatsearch.menu.longpress.chatsearch;

import android.content.Context;
import com.baidu.chatsearch.menu.longpress.chatsearch.constants.BrowserStatisticConstants;
import com.baidu.chatsearch.menu.longpress.chatsearch.constants.ChatSearchLongPressTypeConstants;
import com.baidu.chatsearch.menu.longpress.chatsearch.model.WebFunctionModel;
import com.baidu.chatsearch.widget.R;
import com.baidu.search.longpress.model.LongPressItemMode;
import com.baidu.searchbox.ng.browser.statistic.LongPressUBC;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/chatsearch/menu/longpress/chatsearch/TTSMenuItemChatSearch;", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/ChatSearchLongPressMenuItem;", "context", "Landroid/content/Context;", "itemMode", "Lcom/baidu/search/longpress/model/LongPressItemMode;", "(Landroid/content/Context;Lcom/baidu/search/longpress/model/LongPressItemMode;)V", "getUBCValue", "", "menuContext", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/ChatLongPressMenuContext;", "onItemClick", "", "lib-chatsearch-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchLongPressMenuItem.kt */
public final class TTSMenuItemChatSearch extends ChatSearchLongPressMenuItem {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TTSMenuItemChatSearch(Context context, LongPressItemMode longPressItemMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : longPressItemMode);
    }

    public TTSMenuItemChatSearch(Context context, LongPressItemMode itemMode) {
        super(context, itemMode);
        setSearchItemId(24);
        setSearchItemIconId(R.drawable.long_press_tts);
        setSearchItemTextId(R.string.browser_search_menu_long_press_tts);
        setItemType(1);
    }

    public String getUBCValue(ChatLongPressMenuContext menuContext) {
        return BrowserStatisticConstants.ANSWER_PLAY;
    }

    public void onItemClick(ChatLongPressMenuContext menuContext) {
        Intrinsics.checkNotNullParameter(menuContext, "menuContext");
        ChatSearchChatLongPressMenuContext $this$onItemClick_u24lambda_u2d1 = menuContext instanceof ChatSearchChatLongPressMenuContext ? (ChatSearchChatLongPressMenuContext) menuContext : null;
        if ($this$onItemClick_u24lambda_u2d1 != null) {
            WebFunctionModel $this$onItemClick_u24lambda_u2d1_u24lambda_u2d0 = $this$onItemClick_u24lambda_u2d1.getWebFunctionModel();
            if ($this$onItemClick_u24lambda_u2d1_u24lambda_u2d0 != null) {
                $this$onItemClick_u24lambda_u2d1_u24lambda_u2d0.setFunctionType(ChatSearchLongPressTypeConstants.LONG_PRESS_CARD_FUNCTION_TTS);
            } else {
                $this$onItemClick_u24lambda_u2d1_u24lambda_u2d0 = null;
            }
            $this$onItemClick_u24lambda_u2d1.clickMenuItem($this$onItemClick_u24lambda_u2d1_u24lambda_u2d0);
            LongPressUBC.clickUBC(menuContext.getLastSource(), menuContext.getLastPage(), ChatSearchLongPressMenuItem.getUBCValue$default(this, (ChatLongPressMenuContext) null, 1, (Object) null), menuContext.getLidUbcJson());
            $this$onItemClick_u24lambda_u2d1.cancelSelectedText();
        }
    }
}
