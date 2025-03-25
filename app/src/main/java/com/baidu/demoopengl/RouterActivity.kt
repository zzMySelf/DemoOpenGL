package com.baidu.demoopengl

import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baidu.demoopengl.opencv.PictureFrameActivity
import com.baidu.demoopengl.opengl.MainActivity
import com.baidu.demoopengl.video.Camera2Activity
import com.baidu.demoopengl.video.MediaRecorderActivity
import org.opencv.android.OpenCVLoader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

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

        copyAssertShaderToSdcard()



        findViewById<Button>(R.id.window_dialog).setOnClickListener {
            val floatView = TextView(this).apply {
                text = "哈哈哈哈哈哈悬浮球"
            }
            val layoutFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG
            } else {
                WindowManager.LayoutParams.TYPE_PHONE
            }
            val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layoutFlag,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
            )
            params.token = window.decorView.windowToken
            windowManager.addView(floatView, params)
        }

        if (OpenCVLoader.initDebug()) {
            Toast.makeText(this, "openCV 加载成功", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.opencv_picture_frame).setOnClickListener {
            PictureFrameActivity.start(this@RouterActivity)
        }
    }

    companion object {
        // Used to load the 'demoopengl' library on application startup.
        init {
            System.loadLibrary("demoopengl")
        }
    }

    private fun copyAssertShaderToSdcard() {
        val assetFiles = assets.list("")
        if (assetFiles != null) {
            for (assetFile in assetFiles) {
                // 检查文件是否以 .glsl 结尾
                if (assetFile.endsWith(".glsl")) {
                    val targetFile = File(getExternalFilesDir(""), assetFile)
                    assets.open(assetFile).use { inputStream ->
                        FileOutputStream(targetFile).use { outputStream ->
                            val buffer = ByteArray(1024)
                            var read: Int

                            // 从输入流读取数据，并写入到输出流
                            while (inputStream.read(buffer).also { read = it } != -1) {
                                outputStream.write(buffer, 0, read)
                            }
                        }
                    }
                }
            }
        }
    }
}