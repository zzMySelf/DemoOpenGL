package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.search.webvideo.update.SearchH5VideoDownloadListenerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5AbManager.kt */
final class SearchH5AbManager$showDownloadBtn$2 extends Lambda implements Function0<Boolean> {
    public static final SearchH5AbManager$showDownloadBtn$2 INSTANCE = new SearchH5AbManager$showDownloadBtn$2();

    SearchH5AbManager$showDownloadBtn$2() {
        super(0);
    }

    public final Boolean invoke() {
        boolean z = true;
        if (PreferenceUtils.getInt(SearchH5VideoDownloadListenerKt.KEY_DOWNLOAD_SWITCH, 1) != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
