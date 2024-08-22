package com.baidu.searchbox.download.center.clearcache.view.funison.fileScan;

import com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.MediaFile;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/FileScanUtil;", "", "()V", "byteToHex", "", "data", "", "getFileMd5", "file", "Ljava/io/File;", "FileSizeComparator", "FileTimeComparator", "SimilarFileTimeComparator", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileScanUtil.kt */
public final class FileScanUtil {
    public static final FileScanUtil INSTANCE = new FileScanUtil();

    private FileScanUtil() {
    }

    public final String getFileMd5(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.isFile()) {
            return "";
        }
        byte[] buffer = new byte[1024];
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            FileInputStream inStream = new FileInputStream(file);
            while (true) {
                int it = inStream.read(buffer, 0, 1024);
                int len = it;
                if (it != -1) {
                    digest.update(buffer, 0, len);
                } else {
                    inStream.close();
                    return byteToHex(digest.digest());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private final String byteToHex(byte[] data) {
        if (data != null) {
            try {
                StringBuilder builder = new StringBuilder();
                int length = data.length;
                for (int i2 = 0; i2 < length; i2++) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(data[i2] & 255)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    builder.append(format);
                }
                return builder.toString();
            } catch (Throwable e2) {
                e2.printStackTrace();
                String str = null;
                return null;
            }
        } else {
            String str2 = null;
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/FileScanUtil$SimilarFileTimeComparator;", "Ljava/util/Comparator;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/similarpicscan/MediaFile$SameMediaFileForCacheItem;", "()V", "compare", "", "file1", "file2", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileScanUtil.kt */
    public static final class SimilarFileTimeComparator implements Comparator<MediaFile.SameMediaFileForCacheItem> {
        public int compare(MediaFile.SameMediaFileForCacheItem file1, MediaFile.SameMediaFileForCacheItem file2) {
            if (file1 == null && file2 == null) {
                return 0;
            }
            if (file1 == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            Long l = file1.dateCompareToken;
            Intrinsics.checkNotNullExpressionValue(l, "file1.dateCompareToken");
            long longValue = l.longValue();
            Long l2 = file2.dateCompareToken;
            Intrinsics.checkNotNullExpressionValue(l2, "file2.dateCompareToken");
            if (longValue > l2.longValue()) {
                return -1;
            }
            if (Intrinsics.areEqual((Object) file1.dateCompareToken, (Object) file2.dateCompareToken)) {
                return 0;
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/FileScanUtil$FileSizeComparator;", "Ljava/util/Comparator;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "()V", "compare", "", "o1", "o2", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileScanUtil.kt */
    public static final class FileSizeComparator implements Comparator<ScanBean> {
        public int compare(ScanBean o1, ScanBean o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            if (o1.getSize() > o2.getSize()) {
                return -1;
            }
            if (o1.getSize() == o2.getSize()) {
                return 0;
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/FileScanUtil$FileTimeComparator;", "Ljava/util/Comparator;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "()V", "compare", "", "o1", "o2", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileScanUtil.kt */
    public static final class FileTimeComparator implements Comparator<ScanBean> {
        public int compare(ScanBean o1, ScanBean o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            if (o1.getDatetoken() > o2.getDatetoken()) {
                return -1;
            }
            if (o1.getDatetoken() == o2.getDatetoken()) {
                return 0;
            }
            return 1;
        }
    }
}
