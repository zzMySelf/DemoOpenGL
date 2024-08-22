package com.tera.scan.record.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.aiscan.R;
import fe.mmm.qw.p030switch.rg.yj;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 <2\u00020\u0001:\u0001<BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J_\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006="}, d2 = {"Lcom/tera/scan/record/model/ScanRecordExportFile;", "Landroid/os/Parcelable;", "recordId", "", "fileName", "serverPath", "fsid", "size", "", "serverCtime", "", "localPath", "status", "Lcom/tera/scan/record/model/FileUploadStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Lcom/tera/scan/record/model/FileUploadStatus;)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFsid", "setFsid", "getLocalPath", "setLocalPath", "getRecordId", "setRecordId", "getServerCtime", "()J", "setServerCtime", "(J)V", "getServerPath", "setServerPath", "getSize", "()I", "setSize", "(I)V", "getStatus", "()Lcom/tera/scan/record/model/FileUploadStatus;", "setStatus", "(Lcom/tera/scan/record/model/FileUploadStatus;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanRecordExportFile implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ScanRecordExportFile> CREATOR = new ad();
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public String fileName;
    @Nullable
    public String fsid;
    @Nullable
    public String localPath;
    @NotNull
    public String recordId;
    public long serverCtime;
    @Nullable
    public String serverPath;
    public int size;
    @NotNull
    public FileUploadStatus status;

    public static final class ad implements Parcelable.Creator<ScanRecordExportFile> {
        @NotNull
        /* renamed from: ad */
        public final ScanRecordExportFile[] newArray(int i2) {
            return new ScanRecordExportFile[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ScanRecordExportFile createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScanRecordExportFile(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), FileUploadStatus.valueOf(parcel.readString()));
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScanRecordExportFile qw(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "path");
            File file = new File(str);
            String qw = yj.qw();
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "file.name");
            return new ScanRecordExportFile(qw, name, '/' + context.getResources().getString(R.string.document_scan_export_default_path) + '/' + file.getName(), (String) null, (int) file.length(), System.currentTimeMillis() / ((long) 1000), str, FileUploadStatus.LOCAL);
        }
    }

    public ScanRecordExportFile(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i2, long j, @Nullable String str5, @NotNull FileUploadStatus fileUploadStatus) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        Intrinsics.checkNotNullParameter(fileUploadStatus, "status");
        this.recordId = str;
        this.fileName = str2;
        this.serverPath = str3;
        this.fsid = str4;
        this.size = i2;
        this.serverCtime = j;
        this.localPath = str5;
        this.status = fileUploadStatus;
    }

    public static /* synthetic */ ScanRecordExportFile copy$default(ScanRecordExportFile scanRecordExportFile, String str, String str2, String str3, String str4, int i2, long j, String str5, FileUploadStatus fileUploadStatus, int i3, Object obj) {
        ScanRecordExportFile scanRecordExportFile2 = scanRecordExportFile;
        int i4 = i3;
        return scanRecordExportFile.copy((i4 & 1) != 0 ? scanRecordExportFile2.recordId : str, (i4 & 2) != 0 ? scanRecordExportFile2.fileName : str2, (i4 & 4) != 0 ? scanRecordExportFile2.serverPath : str3, (i4 & 8) != 0 ? scanRecordExportFile2.fsid : str4, (i4 & 16) != 0 ? scanRecordExportFile2.size : i2, (i4 & 32) != 0 ? scanRecordExportFile2.serverCtime : j, (i4 & 64) != 0 ? scanRecordExportFile2.localPath : str5, (i4 & 128) != 0 ? scanRecordExportFile2.status : fileUploadStatus);
    }

    @NotNull
    public final String component1() {
        return this.recordId;
    }

    @NotNull
    public final String component2() {
        return this.fileName;
    }

    @Nullable
    public final String component3() {
        return this.serverPath;
    }

    @Nullable
    public final String component4() {
        return this.fsid;
    }

    public final int component5() {
        return this.size;
    }

    public final long component6() {
        return this.serverCtime;
    }

    @Nullable
    public final String component7() {
        return this.localPath;
    }

    @NotNull
    public final FileUploadStatus component8() {
        return this.status;
    }

    @NotNull
    public final ScanRecordExportFile copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i2, long j, @Nullable String str5, @NotNull FileUploadStatus fileUploadStatus) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        FileUploadStatus fileUploadStatus2 = fileUploadStatus;
        Intrinsics.checkNotNullParameter(fileUploadStatus2, "status");
        return new ScanRecordExportFile(str, str2, str3, str4, i2, j, str5, fileUploadStatus2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanRecordExportFile)) {
            return false;
        }
        ScanRecordExportFile scanRecordExportFile = (ScanRecordExportFile) obj;
        return Intrinsics.areEqual((Object) this.recordId, (Object) scanRecordExportFile.recordId) && Intrinsics.areEqual((Object) this.fileName, (Object) scanRecordExportFile.fileName) && Intrinsics.areEqual((Object) this.serverPath, (Object) scanRecordExportFile.serverPath) && Intrinsics.areEqual((Object) this.fsid, (Object) scanRecordExportFile.fsid) && this.size == scanRecordExportFile.size && this.serverCtime == scanRecordExportFile.serverCtime && Intrinsics.areEqual((Object) this.localPath, (Object) scanRecordExportFile.localPath) && this.status == scanRecordExportFile.status;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final String getFsid() {
        return this.fsid;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @NotNull
    public final String getRecordId() {
        return this.recordId;
    }

    public final long getServerCtime() {
        return this.serverCtime;
    }

    @Nullable
    public final String getServerPath() {
        return this.serverPath;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final FileUploadStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = ((this.recordId.hashCode() * 31) + this.fileName.hashCode()) * 31;
        String str = this.serverPath;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fsid;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.size) * 31) + defpackage.qw.qw(this.serverCtime)) * 31;
        String str3 = this.localPath;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.status.hashCode();
    }

    public final void setFileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFsid(@Nullable String str) {
        this.fsid = str;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setRecordId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recordId = str;
    }

    public final void setServerCtime(long j) {
        this.serverCtime = j;
    }

    public final void setServerPath(@Nullable String str) {
        this.serverPath = str;
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
        return "ScanRecordExportFile(recordId=" + this.recordId + ", fileName=" + this.fileName + ", serverPath=" + this.serverPath + ", fsid=" + this.fsid + ", size=" + this.size + ", serverCtime=" + this.serverCtime + ", localPath=" + this.localPath + ", status=" + this.status + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.recordId);
        parcel.writeString(this.fileName);
        parcel.writeString(this.serverPath);
        parcel.writeString(this.fsid);
        parcel.writeInt(this.size);
        parcel.writeLong(this.serverCtime);
        parcel.writeString(this.localPath);
        parcel.writeString(this.status.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanRecordExportFile(String str, String str2, String str3, String str4, int i2, long j, String str5, FileUploadStatus fileUploadStatus, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? 0 : j, (i3 & 64) != 0 ? null : str5, fileUploadStatus);
    }
}
