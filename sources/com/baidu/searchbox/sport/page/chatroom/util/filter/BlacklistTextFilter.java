package com.baidu.searchbox.sport.page.chatroom.util.filter;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/util/filter/BlacklistTextFilter;", "Lcom/baidu/searchbox/sport/page/chatroom/util/filter/TextFilter;", "blacklist", "", "Lkotlin/ranges/CharRange;", "(Ljava/util/List;)V", "apply", "", "input", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BlacklistTextFilter.kt */
public final class BlacklistTextFilter implements TextFilter {
    private final List<CharRange> blacklist;

    public BlacklistTextFilter(List<CharRange> blacklist2) {
        Intrinsics.checkNotNullParameter(blacklist2, "blacklist");
        this.blacklist = blacklist2;
    }

    public String apply(String input) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(input, "input");
        CharSequence $this$filterNotTo$iv$iv = input;
        Appendable destination$iv$iv = new StringBuilder();
        for (int i2 = 0; i2 < $this$filterNotTo$iv$iv.length(); i2++) {
            char element$iv$iv = $this$filterNotTo$iv$iv.charAt(i2);
            char c2 = element$iv$iv;
            Iterator it = this.blacklist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                if (((CharRange) element$iv).contains(c2)) {
                    break;
                }
            }
            if (!(element$iv != null)) {
                destination$iv$iv.append(element$iv$iv);
            }
        }
        String sb = ((StringBuilder) destination$iv$iv).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb;
    }
}
