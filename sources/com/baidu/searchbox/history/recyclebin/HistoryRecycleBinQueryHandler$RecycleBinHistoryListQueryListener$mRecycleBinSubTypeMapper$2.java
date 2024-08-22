package com.baidu.searchbox.history.recyclebin;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HistoryRecycleBinQueryHandler.kt */
final class HistoryRecycleBinQueryHandler$RecycleBinHistoryListQueryListener$mRecycleBinSubTypeMapper$2 extends Lambda implements Function0<HashMap<String, Integer>> {
    public static final HistoryRecycleBinQueryHandler$RecycleBinHistoryListQueryListener$mRecycleBinSubTypeMapper$2 INSTANCE = new HistoryRecycleBinQueryHandler$RecycleBinHistoryListQueryListener$mRecycleBinSubTypeMapper$2();

    HistoryRecycleBinQueryHandler$RecycleBinHistoryListQueryListener$mRecycleBinSubTypeMapper$2() {
        super(0);
    }

    public final HashMap<String, Integer> invoke() {
        return MapsKt.hashMapOf(TuplesKt.to("feed_text", 25), TuplesKt.to("feed_image", 26), TuplesKt.to("feed_atlas", 2), TuplesKt.to("feed_video", 21), TuplesKt.to("feed_minivideo", 21), TuplesKt.to("feed_live", 3), TuplesKt.to("feed_ad", 19), TuplesKt.to("activity_text", 25), TuplesKt.to("activity_image", 26), TuplesKt.to("activity_atlas", 2), TuplesKt.to("activity_video", 21), TuplesKt.to("activity_repost", 5), TuplesKt.to("mars_text", 17), TuplesKt.to("mars_image", 17), TuplesKt.to("mars_atlas", 17), TuplesKt.to("mars_video", 17), TuplesKt.to("mars_live", 17), TuplesKt.to("mars_sale", 17), TuplesKt.to("qa_question_text", 27), TuplesKt.to("qa_answer_text", 30), TuplesKt.to("qa_question_image", 28), TuplesKt.to("search_text_name", 18), TuplesKt.to("search_text_url", 18), TuplesKt.to("search_video", 21), TuplesKt.to("search_minivideo", 21), TuplesKt.to("mercury_default", 17), TuplesKt.to("splash_image", 19));
    }
}
