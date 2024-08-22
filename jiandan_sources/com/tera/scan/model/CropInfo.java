package com.tera.scan.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006."}, d2 = {"Lcom/tera/scan/model/CropInfo;", "Landroid/os/Parcelable;", "dest", "", "points", "", "Lcom/tera/scan/model/PointInfo;", "rotate", "", "src", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;FF)V", "getDest", "()Ljava/lang/String;", "getHeight", "()F", "setHeight", "(F)V", "getPoints", "()Ljava/util/List;", "getRotate", "()I", "getSrc", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "scan-model_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CropInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CropInfo> CREATOR = new qw();
    @NotNull
    public final String dest;
    public float height;
    @NotNull
    public final List<PointInfo> points;
    public final int rotate;
    @NotNull
    public final String src;
    public float width;

    public static final class qw implements Parcelable.Creator<CropInfo> {
        @NotNull
        /* renamed from: ad */
        public final CropInfo[] newArray(int i2) {
            return new CropInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final CropInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 != readInt; i2++) {
                arrayList.add(PointInfo.CREATOR.createFromParcel(parcel));
            }
            return new CropInfo(readString, arrayList, parcel.readInt(), parcel.readString(), parcel.readFloat(), parcel.readFloat());
        }
    }

    public CropInfo(@NotNull String str, @NotNull List<PointInfo> list, int i2, @NotNull String str2, float f, float f2) {
        Intrinsics.checkNotNullParameter(str, "dest");
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(str2, "src");
        this.dest = str;
        this.points = list;
        this.rotate = i2;
        this.src = str2;
        this.width = f;
        this.height = f2;
    }

    public static /* synthetic */ CropInfo copy$default(CropInfo cropInfo, String str, List<PointInfo> list, int i2, String str2, float f, float f2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cropInfo.dest;
        }
        if ((i3 & 2) != 0) {
            list = cropInfo.points;
        }
        List<PointInfo> list2 = list;
        if ((i3 & 4) != 0) {
            i2 = cropInfo.rotate;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = cropInfo.src;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            f = cropInfo.width;
        }
        float f3 = f;
        if ((i3 & 32) != 0) {
            f2 = cropInfo.height;
        }
        return cropInfo.copy(str, list2, i4, str3, f3, f2);
    }

    @NotNull
    public final String component1() {
        return this.dest;
    }

    @NotNull
    public final List<PointInfo> component2() {
        return this.points;
    }

    public final int component3() {
        return this.rotate;
    }

    @NotNull
    public final String component4() {
        return this.src;
    }

    public final float component5() {
        return this.width;
    }

    public final float component6() {
        return this.height;
    }

    @NotNull
    public final CropInfo copy(@NotNull String str, @NotNull List<PointInfo> list, int i2, @NotNull String str2, float f, float f2) {
        Intrinsics.checkNotNullParameter(str, "dest");
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(str2, "src");
        return new CropInfo(str, list, i2, str2, f, f2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CropInfo)) {
            return false;
        }
        CropInfo cropInfo = (CropInfo) obj;
        return Intrinsics.areEqual((Object) this.dest, (Object) cropInfo.dest) && Intrinsics.areEqual((Object) this.points, (Object) cropInfo.points) && this.rotate == cropInfo.rotate && Intrinsics.areEqual((Object) this.src, (Object) cropInfo.src) && Intrinsics.areEqual((Object) Float.valueOf(this.width), (Object) Float.valueOf(cropInfo.width)) && Intrinsics.areEqual((Object) Float.valueOf(this.height), (Object) Float.valueOf(cropInfo.height));
    }

    @NotNull
    public final String getDest() {
        return this.dest;
    }

    public final float getHeight() {
        return this.height;
    }

    @NotNull
    public final List<PointInfo> getPoints() {
        return this.points;
    }

    public final int getRotate() {
        return this.rotate;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((this.dest.hashCode() * 31) + this.points.hashCode()) * 31) + this.rotate) * 31) + this.src.hashCode()) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height);
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final void setWidth(float f) {
        this.width = f;
    }

    @NotNull
    public String toString() {
        return "CropInfo(dest=" + this.dest + ", points=" + this.points + ", rotate=" + this.rotate + ", src=" + this.src + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.dest);
        List<PointInfo> list = this.points;
        parcel.writeInt(list.size());
        for (PointInfo writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.rotate);
        parcel.writeString(this.src);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
    }
}
