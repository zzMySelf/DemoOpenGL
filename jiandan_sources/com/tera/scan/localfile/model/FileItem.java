package com.tera.scan.localfile.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import fe.mmm.qw.vvv.qw.ad;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class FileItem implements Parcelable {
    public static final Parcelable.Creator<FileItem> CREATOR = new qw();
    public static final String TAG = "FileItem";
    public String mFileName;
    public String mFilePath;
    public FileType mFileType = FileType.EOthers;
    public int mIcon;
    public Long mLastModifiedTime;
    public ad mMimeTypes;
    public String mShowName;

    public enum FileType {
        EAudio,
        EVideo,
        EImage,
        EDocument,
        EInstallPackage,
        EDirectory,
        EOthers
    }

    public class qw implements Parcelable.Creator<FileItem> {
        /* renamed from: ad */
        public FileItem[] newArray(int i2) {
            return new FileItem[i2];
        }

        /* renamed from: qw */
        public FileItem createFromParcel(Parcel parcel) {
            return new FileItem(parcel);
        }
    }

    public FileItem(String str) {
        this.mFilePath = str;
    }

    private String getMimeType(Context context, String str) {
        if (this.mMimeTypes == null) {
            initMimeTypes(context);
        }
        return this.mMimeTypes.qw(str);
    }

    private String getParentPath() {
        return new File(this.mFilePath).getParentFile().getAbsolutePath();
    }

    private void init(Context context, File file) {
        if (file != null) {
            this.mFileName = file.getName();
            this.mLastModifiedTime = Long.valueOf(file.lastModified());
            try {
                this.mFilePath = file.getCanonicalPath();
            } catch (IOException unused) {
            }
            if (file.isDirectory()) {
                this.mFileType = FileType.EDirectory;
            } else {
                String mimeType = getMimeType(context, this.mFileName);
                if (mimeType == null) {
                    this.mFileType = FileType.EOthers;
                } else if (mimeType.startsWith(MediaType.IMAGE_TYPE)) {
                    this.mFileType = FileType.EImage;
                } else if (mimeType.startsWith(MediaType.VIDEO_TYPE)) {
                    this.mFileType = FileType.EVideo;
                } else if ("application/vnd.android.package-archive".equals(mimeType)) {
                    this.mFileType = FileType.EInstallPackage;
                } else {
                    this.mFileType = FileType.EOthers;
                }
            }
            this.mShowName = this.mFileName;
        }
    }

    private void initMimeTypes(Context context) {
        if (context != null) {
            try {
                this.mMimeTypes = new fe.mmm.qw.vvv.qw.qw().ad(context.getResources().getXml(R.xml.mimetypes));
            } catch (IOException | XmlPullParserException unused) {
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileItem fileItem = (FileItem) obj;
        String str = this.mFileName;
        if (str == null) {
            if (fileItem.mFileName != null) {
                return false;
            }
        } else if (!str.equals(fileItem.mFileName)) {
            return false;
        }
        String str2 = this.mFilePath;
        if (str2 == null) {
            if (fileItem.mFilePath != null) {
                return false;
            }
        } else if (!str2.equals(fileItem.mFilePath)) {
            return false;
        }
        return true;
    }

    public long getFileLastModifiedTime() {
        return this.mLastModifiedTime.longValue();
    }

    public String getFileName() {
        if (TextUtils.isEmpty(this.mFileName)) {
            return new File(this.mFilePath).getName();
        }
        return this.mFileName;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public long getFileSize() {
        String str = this.mFilePath;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }

    public FileType getFileType() {
        return this.mFileType;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public String getShowName() {
        return this.mShowName;
    }

    public int hashCode() {
        String str = this.mFileName;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.mFilePath;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public boolean isDir() {
        return new File(this.mFilePath).isDirectory();
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setFileType(FileType fileType) {
        this.mFileType = fileType;
    }

    public void setIcon(int i2) {
        this.mIcon = i2;
    }

    public void setLastModifiedTime(long j) {
        this.mLastModifiedTime = Long.valueOf(j);
    }

    public void setShowName(String str) {
        this.mShowName = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mFileName);
        parcel.writeString(this.mFilePath);
    }

    public FileItem(Context context, File file) {
        init(context, file);
    }

    public FileItem(String str, String str2) {
        this.mFilePath = str;
        this.mFileName = str2;
        this.mFileType = FileType.EDirectory;
        this.mLastModifiedTime = Long.valueOf(System.currentTimeMillis());
        this.mShowName = this.mFileName;
    }

    public FileItem(Parcel parcel) {
        this.mFileName = parcel.readString();
        this.mFilePath = parcel.readString();
    }
}
