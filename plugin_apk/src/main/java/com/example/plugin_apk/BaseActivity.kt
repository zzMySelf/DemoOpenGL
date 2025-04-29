package com.example.plugin_apk

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import java.io.File

internal const val PLUGIN_NAME = "plugin_apk-debug.apk"

/**
 * Day：2025/4/29 14:39
 * @author zhangyelei
 */
open class BaseActivity: Activity() {
    var wrappedContext: PluginContextWrapper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fixActivityIcon()
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun fixActivityIcon() {
        try {
            // 获取 plugin 的 ic_launcher 真实 ID
            val iconResId = resources.getIdentifier("plugin_ic_launcher", "mipmap", "com.example.plugin_apk")
            if (iconResId == 0) return

            // 反射 mActivityInfo
            val field = Activity::class.java.getDeclaredField("mActivityInfo")
            field.isAccessible = true
            val activityInfo = field.get(this) as ActivityInfo
            // 设置 icon
            activityInfo.icon = iconResId
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        val pluginAssetManager = createAssetManager(newBase!!)
        val pluginResources = Resources(
            pluginAssetManager,
            newBase.resources.displayMetrics,
            newBase.resources.configuration
        )
        wrappedContext = PluginContextWrapper(newBase, newBase.classLoader, pluginResources, pluginAssetManager)
        super.attachBaseContext(wrappedContext)
    }

    private fun createAssetManager(context: Context): AssetManager? {
        Log.e("zyl", "创建createAssetManager")

        return try {
            val apkPath = "/storage/emulated/0/Android/data/com.baidu.demoopengl/files/plugin_apk-debug.apk"
            Log.e("zyl", "plugin createAssetManager $apkPath")
            val assetManager = AssetManager::class.java.newInstance()
            val addAssetPathMethod = AssetManager::class.java.getMethod("addAssetPath", String::class.java)
            addAssetPathMethod.invoke(assetManager, apkPath)
            assetManager
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}