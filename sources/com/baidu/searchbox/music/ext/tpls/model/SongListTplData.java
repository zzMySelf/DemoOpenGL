package com.baidu.searchbox.music.ext.tpls.model;

import com.baidu.searchbox.music.ext.model.ISong;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData;", "Lcom/baidu/searchbox/music/ext/tpls/model/ITplData;", "()V", "head", "Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "getHead", "()Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "items", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "getItems", "()Ljava/util/List;", "params", "Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;", "getParams", "()Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "Params", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SongListTplData.kt */
public final class SongListTplData implements ITplData {
    private final TplHeadData head = new TplHeadData();
    private final List<ISong> items = new ArrayList();
    private final Params params = new Params();
    private String tag = "";

    public final TplHeadData getHead() {
        return this.head;
    }

    public final List<ISong> getItems() {
        return this.items;
    }

    public final Params getParams() {
        return this.params;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;", "", "()V", "row", "", "getRow", "()I", "setRow", "(I)V", "showLike", "", "getShowLike", "()Z", "setShowLike", "(Z)V", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SongListTplData.kt */
    public static final class Params {
        private int row = 3;
        private boolean showLike;

        public final int getRow() {
            return this.row;
        }

        public final void setRow(int i2) {
            this.row = i2;
        }

        public final boolean getShowLike() {
            return this.showLike;
        }

        public final void setShowLike(boolean z) {
            this.showLike = z;
        }
    }
}
