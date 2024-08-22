package com.baidu.searchbox.feed.model.gson.bean;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/bean/QuestionFollowBean;", "Lcom/baidu/searchbox/NoProGuard;", "status", "", "addApi", "cancelApi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddApi", "()Ljava/lang/String;", "getCancelApi", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBarBean.kt */
public final class QuestionFollowBean implements NoProGuard {
    @SerializedName("add_api")
    private final String addApi;
    @SerializedName("cancel_api")
    private final String cancelApi;
    private final String status;

    public QuestionFollowBean() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QuestionFollowBean copy$default(QuestionFollowBean questionFollowBean, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = questionFollowBean.status;
        }
        if ((i2 & 2) != 0) {
            str2 = questionFollowBean.addApi;
        }
        if ((i2 & 4) != 0) {
            str3 = questionFollowBean.cancelApi;
        }
        return questionFollowBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.addApi;
    }

    public final String component3() {
        return this.cancelApi;
    }

    public final QuestionFollowBean copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "addApi");
        Intrinsics.checkNotNullParameter(str3, "cancelApi");
        return new QuestionFollowBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionFollowBean)) {
            return false;
        }
        QuestionFollowBean questionFollowBean = (QuestionFollowBean) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) questionFollowBean.status) && Intrinsics.areEqual((Object) this.addApi, (Object) questionFollowBean.addApi) && Intrinsics.areEqual((Object) this.cancelApi, (Object) questionFollowBean.cancelApi);
    }

    public int hashCode() {
        return (((this.status.hashCode() * 31) + this.addApi.hashCode()) * 31) + this.cancelApi.hashCode();
    }

    public String toString() {
        return "QuestionFollowBean(status=" + this.status + ", addApi=" + this.addApi + ", cancelApi=" + this.cancelApi + ')';
    }

    public QuestionFollowBean(String status2, String addApi2, String cancelApi2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(addApi2, "addApi");
        Intrinsics.checkNotNullParameter(cancelApi2, "cancelApi");
        this.status = status2;
        this.addApi = addApi2;
        this.cancelApi = cancelApi2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuestionFollowBean(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getAddApi() {
        return this.addApi;
    }

    public final String getCancelApi() {
        return this.cancelApi;
    }
}
