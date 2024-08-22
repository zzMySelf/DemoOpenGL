package com.baidu.searchbox.skin.resources;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.io.File;

public class SkinResourceUtils {
    public static Resources getPluginResources(AssetManager assets, DisplayMetrics metrics, Configuration config) {
        return new Resources(assets, metrics, config);
    }

    public static AssetManager getPluginAssetManager(File skinApk) throws Exception {
        Class c2 = AssetManager.class;
        AssetManager assetManager = c2.newInstance();
        c2.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{skinApk.getAbsolutePath()});
        return assetManager;
    }
}
