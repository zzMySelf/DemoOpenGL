package com.baidu.netdisk.trade.privilege.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001b\u0010\fJ \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b'\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\f¨\u0006,"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()J", "component3", "component4", "", "component5", "()Ljava/lang/String;", "growthLevel", "growthValue", "historyGrowthLevel", "historyGrowthValue", "v10Id", "copy", "(IJIJLjava/lang/String;)Lcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;", "describeContents", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getGrowthLevel", "J", "getGrowthValue", "getHistoryGrowthLevel", "getHistoryGrowthValue", "Ljava/lang/String;", "getV10Id", "<init>", "(IJIJLjava/lang/String;)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class LevelInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new qw();
    @SerializedName("current_level")

    /* renamed from: _  reason: collision with root package name */
    public final int f921_;
    @SerializedName("current_value")
    public final long __;
    @SerializedName("history_level")
    public final int ___;
    @SerializedName("history_value")
    public final long ____;
    @SerializedName("v10_id")
    @Nullable
    public final String _____;

    public static class qw implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LevelInfo(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i2) {
            return new LevelInfo[i2];
        }
    }

    public LevelInfo(int i2, long j, int i3, long j2, @Nullable String str) {
        this.f921_ = i2;
        this.__ = j;
        this.___ = i3;
        this.____ = j2;
        this._____ = str;
    }

    public final int _() {
        return this.f921_;
    }

    @Nullable
    public final String __() {
        return this._____;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelInfo)) {
            return false;
        }
        LevelInfo levelInfo = (LevelInfo) obj;
        return this.f921_ == levelInfo.f921_ && this.__ == levelInfo.__ && this.___ == levelInfo.___ && this.____ == levelInfo.____ && Intrinsics.areEqual((Object) this._____, (Object) levelInfo._____);
    }

    public int hashCode() {
        int qw2 = ((((((this.f921_ * 31) + defpackage.qw.qw(this.__)) * 31) + this.___) * 31) + defpackage.qw.qw(this.____)) * 31;
        String str = this._____;
        return qw2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LevelInfo(growthLevel=" + this.f921_ + ", growthValue=" + this.__ + ", historyGrowthLevel=" + this.___ + ", historyGrowthValue=" + this.____ + ", v10Id=" + this._____ + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.f921_);
        parcel.writeLong(this.__);
        parcel.writeInt(this.___);
        parcel.writeLong(this.____);
        parcel.writeString(this._____);
    }
}
