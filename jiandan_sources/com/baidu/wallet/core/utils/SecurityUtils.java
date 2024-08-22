package com.baidu.wallet.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecurityUtils {
    public static boolean a(String str) {
        Process process = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine != null && readLine.length() >= 4) {
                char charAt = readLine.charAt(3);
                if (charAt == 's' || charAt == 'x') {
                    if (process != null) {
                        process.destroy();
                    }
                    return true;
                }
            }
            if (process == null) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (process == null) {
                return false;
            }
        } catch (Throwable th2) {
            if (process != null) {
                process.destroy();
            }
            throw th2;
        }
        process.destroy();
        return false;
    }

    public static boolean isRoot() {
        if (new File("/system/bin/su").exists() && a("/system/bin/su")) {
            return true;
        }
        if (!new File("/system/xbin/su").exists() || !a("/system/xbin/su")) {
            return false;
        }
        return true;
    }
}
