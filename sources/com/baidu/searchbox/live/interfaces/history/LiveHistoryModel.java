package com.baidu.searchbox.live.interfaces.history;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryModel;", "", "()V", "cmd", "", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "extra", "getExtra", "setExtra", "feature", "Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;", "getFeature", "()Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;", "setFeature", "(Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;)V", "img", "getImg", "setImg", "title", "getTitle", "setTitle", "tplId", "getTplId", "setTplId", "tts", "getTts", "setTts", "ukey", "getUkey", "setUkey", "url", "getUrl", "setUrl", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveHistoryModel.kt */
public final class LiveHistoryModel {
    private String cmd;
    private long createTime;
    private String extra;
    private LiveHistoryFeature feature;
    private String img;
    private String title;
    private String tplId;
    private String tts;
    private String ukey;
    private String url;

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        this.cmd = str;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final LiveHistoryFeature getFeature() {
        return this.feature;
    }

    public final void setFeature(LiveHistoryFeature liveHistoryFeature) {
        this.feature = liveHistoryFeature;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getTplId() {
        return this.tplId;
    }

    public final void setTplId(String str) {
        this.tplId = str;
    }

    public final String getTts() {
        return this.tts;
    }

    public final void setTts(String str) {
        this.tts = str;
    }

    public final String getUkey() {
        return this.ukey;
    }

    public final void setUkey(String str) {
        this.ukey = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
