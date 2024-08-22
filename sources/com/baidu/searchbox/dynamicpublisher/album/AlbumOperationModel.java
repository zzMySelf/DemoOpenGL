package com.baidu.searchbox.dynamicpublisher.album;

import com.baidu.searchbox.ugc.utils.SelectUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/album/AlbumOperationModel;", "", "type", "", "isUserSelectOriginal", "", "maxImageSize", "sourceFrom", "", "(IZILjava/lang/String;)V", "()Z", "getMaxImageSize", "()I", "getSourceFrom", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumModel.kt */
public final class AlbumOperationModel {
    private final boolean isUserSelectOriginal;
    private final int maxImageSize;
    private final String sourceFrom;
    private final int type;

    public AlbumOperationModel() {
        this(0, false, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AlbumOperationModel copy$default(AlbumOperationModel albumOperationModel, int i2, boolean z, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = albumOperationModel.type;
        }
        if ((i4 & 2) != 0) {
            z = albumOperationModel.isUserSelectOriginal;
        }
        if ((i4 & 4) != 0) {
            i3 = albumOperationModel.maxImageSize;
        }
        if ((i4 & 8) != 0) {
            str = albumOperationModel.sourceFrom;
        }
        return albumOperationModel.copy(i2, z, i3, str);
    }

    public final int component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isUserSelectOriginal;
    }

    public final int component3() {
        return this.maxImageSize;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final AlbumOperationModel copy(@AlbumType int i2, boolean z, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "sourceFrom");
        return new AlbumOperationModel(i2, z, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumOperationModel)) {
            return false;
        }
        AlbumOperationModel albumOperationModel = (AlbumOperationModel) obj;
        return this.type == albumOperationModel.type && this.isUserSelectOriginal == albumOperationModel.isUserSelectOriginal && this.maxImageSize == albumOperationModel.maxImageSize && Intrinsics.areEqual((Object) this.sourceFrom, (Object) albumOperationModel.sourceFrom);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.type) * 31;
        boolean z = this.isUserSelectOriginal;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.maxImageSize)) * 31) + this.sourceFrom.hashCode();
    }

    public String toString() {
        return "AlbumOperationModel(type=" + this.type + ", isUserSelectOriginal=" + this.isUserSelectOriginal + ", maxImageSize=" + this.maxImageSize + ", sourceFrom=" + this.sourceFrom + ')';
    }

    public AlbumOperationModel(@AlbumType int type2, boolean isUserSelectOriginal2, int maxImageSize2, String sourceFrom2) {
        Intrinsics.checkNotNullParameter(sourceFrom2, "sourceFrom");
        this.type = type2;
        this.isUserSelectOriginal = isUserSelectOriginal2;
        this.maxImageSize = maxImageSize2;
        this.sourceFrom = sourceFrom2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlbumOperationModel(int i2, boolean z, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? true : z, (i4 & 4) != 0 ? SelectUtil.MAX_SELECTED_DEFAULT : i3, (i4 & 8) != 0 ? "" : str);
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isUserSelectOriginal() {
        return this.isUserSelectOriginal;
    }

    public final int getMaxImageSize() {
        return this.maxImageSize;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }
}
