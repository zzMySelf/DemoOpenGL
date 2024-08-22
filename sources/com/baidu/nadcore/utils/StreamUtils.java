package com.baidu.nadcore.utils;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.nadcore.core.CloseableHelper;
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
    private static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    private static final String TAG = "StreamUtils";

    public static boolean bytesToFile(byte[] data, File file) {
        if (data == null || file == null) {
            return false;
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data);
            os.flush();
            return true;
        } catch (IOException e2) {
            return false;
        } finally {
            CloseableHelper.safeClose(os);
        }
    }

    public static byte[] streamToBytes(InputStream is) {
        if (is == null) {
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[8192];
            while (true) {
                int read = is.read(buffer);
                int n = read;
                if (-1 == read) {
                    return output.toByteArray();
                }
                output.write(buffer, 0, n);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            CloseableHelper.safeClose(is);
            CloseableHelper.safeClose(output);
        }
    }

    public static String streamToString(InputStream is) {
        return streamToString(is, Xml.Encoding.UTF_8.toString());
    }

    public static String streamToString(InputStream is, String enc) {
        if (is == null) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, enc), 8192);
            while (true) {
                String readLine = reader.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                }
                buffer.append(line);
            }
        } catch (Exception | OutOfMemoryError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            CloseableHelper.safeClose(is);
            CloseableHelper.safeClose((Closeable) null);
            throw th2;
        }
        CloseableHelper.safeClose(is);
        CloseableHelper.safeClose(reader);
        return buffer.toString();
    }

    public static boolean streamToZipFile(InputStream in, ZipOutputStream out, String file) {
        if (in == null || out == null || TextUtils.isEmpty(file)) {
            return false;
        }
        try {
            byte[] buffer = new byte[4096];
            out.putNextEntry(new ZipEntry(file));
            while (true) {
                int read = in.read(buffer);
                int bytesRead = read;
                if (read != -1) {
                    out.write(buffer, 0, bytesRead);
                } else {
                    out.closeEntry();
                    return true;
                }
            }
        } catch (IOException e2) {
            return false;
        }
    }

    public static String getStringFromInput(InputStream inputStream) {
        String str = FileUtils.readInputStream(inputStream);
        if (str.startsWith("﻿")) {
            return str.substring(1);
        }
        return str;
    }
}
