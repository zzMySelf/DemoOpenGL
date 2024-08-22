package com.tera.scan.localfile.model;

import android.content.Context;
import com.tera.scan.localfile.model.FileItem;
import fe.mmm.qw.j.xxx.ad;
import java.io.File;

public class MediaFileItem extends FileItem {
    public static final String TAG = "MediaFileItem";
    public String mRemoteUrl;

    public MediaFileItem(Context context, File file) {
        super(context, file);
    }

    public static MediaFileItem create(Context context, String str, String str2) {
        MediaFileItem mediaFileItem = new MediaFileItem(context, new File(str));
        mediaFileItem.setRemoteUrl(str2);
        return mediaFileItem;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MediaFileItem) {
            return this.mFilePath.equalsIgnoreCase(((MediaFileItem) obj).getFilePath());
        }
        return false;
    }

    public String getRemoteUrl() {
        return this.mRemoteUrl;
    }

    public int hashCode() {
        return this.mFilePath.hashCode();
    }

    public void setRemoteUrl(String str) {
        this.mRemoteUrl = str;
    }

    public MediaFileItem(Context context, String str, long j, long j2) {
        this(context, (File) null);
        setFilePath(str);
        setLastModifiedTime(j);
        try {
            setFileName(str.substring(str.lastIndexOf(ad.qw)));
        } catch (Exception unused) {
        }
        setFileType(FileItem.FileType.EImage);
        setShowName(getFileName());
    }
}
