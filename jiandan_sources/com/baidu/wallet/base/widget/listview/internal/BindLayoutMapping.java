package com.baidu.wallet.base.widget.listview.internal;

public class BindLayoutMapping {
    public static String getLayoutId(Class<?> cls) {
        BindLayout bindLayout = (BindLayout) cls.getAnnotation(BindLayout.class);
        return bindLayout != null ? bindLayout.value() : "";
    }
}
