package com.baidu.searchbox.home.feed;

import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/home/feed/Cache;", "", "()V", "Companion", "lib-ad-feed_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdVideoDetailBaseActivity.kt */
final class Cache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String[] whiteArrayTemp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/home/feed/Cache$Companion;", "", "()V", "whiteArray", "", "", "getWhiteArray", "()[Ljava/lang/String;", "whiteArrayTemp", "[Ljava/lang/String;", "lib-ad-feed_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdVideoDetailBaseActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getWhiteArray() {
            if (Cache.whiteArrayTemp == null) {
                String globalConfStr = ADConfigManager.instance().getGlobalConfStr("video_detail_float_white_list", "");
                Intrinsics.checkNotNullExpressionValue(globalConfStr, "instance().getGlobalConf…LOAT_VIEW_WHITE_LIST, \"\")");
                Object[] array = StringsKt.split$default((CharSequence) globalConfStr, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    Cache.whiteArrayTemp = (String[]) array;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
            String[] access$getWhiteArrayTemp$cp = Cache.whiteArrayTemp;
            Intrinsics.checkNotNull(access$getWhiteArrayTemp$cp);
            return access$getWhiteArrayTemp$cp;
        }
    }
}
