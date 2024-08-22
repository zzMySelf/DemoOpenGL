package com.baidu.browser.menu.longpress.login;

import com.baidu.browser.menu.longpress.LongPressMenuItem;
import com.baidu.search.longpress.model.LongPressItemMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/browser/menu/longpress/LongPressMenuItem;", "invoke", "(Lcom/baidu/browser/menu/longpress/LongPressMenuItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemModeHelper.kt */
final class ItemModeHelper$updateMenuModes$2 extends Lambda implements Function1<LongPressMenuItem, Boolean> {
    public static final ItemModeHelper$updateMenuModes$2 INSTANCE = new ItemModeHelper$updateMenuModes$2();

    ItemModeHelper$updateMenuModes$2() {
        super(1);
    }

    public final Boolean invoke(LongPressMenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LongPressItemMode itemMode = it.getItemMode();
        boolean z = true;
        if (itemMode == null || !itemMode.getHidden()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
