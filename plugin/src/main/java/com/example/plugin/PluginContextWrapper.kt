package com.example.plugin

import android.content.Context
import android.content.ContextWrapper
import android.content.res.AssetManager
import android.content.res.Resources

/**
 * Day：2025/4/28 14:52
 * @author zhangyelei
 */
class PluginContextWrapper(
    base: Context,
    private val pluginClassLoader: ClassLoader
) : ContextWrapper(base) {

    override fun getClassLoader(): ClassLoader {
        // 返回插件的 ClassLoader，这样就能加载插件中的类了
        return pluginClassLoader
    }

    override fun getResources(): Resources {
        // 如果插件有自定义的资源，重写此方法以返回插件的资源
        return super.getResources() // 或者返回插件的资源对象
    }

    // 你可以根据需求重写其他方法，比如获取资产、文件等
    override fun getAssets(): AssetManager {
        // 返回插件的 AssetManager
        return super.getAssets() // 或者返回插件的 AssetManager
    }

    override fun getPackageName(): String {
        // 返回插件的包名
        return "com.example.minedemo" // 插件的包名
    }

    // 其他必要的重写方法
}
