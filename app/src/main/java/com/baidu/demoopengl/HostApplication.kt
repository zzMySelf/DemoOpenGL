package com.baidu.demoopengl

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.plugin.App
import com.example.plugin.PluginHookHelper

/**
 * Day：2025/4/27 20:06
 * @author zhangyelei
 */
class HostApplication: Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.e("zyl", "HostApplication  attachBaseContext")

    }

    override fun onCreate() {
        super.onCreate()
        Log.e("zyl", "HostApplication  onCreate")
        App.context = this
    }
}