package com.tera.scan.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/tera/scan/model/PointInfo;", "Landroid/os/Parcelable;", "dx", "", "dy", "(FF)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "scan-model_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PointInfo> CREATOR = new qw();
    public float dx;
    public float dy;

    public static final class qw implements Parcelable.Creator<PointInfo> {
        @NotNull
        /* renamed from: ad */
        public final PointInfo[] newArray(int i2) {
            return new PointInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final PointInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PointInfo(parcel.readFloat(), parcel.readFloat());
        }
    }

    public PointInfo(float f, float f2) {
        this.dx = f;
        this.dy = f2;
    }

    public static /* synthetic */ PointInfo copy$default(PointInfo pointInfo, float f, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = pointInfo.dx;
        }
        if ((i2 & 2) != 0) {
            f2 = pointInfo.dy;
        }
        return pointInfo.copy(f, f2);
    }

    public final float component1() {
        return this.dx;
    }

    public final float component2() {
        return this.dy;
    }

    @NotNull
    public final PointInfo copy(float f, float f2) {
        return new PointInfo(f, f2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointInfo)) {
            return false;
        }
        PointInfo pointInfo = (PointInfo) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.dx), (Object) Float.valueOf(pointInfo.dx)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy), (Object) Float.valueOf(pointInfo.dy));
    }

    public final float getDx() {
        return this.dx;
    }

    public final float getDy() {
        return this.dy;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
    }

    public final void setDx(float f) {
        this.dx = f;
    }

    public final void setDy(float f) {
        this.dy = f;
    }

    @NotNull
    public String toString() {
        return "PointInfo(dx=" + this.dx + ", dy=" + this.dy + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeFloat(this.dx);
        parcel.writeFloat(this.dy);
    }
}
