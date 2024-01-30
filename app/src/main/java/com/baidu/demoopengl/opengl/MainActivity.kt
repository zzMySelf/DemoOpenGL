package com.baidu.demoopengl.opengl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.baidu.demoopengl.R

class MainActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var rootContainer: ConstraintLayout? = null
    private val glSurfaceView by lazy {
        MyGLSurfaceView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootContainer = findViewById(R.id.rootContainer)
        rootContainer?.addView(glSurfaceView)
    }

    /**
     * A native method that is implemented by the 'demoopengl' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
}