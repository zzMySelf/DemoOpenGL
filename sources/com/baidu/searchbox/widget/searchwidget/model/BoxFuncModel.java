package com.baidu.searchbox.widget.searchwidget.model;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/widget/searchwidget/model/BoxFuncModel;", "", "id", "", "content", "scheme", "order", "", "ext", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;)V", "getContent", "()Ljava/lang/String;", "getExt", "()Lorg/json/JSONObject;", "getId", "getOrder", "()I", "getScheme", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxFuncModel.kt */
public final class BoxFuncModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<BoxFuncModel> PRESET_SEARCH_HOT_WORD_MODEL$delegate = LazyKt.lazy(BoxFuncModel$Companion$PRESET_SEARCH_HOT_WORD_MODEL$2.INSTANCE);
    private final String content;
    private final JSONObject ext;
    private final String id;
    private final int order;
    private final String scheme;

    public static /* synthetic */ BoxFuncModel copy$default(BoxFuncModel boxFuncModel, String str, String str2, String str3, int i2, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = boxFuncModel.id;
        }
        if ((i3 & 2) != 0) {
            str2 = boxFuncModel.content;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = boxFuncModel.scheme;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i2 = boxFuncModel.order;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            jSONObject = boxFuncModel.ext;
        }
        return boxFuncModel.copy(str, str4, str5, i4, jSONObject);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.scheme;
    }

    public final int component4() {
        return this.order;
    }

    public final JSONObject component5() {
        return this.ext;
    }

    public final BoxFuncModel copy(String str, String str2, String str3, int i2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "scheme");
        return new BoxFuncModel(str, str2, str3, i2, jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxFuncModel)) {
            return false;
        }
        BoxFuncModel boxFuncModel = (BoxFuncModel) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) boxFuncModel.id) && Intrinsics.areEqual((Object) this.content, (Object) boxFuncModel.content) && Intrinsics.areEqual((Object) this.scheme, (Object) boxFuncModel.scheme) && this.order == boxFuncModel.order && Intrinsics.areEqual((Object) this.ext, (Object) boxFuncModel.ext);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.content.hashCode()) * 31) + this.scheme.hashCode()) * 31) + Integer.hashCode(this.order)) * 31;
        JSONObject jSONObject = this.ext;
        return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "BoxFuncModel(id=" + this.id + ", content=" + this.content + ", scheme=" + this.scheme + ", order=" + this.order + ", ext=" + this.ext + ')';
    }

    public BoxFuncModel(String id2, String content2, String scheme2, int order2, JSONObject ext2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(content2, "content");
        Intrinsics.checkNotNullParameter(scheme2, "scheme");
        this.id = id2;
        this.content = content2;
        this.scheme = scheme2;
        this.order = order2;
        this.ext = ext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BoxFuncModel(String str, String str2, String str3, int i2, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i2, (i3 & 16) != 0 ? null : jSONObject);
    }

    public final String getId() {
        return this.id;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getOrder() {
        return this.order;
    }

    public final JSONObject getExt() {
        return this.ext;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/widget/searchwidget/model/BoxFuncModel$Companion;", "", "()V", "PRESET_SEARCH_HOT_WORD_MODEL", "Lcom/baidu/searchbox/widget/searchwidget/model/BoxFuncModel;", "getPRESET_SEARCH_HOT_WORD_MODEL", "()Lcom/baidu/searchbox/widget/searchwidget/model/BoxFuncModel;", "PRESET_SEARCH_HOT_WORD_MODEL$delegate", "Lkotlin/Lazy;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BoxFuncModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BoxFuncModel getPRESET_SEARCH_HOT_WORD_MODEL() {
            return (BoxFuncModel) BoxFuncModel.PRESET_SEARCH_HOT_WORD_MODEL$delegate.getValue();
        }
    }
}
