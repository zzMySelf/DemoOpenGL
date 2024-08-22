package com.baidu.searchbox.entry;

import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.kmm.home.tab.HomeSecondTabTypeUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/entry/MessageHomeBarManager;", "", "()V", "isHome2Bar", "", "isHome4Bar", "isHomeBar", "lib-message_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageHomeBarManager.kt */
public final class MessageHomeBarManager {
    public static final MessageHomeBarManager INSTANCE = new MessageHomeBarManager();

    private MessageHomeBarManager() {
    }

    private final boolean isHome2Bar() {
        return HomeSecondTabTypeUtils.INSTANCE.isSecondTabTypeMessage();
    }

    private final boolean isHome4Bar() {
        return HomeFourthTabTypeUtils.INSTANCE.isFourthTabTypeMessage();
    }

    public final boolean isHomeBar() {
        return isHome2Bar() || isHome4Bar();
    }
}
