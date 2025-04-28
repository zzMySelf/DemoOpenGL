package com.example.plugin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.os.Process
import android.util.ArrayMap
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.File
import java.util.zip.ZipFile

/**
 * Day：2025/4/28 10:52
 * @author zhangyelei
 */
internal const val PLUGIN_ACTIVITY_CLASS_NAME = "com.example.minedemo.activity.RouterActivity"
internal const val PLUGIN_PKG = "com.example.minedemo"

internal const val TAG = "zyl"

object PluginLoadManager {
    var pluginClassLoader: DexClassLoader? = null
    var pluginContext: PluginContextWrapper? = null

    @SuppressLint("PrivateApi")
    fun loadPlugin(context: Context) {
        val apkPath = File(context.getExternalFilesDir(null), "debug-plugin.apk").absolutePath
        if (!File(apkPath).exists()) {
            Log.e("zyl", "Plugin APK不存在！${apkPath}")
            return
        }

        val nativeLibDir = getPluginNativeLibDir(apkPath)
        pluginClassLoader = createDexClassLoader(context, apkPath, nativeLibDir)

        pluginClassLoader?.let {
            pluginContext = PluginContextWrapper(context.applicationContext, it)
        }

        val clazz = loadPluginClass(PLUGIN_ACTIVITY_CLASS_NAME)
        if (clazz == null) {
            Log.e("zyl", "Plugin clazz 加载失败")
        } else {
            Log.e("zyl", "Plugin clazz 加载成功")
        }
    }

    private fun loadPluginClass(className: String): Class<*>? {
        return try {
            // 使用 DexClassLoader 加载插件类
            pluginClassLoader?.loadClass(className)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        }
    }

    private fun createDexClassLoader(
        context: Context,
        dexPath: String,
        nativeLibDir: String
    ): DexClassLoader {
        val dexOutputDir = context.getDir("dex", Context.MODE_PRIVATE)
        val dexOutputPath = dexOutputDir.absolutePath
        val loader = DexClassLoader(dexPath, dexOutputPath, nativeLibDir, context.applicationContext.classLoader)
        Log.e("zyl", "Plugin DexClassLoader dexPath:$dexPath dexOutputPath:$dexOutputPath nativeLibDir:$nativeLibDir")
        return loader
    }

    private fun getPluginNativeLibDir(apkPath: String): String {
        val zipFile = ZipFile(apkPath)
        val entry = zipFile.entries().asSequence().find { it.name.startsWith("lib/") }

        // 获取 APK 中的 lib/ 目录路径
        if (entry != null) {
            return zipFile.getEntry("lib/").name
        }

        // 如果没有本地库，返回空字符串
        return ""
    }

    fun startPluginActivity(context: Context) {
        val intent = Intent()
        intent.setClassName(
            PLUGIN_PKG,
            PLUGIN_ACTIVITY_CLASS_NAME
        )
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  // 添加这个标志
        pluginContext?.startActivity(intent)
    }
}