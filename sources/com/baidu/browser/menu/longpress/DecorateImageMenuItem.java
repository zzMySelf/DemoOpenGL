package com.baidu.browser.menu.longpress;

import android.content.Context;
import com.baidu.android.common.menu.bottomlist.BottomCommonMenuItem;
import com.baidu.browser.R;
import com.baidu.search.longpress.model.LongPressItemMode;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.ng.browser.statistic.LongPressUBC;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/browser/menu/longpress/DecorateImageMenuItem;", "Lcom/baidu/browser/menu/longpress/LongPressMenuItem;", "context", "Landroid/content/Context;", "itemMode", "Lcom/baidu/search/longpress/model/LongPressItemMode;", "(Landroid/content/Context;Lcom/baidu/search/longpress/model/LongPressItemMode;)V", "initItem", "", "onItemClick", "menuContext", "Lcom/baidu/browser/menu/longpress/LongPressMenuContext;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressMenuItem.kt */
public final class DecorateImageMenuItem extends LongPressMenuItem {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DecorateImageMenuItem(Context context, LongPressItemMode longPressItemMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : longPressItemMode);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DecorateImageMenuItem(Context context, LongPressItemMode itemMode) {
        super(context, itemMode);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initItem(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.browser_search_menu_decorate_image);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…arch_menu_decorate_image)");
        setItem(new BottomCommonMenuItem(21, string, true));
        setSearchItemId(21);
        setSearchItemTextId(R.string.browser_search_menu_decorate_image);
        setItemType(2);
    }

    public void onItemClick(LongPressMenuContext menuContext) {
        Intrinsics.checkNotNullParameter(menuContext, "menuContext");
        String anchorUrl = menuContext.getAnchorUrl();
        if (!menuContext.windowIsNull() && anchorUrl != null) {
            String scheme = menuContext.createDecorateScheme(menuContext.createDecorateUrl(anchorUrl));
            CharSequence charSequence = scheme;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Router.invoke(getContext(), scheme);
            }
        }
        JSONObject ext = LongPressMenuItemKt.getExtObject(menuContext, (JSONObject) null);
        if (ext != null) {
            LongPressUBC.clickUBC(menuContext.getLastSource(), menuContext.getLastPage(), "zhuangban", ext);
        } else {
            LongPressUBC.click(menuContext.getLastSource(), menuContext.getLastPage(), "zhuangban");
        }
    }
}
