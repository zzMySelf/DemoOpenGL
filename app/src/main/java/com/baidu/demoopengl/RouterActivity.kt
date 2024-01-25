package com.baidu.demoopengl

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.baidu.demoopengl.opengl.MainActivity
import com.baidu.demoopengl.video.Camera2Activity
import com.baidu.demoopengl.video.MediaRecorderActivity

class RouterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_router)


        findViewById<Button>(R.id.mediaRecorder).setOnClickListener {
            MediaRecorderActivity.start(this@RouterActivity)
        }

        findViewById<Button>(R.id.camera2Recorder).setOnClickListener {
            Camera2Activity.start(this@RouterActivity)
        }

        findViewById<Button>(R.id.opengl).setOnClickListener {
            MainActivity.start(this@RouterActivity)
        }
    }

    companion object {
        // Used to load the 'demoopengl' library on application startup.
        init {
            System.loadLibrary("demoopengl")
        }
    }
}