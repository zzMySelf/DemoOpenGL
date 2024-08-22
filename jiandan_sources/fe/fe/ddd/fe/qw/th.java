package fe.fe.ddd.fe.qw;

import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class th {
    public static void ad(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                de(fileOutputStream2, str);
                Closeables.closeSafely((Closeable) fileOutputStream2);
            } catch (FileNotFoundException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.getMessage();
                    Closeables.closeSafely((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                Closeables.closeSafely((Closeable) fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            e.getMessage();
            Closeables.closeSafely((Closeable) fileOutputStream);
        }
    }

    public static void de(FileOutputStream fileOutputStream, String str) {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.flush();
                Closeables.closeSafely((Closeable) bufferedWriter2);
            } catch (IOException e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    e.getMessage();
                    Closeables.closeSafely((Closeable) bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Closeable) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                Closeables.closeSafely((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.getMessage();
            Closeables.closeSafely((Closeable) bufferedWriter);
        }
    }

    public static String qw(FileInputStream fileInputStream) {
        BufferedReader bufferedReader;
        IOException e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        if (fileInputStream != null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        sb.append(readLine);
                    }
                    bufferedReader2 = bufferedReader;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.getMessage();
                        Closeables.closeSafely((Closeable) bufferedReader);
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        Closeables.closeSafely((Closeable) bufferedReader2);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
                e.getMessage();
                Closeables.closeSafely((Closeable) bufferedReader);
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely((Closeable) bufferedReader2);
                throw th;
            }
        }
        Closeables.closeSafely((Closeable) bufferedReader2);
        return sb.toString();
    }
}
