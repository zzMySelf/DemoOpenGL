package com.baidu.demoopengl.video

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baidu.demoopengl.R

class MediaRecorderActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MediaRecorderActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_recorder)
    }
}