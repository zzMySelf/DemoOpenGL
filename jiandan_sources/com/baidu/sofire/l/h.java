package com.baidu.sofire.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    public static final String[] a = {"java.lang.UnsatisfiedLinkError"};
    public static final String[] b = {"space left"};

    public static String a(Context context, String str, String str2) {
        String str3;
        try {
            char c = 0;
            if (str.contains(a[0])) {
                c = 1;
            } else if (str.contains(b[0])) {
                c = 2;
            }
            if (c == 1) {
                str3 = a(str, str2);
            } else if (c != 2) {
                return str;
            } else {
                str3 = a(context, str);
            }
            return str3;
        } catch (Throwable unused) {
            int i2 = a.a;
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, String str) {
        String str2;
        try {
            File f = c.f(context);
            if (Build.VERSION.SDK_INT >= 9) {
                long freeSpace = f.getFreeSpace();
                str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + f.getTotalSpace()) + "  UsableSpace=" + f.getUsableSpace();
            } else {
                str2 = str;
            }
            JSONArray jSONArray = new JSONArray();
            long j = 0;
            for (File file : f.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith(IStringUtil.CURRENT_PATH)) {
                    j += a(file, jSONArray);
                }
            }
            return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j;
        } catch (Throwable unused) {
            return str;
        }
    }

    @SuppressLint({"SdCardPath"})
    public static String a(String str, String str2) {
        ApkInfo b2 = j.g.b(str2);
        String str3 = str + "\r\n{libpath=" + b2.libPath + "}";
        for (String str4 : b2.libPath.split(":")) {
            if (str4.startsWith("/data/data/")) {
                File file = new File(str4);
                if (!file.exists()) {
                    str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                } else if (!file.isDirectory()) {
                    str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                } else {
                    for (File file2 : file.listFiles()) {
                        str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + k.a(file2) + "}\r\n";
                    }
                }
            }
        }
        return str3;
    }

    public static long a(File file, JSONArray jSONArray) throws JSONException {
        long length;
        long j = 0;
        if (!file.isDirectory()) {
            return 0;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                length = a(file2, jSONArray);
            } else if (file2.exists()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", file2.getAbsolutePath());
                jSONObject.put("size", file2.length());
                jSONArray.put(jSONObject);
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}
