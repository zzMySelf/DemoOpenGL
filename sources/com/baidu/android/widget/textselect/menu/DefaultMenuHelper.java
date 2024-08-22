package com.baidu.android.widget.textselect.menu;

import com.baidu.searchbox.textselectmenu.DefaultTextMenuBuilderImpl_Factory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/android/widget/textselect/menu/DefaultMenuHelper;", "", "()V", "defaultBuilder", "Lcom/baidu/android/widget/textselect/menu/IDefaultMenuBuilder;", "getDefaultMenuBuilder", "lib-selectable-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultMenuHelper.kt */
public final class DefaultMenuHelper {
    public static final DefaultMenuHelper INSTANCE = new DefaultMenuHelper();
    private static IDefaultMenuBuilder defaultBuilder = new DefaultMenuHelper$defaultBuilder$1();

    private DefaultMenuHelper() {
    }

    public final IDefaultMenuBuilder getDefaultMenuBuilder() {
        return DefaultTextMenuBuilderImpl_Factory.get();
    }
}
