package com.baidu.searchbox.download.center.ui.search.adapter;

import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.home.tabs.HomeTabTextHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/adapter/Constants;", "", "()V", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Constants.kt */
public final class Constants {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HISTORY_MAX_LIMIT = 9;
    public static final int RECOMMEND_MAX_LIMIT = 10;
    /* access modifiers changed from: private */
    public static final Map<Integer, Integer> REC_TYPE_IMAGE_MAP = MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(R.drawable.download_center_search_rec_video_icon)), TuplesKt.to(4, Integer.valueOf(R.drawable.download_center_search_rec_doc_icon)), TuplesKt.to(3, Integer.valueOf(R.drawable.download_center_search_rec_app_icon)), TuplesKt.to(11, Integer.valueOf(R.drawable.download_center_search_rec_web_icon)), TuplesKt.to(8, Integer.valueOf(R.drawable.download_center_search_rec_zip_icon)), TuplesKt.to(1, Integer.valueOf(R.drawable.download_center_search_rec_music_icon)));
    public static final int RESULT_CHARACTERS_20 = 20;
    public static final int RESULT_MAX_LIMIT = 4;
    public static final int TYPE_HEADER = 10000;
    public static final int TYPE_HISTORY_ITEM = 2;
    public static final int TYPE_HISTORY_LIST = 3;
    public static final int TYPE_TAIL = 10001;
    /* access modifiers changed from: private */
    public static final Map<Integer, String> TYPE_TEXT_MAP = MapsKt.mapOf(TuplesKt.to(0, HomeTabTextHolder.VIDEO_TAB_TEXT), TuplesKt.to(4, "文档"), TuplesKt.to(3, "应用"), TuplesKt.to(11, "网页"), TuplesKt.to(8, "压缩文件"), TuplesKt.to(1, "音频"));
    public static final String UNKNOWN_TYPE = "其他";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/adapter/Constants$Companion;", "", "()V", "HISTORY_MAX_LIMIT", "", "RECOMMEND_MAX_LIMIT", "REC_TYPE_IMAGE_MAP", "", "getREC_TYPE_IMAGE_MAP", "()Ljava/util/Map;", "RESULT_CHARACTERS_20", "RESULT_MAX_LIMIT", "TYPE_HEADER", "TYPE_HISTORY_ITEM", "TYPE_HISTORY_LIST", "TYPE_TAIL", "TYPE_TEXT_MAP", "", "getTYPE_TEXT_MAP", "UNKNOWN_TYPE", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Constants.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, String> getTYPE_TEXT_MAP() {
            return Constants.TYPE_TEXT_MAP;
        }

        public final Map<Integer, Integer> getREC_TYPE_IMAGE_MAP() {
            return Constants.REC_TYPE_IMAGE_MAP;
        }
    }
}
