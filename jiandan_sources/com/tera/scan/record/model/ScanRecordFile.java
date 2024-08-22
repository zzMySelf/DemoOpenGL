package com.tera.scan.record.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JU\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00065"}, d2 = {"Lcom/tera/scan/record/model/ScanRecordFile;", "Landroid/os/Parcelable;", "recordId", "", "order", "", "fsid", "remotePath", "localPath", "size", "status", "Lcom/tera/scan/record/model/FileUploadStatus;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tera/scan/record/model/FileUploadStatus;)V", "getFsid", "()Ljava/lang/String;", "setFsid", "(Ljava/lang/String;)V", "getLocalPath", "setLocalPath", "getOrder", "()I", "setOrder", "(I)V", "getRecordId", "setRecordId", "getRemotePath", "setRemotePath", "getSize", "setSize", "getStatus", "()Lcom/tera/scan/record/model/FileUploadStatus;", "setStatus", "(Lcom/tera/scan/record/model/FileUploadStatus;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanRecordFile implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ScanRecordFile> CREATOR = new qw();
    @SerializedName("fsid")
    @Nullable
    public String fsid;
    @SerializedName("localPath")
    @Nullable
    public String localPath;
    @SerializedName("pos")
    public int order;
    @SerializedName("record_id")
    @NotNull
    public String recordId;
    @SerializedName("path")
    @Nullable
    public String remotePath;
    @SerializedName("size")
    public int size;
    @SerializedName("status")
    @NotNull
    public FileUploadStatus status;

    public static final class qw implements Parcelable.Creator<ScanRecordFile> {
        @NotNull
        /* renamed from: ad */
        public final ScanRecordFile[] newArray(int i2) {
            return new ScanRecordFile[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ScanRecordFile createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScanRecordFile(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), FileUploadStatus.valueOf(parcel.readString()));
        }
    }

    public ScanRecordFile() {
        this((String) null, 0, (String) null, (String) null, (String) null, 0, (FileUploadStatus) null, 127, (DefaultConstructorMarker) null);
    }

    public ScanRecordFile(@NotNull String str, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i3, @NotNull FileUploadStatus fileUploadStatus) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(fileUploadStatus, "status");
        this.recordId = str;
        this.order = i2;
        this.fsid = str2;
        this.remotePath = str3;
        this.localPath = str4;
        this.size = i3;
        this.status = fileUploadStatus;
    }

    public static /* synthetic */ ScanRecordFile copy$default(ScanRecordFile scanRecordFile, String str, int i2, String str2, String str3, String str4, int i3, FileUploadStatus fileUploadStatus, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = scanRecordFile.recordId;
        }
        if ((i4 & 2) != 0) {
            i2 = scanRecordFile.order;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            str2 = scanRecordFile.fsid;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = scanRecordFile.remotePath;
        }
        String str6 = str3;
        if ((i4 & 16) != 0) {
            str4 = scanRecordFile.localPath;
        }
        String str7 = str4;
        if ((i4 & 32) != 0) {
            i3 = scanRecordFile.size;
        }
        int i6 = i3;
        if ((i4 & 64) != 0) {
            fileUploadStatus = scanRecordFile.status;
        }
        return scanRecordFile.copy(str, i5, str5, str6, str7, i6, fileUploadStatus);
    }

    @NotNull
    public final String component1() {
        return this.recordId;
    }

    public final int component2() {
        return this.order;
    }

    @Nullable
    public final String component3() {
        return this.fsid;
    }

    @Nullable
    public final String component4() {
        return this.remotePath;
    }

    @Nullable
    public final String component5() {
        return this.localPath;
    }

    public final int component6() {
        return this.size;
    }

    @NotNull
    public final FileUploadStatus component7() {
        return this.status;
    }

    @NotNull
    public final ScanRecordFile copy(@NotNull String str, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i3, @NotNull FileUploadStatus fileUploadStatus) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        FileUploadStatus fileUploadStatus2 = fileUploadStatus;
        Intrinsics.checkNotNullParameter(fileUploadStatus2, "status");
        return new ScanRecordFile(str, i2, str2, str3, str4, i3, fileUploadStatus2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanRecordFile)) {
            return false;
        }
        ScanRecordFile scanRecordFile = (ScanRecordFile) obj;
        return Intrinsics.areEqual((Object) this.recordId, (Object) scanRecordFile.recordId) && this.order == scanRecordFile.order && Intrinsics.areEqual((Object) this.fsid, (Object) scanRecordFile.fsid) && Intrinsics.areEqual((Object) this.remotePath, (Object) scanRecordFile.remotePath) && Intrinsics.areEqual((Object) this.localPath, (Object) scanRecordFile.localPath) && this.size == scanRecordFile.size && this.status == scanRecordFile.status;
    }

    @Nullable
    public final String getFsid() {
        return this.fsid;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final String getRecordId() {
        return this.recordId;
    }

    @Nullable
    public final String getRemotePath() {
        return this.remotePath;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final FileUploadStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = ((this.recordId.hashCode() * 31) + this.order) * 31;
        String str = this.fsid;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.remotePath;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.localPath;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode3 + i2) * 31) + this.size) * 31) + this.status.hashCode();
    }

    public final void setFsid(@Nullable String str) {
        this.fsid = str;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setOrder(int i2) {
        this.order = i2;
    }

    public final void setRecordId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recordId = str;
    }

    public final void setRemotePath(@Nullable String str) {
        this.remotePath = str;
    }

    public final void setSize(int i2) {
        this.size = i2;
    }

    public final void setStatus(@NotNull FileUploadStatus fileUploadStatus) {
        Intrinsics.checkNotNullParameter(fileUploadStatus, "<set-?>");
        this.status = fileUploadStatus;
    }

    @NotNull
    public String toString() {
        return "ScanRecordFile(recordId=" + this.recordId + ", order=" + this.order + ", fsid=" + this.fsid + ", remotePath=" + this.remotePath + ", localPath=" + this.localPath + ", size=" + this.size + ", status=" + this.status + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.recordId);
        parcel.writeInt(this.order);
        parcel.writeString(this.fsid);
        parcel.writeString(this.remotePath);
        parcel.writeString(this.localPath);
        parcel.writeInt(this.size);
        parcel.writeString(this.status.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ScanRecordFile(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, com.tera.scan.record.model.FileUploadStatus r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0006
            java.lang.String r6 = ""
        L_0x0006:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x000d
            r14 = 0
            goto L_0x000e
        L_0x000d:
            r14 = r7
        L_0x000e:
            r7 = r13 & 4
            r1 = 0
            if (r7 == 0) goto L_0x0015
            r2 = r1
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r1
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r10
        L_0x0023:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r11
        L_0x0029:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x002f
            com.tera.scan.record.model.FileUploadStatus r12 = com.tera.scan.record.model.FileUploadStatus.LOCAL
        L_0x002f:
            r4 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r2
            r11 = r3
            r12 = r1
            r13 = r0
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.model.ScanRecordFile.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, com.tera.scan.record.model.FileUploadStatus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
