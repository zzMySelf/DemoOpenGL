package com.baidu.searchbox.search.mix.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.env.PlayerRuntime;
import com.baidu.searchbox.search.mix.player.SearchPageAPlayer;
import com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper;
import com.baidu.searchbox.search.video.preboot.SearchMixPlayerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/search/mix/helper/SearchNaListPlayerHelper;", "Lcom/baidu/searchbox/search/tab/implement/player/helper/ListPlayerHelper;", "business", "", "player", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "(ILcom/baidu/searchbox/player/BaseVideoPlayer;)V", "createNormalPlayer", "context", "Landroid/content/Context;", "getMuteSource", "", "getPreparedPlayer", "videoInfo", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchNaListPlayerHelper.kt */
public final class SearchNaListPlayerHelper extends ListPlayerHelper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchNaListPlayerHelper(int business, BaseVideoPlayer player) {
        super(business, player);
        Intrinsics.checkNotNullParameter(player, "player");
    }

    /* access modifiers changed from: protected */
    public BaseVideoPlayer getPreparedPlayer(Context context, String videoInfo) {
        String preparedVid = SearchMixPlayerHelper.INSTANCE.fetchPrepareVid();
        if (!TextUtils.isEmpty(preparedVid)) {
            boolean z = true;
            String str = null;
            if (videoInfo == null || !StringsKt.contains$default((CharSequence) videoInfo, (CharSequence) String.valueOf(preparedVid), false, 2, (Object) null)) {
                z = false;
            }
            if (z) {
                long inTime = System.currentTimeMillis();
                if (AppConfig.isDebug()) {
                    Log.v("video_speed", "getPreparedPlayer preparedVid = " + preparedVid);
                }
                if (preparedVid != null) {
                    str = PlayerRuntime.toPlayerKey(preparedVid);
                }
                SearchPageAPlayer player = new SearchPageAPlayer(context, str);
                if (AppConfig.isDebug()) {
                    Log.v("video_speed", "getPreparedPlayer create player cost = " + (System.currentTimeMillis() - inTime));
                }
                return player;
            }
        }
        if (AppConfig.isDebug()) {
            Log.v("video_speed", "getPreparedPlayer vid is empty");
        }
        return super.getPreparedPlayer(context, videoInfo);
    }

    /* access modifiers changed from: protected */
    public BaseVideoPlayer createNormalPlayer(Context context) {
        String fetchPrepareVid = SearchMixPlayerHelper.INSTANCE.fetchPrepareVid();
        return new SearchPageAPlayer(context, fetchPrepareVid != null ? PlayerRuntime.toPlayerKey(fetchPrepareVid) : null);
    }

    /* access modifiers changed from: protected */
    public String getMuteSource() {
        return "A";
    }
}
