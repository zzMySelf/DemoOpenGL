package com.baidu.chatsearch.menu.longpress.chatsearch;

import android.content.Context;
import com.baidu.chatsearch.menu.longpress.chatsearch.helper.ILongPressMenuHelper;
import com.baidu.search.longpress.model.LongPressItemMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/chatsearch/menu/longpress/chatsearch/TextLongPressMenuBuilder;", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/BaseLongPressMenuBuilder;", "()V", "createMenuList", "Ljava/util/ArrayList;", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/ChatSearchLongPressMenuItem;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "helper", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/helper/ILongPressMenuHelper;", "lib-chatsearch-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchLongPressMenuBuilder.kt */
public final class TextLongPressMenuBuilder extends BaseLongPressMenuBuilder {
    public ArrayList<ChatSearchLongPressMenuItem> createMenuList(Context context, ILongPressMenuHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        ArrayList list = new ArrayList();
        if (context == null) {
            return list;
        }
        list.add(new CopyTextMenuItemChatSearch(context, (LongPressItemMode) null, 2, (DefaultConstructorMarker) null));
        list.add(new CopyMenuItemChatSearch(context, (LongPressItemMode) null, 2, (DefaultConstructorMarker) null));
        return list;
    }
}
