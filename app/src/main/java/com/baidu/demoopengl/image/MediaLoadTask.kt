package com.baidu.demoopengl.image

import android.content.Context
import android.database.Cursor

/**
 * Day：2024/8/23 14:24
 * @author zhangyelei
 */
class MediaLoadTask(private val context: Context) : Runnable{

    override fun run() {
        val start = System.currentTimeMillis()

        loadMedia()


    }

    private fun loadMedia() {
        var cursor: Cursor? = null
        try {
            cursor = context.contentResolver.query(
                MediaConfig.QUERY_URI,
                MediaConfig.PROJECTION,
                MediaConfig.SELECTION,
                MediaConfig.SELECTION_ARGS,
                MediaConfig.ORDER_BY
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (cursor == null) {
            notifyError("cursor is null")
            return
        }
    }

    private fun notifyError(message: String) {
    }
}