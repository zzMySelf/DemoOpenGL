package com.baidu.demoopengl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.baidu.demoopengl.video.MediaRecorderActivity

class RouterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)


        findViewById<Button>(R.id.mediaRecorder).setOnClickListener {
            MediaRecorderActivity.start(this@RouterActivity)
        }
    }
}