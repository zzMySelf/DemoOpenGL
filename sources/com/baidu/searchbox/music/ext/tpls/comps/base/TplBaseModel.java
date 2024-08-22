package com.baidu.searchbox.music.ext.tpls.comps.base;

import com.baidu.searchbox.music.ext.mymusic.style.CardStyle;
import com.baidu.searchbox.music.ext.tpls.model.TplHeadData;
import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/music/ext/tpls/comps/base/TplBaseModel;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "()V", "cardStyle", "Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;", "getCardStyle", "()Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;", "setCardStyle", "(Lcom/baidu/searchbox/music/ext/mymusic/style/CardStyle;)V", "head", "Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "getHead", "()Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;", "setHead", "(Lcom/baidu/searchbox/music/ext/tpls/model/TplHeadData;)V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TplBaseModel.kt */
public abstract class TplBaseModel implements IAdapterData {
    private TplHeadData head;
    private String source = "";
    private UniqueId token;

    public abstract CardStyle getCardStyle();

    public abstract void setCardStyle(CardStyle cardStyle);

    public TplHeadData getHead() {
        return this.head;
    }

    public void setHead(TplHeadData tplHeadData) {
        this.head = tplHeadData;
    }

    public UniqueId getToken() {
        return this.token;
    }

    public void setToken(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }
}
