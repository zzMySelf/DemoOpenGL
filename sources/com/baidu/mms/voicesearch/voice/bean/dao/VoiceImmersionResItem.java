package com.baidu.mms.voicesearch.voice.bean.dao;

import com.baidu.ttsplugin.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/bean/dao/VoiceImmersionResItem;", "", "resourceUrl", "", "id", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getResourceUrl", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceImmersionResModel.kt */
public final class VoiceImmersionResItem {
    @SerializedName("id")
    private final String id;
    @SerializedName("resource_url")
    private final String resourceUrl;
    @SerializedName("version")
    private final String version;

    public VoiceImmersionResItem() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VoiceImmersionResItem copy$default(VoiceImmersionResItem voiceImmersionResItem, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = voiceImmersionResItem.resourceUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = voiceImmersionResItem.id;
        }
        if ((i2 & 4) != 0) {
            str3 = voiceImmersionResItem.version;
        }
        return voiceImmersionResItem.copy(str, str2, str3);
    }

    public final String component1() {
        return this.resourceUrl;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.version;
    }

    public final VoiceImmersionResItem copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "resourceUrl");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "version");
        return new VoiceImmersionResItem(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoiceImmersionResItem)) {
            return false;
        }
        VoiceImmersionResItem voiceImmersionResItem = (VoiceImmersionResItem) obj;
        return Intrinsics.areEqual((Object) this.resourceUrl, (Object) voiceImmersionResItem.resourceUrl) && Intrinsics.areEqual((Object) this.id, (Object) voiceImmersionResItem.id) && Intrinsics.areEqual((Object) this.version, (Object) voiceImmersionResItem.version);
    }

    public int hashCode() {
        return (((this.resourceUrl.hashCode() * 31) + this.id.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "VoiceImmersionResItem(resourceUrl=" + this.resourceUrl + ", id=" + this.id + ", version=" + this.version + ')';
    }

    public VoiceImmersionResItem(String resourceUrl2, String id2, String version2) {
        Intrinsics.checkNotNullParameter(resourceUrl2, "resourceUrl");
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(version2, "version");
        this.resourceUrl = resourceUrl2;
        this.id = id2;
        this.version = version2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoiceImmersionResItem(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getVersion() {
        return this.version;
    }
}
