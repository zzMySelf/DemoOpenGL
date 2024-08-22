package com.baidu.browser.components.commonmenu.impl;

import android.content.Context;
import com.baidu.browser.components.commonmenu.core.DefaultMenuItemClickListener;
import com.baidu.browser.components.commonmenu.core.ICommonMenuContext;
import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/browser/components/commonmenu/impl/NewMenuClickListener$addStart$1", "Lcom/baidu/searchbox/bookmark/BookMarkLoginUtils$OnAllowBookMarkListener;", "allowUseBookMark", "", "loginFail", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMenuClickListener.kt */
public final class NewMenuClickListener$addStart$1 implements BookMarkLoginUtils.OnAllowBookMarkListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ NewMenuClickListener this$0;

    NewMenuClickListener$addStart$1(NewMenuClickListener $receiver, Context $context2) {
        this.this$0 = $receiver;
        this.$context = $context2;
    }

    public void allowUseBookMark() {
        DefaultMenuItemClickListener defaultMenuItemClickListener;
        ICommonMenuContext commonMenuContext = this.this$0.getCommonMenuContext();
        if (commonMenuContext != null && (defaultMenuItemClickListener = commonMenuContext.getDefaultMenuItemClickListener()) != null) {
            defaultMenuItemClickListener.processStar(this.$context);
        }
    }

    public void loginFail() {
        DefaultMenuItemClickListener defaultMenuItemClickListener;
        ICommonMenuContext commonMenuContext = this.this$0.getCommonMenuContext();
        if (commonMenuContext != null && (defaultMenuItemClickListener = commonMenuContext.getDefaultMenuItemClickListener()) != null) {
            defaultMenuItemClickListener.uploadStarUbc("loginFail");
        }
    }
}
