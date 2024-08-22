package com.baidu.browser.core.util;

public interface IThemeListener {
    boolean changeTheme(String str);

    String getCurrentTheme();

    String getCurrentThemeTag();

    boolean isSuperTheme();

    boolean isTheme();

    void resetnewtheme();
}
