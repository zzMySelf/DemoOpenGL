package com.baidu.searchbox.feed.ui.autoplay;

import android.view.ViewGroup;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;", "", "getBizUniqueKey", "", "getHolder", "Landroid/view/ViewGroup;", "getIndentity", "getPlayData", "Lorg/json/JSONObject;", "getShownPercent", "", "onPlayStart", "", "onPlayStop", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAutoPlay.kt */
public interface IAutoPlay {
    String getBizUniqueKey();

    ViewGroup getHolder();

    String getIndentity();

    JSONObject getPlayData();

    float getShownPercent();

    void onPlayStart();

    void onPlayStop();
}
