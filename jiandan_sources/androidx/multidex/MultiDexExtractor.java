package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MultiDexExtractor implements Closeable {
    public static final int BUFFER_SIZE = 16384;
    public static final String DEX_PREFIX = "classes";
    public static final String DEX_SUFFIX = ".dex";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_CRC = "crc";
    public static final String KEY_DEX_CRC = "dex.crc.";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String KEY_DEX_TIME = "dex.time.";
    public static final String KEY_TIME_STAMP = "timestamp";
    public static final String LOCK_FILENAME = "MultiDex.lock";
    public static final int MAX_EXTRACT_ATTEMPTS = 3;
    public static final long NO_VALUE = -1;
    public static final String PREFS_FILE = "multidex.version";
    public static final String TAG = "MultiDex";
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        "MultiDexExtractor(" + file.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getPath() + ")";
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            this.lockChannel = randomAccessFile.getChannel();
            try {
                "Blocking on lock " + file3.getPath();
                this.cacheLock = this.lockChannel.lock();
                file3.getPath() + " locked";
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            closeQuietly(this.lockRaf);
            throw e4;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            "Failed to list secondary dex dir content (" + this.dexDir.getPath() + ").";
            return;
        }
        for (File file : listFiles) {
            "Trying to delete old file " + file.getPath() + " of size " + file.length();
            if (!file.delete()) {
                "Failed to delete old file " + file.getPath();
            } else {
                "Deleted old file " + file.getPath();
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        "Extracting " + createTempFile.getPath();
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                "Renaming to " + file.getPath();
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th2) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    public static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    public static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1) == getTimeStamp(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(KEY_CRC);
            return multiDexPreferences.getLong(sb.toString(), -1) != j;
        }
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        String str3 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i2 = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str3 + i3 + EXTRACTED_SUFFIX);
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i3, -1);
                long j2 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i3, -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i3++;
                        multiDexPreferences = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        "Failed to read crc from " + r8.getAbsolutePath();
        r10 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0086 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<androidx.multidex.MultiDexExtractor.ExtractedDex> performExtractions() throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = "classes"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r14.sourceApk
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = ".classes"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r14.clearDexDir()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile
            java.io.File r5 = r14.sourceApk
            r4.<init>(r5)
            r5 = 2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r6.<init>()     // Catch:{ all -> 0x0142 }
            r6.append(r1)     // Catch:{ all -> 0x0142 }
            r6.append(r5)     // Catch:{ all -> 0x0142 }
            r6.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0142 }
            java.util.zip.ZipEntry r6 = r4.getEntry(r6)     // Catch:{ all -> 0x0142 }
        L_0x0041:
            if (r6 == 0) goto L_0x013e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            r7.append(r2)     // Catch:{ all -> 0x0142 }
            r7.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = ".zip"
            r7.append(r8)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0142 }
            androidx.multidex.MultiDexExtractor$ExtractedDex r8 = new androidx.multidex.MultiDexExtractor$ExtractedDex     // Catch:{ all -> 0x0142 }
            java.io.File r9 = r14.dexDir     // Catch:{ all -> 0x0142 }
            r8.<init>(r9, r7)     // Catch:{ all -> 0x0142 }
            r3.add(r8)     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = "Extraction is needed for file "
            r7.append(r9)     // Catch:{ all -> 0x0142 }
            r7.append(r8)     // Catch:{ all -> 0x0142 }
            r7.toString()     // Catch:{ all -> 0x0142 }
            r7 = 0
            r9 = 0
            r10 = 0
        L_0x0074:
            r11 = 3
            if (r9 >= r11) goto L_0x00fa
            if (r10 != 0) goto L_0x00fa
            int r9 = r9 + 1
            extract(r4, r6, r8, r2)     // Catch:{ all -> 0x0142 }
            long r10 = getZipCrc(r8)     // Catch:{ IOException -> 0x0086 }
            r8.crc = r10     // Catch:{ IOException -> 0x0086 }
            r10 = 1
            goto L_0x009b
        L_0x0086:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = "Failed to read crc from "
            r10.append(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r10.append(r11)     // Catch:{ all -> 0x0142 }
            r10.toString()     // Catch:{ all -> 0x0142 }
            r10 = 0
        L_0x009b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r11.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "Extraction "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x00aa
            java.lang.String r12 = "succeeded"
            goto L_0x00ac
        L_0x00aa:
            java.lang.String r12 = "failed"
        L_0x00ac:
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = " '"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "': length "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            long r12 = r8.length()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = " - crc: "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            long r12 = r8.crc     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            r11.toString()     // Catch:{ all -> 0x0142 }
            if (r10 != 0) goto L_0x0074
            r8.delete()     // Catch:{ all -> 0x0142 }
            boolean r11 = r8.exists()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x0074
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r11.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "Failed to delete corrupted secondary dex '"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = r8.getPath()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "'"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            r11.toString()     // Catch:{ all -> 0x0142 }
            goto L_0x0074
        L_0x00fa:
            if (r10 == 0) goto L_0x0116
            int r5 = r5 + 1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r6.<init>()     // Catch:{ all -> 0x0142 }
            r6.append(r1)     // Catch:{ all -> 0x0142 }
            r6.append(r5)     // Catch:{ all -> 0x0142 }
            r6.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0142 }
            java.util.zip.ZipEntry r6 = r4.getEntry(r6)     // Catch:{ all -> 0x0142 }
            goto L_0x0041
        L_0x0116:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r1.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = "Could not create zip file "
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = " for secondary dex ("
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            r1.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0142 }
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x013e:
            r4.close()     // Catch:{ IOException -> 0x0141 }
        L_0x0141:
            return r3
        L_0x0142:
            r0 = move-exception
            r4.close()     // Catch:{ IOException -> 0x0146 }
        L_0x0146:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.performExtractions():java.util.List");
    }

    public static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + KEY_CRC, j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i2 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i2, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i2, next.lastModified());
            i2++;
        }
        edit.commit();
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    public List<? extends File> load(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> list;
        List<ExtractedDex> list2;
        "MultiDexExtractor.load(" + this.sourceApk.getPath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ")";
        if (this.cacheLock.isValid()) {
            if (z || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                list2 = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list2);
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException unused) {
                    list2 = performExtractions();
                    putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list2);
                }
                "load found " + list.size() + " secondary dex files";
                return list;
            }
            list = list2;
            "load found " + list.size() + " secondary dex files";
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
