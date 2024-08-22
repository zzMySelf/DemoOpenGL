package com.baidu.browser.utils;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchChatUtils.kt */
final class SearchChatUtilsKt$DEFAULT_BOT_LIST$2 extends Lambda implements Function0<ArrayList<String>> {
    public static final SearchChatUtilsKt$DEFAULT_BOT_LIST$2 INSTANCE = new SearchChatUtilsKt$DEFAULT_BOT_LIST$2();

    SearchChatUtilsKt$DEFAULT_BOT_LIST$2() {
        super(0);
    }

    public final ArrayList<String> invoke() {
        return CollectionsKt.arrayListOf("bot");
    }
}
