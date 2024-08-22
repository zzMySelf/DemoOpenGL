package com.baidu.swan.apps.impl.clone.clone;

import android.content.Context;
import java.io.File;

public interface ISwanAppClone {
    boolean cloneAbTest(String str);

    boolean cloneCore(String str, File file);

    boolean cloneDb(String str, File file);

    boolean cloneDynamicLib(String str, File file);

    boolean cloneSp(Context context, String str, File file);

    void cloneSwanApp(Context context, String str);

    boolean cloneSwanPkg(String str, File file);

    boolean deleteFolderBeforeCreate(File file);

    File tryCreateFolder(String str, File file, String str2);

    boolean zipCloneResult(File file, String str);
}
