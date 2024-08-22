package com.baidu.titan.sdk.pm;

import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.loader.LoaderHead;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PatchCrashHandler {
    private static final String TAG = "PatchCrashHandler";

    public static void onCrashReported(String crashStr) {
        if (crashStr != null && crashStr.length() != 0 && crashStr.contains("$chg")) {
            File headFile = TitanPaths.getHeadFile();
            LoaderHead lh = LoaderHead.createFromJson(Files.getFileStringContent(headFile));
            lh.crashCount++;
            FileWriter fw = null;
            try {
                fw = new FileWriter(headFile);
                fw.write(lh.toJsonString());
                try {
                    fw.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (fw != null) {
                    fw.close();
                }
            } catch (Throwable th2) {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th2;
            }
        }
    }
}
