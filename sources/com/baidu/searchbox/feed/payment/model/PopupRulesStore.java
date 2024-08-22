package com.baidu.searchbox.feed.payment.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/PopupRulesStore;", "Lcom/baidu/searchbox/feed/payment/model/ObjectPersistable;", "Lcom/baidu/searchbox/feed/payment/model/DataSource;", "popupType", "", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "pid", "getPid", "()Ljava/lang/String;", "setPid", "timeMillis", "", "getTimeMillis", "()J", "setTimeMillis", "(J)V", "triggered", "", "getTriggered", "()Z", "setTriggered", "(Z)V", "commit", "", "copyTo", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupRules.kt */
public class PopupRulesStore extends ObjectPersistable implements DataSource {
    @SerializedName("count")
    private int count;
    @SerializedName("pid")
    private String pid = "";
    @SerializedName("time")
    private long timeMillis;
    @SerializedName("triggered")
    private boolean triggered;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PopupRulesStore(String popupType) {
        super(popupType, PopupRulesStore.class);
        Intrinsics.checkNotNullParameter(popupType, "popupType");
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pid = str;
    }

    public long getTimeMillis() {
        return this.timeMillis;
    }

    public void setTimeMillis(long j2) {
        this.timeMillis = j2;
    }

    public boolean getTriggered() {
        return this.triggered;
    }

    public void setTriggered(boolean z) {
        this.triggered = z;
    }

    public void commit() {
        ObjectDao.upsertEntity(this);
    }

    public final PopupRulesStore copyTo(String popupType) {
        Intrinsics.checkNotNullParameter(popupType, "popupType");
        PopupRulesStore store = new PopupRulesStore(popupType);
        store.setCount(getCount());
        store.setPid(getPid());
        store.setTimeMillis(getTimeMillis());
        store.setTriggered(getTriggered());
        return store;
    }
}
