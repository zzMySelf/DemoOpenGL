package com.baidu.searchbox.feed.payment.model;

import com.google.gson.annotations.SerializedName;
import java.util.TreeMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/SpDetailSubscribeInfo;", "", "()V", "content", "Ljava/util/TreeMap;", "", "count", "lastArticle", "lastArticleTs", "shelfCmd", "state", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnDetailData.kt */
public final class SpDetailSubscribeInfo {
    @SerializedName("content")
    public final TreeMap<String, Object> content = new TreeMap<>();
    @SerializedName("subscribe_num")
    public String count = "";
    @SerializedName("last_article")
    public String lastArticle = "";
    @SerializedName("last_time")
    public String lastArticleTs = "";
    @SerializedName("shelf_cmd")
    public String shelfCmd = "";
    @SerializedName("subscribe_statue")
    public String state = "";
}
