package com.example.plugin

import android.app.Application
import android.content.Context

/**
 * Day：2025/4/28 15:49
 * @author zhangyelei
 */
object App {
    var context: Application? = null

    fun baseContext() = context?.baseContext
}