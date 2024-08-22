package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Xml;
import com.google.zxing.client.result.ResultParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class StreamUtils {
    public static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static final String TAG = "StreamUtils";

    public static boolean bytesToFile(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        if (!(bArr == null || file == null)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException unused) {
                Closeables.closeSafely((Closeable) fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Closeable) fileOutputStream2);
                throw th;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                Closeables.closeSafely((Closeable) fileOutputStream);
                return true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely((Closeable) fileOutputStream2);
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely((Closeable) fileOutputStream2);
                throw th;
            }
        }
        return false;
    }

    public static String getStringFromInput(InputStream inputStream) {
        String readInputStream = FileUtils.readInputStream(inputStream);
        return readInputStream.startsWith(ResultParser.BYTE_ORDER_MARK) ? readInputStream.substring(1) : readInputStream;
    }

    public static byte[] streamToBytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            Closeables.closeSafely((Closeable) inputStream);
            Closeables.closeSafely((Closeable) byteArrayOutputStream);
        }
    }

    @Deprecated
    public static boolean streamToFile(InputStream inputStream, File file) {
        boolean z = false;
        if (inputStream == null) {
            return false;
        }
        if (file == null) {
            Closeables.closeSafely((Closeable) inputStream);
            return false;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.flush();
                z = true;
                Closeables.closeSafely((Closeable) fileOutputStream2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) inputStream);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                Closeables.closeSafely((Closeable) fileOutputStream);
                Closeables.closeSafely((Closeable) inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            Closeables.closeSafely((Closeable) fileOutputStream);
            Closeables.closeSafely((Closeable) inputStream);
            return z;
        }
        Closeables.closeSafely((Closeable) inputStream);
        return z;
    }

    public static String streamToString(InputStream inputStream) {
        return streamToString(inputStream, Xml.Encoding.UTF_8.toString());
    }

    public static boolean streamToZipFile(InputStream inputStream, ZipOutputStream zipOutputStream, String str) {
        if (inputStream == null || zipOutputStream == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream.putNextEntry(new ZipEntry(str));
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static String streamToString(InputStream inputStream, String str) {
        BufferedReader bufferedReader = null;
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception | OutOfMemoryError e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) inputStream);
                        Closeables.closeSafely((Closeable) bufferedReader);
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) inputStream);
                        Closeables.closeSafely((Closeable) bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    Closeables.closeSafely((Closeable) inputStream);
                    Closeables.closeSafely((Closeable) bufferedReader);
                    throw th;
                }
            }
            Closeables.closeSafely((Closeable) inputStream);
            Closeables.closeSafely((Closeable) bufferedReader2);
        } catch (Exception | OutOfMemoryError e2) {
            e = e2;
            e.printStackTrace();
            Closeables.closeSafely((Closeable) inputStream);
            Closeables.closeSafely((Closeable) bufferedReader);
            return sb.toString();
        }
        return sb.toString();
    }
}
