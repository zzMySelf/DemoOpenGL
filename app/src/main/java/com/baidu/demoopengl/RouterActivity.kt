package com.baidu.demoopengl

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.baidu.demoopengl.opengl.MainActivity
import com.baidu.demoopengl.video.Camera2Activity
import com.baidu.demoopengl.video.MediaRecorderActivity
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