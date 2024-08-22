package com.baidu.apollon.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class FileCopyUtils {
    public static final int a = 4096;

    public static int copy(File file, File file2) throws IOException {
        Assert.notNull(file, "No input File specified");
        Assert.notNull(file2, "No output File specified");
        return copy((InputStream) new BufferedInputStream(new FileInputStream(file)), (OutputStream) new BufferedOutputStream(new FileOutputStream(file2)));
    }

    public static byte[] copyToByteArray(File file) throws IOException {
        Assert.notNull(file, "No input File specified");
        return copyToByteArray((InputStream) new BufferedInputStream(new FileInputStream(file)));
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            fileOutputStream.close();
            throw th2;
        }
    }

    public static String copyToString(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(reader, (Writer) stringWriter);
        return stringWriter.toString();
    }

    public static byte[] copyToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        copy(inputStream, (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void copy(byte[] bArr, File file) throws IOException {
        Assert.notNull(bArr, "No input byte array specified");
        Assert.notNull(file, "No output File specified");
        copy((InputStream) new ByteArrayInputStream(bArr), (OutputStream) new BufferedOutputStream(new FileOutputStream(file)));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|(2:3|(1:5)(1:20))|6|7|8|9|10|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copy(java.io.InputStream r5, java.io.OutputStream r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "No InputStream specified"
            com.baidu.apollon.utils.Assert.notNull(r5, r0)
            java.lang.String r0 = "No OutputStream specified"
            com.baidu.apollon.utils.Assert.notNull(r6, r0)
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0026 }
            r1 = 0
            r2 = 0
        L_0x0010:
            int r3 = r5.read(r0)     // Catch:{ all -> 0x0026 }
            r4 = -1
            if (r3 == r4) goto L_0x001c
            r6.write(r0, r1, r3)     // Catch:{ all -> 0x0026 }
            int r2 = r2 + r3
            goto L_0x0010
        L_0x001c:
            r6.flush()     // Catch:{ all -> 0x0026 }
            r5.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r6.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r2
        L_0x0026:
            r0 = move-exception
            r5.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            r6.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.FileCopyUtils.copy(java.io.InputStream, java.io.OutputStream):int");
    }

    public static boolean copyToFile(String str, File file) {
        FileOutputStream fileOutputStream;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            fileOutputStream.close();
            throw th2;
        }
    }

    public static void copy(byte[] bArr, OutputStream outputStream) throws IOException {
        Assert.notNull(bArr, "No input byte array specified");
        Assert.notNull(outputStream, "No OutputStream specified");
        try {
            outputStream.write(bArr);
        } finally {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|(2:3|(1:5)(1:20))|6|7|8|9|10|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copy(java.io.Reader r5, java.io.Writer r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "No Reader specified"
            com.baidu.apollon.utils.Assert.notNull(r5, r0)
            java.lang.String r0 = "No Writer specified"
            com.baidu.apollon.utils.Assert.notNull(r6, r0)
            r0 = 4096(0x1000, float:5.74E-42)
            char[] r0 = new char[r0]     // Catch:{ all -> 0x0026 }
            r1 = 0
            r2 = 0
        L_0x0010:
            int r3 = r5.read(r0)     // Catch:{ all -> 0x0026 }
            r4 = -1
            if (r3 == r4) goto L_0x001c
            r6.write(r0, r1, r3)     // Catch:{ all -> 0x0026 }
            int r2 = r2 + r3
            goto L_0x0010
        L_0x001c:
            r6.flush()     // Catch:{ all -> 0x0026 }
            r5.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r6.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r2
        L_0x0026:
            r0 = move-exception
            r5.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            r6.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.FileCopyUtils.copy(java.io.Reader, java.io.Writer):int");
    }

    public static void copy(String str, Writer writer) throws IOException {
        Assert.notNull(str, "No input String specified");
        Assert.notNull(writer, "No Writer specified");
        try {
            writer.write(str);
        } finally {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }
}
