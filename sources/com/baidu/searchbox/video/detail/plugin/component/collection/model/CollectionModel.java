package com.baidu.searchbox.video.detail.plugin.component.collection.model;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R*\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R\u001a\u00108\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001a\u0010>\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b¨\u0006A"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/collection/model/CollectionModel;", "", "()V", "collId", "", "getCollId", "()Ljava/lang/String;", "setCollId", "(Ljava/lang/String;)V", "collectionTitle", "getCollectionTitle", "setCollectionTitle", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "desc", "getDesc", "setDesc", "extJo", "Lorg/json/JSONObject;", "getExtJo", "()Lorg/json/JSONObject;", "setExtJo", "(Lorg/json/JSONObject;)V", "extRequest", "getExtRequest", "setExtRequest", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "hasPrev", "getHasPrev", "setHasPrev", "list", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "playNum", "getPlayNum", "setPlayNum", "showNum", "getShowNum", "setShowNum", "showOrderNum", "getShowOrderNum", "setShowOrderNum", "source", "getSource", "setSource", "tpl", "getTpl", "setTpl", "videoNum", "getVideoNum", "setVideoNum", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionModel.kt */
public final class CollectionModel {
    private String collId = "";
    private String collectionTitle = "";
    private int currentIndex;
    private String desc = "";
    private JSONObject extJo = new JSONObject();
    private JSONObject extRequest;
    private boolean hasNext;
    private boolean hasPrev;
    private ArrayList<FeedBaseModel> list = new ArrayList<>();
    private String playNum = "";
    private int showNum;
    private boolean showOrderNum = true;
    private String source = "";
    private String tpl = "";
    private String videoNum = "";

    public final boolean getHasPrev() {
        return this.hasPrev;
    }

    public final void setHasPrev(boolean z) {
        this.hasPrev = z;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public final int getShowNum() {
        return this.showNum;
    }

    public final void setShowNum(int i2) {
        this.showNum = i2;
    }

    public final String getCollectionTitle() {
        return this.collectionTitle;
    }

    public final void setCollectionTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.collectionTitle = str;
    }

    public final String getVideoNum() {
        return this.videoNum;
    }

    public final void setVideoNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoNum = str;
    }

    public final String getPlayNum() {
        return this.playNum;
    }

    public final void setPlayNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playNum = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final boolean getShowOrderNum() {
        return this.showOrderNum;
    }

    public final void setShowOrderNum(boolean z) {
        this.showOrderNum = z;
    }

    public final String getTpl() {
        return this.tpl;
    }

    public final void setTpl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tpl = str;
    }

    public final JSONObject getExtRequest() {
        return this.extRequest;
    }

    public final void setExtRequest(JSONObject jSONObject) {
        this.extRequest = jSONObject;
    }

    public final String getCollId() {
        return this.collId;
    }

    public final void setCollId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.collId = str;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i2) {
        this.currentIndex = i2;
    }

    public final ArrayList<FeedBaseModel> getList() {
        return this.list;
    }

    public final void setList(ArrayList<FeedBaseModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    public final JSONObject getExtJo() {
        return this.extJo;
    }

    public final void setExtJo(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.extJo = jSONObject;
    }
}
