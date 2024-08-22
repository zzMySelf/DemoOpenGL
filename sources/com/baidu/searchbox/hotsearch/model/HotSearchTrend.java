package com.baidu.searchbox.hotsearch.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/hotsearch/model/HotSearchTrend;", "", "(Ljava/lang/String;I)V", "UP", "DOWN", "SAME", "NONE", "Companion", "lib_hot_search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotSearchTrend.kt */
public enum HotSearchTrend {
    UP,
    DOWN,
    SAME,
    NONE;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/hotsearch/model/HotSearchTrend$Companion;", "", "()V", "fromString", "Lcom/baidu/searchbox/hotsearch/model/HotSearchTrend;", "string", "", "lib_hot_search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HotSearchTrend.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HotSearchTrend fromString(String string) {
            if (string == null) {
                return HotSearchTrend.NONE;
            }
            switch (string.hashCode()) {
                case 3739:
                    if (string.equals("up")) {
                        return HotSearchTrend.UP;
                    }
                    break;
                case 3089570:
                    if (string.equals("down")) {
                        return HotSearchTrend.DOWN;
                    }
                    break;
                case 3522662:
                    if (string.equals("same")) {
                        return HotSearchTrend.SAME;
                    }
                    break;
            }
            return HotSearchTrend.NONE;
        }
    }
}
