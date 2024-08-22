package com.baidu.searchbox.music.ext.mymusic.comp.song.model;

import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.mymusic.style.CardStyle;
import com.baidu.searchbox.music.ext.mymusic.style.SongListTplStyle;
import com.baidu.searchbox.music.ext.tpls.comps.base.TplBaseModel;
import com.baidu.searchbox.music.ext.tpls.model.SongListTplData;
import com.baidu.searchbox.music.ext.tpls.model.TplHeadData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 /2\u00020\u0001:\u0001/B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010.\u001a\u00020\u0005H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/song/model/SongListModel;", "Lcom/baidu/searchbox/music/ext/tpls/comps/base/TplBaseModel;", "songListTplData", "Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "cardStyle", "Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;", "style", "Lcom/baidu/searchbox/music/ext/mymusic/style/SongListTplStyle;", "(Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData;Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;Lcom/baidu/searchbox/music/ext/mymusic/style/SongListTplStyle;)V", "getCardStyle", "()Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;", "setCardStyle", "(Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;)V", "head", "Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "getHead", "()Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "setHead", "(Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;)V", "items", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "params", "Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;", "getParams", "()Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;", "setParams", "(Lcom/baidu/searchbox/music/ext/tpls/model/SongListTplData$Params;)V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getStyle", "()Lcom/baidu/searchbox/music/ext/mymusic/style/SongListTplStyle;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getType", "Companion", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SongListModel.kt */
public final class SongListModel extends TplBaseModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId TYPE;
    private CardStyle cardStyle;
    private TplHeadData head;
    private List<ISong> items;
    private SongListTplData.Params params;
    private String source;
    private final SongListTplStyle style;
    private UniqueId token;

    public CardStyle getCardStyle() {
        return this.cardStyle;
    }

    public UniqueId getToken() {
        return this.token;
    }

    public void setCardStyle(CardStyle cardStyle2) {
        Intrinsics.checkNotNullParameter(cardStyle2, "<set-?>");
        this.cardStyle = cardStyle2;
    }

    public void setToken(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public SongListModel(SongListTplData songListTplData, UniqueId token2, CardStyle cardStyle2, SongListTplStyle style2) {
        Intrinsics.checkNotNullParameter(songListTplData, "songListTplData");
        Intrinsics.checkNotNullParameter(cardStyle2, "cardStyle");
        Intrinsics.checkNotNullParameter(style2, "style");
        this.token = token2;
        this.cardStyle = cardStyle2;
        this.style = style2;
        this.head = songListTplData.getHead();
        this.items = songListTplData.getItems();
        this.params = songListTplData.getParams();
        this.source = songListTplData.getTag();
    }

    public final SongListTplStyle getStyle() {
        return this.style;
    }

    public TplHeadData getHead() {
        return this.head;
    }

    public void setHead(TplHeadData tplHeadData) {
        this.head = tplHeadData;
    }

    public final List<ISong> getItems() {
        return this.items;
    }

    public final void setItems(List<ISong> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final SongListTplData.Params getParams() {
        return this.params;
    }

    public final void setParams(SongListTplData.Params params2) {
        Intrinsics.checkNotNullParameter(params2, "<set-?>");
        this.params = params2;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/song/model/SongListModel$Companion;", "", "()V", "TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getTYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SongListModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getTYPE() {
            return SongListModel.TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("MusicListModel");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"MusicListModel\")");
        TYPE = gen;
    }

    public UniqueId getType() {
        return TYPE;
    }
}
