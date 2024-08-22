package com.baidu.searchbox.textselectmenu;

import com.baidu.android.widget.textselect.core.BdTextSelectHelper;
import com.baidu.android.widget.textselect.menu.IDefaultMenuBuilder;
import com.baidu.android.widget.textselect.menu.ITextSelectMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/textselectmenu/DefaultTextMenuBuilderImpl;", "Lcom/baidu/android/widget/textselect/menu/IDefaultMenuBuilder;", "()V", "buildDefaultMenu", "Lcom/baidu/android/widget/textselect/menu/ITextSelectMenu;", "textSelectHelper", "Lcom/baidu/android/widget/textselect/core/BdTextSelectHelper;", "lib-floatmenu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTextMenuBuilderImpl.kt */
public final class DefaultTextMenuBuilderImpl implements IDefaultMenuBuilder {
    public ITextSelectMenu buildDefaultMenu(BdTextSelectHelper textSelectHelper) {
        Intrinsics.checkNotNullParameter(textSelectHelper, "textSelectHelper");
        DefaultTextSelectMenu defaultMenu = new DefaultTextSelectMenu();
        defaultMenu.bindTextSelectHelper(textSelectHelper);
        return defaultMenu.getMenuStub();
    }
}
