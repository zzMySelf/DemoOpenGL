package com.baidu.searchbox.widget.music.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicWidgetRepo.kt */
final class MusicWidgetRepo$parseSongList$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ JSONObject $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MusicWidgetRepo$parseSongList$1$1(JSONObject jSONObject) {
        super(0);
        this.$it = jSONObject;
    }

    public final String invoke() {
        return "parseSongList, json data error: " + this.$it;
    }
}
