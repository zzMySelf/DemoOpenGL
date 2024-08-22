package com.tera.scan.record.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\b\u00102\u001a\u0004\u0018\u00010\u0003J\t\u00103\u001a\u00020\tHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\tHÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u0006:"}, d2 = {"Lcom/tera/scan/record/model/ScanRecord;", "Landroid/os/Parcelable;", "name", "", "displayName", "recordId", "modifyTime", "", "category", "", "savePath", "createTime", "openTime", "pictureList", "", "Lcom/tera/scan/record/model/ScanRecordFile;", "exportType", "isDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;JJLjava/util/List;Ljava/lang/String;I)V", "getCategory", "()I", "getCreateTime", "()J", "getDisplayName", "()Ljava/lang/String;", "getExportType", "getModifyTime", "getName", "getOpenTime", "getPictureList", "()Ljava/util/List;", "getRecordId", "getSavePath", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "firstPictureLocalPath", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanRecord implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ScanRecord> CREATOR = new qw();
    @SerializedName("category")
    public final int category;
    @SerializedName("ctime")
    public final long createTime;
    @SerializedName("displayName")
    @Nullable
    public final String displayName;
    @SerializedName("export_type")
    @NotNull
    public final String exportType;
    @SerializedName("is_delete")
    public final int isDelete;
    @SerializedName("mtime")
    public final long modifyTime;
    @SerializedName("name")
    @NotNull
    public final String name;
    @SerializedName("open_time")
    public final long openTime;
    @SerializedName("piclistinfo")
    @NotNull
    public final List<ScanRecordFile> pictureList;
    @SerializedName("record_id")
    @NotNull
    public final String recordId;
    @SerializedName("savePath")
    @Nullable
    public final String savePath;

    public static final class qw implements Parcelable.Creator<ScanRecord> {
        @NotNull
        /* renamed from: ad */
        public final ScanRecord[] newArray(int i2) {
            return new ScanRecord[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ScanRecord createFromParcel(@NotNull Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString4 = parcel.readString();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList.add(ScanRecordFile.CREATOR.createFromParcel(parcel2));
            }
            return new ScanRecord(readString, readString2, readString3, readLong, readInt, readString4, readLong2, readLong3, arrayList, parcel.readString(), parcel.readInt());
        }
    }

    public ScanRecord(@NotNull String str, @Nullable String str2, @NotNull String str3, long j, int i2, @Nullable String str4, long j2, long j3, @NotNull List<ScanRecordFile> list, @NotNull String str5, int i3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str3, "recordId");
        Intrinsics.checkNotNullParameter(list, "pictureList");
        Intrinsics.checkNotNullParameter(str5, "exportType");
        this.name = str;
        this.displayName = str2;
        this.recordId = str3;
        this.modifyTime = j;
        this.category = i2;
        this.savePath = str4;
        this.createTime = j2;
        this.openTime = j3;
        this.pictureList = list;
        this.exportType = str5;
        this.isDelete = i3;
    }

    public static /* synthetic */ ScanRecord copy$default(ScanRecord scanRecord, String str, String str2, String str3, long j, int i2, String str4, long j2, long j3, List list, String str5, int i3, int i4, Object obj) {
        ScanRecord scanRecord2 = scanRecord;
        int i5 = i4;
        return scanRecord.copy((i5 & 1) != 0 ? scanRecord2.name : str, (i5 & 2) != 0 ? scanRecord2.displayName : str2, (i5 & 4) != 0 ? scanRecord2.recordId : str3, (i5 & 8) != 0 ? scanRecord2.modifyTime : j, (i5 & 16) != 0 ? scanRecord2.category : i2, (i5 & 32) != 0 ? scanRecord2.savePath : str4, (i5 & 64) != 0 ? scanRecord2.createTime : j2, (i5 & 128) != 0 ? scanRecord2.openTime : j3, (i5 & 256) != 0 ? scanRecord2.pictureList : list, (i5 & 512) != 0 ? scanRecord2.exportType : str5, (i5 & 1024) != 0 ? scanRecord2.isDelete : i3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component10() {
        return this.exportType;
    }

    public final int component11() {
        return this.isDelete;
    }

    @Nullable
    public final String component2() {
        return this.displayName;
    }

    @NotNull
    public final String component3() {
        return this.recordId;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final int component5() {
        return this.category;
    }

    @Nullable
    public final String component6() {
        return this.savePath;
    }

    public final long component7() {
        return this.createTime;
    }

    public final long component8() {
        return this.openTime;
    }

    @NotNull
    public final List<ScanRecordFile> component9() {
        return this.pictureList;
    }

    @NotNull
    public final ScanRecord copy(@NotNull String str, @Nullable String str2, @NotNull String str3, long j, int i2, @Nullable String str4, long j2, long j3, @NotNull List<ScanRecordFile> list, @NotNull String str5, int i3) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "name");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "recordId");
        List<ScanRecordFile> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "pictureList");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "exportType");
        return new ScanRecord(str6, str2, str7, j, i2, str4, j2, j3, list2, str8, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanRecord)) {
            return false;
        }
        ScanRecord scanRecord = (ScanRecord) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) scanRecord.name) && Intrinsics.areEqual((Object) this.displayName, (Object) scanRecord.displayName) && Intrinsics.areEqual((Object) this.recordId, (Object) scanRecord.recordId) && this.modifyTime == scanRecord.modifyTime && this.category == scanRecord.category && Intrinsics.areEqual((Object) this.savePath, (Object) scanRecord.savePath) && this.createTime == scanRecord.createTime && this.openTime == scanRecord.openTime && Intrinsics.areEqual((Object) this.pictureList, (Object) scanRecord.pictureList) && Intrinsics.areEqual((Object) this.exportType, (Object) scanRecord.exportType) && this.isDelete == scanRecord.isDelete;
    }

    @Nullable
    public final String firstPictureLocalPath() {
        T t;
        Iterator<T> it = this.pictureList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            String localPath = ((ScanRecordFile) t).getLocalPath();
            boolean z = true;
            if (localPath == null || !new File(localPath).exists()) {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ScanRecordFile scanRecordFile = (ScanRecordFile) t;
        if (scanRecordFile != null) {
            return scanRecordFile.getLocalPath();
        }
        return null;
    }

    public final int getCategory() {
        return this.category;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getExportType() {
        return this.exportType;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getOpenTime() {
        return this.openTime;
    }

    @NotNull
    public final List<ScanRecordFile> getPictureList() {
        return this.pictureList;
    }

    @NotNull
    public final String getRecordId() {
        return this.recordId;
    }

    @Nullable
    public final String getSavePath() {
        return this.savePath;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.displayName;
        int i2 = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.recordId.hashCode()) * 31) + defpackage.qw.qw(this.modifyTime)) * 31) + this.category) * 31;
        String str2 = this.savePath;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((((((((hashCode2 + i2) * 31) + defpackage.qw.qw(this.createTime)) * 31) + defpackage.qw.qw(this.openTime)) * 31) + this.pictureList.hashCode()) * 31) + this.exportType.hashCode()) * 31) + this.isDelete;
    }

    public final int isDelete() {
        return this.isDelete;
    }

    @NotNull
    public String toString() {
        return "ScanRecord(name=" + this.name + ", displayName=" + this.displayName + ", recordId=" + this.recordId + ", modifyTime=" + this.modifyTime + ", category=" + this.category + ", savePath=" + this.savePath + ", createTime=" + this.createTime + ", openTime=" + this.openTime + ", pictureList=" + this.pictureList + ", exportType=" + this.exportType + ", isDelete=" + this.isDelete + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.displayName);
        parcel.writeString(this.recordId);
        parcel.writeLong(this.modifyTime);
        parcel.writeInt(this.category);
        parcel.writeString(this.savePath);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.openTime);
        List<ScanRecordFile> list = this.pictureList;
        parcel.writeInt(list.size());
        for (ScanRecordFile writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.exportType);
        parcel.writeInt(this.isDelete);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ScanRecord(java.lang.String r18, java.lang.String r19, java.lang.String r20, long r21, int r23, java.lang.String r24, long r25, long r27, java.util.List r29, java.lang.String r30, int r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r17 = this;
            r0 = r32
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0009
            r1 = -1
            r8 = -1
            goto L_0x000b
        L_0x0009:
            r8 = r23
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0016
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r14 = r1
            goto L_0x0018
        L_0x0016:
            r14 = r29
        L_0x0018:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = ""
            r15 = r1
            goto L_0x0022
        L_0x0020:
            r15 = r30
        L_0x0022:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x002a
            r0 = 0
            r16 = 0
            goto L_0x002c
        L_0x002a:
            r16 = r31
        L_0x002c:
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r9 = r24
            r10 = r25
            r12 = r27
            r2.<init>(r3, r4, r5, r6, r8, r9, r10, r12, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.model.ScanRecord.<init>(java.lang.String, java.lang.String, java.lang.String, long, int, java.lang.String, long, long, java.util.List, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
